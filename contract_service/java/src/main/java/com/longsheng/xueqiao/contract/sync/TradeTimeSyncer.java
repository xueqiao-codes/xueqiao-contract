package com.longsheng.xueqiao.contract.sync;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledCommodityOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.data.SledCommodityAccess;
import com.longsheng.xueqiao.contract.data.TradeTimeAccess;
import com.longsheng.xueqiao.contract.thriftapi.*;
import com.longsheng.xueqiao.contract.utils.DateTimeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.util.*;

public class TradeTimeSyncer {

    private static final int SYNC_DAYS = 25;

    public void runOnce() throws TException {
        sync(SYNC_DAYS, new Date());
    }

    public void sync(int days, Date referenceDate) throws TException {
        SledCommodityAccess sledCommodityAccess = new SledCommodityAccess();
        ReqTSledCommodityOption tOption = new ReqTSledCommodityOption();
        tOption.setWorkingStatus(WorkingStatus.WORKING.getValue());
        SledCommodityEditPage page = sledCommodityAccess.getSledCommodityEditPage(0, Integer.MAX_VALUE, tOption);

        List<SledTradeTime> sledTradeTimes = getSledTradeTimes(days, referenceDate, page, true);
        new ContractDaoServiceStub().batAddSledTradeTime(sledTradeTimes);
    }

    private List<SledTradeTime> getSledTradeTimes(int days, Date referenceDate, SledCommodityEditPage page, boolean isOnlyTimeSpan) throws TException {
        List<SledTradeTime> sledTradeTimes = new ArrayList<>();
        for (SledCommodityEdit sledCommodityEdit : page.getPage()) {
            ReqSledTradingSessionOption option = new ReqSledTradingSessionOption();
            int sledCommodityId = sledCommodityEdit.getSledCommodity().getSledCommodityId();
            String zoneId = sledCommodityEdit.getSledCommodity().getZoneId();
            if (StringUtils.isEmpty(zoneId)) {
                AppLog.d("zone id empty, sledCommodityId: " + sledCommodityId);
                sledTradeTimes.add(new SledTradeTime().setSledCommodityId(sledCommodityId).setDateTimeSpans(new ArrayList<>()));
                continue;
            }
            option.setSledCommodityId(sledCommodityId);
            SledTradingSessionPage tradingSessionPage = new ContractDaoServiceStub().reqSledTradingSession(option, null);
            List<SledCommoditySpecTradeTime> specTradeTimes = getSledCommoditySpecTradeTimes(sledCommodityId);
            SledTradeTime sledTradeTime = new TradeSession2TradeTime().getSledTradeTimes(sledCommodityId, zoneId, tradingSessionPage, specTradeTimes, days, referenceDate);
            if (isOnlyTimeSpan) {
                unsetNotNecessary(sledTradeTime);
            }
            sledTradeTimes.add(sledTradeTime);
        }
        return sledTradeTimes;
    }

    private void unsetNotNecessary(SledTradeTime sledTradeTime) {
        for (DateTimeSpan dateTimeSpan : sledTradeTime.getDateTimeSpans()) {
            for (TTimeSpan tTimeSpan : dateTimeSpan.getTTimeSpan()) {
                tTimeSpan.unsetEndTimestamp();
                tTimeSpan.unsetEndTimeString();
                tTimeSpan.unsetStartTimestamp();
                tTimeSpan.unsetStartTimeString();
            }
        }
    }


    public SledTradeTimePage reqSledTradingSessionTime(ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws TException {

        SledCommodityAccess sledCommodityAccess = new SledCommodityAccess();
        ReqTSledCommodityOption tOption = new ReqTSledCommodityOption();
        if (option.isSetSledCommodityIds() && option.getSledCommodityIdsSize() > 0) {
            tOption.setSledCommodityIds(option.getSledCommodityIds());
        }
        SledCommodityEditPage sledCommodityEditPage = sledCommodityAccess.getSledCommodityEditPage(pageIndex, pageSize, tOption);

        Date referenceDate = null;
        if (option.isSetDate()) {
            String dateStr = option.getDate();
            Calendar calendar = DateTimeUtils.getDateTimeDatePartDate(dateStr);
            if (calendar == null) {
                throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "Date string pattern error ");
            }
            referenceDate = calendar.getTime();
        }
        if (option.isSetDateTimestamp()) {
            referenceDate = new Date(option.getDateTimestamp() * 1000L);
        }
        int days = 1;
        if (option.isSetDays()) {
            days = option.getDays() * 2 + 1;
        }

        if (referenceDate == null) {
            referenceDate = new Date();
        }

        List<SledTradeTime> sledTradeTimes = getSledTradeTimes(days, referenceDate, sledCommodityEditPage, false);
        SledTradeTimePage page = new SledTradeTimePage();
        page.setTotal(sledCommodityEditPage.getTotal());
        page.setPage(sledTradeTimes);
        return page;
    }

    private List<SledCommoditySpecTradeTime> getSledCommoditySpecTradeTimes(int sledCommodityId) throws TException {
        TradeTimeAccess tradeTimeAccess = new TradeTimeAccess();
        ReqCommoditySpecTradeTimeOption reqSpecOption = new ReqCommoditySpecTradeTimeOption();
        reqSpecOption.addToSledCommodityIds(sledCommodityId);
        SledCommoditySpecTradeTimePage specPage = tradeTimeAccess.getSpecTradeTime(reqSpecOption, 0, Integer.MAX_VALUE);
        return specPage.getPage();
    }
}
