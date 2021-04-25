package com.longsheng.xueqiao.ctp_service.core.trade;

import com.longsheng.xueqiao.ctp_service.thriftapi.*;

import java.util.List;

/**
 * Created by suker on 17/8/7.
 */
public interface ICtpTradeApi {
    List<CtpInstrument> reqInstrumentList(String instrumentId) throws Exception;

    List<CtpProduct> reqProducts(String productId) throws Exception;
}
