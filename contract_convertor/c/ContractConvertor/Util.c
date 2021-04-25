/*
data struct for parameter
Jason 2018.2.5
*/

#include "Util.h"
#include "string.h"

/*	
	在source字符串中，如果以target字符串开头的，则返回以target字符串开头外的第一个字符的位置；
	在source字符串中，如果不是以target字符串开头的，则返回-1；
*/
int strPosSource(char *source, char *target)
{
	if (source == NULL || target == NULL)
		return -1;

	if (strlen(target) == 0 || strlen(source) == 0)
		return -1;

	if (strlen(target) > strlen(source))
		return -1;

	int characterCount = strlen(target);
	int pos = characterCount;
	for (int i = 0; i < characterCount; i++)
	{
		if (source[i] != target[i])
		{
			pos = i;
			break;
		}
	}

	if (pos != characterCount) //不是以target字符串开头
		return -1;
	return pos;
}

/*
	根据平台类型，和通用的商品类型，返回CTP的商品类型
*/
CtpCommodityTypeType getCtpCommodityType(TechPlatform techPlatform, CommonCommodityType commonCommodityType)
{
	//把通用的商品类型转成CTP的商品类型
	CtpCommodityTypeType ctpCommodityType = ' ';

	if (techPlatform != TechPlatform_CTP)
		return ctpCommodityType;

	for (int i = 0; i < (int)sizeof(CommonCommodityType) && commonCommodityType[i] != '\0'; ++i)
	{
		//去掉空格或者换行符
		if (commonCommodityType[i] == ' ' || commonCommodityType[i] == '\r' || commonCommodityType[i] == '\n')
			continue;
		ctpCommodityType = commonCommodityType[i]; //第一个非空字符就是CTP的商品类型
		break;
	}

	return ctpCommodityType;
}

/*
	根据平台类型，和通用的商品类型，返回Esunny 9.0的商品类型
*/
EsunnyV9CommodityTypeType getEsunnyV9CommodityType(TechPlatform techPlatform, CommonCommodityType commonCommodityType)
{
	//把通用的商品类型转成 Esunny 9.0 的商品类型
	EsunnyV9CommodityTypeType esunnyV9CommodityTypeType = ' ';

	if (techPlatform != TechPlatform_ESUNNY)
		return esunnyV9CommodityTypeType;

	for (int i = 0; i < (int)sizeof(CommonCommodityType) && commonCommodityType[i] != '\0'; ++i)
	{
		//去掉空格或者换行符
		if (commonCommodityType[i] == ' ' || commonCommodityType[i] == '\r' || commonCommodityType[i] == '\n')
			continue;
		esunnyV9CommodityTypeType = commonCommodityType[i]; //第一个非空字符就是CTP的商品类型
		break;
	}

	return esunnyV9CommodityTypeType;
}

/*
	根据平台类型，和通用的商品类型，返回Esunny 3.0的商品类型
*/
EsunnyV3CommodityTypeType getEsunnyV3CommodityType(TechPlatform techPlatform, CommonCommodityType commonCommodityType)
{
	//把通用的商品类型转成 Esunny 3.0 的商品类型
	EsunnyV3CommodityTypeType esunnyV3CommodityTypeType = ' ';

	if (techPlatform != TechPlatform_ESUNNY_3)
		return esunnyV3CommodityTypeType;

	for (int i = 0; i < (int)sizeof(CommonCommodityType) && commonCommodityType[i] != '\0'; ++i)
	{
		//去掉空格或者换行符
		if (commonCommodityType[i] == ' ' || commonCommodityType[i] == '\r' || commonCommodityType[i] == '\n')
			continue;
		esunnyV3CommodityTypeType = commonCommodityType[i]; //第一个非空字符就是CTP的商品类型
		break;
	}

	return esunnyV3CommodityTypeType;
}
