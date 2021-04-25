/*
 * esunnytrade.cpp
 *
 *  易盛交易9.0接口
 *
 *  Created on: 2018年7月18日
 *      Author: Jason
 */
#include "util/api/esunnytrade.h"
#include "iTapAPIError.h"
//#include "base/app_log.h"

#include <iostream>
#include <unistd.h>

//static const std::string ESUNNYV9_TRADE_LOG_PATH("/data/applog/apps/util/EsunnyV9ContractUtil/esunny");

namespace xueqiao {
namespace util {


EsunnyTrade::EsunnyTrade() {
	
	Tap_Api = NULL;
	m_bIsTradeAPIReady = false;
	m_bExchangeIsReady = false;
	m_bComodityIsReady = false;
	m_bContractIsReady = false;
	m_bAllQryFinish = false;
	m_bIsSpecifyQryCommodityType = false;
	contractCallbackCounter = 1;
}

void EsunnyTrade::Init(EsLoginInfo &esLoginInfo, IEsunnyTradeSwigCallback* callback) {
	//先清理
	Uninit();
	
	esLoginInfo_ = esLoginInfo;
	callback_ = callback;
	
	//const char* c_sEsunnyLogPath = ESUNNYV9_TRADE_LOG_PATH.c_str();
	
	//创建API实例
	ITapTrade::TAPIINT32 iResult = ITapTrade::TAPIERROR_SUCCEED;
	
	//如果api已经创建，就不要再创建了
	if(Tap_Api == NULL) {
		ITapTrade::TapAPIApplicationInfo stAppInfo;
		strcpy(stAppInfo.AuthCode, esLoginInfo_.authCode);
		strcpy(stAppInfo.KeyOperationLogPath, "");
		//mkdir(c_sEsunnyLogPath, 0755);//建易盛api接口log的文件夹
		//strcpy(stAppInfo.KeyOperationLogPath, c_sEsunnyLogPath);
		
		Tap_Api = CreateITapTradeAPI(&stAppInfo, iResult);
	}
	if(Tap_Api == NULL) {
		//APPLOG_ERROR("EsunnyV9 CreateITapTradeAPI Failed!iResult={}", iResult);
		std::cout << "EsunnyV9 CreateITapTradeAPI Failed!iResult=" << iResult << std::endl;
		callback_->onInitFinish(false); //回调通知，说已经初始化失败
		return;
	}
	
	//设定ITapTradeAPINotify的实现类，用于异步消息的接收	
	iResult = Tap_Api->SetAPINotify(this);
	if( iResult != 0)
	{
		//APPLOG_ERROR("EsunnyV9 SetAPINotify Failed!iResult={}", iResult);
		std::cout << "EsunnyV9 SetAPINotify Failed!iResult=" << iResult << std::endl;
	}
	
	//连接服务器
	iResult = Tap_Api->SetHostAddress(esLoginInfo_.ip, esLoginInfo_.port);
	if( iResult != 0) {
		//APPLOG_ERROR("EsunnyV9 SetHostAddress Failed!iResult={}", iResult);
		std::cout << "EsunnyV9 SetHostAddress Failed!iResult=" << iResult << std::endl;
		callback_->onInitFinish(false); //回调通知，说已经初始化失败
		return;
	}
	
	//登录
	ITapTrade::TapAPITradeLoginAuth stLoginAuth;
	memset(&stLoginAuth, 0, sizeof(stLoginAuth));
	strcpy(stLoginAuth.UserNo, esLoginInfo_.userNo);
	strcpy(stLoginAuth.Password, esLoginInfo_.password);
	stLoginAuth.ISModifyPassword = ITapTrade::APIYNFLAG_NO;

	iResult = Tap_Api->Login(&stLoginAuth);
	if( iResult != 0) {
		//APPLOG_ERROR("EsunnyV9 Login Connect Failed!iResult={}", iResult);
		std::cout << "EsunnyV9 Login Connect Failed!iResult=" << iResult << std::endl;
		callback_->onInitFinish(false); //回调通知，说已经初始化失败
		return;
	}
	
	//等待所有查询都准备好后，可以退出了（由于易盛回调是异步的，为了程序在控制台程序使用，因为控制台程序调用完就结束了）
	m_Event.WaitEvent();
}

void EsunnyTrade::Init(EsLoginInfo &esLoginInfo, IEsunnyTradeSwigCallback* callback, QryCommodityType &qryCommodityType) {
	qryCommodityType_ = qryCommodityType;	
	m_bIsSpecifyQryCommodityType = true;
	
	Init(esLoginInfo, callback);		
}

void EsunnyTrade::Uninit() {
	//易盛api释放会崩溃，暂时不释放了
	/*
	if(Tap_Api != NULL) {
		FreeITapTradeAPI(Tap_Api); //如果易盛还没有释放，再次释放易盛API
	}
	*/
	m_Event.SignalEvent(); //发送信号
	
	m_bIsTradeAPIReady = false;
	m_bExchangeIsReady = false;
	m_bComodityIsReady = false;
	m_bContractIsReady = false;
	m_bAllQryFinish = false;
	//m_bIsSpecifyQryCommodityType = false;
}

bool EsunnyTrade::GetAllQryIsReady() {
	return m_bAllQryFinish;
}

std::list<ITapTrade::TapAPICommodityInfo> EsunnyTrade::GetCommodityList() {
	return commodityList;
}

std::list<ITapTrade::TapAPITradeContractInfo> EsunnyTrade::GetContractList() {
	return contractList;
}

std::list<ITapTrade::TapAPITradeContractInfo> EsunnyTrade::GetContractList(char commodityType) {
	std::map<char, std::list<ITapTrade::TapAPITradeContractInfo>>::iterator iter;
	iter = contractListMap.find(commodityType);
	
	if(iter != contractListMap.end()) {
		return iter->second;
	}
	else {
		std::list<ITapTrade::TapAPITradeContractInfo> contractListTmp;
		return contractListTmp;
	}
}

void EsunnyTrade::checkAllQryFinish() {
	if(m_bExchangeIsReady && m_bComodityIsReady && m_bContractIsReady) {
		m_bAllQryFinish = true;
		
		//APPLOG_INFO("EsunnyV9 All Query Finish!");	
		std::cout << "EsunnyV9 All Query Finish!" << std::endl;
		if(Tap_Api != NULL) {
			Tap_Api->Disconnect(); //断开易盛连接
		}
		callback_->onInitFinish(true); //回调通知，说已经初始化完成
	}		
}

void EsunnyTrade::qryExchange() {
	//保证只查一次就够了
	if(!m_bIsTradeAPIReady || Tap_Api == NULL || m_bExchangeIsReady) {
		//APPLOG_ERROR("EsunnyV9 qryExchange Failed!TradeAPI is not Ready or API is Null or Already Query");
		std::cout << "EsunnyV9 qryExchange Failed!TradeAPI is not Ready or API is Null or Already Query" << std::endl;
		return;
	}
	
	exchangeList.clear(); //查询前清空
	
	uint sessionId = 0;
	int iResult = Tap_Api->QryExchange(&sessionId);
	
    //APPLOG_INFO("EsunnyV9 Begin qryExchange!iResult={},sessionId={}", iResult, sessionId);
	std::cout << "EsunnyV9 Begin qryExchange!iResult=" << iResult << ",sessionId=" << sessionId << std::endl;
}

void EsunnyTrade::qryCommodity() {
	//保证只查一次就够了
	if(!m_bIsTradeAPIReady || Tap_Api == NULL || m_bComodityIsReady) {
		//APPLOG_ERROR("EsunnyV9 qryCommodity Failed!TradeAPI is not Ready or API is Null or Already Query");
		std::cout << "EsunnyV9 qryCommodity Failed!TradeAPI is not Ready or API is Null or Already Query" << std::endl;
		return;
	}
	
	commodityList.clear(); //查询前清空
	
	uint sessionId = 0;
	int iResult = Tap_Api->QryCommodity(&sessionId);
	
    //APPLOG_INFO("EsunnyV9 Begin qryCommodity!iResult={},sessionId={}", iResult, sessionId);
	std::cout << "EsunnyV9 Begin qryCommodity!iResult=" << iResult << ",sessionId=" << sessionId << std::endl;
}

void EsunnyTrade::qryContract() {
	//保证只查一次就够了
	if(!m_bIsTradeAPIReady || Tap_Api == NULL || m_bContractIsReady) {
		//APPLOG_ERROR("EsunnyV9 qryContract Failed!TradeAPI is not Ready or API is Null or Already Query");
		std::cout << "EsunnyV9 qryContract Failed!TradeAPI is not Ready or API is Null or Already Query" << std::endl;
		return;
	}
	
	contractListMap.clear();//查询前清空
	contractList.clear();
	contractIsQryFinishMap.clear();
	
	//默认查全部的所有合约
	if(!m_bIsSpecifyQryCommodityType) {
		ITapTrade::TapAPICommodity qryReq;
		memset(&qryReq, 0, sizeof(qryReq));
		//strcpy(qryReq.ExchangeNo,"CBOT");
		//strcpy(qryReq.CommodityNo,"GC");
		//qryReq.CommodityType = ITapTrade::TAPI_COMMODITY_TYPE_FUTURES;
		uint sessionId = 0;
		int iResult = Tap_Api->QryContract(&sessionId, &qryReq);
		
		contractIsQryFinishMap.insert(std::pair<uint, bool>(sessionId, false)); //记录一下，合约开始查询了，但还没有完成，完成后，会修改bool标记
		
		//APPLOG_INFO("EsunnyV9 Begin qryContract, all CommodityType!iResult={},sessionId={}", iResult, sessionId);
		std::cout << "EsunnyV9 Begin qryContract, all CommodityType!iResult=" << iResult << ",sessionId=" << sessionId << std::endl;
	}
	else {
		if(qryCommodityType_.Enable_Spot) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_SPOT);
		}
		if(qryCommodityType_.Enable_Futures) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_FUTURES);
		}
		if(qryCommodityType_.Enable_Option) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_OPTION);
		}
		if(qryCommodityType_.Enable_Spread_Month) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_SPREAD_MONTH);
		}
		if(qryCommodityType_.Enable_Spread_Commodity) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_SPREAD_COMMODITY);
		}
		if(qryCommodityType_.Enable_Bul) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_BUL);
		}
		if(qryCommodityType_.Enable_Ber) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_BER);
		}
		if(qryCommodityType_.Enable_Std) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_STD);
		}
		if(qryCommodityType_.Enable_Stg) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_STG);
		}
		if(qryCommodityType_.Enable_Prt) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_PRT);
		}
		if(qryCommodityType_.Enable_Directforex) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_DIRECTFOREX);
		}
		if(qryCommodityType_.Enable_Indirectforex) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_INDIRECTFOREX);
		}
		if(qryCommodityType_.Enable_Crossforex) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_CROSSFOREX);
		}
		if(qryCommodityType_.Enable_Index) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_INDEX);
		}
		if(qryCommodityType_.Enable_Stock) {
			qryContract(ITapTrade::TAPI_COMMODITY_TYPE_STOCK);
		}
		
	}
	
}

void EsunnyTrade::qryContract(ITapTrade::TAPICommodityType commodityType) {
	std::list<ITapTrade::TapAPIExchangeInfo>::iterator exchangeItem;  
	for ( exchangeItem = exchangeList.begin(); exchangeItem != exchangeList.end(); ++exchangeItem) {				
		ITapTrade::TapAPICommodity qryReq;				
		memset(&qryReq, 0, sizeof(qryReq));
		strcpy(qryReq.ExchangeNo,exchangeItem->ExchangeNo);
		qryReq.CommodityType = commodityType;
		uint sessionId = 0;
		int iResult = Tap_Api->QryContract(&sessionId, &qryReq);
		
		contractIsQryFinishMap.insert(std::pair<uint, bool>(sessionId, false)); //记录一下，合约开始查询了，但还没有完成，完成后，会修改bool标记
		
		//APPLOG_INFO("EsunnyV9 Begin qryContract, exchange={}, CommodityType={}!iResult={},sessionId={}", qryReq.ExchangeNo, qryReq.CommodityType, iResult, sessionId);
		std::cout << "EsunnyV9 Begin qryContract, exchange=" << qryReq.ExchangeNo << ", CommodityType=" << qryReq.CommodityType << "!iResult=" << iResult << ",sessionId=" << sessionId << std::endl;
		usleep(100000);
	}
}

void EsunnyTrade::OnConnect() {
    //APPLOG_INFO("EsunnyV9 OnConnect!");
	std::cout << "EsunnyV9 OnConnect!" << std::endl;
}

void EsunnyTrade::OnRspLogin(ITapTrade::TAPIINT32 errorCode, const ITapTrade::TapAPITradeLoginRspInfo *loginRspInfo) {
    if(errorCode == 0) {
		//APPLOG_INFO("EsunnyV9 OnRspLogin Login Success!");
		std::cout << "EsunnyV9 OnRspLogin Login Success!" << std::endl;
	}
	else {
		//APPLOG_ERROR("EsunnyV9 OnRspLogin Login Failed!errorCode={}", errorCode);
		std::cout << "EsunnyV9 OnRspLogin Login Failed!errorCode=" << errorCode << std::endl;
		callback_->onInitFinish(false); //回调通知，说已经初始化失败
	}
}

void EsunnyTrade::OnAPIReady() {
	m_bIsTradeAPIReady = true;
    //APPLOG_INFO("EsunnyV9 OnAPIReady!");
	std::cout << "EsunnyV9 OnAPIReady!" << std::endl;
	
	//开始查询交易所信息
	qryExchange();
}

void EsunnyTrade::OnDisconnect(ITapTrade::TAPIINT32 reasonCode) {
	m_bIsTradeAPIReady = false;
    //APPLOG_ERROR("EsunnyV9 OnDisconnect!reasonCode={}", reasonCode);
	std::cout << "EsunnyV9 OnDisconnect!reasonCode=" << reasonCode << std::endl;
}

void EsunnyTrade::OnRspQryExchange(ITapTrade::TAPIUINT32 sessionID, ITapTrade::TAPIINT32 errorCode, ITapTrade::TAPIYNFLAG isLast, const ITapTrade::TapAPIExchangeInfo *info) {
	if(errorCode == 0 && NULL != info) {
		ITapTrade::TapAPIExchangeInfo exchange;
		memcpy(&exchange, info, sizeof(ITapTrade::TapAPIExchangeInfo));
		
		exchangeList.push_back(exchange);
	}
	
	//最后一条，可以查商品信息了
	if(isLast == 'Y') {
		m_bExchangeIsReady = true;
		//APPLOG_INFO("EsunnyV9 OnRspQryExchange Finish!");
		std::cout << "EsunnyV9 OnRspQryExchange Finish!" << std::endl;
		
		checkAllQryFinish();
		qryCommodity();
	}
}

void EsunnyTrade::OnRspQryCommodity(ITapTrade::TAPIUINT32 sessionID, ITapTrade::TAPIINT32 errorCode, ITapTrade::TAPIYNFLAG isLast, const ITapTrade::TapAPICommodityInfo *info) {
	if(errorCode == 0 && NULL != info) {
		ITapTrade::TapAPICommodityInfo commodity;
		memcpy(&commodity, info, sizeof(ITapTrade::TapAPICommodityInfo));
		
		commodityList.push_back(commodity);
	}
	
	//最后一条，可以查合约信息了
	if(isLast == 'Y') {
		m_bComodityIsReady = true;
		//APPLOG_INFO("EsunnyV9 OnRspQryCommodity Finish!");
		std::cout << "EsunnyV9 OnRspQryCommodity Finish!" << std::endl;
		
		checkAllQryFinish();
		qryContract();
	}
}

void EsunnyTrade::OnRspQryContract(ITapTrade::TAPIUINT32 sessionID, ITapTrade::TAPIINT32 errorCode, ITapTrade::TAPIYNFLAG isLast, const ITapTrade::TapAPITradeContractInfo *info) {
	if(errorCode == 0 && NULL != info) {
		ITapTrade::TapAPITradeContractInfo contract;
		memcpy(&contract, info, sizeof(ITapTrade::TapAPITradeContractInfo));
		
		contractList.push_back(contract);
		
		std::map<char, std::list<ITapTrade::TapAPITradeContractInfo>>::iterator iter;
		iter = contractListMap.find(contract.CommodityType);
		
		if(iter != contractListMap.end()) {
			iter->second.push_back(contract);
		}
		else {
			std::list<ITapTrade::TapAPITradeContractInfo> contractListTmp;
			contractListTmp.push_back(contract);
			contractListMap.insert(std::pair<char, std::list<ITapTrade::TapAPITradeContractInfo>>(contract.CommodityType, contractListTmp));
		}
	}
	
	//最后一条
	if(isLast == 'Y') {
		/*
			由于contract可能分成了多个查询，所有，需要检测多个合约查询都完成，才算完成
			1、首先是设置某个查询已经完了
			2、检查是不是所有的查询都完了，如果是，标记m_bContractIsReady完成
		*/
		std::map<uint, bool>::iterator iter;
		iter = contractIsQryFinishMap.find(sessionID);
		if(iter != contractIsQryFinishMap.end()) {
			iter->second = true;
		}
		
		bool isAllQryFinish = true;
		for(iter = contractIsQryFinishMap.begin(); iter != contractIsQryFinishMap.end(); iter++) {
			if(!iter->second) {
				isAllQryFinish = false;
				break;
			}
		}
		
		//所有合约的查询都完了，ready了
		if(isAllQryFinish) {
			m_bContractIsReady = true;
		}
		
		if(m_bContractIsReady) {
			//APPLOG_INFO("EsunnyV9 OnRspQryContract Finish!");	
			std::cout << "EsunnyV9 OnRspQryContract Finish!" << std::endl;			
			checkAllQryFinish();
		}
	}
	
	//回调10次就休息一下，以免占用cpu百分比
	if(contractCallbackCounter % 100 == 0)
		usleep(10000);
}

} // end namespace util
} // end namespace xueqiao



