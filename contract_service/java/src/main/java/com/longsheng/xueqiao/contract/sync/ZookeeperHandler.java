package com.longsheng.xueqiao.contract.sync;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.thriftapi.SledTradeTime;
import com.longsheng.xueqiao.contract.utils.JsonFactory;
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
import java.util.List;

public class ZookeeperHandler {

    private final static String TRADE_TIME_KEY = "xueqiao_trade_time";
    private final static String TRADE_TIME_PATH = "/xueqiao/trade_time/";
    private ZooKeeperManager manager;

    public ZookeeperHandler() {
        try {
            manager = ZooKeeperManagerFactory.Global().get(TRADE_TIME_KEY);
        } catch (Throwable e) {
            AppLog.d(e.getMessage(), e);
        }
    }

    public void updateToZookeeper( List<SledTradeTime> sledTradeTimes) throws ErrorInfo {

        try {
            AppLog.i("syncAll trade time : " + sledTradeTimes);
            syncToZookeeper(sledTradeTimes);
        } catch (Exception e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), "Zookeeper update access fail");
        }
    }

    private static String getTradeTimePath(int sledCommodityId) {
        return TRADE_TIME_PATH + sledCommodityId;
    }

    private void syncToZookeeper( List<SledTradeTime> sledTradeTimes) throws IConfProvider.ConfException, IOException, KeeperException, InterruptedException {
       for (SledTradeTime sledTradeTime : sledTradeTimes) {
           byte[] data = ProtocolUtil.serialize2Bytes(JsonFactory.getInstance().getFactory(), sledTradeTime);
           String path = getTradeTimePath(sledTradeTime.getSledCommodityId());
           Stat stat = manager.getZooKeeper().exists(path, false);

           if (stat == null) {
               manager.getZooKeeper().create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
           } else {
               int version = -1;
               manager.getZooKeeper().setData(path, data, version);
           }
       }
    }
}
