package com.tdo.showbox.models.topic;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "TopicTimeItems")
public class TopicTimeItem extends Model {
    @Column(name = "dayNumber")
    private int dayNumber;
    @Column(name = "hourTime")
    private int hourTime;
    @Column(name = "logTime")
    private long logTime;

    public int getDay() {
        return this.dayNumber;
    }

    public void setDay(int i) {
        this.dayNumber = i;
    }

    public int getTime() {
        return this.hourTime;
    }

    public void setTime(int i) {
        this.hourTime = i;
    }

    public long getLogTime() {
        return this.logTime;
    }

    public void setLogTime(long j) {
        this.logTime = j;
    }
}
