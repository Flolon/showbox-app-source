package com.tdo.showbox.data;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.webkit.URLUtil;
import com.activeandroid.query.Select;
import com.iawl.api.ads.sdk.IAWLNativeAdRequest;
import com.tdo.showbox.R;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.data.p124a.C2978a;
import com.tdo.showbox.data.p124a.C2979b;
import com.tdo.showbox.data.p124a.C2980c;
import com.tdo.showbox.models.AlertInfoMessage;
import com.tdo.showbox.models.AppConfig;
import com.tdo.showbox.models.CatCRTorrentItem;
import com.tdo.showbox.models.Episod;
import com.tdo.showbox.models.EpisodeResponse;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.MovieItemMeta;
import com.tdo.showbox.models.News;
import com.tdo.showbox.models.Trailer;
import com.tdo.showbox.models.TrailerDetails;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import com.tdo.showbox.p131f.p132a.C3168a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class ObjParser extends Activity {

    /* renamed from: com.tdo.showbox.data.ObjParser$1 */
    static class C29751 implements Comparator<Episod> {
        C29751() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m16272a((Episod) obj, (Episod) obj2);
        }

        /* renamed from: a */
        public int m16272a(Episod episod, Episod episod2) {
            if (episod.getEpisode_id() == episod2.getEpisode_id()) {
                return 0;
            }
            if (episod.getEpisode_id() > episod2.getEpisode_id()) {
                return -1;
            }
            return 1;
        }
    }

    /* renamed from: a */
    public static AppConfig m16273a(String str) {
        return C2980c.m16299a(str);
    }

    /* renamed from: a */
    public static boolean m16278a(String str, String str2) {
        if (str == null || str2 == null || str2.length() == 0 || !str.contains(str2)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static EpisodeResponse m16279b(String str) {
        JSONObject jSONObject;
        EpisodeResponse episodeResponse = new EpisodeResponse();
        JSONObject jSONObject2 = new JSONObject(str);
        episodeResponse.setDescription(jSONObject2.getString(IAWLNativeAdRequest.ASSET_TYPE_DESCRIPTION));
        episodeResponse.setBanner(jSONObject2.getString("banner"));
        episodeResponse.setCats(jSONObject2.getString("cats"));
        JSONObject jSONObject3 = null;
        try {
            if (jSONObject2.has("titles")) {
                jSONObject3 = jSONObject2.getJSONObject("titles");
            }
            jSONObject = jSONObject3;
        } catch (Exception e) {
            jSONObject = null;
        }
        try {
            JSONObject jSONObject4 = jSONObject2.getJSONObject("thumbs");
            List arrayList = new ArrayList();
            Iterator keys = jSONObject4.keys();
            while (keys.hasNext()) {
                Episod episod = new Episod();
                String str2 = (String) keys.next();
                try {
                    episod.setEpisode_id(Long.valueOf(str2).longValue());
                } catch (Exception e2) {
                }
                episod.setThumb(jSONObject4.getString(str2));
                try {
                    episod.setEpizode_title(jSONObject.getString(str2));
                } catch (Exception e3) {
                }
                arrayList.add(episod);
            }
            jSONObject4 = jSONObject2.getJSONObject("seasons");
            keys = jSONObject4.keys();
            String str3 = "";
            while (keys.hasNext()) {
                str3 = (str3 + jSONObject4.getString((String) keys.next())) + ";";
            }
            episodeResponse.setSeasons(str3);
            episodeResponse.setSeason(jSONObject2.getInt("season"));
            episodeResponse.setImdb_id(jSONObject2.getString("imdb_id"));
            Collections.sort(arrayList, new C29751());
            episodeResponse.setEpisodes(arrayList);
        } catch (Exception e4) {
        }
        return episodeResponse;
    }

    /* renamed from: a */
    public static Episod m16274a(Context context, String str, Episod episod, int i) {
        List arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    episod.setDelay(jSONObject.getLong("delay"));
                    episod.setActive(1);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("sources");
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        jSONObject = jSONArray2.getJSONObject(i3);
                        String string = jSONObject.getString(IjkMediaMeta.IJKM_KEY_TYPE);
                        String str2 = "";
                        if (jSONObject.has("hash")) {
                            str2 = jSONObject.getString("hash");
                            C3168a.m16947a();
                            C3091g.m16686a(str2, context);
                            C3168a.m16949b();
                        }
                        BaseVideoSource baseVideoSource;
                        String string2;
                        if (string.equalsIgnoreCase("3")) {
                            baseVideoSource = new BaseVideoSource();
                            baseVideoSource.setSource_mode_id(2);
                            if (context != null) {
                                baseVideoSource.setSource_name(context.getString(R.string.source_name_moon));
                            }
                            C3168a.m16947a();
                            string2 = jSONObject.getString("token");
                            C3168a.m16949b();
                            baseVideoSource.setStatic_link(C2999a.m16320a(string2));
                            baseVideoSource.setPriority(12);
                            arrayList.add(baseVideoSource);
                        } else if (string.equalsIgnoreCase("10")) {
                            baseVideoSource = new BaseVideoSource();
                            baseVideoSource.setSource_mode_id(10);
                            if (context != null) {
                                baseVideoSource.setSource_name(context.getString(R.string.source_name_ol));
                            }
                            C3168a.m16947a();
                            string2 = C3091g.m16690b(jSONObject.getString("hash"), context);
                            C3168a.m16949b();
                            baseVideoSource.setStatic_link(string2);
                            baseVideoSource.setPriority(10);
                            arrayList.add(baseVideoSource);
                        } else if (string.equalsIgnoreCase("7")) {
                            JSONArray jSONArray3 = jSONObject.getJSONArray("files");
                            BaseVideoSource baseVideoSource2 = new BaseVideoSource();
                            baseVideoSource2.setSource_mode_id(7);
                            if (context != null) {
                                baseVideoSource2.setSource_name(context.getString(R.string.source_name_torrent));
                            }
                            for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                                JSONObject jSONObject2 = jSONArray3.getJSONObject(i4);
                                String string3 = jSONObject2.getString("data");
                                C3168a.m16947a();
                                string3 = C3091g.m16691c(string3, context);
                                C3168a.m16949b();
                                if (jSONObject2.getInt("hd") == 360) {
                                    baseVideoSource2.setStatic_link(string3);
                                    baseVideoSource2.setLow_link(string3);
                                } else if (jSONObject2.getInt("hd") == 480) {
                                    baseVideoSource2.setStatic_link(string3);
                                    baseVideoSource2.setMid_link(string3);
                                } else if (jSONObject2.getInt("hd") == 720) {
                                    baseVideoSource2.setStatic_link(string3);
                                    baseVideoSource2.setHd_link(string3);
                                } else if (jSONObject2.getInt("hd") == 1080) {
                                    baseVideoSource2.setStatic_link(string3);
                                    baseVideoSource2.setFull_hd_link(string3);
                                }
                            }
                            baseVideoSource2.setPriority(5);
                            arrayList.add(baseVideoSource2);
                        }
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
        }
        episod.setSourceList(arrayList);
        return episod;
    }

    /* renamed from: a */
    public static BaseVideoSource m16276a(BaseVideoSource baseVideoSource, String str) {
        ArrayList c = m16282c(str);
        int i = 0;
        while (i < c.size()) {
            try {
                String str2 = (String) c.get(i);
                if (str2 != null) {
                    if (str2.endsWith("720.mp4")) {
                        baseVideoSource.setHd_link(str2);
                    } else if (str2.endsWith("480.mp4")) {
                        baseVideoSource.setMid_link(str2);
                    } else if (str2.endsWith("360.mp4")) {
                        baseVideoSource.setLow_link(str2);
                    }
                }
                i++;
            } catch (Exception e) {
            }
        }
        return baseVideoSource;
    }

    /* renamed from: c */
    public static ArrayList<String> m16282c(String str) {
        Matcher matcher;
        String group;
        ArrayList<String> arrayList = new ArrayList();
        try {
            matcher = Pattern.compile("http://[a-z0-9_-]{1,32}\\S*\\.mp4", 32).matcher(str);
            while (matcher.find()) {
                group = matcher.group(0);
                if (URLUtil.isValidUrl(group)) {
                    arrayList.add(group);
                }
            }
        } catch (Exception e) {
        }
        if (arrayList.size() == 0) {
            try {
                matcher = Pattern.compile("https://[a-z0-9_-]{1,32}\\S*\\.mp4", 32).matcher(str);
                while (matcher.find()) {
                    group = matcher.group(0);
                    if (URLUtil.isValidUrl(group)) {
                        arrayList.add(group);
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (arrayList.size() == 0) {
            try {
                matcher = Pattern.compile("https:\\\\/\\\\/[a-z0-9_-]{1,32}\\S*\\.mp4", 32).matcher(str);
                while (matcher.find()) {
                    group = matcher.group(0).replace("\\", "");
                    if (URLUtil.isValidUrl(group)) {
                        arrayList.add(group);
                    }
                }
            } catch (Exception e3) {
            }
        }
        if (arrayList.size() == 0) {
            try {
                matcher = Pattern.compile("http:\\\\/\\\\/[a-z0-9_-]{1,32}\\S*\\.mp4", 32).matcher(str);
                while (matcher.find()) {
                    group = matcher.group(0).replace("\\", "");
                    if (URLUtil.isValidUrl(group)) {
                        arrayList.add(group);
                    }
                }
            } catch (Exception e4) {
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static String m16281b(String str, String str2) {
        String str3 = "";
        try {
            Matcher matcher = Pattern.compile(str2, 32).matcher(str);
            if (matcher.find()) {
                str3 = matcher.group(0);
            }
        } catch (Exception e) {
        }
        return str3;
    }

    /* renamed from: a */
    public static final MovieItem m16275a(Context context, MovieItem movieItem, String str) {
        List arrayList = new ArrayList();
        try {
            MovieItemMeta movieItemMeta = MovieItem.getMovieItemMeta(movieItem);
            if (str == null) {
                str = movieItemMeta.getRaw_json();
            } else {
                movieItemMeta.setRaw_json(str);
            }
            movieItemMeta.save();
            JSONObject jSONObject = new JSONObject(str);
            movieItem.setDescription(jSONObject.getString(IAWLNativeAdRequest.ASSET_TYPE_DESCRIPTION));
            movieItem.setPoster_hires(jSONObject.getString("poster"));
            movieItem.setTrailer(jSONObject.getString("trailer"));
            movieItem.setImdb_rating(jSONObject.getString("imdb_rating"));
            movieItem.setYear(jSONObject.getString("year"));
            movieItem.setCats(jSONObject.getString("cats"));
            JSONArray jSONArray = jSONObject.getJSONArray("langs");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.getString("lang").equalsIgnoreCase("en")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("sources");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        jSONObject2 = jSONArray2.getJSONObject(i2);
                        String string = jSONObject2.getString(IjkMediaMeta.IJKM_KEY_TYPE);
                        String str2 = "";
                        if (jSONObject2.has("hash")) {
                            str2 = jSONObject2.getString("hash");
                            C3168a.m16947a();
                            C3091g.m16686a(str2, context);
                            C3168a.m16949b();
                        }
                        BaseVideoSource baseVideoSource;
                        String string2;
                        if (string.equalsIgnoreCase("3")) {
                            baseVideoSource = new BaseVideoSource();
                            baseVideoSource.setSource_mode_id(2);
                            if (context != null) {
                                baseVideoSource.setSource_name(context.getString(R.string.source_name_moon));
                            }
                            C3168a.m16947a();
                            string2 = jSONObject2.getString("token");
                            C3168a.m16949b();
                            baseVideoSource.setStatic_link(C2999a.m16320a(string2));
                            baseVideoSource.setPriority(12);
                            arrayList.add(baseVideoSource);
                        } else if (string.equalsIgnoreCase("10")) {
                            baseVideoSource = new BaseVideoSource();
                            baseVideoSource.setSource_mode_id(10);
                            if (context != null) {
                                baseVideoSource.setSource_name(context.getString(R.string.source_name_ol));
                            }
                            C3168a.m16947a();
                            string2 = C3091g.m16690b(jSONObject2.getString("hash"), context);
                            C3168a.m16949b();
                            baseVideoSource.setStatic_link(string2);
                            baseVideoSource.setPriority(10);
                            arrayList.add(baseVideoSource);
                        } else if (string.equalsIgnoreCase("7")) {
                            JSONArray jSONArray3 = jSONObject2.getJSONArray("files");
                            BaseVideoSource baseVideoSource2 = new BaseVideoSource();
                            baseVideoSource2.setSource_mode_id(7);
                            if (context != null) {
                                baseVideoSource2.setSource_name(context.getString(R.string.source_name_torrent));
                            }
                            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                                JSONObject jSONObject3 = jSONArray3.getJSONObject(i3);
                                String string3 = jSONObject3.getString("data");
                                C3168a.m16947a();
                                string3 = C3091g.m16691c(string3, context);
                                C3168a.m16949b();
                                if (jSONObject3.getInt("hd") == 360) {
                                    baseVideoSource2.setStatic_link(string3);
                                    baseVideoSource2.setLow_link(string3);
                                } else if (jSONObject3.getInt("hd") == 480) {
                                    baseVideoSource2.setStatic_link(string3);
                                    baseVideoSource2.setMid_link(string3);
                                } else if (jSONObject3.getInt("hd") == 720) {
                                    baseVideoSource2.setStatic_link(string3);
                                    baseVideoSource2.setHd_link(string3);
                                } else if (jSONObject3.getInt("hd") == 1080) {
                                    baseVideoSource2.setStatic_link(string3);
                                    baseVideoSource2.setFull_hd_link(string3);
                                }
                            }
                            baseVideoSource2.setPriority(5);
                            arrayList.add(baseVideoSource2);
                        }
                    }
                    continue;
                }
            }
            movieItem.setSee_also_array(jSONObject.getJSONArray("see_also").toString());
        } catch (Exception e) {
            Log.e("eel", "bor!!!");
        }
        movieItem.setSourceList(arrayList);
        return movieItem;
    }

    /* renamed from: b */
    public static final BaseVideoSource m16280b(BaseVideoSource baseVideoSource, String str) {
        String str2 = null;
        try {
            String string;
            String string2;
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("360")) {
                string = jSONObject.getString("360");
            } else {
                string = null;
            }
            if (jSONObject.has("480")) {
                string2 = jSONObject.getString("480");
            } else {
                string2 = null;
            }
            if (jSONObject.has("720")) {
                str2 = jSONObject.getString("720");
            }
            baseVideoSource.setLow_link(string);
            baseVideoSource.setMid_link(string2);
            baseVideoSource.setHd_link(str2);
        } catch (Exception e) {
        }
        return baseVideoSource;
    }

    /* renamed from: d */
    public static final List<AlertInfoMessage> m16284d(String str) {
        return C2978a.m16295a(str);
    }

    /* renamed from: e */
    public static boolean m16287e(String str) {
        AppConfig appConfig = (AppConfig) new Select().from(AppConfig.class).executeSingle();
        if (appConfig != null) {
            return m16278a(str, appConfig.getNotfound_video());
        }
        return true;
    }

    /* renamed from: a */
    public static final List<CatCRTorrentItem> m16277a(String str, int i, int i2) {
        try {
            return C2979b.m16297a(str, i, i2);
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    /* renamed from: c */
    public static final List<CatCRTorrentItem> m16283c(String str, String str2) {
        try {
            return C2979b.m16298a(str, str2);
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    /* renamed from: f */
    public static final List<CatCRTorrentItem> m16289f(String str) {
        try {
            return C2979b.m16296a(str);
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    /* renamed from: d */
    public static List<News> m16285d(String str, String str2) {
        List<News> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                News news = new News();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                news.setNewId(jSONObject.getString("id"));
                news.setType(str2);
                news.setDate(jSONObject.getString("date"));
                news.setHead(jSONObject.getString("head"));
                news.setPic(jSONObject.getString("pic"));
                arrayList.add(news);
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    /* renamed from: e */
    public static List<Trailer> m16286e(String str, String str2) {
        List<Trailer> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                Trailer trailer = new Trailer();
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                trailer.setTrailerID(jSONObject.getString("id"));
                trailer.setType(str2);
                trailer.setTitle(jSONObject.getString(IAWLNativeAdRequest.ASSET_TYPE_TITLE));
                trailer.setPoster(jSONObject.getString("poster"));
                arrayList.add(trailer);
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    /* renamed from: f */
    public static TrailerDetails m16288f(String str, String str2) {
        TrailerDetails trailerDetails = new TrailerDetails();
        try {
            JSONObject jSONObject = new JSONObject(str);
            trailerDetails.setCats(jSONObject.getString("cats"));
            trailerDetails.setRelease_info(jSONObject.getString("release_info"));
            trailerDetails.setDescription(jSONObject.getString(IAWLNativeAdRequest.ASSET_TYPE_DESCRIPTION));
            trailerDetails.setPoster_hires(jSONObject.getString("poster_hires"));
            trailerDetails.setTrailers(jSONObject.getJSONArray("trailers").toString());
            trailerDetails.setTrailer_id(str2);
        } catch (Exception e) {
        }
        return trailerDetails;
    }
}
