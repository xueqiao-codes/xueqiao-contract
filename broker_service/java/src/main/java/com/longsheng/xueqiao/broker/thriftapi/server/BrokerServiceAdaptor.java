package com.longsheng.xueqiao.broker.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.Map;
import java.util.HashMap;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessInfoPage;
import com.longsheng.xueqiao.broker.thriftapi.BrokerAccessPage;
import com.longsheng.xueqiao.broker.thriftapi.BrokerPage;
import com.longsheng.xueqiao.broker.thriftapi.ReqBrokerAccessInfoOption;
import com.longsheng.xueqiao.broker.thriftapi.ReqBrokerAccessOption;
import com.longsheng.xueqiao.broker.thriftapi.ReqBrokerOption;
import com.longsheng.xueqiao.broker.thriftapi.BrokerService;
import com.longsheng.xueqiao.broker.thriftapi.BrokerServiceVariable;


public abstract class BrokerServiceAdaptor implements BrokerService.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public BrokerPage reqBroker(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqBrokerOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerServiceVariable.serviceKey,"reqBroker",platformArgs);
    return reqBroker(oCntl, option, pageIndex, pageSize);
  }

  protected abstract BrokerPage reqBroker(TServiceCntl oCntl, ReqBrokerOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public BrokerAccessPage reqBrokerAccess(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqBrokerAccessOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerServiceVariable.serviceKey,"reqBrokerAccess",platformArgs);
    return reqBrokerAccess(oCntl, option, pageIndex, pageSize);
  }

  protected abstract BrokerAccessPage reqBrokerAccess(TServiceCntl oCntl, ReqBrokerAccessOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public BrokerAccessInfoPage reqBrokerAccessInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqBrokerAccessInfoOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(BrokerServiceVariable.serviceKey,"reqBrokerAccessInfo",platformArgs);
    return reqBrokerAccessInfo(oCntl, option, pageIndex, pageSize);
  }

  protected abstract BrokerAccessInfoPage reqBrokerAccessInfo(TServiceCntl oCntl, ReqBrokerAccessInfoOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected BrokerServiceAdaptor(){
    methodParameterNameMap.put("reqBroker",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqBrokerAccess",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqBrokerAccessInfo",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
