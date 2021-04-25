package com.longsheng.xueqiao.currency.dao.config;

import java.util.Properties;

import org.soldier.platform.id_maker.IdException;
import net.qihoo.qconf.QconfException;
import org.soldier.platform.id_maker.IdMaker;
import org.soldier.platform.id_maker.IdMakerFactory;

public class ConfigurationProperty {

    private String roleName;

    private static ConfigurationProperty config;

    private IdMaker historyIdMaker;

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
        this.roleName = props.getProperty("contract_dao_role", "role_xueqiao_contract");
        historyIdMaker = IdMakerFactory.getInstance().getIdMaker(Integer.parseInt(props.getProperty("history_id_maker", "216")));

        System.out.println("roleName=" + roleName);

        if (roleName == null || "".equals(roleName)) {
            throw new IllegalArgumentException("role name not found.");
        }
    }

    public String getRoleName() {
        return roleName;
    }

    public IdMaker getHistoryIdMaker() {
        return historyIdMaker;
    }
}
