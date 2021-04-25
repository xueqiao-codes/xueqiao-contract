/*
data struct for parameter
Jason 2018.1.29
*/

#ifndef CONTRACTCONVERTOR_DATATYPE_H
#define CONTRACTCONVERTOR_DATATYPE_H

#ifdef __cplusplus
extern "C" {
#endif

/*----------------- 通用的类型定义 ----------------------------------------*/

/////////////////////////////////////////////////////////////////////////
///CommonContractCodeType是一个通用合约代码类型，供转换使用
/////////////////////////////////////////////////////////////////////////
typedef char CommonContractCodeType[31];

/////////////////////////////////////////////////////////////////////////
///CommonExchangeType是一个交易所代码类型，供转换使用
/////////////////////////////////////////////////////////////////////////
typedef char CommonExchangeType[31];

/////////////////////////////////////////////////////////////////////////
///CommonCommodityCodeType是一个商品类型，供转换使用
/////////////////////////////////////////////////////////////////////////
typedef char CommonCommodityType[31];

/////////////////////////////////////////////////////////////////////////
///CommonCommodityCodeType是一个商品类型
/////////////////////////////////////////////////////////////////////////
typedef char CommonCommodityCodeType[31];



/*----------------- 雪橇的类型定义 ----------------------------------------*/

/////////////////////////////////////////////////////////////////////////
///SledExchangeMicType是一个ISO标准的交易所代号
/////////////////////////////////////////////////////////////////////////
typedef char SledExchangeMicType[5];

/////////////////////////////////////////////////////////////////////////
///SledCommodityCodeType是一个商品类型
/////////////////////////////////////////////////////////////////////////
typedef char SledCommodityCodeType[31];

/////////////////////////////////////////////////////////////////////////
///SledContractCodeType是一个合约代码类型
/////////////////////////////////////////////////////////////////////////
typedef char SledContractCodeType[31];



/*----------------- CTP 的类型定义 ----------------------------------------*/

/////////////////////////////////////////////////////////////////////////
///CtpCommodityTypeType是一个商品类型类型
/////////////////////////////////////////////////////////////////////////
///期货
#define Ctp_CommodityType_Futures '1'
///期货期权
#define Ctp_CommodityType_Options '2'
///组合
#define Ctp_CommodityType_Combination '3'
///即期
#define Ctp_CommodityType_Spot '4'
///期转现
#define Ctp_CommodityType_EFP '5'
///现货期权
#define Ctp_CommodityType_SpotOption '6'

typedef char CtpCommodityTypeType;



/*----------------- Esunny 9.0 的类型定义 ----------------------------------------*/

/////////////////////////////////////////////////////////////////////////
///EsunnyV9CommodityTypeType是一个商品类型类型
/////////////////////////////////////////////////////////////////////////
//! 无
#define  EsunnyV9_CommodityType_None  'N'
//! 现货
#define  EsunnyV9_CommodityType_Spot  'P'
//! 期货
#define  EsunnyV9_CommodityType_Futures  'F'
//! 期权
#define  EsunnyV9_CommodityType_Option  'O'
//! 跨期套利
#define  EsunnyV9_CommodityType_Spread_Month  'S'
//! 跨品种套利
#define  EsunnyV9_CommodityType_Spread_Commodity  'M'
//! 看涨垂直套利
#define  EsunnyV9_CommodityType_Bul  'U'
//! 看跌垂直套利
#define  EsunnyV9_CommodityType_Ber  'E'
//! 跨式套利
#define  EsunnyV9_CommodityType_Std  'D'
//! 宽跨式套利
#define  EsunnyV9_CommodityType_Stg  'G'
//! 备兑组合
#define  EsunnyV9_CommodityType_Prt  'R'
//! 外汇——直接汇率
#define  EsunnyV9_CommodityType_Directforex  'X'
//! 外汇——间接汇率
#define  EsunnyV9_CommodityType_Indirectforex  'I'
//! 外汇——交叉汇率
#define  EsunnyV9_CommodityType_Crossforex  'C'
//! 指数
#define  EsunnyV9_CommodityType_Index  'Z'
//! 股票
#define  EsunnyV9_CommodityType_Stock  'T'

typedef char EsunnyV9CommodityTypeType;



/*----------------- Esunny 3.0 的类型定义 ----------------------------------------*/

/////////////////////////////////////////////////////////////////////////
///EsunnyV3CommodityTypeType是一个商品类型类型
/////////////////////////////////////////////////////////////////////////
//现货
#define	EsunnyV3_CommodityType_Goods 'G'
//期货
#define	EsunnyV3_CommodityType_Futures 'F'
//期权
#define	EsunnyV3_CommodityType_Option 'O'
//跨期套利
#define	EsunnyV3_CommodityType_Spread_Month 'M'
//跨品种套利
#define	EsunnyV3_CommodityType_Spread_Commodity 'C'

typedef char EsunnyV3CommodityTypeType;


#ifdef __cplusplus
}
#endif

#endif
