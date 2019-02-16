package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "DelayedEpisode")
public class DelayedEpisode extends Model {
    @Column(name = "episode")
    private String episode;
    @Column(name = "episodeTitle")
    private String episodeTitle;
    @Column(name = "firstCheckedTime")
    private long firstCheckedTime;
    @Column(name = "imdb")
    private String imdb;
    @Column(name = "season")
    private String season;
    @Column(name = "showPoster")
    private String showPoster;
    @Column(name = "showTitle")
    private String showTitle;

    public String getImdb() {
        return this.imdb;
    }

    public void setImdb(String str) {
        this.imdb = str;
    }

    public long getFirstCheckedTime() {
        return this.firstCheckedTime;
    }

    public void setFirstCheckedTime(long j) {
        this.firstCheckedTime = j;
    }

    public String getShowPoster() {
        return this.showPoster;
    }

    public void setShowPoster(String str) {
        this.showPoster = str;
    }

    public String getShowTitle() {
        return this.showTitle;
    }

    public void setShowTitle(String str) {
        this.showTitle = str;
    }

    public String getSeason() {
        return this.season;
    }

    public void setSeason(String str) {
        this.season = str;
    }

    public String getEpisode() {
        return this.episode;
    }

    public void setEpisode(String str) {
        this.episode = str;
    }

    public String getEpisodeTitle() {
        return this.episodeTitle;
    }

    public void setEpisodeTitle(String str) {
        this.episodeTitle = str;
    }
}
