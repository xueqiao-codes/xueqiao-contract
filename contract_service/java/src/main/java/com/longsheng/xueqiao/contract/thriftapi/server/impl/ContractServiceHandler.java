package com.longsheng.xueqiao.contract.thriftapi.server.impl;


import java.util.Properties;
import java.util.Set;

import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContract;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.data.*;
import com.longsheng.xueqiao.contract.imports.ContractStorage;
import com.longsheng.xueqiao.contract.imports.Importer;
import com.longsheng.xueqiao.contract.standard.thriftapi.CommodityState;
import com.longsheng.xueqiao.contract.standard.thriftapi.ContractStatus;
import com.longsheng.xueqiao.contract.sync.ContractSyncer;
import com.longsheng.xueqiao.contract.sync.TradeSession2TradeTime;
import com.longsheng.xueqiao.contract.sync.TradeTimeSyncer;
import com.longsheng.xueqiao.contract.thriftapi.*;
import com.longsheng.xueqiao.contract.utils.ContractDao;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.file_storage.FileStorageException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;
import com.longsheng.xueqiao.contract.thriftapi.server.ContractServiceAdaptor;

public class ContractServiceHandler extends ContractServiceAdaptor {
    @Override
    public int InitApp(Properties props) {

        return 0;
    }

    @Override
    protected SledContractEditPage reqSledContractDetail(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledContractOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new SledContractAccess().getSledContractPage(option, pageIndex, pageSize);
    }

    @Override
    protected void updateSledContractStatus(TServiceCntl oCntl, Set<Integer> sledContractIds, ContractStatus newContractStatus) throws ErrorInfo, TException {
        checkNull(sledContractIds, "sledContractIds");
        checkNull(newContractStatus, "newContractStatus");
        ContractDaoServiceStub stub = new ContractDaoServiceStub();
        for (int id : sledContractIds) {
            stub.updateTSledContract(new TSledContract().setSledContractId(id).setContractStatus(newContractStatus.getValue()));
        }
    }

    @Override
    protected SledCommodityEditPage reqSledCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new SledCommodityAccess().getPage(option, pageIndex, pageSize);
    }

    @Override
    protected com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage reqSledExchange(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new SledExchangeAccess().getPage(option, pageIndex, pageSize);
    }

    @Override
    protected CommodityMappingEdit addCommodityMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMap) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(commodityMap, "commodityMap");
        return new CommodityMappingUpdate().addCommodityMap(commodityMap);
    }

    @Override
    protected com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange addSledExchange(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(sledExchange, "sledExchange");
        return new SledExchangeUpdate().addSledExchange(sledExchange);
    }

    @Override
    protected CommodityMappingEditPage reqCommodityMapping(TServiceCntl oCntl, ReqCommodityMappingEditOption option, int pageIndex, int pageSize) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(option, "option");
        return new CommodityMappingAccess().reqCommodityMap(option, pageIndex, pageSize);
    }

    @Override
    protected SledCommodityEdit addSledCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity, String mappingCode) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(sledCommodity, "sledCommodity");
        return new SledCommodityUpdate().addSledCommodity(sledCommodity, mappingCode);
    }

    @Override
    protected com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange updateSledExchange(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange sledExchange) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(sledExchange, "sledExchange");
        return new SledExchangeUpdate().updateSledExchange(sledExchange);
    }

    @Override
    protected SledCommodityEdit updateSledCommodity(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity sledCommodity) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(sledCommodity, "sledCommodity");
        return new SledCommodityUpdate().updateSledCommodity(sledCommodity);
    }

    @Override
    protected CommodityMappingEdit updateCommodityMapping(TServiceCntl oCntl, com.longsheng.xueqiao.contract.standard.thriftapi.CommodityMapping commodityMap) throws org.soldier.platform.svr_platform.comm.ErrorInfo, org.apache.thrift.TException {
        checkNull(commodityMap, "commodityMap");
        return new CommodityMappingUpdate().updateCommodityMap(commodityMap);
    }

    @Override
    protected void addSledExchangeMapping(TServiceCntl oCntl, SledExchangeMapping sledExchangeMapping) throws ErrorInfo, TException {
        checkNull(sledExchangeMapping, "sledExchangeMapping");
        new SledExchangeMappingUpdate().add(sledExchangeMapping);
    }

    @Override
    protected void updateSledExchangeMapping(TServiceCntl oCntl, SledExchangeMapping sledExchangeMapping) throws ErrorInfo, TException {
        checkNull(sledExchangeMapping, "sledExchangeMapping");
        new SledExchangeMappingUpdate().update(sledExchangeMapping);
    }

    @Override
    protected SledExchangeMappingPage reqSledExchangeMapping(TServiceCntl oCntl, ReqSledExchangeMappingOption option) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new SledExchangeMappingAccess().getPage(option);
    }

    @Override
    protected void addSledCommodityTypeMapping(TServiceCntl oCntl, SledCommodityTypeMapping sledCommodityTypeMapping) throws ErrorInfo, TException {
        checkNull(sledCommodityTypeMapping, "sledCommodityTypeMapping");
        new SledCommodityTypeMappingUpdate().add(sledCommodityTypeMapping);
    }

    @Override
    protected void updateSledCommodityTypeMapping(TServiceCntl oCntl, SledCommodityTypeMapping sledCommodityTypeMapping) throws ErrorInfo, TException {
        checkNull(sledCommodityTypeMapping, "sledCommodityTypeMapping");
        new SledCommodityTypeMappingUpdate().update(sledCommodityTypeMapping);
    }

    @Override
    protected SledCommodityTypeMappingPage reqSledCommodityTypeMapping(TServiceCntl oCntl, ReqSledCommodityTypeMappingOption option) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new SledCommodityTypeMappingAccess().getPage(option);
    }

    @Override
    protected ImportCommodityMapResp importCommodityMapFile(TServiceCntl oCntl, CommodityMapFileInfo mapFileInfo) throws TException {
        checkNull(mapFileInfo, "mapFileInfo");
        return new Importer().importMapFile(mapFileInfo);
    }

    @Override
    protected CommodityMapFileInfoPage reqCommodityMapFileInfo(TServiceCntl oCntl, ReqCommodityMapFileInfoOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        CommodityMapFileInfoPage page = ContractDao.getInstance().getServiceStub().reqCommodityMapFileInfo(option, pageIndex, pageSize);
        for (CommodityMapFileInfo info : page.getPage()) {
            try {
                info.setUrl(ContractStorage.getStorage().getUrl(info.getPath()));
            } catch (FileStorageException e) {
                AppLog.e(e.getMessage(), e);
            }
        }
        return page;
    }

    @Override
    protected LinkCommodityMappingResp linkTechPlatformMapping(TServiceCntl oCntl, LinkCommodityMappingInfo linkCommodityMappingInfo) throws ErrorInfo, TException {
        checkNull(linkCommodityMappingInfo, "linkCommodityMappingInfo");
        return new LinkCommodityMappingResp().setSuccess(true);
    }

    @Override
    protected TechPlatformCommodityPage reqTechPlatformCommodity(TServiceCntl oCntl, ReqTechPlatformCommodityOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return ContractDao.getInstance().getServiceStub().reqTechPlatformCommodity(option, pageIndex, pageSize);
    }

    @Override
    protected void addTechPlatformCommodity(TServiceCntl oCntl, TechPlatformCommodity techPlatformCommodity) throws ErrorInfo, TException {
        checkNull(techPlatformCommodity, "techPlatformCommodity");
        ContractDaoServiceStub stub = ContractDao.getInstance().getServiceStub();
        stub.addTechPlatformCommodity(techPlatformCommodity);
    }

    @Override
    protected ActiveCommodityResp activeSledCommodity(TServiceCntl oCntl, int sledCommodityId) throws ErrorInfo, TException {
        new SledCommodityUpdate().activeCommodity(sledCommodityId);
        return new ActiveCommodityResp().setSuccess(true);
    }

    @Override
    protected VerifyCommodityResp verifySledCommodity(TServiceCntl oCntl, int sledCommodityId) throws ErrorInfo, TException {
        new SledCommodityUpdate().verifySledCommodity(sledCommodityId);
        return new VerifyCommodityResp().setSuccess(true);
    }

    @Override
    protected RemoveCommodityResp removeSledCommodity(TServiceCntl oCntl, int sledCommodityId) throws ErrorInfo, TException {
        new SledCommodityUpdate().deleteCommodity(sledCommodityId);
        return new RemoveCommodityResp().setSuccess(true);
    }

    @Override
    protected RemoveSledExchangeResp removeSledExchange(TServiceCntl oCntl, int sledExchangeId) throws ErrorInfo, TException {
        new SledExchangeUpdate().deleteSledExchange(sledExchangeId);
        return new RemoveSledExchangeResp().setSuccess(true);
    }

    @Override
    protected SledCommodityStateChangeResp changeSledCommodityState(TServiceCntl oCntl, int sledCommodityId, CommodityState newState) throws ErrorInfo, TException {
        return new SledCommodityStateChangeResp().setSuccess(true);
    }

    @Override
    protected void addDbLocking(TServiceCntl oCntl, DbLockingInfo dbLockingInfo) throws ErrorInfo, TException {
        checkNull(dbLockingInfo, "dbLockingInfo");
        new DbLockingUpdate().addLocking(dbLockingInfo);
    }

    @Override
    protected void removeDbLocking(TServiceCntl oCntl, String lockedBy) throws ErrorInfo, TException {
        checkNull(lockedBy, "lockedBy");
        new DbLockingUpdate().removeLocking(lockedBy);
    }

    @Override
    protected DbLockingInfo reqDbLockingInfo(TServiceCntl oCntl) throws ErrorInfo, TException {
        return new DbLockingAccess().reqDbLocking();
    }

    @Override
    protected SyncContractResp syncContract(TServiceCntl oCntl, SyncContractOption option) throws ErrorInfo, TException {
        checkNull(option, "option");
        ContractSyncer sync = new ContractSyncer(option.getUserName());
        sync.checkContractEdit();
        sync.unlockDb();
        new Thread(sync).start();
        return new SyncContractResp().setSuccess(true);
    }

    @Deprecated
    @Override
    protected void removeCommodityMapFileInfo(TServiceCntl oCntl, RemoveCommodityMapFileInfoOption option) throws ErrorInfo, TException {

    }

    @Deprecated
    @Override
    protected void addSledTradeTimeConfig(TServiceCntl oCntl, SledTradeTimeConfig config) throws ErrorInfo, TException {
    }

    @Deprecated
    @Override
    protected void updateSledTradeTimeConfig(TServiceCntl oCntl, SledTradeTimeConfig config) throws ErrorInfo, TException {
    }

    @Deprecated
    @Override
    protected SledTradeTimeConfigPage reqSledTradeTimeConfig(TServiceCntl oCntl, ReqSledTradeTimeConfigOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        new ContractDaoServiceStub().reqSledTradeTimeConfig(option, pageIndex, pageSize);
        return new SledTradeTimeConfigPage();
    }

    @Override
    protected void addSpecTradeTime(TServiceCntl oCntl, SpecTradeTime specTradeTime) throws ErrorInfo, TException {
        checkNull(specTradeTime, "specTradeTime");
        new TradeTimeUpdate().addSpecTradeTime(specTradeTime);
    }

    @Override
    protected void updateSpecTradeTime(TServiceCntl oCntl, SpecTradeTime specTradeTime) throws ErrorInfo, TException {
        checkNull(specTradeTime, "specTradeTime");
        new TradeTimeUpdate().updateSpecTradeTime(specTradeTime);
    }

    @Override
    protected SpecTradeTimePage reqSpecTradeTime(TServiceCntl oCntl, ReqSpecTradeTimeOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new ContractDaoServiceStub().reqSpecTradeTime(option, pageIndex, pageSize);
    }

    @Override
    protected SledCommoditySpecTradeTimePage reqSledCommoditySpecTradeTime(TServiceCntl oCntl, ReqCommoditySpecTradeTimeOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new ContractDaoServiceStub().reqSledCommoditySpecTradeTime(option, pageIndex, pageSize);
    }

    @Override
    protected SyncTradeTimeResp syncTradeTime(TServiceCntl oCntl) throws ErrorInfo, TException {
        new TradeTimeSyncer().runOnce();
        return new SyncTradeTimeResp().setSuccess(true);
    }

    @Override
    protected SledTradeTimePage reqSledTradeTime(TServiceCntl oCntl, ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new TradeTimeSyncer().reqSledTradingSessionTime(option, pageIndex, pageSize);
    }

    @Deprecated
    @Override
    protected void addDstTransferConfig(TServiceCntl oCntl, DstTransferConfig transferConfig) throws ErrorInfo, TException {
    }

    @Deprecated
    @Override
    protected void updateDstTransferConfig(TServiceCntl oCntl, DstTransferConfig transferConfig) throws ErrorInfo, TException {
    }

    @Deprecated
    @Override
    protected DstTransferConfigPage reqDstTransferConfig(TServiceCntl oCntl, ReqDstTransferConfigOption option, int pageIndex, int pageSize) throws ErrorInfo, TException {
        return new DstTransferConfigPage();
    }

    @Override
    protected void removeSpecTradeTime(TServiceCntl oCntl, RemoveSpecTradeTimeOption removeOption) throws ErrorInfo, TException {
        checkNull(removeOption, "removeOption");
        new ContractDaoServiceStub().removeSpecTradeTime(removeOption);
    }

    @Deprecated
    @Override
    protected void removeDstTransferConfig(TServiceCntl oCntl, RemoveDstTransferConfigOption removeOption) throws ErrorInfo, TException {
    }

    @Override
    protected void addCommoditySource(TServiceCntl oCntl, CommoditySource commoditySource) throws ErrorInfo, TException {
        checkNull(commoditySource, "commoditySource");
        new ContractDaoServiceStub().addCommoditySource(commoditySource);
    }

    @Override
    protected void updateCommoditySource(TServiceCntl oCntl, CommoditySource commoditySource) throws ErrorInfo, TException {
        checkNull(commoditySource, "commoditySource");
        new CommoditySourceUpdate().update(commoditySource);
    }

    @Override
    protected CommoditySourcePage reqCommoditySource(TServiceCntl oCntl, ReqCommoditySourceOption option) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new ContractDaoServiceStub().reqCommoditySource(option);
    }

    @Override
    protected void addCommoditySourceAccount(TServiceCntl oCntl, CommoditySourceAccount commoditySourceAccount) throws ErrorInfo, TException {
        checkNull(commoditySourceAccount, "commoditySourceAccount");
        new ContractDaoServiceStub().addCommoditySourceAccount(commoditySourceAccount);
    }

    @Override
    protected void updateCommoditySourceAccount(TServiceCntl oCntl, CommoditySourceAccount commoditySourceAccount) throws ErrorInfo, TException {
        checkNull(commoditySourceAccount, "commoditySourceAccount");
        new CommoditySourceAccountUpdate().update(commoditySourceAccount);
    }

    @Override
    protected CommoditySourceAccountPage reqCommoditySourceAccount(TServiceCntl oCntl, ReqCommoditySourceAccountOption option) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new ContractDaoServiceStub().reqCommoditySourceAccount(option);
    }

    @Override
    protected void addSledTradingSession(TServiceCntl oCntl, SledTradingSession sledTradingSession) throws ErrorInfo, TException {
        checkNull(sledTradingSession, "sledTradingSession");
        new TradeSession2TradeTime().checkNewTradingSession(sledTradingSession);
        new ContractDaoServiceStub().addSledTradingSession(sledTradingSession);
    }

    @Override
    protected void updateSledTradingSession(TServiceCntl oCntl, SledTradingSession sledTradingSession) throws ErrorInfo, TException {
        checkNull(sledTradingSession, "sledTradingSession");
        new TradeSession2TradeTime().checkUpdateTradingSession(sledTradingSession);
        new ContractDaoServiceStub().updateSledTradingSession(sledTradingSession);
    }

    @Override
    protected SledTradingSessionPage reqSledTradingSession(TServiceCntl oCntl, ReqSledTradingSessionOption option, IndexedPageOption pageOption) throws ErrorInfo, TException {
        checkNull(option, "option");
        return new ContractDaoServiceStub().reqSledTradingSession(option, pageOption);
    }

    @Override
    protected void removeSledTradingSession(TServiceCntl oCntl, long tradeSessionId) throws ErrorInfo, TException {
        new ContractDaoServiceStub().removeSledTradingSession(tradeSessionId);
    }


    @Override
    public void destroy() {
    }

    private void checkNull(Object obj, String paramterName) {
        if (obj == null) {
            throw new IllegalArgumentException(paramterName + " must not null.");
        }
    }
}
