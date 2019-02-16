package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "News")
public class News extends Model {
    @Column(name = "new_date")
    private String date;
    @Column(name = "head")
    private String head;
    @Column(name = "newId")
    private String newId;
    @Column(name = "newId_int")
    private int newIdInt;
    @Column(name = "pic")
    private String pic;
    @Column(name = "news_type")
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getNewId() {
        return this.newId;
    }

    public void setNewId(String str) {
        this.newId = str;
        try {
            this.newIdInt = Integer.parseInt(str);
        } catch (Exception e) {
        }
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getHead() {
        return this.head;
    }

    public void setHead(String str) {
        this.head = str;
    }

    public String getPic() {
        return this.pic;
    }

    public void setPic(String str) {
        this.pic = str;
    }
}
