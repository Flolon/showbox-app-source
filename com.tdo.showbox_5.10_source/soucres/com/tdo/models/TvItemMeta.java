package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "TvItemMetas")
public class TvItemMeta extends Model {
    @Column(name = "cats")
    private String cats = "";
    @Column(name = "description")
    private String description = "";
    @Column(name = "imdb_id")
    private String imdb_id;
    @Column(name = "item_id")
    private String item_id;
    @Column(name = "last_cached_time")
    private long last_cached_time;
    @Column(name = "prefered_server_id")
    private int prefered_server_id = -1;
    @Column(name = "push_topic")
    private String push_topic;
    @Column(name = "removed_from_lib")
    private int removed_from_lib;

    public String getImdb_id() {
        return this.imdb_id;
    }

    public void setImdb_id(String str) {
        this.imdb_id = str;
    }

    public String getPush_topic() {
        return this.push_topic;
    }

    public void setPush_topic(String str) {
        this.push_topic = str;
    }

    public long getLast_cached_time() {
        return this.last_cached_time;
    }

    public void setLast_cached_time(long j) {
        this.last_cached_time = j;
    }

    public int getPrefered_server_id() {
        return this.prefered_server_id;
    }

    public void setPrefered_server_id(int i) {
        this.prefered_server_id = i;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setItem_id(String str) {
        this.item_id = str;
    }

    public int getRemoved_from_lib() {
        return this.removed_from_lib;
    }

    public void setRemoved_from_lib(int i) {
        this.removed_from_lib = i;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getCats() {
        return this.cats;
    }

    public void setCats(String str) {
        this.cats = str;
    }
}
