package com.tdo.showbox.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
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
import com.tdo.showbox.views.SubtitleIjkVideoView;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;

public class VideoPlayerIjkActivity extends C2631a implements C2655c, C2656a {
    /* renamed from: A */
    private View f10860A;
    /* renamed from: B */
    private int f10861B = 1536;
    /* renamed from: C */
    private View f10862C;
    /* renamed from: D */
    private int f10863D;
    /* renamed from: b */
    private SubtitleIjkVideoView f10864b;
    /* renamed from: c */
    private ProgressBar f10865c;
    /* renamed from: d */
    private String f10866d;
    /* renamed from: e */
    private long f10867e;
    /* renamed from: f */
    private long f10868f;
    /* renamed from: g */
    private C3079a f10869g;
    /* renamed from: h */
    private int f10870h;
    /* renamed from: i */
    private String f10871i;
    /* renamed from: j */
    private int f10872j;
    /* renamed from: k */
    private int f10873k;
    /* renamed from: l */
    private long f10874l;
    /* renamed from: m */
    private long f10875m;
    /* renamed from: n */
    private RelativeLayout f10876n;
    /* renamed from: o */
    private String f10877o;
    /* renamed from: p */
    private boolean f10878p;
    /* renamed from: q */
    private TextView f10879q;
    /* renamed from: r */
    private boolean f10880r;
    /* renamed from: s */
    private int f10881s;
    /* renamed from: t */
    private C3086e f10882t;
    /* renamed from: u */
    private View f10883u;
    /* renamed from: v */
    private TextView f10884v;
    /* renamed from: w */
    private View f10885w;
    /* renamed from: x */
    private View f10886x;
    /* renamed from: y */
    private String f10887y;
    /* renamed from: z */
    private C3304b f10888z;

    /* renamed from: com.tdo.showbox.activities.VideoPlayerIjkActivity$1 */
    class C26571 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerIjkActivity f10848a;

        C26571(VideoPlayerIjkActivity videoPlayerIjkActivity) {
            this.f10848a = videoPlayerIjkActivity;
        }

        public void onClick(View view) {
            if (this.f10848a.f10865c.getVisibility() != 0) {
                this.f10848a.f10864b.setVisibility(8);
                this.f10848a.f10865c.setVisibility(0);
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerIjkActivity$2 */
    class C26582 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerIjkActivity f10849a;

        C26582(VideoPlayerIjkActivity videoPlayerIjkActivity) {
            this.f10849a = videoPlayerIjkActivity;
        }

        public void onClick(View view) {
            if (this.f10849a.f10865c.getVisibility() != 0) {
                this.f10849a.f10864b.setVisibility(8);
                this.f10849a.f10865c.setVisibility(0);
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerIjkActivity$3 */
    class C26603 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerIjkActivity f10851a;

        /* renamed from: com.tdo.showbox.activities.VideoPlayerIjkActivity$3$1 */
        class C26591 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C26603 f10850a;

            C26591(C26603 c26603) {
                this.f10850a = c26603;
            }

            public void run() {
                this.f10850a.f10851a.finish();
            }
        }

        C26603(VideoPlayerIjkActivity videoPlayerIjkActivity) {
            this.f10851a = videoPlayerIjkActivity;
        }

        public void run() {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.f10851a.runOnUiThread(new C26591(this));
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerIjkActivity$5 */
    class C26625 implements OnAttachStateChangeListener {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerIjkActivity f10854a;

        C26625(VideoPlayerIjkActivity videoPlayerIjkActivity) {
            this.f10854a = videoPlayerIjkActivity;
        }

        public void onViewAttachedToWindow(View view) {
            this.f10854a.f10862C = view;
            this.f10854a.m15256o();
        }

        public void onViewDetachedFromWindow(View view) {
            this.f10854a.m15257p();
            view.setPadding(0, 0, 0, 0);
            view.requestLayout();
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerIjkActivity$7 */
    class C26647 implements OnCompletionListener {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerIjkActivity f10857a;

        C26647(VideoPlayerIjkActivity videoPlayerIjkActivity) {
            this.f10857a = videoPlayerIjkActivity;
        }

        public void onCompletion(IMediaPlayer iMediaPlayer) {
            try {
                this.f10857a.f10864b.setVisibility(8);
                this.f10857a.f10869g.mo2130b();
                this.f10857a.f10865c.setVisibility(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerIjkActivity$8 */
    class C26658 implements OnPreparedListener {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerIjkActivity f10858a;

        C26658(VideoPlayerIjkActivity videoPlayerIjkActivity) {
            this.f10858a = videoPlayerIjkActivity;
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
            if (this.f10858a.f10865c != null) {
                this.f10858a.f10865c.setVisibility(8);
            }
            if (this.f10858a.f10869g != null) {
                this.f10858a.f10869g.mo2129a((long) this.f10858a.f10864b.getDuration());
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.VideoPlayerIjkActivity$9 */
    class C26669 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ VideoPlayerIjkActivity f10859a;

        C26669(VideoPlayerIjkActivity videoPlayerIjkActivity) {
            this.f10859a = videoPlayerIjkActivity;
        }

        public void run() {
            if (this.f10859a.f10887y != null) {
                this.f10859a.m15245a(this.f10859a.f10887y);
                this.f10859a.f10887y = null;
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.act_video_ijk);
        this.f10887y = null;
        this.f10860A = findViewById(R.id.main_con);
        C3094j.m16698a("VideoPlayer", "START VLC VIDEO PLAYER");
        this.f10878p = false;
        this.f10879q = (TextView) findViewById(R.id.txtSubtitles);
        this.f10864b = (SubtitleIjkVideoView) findViewById(R.id.video_view);
        this.f10883u = findViewById(R.id.top_panel);
        if (VERSION.SDK_INT < 16) {
            LayoutParams layoutParams = (LayoutParams) this.f10883u.getLayoutParams();
            layoutParams.topMargin = 0;
            this.f10883u.setLayoutParams(layoutParams);
        }
        this.f10882t = new C3086e(this.f10883u);
        this.f10882t.m16671a(false);
        this.f10884v = (TextView) this.f10883u.findViewById(R.id.txtv_part);
        this.f10886x = this.f10883u.findViewById(R.id.view_next);
        this.f10885w = this.f10883u.findViewById(R.id.view_prev);
        this.f10864b.setmActivity(this);
        m15260s();
        this.f10865c = (ProgressBar) findViewById(R.id.load_progress_bar);
        this.f10876n = (RelativeLayout) findViewById(R.id.main_con);
        this.f10866d = getIntent().getStringExtra("VIDEO_URL");
        this.f10867e = getIntent().getLongExtra("ARG_ID", 0);
        this.f10868f = getIntent().getLongExtra("ARG_VIDEO_POSITION", 0);
        Bundle bundleExtra = getIntent().getBundleExtra("ARG_BUNDLE");
        this.f10870h = bundleExtra.getInt("ARG_TYPE_PLAY");
        this.f10871i = bundleExtra.getString("ARG_TITLE");
        this.f10872j = bundleExtra.getInt("ARG_QUALITY");
        this.f10873k = bundleExtra.getInt("ARG_SEASON_NUM");
        this.f10874l = bundleExtra.getLong("ARG_MOVE_ID");
        this.f10875m = bundleExtra.getLong("ARG_EPIZOD_ID");
        this.f10877o = bundleExtra.getString("ARG_SUBTITLES_ID");
        this.f10880r = false;
        switch (this.f10870h) {
            case 1:
                try {
                    this.f10869g = new C3083d(this.f10874l, this.f10873k, this.f10875m);
                    break;
                } catch (Exception e) {
                    m15254m();
                    return;
                }
            case 2:
                BaseVideoSource b = m15263b(this.f10867e, this.f10870h);
                DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + this.f10867e + " AND percent=100 AND is_movie=1").executeSingle();
                if (downloadEpisode != null) {
                    this.f10880r = true;
                }
                this.f10869g = new C3082c("" + this.f10874l, this.f10867e, b, downloadEpisode);
                break;
            case 3:
                this.f10869g = new C3081b(this.f10873k, this.f10875m, this.f10871i, this.f10877o);
                this.f10880r = true;
                break;
        }
        this.f10886x.setOnClickListener(new C26571(this));
        this.f10885w.setOnClickListener(new C26582(this));
        this.f10869g.m16656a((C2656a) this);
        this.f10869g.m16655a((Activity) this);
        this.f10869g.m16657a(this.f10866d);
        this.f10864b.setSubTitleView(this.f10879q);
        m15245a(this.f10866d);
        this.f10882t.m16671a(false);
    }

    /* renamed from: m */
    private void m15254m() {
        new Thread(new C26603(this)).start();
    }

    /* renamed from: a */
    public String m15261a(long j, int i) {
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
    public BaseVideoSource m15263b(long j, int i) {
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
    private void m15244a(final Subtitle subtitle) {
        Builder builder = new Builder(this);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ VideoPlayerIjkActivity f10853b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f10853b.m15248b(subtitle);
            }
        });
        builder.setNegativeButton(R.string.no, null);
        builder.setMessage(R.string.label_enable_subtitles);
        builder.show();
    }

    /* renamed from: b */
    private void m15248b(Subtitle subtitle) {
        if (this.f10864b != null && subtitle != null) {
            this.f10864b.setSubTitleView(this.f10879q);
            try {
                this.f10864b.setSubtitleSource(new File(subtitle.getFile_en()));
                if (subtitle.getPartDelay() > 1000) {
                    this.f10864b.setmSubtitleDalay(subtitle.getPartDelay());
                }
                C3094j.m16698a("VideoActivity", "Sub delay: " + subtitle.getPartDelay());
                this.f10879q.setVisibility(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.f10879q != null) {
            this.f10879q.setVisibility(4);
        }
    }

    /* renamed from: n */
    private void m15255n() {
        Subtitle a = this.f10869g.mo2128a();
        if (!this.f10880r) {
            m15248b(this.f10869g.mo2128a());
        } else if (a != null) {
            m15244a(a);
        }
    }

    /* renamed from: a */
    private void m15245a(final String str) {
        if (str != null) {
            try {
                if (str.length() == 0) {
                    C3094j.m16698a("VideoActivity", "empty uri " + str);
                    finish();
                }
                String replace = str.replace("https://", "http://");
                m15255n();
                this.f10864b.requestFocus();
                this.f10864b.setVisibility(0);
                String a = m15261a(this.f10867e, this.f10870h);
                if (a == null || a.length() <= 0) {
                    this.f10864b.setVideoURI(Uri.parse(replace));
                } else {
                    Map hashMap = new HashMap();
                    hashMap.put("Cookie", a);
                    this.f10864b.m17304a(Uri.parse(replace), hashMap);
                }
                C3094j.m16698a("VideoActivity", "uri: " + replace);
                C3094j.m16698a("VideoActivity", "cookies: " + a);
                if (this.f10888z != null) {
                    this.f10888z.setMediaControllerListener(null);
                }
                this.f10888z = new C3304b(this);
                this.f10888z.addOnAttachStateChangeListener(new C26625(this));
                this.f10888z.setMediaControllerListener(this);
                this.f10864b.setMediaController(this.f10888z);
                this.f10864b.setOnErrorListener(new OnErrorListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ VideoPlayerIjkActivity f10856b;

                    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                        if (C3178f.m16973b(this.f10856b)) {
                            this.f10856b.finish();
                            try {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                                intent.setDataAndType(Uri.parse(str), "video/*");
                                this.f10856b.startActivityForResult(intent, 1113);
                            } catch (Exception e) {
                            }
                        }
                        return false;
                    }
                });
                this.f10864b.setOnCompletionListener(new C26647(this));
                this.f10864b.setOnPreparedListener(new C26658(this));
                if (this.f10868f != 0) {
                    this.f10864b.seekTo((int) this.f10868f);
                }
                this.f10864b.start();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        C3094j.m16698a("VideoActivity", "uri == null");
    }

    /* renamed from: o */
    private void m15256o() {
        if (VERSION.SDK_INT >= 16) {
            int a;
            if (getResources().getConfiguration().orientation == 2) {
                this.f10863D = 0;
                a = C3184j.m16980a((Context) this, 62);
            } else {
                this.f10863D = C3184j.m16980a((Context) this, 50);
                a = 0;
            }
            if (this.f10862C != null) {
                this.f10862C.setPadding(0, 0, 0, this.f10863D);
            }
            LayoutParams layoutParams = (LayoutParams) this.f10886x.getLayoutParams();
            layoutParams.rightMargin = a;
            this.f10886x.setLayoutParams(layoutParams);
            if (this.f10862C != null) {
                this.f10862C.requestLayout();
            }
        }
    }

    /* renamed from: p */
    private void m15257p() {
        this.f10861B = (this.f10861B | 4) | 2;
        this.f10860A.setSystemUiVisibility(this.f10861B);
    }

    /* renamed from: q */
    private void m15258q() {
        this.f10861B = (this.f10861B & -5) & -3;
        this.f10860A.setSystemUiVisibility(this.f10861B);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m15256o();
    }

    public void onBackPressed() {
        try {
            this.f10878p = true;
            int currentPosition = this.f10864b.getCurrentPosition();
            Intent intent = getIntent();
            intent.putExtra("ARG_VIDEO_POSITION", currentPosition);
            intent.putExtra("ARG_VIDEO_PART_NUMBER", 0);
            intent.putExtra("ARG_ID", this.f10867e);
            setResult(-1, intent);
        } catch (Exception e) {
        }
        super.onBackPressed();
    }

    protected void onDestroy() {
        this.f10864b.setmActivity(null);
        m15270i();
        m15259r();
        super.onDestroy();
    }

    /* renamed from: i */
    public void m15270i() {
        this.f10864b.m17303a();
        this.f10876n.removeAllViews();
        C3184j.m16984a(this.f10864b);
        C3184j.m16984a(this.f10876n);
        this.f10864b = null;
    }

    /* renamed from: a */
    public void mo2022a(String str, boolean z, long j, long j2, int i) {
        long j3 = this.f10867e;
        if (!this.f10878p) {
            if (j != -1) {
                this.f10867e = j;
            }
            this.f10868f = 0;
            if (str == null || str.length() == 0) {
                m15241a(j);
            } else {
                if (j2 != -1) {
                    this.f10868f = j2;
                }
                m15249b(str);
            }
            this.f10886x.setVisibility(0);
            this.f10885w.setVisibility(0);
            if (i == 2) {
                this.f10886x.setVisibility(4);
            } else if (i == 3) {
                this.f10885w.setVisibility(4);
            }
            this.f10882t.m16671a(false);
        }
    }

    /* renamed from: a */
    private void m15241a(long j) {
        try {
            Intent intent = getIntent();
            intent.putExtra("ARG_URL_FAIL_ID", j);
            setResult(-1, intent);
        } catch (Exception e) {
        }
        finish();
    }

    /* renamed from: b */
    private void m15249b(String str) {
        this.f10887y = str;
        m15076a().m16467a(true, "next_video__");
    }

    /* renamed from: j */
    public void mo2023j() {
        try {
            Intent intent = getIntent();
            intent.putExtra("ARG_VIDEO_POSITION", 0);
            intent.putExtra("ARG_ID", this.f10867e);
            setResult(-1, intent);
        } catch (Exception e) {
        }
        finish();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: r */
    private void m15259r() {
        if (VERSION.SDK_INT >= 16) {
            getWindow().getDecorView().setSystemUiVisibility(this.f10881s);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: s */
    private void m15260s() {
        if (VERSION.SDK_INT >= 16) {
            this.f10881s = getWindow().getDecorView().getSystemUiVisibility();
        }
    }

    /* renamed from: k */
    public void mo2024k() {
        if (this.f10882t != null) {
            this.f10882t.m16670a();
        }
        m15258q();
    }

    /* renamed from: l */
    public void mo2025l() {
        if (this.f10882t != null) {
            this.f10882t.m16672b();
        }
        m15257p();
    }

    /* renamed from: c */
    public void mo2005c() {
        runOnUiThread(new C26669(this));
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
