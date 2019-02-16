package com.tdo.showbox.models;

import android.os.Bundle;

public class VideoParams {
    private Bundle args;
    private long id;
    private boolean isOffline;
    private String link;
    private long pos;
    private Subtitle subtitle;
    private String videoName;

    public Subtitle getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(Subtitle subtitle) {
        this.subtitle = subtitle;
    }

    public String getVideoName() {
        return this.videoName;
    }

    public void setVideoName(String str) {
        this.videoName = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public long getPos() {
        return this.pos;
    }

    public void setPos(long j) {
        this.pos = j;
    }

    public boolean isOffline() {
        return this.isOffline;
    }

    public void setOffline(boolean z) {
        this.isOffline = z;
    }

    public Bundle getArgs() {
        return this.args;
    }

    public void setArgs(Bundle bundle) {
        this.args = bundle;
    }
}
