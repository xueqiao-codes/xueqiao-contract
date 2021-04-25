package com.xueqiao.analysis;

import com.longsheng.xueqiao.goose.thriftapi.client.GooseAoStub;
import net.qihoo.qconf.Qconf;
import net.qihoo.qconf.QconfException;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;

public class SmsSender {

    public SmsSender() {
        try {
            env = Qconf.getConf("platform/environment");
        } catch (QconfException e) {
            e.printStackTrace();
        }
    }

    private String env = "init";

    public void send2Maintance(String msg) {
        GooseAoStub stub = new GooseAoStub();
        try {
            String tel = "18576421291";
            stub.sendUserNotificationSms(tel, env + ": " + msg);
        } catch (TException e) {
            AppLog.e(e.getMessage(), e);
        }
    }

    public void sendErrMsg() {
        String msg = "analysis broker host ";
        send2Maintance(msg);
    }
}
