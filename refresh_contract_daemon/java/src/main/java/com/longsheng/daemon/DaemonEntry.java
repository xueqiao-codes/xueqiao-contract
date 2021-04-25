package com.longsheng.daemon;

import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;
import com.longsheng.xueqiao.contract.thriftapi.DbLockingInfo;
import com.longsheng.xueqiao.contract.thriftapi.SyncContractOption;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;
import com.longsheng.xueqiao.contractconvertor.LibraryLoader;
import net.qihoo.qconf.Qconf;
import net.qihoo.qconf.QconfException;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.container.DaemonContainer;

import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

public class DaemonEntry {

    private static final String SYNC_TASK_FAIL = "refresh.contract.daemon.sync.task.fail";
    private static final String REFRESH_CTP_FAIL = "refresh.contract.daemon.ctp.fail";
    private static final String REFRESH_ESUNNY_FAIL = "refresh.contract.daemon.esunny.fail";
    private static final String REFRESH_CTP_SUCCESS = "refresh.contract.daemon.ctp.success";
    private static final String REFRESH_DAEMON_WORKING = "refresh.contract.daemon.working";
    private static final String DB_LOCKING = "refresh.contract.db.lock";
    private static final String DB_LOCKING_TOO_LONG = "refresh.contract.db.lock.too.long";

    private static ContractServiceStub stub = new ContractServiceStub();

    public static void main(String[] args) {

        // 加载contract code converter 需要的类库
        LibraryLoader.init();
        com.longsheng.xueqiao.util.esunny9.LibraryLoader.init();
        AppLog.init("refresh_contract");

        int refreshFlag = 0;

        try {
            String flag = Qconf.getConf("xueqiao/contract/refresh_flag");
            refreshFlag = Integer.valueOf(flag);
        } catch (Exception e) {
            AppLog.e(e.getMessage(), e);
        }

        PlatformMonitor.getInstance().logPlatformStatis(REFRESH_DAEMON_WORKING);
        Date date = new Date();
        String log = "time now: " + DateFormat.getInstance().format(date);
        AppLog.d(log);
        dbLockingLogStatis();

        if (refreshFlag > 0) {
            AppLog.e("do ctp update");
            updateLogic(TechPlatform.CTP);
        } else {
            AppLog.i("not ctp update time.");
        }

        if (refreshFlag > 0) {
            AppLog.e("do es update");
            updateLogic(TechPlatform.ESUNNY);
        } else {
            AppLog.i("not es update time.");
        }
        sync();
    }

    private static void updateLogic(TechPlatform techPlatform) {
        lockDb();
        doUpdate(techPlatform);
    }

    private static void sync() {
        SyncContractOption option = new SyncContractOption();
        option.setUserName("refresh_contract_daemon");
        try {
            stub.syncContract(0, 30000, option);
        } catch (Exception e) {
            AppLog.e(e.getMessage(), e);
            PlatformMonitor.getInstance().logPlatformStatis(SYNC_TASK_FAIL);
        }
    }

    private static void lockDb() {
        DbLockingInfo dbLocking = new DbLockingInfo();
        dbLocking.setLockedBy("refresh_contract_daemon");
        dbLocking.setLockArea("all");
        try {
            DbLockingInfo lockInfo = stub.reqDbLockingInfo();
            if (!lockInfo.isIsLocked()) {
                stub.addDbLocking(dbLocking);
            }
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    private static void dbLockingLogStatis() {
        try {
            DbLockingInfo lockInfo = stub.reqDbLockingInfo();
            if (lockInfo.isIsLocked()) {
                PlatformMonitor.getInstance().logPlatformStatis(DB_LOCKING);
                long now = System.currentTimeMillis() / 1000;
                int hours = (int) (now - lockInfo.getStartLockedTimestamp()) / (60 * 60);
                if (hours > 10) {
                    PlatformMonitor.getInstance().logPlatformStatis(DB_LOCKING_TOO_LONG);
                }
            }
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void doUpdate(TechPlatform techPlatform) {
        try {
            AppLog.e("DAEMON START");
            DaemonContainer container = new DaemonContainer();
            Properties prop = container.getDaemonProperties();
            AppLog.d(prop);
            TCommodityMapCache commodityMapCache = TCommodityMapCache.getInstance();
            AppLog.d("init commodity map");
            commodityMapCache.init(0);
            sleep(2000);

            if (TechPlatform.CTP.equals(techPlatform)) {
                try {
                    new CtpContractUpdateDaemon().run();

                    PlatformMonitor.getInstance().logPlatformStatis(REFRESH_CTP_SUCCESS);
                } catch (Exception e) {
                    AppLog.e(e.getMessage(), e);
                    PlatformMonitor.getInstance().logPlatformStatis(REFRESH_CTP_FAIL);
                    throw e;
                }
            }
            if (TechPlatform.ESUNNY.equals(techPlatform)) {
                try {
                    new EsunnyV9().run();
                } catch (Exception e) {
                    AppLog.e(e.getMessage(), e);
                    PlatformMonitor.getInstance().logPlatformStatis(REFRESH_ESUNNY_FAIL);
                    throw e;
                }
            }
            Counter.getInstance().count();
        } catch (Exception e) {
            AppLog.e(e.getMessage(), e);
            AppLog.e("DAEMON Stop at exception");
            new SmsSender().sendErrMsg();
        }
        AppLog.e("Counter " + Counter.getInstance().getCount());
        AppLog.e("DAEMON END");
    }
}
