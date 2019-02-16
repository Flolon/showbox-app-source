package com.tdo.showbox.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.Html;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.TextView;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.models.Phrase;
import com.tdo.showbox.p131f.C3176e;
import com.tdo.showbox.p131f.C3181h;
import com.tdo.showbox.p131f.C3184j;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@SuppressLint({"NewApi"})
public class SubtitleIjkVideoView extends SurfaceView implements MediaPlayerControl {
    /* renamed from: A */
    private boolean f12599A;
    /* renamed from: B */
    private boolean f12600B;
    /* renamed from: C */
    private Context f12601C;
    /* renamed from: D */
    private int f12602D;
    /* renamed from: E */
    private TextView f12603E;
    /* renamed from: F */
    private boolean f12604F;
    /* renamed from: G */
    private C3273a f12605G;
    /* renamed from: H */
    private String f12606H;
    /* renamed from: I */
    private long f12607I;
    /* renamed from: J */
    private Activity f12608J;
    /* renamed from: K */
    private OnCompletionListener f12609K;
    /* renamed from: L */
    private OnErrorListener f12610L;
    /* renamed from: M */
    private OnBufferingUpdateListener f12611M;
    /* renamed from: a */
    OnVideoSizeChangedListener f12612a;
    /* renamed from: b */
    OnPreparedListener f12613b;
    /* renamed from: c */
    Callback f12614c;
    /* renamed from: d */
    Runnable f12615d;
    /* renamed from: e */
    private ArrayList<Phrase> f12616e;
    /* renamed from: f */
    private String f12617f;
    /* renamed from: g */
    private Uri f12618g;
    /* renamed from: h */
    private Map<String, String> f12619h;
    /* renamed from: i */
    private int f12620i;
    /* renamed from: j */
    private int f12621j;
    /* renamed from: k */
    private int f12622k;
    /* renamed from: l */
    private SurfaceHolder f12623l;
    /* renamed from: m */
    private IjkMediaPlayer f12624m;
    /* renamed from: n */
    private int f12625n;
    /* renamed from: o */
    private int f12626o;
    /* renamed from: p */
    private int f12627p;
    /* renamed from: q */
    private int f12628q;
    /* renamed from: r */
    private OnBufferingUpdateListener f12629r;
    /* renamed from: s */
    private MediaController f12630s;
    /* renamed from: t */
    private OnCompletionListener f12631t;
    /* renamed from: u */
    private OnPreparedListener f12632u;
    /* renamed from: v */
    private int f12633v;
    /* renamed from: w */
    private OnErrorListener f12634w;
    /* renamed from: x */
    private OnInfoListener f12635x;
    /* renamed from: y */
    private int f12636y;
    /* renamed from: z */
    private boolean f12637z;

    /* renamed from: com.tdo.showbox.views.SubtitleIjkVideoView$1 */
    class C32611 implements OnVideoSizeChangedListener {
        /* renamed from: a */
        final /* synthetic */ SubtitleIjkVideoView f12583a;

        C32611(SubtitleIjkVideoView subtitleIjkVideoView) {
            this.f12583a = subtitleIjkVideoView;
        }

        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            this.f12583a.f12625n = iMediaPlayer.getVideoWidth();
            this.f12583a.f12626o = iMediaPlayer.getVideoHeight();
            if (this.f12583a.f12625n != 0 && this.f12583a.f12626o != 0) {
                this.f12583a.getHolder().setFixedSize(this.f12583a.f12625n, this.f12583a.f12626o);
                this.f12583a.requestLayout();
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleIjkVideoView$b */
    private interface C3262b {
        /* renamed from: a */
        void mo2165a();
    }

    /* renamed from: com.tdo.showbox.views.SubtitleIjkVideoView$4 */
    class C32674 implements OnPreparedListener {
        /* renamed from: a */
        final /* synthetic */ SubtitleIjkVideoView f12591a;

        C32674(SubtitleIjkVideoView subtitleIjkVideoView) {
            this.f12591a = subtitleIjkVideoView;
        }

        public void onPrepared(IMediaPlayer iMediaPlayer) {
            this.f12591a.f12621j = 2;
            this.f12591a.m17284e();
            this.f12591a.f12637z = this.f12591a.f12599A = this.f12591a.f12600B = true;
            if (this.f12591a.f12632u != null) {
                this.f12591a.f12632u.onPrepared(this.f12591a.f12624m);
            }
            if (this.f12591a.f12630s != null) {
                this.f12591a.f12630s.setEnabled(true);
            }
            this.f12591a.f12625n = iMediaPlayer.getVideoWidth();
            this.f12591a.f12626o = iMediaPlayer.getVideoHeight();
            int g = this.f12591a.f12636y;
            if (g != 0) {
                this.f12591a.seekTo(g);
            }
            if (this.f12591a.f12625n != 0 && this.f12591a.f12626o != 0) {
                this.f12591a.getHolder().setFixedSize(this.f12591a.f12625n, this.f12591a.f12626o);
                if (this.f12591a.f12627p != this.f12591a.f12625n || this.f12591a.f12628q != this.f12591a.f12626o) {
                    return;
                }
                if (this.f12591a.f12622k == 3) {
                    this.f12591a.start();
                    if (this.f12591a.f12630s != null) {
                        this.f12591a.f12630s.show();
                        this.f12591a.m17284e();
                    }
                } else if (!this.f12591a.isPlaying()) {
                    if ((g != 0 || this.f12591a.getCurrentPosition() > 0) && this.f12591a.f12630s != null) {
                        this.f12591a.f12630s.show(0);
                        this.f12591a.m17284e();
                    }
                }
            } else if (this.f12591a.f12622k == 3) {
                this.f12591a.start();
                this.f12591a.m17284e();
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleIjkVideoView$5 */
    class C32685 implements OnCompletionListener {
        /* renamed from: a */
        final /* synthetic */ SubtitleIjkVideoView f12592a;

        C32685(SubtitleIjkVideoView subtitleIjkVideoView) {
            this.f12592a = subtitleIjkVideoView;
        }

        public void onCompletion(IMediaPlayer iMediaPlayer) {
            this.f12592a.f12621j = 5;
            this.f12592a.f12622k = 5;
            if (this.f12592a.f12630s != null) {
                this.f12592a.f12630s.hide();
                this.f12592a.m17284e();
            }
            if (this.f12592a.f12631t != null) {
                this.f12592a.f12631t.onCompletion(this.f12592a.f12624m);
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleIjkVideoView$6 */
    class C32696 implements OnErrorListener {
        /* renamed from: a */
        final /* synthetic */ SubtitleIjkVideoView f12593a;

        C32696(SubtitleIjkVideoView subtitleIjkVideoView) {
            this.f12593a = subtitleIjkVideoView;
        }

        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (i == 1 || i2 == -1004) {
                this.f12593a.m17266a(true);
                this.f12593a.f12602D = this.f12593a.f12602D + 1;
                if (this.f12593a.f12602D > 30) {
                    this.f12593a.f12602D = 0;
                } else {
                    this.f12593a.f12621j = 0;
                    this.f12593a.f12622k = 0;
                    this.f12593a.f12621j = 3;
                    this.f12593a.f12622k = 3;
                    this.f12593a.m17275c();
                    return false;
                }
            }
            this.f12593a.f12602D = 0;
            this.f12593a.f12621j = -1;
            this.f12593a.f12622k = -1;
            if (this.f12593a.f12630s != null) {
                this.f12593a.f12630s.hide();
                this.f12593a.m17284e();
            }
            return (this.f12593a.f12634w == null || !this.f12593a.f12634w.onError(this.f12593a.f12624m, i, i2)) ? true : true;
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleIjkVideoView$7 */
    class C32707 implements OnBufferingUpdateListener {
        /* renamed from: a */
        final /* synthetic */ SubtitleIjkVideoView f12594a;

        C32707(SubtitleIjkVideoView subtitleIjkVideoView) {
            this.f12594a = subtitleIjkVideoView;
        }

        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            this.f12594a.f12633v = i;
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleIjkVideoView$8 */
    class C32718 implements Callback {
        /* renamed from: a */
        final /* synthetic */ SubtitleIjkVideoView f12595a;

        C32718(SubtitleIjkVideoView subtitleIjkVideoView) {
            this.f12595a = subtitleIjkVideoView;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Object obj = 1;
            this.f12595a.f12627p = i2;
            this.f12595a.f12628q = i3;
            Object obj2 = this.f12595a.f12622k == 3 ? 1 : null;
            if (!(this.f12595a.f12625n == i2 && this.f12595a.f12626o == i3)) {
                obj = null;
            }
            if (this.f12595a.f12624m != null && obj2 != null && r1 != null) {
                if (this.f12595a.f12636y != 0) {
                    this.f12595a.seekTo(this.f12595a.f12636y);
                }
                this.f12595a.start();
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f12595a.f12623l = surfaceHolder;
            this.f12595a.m17275c();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f12595a.f12623l = null;
            if (this.f12595a.f12630s != null) {
                this.f12595a.f12630s.hide();
            }
            this.f12595a.m17266a(true);
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleIjkVideoView$9 */
    class C32729 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SubtitleIjkVideoView f12596a;

        C32729(SubtitleIjkVideoView subtitleIjkVideoView) {
            this.f12596a = subtitleIjkVideoView;
        }

        public void run() {
            if (VERSION.SDK_INT >= 16) {
                this.f12596a.getmActivity().getWindow().getDecorView().setSystemUiVisibility(4102);
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleIjkVideoView$a */
    private class C3273a extends Thread {
        /* renamed from: a */
        final /* synthetic */ SubtitleIjkVideoView f12597a;
        /* renamed from: b */
        private volatile IMediaPlayer f12598b;

        private C3273a(SubtitleIjkVideoView subtitleIjkVideoView) {
            this.f12597a = subtitleIjkVideoView;
        }

        public void run() {
            super.run();
            while (this.f12597a.m17273b(this.f12598b)) {
                try {
                    C3273a.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: a */
        public void m17258a(IMediaPlayer iMediaPlayer) {
            this.f12598b = iMediaPlayer;
        }
    }

    public Activity getmActivity() {
        return this.f12608J;
    }

    public void setmActivity(Activity activity) {
        this.f12608J = activity;
    }

    public SubtitleIjkVideoView(Context context) {
        super(context);
        this.f12616e = new ArrayList();
        this.f12617f = "VideoView";
        this.f12621j = 0;
        this.f12622k = 0;
        this.f12623l = null;
        this.f12624m = null;
        this.f12604F = true;
        this.f12612a = new C32611(this);
        this.f12613b = new C32674(this);
        this.f12609K = new C32685(this);
        this.f12610L = new C32696(this);
        this.f12611M = new C32707(this);
        this.f12614c = new C32718(this);
        this.f12615d = new C32729(this);
        this.f12601C = context;
        m17271b();
    }

    public SubtitleIjkVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.f12601C = context;
        m17271b();
    }

    public SubtitleIjkVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12616e = new ArrayList();
        this.f12617f = "VideoView";
        this.f12621j = 0;
        this.f12622k = 0;
        this.f12623l = null;
        this.f12624m = null;
        this.f12604F = true;
        this.f12612a = new C32611(this);
        this.f12613b = new C32674(this);
        this.f12609K = new C32685(this);
        this.f12610L = new C32696(this);
        this.f12611M = new C32707(this);
        this.f12614c = new C32718(this);
        this.f12615d = new C32729(this);
        this.f12601C = context;
        m17271b();
    }

    public long getmSubtitleDalay() {
        return this.f12607I;
    }

    public void setmSubtitleDalay(long j) {
        this.f12607I = j;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.f12625n, i);
        int defaultSize2 = getDefaultSize(this.f12626o, i2);
        if (this.f12625n > 0 && this.f12626o > 0) {
            if (this.f12625n * defaultSize2 > this.f12626o * defaultSize) {
                defaultSize2 = (this.f12626o * defaultSize) / this.f12625n;
            } else if (this.f12625n * defaultSize2 < this.f12626o * defaultSize) {
                defaultSize = (this.f12625n * defaultSize2) / this.f12626o;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(FixedVideoView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(FixedVideoView.class.getName());
    }

    /* renamed from: b */
    private void m17271b() {
        this.f12625n = 0;
        this.f12626o = 0;
        getHolder().addCallback(this.f12614c);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f12621j = 0;
        this.f12622k = 0;
        this.f12602D = 0;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        m17304a(uri, null);
    }

    /* renamed from: a */
    public void m17304a(Uri uri, Map<String, String> map) {
        this.f12618g = uri;
        this.f12619h = map;
        this.f12636y = 0;
        m17275c();
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public void m17303a() {
        if (this.f12624m != null) {
            this.f12624m.stop();
            this.f12624m.release();
            this.f12624m = null;
        }
        this.f12621j = 0;
        this.f12622k = 0;
        if (this.f12623l != null) {
            this.f12623l.removeCallback(null);
            this.f12623l = null;
        }
        removeCallbacks(null);
        destroyDrawingCache();
        try {
            C3184j.m16985a((View) this, false);
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    private void m17275c() {
        if (this.f12618g != null && this.f12623l != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            this.f12601C.sendBroadcast(intent);
            m17266a(false);
            try {
                this.f12624m = new IjkMediaPlayer();
                m17265a(this.f12624m);
                this.f12624m.setOnBufferingUpdateListener(this.f12629r);
                this.f12624m.setOnPreparedListener(this.f12613b);
                this.f12624m.setOnVideoSizeChangedListener(this.f12612a);
                this.f12620i = -1;
                this.f12624m.setOnCompletionListener(this.f12609K);
                this.f12624m.setOnErrorListener(this.f12610L);
                this.f12624m.setOnInfoListener(this.f12635x);
                this.f12624m.setOnBufferingUpdateListener(this.f12611M);
                this.f12633v = 0;
                this.f12624m.setDataSource(this.f12601C, this.f12618g, this.f12619h);
                this.f12624m.setDisplay(this.f12623l);
                this.f12624m.setAudioStreamType(3);
                this.f12624m.setScreenOnWhilePlaying(true);
                this.f12624m.prepareAsync();
                this.f12621j = 1;
                m17280d();
            } catch (IOException e) {
                this.f12621j = -1;
                this.f12622k = -1;
                this.f12610L.onError(this.f12624m, 1, 0);
            } catch (IllegalArgumentException e2) {
                this.f12621j = -1;
                this.f12622k = -1;
                this.f12610L.onError(this.f12624m, 1, 0);
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        if (this.f12630s != null) {
            this.f12630s.hide();
            m17284e();
        }
        this.f12630s = mediaController;
        m17280d();
    }

    /* renamed from: d */
    private void m17280d() {
        if (this.f12624m != null && this.f12630s != null) {
            View view;
            this.f12630s.setMediaPlayer(this);
            if (getParent() instanceof View) {
                view = (View) getParent();
            } else {
                view = this;
            }
            this.f12630s.setAnchorView(view);
            this.f12630s.setEnabled(m17290g());
        }
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.f12632u = onPreparedListener;
    }

    public void setOnBufferUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f12611M = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.f12631t = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.f12634w = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.f12635x = onInfoListener;
    }

    /* renamed from: a */
    private void m17266a(boolean z) {
        if (this.f12624m != null) {
            this.f12624m.reset();
            this.f12624m.release();
            this.f12624m = null;
            this.f12621j = 0;
            if (z) {
                this.f12622k = 0;
            }
        }
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.f12624m.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (m17290g() && this.f12630s != null) {
            m17287f();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (m17290g() && this.f12630s != null) {
            m17287f();
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (m17290g() && z && this.f12630s != null) {
            if (i == 79 || i == 85) {
                if (this.f12624m.isPlaying()) {
                    pause();
                    this.f12630s.show();
                    m17284e();
                    return true;
                }
                start();
                this.f12630s.hide();
                m17284e();
                return true;
            } else if (i == 126) {
                if (this.f12624m.isPlaying()) {
                    return true;
                }
                start();
                this.f12630s.hide();
                m17284e();
                return true;
            } else if (i != 86 && i != 127) {
                m17287f();
            } else if (!this.f12624m.isPlaying()) {
                return true;
            } else {
                pause();
                this.f12630s.show();
                m17284e();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    private void m17284e() {
        try {
            removeCallbacks(this.f12615d);
            postDelayed(this.f12615d, 5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onDetachedFromWindow() {
        try {
            removeCallbacks(this.f12615d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    /* renamed from: f */
    private void m17287f() {
        try {
            if (this.f12630s.isShowing()) {
                this.f12630s.hide();
                m17284e();
                return;
            }
            this.f12630s.show();
            m17284e();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IjkMediaPlayer getMediaPlayer() {
        return this.f12624m;
    }

    public void start() {
        if (m17290g()) {
            this.f12624m.start();
            this.f12621j = 3;
        }
        this.f12622k = 3;
    }

    public void pause() {
        if (m17290g() && this.f12624m.isPlaying()) {
            this.f12624m.pause();
            this.f12621j = 4;
        }
        this.f12622k = 4;
    }

    public int getDuration() {
        if (!m17290g()) {
            this.f12620i = -1;
            return this.f12620i;
        } else if (this.f12620i > 0) {
            return this.f12620i;
        } else {
            this.f12620i = (int) this.f12624m.getDuration();
            return this.f12620i;
        }
    }

    public int getCurrentPosition() {
        if (m17290g()) {
            return (int) this.f12624m.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (m17290g()) {
            this.f12624m.seekTo((long) i);
            this.f12636y = 0;
            return;
        }
        this.f12636y = i;
    }

    public boolean isPlaying() {
        return m17290g() && this.f12624m.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.f12624m != null) {
            return this.f12633v;
        }
        return 0;
    }

    /* renamed from: g */
    private boolean m17290g() {
        return (this.f12624m == null || this.f12621j == -1 || this.f12621j == 0 || this.f12621j == 1) ? false : true;
    }

    public boolean canPause() {
        return this.f12637z;
    }

    public boolean canSeekBackward() {
        return this.f12599A;
    }

    public boolean canSeekForward() {
        return this.f12600B;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public void setSubTitleView(TextView textView) {
        this.f12603E = textView;
        if (textView == null) {
            throw new RuntimeException("subtitle view can`t equals with null");
        }
    }

    public boolean getSubtitleVisable() {
        return this.f12604F;
    }

    public void setSubtitleSource(File file) throws IOException {
        InputStream fileInputStream = new FileInputStream(file);
        this.f12606H = C3181h.m16977a(C3176e.m16970b(new FileInputStream(file)));
        C3094j.m16698a("setSubtitleSource", "charSet.displayName " + this.f12606H);
        C3094j.m16698a("setSubtitleSource", "File: " + file.getAbsolutePath());
        m17302a(fileInputStream);
    }

    public void setSubtitleSource(final URL url) throws IOException {
        this.f12606H = null;
        new Thread(this) {
            /* renamed from: b */
            final /* synthetic */ SubtitleIjkVideoView f12580b;

            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setDoInput(true);
                    this.f12580b.m17302a(new BufferedInputStream(httpURLConnection.getInputStream()));
                } catch (Exception e) {
                }
            }
        }.start();
    }

    /* renamed from: a */
    public InputStream m17302a(InputStream inputStream) throws IOException {
        Reader inputStreamReader;
        this.f12616e.clear();
        if (this.f12606H == null) {
            inputStreamReader = new InputStreamReader(inputStream);
        } else if (this.f12606H.equalsIgnoreCase("MACCYRILLIC")) {
            inputStreamReader = new InputStreamReader(inputStream, "cp1256");
        } else {
            inputStreamReader = new InputStreamReader(inputStream, this.f12606H);
        }
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        new Thread(this) {
            /* renamed from: b */
            final /* synthetic */ SubtitleIjkVideoView f12582b;

            public void run() {
                try {
                    this.f12582b.m17264a(bufferedReader);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return inputStream;
    }

    /* renamed from: a */
    private void m17264a(BufferedReader bufferedReader) throws Exception {
        String str = "";
        String str2 = "";
        ArrayList arrayList = new ArrayList();
        String str3 = "";
        Object obj = null;
        while (true) {
            str3 = bufferedReader.readLine();
            if (str3 != null) {
                if (!str3.equals("")) {
                    obj = 1;
                } else if (obj != null) {
                    try {
                        final Phrase phrase = new Phrase(str, str2, arrayList, getmSubtitleDalay());
                        m17262a(new C3262b(this) {
                            /* renamed from: b */
                            final /* synthetic */ SubtitleIjkVideoView f12585b;

                            /* renamed from: a */
                            public void mo2165a() {
                                this.f12585b.f12616e.add(phrase);
                            }
                        });
                    } catch (Exception e) {
                    }
                    str = "";
                    str2 = "";
                    arrayList.clear();
                    obj = null;
                }
                if (str.equals("")) {
                    str = str3;
                } else if (str2.equals("")) {
                    str2 = str3;
                } else {
                    arrayList.add(str3);
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private synchronized void m17262a(C3262b c3262b) {
        c3262b.mo2165a();
    }

    /* renamed from: a */
    private void m17265a(IMediaPlayer iMediaPlayer) {
        if (this.f12605G == null) {
            this.f12605G = new C3273a();
            this.f12605G.start();
        }
        this.f12605G.m17258a(iMediaPlayer);
    }

    /* renamed from: b */
    private boolean m17273b(IMediaPlayer iMediaPlayer) {
        try {
            if (!this.f12604F || iMediaPlayer == null || this.f12603E == null) {
                return false;
            }
            if (!iMediaPlayer.isPlaying()) {
                return true;
            }
            final int currentPosition = (int) iMediaPlayer.getCurrentPosition();
            m17262a(new C3262b(this) {
                /* renamed from: b */
                final /* synthetic */ SubtitleIjkVideoView f12590b;

                /* renamed from: com.tdo.showbox.views.SubtitleIjkVideoView$3$2 */
                class C32652 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C32663 f12588a;

                    C32652(C32663 c32663) {
                        this.f12588a = c32663;
                    }

                    public void run() {
                        this.f12588a.f12590b.f12603E.setText("");
                    }
                }

                /* renamed from: a */
                public void mo2165a() {
                    Iterator it = this.f12590b.f12616e.iterator();
                    while (it.hasNext()) {
                        final Phrase phrase = (Phrase) it.next();
                        if (phrase.isCanShow((long) currentPosition)) {
                            this.f12590b.f12603E.post(new Runnable(this) {
                                /* renamed from: b */
                                final /* synthetic */ C32663 f12587b;

                                public void run() {
                                    this.f12587b.f12590b.f12603E.setText(Html.fromHtml(phrase.getContent()));
                                }
                            });
                            return;
                        }
                    }
                    this.f12590b.f12603E.post(new C32652(this));
                }
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
