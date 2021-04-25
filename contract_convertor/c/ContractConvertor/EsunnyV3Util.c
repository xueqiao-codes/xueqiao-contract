/*
data struct for parameter
Jason 2018.2.7
*/

#include "EsunnyV3Util.h"
#include "string.h"

/*
功能：把形如 1801/1802，拆成 1801和1802 返回
*/
TwoLegsCommonContractCode SplitEsunnyV3SpreadMonthContractCode(CommonContract commonContract)
{
	TwoLegsCommonContractCode result;
	memset(&result, 0, sizeof(TwoLegsCommonContractCode));

	// 把1801/1802拆开，得到 1801 和 1802；
	int firstContractCodeFinish = -1;
	int firstContractCodeCounter = 0;
	int secondContractCodeCounter = 0;
	for (int i = 0; i < (int)sizeof(CommonContractCodeType) && commonContract.TechPlatform_ContractCode_[i] != '\0'; ++i)
	{
		//去掉空格或者换行符
		if (commonContract.TechPlatform_ContractCode_[i] == ' ' || commonContract.TechPlatform_ContractCode_[i] == '\r' || commonContract.TechPlatform_ContractCode_[i] == '\n')
			continue;

		if (commonContract.TechPlatform_ContractCode_[i] == '/')
		{
			firstContractCodeFinish = 0;
			continue;
		}
		if (firstContractCodeFinish == -1)
		{
			result.FirstContractCode_[firstContractCodeCounter] = commonContract.TechPlatform_ContractCode_[i];
			firstContractCodeCounter++;
		}
		if (firstContractCodeFinish == 0)
		{
			result.SecondContractCode_[secondContractCodeCounter] = commonContract.TechPlatform_ContractCode_[i];
			secondContractCodeCounter++;
		}
	}

	return result;
}
