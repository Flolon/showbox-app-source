package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import java.util.HashMap;
import java.util.Map;

@Table(name = "AlertInfoMessages")
public class AlertInfoMessage extends Model {
    private Map<String, Object> additionalProperties = new HashMap();
    @Column(name = "alert_text")
    private String alert_text;
    @Column(name = "is_shown")
    private int is_shown;
    @Column(name = "link")
    private String link;
    @Column(name = "message_id")
    private String message_id;

    public int getIs_shown() {
        return this.is_shown;
    }

    public void setIs_shown(int i) {
        this.is_shown = i;
    }

    public String getMessageId() {
        return this.message_id;
    }

    public void setMessageId(String str) {
        this.message_id = str;
    }

    public String getText() {
        return this.alert_text;
    }

    public void setText(String str) {
        this.alert_text = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
