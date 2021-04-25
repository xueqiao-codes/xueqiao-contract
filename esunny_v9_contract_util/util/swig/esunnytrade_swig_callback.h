/*
 * esunnytrade_swig_callback.h
 *
 *  ��ʢ����9.0�ӿ� for swig
 *
 *  Created on: 2018��7��19��
 *      Author: Jason
 */
 
#ifndef ESUNNYV9CONTRACTUTIL_CALLBACK_H_
#define ESUNNYV9CONTRACTUTIL_CALLBACK_H_

#include "util/swig/datatype.h"


namespace xueqiao {
namespace util {

	
class IEsunnyTradeSwigCallback {
public:	
	virtual ~IEsunnyTradeSwigCallback() {}

    virtual void onInitFinish(bool isFinish) = 0;
	virtual void onCommodity(EsCommodityInfo &esCommodityInfo, bool isFinish) = 0;
	virtual void onContract(EsContractInfo &esContractInfo, bool isFinish) = 0;
protected:
    IEsunnyTradeSwigCallback() {}
    
};
	

} // end namespace util
} // end namespace xueqiao

#endif /* ESUNNYV9CONTRACTUTIL_CALLBACK_H_ */