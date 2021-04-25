/*
data struct for parameter
Jason 2018.2.7
*/

#ifndef ESUNNYV3CONTRACTCONVERTOR_H
#define ESUNNYV3CONTRACTCONVERTOR_H

#include "DataStruct.h"

#ifdef __cplusplus  
extern "C" {
#endif 

	TechPlatformContractToSledResult EsunnyV3ToSledContract(TechPlatformContractToSledArgs args);

	SledContractToTechPlatformResult SledToEsunnyV3Contract(SledContractToTechPlatformArgs args);

#ifdef __cplusplus
}
#endif

#endif