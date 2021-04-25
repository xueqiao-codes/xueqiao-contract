package com.longsheng.daemon;

import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityMap;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledCommodity;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContract;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledExchange;
import com.longsheng.xueqiao.contract.thriftapi.ContractVersion;
import com.longsheng.xueqiao.contract.thriftapi.SledTradeTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractDbData {

    private List<TSledCommodity> tSledCommodities;
    private List<TSledExchange> tSledExchanges;
    private List<TSledContract> tSledContracts;
    private List<ContractVersion> contractVersions;
    private Map<Integer,List<TCommodityMap>> commodityMappingMap = new HashMap<>();
    private ContractVersion contractVersion;
    private List<SledTradeTime> sledTradeTimes;

    public List<TSledCommodity> gettSledCommodities() {
        return tSledCommodities;
    }

    public void settSledCommodities(List<TSledCommodity> tSledCommodities) {
        this.tSledCommodities = tSledCommodities;
    }

    public List<TSledExchange> gettSledExchanges() {
        return tSledExchanges;
    }

    public void settSledExchanges(List<TSledExchange> tSledExchanges) {
        this.tSledExchanges = tSledExchanges;
    }

    public List<TSledContract> gettSledContracts() {
        return tSledContracts;
    }

    public void settSledContracts(List<TSledContract> tSledContracts) {
        this.tSledContracts = tSledContracts;
    }

    public List<ContractVersion> getContractVersions() {
        return contractVersions;
    }

    public void setContractVersions(List<ContractVersion> contractVersions) {
        this.contractVersions = contractVersions;
    }

    public Map<Integer, List<TCommodityMap>> getCommodityMappingMap() {
        return commodityMappingMap;
    }

    public void setCommodityMappingMap(Map<Integer, List<TCommodityMap>> commodityMappingMap) {
        this.commodityMappingMap = commodityMappingMap;
    }

    public ContractVersion getContractVersion() {
        return contractVersion;
    }

    public void setContractVersion(ContractVersion contractVersion) {
        this.contractVersion = contractVersion;
    }

    public List<SledTradeTime> getSledTradeTimes() {
        return sledTradeTimes;
    }

    public void setSledTradeTimes(List<SledTradeTime> sledTradeTimes) {
        this.sledTradeTimes = sledTradeTimes;
    }
}
