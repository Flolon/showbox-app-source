package com.tdo.showbox.models.topic;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "CurrentTopicSchemes")
public class CurrentTopicScheme extends Model {
    @Column(name = "day1time")
    private int day1time = 1;
    @Column(name = "day2time")
    private int day2time = 1;
    @Column(name = "day3time")
    private int day3time = 1;
    @Column(name = "day4time")
    private int day4time = 1;
    @Column(name = "day5time")
    private int day5time = 1;
    @Column(name = "day6time")
    private int day6time = 1;
    @Column(name = "day7time")
    private int day7time = 1;
    @Column(name = "dayPreviousNumber")
    private int dayPreviousNumber = 0;
    @Column(name = "dayPreviousTime")
    private int dayPreviousTime = 0;

    public int getOptimalTimeForDay(int i) {
        switch (i) {
            case 1:
                return getDay1time();
            case 2:
                return getDay2time();
            case 3:
                return getDay3time();
            case 4:
                return getDay4time();
            case 5:
                return getDay5time();
            case 6:
                return getDay6time();
            case 7:
                return getDay7time();
            default:
                return 1;
        }
    }

    public boolean setTimeForDay(TopicTimeItem topicTimeItem) {
        int time = topicTimeItem.getTime();
        int day1time;
        switch (topicTimeItem.getDay()) {
            case 1:
                day1time = getDay1time();
                if (day1time != time) {
                    this.dayPreviousTime = day1time;
                    this.dayPreviousNumber = topicTimeItem.getDay();
                    setDay1time(time);
                    return true;
                }
                break;
            case 2:
                day1time = getDay2time();
                if (day1time != time) {
                    this.dayPreviousTime = day1time;
                    this.dayPreviousNumber = topicTimeItem.getDay();
                    setDay2time(time);
                    return true;
                }
                break;
            case 3:
                day1time = getDay3time();
                if (day1time != time) {
                    this.dayPreviousTime = day1time;
                    this.dayPreviousNumber = topicTimeItem.getDay();
                    setDay3time(time);
                    return true;
                }
                break;
            case 4:
                day1time = getDay4time();
                if (day1time != time) {
                    this.dayPreviousTime = day1time;
                    this.dayPreviousNumber = topicTimeItem.getDay();
                    setDay4time(time);
                    return true;
                }
                break;
            case 5:
                day1time = getDay5time();
                if (day1time != time) {
                    this.dayPreviousTime = day1time;
                    this.dayPreviousNumber = topicTimeItem.getDay();
                    setDay5time(time);
                    return true;
                }
                break;
            case 6:
                day1time = getDay6time();
                if (day1time != time) {
                    this.dayPreviousTime = day1time;
                    this.dayPreviousNumber = topicTimeItem.getDay();
                    setDay6time(time);
                    return true;
                }
                break;
            case 7:
                day1time = getDay7time();
                if (day1time != time) {
                    this.dayPreviousTime = day1time;
                    this.dayPreviousNumber = topicTimeItem.getDay();
                    setDay7time(time);
                    return true;
                }
                break;
        }
        return false;
    }

    public int getDayPreviousNumber() {
        return this.dayPreviousNumber;
    }

    public void setDayPreviousNumber(int i) {
        this.dayPreviousNumber = i;
    }

    public int getDay1time() {
        return this.day1time;
    }

    public void setDay1time(int i) {
        this.day1time = i;
    }

    public int getDay2time() {
        return this.day2time;
    }

    public void setDay2time(int i) {
        this.day2time = i;
    }

    public int getDay3time() {
        return this.day3time;
    }

    public void setDay3time(int i) {
        this.day3time = i;
    }

    public int getDay4time() {
        return this.day4time;
    }

    public void setDay4time(int i) {
        this.day4time = i;
    }

    public int getDay5time() {
        return this.day5time;
    }

    public void setDay5time(int i) {
        this.day5time = i;
    }

    public int getDay6time() {
        return this.day6time;
    }

    public void setDay6time(int i) {
        this.day6time = i;
    }

    public int getDay7time() {
        return this.day7time;
    }

    public void setDay7time(int i) {
        this.day7time = i;
    }

    public int getDayPreviousTime() {
        return this.dayPreviousTime;
    }

    public void setDayPreviousTime(int i) {
        this.dayPreviousTime = i;
    }
}
