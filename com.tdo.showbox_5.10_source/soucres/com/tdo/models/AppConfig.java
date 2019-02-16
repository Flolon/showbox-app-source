package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Table(name = "AppConfiguration")
public class AppConfig extends Model {
    private Map<String, Object> additionalProperties = new HashMap();
    @Column(name = "ads_by_country")
    private String ads_by_country;
    @Column(name = "ads_default")
    private String ads_default;
    @Column(name = "age_sex_request")
    private String age_sex_request;
    @Column(name = "banner_pos_1")
    private String banner_pos_1;
    @Column(name = "broken_account")
    private String broken_account;
    @Column(name = "db_path")
    private String db_path;
    @Column(name = "fullscreen_enabled")
    private String fullscreen_enabled;
    @Column(name = "fullscreen_interval")
    private String fullscreen_interval;
    @Column(name = "fullscreen_type")
    private String fullscreen_type;
    @Column(name = "invalid_video")
    private String invalid_video;
    @Column(name = "notfound_video")
    private String notfound_video;
    @Column(name = "provider")
    private String provider;
    @Column(name = "provider_version")
    private String provider_version;
    @Column(name = "push_topic")
    private String push_topic;
    @Column(name = "rectangle_pos_1")
    private String rectangle_pos_1;
    @Column(name = "rectangle_pos_2")
    private String rectangle_pos_2;
    @Column(name = "share_link")
    private String share_link;
    @Column(name = "srv")
    private String srv;
    @Column(name = "upd")
    private String upd;
    @Column(name = "upd_vk")
    private String upd_vk;
    @Column(name = "version")
    private String version;

    public String getNotfound_video() {
        return this.notfound_video;
    }

    public void setNotfound_video(String str) {
        this.notfound_video = str;
    }

    public String getPush_topic() {
        return this.push_topic;
    }

    public void setPush_topic(String str) {
        this.push_topic = str;
    }

    public String getBroken_account() {
        return this.broken_account;
    }

    public void setBroken_account(String str) {
        this.broken_account = str;
    }

    public String getInvalid_video() {
        return this.invalid_video;
    }

    public void setInvalid_video(String str) {
        this.invalid_video = str;
    }

    public String getFullscreen_type() {
        if (this.fullscreen_type == null) {
            this.fullscreen_type = "";
        }
        return this.fullscreen_type;
    }

    public String getUpd_vk() {
        return this.upd_vk;
    }

    public void setUpd_vk(String str) {
        this.upd_vk = str;
    }

    public boolean isEqual(AppConfig appConfig) {
        boolean z = true;
        try {
            if (!appConfig.getUpd_vk().equals(getUpd_vk())) {
                z = false;
            }
            if (!appConfig.getFullscreen_enabled().equals(getFullscreen_enabled())) {
                z = false;
            }
            if (!appConfig.getAge_sex_request().equals(getAge_sex_request())) {
                z = false;
            }
            if (!appConfig.getFullscreen_interval().equals(getFullscreen_interval())) {
                z = false;
            }
            if (!appConfig.getFullscreen_type().equals(getFullscreen_type())) {
                z = false;
            }
            if (!appConfig.getShare_link().equals(getShare_link())) {
                z = false;
            }
            if (!appConfig.getSrv().equals(getSrv())) {
                z = false;
            }
            if (!appConfig.getUpd().equals(getUpd())) {
                z = false;
            }
            if (!appConfig.getVersion().equals(getVersion())) {
                z = false;
            }
            if (!appConfig.getDb_path().equals(getDb_path())) {
                z = false;
            }
            if (!appConfig.getNotfound_video().equals(getNotfound_video())) {
                z = false;
            }
            if (!appConfig.getPush_topic().equals(getPush_topic())) {
                z = false;
            }
            if (!appConfig.getBanner_pos_1().equals(getBanner_pos_1())) {
                z = false;
            }
            if (!appConfig.getRectangle_pos_1().equals(getRectangle_pos_1())) {
                z = false;
            }
            if (!appConfig.getRectangle_pos_2().equals(getRectangle_pos_2())) {
                z = false;
            }
            if (!appConfig.getProvider().equals(getProvider())) {
                z = false;
            }
            if (!appConfig.getProvider_version().equals(getProvider_version())) {
                z = false;
            }
            if (!appConfig.getAds_default().equals(getAds_default())) {
                z = false;
            }
            if (appConfig.getAds_by_country().equals(getAds_by_country())) {
                return z;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void setFullscreen_type(String str) {
        this.fullscreen_type = str;
    }

    public String getAge_sex_request() {
        return this.age_sex_request;
    }

    public void setAge_sex_request(String str) {
        this.age_sex_request = str;
    }

    public String getFullscreen_enabled() {
        return this.fullscreen_enabled;
    }

    public void setFullscreen_enabled(String str) {
        this.fullscreen_enabled = str;
    }

    public String getFullscreen_interval() {
        return this.fullscreen_interval;
    }

    public void setFullscreen_interval(String str) {
        this.fullscreen_interval = str;
    }

    public String getSrv() {
        return this.srv;
    }

    public void setSrv(String str) {
        this.srv = str;
    }

    public String getUpd() {
        return this.upd;
    }

    public void setUpd(String str) {
        this.upd = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getShare_link() {
        return this.share_link;
    }

    public void setShare_link(String str) {
        this.share_link = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }

    public String getDb_path() {
        return this.db_path;
    }

    public void setDb_path(String str) {
        this.db_path = str;
    }

    public static final int getDefaultSelectSource(List<BaseVideoSource> list) {
        int i;
        switch (3) {
            case 3:
                for (i = 0; i < list.size(); i++) {
                    if (((BaseVideoSource) list.get(i)).getSource_mode_id() == 2) {
                        return i;
                    }
                }
                break;
            case 7:
                for (i = 0; i < list.size(); i++) {
                    if (((BaseVideoSource) list.get(i)).getSource_mode_id() == 7) {
                        return i;
                    }
                }
                break;
            case 10:
                for (i = 0; i < list.size(); i++) {
                    if (((BaseVideoSource) list.get(i)).getSource_mode_id() == 10) {
                        return i;
                    }
                }
                break;
        }
        return 0;
    }

    public boolean isValid() {
        try {
            if (getUpd_vk().length() <= 0 || getVersion().length() <= 0 || getSrv().length() <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getBanner_pos_1() {
        return this.banner_pos_1;
    }

    public void setBanner_pos_1(String str) {
        this.banner_pos_1 = str;
    }

    public String getRectangle_pos_1() {
        return this.rectangle_pos_1;
    }

    public void setRectangle_pos_1(String str) {
        this.rectangle_pos_1 = str;
    }

    public String getRectangle_pos_2() {
        return this.rectangle_pos_2;
    }

    public void setRectangle_pos_2(String str) {
        this.rectangle_pos_2 = str;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public String getProvider_version() {
        return this.provider_version;
    }

    public void setProvider_version(String str) {
        this.provider_version = str;
    }

    public String getAds_default() {
        return this.ads_default;
    }

    public void setAds_default(String str) {
        this.ads_default = str;
    }

    public String getAds_by_country() {
        return this.ads_by_country;
    }

    public void setAds_by_country(String str) {
        this.ads_by_country = str;
    }
}
