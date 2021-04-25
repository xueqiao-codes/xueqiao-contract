package com.xueqiao.job.bean;

public class CMCRRecord {

    private String vrtCode;
    private String price;
    private String bp;
    private String vrtName;
    private String vrtEName;
    private String foreignCName;
    private double bpDouble;
    private String approvedTime;
    private String approvedTimeEn;
    private String showDate;
    private String showDateForCn;
    private String lastMonthAvgPrice;
    private String monthPrice;
    private String quarterPrice;
    private String yearPrice;
    private boolean isShowBp;
    private boolean show;
    private String url;
    private String bannerPic;
    private String bannerCss;

    @Override
    public String toString() {
        return "CMCRRecord: "
                +"vrtCode: "+vrtCode
                +" ,price: "+price
                +" ,bp: "+bp
                +" ,vrtName: "+vrtName
                +" ,vrtEName: "+vrtEName
                +" ,foreignCName: "+foreignCName
                +" ,bpDouble: "+bpDouble
                +" ,approvedTime: "+approvedTime
                +" ,approvedTimeEn: "+approvedTimeEn
                +" ,showDate: "+showDate
                +" ,showDateForCn: "+showDateForCn
                +" ,lastMonthAvgPrice: "+lastMonthAvgPrice
                +" ,monthPrice: "+monthPrice
                +" ,quarterPrice: "+quarterPrice
                +" ,yearPrice: "+yearPrice
                +" ,isShowBp: "+isShowBp
                +" ,show: "+show
                +" ,url: "+url
                +" ,bannerPic: "+bannerPic
                +" ,bannerCss: "+bannerCss;
    }

    public String getVrtCode() {
        return vrtCode;
    }

    public void setVrtCode(String vrtCode) {
        this.vrtCode = vrtCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getVrtName() {
        return vrtName;
    }

    public void setVrtName(String vrtName) {
        this.vrtName = vrtName;
    }

    public String getVrtEName() {
        return vrtEName;
    }

    public void setVrtEName(String vrtEName) {
        this.vrtEName = vrtEName;
    }

    public String getForeignCName() {
        return foreignCName;
    }

    public void setForeignCName(String foreignCName) {
        this.foreignCName = foreignCName;
    }

    public double getBpDouble() {
        return bpDouble;
    }

    public void setBpDouble(double bpDouble) {
        this.bpDouble = bpDouble;
    }

    public String getApprovedTime() {
        return approvedTime;
    }

    public void setApprovedTime(String approvedTime) {
        this.approvedTime = approvedTime;
    }

    public String getApprovedTimeEn() {
        return approvedTimeEn;
    }

    public void setApprovedTimeEn(String approvedTimeEn) {
        this.approvedTimeEn = approvedTimeEn;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowDateForCn() {
        return showDateForCn;
    }

    public void setShowDateForCn(String showDateForCn) {
        this.showDateForCn = showDateForCn;
    }

    public String getLastMonthAvgPrice() {
        return lastMonthAvgPrice;
    }

    public void setLastMonthAvgPrice(String lastMonthAvgPrice) {
        this.lastMonthAvgPrice = lastMonthAvgPrice;
    }

    public String getMonthPrice() {
        return monthPrice;
    }

    public void setMonthPrice(String monthPrice) {
        this.monthPrice = monthPrice;
    }

    public String getQuarterPrice() {
        return quarterPrice;
    }

    public void setQuarterPrice(String quarterPrice) {
        this.quarterPrice = quarterPrice;
    }

    public String getYearPrice() {
        return yearPrice;
    }

    public void setYearPrice(String yearPrice) {
        this.yearPrice = yearPrice;
    }

    public boolean isShowBp() {
        return isShowBp;
    }

    public void setShowBp(boolean showBp) {
        isShowBp = showBp;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBannerPic() {
        return bannerPic;
    }

    public void setBannerPic(String bannerPic) {
        this.bannerPic = bannerPic;
    }

    public String getBannerCss() {
        return bannerCss;
    }

    public void setBannerCss(String bannerCss) {
        this.bannerCss = bannerCss;
    }
}
