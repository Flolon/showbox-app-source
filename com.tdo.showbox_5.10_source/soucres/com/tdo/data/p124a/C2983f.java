package com.tdo.showbox.data.p124a;

import android.content.Context;
import com.tdo.showbox.models.Subtitle;
import com.tdo.showbox.models.subtitle.PopSubtitleResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: JParserPopSubtitles */
/* renamed from: com.tdo.showbox.data.a.f */
public class C2983f {
    /* renamed from: a */
    public static PopSubtitleResponse m16304a(Context context, String str, String str2) {
        PopSubtitleResponse popSubtitleResponse = new PopSubtitleResponse();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("subs");
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                arrayList.add(str3);
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(str3);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2.getString(IjkMediaMeta.IJKM_KEY_FORMAT).toLowerCase().equals("srt")) {
                            Subtitle subtitle = new Subtitle();
                            subtitle.setLang(str3);
                            subtitle.setZipDownloadLink(jSONObject2.getString("url"));
                            subtitle.setItem_id(jSONObject2.getString("id"));
                            subtitle.setMovieReleaseName(subtitle.getItem_id());
                            subtitle.setItem_id(str2);
                            subtitle.setUserNickName("123");
                            if (!(subtitle.getLang() == null || subtitle.getLang().length() == 0)) {
                                arrayList2.add(subtitle);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        popSubtitleResponse.setCountries(arrayList);
        popSubtitleResponse.setSubtitles(arrayList2);
        return popSubtitleResponse;
    }
}
