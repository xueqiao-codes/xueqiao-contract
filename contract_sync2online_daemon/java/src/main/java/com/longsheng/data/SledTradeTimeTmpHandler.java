package com.longsheng.data;

import com.antiy.error_code.ErrorCodeOuter;
import com.longsheng.table.TableSledTradeTimeTmp;
import com.longsheng.utils.CompactFactory;
import com.longsheng.utils.DaoUtil;
import com.longsheng.xueqiao.contract.thriftapi.ReqSledTradeTimeOption;
import com.longsheng.xueqiao.contract.thriftapi.SledTradeTime;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.AbstractListHandler;
import org.apache.commons.io.IOUtils;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.base.sql.SqlQueryBuilder;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.util.ProtocolUtil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SledTradeTimeTmpHandler extends TableHandler {


    public SledTradeTimeTmpHandler(Connection connection, QueryRunner runner) throws ErrorInfo {
        super(connection, runner);
    }

    public void batInsert(List<SledTradeTime> sledTradeTimes) throws ErrorInfo, SQLException {

        List<PreparedSql> list = new ArrayList<>();
        for (SledTradeTime sledTradeTime : sledTradeTimes) {

            if (sledTradeTime.getSledCommodityId() <= 0) {
                throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "SledCommodityId must set.");
            }
            PreparedSql preparedSql = new PreparedSql();
            int createTime = (int) (System.currentTimeMillis() / 1000);
            PreparedFields fields = prepareFields(sledTradeTime);

            if (fields.getSize() == 0) {
                throw new ErrorInfo(ErrorCodeOuter.PARAM_ERROR.getErrorCode(), "TSledExchange fields must set.");
            }

            fields.addInt(TableSledTradeTimeTmp.COLUMN_FSLED_COMMODITY_ID, sledTradeTime.getSledCommodityId());
            fields.addInt(TableSledTradeTimeTmp.COLUMN_FCREATE_TIMESTAMP, createTime);
            fields.addInt(TableSledTradeTimeTmp.COLUMN_FLAST_MODIFY_TIMESTAMP, createTime);
            StringBuffer insertSqlBuffer = getInsertTableSqlBuffer(TableSledTradeTimeTmp.TABLE_NAME, fields);
            preparedSql.preparedFields = fields;
            preparedSql.sqlBuffer = insertSqlBuffer;
            list.add(preparedSql);
        }
        String deleteSql = "delete from " + TableSledTradeTimeTmp.TABLE_NAME + " where 1=?";
        runner.update(conn, deleteSql, 1);
        for (PreparedSql preparedSql : list) {
            runner.update(conn, preparedSql.sqlBuffer.toString(), preparedSql.preparedFields.getParameters());
        }
    }

    private class PreparedSql {
        public StringBuffer sqlBuffer;
        public PreparedFields preparedFields;
    }

    private PreparedFields prepareFields(SledTradeTime sledTradeTime) {
        PreparedFields fields = new PreparedFields();
        if (sledTradeTime.isSetZoneId()) {
            fields.addString(TableSledTradeTimeTmp.COLUMN_FZONE_ID, sledTradeTime.getZoneId());
        }
        if (sledTradeTime.isSetDateTimeSpans()) {
            ByteBuffer data = ProtocolUtil.serialize(CompactFactory.getInstance().getFactory(), sledTradeTime);
            Blob blob = null;
            try {
                blob = new javax.sql.rowset.serial.SerialBlob(data.array());
            } catch (SQLException e) {
                AppLog.e(e.getMessage(), e);
            }
            if (blob != null) {
                fields.addBlob(TableSledTradeTimeTmp.COLUMN_FTMP_TRADE_TIMES, blob);
            }
        }
        return fields;
    }

    private SqlQueryBuilder createSqlBuilder() {
        SqlQueryBuilder sqlBuilder = new SqlQueryBuilder();
        sqlBuilder.addFields(
                TableSledTradeTimeTmp.COLUMN_FSLED_COMMODITY_ID,
                TableSledTradeTimeTmp.COLUMN_FZONE_ID,
                TableSledTradeTimeTmp.COLUMN_FTMP_TRADE_TIMES,
                TableSledTradeTimeTmp.COLUMN_FCREATE_TIMESTAMP,
                TableSledTradeTimeTmp.COLUMN_FLAST_MODIFY_TIMESTAMP);
        sqlBuilder.addTables(TableSledTradeTimeTmp.TABLE_NAME);
        return sqlBuilder;
    }

    public List<SledTradeTime> query(ReqSledTradeTimeOption option, int pageIndex, int pageSize) throws ErrorInfo, SQLException {
        SqlQueryBuilder sqlBuilder = createSqlBuilder();
        if (option.isSetSledCommodityIds() && option.getSledCommodityIdsSize() > 0) {
            sqlBuilder.addInFieldCondition(SqlQueryBuilder.ConditionType.AND, TableSledTradeTimeTmp.COLUMN_FSLED_COMMODITY_ID,
                    DaoUtil.map2Set(option.getSledCommodityIds()));
        }
        sqlBuilder.setPage(pageIndex, pageSize);
        return runner.query(conn, sqlBuilder.getItemsSql(), new TSledTradeTimeHandler(),
                sqlBuilder.getParameterList());
    }


    private class TSledTradeTimeHandler extends AbstractListHandler<SledTradeTime> {

        @Override
        protected SledTradeTime handleRow(ResultSet rs) throws SQLException {
            SledTradeTime config = new SledTradeTime();
            config.setSledCommodityId(rs.getInt(TableSledTradeTimeTmp.COLUMN_FSLED_COMMODITY_ID));
            config.setZoneId(rs.getString(TableSledTradeTimeTmp.COLUMN_FZONE_ID));

            Blob data = rs.getBlob(TableSledTradeTimeTmp.COLUMN_FTMP_TRADE_TIMES);
            InputStream is = data.getBinaryStream();

            byte[] bytes = null;
            try {
                bytes = IOUtils.toByteArray(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (bytes != null) {
                SledTradeTime sledTradeTime = ProtocolUtil.unSerialize(CompactFactory.getInstance().getFactory(), bytes, SledTradeTime.class);
                if (sledTradeTime != null) {
                    config.setDateTimeSpans(sledTradeTime.getDateTimeSpans());
                }
            }
            return config;
        }
    }
}
