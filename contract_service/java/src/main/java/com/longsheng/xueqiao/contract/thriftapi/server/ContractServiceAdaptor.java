package com.longsheng.xueqiao.contract.thriftapi.server;

import java.util.Properties;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import com.longsheng.xueqiao.contract.thriftapi.ActiveCommodityResp;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEdit;
import com.longsheng.xueqiao.contract.thriftapi.CommodityMappingEditPage;
import com.longsheng.xueqiao.contract.thriftapi.ImportCommodityMapResp;
import com.longsheng.xueqiao.contract.thriftapi.LinkCommodityMappingInfo;
import com.longsheng.xueqiao.contract.thriftapi.LinkCommodityMappingResp;
import com.longsheng.xueqiao.contract.thriftapi.RemoveCommodityResp;
import com.longsheng.xueqiao.contract.thriftapi.RemoveSledExchangeResp;
import com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMappingEditOption;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityStateChangeResp;
import com.longsheng.xueqiao.contract.thriftapi.SledContractEditPage;
import com.longsheng.xueqiao.contract.thriftapi.SyncContractOption;
import com.longsheng.xueqiao.contract.thriftapi.SyncContractResp;
import com.longsheng.xueqiao.contract.thriftapi.SyncTradeTimeResp;
import com.longsheng.xueqiao.contract.thriftapi.VerifyCommodityResp;
import com.longsheng.xueqiao.contract.thriftapi.ContractService;
import com.longsheng.xueqiao.contract.thriftapi.ContractServiceVariable;


public abstract class ContractServiceAdaptor implements ContractService.Iface{
  // unmodified map, so we do not need lock for this 
  private final Map<String, String[]> methodParameterNameMap = new HashMap<String, String[]>(); 

  public String[] getMethodParameterName(String methodName) {
    return methodParameterNameMap.get(methodName);
  }

  @Override
  public SledContractEditPage reqSledContractDetail(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqSledContractDetail",platformArgs);
    return reqSledContractDetail(oCntl, option, pageIndex, pageSize);
  }

  protected abstract SledContractEditPage reqSledContractDetail(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateSledContractStatus(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, Set<Integer> sledContractIds, com.longsheng.xueqiao.contract.standard.thriftapi.ContractStatus newContractStatus) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateSledContractStatus",platformArgs);
updateSledContractStatus(oCntl, sledContractIds, newContractStatus);
  }

  protected abstract void updateSledContractStatus(TServiceCntl oCntl, Set<Integer> sledContractIds, com.longsheng.xueqiao.contract.standard.thriftapi.ContractStatus newContractStatus) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public SledCommodityEditPage reqSledCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqSledCommodity",platformArgs);
    return reqSledCommodity(oCntl, option, pageIndex, pageSize);
  }

  protected abstract SledCommodityEditPage reqSledCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage reqSledExchange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqSledExchange",platformArgs);
    return reqSledExchange(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage reqSledExchange(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityMappingEdit addCommodityMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addCommodityMapping",platformArgs);
    return addCommodityMapping(oCntl, commodityMapping);
  }

  protected abstract CommodityMappingEdit addCommodityMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange addSledExchange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addSledExchange",platformArgs);
    return addSledExchange(oCntl, sledExchange);
  }

  protected abstract com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange addSledExchange(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityMappingEditPage reqCommodityMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, ReqCommodityMappingEditOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqCommodityMapping",platformArgs);
    return reqCommodityMapping(oCntl, option, pageIndex, pageSize);
  }

  protected abstract CommodityMappingEditPage reqCommodityMapping(TServiceCntl oCntl, ReqCommodityMappingEditOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public SledCommodityEdit addSledCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity, String mappingCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addSledCommodity",platformArgs);
    return addSledCommodity(oCntl, sledCommodity, mappingCode);
  }

  protected abstract SledCommodityEdit addSledCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity, String mappingCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange updateSledExchange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateSledExchange",platformArgs);
    return updateSledExchange(oCntl, sledExchange);
  }

  protected abstract com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange updateSledExchange(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public SledCommodityEdit updateSledCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateSledCommodity",platformArgs);
    return updateSledCommodity(oCntl, sledCommodity);
  }

  protected abstract SledCommodityEdit updateSledCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public CommodityMappingEdit updateCommodityMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateCommodityMapping",platformArgs);
    return updateCommodityMapping(oCntl, commodityMapping);
  }

  protected abstract CommodityMappingEdit updateCommodityMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addSledExchangeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping sledExchangeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addSledExchangeMapping",platformArgs);
addSledExchangeMapping(oCntl, sledExchangeMapping);
  }

  protected abstract void addSledExchangeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping sledExchangeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateSledExchangeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping sledExchangeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateSledExchangeMapping",platformArgs);
updateSledExchangeMapping(oCntl, sledExchangeMapping);
  }

  protected abstract void updateSledExchangeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledExchangeMapping sledExchangeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledExchangeMappingPage reqSledExchangeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSledExchangeMappingOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqSledExchangeMapping",platformArgs);
    return reqSledExchangeMapping(oCntl, option);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledExchangeMappingPage reqSledExchangeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSledExchangeMappingOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addSledCommodityTypeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping sledCommodityTypeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addSledCommodityTypeMapping",platformArgs);
addSledCommodityTypeMapping(oCntl, sledCommodityTypeMapping);
  }

  protected abstract void addSledCommodityTypeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping sledCommodityTypeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateSledCommodityTypeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping sledCommodityTypeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateSledCommodityTypeMapping",platformArgs);
updateSledCommodityTypeMapping(oCntl, sledCommodityTypeMapping);
  }

  protected abstract void updateSledCommodityTypeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMapping sledCommodityTypeMapping) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMappingPage reqSledCommodityTypeMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSledCommodityTypeMappingOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqSledCommodityTypeMapping",platformArgs);
    return reqSledCommodityTypeMapping(oCntl, option);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledCommodityTypeMappingPage reqSledCommodityTypeMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSledCommodityTypeMappingOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public ImportCommodityMapResp importCommodityMapFile(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo mapFileInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"importCommodityMapFile",platformArgs);
    return importCommodityMapFile(oCntl, mapFileInfo);
  }

  protected abstract ImportCommodityMapResp importCommodityMapFile(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfo mapFileInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfoPage reqCommodityMapFileInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqCommodityMapFileInfo",platformArgs);
    return reqCommodityMapFileInfo(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.CommodityMapFileInfoPage reqCommodityMapFileInfo(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public LinkCommodityMappingResp linkTechPlatformMapping(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, LinkCommodityMappingInfo linkCommodityMappingInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"linkTechPlatformMapping",platformArgs);
    return linkTechPlatformMapping(oCntl, linkCommodityMappingInfo);
  }

  protected abstract LinkCommodityMappingResp linkTechPlatformMapping(TServiceCntl oCntl, LinkCommodityMappingInfo linkCommodityMappingInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodityPage reqTechPlatformCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqTechPlatformCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqTechPlatformCommodity",platformArgs);
    return reqTechPlatformCommodity(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodityPage reqTechPlatformCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqTechPlatformCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addTechPlatformCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity techPlatformCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addTechPlatformCommodity",platformArgs);
addTechPlatformCommodity(oCntl, techPlatformCommodity);
  }

  protected abstract void addTechPlatformCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.TechPlatformCommodity techPlatformCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public ActiveCommodityResp activeSledCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"activeSledCommodity",platformArgs);
    return activeSledCommodity(oCntl, sledCommodityId);
  }

  protected abstract ActiveCommodityResp activeSledCommodity(TServiceCntl oCntl, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public VerifyCommodityResp verifySledCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"verifySledCommodity",platformArgs);
    return verifySledCommodity(oCntl, sledCommodityId);
  }

  protected abstract VerifyCommodityResp verifySledCommodity(TServiceCntl oCntl, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public RemoveCommodityResp removeSledCommodity(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"removeSledCommodity",platformArgs);
    return removeSledCommodity(oCntl, sledCommodityId);
  }

  protected abstract RemoveCommodityResp removeSledCommodity(TServiceCntl oCntl, int sledCommodityId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public RemoveSledExchangeResp removeSledExchange(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledExchangeId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"removeSledExchange",platformArgs);
    return removeSledExchange(oCntl, sledExchangeId);
  }

  protected abstract RemoveSledExchangeResp removeSledExchange(TServiceCntl oCntl, int sledExchangeId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public SledCommodityStateChangeResp changeSledCommodityState(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState newState) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"changeSledCommodityState",platformArgs);
    return changeSledCommodityState(oCntl, sledCommodityId, newState);
  }

  protected abstract SledCommodityStateChangeResp changeSledCommodityState(TServiceCntl oCntl, int sledCommodityId, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState newState) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addDbLocking(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo dbLockingInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addDbLocking",platformArgs);
addDbLocking(oCntl, dbLockingInfo);
  }

  protected abstract void addDbLocking(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo dbLockingInfo) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeDbLocking(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, String lockedBy) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"removeDbLocking",platformArgs);
removeDbLocking(oCntl, lockedBy);
  }

  protected abstract void removeDbLocking(TServiceCntl oCntl, String lockedBy) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo reqDbLockingInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqDbLockingInfo",platformArgs);
    return reqDbLockingInfo(oCntl);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo reqDbLockingInfo(TServiceCntl oCntl) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public SyncContractResp syncContract(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, SyncContractOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"syncContract",platformArgs);
    return syncContract(oCntl, option);
  }

  protected abstract SyncContractResp syncContract(TServiceCntl oCntl, SyncContractOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeCommodityMapFileInfo(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.RemoveCommodityMapFileInfoOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"removeCommodityMapFileInfo",platformArgs);
removeCommodityMapFileInfo(oCntl, option);
  }

  protected abstract void removeCommodityMapFileInfo(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.RemoveCommodityMapFileInfoOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addSledTradeTimeConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig config) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addSledTradeTimeConfig",platformArgs);
addSledTradeTimeConfig(oCntl, config);
  }

  protected abstract void addSledTradeTimeConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig config) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateSledTradeTimeConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig config) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateSledTradeTimeConfig",platformArgs);
updateSledTradeTimeConfig(oCntl, config);
  }

  protected abstract void updateSledTradeTimeConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfig config) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfigPage reqSledTradeTimeConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeConfigOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqSledTradeTimeConfig",platformArgs);
    return reqSledTradeTimeConfig(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledTradeTimeConfigPage reqSledTradeTimeConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeConfigOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addDstTransferConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.DstTransferConfig transferConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addDstTransferConfig",platformArgs);
addDstTransferConfig(oCntl, transferConfig);
  }

  protected abstract void addDstTransferConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.DstTransferConfig transferConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateDstTransferConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.DstTransferConfig transferConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateDstTransferConfig",platformArgs);
updateDstTransferConfig(oCntl, transferConfig);
  }

  protected abstract void updateDstTransferConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.DstTransferConfig transferConfig) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.DstTransferConfigPage reqDstTransferConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqDstTransferConfigOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqDstTransferConfig",platformArgs);
    return reqDstTransferConfig(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.DstTransferConfigPage reqDstTransferConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqDstTransferConfigOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeDstTransferConfig(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.RemoveDstTransferConfigOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"removeDstTransferConfig",platformArgs);
removeDstTransferConfig(oCntl, removeOption);
  }

  protected abstract void removeDstTransferConfig(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.RemoveDstTransferConfigOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addSpecTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SpecTradeTime specTradeTime) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addSpecTradeTime",platformArgs);
addSpecTradeTime(oCntl, specTradeTime);
  }

  protected abstract void addSpecTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SpecTradeTime specTradeTime) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateSpecTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SpecTradeTime specTradeTime) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateSpecTradeTime",platformArgs);
updateSpecTradeTime(oCntl, specTradeTime);
  }

  protected abstract void updateSpecTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SpecTradeTime specTradeTime) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SpecTradeTimePage reqSpecTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSpecTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqSpecTradeTime",platformArgs);
    return reqSpecTradeTime(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SpecTradeTimePage reqSpecTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSpecTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledCommoditySpecTradeTimePage reqSledCommoditySpecTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySpecTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqSledCommoditySpecTradeTime",platformArgs);
    return reqSledCommoditySpecTradeTime(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledCommoditySpecTradeTimePage reqSledCommoditySpecTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySpecTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public SyncTradeTimeResp syncTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"syncTradeTime",platformArgs);
    return syncTradeTime(oCntl);
  }

  protected abstract SyncTradeTimeResp syncTradeTime(TServiceCntl oCntl) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledTradeTimePage reqSledTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqSledTradeTime",platformArgs);
    return reqSledTradeTime(oCntl, option, pageIndex, pageSize);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledTradeTimePage reqSledTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeSpecTradeTime(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.RemoveSpecTradeTimeOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"removeSpecTradeTime",platformArgs);
removeSpecTradeTime(oCntl, removeOption);
  }

  protected abstract void removeSpecTradeTime(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.RemoveSpecTradeTimeOption removeOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addCommoditySource(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommoditySource commoditySource) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addCommoditySource",platformArgs);
addCommoditySource(oCntl, commoditySource);
  }

  protected abstract void addCommoditySource(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySource commoditySource) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateCommoditySource(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommoditySource commoditySource) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateCommoditySource",platformArgs);
updateCommoditySource(oCntl, commoditySource);
  }

  protected abstract void updateCommoditySource(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySource commoditySource) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.CommoditySourcePage reqCommoditySource(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqCommoditySource",platformArgs);
    return reqCommoditySource(oCntl, option);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.CommoditySourcePage reqCommoditySource(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addCommoditySourceAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount commoditySourceAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addCommoditySourceAccount",platformArgs);
addCommoditySourceAccount(oCntl, commoditySourceAccount);
  }

  protected abstract void addCommoditySourceAccount(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount commoditySourceAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateCommoditySourceAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount commoditySourceAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateCommoditySourceAccount",platformArgs);
updateCommoditySourceAccount(oCntl, commoditySourceAccount);
  }

  protected abstract void updateCommoditySourceAccount(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccount commoditySourceAccount) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccountPage reqCommoditySourceAccount(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceAccountOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqCommoditySourceAccount",platformArgs);
    return reqCommoditySourceAccount(oCntl, option);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.CommoditySourceAccountPage reqCommoditySourceAccount(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqCommoditySourceAccountOption option) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void addSledTradingSession(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledTradingSession sledTradingSession) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"addSledTradingSession",platformArgs);
addSledTradingSession(oCntl, sledTradingSession);
  }

  protected abstract void addSledTradingSession(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledTradingSession sledTradingSession) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void updateSledTradingSession(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.SledTradingSession sledTradingSession) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"updateSledTradingSession",platformArgs);
updateSledTradingSession(oCntl, sledTradingSession);
  }

  protected abstract void updateSledTradingSession(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.SledTradingSession sledTradingSession) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public com.longsheng.xueqiao.contract.thriftapi.SledTradingSessionPage reqSledTradingSession(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradingSessionOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"reqSledTradingSession",platformArgs);
    return reqSledTradingSession(oCntl, option, pageOption);
  }

  protected abstract com.longsheng.xueqiao.contract.thriftapi.SledTradingSessionPage reqSledTradingSession(TServiceCntl oCntl, com.longsheng.xueqiao.contract.thriftapi.ReqSledTradingSessionOption option, org.soldier.platform.page.IndexedPageOption pageOption) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  @Override
  public void removeSledTradingSession(org.soldier.platform.svr_platform.comm.PlatformArgs platformArgs, long tradeSessionId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException{
    TServiceCntl oCntl = new TServiceCntl(ContractServiceVariable.serviceKey,"removeSledTradingSession",platformArgs);
removeSledTradingSession(oCntl, tradeSessionId);
  }

  protected abstract void removeSledTradingSession(TServiceCntl oCntl, long tradeSessionId) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException;

  protected ContractServiceAdaptor(){
    methodParameterNameMap.put("reqSledContractDetail",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("updateSledContractStatus",new String[]{"platformArgs", "sledContractIds", "newContractStatus"});
    methodParameterNameMap.put("reqSledCommodity",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqSledExchange",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("addCommodityMapping",new String[]{"platformArgs", "commodityMapping"});
    methodParameterNameMap.put("addSledExchange",new String[]{"platformArgs", "sledExchange"});
    methodParameterNameMap.put("reqCommodityMapping",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("addSledCommodity",new String[]{"platformArgs", "sledCommodity", "mappingCode"});
    methodParameterNameMap.put("updateSledExchange",new String[]{"platformArgs", "sledExchange"});
    methodParameterNameMap.put("updateSledCommodity",new String[]{"platformArgs", "sledCommodity"});
    methodParameterNameMap.put("updateCommodityMapping",new String[]{"platformArgs", "commodityMapping"});
    methodParameterNameMap.put("addSledExchangeMapping",new String[]{"platformArgs", "sledExchangeMapping"});
    methodParameterNameMap.put("updateSledExchangeMapping",new String[]{"platformArgs", "sledExchangeMapping"});
    methodParameterNameMap.put("reqSledExchangeMapping",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("addSledCommodityTypeMapping",new String[]{"platformArgs", "sledCommodityTypeMapping"});
    methodParameterNameMap.put("updateSledCommodityTypeMapping",new String[]{"platformArgs", "sledCommodityTypeMapping"});
    methodParameterNameMap.put("reqSledCommodityTypeMapping",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("importCommodityMapFile",new String[]{"platformArgs", "mapFileInfo"});
    methodParameterNameMap.put("reqCommodityMapFileInfo",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("linkTechPlatformMapping",new String[]{"platformArgs", "linkCommodityMappingInfo"});
    methodParameterNameMap.put("reqTechPlatformCommodity",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("addTechPlatformCommodity",new String[]{"platformArgs", "techPlatformCommodity"});
    methodParameterNameMap.put("activeSledCommodity",new String[]{"platformArgs", "sledCommodityId"});
    methodParameterNameMap.put("verifySledCommodity",new String[]{"platformArgs", "sledCommodityId"});
    methodParameterNameMap.put("removeSledCommodity",new String[]{"platformArgs", "sledCommodityId"});
    methodParameterNameMap.put("removeSledExchange",new String[]{"platformArgs", "sledExchangeId"});
    methodParameterNameMap.put("changeSledCommodityState",new String[]{"platformArgs", "sledCommodityId", "newState"});
    methodParameterNameMap.put("addDbLocking",new String[]{"platformArgs", "dbLockingInfo"});
    methodParameterNameMap.put("removeDbLocking",new String[]{"platformArgs", "lockedBy"});
    methodParameterNameMap.put("reqDbLockingInfo",new String[]{"platformArgs"});
    methodParameterNameMap.put("syncContract",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("removeCommodityMapFileInfo",new String[]{"platformArgs", "option"});
    methodParameterNameMap.put("addSledTradeTimeConfig",new String[]{"platformArgs", "config"});
    methodParameterNameMap.put("updateSledTradeTimeConfig",new String[]{"platformArgs", "config"});
    methodParameterNameMap.put("reqSledTradeTimeConfig",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("addDstTransferConfig",new String[]{"platformArgs", "transferConfig"});
    methodParameterNameMap.put("updateDstTransferConfig",new String[]{"platformArgs", "transferConfig"});
    methodParameterNameMap.put("reqDstTransferConfig",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("removeDstTransferConfig",new String[]{"platformArgs", "removeOption"});
    methodParameterNameMap.put("addSpecTradeTime",new String[]{"platformArgs", "specTradeTime"});
    methodParameterNameMap.put("updateSpecTradeTime",new String[]{"platformArgs", "specTradeTime"});
    methodParameterNameMap.put("reqSpecTradeTime",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("reqSledCommoditySpecTradeTime",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("syncTradeTime",new String[]{"platformArgs"});
    methodParameterNameMap.put("reqSledTradeTime",new String[]{"platformArgs", "option", "pageIndex", "pageSize"});
    methodParameterNameMap.put("removeSpecTradeTime",new String[]{"platformArgs", "removeOption"});
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
  }
  protected abstract int InitApp(final Properties props);

  protected abstract void destroy();

}
