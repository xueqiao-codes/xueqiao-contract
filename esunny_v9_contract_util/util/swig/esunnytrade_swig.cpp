/*
 * esunnytrade_swig.cpp
 *
 *  易盛交易9.0接口 for swig
 *
 *  Created on: 2018年7月19日
 *      Author: Jason
 */

#include "esunnytrade_swig.h"
//#include "base/app_log.h"

//static const std::string LOG_MODULE("apps/util/EsunnyV9ContractUtil");

namespace xueqiao {
namespace util {
	
EsunnyTradeSwig::EsunnyTradeSwig() {
	//soldier::base::AppLog::Init(LOG_MODULE);
	
	pEsunnyTrade = NULL;
}
	
void EsunnyTradeSwig::Init(EsLoginInfo &esLoginInfo, IEsunnyTradeSwigCallback* callback) {
	callback_ = callback;
	
	pEsunnyTrade = new EsunnyTrade();
	pEsunnyTrade->Init(esLoginInfo, callback);
}

void EsunnyTradeSwig::Init(EsLoginInfo &esLoginInfo, IEsunnyTradeSwigCallback* callback, QryCommodityType &qryCommodityType) {
	callback_ = callback;
	
	pEsunnyTrade = new EsunnyTrade();
	pEsunnyTrade->Init(esLoginInfo, callback, qryCommodityType);
}

void EsunnyTradeSwig::Uninit() {
	if(pEsunnyTrade != NULL)
		pEsunnyTrade->Uninit();
}

void EsunnyTradeSwig::GetCommodityList() {
	std::list<ITapTrade::TapAPICommodityInfo> commodityList = pEsunnyTrade->GetCommodityList();
	
	turnbackCommodity(commodityList);
}

void EsunnyTradeSwig::turnbackCommodity(std::list<ITapTrade::TapAPICommodityInfo> &commodityList) {
	std::list<ITapTrade::TapAPICommodityInfo>::iterator commodityItem;  
	unsigned int count = 0;
    for ( commodityItem = commodityList.begin(); commodityItem != commodityList.end(); ++commodityItem)  
    {  
        EsCommodityInfo commodity;
		memset(&commodity, 0, sizeof(EsCommodityInfo));
		
		strcpy(commodity.ExchangeNo, commodityItem->ExchangeNo);
		commodity.CommodityType = commodityItem->CommodityType;
		strcpy(commodity.CommodityNo, commodityItem->CommodityNo);
		
		strcpy(commodity.CommodityName, commodityItem->CommodityName);
		strcpy(commodity.CommodityEngName, commodityItem->CommodityEngName);
		
		strcpy(commodity.RelateExchangeNo, commodityItem->RelateExchangeNo);
		commodity.RelateCommodityType = commodityItem->RelateCommodityType;
		strcpy(commodity.RelateCommodityNo, commodityItem->RelateCommodityNo);
		
		strcpy(commodity.RelateExchangeNo2, commodityItem->RelateExchangeNo2);
		commodity.RelateCommodityType2 = commodityItem->RelateCommodityType2;
		strcpy(commodity.RelateCommodityNo2, commodityItem->RelateCommodityNo2);
		
		strcpy(commodity.CurrencyGroupNo, commodityItem->CurrencyGroupNo);
		strcpy(commodity.TradeCurrency, commodityItem->TradeCurrency);
		commodity.ContractSize = commodityItem->ContractSize;
		commodity.OpenCloseMode = commodityItem->OpenCloseMode;
		commodity.StrikePriceTimes = commodityItem->StrikePriceTimes;
		
		commodity.CommodityTickSize = commodityItem->CommodityTickSize;
		commodity.CommodityDenominator = commodityItem->CommodityDenominator;
		commodity.CmbDirect = commodityItem->CmbDirect;
		commodity.DeliveryMode = commodityItem->DeliveryMode;
		commodity.DeliveryDays = commodityItem->DeliveryDays;
		strcpy(commodity.AddOneTime, commodityItem->AddOneTime);
		commodity.CommodityTimeZone = commodityItem->CommodityTimeZone;
		commodity.IsAddOne = commodityItem->IsAddOne;
		
		//达到最后一条，告知
		if(count == commodityList.size()) {
			callback_->onCommodity(commodity, true);//回调
		}
		else {
			callback_->onCommodity(commodity, false);//回调
		}		
    } 

	//没有数据，也要返回一条空的数据给回调
	if(count == 0) {
		EsCommodityInfo commodity;
		memset(&commodity, 0, sizeof(EsCommodityInfo));
		
		callback_->onCommodity(commodity, true);//回调
	}
}

void EsunnyTradeSwig::GetContractList() {
	std::list<ITapTrade::TapAPITradeContractInfo> contractList = pEsunnyTrade->GetContractList();
	
	turnbackContract(contractList);
}

void EsunnyTradeSwig::GetContractList(char commodityType) {
	std::list<ITapTrade::TapAPITradeContractInfo> contractList = pEsunnyTrade->GetContractList(commodityType);
	
	turnbackContract(contractList);
}

void EsunnyTradeSwig::turnbackContract(std::list<ITapTrade::TapAPITradeContractInfo> &contractList) {
	std::list<ITapTrade::TapAPITradeContractInfo>::iterator contractItem; 
	unsigned int count = 0;
    for ( contractItem = contractList.begin(); contractItem != contractList.end(); ++contractItem)  
    {  
        EsContractInfo contract;
		memset(&contract, 0, sizeof(EsContractInfo));
		
		strcpy(contract.ExchangeNo, contractItem->ExchangeNo);
		contract.CommodityType = contractItem->CommodityType;
		strcpy(contract.CommodityNo, contractItem->CommodityNo);
		strcpy(contract.ContractNo1, contractItem->ContractNo1);
		strcpy(contract.StrikePrice1, contractItem->StrikePrice1);
		
		contract.CallOrPutFlag1 = contractItem->CallOrPutFlag1;
		strcpy(contract.ContractNo2, contractItem->ContractNo2);
		strcpy(contract.StrikePrice2, contractItem->StrikePrice2);
		contract.CallOrPutFlag2 = contractItem->CallOrPutFlag2;
		contract.ContractType = contractItem->ContractType;
		
		strcpy(contract.QuoteUnderlyingContract, contractItem->QuoteUnderlyingContract);
		strcpy(contract.ContractName, contractItem->ContractName);
		strcpy(contract.ContractExpDate, contractItem->ContractExpDate);
		strcpy(contract.LastTradeDate, contractItem->LastTradeDate);
		strcpy(contract.FirstNoticeDate, contractItem->FirstNoticeDate);
		
		count++;
		
		//达到最后一条，告知
		if(count == contractList.size()) {
			callback_->onContract(contract, true);//回调
		}
		else {
			callback_->onContract(contract, false);//回调
		}	

		//回调10次就休息一下，以免占用cpu百分比
		if(count % 100 == 0)
			usleep(10000);
    } 
	
	//没有数据，也要返回一条空的数据给回调
	if(count == 0) {
		EsContractInfo contract;
		memset(&contract, 0, sizeof(EsContractInfo));
		
		callback_->onContract(contract, true);//回调
	}
}
	

} // end namespace util
} // end namespace xueqiao