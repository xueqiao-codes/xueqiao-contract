package com.longsheng.xueqiao.contractconvertor.util;

/**
 * Created by Jason on 2018/3/10.
 */

import com.longsheng.xueqiao.contractconvertor.swig.*;

public class ObjectToString {

    public static String getStringFromObject(SledContract input)
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("SledContract(");
        strBuilder.append(getStringFromObject(input.getSledBaseContract_())).append(",");
        strBuilder.append("RelateSledContractCount=").append(input.getRelateSledContractCount_()).append(",");
        strBuilder.append("RelateSledContract(");
        for(int i=0; i<input.getRelateSledContractCount_();i++) {
            strBuilder.append(i).append("(").append(getStringFromObject(input.getRelateSledContract_(i)));
            if(i == input.getRelateSledContractCount_()-1)
                strBuilder.append(")");
            else
                strBuilder.append("),");
        }
        strBuilder.append(")");
        strBuilder.append(")");
        return  strBuilder.toString();
    }

    public static String getStringFromObject(SledBaseContract input)
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("SledBaseContract(");
        strBuilder.append("ExchangeMic=").append(input.getExchangeMic_()).append(",");
        strBuilder.append("SledCommodityType=").append(input.getSledCommodityType_()).append(",");
        strBuilder.append("SledCommodityCode=").append(input.getSledCommodityCode_()).append(",");
        strBuilder.append("SledContractCode=").append(input.getSledContractCode_());
        strBuilder.append(")");
        return strBuilder.toString();
    }

    public static String getStringFromObject(CommodityMap input)
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("CommodityMap(");
        strBuilder.append("TechPlatform=").append(input.getTechPlatform_()).append(",");
        strBuilder.append("ExchangeMic=").append(input.getExchangeMic_()).append(",");
        strBuilder.append("SledCommodityType=").append(input.getSledCommodityType_()).append(",");
        strBuilder.append("SledCommodityCode=").append(input.getSledCommodityCode_()).append(",");
        strBuilder.append("TechPlatform_Exchange=").append(input.getTechPlatform_Exchange_()).append(",");
        strBuilder.append("TechPlatform_CommodityType=").append(input.getTechPlatform_CommodityType_()).append(",");
        strBuilder.append("TechPlatform_CommodityCode=").append(input.getTechPlatform_CommodityCode_());
        strBuilder.append(")");
        return strBuilder.toString();
    }

    public static String getStringFromObject(CommonContract input)
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("CommonContract(");
        strBuilder.append("TechPlatform_Exchange=").append(input.getTechPlatform_Exchange_()).append(",");
        strBuilder.append("TechPlatform_CommodityType=").append(input.getTechPlatform_CommodityType_()).append(",");
        strBuilder.append("TechPlatform_CommodityCode=").append(input.getTechPlatform_CommodityCode_()).append(",");
        strBuilder.append("TechPlatform_ContractCode=").append(input.getTechPlatform_ContractCode_());
        strBuilder.append(")");
        return strBuilder.toString();
    }

    public static String getStringFromObject(MixContract input)
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("MixContract(");
        strBuilder.append("TechPlatform_Exchange=").append(input.getTechPlatform_Exchange_()).append(",");
        strBuilder.append("TechPlatform_CommodityType=").append(input.getTechPlatform_CommodityType_()).append(",");
        strBuilder.append("TechPlatform_CommodityCode=").append(input.getTechPlatform_CommodityCode_()).append(",");
        strBuilder.append("SledContractCode=").append(input.getSledContractCode_());
        strBuilder.append(")");
        return strBuilder.toString();
    }

    public static String getStringFromObject(SledContractToTechPlatformArgs input)
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("SledContractToTechPlatformArgs(");
        strBuilder.append("TechPlatform=").append(input.getTechPlatform_()).append(",");
        strBuilder.append(getStringFromObject(input.getSledContract_())).append(",");
        strBuilder.append(getStringFromObject(input.getCommodityMap_())).append(",");
        strBuilder.append("RelateCommodityMapCount=").append(input.getRelateCommodityMapCount_()).append(",");
        strBuilder.append("RelateCommodityMap(");
        for(int i=0; i<input.getRelateCommodityMapCount_(); i++) {
            strBuilder.append(i).append("(").append(getStringFromObject(input.getRelateCommodityMap_(i)));
            if(i == input.getRelateCommodityMapCount_()-1)
                strBuilder.append(")");
            else
                strBuilder.append("),");
        }
        strBuilder.append(")");

        strBuilder.append(")");
        return strBuilder.toString();
    }

    public static String getStringFromObject(SledContractToTechPlatformResult input)
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("SledContractToTechPlatformResult(");
        strBuilder.append("TechPlatform=").append(input.getTechPlatform_()).append(",");
        strBuilder.append(getStringFromObject(input.getCommonContract_())).append(",");
        strBuilder.append("OtherCommonContractCount=").append(input.getOtherCommonContractCount_()).append(",");
        strBuilder.append("OtherCommonContract(");
        for(int i=0; i<input.getOtherCommonContractCount_(); i++) {
            strBuilder.append(i).append("(").append(getStringFromObject(input.getOtherCommonContract_(i)));
            if(i==input.getOtherCommonContractCount_()-1)
                strBuilder.append(")");
            else
                strBuilder.append("),");
        }
        strBuilder.append(")");

        strBuilder.append(")");
        return strBuilder.toString();
    }

    public static String getStringFromObject(TechPlatformContractToSledArgs input)
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("TechPlatformContractToSledArgs(");
        strBuilder.append("TechPlatform=").append(input.getTechPlatform_()).append(",");
        strBuilder.append(getStringFromObject(input.getCommonContract_())).append(",");
        strBuilder.append("OtherCommonContractCount=").append(input.getOtherCommonContractCount_()).append(",");
        strBuilder.append("OtherCommonContract(");
        for(int i=0; i<input.getOtherCommonContractCount_(); i++) {
            strBuilder.append(i).append("(").append(getStringFromObject(input.getOtherCommonContract_(i)));
            if(i==input.getOtherCommonContractCount_()-1)
                strBuilder.append(")");
            else
                strBuilder.append("),");
        }
        strBuilder.append(")");

        strBuilder.append(")");
        return strBuilder.toString();
    }

    public static String getStringFromObject(TechPlatformContractToSledResult input)
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("TechPlatformContractToSledResult(");
        strBuilder.append("TechPlatform=").append(input.getTechPlatform_()).append(",");
        strBuilder.append(getStringFromObject(input.getMixContract_())).append(",");
        strBuilder.append("OtherCommonContractCount=").append(input.getRelateMixContractCount_()).append(",");
        strBuilder.append("OtherCommonContract(");
        for(int i=0; i<input.getRelateMixContractCount_(); i++) {
            strBuilder.append(i).append("(").append(getStringFromObject(input.getRelateMixContract_(i)));
            if(i==input.getRelateMixContractCount_()-1)
                strBuilder.append(")");
            else
                strBuilder.append("),");
        }
        strBuilder.append(")");

        strBuilder.append(")");
        return strBuilder.toString();
    }

}
