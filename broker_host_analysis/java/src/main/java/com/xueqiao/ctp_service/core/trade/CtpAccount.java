package com.xueqiao.ctp_service.core.trade;

import org.soldier.base.logger.AppLog;

public class CtpAccount {

    private int brokerEntryId;
    private String brokerAccessName;

    private String brokerId;
    private String userId;
    private String password;
    private String host;

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String print() {
        StringBuilder builder = new StringBuilder(128);
        builder.append("CtpAccount: ").append("getBrokerId: ").append(brokerId)
                .append(" ").append("getUserId: ").append(userId)
                .append(" ").append("getPassword: ").append(password)
                .append(" ").append("getHost: ").append(host);
        AppLog.i(builder);
        System.out.println(builder);
        return builder.toString();
    }

    @Override
    public String toString() {
        return print();
    }

    public String getBrokerAccessName() {
        return brokerAccessName;
    }

    public void setBrokerAccessName(String brokerAccessName) {
        this.brokerAccessName = brokerAccessName;
    }

    public int getBrokerEntryId() {
        return brokerEntryId;
    }

    public void setBrokerEntryId(int brokerEntryId) {
        this.brokerEntryId = brokerEntryId;
    }
}
