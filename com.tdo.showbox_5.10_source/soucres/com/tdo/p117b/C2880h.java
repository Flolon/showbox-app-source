package com.tdo.showbox.p117b;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.activities.NewsDetailsActivity;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2717g;
import com.tdo.showbox.activities.p115a.C2717g.C2716a;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.ObjParser;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.p112c.C3074a;
import com.tdo.showbox.data.p119b.C3056k;
import com.tdo.showbox.data.p119b.C3056k.C2871a;
import com.tdo.showbox.models.News;
import com.tdo.showbox.models.NewsDetails;
import com.tdo.showbox.models.UserInfo;
import com.tdo.showbox.p121g.p134b.C3193a;
import com.tdo.showbox.p121g.p134b.C3201b;
import com.tdo.showbox.p121g.p134b.C3203c;
import com.tdo.showbox.p131f.C3178f;
import com.tdo.showbox.p131f.C3180g;
import com.tdo.showbox.views.ExtListView;
import com.tdo.showbox.views.ExtListView.C2746a;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: NewsFragment */
/* renamed from: com.tdo.showbox.b.h */
public class C2880h extends C2769a implements C2716a {
    /* renamed from: c */
    private final int f11425c = 3;
    /* renamed from: d */
    private final int f11426d = IjkMediaCodecInfo.RANK_MAX;
    /* renamed from: e */
    private int f11427e;
    /* renamed from: f */
    private long f11428f = 0;
    /* renamed from: g */
    private boolean f11429g;
    /* renamed from: h */
    private C2717g f11430h = new C2717g();
    /* renamed from: i */
    private ExtListView f11431i;
    /* renamed from: j */
    private C3193a f11432j;
    /* renamed from: k */
    private List<News> f11433k;
    /* renamed from: l */
    private View f11434l;
    /* renamed from: m */
    private C3074a f11435m;
    /* renamed from: n */
    private String f11436n = "";
    /* renamed from: o */
    private C3056k f11437o;

    /* compiled from: NewsFragment */
    /* renamed from: com.tdo.showbox.b.h$1 */
    class C28701 implements C2746a {
        /* renamed from: a */
        final /* synthetic */ C2880h f11413a;

        C28701(C2880h c2880h) {
            this.f11413a = c2880h;
        }

        /* renamed from: a */
        public void mo2031a() {
            this.f11413a.f11431i.m17205a();
            this.f11413a.m15911a().m16513a().m16438g();
        }
    }

    /* compiled from: NewsFragment */
    /* renamed from: com.tdo.showbox.b.h$2 */
    class C28722 implements C2871a {
        /* renamed from: a */
        final /* synthetic */ C2880h f11414a;

        C28722(C2880h c2880h) {
            this.f11414a = c2880h;
        }

        /* renamed from: a */
        public void mo2074a() {
            if (this.f11414a.f11431i != null && this.f11414a.f11432j != null) {
                int firstVisiblePosition = this.f11414a.f11431i.getFirstVisiblePosition();
                this.f11414a.m15911a().m16517a(this.f11414a.f11431i, this.f11414a.f11432j);
                this.f11414a.f11431i.setSelection(firstVisiblePosition);
                if (this.f11414a.m15911a().m16522c()) {
                    this.f11414a.m15899b(this.f11414a.m15911a().m16513a().m16433b());
                }
            }
        }
    }

    /* compiled from: NewsFragment */
    /* renamed from: com.tdo.showbox.b.h$a */
    public interface C2876a {
        /* renamed from: a */
        void mo2075a();

        /* renamed from: a */
        void mo2076a(String str, String str2, List<News> list);
    }

    /* compiled from: NewsFragment */
    /* renamed from: com.tdo.showbox.b.h$4 */
    class C28774 implements C2876a {
        /* renamed from: a */
        final /* synthetic */ C2880h f11422a;

        C28774(C2880h c2880h) {
            this.f11422a = c2880h;
        }

        /* renamed from: a */
        public void mo2076a(String str, String str2, List<News> list) {
            this.f11422a.m15902c(false);
            this.f11422a.f11433k = list;
            this.f11422a.m15906l();
        }

        /* renamed from: a */
        public void mo2075a() {
            this.f11422a.m15902c(true);
            this.f11422a.f11431i.setAdapter(null);
        }
    }

    /* compiled from: NewsFragment */
    /* renamed from: com.tdo.showbox.b.h$5 */
    class C28785 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ C2880h f11423a;

        C28785(C2880h c2880h) {
            this.f11423a = c2880h;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C3065b.m16569a("news_details", "tab", this.f11423a.f11436n);
            NewsDetailsActivity.m15180a(this.f11423a.m15484h(), this.f11423a.m15484h().m15142F().m16351f(((News) this.f11423a.f11433k.get(i)).getNewId()));
        }
    }

    /* compiled from: NewsFragment */
    /* renamed from: com.tdo.showbox.b.h$6 */
    class C28796 implements C2876a {
        /* renamed from: a */
        final /* synthetic */ C2880h f11424a;

        C28796(C2880h c2880h) {
            this.f11424a = c2880h;
        }

        /* renamed from: a */
        public void mo2076a(String str, String str2, List<News> list) {
            this.f11424a.m15902c(false);
            this.f11424a.f11433k = list;
            this.f11424a.m15906l();
        }

        /* renamed from: a */
        public void mo2075a() {
            this.f11424a.m15902c(true);
            this.f11424a.f11431i.setAdapter(null);
        }
    }

    /* renamed from: a */
    public C3056k m15911a() {
        if (this.f11437o == null) {
            this.f11437o = new C3056k("native_news");
        }
        return this.f11437o;
    }

    /* renamed from: b */
    public static C2880h m15897b() {
        C3088f.m16677a("PREF_NEWS_LIST_POS", 0);
        return new C2880h();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (m15484h().m15148L()) {
            m15911a().m16515a(m15484h(), bundle, (UserInfo) new Select().from(UserInfo.class).executeSingle());
            m15911a().m16514a(3, (int) IjkMediaCodecInfo.RANK_MAX);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_news, null);
        this.f11431i = (ExtListView) this.a.findViewById(R.id.tv_grid_view);
        this.f11431i.addFooterView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
        this.f11434l = this.a.findViewById(R.id.view_progress);
        this.f11428f = 0;
        this.f11430h.m15373a((C2716a) this);
        this.f11427e = -1;
        m15914c();
        return this.a;
    }

    /* renamed from: c */
    public void m15914c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - C3088f.m16685d("PREF_NEWS_DETAILS_LAST_CLEAR_TIME") >= 259200000) {
            new Delete().from(NewsDetails.class).execute();
            C3088f.m16678a("PREF_NEWS_DETAILS_LAST_CLEAR_TIME", currentTimeMillis);
        }
    }

    /* renamed from: c */
    private void m15902c(boolean z) {
        if (this.f11434l != null) {
            this.f11434l.setVisibility(z ? 0 : 8);
        }
    }

    public void onPause() {
        super.onPause();
        if (m15484h().m15148L()) {
            m15911a().m16525f();
        }
        if (this.f11431i != null) {
            C3088f.m16677a("PREF_NEWS_LIST_POS", this.f11431i.getFirstVisiblePosition());
        }
    }

    /* renamed from: b */
    private void m15899b(View view) {
        this.f11431i.m17206a(view, new C28701(this));
    }

    public void onResume() {
        super.onResume();
        if (m15484h().m15148L()) {
            m15911a().m16524e();
            m15911a().m16518a(new C28722(this));
        }
        if (this.f11429g) {
            this.f11429g = false;
            int b = C3088f.m16681b("PREF_NEWS_SUB_TAB", 0);
            this.f11430h.m15372a(b);
            m15900b(b);
        }
    }

    /* renamed from: a */
    private void m15896a(final String str, final C2876a c2876a) {
        int i = 0;
        List execute = new Select().from(News.class).where("news_type='" + str + "'").orderBy("newId_int DESC").limit(500).execute();
        final String newId = execute.size() > 0 ? ((News) execute.get(0)).getNewId() : "0";
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - C3088f.m16685d("PREF_NEWS_LAST_UPDATE" + str) >= 3600000) {
            i = 1;
        }
        if ((execute.size() == 0 || r1 != 0) && C3178f.m16973b(m15484h())) {
            if (c2876a != null) {
                c2876a.mo2075a();
            }
            C3088f.m16678a("PREF_NEWS_LAST_UPDATE" + str, currentTimeMillis);
            m15484h().m15142F().m16348d(str, newId, new AsyncHttpResponseHandler(this) {
                /* renamed from: d */
                final /* synthetic */ C2880h f11421d;

                public void onSuccess(int i, final String str) {
                    super.onSuccess(i, str);
                    new Thread(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ C28753 f11417b;

                        /* compiled from: NewsFragment */
                        /* renamed from: com.tdo.showbox.b.h$3$1$1 */
                        class C28731 implements Runnable {
                            /* renamed from: a */
                            final /* synthetic */ C28741 f11415a;

                            C28731(C28741 c28741) {
                                this.f11415a = c28741;
                            }

                            public void run() {
                                List execute = new Select().from(News.class).where("news_type='" + str + "'").orderBy("newId_int DESC").limit(500).execute();
                                if (execute.size() == 500) {
                                    new Delete().from(News.class).where("newId_int < " + ((News) execute.get(499)).getNewId()).execute();
                                }
                                if (c2876a != null) {
                                    c2876a.mo2076a(str, newId, execute);
                                }
                            }
                        }

                        public void run() {
                            List<News> d = ObjParser.m16285d(str, str);
                            ActiveAndroid.beginTransaction();
                            for (News save : d) {
                                save.save();
                            }
                            ActiveAndroid.setTransactionSuccessful();
                            ActiveAndroid.endTransaction();
                            if (this.f11417b.f11421d.m15484h() != null) {
                                this.f11417b.f11421d.m15484h().runOnUiThread(new C28731(this));
                            }
                        }
                    }).start();
                }

                public void onFailure(Throwable th, String str) {
                    super.onFailure(th, str);
                    List execute = new Select().from(News.class).where("news_type='" + str + "'").orderBy("newId_int DESC").limit(500).execute();
                    if (c2876a != null) {
                        c2876a.mo2076a(str, newId, execute);
                    }
                }
            });
        } else if (c2876a != null) {
            c2876a.mo2076a(str, newId, execute);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f11429g = true;
    }

    /* renamed from: k */
    private void m15905k() {
        C3094j.m16698a("NewsFragment", "open movies");
        this.f11436n = "movie";
        C3065b.m16569a("news_list", "tab", "movie");
        m15896a("movie", new C28774(this));
    }

    /* renamed from: l */
    private void m15906l() {
        boolean z = false;
        try {
            m15909o();
            boolean z2 = m15484h().getResources().getBoolean(R.bool.portrait_only);
            if (z2) {
                this.f11432j = new C3203c(m15484h(), m15915j(), this.f11433k);
            } else {
                MainActivity h = m15484h();
                C3074a j = m15915j();
                List list = this.f11433k;
                if (!z2) {
                    z = true;
                }
                this.f11432j = new C3201b(h, j, list, z);
            }
            if (!z2) {
                this.f11431i.setAdapter(this.f11432j);
            } else if (m15911a().m16521b()) {
                m15911a().m16517a(this.f11431i, this.f11432j);
            } else {
                this.f11431i.setAdapter(this.f11432j);
            }
            int c = C3088f.m16684c("PREF_NEWS_LIST_POS");
            if (c > 0) {
                this.f11431i.setSelection(c);
                C3088f.m16677a("PREF_NEWS_LIST_POS", 0);
            }
            this.f11432j.notifyDataSetChanged();
            this.f11432j.m17004a(new C28785(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (m15484h().m15148L()) {
            m15911a().m16516a(bundle);
        }
    }

    /* renamed from: m */
    private void m15907m() {
        C3094j.m16698a("NewsFragment", "open tv");
        this.f11436n = "tv";
        C3065b.m16569a("news_list", "tab", "tv");
        m15896a("tv", new C28796(this));
    }

    /* renamed from: n */
    private void m15908n() {
        C3094j.m16698a("NewsFragment", "open music");
    }

    public void onDestroy() {
        if (m15484h().m15148L()) {
            m15911a().m16523d();
        }
        try {
            if (this.f11435m != null) {
                this.f11435m.m16639b();
            }
            this.f11435m = null;
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        return this.f11430h;
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return this.f11430h;
    }

    /* renamed from: a */
    public void mo2077a(int i) {
        switch (i) {
            case 0:
                if (!m15900b(0)) {
                    this.f11430h.m15372a(0);
                    return;
                }
                return;
            case 1:
                if (!m15900b(1)) {
                    this.f11430h.m15372a(1);
                    return;
                }
                return;
            case 2:
                if (!m15900b(2)) {
                    this.f11430h.m15372a(2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private boolean m15900b(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f11428f <= 350) {
            return false;
        }
        this.f11428f = currentTimeMillis;
        if (this.f11427e != i) {
            this.f11427e = i;
            C3088f.m16677a("PREF_NEWS_SUB_TAB", this.f11427e);
            switch (i) {
                case 0:
                    m15905k();
                    break;
                case 1:
                    m15907m();
                    break;
                case 2:
                    m15908n();
                    break;
            }
        }
        return true;
    }

    /* renamed from: j */
    public C3074a m15915j() {
        if (this.f11435m == null) {
            this.f11435m = new C3074a(m15484h());
            boolean a = C3180g.m16974a();
            C3094j.m16698a("getImgLoader", "is low = " + a);
            if (a) {
                this.f11435m.m16631a(2);
            }
            AnimationSet animationSet = new AnimationSet(true);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400);
            animationSet.addAnimation(alphaAnimation);
            AnimationSet animationSet2 = new AnimationSet(true);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(400);
            animationSet2.addAnimation(alphaAnimation2);
            this.f11435m.m16633a(animationSet, animationSet2);
            this.f11435m.m16643d((int) R.drawable.ic_poster_stub);
            if ((m15484h().getResources().getConfiguration().screenLayout & 15) == 4) {
                this.f11435m.m16640b(32);
            }
        }
        return this.f11435m;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m15909o();
    }

    /* renamed from: o */
    private void m15909o() {
        if (!m15484h().m15148L()) {
            try {
                if (m15484h().getResources().getConfiguration().orientation == 2) {
                    m15915j().m16631a(1);
                } else {
                    m15915j().m16631a(3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
