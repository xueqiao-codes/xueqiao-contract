package com.longsheng.daemon;

public class PlatformCommodity {

    private String exchange;

    private String commodityType;

    private String commodityCode;

    public PlatformCommodity() {

    }

    public PlatformCommodity(String exchange, String commodityType, String commodityCode) {
        this.exchange = exchange;
        this.commodityType = commodityType;
        this.commodityCode = commodityCode;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

}
