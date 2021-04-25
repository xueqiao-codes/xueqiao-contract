package com.xueqiao.ctp_service.core.trade;

import org.soldier.base.logger.AppLog;

public class CtpTradeListener extends CtpTradeListenerAdaptor {

    private volatile boolean connected = false;
    private CtpTradeApi ctpTradeApi;

    public boolean isConnected() {
        return connected;
    }

    public CtpTradeListener(CtpTradeApi tradeApi) {
        this.ctpTradeApi = tradeApi;
    }

    @Override
    public void OnFrontConnected() {
        super.OnFrontConnected();
        AppLog.d("OnFrontConnected Done");
        AppLog.d("connected host: "+ this.ctpTradeApi.getCtpAccount().toString());
        this.ctpTradeApi.close();
    }

    @Override
    public void OnFrontDisconnected(int nReason) {
        super.OnFrontDisconnected(nReason);
        AppLog.d("connect host error: "+ this.ctpTradeApi.getCtpAccount().toString());

        synchronized (this) {
            connected = false;
        }
        AppLog.d("OnFrontDisconnected Done");
        this.ctpTradeApi.close();
    }
}
