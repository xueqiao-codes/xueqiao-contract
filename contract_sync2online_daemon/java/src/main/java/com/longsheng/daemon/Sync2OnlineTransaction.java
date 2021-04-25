package com.longsheng.daemon;

import com.antiy.error_code.ErrorCodeInner;
import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.data.*;
import com.longsheng.xueqiao.contract.dao.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.commons.dbutils.QueryRunner;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.dal_set.DalSetProxy;
import org.soldier.platform.dal_set.DbUtil;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sync2OnlineTransaction {

    private final static String EDIT_SERVICE_NAME = "contract_sync2online_daemon_edit";
    private final static String ONLINE_SERVICE_NAME = "contract_sync2online_daemon_online";

    public final static String SYNC_ONLINE_SYSTEM = "sync_online_system@daemon";
    private final static int LOCK_FAIL_ERROR = 999;
    private final static int UNLOCK_FAIL_ERROR = 998;

    private SyncConfig mCurrentConfig;

    public Sync2OnlineTransaction() throws Exception {
    }

    public void runOnce() throws Exception {
        this.mCurrentConfig = SyncConfig.readConfig();
        if (isDifferentVersion()) {
            syncProcess();
        } else {
            AppLog.i("not sync");
        }
    }

    private void syncProcess() throws ErrorInfo {
        AppLog.i("sync start ");
        AppLog.i("check lock db");

        if (checkDbLock()) return;

        AppLog.i(" lock db ");
        if (!lockBothDb()) return;

        ContractDbData dbData = dump();
        sync(dbData);
        unlockDb();


        AppLog.i("sync complete ");
    }

    private void unlockDb() throws ErrorInfo {
        Connection editConn = getDbConnection(mCurrentConfig.getEditDbRole(), EDIT_SERVICE_NAME, false);
        Connection onlineConn = getDbConnection(mCurrentConfig.getOnlineDbRole(), ONLINE_SERVICE_NAME, false);
        try {
            unlockDb(editConn);
            unlockDb(onlineConn);
        } finally {
            DbUtil.closeQuietly(editConn);
            DbUtil.closeQuietly(onlineConn);
        }

    }

    private void unlockDb(Connection conn) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        DbLockingInfoHandler dbLockingInfoHandler = new DbLockingInfoHandler(conn, runner);
        DbLockingInfo info = dbLockingInfoHandler.query();
        if (info.isIsLocked()) {
            if (SYNC_ONLINE_SYSTEM.equals(info.getLockedBy())) {
                dbLockingInfoHandler.remove(SYNC_ONLINE_SYSTEM);
            } else {
                throw new ErrorInfo(UNLOCK_FAIL_ERROR, "unlock fail.");
            }
        }
    }

    private boolean lockBothDb() throws ErrorInfo {
        Connection editConn = getDbConnection(mCurrentConfig.getEditDbRole(), EDIT_SERVICE_NAME, false);
        Connection onlineConn = getDbConnection(mCurrentConfig.getOnlineDbRole(), ONLINE_SERVICE_NAME, false);
        try {
            try {
                lockDb(editConn);
            } catch (ErrorInfo errorInfo) {
                AppLog.d("lock edit db fail.");
                return false;
            }
            try {
                lockDb(onlineConn);
            } catch (ErrorInfo errorInfo) {
                AppLog.d("lock online db fail.");
                return false;
            }
        } finally {
            DbUtil.closeQuietly(editConn);
            DbUtil.closeQuietly(onlineConn);
        }
        return true;
    }

    private void lockDb(Connection conn) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        DbLockingInfoHandler dbLockingInfoHandler = new DbLockingInfoHandler(conn, runner);
        DbLockingInfo info = dbLockingInfoHandler.query();
        if (info.isIsLocked()) {
            if (SYNC_ONLINE_SYSTEM.equals(info.getLockedBy())) {
                return;
            } else {
                throw new ErrorInfo(LOCK_FAIL_ERROR, "LOCK FAIL.");
            }
        }
        DbLockingInfo dblockedInfo = new DbLockingInfo();
        dblockedInfo.setLockedBy(SYNC_ONLINE_SYSTEM);
        dblockedInfo.setLockArea("all");
        dbLockingInfoHandler.insert(dblockedInfo);
    }

    private boolean checkDbLock() throws ErrorInfo {
        Connection editConn = getDbConnection(mCurrentConfig.getEditDbRole(), EDIT_SERVICE_NAME, false);
        Connection onlineConn = getDbConnection(mCurrentConfig.getOnlineDbRole(), ONLINE_SERVICE_NAME, false);
        try {
            boolean isEditDBLockedByOther = isDBLockByOther(editConn);
            boolean isOnlineDBLockedByOther = isDBLockByOther(onlineConn);
            if (isEditDBLockedByOther || isOnlineDBLockedByOther) {
                AppLog.i("db locked by other.");
                return true;
            }
            return false;
        } finally {
            DbUtil.closeQuietly(editConn);
            DbUtil.closeQuietly(onlineConn);
        }
    }

    private boolean isDBLockByOther(Connection connection) throws ErrorInfo {
        QueryRunner runner = new QueryRunner();
        DbLockingInfoHandler dbLockingInfoHandler = new DbLockingInfoHandler(connection, runner);
        DbLockingInfo info = dbLockingInfoHandler.query();
        if (info.isIsLocked()) {
            if (!SYNC_ONLINE_SYSTEM.equals(info.getLockedBy())) {
                AppLog.i(" db locked by  " + info.getLockedBy());
                return true;
            }
        }
        return false;
    }

    private boolean isDifferentVersion() throws ErrorInfo {
        Connection editConn = getDbConnection(mCurrentConfig.getEditDbRole(), EDIT_SERVICE_NAME, true);
        Connection onlineConn = getDbConnection(mCurrentConfig.getOnlineDbRole(), ONLINE_SERVICE_NAME, false);
        try {
            int editVersionId = getVersionId(editConn);
            int onlineVersionId = getVersionId(onlineConn);
            AppLog.i("editVersionId : " + editVersionId);
            AppLog.i("onlineVersionId : " + onlineVersionId);
            return editVersionId != onlineVersionId;
        } finally {
            DbUtil.closeQuietly(editConn);
            DbUtil.closeQuietly(onlineConn);
        }
    }

    private int getVersionId(Connection connection) throws ErrorInfo {
        int versionId = 0;
        ContractVersionHandler contractVersionHandler = new ContractVersionHandler(connection, new QueryRunner());
        ReqContractVersionOption option = new ReqContractVersionOption();
        option.setLatest(true);
        try {
            List<ContractVersion> list = contractVersionHandler.query(option, 0, 1);
            if (list.size() > 0) {
                versionId = list.get(0).getVersionId();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeQuietly(connection);
        }
        return versionId;
    }

    private Connection getDbConnection(String roleName, String serviceName, boolean isReadOnly) throws ErrorInfo {
        try {
            return DalSetProxy.getInstance().getConnection(roleName,
                    serviceName, isReadOnly, 0);
        } catch (SQLException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.DB_CONNECT_FAILED.getErrorCode(),
                    ErrorCodeInner.DB_CONNECT_FAILED.getErrorMsg());
        }
    }

    private ContractDbData dump() throws ErrorInfo {
        ContractDbData dbData = queryWorkingData();
        if (dbData == null) {
            AppLog.e("query db data fail.");
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), "Query db data fail.");
        }
        return dbData;
    }

    private ContractDbData queryWorkingData() throws ErrorInfo {
        Connection conn = getDbConnection(mCurrentConfig.getEditDbRole(), EDIT_SERVICE_NAME, true);
        ReqTSledCommodityOption reqCommodityOption = new ReqTSledCommodityOption();
        reqCommodityOption.setWorkingStatus(WorkingStatus.WORKING.getValue());
        ReqTSledExchangeOption reqExchangeOption = new ReqTSledExchangeOption();
        Set<Integer> sledCommodityIds = new HashSet<>();

        QueryRunner runner = new QueryRunner();
        ContractDbData dbData = new ContractDbData();
        try {
            conn.setAutoCommit(false);
            ReqContractVersionOption reqVersionOption = new ReqContractVersionOption();
            reqVersionOption.setLatest(true);
            List<ContractVersion> contractVersions = new ContractVersionHandler(conn, runner).query(reqVersionOption, 0, 1);
            if (contractVersions.size() > 0) {
                dbData.setContractVersion(contractVersions.get(0));
            } else {
                throw new SQLException("Contract version not found.");
            }

            List<TSledExchange> tSledExchanges = new SledExchangeHandler(conn, runner).query(reqExchangeOption, 0, Integer.MAX_VALUE);
            List<TSledCommodity> tSledCommodities = new SledCommodityHandler(conn, runner).query(reqCommodityOption, 0, Integer.MAX_VALUE);
            for (TSledCommodity s : tSledCommodities) {
                sledCommodityIds.add(s.getSledCommodityId());
            }
            List<Integer> commodityIdList = new ArrayList<>();
            commodityIdList.addAll(sledCommodityIds);
            List<TSledContract> tSledContracts = new SledContractHandler(conn, runner).query(sledCommodityIds);

            for (int id : mCurrentConfig.getCommodityMappingBrokerIds()) {
                AppLog.i("id: " + id);
                ReqTCommodityMapOption reqMappingOption = new ReqTCommodityMapOption();
                reqMappingOption.setBrokerEntryId(id);
                reqMappingOption.setSledCommodityIds(commodityIdList);
                List<TCommodityMap> commodityMappings = new CommodityMapHandler(conn, runner).query(reqMappingOption, 0, Integer.MAX_VALUE);
                AppLog.i("commodityMappings size: " + commodityMappings.size());
                AppLog.i("commodityMappings : " + commodityMappings);
                dbData.getCommodityMappingMap().put(id, commodityMappings);
            }

            ReqSledTradeTimeOption reqTradeTimeOption = new ReqSledTradeTimeOption();
            List<SledTradeTime> sledTradeTimes = new SledTradeTimeTmpHandler(conn, runner).query(reqTradeTimeOption, 0, Integer.MAX_VALUE);

            dbData.settSledExchanges(tSledExchanges);
            dbData.settSledCommodities(tSledCommodities);
            dbData.settSledContracts(tSledContracts);
            dbData.setSledTradeTimes(sledTradeTimes);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            dbData = null;
        } finally {
            DbUtil.closeQuietly(conn);
        }

        return dbData;
    }

    private void sync(ContractDbData data) throws ErrorInfo {

        data.getCommodityMappingMap().keySet().iterator();

        Connection conn = getDbConnection(mCurrentConfig.getOnlineDbRole(), ONLINE_SERVICE_NAME, false);
        QueryRunner runner = new QueryRunner();
        try {
            conn.setAutoCommit(false);
            CommodityMapHandler commodityMapHandler = new CommodityMapHandler(conn, runner);
            List<String> deleteTableSqls = new ArrayList<>();
            for (int id : data.getCommodityMappingMap().keySet()) {
                if (commodityMapHandler.isTableExist(runner, conn, id)) {
                    String deleteTableSql = "delete from " + " t_commodity_mapping_" + id;
                    deleteTableSqls.add(deleteTableSql);
                }
            }
            for (String tableName : mCurrentConfig.getDeleteOnlineTableNames()) {
                String deleteTableSql = "delete from " + tableName;
                deleteTableSqls.add(deleteTableSql);
                AppLog.i("deleteTableSql : " + deleteTableSql);
            }
            for (String sql : deleteTableSqls) {
                System.out.println("delete sql:" + sql);
                runner.update(conn, sql);
            }

            SledExchangeHandler sledExchangeHandler = new SledExchangeHandler(conn, runner);
            SledCommodityHandler sledCommodityHandler = new SledCommodityHandler(conn, runner);
            SledContractHandler sledContractHandler = new SledContractHandler(conn, runner);

            SledTradeTimeTmpHandler sledTradeTimeTmpHandler = new SledTradeTimeTmpHandler(conn, runner);

            for (TSledCommodity tSledCommodity : data.gettSledCommodities()) {
                sledCommodityHandler.insert(tSledCommodity);
            }
            for (TSledExchange tSledExchange : data.gettSledExchanges()) {
                sledExchangeHandler.insert(tSledExchange);
            }
            for (TSledContract tSledContract : data.gettSledContracts()) {
                sledContractHandler.insert(tSledContract);
            }
            for (int id : data.getCommodityMappingMap().keySet()) {
                commodityMapHandler.addTable(id);
                for (TCommodityMap tCommodityMap : data.getCommodityMappingMap().get(id)) {
                    commodityMapHandler.insert(tCommodityMap);
                }
            }
            sledTradeTimeTmpHandler.batInsert(data.getSledTradeTimes());
            new ContractVersionHandler(conn, runner).insert(data.getContractVersion());
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), "sync db data fail.");
        } finally {
            DbUtil.closeQuietly(conn);
        }
    }
}
