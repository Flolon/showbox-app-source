package com.tdo.showbox.data.p119b;

import android.content.Context;
import android.text.TextUtils;
import com.activeandroid.query.Select;
import com.iawl.api.ads.sdk.IAWLMediationDefs;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.p124a.C2981d;
import com.tdo.showbox.models.InternalAd;
import com.tdo.showbox.models.UserInfo;

/* compiled from: CustomAdManager */
/* renamed from: com.tdo.showbox.data.b.h */
public class C3049h {

    /* compiled from: CustomAdManager */
    /* renamed from: com.tdo.showbox.data.b.h$a */
    public interface C3027a {
        /* renamed from: a */
        void mo2109a(InternalAd internalAd);
    }

    /* renamed from: a */
    public static void m16498a(InternalAd internalAd) {
    }

    /* renamed from: b */
    public static void m16500b(InternalAd internalAd) {
    }

    /* renamed from: a */
    public static void m16496a(Context context, C2999a c2999a, C3027a c3027a) {
        C3049h.m16497a(context, c2999a, InternalAd.INTERSTITIAL_AD, c3027a);
    }

    /* renamed from: b */
    public static void m16499b(Context context, C2999a c2999a, C3027a c3027a) {
        C3049h.m16497a(context, c2999a, "banner", c3027a);
    }

    /* renamed from: c */
    public static void m16501c(Context context, C2999a c2999a, C3027a c3027a) {
        C3049h.m16497a(context, c2999a, InternalAd.RECT_AD, c3027a);
    }

    /* renamed from: d */
    public static void m16502d(Context context, C2999a c2999a, C3027a c3027a) {
        C3049h.m16497a(context, c2999a, InternalAd.OWN_RECT_AD, c3027a);
    }

    /* renamed from: a */
    private static void m16497a(Context context, C2999a c2999a, final String str, final C3027a c3027a) {
        Object obj = "";
        UserInfo userInfo = (UserInfo) new Select().from(UserInfo.class).executeSingle();
        if (!TextUtils.isEmpty(userInfo != null ? userInfo.getGender() : "")) {
            if (userInfo.getGender().equalsIgnoreCase(context.getString(R.string.female))) {
                obj = "w";
            } else {
                obj = IAWLMediationDefs.GENDER_MALE;
            }
        }
        Object a = C3088f.m16675a("PREF_COUNTRY_ISO");
        if (!TextUtils.isEmpty(C3088f.m16675a("PREF_DEV_ID")) && !TextUtils.isEmpty(obj) && !TextUtils.isEmpty(a)) {
            c2999a.m16341b(C3088f.m16675a("PREF_DEV_ID"), a, obj, str, new AsyncHttpResponseHandler() {
                public void onSuccess(int i, String str) {
                    super.onSuccess(i, str);
                    C3094j.m16698a("CustomAdManager", "loadAd response: " + str);
                    InternalAd a = C2981d.m16300a(str, str);
                    if (c3027a != null) {
                        c3027a.mo2109a(a);
                    }
                }

                public void onFailure(Throwable th, String str) {
                    super.onFailure(th, str);
                    C3094j.m16698a("CustomAdManager", "loadAd onFailure");
                    if (c3027a != null) {
                        c3027a.mo2109a(null);
                    }
                }
            });
        } else if (c3027a != null) {
            c3027a.mo2109a(null);
        }
    }
}
