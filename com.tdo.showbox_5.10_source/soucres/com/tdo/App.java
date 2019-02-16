package com.tdo.showbox;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.provider.Settings.Secure;
import android.support.p009a.C0080b;
import android.text.TextUtils;
import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.flurry.android.FlurryAgent.Builder;
import com.flurry.android.FlurryAgentListener;
import com.frostwire.jlibtorrent.Session;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.data.C3087e;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.MovieItemMeta;
import com.tdo.showbox.models.SeasonLastViewItem;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.models.UpdateItem;
import com.tdo.showbox.models.ViewedEpizode;
import com.tdo.showbox.models.topic.CurrentTopicScheme;
import com.tdo.showbox.models.topic.FbTopic;
import com.tdo.showbox.models.topic.TopicTimeItem;
import java.util.List;
import java.util.Random;

public class App extends C0080b {
    /* renamed from: a */
    public static ApplicationInfo f10693a;
    /* renamed from: b */
    public static boolean f10694b;
    /* renamed from: c */
    private static MainActivity f10695c;
    /* renamed from: d */
    private static Session f10696d;
    /* renamed from: e */
    private static Context f10697e = null;

    /* renamed from: com.tdo.showbox.App$1 */
    class C26051 implements FlurryAgentListener {
        /* renamed from: a */
        final /* synthetic */ App f10692a;

        C26051(App app) {
            this.f10692a = app;
        }

        public void onSessionStarted() {
            C3094j.m16698a("FlurryAgent", "Session started");
        }
    }

    public void onCreate() {
        int i = 500;
        super.onCreate();
        C2607a.f10703a = false;
        C2607a.f10704b = false;
        if ("release".equalsIgnoreCase("debug")) {
            C2607a.f10703a = true;
        }
        f10693a = getApplicationInfo();
        f10694b = false;
        C3088f.m16676a(getApplicationContext());
        f10697e = getApplicationContext();
        m15022d();
        C3087e.m16673a(getApplicationContext());
        ActiveAndroid.initialize((Context) this);
        try {
            String a = C3088f.m16675a("PREF_VERSION");
            String str = getPackageManager().getPackageInfo(getPackageName(), 128).versionName;
            if (!a.equals(str)) {
                m15018a(str);
                C3088f.m16679a("PREF_VERSION", str);
            }
        } catch (Exception e) {
            m15018a("");
        }
        if (C3088f.m16681b("PREFS_FIRST_START", -1) == -1) {
            C3088f.m16677a("PREFS_FIRST_START", 1);
        }
        new Builder().withLogEnabled(false).withListener(new C26051(this)).build(this, "B9WT7MY7RWC9XXV6T474");
        ActiveAndroid.beginTransaction();
        try {
            int i2;
            List execute = new Select().from(MovieItemMeta.class).execute();
            if (execute.size() > 1500) {
                for (i2 = 500; i2 < execute.size(); i2++) {
                    ((MovieItemMeta) execute.get(i2)).delete();
                }
            }
            if (new Select().from(FbTopic.class).execute().size() > 1500) {
                new Delete().from(FbTopic.class).execute();
            }
            execute = new Select().from(ViewedEpizode.class).execute();
            if (execute.size() > 1500) {
                for (i2 = 500; i2 < execute.size(); i2++) {
                    ((ViewedEpizode) execute.get(i2)).delete();
                }
            }
            List execute2 = new Select().from(SeasonLastViewItem.class).execute();
            if (execute2.size() > 1500) {
                while (i < execute2.size()) {
                    ((SeasonLastViewItem) execute2.get(i)).delete();
                    i++;
                }
            }
            execute2 = new Select().from(MovieItem.class).where("from_push=1 AND in_lib=0").execute();
            execute = new Select().from(TvItem.class).where("from_push=1 AND in_lib=0").execute();
            if (execute2.size() > 200) {
                for (i = 50; i < execute2.size(); i++) {
                    ((MovieItem) execute2.get(i)).delete();
                }
            }
            if (execute.size() > 200) {
                for (i = 50; i < execute.size(); i++) {
                    ((TvItem) execute.get(i)).delete();
                }
            }
        } catch (Exception e2) {
        }
        ActiveAndroid.setTransactionSuccessful();
        ActiveAndroid.endTransaction();
        ParsersFuck.cms("xsnhxjny32eu****mjkjkjnk", this);
        int b = C3088f.m16681b("PREFS_PLAYER_MODE", 1);
        if (b < 0 || b >= 3) {
            C3088f.m16677a("PREFS_PLAYER_MODE", 1);
        }
    }

    /* renamed from: d */
    private void m15022d() {
        Object a = C3088f.m16675a("PREF_DEV_ID");
        if (TextUtils.isEmpty(a)) {
            String str;
            try {
                a = Secure.getString(getApplicationContext().getContentResolver(), "android_id");
            } catch (Throwable th) {
            }
            if (TextUtils.isEmpty(a)) {
                str = "gen_" + new Random().nextInt() + System.nanoTime();
            } else {
                str = a + System.nanoTime();
            }
            C3088f.m16679a("PREF_DEV_ID", str);
        }
    }

    /* renamed from: a */
    public static Session m15016a() {
        if (f10696d == null) {
            f10696d = new Session();
        }
        if (f10696d.isPaused()) {
            f10696d.resume();
        }
        f10696d.resume();
        return f10696d;
    }

    /* renamed from: b */
    public static MainActivity m15019b() {
        return f10695c;
    }

    /* renamed from: a */
    public static void m15017a(MainActivity mainActivity) {
        f10695c = mainActivity;
    }

    public void onTerminate() {
        super.onTerminate();
        f10693a = null;
        ActiveAndroid.dispose();
    }

    /* renamed from: a */
    private void m15018a(String str) {
        f10694b = true;
        System.out.println("version changed: " + str);
        C3088f.m16677a("PREF_LIB_SUB_TAB", (int) R.id.txtv_shows);
        m15020b(str);
    }

    /* renamed from: b */
    private void m15020b(String str) {
        try {
            if (str.equals("4.82")) {
                new Delete().from(TopicTimeItem.class).execute();
                new Delete().from(FbTopic.class).execute();
                new Delete().from(CurrentTopicScheme.class).execute();
            } else if (str.equals("4.91")) {
                new Delete().from(UpdateItem.class).execute();
                C3088f.m16679a("PREFS_UPDATES_TIME", "");
                C3088f.m16677a("PREFS_UPDATES_UNVIEWED_MOVIES_COUNT", 0);
                C3088f.m16677a("PREFS_UPDATES_UNVIEWED_SHOWS_COUNT", 0);
                C3088f.m16677a("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static Context m15021c() {
        return f10697e;
    }
}
