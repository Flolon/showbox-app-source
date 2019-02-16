package com.tdo.showbox.data.api;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.models.ResponseCacheModel;
import com.tdo.showbox.p131f.C3185k;
import java.util.Calendar;

/* compiled from: ResponseCacheManager */
/* renamed from: com.tdo.showbox.data.api.f */
public class C3016f {
    /* renamed from: a */
    public static void m16397a() {
        long d = C3088f.m16685d("PREF_LAST_REQUESTS_UPDATES_CLEARED");
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (d == 0) {
            C3088f.m16678a("PREF_LAST_REQUESTS_UPDATES_CLEARED", timeInMillis);
        } else if (d + 1800000 < timeInMillis) {
            try {
                C3088f.m16678a("PREF_LAST_REQUESTS_UPDATES_CLEARED", timeInMillis);
                new Delete().from(ResponseCacheModel.class).where("cache_time=1800000").execute();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    public static void m16399b() {
        long d = C3088f.m16685d("PREF_LAST_REQUESTS_TRENDING_CLEARED");
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (d == 0) {
            C3088f.m16678a("PREF_LAST_REQUESTS_TRENDING_CLEARED", timeInMillis);
        } else if (d + 3600000 < timeInMillis) {
            try {
                C3088f.m16678a("PREF_LAST_REQUESTS_TRENDING_CLEARED", timeInMillis);
                new Delete().from(ResponseCacheModel.class).where("cache_time=3600000").execute();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: c */
    public static void m16400c() {
        long d = C3088f.m16685d("PREF_LAST_REQUESTS_MOVIES_SHOWS_CLEARED");
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (d == 0) {
            C3088f.m16678a("PREF_LAST_REQUESTS_MOVIES_SHOWS_CLEARED", timeInMillis);
        } else if (d + 86400000 < timeInMillis) {
            try {
                C3088f.m16678a("PREF_LAST_REQUESTS_MOVIES_SHOWS_CLEARED", timeInMillis);
                new Delete().from(ResponseCacheModel.class).where("cache_time=86400000").execute();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static String m16396a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    ResponseCacheModel responseCacheModel = (ResponseCacheModel) new Select().from(ResponseCacheModel.class).where("request_hash='" + str + "'").executeSingle();
                    if (responseCacheModel != null) {
                        String a = C3185k.m16988a(responseCacheModel.getRaw_resp());
                        if (a != null && a.length() > 0) {
                            return a;
                        }
                    }
                    return null;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m16398a(String str, long j, String str2) {
        if (str != null) {
            try {
                if (str.length() != 0 && j != 0 && ((ResponseCacheModel) new Select().from(ResponseCacheModel.class).where("request_hash='" + str + "'").executeSingle()) == null) {
                    byte[] a = C3185k.m16990a(str2);
                    ResponseCacheModel responseCacheModel = new ResponseCacheModel();
                    responseCacheModel.setRaw_resp(a);
                    responseCacheModel.setCache_time(j);
                    responseCacheModel.setRequest_hash(str);
                    responseCacheModel.save();
                }
            } catch (Exception e) {
            }
        }
    }
}
