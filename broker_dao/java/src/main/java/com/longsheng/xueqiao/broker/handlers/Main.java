package com.longsheng.xueqiao.broker.handlers;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.soldier.platform.zookeeper.IConfProvider;
import org.soldier.platform.zookeeper.ZooKeeperManager;
import org.soldier.platform.zookeeper.ZooKeeperManagerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static String XUEQIAO_SPLIT1 = "[xq_split1]";
    private final static String XUEQIAO_SPLIT2 = "[xq_split2]";

    public static void main(String[] args) {
        String info = "ipAddress[xq_split2]tcp://218.76.45.156:41205,tcp://218.76.45.156:41205[xq_split1]broker_code[xq_split2]9999[xq_split1]Cecil[xq_split2]3258";


        Map<String, String> map = new HashMap<>();
        String[] pairs = StringUtils.splitByWholeSeparator(info, XUEQIAO_SPLIT1);

        System.out.println("pairs length: " + pairs.length);
        for (String s : pairs) {
            System.out.println("s: " + s);
            String[] pair = StringUtils.splitByWholeSeparator(s, XUEQIAO_SPLIT2);
            if (pair.length == 2) {
                System.out.println("pair0 : " + pair[0]);
                System.out.println("pair1 : " + pair[1]);
                map.put(pair[0], pair[1]);
            } else {
                System.out.println(pair.length);
            }
        }

        String key = "xueqiao_broker";
        byte[] data = "test".getBytes();
        String path = "xueqiao/broker/access/${brokerId}/${broker_access_entry_id}";
        try {
            ZooKeeperManager manager = ZooKeeperManagerFactory.Global().get(key);
            manager.getZooKeeper().create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (IConfProvider.ConfException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }


    }


}
