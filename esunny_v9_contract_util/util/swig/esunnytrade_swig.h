/*
 * esunnytrade_swig.h
 *
 *  易盛交易9.0接口 for swig
 *
 *  Created on: 2018年7月19日
 *      Author: Jason
 */
 
#ifndef ESUNNYV9CONTRACTUTIL_SWIG_H_
#define ESUNNYV9CONTRACTUTIL_SWIG_H_

#include "util/swig/datatype.h"
#include "util/api/esunnytrade.h"
#include <string.h>
#include <list>
#include <unistd.h>

using namespace xueqiao::util;

namespace xueqiao {
namespace util {
	
class EsunnyTradeSwig {

public:
	EsunnyTradeSwig();
    virtual ~EsunnyTradeSwig() = default;
	
	void Init(EsLoginInfo &esLoginInfo, IEsunnyTradeSwigCallback* callback);
	void Init(EsLoginInfo &esLoginInfo, IEsunnyTradeSwigCallback* callback, QryCommodityType &qryCommodityType);
	void Uninit();
	void GetCommodityList();
	void GetContractList();
	void GetContractList(char commodityType);

private:
	void turnbackCommodity(std::list<ITapTrade::TapAPICommodityInfo> &commodityList);
	void turnbackContract(std::list<ITapTrade::TapAPITradeContractInfo> &contractList);
	
private:
	EsunnyTrade *pEsunnyTrade;
	IEsunnyTradeSwigCallback *callback_;
 
};	


} // end namespace util
} // end namespace xueqiao

#endif /* ESUNNYV9CONTRACTUTIL_SWIG_H_ */