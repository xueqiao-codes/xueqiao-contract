/*
data struct for parameter
Jason 2018.1.29
*/

#ifndef CTPCONTRACTCONVERTOR_H
#define CTPCONTRACTCONVERTOR_H

#include "DataStruct.h"

#ifdef __cplusplus  
extern "C" {
#endif 

TechPlatformContractToSledResult CtpToSledContract(TechPlatformContractToSledArgs args);

SledContractToTechPlatformResult SledToCtpContract(SledContractToTechPlatformArgs args);

#ifdef __cplusplus
}
#endif

#endif