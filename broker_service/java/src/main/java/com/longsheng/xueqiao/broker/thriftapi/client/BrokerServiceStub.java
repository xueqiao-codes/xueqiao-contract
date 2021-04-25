package com.longsheng.xueqiao.broker.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessInfoPage;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessPage;
import com.longsheng.xueqiao.broker.thriftapi.BrokerPage;
import com.longsheng.xueqiao.broker.thriftapi.ReqBrokerAccessInfoOption;
import com.longsheng.xueqiao.broker.thriftapi.ReqBrokerAccessOption;
import com.longsheng.xueqiao.broker.thriftapi.ReqBrokerOption;
import com.longsheng.xueqiao.broker.thriftapi.BrokerService;
import com.longsheng.xueqiao.broker.thriftapi.BrokerServiceVariable;

public class BrokerServiceStub extends BaseStub {

  public BrokerServiceStub() {
    super(BrokerServiceVariable.serviceKey);
  }

  public BrokerPage  reqBroker(ReqBrokerOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBroker(option, pageIndex, pageSize, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public BrokerPage  reqBroker(ReqBrokerOption option, int pageIndex, int pageSize,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqBroker").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<BrokerPage>(){
    @Override
    public BrokerPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerService.Client(protocol).reqBroker(platformArgs, option, pageIndex, pageSize);
      }
    }, invokeInfo);
  }

  public BrokerPage  reqBroker(int routeKey, int timeout,ReqBrokerOption option, int pageIndex, int pageSize)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBroker(option, pageIndex, pageSize, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public BrokerAccessPage  reqBrokerAccess(ReqBrokerAccessOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBrokerAccess(option, pageIndex, pageSize, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public BrokerAccessPage  reqBrokerAccess(ReqBrokerAccessOption option, int pageIndex, int pageSize,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqBrokerAccess").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<BrokerAccessPage>(){
    @Override
    public BrokerAccessPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerService.Client(protocol).reqBrokerAccess(platformArgs, option, pageIndex, pageSize);
      }
    }, invokeInfo);
  }

  public BrokerAccessPage  reqBrokerAccess(int routeKey, int timeout,ReqBrokerAccessOption option, int pageIndex, int pageSize)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBrokerAccess(option, pageIndex, pageSize, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public BrokerAccessInfoPage  reqBrokerAccessInfo(ReqBrokerAccessInfoOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBrokerAccessInfo(option, pageIndex, pageSize, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public BrokerAccessInfoPage  reqBrokerAccessInfo(ReqBrokerAccessInfoOption option, int pageIndex, int pageSize,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqBrokerAccessInfo").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<BrokerAccessInfoPage>(){
    @Override
    public BrokerAccessInfoPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerService.Client(protocol).reqBrokerAccessInfo(platformArgs, option, pageIndex, pageSize);
      }
    }, invokeInfo);
  }

  public BrokerAccessInfoPage  reqBrokerAccessInfo(int routeKey, int timeout,ReqBrokerAccessInfoOption option, int pageIndex, int pageSize)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBrokerAccessInfo(option, pageIndex, pageSize, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
