package com.longsheng.daemon;

public class Counter {
    private static Counter ourInstance = new Counter();

    public static Counter getInstance() {
        return ourInstance;
    }

    private int count = 0;

    private Counter() {
    }

    public int getCount() {
        return count;
    }

    public void count() {
        this.count++;
    }
}
