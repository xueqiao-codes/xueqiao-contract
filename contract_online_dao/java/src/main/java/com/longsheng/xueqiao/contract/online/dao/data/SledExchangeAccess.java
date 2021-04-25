package com.longsheng.xueqiao.contract.online.dao.data;

import com.longsheng.xueqiao.contract.dao.handlers.SledExchangeHandler;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledExchangeOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledExchange;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledExchangePage;
import com.longsheng.xueqiao.contract.standard.thriftapi.ExchangeOperatingMicType;
import com.longsheng.xueqiao.contract.standard.thriftapi.ReqSledExchangeOption;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchange;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledExchangePage;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

public class SledExchangeAccess {
    private final IConnectionProvider connProvider;

    public SledExchangeAccess(IConnectionProvider iConnectionProvider) {
        connProvider = iConnectionProvider;
    }

    public SledExchangePage getPage(ReqSledExchangeOption option, int pageIndex, int pageSize) throws TException {

        ReqTSledExchangeOption tOption = map2TOption(option);
        TSledExchangePage tPage = new SledExchangeHandler(connProvider).query(tOption, pageIndex, pageSize);
        SledExchangePage page = new SledExchangePage();
        page.setTotal(tPage.getTotal());
        page.setPage(mapToAo(tPage.getPage()));
        return page;
    }

    private ReqTSledExchangeOption map2TOption(ReqSledExchangeOption option) {
        ReqTSledExchangeOption tOption = new ReqTSledExchangeOption();
        if (option.isSetExchangeMic()) {
            tOption.setExchangeMic(option.getExchangeMic());
        }
        if (option.isSetSledExchangeIds()) {
            tOption.setSledExchangeIds(option.getSledExchangeIds());
        }
        if (option.isSetExchangeMicPartical()) {
            tOption.setExchangeMicPartical(option.getExchangeMicPartical());
        }
        if (option.isSetNameInstitutionPartical()) {
            tOption.setNameInstitutionPartical(option.getNameInstitutionPartical());
        }
        if (option.isSetAcronymPartical()) {
            tOption.setAcronymPartical(option.getAcronymPartical());
        }
        if (option.isSetCnAcronymPartical()) {
            tOption.setCnAcronymPartical(option.getCnAcronymPartical());
        }
        if (option.isSetCnNamePartical()) {
            tOption.setCnNamePartical(option.getCnNamePartical());
        }
        return tOption;
    }

    protected List<SledExchange> mapToAo(List<TSledExchange> daoData) {

        List<SledExchange> list = new ArrayList<>();
        for (TSledExchange tSledExchange : daoData) {
            SledExchange sledExchange = new SledExchange();
            sledExchange.setSledExchangeId(tSledExchange.getSledExchangeId());
            sledExchange.setExchangeMic(tSledExchange.getExchangeMic());
            sledExchange.setCountry(tSledExchange.getCountry());
            sledExchange.setCountryCode(tSledExchange.getCountryCode());
            sledExchange.setOperatingMic(tSledExchange.getOperatingMic());
            sledExchange.setOperatingMicType(ExchangeOperatingMicType.findByValue(tSledExchange.getOperatingMicType()));
            sledExchange.setNameInstitution(tSledExchange.getNameInstitution());
            sledExchange.setAcronym(tSledExchange.getAcronym());
            sledExchange.setCity(tSledExchange.getCity());
            sledExchange.setWebsite(tSledExchange.getWebsite());
            sledExchange.setCnName(tSledExchange.getCnName());
            sledExchange.setCnAcronym(tSledExchange.getCnAcronym());
            sledExchange.setCreateTimestamp(tSledExchange.getCreateTimestamp());
            sledExchange.setLastModityTimestamp(tSledExchange.getLastModityTimestamp());
            sledExchange.setActiveStartTimestamp(tSledExchange.getActiveStartTimestamp());
            sledExchange.setActiveEndTimestamp(tSledExchange.getActiveEndTimestamp());
            sledExchange.setZoneId(tSledExchange.getZoneId());
            sledExchange.setTimeLagMs(tSledExchange.getTimeLagMs());
            list.add(sledExchange);
        }
        return list;
    }
}
