package com.tdo.showbox.data;

import com.flurry.android.FlurryAgent;
import com.p043b.p044a.p045a.C0911a;
import com.p043b.p044a.p045a.C0929k;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AnaliticsManager */
/* renamed from: com.tdo.showbox.data.b */
public class C3065b {
    /* renamed from: a */
    public static void m16568a(String str) {
        if (str != null) {
            try {
                C0911a.m4940c().m4943a(new C0929k(str));
            } catch (Exception e) {
            }
        }
        C3094j.m16698a("Analitics", "trackEvent FABRIC : " + str);
        if (str != null) {
            try {
                if (str.startsWith("__ads")) {
                    String[] split = str.replace("__ads_", "").split("__");
                    Map hashMap = new HashMap();
                    hashMap.put("action", split[1]);
                    FlurryAgent.logEvent(split[0] + "_" + split[2], hashMap);
                    C3094j.m16698a("Analitics", "trackEvent FLURRY ADS event: " + split[0] + "; " + split[1] + ": " + split[2]);
                    return;
                }
                FlurryAgent.logEvent(str);
                C3094j.m16698a("Analitics", "trackEvent FLURRY: " + str);
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public static void m16569a(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            try {
                C0911a.m4940c().m4943a((C0929k) new C0929k(str).m4950a(str2, str3));
                C3094j.m16698a("Analitics", "trackEvent FABRIC: " + str + "; " + str2 + ": " + str3);
            } catch (Exception e) {
            }
            try {
                if (!str.startsWith("__ads")) {
                    Map hashMap = new HashMap();
                    hashMap.put(str2, str3);
                    FlurryAgent.logEvent(str, hashMap);
                    C3094j.m16698a("Analitics", "trackEvent FLURRY: " + str + "; " + str2 + ": " + str3);
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public static void m16570a(String str, String[] strArr, String[] strArr2) {
        int i = 0;
        if (str != null && strArr != null && strArr2 != null) {
            try {
                C0929k c0929k = new C0929k(str);
                String str2 = "";
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    c0929k.m4950a(strArr[i2], strArr2[i2]);
                    str2 = str2 + strArr[i2] + " : " + strArr2[i2] + " ; ";
                }
                C0911a.m4940c().m4943a(c0929k);
                C3094j.m16698a("Analitics", "trackEvent FABRIC: " + str + " ; " + str2);
            } catch (Exception e) {
            }
            try {
                String str3 = "";
                if (!str.startsWith("__ads")) {
                    Map hashMap = new HashMap();
                    while (i < strArr.length) {
                        hashMap.put(strArr[i], strArr2[i]);
                        str3 = str3 + strArr[i] + " : " + strArr2[i] + " ; ";
                        i++;
                    }
                    FlurryAgent.logEvent(str, hashMap);
                    C3094j.m16698a("Analitics", "trackEvent FLURRY: " + str + "; " + str3);
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public static void m16571a(boolean z, int i) {
        String str;
        String str2 = "360";
        if (i == 1) {
            str = "480";
        } else if (i == 2) {
            str = "720";
        } else {
            str = str2;
        }
        C3065b.m16569a(z ? "movie_watch_now_quality" : "tv_watch_now_quality", "quality", str);
    }

    /* renamed from: a */
    public static void m16567a(BaseVideoSource baseVideoSource, boolean z) {
        if (baseVideoSource != null) {
            if (z) {
                C3065b.m16569a("movie_watch_now", "server", baseVideoSource.getSource_name());
            } else {
                C3065b.m16569a("tv_watch_now", "server", baseVideoSource.getSource_name());
            }
        }
    }

    /* renamed from: b */
    public static void m16573b(BaseVideoSource baseVideoSource, boolean z) {
        if (baseVideoSource != null) {
            if (z) {
                C3065b.m16569a("movie_download", "server", baseVideoSource.getSource_name());
            } else {
                C3065b.m16569a("tv_download", "server", baseVideoSource.getSource_name());
            }
        }
    }

    /* renamed from: b */
    public static String m16572b(String str) {
        try {
            return "interstitial_" + str.replace("__", "");
        } catch (Exception e) {
            return "";
        }
    }
}
