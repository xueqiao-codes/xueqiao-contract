package com.longsheng.daemon;

import com.google.gson.Gson;
import net.qihoo.qconf.Qconf;
import net.qihoo.qconf.QconfException;
import org.soldier.base.logger.AppLog;

import java.util.List;

public class SyncConfig {
    private String editDbRole;
    private String onlineDbRole;
    private List<String> deleteOnlineTableNames;
    private List<Integer> commodityMappingBrokerIds;

    public static SyncConfig readConfig() throws Exception {
        SyncConfig config = null;
        try {
            String configJson = Qconf.getConf("xueqiao/contract/contract_online");
            System.out.println("config json: "+ configJson);
            config = new Gson().fromJson(configJson, SyncConfig.class);
        } catch (QconfException e) {
            AppLog.e(e.getMessage(), e);
        }

        if (config == null) {
            throw new Exception("read config from qconf failed!");
        } else {
            return config;
        }
    }

    public String getEditDbRole() {
        return editDbRole;
    }

    public void setEditDbRole(String editDbRole) {
        this.editDbRole = editDbRole;
    }

    public String getOnlineDbRole() {
        return onlineDbRole;
    }

    public void setOnlineDbRole(String onlineDbRole) {
        this.onlineDbRole = onlineDbRole;
    }

    public List<String> getDeleteOnlineTableNames() {
        return deleteOnlineTableNames;
    }

    public void setDeleteOnlineTableNames(List<String> deleteOnlineTableNames) {
        this.deleteOnlineTableNames = deleteOnlineTableNames;
    }

    public List<Integer> getCommodityMappingBrokerIds() {
        return commodityMappingBrokerIds;
    }

    public void setCommodityMappingBrokerIds(List<Integer> commodityMappingBrokerIds) {
        this.commodityMappingBrokerIds = commodityMappingBrokerIds;
    }
}
