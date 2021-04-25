/*
data struct for parameter
Jason 2018.2.2
*/

#include "ContractConvertor.h"
#include "CtpContractConvertor.h"
#include "EsunnyV9ContractConvertor.h"
#include "EsunnyV3ContractConvertor.h"
#include "string.h"

TechPlatformContractToSledResult PlatformToSledContract(TechPlatformContractToSledArgs args)
{
	switch (args.TechPlatform_)
	{
	case TechPlatform_CTP:
		return CtpToSledContract(args);
	case TechPlatform_ESUNNY: //易盛9.0
		return EsunnyV9ToSledContract(args);
	case TechPlatform_ESUNNY_3: //易盛3.0
		return EsunnyV3ToSledContract(args);

	// to do
	default:
		break;
	}

	TechPlatformContractToSledResult result;
	memset(&result, 0, sizeof(TechPlatformContractToSledResult));
	return result;
}

SledContractToTechPlatformResult SledToPlatformContract(SledContractToTechPlatformArgs args)
{
	switch (args.TechPlatform_)
	{
	case TechPlatform_CTP:
		return SledToCtpContract(args);
	case TechPlatform_ESUNNY: //易盛9.0
		return SledToEsunnyV9Contract(args);
	case TechPlatform_ESUNNY_3: //易盛3.0
		return SledToEsunnyV3Contract(args);

	// to do
	default:
		break;
	}

	SledContractToTechPlatformResult result;
	memset(&result, 0, sizeof(SledContractToTechPlatformResult));
	return result;
}
