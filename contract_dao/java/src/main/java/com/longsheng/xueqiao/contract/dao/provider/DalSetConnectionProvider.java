package com.longsheng.xueqiao.contract.dao.provider;

import java.sql.Connection;

import com.longsheng.xueqiao.contract.dao.config.ConfigurationProperty;
import org.soldier.base.logger.AppLog;
import org.soldier.platform.dal_set.DalSetDataSource;
import org.soldier.platform.dal_set.DalSetProxy;
import org.soldier.platform.svr_platform.comm.ErrorInfo;
import org.soldier.platform.svr_platform.container.TServiceCntl;

import com.antiy.error_code.ErrorCodeInner;

import javax.sql.DataSource;

public class DalSetConnectionProvider implements IConnectionProvider {

	private TServiceCntl oCntl;
	private String roleName;
	private boolean readOnly;
	
	public DalSetConnectionProvider(TServiceCntl oCntl, String roleName) {
		this(oCntl, roleName, false);
	}
	
    public DalSetConnectionProvider(TServiceCntl oCntl
    		, String roleName
    		, boolean readOnly){
    	this.oCntl = oCntl;
    	this.roleName = roleName;
    	this.readOnly = readOnly;
    }

    @Override
    public Connection getConnection() throws ErrorInfo {
    	try {
			return DalSetProxy.getInstance().getConnection(roleName, oCntl.getDalSetServiceName(), readOnly, 0);
		} catch (Throwable e) {
			AppLog.e(e.getMessage(), e);
			throw new ErrorInfo(ErrorCodeInner.DB_CONNECT_FAILED.getErrorCode()
					, ErrorCodeInner.DB_CONNECT_FAILED.getErrorMsg());
		}
    }

    public DalSetDataSource getDalSetDataSource(){
		return new DalSetDataSource(ConfigurationProperty.instance().getRoleName(), oCntl.getDalSetServiceName(), false, 0);
	}
}
