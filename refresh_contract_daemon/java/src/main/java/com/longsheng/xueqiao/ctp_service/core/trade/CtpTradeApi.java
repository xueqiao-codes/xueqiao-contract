package com.longsheng.xueqiao.ctp_service.core.trade;

import com.longsheng.xueqiao.ctp_service.CtpAccount;
import com.longsheng.xueqiao.ctp_service.thriftapi.*;
import net.jctp.*;
import net.jtrader.JTraderException;
import org.soldier.base.logger.AppLog;

import java.util.*;

import static com.longsheng.xueqiao.ctp_service.core.trade.CtpTransformer.*;

/**
 * Created by suker on 17/8/7.
 */
public class CtpTradeApi implements ICtpTradeApi {

    protected TraderApi traderApi;

    protected final Map<String, CtpProduct> qryProductMap = new HashMap<>();
    protected final Map<String, CtpInstrument> qryInstrumentMap = new HashMap<>();

    protected CtpTradeListener ctpTradeListener;
    private CtpAccount ctpAccount;

    public volatile boolean isRefresh = false;

    public CtpTradeApi(CtpAccount ctpAccount) {
        this.ctpAccount = ctpAccount;
        start();
    }

    public CtpAccount getCtpAccount() {
        return this.ctpAccount;
    }

    private void clearMaps() {
        qryProductMap.clear();
        qryInstrumentMap.clear();
    }

    protected void start() {
        ctpTradeListener = new CtpTradeListener(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    traderApi = new TraderApi();
                    traderApi.setListener(ctpTradeListener);
                    traderApi.setFlowControl(true);
                    traderApi.SubscribePrivateTopic(JctpConstants.THOST_TERT_QUICK);
                    traderApi.SubscribePublicTopic(JctpConstants.THOST_TERT_QUICK);
                } catch (Exception e) {
                    AppLog.e("trade api init fail: " + e.getMessage(), e);
                }
                try {
                    String host = ctpAccount.getHost();
                    AppLog.d("Connecting " + host + " ...");
                    traderApi.SyncConnect(host);
                } catch (JTraderException e) {
                    e.printStackTrace();
                    AppLog.e("sync connect fail: " + e.getMessage(), e);
                    traderApi.Close();
                }
            }
        }).start();

    }

    public void onRspQryInstrument(CThostFtdcInstrumentField pInstrument) {
        qryInstrumentMap.put(pInstrument.InstrumentID, getCtpInstrumentFromCThostFtdcInstrumentField(pInstrument));
    }

    public void onRspQryProduct(CThostFtdcProductField pProduct) {
        qryProductMap.put(pProduct.ProductID, getCtpProductFromCThostFtdcProductField(pProduct));
    }

    @Override
    public List<CtpInstrument> reqInstrumentList(String instrumentId) {
        if (instrumentId != null && instrumentId.length() > 0) {
            List<CtpInstrument> list = new ArrayList<CtpInstrument>();
            CtpInstrument instrument = qryInstrumentMap.get(instrumentId);
            if (instrument != null) {
                list.add(instrument);
            }
            return list;
        }
        return new ArrayList(qryInstrumentMap.values());
    }

    @Override
    public List<CtpProduct> reqProducts(String productId) {
        List<CtpProduct> list = new ArrayList<>();
        if (productId != null && productId.length() > 0) {
            CtpProduct ctpProduct = qryProductMap.get(productId);
            if (ctpProduct != null) {
                list.add(ctpProduct);
            }
        } else {
            list.addAll(qryProductMap.values());
        }
        return list;
    }

    public void close() {
        this.traderApi.Close();
        clearMaps();
    }
}
