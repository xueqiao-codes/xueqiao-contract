/*
data struct for parameter
Jason 2018.1.29
*/

#ifndef CTPUTIL_H
#define CTPUTIL_H

#include "DataType.h"
#include "DataStruct.h"
#include "CtpDataStruct.h"

#ifdef __cplusplus  
extern "C" {
#endif 

	/*
		功能：format contract code from 3 digital to 4 digtial
		输入：3位数字的CTP合约数字部分
		输出：纯4位数字的合约数字部分
		传入的参数形如 005（代表2020年5月份的合约）, 得到的返回值是2005
	*/
	ContractCode3To4DigitalResult ContractCode3To4Digital(CommonContractCodeType commonContractCodeType);
	
	/*
		功能：把CTP合约代码RM801，au1806变成纯数字1801，1806
		输入：CTP合约代码，CTP商品代码
		输出：纯4位数字的雪橇合约代码
		注意：不足4位的，按年份补足。
	*/
	CtpFuturesContractCodeToSledContractCodeResult CtpFuturesContractCodeToSledContractCode(CommonContractCodeType ctpContractCode, CommonCommodityCodeType ctpCommodityCode);
	
	/*
		功能：把形如 IPS SF801&SM801，拆成 SF801 和 SM801
	*/
	TwoLegsCommonContractCode SplitCtpSpreadContractCode(CommonContract ctpContract, CommonContractCodeType ctpContractCode);
	
	/*
		功能：把形如 IPS SF&SM，拆成 SF 和 SM
	*/
	TwoLegsCommonCommodityCode SplitCtpSpreadCommodityCode(CommonContract ctpContract, CommonCommodityCodeType ctpCommodityCodeType);

	/*
		功能：由雪橇交易所，CTP商品代码，雪橇合约代码 得到 CTP的合约代码（只针对CTP期货）
	*/
	SledContractCodeToCtpFuturesContractCodeResult SledContractCodeToCtpFuturesContractCode(SledExchangeMicType sledExchangeMic, CommonCommodityCodeType ctpCommodityCode, SledContractCodeType sledContractCode);

#ifdef __cplusplus
}
#endif

#endif