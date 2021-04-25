package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.utils.ContractDao;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledContractOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContract;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledContractPage;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.EditStatus;
import com.longsheng.xueqiao.contract.thriftapi.SledContractEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledContractEditPage;
import com.longsheng.xueqiao.contract.thriftapi.WorkingStatus;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

public class SledContractAccess {

    protected ContractDaoServiceStub stub = ContractDao.getInstance().getServiceStub();
    protected int routeKey = RandomUtils.nextInt();
    protected int timeout = 3000;

    public SledContractEditPage getSledContractPage(ReqSledContractOption option, int pageIndex, int pageSize) throws TException {
        ReqTSledContractOption tOption = getReqTSledContractOption(option);
        TSledContractPage tPage = stub.reqTSledContract(routeKey, timeout, tOption, pageIndex, pageSize);
        return mapToAo(tPage);
    }

    private ReqTSledContractOption getReqTSledContractOption(ReqSledContractOption option) {
        ReqTSledContractOption tOption = new ReqTSledContractOption();

        if (option.isSetPlatformEnv()) {
            tOption.setTechPlatformEnv(option.getPlatformEnv().getValue());
        }
        if (option.isSetSledContractIdList()) {
            tOption.setSledContractIds(option.getSledContractIdList());
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


    protected SledContractEditPage mapToAo(TSledContractPage tPage) {
        SledContractEditPage page = new SledContractEditPage();
        page.setTotal(tPage.getTotal());
        List<SledContractEdit> sledContractDetails = new ArrayList<>();

        for (TSledContract tSledContract : tPage.getPage()) {

            SledContractEdit sledContractEdit = new SledContractEdit();
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

            sledContractEdit.setSledContract(sledContract);
            sledContractEdit.setEditStatus(EditStatus.findByValue(tSledContract.getEditstatus()));
            sledContractEdit.setWorkingStatus(WorkingStatus.findByValue(tSledContract.getWorkingStatus()));
            sledContractDetails.add(sledContractEdit);
        }
        page.setPage(sledContractDetails);
        return page;
    }
}
