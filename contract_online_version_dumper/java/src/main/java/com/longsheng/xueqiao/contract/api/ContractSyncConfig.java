package com.longsheng.xueqiao.contract.api;

import net.qihoo.qconf.Qconf;
import net.qihoo.qconf.QconfException;
import org.soldier.base.AES;

import com.google.gson.Gson;

public class ContractSyncConfig {
	
	private static final String SDK_KEY = "@contract_sync@#";
	
	private String host;
	private String userName;
	private String userPasswd;
	
	private String dbName;
	
	public static ContractSyncConfig readConfig() {
		try {
			String json = Qconf.getConf("xueqiao/contract/contract_sync.json");
			ContractSyncConfig config =  new Gson().fromJson(json, ContractSyncConfig.class);
			config.setUserPasswd(AES.decrypt(config.getUserPasswd(), SDK_KEY));
			return config;
		} catch (QconfException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPasswd() {
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
}
