package com.longsheng.xueqiao.contract.dao.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.google.common.base.Preconditions;
import com.longsheng.xueqiao.contract.dao.config.ConfigurationProperty;
import com.longsheng.xueqiao.contract.thriftapi.Days;
import com.longsheng.xueqiao.contract.thriftapi.SledTradingSessionTimeSpan;
import com.longsheng.xueqiao.contract.thriftapi.TimeSpanState;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.db_helper.TableHelper;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SledTradingSessionTimeSpanTable extends TableHelper<SledTradingSessionTimeSpan> {

    public static final String TABLE_NAME = "t_sled_trading_session_time_span";
    public static final String FTIME_SPAN_ID = "Ftime_span_id";
    public static final String FSTART_DAY = "Fstart_day";
    public static final String FEND_DAY = "Fend_day";
    public static final String FSTART_TIME = "Fstart_time";
    public static final String FEND_TIME = "Fend_time";
    public static final String FTIME_SPAN_STATE = "Ftime_span_state";
    public static final String FTRADING_SESSION_ID = "Ftrading_session_id";
    public static final String FCREATE_TIMESTAMP = "Fcreate_timestamp";
    public static final String FLAST_MODIFY_TIMESTAMP = "Flast_modify_timestamp";

    protected SledTradingSessionTimeSpanTable(Connection conn) {
        super(conn);
    }

    @Override
    protected String getTableName() throws SQLException {
        return TABLE_NAME;
    }

    @Override
    public SledTradingSessionTimeSpan fromResultSet(ResultSet resultSet) throws Exception {
        SledTradingSessionTimeSpan timeSpan = new SledTradingSessionTimeSpan();
        timeSpan.setTimeSpanId(resultSet.getLong(FTIME_SPAN_ID));
        timeSpan.setStartDay(Days.findByValue(resultSet.getInt(FSTART_DAY)));
        timeSpan.setEndDay(Days.findByValue(resultSet.getInt(FEND_DAY)));
        timeSpan.setStartTime(resultSet.getString(FSTART_TIME));
        timeSpan.setEndTime(resultSet.getString(FEND_TIME));
        timeSpan.setTimeSpanState(TimeSpanState.findByValue(resultSet.getInt(FTIME_SPAN_STATE)));
        timeSpan.setTradeSessionId(resultSet.getLong(FTRADING_SESSION_ID));
        timeSpan.setCreateTimestamp(resultSet.getLong(FCREATE_TIMESTAMP));
        timeSpan.setLastModifyTimestamp(resultSet.getLong(FLAST_MODIFY_TIMESTAMP));
        return timeSpan;
    }

    public List<SledTradingSessionTimeSpan> query(Set<Long> timeSpanIds) throws SQLException {
        Preconditions.checkNotNull(timeSpanIds);
        Preconditions.checkArgument(timeSpanIds.size() > 0);
        SqlQueryBuilder builder = super.prepareSqlQueryBuilder();
        builder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, FTIME_SPAN_ID, timeSpanIds);
        return super.getItemList(builder);
    }

    public SledTradingSessionTimeSpan queryForUpdate(long timeSpanId, boolean forUpdate) throws SQLException {
        Preconditions.checkArgument(timeSpanId > 0);
        SqlQueryBuilder builder = super.prepareSqlQueryBuilder();
        builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, FTIME_SPAN_ID + "=?", timeSpanId);
        return super.getItem(builder, forUpdate);
    }

    public void update(SledTradingSessionTimeSpan sledTradingSessionTimeSpan) throws SQLException {
        Preconditions.checkNotNull(sledTradingSessionTimeSpan);
        Preconditions.checkArgument(sledTradingSessionTimeSpan.getTimeSpanId() > 0);

        PreparedFields fields = getPreparedFields(sledTradingSessionTimeSpan);
        long now = System.currentTimeMillis() / 1000;
        fields.addLong(FLAST_MODIFY_TIMESTAMP, now);
        super.update(fields, FTIME_SPAN_ID + "=?", sledTradingSessionTimeSpan.getTimeSpanId());
    }

    private long add(SledTradingSessionTimeSpan sledTradingSessionTimeSpan, long timeSpanId) throws ErrorInfo, SQLException {
        Preconditions.checkNotNull(sledTradingSessionTimeSpan);
        PreparedFields fields = getPreparedFields(sledTradingSessionTimeSpan);
        fields.addLong(FTIME_SPAN_ID, timeSpanId);
        sledTradingSessionTimeSpan.setTimeSpanId(timeSpanId);
        long now = System.currentTimeMillis() / 1000;
        fields.addLong(FCREATE_TIMESTAMP, now);
        fields.addLong(FLAST_MODIFY_TIMESTAMP, now);
        super.insert(fields);
        return timeSpanId;
    }

    public List<Long> batAdd(List<SledTradingSessionTimeSpan> spans) throws ErrorInfo, SQLException {
        List<Long> ids = new LinkedList<>();
        for (int i = 0; i < spans.size(); i++) {
            long timeSpanId = 0;
            try {
                timeSpanId = ConfigurationProperty.instance().getSledTradingSessionTimeSpanIdMaker().createId();
                ids.add(timeSpanId);
            } catch (IdException e) {
                AppLog.e(e.getMessage(), e);
                throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "TradingSessionTimeSpanIdMaker create id fail");
            }
        }
        ids.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1 > o2) {
                    return 1;
                }
                if (o1 < o2) {
                    return -1;
                }
                return 0;
            }
        });
        for (int i = 0; i < spans.size(); i++) {
            add(spans.get(i), ids.get(i));
        }
        return ids;
    }

    private PreparedFields getPreparedFields(SledTradingSessionTimeSpan sledTradingSessionTimeSpan) {
        PreparedFields fields = new PreparedFields();
        if (sledTradingSessionTimeSpan.isSetStartDay()) {
            fields.addInt(FSTART_DAY, sledTradingSessionTimeSpan.getStartDay().getValue());
        }
        if (sledTradingSessionTimeSpan.isSetStartTime()) {
            fields.addString(FSTART_TIME, sledTradingSessionTimeSpan.getStartTime());
        }
        if (sledTradingSessionTimeSpan.isSetEndDay()) {
            fields.addInt(FEND_DAY, sledTradingSessionTimeSpan.getEndDay().getValue());
        }
        if (sledTradingSessionTimeSpan.isSetEndTime()) {
            fields.addString(FEND_TIME, sledTradingSessionTimeSpan.getEndTime());
        }
        if (sledTradingSessionTimeSpan.isSetTimeSpanState()) {
            fields.addInt(FTIME_SPAN_STATE, sledTradingSessionTimeSpan.getTimeSpanState().getValue());
        }
        if (sledTradingSessionTimeSpan.isSetTradeSessionId()) {
            fields.addLong(FTRADING_SESSION_ID, sledTradingSessionTimeSpan.getTradeSessionId());
        }
        return fields;
    }

    public void deleteByTimeSpanId(long timeSpanId) throws SQLException {
        Preconditions.checkArgument(timeSpanId > 0);
        super.delete(FTIME_SPAN_ID + "=?", timeSpanId);
    }

    public void deleteByTradingSessionId(long tradingSessionId) throws SQLException {
        super.delete(FTRADING_SESSION_ID + "=?", tradingSessionId);

    }
}
