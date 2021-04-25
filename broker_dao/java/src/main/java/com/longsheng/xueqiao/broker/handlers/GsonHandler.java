package com.longsheng.xueqiao.broker.handlers;

import com.google.gson.Gson;

public class GsonHandler {
    private static GsonHandler ourInstance = new GsonHandler();

    private Gson gson;

    public static GsonHandler getInstance() {
        return ourInstance;
    }

    private GsonHandler() {
        gson = new Gson();
    }

    public Gson getGson() {
        return gson;
    }
}
