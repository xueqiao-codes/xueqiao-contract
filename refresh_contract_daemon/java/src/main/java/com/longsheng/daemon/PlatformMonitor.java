package com.longsheng.daemon;

import org.soldier.platform.attr.AttrReporterFactory;

import java.util.HashMap;
import java.util.Map;

public class PlatformMonitor {
    private static PlatformMonitor ourInstance = new PlatformMonitor();

    public static PlatformMonitor getInstance() {
        return ourInstance;
    }

    private Map<String, String> requestTags = new HashMap();

    public void logPlatformStatis(String countTag) {
        AttrReporterFactory.getDefault().inc(AttrReporterFactory.getDefault().requireKey(countTag, requestTags), 1L);
    }
}
