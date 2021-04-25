package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledCommodityOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodity;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledCommodityType;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.thrift.TException;

import java.util.*;

public class TradeTimeUpdate {

    public void addSpecTradeTime(SpecTradeTime specTradeTime) throws TException {

        addComposeCommodityIds(specTradeTime);
        new ContractDaoServiceStub().addSpecTradeTime(specTradeTime);
    }

    private void addComposeCommodityIds(SpecTradeTime specTradeTime) throws TException {
        List<Integer> sledCommodityIds = specTradeTime.getSledCommodityIds();
        List<SledCommodity> allSledCommodity = getComposeCommodities(SledCommodityType.SPREAD_COMMODITY);
        allSledCommodity.addAll(getComposeCommodities(SledCommodityType.SPREAD_MONTH));

        Set<Integer> allIds = new HashSet<>();
        for (int id : sledCommodityIds) {
            for (SledCommodity sledCommodity : allSledCommodity) {
                if (sledCommodity.getRelateCommodityIds().contains(id)) {
                    allIds.add(sledCommodity.getSledCommodityId());
                }
            }
        }

        allIds.addAll(sledCommodityIds);
        List<Integer> finalIds = new ArrayList<>();
        finalIds.addAll(allIds);
        specTradeTime.setSledCommodityIds(finalIds);
    }

    public void updateSpecTradeTime(SpecTradeTime specTradeTime) throws TException {
        addComposeCommodityIds(specTradeTime);
        new ContractDaoServiceStub().updateSpecTradeTime(specTradeTime);
    }

    private List<SledCommodity> getComposeCommodities(SledCommodityType type) throws TException {
        SledCommodityEditPage pageSC = getComposeCommodityPage(type);
        List<SledCommodity> allSledCommodity = new ArrayList<>();
        for (SledCommodityEdit sledCommodityEdit : pageSC.getPage()) {
            allSledCommodity.add(sledCommodityEdit.getSledCommodity());
        }
        return allSledCommodity;
    }

    private SledCommodityEditPage getComposeCommodityPage(SledCommodityType spreadCommodity) throws TException {
        SledCommodityAccess access = new SledCommodityAccess();
        ReqSledCommodityOption option = new ReqSledCommodityOption();
        option.setSledCommodityType(spreadCommodity);
        return access.getPage(option, 0, Integer.MAX_VALUE);
    }
}
