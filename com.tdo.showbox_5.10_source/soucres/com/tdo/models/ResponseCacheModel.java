package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "ResponseCacheModel")
public class ResponseCacheModel extends Model {
    @Column(name = "cache_time")
    private long cache_time;
    @Column(name = "raw_resp")
    private byte[] raw_resp;
    @Column(name = "request_hash")
    private String request_hash;

    public long getCache_time() {
        return this.cache_time;
    }

    public void setCache_time(long j) {
        this.cache_time = j;
    }

    public String getRequest_hash() {
        return this.request_hash;
    }

    public void setRequest_hash(String str) {
        this.request_hash = str;
    }

    public byte[] getRaw_resp() {
        return this.raw_resp;
    }

    public void setRaw_resp(byte[] bArr) {
        this.raw_resp = bArr;
    }
}
