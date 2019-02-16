package com.tdo.showbox.data.p124a;

import com.tdo.showbox.data.ObjParser;
import com.tdo.showbox.models.TrendingResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: JParserTrending */
/* renamed from: com.tdo.showbox.data.a.h */
public class C2985h {
    /* renamed from: a */
    public static TrendingResponse m16307a(String str) {
        TrendingResponse trendingResponse = new TrendingResponse();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        List arrayList4 = new ArrayList();
        List arrayList5 = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                arrayList = ObjParser.m16285d(jSONObject.getJSONArray("movies_news").toString(), "movie");
            } catch (Exception e) {
            }
            try {
                arrayList2 = ObjParser.m16285d(jSONObject.getJSONArray("tv_news").toString(), "tv");
            } catch (Exception e2) {
            }
            try {
                arrayList3 = ObjParser.m16286e(jSONObject.getJSONArray("trailers").toString(), "new");
            } catch (Exception e3) {
            }
            try {
                arrayList4 = C2982e.m16303a(jSONObject.getJSONArray("movies").toString());
            } catch (Exception e4) {
            }
            try {
                arrayList5 = C2984g.m16306a(jSONObject.getJSONArray("tv").toString());
            } catch (Exception e5) {
            }
        } catch (Exception e6) {
        }
        trendingResponse.setMovies_news(arrayList);
        trendingResponse.setMovies(arrayList4);
        trendingResponse.setTrailers(arrayList3);
        trendingResponse.setTv(arrayList5);
        trendingResponse.setTv_news(arrayList2);
        return trendingResponse;
    }
}
