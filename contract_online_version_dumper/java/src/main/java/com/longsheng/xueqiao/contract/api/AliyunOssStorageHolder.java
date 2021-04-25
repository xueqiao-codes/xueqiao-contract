package com.longsheng.xueqiao.contract.api;

import org.soldier.platform.oss.api.AliyunOssStorage;
import org.soldier.platform.oss.api.OssFailedException;

public class AliyunOssStorageHolder {
	private static AliyunOssStorage sInstance;
	public static AliyunOssStorage get() throws OssFailedException  {
		if (sInstance == null) {
			synchronized(AliyunOssStorageHolder.class) {
				if (sInstance == null) {
					sInstance = new AliyunOssStorage("oss/config");
				}
			}
		}
		return sInstance;
	}
}
