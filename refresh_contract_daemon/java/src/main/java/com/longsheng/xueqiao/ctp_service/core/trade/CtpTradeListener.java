package com.longsheng.xueqiao.ctp_service.core.trade;

import com.longsheng.xueqiao.ctp_service.CtpAccount;
import net.jctp.*;
import net.jtrader.JTraderException;
import org.soldier.base.logger.AppLog;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class CtpTradeListener extends CtpTradeListenerAdaptor {

    private CtpAccount ctpAccount;

    protected static AtomicInteger atomicInteger = new AtomicInteger(0);

    private CtpTradeApi api;

    private volatile boolean connected = false;

    private volatile boolean isInstrumentLast;

    private volatile boolean isProductLast;

    private interface ITask {
        void run() throws JTraderException;
    }

    private Queue<ITask> taskQueue;

    public CtpTradeListener(CtpTradeApi api) {
        this.api = api;
        this.ctpAccount = api.getCtpAccount();
    }

    private ConcurrentLinkedQueue<ITask> newTaskQueue() {
        return new ConcurrentLinkedQueue<ITask>() {{
            add(new ITask() {//查询商品信息
                @Override
                public void run() throws JTraderException {
                    AppLog.i("Query Products");
                    CThostFtdcQryProductField cThostFtdcQryProductField = new CThostFtdcQryProductField();
                    api.traderApi.ReqQryProduct(cThostFtdcQryProductField);
                }
            });
            add(new ITask() {//查询合约列表
                @Override
                public void run() throws JTraderException {
                    AppLog.i("Query Instruments");
                    CThostFtdcQryInstrumentField qryInstrumentField = new CThostFtdcQryInstrumentField();
                    api.traderApi.ReqQryInstrument(qryInstrumentField);
                }
            });
        }};
    }

    private void runTask() {
        ITask task = taskQueue.poll();
        while (task != null) {
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (this) {
                    if (!connected) {
                        taskQueue.clear();
                        AppLog.d("run task synchronized done 1");
                        return;
                    }
                    AppLog.d("run task synchronized done 2");
                }

                task.run();
                return;
            } catch (JTraderException e) {
                e.printStackTrace();
                AppLog.e(e);
                task = taskQueue.poll();
            }
        }
    }

    //先认证，再登录
    //认证
    private void auth() {
        CThostFtdcReqAuthenticateField f = new CThostFtdcReqAuthenticateField();
        f.AuthCode = this.ctpAccount.getAuthCode();
        f.AppID = this.ctpAccount.getAppId();;
        f.BrokerID = this.ctpAccount.getBrokerId();;
        f.UserID = this.ctpAccount.getUserId();
        AppLog.d("start auth");
        try {
            api.traderApi.ReqAuthenticate(f);
        } catch (JTraderException e) {
            AppLog.e(e);
        } catch (Exception e) {
            AppLog.e(e);
        }
    }
    //登录
    private void login() {
        CThostFtdcReqUserLoginField f = new CThostFtdcReqUserLoginField();
        f.BrokerID = this.ctpAccount.getBrokerId();
        f.UserID = this.ctpAccount.getUserId();
        f.Password = this.ctpAccount.getPassword();
        AppLog.d("start login");
        try {
            api.traderApi.ReqUserLogin(f);
        } catch (JTraderException e) {
            AppLog.e(e);
        } catch (Exception e) {
            AppLog.e(e);
        }
    }

    @Override
    public void OnFrontConnected() {
        super.OnFrontConnected();
        synchronized (this) {
            if (connected) {
                return;
            }

            connected = true;
        }
        //发送认证
        auth();
        AppLog.d("OnFrontConnected Done");
    }

    @Override
    public void OnFrontDisconnected(int nReason) {
        super.OnFrontDisconnected(nReason);

        synchronized (this) {
            connected = false;
        }

        // 修改外面的service为不提供服务的
        AppLog.d("OnFrontDisconnected Done");
    }

    @Override
    public void OnRspAuthenticate(
            CThostFtdcRspAuthenticateField pRspAuthenticateField,
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
        super.OnRspAuthenticate(pRspAuthenticateField, pRspInfo, nRequestID, bIsLast);

        AppLog.i("TraderListener.OnRspAuthenticate enter: "
                + pRspAuthenticateField + "," + pRspInfo + "," + nRequestID
                + "," + bIsLast);
        //发送登录
        if(pRspInfo.ErrorID == 0)
            login();
        else
            AppLog.e("授权认证错误:" + pRspAuthenticateField + "," + pRspInfo);
    }

    @Override
    public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin,
                               CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        super.OnRspUserLogin(pRspUserLogin, pRspInfo, nRequestID, bIsLast);

        int errorID = pRspInfo.ErrorID;
        if (pRspInfo != null && errorID != 0) {
            if (errorID != 3) {
                AppLog.d("Retry login in 5 seconds");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                login();
            } else {     //密码错误
                AppLog.e("password error");
            }
            return;
        }

        atomicInteger.set(Integer.valueOf(pRspUserLogin.MaxOrderRef));
        taskQueue = newTaskQueue();

        if (bIsLast) {
            runTask();
        }
    }

    @Override
    public void OnRspQryProduct(CThostFtdcProductField pProduct, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
        super.OnRspQryProduct(pProduct, pRspInfo, nRequestID, bIsLast);

        if (pProduct != null) {
            api.onRspQryProduct(pProduct);
        }
        isProductLast = bIsLast;

        api.isRefresh = isProductLast && isInstrumentLast;

        if (bIsLast) {
            runTask();
        }
    }

    @Override
    public void OnRspQryInstrument(CThostFtdcInstrumentField pInstrument,
                                   CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {

        super.OnRspQryInstrument(pInstrument, pRspInfo, nRequestID, bIsLast);
        api.onRspQryInstrument(pInstrument);
        isInstrumentLast = bIsLast;
        api.isRefresh = isProductLast && isInstrumentLast;
        if (bIsLast) {
            runTask();
        }
    }
}
