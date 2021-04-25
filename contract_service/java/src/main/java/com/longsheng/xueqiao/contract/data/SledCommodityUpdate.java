package com.longsheng.xueqiao.contract.data;

import com.longsheng.xueqiao.contract.dao.thriftapi.RemoveSledCommodityOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.TSledCommodity;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.imports.PlatformCommodity;
import com.longsheng.xueqiao.contract.links.CommodityConvertor;
import com.longsheng.xueqiao.contract.links.CommodityLink;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.*;
import com.longsheng.xueqiao.contract.utils.JsonFactory;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.util.ProtocolUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;

public class SledCommodityUpdate {

    private static ContractDaoServiceStub stub = new ContractDaoServiceStub();
    int routeKey = RandomUtils.nextInt();
    int timeout = 3000;


    public SledCommodityEdit addSledCommodity(SledCommodity sledCommodity) throws TException {
        return addSledCommodity(sledCommodity, null);
    }

    public SledCommodityEdit addSledCommodity(SledCommodity sledCommodity, String mappingCode) throws TException {
        String platformCommodityCode;
        if (mappingCode == null || "".equals(mappingCode)) {
            platformCommodityCode = sledCommodity.getSledCommodityCode();
        } else {
            platformCommodityCode = mappingCode;
        }

        checkSledCommodityExists(sledCommodity);
        if (!sledCommodity.isSetZoneId()) {
            autoSetZoneId(sledCommodity);
        }
        CommoditySource commoditySource = getCommoditySource(sledCommodity);
        PlatformCommodity platformCommodity = new CommodityConvertor().getPlatformCommodity(sledCommodity, commoditySource.getTechPlatformSource(), platformCommodityCode);
        CommodityLink link = new CommodityLink();

        TechPlatformCommodity techPlatformCommodity = link.checkPlatformCommodityExist(platformCommodity);

        // 反正要保持一致，直接使用api查询到的数据, 如果需要修改则通过界面修正
        if (techPlatformCommodity!=null) {
            sledCommodity.setContractSize(techPlatformCommodity.getContractSize());
            sledCommodity.setTickSize(techPlatformCommodity.getTickSize());
            sledCommodity.setTradeCurrency(techPlatformCommodity.getTradeCurrency());
            sledCommodity.setDenominator(1);
            sledCommodity.setCnName(techPlatformCommodity.getCnName());
            sledCommodity.setEngName(techPlatformCommodity.getEngName());
        }

        TSledCommodity tSledCommodity = getTSledCommodity(sledCommodity);
        tSledCommodity.setEditstatus(EditStatus.NEW.getValue());
        int sledCommodityId = stub.addTSledCommodity(routeKey, timeout, tSledCommodity);

        sledCommodity.setSledCommodityId(sledCommodityId);
        link.addCommodityMapping(sledCommodityId, platformCommodity);
        AppLog.i("platformCommodity: " + platformCommodity);
        AppLog.i("sledCommodity: " + sledCommodity);

        return getSledCommodities(sledCommodityId);
    }


    private void autoSetZoneId(SledCommodity sledCommodity) throws TException {
        SledExchangeAccess sledExchangeAccess = new SledExchangeAccess();
        ReqSledExchangeOption exchangeOption = new ReqSledExchangeOption();
        exchangeOption.setExchangeMic(sledCommodity.getExchangeMic());
        SledExchangePage exchangePage = sledExchangeAccess.getPage(exchangeOption, 0, 1);
        if (exchangePage.getPageSize() > 0) {
            sledCommodity.setZoneId(exchangePage.getPage().get(0).getZoneId());
        } else {
            throw new ErrorInfo(SledContractErrorCode.SLED_EXCHANGE_NOT_FOUND.getValue(), "Sled exchange not found.");
        }
    }

    private void checkSledCommodityExists(SledCommodity sledCommodity) throws TException {
        if (!sledCommodity.isSetExchangeMic() || !sledCommodity.isSetSledCommodityType() || !sledCommodity.isSetSledCommodityCode()) {
            throw new IllegalArgumentException("SledCommodity exchange, commodity type, commodity code must set.");
        }
        SledCommodityAccess access = new SledCommodityAccess();
        ReqSledCommodityOption option = new ReqSledCommodityOption();
        option.setExchangeMic(sledCommodity.getExchangeMic());
        option.setSledCommodityType(sledCommodity.getSledCommodityType());
        option.setSledCommodityCode(sledCommodity.getSledCommodityCode());
        SledCommodityEditPage page = access.getPage(option, 0, 1);
        if (page.getPageSize() > 0) {
            throw new ErrorInfo(SledContractErrorCode.SLED_COMMODITY_EXISTS.getValue(), "sled commodity exists.");
        }
    }

    private CommoditySource getCommoditySource(SledCommodity sledCommodity) throws TException {
        CommoditySourcePage sourcePage = stub.reqCommoditySource(new ReqCommoditySourceOption());
        for (CommoditySource source : sourcePage.getPage()) {
            if (source.getExchangeMic().contains(sledCommodity.getExchangeMic())) {
                return source;
            }
        }
        throw new ErrorInfo(ContractManageErrorCode.SLED_EXCHANGE_SOURCE_NOT_FOUND.getValue(), "sled exchange source not found.");
    }

    private SledCommodityEdit getSledCommodities(int id) throws TException {
        ReqSledCommodityOption option = new ReqSledCommodityOption();
        option.addToSledCommodityIdList(id);
        SledCommodityEditPage page = new SledCommodityAccess().getPage(option, 0, 1);
        if (page.getPageSize() > 0) {
            return page.getPage().get(0);
        }
        throw new ErrorInfo(SledContractErrorCode.SLED_COMMODITY_NOT_FOUND.getValue(), "update sled commodity fail.");
    }

    private TSledCommodity getTSledCommodity(SledCommodity sledCommodity) throws ErrorInfo {
        TSledCommodity tSledCommodity = new TSledCommodity();

        if (sledCommodity.isSetExchangeMic()) {
            tSledCommodity.setExchangeMic(sledCommodity.getExchangeMic());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetSledCommodityType()) {
            tSledCommodity.setSledCommodityType(sledCommodity.getSledCommodityType().getValue());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetSledCommodityCode()) {
            tSledCommodity.setSledCommodityCode(sledCommodity.getSledCommodityCode());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }

        if (sledCommodity.isSetRelateCommodityIds() && sledCommodity.getRelateCommodityIdsSize() > 0) {
            tSledCommodity.setRelateCommodityIds(sledCommodity.getRelateCommodityIds());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }

        if (sledCommodity.isSetTradeCurrency()) {
            tSledCommodity.setTradeCurrency(sledCommodity.getTradeCurrency());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetZoneId()) {

            TimeZone timeZone = TimeZone.getTimeZone(sledCommodity.getZoneId());
            if (timeZone == null) {
                throw new ErrorInfo(ContractManageErrorCode.ZONE_ID_ERROR.getValue(), "zone id not found.");
            }

            tSledCommodity.setZoneId(sledCommodity.getZoneId());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetEngName()) {
            tSledCommodity.setEngName(sledCommodity.getEngName());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetCnName()) {
            tSledCommodity.setCnName(sledCommodity.getCnName());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetTcName()) {
            tSledCommodity.setTcName(sledCommodity.getTcName());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetActiveStartTimestamp()) {
            tSledCommodity.setActiveStartTimestamp(sledCommodity.getActiveStartTimestamp());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetActiveEndTimestamp()) {
            tSledCommodity.setActiveEndTimestamp(sledCommodity.getActiveEndTimestamp());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetSledCommodityConfig()) {
            List<SledCommodityConfig> list = sledCommodity.getSledCommodityConfig();

            Comparator comparator = Comparator.comparing(SledCommodityConfig::getActiveStartTimestamp);
            list.sort(comparator);
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1)
                    list.get(i).setActiveEndTimestamp(list.get(i + 1).getActiveStartTimestamp());
                else {
                    long end = System.currentTimeMillis() / 1000 + 50 * 365 * 24 * 60 * 60;
                    list.get(i).setActiveEndTimestamp(end);
                }
            }

            List<String> configs = getConfigStrings(list);
            tSledCommodity.setSledCommodityConfig(configs);
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetContractSize()) {
            tSledCommodity.setContractSize(sledCommodity.getContractSize());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetTickSize()) {
            tSledCommodity.setTickSize(sledCommodity.getTickSize());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetDenominator()) {
            tSledCommodity.setDenominator(sledCommodity.getDenominator());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetCmbDirect()) {
            tSledCommodity.setCmbDirect(sledCommodity.getCmbDirect().getValue());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetCommodityState()) {
            tSledCommodity.setCommodityState(sledCommodity.getCommodityState().getValue());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetEngAcronym()) {
            tSledCommodity.setEngAcronym(sledCommodity.getEngAcronym());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetCnAcronym()) {
            tSledCommodity.setCnAcronym(sledCommodity.getCnAcronym());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }
        if (sledCommodity.isSetTcAcronym()) {
            tSledCommodity.setTcAcronym(sledCommodity.getTcAcronym());
            tSledCommodity.setEditstatus(EditStatus.EDIT.getValue());
        }

        // 不改变编辑状态
        if (sledCommodity.isSetIsAlsoSupportSim()) {
            tSledCommodity.setIsAlsoSupportSim(sledCommodity.isIsAlsoSupportSim());
        }

        return tSledCommodity;
    }

    public void activeCommodity(int sledCommodityId) throws TException {
        checkSledCommodity(sledCommodityId);

        TSledCommodity tSledCommodity = new TSledCommodity();
        tSledCommodity.setSledCommodityId(sledCommodityId);
        tSledCommodity.setWorkingStatus(WorkingStatus.WORKING.getValue());
        tSledCommodity.setEditstatus(EditStatus.SYNCHRONIZED.getValue());
        stub.updateTSledCommodity(routeKey, timeout, tSledCommodity);
    }

    private void checkSledCommodity(int sledCommodityId) throws TException {
        SledCommodityAccess access = new SledCommodityAccess();
        ReqSledCommodityOption option = new ReqSledCommodityOption();
        option.addToSledCommodityIdList(sledCommodityId);

        SledCommodityEditPage page = access.getPage(option, 0, 1);

        if (page.getTotal() == 0) {
            throw new ErrorInfo(SledContractErrorCode.SLED_COMMODITY_NOT_FOUND.getValue(), "Sled commodity not found.");
        }
        if (page.getPage().get(0).getWorkingStatus() == WorkingStatus.WORKING) {
            throw new ErrorInfo(ContractManageErrorCode.SLED_COMMODITY_WORKING_STATUS_ERROR.getValue(),
                    "Sled commodity is working.");
        }
        if (page.getPage().get(0).getEditStatus() != EditStatus.VERIFIED_CORRECT) {
            throw new ErrorInfo(ContractManageErrorCode.SLED_COMMODITY_NOT_VERIFY.getValue(),
                    "Sled commodity not verify.");
        }

        if (page.getPage().get(0).getSledCommodity().getRelateCommodityIdsSize() > 0) {
            SledCommodityEditPage relatePage = access.getPage(new ReqSledCommodityOption().setSledCommodityIdList(page.getPage().get(0).getSledCommodity().getRelateCommodityIds()), 0, 1);
            if (relatePage.getPageSize() == 0) {
                throw new ErrorInfo(SledContractErrorCode.SLED_COMMODITY_NOT_FOUND.getValue(), "Relate Sled commodity not found.");
            }
            for (SledCommodityEdit sledCommodityEdit : relatePage.getPage()) {
                if (!WorkingStatus.WORKING.equals(sledCommodityEdit.getWorkingStatus())) {
                    throw new ErrorInfo(ContractManageErrorCode.SLED_COMMODITY_NOT_VERIFY.getValue(),
                            "Relate Sled commodity not verify.");
                }
            }
        }

        checkMapping(sledCommodityId);
        checkContract(sledCommodityId);
    }

    private void checkContract(int sledCommodityId) throws TException {
        SledContractAccess sledContractAccess = new SledContractAccess();
        ReqSledContractOption contractOption = new ReqSledContractOption();
        contractOption.setSledCommodityId(sledCommodityId);
        SledContractEditPage contractPage = sledContractAccess.getSledContractPage(contractOption, 0, 1);
        if (contractPage.getTotal() == 0) {
            throw new ErrorInfo(SledContractErrorCode.SLED_CONTRACT_NOT_FOUND.getValue(), "Contract not found.");
        }
    }

    private void checkMapping(int sledCommodityId) throws TException {
        CommodityMappingAccess commodityMappingAccess = new CommodityMappingAccess();
        ReqCommodityMappingEditOption mappingOption = new ReqCommodityMappingEditOption();
        mappingOption.addToSledCommodityIdList(sledCommodityId);
        mappingOption.setBrokerEntryId(0);
        CommodityMappingEditPage mappingPage = commodityMappingAccess.reqCommodityMap(mappingOption, 0, 10);
        if (mappingPage.getTotal() == 0) {
            throw new ErrorInfo(SledContractErrorCode.COMMODITY_MAP_NOT_FOUND.getValue(), "Commodity mapping not found.");
        }
    }

    public void verifySledCommodity(int sledCommodityId) throws TException {
        checkMapping(sledCommodityId);
        checkContract(sledCommodityId);

        TSledCommodity tSledCommodity = new TSledCommodity();
        tSledCommodity.setSledCommodityId(sledCommodityId);
        tSledCommodity.setEditstatus(EditStatus.VERIFIED_CORRECT.getValue());
        stub.updateTSledCommodity(routeKey, timeout, tSledCommodity);
    }

    private List<String> getConfigStrings(List<SledCommodityConfig> list) {
        List<String> configs = new ArrayList<>();
        for (SledCommodityConfig s : list) {
            byte[] data = ProtocolUtil.serialize2Bytes(JsonFactory.getInstance().getFactory(), s);
            if (data != null) {
                configs.add(new String(data));
            }
        }
        return configs;
    }

    public SledCommodityEdit updateSledCommodity(SledCommodity sledCommodity) throws TException {
        if (!sledCommodity.isSetSledCommodityId()) {
            throw new IllegalArgumentException("SledCommodity sled commodity id must set.");
        }
        TSledCommodity tSledCommodity = getTSledCommodity(sledCommodity);
        tSledCommodity.setSledCommodityId(sledCommodity.getSledCommodityId());

        SledCommodityAccess sledCommodityAccess = new SledCommodityAccess();
        ReqSledCommodityOption option = new ReqSledCommodityOption();
        option.addToSledCommodityIdList(sledCommodity.getSledCommodityId());
        SledCommodityEditPage page = sledCommodityAccess.getPage(option, 0, 1);
        if (page.getPageSize() > 0) {
            int id = stub.updateTSledCommodity(routeKey, timeout, tSledCommodity);
            return getSledCommodities(id);
        } else {
            throw new ErrorInfo(SledContractErrorCode.SLED_COMMODITY_NOT_FOUND.getValue(), "sled commodity not found.");
        }
    }

    public void deleteCommodity(int sledCommodityId) throws TException {
        SledCommodityAccess access = new SledCommodityAccess();
        ReqSledCommodityOption option = new ReqSledCommodityOption();
        option.addToSledCommodityIdList(sledCommodityId);

        SledCommodityEditPage page = access.getPage(option, 0, 1);
        if (page.getTotal() == 0) {
            throw new ErrorInfo(SledContractErrorCode.SLED_COMMODITY_NOT_FOUND.getValue(), "Sled commodity not found.");
        }
        if (page.getPage().get(0).getWorkingStatus() == WorkingStatus.WORKING) {
            throw new ErrorInfo(ContractManageErrorCode.SLED_COMMODITY_NO_DELETE.getValue(), "No Delete. Sled commodity is working.");
        }

        option.clear();
        option.setExchangeMic(page.getPage().get(0).getSledCommodity().getExchangeMic());
        page = access.getPage(option, 0, Integer.MAX_VALUE);
        for (SledCommodityEdit edit : page.getPage()) {
            if (edit.getSledCommodity().getRelateCommodityIds().contains(sledCommodityId)) {
                throw new ErrorInfo(ContractManageErrorCode.SLED_COMMODITY_NO_DELETE.getValue(),
                        "No Delete. Sled commodity is a relate commodity, commodity id is: " + edit.getSledCommodity().getSledCommodityId());
            }
        }

        List<Integer> brokerEntryIds = new ArrayList<>();
        brokerEntryIds.add(0);
        ReqCommodityMapFileInfoOption commodityMappingFileOption = new ReqCommodityMapFileInfoOption();
        commodityMappingFileOption.setTechPlatform(TechPlatform.ESUNNY_3);
        CommodityMapFileInfoPage commodityMapFileInfoPage = stub.reqCommodityMapFileInfo(commodityMappingFileOption, 0, Integer.MAX_VALUE);
        for (CommodityMapFileInfo info : commodityMapFileInfoPage.getPage()) {
            brokerEntryIds.add(info.getBrokerEntryId());
        }
        RemoveSledCommodityOption removeOption = new RemoveSledCommodityOption();
        removeOption.setSledCommodityId(sledCommodityId);
        removeOption.setBrokerEntryIds(brokerEntryIds);
        stub.removeSledCommodity(removeOption);
    }
}
