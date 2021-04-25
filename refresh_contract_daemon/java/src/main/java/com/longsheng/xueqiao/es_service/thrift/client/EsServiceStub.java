package com.longsheng.xueqiao.es_service.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import java.util.List;
import com.longsheng.xueqiao.es_service.thrift.EsAccount;
import com.longsheng.xueqiao.es_service.thrift.EsInputOrderActionField;
import com.longsheng.xueqiao.es_service.thrift.EsInputOrderField;
import com.longsheng.xueqiao.es_service.thrift.EsInstrument;
import com.longsheng.xueqiao.es_service.thrift.EsLoginStatus;
import com.longsheng.xueqiao.es_service.thrift.ReqEsClientCountRentsOption;
import com.longsheng.xueqiao.es_service.thrift.ReqEsClientCountRentsRsp;
import com.longsheng.xueqiao.es_service.thrift.ReqEsHoldsOption;
import com.longsheng.xueqiao.es_service.thrift.ReqEsHoldsRsp;
import com.longsheng.xueqiao.es_service.thrift.ReqEsInstrumentsOption;
import com.longsheng.xueqiao.es_service.thrift.ReqEsInstrumentsRsp;
import com.longsheng.xueqiao.es_service.thrift.ReqEsMoneyOption;
import com.longsheng.xueqiao.es_service.thrift.ReqEsMoneyRsp;
import com.longsheng.xueqiao.es_service.thrift.ReqEsProductOption;
import com.longsheng.xueqiao.es_service.thrift.ReqEsProductRsp;
import com.longsheng.xueqiao.es_service.thrift.ReqOrdersOption;
import com.longsheng.xueqiao.es_service.thrift.ReqOrdersRsp;
import com.longsheng.xueqiao.es_service.thrift.ReqTradesOption;
import com.longsheng.xueqiao.es_service.thrift.ReqTradesRsp;
import com.longsheng.xueqiao.es_service.thrift.EsService;
import com.longsheng.xueqiao.es_service.thrift.EsServiceVariable;

public class EsServiceStub extends BaseStub {

  public EsServiceStub() {
    super(EsServiceVariable.serviceKey);
  }

  public void  reqOrderInsert(EsInputOrderField esInputOrderField) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    reqOrderInsert(esInputOrderField, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  reqOrderInsert(EsInputOrderField esInputOrderField,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqOrderInsert").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new EsService.Client(protocol).reqOrderInsert(platformArgs, esInputOrderField);
      return null;
      }
    }, invokeInfo);
  }

  public void  reqOrderInsert(int routeKey, int timeout,EsInputOrderField esInputOrderField)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    reqOrderInsert(esInputOrderField, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  reqOrderAction(EsInputOrderActionField esInputOrderActionField) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    reqOrderAction(esInputOrderActionField, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  reqOrderAction(EsInputOrderActionField esInputOrderActionField,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqOrderAction").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new EsService.Client(protocol).reqOrderAction(platformArgs, esInputOrderActionField);
      return null;
      }
    }, invokeInfo);
  }

  public void  reqOrderAction(int routeKey, int timeout,EsInputOrderActionField esInputOrderActionField)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    reqOrderAction(esInputOrderActionField, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqOrdersRsp  reqOrders(ReqOrdersOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrders(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqOrdersRsp  reqOrders(ReqOrdersOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqOrders").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<ReqOrdersRsp>(){
    @Override
    public ReqOrdersRsp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new EsService.Client(protocol).reqOrders(platformArgs, option);
      }
    }, invokeInfo);
  }

  public ReqOrdersRsp  reqOrders(int routeKey, int timeout,ReqOrdersOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqOrders(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqTradesRsp  reqTrades(ReqTradesOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqTrades(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqTradesRsp  reqTrades(ReqTradesOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqTrades").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<ReqTradesRsp>(){
    @Override
    public ReqTradesRsp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new EsService.Client(protocol).reqTrades(platformArgs, option);
      }
    }, invokeInfo);
  }

  public ReqTradesRsp  reqTrades(int routeKey, int timeout,ReqTradesOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqTrades(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqEsInstrumentsRsp  reqInstruments(ReqEsInstrumentsOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInstruments(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqEsInstrumentsRsp  reqInstruments(ReqEsInstrumentsOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqInstruments").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<ReqEsInstrumentsRsp>(){
    @Override
    public ReqEsInstrumentsRsp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new EsService.Client(protocol).reqInstruments(platformArgs, option);
      }
    }, invokeInfo);
  }

  public ReqEsInstrumentsRsp  reqInstruments(int routeKey, int timeout,ReqEsInstrumentsOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqInstruments(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqEsProductRsp  reqProducts(ReqEsProductOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqProducts(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqEsProductRsp  reqProducts(ReqEsProductOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqProducts").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<ReqEsProductRsp>(){
    @Override
    public ReqEsProductRsp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new EsService.Client(protocol).reqProducts(platformArgs, option);
      }
    }, invokeInfo);
  }

  public ReqEsProductRsp  reqProducts(int routeKey, int timeout,ReqEsProductOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqProducts(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqEsClientCountRentsRsp  reqClientCountRents(ReqEsClientCountRentsOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqClientCountRents(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqEsClientCountRentsRsp  reqClientCountRents(ReqEsClientCountRentsOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqClientCountRents").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<ReqEsClientCountRentsRsp>(){
    @Override
    public ReqEsClientCountRentsRsp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new EsService.Client(protocol).reqClientCountRents(platformArgs, option);
      }
    }, invokeInfo);
  }

  public ReqEsClientCountRentsRsp  reqClientCountRents(int routeKey, int timeout,ReqEsClientCountRentsOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqClientCountRents(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<EsAccount>  reqEsAccount() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqEsAccount(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<EsAccount>  reqEsAccount(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqEsAccount").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<EsAccount>>(){
    @Override
    public List<EsAccount> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new EsService.Client(protocol).reqEsAccount(platformArgs);
      }
    }, invokeInfo);
  }

  public List<EsAccount>  reqEsAccount(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqEsAccount(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateEsAccount(EsAccount esAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateEsAccount(esAccount, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateEsAccount(EsAccount esAccount,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateEsAccount").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new EsService.Client(protocol).updateEsAccount(platformArgs, esAccount);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateEsAccount(int routeKey, int timeout,EsAccount esAccount)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateEsAccount(esAccount, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
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
      new EsService.Client(protocol).reqLogin(platformArgs);
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
      new EsService.Client(protocol).reqLogout(platformArgs);
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
      new EsService.Client(protocol).reqRelogin(platformArgs);
      return null;
      }
    }, invokeInfo);
  }

  public void  reqRelogin(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    reqRelogin(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public EsLoginStatus  reqLoginStatus() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqLoginStatus(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public EsLoginStatus  reqLoginStatus(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqLoginStatus").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<EsLoginStatus>(){
    @Override
    public EsLoginStatus call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new EsService.Client(protocol).reqLoginStatus(platformArgs);
      }
    }, invokeInfo);
  }

  public EsLoginStatus  reqLoginStatus(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqLoginStatus(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqEsHoldsRsp  reqEsHolds(ReqEsHoldsOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqEsHolds(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqEsHoldsRsp  reqEsHolds(ReqEsHoldsOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqEsHolds").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<ReqEsHoldsRsp>(){
    @Override
    public ReqEsHoldsRsp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new EsService.Client(protocol).reqEsHolds(platformArgs, option);
      }
    }, invokeInfo);
  }

  public ReqEsHoldsRsp  reqEsHolds(int routeKey, int timeout,ReqEsHoldsOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqEsHolds(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqEsMoneyRsp  reqEsMoney(ReqEsMoneyOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqEsMoney(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public ReqEsMoneyRsp  reqEsMoney(ReqEsMoneyOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqEsMoney").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<ReqEsMoneyRsp>(){
    @Override
    public ReqEsMoneyRsp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new EsService.Client(protocol).reqEsMoney(platformArgs, option);
      }
    }, invokeInfo);
  }

  public ReqEsMoneyRsp  reqEsMoney(int routeKey, int timeout,ReqEsMoneyOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqEsMoney(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  test1() throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    test1(new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  test1(TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("test1").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new EsService.Client(protocol).test1(platformArgs);
      return null;
      }
    }, invokeInfo);
  }

  public void  test1(int routeKey, int timeout)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    test1(new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<String>  test2(int intParam, String strParam) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return test2(intParam, strParam, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public List<String>  test2(int intParam, String strParam,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("test2").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<List<String>>(){
    @Override
    public List<String> call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new EsService.Client(protocol).test2(platformArgs, intParam, strParam);
      }
    }, invokeInfo);
  }

  public List<String>  test2(int routeKey, int timeout,int intParam, String strParam)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return test2(intParam, strParam, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public EsInstrument  test3(int intParam, String strParam) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return test3(intParam, strParam, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public EsInstrument  test3(int intParam, String strParam,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("test3").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<EsInstrument>(){
    @Override
    public EsInstrument call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new EsService.Client(protocol).test3(platformArgs, intParam, strParam);
      }
    }, invokeInfo);
  }

  public EsInstrument  test3(int routeKey, int timeout,int intParam, String strParam)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return test3(intParam, strParam, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
