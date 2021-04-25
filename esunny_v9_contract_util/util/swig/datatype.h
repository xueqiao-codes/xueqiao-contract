/*
 * datatype.h
 *
 *  易盛交易9.0接口
 *
 *  Created on: 2018年7月18日
 *      Author: Jason
 */

#ifndef ESUNNYV9CONTRACTUTIL_DATATYPE_H
#define ESUNNYV9CONTRACTUTIL_DATATYPE_H

//! 品种类型
//! 无
#define		ESUNNY9_COMMODITY_TYPE_NONE				 	 'N';
//! 现货
#define		ESUNNY9_COMMODITY_TYPE_SPOT				 	 'P';
//! 期货
#define		ESUNNY9_COMMODITY_TYPE_FUTURES				 'F';
//! 期权
#define		ESUNNY9_COMMODITY_TYPE_OPTION				 'O';
//! 跨期套利
#define		ESUNNY9_COMMODITY_TYPE_SPREAD_MONTH		 	 'S';
//! 跨品种套利
#define		ESUNNY9_COMMODITY_TYPE_SPREAD_COMMODITY	 	 'M';
//! 看涨垂直套利
#define		ESUNNY9_COMMODITY_TYPE_BUL					 'U';
//! 看跌垂直套利
#define		ESUNNY9_COMMODITY_TYPE_BER					 'E';
//! 跨式套利
#define		ESUNNY9_COMMODITY_TYPE_STD					 'D';
//! 宽跨式套利
#define		ESUNNY9_COMMODITY_TYPE_STG					 'G';
//! 备兑组合
#define		ESUNNY9_COMMODITY_TYPE_PRT					 'R';
//! 外汇——直接汇率
#define		ESUNNY9_COMMODITY_TYPE_DIRECTFOREX			 'X';
//! 外汇——间接汇率
#define		ESUNNY9_COMMODITY_TYPE_INDIRECTFOREX		 'I';
//! 外汇——交叉汇率
#define		ESUNNY9_COMMODITY_TYPE_CROSSFOREX			 'C';
//! 指数
#define		ESUNNY9_COMMODITY_TYPE_INDEX				 'Z';
//! 股票
#define		ESUNNY9_COMMODITY_TYPE_STOCK				 'T';


//! 看涨看跌标示
//! 买权
#define		ESUNNY9_CALLPUT_FLAG_CALL				 	 'C';
//! 卖权
#define		ESUNNY9_CALLPUT_FLAG_PUT					 'P';
//! 无
#define		ESUNNY9_CALLPUT_FLAG_NONE					 'N';

//! 合约类型
//! 交易行情合约
#define		ESUNNY9_CONTRACT_TYPE_TRADEQUOTE			 '1';
//! 行情合约
#define		ESUNNY9_CONTRACT_TYPE_QUOTE					 '2';



//! 开平方式
//! 不区分开平
#define		ESUNNY9_CLOSE_MODE_NONE				 		 'N';
//! 平仓未了结
#define		ESUNNY9_CLOSE_MODE_UNFINISHED			 	 'U';
//! 区分开仓和平仓
#define		ESUNNY9_CLOSE_MODE_OPENCOVER			 	 'C';
//! 区分开仓、平仓和平今
#define		ESUNNY9_CLOSE_MODE_CLOSETODAY			 	 'T';



//! 组合方向,品种两腿组合合约的买卖方向和第几腿相同
//! 和第一腿一致
#define     ESUNNY9_CMB_DIRECT_FIRST                     '1';
//! 和第二腿一致
#define     ESUNNY9_CMB_DIRECT_SECOND                    '2';



//! 交割行权方式,期货和期权了结的方式
//! 实物交割
#define		ESUNNY9_DELIVERY_MODE_GOODS			 		 'G';
//! 现金交割
#define		ESUNNY9_DELIVERY_MODE_CASH				 	 'C';
//! 期权行权
#define		ESUNNY9_DELIVERY_MODE_EXECUTE				 'E';
//! 期权放弃
#define		ESUNNY9_DELIVERY_MODE_ABANDON				 'A';
//! 港交所行权
#define		ESUNNY9_DELIVERY_MODE_HKF					 'H';
	

//! 是否标示
//! 是
#define		ESUNNY9_YNFLAG_YES	'Y';
//! 否
#define		ESUNNY9_YNFLAG_NO	'N';


namespace xueqiao {
namespace util {
	
//初始化、登录信息
typedef struct _EsLoginInfo {
	char userNo[20];
	char password[20];
	char ip[16];
	int port;
	char authCode[513];
}EsLoginInfo;

//! 交易合约信息
typedef struct _EsContractInfo
{
	char              ExchangeNo[11];                             ///< 交易所编码
	char			CommodityType;                          ///< 品种类型
	char              CommodityNo[11];                            ///< 品种编号
	char              ContractNo1[11];                            ///< 合约代码1
	char              StrikePrice1[11];                           ///< 执行价1
	char			CallOrPutFlag1;                         ///< 看涨看跌标示1
	char              ContractNo2[11];                            ///< 合约代码2
	char              StrikePrice2[11];                           ///< 执行价2
	char			CallOrPutFlag2;                         ///< 看涨看跌标示2
	char			ContractType;                           ///< 合约类型
	char			  QuoteUnderlyingContract[11];				///< 行情真实合约
	char              ContractName[71];                           ///< 合约名称
	char              ContractExpDate[11];                        ///< 合约到期日	
	char              LastTradeDate[11];                          ///< 最后交易日
	char              FirstNoticeDate[11];                        ///< 首次通知日
}EsContractInfo;

//! 交易品种信息
typedef struct _EsCommodityInfo
{
	char			ExchangeNo[11];						//交易所编码
	char		CommodityType;					//品种类型
	char			CommodityNo[11];					//品种编号

	char			CommodityName[21];					//品种名称
	char			CommodityEngName[31];				//品种英文名称

	char			RelateExchangeNo[11];
	char		RelateCommodityType;
	char			RelateCommodityNo[11];

	char			RelateExchangeNo2[11];
	char		RelateCommodityType2;
	char			RelateCommodityNo2[11];

	char			CurrencyGroupNo[11];
	char			TradeCurrency[11];					//交易币种
	double		ContractSize;					//每手乘数
	char		OpenCloseMode;					//开平方式
	double		StrikePriceTimes;				//执行价格倍数

	double		CommodityTickSize;				//最小变动价位
	int			CommodityDenominator;			//报价分母
	char		CmbDirect;						//组合方向
	char		DeliveryMode;					//交割行权方式
	int			DeliveryDays;					//交割日偏移
	char			AddOneTime[9];						//T+1分割时间
	int			CommodityTimeZone;				//品种时区
	char		IsAddOne;						//是否处于T+1时段。
}EsCommodityInfo;	

//! 交易品种信息
typedef struct _QryCommodityType
{
	bool Enable_Spot;					//! 现货
	bool Enable_Futures;				//! 期货
	bool Enable_Option;					//! 期权
	bool Enable_Spread_Month;			//! 跨期套利
	bool Enable_Spread_Commodity;		//! 跨品种套利
	bool Enable_Bul;					//! 看涨垂直套利
	bool Enable_Ber;					//! 看跌垂直套利
	bool Enable_Std;					//! 跨式套利
	bool Enable_Stg;					//! 宽跨式套利
	bool Enable_Prt;					//! 备兑组合
	bool Enable_Directforex;			//! 外汇——直接汇率
	bool Enable_Indirectforex; 			//! 外汇——间接汇率
	bool Enable_Crossforex; 			//! 外汇——交叉汇率
	bool Enable_Index; 					//! 指数
	bool Enable_Stock; 					//! 股票
	
}QryCommodityType;
	
} // end namespace util
} // end namespace xueqiao


#endif /* ESUNNYV9CONTRACTUTIL_DATATYPE_H */