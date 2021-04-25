/*
data struct for parameter
Jason 2018.2.7
*/

#include "EsunnyV3ContractConvertor.h"
#include "Util.h"
#include "EsunnyV3Util.h"
#include "string.h"
#include "stdio.h"

//EsunnyV3期货合约的处理
TechPlatformContractToSledResult EsunnyV3FuturesToSledContract(TechPlatformContractToSledArgs args)
{
	TechPlatformContractToSledResult result;
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

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
	        , args.CommonContract_.TechPlatform_ContractCode_
	        , sizeof(args.CommonContract_.TechPlatform_ContractCode_));

	result.RelateMixContractCount_ = 0; //没有相关合约

	return result;
}

//EsunnyV3跨期合约的处理
TechPlatformContractToSledResult EsunnyV3SpreadMonthToSledContract(TechPlatformContractToSledArgs args)
{
	TechPlatformContractToSledResult result;
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	SledContractCodeType sledContractCode, firstSledContractCode, secondSledContractCode;
	memset(&sledContractCode, 0, sizeof(SledContractCodeType));
	memset(&firstSledContractCode, 0, sizeof(SledContractCodeType));
	memset(&secondSledContractCode, 0, sizeof(SledContractCodeType));

	TwoLegsCommonContractCode contractCodeResult = SplitEsunnyV3SpreadMonthContractCode(args.CommonContract_); // 把形如 1801/1802，拆成 1801和1802 返回

	//得到sled Relate ContractCode
	memcpy(firstSledContractCode, contractCodeResult.FirstContractCode_, sizeof(CommonContractCodeType));	//先得到易盛3.0第一条腿的合约代码，如1801
	memcpy(secondSledContractCode, contractCodeResult.SecondContractCode_, sizeof(CommonContractCodeType));	//先得到易盛3.0 第二条腿的合约代码，如1802

	//得到sled ContractCode，由 firstSledContractCode + "&" + secondSledContractCode
	strcat(sledContractCode, firstSledContractCode); //把第一条腿的代码连接起来
	strncat(sledContractCode, "&", 1); //两条腿之间加入“&”
	strcat(sledContractCode, secondSledContractCode); //把第二条腿的代码连接起来

	//组装返回值
	result.TechPlatform_ = args.TechPlatform_;

	memcpy(&result.MixContract_.TechPlatform_Exchange_, args.CommonContract_.TechPlatform_Exchange_, sizeof(args.CommonContract_.TechPlatform_Exchange_));
	memcpy(&result.MixContract_.TechPlatform_CommodityType_, args.CommonContract_.TechPlatform_CommodityType_, sizeof(args.CommonContract_.TechPlatform_CommodityType_));
	memcpy(&result.MixContract_.TechPlatform_CommodityCode_, args.CommonContract_.TechPlatform_CommodityCode_, sizeof(args.CommonContract_.TechPlatform_CommodityCode_));
	memcpy(&result.MixContract_.SledContractCode_, sledContractCode, sizeof(SledContractCodeType));

	memcpy(&result.RelateMixContract_[0].TechPlatform_Exchange_, args.CommonContract_.TechPlatform_Exchange_, sizeof(args.CommonContract_.TechPlatform_Exchange_));
	result.RelateMixContract_[0].TechPlatform_CommodityType_[0] = EsunnyV3_CommodityType_Futures;
	memcpy(&result.RelateMixContract_[0].TechPlatform_CommodityCode_, args.CommonContract_.TechPlatform_CommodityCode_, sizeof(args.CommonContract_.TechPlatform_CommodityCode_));
	memcpy(&result.RelateMixContract_[0].SledContractCode_, firstSledContractCode, sizeof(SledContractCodeType));

	memcpy(&result.RelateMixContract_[1].TechPlatform_Exchange_, args.CommonContract_.TechPlatform_Exchange_, sizeof(args.CommonContract_.TechPlatform_Exchange_));
	result.RelateMixContract_[1].TechPlatform_CommodityType_[0] = EsunnyV3_CommodityType_Futures;
	memcpy(&result.RelateMixContract_[1].TechPlatform_CommodityCode_, args.CommonContract_.TechPlatform_CommodityCode_, sizeof(args.CommonContract_.TechPlatform_CommodityCode_));
	memcpy(&result.RelateMixContract_[1].SledContractCode_, secondSledContractCode, sizeof(SledContractCodeType));

	result.RelateMixContractCount_ = 2;

	return result;
}

//EsunnyV3默认商品类型的处理
TechPlatformContractToSledResult EsunnyV3DefaultToSledContract(TechPlatformContractToSledArgs args)
{
	//to do
	TechPlatformContractToSledResult result;
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	return result;
}

//雪橇期货合约的处理
SledContractToTechPlatformResult SledFuturesToEsunnyV3Contract(SledContractToTechPlatformArgs args)
{
	SledContractToTechPlatformResult result;
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	//组装返回值
	result.TechPlatform_ = args.TechPlatform_;

	memcpy(&result.CommonContract_.TechPlatform_Exchange_, args.CommodityMap_.TechPlatform_Exchange_, sizeof(args.CommodityMap_.TechPlatform_Exchange_));
	memcpy(&result.CommonContract_.TechPlatform_CommodityType_, args.CommodityMap_.TechPlatform_CommodityType_, sizeof(args.CommodityMap_.TechPlatform_CommodityType_));
	memcpy(&result.CommonContract_.TechPlatform_CommodityCode_, args.CommodityMap_.TechPlatform_CommodityCode_, sizeof(args.CommodityMap_.TechPlatform_CommodityCode_));
	memcpy(&result.CommonContract_.TechPlatform_ContractCode_, args.SledContract_.SledBaseContract_.SledContractCode_, sizeof(args.SledContract_.SledBaseContract_.SledContractCode_));

	result.OtherCommonContractCount_ = 0; //没有第二合约

	return result;
}

//雪橇跨期合约的处理
SledContractToTechPlatformResult SledSpreadMonthToEsunnyV3Contract(SledContractToTechPlatformArgs args)
{
	SledContractToTechPlatformResult result;
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	SledContractCodeType spreadMonthContractCode;
	memset(&spreadMonthContractCode, 0, sizeof(SledContractCodeType));

	strcat(spreadMonthContractCode, args.SledContract_.RelateSledContract_[0].SledContractCode_); //把第一条腿的代码连接起来
	strncat(spreadMonthContractCode, "/", 1); //两条腿之间加入“/”
	strcat(spreadMonthContractCode, args.SledContract_.RelateSledContract_[1].SledContractCode_); //把第二条腿的代码连接起来，最后入：1802/1803

	//组装返回值
	result.TechPlatform_ = args.TechPlatform_;

	memcpy(&result.CommonContract_.TechPlatform_Exchange_, args.CommodityMap_.TechPlatform_Exchange_, sizeof(args.CommodityMap_.TechPlatform_Exchange_));
	memcpy(&result.CommonContract_.TechPlatform_CommodityType_, args.CommodityMap_.TechPlatform_CommodityType_, sizeof(args.CommodityMap_.TechPlatform_CommodityType_));
	memcpy(&result.CommonContract_.TechPlatform_CommodityCode_, args.CommodityMap_.TechPlatform_CommodityCode_, sizeof(args.CommodityMap_.TechPlatform_CommodityCode_));
	memcpy(&result.CommonContract_.TechPlatform_ContractCode_, spreadMonthContractCode, sizeof(SledContractCodeType));

	result.OtherCommonContractCount_ = 0;

	return result;
}

//雪橇默认商品类型的处理
SledContractToTechPlatformResult SledDefaultToEsunnyV3Contract(SledContractToTechPlatformArgs args)
{
	//to do
	SledContractToTechPlatformResult result;
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	return result;
}

TechPlatformContractToSledResult EsunnyV3ToSledContract(TechPlatformContractToSledArgs args)
{
	//非Esunny 3.0技术平台，不是这里处理
	if (args.TechPlatform_ != TechPlatform_ESUNNY_3)
	{
		TechPlatformContractToSledResult result;
		memset(&result, 0, sizeof(TechPlatformContractToSledResult));
		return result;
	}

	EsunnyV3CommodityTypeType esunnyV3CommodityTypeType = getEsunnyV3CommodityType(args.TechPlatform_, args.CommonContract_.TechPlatform_CommodityType_);

	switch (esunnyV3CommodityTypeType)
	{
	case EsunnyV3_CommodityType_Futures:
		return EsunnyV3FuturesToSledContract(args);

	case EsunnyV3_CommodityType_Spread_Month:
		return EsunnyV3SpreadMonthToSledContract(args);

	// to do
	default:
		return EsunnyV3DefaultToSledContract(args);
		break;
	}
}

SledContractToTechPlatformResult SledToEsunnyV3Contract(SledContractToTechPlatformArgs args)
{
	//非Esunny 3.0技术平台，不是这里处理
	if (args.TechPlatform_ != TechPlatform_ESUNNY_3)
	{
		SledContractToTechPlatformResult result;
		memset(&result, 0, sizeof(SledContractToTechPlatformResult));
		return result;
	}

	switch (args.SledContract_.SledBaseContract_.SledCommodityType_)
	{
	case SledCommodityType_FUTURES:
		return SledFuturesToEsunnyV3Contract(args);

	case SledCommodityType_SPREAD_MONTH:
		return SledSpreadMonthToEsunnyV3Contract(args);


	// to do
	default:
		return SledDefaultToEsunnyV3Contract(args);
		break;
	}
}
