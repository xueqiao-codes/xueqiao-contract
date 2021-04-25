package com.longsheng.xueqiao.contract.links;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.data.CommodityMappingUpdate;
import com.longsheng.xueqiao.contract.imports.PlatformCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

public class CommodityLink {

    public void addCommodityMapping(int sledCommodityId, PlatformCommodity platformCommodity) throws TException {
        long timeNow = System.currentTimeMillis() / 1000;
        long timeEnd = timeNow + 100 * 360 * 24 * 60 * 60;

        CommodityMappingUpdate commodityMappingUpdate = new CommodityMappingUpdate();
        CommodityMapping commodityMapping = new CommodityMapping();
        commodityMapping.setBrokerEntryId(0);
        commodityMapping.setActiveEndTimestamp(timeNow);
        commodityMapping.setActiveEndTimestamp(timeEnd);
        commodityMapping.setMoneyRatio(1.0);
        commodityMapping.setTechPlatform(platformCommodity.getTechPlatform());
        commodityMapping.setExchange(platformCommodity.getExchange());
        commodityMapping.setCommodityType(platformCommodity.getCommodityType());
        commodityMapping.setCommodityCode(platformCommodity.getCommodityCode());
        commodityMapping.setSledCommodityId(sledCommodityId);
        commodityMappingUpdate.doAddCommodityMap(commodityMapping);
    }

    public TechPlatformCommodity checkPlatformCommodityExist(PlatformCommodity platformCommodity) throws TException {

        AppLog.d("PlatformCommodity: " + platformCommodity.toString());
        return getTechPlatformCommodity(platformCommodity);
    }

    private TechPlatformCommodity getTechPlatformCommodity(PlatformCommodity platformCommodity) throws TException {

        ReqTechPlatformCommodityOption option = new ReqTechPlatformCommodityOption();
        option.setTechPlatform(platformCommodity.getTechPlatform());
        option.setTechPlatformExchange(platformCommodity.getExchange());
        option.setTechPlatformCommodityType(platformCommodity.getCommodityType());
        option.setTechPlatformCommodityCode(platformCommodity.getCommodityCode());

        TechPlatformCommodityPage products = new ContractDaoServiceStub().reqTechPlatformCommodity(option, 0, 1);

        if (products.getPageSize() == 0) {
            return null;
        }

        TechPlatformCommodity product = products.getPage().get(0);
        AppLog.d("product: " + product);
        return product;
    }
}
