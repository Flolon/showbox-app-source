package com.tdo.showbox.models.topic;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "DelayedPushs")
public class DelayedPush extends Model {
    @Column(name = "data")
    private String data;
    @Column(name = "day_push_delivered")
    private int day_push_delivered;
    @Column(name = "from_topic")
    private String from_topic;
    @Column(name = "hour_push_delivered")
    private int hour_push_delivered;
    @Column(name = "show_when_inet")
    private boolean show_when_inet;

    public int getDay_push_delivered() {
        return this.day_push_delivered;
    }

    public void setDay_push_delivered(int i) {
        this.day_push_delivered = i;
    }

    public int getHour_push_delivered() {
        return this.hour_push_delivered;
    }

    public void setHour_push_delivered(int i) {
        this.hour_push_delivered = i;
    }

    public boolean getShow_when_inet() {
        return this.show_when_inet;
    }

    public void setShow_when_inet(boolean z) {
        this.show_when_inet = z;
    }

    public String getFrom() {
        return this.from_topic;
    }

    public void setFrom(String str) {
        this.from_topic = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }
}
