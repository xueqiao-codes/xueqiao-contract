package com.longsheng.daemon;

import com.longsheng.xueqiao.contract.dao.thriftapi.*;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.CmbDirect;
import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.ReqTechPlatformCommodityOption;
import com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity;
import com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodityPage;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpProduct;
import com.longsheng.xueqiao.ctp_service.thriftapi.client.CtpServiceStub;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;

import java.util.List;

public class CtpCommodityCompare {

    private ContractDaoServiceStub stub = new ContractDaoServiceStub();
    private static final String changeCount = "daemon.server.CtpCommodityCompare.change.count";
    private static final String changeTotal = "daemon.server.CtpCommodityCompare.change.total";

    public void saveTechPlatformCommodity(TechPlatformCommodity techPlatformCommodity, String commodityCode) throws TException {

        List<CtpProduct> products = new CtpServiceStub().reqProducts(commodityCode);
        AppLog.d("req commdoity: "+ commodityCode);
        AppLog.d("products size: " + products.size());
        if (products.size() == 0) {
            return;
        }
        CtpProduct product = products.get(0);
        String productType = String.valueOf(product.getProductClass().getValue());
        TSledCommodity tSledCommodity = TCommodityMapCache.getInstance().getTSledCommodityId(TechPlatform.CTP, product.getExchangeID(), productType, product.getProductID());

        if (tSledCommodity == null) {
            AppLog.d("product not in sled: " + product);
            return;
        }

        ReqTechPlatformCommodityOption reqTechPlatformCommodityOption = new ReqTechPlatformCommodityOption();
        reqTechPlatformCommodityOption.addToSledCommodityIds(tSledCommodity.getSledCommodityId());
        reqTechPlatformCommodityOption.setTechPlatform(TechPlatform.CTP);
        TechPlatformCommodityPage page = stub.reqTechPlatformCommodity(reqTechPlatformCommodityOption, 0, 1);

        techPlatformCommodity.setCommodityCode(commodityCode);
        if (product.isSetPriceTick()) {
            techPlatformCommodity.setTickSize(product.getPriceTick());
        }
        techPlatformCommodity.setTechPlatform(TechPlatform.CTP);
        techPlatformCommodity.setMaxSingleOrderVol(product.getMaxLimitOrderVolume());
//        techPlatformCommodity.setCommodityState(CommodityState.TRADEABLE);
//        techPlatformCommodity.setCmbDirect(CmbDirect.FIRST);
        if (product.isSetVolumeMultiple()) {
            techPlatformCommodity.setContractSize(product.getVolumeMultiple());
        }
        if (product.isSetTradeCurrencyID()) {
            techPlatformCommodity.setTradeCurrency(product.getTradeCurrencyID());
        }
        techPlatformCommodity.addToRelateCommodityCodes(product.getProductID());
        techPlatformCommodity.setCnName(product.getProductName());
        techPlatformCommodity.setTimezone("UTC+8");
        techPlatformCommodity.setDenominator(1);
        techPlatformCommodity.setSledCommodityId(tSledCommodity.getSledCommodityId());

        boolean isChange = false;
        if (page.getPageSize() == 0) {
            isChange = true;
        } else {
            TechPlatformCommodity old = page.getPage().get(0);
            if (techPlatformCommodity.isSetContractSize()) {
                if (old.getContractSize() != techPlatformCommodity.getContractSize()) {
                    isChange = true;
                }
            }
            if (techPlatformCommodity.isSetTickSize()) {
                if (old.getTickSize() != techPlatformCommodity.getTickSize()) {
                    isChange = true;
                }
            }
            if (techPlatformCommodity.isSetTradeCurrency()) {
                if (!old.getTradeCurrency().equals(techPlatformCommodity.getTradeCurrency())) {
                    isChange = true;
                }
            }
        }
        AppLog.d("Counter count: " + Counter.getInstance().getCount());

        if (isChange) {
            AppLog.d("update techPlatformCommodity: "+ techPlatformCommodity);
            // TODO SAVE ALL
            stub.addTechPlatformCommodity(techPlatformCommodity);
        }
    }
}
