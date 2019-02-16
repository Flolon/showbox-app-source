package com.tdo.showbox.data.p124a;

import com.iawl.api.ads.sdk.IAWLNativeAdRequest;
import com.tdo.showbox.models.UpdateItem;
import com.tdo.showbox.models.UpdatesResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JParserUpdates */
/* renamed from: com.tdo.showbox.data.a.i */
public class C2986i {
    /* renamed from: a */
    public static final UpdatesResponse m16309a(String str) {
        UpdatesResponse updatesResponse = new UpdatesResponse();
        try {
            JSONObject jSONObject = new JSONObject(str);
            updatesResponse.setMovies(C2986i.m16310a(jSONObject.getJSONArray("movie")));
            updatesResponse.setTvs(C2986i.m16310a(jSONObject.getJSONArray("tv")));
            updatesResponse.setMovies_count(jSONObject.getInt("movies_count"));
            updatesResponse.setTv_count(jSONObject.getInt("tv_count"));
            updatesResponse.setTotal_count(jSONObject.getInt("total_count"));
            updatesResponse.setTime(jSONObject.getString("time"));
        } catch (Exception e) {
        }
        return updatesResponse;
    }

    /* renamed from: a */
    public static final List<UpdateItem> m16310a(JSONArray jSONArray) {
        List<UpdateItem> arrayList = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                UpdateItem a = C2986i.m16308a(jSONArray.getJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static final UpdateItem m16308a(JSONObject jSONObject) {
        try {
            UpdateItem updateItem = new UpdateItem();
            if (jSONObject.has("id")) {
                updateItem.setItem_id(jSONObject.getString("id"));
            }
            if (jSONObject.has(IAWLNativeAdRequest.ASSET_TYPE_TITLE)) {
                updateItem.setTitle(jSONObject.getString(IAWLNativeAdRequest.ASSET_TYPE_TITLE));
            }
            if (jSONObject.has("poster")) {
                updateItem.setPoster(jSONObject.getString("poster"));
            }
            if (!jSONObject.has("date")) {
                return updateItem;
            }
            updateItem.setDate(jSONObject.getString("date"));
            return updateItem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
