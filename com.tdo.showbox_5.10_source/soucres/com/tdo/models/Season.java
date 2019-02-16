package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Seasons")
public class Season extends Model {
    @Column(name = "banner")
    private String banner;
    @Column(name = "description")
    private String description;
    @Column(name = "movie_id")
    private String movie_id;
    @Column(name = "num")
    private String num;

    public String getBanner() {
        return this.banner;
    }

    public void setBanner(String str) {
        this.banner = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getMovieId() {
        return this.movie_id;
    }

    public void setMovieId(String str) {
        this.movie_id = str;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String str) {
        this.num = str;
    }
}
