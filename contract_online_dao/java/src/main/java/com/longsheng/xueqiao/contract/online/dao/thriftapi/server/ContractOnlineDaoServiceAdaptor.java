package com.longsheng.xueqiao.contract.online.dao.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.Map;
import java.util.HashMap;
import com.longsheng.xueqiao.contract.online.dao.thriftapi.ContractOnlineDaoService;
import com.longsheng.xueqiao.contract.online.dao.thriftapi.ContractOnlineDaoServiceVariable;


public abstract class ContractOnlineDaoServiceAdaptor implements ContractOnlineDaoService.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public com.longsheng.xueqiao.contract.standard.thriftapi.SledContractPage reqSledContract(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"reqSledContract",platformArgs);
    return reqSledContract(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.standard.thriftapi.SledContractPage reqSledContract(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.standard.thriftapi.SledContractDetailsPage reqSledContractDetail(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractDetailsOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"reqSledContractDetail",platformArgs);
    return reqSledContractDetail(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.standard.thriftapi.SledContractDetailsPage reqSledContractDetail(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractDetailsOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMappingPage reqCommodityMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.ReqCommodityMappingOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"reqCommodityMapping",platformArgs);
    return reqCommodityMapping(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMappingPage reqCommodityMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqCommodityMappingOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage reqSledExchange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"reqSledExchange",platformArgs);
    return reqSledExchange(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage reqSledExchange(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityPage reqSledCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"reqSledCommodity",platformArgs);
    return reqSledCommodity(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityPage reqSledCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.ContractVersionPage reqContractVersion(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqContractVersionOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"reqContractVersion",platformArgs);
    return reqContractVersion(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.ContractVersionPage reqContractVersion(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqContractVersionOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateContractVersion(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ContractVersion contractVersion) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"updateContractVersion",platformArgs);
updateContractVersion(oCntl, contractVersion);
  }

  protected abstract void updateContractVersion(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ContractVersion contractVersion) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeContractVersion(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int versionId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"removeContractVersion",platformArgs);
removeContractVersion(oCntl, versionId);
  }

  protected abstract void removeContractVersion(TServiceCntl oCntl, int versionId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addDbLocking(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo dbLockingInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"addDbLocking",platformArgs);
addDbLocking(oCntl, dbLockingInfo);
  }

  protected abstract void addDbLocking(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo dbLockingInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeDbLocking(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String lockedBy) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"removeDbLocking",platformArgs);
removeDbLocking(oCntl, lockedBy);
  }

  protected abstract void removeDbLocking(TServiceCntl oCntl, String lockedBy) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo reqDbLockingInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"reqDbLockingInfo",platformArgs);
    return reqDbLockingInfo(oCntl);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo reqDbLockingInfo(TServiceCntl oCntl) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledTradeTimePage reqSledTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractOnlineDaoServiceVariable.serviceKey,"reqSledTradeTime",platformArgs);
    return reqSledTradeTime(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledTradeTimePage reqSledTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected ContractOnlineDaoServiceAdaptor(){
    methodParameterNameMap.put("reqSledContract",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqSledContractDetail",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqCommodityMapping",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqSledExchange",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqSledCommodity",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqContractVersion",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("updateContractVersion",new String[]{"platformArgs", "contractVersion"});
    methodParameterNameMap.put("removeContractVersion",new String[]{"platformArgs", "versionId"});
    methodParameterNameMap.put("addDbLocking",new String[]{"platformArgs", "dbLockingInfo"});
    methodParameterNameMap.put("removeDbLocking",new String[]{"platformArgs", "lockedBy"});
    methodParameterNameMap.put("reqDbLockingInfo",new String[]{"platformArgs"});
    methodParameterNameMap.put("reqSledTradeTime",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
