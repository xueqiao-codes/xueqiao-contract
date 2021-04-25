package com.longsheng.xueqiao.contract.sync;

import com.antiy.error_code.ErrorCodeOuter;
import com.google.common.base.Preconditions;
import com.longsheng.xueqiao.contract.dao.thriftapi.ReqTSledCommodityOption;
import com.longsheng.xueqiao.contract.dao.thriftapi.client.ContractDaoServiceStub;
import com.longsheng.xueqiao.contract.data.SledCommodityAccess;
import com.longsheng.xueqiao.contract.standard.thriftapi.SledContractErrorCode;
import com.longsheng.xueqiao.contract.thriftapi.*;
import com.longsheng.xueqiao.contract.utils.DateTimeUtils;
import org.apache.thrift.TException;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.text.ParseException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TradeSession2TradeTime {

    public SledTradeTime getSledTradeTimes(int sledCommodityId, String zoneId, SledTradingSessionPage page, List<SledCommoditySpecTradeTime> specTradeTimes, int totalDays, Date referenceDate) throws ErrorInfo {

        Map<Days, List<DaySessionTimeSpan>> standardDayTimeSpanMap = getDayTimeSpanMap(TimeSystem.STANDARD, page, DateTimeUtils.WEEK);
        Map<Days, List<DaySessionTimeSpan>> dstDayTimeSpanMap = getDayTimeSpanMap(TimeSystem.DST, page, DateTimeUtils.WEEK);

        List<DaySessionTimeSpan> allSpans = getAllDateTimeSpans(standardDayTimeSpanMap, dstDayTimeSpanMap, zoneId, totalDays, referenceDate);
        List<DaySessionTimeSpan> specSpans = getSpecTimeSpans(specTradeTimes);
        handleTradeTimeBySpecTradeTime(allSpans, specSpans);

        List<DaySessionTimeSpan> fillSpan = fillTimeSpans(allSpans);
        allSpans.addAll(fillSpan);

        handleLastSecondInSpan(allSpans);
        splitTimeSpans(allSpans);
        allSpans.sort(TradeSession2TradeTime::compareDaySessionTimeSpan);

        List<DateTimeSpan> dateTimeSpans = getDateTimeSpans(allSpans);
        List<DateTimeSpan> referenceSpans = getReferenceDateTimeSpans(totalDays, referenceDate, dateTimeSpans);

        SledTradeTime sledTradeTime = new SledTradeTime();
        sledTradeTime.setSledCommodityId(sledCommodityId);
        sledTradeTime.setZoneId(zoneId);
        sledTradeTime.setDateTimeSpans(referenceSpans);
        return sledTradeTime;
    }

    public boolean checkNewTradingSession(SledTradingSession tradingSession) throws TException {
        Preconditions.checkNotNull(tradingSession);
        Preconditions.checkArgument(tradingSession.isSetSledCommodityId());
        Preconditions.checkArgument(tradingSession.getSledCommodityId() > 0);
        Preconditions.checkArgument(tradingSession.isSetTimeSystem());
        Preconditions.checkArgument(tradingSession.isSetTimeSpans());
        Preconditions.checkArgument(tradingSession.getTimeSpansSize() > 0);

        return checkData(tradingSession);
    }

    public void checkUpdateTradingSession(SledTradingSession tradingSession) throws TException {
        Preconditions.checkNotNull(tradingSession);
        Preconditions.checkArgument(tradingSession.getTradeSessionId() > 0);
        ContractDaoServiceStub stub = new ContractDaoServiceStub();
        ReqSledTradingSessionOption option = new ReqSledTradingSessionOption();
        option.addToTradeSessionIds(tradingSession.getTradeSessionId());
        SledTradingSessionPage tradingSessionPage = stub.reqSledTradingSession(option, null);
        if (tradingSessionPage.getPageSize() == 0) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SledTradingSession not found.");
        }

        int sledCommodityId = tradingSessionPage.getPage().get(0).getSledCommodityId();
        SledCommodityAccess commodityAccess = new SledCommodityAccess();
        ReqTSledCommodityOption reqTSledCommodityOption = new ReqTSledCommodityOption();
        reqTSledCommodityOption.addToSledCommodityIds(tradingSession.getSledCommodityId());
        SledCommodityEditPage editPage = commodityAccess.getSledCommodityEditPage(0, 1, reqTSledCommodityOption);
        String zoneId = editPage.getPage().get(0).getSledCommodity().getZoneId();
        tradingSession.setZoneId(zoneId);
        long tradingSessionId = tradingSession.getTradeSessionId();

        if (tradingSession.isSetSledCommodityId() && sledCommodityId != tradingSession.getSledCommodityId()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "sledCommodityId must not change.");
        }

        if (tradingSession.isSetZoneId() && !zoneId.equals(tradingSession.getZoneId())) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "zone id is not the same as commodity setting.");
        }

        option.clear();
        option.setSledCommodityId(sledCommodityId);
        option.setTimeSystem(tradingSessionPage.getPage().get(0).getTimeSystem());
        tradingSession.setTimeSystem(tradingSessionPage.getPage().get(0).getTimeSystem());
        SledTradingSessionPage page = stub.reqSledTradingSession(option, null);
        SledTradingSessionPage newPage = new SledTradingSessionPage();
        newPage.addToPage(tradingSession);

        for (SledTradingSession session : page.getPage()) {
            if (session.getTradeSessionId() != tradingSessionId)
                newPage.addToPage(session);
        }

        checkTimeSpan(newPage);
    }

    private List<DateTimeSpan> getReferenceDateTimeSpans(int totalDays, Date referenceDate, List<DateTimeSpan> dateTimeSpans) {
        List<String> dates = new ArrayList<>();
        int startDateIndex = 0 - (totalDays / 2);
        for (; startDateIndex < totalDays / 2 + 1; startDateIndex++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(referenceDate);
            calendar.add(Calendar.DATE, startDateIndex);
            dates.add(DateTimeUtils.getDateStringDatePart(calendar.getTimeInMillis()));
        }

        List<DateTimeSpan> referenceSpans = new ArrayList<>();
        for (DateTimeSpan dateTimeSpan : dateTimeSpans) {
            if (dates.contains(dateTimeSpan.getDate())) {
                referenceSpans.add(dateTimeSpan);
            }
        }
        referenceSpans.sort(TradeSession2TradeTime::compareDateTimeSpan);
        return referenceSpans;
    }

    private void checkTimeSpan(SledTradingSessionPage newPage) throws ErrorInfo {
        getDayTimeSpanMap(TimeSystem.STANDARD, newPage, DateTimeUtils.WEEK);
        getDayTimeSpanMap(TimeSystem.DST, newPage, DateTimeUtils.WEEK);
    }

    private boolean checkData(SledTradingSession tradingSession) throws TException {
        String zoneId = getZoneId(tradingSession.getSledCommodityId());
        tradingSession.setZoneId(zoneId);
        SledTradingSessionPage page = getSledTradingSessionPage(tradingSession.getSledCommodityId(), tradingSession.getTimeSystem());
        if (page.getPageSize() == 0) {
            return true;
        }
        page.addToPage(tradingSession);
        page.setTotal(page.getTotal() + 1);

        checkTimeSpan(page);
        return true;
    }

    private SledTradingSessionPage getSledTradingSessionPage(int sledCommodityId, TimeSystem timeSystem) throws TException {
        ContractDaoServiceStub stub = new ContractDaoServiceStub();
        ReqSledTradingSessionOption option = new ReqSledTradingSessionOption();
        option.setSledCommodityId(sledCommodityId);
        option.setTimeSystem(timeSystem);
        return stub.reqSledTradingSession(option, null);
    }

    private String getZoneId(int sledCommodityId) throws TException {
        SledCommodityAccess commodityAccess = new SledCommodityAccess();
        ReqTSledCommodityOption reqTSledCommodityOption = new ReqTSledCommodityOption();
        reqTSledCommodityOption.addToSledCommodityIds(sledCommodityId);
        SledCommodityEditPage editPage = commodityAccess.getSledCommodityEditPage(0, 1, reqTSledCommodityOption);
        if (editPage.getPageSize() == 0) {
            throw new ErrorInfo(SledContractErrorCode.SLED_COMMODITY_NOT_FOUND.getValue(), "sled commodity not found.");
        }

        return editPage.getPage().get(0).getSledCommodity().getZoneId();
    }

    private static int compareDateTimeSpan(DateTimeSpan o1, DateTimeSpan o2) {
        long date1 = 0;
        long date2 = 0;
        try {
            date1 = DateTimeUtils.DATA_SIMPLE_DATE_FORMAT.parse(o1.getDate()).getTime();
            date2 = DateTimeUtils.DATA_SIMPLE_DATE_FORMAT.parse(o2.getDate()).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date1 < date2) {
            return -1;
        } else if (date1 > date2) {
            return 1;
        } else {
            return 0;
        }
    }

    private List<DateTimeSpan> getDateTimeSpans(List<DaySessionTimeSpan> allSpans) {
//        print(allSpans, "DaySessionTimeSpan span");
        Map<String, List<DaySessionTimeSpan>> dateSessionTimeSpanMap = new HashMap<>();
        for (DaySessionTimeSpan daySessionTimeSpan : allSpans) {
            String dateStr = daySessionTimeSpan.startDateStr;
            List<DaySessionTimeSpan> list = dateSessionTimeSpanMap.get(dateStr);
            if (list == null) {
                list = new ArrayList<>();
                dateSessionTimeSpanMap.put(dateStr, list);
            }
            list.add(daySessionTimeSpan);
        }

        List<DateTimeSpan> dateTimeSpans = new ArrayList<>();
        for (String dateStr : dateSessionTimeSpanMap.keySet()) {
            List<DaySessionTimeSpan> spans = dateSessionTimeSpanMap.get(dateStr);
            DateTimeSpan dateTimeSpan = new DateTimeSpan();
            dateTimeSpan.setDate(dateStr);
            List<TTimeSpan> list = new ArrayList<>();

            for (DaySessionTimeSpan daySessionTimeSpan : spans) {

                TTimeSpan tTimeSpan = new TTimeSpan();
                tTimeSpan.setTimespan(daySessionTimeSpan.startTime + "-" + daySessionTimeSpan.endTime);
                tTimeSpan.setTimeSpanState(daySessionTimeSpan.timeSpanState);
                tTimeSpan.setStartTimestamp(daySessionTimeSpan.startTimestamp);
                tTimeSpan.setStartTimeString(dateStr + " " + daySessionTimeSpan.startTime);
                tTimeSpan.setEndTimestamp(daySessionTimeSpan.endTimestamp);
                tTimeSpan.setEndTimeString(dateStr + " " + daySessionTimeSpan.endTime);

                list.add(tTimeSpan);
            }
            list.sort(TradeSession2TradeTime::compareTTimeSpan);
            dateTimeSpan.setTTimeSpan(list);
            dateTimeSpans.add(dateTimeSpan);
        }

        /*
         * sort dateTimeSpans
         * time : 20180928
         * */
        dateTimeSpans.sort(TradeSession2TradeTime::compareDateTimeSpan);
        return dateTimeSpans;
    }

    private void splitTimeSpans(List<DaySessionTimeSpan> allSpans) {
        do {
            List<DaySessionTimeSpan> splitSpans = splitDaySessionTimeSpans(allSpans);
            if (splitSpans.size() == 0) {
                break;
            }
            allSpans.addAll(splitSpans);
            allSpans.sort(TradeSession2TradeTime::compareDaySessionTimeSpan);
        } while (true);
    }

    private void handleLastSecondInSpan(List<DaySessionTimeSpan> allSpans) {
        allSpans.sort(TradeSession2TradeTime::compareDaySessionTimeSpan);
        for (DaySessionTimeSpan span : allSpans) {
            if (!TimeSpanState.T_OPEN.equals(span.timeSpanState)) {
                span.endTimestamp = Math.subtractExact(span.endTimestamp, DateTimeUtils.ONE_SEC);
                span.endTime = DateTimeUtils.getTimeHourStringPart(span.endTimestamp);
                span.startTimestamp = Math.addExact(span.startTimestamp, DateTimeUtils.ONE_SEC);
                span.startTime = DateTimeUtils.getTimeHourStringPart(span.startTimestamp);
            }
        }
    }

    public Map<Days, List<DaySessionTimeSpan>> getDayTimeSpanMap(TimeSystem timeSystem, SledTradingSessionPage page, Days[] week) throws ErrorInfo {
        List<DaySessionTimeSpan> daySessionTimeSpans = new ArrayList<>();
        for (SledTradingSession session : page.getPage()) {
            if (timeSystem.equals(session.getTimeSystem())) {
                for (SledTradingSessionTimeSpan timeSpan : session.getTimeSpans()) {
                    DaySessionTimeSpan daySessionTimeSpan = new DaySessionTimeSpan();
                    daySessionTimeSpan.startDay = timeSpan.getStartDay();
                    daySessionTimeSpan.startTime = timeSpan.getStartTime();
                    daySessionTimeSpan.endDay = timeSpan.getEndDay();
                    daySessionTimeSpan.endTime = timeSpan.getEndTime();
                    daySessionTimeSpan.timeSpanState = TimeSpanState.T_OPEN;
                    daySessionTimeSpan.tradingSessionId = timeSpan.getTradeSessionId();
                    daySessionTimeSpan.timeSpanId = timeSpan.getTimeSpanId();
                    daySessionTimeSpan.startTimestamp = daySessionTimeSpan.startDay.getValue() * DateTimeUtils.DATE_LONG + DateTimeUtils.getHourStringDateTime(timeSpan.getStartTime());
                    daySessionTimeSpan.endTimestamp = daySessionTimeSpan.endDay.getValue() * DateTimeUtils.DATE_LONG + DateTimeUtils.getHourStringDateTime(timeSpan.getEndTime());

                    daySessionTimeSpans.add(daySessionTimeSpan);
                }
            }
        }

        daySessionTimeSpans.sort(TradeSession2TradeTime::compareDaySessionTimeSpan);

//        print(daySessionTimeSpans, "daySessionTimeSpans");
        for (int i = 0; i < daySessionTimeSpans.size() - 1; i++) {
            DaySessionTimeSpan first = daySessionTimeSpans.get(i);
            DaySessionTimeSpan second = daySessionTimeSpans.get(i + 1);
            if (first.endTimestamp > second.startTimestamp) {
                throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "time span error");
            }
        }

        Map<Days, List<DaySessionTimeSpan>> dayTimeSpanMap = new HashMap<>();
        for (DaySessionTimeSpan daySessionTimeSpan : daySessionTimeSpans) {

            for (Days day : week) {
                List<DaySessionTimeSpan> spans = dayTimeSpanMap.get(day);
                if (spans == null) {
                    spans = new ArrayList<>();
                    dayTimeSpanMap.put(day, spans);
                }
                if (daySessionTimeSpan.startDay.equals(day)) {
                    spans.add(daySessionTimeSpan);
                }
            }
        }

        return dayTimeSpanMap;
    }

    private static boolean isDaylightTime(Calendar calendar, String zoneIdStr) {
        AppLog.d("zone id: " + zoneIdStr);

        ZoneId zoneId = ZoneId.of(zoneIdStr);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND), calendar.get(Calendar.MILLISECOND),
                zoneId);

        return zonedDateTime.getZone().getRules().isDaylightSavings(zonedDateTime.toInstant());
    }

    private List<DaySessionTimeSpan> getAllDateTimeSpans(Map<Days, List<DaySessionTimeSpan>> standardDayTimeSpanMap,
                                                         Map<Days, List<DaySessionTimeSpan>> dstDayTimeSpanMap, String zoneIdStr, int totalDays, Date referenceDate) {
        if (totalDays < 25) {
            totalDays = 25;
        }
        int end = Math.floorDiv(totalDays, 2) + 1;
        // 计算时需要从未来至少两天倒算（因为需要至少有一个工作日的交易时间记录来计算）
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(referenceDate);
        calendar.add(Calendar.DATE, end);
        List<DaySessionTimeSpan> allSpans = new CopyOnWriteArrayList<>();

        for (int count = 0; count < totalDays; count++) {
            calendar.add(Calendar.DATE, -1);
            Date date = calendar.getTime();
            int index = calendar.get(Calendar.DAY_OF_WEEK);
            Days days = Days.findByValue(index - 1);

            if (standardDayTimeSpanMap == null || standardDayTimeSpanMap.size() == 0) {
                continue;
            }
            Map<Days, List<DaySessionTimeSpan>> currentMap = standardDayTimeSpanMap;
            if (dstDayTimeSpanMap != null && dstDayTimeSpanMap.size() > 0) {
                boolean isDst = isDaylightTime(calendar, zoneIdStr);
                if (isDst) {
                    currentMap = dstDayTimeSpanMap;
                }
            }

            List<DaySessionTimeSpan> dayTradeTime = currentMap.get(days);
            if (dayTradeTime == null) {
                continue;
            }

            // 只需计算开始是今天的
            for (DaySessionTimeSpan daySessionTimeSpan : dayTradeTime) {
                DaySessionTimeSpan span = new DaySessionTimeSpan();
                span.tradingSessionId = daySessionTimeSpan.tradingSessionId;
                span.startDay = days;
                span.startTime = daySessionTimeSpan.startTime;

                span.endDay = daySessionTimeSpan.endDay;
                span.endTime = daySessionTimeSpan.endTime;
                span.timeSpanState = daySessionTimeSpan.timeSpanState;

                String dateStr = DateTimeUtils.getDateStringDatePart(date.getTime());
                String startStr = dateStr + " " + daySessionTimeSpan.startTime;
                String endStr = dateStr + " " + daySessionTimeSpan.endTime;

                long startTimestamp = DateTimeUtils.getDateTimeFull(startStr);
                long endTimestamp = DateTimeUtils.getDateTimeFull(endStr);

                if (startTimestamp > endTimestamp) {
                    // 跨日
                    endTimestamp = endTimestamp + DateTimeUtils.DATE_LONG;
                }
                endStr = DateTimeUtils.getDateStringDatePart(endTimestamp);
                span.startTimestamp = startTimestamp;
                span.endTimestamp = endTimestamp;
                span.startDateStr = dateStr;
                span.endDateStr = endStr;
                allSpans.add(span);
            }
        }
        return allSpans;
    }

    private static List<DaySessionTimeSpan> getSpecTimeSpans(List<SledCommoditySpecTradeTime> specs) {
        if (specs == null) {
            return new ArrayList<>();
        }
        List<DaySessionTimeSpan> tSpecTradeTime = new CopyOnWriteArrayList<>();
        for (SledCommoditySpecTradeTime specTradeTime : specs) {
            DaySessionTimeSpan span = new DaySessionTimeSpan();
            long startTime = specTradeTime.getNonTradeStartTimestamp() * DateTimeUtils.ONE_SEC;
            long endTime = specTradeTime.getNonTradeEndTimestamp() * DateTimeUtils.ONE_SEC;

            span.startTime = DateTimeUtils.getTimeHourStringPart(startTime);
            span.startTimestamp = startTime;
            span.startDateStr = DateTimeUtils.getDateStringDatePart(startTime);
            span.startDay = DateTimeUtils.getDays(startTime);

            span.endTime = DateTimeUtils.getTimeHourStringPart(endTime);
            span.endTimestamp = endTime;
            span.endDateStr = DateTimeUtils.getDateStringDatePart(endTime);
            span.endDay = DateTimeUtils.getDays(endTime);
            span.timeSpanState = TimeSpanState.CLOSED;
            span.nextTradeOpenType = specTradeTime.getNextTradeOpenType();

            tSpecTradeTime.add(span);
        }
        return tSpecTradeTime;
    }

    private static void handleTradeTimeBySpecTradeTime(List<DaySessionTimeSpan> tTradeTimeSpans, List<DaySessionTimeSpan> tSpecTradeTimes) {
        if (tSpecTradeTimes.isEmpty()) {
            return;
        }
        if (tTradeTimeSpans.isEmpty()) {
            return;
        }
        tTradeTimeSpans.sort(TradeSession2TradeTime::compareDaySessionTimeSpan);
        tSpecTradeTimes.sort(TradeSession2TradeTime::compareDaySessionTimeSpan);
        Iterator<DaySessionTimeSpan> iterator = tTradeTimeSpans.iterator();
        while (iterator.hasNext()) {
            DaySessionTimeSpan t = iterator.next();
            for (DaySessionTimeSpan spec : tSpecTradeTimes) {

                if (spec.startTimestamp > t.endTimestamp || spec.endTimestamp < t.startTimestamp) {
                    continue;
                }
                if (spec.startTimestamp <= t.startTimestamp && spec.endTimestamp >= t.endTimestamp) {

                    // REMOVE
                    System.out.println("remove : " + t);
                    tTradeTimeSpans.remove(t);
                    continue;
                }
                if (spec.startTimestamp > t.startTimestamp && spec.endTimestamp > t.endTimestamp) {
                    t.endTimestamp = spec.startTimestamp;
                    t.endTime = spec.startTime;
                    t.endDateStr = spec.startDateStr;
                    t.endDay = spec.startDay;
                    continue;
                }
                if (spec.startTimestamp < t.startTimestamp) {
                    // 1
                    NextTradeOpenType type = spec.nextTradeOpenType;
                    if (NextTradeOpenType.IMMEDIATELY.equals(type)) {
                        t.startTimestamp = spec.endTimestamp;
                        t.startTime = spec.endTime;
                        t.endDateStr = spec.endDateStr;
                        t.endDay = spec.endDay;
                    }
                    if (NextTradeOpenType.NEXT_TIMESPAN.equals(type)) {
                        tTradeTimeSpans.remove(t);
                    }
                    continue;
                }
                if (spec.startTimestamp > t.startTimestamp && spec.endTimestamp < t.endTimestamp) {
                    // 3
                    NextTradeOpenType type = spec.nextTradeOpenType;
                    if (NextTradeOpenType.IMMEDIATELY.equals(type)) {
                        DaySessionTimeSpan span = new DaySessionTimeSpan();
                        span.startTime = spec.endTime;
                        span.startTimestamp = spec.endTimestamp;
                        span.startDateStr = spec.endDateStr;
                        span.startDay = spec.endDay;

                        span.endTime = t.endTime;
                        span.endTimestamp = t.endTimestamp;
                        span.endDateStr = t.endDateStr;
                        span.endDay = t.endDay;
                        span.timeSpanState = TimeSpanState.T_OPEN;

                        tTradeTimeSpans.add(span);
                    }
                    if (NextTradeOpenType.NEXT_TIMESPAN.equals(type)) {
                        t.endTime = spec.startTime;
                        t.endDay = spec.startDay;
                        t.endDateStr = spec.startDateStr;
                        t.endTimestamp = spec.startTimestamp;
                    }
                }
            }

        }
    }

    private static List<DaySessionTimeSpan> splitDaySessionTimeSpans(List<DaySessionTimeSpan> allSpans) {
        List<DaySessionTimeSpan> splitSpans = new ArrayList<>();
        for (DaySessionTimeSpan span : allSpans) {
            long dateStart = DateTimeUtils.getDateTimeDatePart(span.startDateStr);
            long dateEnd = dateStart + DateTimeUtils.DATE_LONG;
            String dateStartTimeStr = "00:00:00";
            String dateEndTimeStr = "23:59:59";

            if (span.endTimestamp > dateEnd) {
                System.out.println("split date: " + span.startDateStr);

                DaySessionTimeSpan newSpan = new DaySessionTimeSpan();
                newSpan.startDay = span.startDay;
                newSpan.startTime = span.startTime;
                newSpan.startTimestamp = span.startTimestamp;
                newSpan.endDay = span.startDay;
                newSpan.endTime = dateEndTimeStr;
                newSpan.endTimestamp = dateEnd - DateTimeUtils.ONE_SEC;
                newSpan.startDateStr = span.startDateStr;
                newSpan.endDateStr = span.startDateStr;
                newSpan.timeSpanState = span.timeSpanState;

                span.startDay = getNextDayCycle(span.startDay);
                System.out.println("span.startDay: " + span.startDay);
                span.startTime = dateStartTimeStr;
                span.startTimestamp = dateEnd;
                Calendar calendar = DateTimeUtils.getDateTimeDatePartDate(span.startDateStr);
                calendar.add(Calendar.DATE, 1);
                span.startDateStr = DateTimeUtils.getDateStringDatePart(calendar.getTimeInMillis());
                System.out.println("new span date: " + span.startDateStr);

                splitSpans.add(newSpan);
            }
        }
        return splitSpans;
    }

    private List<DaySessionTimeSpan> fillTimeSpans(List<DaySessionTimeSpan> allSpans) {
        allSpans.sort(TradeSession2TradeTime::compareDaySessionTimeSpan);
        List<DaySessionTimeSpan> createSpan = new ArrayList<>();
        DaySessionTimeSpan last = null;
        for (DaySessionTimeSpan span : allSpans) {
            if (last != null) {
                DaySessionTimeSpan newSpan = new DaySessionTimeSpan();
                newSpan.startDay = last.endDay;
                newSpan.startTime = last.endTime;
                newSpan.startTimestamp = last.endTimestamp;
                newSpan.endDay = span.startDay;
                newSpan.endTime = span.startTime;
                newSpan.endTimestamp = span.startTimestamp;
                newSpan.startDateStr = last.endDateStr;
                newSpan.endDateStr = span.startDateStr;

                // 同一个trade session
                if (last.tradingSessionId == span.tradingSessionId) {
                    newSpan.timeSpanState = TimeSpanState.REST;
                } else {
                    newSpan.timeSpanState = TimeSpanState.CLOSED;
                }
                createSpan.add(newSpan);
            }
            last = span;
        }
        return createSpan;
    }

    private static void print(List<DaySessionTimeSpan> daySessionTimeSpans, String key) {
        AppLog.d("key: " + key);
        for (DaySessionTimeSpan span : daySessionTimeSpans) {
            AppLog.d(span.timeSpanId);
            AppLog.d(span.tradingSessionId);
            AppLog.d(span.startDay);
            AppLog.d(span.startTime);
            AppLog.d(span.startTimestamp);
            AppLog.d(span.endDay);
            AppLog.d(span.endTime);
            AppLog.d(span.endTimestamp);
            AppLog.d(span.timeSpanState);
            AppLog.d(span.startDateStr);
            AppLog.d(span.endDateStr);
        }
    }

    private static int compareTTimeSpan(TTimeSpan o1, TTimeSpan o2) {
        if (o1.getStartTimestamp() < o2.getStartTimestamp()) {
            return -1;
        }
        if (o1.getStartTimestamp() > o2.getStartTimestamp()) {
            return 1;
        }
        return 0;
    }

    private static int compareDaySessionTimeSpan(DaySessionTimeSpan o1, DaySessionTimeSpan o2) {
        if (o1.startTimestamp < o2.startTimestamp) {
            return -1;
        } else if (o1.startTimestamp > o2.startTimestamp) {
            return 1;
        }
        return 0;
    }

    // 计算用
    private static class DaySessionTimeSpan {
        public Days startDay;
        public Days endDay;
        public String startTime;
        public String endTime;
        public TimeSpanState timeSpanState;
        public long startTimestamp;
        public long endTimestamp;
        public long tradingSessionId;
        public long timeSpanId;
        public String startDateStr;
        public String endDateStr;
        public NextTradeOpenType nextTradeOpenType;
    }

    private static Days getNextDayCycle(Days day) {

        if (Days.SATURDAY.equals(day)) {
            return Days.SUNDAY;
        }

        return Days.findByValue(day.getValue() + 1);
    }
}
