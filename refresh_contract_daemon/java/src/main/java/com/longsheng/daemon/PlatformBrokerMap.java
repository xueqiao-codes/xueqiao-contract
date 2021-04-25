package com.longsheng.daemon;

import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;

public class PlatformBrokerMap {

    private TechPlatform techPlatform;
    private int brokerEntryId;

    public PlatformBrokerMap(TechPlatform platform, int brokerEntryId) {
        this.techPlatform = platform;
        this.brokerEntryId = brokerEntryId;
    }

    public TechPlatform getTechPlatform() {
        return techPlatform;
    }

    public void setTechPlatform(TechPlatform techPlatform) {
        this.techPlatform = techPlatform;
    }

    public int getBrokerEntryId() {
        return brokerEntryId;
    }

    public void setBrokerEntryId(int brokerEntryId) {
        this.brokerEntryId = brokerEntryId;
    }
}
