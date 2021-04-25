package com.longsheng.xueqiao.currency.dao.handler;

import com.longsheng.xueqiao.currency.dao.config.ConfigurationProperty;
import com.longsheng.xueqiao.currency.dao.util.CurrencyUtil;
import com.longsheng.xueqiao.currency.thriftapi.*;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.dal_set.DalSetTableHelper;
import org.soldier.platform.page.IndexedPageOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SledExchangeRateHandler extends DalSetTableHelper<ExchangeRate> {

    public static final String TABLE_NAME = "t_sled_exchange_rate";

    public static final String COLUMN_FBASE_CURRENCY = "Fbase_currency";
    public static final String COLUMN_FTARGET_CURRENCY = "Ftarget_currency";
    public static final String COLUMN_FEXCHANGE_RATE_NAME = "Fexchange_rate_name";
    public static final String COLUMN_FEXCHANGE_RATE = "Fexchange_rate";
    public static final String COLUMN_FCREATE_TIMESTAMP = "Fcreate_timestamp";
    public static final String COLUMN_FLAST_MODIFY_TIMESTAMP = "Flast_modify_timestamp";

    private static final String SQL_SYMBOL = "=?";

	public SledExchangeRateHandler(Connection conn) {
		super(conn, ConfigurationProperty.instance().getRoleName());
	}

    @Override
    protected String getTableNamePrefix() {
        return TABLE_NAME;
    }

    @Override
    public ExchangeRate fromResultSet(ResultSet resultSet) throws Exception {
        ExchangeRate info = new ExchangeRate();
        info.setName(resultSet.getString(COLUMN_FEXCHANGE_RATE_NAME));
        info.setBaseCurrency(resultSet.getString(COLUMN_FBASE_CURRENCY));
        info.setTargetCurrency(resultSet.getString(COLUMN_FTARGET_CURRENCY));
        info.setExchangeRate(resultSet.getDouble(COLUMN_FEXCHANGE_RATE));
        info.setCreateTimestamp(resultSet.getLong(COLUMN_FCREATE_TIMESTAMP));
        info.setLastModityTimestamp(resultSet.getLong(COLUMN_FLAST_MODIFY_TIMESTAMP));
        return info;
    }

	public int insert(String baseCurrency, String targetCurrency) throws SQLException {
		int createTime = (int) (System.currentTimeMillis() / 1000);
		PreparedFields fields = new PreparedFields();
		fields.addString(COLUMN_FBASE_CURRENCY, baseCurrency);
		fields.addString(COLUMN_FTARGET_CURRENCY, targetCurrency);
		fields.addString(COLUMN_FEXCHANGE_RATE_NAME, CurrencyUtil.getExchangeRateName(baseCurrency, targetCurrency));
		fields.addInt(COLUMN_FCREATE_TIMESTAMP, createTime);
		fields.addInt(COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
		return super.insert(fields);
	}

	public int delete(String baseCurrency) throws SQLException {
        return super.delete(COLUMN_FBASE_CURRENCY + SQL_SYMBOL, baseCurrency);
	}

	public int update(ExchangeRate exchangeRate) throws SQLException {
        int timenow = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = new PreparedFields();
        if (exchangeRate.isSetName()) {
            fields.addString(COLUMN_FEXCHANGE_RATE_NAME, exchangeRate.getName());
        }
        if (exchangeRate.isSetExchangeRate()) {
            fields.addDouble(COLUMN_FEXCHANGE_RATE, exchangeRate.getExchangeRate());
        }
        fields.addInt(COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        String condition = "Fbase_currency =? and  Ftarget_currency =?";
        return super.update(fields, condition, exchangeRate.getBaseCurrency(), exchangeRate.getTargetCurrency());
    }

    public ExchangeRate query(String baseCurrency, String targetCurrency) throws SQLException {
        SqlQueryBuilder sqlQueryBuilder = super.prepareSqlQueryBuilder();
        sqlQueryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, COLUMN_FBASE_CURRENCY + "=?", baseCurrency.trim());
        sqlQueryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, COLUMN_FTARGET_CURRENCY + "=?", targetCurrency.trim());
        List<ExchangeRate> list = super.getItemList(sqlQueryBuilder);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

	public ExchangeRatePage query(ReqExchangeRateOption exchangeRateOption, IndexedPageOption pageOption) throws SQLException {
        SqlQueryBuilder sqlQueryBuilder = super.prepareSqlQueryBuilder();
        boolean isNeedTotal = false;
        if (pageOption != null) {
            if (pageOption.isNeedTotalCount()) {
                isNeedTotal = true;
            }
            if (pageOption.isSetPageIndex() && pageOption.isSetPageSize()) {
                sqlQueryBuilder.setPage(pageOption.getPageIndex(), pageOption.getPageSize());
            }
        }

        if (exchangeRateOption != null) {
            if (exchangeRateOption.isSetBaseCurrency()) {
                sqlQueryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, COLUMN_FBASE_CURRENCY + "=?",
                        exchangeRateOption.getBaseCurrency().trim());
            }
            if (exchangeRateOption.isSetTargetCurrency()) {
                sqlQueryBuilder.addFieldCondition(SqlQueryBuilder.ConditionType.AND, COLUMN_FTARGET_CURRENCY + "=?",
                        exchangeRateOption.getTargetCurrency().trim());
            }
        }
        ExchangeRatePage page = new ExchangeRatePage();
        if (isNeedTotal) {
            page.setTotal(super.getTotalNum(sqlQueryBuilder));
        }
        page.setPage(super.getItemList(sqlQueryBuilder));
        return page;
    }
}
