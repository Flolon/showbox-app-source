package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Column.ConflictAction;
import com.activeandroid.annotation.Table;

@Table(name = "LanguageRating")
public class LanguageRating extends Model {
    @Column(name = "is_pop")
    private int is_pop;
    @Column(name = "lang", onUniqueConflicts = {ConflictAction.REPLACE}, uniqueGroups = {"group1"})
    private String lang;
    @Column(name = "langID", onUniqueConflicts = {ConflictAction.REPLACE}, uniqueGroups = {"group1"})
    private String langID;
    @Column(name = "rating")
    private int rating;

    public LanguageRating(String str, String str2) {
        this.langID = str2;
        this.lang = str;
    }

    public int getIs_pop() {
        return this.is_pop;
    }

    public void setIs_pop(int i) {
        this.is_pop = i;
    }

    public String getLangID() {
        return this.langID;
    }

    public void setLangID(String str) {
        this.langID = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int i) {
        this.rating = i;
    }

    public void incrisRaing() {
        this.rating++;
    }
}
