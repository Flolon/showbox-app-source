package com.tdo.showbox.models;

import java.util.ArrayList;
import java.util.List;

public class EpisodeResponse {
    private String banner = "";
    private String cats = "";
    private String description = "";
    private List<Episod> episodes = new ArrayList();
    private String imdb_id = "";
    private int season = 1;
    private String seasons = "";

    public String getCats() {
        return this.cats;
    }

    public void setCats(String str) {
        this.cats = str;
    }

    public String getImdb_id() {
        return this.imdb_id;
    }

    public void setImdb_id(String str) {
        this.imdb_id = str;
    }

    public int getSeason() {
        return this.season;
    }

    public void setSeason(int i) {
        this.season = i;
    }

    public String getSeasons() {
        return this.seasons;
    }

    public void setSeasons(String str) {
        this.seasons = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getBanner() {
        return this.banner;
    }

    public void setBanner(String str) {
        this.banner = str;
    }

    public List<Episod> getEpisodes() {
        return this.episodes;
    }

    public void setEpisodes(List<Episod> list) {
        this.episodes = list;
    }
}
