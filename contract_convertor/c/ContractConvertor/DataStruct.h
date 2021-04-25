/*
	data struct for parameter
	Jason 2018.1.29
*/

#ifndef CONTRACTCONVERTOR_DATASTRUCT_H
#define CONTRACTCONVERTOR_DATASTRUCT_H

#include "DataType.h"

#ifdef __cplusplus 
extern "C" {
#endif

	//标识2条腿的通用合约代码，用于内部的函数的返回值
	typedef struct _TwoLegsCommonContractCode {
		CommonContractCodeType FirstContractCode_;
		CommonContractCodeType SecondContractCode_;
	}TwoLegsCommonContractCode;

	//标识2条腿的通用商品代码，用于内部的函数的返回值
	typedef struct _TwoLegsCommonCommodityCode {
		CommonCommodityCodeType FirstCommdityCode_;
		CommonCommodityCodeType SecondCommdityCode_;
	}TwoLegsCommonCommodityCode;


	//技术平台，用的是哪个交易接口
	typedef enum _TechPlatform {
		TechPlatform_NONE = 0,
		TechPlatform_CTP = 1,
		TechPlatform_ESUNNY = 2,		// 易盛9.0（默认）
		TechPlatform_SP = 3,
		TechPlatform_ESUNNY_3 = 4,		// 易盛3.0
	}TechPlatform;

	// 雪橇商品类型
	typedef enum _SledCommodityType {
		SledCommodityType_NONE = 0,						// 无
		SledCommodityType_FUTURES = 1,					// 期货
		SledCommodityType_OPTION = 2,					// 期权
		SledCommodityType_SPOT = 3,						// 现货
		SledCommodityType_SPREAD_MONTH = 4,				// 跨期套利
		SledCommodityType_SPREAD_COMMODITY = 5,			// 跨品种套利
		SledCommodityType_BUL = 6,						// 看涨垂直套利
		SledCommodityType_BER = 7,						// 看跌垂直套利
		SledCommodityType_STD = 8,						// 跨式套利
		SledCommodityType_STG = 9,						// 宽跨式套利
		SledCommodityType_PRT = 10,						// 备兑组合
		SledCommodityType_DIRECTFOREX = 11,				// 外汇——直接汇率
		SledCommodityType_INDIRECTFOREX = 12,			// 外汇——间接汇率
		SledCommodityType_CROSSFOREX = 13,				// 外汇——交叉汇率
		SledCommodityType_INDEX = 14,					// 指数
		SledCommodityType_STOCK = 15,					// 股票
	}SledCommodityType;

	//通用合约
	typedef struct _CommonContract {
		CommonExchangeType TechPlatform_Exchange_;				// 对应技术平台的交易所编码
		CommonCommodityCodeType TechPlatform_CommodityType_;		// 对应技术平台的商品类型
		CommonCommodityCodeType TechPlatform_CommodityCode_;		// 对应技术平台的商品代号
		CommonContractCodeType TechPlatform_ContractCode_;		// 对应技术平台的合约代码
	}CommonContract;

	//混合合约，包含对应技术平台的商品资料 和 雪橇的合约代码
	//用于 对应技术平台 转 雪橇合约 的结果输出
	typedef struct _MixContract {
		CommonExchangeType TechPlatform_Exchange_;				// 对应技术平台的交易所编码
		CommonCommodityCodeType TechPlatform_CommodityType_;		// 对应技术平台的商品类型
		CommonCommodityCodeType TechPlatform_CommodityCode_;		// 对应技术平台的商品代号
		SledContractCodeType SledContractCode_;					// 雪橇的合约代码
	}MixContract;


	//雪橇统一合约基础
	typedef struct _SledBaseContract {
		SledExchangeMicType ExchangeMic_;				// ISO标准的交易所代号
		SledCommodityType SledCommodityType_;			// 雪橇商品类型
		SledCommodityCodeType SledCommodityCode_;		// 雪橇商品代号
		SledContractCodeType SledContractCode_;			// 雪橇合约编码
	}SledBaseContract;

	//雪橇统一合约 (雪橇内部流转的合约结构)
	typedef struct _SledContract {
		SledBaseContract SledBaseContract_;				// 雪橇合约
		unsigned int RelateSledContractCount_;			// 相关合约个数，如跨期，跨品种的每条腿，默认2
		SledBaseContract RelateSledContract_[2];			// 相关合约，如跨期，跨品种的每条腿
	}SledContract;


	//雪橇商品映射
	typedef struct _CommodityMap {
		TechPlatform TechPlatform_;								// 技术平台
		SledExchangeMicType ExchangeMic_;						// ISO标准的交易所代号
		SledCommodityType SledCommodityType_;					// 雪橇商品类型
		SledCommodityCodeType SledCommodityCode_;				// 雪橇商品代号

		CommonExchangeType TechPlatform_Exchange_;				// 对应技术平台的交易所编码
		CommonCommodityCodeType TechPlatform_CommodityType_;		// 对应技术平台的商品类型
		CommonCommodityCodeType TechPlatform_CommodityCode_;		// 对应技术平台的商品代号
	}CommodityMap;

	//雪橇合约 转 对应技术平台，输入参数
	typedef struct _SledContractToTechPlatformArgs {
		TechPlatform TechPlatform_;				//技术平台
		SledContract SledContract_;				//雪橇合约结构
		CommodityMap CommodityMap_;				//商品映射
		unsigned int RelateCommodityMapCount_;	//相关商品的个数，默认2
		CommodityMap RelateCommodityMap_[2];		//商品映射，相关商品，如跨期，跨品种的每条腿
	}SledContractToTechPlatformArgs;

	//雪橇合约 转 对应技术平台，输出结果
	typedef struct _SledContractToTechPlatformResult {
		TechPlatform TechPlatform_;					//技术平台
		CommonContract CommonContract_;			    //对应技术平台的合约代码
		unsigned int OtherCommonContractCount_;	    //对应技术平台的其它合约的个数，默认1
		CommonContract OtherCommonContract_[1];	    //对应技术平台的其它合约，如易盛9.0的合约2
	}SledContractToTechPlatformResult;

	//对应技术平台 转 雪橇合约，输入参数
	typedef struct _TechPlatformContractToSledArgs {
		TechPlatform TechPlatform_;				//技术平台
		CommonContract CommonContract_;			//对应技术平台的合约
		unsigned int OtherCommonContractCount_;	//对应技术平台的其它合约的个数，默认1
		CommonContract OtherCommonContract_[1];	//对应技术平台的其它合约，如易盛9.0的合约2
	}TechPlatformContractToSledArgs;

	//对应技术平台 转 雪橇合约，输出结果
	typedef struct _TechPlatformContractToSledResult {
		TechPlatform TechPlatform_;				//技术平台
		MixContract MixContract_;				//混合合约结构，包含对应技术平台的商品资料 和 雪橇的合约代码
		unsigned int RelateMixContractCount_;	//相关混合合约的个数，默认2
		MixContract RelateMixContract_[2];		//相关混合合约，如跨期，跨品种的每条腿
	}TechPlatformContractToSledResult;


#ifdef __cplusplus
}
#endif

#endif
