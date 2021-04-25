/*
 * datatype.h
 *
 *  ��ʢ����9.0�ӿ�
 *
 *  Created on: 2018��7��18��
 *      Author: Jason
 */

#ifndef ESUNNYV9CONTRACTUTIL_DATATYPE_H
#define ESUNNYV9CONTRACTUTIL_DATATYPE_H

//! Ʒ������
//! ��
#define		ESUNNY9_COMMODITY_TYPE_NONE				 	 'N';
//! �ֻ�
#define		ESUNNY9_COMMODITY_TYPE_SPOT				 	 'P';
//! �ڻ�
#define		ESUNNY9_COMMODITY_TYPE_FUTURES				 'F';
//! ��Ȩ
#define		ESUNNY9_COMMODITY_TYPE_OPTION				 'O';
//! ��������
#define		ESUNNY9_COMMODITY_TYPE_SPREAD_MONTH		 	 'S';
//! ��Ʒ������
#define		ESUNNY9_COMMODITY_TYPE_SPREAD_COMMODITY	 	 'M';
//! ���Ǵ�ֱ����
#define		ESUNNY9_COMMODITY_TYPE_BUL					 'U';
//! ������ֱ����
#define		ESUNNY9_COMMODITY_TYPE_BER					 'E';
//! ��ʽ����
#define		ESUNNY9_COMMODITY_TYPE_STD					 'D';
//! ���ʽ����
#define		ESUNNY9_COMMODITY_TYPE_STG					 'G';
//! �������
#define		ESUNNY9_COMMODITY_TYPE_PRT					 'R';
//! ��㡪��ֱ�ӻ���
#define		ESUNNY9_COMMODITY_TYPE_DIRECTFOREX			 'X';
//! ��㡪����ӻ���
#define		ESUNNY9_COMMODITY_TYPE_INDIRECTFOREX		 'I';
//! ��㡪���������
#define		ESUNNY9_COMMODITY_TYPE_CROSSFOREX			 'C';
//! ָ��
#define		ESUNNY9_COMMODITY_TYPE_INDEX				 'Z';
//! ��Ʊ
#define		ESUNNY9_COMMODITY_TYPE_STOCK				 'T';


//! ���ǿ�����ʾ
//! ��Ȩ
#define		ESUNNY9_CALLPUT_FLAG_CALL				 	 'C';
//! ��Ȩ
#define		ESUNNY9_CALLPUT_FLAG_PUT					 'P';
//! ��
#define		ESUNNY9_CALLPUT_FLAG_NONE					 'N';

//! ��Լ����
//! ���������Լ
#define		ESUNNY9_CONTRACT_TYPE_TRADEQUOTE			 '1';
//! �����Լ
#define		ESUNNY9_CONTRACT_TYPE_QUOTE					 '2';



//! ��ƽ��ʽ
//! �����ֿ�ƽ
#define		ESUNNY9_CLOSE_MODE_NONE				 		 'N';
//! ƽ��δ�˽�
#define		ESUNNY9_CLOSE_MODE_UNFINISHED			 	 'U';
//! ���ֿ��ֺ�ƽ��
#define		ESUNNY9_CLOSE_MODE_OPENCOVER			 	 'C';
//! ���ֿ��֡�ƽ�ֺ�ƽ��
#define		ESUNNY9_CLOSE_MODE_CLOSETODAY			 	 'T';



//! ��Ϸ���,Ʒ��������Ϻ�Լ����������͵ڼ�����ͬ
//! �͵�һ��һ��
#define     ESUNNY9_CMB_DIRECT_FIRST                     '1';
//! �͵ڶ���һ��
#define     ESUNNY9_CMB_DIRECT_SECOND                    '2';



//! ������Ȩ��ʽ,�ڻ�����Ȩ�˽�ķ�ʽ
//! ʵ�ｻ��
#define		ESUNNY9_DELIVERY_MODE_GOODS			 		 'G';
//! �ֽ𽻸�
#define		ESUNNY9_DELIVERY_MODE_CASH				 	 'C';
//! ��Ȩ��Ȩ
#define		ESUNNY9_DELIVERY_MODE_EXECUTE				 'E';
//! ��Ȩ����
#define		ESUNNY9_DELIVERY_MODE_ABANDON				 'A';
//! �۽�����Ȩ
#define		ESUNNY9_DELIVERY_MODE_HKF					 'H';
	

//! �Ƿ��ʾ
//! ��
#define		ESUNNY9_YNFLAG_YES	'Y';
//! ��
#define		ESUNNY9_YNFLAG_NO	'N';


namespace xueqiao {
namespace util {
	
//��ʼ������¼��Ϣ
typedef struct _EsLoginInfo {
	char userNo[20];
	char password[20];
	char ip[16];
	int port;
	char authCode[513];
}EsLoginInfo;

//! ���׺�Լ��Ϣ
typedef struct _EsContractInfo
{
	char              ExchangeNo[11];                             ///< ����������
	char			CommodityType;                          ///< Ʒ������
	char              CommodityNo[11];                            ///< Ʒ�ֱ��
	char              ContractNo1[11];                            ///< ��Լ����1
	char              StrikePrice1[11];                           ///< ִ�м�1
	char			CallOrPutFlag1;                         ///< ���ǿ�����ʾ1
	char              ContractNo2[11];                            ///< ��Լ����2
	char              StrikePrice2[11];                           ///< ִ�м�2
	char			CallOrPutFlag2;                         ///< ���ǿ�����ʾ2
	char			ContractType;                           ///< ��Լ����
	char			  QuoteUnderlyingContract[11];				///< ������ʵ��Լ
	char              ContractName[71];                           ///< ��Լ����
	char              ContractExpDate[11];                        ///< ��Լ������	
	char              LastTradeDate[11];                          ///< �������
	char              FirstNoticeDate[11];                        ///< �״�֪ͨ��
}EsContractInfo;

//! ����Ʒ����Ϣ
typedef struct _EsCommodityInfo
{
	char			ExchangeNo[11];						//����������
	char		CommodityType;					//Ʒ������
	char			CommodityNo[11];					//Ʒ�ֱ��

	char			CommodityName[21];					//Ʒ������
	char			CommodityEngName[31];				//Ʒ��Ӣ������

	char			RelateExchangeNo[11];
	char		RelateCommodityType;
	char			RelateCommodityNo[11];

	char			RelateExchangeNo2[11];
	char		RelateCommodityType2;
	char			RelateCommodityNo2[11];

	char			CurrencyGroupNo[11];
	char			TradeCurrency[11];					//���ױ���
	double		ContractSize;					//ÿ�ֳ���
	char		OpenCloseMode;					//��ƽ��ʽ
	double		StrikePriceTimes;				//ִ�м۸���

	double		CommodityTickSize;				//��С�䶯��λ
	int			CommodityDenominator;			//���۷�ĸ
	char		CmbDirect;						//��Ϸ���
	char		DeliveryMode;					//������Ȩ��ʽ
	int			DeliveryDays;					//������ƫ��
	char			AddOneTime[9];						//T+1�ָ�ʱ��
	int			CommodityTimeZone;				//Ʒ��ʱ��
	char		IsAddOne;						//�Ƿ���T+1ʱ�Ρ�
}EsCommodityInfo;	

//! ����Ʒ����Ϣ
typedef struct _QryCommodityType
{
	bool Enable_Spot;					//! �ֻ�
	bool Enable_Futures;				//! �ڻ�
	bool Enable_Option;					//! ��Ȩ
	bool Enable_Spread_Month;			//! ��������
	bool Enable_Spread_Commodity;		//! ��Ʒ������
	bool Enable_Bul;					//! ���Ǵ�ֱ����
	bool Enable_Ber;					//! ������ֱ����
	bool Enable_Std;					//! ��ʽ����
	bool Enable_Stg;					//! ���ʽ����
	bool Enable_Prt;					//! �������
	bool Enable_Directforex;			//! ��㡪��ֱ�ӻ���
	bool Enable_Indirectforex; 			//! ��㡪����ӻ���
	bool Enable_Crossforex; 			//! ��㡪���������
	bool Enable_Index; 					//! ָ��
	bool Enable_Stock; 					//! ��Ʊ
	
}QryCommodityType;
	
} // end namespace util
} // end namespace xueqiao


#endif /* ESUNNYV9CONTRACTUTIL_DATATYPE_H */