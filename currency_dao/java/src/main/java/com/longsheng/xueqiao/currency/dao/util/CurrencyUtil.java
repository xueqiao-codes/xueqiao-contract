package com.longsheng.xueqiao.currency.dao.util;

import java.util.HashMap;
import java.util.Map;

public class CurrencyUtil {
    private static Map<String, String> mTCurrencyCode = new HashMap<String, String>();

    static {
        mTCurrencyCode.put("USD", "美元");
        mTCurrencyCode.put("CNY", "人民币");
        mTCurrencyCode.put("EUR", "欧元");
        mTCurrencyCode.put("GBP", "英镑");
        mTCurrencyCode.put("HKD", "港币");
        mTCurrencyCode.put("JPY", "日元");
        mTCurrencyCode.put("KRW", "韩元");
        mTCurrencyCode.put("MYR", "马来西亚林吉特");
        mTCurrencyCode.put("SGD", "新加坡元");
        mTCurrencyCode.put("THB", "泰铢");
        mTCurrencyCode.put("AUD", "澳元");
        mTCurrencyCode.put("CAD", "加元");
        mTCurrencyCode.put("CHF", "瑞士法郎");
    }

    public static String getExchangeRateName(String baseCurrency, String targetCurrency) {
        if (mTCurrencyCode.containsKey(baseCurrency) && mTCurrencyCode.containsKey(targetCurrency)) {
            return mTCurrencyCode.get(targetCurrency) + mTCurrencyCode.get(baseCurrency);
        } else {
            return targetCurrency + baseCurrency;
        }
    }

}
