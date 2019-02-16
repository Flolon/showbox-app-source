package com.tdo.showbox.models.topic;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "FbTopics")
public class FbTopic extends Model {
    @Column(name = "name")
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
