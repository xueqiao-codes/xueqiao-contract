package com.longsheng.xueqiao.contract.online.dao.data;

import com.longsheng.xueqiao.contract.dao.handlers.SledContractHandler;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledContractOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContract;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContractPage;
import com.longsheng.xueqiao.contract.online.dao.config.WorkingStatus;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SledContractAccess {

    private final IConnectionProvider connProvider;

    public SledContractAccess(IConnectionProvider iConnectionProvider) {
        connProvider = iConnectionProvider;
    }

    public SledContractPage getSledContractPage(ReqSledContractOption option, int pageIndex, int pageSize) throws TException {
        ReqTSledContractOption tOption = getReqTSledContractOption(option);
        TSledContractPage tPage = new SledContractHandler(connProvider).query(tOption, pageIndex, pageSize);
        return mapToAo(tPage);
    }

    public SledContractDetailsPage getSledContractDetailPage(ReqSledContractDetailsOption option, int pageIndex, int pageSize) throws TException {
        if (pageSize <= 0 || pageSize > 50) {
            pageSize = 50;
        }

        SledContractPage sledContractPage = getSledContractPage(option, pageIndex, pageSize);

        List<Integer> sledCommodityIds = new ArrayList<>();
        Map<Integer, SledContract> sledCommodityIdMaps = new HashMap<>();
        if (sledContractPage.getTotal() > 0) {
            for (SledContract sledContract : sledContractPage.getPage()) {
                sledCommodityIdMaps.put(sledContract.getSledCommodityId(), sledContract);
                sledCommodityIds.add(sledContract.getSledCommodityId());
            }
        }

        SledCommodityAccess sledCommodityAccess = new SledCommodityAccess(connProvider);
        ReqSledCommodityOption reqCommodityOption = new ReqSledCommodityOption();
        reqCommodityOption.setSledCommodityIdList(sledCommodityIds);
        SledCommodityPage sledCommodityPage = sledCommodityAccess.getPage(reqCommodityOption, pageIndex, pageSize);
        SledContractDetailsPage page = new SledContractDetailsPage();
        for (SledCommodity sledCommodity : sledCommodityPage.getPage()) {
            SledContractDetails sledContractDetails = new SledContractDetails();
            sledContractDetails.setSledCommodity(sledCommodity);
            sledContractDetails.setSledContract(sledCommodityIdMaps.get(sledCommodity.getSledCommodityId()));
            page.addToPage(sledContractDetails);
        }
        page.setTotal(sledContractPage.getTotal());
        return page;
    }

    private SledContractPage getSledContractPage(ReqSledContractDetailsOption option, int pageIndex, int pageSize) throws TException {
        ReqSledContractOption reqSledContractOption = new ReqSledContractOption();
        if (option.isSetSledContractIds()) {
            List<Integer> list = new ArrayList<>();
            list.addAll(option.getSledContractIds());
            reqSledContractOption.setSledContractIdList(list);
        }
        return getSledContractPage(reqSledContractOption, pageIndex, pageSize);
    }

    private ReqTSledContractOption getReqTSledContractOption(ReqSledContractOption option) {
        ReqTSledContractOption tOption = new ReqTSledContractOption();

        if (option.isSetPlatformEnv()) {
            tOption.setTechPlatformEnv(option.getPlatformEnv().getValue());
        }
        if (option.isSetSledContractIdList()) {
            tOption.setSledContractIds(option.getSledContractIdList());
        } else {
            tOption.setWorkingStatus(WorkingStatus.WORKING.getValue());
        }
        if (option.isSetSledCommodityId()) {
            tOption.setSledCommodityId(option.getSledCommodityId());
        }
        if (option.isSetSledContractCode()) {
            tOption.setSledContractCode(option.getSledContractCode());
        }
        if (option.isSetContractStatus()) {
            tOption.setContractStatus(option.getContractStatus().getValue());
        }
        if (option.isSetContractCodePartical()) {
            tOption.setContractCodePartical(option.getContractCodePartical());
        }
        if (option.isSetSledTagPartical()) {
            tOption.setSledTagPartical(option.getSledTagPartical());
        }
        if (option.isSetContractEngNamePartical()) {
            tOption.setContractEngNamePartical(option.getContractEngNamePartical());
        }
        if (option.isSetContractCnNamePartical()) {
            tOption.setContractCnNamePartical(option.getContractCnNamePartical());
        }
        return tOption;
    }


    protected SledContractPage mapToAo(TSledContractPage tPage) {
        SledContractPage page = new SledContractPage();
        page.setTotal(tPage.getTotal());
        List<SledContract> sledContractDetails = new ArrayList<>();

        for (TSledContract tSledContract : tPage.getPage()) {

            SledContract sledContract = new SledContract();
            sledContract.setSledContractId(tSledContract.getSledContractId());
            sledContract.setSledCommodityId(tSledContract.getSledCommodityId());
            sledContract.setRelateContractIds(tSledContract.getRelateContractIds());
            sledContract.setSledContractCode(tSledContract.getSledContractCode());
            sledContract.setSledTag(tSledContract.getSledTag());
            sledContract.setContractEngName(tSledContract.getEngName());
            sledContract.setContractCnName(tSledContract.getCnName());
            sledContract.setContractTcName(tSledContract.getTcName());
            sledContract.setContractExpDate(tSledContract.getContractExpDate());
            sledContract.setLastTradeDate(tSledContract.getLastTradeDate());
            sledContract.setFirstNoticeDate(tSledContract.getFirstNoticeDate());
            sledContract.setPlatformEnv(TechPlatformEnv.findByValue(tSledContract.getTechPlatformEnv()));
            sledContract.setContractStatus(ContractStatus.findByValue(tSledContract.getContractStatus()));

            sledContract.setCreateTimestamp(tSledContract.getCreateTimestamp());
            sledContract.setLastModityTimestamp(tSledContract.getLastModityTimestamp());
            sledContract.setActiveStartTimestamp(tSledContract.getActiveStartTimestamp());
            sledContract.setActiveEndTimestamp(tSledContract.getActiveEndTimestamp());
            sledContract.setSubscribeXQQuote(tSledContract.getSubscribeXQQuote() == 1 ? true : false);
            sledContractDetails.add(sledContract);
        }
        page.setPage(sledContractDetails);
        return page;
    }
}
