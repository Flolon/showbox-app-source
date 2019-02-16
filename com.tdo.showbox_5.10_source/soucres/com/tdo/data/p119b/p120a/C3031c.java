package com.tdo.showbox.data.p119b.p120a;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.activeandroid.query.Select;
import com.iawl.api.ads.sdk.IAWLAdView;
import com.iawl.api.ads.sdk.IAWLAdView.AdType;
import com.iawl.api.ads.sdk.IAWLErrorCode;
import com.iawl.api.ads.sdk.IAWLMediationName;
import com.iawl.api.ads.sdk.IAWLUserConfig;
import com.iawl.api.ads.sdk.IAWLUserConfig.Gender;
import com.startapp.android.publish.ads.banner.BannerListener;
import com.startapp.android.publish.ads.banner.Cover;
import com.startapp.android.publish.adsCommon.SDKAdPreferences;
import com.startapp.android.publish.common.model.AdPreferences;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.data.p119b.C3025a;
import com.tdo.showbox.data.p119b.C3046f;
import com.tdo.showbox.data.p119b.C3049h;
import com.tdo.showbox.data.p119b.C3049h.C3027a;
import com.tdo.showbox.models.AppConfig;
import com.tdo.showbox.models.InternalAd;
import com.tdo.showbox.models.UserInfo;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.views.CustomAdBannerView;
import com.tdo.showbox.views.CustomAdBannerView.C3029a;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: IaRectangleListAd */
/* renamed from: com.tdo.showbox.data.b.a.c */
public class C3031c {
    /* renamed from: a */
    public static String f11911a = "STARTAPP_AD";
    /* renamed from: b */
    private Activity f11912b;
    /* renamed from: c */
    private IAWLAdView f11913c;
    /* renamed from: d */
    private C2747a f11914d;
    /* renamed from: e */
    private boolean f11915e;
    /* renamed from: f */
    private UserInfo f11916f;
    /* renamed from: g */
    private FrameLayout f11917g;
    /* renamed from: h */
    private int f11918h;
    /* renamed from: i */
    private int f11919i;
    /* renamed from: j */
    private int f11920j = 2;
    /* renamed from: k */
    private String f11921k;
    /* renamed from: l */
    private C2999a f11922l;
    /* renamed from: m */
    private Cover f11923m;

    /* compiled from: IaRectangleListAd */
    /* renamed from: com.tdo.showbox.data.b.a.c$a */
    public interface C2747a {
        /* renamed from: a */
        void mo2032a();
    }

    /* compiled from: IaRectangleListAd */
    /* renamed from: com.tdo.showbox.data.b.a.c$3 */
    class C30303 implements C3029a {
        /* renamed from: a */
        final /* synthetic */ C3031c f11910a;

        C30303(C3031c c3031c) {
            this.f11910a = c3031c;
        }

        /* renamed from: a */
        public void mo2110a() {
        }
    }

    public C3031c(String str) {
        this.f11921k = str;
        AppConfig appConfig = (AppConfig) new Select().from(AppConfig.class).executeSingle();
        C3046f c3046f = new C3046f();
        c3046f.m16481a(appConfig);
        this.f11920j = c3046f.m16483c();
        C3094j.m16698a("Rect_AD", "AdsAttemptsConfig mStartAppRectPos: " + this.f11920j);
    }

    /* renamed from: a */
    public C2999a m16426a() {
        if (this.f11922l == null) {
            this.f11922l = new C2999a(this.f11912b.getApplicationContext());
            AppConfig appConfig = (AppConfig) new Select().from(AppConfig.class).executeSingle();
            if (appConfig != null) {
                this.f11922l.m16331a(appConfig);
            }
        }
        return this.f11922l;
    }

    /* renamed from: a */
    public void m16427a(int i, int i2) {
        this.f11918h = i;
        this.f11919i = i2;
    }

    /* renamed from: b */
    public FrameLayout m16433b() {
        return this.f11917g;
    }

    /* renamed from: a */
    public void m16431a(C2747a c2747a) {
        this.f11914d = c2747a;
    }

    /* renamed from: c */
    public boolean m16434c() {
        return this.f11915e;
    }

    /* renamed from: a */
    public void m16432a(boolean z) {
        this.f11915e = z;
    }

    /* renamed from: a */
    public void m16429a(Activity activity, UserInfo userInfo) {
        this.f11912b = activity;
        this.f11916f = userInfo;
        this.f11917g = new FrameLayout(activity);
    }

    /* renamed from: a */
    private String m16415a(int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("TVFS_Mrec_Android");
        arrayList.add("TVFS_Mrec_tier2_Android");
        arrayList.add(f11911a);
        arrayList.add(this.f11920j, f11911a);
        return (String) arrayList.get(i);
    }

    /* renamed from: d */
    public void m16435d() {
        try {
            if (this.f11913c != null) {
                this.f11913c.destroy();
                this.f11913c = null;
                this.f11914d = null;
            }
        } catch (Exception e) {
        }
        this.f11923m = null;
        try {
            if (this.f11917g != null) {
                this.f11917g.removeAllViews();
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: e */
    public void m16436e() {
        if (this.f11913c == null && this.f11923m == null) {
            this.f11915e = false;
            m16428a(0, false);
        }
    }

    /* renamed from: f */
    public void m16437f() {
        m16435d();
    }

    /* renamed from: b */
    private C3025a m16422b(final int i, final boolean z) {
        return new C3025a(this) {
            /* renamed from: c */
            final /* synthetic */ C3031c f11906c;

            public void iawlBannerLoaded(IAWLAdView iAWLAdView) {
                C3094j.m16698a("Rect_AD", "RectLoaded");
            }

            public void iawlBannerFailed(IAWLAdView iAWLAdView, IAWLErrorCode iAWLErrorCode) {
                C3094j.m16698a("Rect_AD", "RectFailed: " + i);
                if (z && i < 3) {
                    this.f11906c.m16428a(i, true);
                } else if (i < 2) {
                    this.f11906c.m16428a(i + 1, z);
                }
            }
        };
    }

    /* renamed from: a */
    private void m16419a(final C3025a c3025a, final boolean z) {
        if (this.f11912b != null) {
            C3094j.m16698a("Rect_AD", "INT loadCustomRect " + z);
            C3049h.m16501c(this.f11912b, m16426a(), new C3027a(this) {
                /* renamed from: c */
                final /* synthetic */ C3031c f11909c;

                /* renamed from: a */
                public void mo2109a(InternalAd internalAd) {
                    if (internalAd != null) {
                        C3094j.m16698a("Rect_AD", "INT loadRect success");
                        this.f11909c.m16424i();
                        this.f11909c.m16421a(internalAd);
                        return;
                    }
                    C3094j.m16698a("Rect_AD", "INT loadRect fail");
                    if (z) {
                        this.f11909c.m16418a(c3025a);
                    } else {
                        c3025a.iawlBannerFailed(null, null);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m16418a(C3025a c3025a) {
        m16424i();
        this.f11923m = new Cover(this.f11912b, m16425j(), (BannerListener) c3025a);
        try {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, C3184j.m16980a(this.f11912b, 157));
            layoutParams.gravity = 17;
            this.f11917g.setVisibility(0);
            this.f11917g.addView(this.f11923m, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C3094j.m16698a("Rect_AD", "load rect Banner STARTAPP");
    }

    /* renamed from: a */
    protected void m16428a(int i, boolean z) {
        try {
            this.f11915e = false;
            C3094j.m16698a("Rect_AD", String.format(Locale.getDefault(), "Loading rect ad starts with attempt[%s]", new Object[]{Integer.valueOf(i)}));
            if (this.f11913c != null) {
                this.f11913c.destroy();
                this.f11913c = null;
            }
            if (this.f11923m != null) {
                this.f11923m.setBannerListener(null);
                this.f11923m = null;
            }
            if (this.f11917g != null) {
                this.f11917g.removeAllViews();
            }
            String a = m16415a(i);
            if (!a.equals(f11911a)) {
                this.f11913c = new IAWLAdView(this.f11912b, a, AdType.Rectangle);
                if (this.f11916f != null) {
                    IAWLUserConfig iAWLUserConfig = new IAWLUserConfig();
                    iAWLUserConfig.setAge(Integer.valueOf(this.f11916f.getAge()).intValue());
                    if (this.f11916f.getGender().equalsIgnoreCase("Female")) {
                        iAWLUserConfig.setGender(Gender.FEMALE);
                    } else {
                        iAWLUserConfig.setGender(Gender.MALE);
                    }
                    this.f11913c.setUserParams(iAWLUserConfig);
                }
                this.f11913c.setBannerAdListener(m16422b(i, false));
                this.f11913c.setMediationName(IAWLMediationName.OTHER);
                this.f11913c.setRefreshInterval(0);
                this.f11913c.loadAd();
                this.f11913c.requestLayout();
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.f11917g.addView(this.f11913c, layoutParams);
                C3094j.m16698a("Rect_AD", "load rect Banner INNERACTIVE");
            } else if (z) {
                m16419a(m16422b(i, false), false);
            } else {
                if (new Random(System.currentTimeMillis()).nextInt(100) < m16423h()) {
                    m16419a(m16422b(i, false), true);
                } else {
                    m16418a(m16422b(i, true));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: h */
    private int m16423h() {
        int i = 40;
        Object a = C3088f.m16675a("PREF_COUNTRY_ISO");
        AppConfig appConfig = (AppConfig) new Select().from(AppConfig.class).executeSingle();
        if (!(appConfig == null || TextUtils.isEmpty(appConfig.getAds_default()))) {
            i = Integer.valueOf(appConfig.getAds_default()).intValue();
        }
        try {
            if (!TextUtils.isEmpty(a)) {
                JSONArray jSONArray = new JSONArray(appConfig.getAds_by_country());
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject.getString("country").toLowerCase().equals(a.toLowerCase())) {
                        return Integer.valueOf(jSONObject.getString("proportion")).intValue();
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return i;
    }

    /* renamed from: g */
    public void m16438g() {
        C3094j.m16698a("Rect_AD", "onNativeImpressed");
    }

    /* renamed from: a */
    public void m16430a(ListView listView, BaseAdapter baseAdapter) {
        if (this.f11912b != null) {
            ListAdapter c3023a = new C3023a(this.f11912b, baseAdapter, this.f11917g);
            c3023a.m16402a(this.f11918h, this.f11919i);
            listView.setAdapter(c3023a);
        }
    }

    /* renamed from: i */
    private void m16424i() {
        if (!this.f11915e) {
            this.f11915e = true;
            if (this.f11914d != null) {
                this.f11914d.mo2032a();
            }
        }
    }

    /* renamed from: j */
    private AdPreferences m16425j() {
        UserInfo userInfo = (UserInfo) new Select().from(UserInfo.class).executeSingle();
        AdPreferences adPreferences = new AdPreferences();
        if (userInfo != null) {
            try {
                adPreferences.setAge(Integer.valueOf(userInfo.getAge()));
                if (userInfo.getGender().equalsIgnoreCase(this.f11912b.getString(R.string.female))) {
                    adPreferences.setGender(SDKAdPreferences.Gender.FEMALE);
                } else {
                    adPreferences.setGender(SDKAdPreferences.Gender.MALE);
                }
            } catch (Exception e) {
            }
        }
        return adPreferences;
    }

    /* renamed from: a */
    private boolean m16421a(InternalAd internalAd) {
        if (internalAd == null) {
            return false;
        }
        if (this.f11917g != null) {
            this.f11917g.removeAllViews();
        }
        if (this.f11913c != null) {
            this.f11913c.destroy();
            this.f11913c = null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f11912b.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = (int) ((((float) i) / 300.0f) * 100.0f);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(i, (int) (((double) ((float) i)) * 0.52d));
        layoutParams.gravity = 81;
        View customAdBannerView = new CustomAdBannerView(this.f11912b);
        customAdBannerView.setScaleFactor(i2);
        customAdBannerView.setBannerListener(new C30303(this));
        customAdBannerView.setAdInit(internalAd);
        this.f11917g.setVisibility(0);
        this.f11917g.addView(customAdBannerView, 0, layoutParams);
        customAdBannerView.m17199b();
        customAdBannerView.requestLayout();
        m16424i();
        return true;
    }
}
