package com.xueqiao;

import com.xueqiao.analysis.*;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.container.DaemonContainer;

import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

public class Entry {

    public static void main(String[] args) {

        com.longsheng.xueqiao.util.esunny9.LibraryLoader.init();
        AppLog.init("broker_host_analysis");

        Date date = new Date();
        String log = "time now: " + DateFormat.getInstance().format(date);
        AppLog.d(log);
        doUpdate();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void doUpdate() {
        try {
            AppLog.e("DAEMON START");
            DaemonContainer container = new DaemonContainer();
            Properties prop = container.getDaemonProperties();
            AppLog.d(prop);
            AppLog.d("init commodity map");
            sleep(2000);
            new CtpContractUpdateDaemon().run();
        } catch (Exception e) {
            AppLog.e(e.getMessage(), e);
            AppLog.e("DAEMON Stop at exception");
            new SmsSender().sendErrMsg();
        }

        AppLog.e("DAEMON END");
    }
}
