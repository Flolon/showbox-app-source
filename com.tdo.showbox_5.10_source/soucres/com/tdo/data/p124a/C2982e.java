package com.tdo.showbox.data.p124a;

import com.iawl.api.ads.sdk.IAWLNativeAdRequest;
import com.tdo.showbox.models.MovieItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JParserMovies */
/* renamed from: com.tdo.showbox.data.a.e */
public class C2982e {
    /* renamed from: a */
    public static final List<MovieItem> m16303a(String str) {
        List<MovieItem> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                MovieItem a = C2982e.m16302a(jSONArray.getJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    /* renamed from: a */
    public static final MovieItem m16302a(JSONObject jSONObject) {
        try {
            MovieItem movieItem = new MovieItem();
            if (jSONObject.has("id")) {
                movieItem.setMovieId(jSONObject.getString("id"));
            }
            if (jSONObject.has(IAWLNativeAdRequest.ASSET_TYPE_TITLE)) {
                movieItem.setTitle(jSONObject.getString(IAWLNativeAdRequest.ASSET_TYPE_TITLE));
            }
            if (jSONObject.has("imdb_id")) {
                movieItem.setImdb_id(jSONObject.getString("imdb_id"));
            }
            if (jSONObject.has("poster")) {
                movieItem.setPoster(jSONObject.getString("poster"));
            }
            if (jSONObject.has("active")) {
                movieItem.setActive(jSONObject.getString("active"));
            }
            if (jSONObject.has("year")) {
                movieItem.setYear(jSONObject.getString("year"));
            }
            if (jSONObject.has("cats")) {
                movieItem.setCats(jSONObject.getString("cats"));
            }
            if (jSONObject.has("rating")) {
                movieItem.setRating(jSONObject.getString("rating"));
            }
            if (!jSONObject.has("imdb_rating")) {
                return movieItem;
            }
            movieItem.setImdb_rating(jSONObject.getString("imdb_rating"));
            return movieItem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
