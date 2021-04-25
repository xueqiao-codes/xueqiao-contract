package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.RemoveSledExchangeOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledExchange;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.client.ContractServiceStub;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.util.ArrayList;
import java.util.List;

public class SledExchangeUpdate {

    private static ContractDaoServiceStub stub = new ContractDaoServiceStub();
    private static int timeout = 3000;
    private static int routerKey = 0;

    public SledExchange addSledExchange(SledExchange sledExchange) throws TException {
        sledExchange.unsetSledExchangeId();
        checkSledExchangeMic(sledExchange);
        TSledExchange tSledExchange = gettSledExchange(sledExchange);
        int sledExchangeId = stub.addTSledExchange(routerKey, timeout, tSledExchange);
        return getSledExchanges(sledExchangeId);
    }

    private void checkSledExchangeMic(SledExchange sledExchange) throws TException {
        SledExchangeAccess access = new SledExchangeAccess();
        ReqSledExchangeOption option = new ReqSledExchangeOption();
        option.setExchangeMic(sledExchange.getExchangeMic());
        SledExchangePage page = access.getPage(option, 0, 1);
        AppLog.i("input exchange:  " + sledExchange);
        if (page.getPageSize() > 0) {
            AppLog.i("old exchange page: " + page);
            if (sledExchange.getSledExchangeId() != page.getPage().get(0).getSledExchangeId()) {
                throw new ErrorInfo(SledContractErrorCode.SLED_EXCHANGE_EXISTS.getValue(), "sled exchange exists.");
            }
        }
    }

    private TSledExchange gettSledExchange(SledExchange sledExchange) {
        TSledExchange tSledExchange = new TSledExchange();
        if (sledExchange.isSetSledExchangeId()) {
            tSledExchange.setSledExchangeId(sledExchange.getSledExchangeId());
        }
        if (sledExchange.isSetExchangeMic()) {
            tSledExchange.setExchangeMic(sledExchange.getExchangeMic());
        }
        if (sledExchange.isSetCountry()) {
            tSledExchange.setCountry(sledExchange.getCountry());
        }
        if (sledExchange.isSetCountryCode()) {
            tSledExchange.setCountryCode(sledExchange.getCountryCode());
        }
        if (sledExchange.isSetOperatingMic()) {
            tSledExchange.setOperatingMic(sledExchange.getOperatingMic());
        }
        if (sledExchange.isSetOperatingMicType()) {
            tSledExchange.setOperatingMicType(sledExchange.getOperatingMicType().getValue());
        }
        if (sledExchange.isSetNameInstitution()) {
            tSledExchange.setNameInstitution(sledExchange.getNameInstitution());
        }

        if (sledExchange.isSetAcronym()) {
            tSledExchange.setAcronym(sledExchange.getAcronym());
        }
        if (sledExchange.isSetCity()) {
            tSledExchange.setCity(sledExchange.getCity());
        }
        if (sledExchange.isSetWebsite()) {
            tSledExchange.setWebsite(sledExchange.getWebsite());
        }
        if (sledExchange.isSetCnName()) {
            tSledExchange.setCnName(sledExchange.getCnName());
        }
        if (sledExchange.isSetCnAcronym()) {
            tSledExchange.setCnAcronym(sledExchange.getCnAcronym());
        }
        if (sledExchange.isSetActiveStartTimestamp()) {
            tSledExchange.setActiveStartTimestamp(sledExchange.getActiveStartTimestamp());
        }
        if (sledExchange.isSetActiveEndTimestamp()) {
            tSledExchange.setActiveEndTimestamp(sledExchange.getActiveEndTimestamp());
        }
        if (sledExchange.isSetZoneId()) {
            tSledExchange.setZoneId(sledExchange.getZoneId());
        }
        if (sledExchange.isSetTimeLagMs()){
            tSledExchange.setTimeLagMs(sledExchange.getTimeLagMs());
        }
        return tSledExchange;
    }

    public SledExchange updateSledExchange(SledExchange sledExchange) throws TException {
        if (sledExchange.isSetExchangeMic()) {
            checkSledExchangeMic(sledExchange);
        }
        TSledExchange tSledExchange = gettSledExchange(sledExchange);
        int sledExchangeId = stub.updateTSledExchange(routerKey, timeout, tSledExchange);
        return getSledExchanges(sledExchangeId);
    }

    public void deleteSledExchange(int sledExchangeId) throws TException {
        SledExchangeAccess access = new SledExchangeAccess();
        ReqSledExchangeOption option = new ReqSledExchangeOption();
        option.addToSledExchangeIds(sledExchangeId);
        SledExchangePage page = access.getPage(option, 0, 1);
        if (page.getPageSize() > 0) {
            SledExchange sledExchange = page.getPage().get(0);
            SledCommodityAccess commodityAccess = new SledCommodityAccess();
            ReqSledCommodityOption commodityOption = new ReqSledCommodityOption();
            commodityOption.setExchangeMic(sledExchange.getExchangeMic());
            SledCommodityEditPage commodityPage = commodityAccess.getPage(commodityOption, 0, 1);
            if (commodityPage.getTotal() > 0) {
                throw new ErrorInfo(SledContractErrorCode.SLED_COMMODITY_EXISTS.getValue(),
                        "Sled commodity exists, delete exchange fail.");
            }
        }

        RemoveSledExchangeOption removeOption = new RemoveSledExchangeOption();
        removeOption.setSledExchangeId(sledExchangeId);
        stub.removeSledExchange(removeOption);
    }

    private SledExchange getSledExchanges(int sledExchangeId) throws TException {
        ReqSledExchangeOption option = new ReqSledExchangeOption();
        List<Integer> ids = new ArrayList<>();
        ids.add(sledExchangeId);
        option.setSledExchangeIds(ids);
        SledExchangeAccess sledExchangeAccess = new SledExchangeAccess();
        SledExchangePage page = sledExchangeAccess.getPage(option, 0, 1);
        if (page.getPage().isEmpty()) {
            throw new ErrorInfo(SledContractErrorCode.SLED_EXCHANGE_NOT_FOUND.getValue(), "update exchange fail");
        } else {
            return page.getPage().get(0);
        }
    }


}
