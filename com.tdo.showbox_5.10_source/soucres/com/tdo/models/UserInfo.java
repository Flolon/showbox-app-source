package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "UserInfos")
public class UserInfo extends Model {
    @Column(name = "age")
    private String age;
    @Column(name = "deviceID")
    private String deviceID;
    @Column(name = "gender")
    private String gender;
    @Column(name = "lang")
    private String lang;

    public String getAge() {
        return this.age;
    }

    public void setAge(String str) {
        this.age = str;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public void setDeviceID(String str) {
        this.deviceID = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }
}
