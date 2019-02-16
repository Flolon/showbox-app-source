package com.tdo.showbox.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
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

@SuppressLint({"NewApi"})
public class SubtitleVideoView extends SurfaceView implements MediaPlayerControl {
    /* renamed from: A */
    private boolean f12658A;
    /* renamed from: B */
    private boolean f12659B;
    /* renamed from: C */
    private Context f12660C;
    /* renamed from: D */
    private int f12661D;
    /* renamed from: E */
    private TextView f12662E;
    /* renamed from: F */
    private boolean f12663F;
    /* renamed from: G */
    private C3286a f12664G;
    /* renamed from: H */
    private String f12665H;
    /* renamed from: I */
    private long f12666I;
    /* renamed from: J */
    private Activity f12667J;
    /* renamed from: K */
    private OnCompletionListener f12668K;
    /* renamed from: L */
    private OnErrorListener f12669L;
    /* renamed from: M */
    private OnBufferingUpdateListener f12670M;
    /* renamed from: a */
    OnVideoSizeChangedListener f12671a;
    /* renamed from: b */
    OnPreparedListener f12672b;
    /* renamed from: c */
    Callback f12673c;
    /* renamed from: d */
    Runnable f12674d;
    /* renamed from: e */
    private ArrayList<Phrase> f12675e;
    /* renamed from: f */
    private String f12676f;
    /* renamed from: g */
    private Uri f12677g;
    /* renamed from: h */
    private Map<String, String> f12678h;
    /* renamed from: i */
    private int f12679i;
    /* renamed from: j */
    private int f12680j;
    /* renamed from: k */
    private int f12681k;
    /* renamed from: l */
    private SurfaceHolder f12682l;
    /* renamed from: m */
    private MediaPlayer f12683m;
    /* renamed from: n */
    private int f12684n;
    /* renamed from: o */
    private int f12685o;
    /* renamed from: p */
    private int f12686p;
    /* renamed from: q */
    private int f12687q;
    /* renamed from: r */
    private OnBufferingUpdateListener f12688r;
    /* renamed from: s */
    private MediaController f12689s;
    /* renamed from: t */
    private OnCompletionListener f12690t;
    /* renamed from: u */
    private OnPreparedListener f12691u;
    /* renamed from: v */
    private int f12692v;
    /* renamed from: w */
    private OnErrorListener f12693w;
    /* renamed from: x */
    private OnInfoListener f12694x;
    /* renamed from: y */
    private int f12695y;
    /* renamed from: z */
    private boolean f12696z;

    /* renamed from: com.tdo.showbox.views.SubtitleVideoView$1 */
    class C32741 implements OnVideoSizeChangedListener {
        /* renamed from: a */
        final /* synthetic */ SubtitleVideoView f12642a;

        C32741(SubtitleVideoView subtitleVideoView) {
            this.f12642a = subtitleVideoView;
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            this.f12642a.f12684n = mediaPlayer.getVideoWidth();
            this.f12642a.f12685o = mediaPlayer.getVideoHeight();
            if (this.f12642a.f12684n != 0 && this.f12642a.f12685o != 0) {
                this.f12642a.getHolder().setFixedSize(this.f12642a.f12684n, this.f12642a.f12685o);
                this.f12642a.requestLayout();
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleVideoView$b */
    private interface C3275b {
        /* renamed from: a */
        void mo2167a();
    }

    /* renamed from: com.tdo.showbox.views.SubtitleVideoView$4 */
    class C32804 implements OnPreparedListener {
        /* renamed from: a */
        final /* synthetic */ SubtitleVideoView f12650a;

        C32804(SubtitleVideoView subtitleVideoView) {
            this.f12650a = subtitleVideoView;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            this.f12650a.f12680j = 2;
            this.f12650a.m17334e();
            this.f12650a.f12696z = this.f12650a.f12658A = this.f12650a.f12659B = true;
            if (this.f12650a.f12691u != null) {
                this.f12650a.f12691u.onPrepared(this.f12650a.f12683m);
            }
            if (this.f12650a.f12689s != null) {
                this.f12650a.f12689s.setEnabled(true);
            }
            this.f12650a.f12684n = mediaPlayer.getVideoWidth();
            this.f12650a.f12685o = mediaPlayer.getVideoHeight();
            int g = this.f12650a.f12695y;
            if (g != 0) {
                this.f12650a.seekTo(g);
            }
            if (this.f12650a.f12684n != 0 && this.f12650a.f12685o != 0) {
                this.f12650a.getHolder().setFixedSize(this.f12650a.f12684n, this.f12650a.f12685o);
                if (this.f12650a.f12686p != this.f12650a.f12684n || this.f12650a.f12687q != this.f12650a.f12685o) {
                    return;
                }
                if (this.f12650a.f12681k == 3) {
                    this.f12650a.start();
                    if (this.f12650a.f12689s != null) {
                        this.f12650a.f12689s.show();
                        this.f12650a.m17334e();
                    }
                } else if (!this.f12650a.isPlaying()) {
                    if ((g != 0 || this.f12650a.getCurrentPosition() > 0) && this.f12650a.f12689s != null) {
                        this.f12650a.f12689s.show(0);
                        this.f12650a.m17334e();
                    }
                }
            } else if (this.f12650a.f12681k == 3) {
                this.f12650a.start();
                this.f12650a.m17334e();
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleVideoView$5 */
    class C32815 implements OnCompletionListener {
        /* renamed from: a */
        final /* synthetic */ SubtitleVideoView f12651a;

        C32815(SubtitleVideoView subtitleVideoView) {
            this.f12651a = subtitleVideoView;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f12651a.f12680j = 5;
            this.f12651a.f12681k = 5;
            if (this.f12651a.f12689s != null) {
                this.f12651a.f12689s.hide();
                this.f12651a.m17334e();
            }
            if (this.f12651a.f12690t != null) {
                this.f12651a.f12690t.onCompletion(this.f12651a.f12683m);
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleVideoView$6 */
    class C32826 implements OnErrorListener {
        /* renamed from: a */
        final /* synthetic */ SubtitleVideoView f12652a;

        C32826(SubtitleVideoView subtitleVideoView) {
            this.f12652a = subtitleVideoView;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 1 || i2 == -1004) {
                this.f12652a.m17316a(true);
                this.f12652a.f12661D = this.f12652a.f12661D + 1;
                if (this.f12652a.f12661D > 30) {
                    this.f12652a.f12661D = 0;
                } else {
                    this.f12652a.f12680j = 0;
                    this.f12652a.f12681k = 0;
                    this.f12652a.f12680j = 3;
                    this.f12652a.f12681k = 3;
                    this.f12652a.m17325c();
                    return false;
                }
            }
            this.f12652a.f12661D = 0;
            this.f12652a.f12680j = -1;
            this.f12652a.f12681k = -1;
            if (this.f12652a.f12689s != null) {
                this.f12652a.f12689s.hide();
                this.f12652a.m17334e();
            }
            return (this.f12652a.f12693w == null || !this.f12652a.f12693w.onError(this.f12652a.f12683m, i, i2)) ? true : true;
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleVideoView$7 */
    class C32837 implements OnBufferingUpdateListener {
        /* renamed from: a */
        final /* synthetic */ SubtitleVideoView f12653a;

        C32837(SubtitleVideoView subtitleVideoView) {
            this.f12653a = subtitleVideoView;
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            this.f12653a.f12692v = i;
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleVideoView$8 */
    class C32848 implements Callback {
        /* renamed from: a */
        final /* synthetic */ SubtitleVideoView f12654a;

        C32848(SubtitleVideoView subtitleVideoView) {
            this.f12654a = subtitleVideoView;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Object obj = 1;
            this.f12654a.f12686p = i2;
            this.f12654a.f12687q = i3;
            Object obj2 = this.f12654a.f12681k == 3 ? 1 : null;
            if (!(this.f12654a.f12684n == i2 && this.f12654a.f12685o == i3)) {
                obj = null;
            }
            if (this.f12654a.f12683m != null && obj2 != null && r1 != null) {
                if (this.f12654a.f12695y != 0) {
                    this.f12654a.seekTo(this.f12654a.f12695y);
                }
                this.f12654a.start();
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f12654a.f12682l = surfaceHolder;
            this.f12654a.m17325c();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f12654a.f12682l = null;
            if (this.f12654a.f12689s != null) {
                this.f12654a.f12689s.hide();
            }
            this.f12654a.m17316a(true);
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleVideoView$9 */
    class C32859 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ SubtitleVideoView f12655a;

        C32859(SubtitleVideoView subtitleVideoView) {
            this.f12655a = subtitleVideoView;
        }

        public void run() {
            if (VERSION.SDK_INT >= 16) {
                this.f12655a.getmActivity().getWindow().getDecorView().setSystemUiVisibility(4102);
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.SubtitleVideoView$a */
    private class C3286a extends Thread {
        /* renamed from: a */
        final /* synthetic */ SubtitleVideoView f12656a;
        /* renamed from: b */
        private volatile MediaPlayer f12657b;

        private C3286a(SubtitleVideoView subtitleVideoView) {
            this.f12656a = subtitleVideoView;
        }

        public void run() {
            super.run();
            while (this.f12656a.m17322b(this.f12657b)) {
                try {
                    C3286a.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: a */
        public void m17308a(MediaPlayer mediaPlayer) {
            this.f12657b = mediaPlayer;
        }
    }

    public Activity getmActivity() {
        return this.f12667J;
    }

    public void setmActivity(Activity activity) {
        this.f12667J = activity;
    }

    public SubtitleVideoView(Context context) {
        super(context);
        this.f12675e = new ArrayList();
        this.f12676f = "VideoView";
        this.f12680j = 0;
        this.f12681k = 0;
        this.f12682l = null;
        this.f12683m = null;
        this.f12663F = true;
        this.f12671a = new C32741(this);
        this.f12672b = new C32804(this);
        this.f12668K = new C32815(this);
        this.f12669L = new C32826(this);
        this.f12670M = new C32837(this);
        this.f12673c = new C32848(this);
        this.f12674d = new C32859(this);
        this.f12660C = context;
        m17321b();
    }

    public SubtitleVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.f12660C = context;
        m17321b();
    }

    public SubtitleVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12675e = new ArrayList();
        this.f12676f = "VideoView";
        this.f12680j = 0;
        this.f12681k = 0;
        this.f12682l = null;
        this.f12683m = null;
        this.f12663F = true;
        this.f12671a = new C32741(this);
        this.f12672b = new C32804(this);
        this.f12668K = new C32815(this);
        this.f12669L = new C32826(this);
        this.f12670M = new C32837(this);
        this.f12673c = new C32848(this);
        this.f12674d = new C32859(this);
        this.f12660C = context;
        m17321b();
    }

    public long getmSubtitleDalay() {
        return this.f12666I;
    }

    public void setmSubtitleDalay(long j) {
        this.f12666I = j;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.f12684n, i);
        int defaultSize2 = getDefaultSize(this.f12685o, i2);
        if (this.f12684n > 0 && this.f12685o > 0) {
            if (this.f12684n * defaultSize2 > this.f12685o * defaultSize) {
                defaultSize2 = (this.f12685o * defaultSize) / this.f12684n;
            } else if (this.f12684n * defaultSize2 < this.f12685o * defaultSize) {
                defaultSize = (this.f12684n * defaultSize2) / this.f12685o;
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
    private void m17321b() {
        this.f12684n = 0;
        this.f12685o = 0;
        getHolder().addCallback(this.f12673c);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f12680j = 0;
        this.f12681k = 0;
        this.f12661D = 0;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        m17354a(uri, null);
    }

    /* renamed from: a */
    public void m17354a(Uri uri, Map<String, String> map) {
        this.f12677g = uri;
        this.f12678h = map;
        this.f12695y = 0;
        m17325c();
        requestLayout();
        invalidate();
    }

    /* renamed from: a */
    public void m17353a() {
        if (this.f12683m != null) {
            this.f12683m.stop();
            this.f12683m.release();
            this.f12683m = null;
        }
        this.f12680j = 0;
        this.f12681k = 0;
        if (this.f12682l != null) {
            this.f12682l.removeCallback(null);
            this.f12682l = null;
        }
        removeCallbacks(null);
        destroyDrawingCache();
        try {
            C3184j.m16985a((View) this, false);
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    private void m17325c() {
        if (this.f12677g != null && this.f12682l != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            this.f12660C.sendBroadcast(intent);
            m17316a(false);
            try {
                this.f12683m = new MediaPlayer();
                m17312a(this.f12683m);
                this.f12683m.setOnBufferingUpdateListener(this.f12688r);
                this.f12683m.setOnPreparedListener(this.f12672b);
                this.f12683m.setOnVideoSizeChangedListener(this.f12671a);
                this.f12679i = -1;
                this.f12683m.setOnCompletionListener(this.f12668K);
                this.f12683m.setOnErrorListener(this.f12669L);
                this.f12683m.setOnInfoListener(this.f12694x);
                this.f12683m.setOnBufferingUpdateListener(this.f12670M);
                this.f12692v = 0;
                this.f12683m.setDataSource(this.f12660C, this.f12677g, this.f12678h);
                this.f12683m.setDisplay(this.f12682l);
                this.f12683m.setAudioStreamType(3);
                this.f12683m.setScreenOnWhilePlaying(true);
                this.f12683m.prepareAsync();
                this.f12680j = 1;
                m17330d();
            } catch (IOException e) {
                this.f12680j = -1;
                this.f12681k = -1;
                this.f12669L.onError(this.f12683m, 1, 0);
            } catch (IllegalArgumentException e2) {
                this.f12680j = -1;
                this.f12681k = -1;
                this.f12669L.onError(this.f12683m, 1, 0);
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        if (this.f12689s != null) {
            this.f12689s.hide();
            m17334e();
        }
        this.f12689s = mediaController;
        m17330d();
    }

    /* renamed from: d */
    private void m17330d() {
        if (this.f12683m != null && this.f12689s != null) {
            View view;
            this.f12689s.setMediaPlayer(this);
            if (getParent() instanceof View) {
                view = (View) getParent();
            } else {
                view = this;
            }
            this.f12689s.setAnchorView(view);
            this.f12689s.setEnabled(m17340g());
        }
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.f12691u = onPreparedListener;
    }

    public void setOnBufferUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f12670M = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.f12690t = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.f12693w = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.f12694x = onInfoListener;
    }

    /* renamed from: a */
    private void m17316a(boolean z) {
        if (this.f12683m != null) {
            this.f12683m.reset();
            this.f12683m.release();
            this.f12683m = null;
            this.f12680j = 0;
            if (z) {
                this.f12681k = 0;
            }
        }
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.f12683m.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (m17340g() && this.f12689s != null) {
            m17337f();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (m17340g() && this.f12689s != null) {
            m17337f();
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (m17340g() && z && this.f12689s != null) {
            if (i == 79 || i == 85) {
                if (this.f12683m.isPlaying()) {
                    pause();
                    this.f12689s.show();
                    m17334e();
                    return true;
                }
                start();
                this.f12689s.hide();
                m17334e();
                return true;
            } else if (i == 126) {
                if (this.f12683m.isPlaying()) {
                    return true;
                }
                start();
                this.f12689s.hide();
                m17334e();
                return true;
            } else if (i != 86 && i != 127) {
                m17337f();
            } else if (!this.f12683m.isPlaying()) {
                return true;
            } else {
                pause();
                this.f12689s.show();
                m17334e();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    private void m17334e() {
        try {
            removeCallbacks(this.f12674d);
            postDelayed(this.f12674d, 5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onDetachedFromWindow() {
        try {
            removeCallbacks(this.f12674d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    /* renamed from: f */
    private void m17337f() {
        try {
            if (this.f12689s.isShowing()) {
                this.f12689s.hide();
                m17334e();
                return;
            }
            this.f12689s.show();
            m17334e();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MediaPlayer getMediaPlayer() {
        return this.f12683m;
    }

    public void start() {
        if (m17340g()) {
            this.f12683m.start();
            this.f12680j = 3;
        }
        this.f12681k = 3;
    }

    public void pause() {
        if (m17340g() && this.f12683m.isPlaying()) {
            this.f12683m.pause();
            this.f12680j = 4;
        }
        this.f12681k = 4;
    }

    public int getDuration() {
        if (!m17340g()) {
            this.f12679i = -1;
            return this.f12679i;
        } else if (this.f12679i > 0) {
            return this.f12679i;
        } else {
            this.f12679i = this.f12683m.getDuration();
            return this.f12679i;
        }
    }

    public int getCurrentPosition() {
        if (m17340g()) {
            return this.f12683m.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (m17340g()) {
            this.f12683m.seekTo(i);
            this.f12695y = 0;
            return;
        }
        this.f12695y = i;
    }

    public boolean isPlaying() {
        return m17340g() && this.f12683m.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.f12683m != null) {
            return this.f12692v;
        }
        return 0;
    }

    /* renamed from: g */
    private boolean m17340g() {
        return (this.f12683m == null || this.f12680j == -1 || this.f12680j == 0 || this.f12680j == 1) ? false : true;
    }

    public boolean canPause() {
        return this.f12696z;
    }

    public boolean canSeekBackward() {
        return this.f12658A;
    }

    public boolean canSeekForward() {
        return this.f12659B;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public void setSubTitleView(TextView textView) {
        this.f12662E = textView;
        if (textView == null) {
            throw new RuntimeException("subtitle view can`t equals with null");
        }
    }

    public boolean getSubtitleVisable() {
        return this.f12663F;
    }

    public void setSubtitleSource(File file) throws IOException {
        InputStream fileInputStream = new FileInputStream(file);
        this.f12665H = C3181h.m16977a(C3176e.m16970b(new FileInputStream(file)));
        C3094j.m16698a("setSubtitleSource", "charSet.displayName " + this.f12665H);
        C3094j.m16698a("setSubtitleSource", "File: " + file.getAbsolutePath());
        m17352a(fileInputStream);
    }

    public void setSubtitleSource(final URL url) throws IOException {
        this.f12665H = null;
        new Thread(this) {
            /* renamed from: b */
            final /* synthetic */ SubtitleVideoView f12639b;

            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setDoInput(true);
                    this.f12639b.m17352a(new BufferedInputStream(httpURLConnection.getInputStream()));
                } catch (Exception e) {
                }
            }
        }.start();
    }

    /* renamed from: a */
    public InputStream m17352a(InputStream inputStream) throws IOException {
        Reader inputStreamReader;
        this.f12675e.clear();
        if (this.f12665H == null) {
            inputStreamReader = new InputStreamReader(inputStream);
        } else if (this.f12665H.equalsIgnoreCase("MACCYRILLIC")) {
            inputStreamReader = new InputStreamReader(inputStream, "cp1256");
        } else {
            inputStreamReader = new InputStreamReader(inputStream, this.f12665H);
        }
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        new Thread(this) {
            /* renamed from: b */
            final /* synthetic */ SubtitleVideoView f12641b;

            public void run() {
                try {
                    this.f12641b.m17315a(bufferedReader);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return inputStream;
    }

    /* renamed from: a */
    private void m17315a(BufferedReader bufferedReader) throws Exception {
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
                        m17313a(new C3275b(this) {
                            /* renamed from: b */
                            final /* synthetic */ SubtitleVideoView f12644b;

                            /* renamed from: a */
                            public void mo2167a() {
                                this.f12644b.f12675e.add(phrase);
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
    private synchronized void m17313a(C3275b c3275b) {
        c3275b.mo2167a();
    }

    /* renamed from: a */
    private void m17312a(MediaPlayer mediaPlayer) {
        if (this.f12664G == null) {
            this.f12664G = new C3286a();
            this.f12664G.start();
        }
        this.f12664G.m17308a(mediaPlayer);
    }

    /* renamed from: b */
    private boolean m17322b(MediaPlayer mediaPlayer) {
        try {
            if (!this.f12663F || mediaPlayer == null || this.f12662E == null) {
                return false;
            }
            if (!mediaPlayer.isPlaying()) {
                return true;
            }
            final int currentPosition = mediaPlayer.getCurrentPosition();
            m17313a(new C3275b(this) {
                /* renamed from: b */
                final /* synthetic */ SubtitleVideoView f12649b;

                /* renamed from: com.tdo.showbox.views.SubtitleVideoView$3$2 */
                class C32782 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C32793 f12647a;

                    C32782(C32793 c32793) {
                        this.f12647a = c32793;
                    }

                    public void run() {
                        this.f12647a.f12649b.f12662E.setText("");
                    }
                }

                /* renamed from: a */
                public void mo2167a() {
                    Iterator it = this.f12649b.f12675e.iterator();
                    while (it.hasNext()) {
                        final Phrase phrase = (Phrase) it.next();
                        if (phrase.isCanShow((long) currentPosition)) {
                            this.f12649b.f12662E.post(new Runnable(this) {
                                /* renamed from: b */
                                final /* synthetic */ C32793 f12646b;

                                public void run() {
                                    this.f12646b.f12649b.f12662E.setText(Html.fromHtml(phrase.getContent()));
                                }
                            });
                            return;
                        }
                    }
                    this.f12649b.f12662E.post(new C32782(this));
                }
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
