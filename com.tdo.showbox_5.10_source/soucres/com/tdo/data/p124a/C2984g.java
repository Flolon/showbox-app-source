package com.tdo.showbox.data.p124a;

import com.iawl.api.ads.sdk.IAWLNativeAdRequest;
import com.tdo.showbox.models.TvItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JParserShows */
/* renamed from: com.tdo.showbox.data.a.g */
public class C2984g {
    /* renamed from: a */
    public static final List<TvItem> m16306a(String str) {
        List<TvItem> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                TvItem a = C2984g.m16305a(jSONArray.getJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: a */
    public static final TvItem m16305a(JSONObject jSONObject) {
        try {
            TvItem tvItem = new TvItem();
            if (jSONObject.has("id")) {
                tvItem.setId(jSONObject.getString("id"));
            }
            if (jSONObject.has("imdb_id")) {
                tvItem.setImdb_id(jSONObject.getString("imdb_id"));
            }
            if (jSONObject.has(IAWLNativeAdRequest.ASSET_TYPE_TITLE)) {
                tvItem.setTitle(jSONObject.getString(IAWLNativeAdRequest.ASSET_TYPE_TITLE));
            }
            if (jSONObject.has("poster")) {
                tvItem.setPoster(jSONObject.getString("poster"));
            }
            if (jSONObject.has("active")) {
                tvItem.setActive(jSONObject.getString("active"));
            }
            if (jSONObject.has("cats")) {
                tvItem.setCats(jSONObject.getString("cats"));
            }
            if (jSONObject.has("rating")) {
                tvItem.setRating(jSONObject.getString("rating"));
            }
            if (jSONObject.has("seasons")) {
                tvItem.setSeasons(jSONObject.getString("seasons"));
            }
            if (jSONObject.has("banner")) {
                tvItem.setBanner(jSONObject.getString("banner"));
            }
            if (!jSONObject.has("banner_mini")) {
                return tvItem;
            }
            tvItem.setBanner(jSONObject.getString("banner_mini"));
            return tvItem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
