package com.longsheng.xueqiao.currency.dao.thriftapi.client;

import com.longsheng.xueqiao.currency.dao.thriftapi.CurrencyDao;
import com.longsheng.xueqiao.currency.dao.thriftapi.CurrencyDaoVariable;
import org.apache.thrift.TException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.client.AsyncCallRunner;
import org.soldier.platform.svr_platform.client.IMethodCallback;
import org.soldier.platform.svr_platform.client.SvrContainer;
import org.soldier.platform.svr_platform.client.TRequestOption;
import org.soldier.platform.svr_platform.client.TServiceCall;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import org.soldier.platform.svr_platform.client.BaseStub;

public class CurrencyDaoAsyncStub extends BaseStub { 
  public CurrencyDaoAsyncStub() {
    super(CurrencyDaoVariable.serviceKey);
  }
  public void send_addCurrency(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.Currency currency) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_addCurrencyServiceCall(routeKey, timeout, platformArgs, currency), new TRequestOption());
  }

  public void send_addCurrency(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.Currency currency,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_addCurrencyServiceCall(routeKey, timeout, platformArgs, currency), requestOption);
  }

  public long addCurrency(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.Currency currency, IMethodCallback<CurrencyDao.addCurrency_args, CurrencyDao.addCurrency_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_addCurrencyServiceCall(routeKey, timeout, platformArgs, currency), callback);
  }

  public long add_addCurrencyCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.Currency currency, IMethodCallback<CurrencyDao.addCurrency_args, CurrencyDao.addCurrency_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_addCurrencyServiceCall(routeKey, timeout, platformArgs, currency), callback);
  }

  protected TServiceCall create_addCurrencyServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.currency.thriftapi.Currency currency){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CurrencyDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CurrencyDao.addCurrency_args request = new CurrencyDao.addCurrency_args();
    request.setPlatformArgs(platformArgs);
    request.setCurrency(currency);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("addCurrency");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CurrencyDao.addCurrency_result.class);
    return serviceCall;
  }

  public void send_updateCurrency(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.Currency currency) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_updateCurrencyServiceCall(routeKey, timeout, platformArgs, currency), new TRequestOption());
  }

  public void send_updateCurrency(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.Currency currency,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_updateCurrencyServiceCall(routeKey, timeout, platformArgs, currency), requestOption);
  }

  public long updateCurrency(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.Currency currency, IMethodCallback<CurrencyDao.updateCurrency_args, CurrencyDao.updateCurrency_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_updateCurrencyServiceCall(routeKey, timeout, platformArgs, currency), callback);
  }

  public long add_updateCurrencyCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.Currency currency, IMethodCallback<CurrencyDao.updateCurrency_args, CurrencyDao.updateCurrency_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_updateCurrencyServiceCall(routeKey, timeout, platformArgs, currency), callback);
  }

  protected TServiceCall create_updateCurrencyServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.currency.thriftapi.Currency currency){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CurrencyDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CurrencyDao.updateCurrency_args request = new CurrencyDao.updateCurrency_args();
    request.setPlatformArgs(platformArgs);
    request.setCurrency(currency);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateCurrency");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CurrencyDao.updateCurrency_result.class);
    return serviceCall;
  }

  public void send_reqCurrency(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption currencyOption, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqCurrencyServiceCall(routeKey, timeout, platformArgs, currencyOption, pageOption), new TRequestOption());
  }

  public void send_reqCurrency(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption currencyOption, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqCurrencyServiceCall(routeKey, timeout, platformArgs, currencyOption, pageOption), requestOption);
  }

  public long reqCurrency(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption currencyOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<CurrencyDao.reqCurrency_args, CurrencyDao.reqCurrency_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqCurrencyServiceCall(routeKey, timeout, platformArgs, currencyOption, pageOption), callback);
  }

  public long add_reqCurrencyCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption currencyOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<CurrencyDao.reqCurrency_args, CurrencyDao.reqCurrency_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqCurrencyServiceCall(routeKey, timeout, platformArgs, currencyOption, pageOption), callback);
  }

  protected TServiceCall create_reqCurrencyServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption currencyOption, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CurrencyDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CurrencyDao.reqCurrency_args request = new CurrencyDao.reqCurrency_args();
    request.setPlatformArgs(platformArgs);
    request.setCurrencyOption(currencyOption);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqCurrency");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CurrencyDao.reqCurrency_result.class);
    return serviceCall;
  }

  public void send_reqExchangeRate(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption exchangeRateOption, org.soldier.platform.page.IndexedPageOption pageOption) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqExchangeRateServiceCall(routeKey, timeout, platformArgs, exchangeRateOption, pageOption), new TRequestOption());
  }

  public void send_reqExchangeRate(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption exchangeRateOption, org.soldier.platform.page.IndexedPageOption pageOption,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_reqExchangeRateServiceCall(routeKey, timeout, platformArgs, exchangeRateOption, pageOption), requestOption);
  }

  public long reqExchangeRate(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption exchangeRateOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<CurrencyDao.reqExchangeRate_args, CurrencyDao.reqExchangeRate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_reqExchangeRateServiceCall(routeKey, timeout, platformArgs, exchangeRateOption, pageOption), callback);
  }

  public long add_reqExchangeRateCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption exchangeRateOption, org.soldier.platform.page.IndexedPageOption pageOption, IMethodCallback<CurrencyDao.reqExchangeRate_args, CurrencyDao.reqExchangeRate_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_reqExchangeRateServiceCall(routeKey, timeout, platformArgs, exchangeRateOption, pageOption), callback);
  }

  protected TServiceCall create_reqExchangeRateServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption exchangeRateOption, org.soldier.platform.page.IndexedPageOption pageOption){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CurrencyDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CurrencyDao.reqExchangeRate_args request = new CurrencyDao.reqExchangeRate_args();
    request.setPlatformArgs(platformArgs);
    request.setExchangeRateOption(exchangeRateOption);
    request.setPageOption(pageOption);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("reqExchangeRate");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CurrencyDao.reqExchangeRate_result.class);
    return serviceCall;
  }

  public void send_updateExchangeRateValue(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ExchangeRate exchangeRate) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_updateExchangeRateValueServiceCall(routeKey, timeout, platformArgs, exchangeRate), new TRequestOption());
  }

  public void send_updateExchangeRateValue(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ExchangeRate exchangeRate,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_updateExchangeRateValueServiceCall(routeKey, timeout, platformArgs, exchangeRate), requestOption);
  }

  public long updateExchangeRateValue(int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ExchangeRate exchangeRate, IMethodCallback<CurrencyDao.updateExchangeRateValue_args, CurrencyDao.updateExchangeRateValue_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_updateExchangeRateValueServiceCall(routeKey, timeout, platformArgs, exchangeRate), callback);
  }

  public long add_updateExchangeRateValueCall(AsyncCallRunner runner, int routeKey, int timeout, com.longsheng.xueqiao.currency.thriftapi.ExchangeRate exchangeRate, IMethodCallback<CurrencyDao.updateExchangeRateValue_args, CurrencyDao.updateExchangeRateValue_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_updateExchangeRateValueServiceCall(routeKey, timeout, platformArgs, exchangeRate), callback);
  }

  protected TServiceCall create_updateExchangeRateValueServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.currency.thriftapi.ExchangeRate exchangeRate){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CurrencyDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CurrencyDao.updateExchangeRateValue_args request = new CurrencyDao.updateExchangeRateValue_args();
    request.setPlatformArgs(platformArgs);
    request.setExchangeRate(exchangeRate);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("updateExchangeRateValue");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CurrencyDao.updateExchangeRateValue_result.class);
    return serviceCall;
  }

  public void send_syncExchangeRateToOnline(int routeKey, int timeout) throws TException {
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_syncExchangeRateToOnlineServiceCall(routeKey, timeout, platformArgs), new TRequestOption());
  }

  public void send_syncExchangeRateToOnline(int routeKey, int timeout,TRequestOption requestOption) throws TException { 
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    SvrContainer.getInstance().sendRequest(
        create_syncExchangeRateToOnlineServiceCall(routeKey, timeout, platformArgs), requestOption);
  }

  public long syncExchangeRateToOnline(int routeKey, int timeout, IMethodCallback<CurrencyDao.syncExchangeRateToOnline_args, CurrencyDao.syncExchangeRateToOnline_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":"
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return SvrContainer.getInstance().sendRequest(
            create_syncExchangeRateToOnlineServiceCall(routeKey, timeout, platformArgs), callback);
  }

  public long add_syncExchangeRateToOnlineCall(AsyncCallRunner runner, int routeKey, int timeout, IMethodCallback<CurrencyDao.syncExchangeRateToOnline_args, CurrencyDao.syncExchangeRateToOnline_result> callback) throws TException{
    PlatformArgs platformArgs = new PlatformArgs();
    platformArgs.setTimeoutMs(timeout);
    StackTraceElement callStackElement = Thread.currentThread().getStackTrace()[2];
    platformArgs.setSourceDesc(
        callStackElement.getClassName() + "[" + callStackElement.getMethodName() + ":" 
        + callStackElement.getLineNumber() + "]");
    try {
      platformArgs.setSourceIp(InetAddress.getLocalHost().getHostAddress());
    } catch (UnknownHostException e) {
      AppLog.w(e.getMessage(), e);
    }
    return runner.addAsyncCall(
            create_syncExchangeRateToOnlineServiceCall(routeKey, timeout, platformArgs), callback);
  }

  protected TServiceCall create_syncExchangeRateToOnlineServiceCall(int routeKey, int timeout, org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs){
    TServiceCall serviceCall = new TServiceCall();
    if (!getPeerAddr().isEmpty()) {
      serviceCall.setChooseServiceIp(getPeerAddr());
    }
    if (getPeerPort() != 0) {
      serviceCall.setChooseServicePort(getPeerPort());
    }
    serviceCall.setServiceKey(CurrencyDaoVariable.serviceKey);
    serviceCall.setRouteKey(routeKey);
    serviceCall.setOneWay(false);
    CurrencyDao.syncExchangeRateToOnline_args request = new CurrencyDao.syncExchangeRateToOnline_args();
    request.setPlatformArgs(platformArgs);
    serviceCall.setRequest(request);
    serviceCall.setMethodName("syncExchangeRateToOnline");
    serviceCall.setTimeout(timeout);
    serviceCall.setResponse(CurrencyDao.syncExchangeRateToOnline_result.class);
    return serviceCall;
  }

}
