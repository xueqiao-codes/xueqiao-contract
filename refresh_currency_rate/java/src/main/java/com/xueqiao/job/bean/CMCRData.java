package com.xueqiao.job.bean;

public class CMCRData {
    private String lastDateEn;
    private String lastDate;
    private String pairChange;

    @Override
    public String toString() {
        return "CMCRData: "
                +"lastDateEn: "+lastDateEn
                +", lastDate: "+lastDate
                +", pairChange: "+pairChange;
    }

    public String getLastDateEn() {
        return lastDateEn;
    }

    public void setLastDateEn(String lastDateEn) {
        this.lastDateEn = lastDateEn;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getPairChange() {
        return pairChange;
    }

    public void setPairChange(String pairChange) {
        this.pairChange = pairChange;
    }
}
