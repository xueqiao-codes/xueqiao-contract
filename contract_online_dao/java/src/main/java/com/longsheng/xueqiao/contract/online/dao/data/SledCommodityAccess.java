package com.longsheng.xueqiao.contract.online.dao.data;

import com.longsheng.xueqiao.contract.dao.handlers.SledCommodityHandler;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledCommodityOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityPage;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledCommodity;
import com.longsheng.xueqiao.contract.dao.utils.JsonFactory;
import com.longsheng.xueqiao.contract.online.dao.config.WorkingStatus;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.util.ProtocolUtil;

import java.util.ArrayList;
import java.util.List;

public class SledCommodityAccess {
    private final IConnectionProvider connProvider;

    public SledCommodityAccess(IConnectionProvider iConnectionProvider) {
        connProvider = iConnectionProvider;
    }

    public SledCommodityPage getPage(ReqSledCommodityOption option, int pageIndex, int pageSize) throws TException {

        ReqTSledCommodityOption tOption = getReqTSledCommodityOption(option);
        TCommodityPage page = new SledCommodityHandler(connProvider).query(tOption, pageIndex, pageSize);
        SledCommodityPage sledCommodityPage = new SledCommodityPage();
        sledCommodityPage.setPage(mapToAo(page.getPage()));
        sledCommodityPage.setTotal(page.getTotal());
        return sledCommodityPage;
    }

    public static ReqTSledCommodityOption getReqTSledCommodityOption(ReqSledCommodityOption reqSledCommodityOption) {
        ReqTSledCommodityOption tOption = new ReqTSledCommodityOption();
        if (reqSledCommodityOption.isSetSledCommodityIdList()) {
            tOption.setSledCommodityIds(reqSledCommodityOption.getSledCommodityIdList());
        }
        if (reqSledCommodityOption.isSetExchangeMic()) {
            tOption.setExchangeMic(reqSledCommodityOption.getExchangeMic());
        }
        if (reqSledCommodityOption.isSetSledCommodityType()) {
            tOption.setSledCommodityType(reqSledCommodityOption.getSledCommodityType().getValue());
        }
        if (reqSledCommodityOption.isSetSledCommodityCode()) {
            tOption.setSledCommodityCode(reqSledCommodityOption.getSledCommodityCode());
        }
        if (reqSledCommodityOption.isSetCnNamePartical()) {
            tOption.setCnNamePartical(reqSledCommodityOption.getCnNamePartical());
        }
        if (reqSledCommodityOption.isSetEngNamePartical()) {
            tOption.setEngNamePartical(reqSledCommodityOption.getEngNamePartical());
        }
        if (reqSledCommodityOption.isSetSledCommodityCodePartical()) {
            tOption.setSledCommodityCodePartical(reqSledCommodityOption.getSledCommodityCodePartical());
        }
        if (reqSledCommodityOption.isSetPlatformEnv()) {
            boolean isSim = TechPlatformEnv.SIM.equals(reqSledCommodityOption.getPlatformEnv());
            if (isSim) {
                tOption.setIsSim(isSim);
            }
        }
        tOption.setWorkingStatus(WorkingStatus.WORKING.getValue());
        return tOption;
    }

    protected List<SledCommodity> mapToAo(List<TSledCommodity> tSledCommodities) throws TException {

        List<SledCommodity> sledCommodities = new ArrayList<>();

        for (TSledCommodity tSledCommodity : tSledCommodities) {
            SledCommodity sledCommodity = new SledCommodity();
            sledCommodity.setSledCommodityId(tSledCommodity.getSledCommodityId());
            sledCommodity.setExchangeMic(tSledCommodity.getExchangeMic());
            sledCommodity.setSledCommodityType(SledCommodityType.findByValue(tSledCommodity.getSledCommodityType()));
            sledCommodity.setSledCommodityCode(tSledCommodity.getSledCommodityCode());
            sledCommodity.setRelateCommodityIds(tSledCommodity.getRelateCommodityIds());
            sledCommodity.setTradeCurrency(tSledCommodity.getTradeCurrency());
            sledCommodity.setZoneId(tSledCommodity.getZoneId());
            sledCommodity.setEngName(tSledCommodity.getEngName());
            sledCommodity.setCnName(tSledCommodity.getCnName());
            sledCommodity.setTcName(tSledCommodity.getTcName());
            sledCommodity.setContractSize(tSledCommodity.getContractSize());
            sledCommodity.setTickSize(tSledCommodity.getTickSize());
            sledCommodity.setDenominator(tSledCommodity.getDenominator());
            sledCommodity.setCmbDirect(CmbDirect.findByValue(tSledCommodity.getCmbDirect()));
            sledCommodity.setCommodityState(CommodityState.findByValue(tSledCommodity.getCommodityState()));

            sledCommodity.setEngAcronym(tSledCommodity.getEngAcronym());
            sledCommodity.setCnAcronym(tSledCommodity.getCnAcronym());
            sledCommodity.setTcAcronym(tSledCommodity.getTcAcronym());

            List<String> configStrings = tSledCommodity.getSledCommodityConfig();
            List<SledCommodityConfig> configs = getSledCommodityConfigs(configStrings);
            sledCommodity.setSledCommodityConfig(configs);

            sledCommodity.setActiveStartTimestamp(tSledCommodity.getActiveStartTimestamp());
            sledCommodity.setActiveEndTimestamp(tSledCommodity.getActiveEndTimestamp());
            sledCommodity.setCreateTimestamp(tSledCommodity.getCreateTimestamp());
            sledCommodity.setLastModityTimestamp(tSledCommodity.getLastModityTimestamp());

            sledCommodities.add(sledCommodity);
        }

        return sledCommodities;
    }

    private List<SledCommodityConfig> getSledCommodityConfigs(List<String> configStrings) {
        List<SledCommodityConfig> configs = new ArrayList<>();
        for (String s : configStrings) {
            byte[] data = null;
            try {
                if (s != null && !"".equals(s.trim())) {
                    data = s.getBytes("utf-8");
                }
            } catch (Throwable e) {
                AppLog.e(e.getMessage(), e);
            }
            if (data != null) {
                SledCommodityConfig commodityConfig = ProtocolUtil.unSerialize(JsonFactory.getInstance().getFactory(), data, SledCommodityConfig.class);
                configs.add(commodityConfig);
            }
        }
        return configs;
    }
}
