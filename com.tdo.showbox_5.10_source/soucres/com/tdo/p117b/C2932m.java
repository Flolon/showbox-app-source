package com.tdo.showbox.p117b;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.p116a.C2669a;
import com.tdo.showbox.b.m.AnonymousClass10;
import com.tdo.showbox.b.m.AnonymousClass12;
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
import com.tdo.showbox.models.videosources.BaseVideoSource;
import com.tdo.showbox.p117b.C2932m;
import com.tdo.showbox.p117b.C2932m.12.C29181;
import com.tdo.showbox.p121g.C3204b.C2771a;
import com.tdo.showbox.p121g.C3220g;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3172a;
import com.tdo.showbox.p131f.C3176e;
import com.tdo.showbox.p131f.C3178f;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.views.C3324d;
import com.tdo.showbox.views.C3324d.C2744a;
import com.tdo.showbox.views.C3336f;
import com.tdo.showbox.views.C3336f.C2745a;
import com.tdo.showbox.views.VideoQualityView.C3288b;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: TabMovieDetailsFragment */
/* renamed from: com.tdo.showbox.b.m */
public class C2932m extends C2770b implements OnClickListener, C2771a {
    /* renamed from: A */
    private TextView f11595A;
    /* renamed from: B */
    private View f11596B;
    /* renamed from: C */
    private View f11597C;
    /* renamed from: D */
    private View f11598D;
    /* renamed from: E */
    private List<CatCRTorrentItem> f11599E;
    /* renamed from: F */
    private CatCRTorrentItem f11600F;
    /* renamed from: G */
    private boolean f11601G;
    /* renamed from: H */
    private String[] f11602H;
    /* renamed from: I */
    private C2669a f11603I = new C2669a();
    /* renamed from: J */
    private boolean f11604J;
    /* renamed from: K */
    private boolean f11605K;
    /* renamed from: L */
    private boolean f11606L;
    /* renamed from: M */
    private DownloadEpisode f11607M;
    /* renamed from: N */
    private C2755a f11608N;
    /* renamed from: O */
    private List<String> f11609O;
    /* renamed from: P */
    private int f11610P;
    /* renamed from: Q */
    private TextView f11611Q;
    /* renamed from: R */
    private View f11612R;
    /* renamed from: S */
    private View f11613S;
    /* renamed from: T */
    private TextView f11614T;
    /* renamed from: U */
    private View f11615U;
    /* renamed from: V */
    private View f11616V;
    /* renamed from: W */
    private C3336f f11617W;
    /* renamed from: h */
    private ImageView f11618h;
    /* renamed from: i */
    private View f11619i;
    /* renamed from: j */
    private int f11620j = 1;
    /* renamed from: k */
    private TextView f11621k;
    /* renamed from: l */
    private View f11622l;
    /* renamed from: m */
    private C3220g f11623m;
    /* renamed from: n */
    private Subtitle f11624n;
    /* renamed from: o */
    private View f11625o;
    /* renamed from: p */
    private ListView f11626p;
    /* renamed from: q */
    private View f11627q;
    /* renamed from: r */
    private List<BaseVideoSource> f11628r;
    /* renamed from: s */
    private BaseVideoSource f11629s;
    /* renamed from: t */
    private boolean f11630t;
    /* renamed from: u */
    private DownloadEpisode f11631u;
    /* renamed from: v */
    private Bitmap f11632v;
    /* renamed from: w */
    private boolean f11633w;
    /* renamed from: x */
    private TextView f11634x;
    /* renamed from: y */
    private TextView f11635y;
    /* renamed from: z */
    private TextView f11636z;

    /* compiled from: TabMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.m$1 */
    class C29191 implements C2755a {
        /* renamed from: a */
        final /* synthetic */ C2932m f11574a;

        C29191(C2932m c2932m) {
            this.f11574a = c2932m;
        }

        /* renamed from: a */
        public void mo2038a(DownloadEpisode downloadEpisode) {
            try {
                if (this.f11574a.f11614T.getVisibility() != 0) {
                    this.f11574a.f11614T.setVisibility(0);
                }
                CharSequence format = String.format(this.f11574a.m15484h().getString(R.string.torrent_downloading_in_progress_parrent), new Object[]{"" + downloadEpisode.getPercent() + "%"});
                if (downloadEpisode.getPercent() == 100) {
                    this.f11574a.f11614T.setText(R.string.video_downloaded_descr);
                } else {
                    this.f11574a.f11614T.setText(format);
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
            this.f11574a.m16071b();
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
                    this.f11574a.m16071b();
                    return;
                }
                this.f11574a.f11614T.setVisibility(0);
                String string = this.f11574a.m15484h().getString(R.string.torrent_downloading_in_progress_parrent);
                String str = "";
                if (downloadEpisode.getStatus() == 1 || downloadEpisode.getStatus() == 0) {
                    str = this.f11574a.m15484h().getString(R.string.download_waiting);
                } else if (downloadEpisode.getStatus() == 4) {
                    str = this.f11574a.m15484h().getString(R.string.peers_waiting);
                } else if (downloadEpisode.getStatus() == 5) {
                    str = this.f11574a.m15484h().getString(R.string.torrent_broken);
                }
                if (str.length() == 0) {
                    str = this.f11574a.m15484h().getString(R.string.download_waiting);
                }
                this.f11574a.f11614T.setText(String.format(string, new Object[]{str}));
            } catch (Exception e) {
            }
        }
    }

    /* compiled from: TabMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.m$2 */
    class C29212 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2932m f11576a;

        /* compiled from: TabMovieDetailsFragment */
        /* renamed from: com.tdo.showbox.b.m$2$1 */
        class C29201 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C29212 f11575a;

            C29201(C29212 c29212) {
                this.f11575a = c29212;
            }

            public void run() {
                try {
                    this.f11575a.f11576a.m16117w();
                } catch (Exception e) {
                }
            }
        }

        C29212(C2932m c2932m) {
            this.f11576a = c2932m;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11576a.f11600F = (CatCRTorrentItem) this.f11576a.f11599E.get(i);
            if (C3176e.m16969a(this.f11576a.f11600F, this.f11576a.m15484h())) {
                BaseVideoSource b = this.f11576a.m15489j().m16879b(this.f11576a.m15484h(), this.f11576a.f11600F);
                try {
                    DownloadEpisode a = C3172a.m16955a(this.f11576a.m15484h(), this.f11576a.d.getDownloadID(), this.f11576a.m16082c(b), this.f11576a.d.getTitle(), this.f11576a.d.getPoster(), this.f11576a.f11620j, b);
                    Toast.makeText(this.f11576a.m15484h(), this.f11576a.m15484h().getString(R.string.video_added_toast), 0).show();
                    this.f11576a.m15484h().mo2004b().m16490b("movie_details__");
                    a.setSubtitle_id(this.f11576a.d.getMovieId());
                    if (this.f11576a.f11624n != null) {
                        Subtitle subtitle = new Subtitle();
                        subtitle.init(this.f11576a.f11624n);
                        subtitle.setIs_downloaded(1);
                        subtitle.setIs_movie(1);
                        subtitle.setParrent_id(a.getSubtitle_id());
                        subtitle.save();
                    }
                    this.f11576a.m15484h().m15154a(a);
                    C3065b.m16573b(b, true);
                    this.f11576a.m15490k();
                    this.f11576a.f11605K = true;
                    this.f11576a.m16052a(1);
                    this.f11576a.a.postDelayed(new C29201(this), 500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dialogInterface.dismiss();
                return;
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: TabMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.m$3 */
    class C29223 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2932m f11577a;

        C29223(C2932m c2932m) {
            this.f11577a = c2932m;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: TabMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.m$4 */
    class C29234 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2932m f11578a;

        C29234(C2932m c2932m) {
            this.f11578a = c2932m;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11578a.f11600F = (CatCRTorrentItem) this.f11578a.f11599E.get(i);
            this.f11578a.f11629s = this.f11578a.m15489j().m16879b(this.f11578a.m15484h(), this.f11578a.f11600F);
            C3065b.m16567a(this.f11578a.f11629s, true);
            dialogInterface.dismiss();
            if (C3176e.m16969a(this.f11578a.f11600F, this.f11578a.getActivity())) {
                double d = 0.0d;
                try {
                    d = Double.valueOf(this.f11578a.d.getImdb_rating()).doubleValue();
                } catch (Exception e) {
                }
                this.f11578a.m15484h().m15089a(this.f11578a.m16082c(this.f11578a.f11629s), this.f11578a.f11624n, this.f11578a.d.getTitle(), d, 0, 0, this.f11578a.d.getPoster());
            }
        }
    }

    /* compiled from: TabMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.m$5 */
    class C29245 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2932m f11579a;

        C29245(C2932m c2932m) {
            this.f11579a = c2932m;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: TabMovieDetailsFragment */
    /* renamed from: com.tdo.showbox.b.m$7 */
    class C29267 implements C2745a {
        /* renamed from: a */
        final /* synthetic */ C2932m f11582a;

        C29267(C2932m c2932m) {
            this.f11582a = c2932m;
        }

        /* renamed from: a */
        public void mo2029a(Subtitle subtitle) {
            new Delete().from(Subtitle.class).where("is_movie=1 AND parrent_id='" + this.f11582a.d.getMovieId() + "'").execute();
            if (subtitle != null) {
                subtitle.setIs_movie(1);
                subtitle.setParrent_id(this.f11582a.d.getMovieId());
                subtitle.processDelays(0);
                subtitle.save();
            }
            this.f11582a.m16119a(subtitle);
        }

        /* renamed from: a */
        public void mo2028a(int i) {
            this.f11582a.f11610P = i;
            this.f11582a.m16065a((BaseVideoSource) this.f11582a.f11628r.get(i), true, false, true);
        }

        /* renamed from: b */
        public void mo2030b(int i) {
            this.f11582a.f11620j = i;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.c = getArguments().getString("ARG_ID");
            this.d = (MovieItem) new Select().from(MovieItem.class).where("movie_id=" + this.c).executeSingle();
            this.f11631u = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + this.d.getDownloadID() + " AND percent=100 AND is_movie=1").executeSingle();
            this.f11607M = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + this.d.getDownloadID() + " AND percent<100 AND is_movie=1").executeSingle();
            this.f11605K = this.f11607M != null;
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
        this.f11633w = false;
        return m16045a(layoutInflater);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m16107o();
        m16112r();
    }

    /* renamed from: a */
    private void m16051a() {
        C3065b.m16568a("movie_details");
        this.f11635y.setText(this.d.getDescription());
        this.f11634x.setText(this.d.getTitle());
        this.f11595A.setText(m15484h().getString(R.string.imdb_rating) + " " + this.d.getImdb_rating());
        try {
            String[] split = this.d.getCats().split("#");
            if (split.length == 0) {
                throw new Exception();
            }
            String str = "";
            int i = 0;
            while (i < split.length) {
                String str2 = str + ((Category) new Select().from(Category.class).where("cat_id=" + split[i]).executeSingle()).getName();
                if (i != split.length - 1) {
                    str2 = str2 + ", ";
                }
                i++;
                str = str2;
            }
            this.f11636z.setText(this.d.getYear() + " | " + str);
        } catch (Exception e) {
            this.f11636z.setText(this.d.getYear());
        }
    }

    /* renamed from: a */
    private View m16045a(LayoutInflater layoutInflater) {
        View b = this.f11603I.m15277b(m15484h());
        this.a = layoutInflater.inflate(R.layout.frgm_movies_details, null);
        b.findViewById(R.id.filter_btn).setOnClickListener(this);
        this.f11625o = layoutInflater.inflate(R.layout.header_frgm_movies_details, null);
        this.f11622l = this.f11625o.findViewById(R.id.see_also_container);
        this.f11626p = (ListView) this.a.findViewById(R.id.list_view);
        this.f11626p.addFooterView(C2769a.m15475a(LayoutInflater.from(m15484h()).inflate(R.layout.list_footer, null, false)));
        this.f11615U = this.f11625o.findViewById(R.id.btn_download_container);
        this.f11616V = this.f11625o.findViewById(R.id.btn_show_container);
        this.f11613S = this.f11625o.findViewById(R.id.watch_progress);
        this.f11612R = this.f11625o.findViewById(R.id.imgv_container_play);
        this.f11614T = (TextView) this.f11625o.findViewById(R.id.txv_desr_video_download);
        this.f11611Q = (TextView) this.f11625o.findViewById(R.id.btn_show);
        this.f11616V.setOnClickListener(this);
        this.f11615U.setOnClickListener(this);
        this.f11627q = this.f11625o.findViewById(R.id.view_progress_center);
        this.f11621k = (TextView) b.findViewById(R.id.btn_library);
        this.f11621k.setOnClickListener(this);
        this.f11611Q = (TextView) this.f11625o.findViewById(R.id.btn_show);
        this.f11616V.setOnClickListener(this);
        this.f11615U.setOnClickListener(this);
        this.f11598D = this.f11625o.findViewById(R.id.poster_container);
        this.f11597C = this.f11625o.findViewById(R.id.descr_container);
        this.f11618h = (ImageView) this.f11625o.findViewById(R.id.poster_imgv);
        this.f11596B = this.a.findViewById(R.id.view_root_progress_center);
        this.f11619i = b.findViewById(R.id.options_container);
        this.f11619i.setOnClickListener(this);
        this.f11620j = C3088f.m16681b("PREFS_SELECTED_QUALITY", this.f11620j);
        m16052a(1);
        m16079b(false, false);
        this.f11595A = (TextView) this.f11625o.findViewById(R.id.rating_view);
        this.f11635y = (TextView) this.f11625o.findViewById(R.id.description_view);
        this.f11634x = (TextView) this.f11625o.findViewById(R.id.name_view);
        this.f11636z = (TextView) this.f11625o.findViewById(R.id.year_categories_view);
        this.f11625o.findViewById(R.id.txtv_trailer).setOnClickListener(this);
        m16116v();
        this.f11608N = new C29191(this);
        try {
            if (this.f11607M != null) {
                CharSequence format;
                String string = m15484h().getString(R.string.torrent_downloading_in_progress_parrent);
                if (this.f11607M.getPercent() <= 0 || this.f11607M.getPercent() >= 100) {
                    format = String.format(string, new Object[]{m15484h().getString(R.string.download_waiting)});
                } else {
                    format = String.format(string, new Object[]{"" + this.f11607M.getPercent() + "%"});
                }
                this.f11614T.setVisibility(0);
                this.f11614T.setText(format);
            }
        } catch (Exception e) {
        }
        return this.a;
    }

    /* renamed from: b */
    private void m16071b() {
        try {
            this.f11605K = false;
            this.f11607M = null;
            this.f11631u = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + this.d.getDownloadID() + " AND percent=100 AND is_movie=1").executeSingle();
            m16115u();
            this.f11619i.setEnabled(true);
        } catch (Exception e) {
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f11605K && this.f11607M != null) {
            m15484h().m15177x().m16800a(this.f11607M).m16809a(this.f11608N).m16820f();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.f11605K && this.f11607M != null) {
            m15484h().m15177x().m16800a(this.f11607M).m16809a(null);
        }
    }

    /* renamed from: a */
    private void m16063a(final BaseVideoSource baseVideoSource) {
        this.f11604J = false;
        m15489j().m16878a(this.d.getTitle(), this.d.getImdb_id(), new C2750a(this) {
            /* renamed from: b */
            final /* synthetic */ C2932m f11587b;

            /* compiled from: TabMovieDetailsFragment */
            /* renamed from: com.tdo.showbox.b.m$8$1 */
            class C29271 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C29298 f11583a;

                C29271(C29298 c29298) {
                    this.f11583a = c29298;
                }

                public void run() {
                    this.f11583a.f11587b.m16085c(false);
                }
            }

            /* renamed from: a */
            public void mo2033a(List<CatCRTorrentItem> list) {
                this.f11587b.f11599E = list;
                this.f11587b.f11602H = new String[this.f11587b.f11599E.size()];
                int i = 0;
                while (i < this.f11587b.f11599E.size()) {
                    this.f11587b.f11602H[i] = C3139a.m16867a(this.f11587b.m15484h(), (CatCRTorrentItem) this.f11587b.f11599E.get(i));
                    i = (this.f11587b.f11599E.get(i) == null || ((CatCRTorrentItem) this.f11587b.f11599E.get(i)).getSeeds() >= 150) ? i + 1 : i + 1;
                }
                if (this.f11587b.f11599E == null || this.f11587b.f11599E.size() <= 0) {
                    final BaseVideoSource a = this.f11587b.m16049a(this.f11587b.d, this.f11587b.f11628r, baseVideoSource);
                    if (a == null) {
                        if (this.f11587b.m15484h() != null) {
                            this.f11587b.m15484h().runOnUiThread(new C29271(this));
                            return;
                        }
                        return;
                    } else if (this.f11587b.m15484h() != null) {
                        this.f11587b.m15484h().runOnUiThread(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C29298 f11585b;

                            public void run() {
                                if (a != this.f11585b.f11587b.f11629s) {
                                    this.f11585b.f11587b.m16078b(a);
                                    this.f11585b.f11587b.m16079b(false, false);
                                    this.f11585b.f11587b.m16065a(a, false, false, false);
                                }
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                }
                this.f11587b.f11604J = true;
                this.f11587b.m16064a(this.f11587b.m15489j().m16879b(this.f11587b.m15484h(), (CatCRTorrentItem) this.f11587b.f11599E.get(0)), (CatCRTorrentItem) this.f11587b.f11599E.get(0), false, baseVideoSource);
            }
        });
    }

    /* renamed from: a */
    private void m16064a(BaseVideoSource baseVideoSource, CatCRTorrentItem catCRTorrentItem, boolean z, BaseVideoSource baseVideoSource2) {
        final boolean a = new C3141b(m15484h().getApplicationContext()).m16884a(baseVideoSource);
        if (m15484h() != null) {
            final BaseVideoSource baseVideoSource3 = baseVideoSource;
            final BaseVideoSource baseVideoSource4 = baseVideoSource2;
            final boolean z2 = z;
            final CatCRTorrentItem catCRTorrentItem2 = catCRTorrentItem;
            m15484h().runOnUiThread(new Runnable(this) {
                /* renamed from: f */
                final /* synthetic */ C2932m f11594f;

                /* compiled from: TabMovieDetailsFragment */
                /* renamed from: com.tdo.showbox.b.m$9$1 */
                class C29301 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C29319 f11588a;

                    C29301(C29319 c29319) {
                        this.f11588a = c29319;
                    }

                    public void run() {
                        this.f11588a.f11594f.m16052a(1);
                        if (this.f11588a.f11594f.f11628r.size() == 1) {
                            this.f11588a.f11594f.m16065a(baseVideoSource3, false, false, false);
                        }
                    }
                }

                public void run() {
                    BaseVideoSource a;
                    if (baseVideoSource3 == null || !a) {
                        a = this.f11594f.m16049a(this.f11594f.d, this.f11594f.f11628r, baseVideoSource4);
                        if (a == null) {
                            this.f11594f.m16085c(false);
                            return;
                        }
                        this.f11594f.m16078b(a);
                        this.f11594f.m16079b(false, false);
                        this.f11594f.m16065a(a, false, false, false);
                        return;
                    }
                    this.f11594f.f11601G = true;
                    this.f11594f.f11628r.add(baseVideoSource3);
                    a = this.f11594f.m16049a(this.f11594f.d, this.f11594f.f11628r, baseVideoSource4);
                    if (z2) {
                        a = baseVideoSource3;
                    }
                    this.f11594f.m16078b(a);
                    this.f11594f.f11600F = catCRTorrentItem2;
                    this.f11594f.a.postDelayed(new C29301(this), 400);
                }
            });
        }
    }

    /* renamed from: a */
    private void m16062a(MovieItem movieItem, boolean z) {
        m16051a();
        m16093e(false);
        this.f11628r = movieItem.getSourceList();
        BaseVideoSource a = m16049a(this.d, this.f11628r, null);
        m16119a(null);
        if (this.f11631u == null) {
            if (!this.f11605K) {
                this.f11614T.setText(R.string.video_download_descr);
            }
            m16078b(a);
            if (a != null) {
                if (z) {
                    this.f11629s = MovieItem.getMovieItemMeta(this.d).getVideoSource();
                    if (this.f11629s != null) {
                        m16095f(this.f11629s.checkForValidUrls());
                        m16053a(this.f11620j, true);
                        for (int i = 0; i < this.f11628r.size(); i++) {
                            if (((BaseVideoSource) this.f11628r.get(i)).getSource_mode_id() == this.f11629s.getSource_mode_id()) {
                                this.f11610P = i;
                            }
                        }
                    } else {
                        m16085c(false);
                    }
                } else {
                    m16065a(a, false, true, false);
                }
            }
            if (a == null || z) {
                m16063a(null);
                return;
            }
            return;
        }
        m16115u();
    }

    /* renamed from: a */
    private void m16065a(BaseVideoSource baseVideoSource, final boolean z, final boolean z2, final boolean z3) {
        if (!C3178f.m16973b(m15484h())) {
            Toast.makeText(m15484h(), R.string.error_connection, 0).show();
        } else if (baseVideoSource != this.f11629s) {
            this.f11629s = baseVideoSource;
            if (z) {
                m16079b(false, false);
            }
            this.f11630t = true;
            new C3010c(this.f11629s).m16380a(m15484h(), new C2753a(this) {
                /* renamed from: d */
                final /* synthetic */ C2932m f11561d;

                /* renamed from: a */
                public void mo2034a(final BaseResponse baseResponse) {
                    this.f11561d.m15484h().runOnUiThread(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ AnonymousClass10 f11557b;

                        public void run() {
                            if (this.f11557b.f11561d.f11629s.getSource_mode_id() == 10 && !z3 && (baseResponse == null || baseResponse.getResponse() == null)) {
                                BaseVideoSource baseVideoSource = null;
                                int i = 0;
                                while (i < this.f11557b.f11561d.f11628r.size()) {
                                    BaseVideoSource baseVideoSource2 = (BaseVideoSource) this.f11557b.f11561d.f11628r.get(i);
                                    if (baseVideoSource2.getSource_mode_id() == 2) {
                                        this.f11557b.f11561d.f11610P = i;
                                    } else {
                                        baseVideoSource2 = baseVideoSource;
                                    }
                                    i++;
                                    baseVideoSource = baseVideoSource2;
                                }
                                if (baseVideoSource != null) {
                                    this.f11557b.f11561d.m16065a(baseVideoSource, z, z2, true);
                                    return;
                                }
                            }
                            if (baseResponse == null) {
                                this.f11557b.f11561d.f11630t = false;
                                this.f11557b.f11561d.m16085c(false);
                            } else {
                                MovieItemMeta movieItemMeta = MovieItem.getMovieItemMeta(this.f11557b.f11561d.d);
                                movieItemMeta.setVideoSource(this.f11557b.f11561d.f11629s);
                                movieItemMeta.save();
                                if (!this.f11557b.f11561d.f11633w) {
                                    this.f11557b.f11561d.f11630t = false;
                                    boolean checkForValidUrls = this.f11557b.f11561d.f11629s.checkForValidUrls();
                                    this.f11557b.f11561d.m16095f(checkForValidUrls);
                                    if (checkForValidUrls) {
                                        this.f11557b.f11561d.m16053a(this.f11557b.f11561d.f11620j, z2);
                                    } else {
                                        this.f11557b.f11561d.m16052a(2);
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (z2) {
                                this.f11557b.f11561d.m16063a(this.f11557b.f11561d.f11629s);
                            }
                        }
                    });
                }
            });
        }
    }

    /* renamed from: c */
    private void m16085c(final boolean z) {
        if (!this.f11633w) {
            Activity h = m15484h();
            if (h != null) {
                h.runOnUiThread(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C2932m f11563b;

                    public void run() {
                        if (z) {
                            this.f11563b.f11616V.setAlpha(1.0f);
                            this.f11563b.m16079b(true, true);
                            this.f11563b.f11606L = false;
                        } else {
                            this.f11563b.m16052a(2);
                            this.f11563b.f11606L = true;
                            this.f11563b.m16079b(true, true);
                            if (this.f11563b.f11617W != null && this.f11563b.f11617W.isShowing()) {
                                this.f11563b.f11617W.m17579a(false, null, null);
                            }
                            this.f11563b.f11616V.setAlpha(0.5f);
                        }
                        this.f11563b.m16084c();
                    }
                });
            }
        }
    }

    /* renamed from: c */
    private void m16084c() {
        if (this.f11623m == null || this.f11623m.getCount() == 0) {
            m16067a(false, false);
        }
    }

    /* renamed from: b */
    private void m16078b(BaseVideoSource baseVideoSource) {
        this.f11609O = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < this.f11628r.size(); i2++) {
            if (((BaseVideoSource) this.f11628r.get(i2)).getSource_mode_id() == baseVideoSource.getSource_mode_id()) {
                i = i2;
            }
            this.f11609O.add(((BaseVideoSource) this.f11628r.get(i2)).getSource_name());
        }
        this.f11610P = i;
        if (this.f11610P > this.f11609O.size() - 1) {
            this.f11610P = 0;
        }
    }

    /* renamed from: a */
    public void m16119a(Subtitle subtitle) {
        if (this.d != null) {
            try {
                this.f11624n = subtitle;
                C3065b.m16569a("subtitles_enabled", "lang", subtitle.getLang());
            } catch (Exception e) {
                this.f11624n = (Subtitle) new Select().from(Subtitle.class).where("is_movie=1 AND parrent_id='" + this.d.getMovieId() + "'").executeSingle();
            }
        }
    }

    /* renamed from: a */
    private BaseVideoSource m16049a(MovieItem movieItem, List<BaseVideoSource> list, BaseVideoSource baseVideoSource) {
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
    private void m16077b(final MovieItem movieItem, final boolean z) {
        new C3141b(getActivity().getApplicationContext()).m16883a(movieItem, new C2760a(this) {
            /* renamed from: c */
            final /* synthetic */ C2932m f11567c;

            /* compiled from: TabMovieDetailsFragment */
            /* renamed from: com.tdo.showbox.b.m$12$1 */
            class C29181 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ AnonymousClass12 f11564a;

                C29181(AnonymousClass12 anonymousClass12) {
                    this.f11564a = anonymousClass12;
                }

                public void run() {
                    this.f11564a.f11567c.m16067a(true, true);
                    this.f11564a.f11567c.m16088d(z);
                }
            }

            /* renamed from: a */
            public void mo2046a(List<BaseVideoSource> list) {
                movieItem.setSourceList(list);
                Activity activity = this.f11567c.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new C29181(this));
                }
            }

            /* renamed from: a */
            public void mo2045a(String str) {
                this.f11567c.m15487a(movieItem, str);
            }
        });
    }

    /* renamed from: o */
    private void m16107o() {
        try {
            if (this.d.getIn_lib() == 1) {
                this.f11621k.setText(m15484h().getText(R.string.remove_to_lib));
            } else {
                this.f11621k.setText(m15484h().getText(R.string.add_to_lib));
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: p */
    private void m16110p() {
        try {
            if (this.d.getRecommendList().size() == 0) {
                this.f11622l.setVisibility(8);
                return;
            }
            int integer;
            this.f11622l.setVisibility(0);
            if (getResources().getConfiguration().orientation == 2) {
                integer = getResources().getInteger(R.integer.grid_colum_land);
            } else {
                integer = getResources().getInteger(R.integer.grid_colum_portret);
            }
            this.f11623m.m17040a(integer);
        } catch (Exception e) {
        }
    }

    /* renamed from: q */
    private boolean m16111q() {
        if (this.f11630t) {
            Toast.makeText(m15484h(), R.string.alert_wait, 0).show();
        }
        return this.f11630t;
    }

    /* renamed from: d */
    private void m16088d(final boolean z) {
        m15492m().m16636a(new C2754b(this) {
            /* renamed from: b */
            final /* synthetic */ C2932m f11569b;

            /* renamed from: b */
            public void mo2036b(String str) {
            }

            /* renamed from: a */
            public void mo2035a(String str) {
                this.f11569b.m16066a(str, z);
            }

            /* renamed from: c */
            public void mo2037c(String str) {
                this.f11569b.m16066a(str, z);
            }
        });
        m15492m().m16643d((int) R.drawable.im_trans_back);
        m15492m().m16635a(this.f11618h, this.d.getPoster_hires());
    }

    /* renamed from: a */
    private void m16066a(final String str, final boolean z) {
        m15484h().runOnUiThread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C2932m f11572c;

            public void run() {
                if (!(this.f11572c.d == null || this.f11572c.f11627q == null || !this.f11572c.d.getPoster_hires().equals(str))) {
                    this.f11572c.f11627q.setVisibility(8);
                }
                this.f11572c.m16062a(this.f11572c.d, z);
            }
        });
    }

    /* renamed from: e */
    private void m16093e(boolean z) {
        if (z) {
            this.f11596B.setVisibility(0);
            this.f11626p.setVisibility(4);
            return;
        }
        this.f11596B.setVisibility(8);
        this.f11626p.setVisibility(0);
    }

    /* renamed from: r */
    private void m16112r() {
        m16093e(true);
        if (this.d == null) {
            m15493n();
            return;
        }
        BaseVideoSource videoSource = MovieItem.getMovieItemMeta(this.d).getVideoSource();
        if (videoSource == null || !videoSource.checkForValidUrls() || (m15488a(this.d) && C3178f.m16973b(m15484h()))) {
            this.f11627q.setVisibility(0);
            m15484h().m15142F().m16332a(this.c, new AsyncHttpResponseHandler(this) {
                /* renamed from: a */
                final /* synthetic */ C2932m f11573a;

                {
                    this.f11573a = r1;
                }

                public void onSuccess(int i, String str) {
                    super.onSuccess(i, str);
                    this.f11573a.d = ObjParser.m16275a(this.f11573a.m15484h(), this.f11573a.d, str);
                    this.f11573a.d.save();
                    try {
                        this.f11573a.m16077b(this.f11573a.d, false);
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.f11573a.m15493n();
                    }
                }

                public void onFailure(Throwable th, String str) {
                    super.onFailure(th, str);
                    this.f11573a.m15493n();
                }
            });
            return;
        }
        this.d = ObjParser.m16275a(m15484h(), this.d, null);
        try {
            m16077b(this.d, true);
        } catch (Exception e) {
            e.printStackTrace();
            m15493n();
        }
    }

    /* renamed from: a */
    private void m16067a(boolean z, boolean z2) {
        List arrayList = new ArrayList();
        if (!z2) {
            arrayList = this.d.getRecommendList();
        }
        if (this.f11623m != null && z) {
            this.f11626p.removeHeaderView(this.f11625o);
            this.f11626p.setAdapter(null);
            this.f11623m = null;
        }
        if (this.f11623m == null) {
            this.f11623m = new C3220g(m15484h(), arrayList);
            this.f11626p.addHeaderView(this.f11625o);
            this.f11626p.setAdapter(null);
            this.f11626p.setAdapter(this.f11623m);
            this.f11623m.m17041a((C2771a) this);
            m16110p();
        }
        this.f11623m.m17113a(this.d.getRecommendList());
    }

    public void onDestroy() {
        this.f11633w = true;
        if (this.f11605K) {
            m15484h().m15177x().m16800a(this.f11607M).m16809a(null);
            C3124f.m16796a();
        }
        m15484h().m15167n();
        m15484h().m15137A().m16641c();
        m15492m().m16636a(null);
        try {
            this.f11626p.setAdapter(null);
            C3184j.m16985a(this.f11622l, false);
            this.f11632v.recycle();
            this.f11632v = null;
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    /* renamed from: c */
    private String m16082c(BaseVideoSource baseVideoSource) {
        try {
            String str = "";
            switch (this.f11620j) {
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

    /* renamed from: f */
    private void m16095f(boolean z) {
        if (!this.f11633w) {
            if (z) {
                m16085c(true);
                m16079b(true, true);
                return;
            }
            m16085c(false);
        }
    }

    /* renamed from: a */
    private void m16053a(int i, boolean z) {
        if (this.f11629s == null) {
            m16085c(false);
            return;
        }
        List arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f11629s.getHd_link())) {
            arrayList.add(C3288b.HD);
        }
        if (TextUtils.isEmpty(this.f11629s.getMid_link())) {
            arrayList.add(C3288b.MIDDLE);
        }
        if (TextUtils.isEmpty(this.f11629s.getLow_link())) {
            arrayList.add(C3288b.LOW);
        }
        m16052a(z ? 1 : 4);
        this.f11620j = i;
        if (this.f11629s.getSource_mode_id() != 7 && this.f11629s.getSource_mode_id() != 10) {
            m16079b(true, true);
            if (this.f11617W != null && this.f11617W.isShowing()) {
                this.f11617W.m17579a(true, arrayList, C3288b.m17356a(i));
            }
        } else if (this.f11617W != null && this.f11617W.isShowing()) {
            this.f11617W.m17579a(false, null, null);
        }
    }

    /* renamed from: s */
    private void m16113s() {
        Builder builder = new Builder(m15484h());
        builder.setTitle(this.d.getTitle());
        builder.setSingleChoiceItems(this.f11602H, -1, new C29212(this));
        builder.setNegativeButton(R.string.cancel, new C29223(this));
        builder.show();
    }

    /* renamed from: t */
    private void m16114t() {
        Builder builder = new Builder(m15484h());
        builder.setTitle(this.d.getTitle());
        builder.setSingleChoiceItems(this.f11602H, -1, new C29234(this));
        builder.setNegativeButton(R.string.cancel, new C29245(this));
        builder.show();
    }

    public void onClick(View view) {
        boolean z = true;
        switch (view.getId()) {
            case R.id.btn_download_container:
                if (!C3178f.m16973b(m15484h())) {
                    Toast.makeText(m15484h(), R.string.error_connection, 0).show();
                    return;
                } else if (!m16111q()) {
                    m16113s();
                    return;
                } else {
                    return;
                }
            case R.id.btn_library:
                if (!m16111q()) {
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
                    m16107o();
                    return;
                }
                return;
            case R.id.btn_show_container:
                try {
                    if (this.f11606L) {
                        Toast.makeText(m15484h(), R.string.error_video_not_available, 0).show();
                        return;
                    } else if (!m16111q()) {
                        if (this.f11631u != null || C3178f.m16973b(m15484h())) {
                            if (!m15482f()) {
                                m15484h().m15076a().m16467a(true, "movie_details__");
                            }
                            if (this.f11629s == null || this.f11629s.getSource_mode_id() != 7) {
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
                                if (this.f11631u != null) {
                                    bundle.putLong("ARG_OBJECT_ID", this.f11631u.getId().longValue());
                                    C3324d.m17541a(m15484h(), this.f11631u.getVideo_source(), new C2744a(this) {
                                        /* renamed from: b */
                                        final /* synthetic */ C2932m f11581b;

                                        /* renamed from: a */
                                        public void mo2027a() {
                                            this.f11581b.m15484h().mo2003a(this.f11581b.f11631u.getFull_path(), this.f11581b.f11631u.getEpisode_id(), this.f11581b.f11631u.getView_position(), true, bundle, this.f11581b.d.getTitle(), this.f11581b.f11624n);
                                        }
                                    });
                                } else {
                                    try {
                                        m15484h().mo2003a(m16082c(this.f11629s), this.d.getId().longValue(), MovieItem.getMovieItemMeta(this.d).getMovie_progress(), false, bundle, this.d.getTitle(), this.f11624n);
                                    } catch (Exception e2) {
                                    }
                                }
                                C3065b.m16571a(true, this.f11620j);
                                C3065b.m16567a(this.f11629s, true);
                                m15490k();
                                return;
                            } else if (!this.f11601G || this.f11600F == null) {
                                m15484h().m15094k();
                                return;
                            } else {
                                m16114t();
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
            case R.id.filter_btn:
                C3184j.m16981a(m15484h(), "", m15484h().getString(R.string.share_perf_movie) + " '" + this.d.getTitle() + "' " + m15484h().getString(R.string.share_suf) + " " + m15484h().m15142F().f11831c);
                C3065b.m16569a("share", IjkMediaMeta.IJKM_KEY_TYPE, "movie");
                return;
            case R.id.options_container:
                this.f11617W = new C3336f(m15484h(), this.d);
                if (this.f11629s != null) {
                    List arrayList = new ArrayList();
                    if (TextUtils.isEmpty(this.f11629s.getHd_link())) {
                        arrayList.add(C3288b.HD);
                    }
                    if (TextUtils.isEmpty(this.f11629s.getMid_link())) {
                        arrayList.add(C3288b.MIDDLE);
                    }
                    if (TextUtils.isEmpty(this.f11629s.getLow_link())) {
                        arrayList.add(C3288b.LOW);
                    }
                    if (!(this.f11629s.getSource_mode_id() == 7 || this.f11629s.getSource_mode_id() == 10)) {
                        this.f11617W.m17576a(arrayList);
                        this.f11617W.m17574a(C3288b.m17356a(this.f11620j));
                    }
                }
                this.f11617W.m17580b(m15484h().getResources().getDimensionPixelSize(R.dimen.dlg_epizode_width));
                this.f11617W.m17577a(this.f11609O, this.f11610P);
                this.f11617W.m17573a(this.f11624n);
                C3336f c3336f = this.f11617W;
                if (this.f11631u == null) {
                    z = false;
                }
                c3336f.m17578a(z);
                this.f11617W.m17575a(new C29267(this));
                this.f11617W.show();
                return;
            case R.id.txtv_trailer:
                if (!m15482f()) {
                    m15484h().m15076a().m16467a(true, "watch_trailer__");
                }
                m15484h().m15157b(this.d.getTrailer());
                C3065b.m16568a("movie_watch_trailer");
                return;
            default:
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && i == 123) {
            try {
                int intExtra = intent.getIntExtra("ARG_VIDEO_POSITION", 0);
                long longExtra = intent.getLongExtra("ARG_ID", 0);
                int intExtra2 = intent.getIntExtra("ARG_VIDEO_PART_NUMBER", 0);
                MovieItemMeta movieItemMeta = MovieItem.getMovieItemMeta(this.d);
                movieItemMeta.setPart_progress((long) intExtra);
                movieItemMeta.setPart_last_number(intExtra2);
                movieItemMeta.setMovie_progress((long) intExtra);
                movieItemMeta.save();
                DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + longExtra).executeSingle();
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

    /* renamed from: a */
    private void m16052a(int i) {
        boolean z = true;
        int i2 = R.string.video_download_descr;
        float f = 1.0f;
        if (this.f11615U != null) {
            View view;
            switch (i) {
                case 1:
                    boolean z2;
                    view = this.f11615U;
                    if (!this.f11604J) {
                        f = 0.5f;
                    }
                    view.setAlpha(f);
                    View view2 = this.f11615U;
                    if (!this.f11604J || this.f11605K) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    view2.setEnabled(z2);
                    this.f11614T.setVisibility(4);
                    if (this.f11604J && !this.f11605K) {
                        this.f11614T.setVisibility(0);
                        this.f11614T.setText(R.string.video_download_descr);
                        break;
                    }
                    break;
                case 2:
                    this.f11614T.setVisibility(0);
                    View view3 = this.f11615U;
                    if (!this.f11604J) {
                        f = 0.5f;
                    }
                    view3.setAlpha(f);
                    this.f11615U.setEnabled(this.f11604J);
                    if (!this.f11605K) {
                        this.f11614T.setText(this.f11604J ? R.string.video_download_descr : R.string.video_not_available);
                        break;
                    }
                    break;
                case 3:
                    this.f11614T.setText(R.string.video_downloaded_descr);
                    this.f11614T.setVisibility(0);
                    this.f11615U.setAlpha(0.5f);
                    this.f11615U.setEnabled(false);
                    break;
                case 4:
                    view = this.f11615U;
                    if (!this.f11604J) {
                        f = 0.5f;
                    }
                    view.setAlpha(f);
                    View view4 = this.f11615U;
                    if (!this.f11604J || this.f11605K) {
                        z = false;
                    }
                    view4.setEnabled(z);
                    this.f11614T.setVisibility(0);
                    if (!this.f11605K) {
                        TextView textView = this.f11614T;
                        if (!this.f11604J) {
                            i2 = R.string.hint_only_watching;
                        }
                        textView.setText(i2);
                        break;
                    }
                    break;
            }
            if (this.f11605K) {
                this.f11614T.setVisibility(0);
                this.f11615U.setVisibility(4);
                return;
            }
            this.f11615U.setVisibility(0);
        }
    }

    /* renamed from: b */
    private void m16079b(boolean z, boolean z2) {
        int i = 4;
        if (this.f11616V != null) {
            int i2;
            this.f11616V.setEnabled(z2);
            this.f11612R.setVisibility(z ? 0 : 4);
            TextView textView = this.f11611Q;
            if (z) {
                i2 = 0;
            } else {
                i2 = 4;
            }
            textView.setVisibility(i2);
            View view = this.f11613S;
            if (!z) {
                i = 0;
            }
            view.setVisibility(i);
            this.f11619i.setEnabled(z2);
        }
    }

    /* renamed from: u */
    private void m16115u() {
        m16052a(3);
        m16079b(true, true);
        this.f11620j = this.f11631u.getQuality();
        m16067a(false, false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f11623m = new C3220g(m15484h(), this.d.getRecommendList());
        m16116v();
        this.f11626p.setAdapter(null);
        this.f11626p.setAdapter(this.f11623m);
        this.f11623m.m17041a((C2771a) this);
        m16110p();
    }

    /* renamed from: v */
    private void m16116v() {
        try {
            LayoutParams layoutParams;
            if (m15484h().getResources().getConfiguration().orientation == 2) {
                float dimension = m15484h().getResources().getDimension(R.dimen.landscape_weight_poster);
                C3094j.m16698a("checkOrientation", "poster weight: " + dimension);
                layoutParams = (LayoutParams) this.f11598D.getLayoutParams();
                layoutParams = (LayoutParams) this.f11598D.getLayoutParams();
                layoutParams.weight = dimension;
                this.f11598D.setLayoutParams(layoutParams);
                layoutParams = (LayoutParams) this.f11597C.getLayoutParams();
                layoutParams.weight = 1.0f - dimension;
                this.f11597C.setLayoutParams(layoutParams);
                return;
            }
            layoutParams = (LayoutParams) this.f11598D.getLayoutParams();
            layoutParams.weight = 0.32f;
            this.f11598D.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.f11597C.getLayoutParams();
            layoutParams.weight = 0.68f;
            this.f11597C.setLayoutParams(layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return this.f11603I;
    }

    /* renamed from: w */
    private void m16117w() {
        this.f11607M = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + this.d.getDownloadID() + " AND percent<100 AND is_movie=1").executeSingle();
        if (this.f11607M != null) {
            m15484h().m15177x().m16800a(this.f11607M).m16809a(this.f11608N).m16820f();
        }
    }
}
