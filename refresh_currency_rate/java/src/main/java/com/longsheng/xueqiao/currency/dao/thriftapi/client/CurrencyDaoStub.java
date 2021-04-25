package com.longsheng.xueqiao.currency.dao.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import com.longsheng.xueqiao.currency.dao.thriftapi.CurrencyDao;
import com.longsheng.xueqiao.currency.dao.thriftapi.CurrencyDaoVariable;

public class CurrencyDaoStub extends BaseStub {

  public CurrencyDaoStub() {
    super(CurrencyDaoVariable.serviceKey);
  }

  public int  addCurrency(com.longsheng.xueqiao.currency.thriftapi.Currency currency) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addCurrency(currency, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  addCurrency(com.longsheng.xueqiao.currency.thriftapi.Currency currency,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addCurrency").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Integer>(){
    @Override
    public Integer call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CurrencyDao.Client(protocol).addCurrency(platformArgs, currency);
      }
    }, invokeInfo);
  }

  public int  addCurrency(int routeKey, int timeout,com.longsheng.xueqiao.currency.thriftapi.Currency currency)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addCurrency(currency, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  updateCurrency(com.longsheng.xueqiao.currency.thriftapi.Currency currency) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateCurrency(currency, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  updateCurrency(com.longsheng.xueqiao.currency.thriftapi.Currency currency,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateCurrency").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Integer>(){
    @Override
    public Integer call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CurrencyDao.Client(protocol).updateCurrency(platformArgs, currency);
      }
    }, invokeInfo);
  }

  public int  updateCurrency(int routeKey, int timeout,com.longsheng.xueqiao.currency.thriftapi.Currency currency)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateCurrency(currency, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.currency.thriftapi.CurrencyPage  reqCurrency(com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption currencyOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCurrency(currencyOption, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.currency.thriftapi.CurrencyPage  reqCurrency(com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption currencyOption, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCurrency").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.currency.thriftapi.CurrencyPage>(){
    @Override
    public com.longsheng.xueqiao.currency.thriftapi.CurrencyPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CurrencyDao.Client(protocol).reqCurrency(platformArgs, currencyOption, pageOption);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.currency.thriftapi.CurrencyPage  reqCurrency(int routeKey, int timeout,com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption currencyOption, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCurrency(currencyOption, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage  reqExchangeRate(com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption exchangeRateOption, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqExchangeRate(exchangeRateOption, pageOption, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage  reqExchangeRate(com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption exchangeRateOption, org.soldier.platform.page.IndexedPageOption pageOption,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqExchangeRate").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage>(){
    @Override
    public com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CurrencyDao.Client(protocol).reqExchangeRate(platformArgs, exchangeRateOption, pageOption);
      }
    }, invokeInfo);
  }

  public com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage  reqExchangeRate(int routeKey, int timeout,com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption exchangeRateOption, org.soldier.platform.page.IndexedPageOption pageOption)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqExchangeRate(exchangeRateOption, pageOption, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  updateExchangeRateValue(com.longsheng.xueqiao.currency.thriftapi.ExchangeRate exchangeRate) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateExchangeRateValue(exchangeRate, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  updateExchangeRateValue(com.longsheng.xueqiao.currency.thriftapi.ExchangeRate exchangeRate,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateExchangeRateValue").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Integer>(){
    @Override
    public Integer call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CurrencyDao.Client(protocol).updateExchangeRateValue(platformArgs, exchangeRate);
      }
    }, invokeInfo);
  }

  public int  updateExchangeRateValue(int routeKey, int timeout,com.longsheng.xueqiao.currency.thriftapi.ExchangeRate exchangeRate)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return updateExchangeRateValue(exchangeRate, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  syncExchangeRateToOnline() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    syncExchangeRateToOnline(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  syncExchangeRateToOnline(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("syncExchangeRateToOnline").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new CurrencyDao.Client(protocol).syncExchangeRateToOnline(platformArgs);
      return null;
      }
    }, invokeInfo);
  }

  public void  syncExchangeRateToOnline(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    syncExchangeRateToOnline(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
