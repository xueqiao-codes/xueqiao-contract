/*
data struct for parameter
Jason 2018.1.29
*/

#include "CtpContractConvertor.h"
#include "Util.h"
#include "CtpUtil.h"
#include "string.h"
#include "stdio.h"


//CTP期货合约的处理
TechPlatformContractToSledResult CtpFuturesToSledContract(TechPlatformContractToSledArgs args)
{
	TechPlatformContractToSledResult result;
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	//得到sled ContractCode
	CtpFuturesContractCodeToSledContractCodeResult sledContractCodeResult
	    = CtpFuturesContractCodeToSledContractCode(args.CommonContract_.TechPlatform_ContractCode_
	            , args.CommonContract_.TechPlatform_CommodityCode_);

	//组装返回值
	result.TechPlatform_ = args.TechPlatform_;

	memcpy(&result.MixContract_.TechPlatform_Exchange_
	        , args.CommonContract_.TechPlatform_Exchange_
	        , sizeof(args.CommonContract_.TechPlatform_Exchange_));
	memcpy(&result.MixContract_.TechPlatform_CommodityType_
	        , args.CommonContract_.TechPlatform_CommodityType_
	        , sizeof(args.CommonContract_.TechPlatform_CommodityType_));
	memcpy(&result.MixContract_.TechPlatform_CommodityCode_
	        , args.CommonContract_.TechPlatform_CommodityCode_
	        , sizeof(args.CommonContract_.TechPlatform_CommodityCode_));
	memcpy(&result.MixContract_.SledContractCode_
	        , sledContractCodeResult.SledContractCode_
	        , sizeof(SledContractCodeType));

	result.RelateMixContractCount_ = 0; //没有相关合约

	return result;
}

//CTP跨期/跨商品合约的处理
TechPlatformContractToSledResult CtpSpreadToSledContract(TechPlatformContractToSledArgs args)
{
	TechPlatformContractToSledResult result;
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	CommonCommodityCodeType firstCtpCommodityCode, secondCtpCommodityCode;
	memset(&firstCtpCommodityCode, 0, sizeof(CommonCommodityCodeType));
	memset(&secondCtpCommodityCode, 0, sizeof(CommonCommodityCodeType));	
	TwoLegsCommonCommodityCode resultTwoLegsCommonCommodityCode
	    = SplitCtpSpreadCommodityCode(args.CommonContract_, args.CommonContract_.TechPlatform_CommodityCode_);
	memcpy(&firstCtpCommodityCode
	        , resultTwoLegsCommonCommodityCode.FirstCommdityCode_
	        , sizeof(CommonCommodityCodeType));
	memcpy(&secondCtpCommodityCode
	        , resultTwoLegsCommonCommodityCode.SecondCommdityCode_, sizeof(CommonCommodityCodeType));

	CommonContractCodeType firstCtpContractCode, secondCtpContractCode;
	memset(&firstCtpContractCode, 0, sizeof(CommonContractCodeType));
	memset(&secondCtpContractCode, 0, sizeof(CommonContractCodeType));
	TwoLegsCommonContractCode resultTwoLegsCommonContractCode
	    = SplitCtpSpreadContractCode(args.CommonContract_, args.CommonContract_.TechPlatform_ContractCode_);
	memcpy(&firstCtpContractCode, resultTwoLegsCommonContractCode.FirstContractCode_, sizeof(CommonContractCodeType));
	memcpy(&secondCtpContractCode, resultTwoLegsCommonContractCode.SecondContractCode_, sizeof(CommonContractCodeType));

	SledContractCodeType sledContractCode;
	memset(&sledContractCode, 0, sizeof(SledContractCodeType));

	//得到sled Relate ContractCode
	CtpFuturesContractCodeToSledContractCodeResult firstSledContractCodeResult = CtpFuturesContractCodeToSledContractCode(firstCtpContractCode, firstCtpCommodityCode); //先得到交易所组合每条腿的雪橇合约代码，第一条腿，如1801
	CtpFuturesContractCodeToSledContractCodeResult secondSledContractCodeResult = CtpFuturesContractCodeToSledContractCode(secondCtpContractCode, secondCtpCommodityCode);//先得到交易所组合每条腿的雪橇合约代码，第二条腿，如1802

	//得到sled ContractCode，由 firstSledContractCode + "&" + secondSledContractCode
	strcat(sledContractCode, firstSledContractCodeResult.SledContractCode_); //把第一条腿的代码连接起来
	strncat(sledContractCode, "&", 1); //两条腿之间加入“&”
	strcat(sledContractCode, secondSledContractCodeResult.SledContractCode_); //把第二条腿的代码连接起来

	//组装返回值
	result.TechPlatform_ = args.TechPlatform_;

	memcpy(&result.MixContract_.TechPlatform_Exchange_
	        , args.CommonContract_.TechPlatform_Exchange_
	        , sizeof(args.CommonContract_.TechPlatform_Exchange_));
	memcpy(&result.MixContract_.TechPlatform_CommodityType_
	        , args.CommonContract_.TechPlatform_CommodityType_
	        , sizeof(args.CommonContract_.TechPlatform_CommodityType_));
	memcpy(&result.MixContract_.TechPlatform_CommodityCode_
	        , args.CommonContract_.TechPlatform_CommodityCode_
	        , sizeof(args.CommonContract_.TechPlatform_CommodityCode_));
	memcpy(&result.MixContract_.SledContractCode_, sledContractCode, sizeof(SledContractCodeType));

	memcpy(&result.RelateMixContract_[0].TechPlatform_Exchange_
	        , args.CommonContract_.TechPlatform_Exchange_, sizeof(args.CommonContract_.TechPlatform_Exchange_));
	result.RelateMixContract_[0].TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&result.RelateMixContract_[0].TechPlatform_CommodityCode_
	        , firstCtpCommodityCode, sizeof(args.CommonContract_.TechPlatform_CommodityCode_));
	memcpy(&result.RelateMixContract_[0].SledContractCode_
	        , firstSledContractCodeResult.SledContractCode_, sizeof(SledContractCodeType));

	memcpy(&result.RelateMixContract_[1].TechPlatform_Exchange_
	        , args.CommonContract_.TechPlatform_Exchange_
	        , sizeof(args.CommonContract_.TechPlatform_Exchange_));
	result.RelateMixContract_[1].TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&result.RelateMixContract_[1].TechPlatform_CommodityCode_
	        , secondCtpCommodityCode
	        , sizeof(args.CommonContract_.TechPlatform_CommodityCode_));
	memcpy(&result.RelateMixContract_[1].SledContractCode_
	        , secondSledContractCodeResult.SledContractCode_, sizeof(SledContractCodeType));

	result.RelateMixContractCount_ = 2;

	return result;
}

//CTP期权合约的处理
TechPlatformContractToSledResult CtpOptionsToSledContract(TechPlatformContractToSledArgs args)
{
	//to do
	TechPlatformContractToSledResult result;
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	return result;
}

//CTP默认商品类型的处理
TechPlatformContractToSledResult CtpDefaultToSledContract(TechPlatformContractToSledArgs args)
{
	//to do
	TechPlatformContractToSledResult result;
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	return result;
}


//雪橇期货合约的处理
SledContractToTechPlatformResult SledFuturesToCtpContract(SledContractToTechPlatformArgs args)
{
	SledContractToTechPlatformResult result;
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	if (args.SledContract_.SledBaseContract_.SledCommodityType_ != SledCommodityType_FUTURES)
		return result;

	//获取CTP的合约代码
	SledContractCodeToCtpFuturesContractCodeResult commonContractCodeResult
	    = SledContractCodeToCtpFuturesContractCode(args.SledContract_.SledBaseContract_.ExchangeMic_
	            , args.CommodityMap_.TechPlatform_CommodityCode_
	            , args.SledContract_.SledBaseContract_.SledContractCode_);
	
	//组装返回值
	result.TechPlatform_ = args.TechPlatform_;

	memcpy(&result.CommonContract_.TechPlatform_Exchange_
	        , args.CommodityMap_.TechPlatform_Exchange_, sizeof(args.CommodityMap_.TechPlatform_Exchange_));
	memcpy(&result.CommonContract_.TechPlatform_CommodityType_
	        , args.CommodityMap_.TechPlatform_CommodityType_
	        , sizeof(args.CommodityMap_.TechPlatform_CommodityType_));
	memcpy(&result.CommonContract_.TechPlatform_CommodityCode_
	        , args.CommodityMap_.TechPlatform_CommodityCode_
	        , sizeof(args.CommodityMap_.TechPlatform_CommodityCode_));
	memcpy(&result.CommonContract_.TechPlatform_ContractCode_
	        , commonContractCodeResult.CommonContractCode_, sizeof(CommonContractCodeType));

	result.OtherCommonContractCount_ = 0; //没有第二合约

	return result;
}

//雪橇跨期/跨商品合约的处理
SledContractToTechPlatformResult SledSpreadToCtpContract(SledContractToTechPlatformArgs args)
{
	SledContractToTechPlatformResult result;
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	if ( !(args.SledContract_.SledBaseContract_.SledCommodityType_ == SledCommodityType_SPREAD_MONTH || args.SledContract_.SledBaseContract_.SledCommodityType_ == SledCommodityType_SPREAD_COMMODITY) )
		return result;

	CommonContractCodeType ctpContractCode;
	memset(&ctpContractCode, 0, sizeof(CommonContractCodeType));

	if (args.SledContract_.SledBaseContract_.SledCommodityType_ == SledCommodityType_SPREAD_MONTH) //跨期
	{
		if (strcmp(args.SledContract_.SledBaseContract_.ExchangeMic_, "XZCE") == 0) //郑商所
			strcat(ctpContractCode, "SPD "); //连接字符串
		else if (strcmp(args.SledContract_.SledBaseContract_.ExchangeMic_, "XDCE") == 0) //大商所
			strcat(ctpContractCode, "SP "); //连接字符串
	}
	else if (args.SledContract_.SledBaseContract_.SledCommodityType_ == SledCommodityType_SPREAD_COMMODITY) //跨品种
	{
		if (strcmp(args.SledContract_.SledBaseContract_.ExchangeMic_, "XZCE") == 0) //郑商所
			strcat(ctpContractCode, "IPS "); //连接字符串
		else if (strcmp(args.SledContract_.SledBaseContract_.ExchangeMic_, "XDCE") == 0) //大商所
			strcat(ctpContractCode, "SPC "); //连接字符串，结果"SPC "
	}

	SledContractCodeToCtpFuturesContractCodeResult firstCtpContractCodeResult
	    = SledContractCodeToCtpFuturesContractCode(args.SledContract_.SledBaseContract_.ExchangeMic_
	            , args.RelateCommodityMap_[0].TechPlatform_CommodityCode_
	            , args.SledContract_.RelateSledContract_[0].SledContractCode_);
	strcat(ctpContractCode, firstCtpContractCodeResult.CommonContractCode_); //连接字符串，结果"IPS SF801"

	strcat(ctpContractCode, "&"); //连接字符串，结果"IPS SF801&"

	SledContractCodeToCtpFuturesContractCodeResult secondCtpContractCodeResult = SledContractCodeToCtpFuturesContractCode(
	            args.SledContract_.SledBaseContract_.ExchangeMic_
	            , args.RelateCommodityMap_[1].TechPlatform_CommodityCode_, args.SledContract_.RelateSledContract_[1].SledContractCode_);
	strcat(ctpContractCode, secondCtpContractCodeResult.CommonContractCode_); //连接字符串，结果"IPS SF801&SM801"

	//组装返回值
	result.TechPlatform_ = args.TechPlatform_;

	memcpy(&result.CommonContract_.TechPlatform_Exchange_
	        , args.CommodityMap_.TechPlatform_Exchange_
	        , sizeof(args.CommodityMap_.TechPlatform_Exchange_));
	memcpy(&result.CommonContract_.TechPlatform_CommodityType_
	        , args.CommodityMap_.TechPlatform_CommodityType_
	        , sizeof(args.CommodityMap_.TechPlatform_CommodityType_));
	memcpy(&result.CommonContract_.TechPlatform_CommodityCode_
	        , args.CommodityMap_.TechPlatform_CommodityCode_
	        , sizeof(args.CommodityMap_.TechPlatform_CommodityCode_));
	memcpy(&result.CommonContract_.TechPlatform_ContractCode_, ctpContractCode, sizeof(CommonContractCodeType));

	result.OtherCommonContractCount_ = 0; //没有第二合约

	return result;
}

//雪橇默认商品类型的处理
SledContractToTechPlatformResult SledDefaultToCtpContract(SledContractToTechPlatformArgs args)
{
	//to do
	SledContractToTechPlatformResult result;
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	return result;
}

/*
	功能：CTP合约信息转换为雪橇合约信息
	提示：请确保每个字段不要带前后空格，否则，可能结果不正确
*/
TechPlatformContractToSledResult CtpToSledContract(TechPlatformContractToSledArgs args)
{
	//非CTP技术平台，不是这里处理
	if (args.TechPlatform_ != TechPlatform_CTP)
	{
		TechPlatformContractToSledResult result;
		memset(&result, 0, sizeof(TechPlatformContractToSledResult));
		return result;
	}	

	CtpCommodityTypeType ctpCommodityType = getCtpCommodityType(args.TechPlatform_, args.CommonContract_.TechPlatform_CommodityType_);

	switch (ctpCommodityType)
	{
	case Ctp_CommodityType_Futures:
		return CtpFuturesToSledContract(args);

	case Ctp_CommodityType_Combination:
		return CtpSpreadToSledContract(args);

	// to do
	default:
		return CtpDefaultToSledContract(args);
		break;
	}
}


/*
功能：雪橇合约信息 转换为 CTP合约信息
提示：请确保每个字段不要带前后空格，否则，可能结果不正确
*/
SledContractToTechPlatformResult SledToCtpContract(SledContractToTechPlatformArgs args)
{
	//非CTP技术平台，不是这里处理
	if (args.TechPlatform_ != TechPlatform_CTP)
	{
		SledContractToTechPlatformResult result;
		memset(&result, 0, sizeof(SledContractToTechPlatformResult));
		return result;
	}

	switch (args.SledContract_.SledBaseContract_.SledCommodityType_)
	{
	case SledCommodityType_FUTURES:
		return SledFuturesToCtpContract(args);

	case SledCommodityType_SPREAD_MONTH:
		return SledSpreadToCtpContract(args);

	case SledCommodityType_SPREAD_COMMODITY:
		return SledSpreadToCtpContract(args);

	// to do
	default:
		return SledDefaultToCtpContract(args);
		break;
	}
}
