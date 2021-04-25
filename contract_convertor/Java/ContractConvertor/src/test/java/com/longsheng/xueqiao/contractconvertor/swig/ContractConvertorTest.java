package com.longsheng.xueqiao.contractconvertor.swig;

import com.longsheng.xueqiao.contractconvertor.LibraryLoader;
import com.longsheng.xueqiao.contractconvertor.util.ObjectToString;

import static org.junit.Assert.*;

/**
 * Created by ihsl on 2018/2/8.
 */
public class ContractConvertorTest {

    //郑商所期货 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_CZCE_Future() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("CZCE");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commonContract.setTechPlatform_CommodityCode_("RM");
        commonContract.setTechPlatform_ContractCode_("RM801");
        args.setCommonContract_(commonContract);
        args.setOtherCommonContractCount_(0);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("CZCE", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("RM", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("1801", result.getMixContract_().getSledContractCode_());

        assertEquals(0, result.getRelateMixContractCount_());

    }

    //大商所期货 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_DCE_Future() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("DCE");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commonContract.setTechPlatform_CommodityCode_("j");
        commonContract.setTechPlatform_ContractCode_("j1805");
        args.setCommonContract_(commonContract);
        args.setOtherCommonContractCount_(0);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("DCE", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("j", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("1805", result.getMixContract_().getSledContractCode_());

        assertEquals(0, result.getRelateMixContractCount_());
    }

    //上期所期货 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_SHFE_Future() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("SHFE");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commonContract.setTechPlatform_CommodityCode_("au");
        commonContract.setTechPlatform_ContractCode_("au1806");
        args.setCommonContract_(commonContract);
        args.setOtherCommonContractCount_(0);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("SHFE", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("au", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("1806", result.getMixContract_().getSledContractCode_());

        assertEquals(0, result.getRelateMixContractCount_());
    }

    //中金所期货 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_CFFEX_Future() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("CFFEX");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commonContract.setTechPlatform_CommodityCode_("IF");
        commonContract.setTechPlatform_ContractCode_("IF1803");
        args.setCommonContract_(commonContract);
        args.setOtherCommonContractCount_(0);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("CFFEX", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("IF", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("1803", result.getMixContract_().getSledContractCode_());

        assertEquals(0, result.getRelateMixContractCount_());
    }

    // 郑商所跨期 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_CZCE_SpeadMonth() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("CZCE");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination));
        commonContract.setTechPlatform_CommodityCode_("SPD CY&CY");
        commonContract.setTechPlatform_ContractCode_("SPD CY809&CY812");
        args.setCommonContract_(commonContract);
        args.setOtherCommonContractCount_(0);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("CZCE", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("SPD CY&CY", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("1809&1812", result.getMixContract_().getSledContractCode_());

        assertEquals(2, result.getRelateMixContractCount_());

        assertEquals("CZCE", result.getRelateMixContract_(0).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getRelateMixContract_(0).getTechPlatform_CommodityType_());
        assertEquals("CY", result.getRelateMixContract_(0).getTechPlatform_CommodityCode_());
        assertEquals("1809", result.getRelateMixContract_(0).getSledContractCode_());

        assertEquals("CZCE", result.getRelateMixContract_(1).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getRelateMixContract_(1).getTechPlatform_CommodityType_());
        assertEquals("CY", result.getRelateMixContract_(1).getTechPlatform_CommodityCode_());
        assertEquals("1812", result.getRelateMixContract_(1).getSledContractCode_());
    }

    // 大商所跨期 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_DCE_SpeadMonth() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("DCE");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination));
        commonContract.setTechPlatform_CommodityCode_("SP i&i");
        commonContract.setTechPlatform_ContractCode_("SP i1805&i1809");
        args.setCommonContract_(commonContract);
        args.setOtherCommonContractCount_(0);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("DCE", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("SP i&i", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("1805&1809", result.getMixContract_().getSledContractCode_());

        assertEquals(2, result.getRelateMixContractCount_());

        assertEquals("DCE", result.getRelateMixContract_(0).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getRelateMixContract_(0).getTechPlatform_CommodityType_());
        assertEquals("i", result.getRelateMixContract_(0).getTechPlatform_CommodityCode_());
        assertEquals("1805", result.getRelateMixContract_(0).getSledContractCode_());

        assertEquals("DCE", result.getRelateMixContract_(1).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getRelateMixContract_(1).getTechPlatform_CommodityType_());
        assertEquals("i", result.getRelateMixContract_(1).getTechPlatform_CommodityCode_());
        assertEquals("1809", result.getRelateMixContract_(1).getSledContractCode_());

    }

    // 郑商所跨品种 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_CZCE_SpeadCommodity() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("CZCE");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination));
        commonContract.setTechPlatform_CommodityCode_("IPS SF&SM");
        commonContract.setTechPlatform_ContractCode_("IPS SF005&SM005");
        args.setCommonContract_(commonContract);
        args.setOtherCommonContractCount_(0);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("CZCE", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("IPS SF&SM", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("2005&2005", result.getMixContract_().getSledContractCode_());

        assertEquals(2, result.getRelateMixContractCount_());

        assertEquals("CZCE", result.getRelateMixContract_(0).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getRelateMixContract_(0).getTechPlatform_CommodityType_());
        assertEquals("SF", result.getRelateMixContract_(0).getTechPlatform_CommodityCode_());
        assertEquals("2005", result.getRelateMixContract_(0).getSledContractCode_());

        assertEquals("CZCE", result.getRelateMixContract_(1).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getRelateMixContract_(1).getTechPlatform_CommodityType_());
        assertEquals("SM", result.getRelateMixContract_(1).getTechPlatform_CommodityCode_());
        assertEquals("2005", result.getRelateMixContract_(1).getSledContractCode_());
    }

    // 大商所跨品种 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_DCE_SpeadCommodity() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("DCE");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination));
        commonContract.setTechPlatform_CommodityCode_("SPC y&p");
        commonContract.setTechPlatform_ContractCode_("SPC y1912&p1912");
        args.setCommonContract_(commonContract);
        args.setOtherCommonContractCount_(0);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("DCE", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("SPC y&p", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("1912&1912", result.getMixContract_().getSledContractCode_());

        assertEquals(2, result.getRelateMixContractCount_());

        assertEquals("DCE", result.getRelateMixContract_(0).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getRelateMixContract_(0).getTechPlatform_CommodityType_());
        assertEquals("y", result.getRelateMixContract_(0).getTechPlatform_CommodityCode_());
        assertEquals("1912", result.getRelateMixContract_(0).getSledContractCode_());

        assertEquals("DCE", result.getRelateMixContract_(1).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getRelateMixContract_(1).getTechPlatform_CommodityType_());
        assertEquals("p", result.getRelateMixContract_(1).getTechPlatform_CommodityCode_());
        assertEquals("1912", result.getRelateMixContract_(1).getSledContractCode_());
    }

    //易盛9.0期货 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_EsunyyV9_Future() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("COMEX");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Futures));
        commonContract.setTechPlatform_CommodityCode_("GC");
        commonContract.setTechPlatform_ContractCode_("1804");
        args.setCommonContract_(commonContract);
        args.setOtherCommonContractCount_(0);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_ESUNNY, result.getTechPlatform_());

        assertEquals("COMEX", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Futures), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("GC", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("1804", result.getMixContract_().getSledContractCode_());

        assertEquals(0, result.getRelateMixContractCount_());
    }

    // 易盛9.0跨期 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_EsunnyV9_SpeadMonth() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("COMEX");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Spread_Month));
        commonContract.setTechPlatform_CommodityCode_("GC");
        commonContract.setTechPlatform_ContractCode_("1812");
        args.setCommonContract_(commonContract);

        CommonContract otherCommonContract = new CommonContract();
        otherCommonContract.setTechPlatform_ContractCode_("1904");
        args.setOtherCommonContract_(0, otherCommonContract);
        args.setOtherCommonContractCount_(1);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_ESUNNY, result.getTechPlatform_());

        assertEquals("COMEX", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Spread_Month), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("GC", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("1812&1904", result.getMixContract_().getSledContractCode_());

        assertEquals(2, result.getRelateMixContractCount_());

        assertEquals("COMEX", result.getRelateMixContract_(0).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Futures), result.getRelateMixContract_(0).getTechPlatform_CommodityType_());
        assertEquals("GC", result.getRelateMixContract_(0).getTechPlatform_CommodityCode_());
        assertEquals("1812", result.getRelateMixContract_(0).getSledContractCode_());

        assertEquals("COMEX", result.getRelateMixContract_(1).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Futures), result.getRelateMixContract_(1).getTechPlatform_CommodityType_());
        assertEquals("GC", result.getRelateMixContract_(1).getTechPlatform_CommodityCode_());
        assertEquals("1904", result.getRelateMixContract_(1).getSledContractCode_());
    }

    //易盛3.0期货 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_EsunyyV3_Future() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY_3);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("COMEX");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Futures));
        commonContract.setTechPlatform_CommodityCode_("SI");
        commonContract.setTechPlatform_ContractCode_("1806");
        args.setCommonContract_(commonContract);
        args.setOtherCommonContractCount_(0);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_ESUNNY_3, result.getTechPlatform_());

        assertEquals("COMEX", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Futures), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("SI", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("1806", result.getMixContract_().getSledContractCode_());

        assertEquals(0, result.getRelateMixContractCount_());
    }

    // 易盛3.0跨期 转 雪橇合约
    @org.junit.Test
    public void platformToSledContract_EsunnyV3_SpeadMonth() throws Exception {
        LibraryLoader.init();

        TechPlatformContractToSledArgs args = new TechPlatformContractToSledArgs();
        args.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY_3);
        CommonContract commonContract = new CommonContract();
        commonContract.setTechPlatform_Exchange_("COMEX");
        commonContract.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Spread_Month));
        commonContract.setTechPlatform_CommodityCode_("SI");
        commonContract.setTechPlatform_ContractCode_("1812/1903");
        args.setCommonContract_(commonContract);

        args.setOtherCommonContractCount_(0);

        TechPlatformContractToSledResult result = ContractConvertor.PlatformToSledContract(args);

        assertEquals(TechPlatform.TechPlatform_ESUNNY_3, result.getTechPlatform_());

        assertEquals("COMEX", result.getMixContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Spread_Month), result.getMixContract_().getTechPlatform_CommodityType_());
        assertEquals("SI", result.getMixContract_().getTechPlatform_CommodityCode_());
        assertEquals("1812&1903", result.getMixContract_().getSledContractCode_());

        assertEquals(2, result.getRelateMixContractCount_());

        assertEquals("COMEX", result.getRelateMixContract_(0).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Futures), result.getRelateMixContract_(0).getTechPlatform_CommodityType_());
        assertEquals("SI", result.getRelateMixContract_(0).getTechPlatform_CommodityCode_());
        assertEquals("1812", result.getRelateMixContract_(0).getSledContractCode_());

        assertEquals("COMEX", result.getRelateMixContract_(1).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Futures), result.getRelateMixContract_(1).getTechPlatform_CommodityType_());
        assertEquals("SI", result.getRelateMixContract_(1).getTechPlatform_CommodityCode_());
        assertEquals("1903", result.getRelateMixContract_(1).getSledContractCode_());
    }










    //雪橇合约  转 郑商所期货
    @org.junit.Test
    public void sledToPlatformContract_CZCE_Futures() throws Exception {
        LibraryLoader.init();

        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();

        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);

        SledContract sledContract = new SledContract();
        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XZCE");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        sledBaseContract.setSledCommodityCode_("SF");
        sledBaseContract.setSledContractCode_("2001");

        sledContract.setSledBaseContract_(sledBaseContract);
        sledContract.setRelateSledContractCount_(0);

        args.setSledContract_(sledContract);

        //商品映射Map
        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap.setTechPlatform_Exchange_("CZCE");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commodityMap.setTechPlatform_CommodityCode_("SF");

        args.setCommodityMap_(commodityMap);
        args.setRelateCommodityMapCount_(0);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("CZCE", result.getCommonContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getCommonContract_().getTechPlatform_CommodityType_());
        assertEquals("SF", result.getCommonContract_().getTechPlatform_CommodityCode_());
        assertEquals("SF001", result.getCommonContract_().getTechPlatform_ContractCode_());

        assertEquals(0, result.getOtherCommonContractCount_());

        System.out.println(ObjectToString.getStringFromObject(args));
        System.out.println(ObjectToString.getStringFromObject(result));
    }

    //雪橇合约  转 大商所期货
    @org.junit.Test
    public void sledToPlatformContract_DCE_Futures() throws Exception {
        LibraryLoader.init();

        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();

        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);

        SledContract sledContract = new SledContract();
        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XDCE");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        sledBaseContract.setSledCommodityCode_("i");
        sledBaseContract.setSledContractCode_("1912");

        sledContract.setSledBaseContract_(sledBaseContract);
        sledContract.setRelateSledContractCount_(0);

        args.setSledContract_(sledContract);

        //商品映射Map
        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap.setTechPlatform_Exchange_("DCE");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        commodityMap.setTechPlatform_CommodityCode_("i");

        args.setCommodityMap_(commodityMap);
        args.setRelateCommodityMapCount_(0);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("DCE", result.getCommonContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures), result.getCommonContract_().getTechPlatform_CommodityType_());
        assertEquals("i", result.getCommonContract_().getTechPlatform_CommodityCode_());
        assertEquals("i1912", result.getCommonContract_().getTechPlatform_ContractCode_());

        assertEquals(0, result.getOtherCommonContractCount_());
    }


    //雪橇合约  转 郑商所跨期
    @org.junit.Test
    public void sledToPlatformContract_CZCE_SpreadMonth() throws Exception {
        LibraryLoader.init();

        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();

        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);

        SledContract sledContract = new SledContract();
        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XZCE");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_SPREAD_MONTH);
        sledBaseContract.setSledCommodityCode_("SF");
        sledBaseContract.setSledContractCode_("2001/2005");

        sledContract.setSledBaseContract_(sledBaseContract);

        SledBaseContract relateSledBaseContract_0 = new SledBaseContract();
        relateSledBaseContract_0.setExchangeMic_("XZCE");
        relateSledBaseContract_0.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_0.setSledCommodityCode_("SF");
        relateSledBaseContract_0.setSledContractCode_("2001");
        sledContract.setRelateSledContract_(0, relateSledBaseContract_0);

        SledBaseContract relateSledBaseContract_1 = new SledBaseContract();
        relateSledBaseContract_1.setExchangeMic_("XZCE");
        relateSledBaseContract_1.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_1.setSledCommodityCode_("SF");
        relateSledBaseContract_1.setSledContractCode_("2005");
        sledContract.setRelateSledContract_(1, relateSledBaseContract_1);

        sledContract.setRelateSledContractCount_(2);

        args.setSledContract_(sledContract);

        //商品映射Map
        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap.setTechPlatform_Exchange_("CZCE");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination));
        commodityMap.setTechPlatform_CommodityCode_("SPD SF&SF");
        args.setCommodityMap_(commodityMap);

        CommodityMap relateCommodityMap_0 = new CommodityMap();
        relateCommodityMap_0.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        relateCommodityMap_0.setTechPlatform_Exchange_("CZCE");
        relateCommodityMap_0.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        relateCommodityMap_0.setTechPlatform_CommodityCode_("SF");
        args.setRelateCommodityMap_(0, relateCommodityMap_0);

        CommodityMap relateCommodityMap_1 = new CommodityMap();
        relateCommodityMap_1.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        relateCommodityMap_1.setTechPlatform_Exchange_("CZCE");
        relateCommodityMap_1.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        relateCommodityMap_1.setTechPlatform_CommodityCode_("SF");
        args.setRelateCommodityMap_(1, relateCommodityMap_1);

        args.setRelateCommodityMapCount_(2);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("CZCE", result.getCommonContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination), result.getCommonContract_().getTechPlatform_CommodityType_());
        assertEquals("SPD SF&SF", result.getCommonContract_().getTechPlatform_CommodityCode_());
        assertEquals("SPD SF001&SF005", result.getCommonContract_().getTechPlatform_ContractCode_());

        assertEquals(0, result.getOtherCommonContractCount_());

    }

    //雪橇合约  转 大商所跨期
    @org.junit.Test
    public void sledToPlatformContract_DCE_SpreadMonth() throws Exception {
        LibraryLoader.init();

        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();

        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);

        SledContract sledContract = new SledContract();
        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XDCE");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_SPREAD_MONTH);
        sledBaseContract.setSledCommodityCode_("i");
        sledBaseContract.setSledContractCode_("1912/2005");

        sledContract.setSledBaseContract_(sledBaseContract);

        SledBaseContract relateSledBaseContract_0 = new SledBaseContract();
        relateSledBaseContract_0.setExchangeMic_("XDCE");
        relateSledBaseContract_0.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_0.setSledCommodityCode_("i");
        relateSledBaseContract_0.setSledContractCode_("1912");
        sledContract.setRelateSledContract_(0, relateSledBaseContract_0);

        SledBaseContract relateSledBaseContract_1 = new SledBaseContract();
        relateSledBaseContract_1.setExchangeMic_("XDCE");
        relateSledBaseContract_1.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_1.setSledCommodityCode_("i");
        relateSledBaseContract_1.setSledContractCode_("2005");
        sledContract.setRelateSledContract_(1, relateSledBaseContract_1);

        sledContract.setRelateSledContractCount_(2);

        args.setSledContract_(sledContract);

        //商品映射Map
        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap.setTechPlatform_Exchange_("DCE");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination));
        commodityMap.setTechPlatform_CommodityCode_("SP i&i");
        args.setCommodityMap_(commodityMap);

        CommodityMap relateCommodityMap_0 = new CommodityMap();
        relateCommodityMap_0.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        relateCommodityMap_0.setTechPlatform_Exchange_("DCE");
        relateCommodityMap_0.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        relateCommodityMap_0.setTechPlatform_CommodityCode_("i");
        args.setRelateCommodityMap_(0, relateCommodityMap_0);

        CommodityMap relateCommodityMap_1 = new CommodityMap();
        relateCommodityMap_1.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        relateCommodityMap_1.setTechPlatform_Exchange_("DCE");
        relateCommodityMap_1.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        relateCommodityMap_1.setTechPlatform_CommodityCode_("i");
        args.setRelateCommodityMap_(1, relateCommodityMap_1);

        args.setRelateCommodityMapCount_(2);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("DCE", result.getCommonContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination), result.getCommonContract_().getTechPlatform_CommodityType_());
        assertEquals("SP i&i", result.getCommonContract_().getTechPlatform_CommodityCode_());
        assertEquals("SP i1912&i2005", result.getCommonContract_().getTechPlatform_ContractCode_());

        assertEquals(0, result.getOtherCommonContractCount_());
    }

    //雪橇合约  转 郑商所跨品种
    @org.junit.Test
    public void sledToPlatformContract_CZCE_SpreadCommodity() throws Exception {
        LibraryLoader.init();

        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();

        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);

        SledContract sledContract = new SledContract();
        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XZCE");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_SPREAD_COMMODITY);
        sledBaseContract.setSledCommodityCode_("SF&SM");
        sledBaseContract.setSledContractCode_("2001/2005");

        sledContract.setSledBaseContract_(sledBaseContract);

        SledBaseContract relateSledBaseContract_0 = new SledBaseContract();
        relateSledBaseContract_0.setExchangeMic_("XZCE");
        relateSledBaseContract_0.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_0.setSledCommodityCode_("SF");
        relateSledBaseContract_0.setSledContractCode_("2001");
        sledContract.setRelateSledContract_(0, relateSledBaseContract_0);

        SledBaseContract relateSledBaseContract_1 = new SledBaseContract();
        relateSledBaseContract_1.setExchangeMic_("XZCE");
        relateSledBaseContract_1.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_1.setSledCommodityCode_("SM");
        relateSledBaseContract_1.setSledContractCode_("2005");
        sledContract.setRelateSledContract_(1, relateSledBaseContract_1);

        sledContract.setRelateSledContractCount_(2);

        args.setSledContract_(sledContract);

        //商品映射Map
        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap.setTechPlatform_Exchange_("CZCE");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination));
        commodityMap.setTechPlatform_CommodityCode_("IPS SF&SM");
        args.setCommodityMap_(commodityMap);

        CommodityMap relateCommodityMap_0 = new CommodityMap();
        relateCommodityMap_0.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        relateCommodityMap_0.setTechPlatform_Exchange_("CZCE");
        relateCommodityMap_0.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        relateCommodityMap_0.setTechPlatform_CommodityCode_("SF");
        args.setRelateCommodityMap_(0, relateCommodityMap_0);

        CommodityMap relateCommodityMap_1 = new CommodityMap();
        relateCommodityMap_1.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        relateCommodityMap_1.setTechPlatform_Exchange_("CZCE");
        relateCommodityMap_1.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        relateCommodityMap_1.setTechPlatform_CommodityCode_("SM");
        args.setRelateCommodityMap_(1, relateCommodityMap_1);

        args.setRelateCommodityMapCount_(2);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("CZCE", result.getCommonContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination), result.getCommonContract_().getTechPlatform_CommodityType_());
        assertEquals("IPS SF&SM", result.getCommonContract_().getTechPlatform_CommodityCode_());
        assertEquals("IPS SF001&SM005", result.getCommonContract_().getTechPlatform_ContractCode_());

        assertEquals(0, result.getOtherCommonContractCount_());
    }

    //雪橇合约  转 大商所跨品种
    @org.junit.Test
    public void sledToPlatformContract_DCE_SpreadCommidity() throws Exception {
        LibraryLoader.init();

        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();

        args.setTechPlatform_(TechPlatform.TechPlatform_CTP);

        SledContract sledContract = new SledContract();
        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XDCE");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_SPREAD_COMMODITY);
        sledBaseContract.setSledCommodityCode_("i&j");
        sledBaseContract.setSledContractCode_("1912/2005");

        sledContract.setSledBaseContract_(sledBaseContract);

        SledBaseContract relateSledBaseContract_0 = new SledBaseContract();
        relateSledBaseContract_0.setExchangeMic_("XDCE");
        relateSledBaseContract_0.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_0.setSledCommodityCode_("i");
        relateSledBaseContract_0.setSledContractCode_("1912");
        sledContract.setRelateSledContract_(0, relateSledBaseContract_0);

        SledBaseContract relateSledBaseContract_1 = new SledBaseContract();
        relateSledBaseContract_1.setExchangeMic_("XDCE");
        relateSledBaseContract_1.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_1.setSledCommodityCode_("j");
        relateSledBaseContract_1.setSledContractCode_("2005");
        sledContract.setRelateSledContract_(1, relateSledBaseContract_1);

        sledContract.setRelateSledContractCount_(2);

        args.setSledContract_(sledContract);

        //商品映射Map
        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        commodityMap.setTechPlatform_Exchange_("DCE");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination));
        commodityMap.setTechPlatform_CommodityCode_("SPC i&j");
        args.setCommodityMap_(commodityMap);

        CommodityMap relateCommodityMap_0 = new CommodityMap();
        relateCommodityMap_0.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        relateCommodityMap_0.setTechPlatform_Exchange_("DCE");
        relateCommodityMap_0.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        relateCommodityMap_0.setTechPlatform_CommodityCode_("i");
        args.setRelateCommodityMap_(0, relateCommodityMap_0);

        CommodityMap relateCommodityMap_1 = new CommodityMap();
        relateCommodityMap_1.setTechPlatform_(TechPlatform.TechPlatform_CTP);
        relateCommodityMap_1.setTechPlatform_Exchange_("DCE");
        relateCommodityMap_1.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Futures));
        relateCommodityMap_1.setTechPlatform_CommodityCode_("j");
        args.setRelateCommodityMap_(1, relateCommodityMap_1);

        args.setRelateCommodityMapCount_(2);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        assertEquals(TechPlatform.TechPlatform_CTP, result.getTechPlatform_());

        assertEquals("DCE", result.getCommonContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.Ctp_CommodityType_Combination), result.getCommonContract_().getTechPlatform_CommodityType_());
        assertEquals("SPC i&j", result.getCommonContract_().getTechPlatform_CommodityCode_());
        assertEquals("SPC i1912&j2005", result.getCommonContract_().getTechPlatform_ContractCode_());

        assertEquals(0, result.getOtherCommonContractCount_());
    }

    //雪橇合约  转 易盛9.0期货
    @org.junit.Test
    public void sledToPlatformContract_EsunnyV9_Futures() throws Exception {
        LibraryLoader.init();

        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();

        args.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY);

        SledContract sledContract = new SledContract();
        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XCEC");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        sledBaseContract.setSledCommodityCode_("GC");
        sledBaseContract.setSledContractCode_("1912");

        sledContract.setSledBaseContract_(sledBaseContract);
        sledContract.setRelateSledContractCount_(0);

        args.setSledContract_(sledContract);

        //商品映射Map
        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY);
        commodityMap.setTechPlatform_Exchange_("COMEX");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Futures));
        commodityMap.setTechPlatform_CommodityCode_("GC");

        args.setCommodityMap_(commodityMap);
        args.setRelateCommodityMapCount_(0);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        assertEquals(TechPlatform.TechPlatform_ESUNNY, result.getTechPlatform_());

        assertEquals("COMEX", result.getCommonContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Futures), result.getCommonContract_().getTechPlatform_CommodityType_());
        assertEquals("GC", result.getCommonContract_().getTechPlatform_CommodityCode_());
        assertEquals("1912", result.getCommonContract_().getTechPlatform_ContractCode_());

        assertEquals(0, result.getOtherCommonContractCount_());
    }

    //雪橇合约  转 易盛9.0跨期
    @org.junit.Test
    public void sledToPlatformContract_EsunnyV9_SpreadMonth() throws Exception {
        LibraryLoader.init();

        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();

        args.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY);

        SledContract sledContract = new SledContract();
        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XCEC");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_SPREAD_MONTH);
        sledBaseContract.setSledCommodityCode_("GC");
        sledBaseContract.setSledContractCode_("2001/2005");

        sledContract.setSledBaseContract_(sledBaseContract);

        SledBaseContract relateSledBaseContract_0 = new SledBaseContract();
        relateSledBaseContract_0.setExchangeMic_("XCEC");
        relateSledBaseContract_0.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_0.setSledCommodityCode_("GC");
        relateSledBaseContract_0.setSledContractCode_("2001");
        sledContract.setRelateSledContract_(0, relateSledBaseContract_0);

        SledBaseContract relateSledBaseContract_1 = new SledBaseContract();
        relateSledBaseContract_1.setExchangeMic_("XCEC");
        relateSledBaseContract_1.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_1.setSledCommodityCode_("GC");
        relateSledBaseContract_1.setSledContractCode_("2005");
        sledContract.setRelateSledContract_(1, relateSledBaseContract_1);

        sledContract.setRelateSledContractCount_(2);

        args.setSledContract_(sledContract);

        //商品映射Map
        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY);
        commodityMap.setTechPlatform_Exchange_("COMEX");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Spread_Month));
        commodityMap.setTechPlatform_CommodityCode_("GC");
        args.setCommodityMap_(commodityMap);

        CommodityMap relateCommodityMap_0 = new CommodityMap();
        relateCommodityMap_0.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY);
        relateCommodityMap_0.setTechPlatform_Exchange_("COMEX");
        relateCommodityMap_0.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Futures));
        relateCommodityMap_0.setTechPlatform_CommodityCode_("GC");
        args.setRelateCommodityMap_(0, relateCommodityMap_0);

        CommodityMap relateCommodityMap_1 = new CommodityMap();
        relateCommodityMap_1.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY);
        relateCommodityMap_1.setTechPlatform_Exchange_("COMEX");
        relateCommodityMap_1.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Futures));
        relateCommodityMap_1.setTechPlatform_CommodityCode_("GC");
        args.setRelateCommodityMap_(1, relateCommodityMap_1);

        args.setRelateCommodityMapCount_(2);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        assertEquals(TechPlatform.TechPlatform_ESUNNY, result.getTechPlatform_());

        assertEquals("COMEX", result.getCommonContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Spread_Month), result.getCommonContract_().getTechPlatform_CommodityType_());
        assertEquals("GC", result.getCommonContract_().getTechPlatform_CommodityCode_());
        assertEquals("2001", result.getCommonContract_().getTechPlatform_ContractCode_());

        assertEquals(1, result.getOtherCommonContractCount_());

        assertEquals("COMEX", result.getOtherCommonContract_(0).getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV9_CommodityType_Spread_Month), result.getOtherCommonContract_(0).getTechPlatform_CommodityType_());
        assertEquals("GC", result.getOtherCommonContract_(0).getTechPlatform_CommodityCode_());
        assertEquals("2005", result.getOtherCommonContract_(0).getTechPlatform_ContractCode_());
    }

    //雪橇合约  转 易盛3.0期货
    @org.junit.Test
    public void sledToPlatformContract_EsunnyV3_Futures() throws Exception {
        LibraryLoader.init();

        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();

        args.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY_3);

        SledContract sledContract = new SledContract();
        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XCEC");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        sledBaseContract.setSledCommodityCode_("SI");
        sledBaseContract.setSledContractCode_("1912");

        sledContract.setSledBaseContract_(sledBaseContract);
        sledContract.setRelateSledContractCount_(0);

        args.setSledContract_(sledContract);

        //商品映射Map
        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY_3);
        commodityMap.setTechPlatform_Exchange_("COMEX");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Futures));
        commodityMap.setTechPlatform_CommodityCode_("SI");

        args.setCommodityMap_(commodityMap);
        args.setRelateCommodityMapCount_(0);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        assertEquals(TechPlatform.TechPlatform_ESUNNY_3, result.getTechPlatform_());

        assertEquals("COMEX", result.getCommonContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Futures), result.getCommonContract_().getTechPlatform_CommodityType_());
        assertEquals("SI", result.getCommonContract_().getTechPlatform_CommodityCode_());
        assertEquals("1912", result.getCommonContract_().getTechPlatform_ContractCode_());

        assertEquals(0, result.getOtherCommonContractCount_());
    }

    //雪橇合约  转 易盛3.0跨期
    @org.junit.Test
    public void sledToPlatformContract_EsunnyV3_SpreadMonth() throws Exception {
        LibraryLoader.init();

        SledContractToTechPlatformArgs args = new SledContractToTechPlatformArgs();

        args.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY_3);

        SledContract sledContract = new SledContract();
        SledBaseContract sledBaseContract = new SledBaseContract();
        sledBaseContract.setExchangeMic_("XCEC");
        sledBaseContract.setSledCommodityType_(SledCommodityType.SledCommodityType_SPREAD_MONTH);
        sledBaseContract.setSledCommodityCode_("SI");
        sledBaseContract.setSledContractCode_("2001&2005");

        sledContract.setSledBaseContract_(sledBaseContract);

        SledBaseContract relateSledBaseContract_0 = new SledBaseContract();
        relateSledBaseContract_0.setExchangeMic_("XCEC");
        relateSledBaseContract_0.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_0.setSledCommodityCode_("SI");
        relateSledBaseContract_0.setSledContractCode_("2001");
        sledContract.setRelateSledContract_(0, relateSledBaseContract_0);

        SledBaseContract relateSledBaseContract_1 = new SledBaseContract();
        relateSledBaseContract_1.setExchangeMic_("XCEC");
        relateSledBaseContract_1.setSledCommodityType_(SledCommodityType.SledCommodityType_FUTURES);
        relateSledBaseContract_1.setSledCommodityCode_("SI");
        relateSledBaseContract_1.setSledContractCode_("2005");
        sledContract.setRelateSledContract_(1, relateSledBaseContract_1);

        sledContract.setRelateSledContractCount_(2);

        args.setSledContract_(sledContract);

        //商品映射Map
        CommodityMap commodityMap = new CommodityMap();
        commodityMap.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY_3);
        commodityMap.setTechPlatform_Exchange_("COMEX");
        commodityMap.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Spread_Month));
        commodityMap.setTechPlatform_CommodityCode_("SI");
        args.setCommodityMap_(commodityMap);

        CommodityMap relateCommodityMap_0 = new CommodityMap();
        relateCommodityMap_0.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY_3);
        relateCommodityMap_0.setTechPlatform_Exchange_("COMEX");
        relateCommodityMap_0.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Futures));
        relateCommodityMap_0.setTechPlatform_CommodityCode_("SI");
        args.setRelateCommodityMap_(0, relateCommodityMap_0);

        CommodityMap relateCommodityMap_1 = new CommodityMap();
        relateCommodityMap_1.setTechPlatform_(TechPlatform.TechPlatform_ESUNNY_3);
        relateCommodityMap_1.setTechPlatform_Exchange_("COMEX");
        relateCommodityMap_1.setTechPlatform_CommodityType_(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Futures));
        relateCommodityMap_1.setTechPlatform_CommodityCode_("GC");
        args.setRelateCommodityMap_(1, relateCommodityMap_1);

        args.setRelateCommodityMapCount_(2);

        SledContractToTechPlatformResult result = ContractConvertor.SledToPlatformContract(args);

        assertEquals(TechPlatform.TechPlatform_ESUNNY_3, result.getTechPlatform_());

        assertEquals("COMEX", result.getCommonContract_().getTechPlatform_Exchange_());
        assertEquals(String.valueOf(ContractConvertorConstants.EsunnyV3_CommodityType_Spread_Month), result.getCommonContract_().getTechPlatform_CommodityType_());
        assertEquals("SI", result.getCommonContract_().getTechPlatform_CommodityCode_());
        assertEquals("2001/2005", result.getCommonContract_().getTechPlatform_ContractCode_());

        assertEquals(0, result.getOtherCommonContractCount_());
    }

}