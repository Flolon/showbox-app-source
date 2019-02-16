package com.tdo.showbox.models.videosources;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.tdo.showbox.models.PartVideo;
import java.util.List;

@Table(name = "BaseVideoSource")
public class BaseVideoSource extends Model {
    @Column(name = "cookies")
    protected String cookies = "";
    @Column(name = "full_hd_link")
    protected String full_hd_link;
    @Column(name = "hd_link")
    protected String hd_link = "";
    @Column(name = "low_link")
    protected String low_link = "";
    @Column(name = "mid_link")
    protected String mid_link = "";
    private List<PartVideo> parts = null;
    @Column(name = "priority")
    protected int priority = 0;
    @Column(name = "source_mode_id")
    protected int source_mode_id = 3;
    @Column(name = "source_name")
    protected String source_name = "";
    @Column(name = "static_link")
    protected String static_link = "";

    public boolean checkForValidUrls() {
        if ((getLow_link() == null || getLow_link().length() == 0) && ((getMid_link() == null || getMid_link().length() == 0) && ((getHd_link() == null || getHd_link().length() == 0) && (getFull_hd_link() == null || getFull_hd_link().length() == 0)))) {
            return false;
        }
        return true;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public String getSource_name() {
        return this.source_name;
    }

    public void setSource_name(String str) {
        this.source_name = str;
    }

    public int getSource_mode_id() {
        return this.source_mode_id;
    }

    public void setSource_mode_id(int i) {
        this.source_mode_id = i;
    }

    public String getLow_link() {
        return this.low_link;
    }

    public void setLow_link(String str) {
        this.low_link = str;
    }

    public String getMid_link() {
        return this.mid_link;
    }

    public void setMid_link(String str) {
        this.mid_link = str;
    }

    public String getHd_link() {
        return this.hd_link;
    }

    public void setHd_link(String str) {
        this.hd_link = str;
    }

    public String getStatic_link() {
        return this.static_link;
    }

    public void setStatic_link(String str) {
        this.static_link = str;
    }

    public String getCookies() {
        return this.cookies;
    }

    public void setCookies(String str) {
        this.cookies = str;
    }

    public String getFull_hd_link() {
        return this.full_hd_link;
    }

    public void setFull_hd_link(String str) {
        this.full_hd_link = str;
    }

    public List<PartVideo> getParts() {
        return this.parts;
    }

    public void setParts(List<PartVideo> list) {
        this.parts = list;
    }
}
