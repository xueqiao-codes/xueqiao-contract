package com.longsheng.xueqiao.contract.dao.utils;

import com.google.gson.Gson;

public class GsonFactory {

    private Gson gson;
    private static GsonFactory ourInstance = new GsonFactory();

    public static GsonFactory getInstance() {
        return ourInstance;
    }

    private GsonFactory() {
        gson = new Gson();
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
