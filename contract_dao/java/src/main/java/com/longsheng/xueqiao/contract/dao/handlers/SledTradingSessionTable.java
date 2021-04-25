package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.google.common.base.Preconditions;
import com.longsheng.xueqiao.contract.dao.config.ConfigurationProperty;
import com.longsheng.xueqiao.contract.thriftapi.*;
import org.apache.commons.lang.StringUtils;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.db_helper.TableHelper;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SledTradingSessionTable extends TableHelper<SledTradingSession> {

    public static final String TABLE_NAME = "t_sled_trading_session";
    public static final String FTRADING_SESSION_ID = "Ftrading_session_id";
    public static final String FSLED_COMMODITY_ID = "Fsled_commodity_id";
    public static final String FZONE_ID = "Fzone_id";
    public static final String FTIME_SPANS = "Ftime_spans";
    public static final String FTIME_SYSTEM = "Ftime_system";
    public static final String FCREATE_TIMESTAMP = "Fcreate_timestamp";
    public static final String FLAST_MODIFY_TIMESTAMP = "Flast_modify_timestamp";

    protected SledTradingSessionTable(Connection conn) {
        super(conn);
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public SledTradingSession fromResultSet(ResultSet resultSet) throws Exception {
        SledTradingSession tradingSession = new SledTradingSession();
        tradingSession.setTradeSessionId(resultSet.getLong(FTRADING_SESSION_ID));
        tradingSession.setSledCommodityId(resultSet.getInt(FSLED_COMMODITY_ID));
        tradingSession.setZoneId(resultSet.getString(FZONE_ID));
        String content = resultSet.getString(FTIME_SPANS);
        String[] timeSpanIdStrs = StringUtils.split(content, ",");
        Set<Long> timeSpanIds = new HashSet<>();
        for (String str : timeSpanIdStrs) {
            timeSpanIds.add(Long.valueOf(str));
        }
        if (timeSpanIds.size() > 0) {
            SledTradingSessionTimeSpanTable spanTable = new SledTradingSessionTimeSpanTable(getConnection());
            List<SledTradingSessionTimeSpan> list = spanTable.query(timeSpanIds);
            tradingSession.setTimeSpans(list);
        } else {
            tradingSession.setTimeSpans(new ArrayList<>());
        }
        tradingSession.setTimeSystem(TimeSystem.findByValue(resultSet.getInt(FTIME_SYSTEM)));
        tradingSession.setCreateTimestamp(resultSet.getLong(FCREATE_TIMESTAMP));
        tradingSession.setLastModifyTimestamp(resultSet.getLong(FLAST_MODIFY_TIMESTAMP));
        return tradingSession;
    }


    public void add(SledTradingSession sledTradingSession) throws ErrorInfo, SQLException {
        Preconditions.checkNotNull(sledTradingSession);
        long tradeSessionId;
        try {
            tradeSessionId = ConfigurationProperty.instance().getSledTradingSessionIdMaker().createId();
        } catch (IdException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "SledTradingSession Id Maker create id fail.");
        }

        PreparedFields fields = getPreparedFields(sledTradingSession);
        if (sledTradingSession.isSetTimeSpans() && sledTradingSession.getTimeSpansSize() > 0) {
            SledTradingSessionTimeSpanTable tradingSessionTimeSpanTable = new SledTradingSessionTimeSpanTable(getConnection());
            for (SledTradingSessionTimeSpan span : sledTradingSession.getTimeSpans()) {
                span.setTradeSessionId(tradeSessionId);
            }
            List<Long> timeSpanIds = tradingSessionTimeSpanTable.batAdd(sledTradingSession.getTimeSpans());
            fields.addString(FTIME_SPANS, StringUtils.join(timeSpanIds.toArray(), ","));
        }

        fields.addLong(FTRADING_SESSION_ID, tradeSessionId);
        long now = System.currentTimeMillis() / 1000;
        fields.addLong(FCREATE_TIMESTAMP, now);
        fields.addLong(FLAST_MODIFY_TIMESTAMP, now);
        super.insert(fields);
    }

    private PreparedFields getPreparedFields(SledTradingSession sledTradingSession) {
        PreparedFields fields = new PreparedFields();
        if (sledTradingSession.isSetTimeSystem()) {
            fields.addInt(FTIME_SYSTEM, sledTradingSession.getTimeSystem().getValue());
        }
        if (sledTradingSession.isSetSledCommodityId()) {
            fields.addInt(FSLED_COMMODITY_ID, sledTradingSession.getSledCommodityId());
        }
        if (sledTradingSession.isSetZoneId()) {
            fields.addString(FZONE_ID, sledTradingSession.getZoneId());
        }
        return fields;
    }

    public void update(SledTradingSession sledTradingSession) throws SQLException {
        Preconditions.checkNotNull(sledTradingSession);
        Preconditions.checkArgument(sledTradingSession.getTradeSessionId() > 0);

        PreparedFields fields = getPreparedFields(sledTradingSession);

        if (sledTradingSession.isSetTimeSpans()) {
            List<Long> timeSpanIds = new ArrayList<>();
            for (SledTradingSessionTimeSpan timeSpan : sledTradingSession.getTimeSpans()) {
                timeSpanIds.add(timeSpan.getTimeSpanId());
            }
            fields.addString(FTIME_SPANS, StringUtils.join(timeSpanIds.toArray(), ","));
        }

        long now = System.currentTimeMillis() / 1000;
        fields.addLong(FLAST_MODIFY_TIMESTAMP, now);
        super.update(fields, FTRADING_SESSION_ID + "=?", sledTradingSession.getTradeSessionId());
    }

    public SledTradingSession queryForUpdate(long tradeSessionId, boolean isForUpdate) throws SQLException {
        Preconditions.checkArgument(tradeSessionId > 0);
        SqlQueryBuilder builder = super.prepareSqlQueryBuilder();
        builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FTRADING_SESSION_ID + "=?", tradeSessionId);
        return super.getItem(builder, isForUpdate);
    }

    public SledTradingSessionPage query(ReqSledTradingSessionOption option, IndexedPageOption pageOption) throws SQLException {
        Preconditions.checkNotNull(option);
        SqlQueryBuilder builder = super.prepareSqlQueryBuilder();
        if (option.isSetSledCommodityId()) {
            builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FSLED_COMMODITY_ID + "=?", option.getSledCommodityId());
        }
        if (option.isSetTradeSessionIds()) {
            builder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, FTRADING_SESSION_ID, option.getTradeSessionIds());
        }
        if (option.isSetTimeSystem()) {
            builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FTIME_SYSTEM + "=?", option.getTimeSystem().getValue());
        }
        SledTradingSessionPage page = new SledTradingSessionPage();
        if (pageOption != null) {
            if (pageOption.isSetPageIndex() && pageOption.isSetPageSize()) {
                builder.setPage(pageOption.getPageIndex(), pageOption.getPageSize());
            }
            if (pageOption.isNeedTotalCount()) {
                page.setTotal(super.getTotalNum(builder));
            }
        }
        page.setPage(super.getItemList(builder));
        return page;
    }

    public void deleteSledTradingSession(long sledTradingSessionId) throws SQLException {
        super.delete(FTRADING_SESSION_ID + "=?", sledTradingSessionId);
    }

    public void deleteBySledCommodityId(long sledCommodityId) throws SQLException {
        super.delete(FSLED_COMMODITY_ID + "=?", sledCommodityId);
    }
}
