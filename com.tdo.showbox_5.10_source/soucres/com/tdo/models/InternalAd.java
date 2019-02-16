package com.tdo.showbox.models;

import java.io.Serializable;

public class InternalAd implements Serializable {
    public static final String BANNER_AD = "banner";
    public static final String FULLSCREEN_AD = "fullscreen";
    public static final String INTERSTITIAL_AD = "interstitial";
    public static final String OWN_RECT_AD = "own_mrec";
    public static final String RECT_AD = "mrec";
    private int ad_for_current_day;
    private String ad_type;
    private String banner;
    private String directVideoUrl;
    private String gender;
    private String geo;
    private int impressions;
    private int isDeleted;
    private String item_id;
    private String link;
    private int max_per_day;
    private int prev_day;
    private int shown_times;
    private String url;
    private String video;

    public void update(InternalAd internalAd) {
        setAd_type(internalAd.getAd_type());
        setItem_id(internalAd.getItem_id());
        setLink(internalAd.getLink());
        setVideo(internalAd.getVideo());
        setBanner(internalAd.getBanner());
        setGender(internalAd.getGender());
        setMax_per_day(internalAd.getMax_per_day());
        setImpressions(internalAd.getImpressions());
        setGeo(internalAd.getGeo());
        setUrl(internalAd.getUrl());
    }

    public String getGeo() {
        return this.geo;
    }

    public void setGeo(String str) {
        this.geo = str;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public int getImpressions() {
        return this.impressions;
    }

    public void setImpressions(int i) {
        this.impressions = i;
    }

    public int getMax_per_day() {
        return this.max_per_day;
    }

    public void setMax_per_day(int i) {
        this.max_per_day = i;
    }

    public String getDirectVideoUrl() {
        return this.directVideoUrl;
    }

    public void setDirectVideoUrl(String str) {
        this.directVideoUrl = str;
    }

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String str) {
        this.video = str;
    }

    public String getBanner() {
        return this.banner;
    }

    public void setBanner(String str) {
        this.banner = str;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public String getAd_type() {
        return this.ad_type;
    }

    public void setAd_type(String str) {
        this.ad_type = str;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setItem_id(String str) {
        this.item_id = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public int getShown_times() {
        return this.shown_times;
    }

    public void setShown_times(int i) {
        this.shown_times = i;
    }

    public int getPrev_day() {
        return this.prev_day;
    }

    public void setPrev_day(int i) {
        this.prev_day = i;
    }

    public int getAd_for_current_day() {
        return this.ad_for_current_day;
    }

    public void setAd_for_current_day(int i) {
        this.ad_for_current_day = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
