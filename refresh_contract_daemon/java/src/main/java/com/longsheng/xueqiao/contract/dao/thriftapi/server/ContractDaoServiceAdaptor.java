package com.longsheng.xueqiao.contract.dao.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.longsheng.xueqiao.contract.dao.thriftapi.RemoveSledCommodityOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.RemoveSledExchangeOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTCommodityMapOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledCommodityChangeOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledCommodityOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledContractOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledExchangeOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityMap;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityMapPage;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityPage;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledCommodity;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledCommodityChange;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledCommodityChangePage;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContract;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContractPage;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledExchange;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledExchangePage;
import com.longsheng.xueqiao.contract.dao.thriftapi.ContractDaoService;
import com.longsheng.xueqiao.contract.dao.thriftapi.ContractDaoServiceVariable;


public abstract class ContractDaoServiceAdaptor implements ContractDaoService.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public int addTSledCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, TSledCommodity tSledCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addTSledCommodity",platformArgs);
    return addTSledCommodity(oCntl, tSledCommodity);
  }

  protected abstract int addTSledCommodity(TServiceCntl oCntl, TSledCommodity tSledCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public int updateTSledCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, TSledCommodity tSledCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateTSledCommodity",platformArgs);
    return updateTSledCommodity(oCntl, tSledCommodity);
  }

  protected abstract int updateTSledCommodity(TServiceCntl oCntl, TSledCommodity tSledCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public TCommodityPage reqTSledCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqTSledCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqTSledCommodity",platformArgs);
    return reqTSledCommodity(oCntl, option, pageIndex, pageSize);
  }

  protected abstract TCommodityPage reqTSledCommodity(TServiceCntl oCntl, ReqTSledCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public int addTSledContract(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, TSledContract tSledContract) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addTSledContract",platformArgs);
    return addTSledContract(oCntl, tSledContract);
  }

  protected abstract int addTSledContract(TServiceCntl oCntl, TSledContract tSledContract) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public int updateTSledContract(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, TSledContract tSledContract) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateTSledContract",platformArgs);
    return updateTSledContract(oCntl, tSledContract);
  }

  protected abstract int updateTSledContract(TServiceCntl oCntl, TSledContract tSledContract) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public TSledContractPage reqTSledContract(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqTSledContractOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqTSledContract",platformArgs);
    return reqTSledContract(oCntl, option, pageIndex, pageSize);
  }

  protected abstract TSledContractPage reqTSledContract(TServiceCntl oCntl, ReqTSledContractOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public int addTSledExchange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, TSledExchange tSledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addTSledExchange",platformArgs);
    return addTSledExchange(oCntl, tSledExchange);
  }

  protected abstract int addTSledExchange(TServiceCntl oCntl, TSledExchange tSledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public int updateTSledExchange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, TSledExchange tSledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateTSledExchange",platformArgs);
    return updateTSledExchange(oCntl, tSledExchange);
  }

  protected abstract int updateTSledExchange(TServiceCntl oCntl, TSledExchange tSledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public TSledExchangePage reqTSledExchange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqTSledExchangeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqTSledExchange",platformArgs);
    return reqTSledExchange(oCntl, option, pageIndex, pageSize);
  }

  protected abstract TSledExchangePage reqTSledExchange(TServiceCntl oCntl, ReqTSledExchangeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public TCommodityMapPage reqTCommodityMap(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqTCommodityMapOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqTCommodityMap",platformArgs);
    return reqTCommodityMap(oCntl, option, pageIndex, pageSize);
  }

  protected abstract TCommodityMapPage reqTCommodityMap(TServiceCntl oCntl, ReqTCommodityMapOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addTCommodityMap(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, TCommodityMap tCommodityMap) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addTCommodityMap",platformArgs);
addTCommodityMap(oCntl, tCommodityMap);
  }

  protected abstract void addTCommodityMap(TServiceCntl oCntl, TCommodityMap tCommodityMap) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addSledExchangeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping sledExchangeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addSledExchangeMapping",platformArgs);
addSledExchangeMapping(oCntl, sledExchangeMapping);
  }

  protected abstract void addSledExchangeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping sledExchangeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateSledExchangeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping sledExchangeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateSledExchangeMapping",platformArgs);
updateSledExchangeMapping(oCntl, sledExchangeMapping);
  }

  protected abstract void updateSledExchangeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping sledExchangeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledExchangeMappingPage reqSledExchangeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSledExchangeMappingOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqSledExchangeMapping",platformArgs);
    return reqSledExchangeMapping(oCntl, option);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledExchangeMappingPage reqSledExchangeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSledExchangeMappingOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addSledCommodityTypeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping sledCommodityTypeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addSledCommodityTypeMapping",platformArgs);
addSledCommodityTypeMapping(oCntl, sledCommodityTypeMapping);
  }

  protected abstract void addSledCommodityTypeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping sledCommodityTypeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateSledCommodityTypeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping sledCommodityTypeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateSledCommodityTypeMapping",platformArgs);
updateSledCommodityTypeMapping(oCntl, sledCommodityTypeMapping);
  }

  protected abstract void updateSledCommodityTypeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping sledCommodityTypeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMappingPage reqSledCommodityTypeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSledCommodityTypeMappingOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqSledCommodityTypeMapping",platformArgs);
    return reqSledCommodityTypeMapping(oCntl, option);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMappingPage reqSledCommodityTypeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSledCommodityTypeMappingOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public int updateTCommodityMap(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, TCommodityMap tCommodityMap) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateTCommodityMap",platformArgs);
    return updateTCommodityMap(oCntl, tCommodityMap);
  }

  protected abstract int updateTCommodityMap(TServiceCntl oCntl, TCommodityMap tCommodityMap) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public boolean inactiveExpiredSledContract(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long expiredTimestamp) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"inactiveExpiredSledContract",platformArgs);
    return inactiveExpiredSledContract(oCntl, expiredTimestamp);
  }

  protected abstract boolean inactiveExpiredSledContract(TServiceCntl oCntl, long expiredTimestamp) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public TSledCommodityChangePage reqTSledCommodityChange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqTSledCommodityChangeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqTSledCommodityChange",platformArgs);
    return reqTSledCommodityChange(oCntl, option, pageIndex, pageSize);
  }

  protected abstract TSledCommodityChangePage reqTSledCommodityChange(TServiceCntl oCntl, ReqTSledCommodityChangeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public int addTSledCommodityChange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, TSledCommodityChange tCommodityChange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addTSledCommodityChange",platformArgs);
    return addTSledCommodityChange(oCntl, tCommodityChange);
  }

  protected abstract int addTSledCommodityChange(TServiceCntl oCntl, TSledCommodityChange tCommodityChange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public boolean removeTSledCommodityChange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, TSledCommodityChange tCommodityChange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"removeTSledCommodityChange",platformArgs);
    return removeTSledCommodityChange(oCntl, tCommodityChange);
  }

  protected abstract boolean removeTSledCommodityChange(TServiceCntl oCntl, TSledCommodityChange tCommodityChange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addCommodityMapFileInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo mapFileInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addCommodityMapFileInfo",platformArgs);
addCommodityMapFileInfo(oCntl, mapFileInfo);
  }

  protected abstract void addCommodityMapFileInfo(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo mapFileInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateCommodityMapFileInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo mapFileInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateCommodityMapFileInfo",platformArgs);
updateCommodityMapFileInfo(oCntl, mapFileInfo);
  }

  protected abstract void updateCommodityMapFileInfo(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo mapFileInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfoPage reqCommodityMapFileInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqCommodityMapFileInfo",platformArgs);
    return reqCommodityMapFileInfo(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfoPage reqCommodityMapFileInfo(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SyncMappingTaskPage reqSyncMappingTask(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSyncMappingTaskOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqSyncMappingTask",platformArgs);
    return reqSyncMappingTask(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SyncMappingTaskPage reqSyncMappingTask(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSyncMappingTaskOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addSyncMappingTask(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SyncMappingTask tTask) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addSyncMappingTask",platformArgs);
addSyncMappingTask(oCntl, tTask);
  }

  protected abstract void addSyncMappingTask(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SyncMappingTask tTask) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeSyncMappingTask(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSyncMappingTaskOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"removeSyncMappingTask",platformArgs);
removeSyncMappingTask(oCntl, option);
  }

  protected abstract void removeSyncMappingTask(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSyncMappingTaskOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addTechPlatformCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity techPlatformCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addTechPlatformCommodity",platformArgs);
addTechPlatformCommodity(oCntl, techPlatformCommodity);
  }

  protected abstract void addTechPlatformCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity techPlatformCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodityPage reqTechPlatformCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqTechPlatformCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqTechPlatformCommodity",platformArgs);
    return reqTechPlatformCommodity(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodityPage reqTechPlatformCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqTechPlatformCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeSledCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, RemoveSledCommodityOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"removeSledCommodity",platformArgs);
removeSledCommodity(oCntl, removeOption);
  }

  protected abstract void removeSledCommodity(TServiceCntl oCntl, RemoveSledCommodityOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeSledExchange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, RemoveSledExchangeOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"removeSledExchange",platformArgs);
removeSledExchange(oCntl, removeOption);
  }

  protected abstract void removeSledExchange(TServiceCntl oCntl, RemoveSledExchangeOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addContractVersion(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ContractVersion contractVersion) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addContractVersion",platformArgs);
addContractVersion(oCntl, contractVersion);
  }

  protected abstract void addContractVersion(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ContractVersion contractVersion) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeContractVersion(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.RemoveContractVersionOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"removeContractVersion",platformArgs);
removeContractVersion(oCntl, removeOption);
  }

  protected abstract void removeContractVersion(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.RemoveContractVersionOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.ContractVersionPage reqContractVersion(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqContractVersionOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqContractVersion",platformArgs);
    return reqContractVersion(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.ContractVersionPage reqContractVersion(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqContractVersionOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateContractVersion(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ContractVersion contractVersion) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateContractVersion",platformArgs);
updateContractVersion(oCntl, contractVersion);
  }

  protected abstract void updateContractVersion(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ContractVersion contractVersion) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addDbLocking(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo dbLockingInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addDbLocking",platformArgs);
addDbLocking(oCntl, dbLockingInfo);
  }

  protected abstract void addDbLocking(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo dbLockingInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeDbLocking(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String lockedBy) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"removeDbLocking",platformArgs);
removeDbLocking(oCntl, lockedBy);
  }

  protected abstract void removeDbLocking(TServiceCntl oCntl, String lockedBy) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo reqDbLockingInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqDbLockingInfo",platformArgs);
    return reqDbLockingInfo(oCntl);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo reqDbLockingInfo(TServiceCntl oCntl) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addSledTradeTimeConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig config) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addSledTradeTimeConfig",platformArgs);
addSledTradeTimeConfig(oCntl, config);
  }

  protected abstract void addSledTradeTimeConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig config) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateSledTradeTimeConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig config) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateSledTradeTimeConfig",platformArgs);
updateSledTradeTimeConfig(oCntl, config);
  }

  protected abstract void updateSledTradeTimeConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig config) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfigPage reqSledTradeTimeConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeConfigOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqSledTradeTimeConfig",platformArgs);
    return reqSledTradeTimeConfig(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfigPage reqSledTradeTimeConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeConfigOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addSpecTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SpecTradeTime specTradeTime) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addSpecTradeTime",platformArgs);
addSpecTradeTime(oCntl, specTradeTime);
  }

  protected abstract void addSpecTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SpecTradeTime specTradeTime) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateSpecTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SpecTradeTime specTradeTime) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateSpecTradeTime",platformArgs);
updateSpecTradeTime(oCntl, specTradeTime);
  }

  protected abstract void updateSpecTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SpecTradeTime specTradeTime) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SpecTradeTimePage reqSpecTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSpecTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqSpecTradeTime",platformArgs);
    return reqSpecTradeTime(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SpecTradeTimePage reqSpecTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSpecTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledCommoditySpecTradeTimePage reqSledCommoditySpecTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySpecTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqSledCommoditySpecTradeTime",platformArgs);
    return reqSledCommoditySpecTradeTime(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledCommoditySpecTradeTimePage reqSledCommoditySpecTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySpecTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledTradeTimePage reqSledTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqSledTradeTime",platformArgs);
    return reqSledTradeTime(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledTradeTimePage reqSledTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void batAddSledTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, List<com.longsheng.xueqiao.contract.thriftapi.SledTradeTime> sledTradeTimes) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"batAddSledTradeTime",platformArgs);
batAddSledTradeTime(oCntl, sledTradeTimes);
  }

  protected abstract void batAddSledTradeTime(TServiceCntl oCntl, List<com.longsheng.xueqiao.contract.thriftapi.SledTradeTime> sledTradeTimes) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addDstTransferConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.DstTransferConfig transferConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addDstTransferConfig",platformArgs);
addDstTransferConfig(oCntl, transferConfig);
  }

  protected abstract void addDstTransferConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.DstTransferConfig transferConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateDstTransferConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.DstTransferConfig transferConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateDstTransferConfig",platformArgs);
updateDstTransferConfig(oCntl, transferConfig);
  }

  protected abstract void updateDstTransferConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.DstTransferConfig transferConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.DstTransferConfigPage reqDstTransferConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqDstTransferConfigOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqDstTransferConfig",platformArgs);
    return reqDstTransferConfig(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.DstTransferConfigPage reqDstTransferConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqDstTransferConfigOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeSpecTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.RemoveSpecTradeTimeOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"removeSpecTradeTime",platformArgs);
removeSpecTradeTime(oCntl, removeOption);
  }

  protected abstract void removeSpecTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.RemoveSpecTradeTimeOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeDstTransferConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.RemoveDstTransferConfigOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"removeDstTransferConfig",platformArgs);
removeDstTransferConfig(oCntl, removeOption);
  }

  protected abstract void removeDstTransferConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.RemoveDstTransferConfigOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void batUpdateSledTradeTimeConfigs(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, List<com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig> configs) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"batUpdateSledTradeTimeConfigs",platformArgs);
batUpdateSledTradeTimeConfigs(oCntl, configs);
  }

  protected abstract void batUpdateSledTradeTimeConfigs(TServiceCntl oCntl, List<com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig> configs) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addCommoditySource(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommoditySource commoditySource) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addCommoditySource",platformArgs);
addCommoditySource(oCntl, commoditySource);
  }

  protected abstract void addCommoditySource(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySource commoditySource) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateCommoditySource(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommoditySource commoditySource) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateCommoditySource",platformArgs);
updateCommoditySource(oCntl, commoditySource);
  }

  protected abstract void updateCommoditySource(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySource commoditySource) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.CommoditySourcePage reqCommoditySource(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqCommoditySource",platformArgs);
    return reqCommoditySource(oCntl, option);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.CommoditySourcePage reqCommoditySource(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addCommoditySourceAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount commoditySourceAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addCommoditySourceAccount",platformArgs);
addCommoditySourceAccount(oCntl, commoditySourceAccount);
  }

  protected abstract void addCommoditySourceAccount(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount commoditySourceAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateCommoditySourceAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount commoditySourceAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateCommoditySourceAccount",platformArgs);
updateCommoditySourceAccount(oCntl, commoditySourceAccount);
  }

  protected abstract void updateCommoditySourceAccount(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount commoditySourceAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccountPage reqCommoditySourceAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceAccountOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqCommoditySourceAccount",platformArgs);
    return reqCommoditySourceAccount(oCntl, option);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccountPage reqCommoditySourceAccount(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceAccountOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addSledTradingSession(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledTradingSession sledTradingSession) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"addSledTradingSession",platformArgs);
addSledTradingSession(oCntl, sledTradingSession);
  }

  protected abstract void addSledTradingSession(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledTradingSession sledTradingSession) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateSledTradingSession(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledTradingSession sledTradingSession) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"updateSledTradingSession",platformArgs);
updateSledTradingSession(oCntl, sledTradingSession);
  }

  protected abstract void updateSledTradingSession(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledTradingSession sledTradingSession) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledTradingSessionPage reqSledTradingSession(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradingSessionOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"reqSledTradingSession",platformArgs);
    return reqSledTradingSession(oCntl, option, pageOption);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledTradingSessionPage reqSledTradingSession(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradingSessionOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeSledTradingSession(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long tradeSessionId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"removeSledTradingSession",platformArgs);
removeSledTradingSession(oCntl, tradeSessionId);
  }

  protected abstract void removeSledTradingSession(TServiceCntl oCntl, long tradeSessionId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void clearAllTechPlatformCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int techPlatformValue) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractDaoServiceVariable.serviceKey,"clearAllTechPlatformCommodity",platformArgs);
clearAllTechPlatformCommodity(oCntl, techPlatformValue);
  }

  protected abstract void clearAllTechPlatformCommodity(TServiceCntl oCntl, int techPlatformValue) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected ContractDaoServiceAdaptor(){
    methodParameterNameMap.put("addTSledCommodity",new String[]{"platformArgs", "tSledCommodity"});
    methodParameterNameMap.put("updateTSledCommodity",new String[]{"platformArgs", "tSledCommodity"});
    methodParameterNameMap.put("reqTSledCommodity",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("addTSledContract",new String[]{"platformArgs", "tSledContract"});
    methodParameterNameMap.put("updateTSledContract",new String[]{"platformArgs", "tSledContract"});
    methodParameterNameMap.put("reqTSledContract",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("addTSledExchange",new String[]{"platformArgs", "tSledExchange"});
    methodParameterNameMap.put("updateTSledExchange",new String[]{"platformArgs", "tSledExchange"});
    methodParameterNameMap.put("reqTSledExchange",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqTCommodityMap",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("addTCommodityMap",new String[]{"platformArgs", "tCommodityMap"});
    methodParameterNameMap.put("addSledExchangeMapping",new String[]{"platformArgs", "sledExchangeMapping"});
    methodParameterNameMap.put("updateSledExchangeMapping",new String[]{"platformArgs", "sledExchangeMapping"});
    methodParameterNameMap.put("reqSledExchangeMapping",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("addSledCommodityTypeMapping",new String[]{"platformArgs", "sledCommodityTypeMapping"});
    methodParameterNameMap.put("updateSledCommodityTypeMapping",new String[]{"platformArgs", "sledCommodityTypeMapping"});
    methodParameterNameMap.put("reqSledCommodityTypeMapping",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("updateTCommodityMap",new String[]{"platformArgs", "tCommodityMap"});
    methodParameterNameMap.put("inactiveExpiredSledContract",new String[]{"platformArgs", "expiredTimestamp"});
    methodParameterNameMap.put("reqTSledCommodityChange",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("addTSledCommodityChange",new String[]{"platformArgs", "tCommodityChange"});
    methodParameterNameMap.put("removeTSledCommodityChange",new String[]{"platformArgs", "tCommodityChange"});
    methodParameterNameMap.put("addCommodityMapFileInfo",new String[]{"platformArgs", "mapFileInfo"});
    methodParameterNameMap.put("updateCommodityMapFileInfo",new String[]{"platformArgs", "mapFileInfo"});
    methodParameterNameMap.put("reqCommodityMapFileInfo",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqSyncMappingTask",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("addSyncMappingTask",new String[]{"platformArgs", "tTask"});
    methodParameterNameMap.put("removeSyncMappingTask",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("addTechPlatformCommodity",new String[]{"platformArgs", "techPlatformCommodity"});
    methodParameterNameMap.put("reqTechPlatformCommodity",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("removeSledCommodity",new String[]{"platformArgs", "removeOption"});
    methodParameterNameMap.put("removeSledExchange",new String[]{"platformArgs", "removeOption"});
    methodParameterNameMap.put("addContractVersion",new String[]{"platformArgs", "contractVersion"});
    methodParameterNameMap.put("removeContractVersion",new String[]{"platformArgs", "removeOption"});
    methodParameterNameMap.put("reqContractVersion",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("updateContractVersion",new String[]{"platformArgs", "contractVersion"});
    methodParameterNameMap.put("addDbLocking",new String[]{"platformArgs", "dbLockingInfo"});
    methodParameterNameMap.put("removeDbLocking",new String[]{"platformArgs", "lockedBy"});
    methodParameterNameMap.put("reqDbLockingInfo",new String[]{"platformArgs"});
    methodParameterNameMap.put("addSledTradeTimeConfig",new String[]{"platformArgs", "config"});
    methodParameterNameMap.put("updateSledTradeTimeConfig",new String[]{"platformArgs", "config"});
    methodParameterNameMap.put("reqSledTradeTimeConfig",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("addSpecTradeTime",new String[]{"platformArgs", "specTradeTime"});
    methodParameterNameMap.put("updateSpecTradeTime",new String[]{"platformArgs", "specTradeTime"});
    methodParameterNameMap.put("reqSpecTradeTime",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqSledCommoditySpecTradeTime",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqSledTradeTime",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("batAddSledTradeTime",new String[]{"platformArgs", "sledTradeTimes"});
    methodParameterNameMap.put("addDstTransferConfig",new String[]{"platformArgs", "transferConfig"});
    methodParameterNameMap.put("updateDstTransferConfig",new String[]{"platformArgs", "transferConfig"});
    methodParameterNameMap.put("reqDstTransferConfig",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("removeSpecTradeTime",new String[]{"platformArgs", "removeOption"});
    methodParameterNameMap.put("removeDstTransferConfig",new String[]{"platformArgs", "removeOption"});
    methodParameterNameMap.put("batUpdateSledTradeTimeConfigs",new String[]{"platformArgs", "configs"});
    methodParameterNameMap.put("addCommoditySource",new String[]{"platformArgs", "commoditySource"});
    methodParameterNameMap.put("updateCommoditySource",new String[]{"platformArgs", "commoditySource"});
    methodParameterNameMap.put("reqCommoditySource",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("addCommoditySourceAccount",new String[]{"platformArgs", "commoditySourceAccount"});
    methodParameterNameMap.put("updateCommoditySourceAccount",new String[]{"platformArgs", "commoditySourceAccount"});
    methodParameterNameMap.put("reqCommoditySourceAccount",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("addSledTradingSession",new String[]{"platformArgs", "sledTradingSession"});
    methodParameterNameMap.put("updateSledTradingSession",new String[]{"platformArgs", "sledTradingSession"});
    methodParameterNameMap.put("reqSledTradingSession",new String[]{"platformArgs", "option", "pageOption"});
    methodParameterNameMap.put("removeSledTradingSession",new String[]{"platformArgs", "tradeSessionId"});
    methodParameterNameMap.put("clearAllTechPlatformCommodity",new String[]{"platformArgs", "techPlatformValue"});
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
