/*
data struct for parameter
Jason 2018.2.2
*/

#ifndef CONTRACTCONVERTOR_H
#define CONTRACTCONVERTOR_H

#include "DataStruct.h"

#ifdef __cplusplus  
extern "C" {
#endif 

	TechPlatformContractToSledResult PlatformToSledContract(TechPlatformContractToSledArgs args);

	SledContractToTechPlatformResult SledToPlatformContract(SledContractToTechPlatformArgs args);

#ifdef __cplusplus
}
#endif

#endif