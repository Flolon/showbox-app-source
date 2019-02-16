package com.tdo.showbox.models;

public class BaseResponse {
    private int code;
    private String cokies;
    private String logs;
    private String response;

    public String getLogs() {
        return this.logs;
    }

    public void setLogs(String str) {
        this.logs = str;
    }

    public String getCokies() {
        return this.cokies;
    }

    public void setCokies(String str) {
        this.cokies = str;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String str) {
        this.response = str;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }
}
