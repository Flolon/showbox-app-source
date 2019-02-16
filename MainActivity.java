package com.tdo.showbox.activities;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.C0091f;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.C0722b;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.p043b.p044a.C0949a;
import com.p050c.p051a.p052a.p053a.p054a.C1059b;
import com.p050c.p051a.p059b.C1095c.C1092a;
import com.p050c.p051a.p059b.C1100d;
import com.p050c.p051a.p059b.C1108e.C1102a;
import com.p050c.p051a.p068c.C1129e;
import com.startapp.android.publish.ads.splash.SplashConfig;
import com.startapp.android.publish.ads.splash.SplashConfig.Orientation;
import com.startapp.android.publish.ads.splash.SplashConfig.Theme;
import com.startapp.android.publish.adsCommon.SDKAdPreferences;
import com.startapp.android.publish.adsCommon.SDKAdPreferences.Gender;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import com.tdo.showbox.App;
import com.tdo.showbox.C2607a;
import com.tdo.showbox.ParsersFuck;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.data.C2987a;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3075c;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3092h;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.ObjParser;
import com.tdo.showbox.data.UserLocationService;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.data.api.C3007b;
import com.tdo.showbox.data.api.C3011d;
import com.tdo.showbox.data.api.C3011d.C2625a;
import com.tdo.showbox.data.api.C3016f;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.loader.C3124f;
import com.tdo.showbox.data.p112c.C2618c;
import com.tdo.showbox.data.p112c.C3074a;
import com.tdo.showbox.data.p119b.C3047g;
import com.tdo.showbox.data.p124a.C2986i;
import com.tdo.showbox.data.p126d.C3076a;
import com.tdo.showbox.data.push.AlarmSchedulerReceiver;
import com.tdo.showbox.data.push.C3128a;
import com.tdo.showbox.data.push.C3129b;
import com.tdo.showbox.data.torrent.TorrentAutoDownloader;
import com.tdo.showbox.models.AppConfig;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.PartDuration;
import com.tdo.showbox.models.PartVideo;
import com.tdo.showbox.models.Subtitle;
import com.tdo.showbox.models.UpdateItem;
import com.tdo.showbox.models.UpdatesResponse;
import com.tdo.showbox.models.UserInfo;
import com.tdo.showbox.models.VideoParams;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import com.tdo.showbox.p113d.C2630b;
import com.tdo.showbox.p113d.C2773d;
import com.tdo.showbox.p113d.C2973e;
import com.tdo.showbox.p117b.C2769a;
import com.tdo.showbox.p117b.C2855e;
import com.tdo.showbox.p117b.C2867f;
import com.tdo.showbox.p117b.C2914k;
import com.tdo.showbox.p117b.C2963p;
import com.tdo.showbox.p117b.C2967q;
import com.tdo.showbox.p117b.p118a.C2788b;
import com.tdo.showbox.p117b.p118a.C2801c;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3174c;
import com.tdo.showbox.p131f.C3176e;
import com.tdo.showbox.p131f.C3178f;
import com.tdo.showbox.p131f.C3180g;
import com.tdo.showbox.p131f.C3182i;
import com.tdo.showbox.p131f.p132a.C3168a;
import com.tdo.showbox.views.C3328e;
import com.tdo.showbox.views.C3328e.C2622a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import p028b.p029a.p030a.p031a.C0895c;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

public class MainActivity extends C2632b implements C2630b {
    /* renamed from: u */
    private static boolean f10754u;
    /* renamed from: A */
    private long f10755A;
    /* renamed from: b */
    private C2999a f10756b;
    /* renamed from: c */
    private Dialog f10757c;
    /* renamed from: d */
    private C3074a f10758d;
    /* renamed from: e */
    private C3074a f10759e;
    /* renamed from: f */
    private C3074a f10760f;
    /* renamed from: g */
    private C3074a f10761g;
    /* renamed from: h */
    private boolean f10762h;
    /* renamed from: i */
    private int f10763i;
    /* renamed from: j */
    private int f10764j;
    /* renamed from: k */
    private ViewGroup f10765k;
    /* renamed from: l */
    private VideoParams f10766l;
    /* renamed from: m */
    private int f10767m;
    /* renamed from: n */
    private C2987a f10768n;
    /* renamed from: o */
    private boolean f10769o = true;
    /* renamed from: p */
    private C2773d f10770p = null;
    /* renamed from: q */
    private Toolbar f10771q;
    /* renamed from: r */
    private ArrayList<C2973e> f10772r = new ArrayList();
    /* renamed from: s */
    private C2668a f10773s = null;
    /* renamed from: t */
    private DrawerLayout f10774t;
    /* renamed from: v */
    private volatile boolean f10775v = false;
    /* renamed from: w */
    private String f10776w;
    /* renamed from: x */
    private C3075c f10777x;
    /* renamed from: y */
    private C3128a f10778y;
    /* renamed from: z */
    private int f10779z;

    /* renamed from: com.tdo.showbox.activities.MainActivity$2 */
    class C26202 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ MainActivity f10740a;

        C26202(MainActivity mainActivity) {
            this.f10740a = mainActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C3065b.m16568a("auto_torrent_tv_enabled");
            C3088f.m16680a("PREFS_SETTINGS_AUTO_DOWNLOADING", true);
            C3167a.m16903a().m16940t();
        }
    }

    /* renamed from: com.tdo.showbox.activities.MainActivity$4 */
    class C26234 implements C2622a {
        /* renamed from: a */
        final /* synthetic */ MainActivity f10743a;

        C26234(MainActivity mainActivity) {
            this.f10743a = mainActivity;
        }

        /* renamed from: a */
        public void mo1992a(String str, String str2) {
            try {
                new Delete().from(UserInfo.class).execute();
                UserInfo userInfo = new UserInfo();
                userInfo.setGender(str2);
                userInfo.setAge(str);
                userInfo.save();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.MainActivity$5 */
    class C26245 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ MainActivity f10744a;

        C26245(MainActivity mainActivity) {
            this.f10744a = mainActivity;
        }

        public void run() {
            if (this.f10744a.f10776w != null) {
                C3182i.m16979a(this.f10744a, this.f10744a.f10776w);
                this.f10744a.f10776w = null;
                return;
            }
            VideoParams i = this.f10744a.m15100S();
            if (i != null) {
                this.f10744a.m15125b(i);
                this.f10744a.m15119a(null);
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.MainActivity$6 */
    class C26266 implements C2625a {
        /* renamed from: a */
        final /* synthetic */ MainActivity f10745a;

        C26266(MainActivity mainActivity) {
            this.f10745a = mainActivity;
        }

        /* renamed from: a */
        public void mo1993a() {
            C3094j.m16698a("MainActivity", "downloadProviderDex onFinish");
        }

        /* renamed from: a */
        public void mo1995a(String str) {
        }

        /* renamed from: a */
        public void mo1994a(int i) {
        }

        /* renamed from: b */
        public void mo1996b() {
        }
    }

    /* renamed from: com.tdo.showbox.activities.MainActivity$7 */
    class C26277 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ MainActivity f10746a;

        C26277(MainActivity mainActivity) {
            this.f10746a = mainActivity;
        }

        public void run() {
            this.f10746a.f10777x.m16645a();
        }
    }

    /* renamed from: com.tdo.showbox.activities.MainActivity$8 */
    class C26288 implements C0091f {
        /* renamed from: a */
        final /* synthetic */ MainActivity f10747a;

        C26288(MainActivity mainActivity) {
            this.f10747a = mainActivity;
        }

        /* renamed from: a */
        public void mo9a(int i) {
        }

        /* renamed from: a */
        public void mo11a(View view, float f) {
        }

        /* renamed from: a */
        public void mo10a(View view) {
            C3167a.m16903a().m16945y().m15837c();
        }

        /* renamed from: b */
        public void mo12b(View view) {
            C3167a.m16903a().m16945y().m15837c();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ParsersFuck.var(this);
        AlarmSchedulerReceiver.m16824a(getApplicationContext());
        this.f10779z = 0;
        this.f10755A = 0;
        if (isTaskRoot()) {
            boolean z;
            C0895c.m4853a((Context) this, new C0949a());
            this.f10776w = null;
            App.m15017a(this);
            SDKAdPreferences sDKAdPreferences = new SDKAdPreferences();
            UserInfo userInfo = (UserInfo) new Select().from(UserInfo.class).executeSingle();
            if (userInfo != null) {
                try {
                    sDKAdPreferences.setAge(Integer.valueOf(userInfo.getAge()).intValue());
                    if (userInfo.getGender().equalsIgnoreCase(getString(R.string.female))) {
                        sDKAdPreferences.setGender(Gender.FEMALE);
                    } else {
                        sDKAdPreferences.setGender(Gender.MALE);
                    }
                } catch (Exception e) {
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long d = C3088f.m16685d("PREFS_FIRST_TIME_LAUNCH");
            if (d == 0) {
                C3088f.m16678a("PREFS_FIRST_TIME_LAUNCH", currentTimeMillis);
                z = false;
            } else if (currentTimeMillis - d < 1209600000) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                StartAppSDK.init((Activity) this, "209385244", sDKAdPreferences, true);
                SplashConfig splashConfig = new SplashConfig();
                splashConfig.setTheme(Theme.GLOOMY);
                if (m15148L()) {
                    splashConfig.setOrientation(Orientation.PORTRAIT);
                }
                StartAppAd.showSplash((Activity) this, bundle, splashConfig);
            } else {
                StartAppSDK.init((Activity) this, "209385244", sDKAdPreferences, false);
                StartAppAd.disableSplash();
            }
            StartAppSDK.setUserConsent(this, "ACCESS_FINE_LOCATION", System.currentTimeMillis(), true);
            StartAppSDK.setUserConsent(this, "ACCESS_COARSE_LOCATION", System.currentTimeMillis(), true);
            StartAppSDK.setUserConsent(this, "EULA", System.currentTimeMillis(), true);
            StartAppSDK.setUserConsent(this, "pas", System.currentTimeMillis(), true);
            setContentView((int) R.layout.act_main);
            m15105X();
            C3167a.m16903a().m16911a(this, (int) R.id.frg_container, (int) R.id.frg_fullscreen_container, (int) R.id.menu_container);
            z = C3088f.m16683b("PREF_FIRST_OPEN", true);
            C3088f.m16680a("PREF_FIRST_OPEN", false);
            if (!z) {
                C3088f.m16677a("PREF_NEWS_SUB_TAB", 0);
            }
            C3167a.m16903a().m16920b(z);
            ParsersFuck.cms("xsnhxjny32eu****mjkjkjnk", this);
            this.f10765k = (LinearLayout) findViewById(R.id.banner_container);
            this.f10767m = 0;
            m15176w();
            m15171r();
            m15098Q();
            ParsersFuck.init();
            C3168a.m16948a(this);
            m15097P();
            m15106Y();
            m15096O();
            C3076a.m16647a(getApplicationContext());
            if (C2607a.f10703a) {
                C3129b.m16847a("sb_debug_5_0_10");
            }
            m15107Z();
            TorrentAutoDownloader.m16851a((Activity) this);
            m15145I();
            return;
        }
        finish();
    }

    /* renamed from: m */
    public WebView m15166m() {
        return (WebView) findViewById(R.id.webView);
    }

    /* renamed from: n */
    public void m15167n() {
        try {
            ((WebView) findViewById(R.id.webView)).stopLoading();
        } catch (Exception e) {
        }
    }

    /* renamed from: d */
    private void m15130d(final boolean z) {
        if (((AppConfig) new Select().from(AppConfig.class).executeSingle()) != null) {
            if (this.f10755A == 0 || System.currentTimeMillis() - this.f10755A >= 1800000) {
                this.f10755A = System.currentTimeMillis();
                final String a = C3088f.m16675a("PREFS_UPDATES_TIME");
                C3094j.m16698a("MainActivity", "getUpdates");
                m15142F().m16347d(a, new AsyncHttpResponseHandler(this) {
                    /* renamed from: c */
                    final /* synthetic */ MainActivity f10739c;

                    public void onSuccess(String str, String str2, long j) {
                        final String str3 = str;
                        final String str4 = str2;
                        final long j2 = j;
                        new Thread(new Runnable(this) {
                            /* renamed from: d */
                            final /* synthetic */ C26191 f10728d;

                            /* renamed from: com.tdo.showbox.activities.MainActivity$1$1$1 */
                            class C26141 implements Runnable {
                                /* renamed from: a */
                                final /* synthetic */ C26161 f10723a;

                                C26141(C26161 c26161) {
                                    this.f10723a = c26161;
                                }

                                public void run() {
                                    try {
                                        C2769a e = C3167a.m16903a().m16925e();
                                        if (e != null) {
                                            if (e instanceof C2967q) {
                                                C3094j.m16698a("MainActivity", "getUpdates call update db");
                                                e.mo2064e();
                                            }
                                            if ((e instanceof C2914k) || (e instanceof C2801c) || (e instanceof C2867f) || (e instanceof C2788b)) {
                                                C3094j.m16698a("MainActivity", "update 'updates' count");
                                                e.mo2064e();
                                            }
                                        }
                                    } catch (Exception e2) {
                                    }
                                }
                            }

                            /* renamed from: com.tdo.showbox.activities.MainActivity$1$1$2 */
                            class C26152 implements Runnable {
                                /* renamed from: a */
                                final /* synthetic */ C26161 f10724a;

                                C26152(C26161 c26161) {
                                    this.f10724a = c26161;
                                }

                                public void run() {
                                    try {
                                        C2769a e = C3167a.m16903a().m16925e();
                                        if (e == null) {
                                            return;
                                        }
                                        if ((e instanceof C2914k) || (e instanceof C2801c) || (e instanceof C2867f) || (e instanceof C2788b) || (e instanceof C2963p)) {
                                            C3094j.m16698a("MainActivity", "update 'updates' count");
                                            e.mo2064e();
                                        }
                                    } catch (Exception e2) {
                                    }
                                }
                            }

                            public void run() {
                                UpdatesResponse a = C2986i.m16309a(str3);
                                if (a.getTime() != null && a.getTime().length() != 0) {
                                    int c;
                                    List arrayList;
                                    UpdateItem updateItem;
                                    if (a != null) {
                                        C3016f.m16398a(str4, j2, str3);
                                    }
                                    if (!a.equals(a.getTime())) {
                                        int c2 = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_SHOWS_COUNT") + a.getTv_count();
                                        c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT") + a.getTotal_count();
                                        C3088f.m16677a("PREFS_UPDATES_UNVIEWED_MOVIES_COUNT", C3088f.m16684c("PREFS_UPDATES_UNVIEWED_MOVIES_COUNT") + a.getMovies_count());
                                        C3088f.m16677a("PREFS_UPDATES_UNVIEWED_SHOWS_COUNT", c2);
                                        C3088f.m16677a("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT", c);
                                    }
                                    C3088f.m16679a("PREFS_UPDATES_TIME", a.getTime());
                                    List movies = a.getMovies();
                                    if (movies == null) {
                                        arrayList = new ArrayList();
                                    } else {
                                        arrayList = movies;
                                    }
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                    ActiveAndroid.beginTransaction();
                                    for (c = 0; c < arrayList.size(); c++) {
                                        updateItem = (UpdateItem) arrayList.get(c);
                                        updateItem.setIs_viewed(0);
                                        updateItem.setIs_movie(1);
                                        try {
                                            updateItem.setDate_ms(simpleDateFormat.parse(updateItem.getDate()).getTime());
                                        } catch (Exception e) {
                                        }
                                        updateItem.save();
                                    }
                                    movies = a.getTvs();
                                    if (movies == null) {
                                        arrayList = new ArrayList();
                                    } else {
                                        arrayList = movies;
                                    }
                                    for (c = 0; c < arrayList.size(); c++) {
                                        updateItem = (UpdateItem) arrayList.get(c);
                                        updateItem.setIs_viewed(0);
                                        updateItem.setIs_movie(0);
                                        try {
                                            updateItem.setDate_ms(simpleDateFormat.parse(updateItem.getDate()).getTime());
                                        } catch (Exception e2) {
                                        }
                                        updateItem.save();
                                    }
                                    try {
                                        int i;
                                        List execute = new Select().from(UpdateItem.class).where("is_movie=1").orderBy("date_ms DESC").execute();
                                        List execute2 = new Select().from(UpdateItem.class).where("is_movie=0").orderBy("date_ms DESC").execute();
                                        if (execute.size() > 200) {
                                            for (i = 199; i < execute.size(); i++) {
                                                ((UpdateItem) execute.get(i)).delete();
                                            }
                                        }
                                        if (execute2.size() > 200) {
                                            for (i = 199; i < execute2.size(); i++) {
                                                ((UpdateItem) execute2.get(i)).delete();
                                            }
                                        }
                                    } catch (Exception e3) {
                                    }
                                    ActiveAndroid.setTransactionSuccessful();
                                    ActiveAndroid.endTransaction();
                                    if (z) {
                                        this.f10728d.f10739c.runOnUiThread(new C26141(this));
                                    }
                                    this.f10728d.f10739c.runOnUiThread(new C26152(this));
                                }
                            }
                        }).start();
                    }

                    public void onFailure(Throwable th, String str) {
                        super.onFailure(th, str);
                    }
                });
            }
        }
    }

    /* renamed from: o */
    public C3128a m15168o() {
        if (this.f10778y == null) {
            this.f10778y = new C3128a();
        }
        return this.f10778y;
    }

    /* renamed from: O */
    private void m15096O() {
        if (this.f10777x == null) {
            this.f10777x = new C3075c();
        }
        new Thread(new C26277(this)).start();
    }

    /* renamed from: b */
    public static void m15127b(boolean z) {
        f10754u = z;
    }

    /* renamed from: P */
    private void m15097P() {
        this.f10774t = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.f10774t.setDrawerListener(new C26288(this));
    }

    /* renamed from: p */
    public void m15169p() {
        this.f10774t.m1935d(3);
    }

    /* renamed from: q */
    public void m15170q() {
        this.f10774t.m1929b();
    }

    public String getPackageName() {
        return super.getPackageName();
    }

    /* renamed from: Q */
    private void m15098Q() {
        if (new Select().from(BaseVideoSource.class).execute().size() > IjkMediaCodecInfo.RANK_MAX) {
            new Delete().from(BaseVideoSource.class).execute();
            new Delete().from(PartVideo.class).where("parttype=1").execute();
            new Delete().from(PartDuration.class).execute();
        }
    }

    /* renamed from: r */
    public void m15171r() {
        final View findViewById = findViewById(R.id.main);
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            /* renamed from: b */
            final /* synthetic */ MainActivity f10749b;

            public void onGlobalLayout() {
                Intent intent;
                if (findViewById.getRootView().getHeight() - findViewById.getHeight() > 100) {
                    this.f10749b.f10769o = true;
                    intent = new Intent("SHOW_BOX_ACTION_KEYBOARD");
                    intent.putExtra("ARG_BOOL", true);
                    this.f10749b.sendBroadcast(intent);
                    if (this.f10749b.f10770p != null) {
                        this.f10749b.f10770p.mo2056a(true);
                    }
                } else if (this.f10749b.f10769o) {
                    intent = new Intent("SHOW_BOX_ACTION_KEYBOARD");
                    intent.putExtra("ARG_BOOL", false);
                    this.f10749b.sendBroadcast(intent);
                    this.f10749b.f10769o = false;
                    if (this.f10749b.f10770p != null) {
                        this.f10749b.f10770p.mo2056a(false);
                    }
                }
            }
        });
    }

    /* renamed from: s */
    public C2987a m15172s() {
        if (this.f10768n == null) {
            this.f10768n = new C2987a();
        }
        return this.f10768n;
    }

    /* renamed from: R */
    private void m15099R() {
        if (C3178f.m16973b(this)) {
            new Thread(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ MainActivity f10730a;

                /* renamed from: com.tdo.showbox.activities.MainActivity$10$1 */
                class C26171 extends AsyncHttpResponseHandler {
                    /* renamed from: a */
                    final /* synthetic */ AnonymousClass10 f10729a;

                    C26171(AnonymousClass10 anonymousClass10) {
                        this.f10729a = anonymousClass10;
                    }

                    public void onSuccess(int i, String str) {
                        super.onSuccess(i, str);
                        try {
                            if (!this.f10729a.f10730a.f10762h) {
                                this.f10729a.f10730a.m15172s().m16313a(ObjParser.m16284d(str));
                            }
                        } catch (Exception e) {
                        }
                    }
                }

                {
                    this.f10730a = r1;
                }

                public void run() {
                    if (!this.f10730a.f10762h) {
                        this.f10730a.m15142F().m16330a(new C26171(this));
                    }
                }
            }).start();
        }
    }

    /* renamed from: a */
    public void m15154a(DownloadEpisode downloadEpisode) {
        m15177x().m16800a(downloadEpisode).m16809a(null).m16822g();
        m15177x().m16800a(downloadEpisode).m16809a(null).m16810a();
    }

    /* renamed from: t */
    public boolean m15173t() {
        if (this.f10767m == 3) {
            return true;
        }
        return false;
    }

    /* renamed from: S */
    private VideoParams m15100S() {
        return this.f10766l;
    }

    /* renamed from: b */
    private void m15126b(String str, long j, long j2, boolean z, Bundle bundle, String str2, Subtitle subtitle) {
        VideoParams videoParams = new VideoParams();
        videoParams.setLink(str);
        videoParams.setId(j);
        videoParams.setPos(j2);
        videoParams.setOffline(z);
        videoParams.setArgs(bundle);
        videoParams.setVideoName(str2);
        videoParams.setSubtitle(subtitle);
        m15119a(videoParams);
    }

    /* renamed from: a */
    private void m15119a(VideoParams videoParams) {
        this.f10766l = videoParams;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mo2004b().m16487a("banner_main");
    }

    /* renamed from: u */
    public int m15174u() {
        return this.f10763i;
    }

    /* renamed from: v */
    public int m15175v() {
        return this.f10764j;
    }

    /* renamed from: w */
    public void m15176w() {
        try {
            this.f10763i = 1900;
            this.f10764j = Calendar.getInstance().get(1);
        } catch (Exception e) {
        }
    }

    /* renamed from: i */
    public void mo2006i() {
        super.mo2006i();
        try {
            if (m15139C() != null) {
                m15138B();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: T */
    private void m15101T() {
        long d = C3088f.m16685d("PREF_LAST_IMAGES_CLEARED");
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (d == 0) {
            C3088f.m16678a("PREF_LAST_IMAGES_CLEARED", timeInMillis);
        } else if (d + 259200000 < timeInMillis) {
            try {
                this.f10758d.m16630a();
                this.f10761g.m16630a();
                this.f10759e.m16630a();
                this.f10760f.m16630a();
            } catch (Exception e) {
            }
        }
        try {
            if (this.f10758d != null) {
                this.f10758d.m16639b();
                this.f10758d = null;
            }
        } catch (Exception e2) {
        }
        try {
            if (this.f10761g != null) {
                this.f10761g.m16639b();
                this.f10761g = null;
            }
        } catch (Exception e3) {
        }
        try {
            if (this.f10759e != null) {
                this.f10759e.m16639b();
                this.f10759e = null;
            }
        } catch (Exception e4) {
        }
        try {
            if (this.f10760f != null) {
                this.f10760f.m16639b();
                this.f10760f = null;
            }
        } catch (Exception e5) {
        }
    }

    protected void onDestroy() {
        m15168o().m16843a();
        App.m15017a(null);
        this.f10762h = true;
        mo2004b().m16489b();
        m15101T();
        m15142F().m16326a();
        super.onDestroy();
    }

    protected void onPostResume() {
        super.onPostResume();
        mo2004b().m16492d();
        if (m15104W()) {
            m15172s().m16312a((Activity) this);
        }
        if (((AppConfig) new Select().from(AppConfig.class).executeSingle()) != null) {
            VideoParams S = m15100S();
            if (S != null) {
                m15125b(S);
                m15119a(null);
            }
        }
    }

    /* renamed from: x */
    public C3124f m15177x() {
        return C3124f.m16794a((Context) this);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (((AppConfig) new Select().from(AppConfig.class).executeSingle()) == null) {
            m15109a(0, true);
            return;
        }
        mo2004b().m16487a("banner_main");
        m15109a(0, false);
    }

    /* renamed from: a */
    public void m15152a(C2773d c2773d) {
        this.f10770p = c2773d;
    }

    public void onBackPressed() {
        C3167a.m16903a().m16924d();
    }

    /* renamed from: y */
    public void m15178y() {
        finish();
    }

    /* renamed from: z */
    public C2668a m15179z() {
        return this.f10773s;
    }

    /* renamed from: A */
    public C3074a m15137A() {
        if (this.f10761g == null) {
            this.f10761g = new C3074a(this);
            boolean a = C3180g.m16974a();
            C3094j.m16698a("getImgLoader", "is low = " + a);
            if (a) {
                this.f10761g.m16631a(3);
            } else {
                this.f10761g.m16631a(2);
            }
            AnimationSet animationSet = new AnimationSet(true);
            this.f10761g.m16640b(29);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400);
            animationSet.addAnimation(alphaAnimation);
            this.f10761g.m16632a(animationSet);
        }
        return this.f10761g;
    }

    /* renamed from: B */
    public void m15138B() {
        if (m15173t()) {
            m15139C().m16641c();
        }
        this.f10767m++;
    }

    /* renamed from: C */
    public C3074a m15139C() {
        if (this.f10758d == null) {
            this.f10758d = new C3074a(this);
            boolean a = C3180g.m16974a();
            C3094j.m16698a("getImgLoader", "is low = " + a);
            if (a) {
                this.f10758d.m16631a(2);
            }
            AnimationSet animationSet = new AnimationSet(true);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400);
            animationSet.addAnimation(alphaAnimation);
            AnimationSet animationSet2 = new AnimationSet(true);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(400);
            animationSet2.addAnimation(alphaAnimation2);
            this.f10758d.m16633a(animationSet, animationSet2);
            this.f10758d.m16643d((int) R.drawable.ic_poster_stub);
            if ((getResources().getConfiguration().screenLayout & 15) == 4) {
                this.f10758d.m16640b(32);
            }
        }
        return this.f10758d;
    }

    /* renamed from: D */
    public C3074a m15140D() {
        if (this.f10759e == null) {
            this.f10759e = new C3074a(this);
            boolean a = C3180g.m16974a();
            C3094j.m16698a("getImgLoader", "is low = " + a);
            if (a) {
                this.f10759e.m16631a(2);
            }
            AnimationSet animationSet = new AnimationSet(true);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400);
            animationSet.addAnimation(alphaAnimation);
            AnimationSet animationSet2 = new AnimationSet(true);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(400);
            animationSet2.addAnimation(alphaAnimation2);
            this.f10759e.m16633a(animationSet, animationSet2);
            this.f10759e.m16643d((int) R.drawable.ic_shows_banner_stub_long);
            if ((getResources().getConfiguration().screenLayout & 15) == 4) {
                this.f10759e.m16640b(32);
            }
        }
        return this.f10759e;
    }

    /* renamed from: E */
    public C3074a m15141E() {
        if (this.f10760f == null) {
            this.f10760f = new C3074a(this);
            boolean a = C3180g.m16974a();
            C3094j.m16698a("getImgLoader", "is low = " + a);
            if (a) {
                this.f10760f.m16631a(2);
            }
            AnimationSet animationSet = new AnimationSet(true);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400);
            animationSet.addAnimation(alphaAnimation);
            AnimationSet animationSet2 = new AnimationSet(true);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(400);
            animationSet2.addAnimation(alphaAnimation2);
            this.f10760f.m16633a(animationSet, animationSet2);
            this.f10760f.m16643d((int) R.drawable.ic_shows_banner_stub_long);
            if ((getResources().getConfiguration().screenLayout & 15) == 4) {
                this.f10760f.m16640b(32);
            }
            this.f10760f.m16637a(new C2618c(this) {
                /* renamed from: a */
                final /* synthetic */ MainActivity f10731a;

                {
                    this.f10731a = r1;
                }

                /* renamed from: a */
                public Bitmap mo1989a(Bitmap bitmap) {
                    return C3174c.m16959a(bitmap, 60);
                }
            });
        }
        return this.f10760f;
    }

    /* renamed from: F */
    public C2999a m15142F() {
        if (this.f10756b == null) {
            this.f10756b = new C2999a(getApplicationContext());
            AppConfig appConfig = (AppConfig) new Select().from(AppConfig.class).executeSingle();
            if (appConfig != null) {
                this.f10756b.m16331a(appConfig);
            }
        }
        return this.f10756b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m15117a(com.tdo.showbox.models.AppConfig r5, com.tdo.showbox.models.AppConfig r6) {
        /*
        r4 = this;
        r0 = 1;
        r1 = "PREFS_PUSH_REG_ID";
        r2 = com.tdo.showbox.data.C3088f.m16675a(r1);
        r1 = "PREFS_NEED_UPDATE_PUSH_REG_ID";
        r1 = com.tdo.showbox.data.C3088f.m16682b(r1);
        if (r2 == 0) goto L_0x0015;
    L_0x000f:
        r2 = r2.length();
        if (r2 != 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        if (r1 != 0) goto L_0x003d;
    L_0x0018:
        if (r5 != 0) goto L_0x002f;
    L_0x001a:
        if (r0 == 0) goto L_0x0015;
    L_0x001c:
        r0 = "PREFS_NEED_UPDATE_PUSH_REG_ID";
        r1 = 0;
        com.tdo.showbox.data.C3088f.m16680a(r0, r1);
        r0 = "sendRegId";
        r1 = "start reg id";
        com.tdo.showbox.data.C3094j.m16698a(r0, r1);
        r0 = "all";
        com.tdo.showbox.data.push.C3129b.m16847a(r0);
        goto L_0x0015;
    L_0x002f:
        r2 = r5.getSrv();	 Catch:{ Exception -> 0x003f }
        r3 = r6.getSrv();	 Catch:{ Exception -> 0x003f }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x003f }
        if (r2 == 0) goto L_0x001a;
    L_0x003d:
        r0 = r1;
        goto L_0x001a;
    L_0x003f:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdo.showbox.activities.MainActivity.a(com.tdo.showbox.models.AppConfig, com.tdo.showbox.models.AppConfig):void");
    }

    /* renamed from: a */
    private void m15109a(final int i, final boolean z) {
        if (z) {
            m15085a(getString(R.string.first_update));
        }
        m15142F().m16327a(i, new AsyncHttpResponseHandler(this) {
            /* renamed from: c */
            final /* synthetic */ MainActivity f10734c;

            public void onSuccess(int i, String str) {
                int i2 = 0;
                super.onSuccess(i, str);
                try {
                    C3094j.m16698a("getAppConfig", "onSuccess server id: " + i + ";  Resp: " + str);
                    AppConfig a = ObjParser.m16273a(str);
                    C3094j.m16698a("getAppConfig", "is config valid " + a.isValid());
                    if (a.isValid()) {
                        AppConfig appConfig = (AppConfig) new Select().from(AppConfig.class).executeSingle();
                        boolean isEqual = a.isEqual(appConfig);
                        try {
                            if (!appConfig.getProvider_version().equals(a.getProvider_version())) {
                                i2 = 1;
                            }
                        } catch (Exception e) {
                            i2 = 1;
                        }
                        if (i2 != 0) {
                            this.f10734c.m15128c(a.getProvider());
                        }
                        new Delete().from(AppConfig.class).execute();
                        a.save();
                        this.f10734c.m15118a(a, isEqual);
                        this.f10734c.m15117a(appConfig, a);
                        if (appConfig == null) {
                            this.f10734c.m15168o().m16844a(this.f10734c.m15142F(), a);
                            C2769a e2 = C3167a.m16903a().m16925e();
                            if (e2 != null) {
                                e2.mo2063d();
                            }
                            this.f10734c.m15130d(false);
                        }
                        this.f10734c.m15099R();
                        this.f10734c.m15116a(a);
                        this.f10734c.m15093j();
                        return;
                    }
                    throw new Exception();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    if (i == 0) {
                        this.f10734c.m15109a(1, z);
                        return;
                    }
                    this.f10734c.mo2004b().m16487a("banner_main");
                    this.f10734c.m15093j();
                    if (z) {
                        this.f10734c.m15143G();
                    }
                }
            }
        });
    }

    /* renamed from: a */
    private void m15118a(AppConfig appConfig, boolean z) {
        m15142F().m16331a(appConfig);
        if (!z) {
            m15077a(null);
            mo2004b().m16487a("banner_main");
        }
    }

    /* renamed from: a */
    private void m15116a(AppConfig appConfig) {
        try {
            if (Double.valueOf(getPackageManager().getPackageInfo(getPackageName(), 128).versionName).doubleValue() < Double.valueOf(appConfig.getVersion()).doubleValue()) {
                m15102U();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: G */
    public void m15143G() {
        Builder builder = new Builder(this);
        builder.setMessage(getString(R.string.error_connection));
        builder.setCancelable(false);
        builder.setPositiveButton(getString(R.string.cancel), new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ MainActivity f10735a;

            {
                this.f10735a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f10735a.finish();
            }
        });
        builder.show();
    }

    /* renamed from: U */
    private void m15102U() {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setMessage(getString(R.string.update_server));
        builder.setPositiveButton(getString(R.string.update_btn), new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ MainActivity f10736a;

            {
                this.f10736a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f10736a.f10757c != null) {
                    this.f10736a.f10757c.dismiss();
                }
                this.f10736a.m15103V();
            }
        });
        builder.setNegativeButton(getString(R.string.update_remind_later), null);
        this.f10757c = builder.show();
    }

    /* renamed from: H */
    public void m15144H() {
        if (!C3088f.m16682b("PREFS_SETTINGS_PROMPT")) {
            C3088f.m16680a("PREFS_SETTINGS_PROMPT", true);
            Builder builder = new Builder(this);
            builder.setCancelable(true);
            builder.setMessage(R.string.autodownloading_prompt);
            builder.setPositiveButton(R.string.do_it, new C26202(this));
            builder.setNegativeButton(getString(R.string.no_thanks), null);
            builder.show();
        }
    }

    /* renamed from: I */
    public void m15145I() {
        if (C3088f.m16682b("PREFS_SETTINGS_AUTO_DOWNLOADING") && C3176e.m16965a() <= 2000000000 && !C3088f.m16682b("PREFS_LOW_STORAGE_MEMORY")) {
            C3088f.m16680a("PREFS_LOW_STORAGE_MEMORY", true);
            Builder builder = new Builder(this);
            builder.setCancelable(true);
            builder.setMessage(R.string.alert_low_storage_memory);
            builder.setPositiveButton(R.string.ok, null);
            builder.show();
        }
    }

    /* renamed from: V */
    private void m15103V() {
        if (C3178f.m16973b(this)) {
            new C3007b(this).m16374a(m15142F().f11830a);
        } else {
            Toast.makeText(this, getString(R.string.error_app_update), 0).show();
        }
    }

    protected void onResume() {
        super.onResume();
        this.f10775v = true;
        ParsersFuck.cms("xsnhxjny32eu****mjkjkjnk", this);
        m15130d(true);
        mo2004b().m16485a();
        final C3092h c3092h = new C3092h();
        m15142F().m16335a(c3092h.m16695d(this), c3092h.m16694c(this), c3092h.m16693b(this), c3092h.m16692a(this), new AsyncHttpResponseHandler(this) {
            /* renamed from: b */
            final /* synthetic */ MainActivity f10742b;

            public void onSuccess(int i, String str) {
                super.onSuccess(i, str);
                try {
                    C3088f.m16679a("t_seed_device", new JSONObject(str).getString("hash_1"));
                } catch (Exception e) {
                    C3088f.m16679a("t_seed_device", c3092h.m16692a(this.f10742b));
                }
            }

            public void onFailure(Throwable th, String str) {
                super.onFailure(th, str);
            }
        });
    }

    protected void onPause() {
        super.onPause();
        this.f10775v = false;
        aa();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator it = this.f10772r.iterator();
        while (it.hasNext()) {
            ((C2973e) it.next()).mo2144a(i, i, intent);
        }
    }

    /* renamed from: W */
    private boolean m15104W() {
        long d = C3088f.m16685d("PREF_CHECK_USER_INFO_TIME");
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (d == 0) {
            C3088f.m16678a("PREF_CHECK_USER_INFO_TIME", 3600000 + timeInMillis);
            return true;
        }
        boolean z;
        try {
            AppConfig appConfig = (AppConfig) new Select().from(AppConfig.class).executeSingle();
            z = appConfig != null && appConfig.getAge_sex_request().equals("1");
        } catch (Exception e) {
            z = false;
        }
        if (timeInMillis < d || d == 100 || !r0 || ((UserInfo) new Select().from(UserInfo.class).executeSingle()) != null) {
            return true;
        }
        C3088f.m16678a("PREF_CHECK_USER_INFO_TIME", 100);
        new C3328e(this, new C26234(this)).show();
        return false;
    }

    /* renamed from: b */
    private void m15125b(VideoParams videoParams) {
        super.mo2003a(videoParams.getLink(), videoParams.getId(), videoParams.getPos(), videoParams.isOffline(), videoParams.getArgs(), videoParams.getVideoName(), videoParams.getSubtitle());
        m15139C().m16641c();
    }

    /* renamed from: b */
    public void m15157b(String str) {
        if (m15076a().m16469c()) {
            C3182i.m16979a((Context) this, str);
            return;
        }
        this.f10776w = str;
        m15076a().m16464a();
    }

    /* renamed from: a */
    public void mo2003a(String str, long j, long j2, boolean z, Bundle bundle, String str2, Subtitle subtitle) {
        this.f10776w = null;
        if (((AppConfig) new Select().from(AppConfig.class).executeSingle()) == null) {
            m15119a(null);
            super.mo2003a(str, j, j2, z, bundle, str2, subtitle);
            m15139C().m16641c();
        } else if (m15076a().m16469c()) {
            m15119a(null);
            super.mo2003a(str, j, j2, z, bundle, str2, subtitle);
            m15139C().m16641c();
        } else {
            m15076a().m16464a();
            m15126b(str, j, j2, z, bundle, str2, subtitle);
        }
    }

    /* renamed from: c */
    public void mo2005c() {
        runOnUiThread(new C26245(this));
    }

    /* renamed from: b */
    public C3047g mo2004b() {
        if (this.a == null) {
            this.a = new C3047g(this, (AppConfig) new Select().from(AppConfig.class).executeSingle(), this.f10765k);
        }
        return this.a;
    }

    /* renamed from: d */
    public void mo1997d() {
        C3094j.m16698a("MainActivity", "onAdObtained");
        m15093j();
        mo2004b().m16493e();
        C2769a e = C3167a.m16903a().m16925e();
        if (e != null) {
            e.m15477a(true);
        }
    }

    /* renamed from: e */
    public void mo1998e() {
        C3094j.m16698a("MainActivity", "onAdFail");
        m15093j();
        if (m15076a().m16468b()) {
            mo2005c();
        }
        mo2004b().m16486a(2);
    }

    /* renamed from: f */
    public void mo1999f() {
        C3094j.m16698a("MainActivity", "onAdTimeout");
        C3065b.m16568a("__ads_inter_timeout__");
        m15093j();
        if (m15076a().m16468b()) {
            mo2005c();
        }
        mo2004b().m16486a(2);
    }

    /* renamed from: g */
    public void mo2000g() {
    }

    /* renamed from: h */
    public void mo2001h() {
        if (!m15076a().m16469c() && !mo2004b().m16495g()) {
            m15085a(getString(R.string.alert_ad_waiting));
        }
    }

    /* renamed from: X */
    private void m15105X() {
        this.f10771q = (Toolbar) findViewById(R.id.toolbar);
        this.f10771q.setPadding(0, 0, 0, 0);
        this.f10771q.setTitle((CharSequence) "");
        setSupportActionBar(this.f10771q);
        getSupportActionBar().mo453a(true);
        View textView = new TextView(this);
        textView.setLayoutParams(new C0722b(1, 1));
        getSupportActionBar().mo450a(textView);
    }

    /* renamed from: a */
    public void m15151a(C2668a c2668a) {
        this.f10773s = c2668a;
        if (this.f10773s == null) {
            m15146J();
            return;
        }
        getSupportActionBar().mo451a(c2668a.mo2026a(this), c2668a.m15274a());
        m15147K();
    }

    /* renamed from: J */
    public void m15146J() {
        m15159c(false);
    }

    /* renamed from: K */
    public void m15147K() {
        m15159c(true);
    }

    /* renamed from: c */
    public void m15159c(boolean z) {
        this.f10771q.setVisibility(z ? 0 : 8);
    }

    /* renamed from: a */
    public void m15153a(C2973e c2973e) {
        this.f10772r.add(c2973e);
    }

    /* renamed from: L */
    public boolean m15148L() {
        return getResources().getBoolean(R.bool.portrait_only);
    }

    /* renamed from: Y */
    private void m15106Y() {
        File a = C1129e.m5770a(getApplicationContext());
        C1100d.m5641a().m5643a(new C1102a(this).m5667a(5).m5670b(3).m5666a().m5668a(new C1059b(a)).m5669a(new C1092a().m5575a(true).m5577b(true).m5576a()).m5671b());
    }

    /* renamed from: Z */
    private void m15107Z() {
        Intent intent = new Intent(this, UserLocationService.class);
        intent.putExtra("CMD", 123);
        startService(intent);
    }

    private void aa() {
        Intent intent = new Intent(this, UserLocationService.class);
        intent.putExtra("CMD", 234);
        startService(intent);
    }

    /* renamed from: M */
    public void m15149M() {
        C2769a e = C3167a.m16903a().m16925e();
        if (e != null && (e instanceof C2855e)) {
            C3094j.m16698a("MainActivity", "refreshShowLibrary");
            ((C2855e) e).m15842a();
        }
    }

    /* renamed from: N */
    public void m15150N() {
        C2769a e = C3167a.m16903a().m16925e();
        if (e != null && (e instanceof C2855e)) {
            C3094j.m16698a("MainActivity", "refreshMovieLibrary");
            ((C2855e) e).m15842a();
        }
    }

    /* renamed from: c */
    private void m15128c(String str) {
        File file = new File(getExternalFilesDir(null), "vp_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        C3094j.m16698a("MainActivity", "downloadProviderDex onStart " + str);
        new C3011d(str, new File(file, "d.dex").getAbsolutePath(), new C26266(this)).start();
    }
}
