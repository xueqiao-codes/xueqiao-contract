package com.longsheng.xueqiao.broker.handlers;

import java.util.List;

public class ContractSyncObject {

    private String editDbRole;
    private String onlineDbRole;
    private List<String> deleteOnlineTableNames;
    private List<Integer> commodityMappingBrokerIds;

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
