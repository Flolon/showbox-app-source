package com.tdo.showbox.models;

import java.util.List;

public class UpdatesResponse {
    private List<UpdateItem> movies;
    private int movies_count;
    private String time;
    private int total_count;
    private int tv_count;
    private List<UpdateItem> tvs;

    public int getTotal_count() {
        return this.total_count;
    }

    public void setTotal_count(int i) {
        this.total_count = i;
    }

    public int getTv_count() {
        return this.tv_count;
    }

    public void setTv_count(int i) {
        this.tv_count = i;
    }

    public int getMovies_count() {
        return this.movies_count;
    }

    public void setMovies_count(int i) {
        this.movies_count = i;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public List<UpdateItem> getMovies() {
        return this.movies;
    }

    public void setMovies(List<UpdateItem> list) {
        this.movies = list;
    }

    public List<UpdateItem> getTvs() {
        return this.tvs;
    }

    public void setTvs(List<UpdateItem> list) {
        this.tvs = list;
    }
}
