package com.tdo.showbox.data.p124a;

import com.iawl.api.ads.sdk.IAWLMediationDefs;
import com.iawl.api.ads.sdk.IAWLNativeAdRequest;
import com.tdo.showbox.models.InternalAd;
import org.json.JSONObject;

/* compiled from: JParserCustomAds */
/* renamed from: com.tdo.showbox.data.a.d */
public class C2981d {
    /* renamed from: a */
    public static InternalAd m16300a(String str, String str2) {
        try {
            return C2981d.m16301a(new JSONObject(str), str2);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static InternalAd m16301a(JSONObject jSONObject, String str) {
        try {
            InternalAd internalAd = new InternalAd();
            internalAd.setAd_type(str);
            if (jSONObject.has("video")) {
                internalAd.setVideo("http://vk.com/" + jSONObject.getString("video"));
            }
            if (jSONObject.has("banner")) {
                internalAd.setBanner(jSONObject.getString("banner"));
            }
            if (jSONObject.has("max_per_day")) {
                internalAd.setMax_per_day(jSONObject.getInt("max_per_day"));
            }
            if (jSONObject.has("impressions")) {
                internalAd.setImpressions(jSONObject.getInt("impressions"));
            }
            if (jSONObject.has("geo")) {
                internalAd.setGeo(jSONObject.getString("geo"));
            }
            if (jSONObject.has(IAWLMediationDefs.KEY_GENDER)) {
                internalAd.setGender(jSONObject.getString(IAWLMediationDefs.KEY_GENDER));
            }
            if (jSONObject.has("url")) {
                internalAd.setUrl(jSONObject.getString("url"));
            }
            if (jSONObject.has(IAWLNativeAdRequest.ASSET_TYPE_LINK)) {
                internalAd.setLink(jSONObject.getString(IAWLNativeAdRequest.ASSET_TYPE_LINK));
            }
            internalAd.setItem_id(jSONObject.getString("id"));
            return internalAd;
        } catch (Exception e) {
            return null;
        }
    }
}
