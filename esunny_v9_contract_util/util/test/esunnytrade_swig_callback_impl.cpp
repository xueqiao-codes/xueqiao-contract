/*
 * esunnytrade_swig_callback_impl.cpp
 *
 *  易盛交易9.0接口 for swig
 *
 *  Created on: 2018年7月19日
 *      Author: Jason
 */
 
#include "esunnytrade_swig_callback_impl.h"
//#include "base/app_log.h"
#include <iostream>

namespace xueqiao {
namespace util {

void EsunnyTradeSwigCallback::setEsunnyTradeSwig(EsunnyTradeSwig *pEsunnyTradeSwig) {
	pEsunnyTradeSwig_ = pEsunnyTradeSwig;
	
	commodityCounter = 0;
	contractCounter = 0;
}	

void EsunnyTradeSwigCallback::onInitFinish(bool isFinish) {
	//APPLOG_INFO("EsunnyV9 swig callback onInitFinish");
	
	if(isFinish) {
		pEsunnyTradeSwig_->GetCommodityList();
		pEsunnyTradeSwig_->GetContractList();
		//pEsunnyTradeSwig_->GetContractList('F');
		//pEsunnyTradeSwig_->GetContractList('S');
		//pEsunnyTradeSwig_->GetContractList('M');
		/*
		pEsunnyTradeSwig_->GetContractList('N');
		pEsunnyTradeSwig_->GetContractList('P');
		pEsunnyTradeSwig_->GetContractList('F');
		pEsunnyTradeSwig_->GetContractList('O');
		pEsunnyTradeSwig_->GetContractList('S');
		pEsunnyTradeSwig_->GetContractList('M');
		pEsunnyTradeSwig_->GetContractList('U');
		pEsunnyTradeSwig_->GetContractList('E');
		pEsunnyTradeSwig_->GetContractList('D');
		pEsunnyTradeSwig_->GetContractList('G');
		pEsunnyTradeSwig_->GetContractList('R');
		pEsunnyTradeSwig_->GetContractList('X');
		pEsunnyTradeSwig_->GetContractList('I');
		pEsunnyTradeSwig_->GetContractList('C');
		pEsunnyTradeSwig_->GetContractList('Z');
		pEsunnyTradeSwig_->GetContractList('T');
		*/
	}
}

void EsunnyTradeSwigCallback::onCommodity(EsCommodityInfo &esCommodityInfo, bool isFinish) {
	//APPLOG_INFO("EsunnyV9 swig callback onCommodity");
	commodityCounter++;
	std::cout << "onCommodity:" << esCommodityInfo.CommodityNo << " " << esCommodityInfo.CommodityName << "\t" << commodityCounter << std::endl;		
}

void EsunnyTradeSwigCallback::onContract(EsContractInfo &esContractInfo, bool isFinish) {
	//APPLOG_INFO("EsunnyV9 swig callback onContract");
	if(strlen(esContractInfo.CommodityNo) == 0)
		return;
	contractCounter++;
	std::cout << "onContract:" << esContractInfo.CommodityNo << " " << esContractInfo.ContractNo1 << "\t" << contractCounter << std::endl;
}	
	

} // end namespace util
} // end namespace xueqiao