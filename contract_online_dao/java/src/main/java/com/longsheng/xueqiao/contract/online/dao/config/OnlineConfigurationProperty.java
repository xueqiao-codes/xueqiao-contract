package com.longsheng.xueqiao.contract.online.dao.config;

import java.util.Properties;

import net.qihoo.qconf.QconfException;

public class OnlineConfigurationProperty {

    private String roleName;

    private static OnlineConfigurationProperty config;

    private OnlineConfigurationProperty() {
    }

    public static OnlineConfigurationProperty instance() {
        if (config == null) {
            synchronized (OnlineConfigurationProperty.class) {
                if (config == null) {
                    config = new OnlineConfigurationProperty();
                }
            }
        }
        return config;
    }

    public void init(Properties props) throws QconfException {
        this.roleName = props.getProperty("online_contract_dao_role", "role_xueqiao_contract_online");
        System.out.println("onlineRoleName=" + roleName);

        if (roleName == null || "".equals(roleName)) {
            throw new IllegalArgumentException("role name not found.");
        }
    }

    public String getRoleName() {
        return roleName;
    }
}
