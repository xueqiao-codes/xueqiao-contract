package com.xueqiao.ctp_service.core.trade;

import net.jctp.TraderApi;
import net.jtrader.JTraderException;
import org.soldier.base.logger.AppLog;

public class CtpTradeApi {

    protected TraderApi traderApi;

    protected CtpTradeListener ctpTradeListener;
    private CtpAccount ctpAccount;

    public CtpTradeApi(CtpAccount ctpAccount) {
        this.ctpAccount = ctpAccount;
    }

    public CtpAccount getCtpAccount() {
        return this.ctpAccount;
    }

    public void start() {
        ctpTradeListener = new CtpTradeListener(this);
        try {
            traderApi = new TraderApi();
            traderApi.setListener(ctpTradeListener);
            try {
                String host = ctpAccount.getHost();
                AppLog.d("Connecting " + host + " ...");
                traderApi.SyncConnect(host);
            } catch (JTraderException e) {
                AppLog.e("sync connect fail: " + e.getMessage(), e);
                AppLog.e("sync connect fail: " + this.ctpAccount.toString());
                traderApi.Close();
            }
        } catch (Exception e) {
            AppLog.e("trade api init fail: " + e.getMessage(), e);
            AppLog.e("trade api init fail: " + this.ctpAccount.toString());
        }
    }

    public void close() {
        this.traderApi.Close();
    }

}
