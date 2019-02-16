package com.tdo.showbox.p117b;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2732k;
import com.tdo.showbox.activities.p115a.C2732k.C2731a;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.ObjParser;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.p119b.p120a.C3031c;
import com.tdo.showbox.data.p119b.p120a.C3031c.C2747a;
import com.tdo.showbox.models.Trailer;
import com.tdo.showbox.models.TrailerDetails;
import com.tdo.showbox.models.UserInfo;
import com.tdo.showbox.p121g.C3242p;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3178f;
import com.tdo.showbox.views.ExtListView;
import com.tdo.showbox.views.ExtListView.C2746a;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: TrailersFragment */
/* renamed from: com.tdo.showbox.b.o */
public class C2950o extends C2769a implements C2731a {
    /* renamed from: c */
    private final int f11681c = 2;
    /* renamed from: d */
    private final int f11682d = IjkMediaCodecInfo.RANK_MAX;
    /* renamed from: e */
    private int f11683e;
    /* renamed from: f */
    private long f11684f = 0;
    /* renamed from: g */
    private boolean f11685g;
    /* renamed from: h */
    private C2732k f11686h = new C2732k();
    /* renamed from: i */
    private ExtListView f11687i;
    /* renamed from: j */
    private List<Trailer> f11688j;
    /* renamed from: k */
    private View f11689k;
    /* renamed from: l */
    private C3242p f11690l;
    /* renamed from: m */
    private View f11691m;
    /* renamed from: n */
    private C3031c f11692n;

    /* compiled from: TrailersFragment */
    /* renamed from: com.tdo.showbox.b.o$1 */
    class C29411 implements C2747a {
        /* renamed from: a */
        final /* synthetic */ C2950o f11668a;

        C29411(C2950o c2950o) {
            this.f11668a = c2950o;
        }

        /* renamed from: a */
        public void mo2032a() {
            if (this.f11668a.f11690l != null) {
                this.f11668a.f11691m = this.f11668a.m16177c().m16433b();
                if (this.f11668a.f11691m != null) {
                    this.f11668a.f11690l.m17170a(this.f11668a.f11691m);
                    this.f11668a.m16183j();
                }
            }
        }
    }

    /* compiled from: TrailersFragment */
    /* renamed from: com.tdo.showbox.b.o$2 */
    class C29422 implements C2746a {
        /* renamed from: a */
        final /* synthetic */ C2950o f11669a;

        C29422(C2950o c2950o) {
            this.f11669a = c2950o;
        }

        /* renamed from: a */
        public void mo2031a() {
            this.f11669a.f11687i.m17205a();
            this.f11669a.m16177c().m16438g();
        }
    }

    /* compiled from: TrailersFragment */
    /* renamed from: com.tdo.showbox.b.o$3 */
    class C29433 implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ C2950o f11670a;

        C29433(C2950o c2950o) {
            this.f11670a = c2950o;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C3167a.m16903a().m16912a(((Trailer) this.f11670a.f11688j.get(i)).getTrailerID());
        }
    }

    /* compiled from: TrailersFragment */
    /* renamed from: com.tdo.showbox.b.o$a */
    public interface C2947a {
        /* renamed from: a */
        void mo2078a();

        /* renamed from: a */
        void mo2079a(String str, List<Trailer> list);
    }

    /* compiled from: TrailersFragment */
    /* renamed from: com.tdo.showbox.b.o$5 */
    class C29485 implements C2947a {
        /* renamed from: a */
        final /* synthetic */ C2950o f11679a;

        C29485(C2950o c2950o) {
            this.f11679a = c2950o;
        }

        /* renamed from: a */
        public void mo2079a(String str, List<Trailer> list) {
            this.f11679a.m16178c(false);
            this.f11679a.f11688j = list;
            this.f11679a.m16185l();
        }

        /* renamed from: a */
        public void mo2078a() {
            this.f11679a.m16178c(true);
            this.f11679a.f11687i.setAdapter(null);
        }
    }

    /* compiled from: TrailersFragment */
    /* renamed from: com.tdo.showbox.b.o$6 */
    class C29496 implements C2947a {
        /* renamed from: a */
        final /* synthetic */ C2950o f11680a;

        C29496(C2950o c2950o) {
            this.f11680a = c2950o;
        }

        /* renamed from: a */
        public void mo2079a(String str, List<Trailer> list) {
            this.f11680a.m16178c(false);
            this.f11680a.f11688j = list;
            this.f11680a.m16185l();
        }

        /* renamed from: a */
        public void mo2078a() {
            this.f11680a.m16178c(true);
            this.f11680a.f11687i.setAdapter(null);
        }
    }

    /* renamed from: c */
    private C3031c m16177c() {
        if (this.f11692n == null) {
            this.f11692n = new C3031c("native_trailers");
        }
        return this.f11692n;
    }

    /* renamed from: a */
    public static C2950o m16169a() {
        C3088f.m16677a("PREF_TRAILERS_LIST_POS", 0);
        return new C2950o();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m16186m();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_trailers, null);
        C3065b.m16568a("trailers_list");
        m16192b();
        this.f11687i = (ExtListView) this.a.findViewById(R.id.tv_grid_view);
        this.f11687i.addFooterView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
        this.f11689k = this.a.findViewById(R.id.view_progress);
        this.f11684f = 0;
        this.f11686h.m15411a((C2731a) this);
        this.f11683e = -1;
        return this.a;
    }

    /* renamed from: c */
    private void m16178c(boolean z) {
        if (this.f11689k != null) {
            this.f11689k.setVisibility(z ? 0 : 8);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f11685g) {
            this.f11685g = false;
            this.f11686h.m15410a(0);
            m16175b(0);
        }
        if (m15484h().m15148L()) {
            m16177c().m16436e();
            m16177c().m16431a(new C29411(this));
        }
    }

    /* renamed from: j */
    private void m16183j() {
        this.f11687i.m17206a(this.f11691m, new C29422(this));
    }

    public void onPause() {
        super.onPause();
        if (m15484h().m15148L()) {
            m16177c().m16437f();
            if (this.f11690l != null) {
                this.f11690l.m17170a(null);
            }
        }
        if (this.f11687i != null) {
            C3088f.m16677a("PREF_TRAILERS_LIST_POS", this.f11687i.getFirstVisiblePosition());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (m15484h().m15148L()) {
            m16177c().m16435d();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m16184k();
    }

    /* renamed from: k */
    private void m16184k() {
        this.f11690l.notifyDataSetChanged();
    }

    /* renamed from: l */
    private void m16185l() {
        boolean z = false;
        try {
            if (this.f11687i != null) {
                MainActivity h = m15484h();
                List list = this.f11688j;
                if (!m15484h().getResources().getBoolean(R.bool.portrait_only)) {
                    z = true;
                }
                this.f11690l = new C3242p(h, list, z);
                this.f11690l.m17170a(this.f11691m);
                this.f11687i.setAdapter(this.f11690l);
                int c = C3088f.m16684c("PREF_TRAILERS_LIST_POS");
                if (c > 0) {
                    this.f11687i.setSelection(c);
                    C3088f.m16677a("PREF_TRAILERS_LIST_POS", 0);
                }
                this.f11690l.notifyDataSetChanged();
                this.f11690l.m17004a(new C29433(this));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m16192b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - C3088f.m16685d("PREF_TRAILER_DETAILS_LAST_CLEAR_TIME") >= 259200000) {
            new Delete().from(TrailerDetails.class).execute();
            C3088f.m16678a("PREF_TRAILER_DETAILS_LAST_CLEAR_TIME", currentTimeMillis);
        }
    }

    /* renamed from: a */
    private void m16173a(final String str, final C2947a c2947a) {
        final List execute = new Select().from(Trailer.class).where("trailer_type='" + str + "'").orderBy("Id ASC").limit(500).execute();
        long currentTimeMillis = System.currentTimeMillis();
        long d = C3088f.m16685d("PREF_TRAILERS_LAST_UPDATE" + str);
        Object obj = null;
        if (currentTimeMillis - d >= 10800000) {
            obj = 1;
        }
        if ((execute.size() == 0 || r0 != null) && C3178f.m16973b(m15484h())) {
            if (c2947a != null) {
                c2947a.mo2078a();
            }
            C3088f.m16678a("PREF_TRAILERS_LAST_UPDATE" + str, currentTimeMillis);
            m15484h().m15142F().m16339b(str, new AsyncHttpResponseHandler(this) {
                /* renamed from: d */
                final /* synthetic */ C2950o f11678d;

                public void onSuccess(int i, final String str) {
                    super.onSuccess(i, str);
                    new Thread(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ C29464 f11674b;

                        public void run() {
                            final List<Trailer> e = ObjParser.m16286e(str, str);
                            ActiveAndroid.beginTransaction();
                            new Delete().from(Trailer.class).where("trailer_type='" + str + "'").execute();
                            for (Trailer save : e) {
                                save.save();
                            }
                            ActiveAndroid.setTransactionSuccessful();
                            ActiveAndroid.endTransaction();
                            if (this.f11674b.f11678d.m15484h() != null) {
                                this.f11674b.f11678d.m15484h().runOnUiThread(new Runnable(this) {
                                    /* renamed from: b */
                                    final /* synthetic */ C29451 f11672b;

                                    public void run() {
                                        if (c2947a != null) {
                                            c2947a.mo2079a(str, e);
                                        }
                                    }
                                });
                            }
                        }
                    }).start();
                }

                public void onFailure(Throwable th, String str) {
                    super.onFailure(th, str);
                    if (c2947a != null) {
                        c2947a.mo2079a(str, execute);
                    }
                }
            });
        } else if (c2947a != null) {
            c2947a.mo2079a(str, execute);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f11685g = true;
    }

    /* renamed from: m */
    private void m16186m() {
        if (m15484h().m15148L()) {
            m16177c().m16429a(m15484h(), (UserInfo) new Select().from(UserInfo.class).executeSingle());
            m16177c().m16427a(2, (int) IjkMediaCodecInfo.RANK_MAX);
        }
    }

    /* renamed from: n */
    private void m16187n() {
        C3094j.m16698a("TrailersFragment", "open just");
        m16173a("new", new C29485(this));
    }

    /* renamed from: o */
    private void m16188o() {
        C3094j.m16698a("TrailersFragment", "open popular");
        m16173a("popular", new C29496(this));
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        return this.f11686h;
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return this.f11686h;
    }

    /* renamed from: a */
    public void mo2080a(int i) {
        switch (i) {
            case 0:
                if (!m16175b(0)) {
                    this.f11686h.m15410a(0);
                    return;
                }
                return;
            case 1:
                if (!m16175b(1)) {
                    this.f11686h.m15410a(1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private boolean m16175b(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f11684f <= 350) {
            return false;
        }
        this.f11684f = currentTimeMillis;
        if (this.f11683e != i) {
            this.f11683e = i;
            C3088f.m16677a("PREF_TRAILERS_SUB_TAB", this.f11683e);
            switch (i) {
                case 0:
                    m16188o();
                    break;
                case 1:
                    m16187n();
                    break;
            }
        }
        return true;
    }
}
