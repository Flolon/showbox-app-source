package com.tdo.showbox.p117b;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2741m;
import com.tdo.showbox.activities.p115a.C2741m.C2739a;
import com.tdo.showbox.activities.p115a.C2741m.C2740b;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.p119b.p120a.C3031c;
import com.tdo.showbox.data.p119b.p120a.C3031c.C2747a;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.models.UpdateItem;
import com.tdo.showbox.models.UserInfo;
import com.tdo.showbox.p121g.C3245q;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.views.ExtListView;
import com.tdo.showbox.views.ExtListView.C2746a;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: UpdatesFragment */
/* renamed from: com.tdo.showbox.b.q */
public class C2967q extends C2769a implements OnClickListener, OnItemClickListener, C2740b {
    /* renamed from: c */
    private final int f11770c = 2;
    /* renamed from: d */
    private final int f11771d = IjkMediaCodecInfo.RANK_MAX;
    /* renamed from: e */
    private ExtListView f11772e;
    /* renamed from: f */
    private C3245q f11773f;
    /* renamed from: g */
    private List<UpdateItem> f11774g;
    /* renamed from: h */
    private List<UpdateItem> f11775h;
    /* renamed from: i */
    private List<UpdateItem> f11776i;
    /* renamed from: j */
    private View f11777j;
    /* renamed from: k */
    private View f11778k;
    /* renamed from: l */
    private View f11779l;
    /* renamed from: m */
    private int f11780m = -1;
    /* renamed from: n */
    private View f11781n;
    /* renamed from: o */
    private TextView f11782o;
    /* renamed from: p */
    private TextView f11783p;
    /* renamed from: q */
    private TextView f11784q;
    /* renamed from: r */
    private View f11785r;
    /* renamed from: s */
    private View f11786s;
    /* renamed from: t */
    private View f11787t;
    /* renamed from: u */
    private View f11788u;
    /* renamed from: v */
    private int f11789v;
    /* renamed from: w */
    private C2741m f11790w = new C2741m();
    /* renamed from: x */
    private C3031c f11791x;

    /* compiled from: UpdatesFragment */
    /* renamed from: com.tdo.showbox.b.q$1 */
    class C29641 implements C2746a {
        /* renamed from: a */
        final /* synthetic */ C2967q f11767a;

        C29641(C2967q c2967q) {
            this.f11767a = c2967q;
        }

        /* renamed from: a */
        public void mo2031a() {
            this.f11767a.f11772e.m17205a();
            this.f11767a.m16241a().m16438g();
        }
    }

    /* compiled from: UpdatesFragment */
    /* renamed from: com.tdo.showbox.b.q$2 */
    class C29652 implements C2747a {
        /* renamed from: a */
        final /* synthetic */ C2967q f11768a;

        C29652(C2967q c2967q) {
            this.f11768a = c2967q;
        }

        /* renamed from: a */
        public void mo2032a() {
            if (this.f11768a.f11773f != null && this.f11768a.m16241a().m16433b() != null) {
                this.f11768a.f11773f.m17186a(this.f11768a.m16241a().m16433b());
                this.f11768a.m16248b();
            }
        }
    }

    /* renamed from: a */
    private C3031c m16241a() {
        if (this.f11791x == null) {
            this.f11791x = new C3031c("native_new_releases");
        }
        return this.f11791x;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m16250c();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_updates, null);
        this.f11772e = (ExtListView) this.a.findViewById(R.id.tv_grid_view);
        this.f11772e.addFooterView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
        this.f11781n = this.a.findViewById(R.id.sub_tab_container);
        this.f11788u = this.a.findViewById(R.id.empty_txtv);
        this.f11782o = (TextView) this.a.findViewById(R.id.txtv_show_couner);
        this.f11783p = (TextView) this.a.findViewById(R.id.txtv_movie_couner);
        this.f11784q = (TextView) this.a.findViewById(R.id.txtv_shows_my_couner);
        this.f11787t = this.a.findViewById(R.id.shows_marker);
        this.f11786s = this.a.findViewById(R.id.movies_marker);
        this.f11785r = this.a.findViewById(R.id.shows__my_marker);
        this.f11777j = this.a.findViewById(R.id.txtv_shows);
        this.f11778k = this.a.findViewById(R.id.txtv_movies);
        this.f11779l = this.a.findViewById(R.id.txtv_my_shows);
        this.f11778k.setOnClickListener(this);
        this.f11777j.setOnClickListener(this);
        this.f11779l.setOnClickListener(this);
        this.f11780m = C3088f.m16681b("PREFS_SELECTED_NEWS", 1);
        this.f11773f = new C3245q(m15484h(), new ArrayList(), !m15484h().m15148L());
        this.f11781n.setVisibility(0);
        ActiveAndroid.beginTransaction();
        this.f11775h = new Select().from(UpdateItem.class).where("is_movie=1").orderBy("date_ms DESC").execute();
        this.f11774g = new Select().from(UpdateItem.class).where("is_movie=0").orderBy("date_ms DESC").execute();
        this.f11776i = m16244a(this.f11774g);
        ActiveAndroid.setTransactionSuccessful();
        ActiveAndroid.endTransaction();
        if (this.f11776i != null && this.f11776i.size() > 0) {
            m16245a((int) R.id.txtv_my_shows);
            this.f11790w.m15428a(C2739a.MY);
        } else if (this.f11780m == 1) {
            m16245a((int) R.id.txtv_shows);
            this.f11790w.m15428a(C2739a.SHOW);
        } else if (this.f11780m == 2) {
            m16245a((int) R.id.txtv_movies);
            this.f11790w.m15428a(C2739a.MOVIES);
        } else if (this.f11780m == 3) {
            m16245a((int) R.id.txtv_my_shows);
            this.f11790w.m15428a(C2739a.MY);
        }
        m16259n();
        m16260o();
        this.f11790w.m15429a((C2740b) this);
        this.a.findViewById(R.id.sub_tab_container).setVisibility(8);
        return this.a;
    }

    /* renamed from: b */
    private void m16248b() {
        this.f11772e.m17206a(m16241a().m16433b(), new C29641(this));
    }

    public void onResume() {
        super.onResume();
        if (m15484h().m15148L()) {
            m16241a().m16436e();
            m16241a().m16431a(new C29652(this));
        }
    }

    public void onPause() {
        super.onPause();
        if (m15484h().m15148L()) {
            m16241a().m16437f();
            if (this.f11773f != null) {
                this.f11773f.m17186a(null);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (m15484h().m15148L()) {
            m16241a().m16435d();
        }
    }

    /* renamed from: c */
    private void m16250c() {
        if (m15484h().m15148L()) {
            m16241a().m16429a(m15484h(), (UserInfo) new Select().from(UserInfo.class).executeSingle());
            m16241a().m16427a(2, (int) IjkMediaCodecInfo.RANK_MAX);
        }
    }

    /* renamed from: a */
    private List<UpdateItem> m16244a(List<UpdateItem> list) {
        if (this.f11776i == null) {
            this.f11776i = new ArrayList();
        }
        this.f11789v = 0;
        this.f11776i.clear();
        for (UpdateItem updateItem : list) {
            if (((TvItem) new Select().from(TvItem.class).where("item_id=" + updateItem.getItem_id() + " AND in_lib=1").executeSingle()) != null) {
                this.f11776i.add(updateItem);
            }
            if (updateItem.getIs_viewed() == 0) {
                this.f11789v++;
            }
        }
        return this.f11776i;
    }

    /* renamed from: a */
    private void m16245a(int i) {
        this.f11788u.setVisibility(8);
        switch (i) {
            case R.id.txtv_movies:
                this.f11786s.setVisibility(0);
                this.f11787t.setVisibility(4);
                this.f11785r.setVisibility(4);
                m16254e(true);
                return;
            case R.id.txtv_my_shows:
                this.f11786s.setVisibility(4);
                this.f11787t.setVisibility(4);
                this.f11785r.setVisibility(0);
                m16251c(true);
                return;
            case R.id.txtv_shows:
                this.f11786s.setVisibility(4);
                this.f11787t.setVisibility(0);
                this.f11785r.setVisibility(4);
                m16253d(true);
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    private void m16251c(boolean z) {
        this.f11773f.m17188a(this.f11776i);
        this.f11772e.invalidate();
        this.f11773f.m17004a(this);
        C3088f.m16677a("PREFS_SELECTED_NEWS", 3);
        if (this.f11776i != null && this.f11776i.size() == 0) {
            this.f11788u.setVisibility(0);
        }
        this.f11780m = 3;
        m16258m();
        m16259n();
        if (z) {
            C3065b.m16569a("updates", "tab", "my");
        }
    }

    /* renamed from: d */
    private void m16253d(boolean z) {
        this.f11773f.m17188a(this.f11774g);
        this.f11772e.invalidate();
        m16260o();
        this.f11773f.m17004a(this);
        C3088f.m16677a("PREFS_SELECTED_NEWS", 1);
        this.f11780m = 1;
        m16255j();
        if (z) {
            C3065b.m16569a("updates", "tab", "tv");
        }
    }

    /* renamed from: e */
    private void m16254e(boolean z) {
        this.f11773f.m17188a(this.f11775h);
        this.f11772e.invalidate();
        m16260o();
        this.f11773f.m17004a(this);
        C3088f.m16677a("PREFS_SELECTED_NEWS", 2);
        this.f11780m = 2;
        m16256k();
        if (z) {
            C3065b.m16569a("updates", "tab", "movie");
        }
    }

    /* renamed from: j */
    private void m16255j() {
        C3088f.m16677a("PREFS_UPDATES_UNVIEWED_SHOWS_COUNT", 0);
        m16257l();
        new Update(UpdateItem.class).set("is_viewed=1 AND is_movie=0").execute();
        this.f11782o.setText("");
        this.f11790w.m15432b("");
    }

    /* renamed from: k */
    private void m16256k() {
        C3088f.m16677a("PREFS_UPDATES_UNVIEWED_MOVIES_COUNT", 0);
        m16257l();
        new Update(UpdateItem.class).set("is_viewed=1 AND is_movie=1").execute();
        this.f11783p.setText("");
        this.f11790w.m15430a("");
    }

    /* renamed from: l */
    private void m16257l() {
        C3088f.m16677a("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT", C3088f.m16684c("PREFS_UPDATES_UNVIEWED_SHOWS_COUNT") + C3088f.m16684c("PREFS_UPDATES_UNVIEWED_MOVIES_COUNT"));
        this.f11790w.m15431b();
    }

    /* renamed from: m */
    private void m16258m() {
        ActiveAndroid.beginTransaction();
        for (UpdateItem updateItem : this.f11776i) {
            updateItem.setIs_viewed(1);
            updateItem.save();
        }
        ActiveAndroid.setTransactionSuccessful();
        ActiveAndroid.endTransaction();
        this.f11784q.setText("");
        this.f11790w.m15434c("");
    }

    /* renamed from: e */
    public void mo2064e() {
        if (this.b) {
            C3094j.m16698a("UpdatesFragment", "onDbUpdated start updateLists");
            this.f11775h = new Select().from(UpdateItem.class).where("is_movie=1").orderBy("date_ms DESC").execute();
            this.f11774g = new Select().from(UpdateItem.class).where("is_movie=0").orderBy("date_ms DESC").execute();
            this.f11776i = m16244a(this.f11774g);
            switch (this.f11780m) {
                case 1:
                    m16253d(false);
                    break;
                case 2:
                    m16254e(false);
                    break;
                case 3:
                    m16251c(false);
                    break;
            }
            m16259n();
        }
    }

    /* renamed from: n */
    private void m16259n() {
        this.f11790w.m15431b();
        try {
            int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_SHOWS_COUNT");
            if (c > 0) {
                this.f11782o.setText("" + c);
                this.f11790w.m15432b("" + c);
            } else {
                this.f11782o.setText("");
                this.f11790w.m15432b("");
            }
            c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_MOVIES_COUNT");
            if (c > 0) {
                this.f11783p.setText("" + c);
                this.f11790w.m15430a("" + c);
            } else {
                this.f11783p.setText("");
                this.f11790w.m15430a("");
            }
            if (this.f11789v == 0) {
                this.f11784q.setText("");
                this.f11790w.m15434c("");
                return;
            }
            this.f11784q.setText(this.f11789v);
            this.f11790w.m15434c("" + this.f11789v);
        } catch (Exception e) {
        }
    }

    /* renamed from: o */
    private void m16260o() {
        this.f11772e.setAdapter(this.f11773f);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m16260o();
    }

    /* renamed from: a */
    private MovieItem m16242a(UpdateItem updateItem) {
        MovieItem movieItem = new MovieItem();
        movieItem.setMovieId(updateItem.getItem_id());
        movieItem.setPoster(updateItem.getPoster());
        movieItem.setTitle(updateItem.getTitle());
        return movieItem;
    }

    /* renamed from: b */
    private TvItem m16247b(UpdateItem updateItem) {
        TvItem tvItem = new TvItem();
        tvItem.setId(updateItem.getItem_id());
        tvItem.setPoster(updateItem.getPoster());
        tvItem.setTitle(updateItem.getTitle());
        return tvItem;
    }

    public void onClick(View view) {
        m16245a(view.getId());
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        if (this.f11780m != -1) {
            switch (this.f11780m) {
                case 1:
                    this.f11790w.m15428a(C2739a.SHOW);
                    break;
                case 2:
                    this.f11790w.m15428a(C2739a.MOVIES);
                    break;
                case 3:
                    this.f11790w.m15428a(C2739a.MY);
                    break;
            }
        }
        return this.f11790w;
    }

    /* renamed from: a */
    public void mo2082a(C2739a c2739a) {
        this.f11788u.setVisibility(8);
        switch (c2739a) {
            case MOVIES:
                m16254e(true);
                return;
            case SHOW:
                m16253d(true);
                return;
            case MY:
                m16251c(true);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        if (this.f11780m != -1) {
            switch (this.f11780m) {
                case 1:
                    this.f11790w.m15428a(C2739a.SHOW);
                    break;
                case 2:
                    this.f11790w.m15428a(C2739a.MOVIES);
                    break;
                case 3:
                    this.f11790w.m15428a(C2739a.MY);
                    break;
            }
        }
        return this.f11790w;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f11773f != null && this.f11773f.m17189b() != null && i < this.f11773f.m17189b().size()) {
            UpdateItem updateItem = (UpdateItem) this.f11773f.m17189b().get(i);
            if (updateItem.getIs_movie() == 1) {
                if (((MovieItem) new Select().from(MovieItem.class).where("movie_id=" + updateItem.getItem_id()).executeSingle()) == null) {
                    m16242a(updateItem).save();
                }
                C3167a.m16903a().m16915a(updateItem.getItem_id(), false, false);
                return;
            }
            if (((TvItem) new Select().from(TvItem.class).where("item_id=" + updateItem.getItem_id()).executeSingle()) == null) {
                m16247b(updateItem).save();
            }
            C3167a.m16903a().m16919b("-1", updateItem.getItem_id());
        }
    }
}
