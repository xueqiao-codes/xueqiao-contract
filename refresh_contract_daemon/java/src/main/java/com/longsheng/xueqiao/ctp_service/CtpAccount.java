package com.longsheng.xueqiao.ctp_service;

import org.soldier.base.logger.AppLog;

public class CtpAccount {

    private String appId;
    private String authCode;
    private String brokerId;
    private String userId;
    private String password;
    private String host;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

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

    public void print(){
        StringBuilder builder = new StringBuilder(128);
        builder.append("CtpAccount: ").append("getBrokerId: ").append(brokerId)
                .append(" ").append("getUserId: ").append(userId)
                .append(" ").append("getPassword: ").append(password)
                .append(" ").append("getHost: ").append(host)
                .append(" ").append("getAppId: ").append(appId)
                .append(" ").append("getAuthCode: ").append(authCode);
        AppLog.i(builder);
        System.out.println(builder);
    }
}
