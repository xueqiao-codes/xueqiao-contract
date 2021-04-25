package com.longsheng.xueqiao.currency.dao.handler;

import com.antiy.error_code.ErrorCodeInner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.longsheng.xueqiao.currency.dao.config.ConfigurationProperty;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRateHistory;
import com.longsheng.xueqiao.currency.thriftapi.ExchangeRateHistoryPage;
import com.longsheng.xueqiao.currency.thriftapi.ReqHistoryOption;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.dal_set.DalSetTableHelper;
import org.soldier.platform.id_maker.IdException;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class SledExchangeRateHistoryHandler extends DalSetTableHelper<ExchangeRateHistory> {

    private static final String TABLE_NAME = "t_sled_exchange_rate_history";
    private static final String COLUMN_FHISTORY_ID = "Fhistory_id";
    private static final String COLUMN_FBASE_CURRENCY = "Fbase_currency";
    private static final String COLUMN_FCONTENT = "Fcontent";
    private static final String COLUMN_FCREATE_TIMESTAMP = "Fcreate_timestamp";
    private static final String COLUMN_FLAST_MODITY_TIMESTAMP = "Flast_modify_timestamp";

    public SledExchangeRateHistoryHandler(Connection conn, String roleName) {
        super(conn, roleName);
    }

    @Override
    protected String getTableNamePrefix() {
        return TABLE_NAME;
    }

    @Override
    public ExchangeRateHistory fromResultSet(ResultSet resultSet) throws Exception {
        ExchangeRateHistory history = new ExchangeRateHistory();
        history.setHistoryId(resultSet.getLong(COLUMN_FHISTORY_ID));
        history.setCurrencyCode(resultSet.getString(COLUMN_FBASE_CURRENCY));
        history.setExchangeRate(new Gson().fromJson(resultSet.getString(COLUMN_FCONTENT), new TypeToken<HashMap<String, Double>>() {
        }.getType()));
        history.setCreateTimestamp(resultSet.getLong(COLUMN_FCREATE_TIMESTAMP));
        history.setLastModityTimestamp(resultSet.getLong(COLUMN_FLAST_MODITY_TIMESTAMP));
        return history;
    }

    public ExchangeRateHistoryPage query(ReqHistoryOption option, IndexedPageOption pageOption) throws SQLException {
        SqlQueryBuilder builder = super.prepareSqlQueryBuilder();
        if (option.isSetHistoryId()) {
            builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, COLUMN_FHISTORY_ID + "=?", option.getHistoryId());
        }
        if (option.isSetCurrency()) {
            builder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, COLUMN_FBASE_CURRENCY + "=?", option.getCurrency());
        }
        ExchangeRateHistoryPage page = new ExchangeRateHistoryPage();
        if (pageOption != null) {
            if (pageOption.isSetPageSize()) {
                builder.setPage(pageOption.getPageIndex(), pageOption.getPageSize());
            }
            if (pageOption.isNeedTotalCount()) {
                page.setTotal(super.getTotalNum(builder));
            }
        }
        page.setPage(super.getItemList(builder));
        return page;
    }

    public long batAdd(List<ExchangeRateHistory> histories) throws ErrorInfo, SQLException {
        long historyId = getHistoryId();
        for (ExchangeRateHistory history : histories) {
            history.setHistoryId(historyId);
            add(history);
        }
        return historyId;
    }

    private long getHistoryId() throws ErrorInfo {
        try {
            return ConfigurationProperty.instance().getHistoryIdMaker().createId();
        } catch (IdException e) {
            AppLog.e(e.getMessage(), e);
            throw new ErrorInfo(ErrorCodeInner.SERVER_INNER_ERROR.getErrorCode(), "Id maker create id fail.");
        }
    }

    private void add(ExchangeRateHistory history) throws SQLException {

        PreparedFields fields = new PreparedFields();
        if (history.isSetExchangeRate() && history.getExchangeRate().size() > 0) {
            fields.addString(COLUMN_FCONTENT, new Gson().toJson(history.getExchangeRate()));
        }
        if (history.isSetHistoryId()) {
            fields.addLong(COLUMN_FHISTORY_ID, history.getHistoryId());
        }
        if (history.isSetCurrencyCode()) {
            fields.addString(COLUMN_FBASE_CURRENCY, history.getCurrencyCode());
        }

        long now = System.currentTimeMillis();
        fields.addLong(COLUMN_FCREATE_TIMESTAMP, now);
        fields.addLong(COLUMN_FLAST_MODITY_TIMESTAMP, now);
        super.insert(fields);
    }
}
