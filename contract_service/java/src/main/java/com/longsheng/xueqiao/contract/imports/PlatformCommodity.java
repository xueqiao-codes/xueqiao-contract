package com.longsheng.xueqiao.contract.imports;

import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatform;

public class PlatformCommodity {

    private int brokerEntryId;
    private TechPlatform techPlatform;
    private String exchange;
    private String commodityType;
    private String commodityCode;

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public int getBrokerEntryId() {
        return brokerEntryId;
    }

    public void setBrokerEntryId(int brokerEntryId) {
        this.brokerEntryId = brokerEntryId;
    }

    public TechPlatform getTechPlatform() {
        return techPlatform;
    }

    public void setTechPlatform(TechPlatform techPlatform) {
        this.techPlatform = techPlatform;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PlatformCommodity) {
            PlatformCommodity techPlatformCommodity = (PlatformCommodity) obj;
            return techPlatformCommodity.getTechPlatform() == null ? this.getTechPlatform() == null : techPlatformCommodity.getTechPlatform().equals(this.techPlatform)
                    && techPlatformCommodity.getBrokerEntryId() == this.brokerEntryId
                    && techPlatformCommodity.getCommodityCode() == null ? this.getCommodityCode() == null : techPlatformCommodity.getCommodityCode().equals(this.commodityCode)
                    && techPlatformCommodity.getCommodityType() == null ? this.getCommodityType() == null : techPlatformCommodity.getCommodityType().equals(this.commodityType)
                    && techPlatformCommodity.getExchange() == null ? this.getExchange() == null : techPlatformCommodity.getExchange().equals(this.exchange);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.techPlatform +"|"+this.brokerEntryId+"|"+this.exchange+"|"+this.commodityType+"|"+this.commodityCode;
    }
}
