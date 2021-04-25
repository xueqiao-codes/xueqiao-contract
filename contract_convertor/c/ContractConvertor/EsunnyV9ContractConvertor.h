/*
data struct for parameter
Jason 2018.2.5
*/

#ifndef ESUNNYV9CONTRACTCONVERTOR_H
#define ESUNNYV9CONTRACTCONVERTOR_H

#include "DataStruct.h"

#ifdef __cplusplus  
extern "C" {
#endif 

	TechPlatformContractToSledResult EsunnyV9ToSledContract(TechPlatformContractToSledArgs args);

	SledContractToTechPlatformResult SledToEsunnyV9Contract(SledContractToTechPlatformArgs args);

#ifdef __cplusplus
}
#endif

#endif