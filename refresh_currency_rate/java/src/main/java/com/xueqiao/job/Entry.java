package com.xueqiao.job;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.Gson;
import com.longsheng.xueqiao.currency.dao.thriftapi.client.CurrencyDaoStub;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRate;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRatePage;
import com.longsheng.xueqiao.currency.thriftapi.ReqExchangeRateOption;
import com.longsheng.xueqiao.goose.thriftapi.client.GooseAoStub;
import com.xueqiao.job.bean.CMCRRecord;
import com.xueqiao.job.bean.ChinaMoneyCurrencyRate;
import net.qihoo.qconf.Qconf;
import net.qihoo.qconf.QconfException;
import org.apache.commons.io.IOUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Entry {

    public static void main(String[] args) {
        AppLog.init("refresh_currency_rate");
        boolean done = false;
        int retryCount = 0;
        do {
            Date date = new Date();
            String log = "time now: " + DateFormat.getInstance().format(date);
            AppLog.d(log);
            AppLog.e("DAEMON working");

            try {
                long now = System.currentTimeMillis();
                String content = doPost(now);
                ChinaMoneyCurrencyRate currencyRate = new Gson().fromJson(content, ChinaMoneyCurrencyRate.class);
                AppLog.d(currencyRate);
                boolean success = updateCurrencyRate(currencyRate);
                if (!success) {
                    throw new ErrorInfo(1, "update fail");
                }
                AppLog.e("sync done");
                done = true;
            } catch (Exception e) {
                AppLog.e(e.getMessage(), e);
                AppLog.e("DAEMON Stop at exception");
                retryCount++;
                if (retryCount == 5) {
                    sendSms("refresh currency rate fail.");
                    done = true;
                }
            }
        } while (!done);
    }

    private static boolean updateCurrencyRate(ChinaMoneyCurrencyRate currencyRate) throws TException {
        if (currencyRate.getRecords() == null || currencyRate.getRecords().size() == 0) {
            return false;
        }
        Map<String, CMCRRecord> records = new HashMap<>();
        for (CMCRRecord record : currencyRate.getRecords()) {
            records.put(record.getForeignCName(), record);
        }

        String baseCurrency = "CNY";
        CurrencyDaoStub stub = new CurrencyDaoStub();
        ReqExchangeRateOption option = new ReqExchangeRateOption();
        option.setBaseCurrency(baseCurrency);
        ExchangeRatePage page = stub.reqExchangeRate(option, new IndexedPageOption().setNeedTotalCount(true));
        if (page.getPageSize() > 0) {
            for (ExchangeRate exchangeRate : page.getPage()) {
                String currency = exchangeRate.getTargetCurrency();

                ExchangeRate newRate = new ExchangeRate();
                newRate.setBaseCurrency(baseCurrency);
                newRate.setTargetCurrency(currency);

                CMCRRecord record = records.get(currency);
                double price;
                if (record != null) {
                    String positive = currency + "/" + baseCurrency;
                    String negative = baseCurrency + "/" + currency;
                    BigDecimal recordPrice = new BigDecimal(record.getPrice());
                    if (positive.equals(record.getVrtEName())) {
                        price = recordPrice.doubleValue();

                    } else if (negative.equals(record.getVrtEName())) {
                        if (BigDecimal.ZERO.equals(recordPrice)) {
                            price = recordPrice.doubleValue();
                        } else {
                            price = BigDecimal.ONE.divide(recordPrice, 6, RoundingMode.CEILING).doubleValue();
                        }
                    } else if (positive.equals(record.getVrtEName().replace("100", ""))) { // 简单处理 100倍数汇率
                        int times = 100;
                        price = recordPrice.divide(BigDecimal.valueOf(times), 6, RoundingMode.CEILING).doubleValue();
                    } else {
                        continue;
                    }
                    newRate.setExchangeRate(price);
                    stub.updateExchangeRateValue(newRate);
                }
            }
            stub.syncExchangeRateToOnline();
            return true;
        }
        return false;
    }

    private static void sendSms(String msg) {
        try {
            String env = "";
            try {
                env = Qconf.getConf("platform/environment");
            } catch (QconfException e) {
                e.printStackTrace();
            }
            new GooseAoStub().sendUserNotificationSms("18576421291", env + ": " + msg);
        } catch (TException e1) {
            AppLog.e(e1.getMessage(), e1);
        }
    }

    private static String doPost(long millis) throws Exception {
        String urlStr = "http://www.chinamoney.com.cn/r/cms/www/chinamoney/data/fx/ccpr.json?t=" + millis;
        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        GenericUrl url = new GenericUrl(urlStr);
        HttpRequest request = requestFactory.buildGetRequest(url);
        HttpResponse resp = request.execute();
        InputStream is = resp.getContent();
        String content = IOUtils.toString(is, "utf-8");
        resp.disconnect();
//        System.out.println(content);
        return content;
    }
}
