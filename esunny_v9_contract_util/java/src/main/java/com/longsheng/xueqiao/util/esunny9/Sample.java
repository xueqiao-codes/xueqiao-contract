package com.longsheng.xueqiao.util.esunny9;

/**
 * Created by Jason on 2018/7/19.
 */

import com.longsheng.xueqiao.util.esunny9.swig.*;

public class Sample {
    public static void main(String[] args) {
        //加载so
        LibraryLoader.init();

        //设置初始化信息（账号、IP、授权码）


        //模拟账号
        EsLoginInfo esLoginInfo = new EsLoginInfo();
        esLoginInfo.setUserNo("Q2691455");
        esLoginInfo.setPassword("487211");
        esLoginInfo.setIp("123.161.206.213");
        esLoginInfo.setPort(8383);
        esLoginInfo.setAuthCode("67EA896065459BECDFDB924B29CB7DF1946CED32E26C1EAC946CED32E26C1EAC946CED32E26C1EAC946CED32E26C1EAC5211AF9FEE541DDE41BCBAB68D525B0D111A0884D847D57163FF7F329FA574E7946CED32E26C1EAC946CED32E26C1EAC733827B0CE853869ABD9B8F170E14F8847D3EA0BF4E191F5D97B3DFE4CCB1F01842DD2B3EA2F4B20CAD19B8347719B7E20EA1FA7A3D1BFEFF22290F4B5C43E6C520ED5A40EC1D50ACDF342F46A92CCF87AEE6D73542C42EC17818349C7DEDAB0E4DB16977714F873D505029E27B3D57EB92D5BEDA0A710197EB67F94BB1892B30F58A3F211D9C3B3839BE2D73FD08DD776B9188654853DDA57675EBB7D6FBBFC");


        //实盘账号
        /*
        EsLoginInfo esLoginInfo = new EsLoginInfo();
        esLoginInfo.setUserNo("");
        esLoginInfo.setPassword("");
        esLoginInfo.setIp("210.176.173.163");
        esLoginInfo.setPort(8886);
        esLoginInfo.setAuthCode("204D597AAB3CB6E649F597ED08D42A6C946CED32E26C1EAC946CED32E26C1EAC946CED32E26C1EAC946CED32E26C1EACAE278E1FDBF325F70C6A683AF32D0602946CED32E26C1EACADAAB67FF40DD54047531CE2ABEE6172946CED32E26C1EACD33D6030790F896588A207070965E1B8972A6F97458DD80F5B62423465DC551369845644805D2C505A2849B05D74F3B81416E94EBD884CB448023DFE03067729C69699C7EBBCA06A4953AC44EA780AA710293A9ED8622286BB3473923AA3F96B785C5D9F10F2EC079F4C67E83EE3B0D4CEF19308240678820FB601D6C154C4A5D42D2BEA52759C48A4D0A16BD5DF83F996F454B480DDF7713013B6216C910826");
        */

        /*
            信息获取过程
            1，调用初始化；
                初始化有2种方式
                1）不指定参数商品类型参数。不指定初始化哪些商品类型的合约，默认取全部合约，时间比较久
                2）指定参数商品类型参数。初始化指定商品类型，只初始化指定商品类型的合约，如果没有期权，时间比较短
            2，初始化完毕后，回调函数会收到完成通知
            3，主动去Get商品信息、合约信息
                Get合约也有2种方式
                1）不指定商品类型参数
                2）指定商品类型参数
            4，回调函数会收到商品信息、合约信息
        */

        EsunnyTradeSwig esunnyTradeSwig = new EsunnyTradeSwig();

        //收取商品、合约信息，需要实现对应的回调函数
        EsunnyTradeSwigCallback callback = new EsunnyTradeSwigCallback();
        callback.setEsunnyTradeSwig(esunnyTradeSwig); //用于在初始化完成后，主动Get信息

        /*
            初始化，商品信息、合约信息会在回调函数给出
            初始化有2种方式
                1）不指定参数商品类型参数。不指定初始化哪些商品类型的合约，默认取全部合约，时间比较久
                2）指定参数商品类型参数。初始化指定商品类型，只初始化指定商品类型的合约，如果没有期权，时间比较短
        */

        //初始化方式1
        //esunnyTradeSwig.Init(esLoginInfo, callback);

        //初始化方式2
        QryCommodityType qryCommodityType = new QryCommodityType();
        qryCommodityType.setEnable_Futures(true);
        qryCommodityType.setEnable_Spread_Month(true);
        qryCommodityType.setEnable_Spread_Commodity(true);
        esunnyTradeSwig.Init(esLoginInfo, callback, qryCommodityType);


    }
}
