package com.longsheng.xueqiao.broker.handlers;

import com.antiy.error_code.ErrorCodeInner;
import com.longsheng.xueqiao.broker.config.ConfigurationProperty;
import org.soldier.base.logger.AppLog;
import org.soldier.base.sql.PreparedFields;
import org.soldier.platform.dal_set.DalSetProxy;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class TableHandler {

	protected TServiceCntl oCntl;

	public TableHandler(TServiceCntl oCntl) {
		this.oCntl = oCntl;
	}

	public Connection getConnection() throws ErrorInfo {
		try {
			return DalSetProxy.getInstance().getConnection(ConfigurationProperty.instance().getRoleName(),
					oCntl.getDalSetServiceName(), false, 0);
		} catch (SQLException e) {
			AppLog.e(e.getMessage(), e);
			throw new ErrorInfo(ErrorCodeInner.DB_CONNECT_FAILED.getErrorCode(),
					ErrorCodeInner.DB_CONNECT_FAILED.getErrorMsg());
		}
	}
	
	protected StringBuffer getInsertTableSqlBuffer(String tableName, PreparedFields fields){
		StringBuffer giftTableSqlBuffer = new StringBuffer(128);
		giftTableSqlBuffer.append("INSERT INTO ");
		giftTableSqlBuffer.append(tableName);
		giftTableSqlBuffer.append(" SET ");
		giftTableSqlBuffer.append(fields.getPreparedSql());
		return giftTableSqlBuffer;
	}
	
	protected StringBuffer getTableUpdateSqlBuffer(String tableName,PreparedFields fields) {
		StringBuffer sqlBuffer = new StringBuffer(128);
		sqlBuffer.append("UPDATE ");
		sqlBuffer.append(tableName);
		sqlBuffer.append(" SET ");
		sqlBuffer.append(fields.getPreparedSql());
		sqlBuffer.append(" WHERE ");
		return sqlBuffer;
	}
}
