package com.longsheng.xueqiao.contract;

import java.io.File;

import org.soldier.base.logger.AppLog;

import com.longsheng.xueqiao.contract.api.VersionDumper;

public class DaemonMain {
	
	public static void main(String[] args) throws Exception {
		VersionDumper dumper = new VersionDumper();
		while(true) {
			try {
				dumper.runOnce();
				Thread.sleep(60000);
			}  catch (Throwable e) {
				AppLog.e(e.getMessage(), e);
				Thread.sleep(15000);
			}
		}
	}
}
