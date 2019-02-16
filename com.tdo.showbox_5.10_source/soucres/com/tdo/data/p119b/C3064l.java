package com.tdo.showbox.data.p119b;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.activeandroid.query.Select;
import com.iawl.api.ads.sdk.IAWLAdManager;
import com.iawl.api.ads.sdk.IAWLAdView;
import com.iawl.api.ads.sdk.IAWLAdView.AdType;
import com.iawl.api.ads.sdk.IAWLErrorCode;
import com.iawl.api.ads.sdk.IAWLInterstitialView;
import com.iawl.api.ads.sdk.IAWLUserConfig;
import com.startapp.android.publish.ads.banner.Banner;
import com.startapp.android.publish.adsCommon.SDKAdPreferences.Gender;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.common.model.AdPreferences;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.C2631a;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.data.p119b.C3049h.C3027a;
import com.tdo.showbox.models.AppConfig;
import com.tdo.showbox.models.InternalAd;
import com.tdo.showbox.models.UserInfo;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.views.CustomAdBannerView;
import com.tdo.showbox.views.CustomAdBannerView.C3029a;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Iad */
/* renamed from: com.tdo.showbox.data.b.l */
public class C3064l extends C3045e {
    /* renamed from: d */
    public static String f12006d = "IA AD-LOG";
    /* renamed from: e */
    public static String f12007e = "STARTAPP_AD";
    /* renamed from: f */
    private Banner f12008f;
    /* renamed from: g */
    private CustomAdBannerView f12009g;
    /* renamed from: h */
    private IAWLAdView f12010h;
    /* renamed from: i */
    private boolean f12011i = false;
    /* renamed from: j */
    private C3042c f12012j;
    /* renamed from: k */
    private IAWLInterstitialView f12013k;
    /* renamed from: l */
    private StartAppAd f12014l;
    /* renamed from: m */
    private boolean f12015m = false;
    /* renamed from: n */
    private int f12016n = 0;
    /* renamed from: o */
    private String f12017o;
    /* renamed from: p */
    private int f12018p;
    /* renamed from: q */
    private int f12019q;
    /* renamed from: r */
    private C2999a f12020r;

    /* compiled from: Iad */
    /* renamed from: com.tdo.showbox.data.b.l$3 */
    class C30593 implements C3029a {
        /* renamed from: a */
        final /* synthetic */ C3064l f11995a;

        C30593(C3064l c3064l) {
            this.f11995a = c3064l;
        }

        /* renamed from: a */
        public void mo2110a() {
        }
    }

    /* compiled from: Iad */
    /* renamed from: com.tdo.showbox.data.b.l$4 */
    class C30604 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3064l f11996a;

        C30604(C3064l c3064l) {
            this.f11996a = c3064l;
        }

        public void run() {
            if (this.f11996a.b != null) {
                try {
                    if (this.f11996a.a.getResources().getBoolean(R.bool.portrait_only)) {
                        LayoutParams layoutParams = (LayoutParams) this.f11996a.b.getLayoutParams();
                        layoutParams.height = -2;
                        this.f11996a.b.setLayoutParams(layoutParams);
                    }
                } catch (Exception e) {
                }
                this.f11996a.b.setVisibility(8);
            }
        }
    }

    /* compiled from: Iad */
    /* renamed from: com.tdo.showbox.data.b.l$5 */
    class C30615 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3064l f11997a;

        C30615(C3064l c3064l) {
            this.f11997a = c3064l;
        }

        public void run() {
            if (this.f11997a.b != null) {
                try {
                    if (this.f11997a.a.getResources().getBoolean(R.bool.portrait_only)) {
                        LayoutParams layoutParams = (LayoutParams) this.f11997a.b.getLayoutParams();
                        int c = C3088f.m16684c("PREFS_BANNER_HEIGHT");
                        if (c == 0) {
                            c = C3184j.m16980a(this.f11997a.a, 50);
                        }
                        layoutParams.height = c;
                        this.f11997a.b.setLayoutParams(layoutParams);
                    }
                } catch (Exception e) {
                }
                this.f11997a.b.setVisibility(0);
            }
        }
    }

    public C3064l(C2631a c2631a, ViewGroup viewGroup, C3046f c3046f) {
        super(c2631a, viewGroup);
        this.f12018p = c3046f.m16480a();
        this.f12019q = c3046f.m16482b();
        C3094j.m16698a(f12006d, "AdsAttemptsConfig mStartAppInterPos: " + this.f12018p);
        C3094j.m16698a(f12006d, "AdsAttemptsConfig mStartAppBannerPos: " + this.f12019q);
        IAWLAdManager.initialize(c2631a);
        IAWLAdManager.testEnvironmentConfigurationIntegration("com.movietime.tv");
    }

    /* renamed from: a */
    private C3025a m16530a(final int i, final String str, final boolean z) {
        return new C3025a(this) {
            /* renamed from: d */
            final /* synthetic */ C3064l f11990d;

            public void iawlBannerLoaded(IAWLAdView iAWLAdView) {
                C3094j.m16698a(C3064l.f12006d, "BannerLoaded");
                C3065b.m16568a("ads_banner_load_success");
                this.f11990d.f12011i = true;
                this.f11990d.mo2125d();
            }

            public void iawlBannerFailed(IAWLAdView iAWLAdView, IAWLErrorCode iAWLErrorCode) {
                C3065b.m16568a("ads_banner_load_fail");
                C3094j.m16698a(C3064l.f12006d, "Banner Failed: " + i);
                if (z && i < 2) {
                    this.f11990d.m16550b(i, str, true);
                } else if (i < 1) {
                    this.f11990d.m16550b(i + 1, str, z);
                } else {
                    this.f11990d.f12011i = false;
                    this.f11990d.m16566h();
                }
            }
        };
    }

    /* renamed from: g */
    public C2999a m16565g() {
        if (this.f12020r == null) {
            this.f12020r = new C2999a(this.a.getApplicationContext());
            AppConfig appConfig = (AppConfig) new Select().from(AppConfig.class).executeSingle();
            if (appConfig != null) {
                this.f12020r.m16331a(appConfig);
            }
        }
        return this.f12020r;
    }

    /* renamed from: a */
    private void m16539a(final C3025a c3025a, final String str, final boolean z) {
        if (this.a != null) {
            C3094j.m16698a(f12006d, "INT loadCustomBanner " + z);
            C3049h.m16499b(this.a, m16565g(), new C3027a(this) {
                /* renamed from: d */
                final /* synthetic */ C3064l f11994d;

                /* renamed from: a */
                public void mo2109a(InternalAd internalAd) {
                    if (internalAd != null) {
                        C3094j.m16698a(C3064l.f12006d, "INT loadBanner success");
                        this.f11994d.m16548a(internalAd);
                        return;
                    }
                    C3094j.m16698a(C3064l.f12006d, "INT loadBanner fail");
                    if (z) {
                        this.f11994d.m16538a(c3025a, str);
                    } else {
                        c3025a.iawlBannerFailed(null, null);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m16538a(C3025a c3025a, String str) {
        ViewGroup.LayoutParams i = m16552i();
        this.f12008f = new Banner(this.a, m16553j());
        this.f12008f.setBannerListener(c3025a);
        this.f12008f.setAdTag(str);
        this.b.addView(this.f12008f, 0, i);
        C3094j.m16698a(f12006d, "loadBanner STARTAPP TAG: " + str);
    }

    /* renamed from: a */
    private String m16534a(int i) {
        Object obj = (this.a == null || !this.a.getResources().getBoolean(R.bool.portrait_only)) ? null : 1;
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj != null ? "TVFS_MovieTime_Banner_Android" : "TVFS_MovieTime_Banner_AndroidTablet");
        arrayList.add(f12007e);
        arrayList.add(this.f12019q, f12007e);
        return (String) arrayList.get(i);
    }

    /* renamed from: b */
    public void mo2121b() {
        try {
            this.f12010h.destroy();
            this.f12013k.destroy();
        } catch (Exception e) {
        }
        try {
            this.f12009g.m17200c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.a.isFinishing()) {
                IAWLAdManager.destroy();
            }
        } catch (Exception e3) {
        }
    }

    /* renamed from: i */
    private LinearLayout.LayoutParams m16552i() {
        LinearLayout.LayoutParams layoutParams;
        boolean z = this.a.getResources().getBoolean(R.bool.portrait_only);
        int c = C3088f.m16684c("PREFS_BANNER_HEIGHT");
        if (z) {
            if (c == 0) {
                c = C3184j.m16980a(this.a, 50);
            }
            layoutParams = new LinearLayout.LayoutParams(-1, c);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, C3184j.m16980a(this.a, 90));
        }
        layoutParams.gravity = 81;
        return layoutParams;
    }

    /* renamed from: b */
    private void m16550b(int i, String str, boolean z) {
        if (this.b != null) {
            this.b.removeAllViews();
        }
        if (this.f12010h != null) {
            this.f12010h.destroy();
            this.f12010h = null;
        }
        String a = m16534a(i);
        ViewGroup.LayoutParams i2 = m16552i();
        if (!a.equals(f12007e)) {
            this.f12008f = null;
            this.f12010h = new IAWLAdView(this.a, a, AdType.Banner);
            m16537a(this.f12010h);
            this.f12010h.setBannerAdListener(m16530a(i, str, false));
            this.f12010h.setRefreshInterval(30);
            this.b.addView(this.f12010h, 0, i2);
            this.f12010h.loadAd();
            this.f12010h.requestLayout();
            C3094j.m16698a(f12006d, "loadBanner INNERACTIVE");
        } else if (z) {
            m16539a(m16530a(i, str, false), str, false);
        } else {
            if (new Random(System.currentTimeMillis()).nextInt(100) < m16554k()) {
                m16539a(m16530a(i, str, false), str, true);
            } else {
                m16538a(m16530a(i, str, true), str);
            }
        }
        C3065b.m16568a("ads_banner_try_to_load");
    }

    /* renamed from: a */
    public void mo2119a() {
    }

    /* renamed from: a */
    private boolean m16548a(InternalAd internalAd) {
        if (internalAd == null) {
            return false;
        }
        int a;
        int a2;
        if (this.b != null) {
            this.b.removeAllViews();
        }
        if (this.f12010h != null) {
            this.f12010h.destroy();
            this.f12010h = null;
        }
        if (this.a.getResources().getConfiguration().orientation == 2) {
            a = C3184j.m16980a(this.a, 90);
            a2 = C3184j.m16980a(this.a, 728);
        } else {
            a2 = this.b.getMeasuredWidth();
            a = (int) (((double) ((float) a2)) * 0.123d);
        }
        int i = (int) ((((float) a2) / 460.0f) * 100.0f);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a);
        layoutParams.gravity = 81;
        this.f12009g = new CustomAdBannerView(this.a);
        this.f12009g.setScaleFactor(i);
        this.f12009g.setBannerListener(new C30593(this));
        this.f12009g.setAdInit(internalAd);
        this.b.addView(this.f12009g, 0, layoutParams);
        this.f12009g.m17199b();
        this.f12009g.requestLayout();
        return true;
    }

    /* renamed from: a */
    public void mo2120a(String str) {
        try {
            m16550b(0, str, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: h */
    public void m16566h() {
        if (this.a != null) {
            this.a.runOnUiThread(new C30604(this));
        }
    }

    /* renamed from: d */
    public void mo2125d() {
        if (this.f12011i && this.a != null) {
            this.a.runOnUiThread(new C30615(this));
        }
    }

    /* renamed from: j */
    private AdPreferences m16553j() {
        UserInfo userInfo = (UserInfo) new Select().from(UserInfo.class).executeSingle();
        AdPreferences adPreferences = new AdPreferences();
        if (userInfo != null) {
            try {
                adPreferences.setAge(Integer.valueOf(userInfo.getAge()));
                if (userInfo.getGender().equalsIgnoreCase(this.a.getString(R.string.female))) {
                    adPreferences.setGender(Gender.FEMALE);
                } else {
                    adPreferences.setGender(Gender.MALE);
                }
            } catch (Exception e) {
            }
        }
        return adPreferences;
    }

    /* renamed from: a */
    private void m16537a(IAWLAdView iAWLAdView) {
        UserInfo userInfo = (UserInfo) new Select().from(UserInfo.class).executeSingle();
        if (userInfo != null) {
            try {
                IAWLUserConfig iAWLUserConfig = new IAWLUserConfig();
                iAWLUserConfig.setAge(Integer.valueOf(userInfo.getAge()).intValue());
                if (userInfo.getGender().equalsIgnoreCase(this.a.getString(R.string.female))) {
                    iAWLUserConfig.setGender(IAWLUserConfig.Gender.FEMALE);
                } else {
                    iAWLUserConfig.setGender(IAWLUserConfig.Gender.MALE);
                }
                iAWLAdView.setUserParams(iAWLUserConfig);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    public void mo2122b(String str) {
        this.f12015m = false;
        m16562d(str);
    }

    /* renamed from: e */
    public boolean mo2126e() {
        if (this.f12012j != null) {
            if (this.f12015m) {
                return false;
            }
            return this.f12012j.m16455a();
        } else if (this.f12014l != null) {
            if (this.f12015m) {
                return false;
            }
            return this.f12014l.isReady();
        } else if (this.f12013k == null || this.f12015m) {
            return false;
        } else {
            return this.f12013k.isReady();
        }
    }

    /* renamed from: f */
    public boolean mo2127f() {
        return this.f12015m;
    }

    /* renamed from: d */
    public void m16562d(String str) {
        try {
            m16536a(0, false, str, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public void mo2123c(String str) {
        try {
            m16536a(0, true, str, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private String m16549b(int i) {
        Object obj = (this.a == null || !this.a.getResources().getBoolean(R.bool.portrait_only)) ? null : 1;
        ArrayList arrayList = new ArrayList();
        arrayList.add("TVFS_MovieTime_Fullscreen_Premium_Android");
        arrayList.add(obj != null ? "TVFS_MovieTime_Fullscreen_Android" : "TVFS_MovieTime_Fullscreen_AndroidTablet");
        arrayList.add(obj != null ? "TVFS_MovieTime_Fullscreen_Tier2_Android" : "TVFS_MovieTime_Fullscreen_Tier2_AndroidTablet");
        arrayList.add(f12007e);
        return (String) arrayList.get(i);
    }

    /* renamed from: a */
    private void m16536a(int i, boolean z, String str, boolean z2) {
        try {
            String b = m16549b(i);
            C3094j.m16698a(f12006d, "INT loadFullscreenAds " + b + " ; " + i + "  " + z2);
            if (this.f12013k != null) {
                this.f12013k.destroy();
                this.f12013k = null;
            }
            if (this.f12012j != null) {
                this.f12012j.m16461g();
                this.f12012j = null;
            }
            this.f12014l = null;
            if (!b.equals(f12007e)) {
                C3094j.m16698a(f12006d, "INT loadFullscreenAds INNERACTIVE");
                this.f12013k = new IAWLInterstitialView(this.a, b);
                m16537a(this.f12013k);
                this.f12013k.setInterstitialAdListener(m16531a(z, i, str, false));
                this.f12013k.loadAd();
            } else if (z2) {
                m16541a(m16531a(z, i, str, false), false);
            } else {
                if (new Random(System.currentTimeMillis()).nextInt(100) < m16554k()) {
                    m16541a(m16531a(z, i, str, false), true);
                } else {
                    m16540a(m16531a(z, i, str, true));
                }
            }
            C3065b.m16568a("__ads_inter_load__" + str + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m16541a(final C3035b c3035b, final boolean z) {
        if (this.a != null) {
            this.a.mo2004b().m16486a(2);
            C3094j.m16698a(f12006d, "INT loadCustomInt " + z);
            C3049h.m16496a(this.a, m16565g(), new C3027a(this) {
                /* renamed from: c */
                final /* synthetic */ C3064l f12000c;

                /* renamed from: a */
                public void mo2109a(InternalAd internalAd) {
                    if (internalAd != null) {
                        C3094j.m16698a(C3064l.f12006d, "INT loadCustomInt success");
                        this.f12000c.f12012j = new C3042c(this.f12000c.a);
                        this.f12000c.f12012j.m16454a(internalAd, c3035b);
                        return;
                    }
                    C3094j.m16698a(C3064l.f12006d, "INT loadCustomInt fail");
                    if (z) {
                        this.f12000c.m16540a(c3035b);
                    } else {
                        c3035b.iawlInterstitialFailed(null, null);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m16540a(C3035b c3035b) {
        this.f12014l = new StartAppAd(this.a);
        this.f12014l.loadAd(m16553j(), (AdEventListener) c3035b);
        C3094j.m16698a(f12006d, "INT loadStartAppInt");
    }

    /* renamed from: k */
    private int m16554k() {
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

    /* renamed from: a */
    private C3035b m16531a(boolean z, int i, String str, boolean z2) {
        final int i2 = i;
        final String str2 = str;
        final boolean z3 = z;
        final boolean z4 = z2;
        return new C3035b(this) {
            /* renamed from: e */
            final /* synthetic */ C3064l f12005e;

            public void iawlInterstitialLoaded(IAWLInterstitialView iAWLInterstitialView) {
                C3094j.m16698a(C3064l.f12006d, "Loaded: " + i2);
                this.f12005e.f12016n = i2;
                this.f12005e.f12017o = str2;
                C3065b.m16568a("__ads_inter_loaded_success__" + str2 + i2);
                if (z3) {
                    this.f12005e.mo2124c();
                } else {
                    this.f12005e.f12015m = false;
                }
            }

            public void iawlInterstitialFailed(IAWLInterstitialView iAWLInterstitialView, IAWLErrorCode iAWLErrorCode) {
                C3065b.m16568a("__ads_inter_loaded_fail__" + str2 + i2);
                C3094j.m16698a(C3064l.f12006d, "Interstitial Failed: " + i2);
                if (z4 && i2 < 4) {
                    this.f12005e.m16536a(i2, z3, str2, z4);
                } else if (i2 < 3) {
                    this.f12005e.m16536a(i2 + 1, z3, str2, z4);
                }
            }

            public void iawlInterstitialShown(IAWLInterstitialView iAWLInterstitialView) {
                C3065b.m16568a("__ads_inter_shown__" + str2 + i2);
                C3094j.m16698a(C3064l.f12006d, "Shown: " + i2);
                if (!z3) {
                    this.f12005e.f12015m = false;
                }
            }

            public void iawlInterstitialClicked(IAWLInterstitialView iAWLInterstitialView) {
                C3094j.m16698a(C3064l.f12006d, "Clicked: " + i2);
                C3065b.m16568a("__ads_inter_clicked__" + str2 + i2);
                if (!z3 && this.f12005e.c != null) {
                    this.f12005e.c.m16269a();
                }
            }

            public void iawlInterstitialDismissed(IAWLInterstitialView iAWLInterstitialView) {
                C3094j.m16698a(C3064l.f12006d, "Dismissed: " + i2);
                C3065b.m16568a("__ads_inter_dismissed__" + str2 + i2);
                if (!z3 && this.f12005e.a != null) {
                    this.f12005e.a.mo2005c();
                }
            }

            public void iawlAdWillOpenExternalApp(IAWLAdView iAWLAdView) {
                C3065b.m16568a("__ads_inter_will_open_external_app__" + str2 + i2);
            }

            public void iawlInternalBrowserDismissed(IAWLAdView iAWLAdView) {
                C3065b.m16568a("__ads_inter_browser_dismissed__" + str2 + i2);
            }

            public void iawlInterstitialVideoCompleted(IAWLInterstitialView iAWLInterstitialView) {
                C3065b.m16568a("__ads_inter_video_completed__" + str2 + i2);
            }
        };
    }

    /* renamed from: c */
    public boolean mo2124c() {
        try {
            C3065b.m16568a("__ads_inter_try_to_show__" + this.f12017o + this.f12016n);
            if (this.f12014l != null) {
                if (this.f12015m) {
                    this.f12015m = false;
                    return false;
                } else if (this.f12014l.isReady()) {
                    C3065b.m16568a("__ads_inter_try_to_show_ads_is_ready__" + this.f12017o + this.f12016n);
                    String b = C3065b.m16572b(this.f12017o);
                    C3094j.m16698a(f12006d, "Interstitial ad tag: " + b);
                    this.f12014l.showAd(b, m16531a(false, this.f12016n, this.f12017o, false));
                    return true;
                } else {
                    C3065b.m16568a("__ads_inter_try_to_show_ads_not_ready__" + this.f12017o + this.f12016n);
                    return false;
                }
            } else if (this.f12012j != null) {
                if (this.f12015m) {
                    this.f12015m = false;
                    return false;
                } else if (this.f12012j.m16455a()) {
                    C3065b.m16568a("__ads_inter_try_to_show_ads_is_ready__" + this.f12017o + this.f12016n);
                    this.f12012j.m16456b();
                    return true;
                } else {
                    C3065b.m16568a("__ads_inter_try_to_show_ads_not_ready__" + this.f12017o + this.f12016n);
                    return false;
                }
            } else if (this.f12013k == null || this.f12015m) {
                this.f12015m = false;
                return false;
            } else {
                this.f12015m = false;
                if (this.f12013k.isReady()) {
                    C3065b.m16568a("__ads_inter_try_to_show_ads_is_ready__" + this.f12017o + this.f12016n);
                    this.f12013k.showAd();
                    return true;
                }
                C3065b.m16568a("__ads_inter_try_to_show_ads_not_ready__" + this.f12017o + this.f12016n);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
