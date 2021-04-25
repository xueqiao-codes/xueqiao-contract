package com.longsheng.xueqiao.currency.dao.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.longsheng.xueqiao.currency.dao.config.ConfigurationProperty;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.base.sql.SqlQueryBuilder.ConditionType;
import org.soldier.platform.dal_set.DalSetTableHelper;
import org.soldier.platform.page.IndexedPageOption;
import org.soldier.platform.svr_platform.comm.ErrorInfo;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.xueqiao.currency.thriftapi.Currency;
import com.longsheng.xueqiao.currency.thriftapi.CurrencyPage;
import com.longsheng.xueqiao.currency.thriftapi.ReqCurrencyOption;

public class SledCurrencyHandler extends DalSetTableHelper<Currency> {

    public static final String TABLE_NAME = "t_sled_currency";

    public static final String COLUMN_FCURRENCY_CODE = "Fcurrency_code";
    public static final String COLUMN_FEN_NAME = "Fen_name";
    public static final String COLUMN_FCN_NAME = "Fcn_name";
    public static final String COLUMN_FCURRENCY_SYMBOL = "Fcurrency_symbol";
    public static final String COLUMN_FIS_BASE_CURRENCY = "Fis_base_currency";
    public static final String COLUMN_FCREATE_TIMESTAMP = "Fcreate_timestamp";
    public static final String COLUMN_FLAST_MODIFY_TIMESTAMP = "Flast_modify_timestamp";

    public SledCurrencyHandler(Connection conn) {
        super(conn, ConfigurationProperty.instance().getRoleName());
    }

    @Override
    protected String getTableNamePrefix() {
        return TABLE_NAME;
    }

    @Override
    public Currency fromResultSet(ResultSet rs) throws Exception {
        Currency info = new Currency();
        info.setCurrencyCode(rs.getString(COLUMN_FCURRENCY_CODE));
        info.setEnName(rs.getString(COLUMN_FEN_NAME));
        info.setCnName(rs.getString(COLUMN_FCN_NAME));
        info.setSymbol(rs.getString(COLUMN_FCURRENCY_SYMBOL));
        info.setIsBaseCurrency(rs.getBoolean(COLUMN_FIS_BASE_CURRENCY));
        info.setCreateTimestamp(rs.getLong(COLUMN_FCREATE_TIMESTAMP));
        info.setLastModityTimestamp(rs.getLong(COLUMN_FLAST_MODIFY_TIMESTAMP));
        return info;
    }

    public int insert(Currency currency) throws ErrorInfo, SQLException {
        int createTime = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = new PreparedFields();

        if (currency.isSetCurrencyCode() && !currency.getCurrencyCode().isEmpty()) {
            fields.addString(COLUMN_FCURRENCY_CODE, currency.getCurrencyCode());
        } else {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "Currency field currencyCode must set.");
        }
        if (currency.isSetEnName()) {
            fields.addString(COLUMN_FEN_NAME, currency.getEnName());
        }
        if (currency.isSetCnName()) {
            fields.addString(COLUMN_FCN_NAME, currency.getCnName());
        }
        if (currency.isSetSymbol()) {
            fields.addString(COLUMN_FCURRENCY_SYMBOL, currency.getSymbol());
        }
        fields.addInt(COLUMN_FIS_BASE_CURRENCY, currency.isBaseCurrency ? 1 : 0);
        fields.addInt(COLUMN_FCREATE_TIMESTAMP, createTime);
        fields.addInt(COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
        return super.insert(fields);

    }

    public int update(Currency currency) throws ErrorInfo, SQLException {
        if (!currency.isSetCurrencyCode()) {
            throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "Currency field currencyCode must set.");
        }
        int timenow = (int) (System.currentTimeMillis() / 1000);
        PreparedFields fields = new PreparedFields();
        if (currency.isSetEnName()) {
            fields.addString(COLUMN_FEN_NAME, currency.getEnName());
        }
        if (currency.isSetCnName()) {
            fields.addString(COLUMN_FCN_NAME, currency.getCnName());
        }
        if (currency.isSetSymbol()) {
            fields.addString(COLUMN_FCURRENCY_SYMBOL, currency.getSymbol());
        }
        if (currency.isSetIsBaseCurrency()) {
            fields.addInt(COLUMN_FIS_BASE_CURRENCY, currency.isBaseCurrency ? 1 : 0);
        }
        fields.addInt(COLUMN_FLAST_MODIFY_TIMESTAMP, timenow);
        String condition = "Fcurrency_code =?";
        return super.update(fields, condition, currency.getCurrencyCode());
    }

    public Currency query(String currencyCode) throws ErrorInfo, SQLException {
        SqlQueryBuilder sqlQueryBuilder = super.prepareSqlQueryBuilder();
        sqlQueryBuilder.addFieldCondition(ConditionType.AND, COLUMN_FCURRENCY_CODE + "=?", currencyCode.trim());
        List<Currency> list = super.getItemList(sqlQueryBuilder);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public CurrencyPage query(ReqCurrencyOption currencyOption, IndexedPageOption pageOption) throws ErrorInfo, SQLException {
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

        if (currencyOption != null) {
            if (currencyOption.isSetIsBaseCurrency()) {
                sqlQueryBuilder.addFieldCondition(ConditionType.AND, COLUMN_FIS_BASE_CURRENCY + "=?",
                        currencyOption.isBaseCurrency ? 1 : 0);
            }
            if (currencyOption.isSetCurrencyCode()) {
                sqlQueryBuilder.addFieldCondition(ConditionType.AND, COLUMN_FCURRENCY_CODE + "=?",
                        currencyOption.getCurrencyCode().trim());
            }
            if (currencyOption.isSetEnName()) {
                sqlQueryBuilder.addFieldCondition(ConditionType.AND, COLUMN_FEN_NAME + "=?",
                        currencyOption.getEnName().trim());
            }
            if (currencyOption.isSetCnName()) {
                sqlQueryBuilder.addFieldCondition(ConditionType.AND, COLUMN_FCN_NAME + "=?",
                        currencyOption.getCnName().trim());
            }
            if (currencyOption.isSetSymbol()) {
                sqlQueryBuilder.addFieldCondition(ConditionType.AND, COLUMN_FCURRENCY_SYMBOL + "=?",
                        currencyOption.getSymbol().trim());
            }
        }

        CurrencyPage page = new CurrencyPage();
        if (isNeedTotal) {
            page.setTotal(super.getTotalNum(sqlQueryBuilder));
        }
        page.setPage(super.getItemList(sqlQueryBuilder));
        return page;
    }
}
