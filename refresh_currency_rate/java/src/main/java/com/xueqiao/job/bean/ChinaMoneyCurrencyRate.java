package com.xueqiao.job.bean;

import java.util.List;

public class ChinaMoneyCurrencyRate {

    private CMCRHead head;
    private CMCRData data;
    private List<CMCRRecord> records;

    @Override
    public String toString() {
        return "ChinaMoneyCurrencyRate: "
                + " head: " + head
                + " ,data： " + data
                + " ,records: " + records;
    }

    public CMCRHead getHead() {
        return head;
    }

    public void setHead(CMCRHead head) {
        this.head = head;
    }

    public CMCRData getData() {
        return data;
    }

    public void setData(CMCRData data) {
        this.data = data;
    }

    public List<CMCRRecord> getRecords() {
        return records;
    }

    public void setRecords(List<CMCRRecord> records) {
        this.records = records;
    }
}
