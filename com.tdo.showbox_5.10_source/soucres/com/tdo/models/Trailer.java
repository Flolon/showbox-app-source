package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Trailers")
public class Trailer extends Model {
    @Column(name = "trailer_id")
    private String mTrailerID;
    @Column(name = "trailer_id_int")
    private int mTrailerIDInt;
    @Column(name = "poster")
    private String poster;
    @Column(name = "title")
    private String title;
    @Column(name = "trailer_type")
    private String type;

    public String getTrailerID() {
        return this.mTrailerID;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setTrailerID(String str) {
        this.mTrailerID = str;
        try {
            this.mTrailerIDInt = Integer.valueOf(str).intValue();
        } catch (Exception e) {
        }
    }

    public int getTrailerIDInt() {
        return this.mTrailerIDInt;
    }

    public void setTrailerIDInt(int i) {
        this.mTrailerIDInt = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String str) {
        this.poster = str;
    }
}
