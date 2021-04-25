package com.longsheng.xueqiao.contract.online.dao.provider;

import org.soldier.platform.svr_platform.container.TServiceCntl;

import com.longsheng.xueqiao.contract.dao.provider.IConnectionProvider;

public interface IConnectionProviderFactory {
	public static class ConnectionContext {
		private TServiceCntl oCntl;
		private boolean readOnly;
		
		public ConnectionContext(TServiceCntl oCntl) {
			this(oCntl, false);
		}
		
		public ConnectionContext(TServiceCntl oCntl, boolean readOnly) {
			this.oCntl = oCntl;
			this.readOnly = readOnly;
		}
		
		public TServiceCntl getCntl() {
			return oCntl;
		}
		public void setCntl(TServiceCntl oCntl) {
			this.oCntl = oCntl;
		}
		
		public boolean isReadOnly() {
			return readOnly;
		}
		public void setReadOnly(boolean readOnly) {
			this.readOnly = readOnly;
		}
		
	}
	
	public IConnectionProvider getConnectionProvider(ConnectionContext ctx);
}
