package com.tdo.showbox.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.p114e.C3079a;
import com.tdo.showbox.data.p114e.C3079a.C2656a;
import com.tdo.showbox.data.p114e.C3081b;
import com.tdo.showbox.data.p114e.C3082c;
import com.tdo.showbox.data.p114e.C3083d;
import com.tdo.showbox.data.p114e.C3086e;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.Episod;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.Subtitle;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import com.tdo.showbox.p113d.C2655c;
import com.tdo.showbox.p131f.C3178f;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.views.C3304b;
import com.tdo.showbox.views.SubtitleVideoView;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class VideoPlayerActivity extends C2631a implements C2655c, C2656a {
    /* renamed from: A */
    private View f10819A;
    /* renamed from: B */
    private int f10820B = 1536;
    /* renamed from: C */
    private View f10821C;
    /* renamed from: D */
    private int f10822D;
    /* renamed from: b */
    private SubtitleVideoView f10823b;
    /* renamed from: c */
    private ProgressBar f10824c;
    /* renamed from: d */
    private String f10825d;
    /* renamed from: e */
    private long f10826e;
    /* renamed from: f */
    private long f10827f;
    /* renamed from: g */
    private C3079a f10828g;
    /* renamed from: h */
    private int f10829h;
    /* renamed from: i */
    private String f10830i;
    /* renamed from: j */
    private int f10831j;
    /* renamed from: k */
    private int f10832k;
    /* renamed from: l */
    private long f10833l;
    /* renamed from: m */
    private long f10834m;
    /* renamed from: n */
    private RelativeLayout f10835n;
    /* renamed from: o */
    private String f10836o;
    /* renamed from: p */
    private boolean f10837p;
    /* renamed from: q */
    private TextView f10838q;
    /* renamed from: r */
    private boolean f10839r;
    /* renamed from: s */
    private int f10840s;
    /* renamed from: t */
    private C3086e f10841t;
    /* renamed from: u */
    private View f10842u;
    /* renamed from: v */
    private TextView f10843v;
    /* renamed from: w */
    private View f10844w;
    /* renamed from: x */
    private View f10845x;
    /* renamed from: y */
    private C3304b f10846y;
    /* renamed from: z */
    private String f10847z;

    /* renamed from: com.tdo.showbox.activities.VideoPlayerActivity$1 */
    class C26451 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerActivity f10807a;

        C26451(VideoPlayerActivity videoPlayerActivity) {
            this.f10807a = videoPlayerActivity;
        }

        public void onClick(View view) {
            if (this.f10807a.f10824c.getVisibility() != 0) {
                this.f10807a.f10823b.setVisibility(8);
                this.f10807a.f10824c.setVisibility(0);
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerActivity$2 */
    class C26462 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerActivity f10808a;

        C26462(VideoPlayerActivity videoPlayerActivity) {
            this.f10808a = videoPlayerActivity;
        }

        public void onClick(View view) {
            if (this.f10808a.f10824c.getVisibility() != 0) {
                this.f10808a.f10823b.setVisibility(8);
                this.f10808a.f10824c.setVisibility(0);
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerActivity$3 */
    class C26483 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerActivity f10810a;

        /* renamed from: com.tdo.showbox.activities.VideoPlayerActivity$3$1 */
        class C26471 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C26483 f10809a;

            C26471(C26483 c26483) {
                this.f10809a = c26483;
            }

            public void run() {
                this.f10809a.f10810a.finish();
            }
        }

        C26483(VideoPlayerActivity videoPlayerActivity) {
            this.f10810a = videoPlayerActivity;
        }

        public void run() {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.f10810a.runOnUiThread(new C26471(this));
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerActivity$5 */
    class C26505 implements OnAttachStateChangeListener {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerActivity f10813a;

        C26505(VideoPlayerActivity videoPlayerActivity) {
            this.f10813a = videoPlayerActivity;
        }

        public void onViewAttachedToWindow(View view) {
            this.f10813a.f10821C = view;
            this.f10813a.m15221o();
        }

        public void onViewDetachedFromWindow(View view) {
            this.f10813a.m15222p();
            view.setPadding(0, 0, 0, 0);
            view.requestLayout();
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerActivity$7 */
    class C26527 implements OnCompletionListener {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerActivity f10816a;

        C26527(VideoPlayerActivity videoPlayerActivity) {
            this.f10816a = videoPlayerActivity;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                this.f10816a.f10823b.setVisibility(8);
                this.f10816a.f10824c.setVisibility(0);
                this.f10816a.f10828g.mo2130b();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerActivity$8 */
    class C26538 implements OnPreparedListener {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerActivity f10817a;

        C26538(VideoPlayerActivity videoPlayerActivity) {
            this.f10817a = videoPlayerActivity;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            if (this.f10817a.f10824c != null) {
                this.f10817a.f10824c.setVisibility(8);
            }
            if (this.f10817a.f10828g != null) {
                this.f10817a.f10828g.mo2129a((long) this.f10817a.f10823b.getDuration());
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerActivity$9 */
    class C26549 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerActivity f10818a;

        C26549(VideoPlayerActivity videoPlayerActivity) {
            this.f10818a = videoPlayerActivity;
        }

        public void run() {
            if (this.f10818a.f10847z != null) {
                this.f10818a.m15210a(this.f10818a.f10847z);
                this.f10818a.f10847z = null;
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.act_video);
        this.f10819A = findViewById(R.id.main_con);
        this.f10847z = null;
        C3094j.m16698a("VideoPlayer", "START NAVIVE VIDEO PLAYER");
        this.f10837p = false;
        this.f10838q = (TextView) findViewById(R.id.txtSubtitles);
        this.f10823b = (SubtitleVideoView) findViewById(R.id.video_view);
        this.f10842u = findViewById(R.id.top_panel);
        this.f10841t = new C3086e(this.f10842u);
        this.f10841t.m16671a(false);
        if (VERSION.SDK_INT < 16) {
            LayoutParams layoutParams = (LayoutParams) this.f10842u.getLayoutParams();
            layoutParams.topMargin = 0;
            this.f10842u.setLayoutParams(layoutParams);
        }
        this.f10843v = (TextView) this.f10842u.findViewById(R.id.txtv_part);
        this.f10845x = this.f10842u.findViewById(R.id.view_next);
        this.f10844w = this.f10842u.findViewById(R.id.view_prev);
        this.f10823b.setmActivity(this);
        m15225s();
        this.f10824c = (ProgressBar) findViewById(R.id.load_progress_bar);
        this.f10835n = (RelativeLayout) findViewById(R.id.main_con);
        this.f10825d = getIntent().getStringExtra("VIDEO_URL");
        this.f10826e = getIntent().getLongExtra("ARG_ID", 0);
        this.f10827f = getIntent().getLongExtra("ARG_VIDEO_POSITION", 0);
        Bundle bundleExtra = getIntent().getBundleExtra("ARG_BUNDLE");
        this.f10829h = bundleExtra.getInt("ARG_TYPE_PLAY");
        this.f10830i = bundleExtra.getString("ARG_TITLE");
        this.f10831j = bundleExtra.getInt("ARG_QUALITY");
        this.f10832k = bundleExtra.getInt("ARG_SEASON_NUM");
        this.f10833l = bundleExtra.getLong("ARG_MOVE_ID");
        this.f10834m = bundleExtra.getLong("ARG_EPIZOD_ID");
        this.f10836o = bundleExtra.getString("ARG_SUBTITLES_ID");
        this.f10839r = false;
        switch (this.f10829h) {
            case 1:
                try {
                    this.f10828g = new C3083d(this.f10833l, this.f10832k, this.f10834m);
                    break;
                } catch (Exception e) {
                    m15219m();
                    return;
                }
            case 2:
                BaseVideoSource b = m15228b(this.f10826e, this.f10829h);
                DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + this.f10826e + " AND percent=100 AND is_movie=1").executeSingle();
                if (downloadEpisode != null) {
                    this.f10839r = true;
                }
                this.f10828g = new C3082c("" + this.f10833l, this.f10826e, b, downloadEpisode);
                break;
            case 3:
                this.f10828g = new C3081b(this.f10832k, this.f10834m, this.f10830i, this.f10836o);
                this.f10839r = true;
                break;
        }
        this.f10845x.setOnClickListener(new C26451(this));
        this.f10844w.setOnClickListener(new C26462(this));
        this.f10828g.m16656a((C2656a) this);
        this.f10828g.m16655a((Activity) this);
        this.f10828g.m16657a(this.f10825d);
        this.f10823b.setSubTitleView(this.f10838q);
        m15210a(this.f10825d);
        this.f10841t.m16671a(false);
    }

    /* renamed from: m */
    private void m15219m() {
        new Thread(new C26483(this)).start();
    }

    /* renamed from: a */
    public String m15226a(long j, int i) {
        BaseVideoSource baseVideoSource = null;
        if (i == 1) {
            BaseVideoSource videoSource;
            Episod episod = (Episod) new Select().from(Episod.class).where("ID=" + j).executeSingle();
            if (episod != null) {
                videoSource = episod.getVideoSource();
            } else {
                videoSource = null;
            }
            baseVideoSource = videoSource;
        } else if (i == 2) {
            MovieItem movieItem = (MovieItem) new Select().from(MovieItem.class).where("Id=" + j).executeSingle();
            if (movieItem != null) {
                baseVideoSource = MovieItem.getMovieItemMeta(movieItem).getVideoSource();
            }
        }
        if (baseVideoSource != null) {
            return baseVideoSource.getCookies();
        }
        return "";
    }

    /* renamed from: b */
    public BaseVideoSource m15228b(long j, int i) {
        if (i == 1) {
            BaseVideoSource videoSource;
            Episod episod = (Episod) new Select().from(Episod.class).where("ID=" + j).executeSingle();
            if (episod != null) {
                videoSource = episod.getVideoSource();
            } else {
                videoSource = null;
            }
            return videoSource;
        } else if (i != 2) {
            return null;
        } else {
            MovieItem movieItem = (MovieItem) new Select().from(MovieItem.class).where("Id=" + j).executeSingle();
            if (movieItem != null) {
                return MovieItem.getMovieItemMeta(movieItem).getVideoSource();
            }
            return null;
        }
    }

    /* renamed from: a */
    private void m15209a(final Subtitle subtitle) {
        Builder builder = new Builder(this);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ VideoPlayerActivity f10812b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f10812b.m15213b(subtitle);
            }
        });
        builder.setNegativeButton(R.string.no, null);
        builder.setMessage(R.string.label_enable_subtitles);
        builder.show();
    }

    /* renamed from: b */
    private void m15213b(Subtitle subtitle) {
        if (this.f10823b != null && subtitle != null) {
            this.f10823b.setSubTitleView(this.f10838q);
            try {
                this.f10823b.setSubtitleSource(new File(subtitle.getFile_en()));
                if (subtitle.getPartDelay() > 1000) {
                    this.f10823b.setmSubtitleDalay(subtitle.getPartDelay());
                }
                C3094j.m16698a("VideoActivity", "Sub delay: " + subtitle.getPartDelay());
                this.f10838q.setVisibility(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.f10838q != null) {
            this.f10838q.setVisibility(4);
        }
    }

    /* renamed from: n */
    private void m15220n() {
        Subtitle a = this.f10828g.mo2128a();
        if (!this.f10839r) {
            m15213b(this.f10828g.mo2128a());
        } else if (a != null) {
            m15209a(a);
        }
    }

    /* renamed from: a */
    private void m15210a(final String str) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    C3094j.m16698a("VideoActivity", "empty uri " + str);
                    finish();
                }
                m15220n();
                this.f10823b.requestFocus();
                this.f10823b.setVisibility(0);
                String a = m15226a(this.f10826e, this.f10829h);
                if (a == null || a.length() <= 0) {
                    this.f10823b.setVideoURI(Uri.parse(str));
                } else {
                    Map hashMap = new HashMap();
                    hashMap.put("Cookie", a);
                    this.f10823b.m17354a(Uri.parse(str), hashMap);
                }
                C3094j.m16698a("VideoActivity", "uri: " + str);
                C3094j.m16698a("VideoActivity", "cookies: " + a);
                if (this.f10846y != null) {
                    this.f10846y.setMediaControllerListener(null);
                }
                this.f10846y = new C3304b(this);
                this.f10846y.addOnAttachStateChangeListener(new C26505(this));
                this.f10846y.setMediaControllerListener(this);
                this.f10823b.setMediaController(this.f10846y);
                this.f10823b.setOnErrorListener(new OnErrorListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ VideoPlayerActivity f10815b;

                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (C3178f.m16973b(this.f10815b)) {
                            this.f10815b.finish();
                            try {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                                intent.setDataAndType(Uri.parse(str), "video/*");
                                this.f10815b.startActivityForResult(intent, 1113);
                            } catch (Exception e) {
                            }
                        }
                        return false;
                    }
                });
                this.f10823b.setOnCompletionListener(new C26527(this));
                this.f10823b.setOnPreparedListener(new C26538(this));
                if (this.f10827f != 0) {
                    this.f10823b.seekTo((int) this.f10827f);
                }
                this.f10823b.start();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        C3094j.m16698a("VideoActivity", "uri == null");
    }

    /* renamed from: o */
    private void m15221o() {
        if (VERSION.SDK_INT >= 16) {
            int a;
            if (getResources().getConfiguration().orientation == 2) {
                this.f10822D = 0;
                a = C3184j.m16980a((Context) this, 62);
            } else {
                this.f10822D = C3184j.m16980a((Context) this, 50);
                a = 0;
            }
            if (this.f10821C != null) {
                this.f10821C.setPadding(0, 0, 0, this.f10822D);
            }
            LayoutParams layoutParams = (LayoutParams) this.f10845x.getLayoutParams();
            layoutParams.rightMargin = a;
            this.f10845x.setLayoutParams(layoutParams);
            if (this.f10821C != null) {
                this.f10821C.requestLayout();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m15221o();
    }

    public void onBackPressed() {
        try {
            this.f10837p = true;
            int currentPosition = this.f10823b.getCurrentPosition();
            Intent intent = getIntent();
            intent.putExtra("ARG_VIDEO_POSITION", currentPosition);
            intent.putExtra("ARG_VIDEO_PART_NUMBER", 0);
            intent.putExtra("ARG_ID", this.f10826e);
            setResult(-1, intent);
        } catch (Exception e) {
        }
        super.onBackPressed();
    }

    protected void onDestroy() {
        this.f10823b.setmActivity(null);
        m15235i();
        m15224r();
        super.onDestroy();
    }

    /* renamed from: i */
    public void m15235i() {
        this.f10823b.m17353a();
        this.f10835n.removeAllViews();
        C3184j.m16984a(this.f10823b);
        C3184j.m16984a(this.f10835n);
        this.f10823b = null;
    }

    /* renamed from: a */
    public void mo2022a(String str, boolean z, long j, long j2, int i) {
        long j3 = this.f10826e;
        if (!this.f10837p) {
            if (j != -1) {
                this.f10826e = j;
            }
            this.f10827f = 0;
            if (str == null || str.length() == 0) {
                m15206a(j);
            } else {
                if (j2 != -1) {
                    this.f10827f = j2;
                }
                m15214b(str);
            }
            this.f10845x.setVisibility(0);
            this.f10844w.setVisibility(0);
            if (i == 2) {
                this.f10845x.setVisibility(4);
            } else if (i == 3) {
                this.f10844w.setVisibility(4);
            }
            this.f10841t.m16671a(false);
        }
    }

    /* renamed from: b */
    private void m15214b(String str) {
        this.f10847z = str;
        m15076a().m16467a(true, "next_video__");
    }

    /* renamed from: a */
    private void m15206a(long j) {
        try {
            Intent intent = getIntent();
            intent.putExtra("ARG_URL_FAIL_ID", j);
            setResult(-1, intent);
        } catch (Exception e) {
        }
        finish();
    }

    /* renamed from: j */
    public void mo2023j() {
        try {
            Intent intent = getIntent();
            intent.putExtra("ARG_VIDEO_POSITION", 0);
            intent.putExtra("ARG_ID", this.f10826e);
            setResult(-1, intent);
        } catch (Exception e) {
        }
        finish();
    }

    /* renamed from: p */
    private void m15222p() {
        this.f10820B = (this.f10820B | 4) | 2;
        this.f10819A.setSystemUiVisibility(this.f10820B);
    }

    /* renamed from: q */
    private void m15223q() {
        this.f10820B = (this.f10820B & -5) & -3;
        this.f10819A.setSystemUiVisibility(this.f10820B);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: r */
    private void m15224r() {
        if (VERSION.SDK_INT >= 16) {
            getWindow().getDecorView().setSystemUiVisibility(this.f10840s);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: s */
    private void m15225s() {
        if (VERSION.SDK_INT >= 16) {
            this.f10840s = getWindow().getDecorView().getSystemUiVisibility();
        }
    }

    /* renamed from: k */
    public void mo2024k() {
        if (this.f10841t != null) {
            this.f10841t.m16670a();
        }
        m15223q();
    }

    /* renamed from: l */
    public void mo2025l() {
        if (this.f10841t != null) {
            this.f10841t.m16672b();
        }
        m15222p();
    }

    /* renamed from: c */
    public void mo2005c() {
        runOnUiThread(new C26549(this));
    }

    /* renamed from: d */
    public void mo1997d() {
        mo2004b().m16493e();
    }

    /* renamed from: e */
    public void mo1998e() {
        mo2005c();
    }

    /* renamed from: f */
    public void mo1999f() {
        C3065b.m16568a("__ads_inter_timeout__");
        mo2005c();
    }

    /* renamed from: g */
    public void mo2000g() {
    }

    /* renamed from: h */
    public void mo2001h() {
    }
}
