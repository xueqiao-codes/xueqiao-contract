package com.longsheng.xueqiao.contract.imports;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.data.CommodityMappingAccess;
import com.longsheng.xueqiao.contract.data.CommodityMappingUpdate;
import com.longsheng.xueqiao.contract.data.SledCommodityAccess;
import com.longsheng.xueqiao.contract.standard.thriftapi.*;
import com.longsheng.xueqiao.contract.thriftapi.*;
import com.longsheng.xueqiao.contract.utils.ContractDao;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.base.Md5;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.file_storage.FileStorageException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Importer {

    private int routerKey = 0;
    private int timeout = 2000;

    public ImportCommodityMapResp importMapFile(CommodityMapFileInfo fileInfo) throws TException {

        List<EsCommodityMappingData> mappingData = getEsCommodityMappingData(fileInfo);
        ImportCommodityMapResp resp = new ImportCommodityMapResp();
        if (mappingData.size() > 0) {
            saveFile(fileInfo);
            for (EsCommodityMappingData data : mappingData) {
                String es3Commodity = data.brokerCommodity.toString();
                try {
                    if (addCommodityMap(fileInfo, data)) {
                        resp.addToAddMapping(es3Commodity);
                    }
                } catch (ErrorInfo e) {
                    SledContractErrorCode code = SledContractErrorCode.findByValue(e.getErrorCode());
                    if (code == SledContractErrorCode.COMMODITY_MAP_EXISTS) {
                        resp.addToExistMapping(es3Commodity);
                    } else if (code == SledContractErrorCode.COMMODITY_MAP_UPDATE_FORBID) {
                        resp.addToConflictMapping(es3Commodity);
                    } else {
                        AppLog.e(e.getMessage(), e);
                    }
                }
            }

            ContractDao.getInstance().getServiceStub().addCommodityMapFileInfo(routerKey, timeout, fileInfo);
            return resp.setComplete(true);
        }
        return resp;
    }

    public List<EsCommodityMappingData> getEsCommodityMappingData(CommodityMapFileInfo fileInfo) throws ErrorInfo {
        fileInfo.setTechPlatform(TechPlatform.ESUNNY_3);
        checkSmallFileMD5(fileInfo);
        List<String> lines = readMapFile(fileInfo.getCommodityMapFile());
        return getEsCommodityMappingData(lines);
    }

    private List<EsCommodityMappingData> getEsCommodityMappingData(List<String> lines) throws ErrorInfo {
        List<EsCommodityMappingData> mappingData = new ArrayList<>();
        try {
            for (String line : lines) {
                AppLog.d("line: " + line);
                String[] data = splitData(line);

                String es9Commodity = data[0];
                String borkerCommodity = data[1];
                String priceRatio = data[2];

                EsCommodity es9Data = getCommodityStrings(es9Commodity);
                EsCommodity brokerData = getCommodityStrings(borkerCommodity);
                double moneyRatio = Double.valueOf(priceRatio);
                mappingData.add(new EsCommodityMappingData(es9Data, brokerData, moneyRatio));
            }
        } catch (Throwable e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ContractManageErrorCode.DATA_FORMAT_ERROR.getValue(), "Input data format error.");
        }
        return mappingData;
    }

    private void saveFile(CommodityMapFileInfo fileInfo) throws ErrorInfo {

        String filePath = ContractStorage.generateFilePath(fileInfo.getBrokerEntryId());
        try {
            ContractStorage.getStorage().write(filePath, fileInfo.getCommodityMapFile());
            fileInfo.setUrl(ContractStorage.getStorage().getUrl(filePath));
            fileInfo.setPath(filePath);
        } catch (Throwable e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), ErrorCodeOuter.SERVER_BUSY.getErrorMsg());
        }
    }

    public void importCommodity(PlatformCommodity platformCommodity) throws TException {

        ReqCommodityMapFileInfoOption option = new ReqCommodityMapFileInfoOption();
        option.setTechPlatform(TechPlatform.ESUNNY_3);
        option.setStatus(CommodityMapFileStatus.IN_USE);
        CommodityMapFileInfoPage page = new ContractDaoServiceStub().reqCommodityMapFileInfo(option, 0, Integer.MAX_VALUE);
        for (CommodityMapFileInfo fileInfo : page.getPage()) {
            try {
                fileInfo.setCommodityMapFile(ContractStorage.getStorage().read(fileInfo.getPath()));
            } catch (FileStorageException e) {
                AppLog.e(e.getMessage(), e);
                throw new ErrorInfo(ErrorCodeOuter.SERVER_BUSY.getErrorCode(), ErrorCodeOuter.SERVER_BUSY.getErrorMsg());
            }
            List<Importer.EsCommodityMappingData> list = getEsCommodityMappingData(fileInfo);

            for (EsCommodityMappingData data : list) {
                EsCommodity  es9Commodity = data.es9Commodity;
                if (es9Commodity.esExchange.equals(platformCommodity.getExchange())
                        && es9Commodity.esType.equals(platformCommodity.getCommodityType())
                        && es9Commodity.esCode.equals(platformCommodity.getCommodityCode())){
                    AppLog.d("add mapping: "+ data.brokerCommodity);
                    AppLog.d("add mapping: "+ platformCommodity);
                    addCommodityMap(fileInfo, data);
                    break;
                }
            }
        }
    }

//    breakprivate void checkCommodityMapExist(ImportCommodityMapInfo mapInfo) throws TException {
//        CommodityMappingAccess commodityMapAccess = new CommodityMappingAccess();
//
//        ReqCommodityMappingEditOption reqCommodityOption = new ReqCommodityMappingEditOption();
//        reqCommodityOption.addToSledCommodityIdList(mapInfo.getSledCommodityId());
//        reqCommodityOption.setTechPlatform(mapInfo.getTechPlatform());
//        if (mapInfo.isSetBrokerEntryId()) {
//            reqCommodityOption.setBrokerEntryId(mapInfo.getBrokerEntryId());
//        }
//        CommodityMappingEditPage commodityMapPage = commodityMapAccess.reqCommodityMap(reqCommodityOption, 0, 1);
//        if (commodityMapPage.getTotal() > 0) {
//            throw new ErrorInfo(SledContractErrorCode.COMMODITY_MAP_EXISTS.getValue(), "commodity map exists.");
//        }
//    }

//    private SledCommodity checkSledCommodityExist(ImportCommodityMapInfo mapInfo) throws TException {
//        SledCommodityAccess sledCommodityAccess = new SledCommodityAccess();
//        ReqSledCommodityOption option = new ReqSledCommodityOption();
//        option.addToSledCommodityIdList(mapInfo.getSledCommodityId());
//        SledCommodityEditPage page = sledCommodityAccess.getPage(option, 0, 1);
//
//        if (page.getTotal() == 0) {
//            throw new ErrorInfo(SledContractErrorCode.SLED_COMMODITY_NOT_FOUND.getValue(), "sled commodity not found.");
//        }
//        return page.getPage().get(0).getSledCommodity();
//    }

    private boolean addCommodityMap(CommodityMapFileInfo fileInfo, EsCommodityMappingData data) throws TException {

        EsCommodity commodityData = data.es9Commodity;

        CommodityMappingAccess commodityMappingAccess = new CommodityMappingAccess();
        ReqCommodityMappingEditOption option = new ReqCommodityMappingEditOption();
        option.setBrokerEntryId(0);
        option.setTechPlatform(TechPlatform.ESUNNY);
        option.setExchange(commodityData.esExchange);
        option.setCommodityType(commodityData.esType);
        option.setCommodityCode(commodityData.esCode);
        CommodityMappingEditPage page = commodityMappingAccess.reqCommodityMap(option, 0, 1);
        if (page.getTotal() > 0) {

            CommodityMapping sledEsCommodityMap = page.getPage().get(0).getCommodityMapping();
            int sledCommodityId = sledEsCommodityMap.getSledCommodityId();

            EsCommodity brokerCommodityData = data.brokerCommodity;
            CommodityMappingUpdate commodityMapUpdate = new CommodityMappingUpdate();
            CommodityMapping commodityMap = new CommodityMapping();
            commodityMap.setSledCommodityId(sledCommodityId);
            commodityMap.setTechPlatform(TechPlatform.ESUNNY_3);
            commodityMap.setBrokerEntryId(fileInfo.getBrokerEntryId());
            commodityMap.setMoneyRatio(data.priceRatio * sledEsCommodityMap.getMoneyRatio());
            commodityMap.setExchange(brokerCommodityData.esExchange);
            commodityMap.setCommodityType(brokerCommodityData.esType);
            commodityMap.setCommodityCode(brokerCommodityData.esCode);
            commodityMapUpdate.doAddCommodityMap(commodityMap);
            return true;
        }
        return false;
    }

    private EsCommodity getCommodityStrings(String commodity) throws ErrorInfo {
        String[] commodityData = StringUtils.splitPreserveAllTokens(commodity, "|");
        return new EsCommodity(commodityData[0], commodityData[1], commodityData[2]);
    }

    private String[] splitData(String line) {
//      "ASX|F|AP","SFE|F|SSPI200","1"
        String[] data = StringUtils.splitPreserveAllTokens(line, ",");
        AppLog.d("line: " + line);

        for (int j = 0; j < data.length; j++) {
            data[j] = data[j].trim().replace("\"", "");
        }
        return data;
    }

    private void checkSmallFileMD5(CommodityMapFileInfo fileInfo) throws ErrorInfo {
        if (!fileInfo.isSetFileMD5()) {
            throw new ErrorInfo(ContractManageErrorCode.MAP_FILE_MD5_ERROR.getValue(), "file md5 error.");
        }
        String localMD5 = Md5.toMd5(fileInfo.getCommodityMapFile());
        AppLog.d("local md5 : " + localMD5);
        if (!localMD5.toUpperCase().equals(fileInfo.getFileMD5().toUpperCase().trim())) {
            throw new ErrorInfo(ContractManageErrorCode.MAP_FILE_MD5_ERROR.getValue(), "file md5 error.");
        }
    }

    private List<String> readMapFile(byte[] bytes) throws ErrorInfo {

        InputStreamReader reader = new InputStreamReader(new ByteArrayInputStream(bytes));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        List<String> lines = new ArrayList<>();
        try {
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Throwable e) {
            throw new ErrorInfo(ContractManageErrorCode.MAP_FILE_READ_FAIL.getValue(), "read map file fail.");
        }
        return lines;
    }

    public class EsCommodity {
        public String esExchange;
        public String esType;
        public String esCode;

        public EsCommodity(String esExchange, String esType, String esCode) {
            this.esExchange = esExchange;
            this.esType = esType;
            this.esCode = esCode;
        }

        @Override
        public String toString() {
            return this.esExchange + "|" + this.esType + "|" + this.esCode;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj instanceof EsCommodity) {
                EsCommodity esCommodity = (EsCommodity) obj;
                if (esCommodity.esExchange == this.esExchange
                        && esCommodity.esCode == this.esCode
                        && esCommodity.esType == this.esType) {
                    return true;
                }
            }
            return false;
        }
    }

    public class EsCommodityMappingData {
        public EsCommodity es9Commodity;
        public EsCommodity brokerCommodity;
        public double priceRatio;

        public EsCommodityMappingData(EsCommodity es9Commodity, EsCommodity brokerCommodity, double priceRatio) {
            this.es9Commodity = es9Commodity;
            this.brokerCommodity = brokerCommodity;
            this.priceRatio = priceRatio;
        }
    }
}
