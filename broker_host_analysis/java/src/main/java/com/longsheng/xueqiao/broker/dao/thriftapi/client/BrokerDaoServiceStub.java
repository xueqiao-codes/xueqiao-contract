package com.longsheng.xueqiao.broker.dao.thriftapi.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.soldier.platform.svr_platform.client.BaseStub;
import org.soldier.platform.svr_platform.client.TStubOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.comm.PlatformArgs;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerAccessEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerEntryPage;
import com.longsheng.xueqiao.broker.dao.thriftapi.RemoveBrokerAccessEntryResp;
import com.longsheng.xueqiao.broker.dao.thriftapi.RemoveBrokerEntryResp;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.SyncBrokerOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.SyncBrokerResp;
import com.longsheng.xueqiao.broker.dao.thriftapi.WorkingBrokerAccessEntryResp;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerDaoService;
import com.longsheng.xueqiao.broker.dao.thriftapi.BrokerDaoServiceVariable;

public class BrokerDaoServiceStub extends BaseStub {

  public BrokerDaoServiceStub() {
    super(BrokerDaoServiceVariable.serviceKey);
  }

  public int  addBrokerEntry(com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addBrokerEntry(brokerEntry, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  addBrokerEntry(com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addBrokerEntry").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Integer>(){
    @Override
    public Integer call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerDaoService.Client(protocol).addBrokerEntry(platformArgs, brokerEntry);
      }
    }, invokeInfo);
  }

  public int  addBrokerEntry(int routeKey, int timeout,com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addBrokerEntry(brokerEntry, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateBrokerEntry(com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateBrokerEntry(brokerEntry, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateBrokerEntry(com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateBrokerEntry").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new BrokerDaoService.Client(protocol).updateBrokerEntry(platformArgs, brokerEntry);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateBrokerEntry(int routeKey, int timeout,com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateBrokerEntry(brokerEntry, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public BrokerEntryPage  reqBrokerEntry(ReqBrokerEntryOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBrokerEntry(option, pageIndex, pageSize, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public BrokerEntryPage  reqBrokerEntry(ReqBrokerEntryOption option, int pageIndex, int pageSize,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqBrokerEntry").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<BrokerEntryPage>(){
    @Override
    public BrokerEntryPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerDaoService.Client(protocol).reqBrokerEntry(platformArgs, option, pageIndex, pageSize);
      }
    }, invokeInfo);
  }

  public BrokerEntryPage  reqBrokerEntry(int routeKey, int timeout,ReqBrokerEntryOption option, int pageIndex, int pageSize)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBrokerEntry(option, pageIndex, pageSize, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  addBrokerAccessEntry(com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addBrokerAccessEntry(brokerAccessEntry, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public int  addBrokerAccessEntry(com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("addBrokerAccessEntry").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<Integer>(){
    @Override
    public Integer call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerDaoService.Client(protocol).addBrokerAccessEntry(platformArgs, brokerAccessEntry);
      }
    }, invokeInfo);
  }

  public int  addBrokerAccessEntry(int routeKey, int timeout,com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return addBrokerAccessEntry(brokerAccessEntry, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateBrokerAccessEntry(com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateBrokerAccessEntry(brokerAccessEntry, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public void  updateBrokerAccessEntry(com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("updateBrokerAccessEntry").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    super.runSync(new ThriftCallable<Void>(){
    @Override
    public Void call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      new BrokerDaoService.Client(protocol).updateBrokerAccessEntry(platformArgs, brokerAccessEntry);
      return null;
      }
    }, invokeInfo);
  }

  public void  updateBrokerAccessEntry(int routeKey, int timeout,com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    updateBrokerAccessEntry(brokerAccessEntry, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public BrokerAccessEntryPage  reqBrokerAccessEntry(ReqBrokerAccessEntryOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBrokerAccessEntry(option, pageIndex, pageSize, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public BrokerAccessEntryPage  reqBrokerAccessEntry(ReqBrokerAccessEntryOption option, int pageIndex, int pageSize,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqBrokerAccessEntry").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<BrokerAccessEntryPage>(){
    @Override
    public BrokerAccessEntryPage call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerDaoService.Client(protocol).reqBrokerAccessEntry(platformArgs, option, pageIndex, pageSize);
      }
    }, invokeInfo);
  }

  public BrokerAccessEntryPage  reqBrokerAccessEntry(int routeKey, int timeout,ReqBrokerAccessEntryOption option, int pageIndex, int pageSize)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqBrokerAccessEntry(option, pageIndex, pageSize, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public WorkingBrokerAccessEntryResp  reqWorkingBrokerAccessEntry(int brokerAccessEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqWorkingBrokerAccessEntry(brokerAccessEntryId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public WorkingBrokerAccessEntryResp  reqWorkingBrokerAccessEntry(int brokerAccessEntryId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("reqWorkingBrokerAccessEntry").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<WorkingBrokerAccessEntryResp>(){
    @Override
    public WorkingBrokerAccessEntryResp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerDaoService.Client(protocol).reqWorkingBrokerAccessEntry(platformArgs, brokerAccessEntryId);
      }
    }, invokeInfo);
  }

  public WorkingBrokerAccessEntryResp  reqWorkingBrokerAccessEntry(int routeKey, int timeout,int brokerAccessEntryId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return reqWorkingBrokerAccessEntry(brokerAccessEntryId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public WorkingBrokerAccessEntryResp  syncBrokerAccessEntry(int brokerAccessEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return syncBrokerAccessEntry(brokerAccessEntryId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public WorkingBrokerAccessEntryResp  syncBrokerAccessEntry(int brokerAccessEntryId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("syncBrokerAccessEntry").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<WorkingBrokerAccessEntryResp>(){
    @Override
    public WorkingBrokerAccessEntryResp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerDaoService.Client(protocol).syncBrokerAccessEntry(platformArgs, brokerAccessEntryId);
      }
    }, invokeInfo);
  }

  public WorkingBrokerAccessEntryResp  syncBrokerAccessEntry(int routeKey, int timeout,int brokerAccessEntryId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return syncBrokerAccessEntry(brokerAccessEntryId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public RemoveBrokerAccessEntryResp  removeBrokerAccessEntry(int brokerAccessEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return removeBrokerAccessEntry(brokerAccessEntryId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public RemoveBrokerAccessEntryResp  removeBrokerAccessEntry(int brokerAccessEntryId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("removeBrokerAccessEntry").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<RemoveBrokerAccessEntryResp>(){
    @Override
    public RemoveBrokerAccessEntryResp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerDaoService.Client(protocol).removeBrokerAccessEntry(platformArgs, brokerAccessEntryId);
      }
    }, invokeInfo);
  }

  public RemoveBrokerAccessEntryResp  removeBrokerAccessEntry(int routeKey, int timeout,int brokerAccessEntryId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return removeBrokerAccessEntry(brokerAccessEntryId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public RemoveBrokerEntryResp  removeBrokerEntry(int brokerEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return removeBrokerEntry(brokerEntryId, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public RemoveBrokerEntryResp  removeBrokerEntry(int brokerEntryId,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("removeBrokerEntry").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<RemoveBrokerEntryResp>(){
    @Override
    public RemoveBrokerEntryResp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerDaoService.Client(protocol).removeBrokerEntry(platformArgs, brokerEntryId);
      }
    }, invokeInfo);
  }

  public RemoveBrokerEntryResp  removeBrokerEntry(int routeKey, int timeout,int brokerEntryId)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return removeBrokerEntry(brokerEntryId, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public SyncBrokerResp  syncBroker(SyncBrokerOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return syncBroker(option, new TStubOption().setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

  public SyncBrokerResp  syncBroker(SyncBrokerOption option,TStubOption platformStubOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException {
    InvokeMethodInfo invokeInfo = new InvokeMethodInfo("syncBroker").setRouteKey(platformStubOption.getRouteKey()).setTimeoutMs(platformStubOption.getTimeoutMs());
    if (platformStubOption.getCallTrace() != null) { 
      invokeInfo.setSourceCallTrace(platformStubOption.getCallTrace());
    } else {
      invokeInfo.setSourceCallTrace(Thread.currentThread().getStackTrace()[2]);
    }
    return super.runSync(new ThriftCallable<SyncBrokerResp>(){
    @Override
    public SyncBrokerResp call(TProtocol protocol, PlatformArgs platformArgs) throws ErrorInfo, TException {
      return new BrokerDaoService.Client(protocol).syncBroker(platformArgs, option);
      }
    }, invokeInfo);
  }

  public SyncBrokerResp  syncBroker(int routeKey, int timeout,SyncBrokerOption option)throws org.soldier.platform.svr_platform.comm.ErrorInfo, TException{
    return syncBroker(option, new TStubOption().setRouteKey(routeKey).setTimeoutMs(timeout).setCallTrace(Thread.currentThread().getStackTrace()[2]));
  }

}
