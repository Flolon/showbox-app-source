package com.tdo.showbox.p117b.p118a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2695d;
import com.tdo.showbox.activities.p115a.C2695d.C2692a;
import com.tdo.showbox.activities.p115a.C2695d.C2693b;
import com.tdo.showbox.activities.p115a.C2695d.C2694c;
import com.tdo.showbox.b.a.a.AnonymousClass14;
import com.tdo.showbox.b.a.a.AnonymousClass15;
import com.tdo.showbox.b.a.a.AnonymousClass17;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.ObjParser;
import com.tdo.showbox.data.api.C3010c;
import com.tdo.showbox.data.api.C3010c.C2753a;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.loader.C2755a;
import com.tdo.showbox.data.loader.C3124f;
import com.tdo.showbox.data.p112c.C2754b;
import com.tdo.showbox.data.p119b.p120a.C3031c;
import com.tdo.showbox.data.p119b.p120a.C3031c.C2747a;
import com.tdo.showbox.data.torrent.C3139a;
import com.tdo.showbox.data.torrent.C3139a.C2750a;
import com.tdo.showbox.data.torrent.C3141b;
import com.tdo.showbox.data.torrent.C3141b.C2760a;
import com.tdo.showbox.models.AppConfig;
import com.tdo.showbox.models.BaseResponse;
import com.tdo.showbox.models.CatCRTorrentItem;
import com.tdo.showbox.models.Category;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.MovieItemMeta;
import com.tdo.showbox.models.Subtitle;
import com.tdo.showbox.models.UserInfo;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import com.tdo.showbox.p117b.C2769a;
import com.tdo.showbox.p117b.C2770b;
import com.tdo.showbox.p117b.p118a.C2772a;
import com.tdo.showbox.p117b.p118a.C2772a.14.C27481;
import com.tdo.showbox.p117b.p118a.C2772a.15.C27511;
import com.tdo.showbox.p121g.C3204b.C2771a;
import com.tdo.showbox.p121g.C3220g;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3172a;
import com.tdo.showbox.p131f.C3174c;
import com.tdo.showbox.p131f.C3176e;
import com.tdo.showbox.p131f.C3178f;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.views.C3324d;
import com.tdo.showbox.views.C3324d.C2744a;
import com.tdo.showbox.views.C3336f;
import com.tdo.showbox.views.C3336f.C2745a;
import com.tdo.showbox.views.ExtListView;
import com.tdo.showbox.views.ExtListView.C2746a;
import com.tdo.showbox.views.VideoQualityView.C3288b;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: PhoneMovieDetailsFragment */
/* renamed from: com.tdo.showbox.b.a.a */
public class C2772a extends C2770b implements OnClickListener, C2692a, C2693b, C2694c, C2771a {
    /* renamed from: A */
    private BaseVideoSource f11104A;
    /* renamed from: B */
    private List<String> f11105B;
    /* renamed from: C */
    private int f11106C;
    /* renamed from: D */
    private boolean f11107D;
    /* renamed from: E */
    private DownloadEpisode f11108E;
    /* renamed from: F */
    private Bitmap f11109F;
    /* renamed from: G */
    private boolean f11110G;
    /* renamed from: H */
    private C2695d f11111H;
    /* renamed from: I */
    private View f11112I;
    /* renamed from: J */
    private List<CatCRTorrentItem> f11113J;
    /* renamed from: K */
    private CatCRTorrentItem f11114K;
    /* renamed from: L */
    private boolean f11115L;
    /* renamed from: M */
    private String[] f11116M;
    /* renamed from: N */
    private boolean f11117N;
    /* renamed from: O */
    private boolean f11118O;
    /* renamed from: P */
    private boolean f11119P;
    /* renamed from: Q */
    private DownloadEpisode f11120Q;
    /* renamed from: R */
    private C2755a f11121R;
    /* renamed from: S */
    private C3336f f11122S;
    /* renamed from: h */
    private final String f11123h = C2772a.class.getName();
    /* renamed from: i */
    private ImageView f11124i;
    /* renamed from: j */
    private ImageView f11125j;
    /* renamed from: k */
    private int f11126k = 1;
    /* renamed from: l */
    private TextView f11127l;
    /* renamed from: m */
    private View f11128m;
    /* renamed from: n */
    private View f11129n;
    /* renamed from: o */
    private TextView f11130o;
    /* renamed from: p */
    private View f11131p;
    /* renamed from: q */
    private View f11132q;
    /* renamed from: r */
    private View f11133r;
    /* renamed from: s */
    private C3220g f11134s;
    /* renamed from: t */
    private FrameLayout f11135t;
    /* renamed from: u */
    private C3031c f11136u;
    /* renamed from: v */
    private Subtitle f11137v;
    /* renamed from: w */
    private View f11138w;
    /* renamed from: x */
    private ExtListView f11139x;
    /* renamed from: y */
    private View f11140y;
    /* renamed from: z */
    private List<BaseVideoSource> f11141z;

    /* compiled from: PhoneMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.a.a$1 */
    class C27561 implements C2755a {
        /* renamed from: a */
        final /* synthetic */ C2772a f11076a;

        C27561(C2772a c2772a) {
            this.f11076a = c2772a;
        }

        /* renamed from: a */
        public void mo2038a(DownloadEpisode downloadEpisode) {
            try {
                if (this.f11076a.f11130o.getVisibility() != 0) {
                    this.f11076a.f11130o.setVisibility(0);
                }
                CharSequence format = String.format(this.f11076a.m15484h().getString(R.string.torrent_downloading_in_progress_parrent), new Object[]{"" + downloadEpisode.getPercent() + "%"});
                if (downloadEpisode.getPercent() == 100) {
                    this.f11076a.f11130o.setText(R.string.video_downloaded_descr);
                } else {
                    this.f11076a.f11130o.setText(format);
                }
            } catch (Exception e) {
            }
        }

        /* renamed from: b */
        public void mo2039b(DownloadEpisode downloadEpisode) {
        }

        /* renamed from: c */
        public void mo2041c(DownloadEpisode downloadEpisode) {
        }

        /* renamed from: d */
        public void mo2042d(DownloadEpisode downloadEpisode) {
            this.f11076a.m15593r();
        }

        /* renamed from: e */
        public void mo2043e(DownloadEpisode downloadEpisode) {
        }

        /* renamed from: c */
        public void mo2040c() {
        }

        /* renamed from: f */
        public void mo2044f(DownloadEpisode downloadEpisode) {
            try {
                if (downloadEpisode.getPercent() == 100) {
                    this.f11076a.m15593r();
                    return;
                }
                this.f11076a.f11130o.setVisibility(0);
                String string = this.f11076a.m15484h().getString(R.string.torrent_downloading_in_progress_parrent);
                String str = "";
                if (downloadEpisode.getStatus() == 1 || downloadEpisode.getStatus() == 0) {
                    str = this.f11076a.m15484h().getString(R.string.download_waiting);
                } else if (downloadEpisode.getStatus() == 4) {
                    str = this.f11076a.m15484h().getString(R.string.peers_waiting);
                } else if (downloadEpisode.getStatus() == 5) {
                    str = this.f11076a.m15484h().getString(R.string.torrent_broken);
                }
                if (str.length() == 0) {
                    str = this.f11076a.m15484h().getString(R.string.download_waiting);
                }
                this.f11076a.f11130o.setText(String.format(string, new Object[]{str}));
            } catch (Exception e) {
            }
        }
    }

    /* compiled from: PhoneMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.a.a$3 */
    class C27583 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C2772a f11080a;

        C27583(C2772a c2772a) {
            this.f11080a = c2772a;
        }

        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            C3094j.m16698a("MovieDetailsFragment", "getMovieDetails response  " + str);
            this.f11080a.d = ObjParser.m16275a(this.f11080a.m15484h(), this.f11080a.d, str);
            this.f11080a.d.save();
            this.f11080a.m15559b(this.f11080a.d, false);
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            this.f11080a.m15493n();
        }
    }

    /* compiled from: PhoneMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.a.a$5 */
    class C27635 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2772a f11086a;

        /* compiled from: PhoneMovieDetailsFragment */
        /* renamed from: com.tdo.showbox.b.a.a$5$1 */
        class C27621 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C27635 f11085a;

            C27621(C27635 c27635) {
                this.f11085a = c27635;
            }

            public void run() {
                this.f11085a.f11086a.f11125j.setImageBitmap(this.f11085a.f11086a.f11109F);
            }
        }

        C27635(C2772a c2772a) {
            this.f11086a = c2772a;
        }

        public void run() {
            try {
                this.f11086a.f11109F = C3174c.m16959a(BitmapFactory.decodeStream(new URL(this.f11086a.d.getPoster()).openStream()), 60);
                this.f11086a.m15484h().runOnUiThread(new C27621(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: PhoneMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.a.a$6 */
    class C27656 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2772a f11088a;

        /* compiled from: PhoneMovieDetailsFragment */
        /* renamed from: com.tdo.showbox.b.a.a$6$1 */
        class C27641 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C27656 f11087a;

            C27641(C27656 c27656) {
                this.f11087a = c27656;
            }

            public void run() {
                try {
                    this.f11087a.f11088a.m15597t();
                } catch (Exception e) {
                }
            }
        }

        C27656(C2772a c2772a) {
            this.f11088a = c2772a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11088a.f11114K = (CatCRTorrentItem) this.f11088a.f11113J.get(i);
            if (C3176e.m16969a(this.f11088a.f11114K, this.f11088a.m15484h())) {
                BaseVideoSource b = this.f11088a.m15489j().m16879b(this.f11088a.m15484h(), this.f11088a.f11114K);
                try {
                    DownloadEpisode a = C3172a.m16955a(this.f11088a.m15484h(), this.f11088a.d.getDownloadID(), this.f11088a.m15564c(b), this.f11088a.d.getTitle(), this.f11088a.d.getPoster(), this.f11088a.f11126k, b);
                    Toast.makeText(this.f11088a.m15484h(), this.f11088a.m15484h().getString(R.string.video_added_toast), 0).show();
                    this.f11088a.m15484h().mo2004b().m16490b("movie_details__");
                    a.setSubtitle_id(this.f11088a.d.getMovieId());
                    if (this.f11088a.f11137v != null) {
                        Subtitle subtitle = new Subtitle();
                        subtitle.init(this.f11088a.f11137v);
                        subtitle.setIs_downloaded(1);
                        subtitle.setIs_movie(1);
                        subtitle.setParrent_id(a.getSubtitle_id());
                        subtitle.save();
                    }
                    this.f11088a.m15484h().m15154a(a);
                    C3065b.m16573b(b, true);
                    this.f11088a.m15490k();
                    this.f11088a.f11118O = true;
                    this.f11088a.m15534a(1);
                    this.f11088a.a.postDelayed(new C27641(this), 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dialogInterface.dismiss();
                return;
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: PhoneMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.a.a$7 */
    class C27667 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2772a f11089a;

        C27667(C2772a c2772a) {
            this.f11089a = c2772a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: PhoneMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.a.a$8 */
    class C27678 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2772a f11090a;

        C27678(C2772a c2772a) {
            this.f11090a = c2772a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11090a.f11114K = (CatCRTorrentItem) this.f11090a.f11113J.get(i);
            this.f11090a.f11104A = this.f11090a.m15489j().m16879b(this.f11090a.m15484h(), this.f11090a.f11114K);
            C3065b.m16567a(this.f11090a.f11104A, true);
            dialogInterface.dismiss();
            if (C3176e.m16969a(this.f11090a.f11114K, this.f11090a.getActivity())) {
                double d = 0.0d;
                try {
                    d = Double.valueOf(this.f11090a.d.getImdb_rating()).doubleValue();
                } catch (Exception e) {
                }
                this.f11090a.m15484h().m15089a(this.f11090a.m15564c(this.f11090a.f11104A), this.f11090a.f11137v, this.f11090a.d.getTitle(), d, 0, 0, this.f11090a.d.getPoster());
            }
        }
    }

    /* compiled from: PhoneMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.a.a$9 */
    class C27689 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2772a f11091a;

        C27689(C2772a c2772a) {
            this.f11091a = c2772a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            new Delete().from(DownloadEpisode.class).where("isDeleted=1").execute();
            this.c = getArguments().getString("ARG_ID");
            this.d = (MovieItem) new Select().from(MovieItem.class).where("movie_id=" + this.c).executeSingle();
            this.f11108E = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + this.d.getDownloadID() + " AND percent=100 AND is_movie=1").executeSingle();
            this.f11120Q = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + this.d.getDownloadID() + " AND percent<100 AND is_movie=1").executeSingle();
            this.f11118O = this.f11120Q != null;
        } catch (Exception e) {
            this.c = "";
        }
        try {
            this.e = getArguments().getBoolean("ARG_NEED_REMOVE", false);
        } catch (Exception e2) {
            this.e = false;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f11110G = false;
        return m15527a(layoutInflater);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m15617o();
        m15496A();
        if (this.d == null) {
            m15493n();
            return;
        }
        m15603w();
        m15609z();
        m15591q();
    }

    /* renamed from: p */
    private C3031c m15588p() {
        if (this.f11136u == null) {
            this.f11136u = new C3031c("native_movie_details");
        }
        return this.f11136u;
    }

    /* renamed from: q */
    private void m15591q() {
        if (m15484h().m15148L()) {
            m15588p().m16429a(m15484h(), (UserInfo) new Select().from(UserInfo.class).executeSingle());
        }
    }

    /* renamed from: a */
    private View m15527a(LayoutInflater layoutInflater) {
        this.a = layoutInflater.inflate(R.layout.frgm_movies_details, null);
        this.f11138w = layoutInflater.inflate(R.layout.header_frgm_movies_details, null);
        this.f11112I = layoutInflater.inflate(R.layout.view_movie_info, null);
        this.f11135t = (FrameLayout) this.f11138w.findViewById(R.id.rect_ad);
        this.f11133r = this.f11138w.findViewById(R.id.see_also_container);
        this.f11139x = (ExtListView) this.a.findViewById(R.id.list_view);
        this.f11139x.addFooterView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
        this.f11140y = this.f11138w.findViewById(R.id.view_progress_center);
        this.f11131p = this.f11138w.findViewById(R.id.btn_download_container);
        this.f11132q = this.f11138w.findViewById(R.id.btn_show_container);
        this.f11129n = this.f11138w.findViewById(R.id.watch_progress);
        this.f11128m = this.f11138w.findViewById(R.id.imgv_container_play);
        this.f11130o = (TextView) this.f11138w.findViewById(R.id.txv_desr_video_download);
        this.f11127l = (TextView) this.f11138w.findViewById(R.id.btn_show);
        this.f11132q.setOnClickListener(this);
        this.f11131p.setOnClickListener(this);
        this.f11124i = (ImageView) this.f11138w.findViewById(R.id.imgv_poster);
        this.f11125j = (ImageView) this.a.findViewById(R.id.imgv_background);
        this.f11126k = C3088f.m16681b("PREFS_SELECTED_QUALITY", this.f11126k);
        m15534a(1);
        m15561b(false, false);
        this.f11121R = new C27561(this);
        try {
            if (this.f11120Q != null) {
                CharSequence format;
                String string = m15484h().getString(R.string.torrent_downloading_in_progress_parrent);
                if (this.f11120Q.getPercent() <= 0 || this.f11120Q.getPercent() >= 100) {
                    format = String.format(string, new Object[]{m15484h().getString(R.string.download_waiting)});
                } else {
                    format = String.format(string, new Object[]{"" + this.f11120Q.getPercent() + "%"});
                }
                this.f11130o.setVisibility(0);
                this.f11130o.setText(format);
            }
        } catch (Exception e) {
        }
        return this.a;
    }

    /* renamed from: r */
    private void m15593r() {
        try {
            this.f11118O = false;
            this.f11120Q = null;
            this.f11108E = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + this.d.getDownloadID() + " AND percent=100 AND is_movie=1").executeSingle();
            m15504E();
            m15577f(true);
        } catch (Exception e) {
        }
    }

    /* renamed from: s */
    private void m15595s() {
        this.f11139x.m17206a(this.f11135t, new C2746a(this) {
            /* renamed from: a */
            final /* synthetic */ C2772a f11052a;

            {
                this.f11052a = r1;
            }

            /* renamed from: a */
            public void mo2031a() {
                this.f11052a.f11139x.m17205a();
                this.f11052a.m15588p().m16438g();
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (m15484h().m15148L()) {
            m15588p().m16436e();
            m15588p().m16431a(new C2747a(this) {
                /* renamed from: a */
                final /* synthetic */ C2772a f11053a;

                {
                    this.f11053a = r1;
                }

                /* renamed from: a */
                public void mo2032a() {
                    if (this.f11053a.f11135t != null && this.f11053a.m15588p().m16433b() != null) {
                        this.f11053a.f11135t.removeAllViews();
                        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        int dimensionPixelSize = this.f11053a.m15484h().getResources().getDimensionPixelSize(R.dimen.ad_rect_padding_top_bottom);
                        layoutParams.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
                        layoutParams.gravity = 17;
                        this.f11053a.f11135t.addView(this.f11053a.m15588p().m16433b(), layoutParams);
                        this.f11053a.m15595s();
                        C3094j.m16698a(this.f11053a.f11123h, "onAdsReady");
                    }
                }
            });
        }
        if (this.f11118O && this.f11120Q != null) {
            m15484h().m15177x().m16800a(this.f11120Q).m16809a(this.f11121R).m16820f();
        }
    }

    public void onPause() {
        super.onPause();
        if (m15484h().m15148L()) {
            m15588p().m16437f();
            if (this.f11135t != null) {
                this.f11135t.removeAllViews();
            }
        }
        if (this.f11118O && this.f11120Q != null) {
            m15484h().m15177x().m16800a(this.f11120Q).m16809a(null);
        }
    }

    /* renamed from: t */
    private void m15597t() {
        this.f11120Q = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + this.d.getDownloadID() + " AND percent<100 AND is_movie=1").executeSingle();
        if (this.f11120Q != null) {
            m15484h().m15177x().m16800a(this.f11120Q).m16809a(this.f11121R).m16820f();
        }
    }

    /* renamed from: a */
    private void m15546a(final BaseVideoSource baseVideoSource) {
        this.f11117N = false;
        m15489j().m16878a(this.d.getTitle(), this.d.getImdb_id(), new C2750a(this) {
            /* renamed from: b */
            final /* synthetic */ C2772a f11058b;

            /* compiled from: PhoneMovieDetailsFragment */
            /* renamed from: com.tdo.showbox.b.a.a$14$1 */
            class C27481 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass14 f11054a;

                C27481(AnonymousClass14 anonymousClass14) {
                    this.f11054a = anonymousClass14;
                }

                public void run() {
                    this.f11054a.f11058b.m15566c(false);
                }
            }

            /* renamed from: a */
            public void mo2033a(List<CatCRTorrentItem> list) {
                this.f11058b.f11113J = list;
                this.f11058b.f11116M = new String[this.f11058b.f11113J.size()];
                int i = 0;
                while (i < this.f11058b.f11113J.size()) {
                    this.f11058b.f11116M[i] = C3139a.m16867a(this.f11058b.m15484h(), (CatCRTorrentItem) this.f11058b.f11113J.get(i));
                    i = (this.f11058b.f11113J.get(i) == null || ((CatCRTorrentItem) this.f11058b.f11113J.get(i)).getSeeds() >= 150) ? i + 1 : i + 1;
                }
                if (this.f11058b.f11113J == null || this.f11058b.f11113J.size() <= 0) {
                    final BaseVideoSource a = this.f11058b.m15532a(this.f11058b.d, this.f11058b.f11141z, baseVideoSource);
                    if (a == null) {
                        if (this.f11058b.m15484h() != null) {
                            this.f11058b.m15484h().runOnUiThread(new C27481(this));
                            return;
                        }
                        return;
                    } else if (this.f11058b.m15484h() != null) {
                        this.f11058b.m15484h().runOnUiThread(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ AnonymousClass14 f11056b;

                            public void run() {
                                if (a != this.f11056b.f11058b.f11104A) {
                                    this.f11056b.f11058b.m15560b(a);
                                    this.f11056b.f11058b.m15561b(false, false);
                                    this.f11056b.f11058b.m15548a(a, false, false, false);
                                }
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                }
                this.f11058b.f11117N = true;
                this.f11058b.m15547a(this.f11058b.m15489j().m16879b(this.f11058b.m15484h(), (CatCRTorrentItem) this.f11058b.f11113J.get(0)), (CatCRTorrentItem) this.f11058b.f11113J.get(0), false, baseVideoSource);
            }
        });
    }

    /* renamed from: a */
    private void m15547a(BaseVideoSource baseVideoSource, CatCRTorrentItem catCRTorrentItem, boolean z, BaseVideoSource baseVideoSource2) {
        final boolean a = new C3141b(m15484h().getApplicationContext()).m16884a(baseVideoSource);
        if (m15484h() != null) {
            final BaseVideoSource baseVideoSource3 = baseVideoSource;
            final BaseVideoSource baseVideoSource4 = baseVideoSource2;
            final boolean z2 = z;
            final CatCRTorrentItem catCRTorrentItem2 = catCRTorrentItem;
            m15484h().runOnUiThread(new Runnable(this) {
                /* renamed from: f */
                final /* synthetic */ C2772a f11065f;

                /* compiled from: PhoneMovieDetailsFragment */
                /* renamed from: com.tdo.showbox.b.a.a$15$1 */
                class C27511 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ AnonymousClass15 f11059a;

                    C27511(AnonymousClass15 anonymousClass15) {
                        this.f11059a = anonymousClass15;
                    }

                    public void run() {
                        this.f11059a.f11065f.m15534a(1);
                        if (this.f11059a.f11065f.f11141z.size() == 1) {
                            this.f11059a.f11065f.m15548a(baseVideoSource3, false, false, false);
                        }
                    }
                }

                public void run() {
                    BaseVideoSource a;
                    if (baseVideoSource3 == null || !a) {
                        a = this.f11065f.m15532a(this.f11065f.d, this.f11065f.f11141z, baseVideoSource4);
                        if (a == null) {
                            this.f11065f.m15566c(false);
                            return;
                        }
                        this.f11065f.m15560b(a);
                        this.f11065f.m15561b(false, false);
                        this.f11065f.m15548a(a, false, false, false);
                        return;
                    }
                    this.f11065f.f11115L = true;
                    this.f11065f.f11141z.add(baseVideoSource3);
                    a = this.f11065f.m15532a(this.f11065f.d, this.f11065f.f11141z, baseVideoSource4);
                    if (z2) {
                        a = baseVideoSource3;
                    }
                    this.f11065f.m15560b(a);
                    this.f11065f.f11114K = catCRTorrentItem2;
                    this.f11065f.f11139x.postDelayed(new C27511(this), 400);
                }
            });
        }
    }

    /* renamed from: u */
    private void m15599u() {
        C3065b.m16568a("movie_details");
        TextView textView = (TextView) this.f11112I.findViewById(R.id.rating_view);
        TextView textView2 = (TextView) this.f11112I.findViewById(R.id.description_view);
        TextView textView3 = (TextView) this.f11112I.findViewById(R.id.name_view);
        TextView textView4 = (TextView) this.f11112I.findViewById(R.id.category_view);
        ((TextView) this.f11112I.findViewById(R.id.year_view)).setText(this.d.getYear());
        textView2.setText(this.d.getDescription());
        textView3.setText(this.d.getTitle());
        textView.setText(m15484h().getString(R.string.imdb_rating) + " " + this.d.getImdb_rating());
        try {
            String[] split = this.d.getCats().split("#");
            if (split.length == 0) {
                throw new Exception();
            }
            CharSequence charSequence = "";
            int i = 0;
            while (i < split.length) {
                String str = charSequence + ((Category) new Select().from(Category.class).where("cat_id=" + split[i]).executeSingle()).getName();
                if (i != split.length - 1) {
                    str = str + ", ";
                }
                i++;
                Object obj = str;
            }
            textView4.setText(charSequence);
            this.f11112I.findViewById(R.id.txtv_watch_trailer).setOnClickListener(new OnClickListener(this) {
                /* renamed from: a */
                final /* synthetic */ C2772a f11066a;

                {
                    this.f11066a = r1;
                }

                public void onClick(View view) {
                    if (!this.f11066a.m15482f()) {
                        this.f11066a.m15484h().m15076a().m16467a(true, "watch_trailer__");
                    }
                    this.f11066a.m15484h().m15157b(this.f11066a.d.getTrailer());
                    C3065b.m16568a("movie_watch_trailer");
                }
            });
        } catch (Exception e) {
            textView4.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m15545a(MovieItem movieItem, boolean z) {
        int i = false;
        this.f11119P = false;
        this.f11133r.setVisibility(0);
        this.f11138w.findViewById(R.id.info_movie_container).setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) this.f11138w.findViewById(R.id.info_content_container);
        m15599u();
        try {
            linearLayout.addView(this.f11112I);
        } catch (IllegalStateException e) {
            try {
                linearLayout.removeAllViews();
                linearLayout.addView(this.f11112I);
            } catch (Exception e2) {
            }
        }
        this.f11141z = movieItem.getSourceList();
        BaseVideoSource a = m15532a(this.d, this.f11141z, null);
        m15613a(null);
        if (this.f11108E == null) {
            if (!this.f11118O) {
                this.f11130o.setText(R.string.video_download_descr);
            }
            m15560b(a);
            if (a != null) {
                if (z) {
                    this.f11104A = MovieItem.getMovieItemMeta(this.d).getVideoSource();
                    if (this.f11104A != null) {
                        m15574e(this.f11104A.checkForValidUrls());
                        m15535a(this.f11126k, true);
                        while (i < this.f11141z.size()) {
                            if (((BaseVideoSource) this.f11141z.get(i)).getSource_mode_id() == this.f11104A.getSource_mode_id()) {
                                this.f11106C = i;
                            }
                            i++;
                        }
                    } else {
                        m15566c(false);
                    }
                } else {
                    m15548a(a, false, true, false);
                }
            }
            if (a == null || z) {
                m15546a(null);
                return;
            }
            return;
        }
        m15504E();
    }

    /* renamed from: a */
    private void m15548a(BaseVideoSource baseVideoSource, final boolean z, final boolean z2, final boolean z3) {
        if (!C3178f.m16973b(m15484h())) {
            Toast.makeText(m15484h(), R.string.error_connection, 0).show();
        } else if (baseVideoSource != this.f11104A) {
            this.f11104A = baseVideoSource;
            if (z) {
                m15561b(false, false);
            }
            this.f11107D = true;
            new C3010c(this.f11104A).m16380a(m15484h(), new C2753a(this) {
                /* renamed from: d */
                final /* synthetic */ C2772a f11072d;

                /* renamed from: a */
                public void mo2034a(final BaseResponse baseResponse) {
                    this.f11072d.m15484h().runOnUiThread(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ AnonymousClass17 f11068b;

                        public void run() {
                            if (this.f11068b.f11072d.f11104A.getSource_mode_id() == 10 && !z3 && (baseResponse == null || baseResponse.getResponse() == null)) {
                                BaseVideoSource baseVideoSource = null;
                                int i = 0;
                                while (i < this.f11068b.f11072d.f11141z.size()) {
                                    BaseVideoSource baseVideoSource2 = (BaseVideoSource) this.f11068b.f11072d.f11141z.get(i);
                                    if (baseVideoSource2.getSource_mode_id() == 2) {
                                        this.f11068b.f11072d.f11106C = i;
                                    } else {
                                        baseVideoSource2 = baseVideoSource;
                                    }
                                    i++;
                                    baseVideoSource = baseVideoSource2;
                                }
                                if (baseVideoSource != null) {
                                    this.f11068b.f11072d.m15548a(baseVideoSource, z, z2, true);
                                    return;
                                }
                            }
                            if (baseResponse == null) {
                                this.f11068b.f11072d.f11107D = false;
                                this.f11068b.f11072d.m15566c(false);
                            } else {
                                MovieItemMeta movieItemMeta = MovieItem.getMovieItemMeta(this.f11068b.f11072d.d);
                                movieItemMeta.setVideoSource(this.f11068b.f11072d.f11104A);
                                movieItemMeta.save();
                                if (!this.f11068b.f11072d.f11110G) {
                                    this.f11068b.f11072d.f11107D = false;
                                    boolean checkForValidUrls = this.f11068b.f11072d.f11104A.checkForValidUrls();
                                    this.f11068b.f11072d.m15574e(checkForValidUrls);
                                    if (checkForValidUrls) {
                                        this.f11068b.f11072d.m15535a(this.f11068b.f11072d.f11126k, z2);
                                    } else {
                                        this.f11068b.f11072d.m15534a(2);
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (z2) {
                                this.f11068b.f11072d.m15546a(this.f11068b.f11072d.f11104A);
                            }
                        }
                    });
                }
            });
        }
    }

    /* renamed from: c */
    private void m15566c(boolean z) {
        if (!this.f11110G) {
            if (z) {
                this.f11132q.setAlpha(1.0f);
                m15561b(true, true);
                this.f11119P = false;
            } else {
                m15534a(2);
                this.f11119P = true;
                m15561b(true, true);
                if (this.f11122S != null && this.f11122S.isShowing()) {
                    this.f11122S.m17579a(false, null, null);
                }
                this.f11132q.setAlpha(0.5f);
            }
            if (m15484h() != null) {
                m15484h().runOnUiThread(new Runnable(this) {
                    /* renamed from: a */
                    final /* synthetic */ C2772a f11073a;

                    {
                        this.f11073a = r1;
                    }

                    public void run() {
                        this.f11073a.m15601v();
                    }
                });
            }
        }
    }

    /* renamed from: v */
    private void m15601v() {
        if (this.f11134s == null || this.f11134s.getCount() == 0) {
            m15550a(false, false);
        }
    }

    /* renamed from: a */
    private BaseVideoSource m15532a(MovieItem movieItem, List<BaseVideoSource> list, BaseVideoSource baseVideoSource) {
        if (list == null || list.size() == 0) {
            return null;
        }
        BaseVideoSource baseVideoSource2 = (BaseVideoSource) list.get(AppConfig.getDefaultSelectSource(list));
        BaseVideoSource baseVideoSource3 = baseVideoSource2;
        for (BaseVideoSource baseVideoSource22 : list) {
            if (baseVideoSource != null && baseVideoSource22.getSource_mode_id() == baseVideoSource.getSource_mode_id()) {
                return baseVideoSource22;
            }
            if (baseVideoSource22.getPriority() <= baseVideoSource3.getPriority()) {
                baseVideoSource22 = baseVideoSource3;
            }
            baseVideoSource3 = baseVideoSource22;
        }
        return baseVideoSource3;
    }

    /* renamed from: b */
    private void m15560b(BaseVideoSource baseVideoSource) {
        this.f11105B = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < this.f11141z.size(); i2++) {
            if (((BaseVideoSource) this.f11141z.get(i2)).getSource_mode_id() == baseVideoSource.getSource_mode_id()) {
                i = i2;
            }
            this.f11105B.add(((BaseVideoSource) this.f11141z.get(i2)).getSource_name());
        }
        this.f11106C = i;
        if (this.f11106C > this.f11105B.size() - 1) {
            this.f11106C = 0;
        }
    }

    /* renamed from: a */
    public void m15613a(Subtitle subtitle) {
        if (this.d != null) {
            try {
                this.f11137v = subtitle;
                C3065b.m16569a("subtitles_enabled", "lang", subtitle.getLang());
            } catch (Exception e) {
                this.f11137v = (Subtitle) new Select().from(Subtitle.class).where("is_movie=1 AND parrent_id='" + this.d.getMovieId() + "'").executeSingle();
            }
        }
    }

    /* renamed from: w */
    private void m15603w() {
        boolean z = true;
        if (this.d != null) {
            C2695d c2695d = this.f11111H;
            if (this.d.getIn_lib() != 1) {
                z = false;
            }
            c2695d.m15325a(z);
        }
    }

    /* renamed from: x */
    private void m15605x() {
        try {
            if (this.d.getRecommendList().size() == 0) {
                this.f11133r.setVisibility(8);
                return;
            }
            int integer;
            this.f11133r.setVisibility(0);
            if (getResources().getConfiguration().orientation == 2) {
                integer = getResources().getInteger(R.integer.grid_colum_land);
            } else {
                integer = getResources().getInteger(R.integer.grid_colum_portret);
            }
            this.f11134s.m17040a(integer);
        } catch (Exception e) {
        }
    }

    /* renamed from: y */
    private boolean m15607y() {
        if (this.f11107D) {
            Toast.makeText(m15484h(), R.string.alert_wait, 0).show();
        }
        return this.f11107D;
    }

    /* renamed from: d */
    private void m15570d(final boolean z) {
        m15492m().m16636a(new C2754b(this) {
            /* renamed from: b */
            final /* synthetic */ C2772a f11075b;

            /* renamed from: b */
            public void mo2036b(String str) {
            }

            /* renamed from: a */
            public void mo2035a(String str) {
                this.f11075b.m15549a(str, z);
            }

            /* renamed from: c */
            public void mo2037c(String str) {
                this.f11075b.m15549a(str, z);
            }
        });
        m15492m().m16643d((int) R.drawable.im_trans_back);
        m15492m().m16635a(this.f11124i, this.d.getPoster_hires());
    }

    /* renamed from: a */
    private void m15549a(final String str, final boolean z) {
        m15484h().runOnUiThread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C2772a f11079c;

            public void run() {
                if (!(this.f11079c.d == null || this.f11079c.f11140y == null || !this.f11079c.d.getPoster_hires().equals(str))) {
                    this.f11079c.f11140y.setVisibility(8);
                }
                this.f11079c.m15545a(this.f11079c.d, z);
            }
        });
    }

    /* renamed from: z */
    private void m15609z() {
        BaseVideoSource videoSource = MovieItem.getMovieItemMeta(this.d).getVideoSource();
        if (videoSource == null || !videoSource.checkForValidUrls() || (m15488a(this.d) && C3178f.m16973b(m15484h()))) {
            this.f11140y.setVisibility(0);
            m15484h().m15142F().m16332a(this.c, new C27583(this));
            return;
        }
        this.d = ObjParser.m16275a(m15484h(), this.d, null);
        m15559b(this.d, true);
    }

    /* renamed from: b */
    private void m15559b(final MovieItem movieItem, final boolean z) {
        try {
            new C3141b(getActivity().getApplicationContext()).m16883a(movieItem, new C2760a(this) {
                /* renamed from: c */
                final /* synthetic */ C2772a f11084c;

                /* compiled from: PhoneMovieDetailsFragment */
                /* renamed from: com.tdo.showbox.b.a.a$4$1 */
                class C27591 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C27614 f11081a;

                    C27591(C27614 c27614) {
                        this.f11081a = c27614;
                    }

                    public void run() {
                        this.f11081a.f11084c.m15550a(true, true);
                        this.f11081a.f11084c.m15570d(z);
                    }
                }

                /* renamed from: a */
                public void mo2046a(List<BaseVideoSource> list) {
                    movieItem.setSourceList(list);
                    Activity activity = this.f11084c.getActivity();
                    if (activity != null) {
                        activity.runOnUiThread(new C27591(this));
                    }
                }

                /* renamed from: a */
                public void mo2045a(String str) {
                    this.f11084c.m15487a(movieItem, str);
                }
            });
        } catch (Exception e) {
        }
    }

    /* renamed from: A */
    private void m15496A() {
        try {
            String a = m15484h().m15139C().m16629a(this.d.getPoster());
            if (a != null) {
                this.f11109F = C3174c.m16959a(BitmapFactory.decodeFile(a), 60);
                this.f11125j.setImageBitmap(this.f11109F);
            } else if (C3178f.m16973b(m15484h())) {
                m15498B();
            }
        } catch (OutOfMemoryError e) {
            System.gc();
        } catch (Exception e2) {
        }
    }

    /* renamed from: B */
    private void m15498B() {
        new Thread(new C27635(this)).start();
    }

    /* renamed from: a */
    private void m15550a(boolean z, boolean z2) {
        List arrayList = new ArrayList();
        if (!z2) {
            arrayList = this.d.getRecommendList();
        }
        if (this.f11134s != null && z) {
            this.f11139x.removeHeaderView(this.f11138w);
            this.f11139x.setAdapter(null);
            this.f11134s = null;
        }
        if (this.f11134s == null) {
            this.f11134s = new C3220g(m15484h(), arrayList);
            this.f11139x.addHeaderView(this.f11138w);
            this.f11139x.setAdapter(null);
            this.f11139x.setAdapter(this.f11134s);
            this.f11134s.m17041a((C2771a) this);
            m15605x();
        }
        this.f11134s.m17113a(this.d.getRecommendList());
        m15595s();
    }

    public void onDestroy() {
        if (m15484h().m15148L()) {
            m15588p().m16435d();
        }
        m15484h().m15167n();
        this.f11110G = true;
        if (this.f11118O) {
            m15484h().m15177x().m16800a(this.f11120Q).m16809a(null);
            C3124f.m16796a();
        }
        m15484h().m15137A().m16641c();
        m15492m().m16636a(null);
        try {
            this.f11139x.setAdapter(null);
            C3184j.m16985a(this.f11133r, false);
            C3184j.m16985a(this.f11125j, false);
            this.f11109F.recycle();
            this.f11109F = null;
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    /* renamed from: c */
    private String m15564c(BaseVideoSource baseVideoSource) {
        try {
            String str = "";
            switch (this.f11126k) {
                case 0:
                    str = baseVideoSource.getLow_link();
                    break;
                case 1:
                    str = baseVideoSource.getMid_link();
                    break;
                case 2:
                    str = baseVideoSource.getHd_link();
                    break;
                case 3:
                    str = baseVideoSource.getFull_hd_link();
                    break;
            }
            if (str == null || str.length() == 0) {
                str = baseVideoSource.getFull_hd_link();
            }
            if (str == null || str.length() == 0) {
                str = baseVideoSource.getHd_link();
            }
            if (str == null || str.length() == 0) {
                str = baseVideoSource.getMid_link();
            }
            if (str == null || str.length() == 0) {
                return baseVideoSource.getLow_link();
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: e */
    private void m15574e(boolean z) {
        if (!this.f11110G) {
            if (z) {
                m15566c(true);
                m15561b(true, true);
                return;
            }
            m15566c(false);
        }
    }

    /* renamed from: a */
    private void m15535a(int i, boolean z) {
        if (this.f11104A == null) {
            m15566c(false);
            return;
        }
        List arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f11104A.getHd_link())) {
            arrayList.add(C3288b.HD);
        }
        if (TextUtils.isEmpty(this.f11104A.getMid_link())) {
            arrayList.add(C3288b.MIDDLE);
        }
        if (TextUtils.isEmpty(this.f11104A.getLow_link())) {
            arrayList.add(C3288b.LOW);
        }
        m15534a(z ? 1 : 4);
        this.f11126k = i;
        if (this.f11104A.getSource_mode_id() != 7 && this.f11104A.getSource_mode_id() != 10) {
            m15561b(true, true);
            if (this.f11122S != null && this.f11122S.isShowing()) {
                this.f11122S.m17579a(true, arrayList, C3288b.m17356a(i));
            }
        } else if (this.f11122S != null && this.f11122S.isShowing()) {
            this.f11122S.m17579a(false, null, null);
        }
    }

    /* renamed from: C */
    private void m15500C() {
        Builder builder = new Builder(m15484h());
        builder.setTitle(this.d.getTitle());
        builder.setSingleChoiceItems(this.f11116M, -1, new C27656(this));
        builder.setNegativeButton(R.string.cancel, new C27667(this));
        builder.show();
    }

    /* renamed from: D */
    private void m15502D() {
        Builder builder = new Builder(m15484h());
        builder.setTitle(this.d.getTitle());
        builder.setSingleChoiceItems(this.f11116M, -1, new C27678(this));
        builder.setNegativeButton(R.string.cancel, new C27689(this));
        builder.show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_download_container:
                if (!C3178f.m16973b(m15484h())) {
                    Toast.makeText(m15484h(), R.string.error_connection, 0).show();
                    return;
                } else if (!m15607y()) {
                    m15500C();
                    return;
                } else {
                    return;
                }
            case R.id.btn_show_container:
                try {
                    if (this.f11119P) {
                        Toast.makeText(m15484h(), R.string.error_video_not_available, 0).show();
                        return;
                    } else if (!m15607y()) {
                        if (this.f11108E != null || C3178f.m16973b(m15484h())) {
                            if (!m15482f()) {
                                m15484h().m15076a().m16467a(true, "movie_details__");
                            }
                            if (this.f11104A == null || this.f11104A.getSource_mode_id() != 7) {
                                final Bundle bundle = new Bundle();
                                bundle.putInt("ARG_TYPE_PLAY", 2);
                                bundle.putString("ARG_TITLE", "");
                                bundle.putInt("ARG_QUALITY", 0);
                                bundle.putInt("ARG_SEASON_NUM", 0);
                                try {
                                    bundle.putLong("ARG_MOVE_ID", Long.valueOf(this.d.getMovieId()).longValue());
                                } catch (Exception e) {
                                    bundle.putLong("ARG_MOVE_ID", 0);
                                }
                                bundle.putLong("ARG_EPIZOD_ID", 0);
                                if (this.f11108E != null) {
                                    bundle.putLong("ARG_OBJECT_ID", this.f11108E.getId().longValue());
                                    C3324d.m17541a(m15484h(), this.f11108E.getVideo_source(), new C2744a(this) {
                                        /* renamed from: b */
                                        final /* synthetic */ C2772a f11050b;

                                        /* renamed from: a */
                                        public void mo2027a() {
                                            this.f11050b.m15484h().mo2003a(this.f11050b.f11108E.getFull_path(), this.f11050b.f11108E.getEpisode_id(), this.f11050b.f11108E.getView_position(), true, bundle, this.f11050b.d.getTitle(), this.f11050b.f11137v);
                                        }
                                    });
                                } else {
                                    try {
                                        m15484h().mo2003a(m15564c(this.f11104A), this.d.getId().longValue(), MovieItem.getMovieItemMeta(this.d).getMovie_progress(), false, bundle, this.d.getTitle(), this.f11137v);
                                    } catch (Exception e2) {
                                    }
                                }
                                m15490k();
                                C3065b.m16571a(true, this.f11126k);
                                C3065b.m16567a(this.f11104A, true);
                                return;
                            } else if (!this.f11115L || this.f11114K == null) {
                                m15484h().m15094k();
                                return;
                            } else {
                                m15502D();
                                return;
                            }
                        }
                        Toast.makeText(m15484h(), R.string.error_connection, 0).show();
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            default:
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && i == 123) {
            try {
                int intExtra = intent.getIntExtra("ARG_VIDEO_POSITION", 0);
                int intExtra2 = intent.getIntExtra("ARG_VIDEO_PART_NUMBER", 0);
                MovieItemMeta movieItemMeta = MovieItem.getMovieItemMeta(this.d);
                movieItemMeta.setMovie_progress((long) intExtra);
                movieItemMeta.setPart_progress((long) intExtra);
                movieItemMeta.setPart_last_number(intExtra2);
                movieItemMeta.save();
                DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + this.d.getDownloadID()).executeSingle();
                if (downloadEpisode != null) {
                    downloadEpisode.setView_position((long) intExtra);
                    downloadEpisode.setPart_progress((long) intExtra);
                    downloadEpisode.setPart_last_number(intExtra2);
                    downloadEpisode.save();
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public void mo2052a(View view, int i, Object obj) {
        String movieId = ((MovieItem) this.d.getRecommendList().get(i)).getMovieId();
        if (((MovieItem) new Select().from(MovieItem.class).where("movie_id=" + movieId).executeSingle()) == null) {
            ((MovieItem) this.d.getRecommendList().get(i)).save();
        }
        if (((MovieItem) new Select().from(MovieItem.class).where("movie_id=" + movieId).executeSingle()) == null) {
            m15491l();
            return;
        }
        C3167a.m16903a().m16915a(movieId, false, false);
        C3065b.m16568a("see_also");
    }

    /* renamed from: b */
    private void m15561b(boolean z, boolean z2) {
        int i = 4;
        if (this.f11132q != null) {
            int i2;
            this.f11132q.setEnabled(z2);
            this.f11128m.setVisibility(z ? 0 : 4);
            TextView textView = this.f11127l;
            if (z) {
                i2 = 0;
            } else {
                i2 = 4;
            }
            textView.setVisibility(i2);
            View view = this.f11129n;
            if (!z) {
                i = 0;
            }
            view.setVisibility(i);
            m15577f(z2);
        }
    }

    /* renamed from: a */
    private void m15534a(int i) {
        boolean z = true;
        int i2 = R.string.video_download_descr;
        float f = 1.0f;
        if (this.f11131p != null) {
            View view;
            switch (i) {
                case 1:
                    boolean z2;
                    view = this.f11131p;
                    if (!this.f11117N) {
                        f = 0.5f;
                    }
                    view.setAlpha(f);
                    View view2 = this.f11131p;
                    if (!this.f11117N || this.f11118O) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    view2.setEnabled(z2);
                    this.f11130o.setVisibility(4);
                    if (this.f11117N && !this.f11118O) {
                        this.f11130o.setVisibility(0);
                        this.f11130o.setText(R.string.video_download_descr);
                        break;
                    }
                    break;
                case 2:
                    this.f11130o.setVisibility(0);
                    View view3 = this.f11131p;
                    if (!this.f11117N) {
                        f = 0.5f;
                    }
                    view3.setAlpha(f);
                    this.f11131p.setEnabled(this.f11117N);
                    if (!this.f11118O) {
                        this.f11130o.setText(this.f11117N ? R.string.video_download_descr : R.string.video_not_available);
                        break;
                    }
                    break;
                case 3:
                    this.f11130o.setText(R.string.video_downloaded_descr);
                    this.f11130o.setVisibility(0);
                    this.f11131p.setAlpha(0.5f);
                    this.f11131p.setEnabled(false);
                    break;
                case 4:
                    view = this.f11131p;
                    if (!this.f11117N) {
                        f = 0.5f;
                    }
                    view.setAlpha(f);
                    View view4 = this.f11131p;
                    if (!this.f11117N || this.f11118O) {
                        z = false;
                    }
                    view4.setEnabled(z);
                    this.f11130o.setVisibility(0);
                    if (!this.f11118O) {
                        TextView textView = this.f11130o;
                        if (!this.f11117N) {
                            i2 = R.string.hint_only_watching;
                        }
                        textView.setText(i2);
                        break;
                    }
                    break;
            }
            if (this.f11118O) {
                this.f11130o.setVisibility(0);
                this.f11131p.setVisibility(4);
                return;
            }
            this.f11131p.setVisibility(0);
        }
    }

    /* renamed from: E */
    private void m15504E() {
        m15534a(3);
        m15561b(true, true);
        this.f11126k = this.f11108E.getQuality();
        m15550a(false, false);
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        return m15617o();
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return m15617o();
    }

    /* renamed from: o */
    public C2668a m15617o() {
        if (this.f11111H == null) {
            this.f11111H = new C2695d();
            this.f11111H.m15322a((C2692a) this);
            this.f11111H.m15324a((C2694c) this);
            this.f11111H.m15323a((C2693b) this);
        }
        return this.f11111H;
    }

    /* renamed from: a */
    public void mo2051a() {
        if (!m15607y()) {
            if (this.e) {
                this.d.setIn_lib(0);
                this.d.save();
                Toast.makeText(m15484h(), m15484h().getString(R.string.alert_removed_from_lib), 0).show();
                C3065b.m16569a("favorite_removed", IjkMediaMeta.IJKM_KEY_TYPE, "movie");
                C3167a.m16903a().m16924d();
                m15484h().m15150N();
                return;
            }
            if (this.d.getIn_lib() == 0) {
                this.d.setIn_lib(1);
                this.d.save();
                Toast.makeText(m15484h(), m15484h().getString(R.string.alert_added_to_lib), 0).show();
                C3065b.m16569a("favorite_added", IjkMediaMeta.IJKM_KEY_TYPE, "movie");
            } else {
                this.d.setIn_lib(0);
                this.d.save();
                Toast.makeText(m15484h(), m15484h().getString(R.string.alert_removed_from_lib), 0).show();
                C3065b.m16569a("favorite_removed", IjkMediaMeta.IJKM_KEY_TYPE, "movie");
            }
            m15603w();
        }
    }

    /* renamed from: c */
    public void mo2055c() {
        C3184j.m16981a(m15484h(), "", m15484h().getString(R.string.share_perf_movie) + " '" + this.d.getTitle() + "' " + m15484h().getString(R.string.share_suf) + " " + m15484h().m15142F().f11831c);
        C3065b.m16569a("share", IjkMediaMeta.IJKM_KEY_TYPE, "movie");
    }

    /* renamed from: b */
    public void mo2054b() {
        this.f11122S = new C3336f(m15484h(), this.d);
        if (this.f11104A != null) {
            List arrayList = new ArrayList();
            if (TextUtils.isEmpty(this.f11104A.getHd_link())) {
                arrayList.add(C3288b.HD);
            }
            if (TextUtils.isEmpty(this.f11104A.getMid_link())) {
                arrayList.add(C3288b.MIDDLE);
            }
            if (TextUtils.isEmpty(this.f11104A.getLow_link())) {
                arrayList.add(C3288b.LOW);
            }
            if (!(this.f11104A.getSource_mode_id() == 7 || this.f11104A.getSource_mode_id() == 10)) {
                this.f11122S.m17576a(arrayList);
                this.f11122S.m17574a(C3288b.m17356a(this.f11126k));
            }
        }
        this.f11122S.m17580b(this.a.getMeasuredWidth());
        this.f11122S.m17577a(this.f11105B, this.f11106C);
        this.f11122S.m17573a(this.f11137v);
        this.f11122S.m17578a(this.f11108E != null);
        this.f11122S.m17575a(new C2745a(this) {
            /* renamed from: a */
            final /* synthetic */ C2772a f11051a;

            {
                this.f11051a = r1;
            }

            /* renamed from: a */
            public void mo2029a(Subtitle subtitle) {
                new Delete().from(Subtitle.class).where("is_movie=1 AND parrent_id='" + this.f11051a.d.getMovieId() + "'").execute();
                if (subtitle != null) {
                    subtitle.setIs_movie(1);
                    subtitle.setParrent_id(this.f11051a.d.getMovieId());
                    subtitle.processDelays(0);
                    subtitle.save();
                }
                this.f11051a.m15613a(subtitle);
            }

            /* renamed from: a */
            public void mo2028a(int i) {
                this.f11051a.f11106C = i;
                this.f11051a.m15548a((BaseVideoSource) this.f11051a.f11141z.get(i), true, false, true);
            }

            /* renamed from: b */
            public void mo2030b(int i) {
                this.f11051a.f11126k = i;
            }
        });
        this.f11122S.show();
    }

    /* renamed from: f */
    private void m15577f(boolean z) {
        if (this.f11111H != null) {
            this.f11111H.m15326b(z);
        }
    }
}
