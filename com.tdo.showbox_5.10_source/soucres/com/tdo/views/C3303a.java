package com.tdo.showbox.views;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3077d;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.C3010c;
import com.tdo.showbox.data.api.C3010c.C2753a;
import com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler;
import com.tdo.showbox.data.loader.C2755a;
import com.tdo.showbox.data.p112c.C3074a;
import com.tdo.showbox.data.p119b.p120a.C3034d;
import com.tdo.showbox.data.torrent.C3139a;
import com.tdo.showbox.data.torrent.C3139a.C2750a;
import com.tdo.showbox.data.torrent.C3141b;
import com.tdo.showbox.models.AppConfig;
import com.tdo.showbox.models.BaseResponse;
import com.tdo.showbox.models.CatCRTorrentItem;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.Episod;
import com.tdo.showbox.models.Subtitle;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import com.tdo.showbox.p117b.C2769a;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3172a;
import com.tdo.showbox.p131f.C3176e;
import com.tdo.showbox.p131f.C3178f;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.views.C3324d.C2744a;
import com.tdo.showbox.views.C3336f.C2745a;
import com.tdo.showbox.views.VideoQualityView.C3288b;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: EpizodeDialog */
/* renamed from: com.tdo.showbox.views.a */
public class C3303a extends Dialog implements OnClickListener {
    /* renamed from: A */
    private List<CatCRTorrentItem> f12743A;
    /* renamed from: B */
    private CatCRTorrentItem f12744B;
    /* renamed from: C */
    private boolean f12745C;
    /* renamed from: D */
    private int f12746D;
    /* renamed from: E */
    private String[] f12747E;
    /* renamed from: F */
    private TextView f12748F;
    /* renamed from: G */
    private boolean f12749G;
    /* renamed from: H */
    private int f12750H;
    /* renamed from: I */
    private DownloadEpisode f12751I;
    /* renamed from: J */
    private C2755a f12752J;
    /* renamed from: K */
    private C3336f f12753K;
    /* renamed from: L */
    private C3034d f12754L;
    /* renamed from: M */
    private ViewGroup f12755M;
    /* renamed from: a */
    private MainActivity f12756a;
    /* renamed from: b */
    private Episod f12757b;
    /* renamed from: c */
    private View f12758c;
    /* renamed from: d */
    private TextView f12759d;
    /* renamed from: e */
    private View f12760e;
    /* renamed from: f */
    private View f12761f;
    /* renamed from: g */
    private TextView f12762g;
    /* renamed from: h */
    private int f12763h;
    /* renamed from: i */
    private View f12764i;
    /* renamed from: j */
    private View f12765j;
    /* renamed from: k */
    private int f12766k = 0;
    /* renamed from: l */
    private TvItem f12767l;
    /* renamed from: m */
    private int f12768m;
    /* renamed from: n */
    private C2816a f12769n;
    /* renamed from: o */
    private C3074a f12770o;
    /* renamed from: p */
    private ImageView f12771p;
    /* renamed from: q */
    private Subtitle f12772q;
    /* renamed from: r */
    private List<BaseVideoSource> f12773r;
    /* renamed from: s */
    private BaseVideoSource f12774s;
    /* renamed from: t */
    private List<String> f12775t;
    /* renamed from: u */
    private boolean f12776u;
    /* renamed from: v */
    private boolean f12777v;
    /* renamed from: w */
    private boolean f12778w;
    /* renamed from: x */
    private DownloadEpisode f12779x;
    /* renamed from: y */
    private boolean f12780y;
    /* renamed from: z */
    private C3139a f12781z;

    /* compiled from: EpizodeDialog */
    /* renamed from: com.tdo.showbox.views.a$a */
    public interface C2816a {
        /* renamed from: a */
        void mo2068a(DownloadEpisode downloadEpisode);
    }

    /* compiled from: EpizodeDialog */
    /* renamed from: com.tdo.showbox.views.a$1 */
    class C32891 implements C2755a {
        /* renamed from: a */
        final /* synthetic */ C3303a f12720a;

        C32891(C3303a c3303a) {
            this.f12720a = c3303a;
        }

        /* renamed from: a */
        public void mo2038a(DownloadEpisode downloadEpisode) {
            try {
                CharSequence format = String.format(this.f12720a.f12756a.getString(R.string.torrent_downloading_in_progress_parrent), new Object[]{"" + downloadEpisode.getPercent() + "%"});
                if (this.f12720a.f12762g.getVisibility() != 0) {
                    this.f12720a.f12762g.setVisibility(0);
                }
                if (downloadEpisode.getPercent() == 100) {
                    this.f12720a.f12762g.setText(R.string.video_downloaded_descr);
                } else {
                    this.f12720a.f12762g.setText(format);
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
            this.f12720a.m17406c(downloadEpisode);
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
                    this.f12720a.m17406c(downloadEpisode);
                    return;
                }
                this.f12720a.f12762g.setVisibility(0);
                String string = this.f12720a.f12756a.getString(R.string.torrent_downloading_in_progress_parrent);
                String str = "";
                if (downloadEpisode.getStatus() == 1 || downloadEpisode.getStatus() == 0) {
                    str = this.f12720a.f12756a.getString(R.string.download_waiting);
                } else if (downloadEpisode.getStatus() == 4) {
                    str = this.f12720a.f12756a.getString(R.string.peers_waiting);
                } else if (downloadEpisode.getStatus() == 5) {
                    str = this.f12720a.f12756a.getString(R.string.torrent_broken);
                }
                if (str.length() == 0) {
                    str = this.f12720a.f12756a.getString(R.string.download_waiting);
                }
                this.f12720a.f12762g.setText(String.format(string, new Object[]{str}));
            } catch (Exception e) {
            }
        }
    }

    /* compiled from: EpizodeDialog */
    /* renamed from: com.tdo.showbox.views.a$2 */
    class C32902 extends AsyncHttpResponseHandler {
        /* renamed from: a */
        final /* synthetic */ C3303a f12721a;

        C32902(C3303a c3303a) {
            this.f12721a = c3303a;
        }

        public void onSuccess(String str) {
            super.onSuccess(str);
            C3094j.m16698a("set rating", "onSuccess, tv " + str);
        }

        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            C3094j.m16698a("set rating", "onFail, tv " + str);
        }
    }

    /* compiled from: EpizodeDialog */
    /* renamed from: com.tdo.showbox.views.a$3 */
    class C32913 implements C2744a {
        /* renamed from: a */
        final /* synthetic */ C3303a f12722a;

        C32913(C3303a c3303a) {
            this.f12722a = c3303a;
        }

        /* renamed from: a */
        public void mo2027a() {
            C3077d.m16650a(this.f12722a.f12767l, this.f12722a.f12757b.getEpisode_id(), this.f12722a.f12757b.getMovId(), this.f12722a.f12768m);
            this.f12722a.dismiss();
            boolean z = false;
            C2769a e = C3167a.m16903a().m16925e();
            if (e != null) {
                z = e.m15482f();
            }
            if (!z) {
                this.f12722a.f12756a.m15076a().m16467a(true, "episode_details__");
            }
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_TYPE_PLAY", 1);
            bundle.putString("ARG_TITLE", this.f12722a.f12757b.getTitle());
            bundle.putInt("ARG_QUALITY", this.f12722a.f12766k);
            bundle.putInt("ARG_SEASON_NUM", this.f12722a.f12768m);
            bundle.putLong("ARG_MOVE_ID", this.f12722a.f12757b.getMovId());
            bundle.putLong("ARG_EPIZOD_ID", this.f12722a.f12757b.getEpisode_id());
            bundle.putLong("ARG_OBJECT_ID", this.f12722a.f12779x.getId().longValue());
            this.f12722a.f12756a.mo2003a(this.f12722a.f12779x.getFull_path(), this.f12722a.f12779x.getEpisode_id(), this.f12722a.f12779x.getView_position(), true, bundle, this.f12722a.f12767l.getTitle(), this.f12722a.f12772q);
            this.f12722a.f12779x.setIs_viewed(1);
            this.f12722a.f12779x.save();
            new Update(DownloadEpisode.class).set("is_viewed=1").where("Id=" + this.f12722a.f12779x.getId()).execute();
        }
    }

    /* compiled from: EpizodeDialog */
    /* renamed from: com.tdo.showbox.views.a$4 */
    class C32944 implements C2750a {
        /* renamed from: a */
        final /* synthetic */ C3303a f12726a;

        /* compiled from: EpizodeDialog */
        /* renamed from: com.tdo.showbox.views.a$4$1 */
        class C32921 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C32944 f12723a;

            C32921(C32944 c32944) {
                this.f12723a = c32944;
            }

            public void run() {
                this.f12723a.f12726a.m17389a(false);
            }
        }

        C32944(C3303a c3303a) {
            this.f12726a = c3303a;
        }

        /* renamed from: a */
        public void mo2033a(List<CatCRTorrentItem> list) {
            this.f12726a.f12743A = list;
            this.f12726a.f12747E = new String[this.f12726a.f12743A.size()];
            int i = 0;
            while (i < this.f12726a.f12743A.size()) {
                this.f12726a.f12747E[i] = C3139a.m16867a(this.f12726a.f12756a, (CatCRTorrentItem) this.f12726a.f12743A.get(i));
                i = (this.f12726a.f12743A.get(i) == null || ((CatCRTorrentItem) this.f12726a.f12743A.get(i)).getSeeds() >= 150) ? i + 1 : i + 1;
            }
            if (this.f12726a.f12743A == null || this.f12726a.f12743A.size() <= 0) {
                final BaseVideoSource a = this.f12726a.m17378a(this.f12726a.f12767l, this.f12726a.f12773r);
                if (a == null) {
                    if (this.f12726a.f12756a != null) {
                        this.f12726a.f12756a.runOnUiThread(new C32921(this));
                        return;
                    }
                    return;
                } else if (this.f12726a.f12756a != null) {
                    this.f12726a.f12756a.runOnUiThread(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ C32944 f12725b;

                        public void run() {
                            this.f12725b.f12726a.m17381a(a);
                            this.f12725b.f12726a.m17390a(false, false);
                            this.f12725b.f12726a.m17383a(a, false, false);
                        }
                    });
                    return;
                } else {
                    return;
                }
            }
            this.f12726a.f12746D = 0;
            this.f12726a.f12776u = true;
            this.f12726a.m17382a(this.f12726a.m17402c().m16879b(this.f12726a.f12756a, (CatCRTorrentItem) this.f12726a.f12743A.get(0)), (CatCRTorrentItem) this.f12726a.f12743A.get(0), false);
        }
    }

    /* compiled from: EpizodeDialog */
    /* renamed from: com.tdo.showbox.views.a$7 */
    class C33007 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3303a f12740a;

        /* compiled from: EpizodeDialog */
        /* renamed from: com.tdo.showbox.views.a$7$1 */
        class C32991 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C33007 f12739a;

            C32991(C33007 c33007) {
                this.f12739a = c33007;
            }

            public void run() {
                try {
                    this.f12739a.f12740a.m17408d();
                } catch (Exception e) {
                }
            }
        }

        C33007(C3303a c3303a) {
            this.f12740a = c3303a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f12740a.f12746D = i;
            this.f12740a.f12744B = (CatCRTorrentItem) this.f12740a.f12743A.get(i);
            BaseVideoSource b = this.f12740a.m17402c().m16879b(this.f12740a.f12756a, this.f12740a.f12744B);
            if (C3176e.m16969a(this.f12740a.f12744B, this.f12740a.f12756a)) {
                String b2 = this.f12740a.m17394b(b);
                if (b2 == null) {
                    b2 = "";
                }
                if (b2.equals("")) {
                    this.f12740a.f12756a.m15094k();
                } else {
                    if (this.f12740a.f12769n != null) {
                        DownloadEpisode a = C3172a.m16954a(this.f12740a.f12756a, this.f12740a.f12757b.getDownloadID(), b2, this.f12740a.f12767l.getTitle(), this.f12740a.f12768m, this.f12740a.f12757b.getTitle(), this.f12740a.f12767l.getPoster(), this.f12740a.f12766k, this.f12740a.f12757b.getEpisode_id(), b);
                        a.setSubtitle_id("" + this.f12740a.f12757b.getMovId() + this.f12740a.f12768m + this.f12740a.f12757b.getEpisode_id());
                        if (this.f12740a.f12772q != null) {
                            new Delete().from(Subtitle.class).where("is_movie=0 AND parrent_id='" + a.getSubtitle_id() + "'").execute();
                            Subtitle subtitle = new Subtitle();
                            subtitle.init(this.f12740a.f12772q);
                            subtitle.setIs_downloaded(1);
                            subtitle.setIs_movie(0);
                            subtitle.setParrent_id(a.getSubtitle_id());
                            subtitle.save();
                        }
                        this.f12740a.f12769n.mo2068a(a);
                        C3065b.m16573b(b, false);
                        this.f12740a.f12777v = true;
                        this.f12740a.m17396b(1);
                        this.f12740a.f12758c.postDelayed(new C32991(this), 500);
                    }
                    this.f12740a.m17424i();
                }
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: EpizodeDialog */
    /* renamed from: com.tdo.showbox.views.a$8 */
    class C33018 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3303a f12741a;

        C33018(C3303a c3303a) {
            this.f12741a = c3303a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: EpizodeDialog */
    /* renamed from: com.tdo.showbox.views.a$9 */
    class C33029 implements DialogInterface.OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3303a f12742a;

        C33029(C3303a c3303a) {
            this.f12742a = c3303a;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f12742a.f12746D = i;
            this.f12742a.f12744B = (CatCRTorrentItem) this.f12742a.f12743A.get(i);
            this.f12742a.f12774s = this.f12742a.m17402c().m16879b(this.f12742a.f12756a, this.f12742a.f12744B);
            dialogInterface.dismiss();
            if (!this.f12742a.f12745C || this.f12742a.f12744B == null) {
                this.f12742a.f12756a.m15094k();
            } else if (C3176e.m16969a(this.f12742a.f12744B, this.f12742a.f12756a)) {
                this.f12742a.f12756a.m15089a(this.f12742a.m17394b(this.f12742a.f12774s), this.f12742a.f12772q, this.f12742a.f12767l.getTitle(), 0.0d, this.f12742a.f12768m, (int) this.f12742a.f12757b.getEpisode_id(), this.f12742a.f12767l.getPoster());
            } else {
                this.f12742a.dismiss();
                return;
            }
            this.f12742a.dismiss();
        }
    }

    public C3303a(MainActivity mainActivity, Episod episod, TvItem tvItem, int i, C3034d c3034d) {
        super(mainActivity, R.style.custom_dialog);
        this.f12756a = mainActivity;
        this.f12757b = episod;
        this.f12767l = tvItem;
        this.f12768m = i;
        if (episod == null) {
            this.f12773r = new ArrayList();
        } else {
            this.f12773r = episod.getSourceList();
        }
        this.f12780y = false;
        this.f12745C = false;
        this.f12754L = c3034d;
    }

    /* renamed from: a */
    public void m17440a(int i) {
        this.f12750H = i;
    }

    /* renamed from: b */
    private boolean m17400b() {
        try {
            for (BaseVideoSource source_mode_id : this.f12773r) {
                if (source_mode_id.getSource_mode_id() == 7) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public void m17441a(DownloadEpisode downloadEpisode) {
        this.f12779x = downloadEpisode;
    }

    /* renamed from: b */
    public void m17444b(DownloadEpisode downloadEpisode) {
        this.f12751I = downloadEpisode;
        this.f12777v = downloadEpisode != null;
    }

    /* renamed from: a */
    public void m17443a(C2816a c2816a) {
        this.f12769n = c2816a;
    }

    /* renamed from: c */
    private C3139a m17402c() {
        if (this.f12781z == null) {
            this.f12781z = new C3139a(this.f12756a.m15142F());
        }
        return this.f12781z;
    }

    /* renamed from: a */
    public void m17442a(Subtitle subtitle) {
        if (this.f12767l != null && this.f12757b != null) {
            try {
                this.f12772q = subtitle;
                C3065b.m16569a("subtitles_enabled", "lang", subtitle.getLang());
            } catch (Exception e) {
                this.f12772q = (Subtitle) new Select().from(Subtitle.class).where("is_movie=0 AND parrent_id='" + "" + this.f12757b.getMovId() + this.f12768m + this.f12757b.getEpisode_id() + "'").executeSingle();
            }
        }
    }

    /* renamed from: d */
    private void m17408d() {
        this.f12751I = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_num=" + this.f12757b.getEpisode_id() + " AND percent<100 AND season_num=" + this.f12768m + " AND title=" + DatabaseUtils.sqlEscapeString(this.f12767l.getTitle())).executeSingle();
        if (this.f12751I != null) {
            this.f12756a.m15177x().m16800a(this.f12751I).m16809a(this.f12752J).m16820f();
        }
    }

    protected void onStop() {
        this.f12749G = true;
        if (this.f12771p != null) {
            C3184j.m16985a(this.f12771p, false);
        }
        if (this.f12770o != null) {
            this.f12770o.m16639b();
        }
        if (this.f12777v && this.f12751I != null) {
            this.f12756a.m15177x().m16800a(this.f12751I).m16809a(null);
        }
        this.f12756a.m15167n();
        super.onStop();
        if (this.f12755M != null) {
            this.f12755M.removeAllViews();
        }
    }

    protected void onStart() {
        super.onStart();
        this.f12749G = false;
        m17439a().m16635a(this.f12771p, this.f12757b.getThumb());
        if (this.f12777v && this.f12751I != null) {
            this.f12756a.m15177x().m16800a(this.f12751I).m16809a(this.f12752J).m16820f();
        }
        if (this.f12754L.m16446a()) {
            this.f12754L.m16447a(this.f12756a, this.f12755M);
        }
    }

    /* renamed from: a */
    public C3074a m17439a() {
        if (this.f12770o == null) {
            this.f12770o = new C3074a(this.f12756a);
            AnimationSet animationSet = new AnimationSet(true);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400);
            animationSet.addAnimation(alphaAnimation);
            AnimationSet animationSet2 = new AnimationSet(true);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(400);
            animationSet2.addAnimation(alphaAnimation2);
            this.f12770o.m16633a(animationSet, animationSet2);
        }
        return this.f12770o;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.epizode_dlg);
        getWindow().setBackgroundDrawableResource(17170445);
        if (this.f12750H > 0) {
            View findViewById = findViewById(R.id.root);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.width = this.f12750H;
            findViewById.setLayoutParams(layoutParams);
            findViewById = findViewById(R.id.content_container);
            layoutParams = findViewById.getLayoutParams();
            layoutParams.width = this.f12750H;
            findViewById.setLayoutParams(layoutParams);
        }
        getWindow().getAttributes().dimAmount = 0.75f;
        getWindow().addFlags(2);
        this.f12764i = findViewById(R.id.btn_download_container);
        this.f12755M = (ViewGroup) findViewById(R.id.banner_container);
        this.f12765j = findViewById(R.id.btn_show_container);
        this.f12761f = findViewById(R.id.watch_progress);
        this.f12760e = findViewById(R.id.imgv_container_play);
        this.f12762g = (TextView) findViewById(R.id.txv_desr_video_download);
        findViewById(R.id.play_imgv).setOnClickListener(this);
        findViewById(R.id.play_imgv).setVisibility(0);
        this.f12758c = findViewById(R.id.options_container);
        this.f12758c.setOnClickListener(this);
        this.f12759d = (TextView) findViewById(R.id.btn_show);
        this.f12765j.setOnClickListener(this);
        this.f12764i.setOnClickListener(this);
        findViewById(R.id.btn_close).setOnClickListener(this);
        this.f12748F = (TextView) findViewById(R.id.txtv_epizone_name);
        this.f12771p = (ImageView) findViewById(R.id.imageScreen);
        findViewById(R.id.play_imgv).setOnClickListener(this);
        this.f12771p.setOnClickListener(this);
        String epizode_title = this.f12757b.getEpizode_title();
        if (epizode_title == null) {
            epizode_title = "";
        }
        this.f12748F.setText(Html.fromHtml(epizode_title.toUpperCase()));
        this.f12766k = C3088f.m16681b("PREFS_SELECTED_QUALITY", this.f12766k);
        m17396b(1);
        m17390a(false, false);
        BaseVideoSource a = m17378a(this.f12767l, this.f12773r);
        m17442a(null);
        this.f12752J = new C32891(this);
        try {
            if (this.f12751I != null) {
                CharSequence format;
                epizode_title = this.f12756a.getString(R.string.torrent_downloading_in_progress_parrent);
                if (this.f12751I.getPercent() <= 0 || this.f12751I.getPercent() >= 100) {
                    format = String.format(epizode_title, new Object[]{this.f12756a.getString(R.string.download_waiting)});
                } else {
                    format = String.format(epizode_title, new Object[]{"" + this.f12751I.getPercent() + "%"});
                }
                this.f12762g.setVisibility(0);
                this.f12762g.setText(format);
            }
        } catch (Exception e) {
        }
        this.f12778w = false;
        if (this.f12779x != null) {
            m17430l();
        } else if (m17400b()) {
            m17381a(a);
            if (a == null) {
                m17389a(false);
            } else {
                m17383a(a, false, false);
            }
        } else {
            m17414e();
        }
    }

    /* renamed from: c */
    private void m17406c(DownloadEpisode downloadEpisode) {
        try {
            this.f12777v = false;
            this.f12751I = null;
            this.f12779x = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("Id=" + downloadEpisode.getId()).executeSingle();
            m17430l();
            this.f12758c.setEnabled(true);
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    private void m17396b(int i) {
        boolean z = true;
        int i2 = R.string.video_download_descr;
        float f = 1.0f;
        if (this.f12764i != null) {
            View view;
            switch (i) {
                case 1:
                    boolean z2;
                    view = this.f12764i;
                    if (!this.f12776u) {
                        f = 0.5f;
                    }
                    view.setAlpha(f);
                    View view2 = this.f12764i;
                    if (!this.f12776u || this.f12777v) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    view2.setEnabled(z2);
                    this.f12762g.setVisibility(4);
                    if (this.f12776u && !this.f12777v) {
                        this.f12762g.setVisibility(0);
                        this.f12762g.setText(R.string.video_download_descr);
                        break;
                    }
                    break;
                case 2:
                    this.f12762g.setVisibility(0);
                    View view3 = this.f12764i;
                    if (!this.f12776u) {
                        f = 0.5f;
                    }
                    view3.setAlpha(f);
                    this.f12764i.setEnabled(this.f12776u);
                    if (!this.f12777v) {
                        this.f12762g.setText(this.f12776u ? R.string.video_download_descr : R.string.video_not_available);
                        break;
                    }
                    break;
                case 3:
                    this.f12762g.setText(R.string.video_downloaded_descr);
                    this.f12762g.setVisibility(0);
                    this.f12764i.setAlpha(0.5f);
                    this.f12764i.setEnabled(false);
                    break;
                case 4:
                    view = this.f12764i;
                    if (!this.f12776u) {
                        f = 0.5f;
                    }
                    view.setAlpha(f);
                    View view4 = this.f12764i;
                    if (!this.f12776u || this.f12777v) {
                        z = false;
                    }
                    view4.setEnabled(z);
                    this.f12762g.setVisibility(0);
                    if (!this.f12777v) {
                        TextView textView = this.f12762g;
                        if (!this.f12776u) {
                            i2 = R.string.hint_only_watching;
                        }
                        textView.setText(i2);
                        break;
                    }
                    break;
            }
            if (this.f12777v) {
                this.f12762g.setVisibility(0);
                this.f12764i.setVisibility(4);
                return;
            }
            this.f12764i.setVisibility(0);
        }
    }

    /* renamed from: e */
    private void m17414e() {
        m17402c().m16877a(this.f12767l.getTitle(), this.f12768m, (int) this.f12757b.getEpisode_id(), this.f12767l.getImdb_id(), new C32944(this));
    }

    /* renamed from: a */
    private void m17382a(BaseVideoSource baseVideoSource, CatCRTorrentItem catCRTorrentItem, boolean z) {
        final boolean a = new C3141b(this.f12756a.getApplicationContext()).m16884a(baseVideoSource);
        if (this.f12756a != null) {
            final BaseVideoSource baseVideoSource2 = baseVideoSource;
            final boolean z2 = z;
            final CatCRTorrentItem catCRTorrentItem2 = catCRTorrentItem;
            this.f12756a.runOnUiThread(new Runnable(this) {
                /* renamed from: e */
                final /* synthetic */ C3303a f12733e;

                public void run() {
                    BaseVideoSource a;
                    if (baseVideoSource2 == null || !a) {
                        a = this.f12733e.m17378a(this.f12733e.f12767l, this.f12733e.f12773r);
                        if (a == null) {
                            this.f12733e.m17389a(false);
                            return;
                        }
                        this.f12733e.m17381a(a);
                        this.f12733e.m17390a(false, false);
                        this.f12733e.m17383a(a, false, false);
                        return;
                    }
                    this.f12733e.f12745C = true;
                    this.f12733e.f12773r.add(baseVideoSource2);
                    a = this.f12733e.m17378a(this.f12733e.f12767l, this.f12733e.f12773r);
                    if (z2) {
                        a = baseVideoSource2;
                    }
                    this.f12733e.m17381a(a);
                    this.f12733e.f12744B = catCRTorrentItem2;
                    this.f12733e.f12758c.postDelayed(new Runnable(this) {
                        /* renamed from: b */
                        final /* synthetic */ C32965 f12728b;

                        public void run() {
                            this.f12728b.f12733e.m17396b(1);
                            this.f12728b.f12733e.m17383a(a, false, false);
                        }
                    }, 400);
                }
            });
        }
    }

    /* renamed from: c */
    private void m17405c(int i) {
        if (this.f12774s == null) {
            m17389a(false);
            return;
        }
        List arrayList = new ArrayList();
        if (TextUtils.isEmpty(this.f12774s.getHd_link())) {
            arrayList.add(C3288b.HD);
        }
        if (TextUtils.isEmpty(this.f12774s.getMid_link())) {
            arrayList.add(C3288b.MIDDLE);
        }
        if (TextUtils.isEmpty(this.f12774s.getLow_link())) {
            arrayList.add(C3288b.LOW);
        }
        m17396b(4);
        this.f12766k = i;
        if (this.f12774s.getSource_mode_id() != 7 && this.f12774s.getSource_mode_id() != 10) {
            m17390a(true, true);
            if (this.f12753K != null && this.f12753K.isShowing()) {
                this.f12753K.m17579a(true, arrayList, C3288b.m17356a(i));
            }
        } else if (this.f12753K != null && this.f12753K.isShowing()) {
            this.f12753K.m17579a(false, null, null);
        }
    }

    /* renamed from: a */
    private void m17381a(BaseVideoSource baseVideoSource) {
        this.f12775t = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < this.f12773r.size(); i2++) {
            if (((BaseVideoSource) this.f12773r.get(i2)).getSource_mode_id() == baseVideoSource.getSource_mode_id()) {
                i = i2;
            }
            this.f12775t.add(((BaseVideoSource) this.f12773r.get(i2)).getSource_name());
        }
        this.f12763h = i;
        if (this.f12763h > this.f12775t.size() - 1) {
            this.f12763h = 0;
        }
    }

    /* renamed from: a */
    private BaseVideoSource m17378a(TvItem tvItem, List<BaseVideoSource> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        BaseVideoSource baseVideoSource = (BaseVideoSource) list.get(AppConfig.getDefaultSelectSource(list));
        BaseVideoSource baseVideoSource2 = baseVideoSource;
        for (BaseVideoSource baseVideoSource3 : list) {
            if (baseVideoSource3.getPriority() <= baseVideoSource2.getPriority()) {
                baseVideoSource3 = baseVideoSource2;
            }
            baseVideoSource2 = baseVideoSource3;
        }
        return baseVideoSource2;
    }

    /* renamed from: a */
    private void m17383a(BaseVideoSource baseVideoSource, final boolean z, final boolean z2) {
        if (C3178f.m16973b(this.f12756a)) {
            this.f12774s = baseVideoSource;
            this.f12780y = true;
            if (z) {
                m17390a(false, false);
            }
            new C3010c(this.f12774s).m16380a(this.f12756a, new C2753a(this) {
                /* renamed from: c */
                final /* synthetic */ C3303a f12738c;

                /* renamed from: a */
                public void mo2034a(final BaseResponse baseResponse) {
                    if (this.f12738c.f12756a != null) {
                        this.f12738c.f12756a.runOnUiThread(new Runnable(this) {
                            /* renamed from: b */
                            final /* synthetic */ C32986 f12735b;

                            public void run() {
                                boolean z = false;
                                if (this.f12735b.f12738c.f12774s.getSource_mode_id() == 10 && !z2 && (baseResponse == null || baseResponse.getResponse() == null)) {
                                    BaseVideoSource baseVideoSource = null;
                                    int i = 0;
                                    while (i < this.f12735b.f12738c.f12773r.size()) {
                                        BaseVideoSource baseVideoSource2 = (BaseVideoSource) this.f12735b.f12738c.f12773r.get(i);
                                        if (baseVideoSource2.getSource_mode_id() == 2) {
                                            this.f12735b.f12738c.f12763h = i;
                                        } else {
                                            baseVideoSource2 = baseVideoSource;
                                        }
                                        i++;
                                        baseVideoSource = baseVideoSource2;
                                    }
                                    if (baseVideoSource != null) {
                                        this.f12735b.f12738c.m17383a(baseVideoSource, z, true);
                                        return;
                                    }
                                }
                                if (baseResponse == null) {
                                    this.f12735b.f12738c.f12780y = false;
                                    this.f12735b.f12738c.m17389a(false);
                                    return;
                                }
                                this.f12735b.f12738c.f12757b.setVideoSource(this.f12735b.f12738c.f12774s);
                                this.f12735b.f12738c.f12757b.save();
                                this.f12735b.f12738c.f12767l.save();
                                if (!this.f12735b.f12738c.f12749G) {
                                    this.f12735b.f12738c.f12780y = false;
                                    boolean checkForValidUrls = this.f12735b.f12738c.f12774s.checkForValidUrls();
                                    C3303a c3303a = this.f12735b.f12738c;
                                    if (!checkForValidUrls) {
                                        z = true;
                                    }
                                    c3303a.m17399b(z);
                                    if (checkForValidUrls) {
                                        this.f12735b.f12738c.m17405c(this.f12735b.f12738c.f12766k);
                                    } else {
                                        this.f12735b.f12738c.m17396b(2);
                                    }
                                }
                            }
                        });
                    }
                }
            });
            return;
        }
        Toast.makeText(this.f12756a, R.string.error_connection, 0).show();
    }

    /* renamed from: a */
    private void m17390a(boolean z, boolean z2) {
        int i = 4;
        if (this.f12765j != null) {
            int i2;
            this.f12765j.setEnabled(z2);
            this.f12760e.setVisibility(z ? 0 : 4);
            TextView textView = this.f12759d;
            if (z) {
                i2 = 0;
            } else {
                i2 = 4;
            }
            textView.setVisibility(i2);
            View view = this.f12761f;
            if (!z) {
                i = 0;
            }
            view.setVisibility(i);
            this.f12758c.setEnabled(z2);
            findViewById(R.id.play_imgv).setEnabled(z2);
            findViewById(R.id.imageScreen).setEnabled(z2);
        }
    }

    /* renamed from: a */
    private void m17389a(boolean z) {
        if (!this.f12749G) {
            if (z) {
                this.f12765j.setAlpha(1.0f);
                m17390a(true, true);
                this.f12778w = false;
                return;
            }
            m17396b(2);
            this.f12778w = true;
            m17390a(true, true);
            if (this.f12753K != null && this.f12753K.isShowing()) {
                this.f12753K.m17579a(false, null, null);
            }
            this.f12765j.setAlpha(0.5f);
        }
    }

    /* renamed from: f */
    private boolean m17417f() {
        if (this.f12780y) {
            Toast.makeText(this.f12756a, R.string.alert_wait, 0).show();
        }
        return this.f12780y;
    }

    /* renamed from: g */
    private void m17420g() {
        Builder builder = new Builder(this.f12756a);
        builder.setTitle(String.format(this.f12756a.getString(R.string.torrent_choice_title_pattern), new Object[]{this.f12767l.getTitle(), Integer.valueOf(this.f12768m), Long.valueOf(this.f12757b.getEpisode_id())}));
        builder.setSingleChoiceItems(this.f12747E, -1, new C33007(this));
        builder.setNegativeButton(R.string.cancel, new C33018(this));
        builder.show();
    }

    /* renamed from: h */
    private void m17422h() {
        CharSequence format = String.format(this.f12756a.getString(R.string.torrent_choice_title_pattern), new Object[]{this.f12767l.getTitle(), Integer.valueOf(this.f12768m), Long.valueOf(this.f12757b.getEpisode_id())});
        Builder builder = new Builder(this.f12756a);
        builder.setTitle(format);
        builder.setSingleChoiceItems(this.f12747E, -1, new C33029(this));
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(this) {
            /* renamed from: a */
            final /* synthetic */ C3303a f12718a;

            {
                this.f12718a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();
    }

    public void onClick(View view) {
        boolean z = false;
        switch (view.getId()) {
            case R.id.btn_close:
                dismiss();
                return;
            case R.id.btn_download_container:
                if (!m17417f()) {
                    m17420g();
                    return;
                }
                return;
            case R.id.btn_show_container:
                if (!m17417f()) {
                    if (this.f12779x == null) {
                        m17426j();
                    } else {
                        dismiss();
                        m17427k();
                    }
                    C3065b.m16567a(this.f12774s, false);
                    return;
                }
                return;
            case R.id.imageScreen:
                if (this.f12774s == null || this.f12774s.getSource_mode_id() != 7) {
                    if (this.f12779x == null) {
                        m17426j();
                    } else {
                        dismiss();
                        m17427k();
                    }
                    C3065b.m16567a(this.f12774s, false);
                    return;
                }
                return;
            case R.id.options_container:
                this.f12753K = new C3336f(this.f12756a, this.f12767l);
                if (this.f12756a.m15148L()) {
                    this.f12753K.m17580b(this.f12750H);
                } else {
                    this.f12753K.m17580b(this.f12756a.getResources().getDimensionPixelSize(R.dimen.dlg_epizode_width));
                }
                this.f12753K.m17570a(0.01f);
                if (this.f12774s != null) {
                    List arrayList = new ArrayList();
                    if (TextUtils.isEmpty(this.f12774s.getHd_link())) {
                        arrayList.add(C3288b.HD);
                    }
                    if (TextUtils.isEmpty(this.f12774s.getMid_link())) {
                        arrayList.add(C3288b.MIDDLE);
                    }
                    if (TextUtils.isEmpty(this.f12774s.getLow_link())) {
                        arrayList.add(C3288b.LOW);
                    }
                    if (!(this.f12774s.getSource_mode_id() == 7 || this.f12774s.getSource_mode_id() == 10)) {
                        this.f12753K.m17576a(arrayList);
                        this.f12753K.m17574a(C3288b.m17356a(this.f12766k));
                    }
                }
                this.f12753K.m17577a(this.f12775t, this.f12763h);
                this.f12753K.m17573a(this.f12772q);
                this.f12753K.m17572a(this.f12757b.getEpisode_id());
                this.f12753K.m17571a(this.f12768m);
                C3336f c3336f = this.f12753K;
                if (this.f12779x != null) {
                    z = true;
                }
                c3336f.m17578a(z);
                this.f12753K.m17575a(new C2745a(this) {
                    /* renamed from: a */
                    final /* synthetic */ C3303a f12719a;

                    {
                        this.f12719a = r1;
                    }

                    /* renamed from: a */
                    public void mo2029a(Subtitle subtitle) {
                        new Delete().from(Subtitle.class).where("is_movie=0 AND parrent_id='" + "" + this.f12719a.f12757b.getMovId() + this.f12719a.f12768m + this.f12719a.f12757b.getEpisode_id() + "'").execute();
                        if (subtitle != null) {
                            subtitle.setIs_movie(0);
                            subtitle.setParrent_id("" + "" + this.f12719a.f12757b.getMovId() + this.f12719a.f12768m + this.f12719a.f12757b.getEpisode_id());
                            subtitle.processDelays((int) this.f12719a.f12757b.getDelay());
                            subtitle.save();
                        }
                        this.f12719a.m17442a(subtitle);
                    }

                    /* renamed from: a */
                    public void mo2028a(int i) {
                        this.f12719a.f12763h = i;
                        this.f12719a.m17383a((BaseVideoSource) this.f12719a.f12773r.get(i), true, true);
                    }

                    /* renamed from: b */
                    public void mo2030b(int i) {
                        this.f12719a.f12766k = i;
                    }
                });
                this.f12753K.show();
                return;
            case R.id.play_imgv:
                try {
                    if (!m17417f()) {
                        if (this.f12779x == null) {
                            m17426j();
                        } else {
                            dismiss();
                            m17427k();
                        }
                        C3065b.m16567a(this.f12774s, false);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: i */
    private void m17424i() {
        if (this.f12756a != null && new Random().nextInt(6) + 1 == 1) {
            this.f12756a.m15142F().m16345c("" + this.f12767l.getItemId(), "TV", new C32902(this));
        }
    }

    /* renamed from: j */
    private void m17426j() {
        if (this.f12778w) {
            Toast.makeText(this.f12756a, R.string.error_video_not_available, 0).show();
        } else if (this.f12774s != null) {
            C3077d.m16650a(this.f12767l, this.f12757b.getEpisode_id(), this.f12757b.getMovId(), this.f12768m);
            if (this.f12774s.getSource_mode_id() == 7) {
                m17422h();
                return;
            }
            dismiss();
            String b = m17394b(this.f12774s);
            C3065b.m16571a(false, this.f12766k);
            if (b == null || b.equals("")) {
                this.f12756a.m15094k();
                return;
            }
            boolean f;
            m17424i();
            C2769a e = C3167a.m16903a().m16925e();
            if (e != null) {
                f = e.m15482f();
            } else {
                f = false;
            }
            if (!f) {
                this.f12756a.m15076a().m16467a(true, "episode_details__");
            }
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_TYPE_PLAY", 1);
            bundle.putString("ARG_TITLE", this.f12757b.getTitle());
            bundle.putInt("ARG_QUALITY", this.f12766k);
            bundle.putInt("ARG_SEASON_NUM", this.f12768m);
            bundle.putLong("ARG_MOVE_ID", this.f12757b.getMovId());
            bundle.putLong("ARG_EPIZOD_ID", this.f12757b.getEpisode_id());
            this.f12756a.mo2003a(b, this.f12757b.getId().longValue(), this.f12757b.getMovieProgress(), false, bundle, this.f12767l.getTitle(), this.f12772q);
        }
    }

    /* renamed from: b */
    private String m17394b(BaseVideoSource baseVideoSource) {
        if (baseVideoSource == null) {
            return null;
        }
        String str = "";
        switch (this.f12766k) {
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
            str = baseVideoSource.getLow_link();
        }
        C3094j.m16698a("EpizodeDialog", "select link: " + str);
        return str;
    }

    /* renamed from: b */
    private void m17399b(boolean z) {
        if (z) {
            m17389a(false);
            return;
        }
        m17389a(true);
        m17390a(true, true);
    }

    /* renamed from: k */
    private void m17427k() {
        C3324d.m17541a(this.f12756a, this.f12779x.getVideo_source(), new C32913(this));
    }

    /* renamed from: l */
    private void m17430l() {
        m17396b(3);
        m17390a(true, true);
        this.f12766k = this.f12779x.getQuality();
    }
}
