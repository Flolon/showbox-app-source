package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "ViewedEpizodes")
public class ViewedEpizode extends Model {
    @Column(name = "episode_id")
    private long episode_id;
    @Column(name = "mov_id")
    private long mov_id;
    @Column(name = "season_num")
    private long season_num;

    public long getEpisode_id() {
        return this.episode_id;
    }

    public void setEpisode_id(long j) {
        this.episode_id = j;
    }

    public long getSeason_num() {
        return this.season_num;
    }

    public void setSeason_num(long j) {
        this.season_num = j;
    }

    public long getMov_id() {
        return this.mov_id;
    }

    public void setMov_id(long j) {
        this.mov_id = j;
    }
}
