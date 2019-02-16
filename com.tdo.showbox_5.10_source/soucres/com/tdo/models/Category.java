package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Categories")
public class Category extends Model {
    @Column(name = "cat_id")
    private String cat_id;
    @Column(name = "name")
    private String name;

    public String getCatId() {
        return this.cat_id;
    }

    public void setCatId(String str) {
        this.cat_id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
