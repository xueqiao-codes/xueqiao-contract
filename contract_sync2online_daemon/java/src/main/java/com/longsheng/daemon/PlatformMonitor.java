package com.longsheng.daemon;

import com.longsheng.xueqiao.contract.standard.thriftapi.TechPlatformEnv;
import org.soldier.platform.attr.AttrReporterFactory;

import java.util.HashMap;
import java.util.Map;

public class PlatformMonitor {
    private static PlatformMonitor ourInstance = new PlatformMonitor();

    public static PlatformMonitor getInstance() {
        return ourInstance;
    }

    private PlatformMonitor() {
        requestTags.put("method", method);
        requestTags.put("servicekey", serviceKey);
        totalTags.put("servicekey", serviceKey);
    }

    private TechPlatformEnv env;
    private static final String method = "sync2online_contract";
    private static final String serviceKey = "contract_sync2online_daemon";
    private Map<String, String> requestTags = new HashMap();
    private HashMap totalTags = new HashMap();

    public void logPlatformStatis(String countTag, String totalTag) {
        AttrReporterFactory.getDefault().inc(AttrReporterFactory.getDefault().requireKey(countTag, requestTags), 1L);
        AttrReporterFactory.getDefault().inc(AttrReporterFactory.getDefault().requireKey(totalTag, totalTags), 1L);
    }
}
