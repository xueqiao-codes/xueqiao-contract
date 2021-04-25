/*
 * esunnytrade_swig_callback_impl.h
 *
 *  ��ʢ����9.0�ӿ� for swig
 *
 *  Created on: 2018��7��19��
 *      Author: Jason
 */
 
#ifndef ESUNNYV9CONTRACTUTIL_CALLBACK_IMPL_H_
#define ESUNNYV9CONTRACTUTIL_CALLBACK_IMPL_H_

#include "util/swig/esunnytrade_swig.h"

using namespace xueqiao::util;

namespace xueqiao {
namespace util {

	
class EsunnyTradeSwigCallback : public IEsunnyTradeSwigCallback {
public:
	EsunnyTradeSwigCallback() {}
    virtual ~EsunnyTradeSwigCallback() {}

    virtual void onInitFinish(bool isFinish);
	virtual void onCommodity(EsCommodityInfo &esCommodityInfo, bool isFinish);
	virtual void onContract(EsContractInfo &esContractInfo, bool isFinish);
	
	void setEsunnyTradeSwig(EsunnyTradeSwig *pEsunnyTradeSwig);   

private:
	EsunnyTradeSwig *pEsunnyTradeSwig_;
	int commodityCounter;
	int contractCounter;
};
	

} // end namespace util
} // end namespace xueqiao

#endif /* ESUNNYV9CONTRACTUTIL_CALLBACK_IMPL_H_ */