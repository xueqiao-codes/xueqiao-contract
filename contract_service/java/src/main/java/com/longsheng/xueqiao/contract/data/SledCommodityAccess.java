package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledCommodityOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TCommodityPage;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledCommodity;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.EditStatus;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEdit;
import com.longsheng.xueqiao.contract.thriftapi.SledCommodityEditPage;
import com.longsheng.xueqiao.contract.thriftapi.WorkingStatus;
import com.longsheng.xueqiao.contract.utils.JsonFactory;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.util.ProtocolUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class SledCommodityAccess {

    private static ContractDaoServiceStub stub = new ContractDaoServiceStub();
    private static int timeout = 3000;
    private static int routerKey = 0;

    public SledCommodityEditPage getPage(ReqSledCommodityOption option, int pageIndex, int pageSize) throws TException {

        ReqTSledCommodityOption tOption = getReqTSledCommodityOption(option);
        return getSledCommodityEditPage(pageIndex, pageSize, tOption);
    }

    public SledCommodityEditPage getSledCommodityEditPage(int pageIndex, int pageSize, ReqTSledCommodityOption tOption) throws TException {
        TCommodityPage page = stub.reqTSledCommodity(routerKey, timeout, tOption, pageIndex, pageSize);
        SledCommodityEditPage sledCommodityPage = new SledCommodityEditPage();
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
        return tOption;
    }

    protected List<SledCommodityEdit> mapToAo(List<TSledCommodity> tSledCommodities) throws TException {

        List<SledCommodityEdit> sledCommodities = new ArrayList<>();

        for (TSledCommodity tSledCommodity : tSledCommodities) {
            SledCommodityEdit sledCommodityEdit = new SledCommodityEdit();
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

            List<String> configStrings = tSledCommodity.getSledCommodityConfig();
            List<SledCommodityConfig> configs = getSledCommodityConfigs(configStrings);
            sledCommodity.setSledCommodityConfig(configs);

            sledCommodity.setActiveStartTimestamp(tSledCommodity.getActiveStartTimestamp());
            sledCommodity.setActiveEndTimestamp(tSledCommodity.getActiveEndTimestamp());
            sledCommodity.setCreateTimestamp(tSledCommodity.getCreateTimestamp());
            sledCommodity.setLastModityTimestamp(tSledCommodity.getLastModityTimestamp());
            sledCommodity.setIsAlsoSupportSim(tSledCommodity.isIsAlsoSupportSim());
            sledCommodity.setEngAcronym(tSledCommodity.getEngAcronym());
            sledCommodity.setCnAcronym(tSledCommodity.getCnAcronym());
            sledCommodity.setTcAcronym(tSledCommodity.getTcAcronym());

            sledCommodityEdit.setSledCommodity(sledCommodity);
            sledCommodityEdit.setEditStatus(EditStatus.findByValue(tSledCommodity.getEditstatus()));
            sledCommodityEdit.setWorkingStatus(WorkingStatus.findByValue(tSledCommodity.getWorkingStatus()));
            sledCommodities.add(sledCommodityEdit);
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
