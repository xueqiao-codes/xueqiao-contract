package com.longsheng.xueqiao.contractconvertor; /**
 * Created by ihsl on 2018/2/3.
 */

import com.longsheng.xueqiao.contractconvertor.swig.*;
import com.longsheng.xueqiao.contractconvertor.LibraryLoader;

public class Sample {

    public static void main(String[] args) {

        LibraryLoader.init();

        //testCtpFuturesToSledContract_CZCE();
        //testCtpFuturesToSledContract_CFFEX();

        testCtpSpreadToSledContract_CZCE_S();

        //testCtpSpreadToSledContract_CZCE_M();

        //testSledFuturesToCtpContract();

        //testSledSpreadToCtpContract();
    }

    static  void testCtpFuturesToSledContract_CZCE()
    {
        // 测试1 -- 郑商所期货
        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("CZCE");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commonContract.setTechPlatform_CommodityCode_("RM");
        commonContract.setTechPlatform_ContractCode_("RM801");
        args.setCommonContract_(commonContract);
        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        System.out.println("Input Info:");
        System.out.println("Tech Platform:" + args.getTechPlatform_());
        System.out.println("CTP Exchange:" + args.getCommonContract_().getTechPlatform_Exchange_());
        System.out.println("CTP CommodityType:" + args.getCommonContract_().getTechPlatform_CommodityType_());
        System.out.println("CTP Commodity:" + args.getCommonContract_().getTechPlatform_CommodityCode_());
        System.out.println("CTP ContractCode:" + args.getCommonContract_().getTechPlatform_ContractCode_());

        System.out.println("Convert Result:");
        System.out.println("Tech Platform:" + result.getTechPlatform_());
        System.out.println("CtpExchange:" + result.getMixContract_().getTechPlatform_Exchange_());
        System.out.println("CtpCommodityClass:" + result.getMixContract_().getTechPlatform_CommodityType_());
        System.out.println("CtpCommodityCode:" + result.getMixContract_().getTechPlatform_CommodityCode_());
        System.out.println("SledContractCode:" + result.getMixContract_().getSledContractCode_());

        System.out.println("Relate[0] CtpExchange:" + result.getRelateMixContract_(0).getTechPlatform_Exchange_());
        System.out.println("Relate[0] CtpCommodityClass:" + result.getRelateMixContract_(0).getTechPlatform_CommodityType_());
        System.out.println("Relate[0] CtpCommodityCode:" + result.getRelateMixContract_(0).getTechPlatform_CommodityCode_());
        System.out.println("Relate[0] SledContractCode:" + result.getRelateMixContract_(0).getSledContractCode_());

        System.out.println("Relate[1] CtpExchange:" + result.getRelateMixContract_(1).getTechPlatform_Exchange_());
        System.out.println("Relate[1] CtpCommodityClass:" + result.getRelateMixContract_(1).getTechPlatform_CommodityType_());
        System.out.println("Relate[1] CtpCommodityCode:" + result.getRelateMixContract_(1).getTechPlatform_CommodityCode_());
        System.out.println("Relate[1] SledContractCode:" + result.getRelateMixContract_(1).getSledContractCode_());

    }

    static  void testCtpFuturesToSledContract_CFFEX()
    {
        // 测试2 -- 中金所所期货
        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("CFFEX");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commonContract.setTechPlatform_CommodityCode_("IF");
        commonContract.setTechPlatform_ContractCode_("IF1803");
        args.setCommonContract_(commonContract);
        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        System.out.println("Input Info:");
        System.out.println("Tech Platform:" + args.getTechPlatform_());
        System.out.println("CTP Exchange:" + args.getCommonContract_().getTechPlatform_Exchange_());
        System.out.println("CTP CommodityType:" + args.getCommonContract_().getTechPlatform_CommodityType_());
        System.out.println("CTP Commodity:" + args.getCommonContract_().getTechPlatform_CommodityCode_());
        System.out.println("CTP ContractCode:" + args.getCommonContract_().getTechPlatform_ContractCode_());

        System.out.println("Convert Result:");
        System.out.println("Tech Platform:" + result.getTechPlatform_());
        System.out.println("CtpExchange:" + result.getMixContract_().getTechPlatform_Exchange_());
        System.out.println("CtpCommodityClass:" + result.getMixContract_().getTechPlatform_CommodityType_());
        System.out.println("CtpCommodityCode:" + result.getMixContract_().getTechPlatform_CommodityCode_());
        System.out.println("SledContractCode:" + result.getMixContract_().getSledContractCode_());

        System.out.println("Relate[0] CtpExchange:" + result.getRelateMixContract_(0).getTechPlatform_Exchange_());
        System.out.println("Relate[0] CtpCommodityClass:" + result.getRelateMixContract_(0).getTechPlatform_CommodityType_());
        System.out.println("Relate[0] CtpCommodityCode:" + result.getRelateMixContract_(0).getTechPlatform_CommodityCode_());
        System.out.println("Relate[0] SledContractCode:" + result.getRelateMixContract_(0).getSledContractCode_());

        System.out.println("Relate[1] CtpExchange:" + result.getRelateMixContract_(1).getTechPlatform_Exchange_());
        System.out.println("Relate[1] CtpCommodityClass:" + result.getRelateMixContract_(1).getTechPlatform_CommodityType_());
        System.out.println("Relate[1] CtpCommodityCode:" + result.getRelateMixContract_(1).getTechPlatform_CommodityCode_());
        System.out.println("Relate[1] SledContractCode:" + result.getRelateMixContract_(1).getSledContractCode_());
    }

    static void testCtpSpreadToSledContract_CZCE_S()
    {
        // 测试1 -- 郑商所期货
        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("CZCE");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination));
        commonContract.setTechPlatform_CommodityCode_("SPD CY&CY");
        commonContract.setTechPlatform_ContractCode_("SPD CY809&CY812");
        args.setCommonContract_(commonContract);
        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        System.out.println("Input Info:");
        System.out.println("Tech Platform:" + args.getTechPlatform_());
        System.out.println("CTP Exchange:" + args.getCommonContract_().getTechPlatform_Exchange_());
        System.out.println("CTP CommodityType:" + args.getCommonContract_().getTechPlatform_CommodityType_());
        System.out.println("CTP Commodity:" + args.getCommonContract_().getTechPlatform_CommodityCode_());
        System.out.println("CTP ContractCode:" + args.getCommonContract_().getTechPlatform_ContractCode_());

        System.out.println("Convert Result:");
        System.out.println("Tech Platform:" + result.getTechPlatform_());
        System.out.println("CtpExchange:" + result.getMixContract_().getTechPlatform_Exchange_());
        System.out.println("CtpCommodityClass:" + result.getMixContract_().getTechPlatform_CommodityType_());
        System.out.println("CtpCommodityCode:" + result.getMixContract_().getTechPlatform_CommodityCode_());
        System.out.println("SledContractCode:" + result.getMixContract_().getSledContractCode_());

        System.out.println("Relate[0] CtpExchange:" + result.getRelateMixContract_(0).getTechPlatform_Exchange_());
        System.out.println("Relate[0] CtpCommodityClass:" + result.getRelateMixContract_(0).getTechPlatform_CommodityType_());
        System.out.println("Relate[0] CtpCommodityCode:" + result.getRelateMixContract_(0).getTechPlatform_CommodityCode_());
        System.out.println("Relate[0] SledContractCode:" + result.getRelateMixContract_(0).getSledContractCode_());

        System.out.println("Relate[1] CtpExchange:" + result.getRelateMixContract_(1).getTechPlatform_Exchange_());
        System.out.println("Relate[1] CtpCommodityClass:" + result.getRelateMixContract_(1).getTechPlatform_CommodityType_());
        System.out.println("Relate[1] CtpCommodityCode:" + result.getRelateMixContract_(1).getTechPlatform_CommodityCode_());
        System.out.println("Relate[1] SledContractCode:" + result.getRelateMixContract_(1).getSledContractCode_());
    }

    static void testCtpSpreadToSledContract_CZCE_M()
    {
        // 测试1 -- 郑商所跨品种
        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("CZCE");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination));
        commonContract.setTechPlatform_CommodityCode_("IPS SF&SM");
        commonContract.setTechPlatform_ContractCode_("IPS SF805&SM805");
        args.setCommonContract_(commonContract);
        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        System.out.println("Input Info:");
        System.out.println("Tech Platform:" + args.getTechPlatform_());
        System.out.println("CTP Exchange:" + args.getCommonContract_().getTechPlatform_Exchange_());
        System.out.println("CTP CommodityType:" + args.getCommonContract_().getTechPlatform_CommodityType_());
        System.out.println("CTP Commodity:" + args.getCommonContract_().getTechPlatform_CommodityCode_());
        System.out.println("CTP ContractCode:" + args.getCommonContract_().getTechPlatform_ContractCode_());

        System.out.println("Convert Result:");
        System.out.println("Tech Platform:" + result.getTechPlatform_());
        System.out.println("CtpExchange:" + result.getMixContract_().getTechPlatform_Exchange_());
        System.out.println("CtpCommodityClass:" + result.getMixContract_().getTechPlatform_CommodityType_());
        System.out.println("CtpCommodityCode:" + result.getMixContract_().getTechPlatform_CommodityCode_());
        System.out.println("SledContractCode:" + result.getMixContract_().getSledContractCode_());

        System.out.println("Relate[0] CtpExchange:" + result.getRelateMixContract_(0).getTechPlatform_Exchange_());
        System.out.println("Relate[0] CtpCommodityClass:" + result.getRelateMixContract_(0).getTechPlatform_CommodityType_());
        System.out.println("Relate[0] CtpCommodityCode:" + result.getRelateMixContract_(0).getTechPlatform_CommodityCode_());
        System.out.println("Relate[0] SledContractCode:" + result.getRelateMixContract_(0).getSledContractCode_());

        System.out.println("Relate[1] CtpExchange:" + result.getRelateMixContract_(1).getTechPlatform_Exchange_());
        System.out.println("Relate[1] CtpCommodityClass:" + result.getRelateMixContract_(1).getTechPlatform_CommodityType_());
        System.out.println("Relate[1] CtpCommodityCode:" + result.getRelateMixContract_(1).getTechPlatform_CommodityCode_());
        System.out.println("Relate[1] SledContractCode:" + result.getRelateMixContract_(1).getSledContractCode_());
    }

    static void testSledFuturesToCtpContract()
    {
         // 测试1 -- 郑商所期货
        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);

        SledContract sledContract = new SledContract();

        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XZCE");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        sledBaseContract.setSledCommodityCode_("SF");
        sledBaseContract.setSledContractCode_("2001");

        sledContract.setSledBaseContract_(sledBaseContract);

        SledBaseContract relateSledContract_0 = new SledBaseContract();
        relateSledContract_0.setExchangeMic_("XZCE");
        relateSledContract_0.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledContract_0.setSledCommodityCode_("SF");
        relateSledContract_0.setSledContractCode_("2001");

        sledContract.setRelateSledContract_(0, relateSledContract_0);

        SledBaseContract relateSledContract_1 = new SledBaseContract();
        relateSledContract_1.setExchangeMic_("XZCE");
        relateSledContract_1.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledContract_1.setSledCommodityCode_("SF");
        relateSledContract_1.setSledContractCode_("2001");

        sledContract.setRelateSledContract_(1, relateSledContract_1);

        sledContract.setRelateSledContractCount_(2); //2个关联商品

        args.setSledContract_(sledContract);

        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap.setTechPlatform_Exchange_("CZCE");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commodityMap.setTechPlatform_CommodityCode_("SF");

        args.setCommodityMap_(commodityMap);

        CommodityMap commodityMap_0 = new CommodityMap();
        commodityMap_0.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap_0.setTechPlatform_Exchange_("CZCE");
        commodityMap_0.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commodityMap_0.setTechPlatform_CommodityCode_("SF");

        args.setRelateCommodityMap_(0, commodityMap_0);

        CommodityMap commodityMap_1 = new CommodityMap();
        commodityMap_1.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap_1.setTechPlatform_Exchange_("CZCE");
        commodityMap_1.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commodityMap_1.setTechPlatform_CommodityCode_("SF");

        args.setRelateCommodityMap_(2, commodityMap_1);

        args.setRelateCommodityMapCount_(2);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        System.out.println("Input Info:");
        System.out.println("Tech Platform:" + args.getTechPlatform_());
        System.out.println("Sled Exchange:" + args.getSledContract_().getSledBaseContract_().getExchangeMic_());
        System.out.println("Sled CommodityType:" + args.getSledContract_().getSledBaseContract_().getSledCommodityType_());
        System.out.println("SledCommodity:" + args.getSledContract_().getSledBaseContract_().getSledCommodityCode_());
        System.out.println("SledContractCode:" + args.getSledContract_().getSledBaseContract_().getSledContractCode_());

        System.out.println("Relate[0] Exchange:" + relateSledContract_0.getExchangeMic_());
        System.out.println("Relate[0] CommodityType:" + relateSledContract_0.getSledCommodityType_());
        System.out.println("Relate[0]Commodity:" + relateSledContract_0.getSledCommodityCode_());
        System.out.println("Relate[0]ContractCode:" + relateSledContract_0.getSledContractCode_());

        System.out.println("Relate[0] Exchange:" + relateSledContract_1.getExchangeMic_());
        System.out.println("Relate[0] CommodityType:" + relateSledContract_1.getSledCommodityType_());
        System.out.println("Relate[0]Commodity:" + relateSledContract_1.getSledCommodityCode_());
        System.out.println("Relate[0]ContractCode:" + relateSledContract_1.getSledContractCode_());

        System.out.println("Map Tech Platform:" + commodityMap.getTechPlatform_());
        System.out.println("Map CTP Exchange:" + commodityMap.getTechPlatform_Exchange_());
        System.out.println("Map CTP CommodityType:" + commodityMap.getTechPlatform_CommodityType_());
        System.out.println("Map CTPCommodity:" + commodityMap.getTechPlatform_CommodityCode_());

        System.out.println("Map Tech Platform:" + commodityMap_0.getTechPlatform_());
        System.out.println("Map CTP Relate[0] Exchange:" + commodityMap_0.getTechPlatform_Exchange_());
        System.out.println("Map CTP Relate[0] CommodityType:" + commodityMap_0.getTechPlatform_CommodityType_());
        System.out.println("Map CTP Relate[0]Commodity:" + commodityMap_0.getTechPlatform_CommodityCode_());

        System.out.println("Map Tech Platform:" + commodityMap_1.getTechPlatform_());
        System.out.println("Map CTP Relate[1] Exchange:" + commodityMap_1.getTechPlatform_Exchange_());
        System.out.println("Map CTP Relate[1] CommodityType:" + commodityMap_1.getTechPlatform_CommodityType_());
        System.out.println("Map CTP Relate[1]Commodity:" + commodityMap_1.getTechPlatform_CommodityCode_());

        System.out.println("Convert Result:");
        System.out.println("Tech Platform:" + result.getTechPlatform_());
        System.out.println("CTPContractCode:" + result.getCommonContract_().getTechPlatform_ContractCode_());
    }

    static void testSledSpreadToCtpContract()
    {
        // 测试1 -- 郑商所跨期
        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);

        SledContract sledContract = new SledContract();

        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XZCE");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_SPREAD_MONTH);
        sledBaseContract.setSledCommodityCode_("SF");
        sledBaseContract.setSledContractCode_("1801/1805");

        sledContract.setSledBaseContract_(sledBaseContract);

        SledBaseContract relateSledContract_0 = new SledBaseContract();
        relateSledContract_0.setExchangeMic_("XZCE");
        relateSledContract_0.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledContract_0.setSledCommodityCode_("SF");
        relateSledContract_0.setSledContractCode_("1801");

        sledContract.setRelateSledContract_(0, relateSledContract_0);

        SledBaseContract relateSledContract_1 = new SledBaseContract();
        relateSledContract_1.setExchangeMic_("XZCE");
        relateSledContract_1.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledContract_1.setSledCommodityCode_("SF");
        relateSledContract_1.setSledContractCode_("1805");

        sledContract.setRelateSledContract_(1, relateSledContract_1);

        sledContract.setRelateSledContractCount_(2); //2个关联商品

        args.setSledContract_(sledContract);

        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap.setTechPlatform_Exchange_("CZCE");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination));
        commodityMap.setTechPlatform_CommodityCode_("SPD  SF&SF");

        args.setCommodityMap_(commodityMap);

        CommodityMap commodityMap_0 = new CommodityMap();
        commodityMap_0.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap_0.setTechPlatform_Exchange_("CZCE");
        commodityMap_0.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commodityMap_0.setTechPlatform_CommodityCode_("SF");

        args.setRelateCommodityMap_(0, commodityMap_0);

        CommodityMap commodityMap_1 = new CommodityMap();
        commodityMap_1.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap_1.setTechPlatform_Exchange_("CZCE");
        commodityMap_1.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commodityMap_1.setTechPlatform_CommodityCode_("SF");

        args.setRelateCommodityMap_(1, commodityMap_1);

        args.setRelateCommodityMapCount_(2);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        System.out.println("Input Info:");
        System.out.println("Tech Platform:" + args.getTechPlatform_());
        System.out.println("Sled Exchange:" + args.getSledContract_().getSledBaseContract_().getExchangeMic_());
        System.out.println("Sled CommodityType:" + args.getSledContract_().getSledBaseContract_().getSledCommodityType_());
        System.out.println("SledCommodity:" + args.getSledContract_().getSledBaseContract_().getSledCommodityCode_());
        System.out.println("SledContractCode:" + args.getSledContract_().getSledBaseContract_().getSledContractCode_());

        System.out.println("Relate[0] Exchange:" + relateSledContract_0.getExchangeMic_());
        System.out.println("Relate[0] CommodityType:" + relateSledContract_0.getSledCommodityType_());
        System.out.println("Relate[0]Commodity:" + relateSledContract_0.getSledCommodityCode_());
        System.out.println("Relate[0]ContractCode:" + relateSledContract_0.getSledContractCode_());

        System.out.println("Relate[0] Exchange:" + relateSledContract_1.getExchangeMic_());
        System.out.println("Relate[0] CommodityType:" + relateSledContract_1.getSledCommodityType_());
        System.out.println("Relate[0]Commodity:" + relateSledContract_1.getSledCommodityCode_());
        System.out.println("Relate[0]ContractCode:" + relateSledContract_1.getSledContractCode_());

        System.out.println("Map Tech Platform:" + commodityMap.getTechPlatform_());
        System.out.println("Map CTP Exchange:" + commodityMap.getTechPlatform_Exchange_());
        System.out.println("Map CTP CommodityType:" + commodityMap.getTechPlatform_CommodityType_());
        System.out.println("Map CTPCommodity:" + commodityMap.getTechPlatform_CommodityCode_());

        System.out.println("Map Tech Platform:" + commodityMap_0.getTechPlatform_());
        System.out.println("Map CTP Relate[0] Exchange:" + commodityMap_0.getTechPlatform_Exchange_());
        System.out.println("Map CTP Relate[0] CommodityType:" + commodityMap_0.getTechPlatform_CommodityType_());
        System.out.println("Map CTP Relate[0]Commodity:" + commodityMap_0.getTechPlatform_CommodityCode_());

        System.out.println("Map Tech Platform:" + commodityMap_1.getTechPlatform_());
        System.out.println("Map CTP Relate[1] Exchange:" + commodityMap_1.getTechPlatform_Exchange_());
        System.out.println("Map CTP Relate[1] CommodityType:" + commodityMap_1.getTechPlatform_CommodityType_());
        System.out.println("Map CTP Relate[1]Commodity:" + commodityMap_1.getTechPlatform_CommodityCode_());

        System.out.println("Convert Result:");
        System.out.println("Tech Platform:" + result.getTechPlatform_());
        System.out.println("CTPContractCode:" + result.getCommonContract_().getTechPlatform_ContractCode_());
    }
}
