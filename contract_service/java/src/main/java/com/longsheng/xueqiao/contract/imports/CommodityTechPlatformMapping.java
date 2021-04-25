package com.longsheng.xueqiao.contract.imports;

import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;

import java.util.HashMap;
import java.util.Map;

public class CommodityTechPlatformMapping {

    private static Map<SledCommodityType, String> ctpCommodityTypeMap = new HashMap<>();
    private static Map<String, String> exchangeCtpMap = new HashMap<>();

    public PlatformCommodity map2CTP(SledCommodity sledCommodity, TechPlatform techPlatform, int brokerAccessId) {


        PlatformCommodity techPlatformCommodity = new PlatformCommodity();
        techPlatformCommodity.setExchange( getCtpExchangeMapping(sledCommodity.getExchangeMic()));
        techPlatformCommodity.setCommodityType(getCtpCommodityType(sledCommodity.getSledCommodityType()));
        techPlatformCommodity.setCommodityCode(getCtpCommodityCode(sledCommodity.getSledCommodityCode()));
        return techPlatformCommodity;
    }

    public String getCtpExchangeMapping(String sledExchangeMic) {

        return exchangeCtpMap.get(sledExchangeMic);
    }

    private String getCtpCommodityType(SledCommodityType sledCommodityType){
        return ctpCommodityTypeMap.get(sledCommodityType);
    }

    public String getCtpCommodityCode(String sledCommodityCode){

        return null;
    }
}
