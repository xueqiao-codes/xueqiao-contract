package com.longsheng.xueqiao.broker.page;

import java.util.List;

public class Page<T> {

    private int total;
    private List<T> page;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getPage() {
        return page;
    }

    public void setPage(List<T> page) {
        this.page = page;
    }
}
