package com.tdo.showbox.p117b;

import android.app.Activity;
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
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2705e.C2701a;
import com.tdo.showbox.activities.p115a.p116a.C2679d;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.data.api.C3016f;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.p124a.C2984g;
import com.tdo.showbox.data.p126d.C3076a;
import com.tdo.showbox.data.push.C3128a;
import com.tdo.showbox.models.Category;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.p111a.C2606a;
import com.tdo.showbox.p113d.C2773d;
import com.tdo.showbox.p113d.C2782f;
import com.tdo.showbox.p117b.C2914k;
import com.tdo.showbox.p121g.C3224i;
import com.tdo.showbox.p121g.C3227j;
import com.tdo.showbox.p121g.C3227j.C2790a;
import com.tdo.showbox.p121g.C3233l;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3184j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShowsFragment */
/* renamed from: com.tdo.showbox.b.k */
public class C2914k extends C2769a implements OnItemClickListener {
    /* renamed from: c */
    private Spinner f11533c;
    /* renamed from: d */
    private Spinner f11534d;
    /* renamed from: e */
    private ListView f11535e;
    /* renamed from: f */
    private C3224i f11536f;
    /* renamed from: g */
    private List<TvItem> f11537g;
    /* renamed from: h */
    private EditText f11538h;
    /* renamed from: i */
    private C3227j f11539i;
    /* renamed from: j */
    private C3233l f11540j;
    /* renamed from: k */
    private List<Category> f11541k;
    /* renamed from: l */
    private TextView f11542l;
    /* renamed from: m */
    private String f11543m;
    /* renamed from: n */
    private C2679d f11544n = new C2679d();
    /* renamed from: o */
    private boolean f11545o;
    /* renamed from: p */
    private View f11546p;
    /* renamed from: q */
    private boolean f11547q = false;
    /* renamed from: r */
    private View f11548r;
    /* renamed from: s */
    private C2606a f11549s;
    /* renamed from: t */
    private View f11550t;

    /* compiled from: ShowsFragment */
    /* renamed from: com.tdo.showbox.b.k$1 */
    class C29031 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2914k f11516a;

        C29031(C2914k c2914k) {
            this.f11516a = c2914k;
        }

        public void onClick(View view) {
            this.f11516a.f11533c.performClick();
        }
    }

    /* compiled from: ShowsFragment */
    /* renamed from: com.tdo.showbox.b.k$2 */
    class C29042 implements C2782f {
        /* renamed from: a */
        final /* synthetic */ C2914k f11517a;

        C29042(C2914k c2914k) {
            this.f11517a = c2914k;
        }

        /* renamed from: a */
        public void mo2058a(Category category) {
            if (category == null) {
                category = new Category();
                category.setName("");
                category.setCatId("-1");
            }
            this.f11517a.m16022a(category.getName());
            this.f11517a.m16003b().m15025a(category);
            this.f11517a.m16005c();
        }
    }

    /* compiled from: ShowsFragment */
    /* renamed from: com.tdo.showbox.b.k$3 */
    class C29053 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2914k f11518a;

        C29053(C2914k c2914k) {
            this.f11518a = c2914k;
        }

        public void onClick(View view) {
            this.f11518a.f11534d.performClick();
        }
    }

    /* compiled from: ShowsFragment */
    /* renamed from: com.tdo.showbox.b.k$4 */
    class C29064 implements OnEditorActionListener {
        /* renamed from: a */
        final /* synthetic */ C2914k f11519a;

        C29064(C2914k c2914k) {
            this.f11519a = c2914k;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if ((i == 3 || i == 66) && this.f11519a.f11536f != null) {
                if (this.f11519a.f11538h.getText().toString().length() < 2) {
                    this.f11519a.m16003b().m15029b(null);
                    if (VERSION.SDK_INT > 11) {
                        this.f11519a.f11546p.findViewById(R.id.genre).setAlpha(1.0f);
                        this.f11519a.f11546p.findViewById(R.id.sort_by).setAlpha(1.0f);
                    }
                    this.f11519a.f11546p.findViewById(R.id.genre).setEnabled(true);
                    this.f11519a.f11546p.findViewById(R.id.sort_by).setEnabled(true);
                } else {
                    this.f11519a.m16003b().m15029b(this.f11519a.f11538h.getText().toString());
                    if (VERSION.SDK_INT > 11) {
                        this.f11519a.f11546p.findViewById(R.id.genre).setAlpha(0.5f);
                        this.f11519a.f11546p.findViewById(R.id.sort_by).setAlpha(0.5f);
                    }
                    this.f11519a.f11546p.findViewById(R.id.genre).setEnabled(false);
                    this.f11519a.f11546p.findViewById(R.id.sort_by).setEnabled(false);
                }
                C3184j.m16982a(this.f11519a.m15484h(), this.f11519a.f11538h);
                this.f11519a.m16005c();
                this.f11519a.m16021o();
            }
            return false;
        }
    }

    /* compiled from: ShowsFragment */
    /* renamed from: com.tdo.showbox.b.k$5 */
    class C29075 implements C2701a {
        /* renamed from: a */
        final /* synthetic */ C2914k f11520a;

        C29075(C2914k c2914k) {
            this.f11520a = c2914k;
        }

        /* renamed from: a */
        public void mo2060a() {
            if (VERSION.SDK_INT > 11) {
                this.f11520a.f11546p.findViewById(R.id.genre).setAlpha(1.0f);
                this.f11520a.f11546p.findViewById(R.id.sort_by).setAlpha(1.0f);
            }
            this.f11520a.f11546p.findViewById(R.id.genre).setEnabled(true);
            this.f11520a.f11546p.findViewById(R.id.sort_by).setEnabled(true);
            C3184j.m16982a(this.f11520a.m15484h(), this.f11520a.f11538h);
            this.f11520a.m16003b().m15029b(null);
            this.f11520a.m16005c();
        }
    }

    /* compiled from: ShowsFragment */
    /* renamed from: com.tdo.showbox.b.k$6 */
    class C29086 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2914k f11521a;

        C29086(C2914k c2914k) {
            this.f11521a = c2914k;
        }

        public void run() {
            try {
                this.f11521a.f11550t.findViewById(R.id.txtv_title).setVisibility(0);
            } catch (Exception e) {
            }
        }
    }

    /* compiled from: ShowsFragment */
    /* renamed from: com.tdo.showbox.b.k$7 */
    class C29117 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C2914k f11527a;

        C29117(C2914k c2914k) {
            this.f11527a = c2914k;
        }

        public void onSuccess(String str, String str2, long j) {
            final String str3 = str;
            final String str4 = str2;
            final long j2 = j;
            new Thread(new Runnable(this) {
                /* renamed from: d */
                final /* synthetic */ C29117 f11526d;

                /* compiled from: ShowsFragment */
                /* renamed from: com.tdo.showbox.b.k$7$1$1 */
                class C29091 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C29101 f11522a;

                    C29091(C29101 c29101) {
                        this.f11522a = c29101;
                    }

                    public void run() {
                        this.f11522a.f11526d.f11527a.f11536f.m17132a(this.f11522a.f11526d.f11527a.f11537g);
                        this.f11522a.f11526d.f11527a.f11535e.setSelectionFromTop(0, 0);
                        this.f11522a.f11526d.f11527a.m16006c(false);
                        this.f11522a.f11526d.f11527a.m16000a();
                    }
                }

                public void run() {
                    this.f11526d.f11527a.f11537g = C2984g.m16306a(str3);
                    if (this.f11526d.f11527a.f11537g != null) {
                        C3016f.m16398a(str4, j2, str3);
                    }
                    ActiveAndroid.beginTransaction();
                    new Delete().from(TvItem.class).where("in_lib=0 AND from_push!=1").execute();
                    for (TvItem save : this.f11526d.f11527a.f11537g) {
                        save.save();
                    }
                    ActiveAndroid.setTransactionSuccessful();
                    ActiveAndroid.endTransaction();
                    Activity h = this.f11526d.f11527a.m15484h();
                    if (h != null) {
                        h.runOnUiThread(new C29091(this));
                    }
                }
            }).start();
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            this.f11527a.m16006c(false);
        }
    }

    /* compiled from: ShowsFragment */
    /* renamed from: com.tdo.showbox.b.k$9 */
    class C29139 implements C2773d {
        /* renamed from: a */
        final /* synthetic */ C2914k f11532a;

        C29139(C2914k c2914k) {
            this.f11532a = c2914k;
        }

        /* renamed from: a */
        public void mo2056a(boolean z) {
            if (this.f11532a.m15484h() != null && this.f11532a.f11538h != null && !z && this.f11532a.f11538h.getText().length() < 2) {
                this.f11532a.f11538h.setText("");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_shows, null);
        this.f11545o = false;
        this.f11546p = this.f11544n.m15290b(m15484h());
        this.f11548r = this.a.findViewById(R.id.search_progress);
        this.f11533c = (Spinner) this.f11546p.findViewById(R.id.sort_spinner);
        this.f11534d = (Spinner) this.f11546p.findViewById(R.id.sort_genre_spinner);
        this.f11542l = (TextView) this.f11546p.findViewById(R.id.txtv_genre_spinner);
        this.f11535e = (ListView) this.a.findViewById(R.id.tv_grid_view);
        this.f11550t = LayoutInflater.from(m15484h()).inflate(R.layout.list_movies_footer, null, false);
        this.f11535e.addFooterView(this.f11550t);
        this.f11538h = (EditText) this.f11546p.findViewById(R.id.edttx_search);
        if (this.f11537g == null) {
            this.f11537g = new ArrayList();
        }
        if (this.f11536f == null) {
            this.f11536f = new C3224i(m15484h(), true, this.f11537g);
        } else {
            this.f11536f.m17132a(this.f11537g);
        }
        this.f11536f.m17004a(this);
        this.f11535e.setAdapter(this.f11536f);
        m16017l();
        this.f11546p.findViewById(R.id.sort_by).setOnClickListener(new C29031(this));
        this.f11546p.findViewById(R.id.genre).setOnClickListener(new C29053(this));
        m16020n();
        m16019m();
        if (this.f11543m != null) {
            this.f11542l.setText(this.f11543m);
        }
        C3065b.m16568a("tv_list");
        m16016k();
        m16014j();
        if (this.f11537g.size() == 0) {
            m16005c();
        }
        this.f11538h.setOnEditorActionListener(new C29064(this));
        this.f11544n.m15289a(new C29075(this));
        return this.a;
    }

    /* renamed from: a */
    private void m16000a() {
        if (!this.f11536f.isEmpty()) {
            this.f11535e.postDelayed(new C29086(this), 200);
        }
    }

    /* renamed from: d */
    public void mo2063d() {
        super.mo2063d();
        m16005c();
    }

    /* renamed from: c */
    private void m16006c(boolean z) {
        int i = 0;
        if (this.f11548r != null && this.f11535e != null) {
            int i2;
            ListView listView = this.f11535e;
            if (z) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            listView.setVisibility(i2);
            View view = this.f11548r;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    /* renamed from: b */
    private C2606a m16003b() {
        if (this.f11549s == null) {
            this.f11549s = new C2606a();
            this.f11549s.m15025a(null);
            this.f11549s.m15024a(2);
            this.f11549s.m15028b(-1);
            this.f11549s.m15029b(null);
        }
        return this.f11549s;
    }

    /* renamed from: c */
    private void m16005c() {
        C2606a b = m16003b();
        C2999a F = m15484h().m15142F();
        m16006c(true);
        F.m16337b(b, new C29117(this));
    }

    /* renamed from: j */
    private void m16014j() {
        try {
            final int a = C3128a.m16834a(getArguments().getString("from"));
            final String string = getArguments().getString("showId");
            final boolean z = getArguments().getBoolean("openLastSeason");
            if (string.length() > 0 && !this.f11547q) {
                this.f11547q = true;
                m15484h().m15090a(true);
                this.a.postDelayed(new Runnable(this) {
                    /* renamed from: d */
                    final /* synthetic */ C2914k f11531d;

                    public void run() {
                        try {
                            this.f11531d.m15484h().m15090a(false);
                            TvItem tvItem = (TvItem) new Select().from(TvItem.class).where("item_id=" + string).executeSingle();
                            String str = tvItem.getLast_vieved_season() == 0 ? "-1" : "" + tvItem.getLast_vieved_season();
                            if (z) {
                                str = tvItem.getSeasons();
                                if (a == -1) {
                                    C3065b.m16568a("push_new_episode");
                                } else {
                                    C3065b.m16569a("push_new_episode", "hour", "" + a);
                                }
                            } else if (a == -1) {
                                C3065b.m16568a("push_new_show");
                            } else {
                                C3065b.m16569a("push_new_show", "hour", "" + a);
                            }
                            C3167a.m16903a().m16919b(str, tvItem.getItemId());
                            this.f11531d.getArguments().clear();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 1200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    private void m16016k() {
        try {
            m15484h().m15152a(new C29139(this));
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m16022a(String str) {
        try {
            if (str.equals("")) {
                this.f11543m = m15484h().getString(R.string.genre);
            } else {
                this.f11543m = str.toUpperCase();
            }
            this.f11542l.setText(this.f11543m);
        } catch (Exception e) {
        }
    }

    /* renamed from: l */
    private void m16017l() {
        if (this.f11539i == null) {
            this.f11539i = new C3227j(m15484h(), 1, new C2790a(this) {
                /* renamed from: a */
                final /* synthetic */ C2914k f11515a;

                {
                    this.f11515a = r1;
                }

                /* renamed from: a */
                public void mo2065a(int i) {
                    this.f11515a.m16003b().m15024a(i);
                    this.f11515a.m16003b().m15026a(C3076a.m16648b(i));
                    this.f11515a.m16005c();
                }
            });
        }
        this.f11533c.setAdapter(this.f11539i);
    }

    /* renamed from: m */
    private void m16019m() {
        this.f11541k = new ArrayList();
        Category category = new Category();
        category.setName(m15484h().getString(R.string.genre_all));
        category.setCatId("-1");
        this.f11541k.add(category);
        this.f11541k.addAll(new Select().from(Category.class).orderBy("name ASC").execute());
        if (this.f11540j == null) {
            this.f11540j = new C3233l(m15484h(), (Category) this.f11541k.get(0), this.f11541k, 0);
        }
        if (this.f11540j.getCount() <= 2) {
            this.f11540j = new C3233l(m15484h(), (Category) this.f11541k.get(0), this.f11541k, 0);
        }
        this.f11534d.setAdapter(this.f11540j);
        this.f11540j.m17141a(new C29042(this));
    }

    public void onDestroy() {
        if (this.f11535e != null) {
            this.f11535e.setAdapter(null);
        }
        super.onDestroy();
    }

    public void onPause() {
        C3184j.m16982a(m15484h(), this.f11538h);
        super.onPause();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m16020n();
    }

    /* renamed from: n */
    private void m16020n() {
        this.f11536f.notifyDataSetChanged();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        try {
            TvItem tvItem = (TvItem) new Select().from(TvItem.class).where("Id=" + this.f11536f.m17130a(i).getId()).executeSingle();
            C3167a.m16903a().m16919b(tvItem.getLast_vieved_season() == 0 ? "-1" : "" + tvItem.getLast_vieved_season(), this.f11536f.m17130a(i).getItemId());
            m15484h().m15138B();
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return this.f11544n;
    }

    /* renamed from: o */
    private void m16021o() {
        if (!this.f11545o) {
            this.f11545o = true;
            C3065b.m16568a("tv_search");
        }
    }

    /* renamed from: e */
    public void mo2064e() {
        try {
            this.f11544n.m15291b();
        } catch (Exception e) {
        }
    }
}
