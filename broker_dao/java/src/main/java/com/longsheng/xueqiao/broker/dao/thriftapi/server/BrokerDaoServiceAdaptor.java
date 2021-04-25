package com.longsheng.xueqiao.broker.dao.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.Map;
import java.util.HashMap;
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


public abstract class BrokerDaoServiceAdaptor implements BrokerDaoService.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public int addBrokerEntry(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerDaoServiceVariable.serviceKey,"addBrokerEntry",platformArgs);
    return addBrokerEntry(oCntl, brokerEntry);
  }

  protected abstract int addBrokerEntry(TServiceCntl oCntl, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateBrokerEntry(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerDaoServiceVariable.serviceKey,"updateBrokerEntry",platformArgs);
updateBrokerEntry(oCntl, brokerEntry);
  }

  protected abstract void updateBrokerEntry(TServiceCntl oCntl, com.longsheng.xueqiao.broker.thriftapi.BrokerEntry brokerEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public BrokerEntryPage reqBrokerEntry(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqBrokerEntryOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerDaoServiceVariable.serviceKey,"reqBrokerEntry",platformArgs);
    return reqBrokerEntry(oCntl, option, pageIndex, pageSize);
  }

  protected abstract BrokerEntryPage reqBrokerEntry(TServiceCntl oCntl, ReqBrokerEntryOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public int addBrokerAccessEntry(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerDaoServiceVariable.serviceKey,"addBrokerAccessEntry",platformArgs);
    return addBrokerAccessEntry(oCntl, brokerAccessEntry);
  }

  protected abstract int addBrokerAccessEntry(TServiceCntl oCntl, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateBrokerAccessEntry(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerDaoServiceVariable.serviceKey,"updateBrokerAccessEntry",platformArgs);
updateBrokerAccessEntry(oCntl, brokerAccessEntry);
  }

  protected abstract void updateBrokerAccessEntry(TServiceCntl oCntl, com.longsheng.xueqiao.broker.thriftapi.BrokerAccessEntry brokerAccessEntry) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public BrokerAccessEntryPage reqBrokerAccessEntry(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqBrokerAccessEntryOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerDaoServiceVariable.serviceKey,"reqBrokerAccessEntry",platformArgs);
    return reqBrokerAccessEntry(oCntl, option, pageIndex, pageSize);
  }

  protected abstract BrokerAccessEntryPage reqBrokerAccessEntry(TServiceCntl oCntl, ReqBrokerAccessEntryOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public WorkingBrokerAccessEntryResp reqWorkingBrokerAccessEntry(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int brokerAccessEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerDaoServiceVariable.serviceKey,"reqWorkingBrokerAccessEntry",platformArgs);
    return reqWorkingBrokerAccessEntry(oCntl, brokerAccessEntryId);
  }

  protected abstract WorkingBrokerAccessEntryResp reqWorkingBrokerAccessEntry(TServiceCntl oCntl, int brokerAccessEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public WorkingBrokerAccessEntryResp syncBrokerAccessEntry(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int brokerAccessEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerDaoServiceVariable.serviceKey,"syncBrokerAccessEntry",platformArgs);
    return syncBrokerAccessEntry(oCntl, brokerAccessEntryId);
  }

  protected abstract WorkingBrokerAccessEntryResp syncBrokerAccessEntry(TServiceCntl oCntl, int brokerAccessEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public RemoveBrokerAccessEntryResp removeBrokerAccessEntry(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int brokerAccessEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerDaoServiceVariable.serviceKey,"removeBrokerAccessEntry",platformArgs);
    return removeBrokerAccessEntry(oCntl, brokerAccessEntryId);
  }

  protected abstract RemoveBrokerAccessEntryResp removeBrokerAccessEntry(TServiceCntl oCntl, int brokerAccessEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public RemoveBrokerEntryResp removeBrokerEntry(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int brokerEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerDaoServiceVariable.serviceKey,"removeBrokerEntry",platformArgs);
    return removeBrokerEntry(oCntl, brokerEntryId);
  }

  protected abstract RemoveBrokerEntryResp removeBrokerEntry(TServiceCntl oCntl, int brokerEntryId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public SyncBrokerResp syncBroker(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, SyncBrokerOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerDaoServiceVariable.serviceKey,"syncBroker",platformArgs);
    return syncBroker(oCntl, option);
  }

  protected abstract SyncBrokerResp syncBroker(TServiceCntl oCntl, SyncBrokerOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected BrokerDaoServiceAdaptor(){
    methodParameterNameMap.put("addBrokerEntry",new String[]{"platformArgs", "brokerEntry"});
    methodParameterNameMap.put("updateBrokerEntry",new String[]{"platformArgs", "brokerEntry"});
    methodParameterNameMap.put("reqBrokerEntry",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("addBrokerAccessEntry",new String[]{"platformArgs", "brokerAccessEntry"});
    methodParameterNameMap.put("updateBrokerAccessEntry",new String[]{"platformArgs", "brokerAccessEntry"});
    methodParameterNameMap.put("reqBrokerAccessEntry",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqWorkingBrokerAccessEntry",new String[]{"platformArgs", "brokerAccessEntryId"});
    methodParameterNameMap.put("syncBrokerAccessEntry",new String[]{"platformArgs", "brokerAccessEntryId"});
    methodParameterNameMap.put("removeBrokerAccessEntry",new String[]{"platformArgs", "brokerAccessEntryId"});
    methodParameterNameMap.put("removeBrokerEntry",new String[]{"platformArgs", "brokerEntryId"});
    methodParameterNameMap.put("syncBroker",new String[]{"platformArgs", "option"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
