package com.tdo.showbox.p117b;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.activities.ScrollHintActivity;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2711f;
import com.tdo.showbox.activities.p115a.C2711f.C2709a;
import com.tdo.showbox.activities.p115a.C2711f.C2710b;
import com.tdo.showbox.activities.p115a.p116a.C2675c;
import com.tdo.showbox.b.j.AnonymousClass11;
import com.tdo.showbox.b.j.AnonymousClass15;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3093i;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.ObjParser;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.p112c.C2754b;
import com.tdo.showbox.data.p112c.C3074a;
import com.tdo.showbox.data.p119b.p120a.C3031c;
import com.tdo.showbox.data.p119b.p120a.C3031c.C2747a;
import com.tdo.showbox.data.p119b.p120a.C3034d;
import com.tdo.showbox.data.p119b.p120a.C3034d.C2814a;
import com.tdo.showbox.data.torrent.C3141b;
import com.tdo.showbox.data.torrent.C3141b.C2760a;
import com.tdo.showbox.models.Category;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.Episod;
import com.tdo.showbox.models.EpisodeResponse;
import com.tdo.showbox.models.Season;
import com.tdo.showbox.models.SeasonLastViewItem;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.models.TvItemMeta;
import com.tdo.showbox.models.UserInfo;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import com.tdo.showbox.p117b.C2902j;
import com.tdo.showbox.p117b.C2902j.11.C28871;
import com.tdo.showbox.p117b.C2902j.11.C28882;
import com.tdo.showbox.p117b.C2902j.11.C28893;
import com.tdo.showbox.p121g.C3204b.C2771a;
import com.tdo.showbox.p121g.C3221h;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3178f;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.views.C3303a;
import com.tdo.showbox.views.C3303a.C2816a;
import com.tdo.showbox.views.ExtListView;
import com.tdo.showbox.views.ExtListView.C2746a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: ShowsDetailsFragment */
/* renamed from: com.tdo.showbox.b.j */
public class C2902j extends C2769a implements OnClickListener, C2709a, C2710b, C2771a {
    /* renamed from: A */
    private C2675c f11487A = new C2675c();
    /* renamed from: B */
    private View f11488B;
    /* renamed from: C */
    private C3031c f11489C;
    /* renamed from: D */
    private C3034d f11490D;
    /* renamed from: c */
    private final String f11491c = "VIEW_TAG_CONTAINER_AD";
    /* renamed from: d */
    private String f11492d;
    /* renamed from: e */
    private String f11493e;
    /* renamed from: f */
    private TextView f11494f;
    /* renamed from: g */
    private Spinner f11495g;
    /* renamed from: h */
    private Dialog f11496h;
    /* renamed from: i */
    private C3221h f11497i;
    /* renamed from: j */
    private List<Episod> f11498j;
    /* renamed from: k */
    private Integer f11499k;
    /* renamed from: l */
    private TvItem f11500l;
    /* renamed from: m */
    private ImageView f11501m;
    /* renamed from: n */
    private Season f11502n;
    /* renamed from: o */
    private ExtListView f11503o;
    /* renamed from: p */
    private View f11504p;
    /* renamed from: q */
    private boolean f11505q;
    /* renamed from: r */
    private boolean f11506r;
    /* renamed from: s */
    private C3074a f11507s;
    /* renamed from: t */
    private TextView f11508t;
    /* renamed from: u */
    private TextView f11509u;
    /* renamed from: v */
    private View f11510v;
    /* renamed from: w */
    private View f11511w;
    /* renamed from: x */
    private boolean f11512x;
    /* renamed from: y */
    private TextView f11513y;
    /* renamed from: z */
    private C2711f f11514z;

    /* compiled from: ShowsDetailsFragment */
    /* renamed from: com.tdo.showbox.b.j$1 */
    class C28921 implements C2746a {
        /* renamed from: a */
        final /* synthetic */ C2902j f11472a;

        C28921(C2902j c2902j) {
            this.f11472a = c2902j;
        }

        /* renamed from: a */
        public void mo2031a() {
            this.f11472a.f11503o.m17205a();
            this.f11472a.m15973k().m16438g();
        }
    }

    /* compiled from: ShowsDetailsFragment */
    /* renamed from: com.tdo.showbox.b.j$3 */
    class C28953 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C2902j f11476a;

        C28953(C2902j c2902j) {
            this.f11476a = c2902j;
        }

        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
        }
    }

    /* compiled from: ShowsDetailsFragment */
    /* renamed from: com.tdo.showbox.b.j$5 */
    class C28975 implements C2816a {
        /* renamed from: a */
        final /* synthetic */ C2902j f11479a;

        C28975(C2902j c2902j) {
            this.f11479a = c2902j;
        }

        /* renamed from: a */
        public void mo2068a(DownloadEpisode downloadEpisode) {
            this.f11479a.m15484h().m15154a(downloadEpisode);
            Toast.makeText(this.f11479a.m15484h(), this.f11479a.m15484h().getString(R.string.video_added_toast), 0).show();
            this.f11479a.m15484h().mo2004b().m16490b("episode_details__");
        }
    }

    /* compiled from: ShowsDetailsFragment */
    /* renamed from: com.tdo.showbox.b.j$6 */
    class C28986 implements C2747a {
        /* renamed from: a */
        final /* synthetic */ C2902j f11480a;

        C28986(C2902j c2902j) {
            this.f11480a = c2902j;
        }

        /* renamed from: a */
        public void mo2032a() {
            if (this.f11480a.f11503o != null) {
                View findViewWithTag = this.f11480a.f11503o.findViewWithTag("VIEW_TAG_CONTAINER_AD");
                if (!(findViewWithTag == null || this.f11480a.m15973k().m16433b() == null)) {
                    if (findViewWithTag instanceof ViewGroup) {
                        ((ViewGroup) findViewWithTag).removeAllViews();
                        ((ViewGroup) findViewWithTag).addView(this.f11480a.m15973k().m16433b());
                    } else {
                        throw new RuntimeException("expected ViewGroup as 'ad container'");
                    }
                }
                this.f11480a.m15975l();
            }
        }
    }

    /* compiled from: ShowsDetailsFragment */
    /* renamed from: com.tdo.showbox.b.j$8 */
    class C29008 implements C2816a {
        /* renamed from: a */
        final /* synthetic */ C2902j f11484a;

        C29008(C2902j c2902j) {
            this.f11484a = c2902j;
        }

        /* renamed from: a */
        public void mo2068a(DownloadEpisode downloadEpisode) {
            this.f11484a.m15484h().m15154a(downloadEpisode);
            Toast.makeText(this.f11484a.m15484h(), this.f11484a.m15484h().getString(R.string.video_added_toast), 0).show();
            this.f11484a.m15484h().mo2004b().m16490b("episode_details__");
        }
    }

    /* renamed from: a */
    public static C2902j m15937a(String str, String str2, boolean z) {
        C2902j c2902j = new C2902j();
        Bundle bundle = new Bundle();
        SeasonLastViewItem a = C3093i.m16696a(str2);
        if (a == null) {
            bundle.putString("ARG_SEASON", "" + str);
        } else {
            bundle.putString("ARG_SEASON", "" + a.getLast_season());
        }
        bundle.putString("ARG_ID", str2);
        bundle.putBoolean("ARG_NEED_REMOVE", z);
        c2902j.setArguments(bundle);
        return c2902j;
    }

    /* renamed from: k */
    private C3031c m15973k() {
        if (this.f11489C == null) {
            this.f11489C = new C3031c("native_shows_details");
        }
        return this.f11489C;
    }

    /* renamed from: l */
    private void m15975l() {
        this.f11503o.m17206a(this.f11503o.findViewWithTag("VIEW_TAG_CONTAINER_AD"), new C28921(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new Delete().from(DownloadEpisode.class).where("isDeleted=1").execute();
        try {
            this.f11506r = getArguments().getBoolean("ARG_NEED_REMOVE", false);
        } catch (Exception e) {
            this.f11506r = false;
        }
        try {
            this.f11492d = getArguments().getString("ARG_ID");
            this.f11493e = getArguments().getString("ARG_SEASON");
            try {
                if (this.f11499k == null) {
                    this.f11499k = Integer.valueOf(this.f11493e);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            this.f11493e = "";
            this.f11492d = "";
        }
        m15992c();
    }

    /* renamed from: m */
    private void m15977m() {
        boolean z = true;
        try {
            if (this.f11500l.getIn_lib() == 1) {
                this.f11513y.setText(m15484h().getText(R.string.remove_to_lib));
            } else {
                this.f11513y.setText(m15484h().getText(R.string.add_to_lib));
            }
        } catch (Exception e) {
        }
        C2711f c2711f = this.f11514z;
        if (this.f11500l.getIn_lib() != 1) {
            z = false;
        }
        c2711f.m15360a(z);
    }

    /* renamed from: n */
    private void m15978n() {
        this.f11507s = new C3074a(m15484h());
        this.f11507s.m16642c(1);
        AnimationSet animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(400);
        animationSet.addAnimation(alphaAnimation);
        this.f11507s.m16632a(animationSet);
        this.f11507s.m16636a(new C2754b(this) {
            /* renamed from: a */
            final /* synthetic */ C2902j f11456a;

            /* compiled from: ShowsDetailsFragment */
            /* renamed from: com.tdo.showbox.b.j$11$1 */
            class C28871 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass11 f11453a;

                C28871(AnonymousClass11 anonymousClass11) {
                    this.f11453a = anonymousClass11;
                }

                public void run() {
                    try {
                        this.f11453a.f11456a.f11511w.setVisibility(0);
                    } catch (Exception e) {
                    }
                }
            }

            /* compiled from: ShowsDetailsFragment */
            /* renamed from: com.tdo.showbox.b.j$11$2 */
            class C28882 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass11 f11454a;

                C28882(AnonymousClass11 anonymousClass11) {
                    this.f11454a = anonymousClass11;
                }

                public void run() {
                    try {
                        this.f11454a.f11456a.f11511w.setVisibility(8);
                    } catch (Exception e) {
                    }
                }
            }

            /* compiled from: ShowsDetailsFragment */
            /* renamed from: com.tdo.showbox.b.j$11$3 */
            class C28893 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass11 f11455a;

                C28893(AnonymousClass11 anonymousClass11) {
                    this.f11455a = anonymousClass11;
                }

                public void run() {
                    try {
                        this.f11455a.f11456a.f11511w.setVisibility(8);
                        this.f11455a.f11456a.f11501m.setVisibility(8);
                    } catch (Exception e) {
                    }
                }
            }

            {
                this.f11456a = r1;
            }

            /* renamed from: b */
            public void mo2036b(String str) {
                this.f11456a.m15484h().runOnUiThread(new C28871(this));
            }

            /* renamed from: a */
            public void mo2035a(String str) {
                this.f11456a.m15484h().runOnUiThread(new C28882(this));
            }

            /* renamed from: c */
            public void mo2037c(String str) {
                this.f11456a.m15484h().runOnUiThread(new C28893(this));
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_shows_details, null);
        if (!m15484h().m15148L()) {
            this.f11488B = this.f11487A.m15285b(m15484h());
            this.f11488B.findViewById(R.id.filter_btn).setOnClickListener(this);
            this.f11513y = (TextView) this.f11488B.findViewById(R.id.btn_library);
            this.f11513y.setOnClickListener(this);
            this.f11488B.findViewById(R.id.btn_info).setOnClickListener(this);
        }
        this.f11504p = LayoutInflater.from(m15484h()).inflate(R.layout.shows_header, null);
        this.f11511w = this.f11504p.findViewById(R.id.load_progress);
        this.f11510v = this.f11504p.findViewById(R.id.seasson);
        this.f11509u = (TextView) this.f11504p.findViewById(R.id.txtv_season);
        this.f11508t = (TextView) this.f11504p.findViewById(R.id.txtv_genres);
        this.f11503o = (ExtListView) this.a.findViewById(R.id.ep_list_view);
        this.f11503o.addFooterView(m15979o());
        this.f11503o.addFooterView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
        this.f11494f = (TextView) this.f11504p.findViewById(R.id.txtv_episod_title);
        this.f11495g = (Spinner) this.f11504p.findViewById(R.id.seasons_spinner);
        this.f11501m = (ImageView) this.f11504p.findViewById(R.id.imgv_poster);
        m15978n();
        m15980p();
        this.f11510v.setOnClickListener(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ C2902j f11457a;

            {
                this.f11457a = r1;
            }

            public void onClick(View view) {
                this.f11457a.f11495g.performClick();
            }
        });
        try {
            this.f11500l = (TvItem) new Select().from(TvItem.class).where("item_id=" + this.f11492d).executeSingle();
        } catch (Exception e) {
        }
        if (this.f11500l == null) {
            C3167a.m16903a().m16924d();
            return this.a;
        }
        if (!m15964c(true)) {
            m15940a(this.f11499k.intValue());
        }
        if (this.f11506r) {
            m15484h().m15144H();
        }
        this.f11490D = new C3034d();
        this.f11490D.m16445a(getActivity(), m15484h().m15142F());
        return this.a;
    }

    /* renamed from: o */
    private View m15979o() {
        View frameLayout = new FrameLayout(m15484h());
        frameLayout.setLayoutParams(new LayoutParams(-1, -2));
        frameLayout.setTag("VIEW_TAG_CONTAINER_AD");
        return frameLayout;
    }

    /* renamed from: p */
    private void m15980p() {
        if (m15484h().m15148L()) {
            m15973k().m16429a(m15484h(), (UserInfo) new Select().from(UserInfo.class).executeSingle());
        }
    }

    public void onDestroy() {
        m15484h().m15137A().m16641c();
        if (m15484h().m15148L()) {
            m15973k().m16435d();
        }
        try {
            this.f11507s.m16639b();
        } catch (Exception e) {
        }
        try {
            this.f11503o.setAdapter(null);
        } catch (Exception e2) {
        }
        super.onDestroy();
    }

    /* renamed from: a */
    private boolean m15954a(TvItem tvItem) {
        if (!m15960b(tvItem) || !C3178f.m16973b(m15484h())) {
            return false;
        }
        new Delete().from(Season.class).where("movie_id=" + tvItem.getItemId()).execute();
        new Delete().from(Episod.class).where("mov_id=" + tvItem.getItemId()).execute();
        return true;
    }

    /* renamed from: b */
    private boolean m15960b(TvItem tvItem) {
        if (tvItem == null) {
            return true;
        }
        TvItemMeta tvItemMeta = TvItem.getTvItemMeta(tvItem);
        long last_cached_time = tvItemMeta.getLast_cached_time();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (last_cached_time + 3600000 >= timeInMillis) {
            return false;
        }
        tvItemMeta.setLast_cached_time(timeInMillis);
        tvItemMeta.save();
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f11497i = new C3221h(m15484h(), this.f11498j);
        m15981q();
        this.f11503o.setAdapter(null);
        this.f11503o.setAdapter(this.f11497i);
        this.f11497i.m17041a((C2771a) this);
        m15985u();
        this.f11512x = false;
    }

    /* renamed from: q */
    private void m15981q() {
        try {
            if (m15484h().getResources().getConfiguration().orientation == 2) {
                this.f11497i.m17040a(m15484h().getResources().getInteger(R.integer.grid_colum_land_shows_episode));
            } else {
                this.f11497i.m17040a(m15484h().getResources().getInteger(R.integer.grid_colum_portret_shows_episode));
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    private boolean m15964c(boolean z) {
        int i = 0;
        if (this.f11500l == null) {
            return false;
        }
        SeasonLastViewItem a = C3093i.m16696a(this.f11492d);
        if (a != null) {
            this.f11500l.setSeasonslist(a.getSeason_list());
        }
        if (z && m15954a(this.f11500l)) {
            return false;
        }
        if (this.f11499k.intValue() == -1) {
            return false;
        }
        if (this.f11500l.getSeasonslist() == null || this.f11500l.getSeasonslist().length() == 0) {
            return false;
        }
        C3065b.m16568a("tv_details");
        this.f11502n = (Season) new Select().from(Season.class).where("movie_id=" + this.f11492d + " AND num=" + this.f11499k).executeSingle();
        if (this.f11502n == null) {
            return false;
        }
        C3093i.m16697a(this.f11500l, this.f11499k.intValue(), this.f11500l.getSeasonslist());
        this.f11500l.setLast_vieved_season(this.f11499k.intValue());
        this.f11500l.save();
        this.f11500l.setImdb_id(TvItem.getTvItemMeta(this.f11500l).getImdb_id());
        this.f11500l.save();
        this.f11494f.setText(this.f11500l.getTitle());
        String banner = this.f11502n.getBanner();
        if (banner == null) {
            banner = "";
        }
        if (banner.equals("")) {
            this.f11501m.setVisibility(8);
        } else {
            this.f11507s.m16635a(this.f11501m, banner);
        }
        m15982r();
        this.f11498j = new Select().from(Episod.class).where("season_num=" + this.f11499k + " AND mov_id=" + this.f11492d).orderBy("Id DESC").execute();
        if (this.f11498j != null) {
            if (this.f11497i != null) {
                this.f11503o.removeHeaderView(this.f11504p);
                this.f11503o.setAdapter(null);
                this.f11497i = null;
            }
            this.f11497i = new C3221h(m15484h(), this.f11498j);
            this.f11503o.addHeaderView(this.f11504p);
            m15981q();
            m15985u();
            this.f11497i.m17041a((C2771a) this);
            this.f11503o.setAdapter(this.f11497i);
        }
        try {
            String[] split = this.f11500l.getCats().split("#");
            if (split.length == 0) {
                throw new Exception();
            }
            CharSequence charSequence = "";
            while (i < split.length) {
                banner = charSequence + ((Category) new Select().from(Category.class).where("cat_id=" + split[i]).executeSingle()).getName();
                if (i != split.length - 1) {
                    banner = banner + ", ";
                }
                i++;
                Object obj = banner;
            }
            this.f11508t.setText(charSequence);
            m15977m();
            return true;
        } catch (Exception e) {
            this.f11508t.setVisibility(8);
        }
    }

    /* renamed from: r */
    private void m15982r() {
        int i = 0;
        this.f11505q = false;
        final String[] split = this.f11500l.getSeasonslist().split(";");
        Arrays.sort(split, new Comparator<String>(this) {
            /* renamed from: a */
            final /* synthetic */ C2902j f11458a;

            {
                this.f11458a = r1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return m15928a((String) obj, (String) obj2);
            }

            /* renamed from: a */
            public int m15928a(String str, String str2) {
                return Integer.valueOf(str).compareTo(Integer.valueOf(str2));
            }
        });
        List arrayList = new ArrayList();
        for (String str : split) {
            arrayList.add(m15484h().getString(R.string.season) + " " + str);
        }
        SpinnerAdapter arrayAdapter = new ArrayAdapter(m15484h(), 17367048, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.item_sort);
        this.f11495g.setAdapter(arrayAdapter);
        this.f11495g.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            /* renamed from: b */
            final /* synthetic */ C2902j f11460b;

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.f11460b.f11505q) {
                    int intValue = Integer.valueOf(split[i]).intValue();
                    if (this.f11460b.f11499k.intValue() != intValue) {
                        this.f11460b.m15940a(intValue);
                        this.f11460b.f11509u.setText(this.f11460b.m15484h().getString(R.string.season) + " " + intValue);
                        return;
                    }
                    return;
                }
                this.f11460b.f11505q = true;
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        while (i < split.length) {
            try {
                if (this.f11499k == Integer.valueOf(split[i])) {
                    this.f11495g.setSelection(i);
                    break;
                }
                i++;
            } catch (Exception e) {
            }
        }
        this.f11509u.setText(m15484h().getString(R.string.season) + " " + this.f11499k);
    }

    /* renamed from: a */
    private void m15940a(int i) {
        this.f11499k = Integer.valueOf(i);
        this.f11502n = (Season) new Select().from(Season.class).where("movie_id=" + this.f11492d + " AND num=" + this.f11499k).executeSingle();
        if (this.f11502n != null) {
            m15964c(false);
        } else if (C3178f.m16973b(m15484h())) {
            m15952a(m15484h().getString(R.string.loading_seasons));
            m15484h().m15142F().m16333a(this.f11492d, "" + i, new AsyncHttpResponseHandler(this) {
                /* renamed from: a */
                final /* synthetic */ C2902j f11464a;

                {
                    this.f11464a = r1;
                }

                public void onSuccess(int i, final String str) {
                    C3094j.m16698a("getEpisodes", "" + str);
                    new Thread(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ AnonymousClass15 f11463b;

                        /* compiled from: ShowsDetailsFragment */
                        /* renamed from: com.tdo.showbox.b.j$15$1$1 */
                        class C28901 implements Runnable {
                            /* renamed from: a */
                            final /* synthetic */ C28911 f11461a;

                            C28901(C28911 c28911) {
                                this.f11461a = c28911;
                            }

                            public void run() {
                                this.f11461a.f11463b.f11464a.m15964c(false);
                                this.f11461a.f11463b.f11464a.m15984t();
                            }
                        }

                        public void run() {
                            EpisodeResponse b = ObjParser.m16279b(str);
                            this.f11463b.f11464a.f11500l.setCats(b.getCats());
                            this.f11463b.f11464a.f11500l.setImdb_id(b.getImdb_id());
                            this.f11463b.f11464a.f11499k = Integer.valueOf(b.getSeason());
                            if (this.f11463b.f11464a.f11499k.intValue() <= 0) {
                                this.f11463b.f11464a.f11499k = Integer.valueOf(1);
                                b.setSeason(this.f11463b.f11464a.f11499k.intValue());
                            }
                            this.f11463b.f11464a.m15950a(b);
                            this.f11463b.f11464a.f11500l.setSeasonslist(b.getSeasons());
                            this.f11463b.f11464a.f11500l.save();
                            C3093i.m16697a(this.f11463b.f11464a.f11500l, this.f11463b.f11464a.f11499k.intValue(), this.f11463b.f11464a.f11500l.getSeasonslist());
                            TvItemMeta tvItemMeta = TvItem.getTvItemMeta(this.f11463b.f11464a.f11500l);
                            tvItemMeta.setImdb_id(b.getImdb_id());
                            tvItemMeta.save();
                            this.f11463b.f11464a.m15484h().runOnUiThread(new C28901(this));
                        }
                    }).start();
                }

                public void onFailure(Throwable th) {
                    this.f11464a.m15984t();
                }
            });
        } else {
            Toast.makeText(m15484h(), m15484h().getString(R.string.error_connection), 0).show();
        }
    }

    /* renamed from: a */
    private void m15950a(EpisodeResponse episodeResponse) {
        Season season = new Season();
        season.setBanner(episodeResponse.getBanner());
        season.setDescription(episodeResponse.getDescription());
        season.setNum("" + episodeResponse.getSeason());
        season.setMovieId(this.f11492d);
        for (Episod episod : episodeResponse.getEpisodes()) {
            episod.setSeasonNum((long) episodeResponse.getSeason());
            String epizode_title = episod.getEpizode_title();
            String str = "" + episod.getEpisode_id();
            if (epizode_title == null) {
                epizode_title = "";
                episod.setEpizode_title("");
            }
            episod.setTitle(m15484h().getString(R.string.episode) + " " + str);
            if (!epizode_title.equals("")) {
                episod.setEpizode_title(epizode_title);
            }
            try {
                episod.setMovId(Long.valueOf(this.f11492d).longValue());
            } catch (Exception e) {
            }
            episod.save();
        }
        season.save();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_info:
                m15993j();
                return;
            case R.id.btn_library:
                mo2069a();
                return;
            case R.id.filter_btn:
                mo2070b();
                return;
            default:
                return;
        }
    }

    /* renamed from: s */
    private void m15983s() {
        if (this.f11502n != null) {
            final Dialog dialog = new Dialog(m15484h(), R.style.custom_dialog);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.dialog_show_info);
            Window window = dialog.getWindow();
            window.setBackgroundDrawableResource(17170445);
            window.getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            ((TextView) dialog.findViewById(R.id.descr_view)).setText(this.f11502n.getDescription());
            dialog.findViewById(R.id.btn_close).setOnClickListener(new OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C2902j f11466b;

                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    }

    /* renamed from: a */
    private void m15952a(String str) {
        try {
            if (this.f11496h == null) {
                this.f11496h = ProgressDialog.show(m15484h(), "", str);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: t */
    private void m15984t() {
        try {
            if (this.f11496h != null) {
                this.f11496h.dismiss();
                this.f11496h = null;
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void mo2052a(View view, int i, Object obj) {
        m15477a(false);
        final Episod episod = (Episod) this.f11498j.get(i);
        DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_num=" + episod.getEpisode_id() + " AND percent=100 AND season_num=" + this.f11499k + " AND title=" + DatabaseUtils.sqlEscapeString(this.f11500l.getTitle())).executeSingle();
        if (downloadEpisode != null) {
            m15948a(episod, downloadEpisode);
        } else if (!m15484h().m15095l()) {
            if (C3178f.m16973b(m15484h())) {
                m15952a(m15484h().getString(R.string.loading_episode));
                m15484h().m15142F().m16334a("" + episod.getMovId(), "" + this.f11499k, "" + episod.getEpisode_id(), new AsyncHttpResponseHandler(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2902j f11468b;

                    public void onSuccess(int i, String str) {
                        super.onSuccess(i, str);
                        C3094j.m16698a("Shows details load epizode ", str);
                        this.f11468b.m15949a(episod, str);
                    }

                    public void onFailure(Throwable th, String str) {
                        super.onFailure(th, str);
                        this.f11468b.m15984t();
                        this.f11468b.m15986v();
                    }
                });
                return;
            }
            Toast.makeText(m15484h(), m15484h().getString(R.string.error_connection), 0).show();
        }
    }

    /* renamed from: a */
    private void m15949a(final Episod episod, final String str) {
        new Thread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C2902j f11471c;

            public void run() {
                ObjParser.m16274a(this.f11471c.m15484h(), str, episod, this.f11471c.f11499k.intValue());
                this.f11471c.m15947a(episod);
            }
        }).start();
    }

    /* renamed from: a */
    private void m15947a(final Episod episod) {
        new C3141b(m15484h().getApplicationContext()).m16882a(episod, new C2760a(this) {
            /* renamed from: b */
            final /* synthetic */ C2902j f11475b;

            /* compiled from: ShowsDetailsFragment */
            /* renamed from: com.tdo.showbox.b.j$2$1 */
            class C28931 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C28942 f11473a;

                C28931(C28942 c28942) {
                    this.f11473a = c28942;
                }

                public void run() {
                    this.f11473a.f11475b.m15984t();
                    this.f11473a.f11475b.m15957b(episod);
                }
            }

            /* renamed from: a */
            public void mo2046a(List<BaseVideoSource> list) {
                episod.setSourceList(list);
                Activity activity = this.f11475b.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new C28931(this));
                }
            }

            /* renamed from: a */
            public void mo2045a(String str) {
                this.f11475b.m15951a(this.f11475b.f11500l, this.f11475b.f11499k.intValue(), episod, str);
            }
        });
    }

    /* renamed from: a */
    private void m15951a(TvItem tvItem, int i, Episod episod, String str) {
        C3094j.m16698a("ShowsDetailsFragment", "markBrokenTorrent: name: " + tvItem.getTitle() + " hd: " + str + " epizode title: " + episod.getTitle() + " season: " + i);
        m15484h().m15142F().m16336a(tvItem.getItemId(), "tv", str, "" + i, "" + episod.getEpisode_id(), new C28953(this));
    }

    /* renamed from: b */
    private void m15957b(final Episod episod) {
        if (this.f11490D.m16448a(new C2814a(this) {
            /* renamed from: b */
            final /* synthetic */ C2902j f11478b;

            /* renamed from: a */
            public void mo2067a() {
                this.f11478b.m15984t();
                this.f11478b.m15963c(episod);
            }
        })) {
            m15963c(episod);
        } else {
            m15952a(getActivity().getString(R.string.alert_wait));
        }
    }

    /* renamed from: c */
    private void m15963c(Episod episod) {
        try {
            C3303a c3303a = new C3303a(m15484h(), episod, this.f11500l, this.f11499k.intValue(), this.f11490D);
            c3303a.m17443a(new C28975(this));
            if (m15484h().m15148L()) {
                c3303a.m17440a(this.a.getMeasuredWidth());
            }
            c3303a.m17444b((DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_num=" + episod.getEpisode_id() + " AND percent<100 AND season_num=" + this.f11499k + " AND title=" + DatabaseUtils.sqlEscapeString(this.f11500l.getTitle())).executeSingle());
            c3303a.show();
        } catch (Exception e) {
            e.printStackTrace();
            m15484h().m15094k();
        }
    }

    public void onResume() {
        super.onResume();
        if (m15484h().m15148L()) {
            m15973k().m16436e();
            m15973k().m16431a(new C28986(this));
        }
        if (this.f11500l != null && this.f11500l.getId() != null) {
            TvItem tvItem = (TvItem) new Select().from(TvItem.class).where("Id=" + this.f11500l.getId()).executeSingle();
            if (tvItem != null) {
                this.f11500l.setIn_lib(tvItem.getIn_lib());
                m15977m();
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (m15484h().m15148L()) {
            m15973k().m16437f();
        }
    }

    /* renamed from: a */
    private void m15948a(final Episod episod, final DownloadEpisode downloadEpisode) {
        if (this.f11490D.m16448a(new C2814a(this) {
            /* renamed from: c */
            final /* synthetic */ C2902j f11483c;

            /* renamed from: a */
            public void mo2067a() {
                this.f11483c.m15984t();
                this.f11483c.m15958b(episod, downloadEpisode);
            }
        })) {
            m15958b(episod, downloadEpisode);
        } else {
            m15952a(getActivity().getString(R.string.alert_wait));
        }
    }

    /* renamed from: b */
    private void m15958b(Episod episod, DownloadEpisode downloadEpisode) {
        C3303a c3303a = new C3303a(m15484h(), episod, this.f11500l, this.f11499k.intValue(), this.f11490D);
        c3303a.m17443a(new C29008(this));
        if (m15484h().m15148L()) {
            c3303a.m17440a(this.a.getMeasuredWidth());
        }
        c3303a.m17441a(downloadEpisode);
        c3303a.show();
    }

    /* renamed from: u */
    private void m15985u() {
        if (getActivity() != null && !m15484h().getResources().getBoolean(R.bool.portrait_only) && !C3088f.m16682b("PREF_SCROLL_SHOWED") && !this.f11512x && m15484h().getResources().getConfiguration().orientation == 2) {
            Intent intent = new Intent(m15484h(), ScrollHintActivity.class);
            this.f11512x = true;
            startActivityForResult(intent, 9845);
        }
    }

    /* renamed from: d */
    private void m15966d(final Episod episod) {
        m15952a(m15484h().getString(R.string.loading_episode));
        m15484h().m15142F().m16334a("" + episod.getMovId(), "" + this.f11499k, "" + episod.getEpisode_id(), new AsyncHttpResponseHandler(this) {
            /* renamed from: b */
            final /* synthetic */ C2902j f11486b;

            public void onSuccess(int i, String str) {
                super.onSuccess(i, str);
                this.f11486b.m15949a(episod, str);
            }

            public void onFailure(Throwable th, String str) {
                super.onFailure(th, str);
                this.f11486b.m15984t();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9845) {
            this.f11512x = false;
        }
        if (intent != null) {
            if (i == 123) {
                if (this.f11497i != null) {
                    this.f11497i.m17118c();
                }
                try {
                    long longExtra = intent.getLongExtra("ARG_URL_FAIL_ID", -1);
                    Episod episod;
                    if (longExtra != -1) {
                        for (Episod episod2 : this.f11498j) {
                            if (episod2.getId().longValue() == longExtra) {
                                m15966d(episod2);
                            }
                        }
                        return;
                    }
                    int intExtra = intent.getIntExtra("ARG_VIDEO_POSITION", 0);
                    long longExtra2 = intent.getLongExtra("ARG_ID", 0);
                    int intExtra2 = intent.getIntExtra("ARG_VIDEO_PART_NUMBER", 0);
                    episod2 = (Episod) new Select().from(Episod.class).where("ID=" + longExtra2).executeSingle();
                    episod2.setMovieProgress((long) intExtra);
                    episod2.setPart_progress((long) intExtra);
                    episod2.setPart_last_number(intExtra2);
                    episod2.save();
                    for (Episod episod3 : this.f11498j) {
                        if (episod3.getId().longValue() == longExtra2) {
                            episod3.setMovieProgress((long) intExtra);
                            episod3.setPart_progress((long) intExtra);
                            episod3.setPart_last_number(intExtra2);
                        }
                    }
                    DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + episod2.getDownloadID() + " AND is_movie=0").executeSingle();
                    if (downloadEpisode != null) {
                        downloadEpisode.setView_position((long) intExtra);
                        downloadEpisode.setPart_progress((long) intExtra);
                        downloadEpisode.setPart_last_number(intExtra2);
                        downloadEpisode.save();
                    }
                } catch (Exception e) {
                }
            }
        } else if (i == 1113 && this.f11497i != null) {
            this.f11497i.m17118c();
        }
    }

    /* renamed from: v */
    private void m15986v() {
        Builder builder = new Builder(m15484h());
        builder.setPositiveButton(m15484h().getString(R.string.close), new DialogInterface.OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ C2902j f11452a;

            {
                this.f11452a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                C3167a.m16903a().m16924d();
            }
        });
        builder.setMessage(m15484h().getString(R.string.error_server));
        builder.show();
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        return m15992c();
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return this.f11487A;
    }

    /* renamed from: c */
    public C2668a m15992c() {
        if (this.f11514z == null) {
            this.f11514z = new C2711f();
            this.f11514z.m15358a((C2709a) this);
            this.f11514z.m15359a((C2710b) this);
        }
        return this.f11514z;
    }

    /* renamed from: a */
    public void mo2069a() {
        MainActivity h;
        if (this.f11506r) {
            this.f11500l.setIn_lib(0);
            TvItemMeta tvItemMeta = TvItem.getTvItemMeta(this.f11500l);
            tvItemMeta.setRemoved_from_lib(1);
            tvItemMeta.save();
            this.f11500l.save();
            h = m15484h();
            if (h != null) {
                h.m15168o().m16846b(this.f11500l);
            }
            Toast.makeText(m15484h(), m15484h().getString(R.string.alert_removed_from_lib), 0).show();
            C3065b.m16569a("favorite_removed", IjkMediaMeta.IJKM_KEY_TYPE, "tv");
            C3167a.m16903a().m16924d();
            m15484h().m15149M();
            return;
        }
        if (this.f11500l.getIn_lib() == 0) {
            this.f11500l.setIn_lib(1);
            this.f11500l.save();
            Toast.makeText(m15484h(), m15484h().getString(R.string.alert_added_to_lib), 0).show();
            C3065b.m16569a("favorite_added", IjkMediaMeta.IJKM_KEY_TYPE, "tv");
            h = m15484h();
            if (h != null) {
                h.m15168o().m16845a(this.f11500l);
            }
            m15484h().m15144H();
        } else {
            tvItemMeta = TvItem.getTvItemMeta(this.f11500l);
            tvItemMeta.setRemoved_from_lib(1);
            tvItemMeta.save();
            this.f11500l.setIn_lib(0);
            this.f11500l.save();
            Toast.makeText(m15484h(), m15484h().getString(R.string.alert_removed_from_lib), 0).show();
            C3065b.m16569a("favorite_removed", IjkMediaMeta.IJKM_KEY_TYPE, "tv");
            h = m15484h();
            if (h != null) {
                h.m15168o().m16846b(this.f11500l);
            }
        }
        m15977m();
    }

    /* renamed from: j */
    public void m15993j() {
        m15983s();
    }

    /* renamed from: b */
    public void mo2070b() {
        C3184j.m16981a(m15484h(), "", m15484h().getString(R.string.share_perf) + " '" + this.f11500l.getTitle() + "' " + getString(R.string.share_suf) + " " + m15484h().m15142F().f11831c);
        C3065b.m16569a("share", IjkMediaMeta.IJKM_KEY_TYPE, "tv");
    }
}
