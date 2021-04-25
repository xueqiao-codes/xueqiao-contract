package com.longsheng.xueqiao.currency.dao.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.Map;
import java.util.HashMap;
import com.longsheng.xueqiao.currency.dao.thriftapi.CurrencyDao;
import com.longsheng.xueqiao.currency.dao.thriftapi.CurrencyDaoVariable;


public abstract class CurrencyDaoAdaptor implements CurrencyDao.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public int addCurrency(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.currency.thriftapi.Currency currency) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(CurrencyDaoVariable.serviceKey,"addCurrency",platformArgs);
    return addCurrency(oCntl, currency);
  }

  protected abstract int addCurrency(TServiceCntl oCntl, com.longsheng.xueqiao.currency.thriftapi.Currency currency) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public int updateCurrency(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.currency.thriftapi.Currency currency) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(CurrencyDaoVariable.serviceKey,"updateCurrency",platformArgs);
    return updateCurrency(oCntl, currency);
  }

  protected abstract int updateCurrency(TServiceCntl oCntl, com.longsheng.xueqiao.currency.thriftapi.Currency currency) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.currency.thriftapi.CurrencyPage reqCurrency(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption currencyOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(CurrencyDaoVariable.serviceKey,"reqCurrency",platformArgs);
    return reqCurrency(oCntl, currencyOption, pageOption);
  }

  protected abstract com.longsheng.xueqiao.currency.thriftapi.CurrencyPage reqCurrency(TServiceCntl oCntl, com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption currencyOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage reqExchangeRate(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption exchangeRateOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(CurrencyDaoVariable.serviceKey,"reqExchangeRate",platformArgs);
    return reqExchangeRate(oCntl, exchangeRateOption, pageOption);
  }

  protected abstract com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage reqExchangeRate(TServiceCntl oCntl, com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption exchangeRateOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public int updateExchangeRateValue(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.currency.thriftapi.ExchangeRate exchangeRate) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(CurrencyDaoVariable.serviceKey,"updateExchangeRateValue",platformArgs);
    return updateExchangeRateValue(oCntl, exchangeRate);
  }

  protected abstract int updateExchangeRateValue(TServiceCntl oCntl, com.longsheng.xueqiao.currency.thriftapi.ExchangeRate exchangeRate) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void syncExchangeRateToOnline(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(CurrencyDaoVariable.serviceKey,"syncExchangeRateToOnline",platformArgs);
syncExchangeRateToOnline(oCntl);
  }

  protected abstract void syncExchangeRateToOnline(TServiceCntl oCntl) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected CurrencyDaoAdaptor(){
    methodParameterNameMap.put("addCurrency",new String[]{"platformArgs", "currency"});
    methodParameterNameMap.put("updateCurrency",new String[]{"platformArgs", "currency"});
    methodParameterNameMap.put("reqCurrency",new String[]{"platformArgs", "currencyOption", "pageOption"});
    methodParameterNameMap.put("reqExchangeRate",new String[]{"platformArgs", "exchangeRateOption", "pageOption"});
    methodParameterNameMap.put("updateExchangeRateValue",new String[]{"platformArgs", "exchangeRate"});
    methodParameterNameMap.put("syncExchangeRateToOnline",new String[]{"platformArgs"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
