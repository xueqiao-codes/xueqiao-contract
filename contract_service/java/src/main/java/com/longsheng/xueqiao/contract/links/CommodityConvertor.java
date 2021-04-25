package com.longsheng.xueqiao.contract.links;

import com.longsheng.xueqiao.contract.data.SledCommodityTypeMappingAccess;
import com.longsheng.xueqiao.contract.data.SledExchangeMappingAccess;
import com.longsheng.xueqiao.contract.imports.PlatformCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;


public class CommodityConvertor {

    public PlatformCommodity getPlatformCommodity(SledCommodity sledCommodity, TechPlatform techPlatform, String platformCommodityCode) throws TException {

        String platformExchange = getTechPlatformExchange(sledCommodity, techPlatform);
        String platformType = getTechPlatformType(sledCommodity, techPlatform);

        if (platformType == null || platformExchange == null) {
            throw new ErrorInfo(ContractManageErrorCode.PLATFORM_COMMODITY_NOT_FOUND.getValue(), "Exchange or CommodityType mapping not found.");
        }

        PlatformCommodity platformCommodity = new PlatformCommodity();
        platformCommodity.setTechPlatform(techPlatform);
        platformCommodity.setCommodityCode(platformCommodityCode);
        platformCommodity.setCommodityType(platformType);
        platformCommodity.setExchange(platformExchange);

        return platformCommodity;
    }

    private String getTechPlatformType(SledCommodity sledCommodity, TechPlatform techPlatform) throws TException {

        SledCommodityTypeMappingAccess access = new SledCommodityTypeMappingAccess();
        ReqSledCommodityTypeMappingOption option = new ReqSledCommodityTypeMappingOption();
        option.setTechPlatform(techPlatform);
        option.setSledCommodityType(sledCommodity.getSledCommodityType());
        SledCommodityTypeMappingPage page = access.getPage(option);
        if (page.getPageSize() > 0) {
            return page.getPage().get(0).getTechPlatformCommodityType();
        }
        return null;
    }

    private String getTechPlatformExchange(SledCommodity sledCommodity, TechPlatform techPlatform) throws TException {
        SledExchangeMappingAccess exchangeMappingAccess = new SledExchangeMappingAccess();
        ReqSledExchangeMappingOption exchangeMappingOption = new ReqSledExchangeMappingOption();
        exchangeMappingOption.setTechPlatform(techPlatform);
        exchangeMappingOption.setSledExchangeMic(sledCommodity.getExchangeMic());
        SledExchangeMappingPage exchangeMappingPage = exchangeMappingAccess.getPage(exchangeMappingOption);
        if (exchangeMappingPage.getPageSize() > 0) {
            return exchangeMappingPage.getPage().get(0).getTechPlatformExchangeCode();
        }
        return null;
    }
}
