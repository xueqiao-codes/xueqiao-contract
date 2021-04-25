package com.longsheng.xueqiao.contract.sync;

import com.longsheng.xueqiao.contract.thriftapi.*;
import com.longsheng.xueqiao.contract.utils.DateTimeUtils;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TradeSession2TradeTime.class)
public class TradeSession2TradeTimeTest {

    int sledCommodityId = 10534;
    String zoneId = "Asia/Shanghai";
    String spanOpen0WorkingDay = "00:00:00-02:00:00";
    String spanRest1WorkingDay = "02:00:01-08:59:59";

    String spanOpen2WorkingDay = "09:00:00-11:00:00";
    String spanRest3WorkingDay = "11:00:01-12:59:59";

    String spanOpen4WorkingDay = "13:00:00-15:00:00";
    String spanClose5WorkingDay = "15:00:01-20:59:59";

    String spanOpen6WorkingDay = "21:00:00-23:59:59";

    String spanRestSaturday = "02:00:01-23:59:59";
    String spanRestSunday = "00:00:00-23:59:59";
    String spanRest0Monday = "00:00:00-08:59:59";

    String spanOpen1StartTime = "09:00:00";
    String spanOpen1EndTime = "11:00:00";

    String spanOpen2StartTime = "13:00:00";
    String spanOpen2EndTime = "15:00:00";

    String spanOpen3StartTime = "21:00:00";
    String spanOpen3EndTime = "02:00:00";

    List<SledTradingSession> sledTradingSessions = new ArrayList<>();
    SledTradingSessionPage sledTradingSessionPage = new SledTradingSessionPage();
    private List<SledCommoditySpecTradeTime> specTradeTimes;

    String time_span_error = "time span error";
    String time_span_state_error = "time span state error";

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 7; i++) {
            SledTradingSession session = new SledTradingSession();

            if (i == 0 || i == 6) {

            } else {
                session.setTimeSystem(TimeSystem.STANDARD);
                session.setSledCommodityId(sledCommodityId);
                List<SledTradingSessionTimeSpan> timeSpans = new ArrayList<>();

                SledTradingSessionTimeSpan span3 = new SledTradingSessionTimeSpan();
                span3.setStartDay(Days.findByValue(i));
                span3.setEndDay(Days.findByValue(i + 1));
                span3.setStartTime(spanOpen3StartTime);
                span3.setEndTime(spanOpen3EndTime);
                span3.setTimeSpanState(TimeSpanState.T_OPEN);
                span3.setTimeSpanId(i * 100 + 3);
                if (i == 5) {
                    span3.setTradeSessionId(1 * 1000 + 1);
                } else {
                    span3.setTradeSessionId((i + 1) * 1000 + 1);
                }
                timeSpans.add(span3);

                SledTradingSessionTimeSpan span1 = new SledTradingSessionTimeSpan();
                span1.setStartDay(Days.findByValue(i));
                span1.setEndDay(Days.findByValue(i));
                span1.setStartTime(spanOpen1StartTime);
                span1.setEndTime(spanOpen1EndTime);
                span1.setTimeSpanId(i * 100 + 1);
                span1.setTradeSessionId(i * 1000 + 1);
                span1.setTimeSpanState(TimeSpanState.T_OPEN);
                timeSpans.add(span1);

                SledTradingSessionTimeSpan span2 = new SledTradingSessionTimeSpan();
                span2.setStartDay(Days.findByValue(i));
                span2.setEndDay(Days.findByValue(i));
                span2.setStartTime(spanOpen2StartTime);
                span2.setEndTime(spanOpen2EndTime);
                span2.setTimeSpanId(i * 100 + 2);
                span2.setTradeSessionId(i * 1000 + 1);
                span2.setTimeSpanState(TimeSpanState.T_OPEN);
                timeSpans.add(span2);

                session.setTimeSpans(timeSpans);
            }
            sledTradingSessions.add(session);
        }

        sledTradingSessionPage.setPage(sledTradingSessions);
        System.out.println(sledTradingSessionPage);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSledTradeTimesWithoutSpecTradeTimes() {

        String formatDate = "2018-10-09";
        Calendar calendar = DateTimeUtils.getDateTimeDatePartDate(formatDate);
        int totalDays = 9;
        String[] expectedDate = new String[]{"2018-10-05", "2018-10-06", "2018-10-07", "2018-10-08", "2018-10-09", "2018-10-10", "2018-10-11", "2018-10-12", "2018-10-13"};

        try {
            SledTradeTime result = new TradeSession2TradeTime().getSledTradeTimes(sledCommodityId, zoneId, sledTradingSessionPage, specTradeTimes, totalDays, calendar.getTime());
            assertNormalProperties(totalDays, result);
            for (int i = 0; i < totalDays; i++) {
                Assert.assertEquals("date sort error", expectedDate[i], result.getDateTimeSpans().get(i).getDate());
            }

            for (int i = 0; i < totalDays; i++) {
                Assert.assertNotNull("Time span null", result.getDateTimeSpans().get(i).getTTimeSpan());
            }

            // "2018-10-05" 周五 第一日
            assertWorkingDay2_5(result, 0);

            // "2018-10-06" 周六，第二日
            assertSat(result, 1);

            // "2018-10-07" 周日，第三日
            assertRest(result, 2);

            // "2018-10-08" 周一，第四日
            assertMon(result, 3);

            // "2018-10-09" - "2018-10-12" 周二至周五
            for (int i = 4; i < 8; i++) {
                assertWorkingDay2_5(result, i);
            }

            // "2018-10-13" 周六
            assertSat(result, 8);

        } catch (ErrorInfo e) {
            Assert.fail("Exception: " + e.getMessage());
        }
    }

    private void assertSat(SledTradeTime result, int index) {
        Assert.assertEquals(time_span_error, spanOpen0WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(0).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.T_OPEN, result.getDateTimeSpans().get(index).getTTimeSpan().get(0).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanRestSaturday, result.getDateTimeSpans().get(index).getTTimeSpan().get(1).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.REST, result.getDateTimeSpans().get(index).getTTimeSpan().get(1).getTimeSpanState());
    }

    private void assertWorkingDay2_5(SledTradeTime result, int index) {
        Assert.assertEquals(time_span_error, spanOpen0WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(0).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.T_OPEN, result.getDateTimeSpans().get(index).getTTimeSpan().get(0).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanRest1WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(1).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.REST, result.getDateTimeSpans().get(index).getTTimeSpan().get(1).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanOpen2WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(2).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.T_OPEN, result.getDateTimeSpans().get(index).getTTimeSpan().get(2).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanRest3WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(3).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.REST, result.getDateTimeSpans().get(index).getTTimeSpan().get(3).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanOpen4WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(4).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.T_OPEN, result.getDateTimeSpans().get(index).getTTimeSpan().get(4).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanClose5WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(5).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.CLOSED, result.getDateTimeSpans().get(index).getTTimeSpan().get(5).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanOpen6WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(6).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.T_OPEN, result.getDateTimeSpans().get(index).getTTimeSpan().get(6).getTimeSpanState());
    }

    @Test
    public void getSledTradeTimesWithSpecTradeTimes() {
        specTradeTimes = new ArrayList<>();
        SledCommoditySpecTradeTime specTradeTime = new SledCommoditySpecTradeTime();
        specTradeTime.setSledCommodityId(sledCommodityId);
        // 2018-10-01  至 2018-10-08 00:00:00
        specTradeTime.setNonTradeStartTimestamp(1538323200L);
        specTradeTime.setNonTradeEndTimestamp(1538841600L);
        specTradeTime.setNextTradeOpenType(NextTradeOpenType.NEXT_TIMESPAN);
        specTradeTimes.add(specTradeTime);

        String formatDate = "2018-10-09";
        Calendar calendar = DateTimeUtils.getDateTimeDatePartDate(formatDate);
        int totalDays = 9;
        String[] expectedDate = new String[]{"2018-10-05", "2018-10-06", "2018-10-07", "2018-10-08", "2018-10-09", "2018-10-10", "2018-10-11", "2018-10-12", "2018-10-13"};

        try {
            SledTradeTime result = new TradeSession2TradeTime().getSledTradeTimes(sledCommodityId, zoneId, sledTradingSessionPage, specTradeTimes, totalDays, calendar.getTime());
            assertNormalProperties(totalDays, result);
            for (int i = 0; i < totalDays; i++) {
                Assert.assertEquals("date sort error", expectedDate[i], result.getDateTimeSpans().get(i).getDate());
            }

            for (int i = 0; i < totalDays; i++) {
                Assert.assertNotNull("Time span null", result.getDateTimeSpans().get(i).getTTimeSpan());
            }

            // "2018-10-05" 第一日 至 "2018-10-07" 周日，第三日 特殊交易时间导致这些日子都是休市状态
            for (int i = 0; i < 3; i++) {
                assertRest(result, i);
            }

            // "2018-10-08" 周一，第四日
            assertMon(result, 3);

            // "2018-10-09" - "2018-10-12" 周二至周五
            for (int i = 4; i < 8; i++) {
                assertWorkingDay2_5(result, i);
            }

        } catch (ErrorInfo e) {
            Assert.fail("Exception: " + e.getMessage());
        }
    }

    private void assertNormalProperties(int totalDays, SledTradeTime result) {
        Assert.assertNotNull("Result null", result);
        Assert.assertEquals("Sled commodity id not set", sledCommodityId, result.getSledCommodityId());
        Assert.assertEquals("Zone id error", zoneId, result.getZoneId());
        Assert.assertNotNull("Date time spans not found", result.getDateTimeSpans());
        Assert.assertEquals("total days error", totalDays, result.getDateTimeSpansSize());
    }

    private void assertMon(SledTradeTime result, int index) {
        Assert.assertEquals(time_span_error, spanRest0Monday, result.getDateTimeSpans().get(index).getTTimeSpan().get(0).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.REST, result.getDateTimeSpans().get(index).getTTimeSpan().get(0).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanOpen2WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(1).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.T_OPEN, result.getDateTimeSpans().get(index).getTTimeSpan().get(1).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanRest3WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(2).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.REST, result.getDateTimeSpans().get(index).getTTimeSpan().get(2).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanOpen4WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(3).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.T_OPEN, result.getDateTimeSpans().get(index).getTTimeSpan().get(3).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanClose5WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(4).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.CLOSED, result.getDateTimeSpans().get(index).getTTimeSpan().get(4).getTimeSpanState());

        Assert.assertEquals(time_span_error, spanOpen6WorkingDay, result.getDateTimeSpans().get(index).getTTimeSpan().get(5).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.T_OPEN, result.getDateTimeSpans().get(index).getTTimeSpan().get(5).getTimeSpanState());
    }

    private void assertRest(SledTradeTime result, int index) {
        Assert.assertEquals(time_span_error, spanRestSunday, result.getDateTimeSpans().get(index).getTTimeSpan().get(0).getTimespan());
        Assert.assertEquals(time_span_state_error, TimeSpanState.REST, result.getDateTimeSpans().get(index).getTTimeSpan().get(0).getTimeSpanState());
    }

    @Test
    public void checkNewTradingSession() throws Exception {
        SledTradingSession sledTradingSession = getSledTradingSession();

        TradeSession2TradeTime tradeSession2TradeTime = PowerMockito.mock(TradeSession2TradeTime.class);
        PowerMockito.when(tradeSession2TradeTime.checkNewTradingSession(sledTradingSession)).thenCallRealMethod();
        PowerMockito.when(tradeSession2TradeTime, "checkData", sledTradingSession).thenReturn(true);

        tradeSession2TradeTime.checkNewTradingSession(sledTradingSession);
        verifyPrivate(tradeSession2TradeTime).invoke("checkData", sledTradingSession);
    }

    private SledTradingSession getSledTradingSession() {
        SledTradingSession sledTradingSession = new SledTradingSession();
        sledTradingSession.setSledCommodityId(sledCommodityId);
        sledTradingSession.setZoneId(zoneId);
        sledTradingSession.setTimeSystem(TimeSystem.STANDARD);
        List<SledTradingSessionTimeSpan> list = new ArrayList<>();
        SledTradingSessionTimeSpan timeSpan = new SledTradingSessionTimeSpan();

        timeSpan.setStartDay(Days.findByValue(1));
        timeSpan.setEndDay(Days.findByValue(1));
        timeSpan.setStartTime("10:10:00");
        timeSpan.setEndTime("10:20:00");
        timeSpan.setTimeSpanId(100 + 1);
        timeSpan.setTradeSessionId(1000 + 1);
        timeSpan.setTimeSpanState(TimeSpanState.T_OPEN);
        list.add(timeSpan);
        sledTradingSession.setTimeSpans(list);
        return sledTradingSession;
    }

    private SledTradingSessionPage getPage() {

        SledTradingSession sledTradingSession = new SledTradingSession();
        sledTradingSession.setSledCommodityId(sledCommodityId);
        sledTradingSession.setTimeSystem(TimeSystem.STANDARD);
        List<SledTradingSessionTimeSpan> list = new ArrayList<>();
        SledTradingSessionTimeSpan timeSpan = new SledTradingSessionTimeSpan();

        timeSpan.setStartDay(Days.findByValue(1));
        timeSpan.setEndDay(Days.findByValue(1));
        timeSpan.setStartTime("10:00:00");
        timeSpan.setEndTime("10:30:00");
        timeSpan.setTimeSpanId(100 + 1);
        timeSpan.setTradeSessionId(1000 + 1);
        timeSpan.setTimeSpanState(TimeSpanState.T_OPEN);
        list.add(timeSpan);
        sledTradingSession.setTimeSpans(list);
        SledTradingSessionPage page = new SledTradingSessionPage();
        page.setTotal(1);
        page.addToPage(sledTradingSession);
        return page;
    }

    @Test
    public void getDayTimeSpanMap() {
        TradeSession2TradeTime tradeSession2TradeTime = new TradeSession2TradeTime();
        SledTradingSessionPage page = getPage();
        page.addToPage(getSledTradingSession());
        try {
            tradeSession2TradeTime.getDayTimeSpanMap(TimeSystem.STANDARD, page, DateTimeUtils.WEEK);
            Assert.fail(" time span should be not match.");
        } catch (ErrorInfo errorInfo) {
            Assert.assertEquals("time span error check fail", "time span error", errorInfo.getErrorMsg());
        }
    }
}