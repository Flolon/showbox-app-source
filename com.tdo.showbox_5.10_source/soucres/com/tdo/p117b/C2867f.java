package com.tdo.showbox.p117b;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.TopicActivity;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2705e.C2701a;
import com.tdo.showbox.activities.p115a.p116a.C2673b;
import com.tdo.showbox.b.f.AnonymousClass13;
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
import com.tdo.showbox.p117b.C2867f;
import com.tdo.showbox.p121g.C3219f;
import com.tdo.showbox.p121g.C3231k;
import com.tdo.showbox.p121g.C3231k.C2784a;
import com.tdo.showbox.p121g.C3233l;
import com.tdo.showbox.p121g.C3235m;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3184j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MovieFragment */
/* renamed from: com.tdo.showbox.b.f */
public class C2867f extends C2769a implements OnItemClickListener {
    /* renamed from: c */
    private Spinner f11385c;
    /* renamed from: d */
    private ListView f11386d;
    /* renamed from: e */
    private C3219f f11387e;
    /* renamed from: f */
    private EditText f11388f;
    /* renamed from: g */
    private Spinner f11389g;
    /* renamed from: h */
    private Spinner f11390h;
    /* renamed from: i */
    private C3235m f11391i;
    /* renamed from: j */
    private C3233l f11392j;
    /* renamed from: k */
    private List<Category> f11393k;
    /* renamed from: l */
    private C3231k f11394l;
    /* renamed from: m */
    private TextView f11395m;
    /* renamed from: n */
    private String f11396n;
    /* renamed from: o */
    private TextView f11397o;
    /* renamed from: p */
    private String f11398p;
    /* renamed from: q */
    private View f11399q;
    /* renamed from: r */
    private boolean f11400r;
    /* renamed from: s */
    private TextView f11401s;
    /* renamed from: t */
    private C2673b f11402t = new C2673b();
    /* renamed from: u */
    private View f11403u;
    /* renamed from: v */
    private View f11404v;
    /* renamed from: w */
    private List<MovieItem> f11405w;
    /* renamed from: x */
    private C2606a f11406x;
    /* renamed from: y */
    private View f11407y;

    /* compiled from: MovieFragment */
    /* renamed from: com.tdo.showbox.b.f$1 */
    class C28581 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2867f f11376a;

        C28581(C2867f c2867f) {
            this.f11376a = c2867f;
        }

        public void onClick(View view) {
            this.f11376a.f11385c.performClick();
        }
    }

    /* compiled from: MovieFragment */
    /* renamed from: com.tdo.showbox.b.f$2 */
    class C28592 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2867f f11377a;

        C28592(C2867f c2867f) {
            this.f11377a = c2867f;
        }

        public void run() {
            try {
                this.f11377a.f11387e.notifyDataSetChanged();
            } catch (Exception e) {
            }
        }
    }

    /* compiled from: MovieFragment */
    /* renamed from: com.tdo.showbox.b.f$3 */
    class C28603 implements C2780g {
        /* renamed from: a */
        final /* synthetic */ C2867f f11378a;

        C28603(C2867f c2867f) {
            this.f11378a = c2867f;
        }

        /* renamed from: a */
        public void mo2057a(String str) {
            int i = -1;
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Exception e) {
            }
            this.f11378a.m15856b().m15028b(i);
            this.f11378a.m15877a(str);
            this.f11378a.m15871k();
        }
    }

    /* compiled from: MovieFragment */
    /* renamed from: com.tdo.showbox.b.f$4 */
    class C28614 implements C2782f {
        /* renamed from: a */
        final /* synthetic */ C2867f f11379a;

        C28614(C2867f c2867f) {
            this.f11379a = c2867f;
        }

        /* renamed from: a */
        public void mo2058a(Category category) {
            if (category == null) {
                category = new Category();
                category.setName("");
                category.setCatId("-1");
            }
            this.f11379a.m15879b(category.getName());
            this.f11379a.m15856b().m15025a(category);
            this.f11379a.m15871k();
        }
    }

    /* compiled from: MovieFragment */
    /* renamed from: com.tdo.showbox.b.f$5 */
    class C28625 implements C2784a {
        /* renamed from: a */
        final /* synthetic */ C2867f f11380a;

        C28625(C2867f c2867f) {
            this.f11380a = c2867f;
        }

        /* renamed from: a */
        public void mo2059a(int i) {
            this.f11380a.m15856b().m15024a(i);
            this.f11380a.m15856b().m15026a(C3076a.m16646a(i));
            this.f11380a.m15871k();
        }
    }

    /* compiled from: MovieFragment */
    /* renamed from: com.tdo.showbox.b.f$6 */
    class C28636 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2867f f11381a;

        C28636(C2867f c2867f) {
            this.f11381a = c2867f;
        }

        public void onClick(View view) {
            this.f11381a.f11389g.performClick();
        }
    }

    /* compiled from: MovieFragment */
    /* renamed from: com.tdo.showbox.b.f$7 */
    class C28647 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2867f f11382a;

        C28647(C2867f c2867f) {
            this.f11382a = c2867f;
        }

        public void onClick(View view) {
            this.f11382a.f11390h.performClick();
        }
    }

    /* compiled from: MovieFragment */
    /* renamed from: com.tdo.showbox.b.f$8 */
    class C28658 implements OnEditorActionListener {
        /* renamed from: a */
        final /* synthetic */ C2867f f11383a;

        C28658(C2867f c2867f) {
            this.f11383a = c2867f;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3 && i != 66) {
                return false;
            }
            if (this.f11383a.f11387e != null) {
                if (this.f11383a.f11388f.getText().length() < 2) {
                    this.f11383a.m15856b().m15029b(null);
                    if (VERSION.SDK_INT > 11) {
                        this.f11383a.f11403u.findViewById(R.id.genre).setAlpha(1.0f);
                        this.f11383a.f11403u.findViewById(R.id.sort_by).setAlpha(1.0f);
                        this.f11383a.f11403u.findViewById(R.id.year).setAlpha(1.0f);
                    }
                    this.f11383a.f11403u.findViewById(R.id.genre).setEnabled(true);
                    this.f11383a.f11403u.findViewById(R.id.sort_by).setEnabled(true);
                    this.f11383a.f11403u.findViewById(R.id.year).setEnabled(true);
                } else if (this.f11383a.f11388f.getText().toString().equals("Show topics")) {
                    this.f11383a.m15484h().startActivity(new Intent(this.f11383a.m15484h(), TopicActivity.class));
                    C3184j.m16982a(this.f11383a.m15484h(), this.f11383a.f11388f);
                    return true;
                } else {
                    this.f11383a.m15856b().m15029b(this.f11383a.f11388f.getText().toString());
                    if (VERSION.SDK_INT > 11) {
                        this.f11383a.f11403u.findViewById(R.id.genre).setAlpha(0.5f);
                        this.f11383a.f11403u.findViewById(R.id.sort_by).setAlpha(0.5f);
                        this.f11383a.f11403u.findViewById(R.id.year).setAlpha(0.5f);
                    }
                    this.f11383a.f11403u.findViewById(R.id.genre).setEnabled(false);
                    this.f11383a.f11403u.findViewById(R.id.sort_by).setEnabled(false);
                    this.f11383a.f11403u.findViewById(R.id.year).setEnabled(false);
                }
                C3184j.m16982a(this.f11383a.m15484h(), this.f11383a.f11388f);
                this.f11383a.m15871k();
                this.f11383a.m15876n();
            }
            C3184j.m16982a(this.f11383a.m15484h(), this.f11383a.f11388f);
            return true;
        }
    }

    /* compiled from: MovieFragment */
    /* renamed from: com.tdo.showbox.b.f$9 */
    class C28669 implements C2701a {
        /* renamed from: a */
        final /* synthetic */ C2867f f11384a;

        C28669(C2867f c2867f) {
            this.f11384a = c2867f;
        }

        /* renamed from: a */
        public void mo2060a() {
            if (VERSION.SDK_INT > 11) {
                this.f11384a.f11403u.findViewById(R.id.genre).setAlpha(1.0f);
                this.f11384a.f11403u.findViewById(R.id.sort_by).setAlpha(1.0f);
                this.f11384a.f11403u.findViewById(R.id.year).setAlpha(1.0f);
            }
            this.f11384a.f11403u.findViewById(R.id.genre).setEnabled(true);
            this.f11384a.f11403u.findViewById(R.id.sort_by).setEnabled(true);
            this.f11384a.f11403u.findViewById(R.id.year).setEnabled(true);
            C3184j.m16982a(this.f11384a.m15484h(), this.f11384a.f11388f);
            this.f11384a.m15856b().m15029b(null);
            this.f11384a.m15871k();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_movies, null);
        this.f11403u = this.f11402t.m15282b(m15484h());
        this.f11400r = false;
        this.f11407y = this.a.findViewById(R.id.search_progress);
        this.f11395m = (TextView) this.f11403u.findViewById(R.id.txtv_genre_spinner);
        this.f11397o = (TextView) this.f11403u.findViewById(R.id.yesr_sort_txtv);
        this.f11385c = (Spinner) this.f11403u.findViewById(R.id.sort_spinner);
        this.f11389g = (Spinner) this.f11403u.findViewById(R.id.sort_genre_spinner);
        this.f11390h = (Spinner) this.f11403u.findViewById(R.id.sort_year_spinner);
        this.f11386d = (ListView) this.a.findViewById(R.id.tv_grid_view);
        this.f11404v = LayoutInflater.from(m15484h()).inflate(R.layout.list_movies_footer, null, false);
        this.f11386d.addFooterView(this.f11404v);
        this.f11388f = (EditText) this.f11403u.findViewById(R.id.edttx_search);
        this.f11399q = this.f11403u.findViewById(R.id.update_container);
        this.f11401s = (TextView) this.f11403u.findViewById(R.id.txtv_update_persents);
        if (this.f11405w == null) {
            this.f11405w = new ArrayList();
        }
        if (this.f11387e == null) {
            this.f11387e = new C3219f(m15484h(), true, this.f11405w);
        } else {
            this.f11387e.m17110a(this.f11405w);
        }
        this.f11387e.m17004a(this);
        this.f11386d.setAdapter(this.f11387e);
        this.f11387e.notifyDataSetChanged();
        m15873l();
        this.f11403u.findViewById(R.id.sort_by).setOnClickListener(new C28581(this));
        this.f11403u.findViewById(R.id.genre).setOnClickListener(new C28636(this));
        this.f11403u.findViewById(R.id.year).setOnClickListener(new C28647(this));
        m15874m();
        m15863e(false);
        m15861d(false);
        if (this.f11396n != null) {
            this.f11395m.setText(this.f11396n);
        }
        if (this.f11398p != null) {
            this.f11397o.setText(this.f11398p);
        }
        C3065b.m16568a("movies_list");
        m15869j();
        m15858c();
        if (this.f11405w.size() == 0) {
            m15871k();
        }
        this.f11388f.setOnEditorActionListener(new C28658(this));
        this.f11402t.m15281a(new C28669(this));
        return this.a;
    }

    /* renamed from: a */
    private void m15853a() {
        if (!this.f11387e.isEmpty()) {
            this.f11386d.postDelayed(new Runnable(this) {
                /* renamed from: a */
                final /* synthetic */ C2867f f11365a;

                {
                    this.f11365a = r1;
                }

                public void run() {
                    try {
                        this.f11365a.f11404v.findViewById(R.id.txtv_title).setVisibility(0);
                    } catch (Exception e) {
                    }
                }
            }, 500);
        }
    }

    /* renamed from: d */
    public void mo2063d() {
        super.mo2063d();
        m15871k();
    }

    /* renamed from: c */
    private void m15859c(boolean z) {
        int i = 0;
        if (this.f11407y != null && this.f11386d != null) {
            int i2;
            ListView listView = this.f11386d;
            if (z) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            listView.setVisibility(i2);
            View view = this.f11407y;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    /* renamed from: b */
    private C2606a m15856b() {
        if (this.f11406x == null) {
            this.f11406x = new C2606a();
            this.f11406x.m15025a(null);
            this.f11406x.m15024a(2);
            this.f11406x.m15028b(-1);
            this.f11406x.m15029b(null);
        }
        return this.f11406x;
    }

    /* renamed from: c */
    private void m15858c() {
        try {
            if (getArguments() != null) {
                final String string = getArguments().getString("movieId");
                final int a = C3128a.m16834a(getArguments().getString("from"));
                if (string.length() > 0) {
                    m15484h().m15090a(true);
                    this.a.postDelayed(new Runnable(this) {
                        /* renamed from: c */
                        final /* synthetic */ C2867f f11368c;

                        public void run() {
                            try {
                                this.f11368c.m15484h().m15090a(false);
                                if (a == -1) {
                                    C3065b.m16568a("push_new_movie");
                                } else {
                                    C3065b.m16569a("push_new_movie", "hour", "" + a);
                                }
                                C3167a.m16903a().m16915a(string, false, true);
                                this.f11368c.getArguments().clear();
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

    /* renamed from: j */
    private void m15869j() {
        try {
            m15484h().m15152a(new C2773d(this) {
                /* renamed from: a */
                final /* synthetic */ C2867f f11369a;

                {
                    this.f11369a = r1;
                }

                /* renamed from: a */
                public void mo2056a(boolean z) {
                    if (this.f11369a.m15484h() != null && this.f11369a.f11388f != null && !z && this.f11369a.f11388f.getText().length() < 2) {
                        this.f11369a.f11388f.setText("");
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    /* renamed from: k */
    private void m15871k() {
        C2606a b = m15856b();
        C2999a F = m15484h().m15142F();
        m15859c(true);
        F.m16329a(b, new AsyncHttpResponseHandler(this) {
            /* renamed from: a */
            final /* synthetic */ C2867f f11375a;

            {
                this.f11375a = r1;
            }

            public void onSuccess(String str, String str2, long j) {
                final String str3 = str;
                final String str4 = str2;
                final long j2 = j;
                new Thread(new Runnable(this) {
                    /* renamed from: d */
                    final /* synthetic */ AnonymousClass13 f11374d;

                    /* compiled from: MovieFragment */
                    /* renamed from: com.tdo.showbox.b.f$13$1$1 */
                    class C28561 implements Runnable {
                        /* renamed from: a */
                        final /* synthetic */ C28571 f11370a;

                        C28561(C28571 c28571) {
                            this.f11370a = c28571;
                        }

                        public void run() {
                            if (this.f11370a.f11374d.f11375a.f11387e != null && this.f11370a.f11374d.f11375a.f11386d != null && this.f11370a.f11374d.f11375a.f11405w != null) {
                                this.f11370a.f11374d.f11375a.f11387e.m17110a(this.f11370a.f11374d.f11375a.f11405w);
                                this.f11370a.f11374d.f11375a.f11386d.setSelectionFromTop(0, 0);
                                this.f11370a.f11374d.f11375a.m15859c(false);
                                this.f11370a.f11374d.f11375a.m15853a();
                            }
                        }
                    }

                    public void run() {
                        this.f11374d.f11375a.f11405w = C2982e.m16303a(str3);
                        if (this.f11374d.f11375a.f11405w != null) {
                            C3016f.m16398a(str4, j2, str3);
                        }
                        ActiveAndroid.beginTransaction();
                        new Delete().from(MovieItem.class).where("in_lib=0 AND from_push!=1").execute();
                        for (MovieItem save : this.f11374d.f11375a.f11405w) {
                            save.save();
                        }
                        ActiveAndroid.setTransactionSuccessful();
                        ActiveAndroid.endTransaction();
                        Activity h = this.f11374d.f11375a.m15484h();
                        if (h != null) {
                            h.runOnUiThread(new C28561(this));
                        }
                    }
                }).start();
            }

            public void onFailure(Throwable th, String str) {
                super.onFailure(th, str);
                this.f11375a.m15859c(false);
            }
        });
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.a.postDelayed(new C28592(this), 400);
    }

    /* renamed from: a */
    public void m15877a(String str) {
        try {
            if (str.equals("")) {
                this.f11398p = m15484h().getString(R.string.year);
            } else {
                this.f11398p = str.toUpperCase();
            }
            this.f11397o.setText(this.f11398p);
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public void m15879b(String str) {
        try {
            if (str.equals("")) {
                this.f11396n = m15484h().getString(R.string.genre);
            } else {
                this.f11396n = str.toUpperCase();
            }
            this.f11395m.setText(this.f11396n);
        } catch (Exception e) {
        }
    }

    /* renamed from: d */
    private void m15861d(boolean z) {
        if (this.f11391i == null || z) {
            this.f11391i = new C3235m(m15484h(), 0);
        }
        this.f11390h.setAdapter(this.f11391i);
        this.f11391i.m17145a(new C28603(this));
    }

    /* renamed from: e */
    private void m15863e(boolean z) {
        this.f11393k = new ArrayList();
        Category category = new Category();
        category.setName(m15484h().getString(R.string.genre_all));
        category.setCatId("-1");
        this.f11393k.add(category);
        this.f11393k.addAll(new Select().from(Category.class).orderBy("name ASC").execute());
        if (this.f11392j == null || z) {
            this.f11392j = new C3233l(m15484h(), (Category) this.f11393k.get(0), this.f11393k, 0);
        }
        this.f11389g.setAdapter(this.f11392j);
        this.f11392j.m17141a(new C28614(this));
    }

    /* renamed from: l */
    private void m15873l() {
        if (this.f11394l == null) {
            this.f11394l = new C3231k(m15484h(), 2, new C28625(this));
        }
        this.f11385c.setAdapter(this.f11394l);
    }

    public void onPause() {
        C3184j.m16982a(m15484h(), this.f11388f);
        super.onPause();
    }

    public void onDestroy() {
        if (this.f11386d != null) {
            this.f11386d.setAdapter(null);
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m15874m();
    }

    /* renamed from: m */
    private void m15874m() {
        this.f11387e.notifyDataSetChanged();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C3167a.m16903a().m16915a(this.f11387e.m17109a(i).getMovieId(), false, false);
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return this.f11402t;
    }

    /* renamed from: n */
    private void m15876n() {
        if (!this.f11400r) {
            this.f11400r = true;
            C3065b.m16568a("movie_search");
        }
    }

    /* renamed from: e */
    public void mo2064e() {
        try {
            this.f11402t.m15283b();
        } catch (Exception e) {
        }
    }
}
