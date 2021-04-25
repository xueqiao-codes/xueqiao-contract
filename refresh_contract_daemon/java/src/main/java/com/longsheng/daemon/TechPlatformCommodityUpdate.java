package com.longsheng.daemon;

import com.longsheng.xueqiao.contract.dao.thriftapi.TSledCommodity;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.CmbDirect;
import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpProduct;
import com.longsheng.xueqiao.util.esunny9.swig.EsCommodityInfo;
import com.longsheng.xueqiao.util.esunny9.swig.EsunnyTradeSwigUtilConstants;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;

import java.util.Collection;
import java.util.List;

public class TechPlatformCommodityUpdate {

    private ContractDaoServiceStub stub = new ContractDaoServiceStub();
    private static final String changeCount = "daemon.server.TechPlatformCommodityUpdate.change.count";
    private static final String changeTotal = "daemon.server.TechPlatformCommodityUpdate.change.total";

    public static void refreshEsunnyTechPlatformCommodity(Collection<EsCommodityInfo> products) {
        if (!products.isEmpty()) {
            clear(TechPlatform.ESUNNY);
        }
        for (EsCommodityInfo product : products) {
            try {
                saveEsunnyTechPlatformCommodity(product);
            } catch (Throwable e) {
                AppLog.e(e.getMessage(), e);
            }
        }
    }

    private static void saveEsunnyTechPlatformCommodity(EsCommodityInfo product) {
        TechPlatformCommodity techPlatformCommodity = new TechPlatformCommodity();
        PlatformCommodity esCommodity = getEsPlatformCommodity(product);
        techPlatformCommodity.setExchange(esCommodity.getExchange());
        techPlatformCommodity.setCommodityType(esCommodity.getCommodityType());
        techPlatformCommodity.setCommodityCode(esCommodity.getCommodityCode());
        techPlatformCommodity.setTickSize(product.getCommodityTickSize());
        techPlatformCommodity.setTechPlatform(TechPlatform.ESUNNY);
        techPlatformCommodity.setCmbDirect(CmbDirect.findByValue(product.getCmbDirect() + 1));
        techPlatformCommodity.setContractSize(product.getContractSize());
        techPlatformCommodity.setTradeCurrency(product.getTradeCurrency());
        techPlatformCommodity.setCnName(product.getCommodityName());
        techPlatformCommodity.setDenominator(1);

        TSledCommodity tSledCommodity = TCommodityMapCache.getInstance().getTSledCommodityId(TechPlatform.ESUNNY, esCommodity.getExchange(), esCommodity.getCommodityType(), esCommodity.getCommodityCode());

        if (tSledCommodity != null) {
            techPlatformCommodity.setSledCommodityId(tSledCommodity.getSledCommodityId());
        }

        save(techPlatformCommodity);
    }

    private static void save(TechPlatformCommodity techPlatformCommodity) {
        try {
            if (!techPlatformCommodity.isSetSledCommodityId()) {
                techPlatformCommodity.setSledCommodityId(0);
            }
            new ContractDaoServiceStub().addTechPlatformCommodity(techPlatformCommodity);
        } catch (TException e) {
            AppLog.e(e.getMessage(), e);
        }
    }

    public static PlatformCommodity getEsPlatformCommodity(EsCommodityInfo esProduct) {
        char type = esProduct.getCommodityType();
        AppLog.d("type: " + type);
        String typeStr = new String(Character.toString(type));
        if (type == EsunnyTradeSwigUtilConstants.ESUNNY9_COMMODITY_TYPE_FUTURES) {
            typeStr = "F";
        } else if (type == EsunnyTradeSwigUtilConstants.ESUNNY9_COMMODITY_TYPE_SPREAD_COMMODITY) {
            typeStr = "M";
        } else if (type == EsunnyTradeSwigUtilConstants.ESUNNY9_COMMODITY_TYPE_SPREAD_MONTH) {
            typeStr = "S";
        }
        AppLog.d("typeStr: " + typeStr);

        if (typeStr == null) {
            return null;
        }

        String commodityNo = esProduct.getCommodityNo();
        String commodityType = typeStr;
        String exchangeNo = esProduct.getExchangeNo();

        PlatformCommodity platformCommodity = new PlatformCommodity();
        platformCommodity.setCommodityCode(commodityNo);
        platformCommodity.setCommodityType(commodityType);
        platformCommodity.setExchange(exchangeNo);
        return platformCommodity;
    }

    public static void refreshCtpTechPlatformCommodity(List<CtpProduct> products) {
        if (!products.isEmpty()) {
            clear(TechPlatform.CTP);
        }
        for (CtpProduct product : products) {
            try {
                saveCtpTechPlatformCommodity(product);
            } catch (Throwable e) {
                AppLog.e(e.getMessage(), e);
            }
        }
    }

    private static void saveCtpTechPlatformCommodity(CtpProduct product) throws TException {
        TechPlatformCommodity techPlatformCommodity = new TechPlatformCommodity();
        String productType = String.valueOf(product.getProductClass().getValue());
        TSledCommodity tSledCommodity = TCommodityMapCache.getInstance().getTSledCommodityId(TechPlatform.CTP, product.getExchangeID(), productType, product.getProductID());

        if (tSledCommodity != null) {
            techPlatformCommodity.setSledCommodityId(tSledCommodity.getSledCommodityId());
        }

        techPlatformCommodity.setCommodityCode(product.getProductID());
        if (product.isSetPriceTick()) {
            techPlatformCommodity.setTickSize(product.getPriceTick());
        }
        techPlatformCommodity.setTechPlatform(TechPlatform.CTP);
        techPlatformCommodity.setExchange(product.getExchangeID());
        techPlatformCommodity.setCommodityType(productType);
        techPlatformCommodity.setMaxSingleOrderVol(product.getMaxLimitOrderVolume());
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
        save(techPlatformCommodity);
    }

    private static void clear(TechPlatform techPlatform) {
        try {
            new ContractDaoServiceStub().clearAllTechPlatformCommodity(techPlatform.getValue());
        } catch (TException e) {
            AppLog.e(e.getMessage(), e);
        }
    }
}
