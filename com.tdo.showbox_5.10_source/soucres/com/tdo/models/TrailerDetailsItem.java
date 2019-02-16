package com.tdo.showbox.models;

public class TrailerDetailsItem {
    private String date;
    private String id;
    private String link;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getYoutubeLink() {
        try {
            return String.format("http://img.youtube.com/vi/%s/0.jpg", new Object[]{getLink()});
        } catch (Exception e) {
            return null;
        }
    }
}
