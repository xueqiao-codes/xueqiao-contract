/*
data struct for parameter
Jason 2018.2.5
*/

#ifndef UTIL_H
#define UTIL_H

#include "DataType.h"
#include "DataStruct.h"

#ifdef __cplusplus  
extern "C" {
#endif

	/*	
		在source字符串中，如果target字符串开头的，则返回以target字符串开头外的第一个字符的位置；
		在source字符串中，如果不是target字符串开头的，则返回-1；
	*/
	int strPosSource(char *source, char *target);

	/*
		根据平台类型，和通用的商品类型，返回CTP的商品类型
	*/
	CtpCommodityTypeType getCtpCommodityType(TechPlatform techPlatform, CommonCommodityType commonCommodityType);

	/*
		根据平台类型，和通用的商品类型，返回Esunny 9.0的商品类型
	*/
	EsunnyV9CommodityTypeType getEsunnyV9CommodityType(TechPlatform techPlatform, CommonCommodityType commonCommodityType);

	/*
		根据平台类型，和通用的商品类型，返回Esunny 3.0的商品类型
	*/
	EsunnyV3CommodityTypeType getEsunnyV3CommodityType(TechPlatform techPlatform, CommonCommodityType commonCommodityType);

#ifdef __cplusplus
}
#endif

#endif