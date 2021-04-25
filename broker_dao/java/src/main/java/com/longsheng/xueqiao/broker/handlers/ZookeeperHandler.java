package com.longsheng.xueqiao.broker.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.broker.dao.thriftapi.ReqBrokerAccessEntryOption;
import com.longsheng.xueqiao.broker.dao.thriftapi.WorkingBrokerAccessEntryResp;
import com.longsheng.xueqiao.broker.page.Page;
import com.longsheng.xueqiao.broker.thriftapi.*;
import com.longsheng.xueqiao.broker.utils.JsonFactory;
import net.qihoo.qconf.Qconf;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.util.ProtocolUtil;
import org.soldier.platform.zookeeper.IConfProvider;
import org.soldier.platform.zookeeper.ZooKeeperManager;
import org.soldier.platform.zookeeper.ZooKeeperManagerFactory;

import java.io.IOException;

public class ZookeeperHandler {

    private final static String BROKER_ACCESS_ENTRY_KEY = "xueqiao_broker";
    private final static String BROKER_ACCESS_ENTRY_PATH = "/xueqiao/broker/access/";
    private ZooKeeperManager manager;

    public ZookeeperHandler() {
        try {
            manager = ZooKeeperManagerFactory.Global().get(BROKER_ACCESS_ENTRY_KEY);
        } catch (Throwable e) {
            AppLog.d(e.getMessage(), e);
        }
    }

    public WorkingBrokerAccessEntryResp reqWorkingBrokerAccessEntry(int brokeAccessEntryId, BrokerAccessHandler handler) throws ErrorInfo {

        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
        option.addToEntryIds(brokeAccessEntryId);
        Page<BrokerAccessEntry> page = handler.query(option, 0, 1);
        if (page.getTotal() > 0) {
            BrokerAccessEntry entry = page.getPage().get(0);
            try {
                WorkingBrokerAccessEntryResp resp = new WorkingBrokerAccessEntryResp();
                if (entry.getWorkingStatus() != BrokerAccessWorkingStatus.WORKING) {
                    resp.setWorking(false);
                    return resp;
                }

                byte[] bytes = reqZookeeperData(entry.getBrokerId(), entry.getEntryId());
                if (bytes == null) {
                    resp.setWorking(false);
                    return resp;
                }

                BrokerAccessEntry brokerAccessEntry = ProtocolUtil.unSerialize(JsonFactory.getInstance().getFactory(), bytes, BrokerAccessEntry.class);

                if (brokerAccessEntry == null) {
                    resp.setWorking(false);
                } else {
                    resp.setWorking(true);
                    resp.setEntry(brokerAccessEntry);
                    handler.update(brokerAccessEntry);
                }
                return resp;
            } catch (ErrorInfo e) {
                AppLog.e(e.getMessage(), e);
                throw e;
            } catch (Throwable e) {
                AppLog.e(e.getMessage(), e);
            }
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), "Zookeeper request access fail");

        } else {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_NOT_FOUND.getValue(), BrokerErrorCode.BROKER_ACCESS_NOT_FOUND.name());
        }

    }

    public BrokerAccessEntry updateToZookeeper(BrokerAccessEntry accessEntry, BrokerAccessHandler handler) throws ErrorInfo {

        sync2Zookeeper(accessEntry, handler);

        ReqBrokerAccessEntryOption option = new ReqBrokerAccessEntryOption();
        option.addToEntryIds(accessEntry.getEntryId());
        return handler.query(option, 0, 1).getPage().get(0);
    }

    public void sync2Zookeeper(BrokerAccessEntry accessEntry, BrokerAccessHandler handler) throws ErrorInfo {
        checkBrokerAccessEntry(accessEntry);
        try {
            AppLog.i("sync broker access : " + accessEntry);
            accessEntry.setWorkingStatus(BrokerAccessWorkingStatus.WORKING);
            accessEntry.setStatus(BrokerAccessStatus.SYNCHRONIZED);
            syncToZookeeper(accessEntry);
        } catch (Exception e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), "Zookeeper update access fail");
        }

        BrokerAccessEntry updateAccessEntry = new BrokerAccessEntry();
        updateAccessEntry.setEntryId(accessEntry.getEntryId());
        updateAccessEntry.setStatus(BrokerAccessStatus.SYNCHRONIZED);
        updateAccessEntry.setWorkingStatus(BrokerAccessWorkingStatus.WORKING);
        handler.update(updateAccessEntry);
    }

    private void checkBrokerAccessEntry(BrokerAccessEntry accessEntry) throws ErrorInfo {
        if (accessEntry == null || accessEntry.getBrokerId() == 0 || accessEntry.getEntryId() == 0) {
            throw new IllegalArgumentException("BrokerAccessEntry BrokerId and EntryId must set");
        }
        if (!accessEntry.isSetPlatform()) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_TECH_PLATFORM_MUST_SET.getValue(), BrokerErrorCode.BROKER_ACCESS_TECH_PLATFORM_MUST_SET.name());
        }
        if (!accessEntry.isSetTechPlatformEnv() || accessEntry.getTechPlatformEnv() == TechPlatformEnv.NONE) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_TECH_PLATFORM_ENV_MUST_SET.getValue(), BrokerErrorCode.BROKER_ACCESS_TECH_PLATFORM_ENV_MUST_SET.name());
        }
        if (accessEntry.getTradeAddressesSize() == 0) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_TRADE_ADDRESS_MUST_SET.getValue(), BrokerErrorCode.BROKER_ACCESS_TRADE_ADDRESS_MUST_SET.name());
        }
        if (accessEntry.getPlatform() == BrokerPlatform.CTP) {
            if (accessEntry.getCustomInfoMapSize() == 0 || accessEntry.getCustomInfoMap().get("BROKER_ID_INFO") == null) {
                throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_CUSTOM_INFO_MUST_SET.getValue(), "CTP broker_id_info must set.");
            }
        }
        if (accessEntry.getStatus() != BrokerAccessStatus.VERIFIED_CORRECT && accessEntry.getStatus() != BrokerAccessStatus.SYNCHRONIZED) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_NOT_VERIFIED.getValue(), BrokerErrorCode.BROKER_ACCESS_NOT_VERIFIED.name());
        }
    }

    private static String getFullPath(int brokerId, int accessEntryId) {
        return BROKER_ACCESS_ENTRY_PATH + brokerId + "/" + accessEntryId;
    }

    private static String getBrokerPath(int brokerId) {
        return BROKER_ACCESS_ENTRY_PATH + brokerId;
    }

    private void syncToZookeeper(BrokerAccessEntry accessEntry) throws IConfProvider.ConfException, IOException, KeeperException, InterruptedException {
        byte[] data = ProtocolUtil.serialize2Bytes(JsonFactory.getInstance().getFactory(), accessEntry);
        String path = getFullPath(accessEntry.getBrokerId(), accessEntry.getEntryId());
        String brokerPath = getBrokerPath(accessEntry.getBrokerId());
        Stat brokerStat = manager.getZooKeeper().exists(brokerPath, false);
        if (brokerStat == null) {
            manager.getZooKeeper().create(brokerPath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        Stat stat = manager.getZooKeeper().exists(path, false);

        if (stat == null) {
            manager.getZooKeeper().create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } else {
            int version = -1;
            manager.getZooKeeper().setData(path, data, version);
        }
    }

    private byte[] reqZookeeperData(int brokerId, int brokerAccessEntryId) throws IConfProvider.ConfException, IOException, KeeperException, InterruptedException, ErrorInfo {

        String path = getFullPath(brokerId, brokerAccessEntryId);
        ZooKeeperManager manager = ZooKeeperManagerFactory.Global().get(BROKER_ACCESS_ENTRY_KEY);
        Stat stat = manager.getZooKeeper().exists(path, false);
        if (stat == null) {
            throw new ErrorInfo(BrokerErrorCode.BROKER_ACCESS_NOT_WORKING.getValue(), BrokerErrorCode.BROKER_ACCESS_NOT_WORKING.name());
        } else {
            return manager.getZooKeeper().getData(path, false, null);
        }
    }

    private String contractSyncConfigPaht() {
        return "/xueqiao/contract/contract_online";
    }

    public void removeSyncMappingTable(BrokerAccessEntry brokerAccessEntry) throws ErrorInfo {
        try {
            ContractSyncObject contractSyncObject = getSyncObject();
            if (contractSyncObject.getCommodityMappingBrokerIds().contains(brokerAccessEntry.getBrokerId())) {
                contractSyncObject.getCommodityMappingBrokerIds().remove(new Integer(brokerAccessEntry.getBrokerId()));
                updateContractSyncObject(contractSyncObject);
            }
        } catch (ErrorInfo errorInfo) {
            AppLog.e(errorInfo.getMessage());
            throw errorInfo;
        } catch (Throwable e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), "system busy.");
        }

    }

    public void addSyncMappingTable(BrokerAccessEntry brokerAccessEntry) throws ErrorInfo {
        try {
            ContractSyncObject contractSyncObject = getSyncObject();
            if (!contractSyncObject.getCommodityMappingBrokerIds().contains(brokerAccessEntry.getBrokerId())) {
                contractSyncObject.getCommodityMappingBrokerIds().add(brokerAccessEntry.getBrokerId());
                updateContractSyncObject(contractSyncObject);
            }
        } catch (ErrorInfo errorInfo) {
            AppLog.e(errorInfo.getMessage());
            throw errorInfo;
        } catch (Throwable e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), "system busy.");
        }
    }

    private void updateContractSyncObject(ContractSyncObject syncObject) throws KeeperException, InterruptedException {
        byte[] data = GsonHandler.getInstance().getGson().toJson(syncObject).getBytes();
        String path = contractSyncConfigPaht();
        Stat stat = manager.getZooKeeper().exists(path, false);
        if (stat == null) {
            manager.getZooKeeper().create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } else {
            int version = -1;
            manager.getZooKeeper().setData(path, data, version);
        }
    }

    private ContractSyncObject getSyncObject() throws IConfProvider.ConfException, IOException, KeeperException, InterruptedException, ErrorInfo {
        ZooKeeperManager manager = ZooKeeperManagerFactory.Global().get(BROKER_ACCESS_ENTRY_KEY);
        Stat stat = manager.getZooKeeper().exists(contractSyncConfigPaht(), false);
        if (stat == null) {
            throw new ErrorInfo(ErrorCodeInner.ILLEGAL_OPERATION_ERROR.getErrorCode(), "Contract sync config not found.");
        } else {
            byte[] data = manager.getZooKeeper().getData(contractSyncConfigPaht(), false, null);
            if (data == null) {
                throw new ErrorInfo(ErrorCodeInner.ILLEGAL_OPERATION_ERROR.getErrorCode(), "Contract sync config not found.");
            }
            return GsonHandler.getInstance().getGson().fromJson(new String(data), ContractSyncObject.class);
        }
    }
}
