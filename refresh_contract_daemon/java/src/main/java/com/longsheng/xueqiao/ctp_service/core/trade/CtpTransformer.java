package com.longsheng.xueqiao.ctp_service.core.trade;

import com.longsheng.xueqiao.ctp_service.thriftapi.*;
import net.jctp.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suker on 17/5/25.
 */
public class CtpTransformer {

    public static final byte THOST_FTDC_PC_Futures = 49;
    public static final byte THOST_FTDC_PC_Options = 50;
    public static final byte THOST_FTDC_PC_Combination = 51;
    public static final byte THOST_FTDC_PC_Spot = 52;
    public static final byte THOST_FTDC_PC_EFP = 53;
    public static final byte THOST_FTDC_PC_SpotOption = 54;

    public static CtpInstrument getCtpInstrumentFromCThostFtdcInstrumentField(CThostFtdcInstrumentField pInstrument) {
        CtpInstrument r = new CtpInstrument();

        r.setInstrumentID(pInstrument.InstrumentID);
        r.setExchangeID(pInstrument.ExchangeID);
        r.setInstrumentName(pInstrument.InstrumentName);
        r.setExchangeInstID(pInstrument.ExchangeInstID);
        r.setProductID(pInstrument.ProductID);
        r.setProductClass((byte) pInstrument.ProductClass);
        r.setDeliveryYear(pInstrument.DeliveryYear);
        r.setDeliveryMonth(pInstrument.DeliveryMonth);
        r.setMaxMarketOrderVolume(pInstrument.MaxMarketOrderVolume);
        r.setMinMarketOrderVolume(pInstrument.MinMarketOrderVolume);
        r.setMaxLimitOrderVolume(pInstrument.MaxLimitOrderVolume);
        r.setMinLimitOrderVolume(pInstrument.MinLimitOrderVolume);
        r.setVolumeMultiple(pInstrument.VolumeMultiple);
        r.setPriceTick(pInstrument.PriceTick);
        r.setCreateDate(pInstrument.CreateDate);
        r.setOpenDate(pInstrument.OpenDate);
        r.setExpireDate(pInstrument.ExpireDate);
        r.setStartDelivDate(pInstrument.StartDelivDate);
        r.setEndDelivDate(pInstrument.EndDelivDate);
        r.setInstLifePhase((byte) pInstrument.InstLifePhase);
        r.setIsTrading(pInstrument.IsTrading);
        r.setPositionType((byte) pInstrument.PositionType);
        r.setPositionDateType((byte) pInstrument.PositionDateType);
        r.setLongMarginRatio(pInstrument.LongMarginRatio);
        r.setShortMarginRatio(pInstrument.ShortMarginRatio);
        r.setMaxMarginSideAlgorithm((byte) pInstrument.MaxMarginSideAlgorithm);
        r.setUnderlyingInstrID(pInstrument.UnderlyingInstrID);
        r.setStrikePrice(pInstrument.StrikePrice);
        r.setOptionsType((byte) pInstrument.OptionsType);
        r.setUnderlyingMultiple(pInstrument.UnderlyingMultiple);
        r.setCombinationType((byte) pInstrument.CombinationType);

        return r;
    }

    private static final Map<Byte, CtpProductClassType> ctpProductClassTypeMap = new HashMap() {{
        put(THOST_FTDC_PC_Futures, CtpProductClassType.THOST_FTDC_PC_Futures);
        put(THOST_FTDC_PC_Options, CtpProductClassType.THOST_FTDC_PC_Options);
        put(THOST_FTDC_PC_Combination, CtpProductClassType.THOST_FTDC_PC_Combination);
        put(THOST_FTDC_PC_Spot, CtpProductClassType.THOST_FTDC_PC_Spot);
        put(THOST_FTDC_PC_EFP, CtpProductClassType.THOST_FTDC_PC_EFP);
        put(THOST_FTDC_PC_SpotOption, CtpProductClassType.THOST_FTDC_PC_SpotOption);
    }};

    public static CtpProduct getCtpProductFromCThostFtdcProductField(CThostFtdcProductField pProduct) {
        CtpProduct r = new CtpProduct();

        r.setProductID(pProduct.ProductID);
        r.setProductName(pProduct.ProductName);
        r.setExchangeID(pProduct.ExchangeID);
        r.setProductClass(ctpProductClassTypeMap.get((byte) pProduct.ProductClass));
        r.setVolumeMultiple(pProduct.VolumeMultiple);
        r.setPriceTick(pProduct.PriceTick);
        r.setMaxMarketOrderVolume(pProduct.MaxMarketOrderVolume);
        r.setMinMarketOrderVolume(pProduct.MinMarketOrderVolume);
        r.setMaxLimitOrderVolume(pProduct.MaxLimitOrderVolume);
        r.setMinLimitOrderVolume(pProduct.MinLimitOrderVolume);
        r.setTradeCurrencyID(pProduct.TradeCurrencyID);
        r.setExchangeProductID(pProduct.ExchangeProductID);
        r.setUnderlyingMultiple(pProduct.UnderlyingMultiple);

        return r;
    }

    public static CtpInstrumentCommissionRate getCtpInstrumentCommissionRateFromCThostFtdcInstrumentCommissionRateField(CThostFtdcInstrumentCommissionRateField pInstrumentCommissionRate) {
        CtpInstrumentCommissionRate ctpInstrumentCommissionRate = new CtpInstrumentCommissionRate();

        ctpInstrumentCommissionRate.setInstrumentID(pInstrumentCommissionRate.InstrumentID);
        ctpInstrumentCommissionRate.setInvestorRange((byte) pInstrumentCommissionRate.InvestorRange);
        ctpInstrumentCommissionRate.setOpenRatioByMoney(pInstrumentCommissionRate.OpenRatioByMoney);
        ctpInstrumentCommissionRate.setOpenRatioByVolume(pInstrumentCommissionRate.OpenRatioByVolume);
        ctpInstrumentCommissionRate.setCloseRatioByMoney(pInstrumentCommissionRate.CloseRatioByMoney);
        ctpInstrumentCommissionRate.setCloseRatioByVolume(pInstrumentCommissionRate.CloseRatioByVolume);
        ctpInstrumentCommissionRate.setCloseTodayRatioByMoney(pInstrumentCommissionRate.CloseTodayRatioByMoney);
        ctpInstrumentCommissionRate.setCloseTodayRatioByVolume(pInstrumentCommissionRate.CloseTodayRatioByVolume);

        return ctpInstrumentCommissionRate;
    }

    public static CtpInstrumentMarginRate getCtpInstrumentMarginRateFromCThostFtdcInstrumentMarginRateField(CThostFtdcInstrumentMarginRateField pInstrumentMarginRate) {
        CtpInstrumentMarginRate ctpInstrumentMarginRate = new CtpInstrumentMarginRate();

        ctpInstrumentMarginRate.setInstrumentID(pInstrumentMarginRate.InstrumentID);
        ctpInstrumentMarginRate.setInvestorRange((byte) pInstrumentMarginRate.InvestorRange);
        ctpInstrumentMarginRate.setHedgeFlag((byte) pInstrumentMarginRate.HedgeFlag);
        ctpInstrumentMarginRate.setLongMarginRatioByMoney(pInstrumentMarginRate.LongMarginRatioByMoney);
        ctpInstrumentMarginRate.setLongMarginRatioByVolume(pInstrumentMarginRate.LongMarginRatioByVolume);
        ctpInstrumentMarginRate.setShortMarginRatioByMoney(pInstrumentMarginRate.ShortMarginRatioByMoney);
        ctpInstrumentMarginRate.setShortMarginRatioByVolume(pInstrumentMarginRate.ShortMarginRatioByVolume);
        ctpInstrumentMarginRate.setIsRelative(pInstrumentMarginRate.IsRelative);

        return ctpInstrumentMarginRate;
    }
}
