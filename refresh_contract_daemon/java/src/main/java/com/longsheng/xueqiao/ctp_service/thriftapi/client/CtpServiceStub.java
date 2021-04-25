package com.longsheng.xueqiao.ctp_service.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import java.util.List;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpAccount;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInputOrderActionField;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInputOrderField;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInstrument;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInstrumentCommissionRate;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInstrumentMarginRate;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInvestorInfo;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpInvestorPosition;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpLoginStatus;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpOrderField;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpProduct;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpTradeField;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpTradingAccount;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpTradingParams;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpService;
import com.longsheng.xueqiao.ctp_service.thriftapi.CtpServiceVariable;

public class CtpServiceStub extends BaseStub {

  public CtpServiceStub() {
    super(CtpServiceVariable.serviceKey);
  }

  public String  reqOrderInsert(CtpInputOrderField ctpInputOrderField, String clientInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrderInsert(ctpInputOrderField, clientInfo, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public String  reqOrderInsert(CtpInputOrderField ctpInputOrderField, String clientInfo,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqOrderInsert").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<String>(){
    @Override
    public String call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqOrderInsert(platformArgs, ctpInputOrderField, clientInfo);
      }
    }, invokeInfo);
  }

  public String  reqOrderInsert(int routeKey, int timeout,CtpInputOrderField ctpInputOrderField, String clientInfo)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrderInsert(ctpInputOrderField, clientInfo, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  reqOrderAction(CtpInputOrderActionField ctpInputOrderActionField, String clientInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrderAction(ctpInputOrderActionField, clientInfo, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  reqOrderAction(CtpInputOrderActionField ctpInputOrderActionField, String clientInfo,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqOrderAction").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Integer>(){
    @Override
    public Integer call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqOrderAction(platformArgs, ctpInputOrderActionField, clientInfo);
      }
    }, invokeInfo);
  }

  public int  reqOrderAction(int routeKey, int timeout,CtpInputOrderActionField ctpInputOrderActionField, String clientInfo)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrderAction(ctpInputOrderActionField, clientInfo, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpInstrument>  reqInstrumentList(String instrumentId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInstrumentList(instrumentId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpInstrument>  reqInstrumentList(String instrumentId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqInstrumentList").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CtpInstrument>>(){
    @Override
    public List<CtpInstrument> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqInstrumentList(platformArgs, instrumentId);
      }
    }, invokeInfo);
  }

  public List<CtpInstrument>  reqInstrumentList(int routeKey, int timeout,String instrumentId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInstrumentList(instrumentId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpInvestorInfo>  reqInvestorInfo() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInvestorInfo(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpInvestorInfo>  reqInvestorInfo(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqInvestorInfo").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CtpInvestorInfo>>(){
    @Override
    public List<CtpInvestorInfo> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqInvestorInfo(platformArgs);
      }
    }, invokeInfo);
  }

  public List<CtpInvestorInfo>  reqInvestorInfo(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInvestorInfo(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpTradingParams>  reqTradingParams() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqTradingParams(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpTradingParams>  reqTradingParams(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqTradingParams").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CtpTradingParams>>(){
    @Override
    public List<CtpTradingParams> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqTradingParams(platformArgs);
      }
    }, invokeInfo);
  }

  public List<CtpTradingParams>  reqTradingParams(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqTradingParams(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpOrderField>  reqOrders(String frontId, String sessionId, String orderRef, String sledId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrders(frontId, sessionId, orderRef, sledId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpOrderField>  reqOrders(String frontId, String sessionId, String orderRef, String sledId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqOrders").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CtpOrderField>>(){
    @Override
    public List<CtpOrderField> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqOrders(platformArgs, frontId, sessionId, orderRef, sledId);
      }
    }, invokeInfo);
  }

  public List<CtpOrderField>  reqOrders(int routeKey, int timeout,String frontId, String sessionId, String orderRef, String sledId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrders(frontId, sessionId, orderRef, sledId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpTradeField>  reqTrades(String exchangeId, String orderSysID, String tradeId, String sledId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqTrades(exchangeId, orderSysID, tradeId, sledId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpTradeField>  reqTrades(String exchangeId, String orderSysID, String tradeId, String sledId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqTrades").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CtpTradeField>>(){
    @Override
    public List<CtpTradeField> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqTrades(platformArgs, exchangeId, orderSysID, tradeId, sledId);
      }
    }, invokeInfo);
  }

  public List<CtpTradeField>  reqTrades(int routeKey, int timeout,String exchangeId, String orderSysID, String tradeId, String sledId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqTrades(exchangeId, orderSysID, tradeId, sledId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpInvestorPosition>  reqInvestorPosition(String instrumentId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInvestorPosition(instrumentId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpInvestorPosition>  reqInvestorPosition(String instrumentId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqInvestorPosition").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CtpInvestorPosition>>(){
    @Override
    public List<CtpInvestorPosition> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqInvestorPosition(platformArgs, instrumentId);
      }
    }, invokeInfo);
  }

  public List<CtpInvestorPosition>  reqInvestorPosition(int routeKey, int timeout,String instrumentId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInvestorPosition(instrumentId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpInstrumentMarginRate>  reqInstrumentMarginRate(String instrumentId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInstrumentMarginRate(instrumentId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpInstrumentMarginRate>  reqInstrumentMarginRate(String instrumentId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqInstrumentMarginRate").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CtpInstrumentMarginRate>>(){
    @Override
    public List<CtpInstrumentMarginRate> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqInstrumentMarginRate(platformArgs, instrumentId);
      }
    }, invokeInfo);
  }

  public List<CtpInstrumentMarginRate>  reqInstrumentMarginRate(int routeKey, int timeout,String instrumentId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInstrumentMarginRate(instrumentId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpInstrumentCommissionRate>  reqInstrumentCommissionRate(String instrumentId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInstrumentCommissionRate(instrumentId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpInstrumentCommissionRate>  reqInstrumentCommissionRate(String instrumentId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqInstrumentCommissionRate").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CtpInstrumentCommissionRate>>(){
    @Override
    public List<CtpInstrumentCommissionRate> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqInstrumentCommissionRate(platformArgs, instrumentId);
      }
    }, invokeInfo);
  }

  public List<CtpInstrumentCommissionRate>  reqInstrumentCommissionRate(int routeKey, int timeout,String instrumentId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInstrumentCommissionRate(instrumentId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpTradingAccount>  reqTradingAccount() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqTradingAccount(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpTradingAccount>  reqTradingAccount(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqTradingAccount").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CtpTradingAccount>>(){
    @Override
    public List<CtpTradingAccount> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqTradingAccount(platformArgs);
      }
    }, invokeInfo);
  }

  public List<CtpTradingAccount>  reqTradingAccount(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqTradingAccount(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpProduct>  reqProducts(String productId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqProducts(productId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpProduct>  reqProducts(String productId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqProducts").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CtpProduct>>(){
    @Override
    public List<CtpProduct> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqProducts(platformArgs, productId);
      }
    }, invokeInfo);
  }

  public List<CtpProduct>  reqProducts(int routeKey, int timeout,String productId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqProducts(productId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpAccount>  reqCtpAccount() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCtpAccount(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<CtpAccount>  reqCtpAccount(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqCtpAccount").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<CtpAccount>>(){
    @Override
    public List<CtpAccount> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqCtpAccount(platformArgs);
      }
    }, invokeInfo);
  }

  public List<CtpAccount>  reqCtpAccount(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqCtpAccount(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateCtpAccount(CtpAccount account) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateCtpAccount(account, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateCtpAccount(CtpAccount account,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateCtpAccount").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new CtpService.Client(protocol).updateCtpAccount(platformArgs, account);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateCtpAccount(int routeKey, int timeout,CtpAccount account)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateCtpAccount(account, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  reqLogin() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    reqLogin(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  reqLogin(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqLogin").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new CtpService.Client(protocol).reqLogin(platformArgs);
      return null;
      }
    }, invokeInfo);
  }

  public void  reqLogin(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    reqLogin(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  reqLogout() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    reqLogout(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  reqLogout(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqLogout").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new CtpService.Client(protocol).reqLogout(platformArgs);
      return null;
      }
    }, invokeInfo);
  }

  public void  reqLogout(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    reqLogout(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  reqRelogin() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    reqRelogin(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  reqRelogin(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqRelogin").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new CtpService.Client(protocol).reqRelogin(platformArgs);
      return null;
      }
    }, invokeInfo);
  }

  public void  reqRelogin(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    reqRelogin(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CtpLoginStatus  reqLoginStatus() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqLoginStatus(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public CtpLoginStatus  reqLoginStatus(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqLoginStatus").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<CtpLoginStatus>(){
    @Override
    public CtpLoginStatus call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new CtpService.Client(protocol).reqLoginStatus(platformArgs);
      }
    }, invokeInfo);
  }

  public CtpLoginStatus  reqLoginStatus(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqLoginStatus(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
