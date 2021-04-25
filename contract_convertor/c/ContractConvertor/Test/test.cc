/*
data struct for parameter
Jason 2018.1.29
*/

#include "../DataStruct.h"
#include "../ContractConvertor.h"
#include "string.h"
#include "stdio.h"

void testCtpFuturesToSledContract()
{
	TechPlatformContractToSledArgs args;
	TechPlatformContractToSledResult result;

	// 测试1 -- 郑商所期货
	memset(&args, 0, sizeof(TechPlatformContractToSledArgs));
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	memcpy(&args.CommonContract_.TechPlatform_Exchange_, "CZCE", strlen("CZCE"));
	args.CommonContract_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.CommonContract_.TechPlatform_CommodityCode_, "RM", strlen("RM"));
	memcpy(&args.CommonContract_.TechPlatform_ContractCode_, "RM801", strlen("RM801"));

	args.TechPlatform_ = TechPlatform_CTP;

	result = PlatformToSledContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("CTP Exchange:%s\n", args.CommonContract_.TechPlatform_Exchange_);
	printf("CTP CommodityType:%s\n", args.CommonContract_.TechPlatform_CommodityType_);
	printf("CTP Commodity:%s\n", args.CommonContract_.TechPlatform_CommodityCode_);
	printf("CTP ContractCode:%s\n\n", args.CommonContract_.TechPlatform_ContractCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CtpExchange:%s\n", result.MixContract_.TechPlatform_Exchange_);
	printf("CtpCommodityClass:%s\n", result.MixContract_.TechPlatform_CommodityType_);
	printf("CtpCommodityCode:%s\n", result.MixContract_.TechPlatform_CommodityCode_);
	printf("SledContractCode:%s\n", result.MixContract_.SledContractCode_);

	printf("RelateMixContractCount:%d\n", result.RelateMixContractCount_);

	printf("Relate[0] CtpExchange:%s\n", result.RelateMixContract_[0].TechPlatform_Exchange_);
	printf("Relate[0] CtpCommodityClass:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityType_);
	printf("Relate[0] CtpCommodityCode:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityCode_);
	printf("Relate[0] SledContractCode:%s\n", result.RelateMixContract_[0].SledContractCode_);

	printf("Relate[1] CtpExchange:%s\n", result.RelateMixContract_[1].TechPlatform_Exchange_);
	printf("Relate[1] CtpCommodityClass:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityType_);
	printf("Relate[1] CtpCommodityCode:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityCode_);
	printf("Relate[1] SledContractCode:%s\n\n\n", result.RelateMixContract_[1].SledContractCode_);


	// 测试2 -- 中金所所期货
	memset(&args, 0, sizeof(TechPlatformContractToSledArgs));
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	memcpy(&args.CommonContract_.TechPlatform_Exchange_, "CFFEX", strlen("CFFEX"));
	args.CommonContract_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.CommonContract_.TechPlatform_CommodityCode_, "IF", strlen("IF"));
	memcpy(&args.CommonContract_.TechPlatform_ContractCode_, "IF1803", strlen("IF1803"));

	args.TechPlatform_ = TechPlatform_CTP;

	result = PlatformToSledContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("CTP Exchange:%s\n", args.CommonContract_.TechPlatform_Exchange_);
	printf("CTP CommodityType:%s\n", args.CommonContract_.TechPlatform_CommodityType_);
	printf("CTP Commodity:%s\n", args.CommonContract_.TechPlatform_CommodityCode_);
	printf("CTP ContractCode:%s\n\n", args.CommonContract_.TechPlatform_ContractCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CtpExchange:%s\n", result.MixContract_.TechPlatform_Exchange_);
	printf("CtpCommodityClass:%s\n", result.MixContract_.TechPlatform_CommodityType_);
	printf("CtpCommodityCode:%s\n", result.MixContract_.TechPlatform_CommodityCode_);
	printf("SledContractCode:%s\n", result.MixContract_.SledContractCode_);

	printf("RelateMixContractCount:%d\n", result.RelateMixContractCount_);

	printf("Relate[0] CtpExchange:%s\n", result.RelateMixContract_[0].TechPlatform_Exchange_);
	printf("Relate[0] CtpCommodityClass:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityType_);
	printf("Relate[0] CtpCommodityCode:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityCode_);
	printf("Relate[0] SledContractCode:%s\n", result.RelateMixContract_[0].SledContractCode_);

	printf("Relate[1] CtpExchange:%s\n", result.RelateMixContract_[1].TechPlatform_Exchange_);
	printf("Relate[1] CtpCommodityClass:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityType_);
	printf("Relate[1] CtpCommodityCode:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityCode_);
	printf("Relate[1] SledContractCode:%s\n\n\n", result.RelateMixContract_[1].SledContractCode_);
	
}


void testCtpSpreadToSledContract()
{
	TechPlatformContractToSledArgs args;
	TechPlatformContractToSledResult result;

	// 测试1 -- 郑商所跨期
	memset(&args, 0, sizeof(TechPlatformContractToSledArgs));
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	memcpy(&args.CommonContract_.TechPlatform_Exchange_, "CZCE", strlen("CZCE"));
	args.CommonContract_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Combination;
	memcpy(&args.CommonContract_.TechPlatform_CommodityCode_, "SPD CY&CY", strlen("SPD CY&CY"));
	memcpy(&args.CommonContract_.TechPlatform_ContractCode_, "SPD CY809&CY812", strlen("SPD CY809&CY812"));

	args.TechPlatform_ = TechPlatform_CTP;

	result = PlatformToSledContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("CTP Exchange:%s\n", args.CommonContract_.TechPlatform_Exchange_);
	printf("CTP CommodityType:%s\n", args.CommonContract_.TechPlatform_CommodityType_);
	printf("CTP Commodity:%s\n", args.CommonContract_.TechPlatform_CommodityCode_);
	printf("CTP ContractCode:%s\n\n", args.CommonContract_.TechPlatform_ContractCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CtpExchange:%s\n", result.MixContract_.TechPlatform_Exchange_);
	printf("CtpCommodityClass:%s\n", result.MixContract_.TechPlatform_CommodityType_);
	printf("CtpCommodityCode:%s\n", result.MixContract_.TechPlatform_CommodityCode_);
	printf("SledContractCode:%s\n", result.MixContract_.SledContractCode_);

	printf("RelateMixContractCount:%d\n", result.RelateMixContractCount_);

	printf("Relate[0] CtpExchange:%s\n", result.RelateMixContract_[0].TechPlatform_Exchange_);
	printf("Relate[0] CtpCommodityClass:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityType_);
	printf("Relate[0] CtpCommodityCode:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityCode_);
	printf("Relate[0] SledContractCode:%s\n", result.RelateMixContract_[0].SledContractCode_);

	printf("Relate[1] CtpExchange:%s\n", result.RelateMixContract_[1].TechPlatform_Exchange_);
	printf("Relate[1] CtpCommodityClass:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityType_);
	printf("Relate[1] CtpCommodityCode:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityCode_);
	printf("Relate[1] SledContractCode:%s\n\n\n", result.RelateMixContract_[1].SledContractCode_);

	// 测试2 -- 郑商所跨品种
	memset(&args, 0, sizeof(TechPlatformContractToSledArgs));
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	memcpy(&args.CommonContract_.TechPlatform_Exchange_, "CZCE", strlen("CZCE"));
	args.CommonContract_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Combination;
	memcpy(&args.CommonContract_.TechPlatform_CommodityCode_, "IPS SF&SM", strlen("IPS SF&SM"));
	memcpy(&args.CommonContract_.TechPlatform_ContractCode_, "IPS SF805&SM805", strlen("IPS SF805&SM805"));

	args.TechPlatform_ = TechPlatform_CTP;

	result = PlatformToSledContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("CTP Exchange:%s\n", args.CommonContract_.TechPlatform_Exchange_);
	printf("CTP CommodityType:%s\n", args.CommonContract_.TechPlatform_CommodityType_);
	printf("CTP Commodity:%s\n", args.CommonContract_.TechPlatform_CommodityCode_);
	printf("CTP ContractCode:%s\n\n", args.CommonContract_.TechPlatform_ContractCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CtpExchange:%s\n", result.MixContract_.TechPlatform_Exchange_);
	printf("CtpCommodityClass:%s\n", result.MixContract_.TechPlatform_CommodityType_);
	printf("CtpCommodityCode:%s\n", result.MixContract_.TechPlatform_CommodityCode_);
	printf("SledContractCode:%s\n", result.MixContract_.SledContractCode_);

	printf("RelateMixContractCount:%d\n", result.RelateMixContractCount_);

	printf("Relate[0] CtpExchange:%s\n", result.RelateMixContract_[0].TechPlatform_Exchange_);
	printf("Relate[0] CtpCommodityClass:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityType_);
	printf("Relate[0] CtpCommodityCode:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityCode_);
	printf("Relate[0] SledContractCode:%s\n", result.RelateMixContract_[0].SledContractCode_);

	printf("Relate[1] CtpExchange:%s\n", result.RelateMixContract_[1].TechPlatform_Exchange_);
	printf("Relate[1] CtpCommodityClass:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityType_);
	printf("Relate[1] CtpCommodityCode:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityCode_);
	printf("Relate[1] SledContractCode:%s\n\n\n", result.RelateMixContract_[1].SledContractCode_);


	// 测试3 -- 大商所跨期
	memset(&args, 0, sizeof(TechPlatformContractToSledArgs));
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	memcpy(&args.CommonContract_.TechPlatform_Exchange_, "DCE", strlen("DCE"));
	args.CommonContract_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Combination;
	memcpy(&args.CommonContract_.TechPlatform_CommodityCode_, "SP i&i", strlen("SP i&i"));
	memcpy(&args.CommonContract_.TechPlatform_ContractCode_, "SP i1901&i1901", strlen("SP i1901&i1901"));

	args.TechPlatform_ = TechPlatform_CTP;

	result = PlatformToSledContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("CTP Exchange:%s\n", args.CommonContract_.TechPlatform_Exchange_);
	printf("CTP CommodityType:%s\n", args.CommonContract_.TechPlatform_CommodityType_);
	printf("CTP Commodity:%s\n", args.CommonContract_.TechPlatform_CommodityCode_);
	printf("CTP ContractCode:%s\n\n", args.CommonContract_.TechPlatform_ContractCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CtpExchange:%s\n", result.MixContract_.TechPlatform_Exchange_);
	printf("CtpCommodityClass:%s\n", result.MixContract_.TechPlatform_CommodityType_);
	printf("CtpCommodityCode:%s\n", result.MixContract_.TechPlatform_CommodityCode_);
	printf("SledContractCode:%s\n", result.MixContract_.SledContractCode_);

	printf("RelateMixContractCount:%d\n", result.RelateMixContractCount_);

	printf("Relate[0] CtpExchange:%s\n", result.RelateMixContract_[0].TechPlatform_Exchange_);
	printf("Relate[0] CtpCommodityClass:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityType_);
	printf("Relate[0] CtpCommodityCode:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityCode_);
	printf("Relate[0] SledContractCode:%s\n", result.RelateMixContract_[0].SledContractCode_);

	printf("Relate[1] CtpExchange:%s\n", result.RelateMixContract_[1].TechPlatform_Exchange_);
	printf("Relate[1] CtpCommodityClass:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityType_);
	printf("Relate[1] CtpCommodityCode:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityCode_);
	printf("Relate[1] SledContractCode:%s\n\n\n", result.RelateMixContract_[1].SledContractCode_);

	// 测试4 -- 大商所跨品种
	memset(&args, 0, sizeof(TechPlatformContractToSledArgs));
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	memcpy(&args.CommonContract_.TechPlatform_Exchange_, "DCE", strlen("DCE"));
	args.CommonContract_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Combination;
	memcpy(&args.CommonContract_.TechPlatform_CommodityCode_, "SPC y&p", strlen("SPC y&p"));
	memcpy(&args.CommonContract_.TechPlatform_ContractCode_, "SPC y1809&p1809", strlen("SPC y1809&p1809"));

	args.TechPlatform_ = TechPlatform_CTP;

	result = PlatformToSledContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("CTP Exchange:%s\n", args.CommonContract_.TechPlatform_Exchange_);
	printf("CTP CommodityType:%s\n", args.CommonContract_.TechPlatform_CommodityType_);
	printf("CTP Commodity:%s\n", args.CommonContract_.TechPlatform_CommodityCode_);
	printf("CTP ContractCode:%s\n\n", args.CommonContract_.TechPlatform_ContractCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CtpExchange:%s\n", result.MixContract_.TechPlatform_Exchange_);
	printf("CtpCommodityClass:%s\n", result.MixContract_.TechPlatform_CommodityType_);
	printf("CtpCommodityCode:%s\n", result.MixContract_.TechPlatform_CommodityCode_);
	printf("SledContractCode:%s\n", result.MixContract_.SledContractCode_);

	printf("RelateMixContractCount:%d\n", result.RelateMixContractCount_);

	printf("Relate[0] CtpExchange:%s\n", result.RelateMixContract_[0].TechPlatform_Exchange_);
	printf("Relate[0] CtpCommodityClass:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityType_);
	printf("Relate[0] CtpCommodityCode:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityCode_);
	printf("Relate[0] SledContractCode:%s\n", result.RelateMixContract_[0].SledContractCode_);

	printf("Relate[1] CtpExchange:%s\n", result.RelateMixContract_[1].TechPlatform_Exchange_);
	printf("Relate[1] CtpCommodityClass:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityType_);
	printf("Relate[1] CtpCommodityCode:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityCode_);
	printf("Relate[1] SledContractCode:%s\n\n\n", result.RelateMixContract_[1].SledContractCode_);
}

void testSledFuturesToCtpContract()
{
	SledContractToTechPlatformArgs args;
	SledContractToTechPlatformResult result;

	// 测试1 -- 郑商所期货
	memset(&args, 0, sizeof(SledContractToTechPlatformArgs));
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	args.TechPlatform_ = TechPlatform_CTP;

	memcpy(&args.SledContract_.SledBaseContract_.ExchangeMic_, "XZCE", strlen("XZCE"));
	args.SledContract_.SledBaseContract_.SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.SledBaseContract_.SledCommodityCode_, "SF", strlen("SF"));
	memcpy(&args.SledContract_.SledBaseContract_.SledContractCode_, "2001", strlen("2001"));

	//商品映射Map
	args.CommodityMap_.TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.CommodityMap_.TechPlatform_Exchange_, "CZCE", strlen("CZCE"));
	args.CommodityMap_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.CommodityMap_.TechPlatform_CommodityCode_, "SF", strlen("SF"));

	args.RelateCommodityMapCount_ = 0;

	result = SledToPlatformContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("Sled Exchange:%s\n", args.SledContract_.SledBaseContract_.ExchangeMic_);
	printf("Sled CommodityType:%d\n", args.SledContract_.SledBaseContract_.SledCommodityType_);
	printf("Sled Commodity:%s\n", args.SledContract_.SledBaseContract_.SledCommodityCode_);
	printf("Sled ContractCode:%s\n\n", args.SledContract_.SledBaseContract_.SledContractCode_);

	printf("Relate[0] Exchange:%s\n", args.SledContract_.RelateSledContract_[0].ExchangeMic_);
	printf("Relate[0] CommodityType:%d\n", args.SledContract_.RelateSledContract_[0].SledCommodityType_);
	printf("Relate[0] Commodity:%s\n", args.SledContract_.RelateSledContract_[0].SledCommodityCode_);
	printf("Relate[0] ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[0].SledContractCode_);

	printf("Relate[1] Exchange:%s\n", args.SledContract_.RelateSledContract_[1].ExchangeMic_);
	printf("Relate[1] CommodityType:%d\n", args.SledContract_.RelateSledContract_[1].SledCommodityType_);
	printf("Relate[1] Commodity:%s\n", args.SledContract_.RelateSledContract_[1].SledCommodityCode_);
	printf("Relate[1] ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[1].SledContractCode_);

	printf("Map Tech Platform:%d\n", args.CommodityMap_.TechPlatform_);
	printf("Map CTP Exchange:%s\n", args.CommodityMap_.TechPlatform_Exchange_);
	printf("Map CTP CommodityType:%s\n", args.CommodityMap_.TechPlatform_CommodityType_);
	printf("Map CTP Commodity:%s\n", args.CommodityMap_.TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[0].TechPlatform_);
	printf("Map CTP Relate[0] Exchange:%s\n", args.RelateCommodityMap_[0].TechPlatform_Exchange_);
	printf("Map CTP Relate[0] CommodityType:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityType_);
	printf("Map CTP Relate[0] Commodity:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[1].TechPlatform_);
	printf("Map CTP Relate[1] Exchange:%s\n", args.RelateCommodityMap_[1].TechPlatform_Exchange_);
	printf("Map CTP Relate[1] CommodityType:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityType_);
	printf("Map CTP Relate[1] Commodity:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CTPContractCode:%s\n", result.CommonContract_.TechPlatform_ContractCode_);
	printf("OtherCommonContractCount:%d\n\n\n", result.OtherCommonContractCount_);


	// 测试2 -- 上期所期货
	memset(&args, 0, sizeof(SledContractToTechPlatformArgs));
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	args.TechPlatform_ = TechPlatform_CTP;

	memcpy(&args.SledContract_.SledBaseContract_.ExchangeMic_, "XSGE", strlen("XSGE"));
	args.SledContract_.SledBaseContract_.SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.SledBaseContract_.SledCommodityCode_, "au", strlen("au"));
	memcpy(&args.SledContract_.SledBaseContract_.SledContractCode_, "1806", strlen("1806"));

	//商品映射Map
	args.CommodityMap_.TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.CommodityMap_.TechPlatform_Exchange_, "SHFE", strlen("SHFE"));
	args.CommodityMap_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.CommodityMap_.TechPlatform_CommodityCode_, "au", strlen("au"));

	args.RelateCommodityMapCount_ = 0;

	result = SledToPlatformContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("Sled Exchange:%s\n", args.SledContract_.SledBaseContract_.ExchangeMic_);
	printf("Sled CommodityType:%d\n", args.SledContract_.SledBaseContract_.SledCommodityType_);
	printf("Sled Commodity:%s\n", args.SledContract_.SledBaseContract_.SledCommodityCode_);
	printf("Sled ContractCode:%s\n\n", args.SledContract_.SledBaseContract_.SledContractCode_);

	printf("Relate[0] Exchange:%s\n", args.SledContract_.RelateSledContract_[0].ExchangeMic_);
	printf("Relate[0] CommodityType:%d\n", args.SledContract_.RelateSledContract_[0].SledCommodityType_);
	printf("Relate[0]Commodity:%s\n", args.SledContract_.RelateSledContract_[0].SledCommodityCode_);
	printf("Relate[0]ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[0].SledContractCode_);

	printf("Relate[1] Exchange:%s\n", args.SledContract_.RelateSledContract_[1].ExchangeMic_);
	printf("Relate[1] CommodityType:%d\n", args.SledContract_.RelateSledContract_[1].SledCommodityType_);
	printf("Relate[1] Commodity:%s\n", args.SledContract_.RelateSledContract_[1].SledCommodityCode_);
	printf("Relate[1] ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[1].SledContractCode_);

	printf("Map Tech Platform:%d\n", args.CommodityMap_.TechPlatform_);
	printf("Map CTP Exchange:%s\n", args.CommodityMap_.TechPlatform_Exchange_);
	printf("Map CTP CommodityType:%s\n", args.CommodityMap_.TechPlatform_CommodityType_);
	printf("Map CTP Commodity:%s\n", args.CommodityMap_.TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[0].TechPlatform_);
	printf("Map CTP Relate[0] Exchange:%s\n", args.RelateCommodityMap_[0].TechPlatform_Exchange_);
	printf("Map CTP Relate[0] CommodityType:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityType_);
	printf("Map CTP Relate[0] Commodity:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[1].TechPlatform_);
	printf("Map CTP Relate[1] Exchange:%s\n", args.RelateCommodityMap_[1].TechPlatform_Exchange_);
	printf("Map CTP Relate[1] CommodityType:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityType_);
	printf("Map CTP Relate[1] Commodity:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CTPContractCode:%s\n", result.CommonContract_.TechPlatform_ContractCode_);
	printf("OtherCommonContractCount:%d\n\n\n", result.OtherCommonContractCount_);
}

void testSledSpreadToCtpContract()
{
	SledContractToTechPlatformArgs args;
	SledContractToTechPlatformResult result;

	// 测试1 -- 郑商所跨期
	memset(&args, 0, sizeof(SledContractToTechPlatformArgs));
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	args.TechPlatform_ = TechPlatform_CTP;

	memcpy(&args.SledContract_.SledBaseContract_.ExchangeMic_, "XZCE", strlen("XZCE"));
	args.SledContract_.SledBaseContract_.SledCommodityType_ = SledCommodityType_SPREAD_MONTH;
	memcpy(&args.SledContract_.SledBaseContract_.SledCommodityCode_, "SF", strlen("SF"));
	memcpy(&args.SledContract_.SledBaseContract_.SledContractCode_, "1801/1805", strlen("1801/1805"));

	memcpy(&args.SledContract_.RelateSledContract_[0].ExchangeMic_, "XZCE", strlen("XZCE"));
	args.SledContract_.RelateSledContract_[0].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[0].SledCommodityCode_, "SF", strlen("SF"));
	memcpy(&args.SledContract_.RelateSledContract_[0].SledContractCode_, "1801", strlen("1801"));

	memcpy(&args.SledContract_.RelateSledContract_[1].ExchangeMic_, "XZCE", strlen("XZCE"));
	args.SledContract_.RelateSledContract_[1].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[1].SledCommodityCode_, "SF", strlen("SF"));
	memcpy(&args.SledContract_.RelateSledContract_[1].SledContractCode_, "1805", strlen("1805"));

	//商品映射Map
	args.CommodityMap_.TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.CommodityMap_.TechPlatform_Exchange_, "CZCE", strlen("CZCE"));
	args.CommodityMap_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Combination;
	memcpy(&args.CommodityMap_.TechPlatform_CommodityCode_, "SPD  SF&SF", strlen("SPD  SF&SF"));

	args.RelateCommodityMap_[0].TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_Exchange_, "CZCE", strlen("CZCE"));
	args.RelateCommodityMap_[0].TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_CommodityCode_, "SF", strlen("SF"));

	args.RelateCommodityMap_[1].TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_Exchange_, "CZCE", strlen("CZCE"));
	args.RelateCommodityMap_[1].TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_CommodityCode_, "SF", strlen("SF"));

	args.RelateCommodityMapCount_ = 2;

	result = SledToPlatformContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("Sled Exchange:%s\n", args.SledContract_.SledBaseContract_.ExchangeMic_);
	printf("Sled CommodityType:%d\n", args.SledContract_.SledBaseContract_.SledCommodityType_);
	printf("Sled Commodity:%s\n", args.SledContract_.SledBaseContract_.SledCommodityCode_);
	printf("Sled ContractCode:%s\n\n", args.SledContract_.SledBaseContract_.SledContractCode_);

	printf("Relate[0] Exchange:%s\n", args.SledContract_.RelateSledContract_[0].ExchangeMic_);
	printf("Relate[0] CommodityType:%d\n", args.SledContract_.RelateSledContract_[0].SledCommodityType_);
	printf("Relate[0] Commodity:%s\n", args.SledContract_.RelateSledContract_[0].SledCommodityCode_);
	printf("Relate[0] ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[0].SledContractCode_);

	printf("Relate[1] Exchange:%s\n", args.SledContract_.RelateSledContract_[1].ExchangeMic_);
	printf("Relate[1] CommodityType:%d\n", args.SledContract_.RelateSledContract_[1].SledCommodityType_);
	printf("Relate[1] Commodity:%s\n", args.SledContract_.RelateSledContract_[1].SledCommodityCode_);
	printf("Relate[1] ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[1].SledContractCode_);

	printf("Map Tech Platform:%d\n", args.CommodityMap_.TechPlatform_);
	printf("Map CTP Exchange:%s\n", args.CommodityMap_.TechPlatform_Exchange_);
	printf("Map CTP CommodityType:%s\n", args.CommodityMap_.TechPlatform_CommodityType_);
	printf("Map CTP Commodity:%s\n", args.CommodityMap_.TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[0].TechPlatform_);
	printf("Map CTP Relate[0] Exchange:%s\n", args.RelateCommodityMap_[0].TechPlatform_Exchange_);
	printf("Map CTP Relate[0] CommodityType:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityType_);
	printf("Map CTP Relate[0] Commodity:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[1].TechPlatform_);
	printf("Map CTP Relate[1] Exchange:%s\n", args.RelateCommodityMap_[1].TechPlatform_Exchange_);
	printf("Map CTP Relate[1] CommodityType:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityType_);
	printf("Map CTP Relate[1] Commodity:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CTPContractCode:%s\n", result.CommonContract_.TechPlatform_ContractCode_);
	printf("OtherCommonContractCount:%d\n\n\n", result.OtherCommonContractCount_);

	// 测试2 -- 郑商所跨品种
	memset(&args, 0, sizeof(SledContractToTechPlatformArgs));
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	args.TechPlatform_ = TechPlatform_CTP;

	memcpy(&args.SledContract_.SledBaseContract_.ExchangeMic_, "XZCE", strlen("XZCE"));
	args.SledContract_.SledBaseContract_.SledCommodityType_ = SledCommodityType_SPREAD_COMMODITY;
	memcpy(&args.SledContract_.SledBaseContract_.SledCommodityCode_, "SF&SM", strlen("SF&SM"));
	memcpy(&args.SledContract_.SledBaseContract_.SledContractCode_, "1801/1801", strlen("1801/1801"));

	memcpy(&args.SledContract_.RelateSledContract_[0].ExchangeMic_, "XZCE", strlen("XZCE"));
	args.SledContract_.RelateSledContract_[0].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[0].SledCommodityCode_, "SF", strlen("SF"));
	memcpy(&args.SledContract_.RelateSledContract_[0].SledContractCode_, "1801", strlen("1801"));

	memcpy(&args.SledContract_.RelateSledContract_[1].ExchangeMic_, "XZCE", strlen("XZCE"));
	args.SledContract_.RelateSledContract_[1].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[1].SledCommodityCode_, "SM", strlen("SM"));
	memcpy(&args.SledContract_.RelateSledContract_[1].SledContractCode_, "1801", strlen("1801"));

	//商品映射Map
	args.CommodityMap_.TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.CommodityMap_.TechPlatform_Exchange_, "CZCE", strlen("CZCE"));
	args.CommodityMap_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Combination;
	memcpy(&args.CommodityMap_.TechPlatform_CommodityCode_, "IPS SF&SM", strlen("IPS SF&SM"));

	args.RelateCommodityMap_[0].TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_Exchange_, "CZCE", strlen("CZCE"));
	args.RelateCommodityMap_[0].TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_CommodityCode_, "SF", strlen("SF"));

	args.RelateCommodityMap_[1].TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_Exchange_, "CZCE", strlen("CZCE"));
	args.RelateCommodityMap_[1].TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_CommodityCode_, "SM", strlen("SM"));

	args.RelateCommodityMapCount_ = 2;

	result = SledToPlatformContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("Sled Exchange:%s\n", args.SledContract_.SledBaseContract_.ExchangeMic_);
	printf("Sled CommodityType:%d\n", args.SledContract_.SledBaseContract_.SledCommodityType_);
	printf("SledCommodity:%s\n", args.SledContract_.SledBaseContract_.SledCommodityCode_);
	printf("SledContractCode:%s\n\n", args.SledContract_.SledBaseContract_.SledContractCode_);

	printf("Relate[0] Exchange:%s\n", args.SledContract_.RelateSledContract_[0].ExchangeMic_);
	printf("Relate[0] CommodityType:%d\n", args.SledContract_.RelateSledContract_[0].SledCommodityType_);
	printf("Relate[0] Commodity:%s\n", args.SledContract_.RelateSledContract_[0].SledCommodityCode_);
	printf("Relate[0] ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[0].SledContractCode_);

	printf("Relate[1] Exchange:%s\n", args.SledContract_.RelateSledContract_[1].ExchangeMic_);
	printf("Relate[1] CommodityType:%d\n", args.SledContract_.RelateSledContract_[1].SledCommodityType_);
	printf("Relate[1] Commodity:%s\n", args.SledContract_.RelateSledContract_[1].SledCommodityCode_);
	printf("Relate[1] ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[1].SledContractCode_);

	printf("Map Tech Platform:%d\n", args.CommodityMap_.TechPlatform_);
	printf("Map CTP Exchange:%s\n", args.CommodityMap_.TechPlatform_Exchange_);
	printf("Map CTP CommodityType:%s\n", args.CommodityMap_.TechPlatform_CommodityType_);
	printf("Map CTP Commodity:%s\n", args.CommodityMap_.TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[0].TechPlatform_);
	printf("Map CTP Relate[0] Exchange:%s\n", args.RelateCommodityMap_[0].TechPlatform_Exchange_);
	printf("Map CTP Relate[0] CommodityType:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityType_);
	printf("Map CTP Relate[0] Commodity:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[1].TechPlatform_);
	printf("Map CTP Relate[1] Exchange:%s\n", args.RelateCommodityMap_[1].TechPlatform_Exchange_);
	printf("Map CTP Relate[1] CommodityType:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityType_);
	printf("Map CTP Relate[1] Commodity:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CTPContractCode:%s\n", result.CommonContract_.TechPlatform_ContractCode_);
	printf("OtherCommonContractCount:%d\n\n\n", result.OtherCommonContractCount_);

	// 测试3 -- 大商所跨期
	memset(&args, 0, sizeof(SledContractToTechPlatformArgs));
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	args.TechPlatform_ = TechPlatform_CTP;

	memcpy(&args.SledContract_.SledBaseContract_.ExchangeMic_, "XDCE", strlen("XDCE"));
	args.SledContract_.SledBaseContract_.SledCommodityType_ = SledCommodityType_SPREAD_MONTH;
	memcpy(&args.SledContract_.SledBaseContract_.SledCommodityCode_, "y", strlen("y"));
	memcpy(&args.SledContract_.SledBaseContract_.SledContractCode_, "1805/1809", strlen("1805/1809"));

	memcpy(&args.SledContract_.RelateSledContract_[0].ExchangeMic_, "XDCE", strlen("XDCE"));
	args.SledContract_.RelateSledContract_[0].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[0].SledCommodityCode_, "y", strlen("y"));
	memcpy(&args.SledContract_.RelateSledContract_[0].SledContractCode_, "1805", strlen("1805"));

	memcpy(&args.SledContract_.RelateSledContract_[1].ExchangeMic_, "XDCE", strlen("XDCE"));
	args.SledContract_.RelateSledContract_[1].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[1].SledCommodityCode_, "y", strlen("y"));
	memcpy(&args.SledContract_.RelateSledContract_[1].SledContractCode_, "1809", strlen("1809"));

	//商品映射Map
	args.CommodityMap_.TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.CommodityMap_.TechPlatform_Exchange_, "DCE", strlen("DCE"));
	args.CommodityMap_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Combination;
	memcpy(&args.CommodityMap_.TechPlatform_CommodityCode_, "SP y&y", strlen("SP y&y"));

	args.RelateCommodityMap_[0].TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_Exchange_, "DCE", strlen("DCE"));
	args.RelateCommodityMap_[0].TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_CommodityCode_, "y", strlen("y"));

	args.RelateCommodityMap_[1].TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_Exchange_, "DCE", strlen("DCE"));
	args.RelateCommodityMap_[1].TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_CommodityCode_, "y", strlen("y"));

	args.RelateCommodityMapCount_ = 2;

	result = SledToPlatformContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("Sled Exchange:%s\n", args.SledContract_.SledBaseContract_.ExchangeMic_);
	printf("Sled CommodityType:%d\n", args.SledContract_.SledBaseContract_.SledCommodityType_);
	printf("Sled Commodity:%s\n", args.SledContract_.SledBaseContract_.SledCommodityCode_);
	printf("Sled ContractCode:%s\n\n", args.SledContract_.SledBaseContract_.SledContractCode_);

	printf("Relate[0] Exchange:%s\n", args.SledContract_.RelateSledContract_[0].ExchangeMic_);
	printf("Relate[0] CommodityType:%d\n", args.SledContract_.RelateSledContract_[0].SledCommodityType_);
	printf("Relate[0] Commodity:%s\n", args.SledContract_.RelateSledContract_[0].SledCommodityCode_);
	printf("Relate[0] ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[0].SledContractCode_);

	printf("Relate[1] Exchange:%s\n", args.SledContract_.RelateSledContract_[1].ExchangeMic_);
	printf("Relate[1] CommodityType:%d\n", args.SledContract_.RelateSledContract_[1].SledCommodityType_);
	printf("Relate[1] Commodity:%s\n", args.SledContract_.RelateSledContract_[1].SledCommodityCode_);
	printf("Relate[1] ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[1].SledContractCode_);

	printf("Map Tech Platform:%d\n", args.CommodityMap_.TechPlatform_);
	printf("Map CTP Exchange:%s\n", args.CommodityMap_.TechPlatform_Exchange_);
	printf("Map CTP CommodityType:%s\n", args.CommodityMap_.TechPlatform_CommodityType_);
	printf("Map CTP Commodity:%s\n", args.CommodityMap_.TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[0].TechPlatform_);
	printf("Map CTP Relate[0] Exchange:%s\n", args.RelateCommodityMap_[0].TechPlatform_Exchange_);
	printf("Map CTP Relate[0] CommodityType:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityType_);
	printf("Map CTP Relate[0] Commodity:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[1].TechPlatform_);
	printf("Map CTP Relate[1] Exchange:%s\n", args.RelateCommodityMap_[1].TechPlatform_Exchange_);
	printf("Map CTP Relate[1] CommodityType:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityType_);
	printf("Map CTP Relate[1] Commodity:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CTPContractCode:%s\n", result.CommonContract_.TechPlatform_ContractCode_);
	printf("OtherCommonContractCount:%d\n\n\n", result.OtherCommonContractCount_);

	// 测试4 -- 大商所跨品种
	memset(&args, 0, sizeof(SledContractToTechPlatformArgs));
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	args.TechPlatform_ = TechPlatform_CTP;

	memcpy(&args.SledContract_.SledBaseContract_.ExchangeMic_, "XDCE", strlen("XDCE"));
	args.SledContract_.SledBaseContract_.SledCommodityType_ = SledCommodityType_SPREAD_COMMODITY;
	memcpy(&args.SledContract_.SledBaseContract_.SledCommodityCode_, "j&jm", strlen("j&jm"));
	memcpy(&args.SledContract_.SledBaseContract_.SledContractCode_, "1809/1809", strlen("1809/1809"));

	memcpy(&args.SledContract_.RelateSledContract_[0].ExchangeMic_, "XDCE", strlen("XDCE"));
	args.SledContract_.RelateSledContract_[0].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[0].SledCommodityCode_, "j", strlen("j"));
	memcpy(&args.SledContract_.RelateSledContract_[0].SledContractCode_, "1809", strlen("1809"));

	memcpy(&args.SledContract_.RelateSledContract_[1].ExchangeMic_, "XDCE", strlen("XDCE"));
	args.SledContract_.RelateSledContract_[1].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[1].SledCommodityCode_, "jm", strlen("jm"));
	memcpy(&args.SledContract_.RelateSledContract_[1].SledContractCode_, "1809", strlen("1809"));

	//商品映射Map
	args.CommodityMap_.TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.CommodityMap_.TechPlatform_Exchange_, "DCE", strlen("DCE"));
	args.CommodityMap_.TechPlatform_CommodityType_[0] = Ctp_CommodityType_Combination;
	memcpy(&args.CommodityMap_.TechPlatform_CommodityCode_, "SPC j&jm", strlen("SPC j&jm"));

	args.RelateCommodityMap_[0].TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_Exchange_, "DCE", strlen("DCE"));
	args.RelateCommodityMap_[0].TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_CommodityCode_, "j", strlen("j"));

	args.RelateCommodityMap_[1].TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_Exchange_, "DCE", strlen("DCE"));
	args.RelateCommodityMap_[1].TechPlatform_CommodityType_[0] = Ctp_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_CommodityCode_, "jm", strlen("jm"));

	args.RelateCommodityMapCount_ = 2;

	result = SledToPlatformContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("Sled Exchange:%s\n", args.SledContract_.SledBaseContract_.ExchangeMic_);
	printf("Sled CommodityType:%d\n", args.SledContract_.SledBaseContract_.SledCommodityType_);
	printf("Sled Commodity:%s\n", args.SledContract_.SledBaseContract_.SledCommodityCode_);
	printf("Sled ContractCode:%s\n\n", args.SledContract_.SledBaseContract_.SledContractCode_);

	printf("Relate[0] Exchange:%s\n", args.SledContract_.RelateSledContract_[0].ExchangeMic_);
	printf("Relate[0] CommodityType:%d\n", args.SledContract_.RelateSledContract_[0].SledCommodityType_);
	printf("Relate[0] Commodity:%s\n", args.SledContract_.RelateSledContract_[0].SledCommodityCode_);
	printf("Relate[0] ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[0].SledContractCode_);

	printf("Relate[1] Exchange:%s\n", args.SledContract_.RelateSledContract_[1].ExchangeMic_);
	printf("Relate[1] CommodityType:%d\n", args.SledContract_.RelateSledContract_[1].SledCommodityType_);
	printf("Relate[1] Commodity:%s\n", args.SledContract_.RelateSledContract_[1].SledCommodityCode_);
	printf("Relate[1] ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[1].SledContractCode_);

	printf("Map Tech Platform:%d\n", args.CommodityMap_.TechPlatform_);
	printf("Map CTP Exchange:%s\n", args.CommodityMap_.TechPlatform_Exchange_);
	printf("Map CTP CommodityType:%s\n", args.CommodityMap_.TechPlatform_CommodityType_);
	printf("Map CTP Commodity:%s\n", args.CommodityMap_.TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[0].TechPlatform_);
	printf("Map CTP Relate[0] Exchange:%s\n", args.RelateCommodityMap_[0].TechPlatform_Exchange_);
	printf("Map CTP Relate[0] CommodityType:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityType_);
	printf("Map CTP Relate[0] Commodity:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[1].TechPlatform_);
	printf("Map CTP Relate[1] Exchange:%s\n", args.RelateCommodityMap_[1].TechPlatform_Exchange_);
	printf("Map CTP Relate[1] CommodityType:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityType_);
	printf("Map CTP Relate[1] Commodity:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("CTPContractCode:%s\n", result.CommonContract_.TechPlatform_ContractCode_);
	printf("OtherCommonContractCount:%d\n\n\n", result.OtherCommonContractCount_);
}

void testEsunnyV9FuturesToSledContract()
{
	TechPlatformContractToSledArgs args;
	TechPlatformContractToSledResult result;

	// 测试1 -- 外盘期货
	memset(&args, 0, sizeof(TechPlatformContractToSledArgs));
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	memcpy(&args.CommonContract_.TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.CommonContract_.TechPlatform_CommodityType_[0] = EsunnyV9_CommodityType_Futures;
	memcpy(&args.CommonContract_.TechPlatform_CommodityCode_, "GC", strlen("GC"));
	memcpy(&args.CommonContract_.TechPlatform_ContractCode_, "1804", strlen("1804"));

	args.TechPlatform_ = TechPlatform_ESUNNY;

	result = PlatformToSledContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("EsunnyV9 Exchange:%s\n", args.CommonContract_.TechPlatform_Exchange_);
	printf("EsunnyV9 CommodityType:%s\n", args.CommonContract_.TechPlatform_CommodityType_);
	printf("EsunnyV9 Commodity:%s\n", args.CommonContract_.TechPlatform_CommodityCode_);
	printf("EsunnyV9 ContractCode:%s\n\n", args.CommonContract_.TechPlatform_ContractCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("EsunnyV9 Exchange:%s\n", result.MixContract_.TechPlatform_Exchange_);
	printf("EsunnyV9 CommodityClass:%s\n", result.MixContract_.TechPlatform_CommodityType_);
	printf("EsunnyV9 CommodityCode:%s\n", result.MixContract_.TechPlatform_CommodityCode_);
	printf("SledContractCode:%s\n", result.MixContract_.SledContractCode_);

	printf("Relate[0] EsunnyV9 Exchange:%s\n", result.RelateMixContract_[0].TechPlatform_Exchange_);
	printf("Relate[0] EsunnyV9 CommodityClass:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityType_);
	printf("Relate[0] EsunnyV9 CommodityCode:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityCode_);
	printf("Relate[0] SledContractCode:%s\n", result.RelateMixContract_[0].SledContractCode_);

	printf("Relate[1] EsunnyV9 Exchange:%s\n", result.RelateMixContract_[1].TechPlatform_Exchange_);
	printf("Relate[1] EsunnyV9 CommodityClass:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityType_);
	printf("Relate[1] EsunnyV9 CommodityCode:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityCode_);
	printf("Relate[1] SledContractCode:%s\n\n\n", result.RelateMixContract_[1].SledContractCode_);
}

void testEsunnyV9SpreadToSledContract()
{
	TechPlatformContractToSledArgs args;
	TechPlatformContractToSledResult result;

	// 测试1 -- 跨期
	memset(&args, 0, sizeof(TechPlatformContractToSledArgs));
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	memcpy(&args.CommonContract_.TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.CommonContract_.TechPlatform_CommodityType_[0] = EsunnyV9_CommodityType_Spread_Month;
	memcpy(&args.CommonContract_.TechPlatform_CommodityCode_, "GC", strlen("GC"));
	memcpy(&args.CommonContract_.TechPlatform_ContractCode_, "1804", strlen("1804"));
	memcpy(&args.OtherCommonContract_[0].TechPlatform_ContractCode_, "1806", strlen("1806"));
	args.OtherCommonContractCount_ = 1;

	args.TechPlatform_ = TechPlatform_ESUNNY;

	result = PlatformToSledContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("EsunnyV9 Exchange:%s\n", args.CommonContract_.TechPlatform_Exchange_);
	printf("EsunnyV9 CommodityType:%s\n", args.CommonContract_.TechPlatform_CommodityType_);
	printf("EsunnyV9 Commodity:%s\n", args.CommonContract_.TechPlatform_CommodityCode_);
	printf("EsunnyV9 ContractCode:%s\n", args.CommonContract_.TechPlatform_ContractCode_);
	printf("EsunnyV9 Other ContractCode[0]:%s\n\n", args.OtherCommonContract_[0].TechPlatform_ContractCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("EsunnyV9 Exchange:%s\n", result.MixContract_.TechPlatform_Exchange_);
	printf("EsunnyV9 CommodityClass:%s\n", result.MixContract_.TechPlatform_CommodityType_);
	printf("EsunnyV9 CommodityCode:%s\n", result.MixContract_.TechPlatform_CommodityCode_);
	printf("SledContractCode:%s\n", result.MixContract_.SledContractCode_);

	printf("Relate[0] EsunnyV9 Exchange:%s\n", result.RelateMixContract_[0].TechPlatform_Exchange_);
	printf("Relate[0] EsunnyV9 CommodityClass:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityType_);
	printf("Relate[0] EsunnyV9 CommodityCode:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityCode_);
	printf("Relate[0] SledContractCode:%s\n", result.RelateMixContract_[0].SledContractCode_);

	printf("Relate[1] EsunnyV9 Exchange:%s\n", result.RelateMixContract_[1].TechPlatform_Exchange_);
	printf("Relate[1] EsunnyV9 CommodityClass:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityType_);
	printf("Relate[1] EsunnyV9 CommodityCode:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityCode_);
	printf("Relate[1] SledContractCode:%s\n\n\n", result.RelateMixContract_[1].SledContractCode_);
}

void testEsunnyV3FuturesToSledContract()
{
	TechPlatformContractToSledArgs args;
	TechPlatformContractToSledResult result;

	// 测试1 -- 外盘期货
	memset(&args, 0, sizeof(TechPlatformContractToSledArgs));
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	memcpy(&args.CommonContract_.TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.CommonContract_.TechPlatform_CommodityType_[0] = EsunnyV3_CommodityType_Futures;
	memcpy(&args.CommonContract_.TechPlatform_CommodityCode_, "SI", strlen("SI"));
	memcpy(&args.CommonContract_.TechPlatform_ContractCode_, "1806", strlen("1806"));

	args.TechPlatform_ = TechPlatform_ESUNNY_3;

	result = PlatformToSledContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("EsunnyV3 Exchange:%s\n", args.CommonContract_.TechPlatform_Exchange_);
	printf("EsunnyV3 CommodityType:%s\n", args.CommonContract_.TechPlatform_CommodityType_);
	printf("EsunnyV3 Commodity:%s\n", args.CommonContract_.TechPlatform_CommodityCode_);
	printf("EsunnyV3 ContractCode:%s\n\n", args.CommonContract_.TechPlatform_ContractCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("EsunnyV3 Exchange:%s\n", result.MixContract_.TechPlatform_Exchange_);
	printf("EsunnyV3 CommodityClass:%s\n", result.MixContract_.TechPlatform_CommodityType_);
	printf("EsunnyV3 CommodityCode:%s\n", result.MixContract_.TechPlatform_CommodityCode_);
	printf("SledContractCode:%s\n", result.MixContract_.SledContractCode_);

	printf("Relate[0] EsunnyV3 Exchange:%s\n", result.RelateMixContract_[0].TechPlatform_Exchange_);
	printf("Relate[0] EsunnyV3 CommodityClass:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityType_);
	printf("Relate[0] EsunnyV3 CommodityCode:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityCode_);
	printf("Relate[0] SledContractCode:%s\n", result.RelateMixContract_[0].SledContractCode_);

	printf("Relate[1] EsunnyV3 Exchange:%s\n", result.RelateMixContract_[1].TechPlatform_Exchange_);
	printf("Relate[1] EsunnyV3 CommodityClass:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityType_);
	printf("Relate[1] EsunnyV3 CommodityCode:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityCode_);
	printf("Relate[1] SledContractCode:%s\n\n\n", result.RelateMixContract_[1].SledContractCode_);
}

void testEsunnyV3SpreadToSledContract()
{
	TechPlatformContractToSledArgs args;
	TechPlatformContractToSledResult result;

	// 测试1 -- 跨期
	memset(&args, 0, sizeof(TechPlatformContractToSledArgs));
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));

	memcpy(&args.CommonContract_.TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.CommonContract_.TechPlatform_CommodityType_[0] = EsunnyV3_CommodityType_Spread_Month;
	memcpy(&args.CommonContract_.TechPlatform_CommodityCode_, "SI", strlen("SI"));
	memcpy(&args.CommonContract_.TechPlatform_ContractCode_, "1804/1806", strlen("1804/1806"));
	
	args.OtherCommonContractCount_ = 0;

	args.TechPlatform_ = TechPlatform_ESUNNY_3;

	result = PlatformToSledContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("EsunnyV3 Exchange:%s\n", args.CommonContract_.TechPlatform_Exchange_);
	printf("EsunnyV3 CommodityType:%s\n", args.CommonContract_.TechPlatform_CommodityType_);
	printf("EsunnyV3 Commodity:%s\n", args.CommonContract_.TechPlatform_CommodityCode_);
	printf("EsunnyV3 ContractCode:%s\n", args.CommonContract_.TechPlatform_ContractCode_);
	printf("EsunnyV3 Other ContractCode[0]:%s\n\n", args.OtherCommonContract_[0].TechPlatform_ContractCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("EsunnyV3 Exchange:%s\n", result.MixContract_.TechPlatform_Exchange_);
	printf("EsunnyV3 CommodityClass:%s\n", result.MixContract_.TechPlatform_CommodityType_);
	printf("EsunnyV3 CommodityCode:%s\n", result.MixContract_.TechPlatform_CommodityCode_);
	printf("SledContractCode:%s\n", result.MixContract_.SledContractCode_);

	printf("Relate[0] EsunnyV3 Exchange:%s\n", result.RelateMixContract_[0].TechPlatform_Exchange_);
	printf("Relate[0] EsunnyV3 CommodityClass:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityType_);
	printf("Relate[0] EsunnyV3 CommodityCode:%s\n", result.RelateMixContract_[0].TechPlatform_CommodityCode_);
	printf("Relate[0] SledContractCode:%s\n", result.RelateMixContract_[0].SledContractCode_);

	printf("Relate[1] EsunnyV3 Exchange:%s\n", result.RelateMixContract_[1].TechPlatform_Exchange_);
	printf("Relate[1] EsunnyV3 CommodityClass:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityType_);
	printf("Relate[1] EsunnyV3 CommodityCode:%s\n", result.RelateMixContract_[1].TechPlatform_CommodityCode_);
	printf("Relate[1] SledContractCode:%s\n\n\n", result.RelateMixContract_[1].SledContractCode_);
}

void testSledFuturesToEsunnyV9Contract()
{
	SledContractToTechPlatformArgs args;
	SledContractToTechPlatformResult result;

	// 测试1
	memset(&args, 0, sizeof(SledContractToTechPlatformArgs));
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	args.TechPlatform_ = TechPlatform_ESUNNY;

	memcpy(&args.SledContract_.SledBaseContract_.ExchangeMic_, "XCEC", strlen("XCEC"));
	args.SledContract_.SledBaseContract_.SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.SledBaseContract_.SledCommodityCode_, "GC", strlen("GC"));
	memcpy(&args.SledContract_.SledBaseContract_.SledContractCode_, "2001", strlen("2001"));

	args.SledContract_.RelateSledContractCount_ = 0;	

	//商品映射Map
	args.CommodityMap_.TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.CommodityMap_.TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.CommodityMap_.TechPlatform_CommodityType_[0] = EsunnyV9_CommodityType_Futures;
	memcpy(&args.CommodityMap_.TechPlatform_CommodityCode_, "GC", strlen("GC"));

	args.RelateCommodityMapCount_ = 0;

	result = SledToPlatformContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("Sled Exchange:%s\n", args.SledContract_.SledBaseContract_.ExchangeMic_);
	printf("Sled CommodityType:%d\n", args.SledContract_.SledBaseContract_.SledCommodityType_);
	printf("SledCommodity:%s\n", args.SledContract_.SledBaseContract_.SledCommodityCode_);
	printf("SledContractCode:%s\n\n", args.SledContract_.SledBaseContract_.SledContractCode_);

	printf("Relate[0] Exchange:%s\n", args.SledContract_.RelateSledContract_[0].ExchangeMic_);
	printf("Relate[0] CommodityType:%d\n", args.SledContract_.RelateSledContract_[0].SledCommodityType_);
	printf("Relate[0]Commodity:%s\n", args.SledContract_.RelateSledContract_[0].SledCommodityCode_);
	printf("Relate[0]ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[0].SledContractCode_);

	printf("Relate[1] Exchange:%s\n", args.SledContract_.RelateSledContract_[1].ExchangeMic_);
	printf("Relate[1] CommodityType:%d\n", args.SledContract_.RelateSledContract_[1].SledCommodityType_);
	printf("Relate[1]Commodity:%s\n", args.SledContract_.RelateSledContract_[1].SledCommodityCode_);
	printf("Relate[1]ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[1].SledContractCode_);

	printf("Map Tech Platform:%d\n", args.CommodityMap_.TechPlatform_);
	printf("Map EsunnyV9 Exchange:%s\n", args.CommodityMap_.TechPlatform_Exchange_);
	printf("Map EsunnyV9 CommodityType:%s\n", args.CommodityMap_.TechPlatform_CommodityType_);
	printf("Map EsunnyV9 Commodity:%s\n", args.CommodityMap_.TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[0].TechPlatform_);
	printf("Map EsunnyV9 Relate[0] Exchange:%s\n", args.RelateCommodityMap_[0].TechPlatform_Exchange_);
	printf("Map EsunnyV9 Relate[0] CommodityType:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityType_);
	printf("Map EsunnyV9 Relate[0]Commodity:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[1].TechPlatform_);
	printf("Map EsunnyV9 Relate[1] Exchange:%s\n", args.RelateCommodityMap_[1].TechPlatform_Exchange_);
	printf("Map EsunnyV9 Relate[1] CommodityType:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityType_);
	printf("Map EsunnyV9 Relate[1]Commodity:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("EsunnyV9 ContractCode:%s\n", result.CommonContract_.TechPlatform_ContractCode_);
	printf("EsunnyV9 ContractCode2:%s\n\n\n", result.OtherCommonContract_[0].TechPlatform_ContractCode_);
}

void testSledSpreadToEsunnyV9Contract()
{
	SledContractToTechPlatformArgs args;
	SledContractToTechPlatformResult result;

	// 测试1
	memset(&args, 0, sizeof(SledContractToTechPlatformArgs));
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	args.TechPlatform_ = TechPlatform_ESUNNY;

	memcpy(&args.SledContract_.SledBaseContract_.ExchangeMic_, "XCEC", strlen("XCEC"));
	args.SledContract_.SledBaseContract_.SledCommodityType_ = SledCommodityType_SPREAD_MONTH;
	memcpy(&args.SledContract_.SledBaseContract_.SledCommodityCode_, "GC", strlen("GC"));
	memcpy(&args.SledContract_.SledBaseContract_.SledContractCode_, "1801/1805", strlen("1801/1805"));

	memcpy(&args.SledContract_.RelateSledContract_[0].ExchangeMic_, "XCEC", strlen("XCEC"));
	args.SledContract_.RelateSledContract_[0].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[0].SledCommodityCode_, "GC", strlen("GC"));
	memcpy(&args.SledContract_.RelateSledContract_[0].SledContractCode_, "1801", strlen("1801"));

	memcpy(&args.SledContract_.RelateSledContract_[1].ExchangeMic_, "XCEC", strlen("XCEC"));
	args.SledContract_.RelateSledContract_[1].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[1].SledCommodityCode_, "GC", strlen("GC"));
	memcpy(&args.SledContract_.RelateSledContract_[1].SledContractCode_, "1805", strlen("1805"));

	//商品映射Map
	args.CommodityMap_.TechPlatform_ = TechPlatform_ESUNNY;
	memcpy(&args.CommodityMap_.TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.CommodityMap_.TechPlatform_CommodityType_[0] = EsunnyV9_CommodityType_Spread_Month;
	memcpy(&args.CommodityMap_.TechPlatform_CommodityCode_, "GC", strlen("GC"));

	args.RelateCommodityMap_[0].TechPlatform_ = TechPlatform_ESUNNY;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.RelateCommodityMap_[0].TechPlatform_CommodityType_[0] = EsunnyV9_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_CommodityCode_, "GC", strlen("GC"));

	args.RelateCommodityMap_[1].TechPlatform_ = TechPlatform_ESUNNY;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.RelateCommodityMap_[1].TechPlatform_CommodityType_[0] = EsunnyV9_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_CommodityCode_, "GC", strlen("GC"));

	args.RelateCommodityMapCount_ = 2;

	result = SledToPlatformContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("Sled Exchange:%s\n", args.SledContract_.SledBaseContract_.ExchangeMic_);
	printf("Sled CommodityType:%d\n", args.SledContract_.SledBaseContract_.SledCommodityType_);
	printf("SledCommodity:%s\n", args.SledContract_.SledBaseContract_.SledCommodityCode_);
	printf("SledContractCode:%s\n\n", args.SledContract_.SledBaseContract_.SledContractCode_);

	printf("Relate[0] Exchange:%s\n", args.SledContract_.RelateSledContract_[0].ExchangeMic_);
	printf("Relate[0] CommodityType:%d\n", args.SledContract_.RelateSledContract_[0].SledCommodityType_);
	printf("Relate[0]Commodity:%s\n", args.SledContract_.RelateSledContract_[0].SledCommodityCode_);
	printf("Relate[0]ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[0].SledContractCode_);

	printf("Relate[1] Exchange:%s\n", args.SledContract_.RelateSledContract_[1].ExchangeMic_);
	printf("Relate[1] CommodityType:%d\n", args.SledContract_.RelateSledContract_[1].SledCommodityType_);
	printf("Relate[1]Commodity:%s\n", args.SledContract_.RelateSledContract_[1].SledCommodityCode_);
	printf("Relate[1]ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[1].SledContractCode_);

	printf("Map Tech Platform:%d\n", args.CommodityMap_.TechPlatform_);
	printf("Map EsunnyV9 Exchange:%s\n", args.CommodityMap_.TechPlatform_Exchange_);
	printf("Map EsunnyV9 CommodityType:%s\n", args.CommodityMap_.TechPlatform_CommodityType_);
	printf("Map EsunnyV9 Commodity:%s\n", args.CommodityMap_.TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[0].TechPlatform_);
	printf("Map EsunnyV9 Relate[0] Exchange:%s\n", args.RelateCommodityMap_[0].TechPlatform_Exchange_);
	printf("Map EsunnyV9 Relate[0] CommodityType:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityType_);
	printf("Map EsunnyV9 Relate[0]Commodity:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[1].TechPlatform_);
	printf("Map EsunnyV9 Relate[1] Exchange:%s\n", args.RelateCommodityMap_[1].TechPlatform_Exchange_);
	printf("Map EsunnyV9 Relate[1] CommodityType:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityType_);
	printf("Map EsunnyV9 Relate[1]Commodity:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("EsunnyV9 ContractCode:%s\n", result.CommonContract_.TechPlatform_ContractCode_);
	printf("EsunnyV9 ContractCode2:%s\n\n\n", result.OtherCommonContract_[0].TechPlatform_ContractCode_);
}

void testSledFuturesToEsunnyV3Contract()
{
	SledContractToTechPlatformArgs args;
	SledContractToTechPlatformResult result;

	// 测试1
	memset(&args, 0, sizeof(SledContractToTechPlatformArgs));
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	args.TechPlatform_ = TechPlatform_ESUNNY_3;

	memcpy(&args.SledContract_.SledBaseContract_.ExchangeMic_, "XCEC", strlen("XCEC"));
	args.SledContract_.SledBaseContract_.SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.SledBaseContract_.SledCommodityCode_, "GC", strlen("GC"));
	memcpy(&args.SledContract_.SledBaseContract_.SledContractCode_, "2001", strlen("2001"));

	args.SledContract_.RelateSledContractCount_ = 0;

	//商品映射Map
	args.CommodityMap_.TechPlatform_ = TechPlatform_CTP;
	memcpy(&args.CommodityMap_.TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.CommodityMap_.TechPlatform_CommodityType_[0] = EsunnyV3_CommodityType_Futures;
	memcpy(&args.CommodityMap_.TechPlatform_CommodityCode_, "GC", strlen("GC"));

	args.RelateCommodityMapCount_ = 0;

	result = SledToPlatformContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("Sled Exchange:%s\n", args.SledContract_.SledBaseContract_.ExchangeMic_);
	printf("Sled CommodityType:%d\n", args.SledContract_.SledBaseContract_.SledCommodityType_);
	printf("SledCommodity:%s\n", args.SledContract_.SledBaseContract_.SledCommodityCode_);
	printf("SledContractCode:%s\n\n", args.SledContract_.SledBaseContract_.SledContractCode_);

	printf("Relate[0] Exchange:%s\n", args.SledContract_.RelateSledContract_[0].ExchangeMic_);
	printf("Relate[0] CommodityType:%d\n", args.SledContract_.RelateSledContract_[0].SledCommodityType_);
	printf("Relate[0]Commodity:%s\n", args.SledContract_.RelateSledContract_[0].SledCommodityCode_);
	printf("Relate[0]ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[0].SledContractCode_);

	printf("Relate[1] Exchange:%s\n", args.SledContract_.RelateSledContract_[1].ExchangeMic_);
	printf("Relate[1] CommodityType:%d\n", args.SledContract_.RelateSledContract_[1].SledCommodityType_);
	printf("Relate[1]Commodity:%s\n", args.SledContract_.RelateSledContract_[1].SledCommodityCode_);
	printf("Relate[1]ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[1].SledContractCode_);

	printf("Map Tech Platform:%d\n", args.CommodityMap_.TechPlatform_);
	printf("Map EsunnyV3 Exchange:%s\n", args.CommodityMap_.TechPlatform_Exchange_);
	printf("Map EsunnyV3 CommodityType:%s\n", args.CommodityMap_.TechPlatform_CommodityType_);
	printf("Map EsunnyV3 Commodity:%s\n", args.CommodityMap_.TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[0].TechPlatform_);
	printf("Map EsunnyV3 Relate[0] Exchange:%s\n", args.RelateCommodityMap_[0].TechPlatform_Exchange_);
	printf("Map EsunnyV3 Relate[0] CommodityType:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityType_);
	printf("Map EsunnyV3 Relate[0]Commodity:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[1].TechPlatform_);
	printf("Map EsunnyV3 Relate[1] Exchange:%s\n", args.RelateCommodityMap_[1].TechPlatform_Exchange_);
	printf("Map EsunnyV3 Relate[1] CommodityType:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityType_);
	printf("Map EsunnyV3 Relate[1]Commodity:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("EsunnyV3 ContractCode:%s\n", result.CommonContract_.TechPlatform_ContractCode_);
}

void testSledSpreadToEsunnyV3Contract()
{
	SledContractToTechPlatformArgs args;
	SledContractToTechPlatformResult result;

	// 测试1
	memset(&args, 0, sizeof(SledContractToTechPlatformArgs));
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));

	args.TechPlatform_ = TechPlatform_ESUNNY_3;

	memcpy(&args.SledContract_.SledBaseContract_.ExchangeMic_, "XCEC", strlen("XCEC"));
	args.SledContract_.SledBaseContract_.SledCommodityType_ = SledCommodityType_SPREAD_MONTH;
	memcpy(&args.SledContract_.SledBaseContract_.SledCommodityCode_, "GC", strlen("GC"));
	memcpy(&args.SledContract_.SledBaseContract_.SledContractCode_, "1801/1805", strlen("1801/1805"));

	memcpy(&args.SledContract_.RelateSledContract_[0].ExchangeMic_, "XCEC", strlen("XCEC"));
	args.SledContract_.RelateSledContract_[0].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[0].SledCommodityCode_, "GC", strlen("GC"));
	memcpy(&args.SledContract_.RelateSledContract_[0].SledContractCode_, "1801", strlen("1801"));

	memcpy(&args.SledContract_.RelateSledContract_[1].ExchangeMic_, "XCEC", strlen("XCEC"));
	args.SledContract_.RelateSledContract_[1].SledCommodityType_ = SledCommodityType_FUTURES;
	memcpy(&args.SledContract_.RelateSledContract_[1].SledCommodityCode_, "GC", strlen("GC"));
	memcpy(&args.SledContract_.RelateSledContract_[1].SledContractCode_, "1805", strlen("1805"));

	//商品映射Map
	args.CommodityMap_.TechPlatform_ = TechPlatform_ESUNNY;
	memcpy(&args.CommodityMap_.TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.CommodityMap_.TechPlatform_CommodityType_[0] = EsunnyV3_CommodityType_Spread_Month;
	memcpy(&args.CommodityMap_.TechPlatform_CommodityCode_, "GC", strlen("GC"));

	args.RelateCommodityMap_[0].TechPlatform_ = TechPlatform_ESUNNY;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.RelateCommodityMap_[0].TechPlatform_CommodityType_[0] = EsunnyV3_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[0].TechPlatform_CommodityCode_, "GC", strlen("GC"));

	args.RelateCommodityMap_[1].TechPlatform_ = TechPlatform_ESUNNY;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_Exchange_, "COMEX", strlen("COMEX"));
	args.RelateCommodityMap_[1].TechPlatform_CommodityType_[0] = EsunnyV3_CommodityType_Futures;
	memcpy(&args.RelateCommodityMap_[1].TechPlatform_CommodityCode_, "GC", strlen("GC"));

	args.RelateCommodityMapCount_ = 2;

	result = SledToPlatformContract(args);

	printf("Input Info:\n");
	printf("Tech Platform:%d\n", args.TechPlatform_);
	printf("Sled Exchange:%s\n", args.SledContract_.SledBaseContract_.ExchangeMic_);
	printf("Sled CommodityType:%d\n", args.SledContract_.SledBaseContract_.SledCommodityType_);
	printf("SledCommodity:%s\n", args.SledContract_.SledBaseContract_.SledCommodityCode_);
	printf("SledContractCode:%s\n\n", args.SledContract_.SledBaseContract_.SledContractCode_);

	printf("Relate[0] Exchange:%s\n", args.SledContract_.RelateSledContract_[0].ExchangeMic_);
	printf("Relate[0] CommodityType:%d\n", args.SledContract_.RelateSledContract_[0].SledCommodityType_);
	printf("Relate[0]Commodity:%s\n", args.SledContract_.RelateSledContract_[0].SledCommodityCode_);
	printf("Relate[0]ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[0].SledContractCode_);

	printf("Relate[1] Exchange:%s\n", args.SledContract_.RelateSledContract_[1].ExchangeMic_);
	printf("Relate[1] CommodityType:%d\n", args.SledContract_.RelateSledContract_[1].SledCommodityType_);
	printf("Relate[1]Commodity:%s\n", args.SledContract_.RelateSledContract_[1].SledCommodityCode_);
	printf("Relate[1]ContractCode:%s\n\n", args.SledContract_.RelateSledContract_[1].SledContractCode_);

	printf("Map Tech Platform:%d\n", args.CommodityMap_.TechPlatform_);
	printf("Map EsunnyV3 Exchange:%s\n", args.CommodityMap_.TechPlatform_Exchange_);
	printf("Map EsunnyV3 CommodityType:%s\n", args.CommodityMap_.TechPlatform_CommodityType_);
	printf("Map EsunnyV3 Commodity:%s\n", args.CommodityMap_.TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[0].TechPlatform_);
	printf("Map EsunnyV3 Relate[0] Exchange:%s\n", args.RelateCommodityMap_[0].TechPlatform_Exchange_);
	printf("Map EsunnyV3 Relate[0] CommodityType:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityType_);
	printf("Map EsunnyV3 Relate[0]Commodity:%s\n", args.RelateCommodityMap_[0].TechPlatform_CommodityCode_);

	printf("Map Tech Platform:%d\n", args.RelateCommodityMap_[1].TechPlatform_);
	printf("Map EsunnyV3 Relate[1] Exchange:%s\n", args.RelateCommodityMap_[1].TechPlatform_Exchange_);
	printf("Map EsunnyV3 Relate[1] CommodityType:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityType_);
	printf("Map EsunnyV3 Relate[1]Commodity:%s\n", args.RelateCommodityMap_[1].TechPlatform_CommodityCode_);

	printf("Convert Result:\n");
	printf("Tech Platform:%d\n", result.TechPlatform_);
	printf("EsunnyV3 ContractCode:%s\n", result.CommonContract_.TechPlatform_ContractCode_);
}

void ScreenInfo()
{
	printf("\n|   1:CTP Contract Convert To Sled Contract   |");
	printf("\n|   2:Sled Contract Convert To CTP Contract   |");
}

void InputCTPToSledContract()
{

}

void InputSledToCtpContract()
{

}

void main()
{
	//期货
	//testCtpFuturesToSledContract();

	//跨期，跨品种
	//testCtpSpreadToSledContract();

	//期货
	testSledFuturesToCtpContract();
	
	//跨期，跨品种
	//testSledSpreadToCtpContract();


	//testEsunnyV9FuturesToSledContract();

	//testEsunnyV9SpreadToSledContract();

	//testEsunnyV3FuturesToSledContract();

	//testEsunnyV3SpreadToSledContract();

	//testSledFuturesToEsunnyV9Contract();

	//testSledSpreadToEsunnyV9Contract();

	//testSledFuturesToEsunnyV3Contract();

	//testSledSpreadToEsunnyV3Contract();

	//ScreenInfo();
	/*
	int ch = getch();
	if (ch == 49) InputCTPToSledContract();		 //Num 1
	if (ch == 50) InputSledToCtpContract();      //Num 2	
	*/
	getchar();
}
