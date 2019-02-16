package com.tdo.showbox.p117b.p118a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2705e;
import com.tdo.showbox.activities.p115a.C2705e.C2701a;
import com.tdo.showbox.activities.p115a.C2705e.C2702b;
import com.tdo.showbox.activities.p115a.C2705e.C2703c;
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
import com.tdo.showbox.p117b.C2769a;
import com.tdo.showbox.p117b.p118a.C2801c;
import com.tdo.showbox.p121g.C3224i;
import com.tdo.showbox.p121g.C3227j;
import com.tdo.showbox.p121g.C3227j.C2790a;
import com.tdo.showbox.p121g.C3233l;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3184j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PhoneShowsFragment */
/* renamed from: com.tdo.showbox.b.a.c */
public class C2801c extends C2769a implements OnItemClickListener, C2701a, C2702b, C2703c {
    /* renamed from: c */
    private Spinner f11205c;
    /* renamed from: d */
    private Spinner f11206d;
    /* renamed from: e */
    private List<TvItem> f11207e;
    /* renamed from: f */
    private ListView f11208f;
    /* renamed from: g */
    private C3224i f11209g;
    /* renamed from: h */
    private EditText f11210h;
    /* renamed from: i */
    private C3227j f11211i;
    /* renamed from: j */
    private C3233l f11212j;
    /* renamed from: k */
    private List<Category> f11213k;
    /* renamed from: l */
    private TextView f11214l;
    /* renamed from: m */
    private String f11215m;
    /* renamed from: n */
    private ViewGroup f11216n;
    /* renamed from: o */
    private Dialog f11217o;
    /* renamed from: p */
    private boolean f11218p;
    /* renamed from: q */
    private C2705e f11219q = new C2705e();
    /* renamed from: r */
    private boolean f11220r = false;
    /* renamed from: s */
    private View f11221s;
    /* renamed from: t */
    private C2606a f11222t;
    /* renamed from: u */
    private View f11223u;

    /* compiled from: PhoneShowsFragment */
    /* renamed from: com.tdo.showbox.b.a.c$1 */
    class C27891 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2801c f11188a;

        C27891(C2801c c2801c) {
            this.f11188a = c2801c;
        }

        public void onClick(View view) {
            this.f11188a.f11205c.performClick();
        }
    }

    /* compiled from: PhoneShowsFragment */
    /* renamed from: com.tdo.showbox.b.a.c$2 */
    class C27912 implements C2790a {
        /* renamed from: a */
        final /* synthetic */ C2801c f11189a;

        C27912(C2801c c2801c) {
            this.f11189a = c2801c;
        }

        /* renamed from: a */
        public void mo2065a(int i) {
            this.f11189a.m15684j().m15024a(i);
            this.f11189a.m15684j().m15026a(C3076a.m16648b(i));
            this.f11189a.m15687k();
        }
    }

    /* compiled from: PhoneShowsFragment */
    /* renamed from: com.tdo.showbox.b.a.c$3 */
    class C27923 implements C2782f {
        /* renamed from: a */
        final /* synthetic */ C2801c f11190a;

        C27923(C2801c c2801c) {
            this.f11190a = c2801c;
        }

        /* renamed from: a */
        public void mo2058a(Category category) {
            if (category == null) {
                category = new Category();
                category.setName("");
                category.setCatId("-1");
            }
            this.f11190a.m15704b(category.getName());
            this.f11190a.m15684j().m15025a(category);
            this.f11190a.m15687k();
        }
    }

    /* compiled from: PhoneShowsFragment */
    /* renamed from: com.tdo.showbox.b.a.c$4 */
    class C27934 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2801c f11191a;

        C27934(C2801c c2801c) {
            this.f11191a = c2801c;
        }

        public void onClick(View view) {
            this.f11191a.f11206d.performClick();
        }
    }

    /* compiled from: PhoneShowsFragment */
    /* renamed from: com.tdo.showbox.b.a.c$5 */
    class C27945 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2801c f11192a;

        C27945(C2801c c2801c) {
            this.f11192a = c2801c;
        }

        public void onClick(View view) {
            this.f11192a.m15696p();
        }
    }

    /* compiled from: PhoneShowsFragment */
    /* renamed from: com.tdo.showbox.b.a.c$6 */
    class C27956 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2801c f11193a;

        C27956(C2801c c2801c) {
            this.f11193a = c2801c;
        }

        public void run() {
            try {
                this.f11193a.f11223u.findViewById(R.id.txtv_title).setVisibility(0);
            } catch (Exception e) {
            }
        }
    }

    /* compiled from: PhoneShowsFragment */
    /* renamed from: com.tdo.showbox.b.a.c$7 */
    class C27987 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C2801c f11199a;

        C27987(C2801c c2801c) {
            this.f11199a = c2801c;
        }

        public void onSuccess(String str, String str2, long j) {
            final String str3 = str;
            final String str4 = str2;
            final long j2 = j;
            new Thread(new Runnable(this) {
                /* renamed from: d */
                final /* synthetic */ C27987 f11198d;

                /* compiled from: PhoneShowsFragment */
                /* renamed from: com.tdo.showbox.b.a.c$7$1$1 */
                class C27961 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C27971 f11194a;

                    C27961(C27971 c27971) {
                        this.f11194a = c27971;
                    }

                    public void run() {
                        this.f11194a.f11198d.f11199a.f11209g.m17132a(this.f11194a.f11198d.f11199a.f11207e);
                        this.f11194a.f11198d.f11199a.f11208f.setSelectionFromTop(0, 0);
                        this.f11194a.f11198d.f11199a.m15676c(false);
                        this.f11194a.f11198d.f11199a.m15674c();
                    }
                }

                public void run() {
                    this.f11198d.f11199a.f11207e = C2984g.m16306a(str3);
                    if (this.f11198d.f11199a.f11207e != null) {
                        C3016f.m16398a(str4, j2, str3);
                    }
                    ActiveAndroid.beginTransaction();
                    new Delete().from(TvItem.class).where("in_lib=0 AND from_push!=1").execute();
                    for (TvItem save : this.f11198d.f11199a.f11207e) {
                        save.save();
                    }
                    ActiveAndroid.setTransactionSuccessful();
                    ActiveAndroid.endTransaction();
                    Activity f = this.f11198d.f11199a.m15484h();
                    if (f != null) {
                        f.runOnUiThread(new C27961(this));
                    }
                }
            }).start();
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            this.f11199a.m15676c(false);
        }
    }

    /* compiled from: PhoneShowsFragment */
    /* renamed from: com.tdo.showbox.b.a.c$9 */
    class C28009 implements C2773d {
        /* renamed from: a */
        final /* synthetic */ C2801c f11204a;

        C28009(C2801c c2801c) {
            this.f11204a = c2801c;
        }

        /* renamed from: a */
        public void mo2056a(boolean z) {
            if (this.f11204a.m15484h() != null && this.f11204a.f11210h != null && !z && this.f11204a.f11210h.getText().length() < 2) {
                this.f11204a.f11210h.setText("");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_shows, null);
        this.f11218p = false;
        this.f11216n = (ViewGroup) layoutInflater.inflate(R.layout.dialog_filter_shows, null);
        this.f11205c = (Spinner) this.f11216n.findViewById(R.id.sort_spinner);
        this.f11206d = (Spinner) this.f11216n.findViewById(R.id.sort_genre_spinner);
        this.f11214l = (TextView) this.f11216n.findViewById(R.id.txtv_genre_spinner);
        this.f11221s = this.a.findViewById(R.id.search_progress);
        this.f11208f = (ListView) this.a.findViewById(R.id.tv_grid_view);
        this.f11223u = LayoutInflater.from(m15484h()).inflate(R.layout.list_movies_footer, null, false);
        this.f11208f.addFooterView(this.f11223u);
        this.f11210h = (EditText) this.a.findViewById(R.id.edttx_search);
        if (this.f11207e == null) {
            this.f11207e = new ArrayList();
        }
        if (this.f11209g == null) {
            this.f11209g = new C3224i(m15484h(), false, this.f11207e);
        } else {
            this.f11209g.m17132a(this.f11207e);
        }
        this.f11209g.m17004a(this);
        this.f11208f.setAdapter(this.f11209g);
        m15698r();
        this.f11216n.findViewById(R.id.sort_by).setOnClickListener(new C27891(this));
        this.f11216n.findViewById(R.id.genre).setOnClickListener(new C27934(this));
        m15678d(false);
        if (this.f11215m != null) {
            this.f11214l.setText(this.f11215m);
        }
        this.a.findViewById(R.id.f_view).setOnClickListener(new C27945(this));
        m15697q();
        C3065b.m16568a("tv_list");
        m15694o();
        m15693n();
        m15691m();
        m15689l();
        if (this.f11207e.size() == 0) {
            m15687k();
        }
        return this.a;
    }

    /* renamed from: c */
    private void m15674c() {
        if (!this.f11209g.isEmpty()) {
            this.f11208f.postDelayed(new C27956(this), 200);
        }
    }

    /* renamed from: d */
    public void mo2063d() {
        super.mo2063d();
        m15687k();
    }

    /* renamed from: j */
    private C2606a m15684j() {
        if (this.f11222t == null) {
            this.f11222t = new C2606a();
            this.f11222t.m15025a(null);
            this.f11222t.m15024a(2);
            this.f11222t.m15028b(-1);
            this.f11222t.m15029b(null);
        }
        return this.f11222t;
    }

    /* renamed from: k */
    private void m15687k() {
        C2606a j = m15684j();
        C2999a F = m15484h().m15142F();
        m15676c(true);
        F.m16337b(j, new C27987(this));
    }

    /* renamed from: c */
    private void m15676c(boolean z) {
        int i = 0;
        if (this.f11221s != null && this.f11208f != null) {
            int i2;
            ListView listView = this.f11208f;
            if (z) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            listView.setVisibility(i2);
            View view = this.f11221s;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    /* renamed from: l */
    private void m15689l() {
        try {
            if (getArguments() != null) {
                final int a = C3128a.m16834a(getArguments().getString("from"));
                final String string = getArguments().getString("showId");
                final boolean z = getArguments().getBoolean("openLastSeason");
                if (string.length() > 0 && !this.f11220r) {
                    this.f11220r = true;
                    m15484h().m15090a(true);
                    this.a.postDelayed(new Runnable(this) {
                        /* renamed from: d */
                        final /* synthetic */ C2801c f11203d;

                        public void run() {
                            try {
                                this.f11203d.m15484h().m15090a(false);
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
                                this.f11203d.getArguments().clear();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 1200);
                }
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: m */
    private void m15691m() {
        if (m15484h().m15148L()) {
            this.a.findViewById(R.id.search_container).setVisibility(8);
        } else {
            this.a.findViewById(R.id.search_container).setVisibility(0);
        }
    }

    /* renamed from: n */
    private void m15693n() {
        this.f11219q.m15348b(m15484h().getString(R.string.tv_show));
        this.f11219q.m15344a((C2702b) this);
        this.f11219q.m15343a((C2701a) this);
        this.f11219q.m15345a((C2703c) this);
        this.f11219q.m15346a(m15484h().getString(R.string.search_text_shows));
    }

    /* renamed from: o */
    private void m15694o() {
        try {
            m15484h().m15152a(new C28009(this));
        } catch (Exception e) {
        }
    }

    /* renamed from: p */
    private void m15696p() {
        this.f11217o.show();
    }

    /* renamed from: q */
    private void m15697q() {
        this.f11217o = new Dialog(m15484h(), R.style.custom_dialog);
        this.f11217o.requestWindowFeature(1);
        this.f11217o.setContentView(this.f11216n);
        Window window = this.f11217o.getWindow();
        window.setBackgroundDrawableResource(17170445);
        window.getAttributes().windowAnimations = R.style.FilterDialogAnimation;
        window.setGravity(53);
        window.getAttributes().dimAmount = 0.0f;
        this.f11217o.findViewById(R.id.ok_btn).setOnClickListener(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ C2801c f11186a;

            {
                this.f11186a = r1;
            }

            public void onClick(View view) {
                try {
                    this.f11186a.f11217o.dismiss();
                } catch (Exception e) {
                }
            }
        });
        this.f11217o.findViewById(R.id.main).setOnClickListener(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ C2801c f11187a;

            {
                this.f11187a = r1;
            }

            public void onClick(View view) {
                try {
                    this.f11187a.f11217o.dismiss();
                } catch (Exception e) {
                }
            }
        });
    }

    /* renamed from: b */
    public void m15704b(String str) {
        try {
            if (str.equals("")) {
                this.f11215m = m15484h().getString(R.string.genre);
            } else {
                this.f11215m = str.toUpperCase();
            }
            this.f11214l.setText(this.f11215m);
        } catch (Exception e) {
        }
    }

    /* renamed from: r */
    private void m15698r() {
        if (this.f11211i == null) {
            this.f11211i = new C3227j(m15484h(), 1, new C27912(this));
        }
        this.f11205c.setAdapter(this.f11211i);
    }

    /* renamed from: d */
    private void m15678d(boolean z) {
        this.f11213k = new ArrayList();
        Category category = new Category();
        category.setName(m15484h().getString(R.string.genre_all));
        category.setCatId("-1");
        this.f11213k.add(category);
        this.f11213k.addAll(new Select().from(Category.class).orderBy("name ASC").execute());
        if (this.f11212j == null || z) {
            this.f11212j = new C3233l(m15484h(), (Category) this.f11213k.get(0), this.f11213k, 0);
        }
        if (this.f11212j.getCount() <= 2) {
            this.f11212j = new C3233l(m15484h(), (Category) this.f11213k.get(0), this.f11213k, 0);
        }
        this.f11206d.setAdapter(this.f11212j);
        this.f11212j.m17141a(new C27923(this));
    }

    public void onDestroy() {
        if (this.f11208f != null) {
            this.f11208f.setAdapter(null);
        }
        super.onDestroy();
    }

    public void onPause() {
        C3184j.m16982a(m15484h(), this.f11210h);
        super.onPause();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        try {
            TvItem tvItem = (TvItem) new Select().from(TvItem.class).where("Id=" + this.f11209g.m17130a(i).getId()).executeSingle();
            C3167a.m16903a().m16919b(tvItem.getLast_vieved_season() == 0 ? "-1" : "" + tvItem.getLast_vieved_season(), tvItem.getItemId());
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        return this.f11219q;
    }

    /* renamed from: b */
    public void mo2062b() {
        m15696p();
    }

    /* renamed from: a */
    public void mo2060a() {
        m15684j().m15029b(null);
        m15687k();
    }

    /* renamed from: a */
    public void mo2061a(String str) {
        if (this.f11209g != null) {
            if (str.length() < 2) {
                m15684j().m15029b(null);
                this.a.findViewById(R.id.f_view).setEnabled(true);
                if (VERSION.SDK_INT > 11) {
                    this.a.findViewById(R.id.f_view).setAlpha(1.0f);
                }
            } else {
                m15684j().m15029b(str.toString());
                this.a.findViewById(R.id.f_view).setEnabled(false);
                if (VERSION.SDK_INT > 11) {
                    this.a.findViewById(R.id.f_view).setAlpha(0.5f);
                }
            }
            m15687k();
            m15699s();
        }
    }

    /* renamed from: s */
    private void m15699s() {
        if (!this.f11218p) {
            this.f11218p = true;
            C3065b.m16568a("tv_search");
        }
    }

    /* renamed from: e */
    public void mo2064e() {
        try {
            this.f11219q.m15347b();
        } catch (Exception e) {
        }
    }
}
