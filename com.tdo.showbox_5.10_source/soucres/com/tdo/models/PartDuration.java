package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "PartDurations")
public class PartDuration extends Model {
    @Column(name = "duration")
    private long duration;
    @Column(name = "hash")
    private String hash;

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String str) {
        this.hash = str;
    }
}
