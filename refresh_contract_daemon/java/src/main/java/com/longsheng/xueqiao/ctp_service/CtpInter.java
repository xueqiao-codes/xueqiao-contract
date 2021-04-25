package com.longsheng.xueqiao.ctp_service;

public class CtpInter {

    private CtpAccount ctpAccount;

    public CtpInter(){

    }

    public boolean dataCache(){
        return true;
    }
    public CtpAccount getCtpAccount() {
        return ctpAccount;
    }



    public void setCtpAccount(CtpAccount ctpAccount) {
        this.ctpAccount = ctpAccount;
    }
}
