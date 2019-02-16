package com.tdo.showbox.data.p124a;

import com.tdo.showbox.models.AppConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JParserConfig */
/* renamed from: com.tdo.showbox.data.a.c */
public class C2980c {
    /* renamed from: a */
    public static AppConfig m16299a(String str) {
        AppConfig appConfig = new AppConfig();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("fullscreen_type")) {
                appConfig.setFullscreen_type(jSONObject.getString("fullscreen_type"));
            }
            if (jSONObject.has("age_sex_request")) {
                appConfig.setAge_sex_request(jSONObject.getString("age_sex_request"));
            }
            if (jSONObject.has("invalid_video")) {
                appConfig.setInvalid_video(jSONObject.getString("invalid_video"));
            }
            if (jSONObject.has("notfound_video")) {
                appConfig.setNotfound_video(jSONObject.getString("notfound_video"));
            }
            if (jSONObject.has("broken_account")) {
                appConfig.setBroken_account(jSONObject.getString("broken_account"));
            }
            if (jSONObject.has("fullscreen_enabled")) {
                appConfig.setFullscreen_enabled(jSONObject.getString("fullscreen_enabled"));
            }
            if (jSONObject.has("fullscreen_interval")) {
                appConfig.setFullscreen_interval(jSONObject.getString("fullscreen_interval"));
            }
            if (jSONObject.has("db_path")) {
                appConfig.setDb_path(jSONObject.getString("db_path"));
            }
            if (jSONObject.has("srv")) {
                appConfig.setSrv(jSONObject.getString("srv"));
            }
            if (jSONObject.has("upd")) {
                appConfig.setUpd(jSONObject.getString("upd"));
            }
            if (jSONObject.has("version")) {
                appConfig.setVersion(jSONObject.getString("version"));
            }
            if (jSONObject.has("share_link")) {
                appConfig.setShare_link(jSONObject.getString("share_link"));
            }
            if (jSONObject.has("upd_vk")) {
                appConfig.setUpd_vk(jSONObject.getString("upd_vk"));
            }
            if (jSONObject.has("push_topic")) {
                appConfig.setPush_topic(jSONObject.getString("push_topic"));
            }
            if (jSONObject.has("banner_pos_1")) {
                appConfig.setBanner_pos_1(jSONObject.getString("banner_pos_1"));
            }
            if (jSONObject.has("rectangle_pos_1")) {
                appConfig.setRectangle_pos_1(jSONObject.getString("rectangle_pos_1"));
            }
            if (jSONObject.has("rectangle_pos_2")) {
                appConfig.setRectangle_pos_2(jSONObject.getString("rectangle_pos_2"));
            }
            if (jSONObject.has("provider_version")) {
                appConfig.setProvider_version(jSONObject.getString("provider_version"));
            }
            if (jSONObject.has("provider")) {
                appConfig.setProvider(jSONObject.getString("provider"));
            }
            if (jSONObject.has("ads_default")) {
                appConfig.setAds_default(jSONObject.getString("ads_default"));
            }
            if (jSONObject.has("ads_by_country")) {
                appConfig.setAds_by_country(jSONObject.getString("ads_by_country"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        appConfig.setFullscreen_type("preroll");
        return appConfig;
    }
}
