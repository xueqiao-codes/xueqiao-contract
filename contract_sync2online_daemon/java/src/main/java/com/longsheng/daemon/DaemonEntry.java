package com.longsheng.daemon;

import com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo;
import com.longsheng.xueqiao.contract.thriftapi.SyncContractOption;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;
import com.longsheng.xueqiao.goose.thriftapi.client.GooseAoStub;
import net.qihoo.qconf.Qconf;
import net.qihoo.qconf.QconfException;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.dal_set.DalSetProxy;
import org.soldier.platform.svr_platform.container.DaemonContainer;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

public class DaemonEntry {

    private static final String taskFailCount = "daemon.server.contract.edit.dump.fail.count";
    private static final String taskFailTotal = "daemon.server.contract.edit.dump.fail.total";

    private static final String successCount = "daemon.server.contract.edit.dump.success.count";
    private static final String successTotal = "daemon.server.contract.edit.dump.success.total";

    private static final String taskCount = "daemon.server.contract.edit.dump.count";
    private static final String taskTotal = "daemon.server.contract.edit.dump.total";

    private static final int DAILY_SYNC_HOUR = 11;

    public static void main(String[] args) {

        PlatformMonitor.getInstance().logPlatformStatis(taskCount, taskTotal);
        DaemonContainer container = new DaemonContainer();
        Properties prop = container.getDaemonProperties();
        AppLog.d(prop);

        try {
            DalSetProxy.getInstance().loadFromXml();
        } catch (Exception e) {
            AppLog.e("DAL init fail.", e);
            e.printStackTrace();
            return;
        }

        Sync2OnlineTransaction sync2OnlineDaemon = null;
        try {
            sync2OnlineDaemon = new Sync2OnlineTransaction();
        } catch (Exception e) {
            AppLog.e(e.getMessage(), e);
            return;
        }
        boolean dailySync = false;
        int retrySyncCount = 0;
        int retryRunOnce = 0;
        do {
            Date date = new Date();
            String log = "time now: " + DateFormat.getInstance().format(date);
            AppLog.d(log);
            AppLog.e("DAEMON working");

            if (!dailySync && date.getHours() == DAILY_SYNC_HOUR && retrySyncCount < 10) {
                SyncContractOption option = new SyncContractOption();
                option.setUserName(Sync2OnlineTransaction.SYNC_ONLINE_SYSTEM);
                try {
                    ContractServiceStub contractServiceStub = new ContractServiceStub();
                    DbLockingInfo dbLockingInfo = new DbLockingInfo();
                    dbLockingInfo.setLockArea("all");
                    dbLockingInfo.setLockedBy(Sync2OnlineTransaction.SYNC_ONLINE_SYSTEM);
                    DbLockingInfo lockInfo = contractServiceStub.reqDbLockingInfo();
                    if (!lockInfo.isIsLocked()) {
                        contractServiceStub.addDbLocking(dbLockingInfo);
                    }
                    new ContractServiceStub().syncContract(0, 300000, option);
                    dailySync = true;
                    AppLog.e("daily sync complete.");
                    retrySyncCount = 0;
                } catch (TException e) {
                    AppLog.e(e.getMessage(), e);
                    retrySyncCount++;
                    if (retrySyncCount == 5) {
                        sendSms("ContractServiceStub SyncContract fail.");
                    }
                }
            }

            if (dailySync && date.getHours() == 0) {
                dailySync = false;
                retrySyncCount = 0;
            }

            try {
                sync2OnlineDaemon.runOnce();
                PlatformMonitor.getInstance().logPlatformStatis(successCount, successTotal);
                retryRunOnce = 0;
            } catch (Exception e) {
                AppLog.e(e.getMessage(), e);
                PlatformMonitor.getInstance().logPlatformStatis(taskFailCount, taskFailTotal);
                AppLog.e("DAEMON Stop at exception");
                retryRunOnce++;
                if (retryRunOnce == 5) {
                    sendSms("sync2online fail.");
                }
            }

            sleep(60 * 1000);
        } while (true);
    }

    private static void sendSms(String msg) {
        try {
            String env = "";
            try {
                env = Qconf.getConf("platform/environment");
            } catch (QconfException e) {
                e.printStackTrace();
            }
            new GooseAoStub().sendMaintenanceNotificationSms(1000, 5000, env + ": " + msg);
        } catch (TException e1) {
            e1.printStackTrace();
        }
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
