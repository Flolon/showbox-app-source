package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "NewsDetails")
public class NewsDetails extends Model {
    @Column(name = "html")
    private byte[] html;
    @Column(name = "newId")
    private String newId;

    public String getNewId() {
        return this.newId;
    }

    public void setNewId(String str) {
        this.newId = str;
    }

    public byte[] getHtml() {
        return this.html;
    }

    public void setHtml(byte[] bArr) {
        this.html = bArr;
    }
}
