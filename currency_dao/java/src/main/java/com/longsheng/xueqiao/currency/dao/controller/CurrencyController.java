package com.longsheng.xueqiao.currency.dao.controller;

import com.longsheng.xueqiao.currency.dao.handler.SledCurrencyHandler;
import com.longsheng.xueqiao.currency.dao.handler.SledExchangeRateHandler;
import com.longsheng.xueqiao.currency.thriftapi.Currency;
import com.longsheng.xueqiao.currency.thriftapi.CurrencyPage;
import com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.SQLException;

public class CurrencyController {

    public int addCurrency(Connection conn, Currency currency) throws ErrorInfo, SQLException {
        int rowId = 0;
        SledCurrencyHandler sledCurrencyHandler = new SledCurrencyHandler(conn);
        SledExchangeRateHandler sledExchangeRateHandler = new SledExchangeRateHandler(conn);
        ReqCurrencyOption currencyOption = new ReqCurrencyOption();
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(Integer.MAX_VALUE);

        // 当添加的为基准备货币时，再以该货币为基准创建汇率记录
        if (currency.isBaseCurrency) {
            CurrencyPage currencyPage = sledCurrencyHandler.query(currencyOption, pageOption);
            if (currencyPage != null && currencyPage.getPageSize() > 0) {
                for (Currency item : currencyPage.getPage()) {
                    if (!currency.getCurrencyCode().equals(item.getCurrencyCode())) {
                        sledExchangeRateHandler.insert(currency.getCurrencyCode(), item.getCurrencyCode());
                    }
                }
            }
        }

        // 以别人基准货币创建汇率记录
        // attention: 两个查询用的是同一个currencyOption
        currencyOption.setIsBaseCurrency(true);
        CurrencyPage currencyPage = sledCurrencyHandler.query(currencyOption, pageOption);
        if (currencyPage != null && currencyPage.getPageSize() > 0) {
            for (Currency item : currencyPage.getPage()) {
                sledExchangeRateHandler.insert(item.getCurrencyCode(), currency.getCurrencyCode());
            }
        }

        // 插入货币记录
        rowId = sledCurrencyHandler.insert(currency);
        return rowId;
    }

    public int updateCurrency(Connection conn, Currency currency, boolean isOrignalCurrencyBase) throws ErrorInfo, SQLException {
        int rowId = 0;
        SledCurrencyHandler sledCurrencyHandler = new SledCurrencyHandler(conn);
        SledExchangeRateHandler sledExchangeRateHandler = new SledExchangeRateHandler(conn);
        rowId =  sledCurrencyHandler.update(currency);
        ReqCurrencyOption currencyOption = new ReqCurrencyOption();
        IndexedPageOption pageOption = new IndexedPageOption();
        pageOption.setPageIndex(0);
        pageOption.setPageSize(Integer.MAX_VALUE);
        if (currency.isSetIsBaseCurrency()) {
            if (isOrignalCurrencyBase && !currency.isBaseCurrency) {
                sledExchangeRateHandler.delete(currency.getCurrencyCode());
            } else if (!isOrignalCurrencyBase && currency.isBaseCurrency) {
                CurrencyPage currencyPage = sledCurrencyHandler.query(currencyOption, pageOption);
                if (currencyPage != null && currencyPage.getPageSize() > 0) {
                    for (Currency item : currencyPage.getPage()) {
                        if (!currency.getCurrencyCode().equals(item.getCurrencyCode())) {
                            sledExchangeRateHandler.insert(currency.getCurrencyCode(), item.getCurrencyCode());
                        }
                    }
                }
            }
        }
        return rowId;
    }
}
