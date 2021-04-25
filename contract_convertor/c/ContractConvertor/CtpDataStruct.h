/*
data struct for parameter
Jason 2018.1.29
*/

#ifndef CTPDATASTRUCT_H
#define CTPDATASTRUCT_H

#include "DataType.h"

#ifdef __cplusplus 
extern "C" {
#endif

	//CommonContractCode 3位数字升级到4位数字，用于内部的函数的返回值
	typedef struct _ContractCode3To4DigitalResult {
		CommonContractCodeType CommonContractCode4Digital_;
	}ContractCode3To4DigitalResult;

	//纯4位数字的雪橇合约代码，用于内部的函数的返回值
	typedef struct _CtpFuturesContractCodeToSledContractCodeResult {
		SledContractCodeType SledContractCode_;
	}CtpFuturesContractCodeToSledContractCodeResult;

	//CTP的合约代码，用于内部的函数的返回值
	typedef struct _SledContractCodeToCtpFuturesContractCodeResult {
		CommonContractCodeType CommonContractCode_;
	}SledContractCodeToCtpFuturesContractCodeResult;

#ifdef __cplusplus
}
#endif

#endif
