package com.longsheng.xueqiao.contract.online.dao.provider;

import org.soldier.platform.dal_set.DalSetProxy;

import com.longsheng.xueqiao.contract.dao.provider.DalSetConnectionProvider;
import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;

public class DalSetConnectionProviderFactory implements IConnectionProviderFactory {
	private String roleName;
	
	public DalSetConnectionProviderFactory(String roleName) throws Exception {
		this.roleName = roleName;
		DalSetProxy.getInstance().loadFromXml();
	}

	@Override
	public IConnectionProvider getConnectionProvider(ConnectionContext ctx) {
		return new DalSetConnectionProvider(ctx.getCntl(), roleName, ctx.isReadOnly());
	}
	
}
