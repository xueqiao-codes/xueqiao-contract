package com.longsheng.xueqiao.currency.dao.thriftapi.server.impl;

import java.util.Properties;

import com.longsheng.xueqiao.currency.dao.controller.CurrencyController;
import com.longsheng.xueqiao.currency.dao.controller.CurrencyHistoryController;
import com.longsheng.xueqiao.currency.dao.handler.SledExchangeRateHandler;
import com.longsheng.xueqiao.currency.thriftapi.*;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.dal_set.DalSetProxy;
import org.soldier.platform.db_helper.DBTransactionHelper;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;

import com.antiy.error_code.ErrorCodeInner;
import com.longsheng.xueqiao.currency.dao.config.ConfigurationProperty;
import com.longsheng.xueqiao.currency.dao.handler.SledCurrencyHandler;
import com.longsheng.xueqiao.currency.dao.thriftapi.server.CurrencyDaoAdaptor;

public class CurrencyDaoHandler extends CurrencyDaoAdaptor {

    private String roleName;

    @Override
    public int InitApp(Properties props) {
        try {
            DalSetProxy.getInstance().loadFromXml();
        } catch (Exception e) {
            AppLog.e("DAL init fail.", e);
            e.printStackTrace();
            return -1;
        }
        try {
            ConfigurationProperty.instance().init(props);
            roleName = ConfigurationProperty.instance().getRoleName();
        } catch (Exception e) {
            e.printStackTrace();
            AppLog.e("Config init fail.", e);
            return -1;
        }
        AppLog.e("======= SERVICE START =======");
        return 0;
    }

    @Override
    protected int addCurrency(TServiceCntl oCntl, com.longsheng.xueqiao.currency.thriftapi.Currency currency) throws ErrorInfo, TException {
        AppLog.i("CurrencyDaoHandler ---- addCurrency ---- currency : " + currency);
        if (currency == null) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "currency should not be null");
        }
        if (StringUtils.isBlank(currency.getCurrencyCode())) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "currency's currencyCode should not be blank");
        }
        if (!StringUtils.isBlank(currency.getSymbol()) && currency.getSymbol().length() > 16) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "currency's symbol should not contain more than 16 bytes");
        }

        return new DBTransactionHelper<Integer>(new DalSetDataSource(roleName, oCntl.getDalSetServiceName(), false, 0)) {
            private int rowId;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
                Currency cy = new SledCurrencyHandler(getConnection()).query(currency.getCurrencyCode());
                if (cy != null) {
                    throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), currency.getCurrencyCode() + " already exist.");
                }
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                rowId = new CurrencyController().addCurrency(getConnection(), currency);
            }

            @Override
            public Integer getResult() {
                return rowId;
            }
        }.execute().getResult();


    }

    @Override
    protected int updateCurrency(TServiceCntl oCntl, com.longsheng.xueqiao.currency.thriftapi.Currency currency)
            throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        AppLog.i("CurrencyDaoHandler ---- updateCurrency ---- currency : " + currency);

        if (currency == null) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "currency should not be null");
        }
        if (StringUtils.isBlank(currency.getCurrencyCode())) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "currency's currencyCode should not be blank");
        }

        return new DBTransactionHelper<Integer>(new DalSetDataSource(roleName, oCntl.getDalSetServiceName(), false, 0)) {
            private int rowId;
            private boolean isOrignalCurrencyBase = false;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
                Currency cy = new SledCurrencyHandler(getConnection()).query(currency.getCurrencyCode());
                if (cy == null) {
                    throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), currency.getCurrencyCode() + " is not exist.");
                } else {
                    isOrignalCurrencyBase = cy.isBaseCurrency;
                }
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                rowId = new CurrencyController().updateCurrency(getConnection(), currency, isOrignalCurrencyBase);
            }

            @Override
            public Integer getResult() {
                return rowId;
            }
        }.execute().getResult();
    }

    @Override
    protected com.longsheng.xueqiao.currency.thriftapi.CurrencyPage reqCurrency(TServiceCntl oCntl, ReqCurrencyOption currencyOption, IndexedPageOption pageOption)
            throws ErrorInfo, TException {
        AppLog.i("CurrencyDaoHandler ---- reqCurrency ---- pageOption : " + pageOption);
        return new DBTransactionHelper<CurrencyPage>(new DalSetDataSource(roleName, oCntl.getDalSetServiceName(), false, 0)) {
            private CurrencyPage currencyPage;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                currencyPage = new SledCurrencyHandler(getConnection()).query(currencyOption, pageOption);
            }

            @Override
            public CurrencyPage getResult() {
                return currencyPage;
            }
        }.execute().getResult();
    }

    @Override
    protected com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage reqExchangeRate(TServiceCntl oCntl, ReqExchangeRateOption exchangeRateOption, IndexedPageOption pageOption)
            throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        return new DBTransactionHelper<ExchangeRatePage>(new DalSetDataSource(roleName, oCntl.getDalSetServiceName(), false, 0)) {
            private ExchangeRatePage exchangeRatePage;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                exchangeRatePage = new SledExchangeRateHandler(getConnection()).query(exchangeRateOption, pageOption);
            }

            @Override
            public ExchangeRatePage getResult() {
                return exchangeRatePage;
            }
        }.execute().getResult();
    }

    @Override
    protected int updateExchangeRateValue(TServiceCntl oCntl,
                                          com.longsheng.xueqiao.currency.thriftapi.ExchangeRate exchangeRate)
            throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {

        if (exchangeRate == null) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "exchangeRate should not be null");
        }
        if (StringUtils.isBlank(exchangeRate.getBaseCurrency())) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "exchangeRate's baseCurrency should not be blank");
        }
        if (StringUtils.isBlank(exchangeRate.getTargetCurrency())) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "exchangeRate's targetCurrency should not be blank");
        }
        if (exchangeRate.getExchangeRate() <= 0) {
            throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), "exchangeRate's exchangeRate should not be larger than zero");
        }

        return new DBTransactionHelper<Integer>(new DalSetDataSource(roleName, oCntl.getDalSetServiceName(), false, 0)) {
            private int rowId;

            @Override
            public void onPrepareData() throws ErrorInfo, Exception {
                ExchangeRate er = new SledExchangeRateHandler(getConnection()).query(exchangeRate.getBaseCurrency(), exchangeRate.getTargetCurrency());
                if (er == null) {
                    throw new ErrorInfo(ErrorCodeInner.PARAM_ERROR.getErrorCode(), exchangeRate.getTargetCurrency() + exchangeRate.getBaseCurrency() + " is not exist.");
                }
            }

            @Override
            public void onUpdate() throws ErrorInfo, Exception {
                ExchangeRate modifyExchangeRate = new ExchangeRate();
                modifyExchangeRate.setBaseCurrency(exchangeRate.getBaseCurrency());
                modifyExchangeRate.setTargetCurrency(exchangeRate.getTargetCurrency());
                modifyExchangeRate.setExchangeRate(exchangeRate.getExchangeRate());
                rowId = new SledExchangeRateHandler(getConnection()).update(modifyExchangeRate);
            }

            @Override
            public Integer getResult() {
                return rowId;
            }
        }.execute().getResult();
    }

    @Override
    protected void syncExchangeRateToOnline(TServiceCntl oCntl) throws ErrorInfo, TException {
        new CurrencyHistoryController().syncHistory(ConfigurationProperty.instance().getRoleName(), oCntl.getDalSetServiceName());
    }

    @Override
    public void destroy() {
    }
}
