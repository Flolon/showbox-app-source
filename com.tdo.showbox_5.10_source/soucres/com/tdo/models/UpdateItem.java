package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "UpdateItems")
public class UpdateItem extends Model {
    @Column(name = "date_item")
    private String date_item;
    @Column(name = "date_ms")
    private long date_ms;
    @Column(name = "is_movie")
    private int is_movie;
    @Column(name = "is_viewed")
    private int is_viewed;
    @Column(name = "item_id_")
    private String item_id;
    @Column(name = "poster")
    private String poster;
    @Column(name = "title")
    private String title;

    public long getDate_ms() {
        return this.date_ms;
    }

    public void setDate_ms(long j) {
        this.date_ms = j;
    }

    public int getIs_viewed() {
        return this.is_viewed;
    }

    public void setIs_viewed(int i) {
        this.is_viewed = i;
    }

    public int getIs_movie() {
        return this.is_movie;
    }

    public void setIs_movie(int i) {
        this.is_movie = i;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setItem_id(String str) {
        this.item_id = str;
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

    public String getDate() {
        return this.date_item;
    }

    public void setDate(String str) {
        this.date_item = str;
    }
}
