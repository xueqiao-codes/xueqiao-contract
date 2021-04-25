package com.xueqiao.job.bean;

public class CMCRHead {

    private String version;
    private String provider;
    private String req_code;
    private String rep_code;
    private String rep_message;
    private long ts;
    private String producer;

    @Override
    public String toString() {
        return "CMCRHead: version:"+version
                + ", provider:"+ provider
                + ", req_code:"+ req_code
                + ", rep_code:"+ rep_code
                + ", rep_message:"+ rep_message
                + ", ts:"+ ts
                + ", producer:"+ producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public String getRep_message() {
        return rep_message;
    }

    public void setRep_message(String rep_message) {
        this.rep_message = rep_message;
    }

    public String getRep_code() {
        return rep_code;
    }

    public void setRep_code(String rep_code) {
        this.rep_code = rep_code;
    }

    public String getReq_code() {
        return req_code;
    }

    public void setReq_code(String req_code) {
        this.req_code = req_code;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
