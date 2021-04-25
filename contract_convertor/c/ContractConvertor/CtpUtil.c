/*
data struct for parameter
Jason 2018.1.29
*/

#include "CtpUtil.h"
#include "Util.h"
#include "string.h"
#include "time.h"
#include "stdio.h"
#include "stdlib.h"




/*
	功能：把CTP合约代码RM801，au1806变成纯数字1801，1806
	输入：CTP合约代码，CTP商品代码
	输出：纯4位数字的雪橇合约代码
	注意：不足4位的，按年份补足。
*/
CtpFuturesContractCodeToSledContractCodeResult CtpFuturesContractCodeToSledContractCode(CommonContractCodeType ctpContractCode, CommonCommodityCodeType ctpCommodityCode)
{
	CtpFuturesContractCodeToSledContractCodeResult result;
	memset(&result, 0, sizeof(CtpFuturesContractCodeToSledContractCodeResult));

	//把合约代码RM801，au1806的数字部分提取出来
	int digitalPos = strPosSource(ctpContractCode, ctpCommodityCode);
	if (digitalPos == -1)
		return result;

	CommonContractCodeType commonContractCode;
	memset(&commonContractCode, 0, sizeof(CommonContractCodeType));

	int codeDigitalCount = 0;
	for (int i = digitalPos; i < (int)sizeof(CommonContractCodeType) && ctpContractCode[i] != '\0'; ++i)
	{
		//去掉空格或者换行符
		if (ctpContractCode[i] == ' ' || ctpContractCode[i] == '\r' || ctpContractCode[i] == '\n')
			continue;
		commonContractCode[codeDigitalCount] = ctpContractCode[i];
		codeDigitalCount++;
	}

	//如果数字部分只有3位数，如801，001，需要补足成4位数1801，2001
	if (strlen(commonContractCode) < 4)
	{
		ContractCode3To4DigitalResult contractCode3To4DigitalResult = ContractCode3To4Digital(commonContractCode);
		memcpy(result.SledContractCode_, contractCode3To4DigitalResult.CommonContractCode4Digital_, sizeof(CommonContractCodeType));
	}
	else
		memcpy(result.SledContractCode_, commonContractCode, sizeof(CommonContractCodeType));

	return result;
}

/*
	功能：format contract code from 3 digital to 4 digtial
	传入参数又是返回参数。传入的参数形如 005（代表2020年5月份的合约）, 得到的返回值是2005
*/
ContractCode3To4DigitalResult ContractCode3To4Digital(CommonContractCodeType commonContractCode)
{
	ContractCode3To4DigitalResult result;
	memset(&result, 0, sizeof(ContractCode3To4DigitalResult));

	if (strlen(commonContractCode) != 3) //只处理3位数的数字
		return result;

	CommonContractCodeType tmpCommonContractCode;
	memset(tmpCommonContractCode, 0, sizeof(CommonContractCodeType));

	//获取现在年份的第3位数字，如2018，则获取到1，如2020，则获取到2
	time_t rawtime;
	struct tm *time_info;

	time(&rawtime);
	/* 获取 GMT 时间 */
	time_info = gmtime(&rawtime);

	int yearLastTwoDigital = time_info->tm_year % 100;

	//获取现在年份的第3位数字
	int yearTheThirdDigital = yearLastTwoDigital / 10;

	sprintf(tmpCommonContractCode, "%d", yearTheThirdDigital); //值可能是1，2...
	
	strncat(tmpCommonContractCode, commonContractCode, 1); //把1,8连接起来，变成18，但如果连接起来成了10，那就有问题了，下面处理

	int yearConvertResult = atoi(tmpCommonContractCode);
	if (yearConvertResult < yearLastTwoDigital)
		yearTheThirdDigital = yearTheThirdDigital + 1; //把005这样的合约能正确处理成2005，而不是1005

	//重新赋值
	memset(tmpCommonContractCode, 0, sizeof(CommonContractCodeType));
	sprintf(tmpCommonContractCode, "%d", yearTheThirdDigital); //值可能是1，2...
	strcat(tmpCommonContractCode, commonContractCode); //把1,801连接起来，变成1801

	memcpy(result.CommonContractCode4Digital_, tmpCommonContractCode, sizeof(CommonContractCodeType)); //内存拷贝赋值

	return result;
}

/*
	功能：把形如 IPS SF801&SM801，拆成 SF801 和 SM801
*/
TwoLegsCommonContractCode SplitCtpSpreadContractCode(CommonContract ctpContract, CommonContractCodeType ctpContractCode)
{
	TwoLegsCommonContractCode result;
	memset(&result, 0, sizeof(TwoLegsCommonContractCode));

	//先把交易所组合的商品代码拆开，商品代码形如：IPS SF&SM，拆成 IPS 和 SF&SM；形如 IPS SF801&SM801，拆成 SF801和SM801
	int splitPos = -1;
	if (strcmp(ctpContract.TechPlatform_Exchange_, "CZCE") == 0 && strPosSource(ctpContractCode, "IPS ") > 0)
		splitPos = strPosSource(ctpContractCode, "IPS ");
	else if (strcmp(ctpContract.TechPlatform_Exchange_, "CZCE") == 0 && strPosSource(ctpContractCode, "SPD ") > 0)
		splitPos = strPosSource(ctpContractCode, "SPD ");
	else if (strcmp(ctpContract.TechPlatform_Exchange_, "DCE") == 0 && strPosSource(ctpContractCode, "SPC ") > 0)
		splitPos = strPosSource(ctpContractCode, "SPC ");
	else if (strcmp(ctpContract.TechPlatform_Exchange_, "DCE") == 0 && strPosSource(ctpContractCode, "SP ") > 0)
		splitPos = strPosSource(ctpContractCode, "SP ");

	//不是指定的交易所组合,直接返回
	if (splitPos == -1)
		return result;

	CommonContractCodeType twoCommodity; //最后可以得到SF&SM；或者SF801&SM801
	memset(&twoCommodity, 0, sizeof(CommonContractCodeType));

	int twoCommodityCount = 0;
	for (int i = splitPos; i < (int)sizeof(CommonContractCodeType) && ctpContractCode[i] != '\0'; ++i)
	{
		//去掉空格或者换行符
		if (ctpContractCode[i] == ' ' || ctpContractCode[i] == '\r' || ctpContractCode[i] == '\n')
			continue;
		twoCommodity[twoCommodityCount] = ctpContractCode[i];
		twoCommodityCount++;
	}

	// 把SF&SM拆开，得到 SF 和 SM；或者SF801&SM801，得到 SF801 和 SM801	
	int firstContractCodeFinish = -1;
	int firstContractCodeCounter = 0;
	int secondContractCodeCounter = 0;
	for (int i = 0; i < (int)sizeof(CommonContractCodeType) && twoCommodity[i] != '\0'; ++i)
	{
		if (twoCommodity[i] == '&')
		{
			firstContractCodeFinish = 0;
			continue;
		}
		if (firstContractCodeFinish == -1)
		{
			result.FirstContractCode_[firstContractCodeCounter] = twoCommodity[i];
			firstContractCodeCounter++;
		}
		if (firstContractCodeFinish == 0)
		{
			result.SecondContractCode_[secondContractCodeCounter] = twoCommodity[i];
			secondContractCodeCounter++;
		}
	}

	return result;
}

/*
功能：把形如 IPS SF&SM，拆成 SF 和 SM
*/
TwoLegsCommonCommodityCode SplitCtpSpreadCommodityCode(CommonContract ctpContract, CommonCommodityCodeType ctpCommodityCodeType)
{
	TwoLegsCommonContractCode resultContractCode = SplitCtpSpreadContractCode(ctpContract, ctpCommodityCodeType);

	TwoLegsCommonCommodityCode resultCommodityCode;
	memset(&resultCommodityCode, 0, sizeof(TwoLegsCommonCommodityCode));
	memcpy(resultCommodityCode.FirstCommdityCode_, resultContractCode.FirstContractCode_, sizeof(CommonCommodityCodeType));
	memcpy(resultCommodityCode.SecondCommdityCode_, resultContractCode.SecondContractCode_, sizeof(CommonCommodityCodeType));

	return resultCommodityCode;
}

/*
功能：由雪橇交易所，CTP商品代码，雪橇合约代码 得到 CTP的合约代码（只针对CTP期货）
*/
SledContractCodeToCtpFuturesContractCodeResult SledContractCodeToCtpFuturesContractCode(SledExchangeMicType sledExchangeMic, CommonCommodityCodeType ctpCommodityCode, SledContractCodeType sledContractCode)
{
	SledContractCodeToCtpFuturesContractCodeResult result;
	memset(&result, 0, sizeof(SledContractCodeToCtpFuturesContractCodeResult));

	//如果没有传入商品映射，返回的结果是没有任何内容的
	if (strlen(sledExchangeMic) == 0 || strlen(sledExchangeMic) > sizeof(SledExchangeMicType) || strlen(ctpCommodityCode) == 0 || strlen(ctpCommodityCode) > sizeof(CommonCommodityCodeType) || strlen(sledContractCode) == 0 || strlen(sledContractCode) > sizeof(SledContractCodeType))
		return result;

	CommonContractCodeType ctpContractCode;
	memset(&ctpContractCode, 0, sizeof(CommonContractCodeType));

	//CTP合约代码 = CTP商品代码 + 雪橇合约代码；如 CTP合约代码 = au + 1806
	strcat(ctpContractCode, ctpCommodityCode);  // 先连接CTP商品代码部分

	//对郑商所的合约做处理，因为郑商所的合约数字部分只有3位，所以需要把雪橇的合约数字部分截短1位
	if (strcmp(sledExchangeMic, "XZCE") == 0)
	{
		CommonContractCodeType tmpCtpContractCode;
		memset(&tmpCtpContractCode, 0, sizeof(CommonContractCodeType));
		int tmpCounter = 0;
		for (int i = 1; i < (int)sizeof(CommonContractCodeType) && sledContractCode[i] != '\0'; ++i) //跳过第1位即可
		{
			tmpCtpContractCode[tmpCounter] = sledContractCode[i];
			tmpCounter++;
		}

		if (sizeof(CommonContractCodeType) > strlen(ctpContractCode) + strlen(tmpCtpContractCode)) //空间够，字符串才能串起来
			strcat(ctpContractCode, tmpCtpContractCode);  // 再连接雪橇合约代码部分
	}
	else
	{
		if (sizeof(CommonContractCodeType) > strlen(ctpContractCode) + strlen(sledContractCode)) //空间够，字符串才能串起来
			strcat(ctpContractCode, sledContractCode);  // 再连接雪橇合约代码部分
	}

	memcpy(result.CommonContractCode_, ctpContractCode, sizeof(CommonContractCodeType));

	return result;
}
