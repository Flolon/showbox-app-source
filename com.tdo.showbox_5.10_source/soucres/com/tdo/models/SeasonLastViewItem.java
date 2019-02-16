package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "SeasonLastViewItems")
public class SeasonLastViewItem extends Model {
    @Column(name = "last_season")
    private int last_season;
    @Column(name = "movie_id")
    private String movie_id;
    @Column(name = "season_list")
    private String season_list;

    public String getSeason_list() {
        return this.season_list;
    }

    public void setSeason_list(String str) {
        this.season_list = str;
    }

    public int getLast_season() {
        return this.last_season;
    }

    public String getMovie_id() {
        return this.movie_id;
    }

    public void setMovie_id(String str) {
        this.movie_id = str;
    }

    public void setLast_season(int i) {
        this.last_season = i;
    }
}
