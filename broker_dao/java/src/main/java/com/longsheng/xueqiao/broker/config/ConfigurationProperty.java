package com.longsheng.xueqiao.broker.config;

import net.qihoo.qconf.Qconf;
import net.qihoo.qconf.QconfException;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.id_maker.IdMaker;
import org.soldier.platform.id_maker.IdMakerFactory;

import java.util.Properties;

public class ConfigurationProperty {

    private String roleName;

    private static ConfigurationProperty config;

    private IdMaker brokerIdMaker;

    private IdMaker brokerAccessIdMaker;

    private ConfigurationProperty() {

    }

    public static ConfigurationProperty instance() {

        if (config == null) {
            synchronized (ConfigurationProperty.class) {
                if (config == null) {
                    config = new ConfigurationProperty();
                }
            }
        }
        return config;
    }

    public void init(Properties props) throws IdException, QconfException {

        this.roleName = props.getProperty("roleName", "role_xueqiao_broker");
        int brokerIdMakerNum = Integer.parseInt(props.getProperty("brokerIdMaker", "101"));
        int brokerAccessIdMakerNum = Integer.parseInt(props.getProperty("brokerAccessIdMaker", "102"));

        this.brokerIdMaker = IdMakerFactory.getInstance().getIdMaker(brokerIdMakerNum);
        this.brokerAccessIdMaker = IdMakerFactory.getInstance().getIdMaker(brokerAccessIdMakerNum);


        System.out.println("roleName=" + roleName);
        System.out.println("brokerIdMakerNum=" + brokerIdMakerNum);
        System.out.println("brokerAccessIdMakerNum=" + brokerAccessIdMakerNum);

        if (this.brokerIdMaker == null) {
            throw new IdException("brokerIdMaker create failed!");
        }
        if (roleName == null || "".equals(roleName)) {
            throw new IllegalArgumentException("role name not found.");
        }
    }

    public String getRoleName() {
        return roleName;
    }

    public IdMaker getBrokerIdMaker() {
        return brokerIdMaker;
    }

    public IdMaker getBrokerAccessIdMaker() {
        return brokerAccessIdMaker;
    }
}
