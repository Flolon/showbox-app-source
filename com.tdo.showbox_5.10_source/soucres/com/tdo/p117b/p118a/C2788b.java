package com.tdo.showbox.p117b.p118a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.TopicActivity;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2705e;
import com.tdo.showbox.activities.p115a.C2705e.C2701a;
import com.tdo.showbox.activities.p115a.C2705e.C2702b;
import com.tdo.showbox.activities.p115a.C2705e.C2703c;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.data.api.C3016f;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.p124a.C2982e;
import com.tdo.showbox.data.p126d.C3076a;
import com.tdo.showbox.data.push.C3128a;
import com.tdo.showbox.models.Category;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.p111a.C2606a;
import com.tdo.showbox.p113d.C2773d;
import com.tdo.showbox.p113d.C2780g;
import com.tdo.showbox.p113d.C2782f;
import com.tdo.showbox.p117b.C2769a;
import com.tdo.showbox.p117b.p118a.C2788b;
import com.tdo.showbox.p121g.C3219f;
import com.tdo.showbox.p121g.C3231k;
import com.tdo.showbox.p121g.C3231k.C2784a;
import com.tdo.showbox.p121g.C3233l;
import com.tdo.showbox.p121g.C3235m;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3184j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PhoneMovieFragment */
/* renamed from: com.tdo.showbox.b.a.b */
public class C2788b extends C2769a implements OnItemClickListener, C2701a, C2702b, C2703c {
    /* renamed from: c */
    private Spinner f11164c;
    /* renamed from: d */
    private ListView f11165d;
    /* renamed from: e */
    private C3219f f11166e;
    /* renamed from: f */
    private EditText f11167f;
    /* renamed from: g */
    private Spinner f11168g;
    /* renamed from: h */
    private Spinner f11169h;
    /* renamed from: i */
    private C3235m f11170i;
    /* renamed from: j */
    private C3233l f11171j;
    /* renamed from: k */
    private List<Category> f11172k;
    /* renamed from: l */
    private C3231k f11173l;
    /* renamed from: m */
    private TextView f11174m;
    /* renamed from: n */
    private String f11175n;
    /* renamed from: o */
    private TextView f11176o;
    /* renamed from: p */
    private String f11177p;
    /* renamed from: q */
    private ViewGroup f11178q;
    /* renamed from: r */
    private Dialog f11179r;
    /* renamed from: s */
    private C2705e f11180s = new C2705e();
    /* renamed from: t */
    private boolean f11181t;
    /* renamed from: u */
    private View f11182u;
    /* renamed from: v */
    private List<MovieItem> f11183v;
    /* renamed from: w */
    private C2606a f11184w;
    /* renamed from: x */
    private View f11185x;

    /* compiled from: PhoneMovieFragment */
    /* renamed from: com.tdo.showbox.b.a.b$1 */
    class C27741 implements OnGlobalLayoutListener {
        /* renamed from: a */
        final /* synthetic */ C2788b f11150a;

        C27741(C2788b c2788b) {
            this.f11150a = c2788b;
        }

        public void onGlobalLayout() {
            if (this.f11150a.f11167f.getRootView().getHeight() - this.f11150a.f11167f.getHeight() <= 100) {
            }
        }
    }

    /* compiled from: PhoneMovieFragment */
    /* renamed from: com.tdo.showbox.b.a.b$2 */
    class C27772 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C2788b f11156a;

        C27772(C2788b c2788b) {
            this.f11156a = c2788b;
        }

        public void onSuccess(String str, String str2, long j) {
            final String str3 = str;
            final String str4 = str2;
            final long j2 = j;
            new Thread(new Runnable(this) {
                /* renamed from: d */
                final /* synthetic */ C27772 f11155d;

                /* compiled from: PhoneMovieFragment */
                /* renamed from: com.tdo.showbox.b.a.b$2$1$1 */
                class C27751 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C27761 f11151a;

                    C27751(C27761 c27761) {
                        this.f11151a = c27761;
                    }

                    public void run() {
                        if (this.f11151a.f11155d.f11156a.f11166e != null && this.f11151a.f11155d.f11156a.f11165d != null && this.f11151a.f11155d.f11156a.f11183v != null) {
                            this.f11151a.f11155d.f11156a.f11166e.m17110a(this.f11151a.f11155d.f11156a.f11183v);
                            this.f11151a.f11155d.f11156a.f11165d.setSelectionFromTop(0, 0);
                            this.f11151a.f11155d.f11156a.m15632c(false);
                            this.f11151a.f11155d.f11156a.m15631c();
                        }
                    }
                }

                public void run() {
                    this.f11155d.f11156a.f11183v = C2982e.m16303a(str3);
                    if (this.f11155d.f11156a.f11183v != null) {
                        C3016f.m16398a(str4, j2, str3);
                    }
                    ActiveAndroid.beginTransaction();
                    new Delete().from(MovieItem.class).where("in_lib=0 AND from_push!=1").execute();
                    for (MovieItem save : this.f11155d.f11156a.f11183v) {
                        save.save();
                    }
                    ActiveAndroid.setTransactionSuccessful();
                    ActiveAndroid.endTransaction();
                    Activity k = this.f11155d.f11156a.m15484h();
                    if (k != null) {
                        k.runOnUiThread(new C27751(this));
                    }
                }
            }).start();
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            this.f11156a.m15632c(false);
        }
    }

    /* compiled from: PhoneMovieFragment */
    /* renamed from: com.tdo.showbox.b.a.b$3 */
    class C27783 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2788b f11157a;

        C27783(C2788b c2788b) {
            this.f11157a = c2788b;
        }

        public void onClick(View view) {
            try {
                this.f11157a.f11179r.dismiss();
            } catch (Exception e) {
            }
        }
    }

    /* compiled from: PhoneMovieFragment */
    /* renamed from: com.tdo.showbox.b.a.b$4 */
    class C27794 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2788b f11158a;

        C27794(C2788b c2788b) {
            this.f11158a = c2788b;
        }

        public void onClick(View view) {
            try {
                this.f11158a.f11179r.dismiss();
            } catch (Exception e) {
            }
        }
    }

    /* compiled from: PhoneMovieFragment */
    /* renamed from: com.tdo.showbox.b.a.b$5 */
    class C27815 implements C2780g {
        /* renamed from: a */
        final /* synthetic */ C2788b f11159a;

        C27815(C2788b c2788b) {
            this.f11159a = c2788b;
        }

        /* renamed from: a */
        public void mo2057a(String str) {
            int i = -1;
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Exception e) {
            }
            this.f11159a.m15641j().m15028b(i);
            this.f11159a.m15662b(str);
            this.f11159a.m15652o();
        }
    }

    /* compiled from: PhoneMovieFragment */
    /* renamed from: com.tdo.showbox.b.a.b$6 */
    class C27836 implements C2782f {
        /* renamed from: a */
        final /* synthetic */ C2788b f11160a;

        C27836(C2788b c2788b) {
            this.f11160a = c2788b;
        }

        /* renamed from: a */
        public void mo2058a(Category category) {
            if (category == null) {
                category = new Category();
                category.setName("");
                category.setCatId("-1");
            }
            this.f11160a.m15663c(category.getName());
            this.f11160a.m15641j().m15025a(category);
            this.f11160a.m15652o();
        }
    }

    /* compiled from: PhoneMovieFragment */
    /* renamed from: com.tdo.showbox.b.a.b$7 */
    class C27857 implements C2784a {
        /* renamed from: a */
        final /* synthetic */ C2788b f11161a;

        C27857(C2788b c2788b) {
            this.f11161a = c2788b;
        }

        /* renamed from: a */
        public void mo2059a(int i) {
            this.f11161a.m15641j().m15024a(i);
            this.f11161a.m15641j().m15026a(C3076a.m16646a(i));
            this.f11161a.m15652o();
        }
    }

    /* compiled from: PhoneMovieFragment */
    /* renamed from: com.tdo.showbox.b.a.b$8 */
    class C27868 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2788b f11162a;

        C27868(C2788b c2788b) {
            this.f11162a = c2788b;
        }

        public void onClick(View view) {
            this.f11162a.f11164c.performClick();
        }
    }

    /* compiled from: PhoneMovieFragment */
    /* renamed from: com.tdo.showbox.b.a.b$9 */
    class C27879 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2788b f11163a;

        C27879(C2788b c2788b) {
            this.f11163a = c2788b;
        }

        public void onClick(View view) {
            this.f11163a.f11168g.performClick();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_movies, null);
        this.f11181t = false;
        this.f11178q = (ViewGroup) layoutInflater.inflate(R.layout.dialog_filter, null);
        this.f11174m = (TextView) this.f11178q.findViewById(R.id.txtv_genre_spinner);
        this.f11176o = (TextView) this.f11178q.findViewById(R.id.yesr_sort_txtv);
        this.f11185x = this.a.findViewById(R.id.search_progress);
        this.f11164c = (Spinner) this.f11178q.findViewById(R.id.sort_spinner);
        this.f11168g = (Spinner) this.f11178q.findViewById(R.id.sort_genre_spinner);
        this.f11169h = (Spinner) this.f11178q.findViewById(R.id.sort_year_spinner);
        this.f11165d = (ListView) this.a.findViewById(R.id.tv_grid_view);
        this.f11182u = LayoutInflater.from(m15484h()).inflate(R.layout.list_movies_footer, null, false);
        this.f11165d.addFooterView(this.f11182u);
        this.f11167f = (EditText) this.a.findViewById(R.id.edttx_search);
        if (this.f11183v == null) {
            this.f11183v = new ArrayList();
        }
        if (this.f11166e == null) {
            this.f11166e = new C3219f(m15484h(), false, this.f11183v);
        } else {
            this.f11166e.m17110a(this.f11183v);
        }
        this.f11166e.m17004a(this);
        this.f11165d.setAdapter(this.f11166e);
        this.f11167f.getViewTreeObserver().addOnGlobalLayoutListener(new C27741(this));
        m15656r();
        this.f11178q.findViewById(R.id.sort_by).setOnClickListener(new C27868(this));
        this.f11178q.findViewById(R.id.genre).setOnClickListener(new C27879(this));
        this.f11178q.findViewById(R.id.year).setOnClickListener(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ C2788b f11142a;

            {
                this.f11142a = r1;
            }

            public void onClick(View view) {
                this.f11142a.f11169h.performClick();
            }
        });
        this.a.findViewById(R.id.f_view).setOnClickListener(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ C2788b f11143a;

            {
                this.f11143a = r1;
            }

            public void onClick(View view) {
                this.f11143a.m15655q();
            }
        });
        m15636e(false);
        m15634d(false);
        if (this.f11175n != null) {
            this.f11174m.setText(this.f11175n);
        }
        if (this.f11177p != null) {
            this.f11176o.setText(this.f11177p);
        }
        m15653p();
        C3065b.m16568a("movies_list");
        m15650n();
        m15646l();
        m15647m();
        m15644k();
        if (this.f11183v.size() == 0) {
            m15652o();
        }
        return this.a;
    }

    /* renamed from: c */
    private void m15631c() {
        if (!this.f11166e.isEmpty()) {
            this.f11165d.postDelayed(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ C2788b f11144a;

                {
                    this.f11144a = r1;
                }

                public void run() {
                    try {
                        this.f11144a.f11182u.findViewById(R.id.txtv_title).setVisibility(0);
                    } catch (Exception e) {
                    }
                }
            }, 200);
        }
    }

    /* renamed from: c */
    private void m15632c(boolean z) {
        int i = 0;
        if (this.f11185x != null && this.f11165d != null) {
            int i2;
            ListView listView = this.f11165d;
            if (z) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            listView.setVisibility(i2);
            View view = this.f11185x;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    /* renamed from: j */
    private C2606a m15641j() {
        if (this.f11184w == null) {
            this.f11184w = new C2606a();
            this.f11184w.m15025a(null);
            this.f11184w.m15024a(2);
            this.f11184w.m15028b(-1);
            this.f11184w.m15029b(null);
        }
        return this.f11184w;
    }

    /* renamed from: d */
    public void mo2063d() {
        super.mo2063d();
        m15652o();
    }

    /* renamed from: k */
    private void m15644k() {
        try {
            if (getArguments() != null) {
                final int a = C3128a.m16834a(getArguments().getString("from"));
                final String string = getArguments().getString("movieId");
                if (string.length() > 0) {
                    m15484h().m15090a(true);
                    this.a.postDelayed(new Runnable(this) {
                        /* renamed from: c */
                        final /* synthetic */ C2788b f11147c;

                        public void run() {
                            try {
                                if (a == -1) {
                                    C3065b.m16568a("push_new_movie");
                                } else {
                                    C3065b.m16569a("push_new_movie", "hour", "" + a);
                                }
                                this.f11147c.m15484h().m15090a(false);
                                C3167a.m16903a().m16915a(string, false, true);
                                this.f11147c.getArguments().clear();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 1200);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: l */
    private void m15646l() {
        if (m15484h().m15148L()) {
            this.a.findViewById(R.id.search_container).setVisibility(8);
        } else {
            this.a.findViewById(R.id.search_container).setVisibility(0);
        }
    }

    /* renamed from: m */
    private void m15647m() {
        this.f11180s.m15348b(getString(R.string.movies));
        this.f11180s.m15344a((C2702b) this);
        this.f11180s.m15343a((C2701a) this);
        this.f11180s.m15345a((C2703c) this);
        this.f11180s.m15346a(m15484h().getString(R.string.search_text));
    }

    /* renamed from: n */
    private void m15650n() {
        try {
            m15484h().m15152a(new C2773d(this) {
                /* renamed from: a */
                final /* synthetic */ C2788b f11148a;

                {
                    this.f11148a = r1;
                }

                /* renamed from: a */
                public void mo2056a(boolean z) {
                    if (this.f11148a.m15484h() != null && this.f11148a.f11167f != null && !z && this.f11148a.f11167f.getText().length() < 2) {
                        this.f11148a.f11167f.setText("");
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.a.postDelayed(new Runnable(this) {
            /* renamed from: a */
            final /* synthetic */ C2788b f11149a;

            {
                this.f11149a = r1;
            }

            public void run() {
                try {
                    this.f11149a.f11166e.notifyDataSetChanged();
                } catch (Exception e) {
                }
            }
        }, 400);
    }

    /* renamed from: o */
    private void m15652o() {
        C2606a j = m15641j();
        C2999a F = m15484h().m15142F();
        m15632c(true);
        F.m16329a(j, new C27772(this));
    }

    /* renamed from: p */
    private void m15653p() {
        this.f11179r = new Dialog(m15484h(), R.style.custom_dialog);
        this.f11179r.requestWindowFeature(1);
        this.f11179r.setContentView(this.f11178q);
        Window window = this.f11179r.getWindow();
        window.setBackgroundDrawableResource(17170445);
        window.getAttributes().windowAnimations = R.style.FilterDialogAnimation;
        window.setGravity(53);
        window.getAttributes().dimAmount = 0.0f;
        this.f11179r.findViewById(R.id.ok_btn).setOnClickListener(new C27783(this));
        this.f11179r.findViewById(R.id.main).setOnClickListener(new C27794(this));
    }

    /* renamed from: q */
    private void m15655q() {
        this.f11179r.show();
    }

    /* renamed from: b */
    public void m15662b(String str) {
        try {
            if (str.equals("")) {
                this.f11177p = m15484h().getString(R.string.year);
            } else {
                this.f11177p = str.toUpperCase();
            }
            this.f11176o.setText(this.f11177p);
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    public void m15663c(String str) {
        try {
            if (str.equals("")) {
                this.f11175n = m15484h().getString(R.string.genre);
            } else {
                this.f11175n = str.toUpperCase();
            }
            this.f11174m.setText(this.f11175n);
        } catch (Exception e) {
        }
    }

    /* renamed from: d */
    private void m15634d(boolean z) {
        if (this.f11170i == null || z) {
            this.f11170i = new C3235m(m15484h(), 0);
        }
        this.f11169h.setAdapter(this.f11170i);
        this.f11170i.m17145a(new C27815(this));
    }

    /* renamed from: e */
    private void m15636e(boolean z) {
        this.f11172k = new ArrayList();
        Category category = new Category();
        category.setName(m15484h().getString(R.string.genre_all));
        category.setCatId("-1");
        this.f11172k.add(category);
        this.f11172k.addAll(new Select().from(Category.class).orderBy("name ASC").execute());
        if (this.f11171j == null || z) {
            this.f11171j = new C3233l(m15484h(), (Category) this.f11172k.get(0), this.f11172k, 0);
        }
        this.f11168g.setAdapter(this.f11171j);
        this.f11171j.m17141a(new C27836(this));
    }

    /* renamed from: r */
    private void m15656r() {
        if (this.f11173l == null) {
            this.f11173l = new C3231k(m15484h(), 2, new C27857(this));
        }
        this.f11164c.setAdapter(this.f11173l);
    }

    public void onPause() {
        C3184j.m16982a(m15484h(), this.f11167f);
        super.onPause();
    }

    public void onDestroy() {
        if (this.f11165d != null) {
            this.f11165d.setAdapter(null);
            try {
                this.f11166e.clear();
                this.f11166e = null;
                this.f11165d = null;
            } catch (Exception e) {
            }
        }
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        try {
            C3184j.m16982a(m15484h(), this.f11167f);
            C3167a.m16903a().m16915a(this.f11166e.m17109a(i).getMovieId(), false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        return this.f11180s;
    }

    /* renamed from: b */
    public void mo2062b() {
        m15655q();
    }

    /* renamed from: a */
    public void mo2060a() {
        m15641j().m15029b(null);
        m15652o();
    }

    /* renamed from: a */
    public void mo2061a(String str) {
        if (this.f11166e != null) {
            if (str.length() < 2) {
                m15641j().m15029b(null);
                this.a.findViewById(R.id.f_view).setEnabled(true);
                if (VERSION.SDK_INT > 11) {
                    this.a.findViewById(R.id.f_view).setAlpha(1.0f);
                }
            } else if (str.toString().equals("Show topics")) {
                m15484h().startActivity(new Intent(m15484h(), TopicActivity.class));
                return;
            } else {
                m15641j().m15029b(str.toString());
                this.a.findViewById(R.id.f_view).setEnabled(false);
                if (VERSION.SDK_INT > 11) {
                    this.a.findViewById(R.id.f_view).setAlpha(0.5f);
                }
            }
            m15652o();
            m15657s();
        }
    }

    /* renamed from: s */
    private void m15657s() {
        if (!this.f11181t) {
            this.f11181t = true;
            C3065b.m16568a("movie_search");
        }
    }

    /* renamed from: e */
    public void mo2064e() {
        try {
            this.f11180s.m15347b();
        } catch (Exception e) {
        }
    }
}
