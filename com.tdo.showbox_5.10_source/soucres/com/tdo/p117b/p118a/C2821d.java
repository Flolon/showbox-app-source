package com.tdo.showbox.p117b.p118a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.AbsListView;
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
import com.tdo.showbox.b.a.d.AnonymousClass11;
import com.tdo.showbox.b.a.d.AnonymousClass13;
import com.tdo.showbox.b.a.d.AnonymousClass16;
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
import com.tdo.showbox.p117b.C2769a;
import com.tdo.showbox.p117b.p118a.C2821d;
import com.tdo.showbox.p117b.p118a.C2821d.11.C28031;
import com.tdo.showbox.p117b.p118a.C2821d.11.C28042;
import com.tdo.showbox.p117b.p118a.C2821d.11.C28053;
import com.tdo.showbox.p117b.p118a.C2821d.13.C28061;
import com.tdo.showbox.p121g.C3204b.C2771a;
import com.tdo.showbox.p121g.C3221h;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3174c;
import com.tdo.showbox.p131f.C3178f;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.views.C3303a;
import com.tdo.showbox.views.C3303a.C2816a;
import com.tdo.showbox.views.ExtListView;
import com.tdo.showbox.views.ExtListView.C2746a;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: ShowsPhoneDetailsFragment */
/* renamed from: com.tdo.showbox.b.a.d */
public class C2821d extends C2769a implements OnClickListener, C2709a, C2710b, C2771a {
    /* renamed from: A */
    private C2711f f11262A;
    /* renamed from: B */
    private C2675c f11263B = new C2675c();
    /* renamed from: C */
    private View f11264C;
    /* renamed from: D */
    private ImageView f11265D;
    /* renamed from: E */
    private C3031c f11266E;
    /* renamed from: F */
    private Bitmap f11267F;
    /* renamed from: G */
    private C3034d f11268G;
    /* renamed from: c */
    private final String f11269c = "VIEW_TAG_CONTAINER_AD";
    /* renamed from: d */
    private String f11270d;
    /* renamed from: e */
    private String f11271e;
    /* renamed from: f */
    private TextView f11272f;
    /* renamed from: g */
    private Spinner f11273g;
    /* renamed from: h */
    private Dialog f11274h;
    /* renamed from: i */
    private C3221h f11275i;
    /* renamed from: j */
    private List<Episod> f11276j;
    /* renamed from: k */
    private Integer f11277k;
    /* renamed from: l */
    private TvItem f11278l;
    /* renamed from: m */
    private ImageView f11279m;
    /* renamed from: n */
    private Season f11280n;
    /* renamed from: o */
    private ExtListView f11281o;
    /* renamed from: p */
    private View f11282p;
    /* renamed from: q */
    private boolean f11283q;
    /* renamed from: r */
    private boolean f11284r;
    /* renamed from: s */
    private C3074a f11285s;
    /* renamed from: t */
    private TextView f11286t;
    /* renamed from: u */
    private TextView f11287u;
    /* renamed from: v */
    private View f11288v;
    /* renamed from: w */
    private TextView f11289w;
    /* renamed from: x */
    private View f11290x;
    /* renamed from: y */
    private boolean f11291y;
    /* renamed from: z */
    private TextView f11292z;

    /* compiled from: ShowsPhoneDetailsFragment */
    /* renamed from: com.tdo.showbox.b.a.d$1 */
    class C28091 implements C2746a {
        /* renamed from: a */
        final /* synthetic */ C2821d f11245a;

        /* compiled from: ShowsPhoneDetailsFragment */
        /* renamed from: com.tdo.showbox.b.a.d$1$1 */
        class C28021 implements C2747a {
            /* renamed from: a */
            final /* synthetic */ C28091 f11224a;

            C28021(C28091 c28091) {
                this.f11224a = c28091;
            }

            /* renamed from: a */
            public void mo2032a() {
                if (this.f11224a.f11245a.f11281o != null) {
                    View findViewWithTag = this.f11224a.f11245a.f11281o.findViewWithTag("VIEW_TAG_CONTAINER_AD");
                    if (findViewWithTag != null && this.f11224a.f11245a.m15762k().m16433b() != null) {
                        if (findViewWithTag instanceof ViewGroup) {
                            ((ViewGroup) findViewWithTag).removeAllViews();
                            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                            layoutParams.topMargin = this.f11224a.f11245a.m15484h().getResources().getDimensionPixelOffset(R.dimen.dimen_25);
                            ((ViewGroup) findViewWithTag).addView(this.f11224a.f11245a.m15762k().m16433b(), layoutParams);
                            return;
                        }
                        throw new RuntimeException("expected ViewGroup as 'ad container'");
                    }
                }
            }
        }

        C28091(C2821d c2821d) {
            this.f11245a = c2821d;
        }

        /* renamed from: a */
        public void mo2031a() {
            this.f11245a.f11281o.m17205a();
            if (this.f11245a.m15484h().m15148L()) {
                this.f11245a.m15762k().m16436e();
                this.f11245a.m15762k().m16431a(new C28021(this));
            }
            this.f11245a.m15762k().m16438g();
        }
    }

    /* compiled from: ShowsPhoneDetailsFragment */
    /* renamed from: com.tdo.showbox.b.a.d$4 */
    class C28134 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C2821d f11252a;

        C28134(C2821d c2821d) {
            this.f11252a = c2821d;
        }

        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
        }
    }

    /* compiled from: ShowsPhoneDetailsFragment */
    /* renamed from: com.tdo.showbox.b.a.d$6 */
    class C28176 implements C2816a {
        /* renamed from: a */
        final /* synthetic */ C2821d f11255a;

        C28176(C2821d c2821d) {
            this.f11255a = c2821d;
        }

        /* renamed from: a */
        public void mo2068a(DownloadEpisode downloadEpisode) {
            this.f11255a.m15484h().m15154a(downloadEpisode);
            Toast.makeText(this.f11255a.m15484h(), this.f11255a.m15484h().getString(R.string.video_added_toast), 0).show();
            this.f11255a.m15484h().mo2004b().m16490b("episode_details__");
        }
    }

    /* compiled from: ShowsPhoneDetailsFragment */
    /* renamed from: com.tdo.showbox.b.a.d$8 */
    class C28198 implements C2816a {
        /* renamed from: a */
        final /* synthetic */ C2821d f11259a;

        C28198(C2821d c2821d) {
            this.f11259a = c2821d;
        }

        /* renamed from: a */
        public void mo2068a(DownloadEpisode downloadEpisode) {
            this.f11259a.m15484h().m15154a(downloadEpisode);
            Toast.makeText(this.f11259a.m15484h(), this.f11259a.m15484h().getString(R.string.video_added_toast), 0).show();
            this.f11259a.m15484h().mo2004b().m16490b("episode_details__");
        }
    }

    /* renamed from: a */
    public static C2821d m15726a(String str, String str2, boolean z) {
        C2821d c2821d = new C2821d();
        Bundle bundle = new Bundle();
        SeasonLastViewItem a = C3093i.m16696a(str2);
        if (a == null) {
            bundle.putString("ARG_SEASON", "" + str);
        } else {
            bundle.putString("ARG_SEASON", "" + a.getLast_season());
        }
        bundle.putString("ARG_ID", str2);
        bundle.putBoolean("ARG_NEED_REMOVE", z);
        c2821d.setArguments(bundle);
        c2821d.m15479b(true);
        return c2821d;
    }

    /* renamed from: k */
    private C3031c m15762k() {
        if (this.f11266E == null) {
            this.f11266E = new C3031c("native_shows_details");
        }
        return this.f11266E;
    }

    /* renamed from: l */
    private void m15765l() {
        this.f11281o.m17207a(this.f11281o.findViewWithTag("VIEW_TAG_CONTAINER_AD"), true, new C28091(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new Delete().from(DownloadEpisode.class).where("isDeleted=1").execute();
        try {
            this.f11284r = getArguments().getBoolean("ARG_NEED_REMOVE", false);
        } catch (Exception e) {
            this.f11284r = false;
        }
        try {
            this.f11270d = getArguments().getString("ARG_ID");
            this.f11271e = getArguments().getString("ARG_SEASON");
            try {
                if (this.f11277k == null) {
                    this.f11277k = Integer.valueOf(this.f11271e);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            this.f11271e = "";
            this.f11270d = "";
        }
        m15797c();
    }

    /* renamed from: m */
    private void m15767m() {
        boolean z = true;
        try {
            if (this.f11278l.getIn_lib() == 1) {
                this.f11292z.setText(m15484h().getText(R.string.remove_to_lib));
            } else {
                this.f11292z.setText(m15484h().getText(R.string.add_to_lib));
            }
        } catch (Exception e) {
        }
        C2711f c2711f = this.f11262A;
        if (this.f11278l.getIn_lib() != 1) {
            z = false;
        }
        c2711f.m15360a(z);
    }

    /* renamed from: n */
    private void m15769n() {
        this.f11285s = new C3074a(m15484h());
        this.f11285s.m16642c(1);
        AnimationSet animationSet = new AnimationSet(true);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(400);
        animationSet.addAnimation(alphaAnimation);
        this.f11285s.m16632a(animationSet);
        this.f11285s.m16636a(new C2754b(this) {
            /* renamed from: a */
            final /* synthetic */ C2821d f11229a;

            /* compiled from: ShowsPhoneDetailsFragment */
            /* renamed from: com.tdo.showbox.b.a.d$11$1 */
            class C28031 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass11 f11226a;

                C28031(AnonymousClass11 anonymousClass11) {
                    this.f11226a = anonymousClass11;
                }

                public void run() {
                    try {
                        this.f11226a.f11229a.f11290x.setVisibility(0);
                    } catch (Exception e) {
                    }
                }
            }

            /* compiled from: ShowsPhoneDetailsFragment */
            /* renamed from: com.tdo.showbox.b.a.d$11$2 */
            class C28042 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass11 f11227a;

                C28042(AnonymousClass11 anonymousClass11) {
                    this.f11227a = anonymousClass11;
                }

                public void run() {
                    try {
                        this.f11227a.f11229a.f11290x.setVisibility(8);
                    } catch (Exception e) {
                    }
                }
            }

            /* compiled from: ShowsPhoneDetailsFragment */
            /* renamed from: com.tdo.showbox.b.a.d$11$3 */
            class C28053 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass11 f11228a;

                C28053(AnonymousClass11 anonymousClass11) {
                    this.f11228a = anonymousClass11;
                }

                public void run() {
                    try {
                        this.f11228a.f11229a.f11290x.setVisibility(8);
                        this.f11228a.f11229a.f11279m.setVisibility(8);
                    } catch (Exception e) {
                    }
                }
            }

            {
                this.f11229a = r1;
            }

            /* renamed from: b */
            public void mo2036b(String str) {
                this.f11229a.m15484h().runOnUiThread(new C28031(this));
            }

            /* renamed from: a */
            public void mo2035a(String str) {
                this.f11229a.m15484h().runOnUiThread(new C28042(this));
            }

            /* renamed from: c */
            public void mo2037c(String str) {
                this.f11229a.m15484h().runOnUiThread(new C28053(this));
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.frgm_shows_details, null);
        if (!m15484h().m15148L()) {
            this.f11264C = this.f11263B.m15285b(m15484h());
            this.f11264C.findViewById(R.id.filter_btn).setOnClickListener(this);
            this.f11292z = (TextView) this.f11264C.findViewById(R.id.btn_library);
            this.f11292z.setOnClickListener(this);
            this.f11264C.findViewById(R.id.btn_info).setOnClickListener(this);
        }
        this.f11265D = (ImageView) this.a.findViewById(R.id.imgv_background);
        this.f11282p = LayoutInflater.from(m15484h()).inflate(R.layout.shows_header, null);
        this.f11290x = this.f11282p.findViewById(R.id.load_progress);
        this.f11288v = this.f11282p.findViewById(R.id.seasson);
        this.f11287u = (TextView) this.f11282p.findViewById(R.id.seasson);
        this.f11286t = (TextView) this.f11282p.findViewById(R.id.category_view);
        this.f11289w = (TextView) this.f11282p.findViewById(R.id.description_view);
        this.f11281o = (ExtListView) this.a.findViewById(R.id.ep_list_view);
        this.f11281o.addFooterView(m15774q());
        this.f11281o.addFooterView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
        this.f11272f = (TextView) this.f11282p.findViewById(R.id.name_view);
        this.f11273g = (Spinner) this.f11282p.findViewById(R.id.seasons_spinner);
        this.f11279m = (ImageView) this.f11282p.findViewById(R.id.imgv_poster);
        m15769n();
        m15777r();
        this.f11288v.setOnClickListener(new OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ C2821d f11230a;

            {
                this.f11230a = r1;
            }

            public void onClick(View view) {
                this.f11230a.f11273g.performClick();
            }
        });
        try {
            this.f11278l = (TvItem) new Select().from(TvItem.class).where("item_id=" + this.f11270d).executeSingle();
        } catch (Exception e) {
        }
        if (this.f11278l == null) {
            C3167a.m16903a().m16924d();
            return this.a;
        }
        if (!m15745a(true, true)) {
            m15729a(this.f11277k.intValue(), false);
        }
        if (this.f11284r) {
            m15484h().m15144H();
        }
        this.f11268G = new C3034d();
        this.f11268G.m16445a(getActivity(), m15484h().m15142F());
        return this.a;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m15770o();
    }

    /* renamed from: o */
    private void m15770o() {
        try {
            String a = m15484h().m15139C().m16629a(this.f11278l.getPoster());
            if (a != null) {
                this.f11267F = C3174c.m16959a(BitmapFactory.decodeFile(a), 60);
                this.f11265D.setImageBitmap(this.f11267F);
            } else if (C3178f.m16973b(m15484h())) {
                m15773p();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
        } catch (Exception e2) {
        }
    }

    /* renamed from: p */
    private void m15773p() {
        new Thread(new Runnable(this) {
            /* renamed from: a */
            final /* synthetic */ C2821d f11232a;

            /* compiled from: ShowsPhoneDetailsFragment */
            /* renamed from: com.tdo.showbox.b.a.d$13$1 */
            class C28061 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass13 f11231a;

                C28061(AnonymousClass13 anonymousClass13) {
                    this.f11231a = anonymousClass13;
                }

                public void run() {
                    this.f11231a.f11232a.f11265D.setImageBitmap(this.f11231a.f11232a.f11267F);
                }
            }

            {
                this.f11232a = r1;
            }

            public void run() {
                try {
                    this.f11232a.f11267F = C3174c.m16959a(BitmapFactory.decodeStream(new URL(this.f11232a.f11278l.getPoster()).openStream()), 60);
                    this.f11232a.m15484h().runOnUiThread(new C28061(this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /* renamed from: q */
    private View m15774q() {
        View frameLayout = new FrameLayout(m15484h());
        frameLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        frameLayout.setTag("VIEW_TAG_CONTAINER_AD");
        frameLayout.setMinimumHeight(5);
        return frameLayout;
    }

    /* renamed from: r */
    private void m15777r() {
        if (m15484h().m15148L()) {
            m15762k().m16429a(m15484h(), (UserInfo) new Select().from(UserInfo.class).executeSingle());
        }
    }

    public void onDestroy() {
        m15484h().m15137A().m16641c();
        if (m15484h().m15148L()) {
            m15762k().m16435d();
        }
        try {
            this.f11285s.m16639b();
        } catch (Exception e) {
        }
        try {
            this.f11281o.setAdapter(null);
        } catch (Exception e2) {
        }
        try {
            C3184j.m16985a(this.f11265D, false);
            this.f11267F.recycle();
            this.f11267F = null;
        } catch (Exception e3) {
        }
        super.onDestroy();
    }

    /* renamed from: a */
    private boolean m15744a(TvItem tvItem) {
        if (!m15750b(tvItem) || !C3178f.m16973b(m15484h())) {
            return false;
        }
        new Delete().from(Season.class).where("movie_id=" + tvItem.getItemId()).execute();
        new Delete().from(Episod.class).where("mov_id=" + tvItem.getItemId()).execute();
        return true;
    }

    /* renamed from: b */
    private boolean m15750b(TvItem tvItem) {
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
        this.f11275i = new C3221h(m15484h(), this.f11276j);
        m15778s();
        this.f11281o.setAdapter(null);
        this.f11281o.setAdapter(this.f11275i);
        this.f11275i.m17041a((C2771a) this);
        m15787w();
        this.f11291y = false;
    }

    /* renamed from: s */
    private void m15778s() {
        try {
            if (m15484h().getResources().getConfiguration().orientation == 2) {
                this.f11275i.m17040a(m15484h().getResources().getInteger(R.integer.grid_colum_land_shows_episode));
            } else {
                this.f11275i.m17040a(m15484h().getResources().getInteger(R.integer.grid_colum_portret_shows_episode));
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private boolean m15745a(boolean z, boolean z2) {
        int i = 0;
        if (this.f11278l == null) {
            return false;
        }
        SeasonLastViewItem a = C3093i.m16696a(this.f11270d);
        if (a != null) {
            this.f11278l.setSeasonslist(a.getSeason_list());
        }
        if (z && m15744a(this.f11278l)) {
            return false;
        }
        if (this.f11277k.intValue() == -1) {
            return false;
        }
        if (this.f11278l.getSeasonslist() == null || this.f11278l.getSeasonslist().length() == 0) {
            return false;
        }
        C3065b.m16568a("tv_details");
        this.f11280n = (Season) new Select().from(Season.class).where("movie_id=" + this.f11270d + " AND num=" + this.f11277k).executeSingle();
        if (this.f11280n == null) {
            return false;
        }
        String poster;
        TvItemMeta tvItemMeta = TvItem.getTvItemMeta(this.f11278l);
        C3093i.m16697a(this.f11278l, this.f11277k.intValue(), this.f11278l.getSeasonslist());
        this.f11278l.setLast_vieved_season(this.f11277k.intValue());
        this.f11278l.setImdb_id(tvItemMeta.getImdb_id());
        this.f11278l.setDescription(tvItemMeta.getDescription());
        this.f11278l.setCats(tvItemMeta.getCats());
        this.f11278l.save();
        this.f11282p.findViewById(R.id.info_movie_container).setVisibility(0);
        this.f11272f.setText(this.f11278l.getTitle());
        if (z2) {
            poster = this.f11278l.getPoster();
            if (poster == null) {
                poster = this.f11280n.getBanner();
            }
            if (poster.equals("")) {
                this.f11279m.setVisibility(8);
            } else {
                this.f11285s.m16635a(this.f11279m, poster);
            }
        }
        m15781t();
        this.f11276j = new Select().from(Episod.class).where("season_num=" + this.f11277k + " AND mov_id=" + this.f11270d).orderBy("Id DESC").execute();
        if (this.f11276j != null) {
            if (z2) {
                if (this.f11275i != null) {
                    this.f11281o.removeHeaderView(this.f11282p);
                    this.f11281o.setAdapter(null);
                    this.f11275i = null;
                }
                this.f11275i = new C3221h(m15484h(), this.f11276j);
                this.f11281o.addHeaderView(this.f11282p);
                m15778s();
                m15787w();
                this.f11275i.m17041a((C2771a) this);
                this.f11281o.setAdapter(this.f11275i);
            } else {
                this.f11275i.m17116a(this.f11276j);
            }
        }
        try {
            String[] split = this.f11278l.getCats().split("#");
            if (split.length == 0) {
                throw new Exception();
            }
            CharSequence charSequence = "";
            while (i < split.length) {
                poster = charSequence + ((Category) new Select().from(Category.class).where("cat_id=" + split[i]).executeSingle()).getName();
                if (i != split.length - 1) {
                    poster = poster + ", ";
                }
                i++;
                Object obj = poster;
            }
            this.f11286t.setText(charSequence);
            this.f11289w.setText(this.f11278l.getDescription());
            m15767m();
            return true;
        } catch (Exception e) {
            this.f11286t.setVisibility(8);
        }
    }

    /* renamed from: t */
    private void m15781t() {
        int i = 0;
        this.f11283q = false;
        final String[] split = this.f11278l.getSeasonslist().split(";");
        Arrays.sort(split, new Comparator<String>(this) {
            /* renamed from: a */
            final /* synthetic */ C2821d f11233a;

            {
                this.f11233a = r1;
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return m15711a((String) obj, (String) obj2);
            }

            /* renamed from: a */
            public int m15711a(String str, String str2) {
                return Integer.valueOf(str).compareTo(Integer.valueOf(str2));
            }
        });
        List arrayList = new ArrayList();
        for (String str : split) {
            arrayList.add(m15484h().getString(R.string.season) + " " + str);
        }
        SpinnerAdapter arrayAdapter = new ArrayAdapter(m15484h(), 17367048, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.item_sort);
        this.f11273g.setAdapter(arrayAdapter);
        this.f11273g.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            /* renamed from: b */
            final /* synthetic */ C2821d f11235b;

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.f11235b.f11283q) {
                    int intValue = Integer.valueOf(split[i]).intValue();
                    if (this.f11235b.f11277k.intValue() != intValue) {
                        this.f11235b.m15729a(intValue, true);
                        this.f11235b.f11287u.setText(this.f11235b.m15484h().getString(R.string.season) + " " + intValue);
                        return;
                    }
                    return;
                }
                this.f11235b.f11283q = true;
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        while (i < split.length) {
            try {
                if (this.f11277k == Integer.valueOf(split[i])) {
                    this.f11273g.setSelection(i);
                    break;
                }
                i++;
            } catch (Exception e) {
            }
        }
        this.f11287u.setText(m15484h().getString(R.string.season) + " " + this.f11277k);
    }

    /* renamed from: a */
    private void m15729a(int i, final boolean z) {
        this.f11277k = Integer.valueOf(i);
        this.f11280n = (Season) new Select().from(Season.class).where("movie_id=" + this.f11270d + " AND num=" + this.f11277k).executeSingle();
        if (this.f11280n != null) {
            boolean z2;
            if (z) {
                z2 = false;
            } else {
                z2 = true;
            }
            m15745a(false, z2);
        } else if (C3178f.m16973b(m15484h())) {
            m15741a(m15484h().getString(R.string.loading_seasons));
            m15484h().m15142F().m16333a(this.f11270d, "" + i, new AsyncHttpResponseHandler(this) {
                /* renamed from: b */
                final /* synthetic */ C2821d f11240b;

                public void onSuccess(int i, final String str) {
                    C3094j.m16698a("getEpisodes", "" + str);
                    new Thread(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ AnonymousClass16 f11238b;

                        /* compiled from: ShowsPhoneDetailsFragment */
                        /* renamed from: com.tdo.showbox.b.a.d$16$1$1 */
                        class C28071 implements Runnable {
                            /* renamed from: a */
                            final /* synthetic */ C28081 f11236a;

                            C28071(C28081 c28081) {
                                this.f11236a = c28081;
                            }

                            public void run() {
                                boolean z;
                                C2821d c2821d = this.f11236a.f11238b.f11240b;
                                if (z) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                c2821d.m15745a(false, z);
                                this.f11236a.f11238b.f11240b.m15785v();
                            }
                        }

                        public void run() {
                            EpisodeResponse b = ObjParser.m16279b(str);
                            this.f11238b.f11240b.f11278l.setCats(b.getCats());
                            this.f11238b.f11240b.f11278l.setImdb_id(b.getImdb_id());
                            this.f11238b.f11240b.f11278l.setDescription(b.getDescription());
                            this.f11238b.f11240b.f11277k = Integer.valueOf(b.getSeason());
                            if (this.f11238b.f11240b.f11277k.intValue() <= 0) {
                                this.f11238b.f11240b.f11277k = Integer.valueOf(1);
                                b.setSeason(this.f11238b.f11240b.f11277k.intValue());
                            }
                            this.f11238b.f11240b.m15739a(b);
                            this.f11238b.f11240b.f11278l.setSeasonslist(b.getSeasons());
                            this.f11238b.f11240b.f11278l.save();
                            C3093i.m16697a(this.f11238b.f11240b.f11278l, this.f11238b.f11240b.f11277k.intValue(), this.f11238b.f11240b.f11278l.getSeasonslist());
                            TvItemMeta tvItemMeta = TvItem.getTvItemMeta(this.f11238b.f11240b.f11278l);
                            tvItemMeta.setImdb_id(b.getImdb_id());
                            tvItemMeta.setCats(b.getCats());
                            tvItemMeta.setDescription(b.getDescription());
                            tvItemMeta.save();
                            this.f11238b.f11240b.m15484h().runOnUiThread(new C28071(this));
                        }
                    }).start();
                }

                public void onFailure(Throwable th) {
                    this.f11240b.m15785v();
                }
            });
        } else {
            Toast.makeText(m15484h(), m15484h().getString(R.string.error_connection), 0).show();
        }
    }

    /* renamed from: a */
    private void m15739a(EpisodeResponse episodeResponse) {
        Season season = new Season();
        season.setBanner(episodeResponse.getBanner());
        season.setDescription(episodeResponse.getDescription());
        season.setNum("" + episodeResponse.getSeason());
        season.setMovieId(this.f11270d);
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
                episod.setMovId(Long.valueOf(this.f11270d).longValue());
            } catch (Exception e) {
            }
            episod.save();
        }
        season.save();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_info:
                m15798j();
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

    /* renamed from: u */
    private void m15782u() {
        if (this.f11280n != null) {
            final Dialog dialog = new Dialog(m15484h(), R.style.custom_dialog);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.dialog_show_info);
            Window window = dialog.getWindow();
            window.setBackgroundDrawableResource(17170445);
            window.getAttributes().windowAnimations = R.style.PauseDialogAnimation;
            ((TextView) dialog.findViewById(R.id.descr_view)).setText(this.f11280n.getDescription());
            dialog.findViewById(R.id.btn_close).setOnClickListener(new OnClickListener(this) {
                /* renamed from: b */
                final /* synthetic */ C2821d f11242b;

                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    }

    /* renamed from: a */
    private void m15741a(String str) {
        try {
            if (this.f11274h == null) {
                this.f11274h = ProgressDialog.show(m15484h(), "", str);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: v */
    private void m15785v() {
        try {
            if (this.f11274h != null) {
                this.f11274h.dismiss();
                this.f11274h = null;
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void mo2052a(View view, int i, Object obj) {
        m15477a(false);
        final Episod episod = (Episod) this.f11276j.get(i);
        DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_num=" + episod.getEpisode_id() + " AND percent=100 AND season_num=" + this.f11277k + " AND title=" + DatabaseUtils.sqlEscapeString(this.f11278l.getTitle())).executeSingle();
        if (downloadEpisode != null) {
            m15737a(episod, downloadEpisode);
        } else if (!m15484h().m15095l()) {
            if (C3178f.m16973b(m15484h())) {
                m15741a(m15484h().getString(R.string.loading_episode));
                m15484h().m15142F().m16334a("" + episod.getMovId(), "" + this.f11277k, "" + episod.getEpisode_id(), new AsyncHttpResponseHandler(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2821d f11244b;

                    public void onSuccess(int i, String str) {
                        super.onSuccess(i, str);
                        C3094j.m16698a("Shows details load epizode ", str);
                        this.f11244b.m15738a(episod, str);
                    }

                    public void onFailure(Throwable th, String str) {
                        super.onFailure(th, str);
                        this.f11244b.m15785v();
                        this.f11244b.m15789x();
                    }
                });
                return;
            }
            Toast.makeText(m15484h(), m15484h().getString(R.string.error_connection), 0).show();
        }
    }

    /* renamed from: a */
    private void m15738a(final Episod episod, final String str) {
        new Thread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C2821d f11248c;

            public void run() {
                ObjParser.m16274a(this.f11248c.m15484h(), str, episod, this.f11248c.f11277k.intValue());
                this.f11248c.m15736a(episod);
            }
        }).start();
    }

    /* renamed from: a */
    private void m15736a(final Episod episod) {
        new C3141b(m15484h().getApplicationContext()).m16882a(episod, new C2760a(this) {
            /* renamed from: b */
            final /* synthetic */ C2821d f11251b;

            /* compiled from: ShowsPhoneDetailsFragment */
            /* renamed from: com.tdo.showbox.b.a.d$3$1 */
            class C28111 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C28123 f11249a;

                C28111(C28123 c28123) {
                    this.f11249a = c28123;
                }

                public void run() {
                    this.f11249a.f11251b.m15785v();
                    this.f11249a.f11251b.m15748b(episod);
                }
            }

            /* renamed from: a */
            public void mo2046a(List<BaseVideoSource> list) {
                episod.setSourceList(list);
                Activity activity = this.f11251b.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new C28111(this));
                }
            }

            /* renamed from: a */
            public void mo2045a(String str) {
                this.f11251b.m15740a(this.f11251b.f11278l, this.f11251b.f11277k.intValue(), episod, str);
            }
        });
    }

    /* renamed from: a */
    private void m15740a(TvItem tvItem, int i, Episod episod, String str) {
        C3094j.m16698a("ShowsDetailsFragment", "markBrokenTorrent: name: " + tvItem.getTitle() + " hd: " + str + " epizode title: " + episod.getTitle() + " season: " + i);
        m15484h().m15142F().m16336a(tvItem.getItemId(), "tv", str, "" + i, "" + episod.getEpisode_id(), new C28134(this));
    }

    /* renamed from: b */
    private void m15748b(final Episod episod) {
        if (this.f11268G.m16448a(new C2814a(this) {
            /* renamed from: b */
            final /* synthetic */ C2821d f11254b;

            /* renamed from: a */
            public void mo2067a() {
                this.f11254b.m15785v();
                this.f11254b.m15753c(episod);
            }
        })) {
            m15753c(episod);
        } else {
            m15741a(getActivity().getString(R.string.alert_wait));
        }
    }

    /* renamed from: c */
    private void m15753c(Episod episod) {
        try {
            C3303a c3303a = new C3303a(m15484h(), episod, this.f11278l, this.f11277k.intValue(), this.f11268G);
            c3303a.m17443a(new C28176(this));
            if (m15484h().m15148L()) {
                c3303a.m17440a(this.a.getMeasuredWidth());
            }
            c3303a.m17444b((DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_num=" + episod.getEpisode_id() + " AND percent<100 AND season_num=" + this.f11277k + " AND title=" + DatabaseUtils.sqlEscapeString(this.f11278l.getTitle())).executeSingle());
            c3303a.show();
        } catch (Exception e) {
            e.printStackTrace();
            m15484h().m15094k();
        }
    }

    public void onResume() {
        super.onResume();
        if (m15484h().m15148L()) {
            m15765l();
        }
        if (this.f11278l != null && this.f11278l.getId() != null) {
            TvItem tvItem = (TvItem) new Select().from(TvItem.class).where("Id=" + this.f11278l.getId()).executeSingle();
            if (tvItem != null) {
                this.f11278l.setIn_lib(tvItem.getIn_lib());
                m15767m();
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (m15484h().m15148L()) {
            m15762k().m16437f();
        }
    }

    /* renamed from: a */
    private void m15737a(final Episod episod, final DownloadEpisode downloadEpisode) {
        if (this.f11268G.m16448a(new C2814a(this) {
            /* renamed from: c */
            final /* synthetic */ C2821d f11258c;

            /* renamed from: a */
            public void mo2067a() {
                this.f11258c.m15785v();
                this.f11258c.m15749b(episod, downloadEpisode);
            }
        })) {
            m15749b(episod, downloadEpisode);
        } else {
            m15741a(getActivity().getString(R.string.alert_wait));
        }
    }

    /* renamed from: b */
    private void m15749b(Episod episod, DownloadEpisode downloadEpisode) {
        C3303a c3303a = new C3303a(m15484h(), episod, this.f11278l, this.f11277k.intValue(), this.f11268G);
        c3303a.m17443a(new C28198(this));
        if (m15484h().m15148L()) {
            c3303a.m17440a(this.a.getMeasuredWidth());
        }
        c3303a.m17441a(downloadEpisode);
        c3303a.show();
    }

    /* renamed from: w */
    private void m15787w() {
        if (!m15484h().getResources().getBoolean(R.bool.portrait_only) && !C3088f.m16682b("PREF_SCROLL_SHOWED") && !this.f11291y && m15484h().getResources().getConfiguration().orientation == 2) {
            Intent intent = new Intent(m15484h(), ScrollHintActivity.class);
            this.f11291y = true;
            startActivityForResult(intent, 9845);
        }
    }

    /* renamed from: d */
    private void m15755d(final Episod episod) {
        m15741a(m15484h().getString(R.string.loading_episode));
        m15484h().m15142F().m16334a("" + episod.getMovId(), "" + this.f11277k, "" + episod.getEpisode_id(), new AsyncHttpResponseHandler(this) {
            /* renamed from: b */
            final /* synthetic */ C2821d f11261b;

            public void onSuccess(int i, String str) {
                super.onSuccess(i, str);
                this.f11261b.m15738a(episod, str);
            }

            public void onFailure(Throwable th, String str) {
                super.onFailure(th, str);
                this.f11261b.m15785v();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9845) {
            this.f11291y = false;
        }
        if (intent != null) {
            if (i == 123) {
                C3094j.m16698a("ShowsDetailsFragment", "onActivityResult ARG_CODE_OPEN_VIDEO");
                if (this.f11275i != null) {
                    this.f11275i.m17118c();
                }
                try {
                    long longExtra = intent.getLongExtra("ARG_URL_FAIL_ID", -1);
                    Episod episod;
                    if (longExtra != -1) {
                        for (Episod episod2 : this.f11276j) {
                            if (episod2.getId().longValue() == longExtra) {
                                m15755d(episod2);
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
                    for (Episod episod3 : this.f11276j) {
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
        } else if (i == 1113) {
            C3094j.m16698a("ShowsDetailsFragment", "onActivityResult ARG_CODE_OPEN_EXTERNAL_VIDEO");
            if (this.f11275i != null) {
                this.f11275i.m17118c();
            }
        }
    }

    /* renamed from: x */
    private void m15789x() {
        Builder builder = new Builder(m15484h());
        builder.setPositiveButton(m15484h().getString(R.string.close), new DialogInterface.OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ C2821d f11225a;

            {
                this.f11225a = r1;
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
        return m15797c();
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return this.f11263B;
    }

    /* renamed from: c */
    public C2668a m15797c() {
        if (this.f11262A == null) {
            this.f11262A = new C2711f();
            this.f11262A.m15358a((C2709a) this);
            this.f11262A.m15359a((C2710b) this);
        }
        return this.f11262A;
    }

    /* renamed from: a */
    public void mo2069a() {
        MainActivity h;
        if (this.f11284r) {
            this.f11278l.setIn_lib(0);
            TvItemMeta tvItemMeta = TvItem.getTvItemMeta(this.f11278l);
            tvItemMeta.setRemoved_from_lib(1);
            tvItemMeta.save();
            this.f11278l.save();
            h = m15484h();
            if (h != null) {
                h.m15168o().m16846b(this.f11278l);
            }
            Toast.makeText(m15484h(), m15484h().getString(R.string.alert_removed_from_lib), 0).show();
            C3065b.m16569a("favorite_removed", IjkMediaMeta.IJKM_KEY_TYPE, "tv");
            C3167a.m16903a().m16924d();
            m15484h().m15149M();
            return;
        }
        if (this.f11278l.getIn_lib() == 0) {
            this.f11278l.setIn_lib(1);
            this.f11278l.save();
            Toast.makeText(m15484h(), m15484h().getString(R.string.alert_added_to_lib), 0).show();
            C3065b.m16569a("favorite_added", IjkMediaMeta.IJKM_KEY_TYPE, "tv");
            h = m15484h();
            if (h != null) {
                h.m15168o().m16845a(this.f11278l);
            }
            m15484h().m15144H();
        } else {
            tvItemMeta = TvItem.getTvItemMeta(this.f11278l);
            tvItemMeta.setRemoved_from_lib(1);
            tvItemMeta.save();
            this.f11278l.setIn_lib(0);
            this.f11278l.save();
            Toast.makeText(m15484h(), m15484h().getString(R.string.alert_removed_from_lib), 0).show();
            C3065b.m16569a("favorite_removed", IjkMediaMeta.IJKM_KEY_TYPE, "tv");
            h = m15484h();
            if (h != null) {
                h.m15168o().m16846b(this.f11278l);
            }
        }
        m15767m();
    }

    /* renamed from: j */
    public void m15798j() {
        m15782u();
    }

    /* renamed from: b */
    public void mo2070b() {
        C3184j.m16981a(m15484h(), "", m15484h().getString(R.string.share_perf) + " '" + this.f11278l.getTitle() + "' " + getString(R.string.share_suf) + " " + m15484h().m15142F().f11831c);
        C3065b.m16569a("share", IjkMediaMeta.IJKM_KEY_TYPE, "tv");
    }
}
