package com.tdo.showbox.views;

import android.annotation.SuppressLint;
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
import java.io.IOException;
import java.util.Map;

@SuppressLint({"NewApi"})
public class FixedVideoView extends SurfaceView implements MediaPlayerControl {
    /* renamed from: A */
    private Context f12527A;
    /* renamed from: B */
    private int f12528B;
    /* renamed from: C */
    private OnCompletionListener f12529C = new C32563(this);
    /* renamed from: D */
    private OnErrorListener f12530D = new C32574(this);
    /* renamed from: E */
    private OnBufferingUpdateListener f12531E = new C32585(this);
    /* renamed from: a */
    OnVideoSizeChangedListener f12532a = new C32541(this);
    /* renamed from: b */
    OnPreparedListener f12533b = new C32552(this);
    /* renamed from: c */
    Callback f12534c = new C32596(this);
    /* renamed from: d */
    private String f12535d = "VideoView";
    /* renamed from: e */
    private Uri f12536e;
    /* renamed from: f */
    private Map<String, String> f12537f;
    /* renamed from: g */
    private int f12538g;
    /* renamed from: h */
    private int f12539h = 0;
    /* renamed from: i */
    private int f12540i = 0;
    /* renamed from: j */
    private SurfaceHolder f12541j = null;
    /* renamed from: k */
    private MediaPlayer f12542k = null;
    /* renamed from: l */
    private int f12543l;
    /* renamed from: m */
    private int f12544m;
    /* renamed from: n */
    private int f12545n;
    /* renamed from: o */
    private int f12546o;
    /* renamed from: p */
    private OnBufferingUpdateListener f12547p;
    /* renamed from: q */
    private MediaController f12548q;
    /* renamed from: r */
    private OnCompletionListener f12549r;
    /* renamed from: s */
    private OnPreparedListener f12550s;
    /* renamed from: t */
    private int f12551t;
    /* renamed from: u */
    private OnErrorListener f12552u;
    /* renamed from: v */
    private OnInfoListener f12553v;
    /* renamed from: w */
    private int f12554w;
    /* renamed from: x */
    private boolean f12555x;
    /* renamed from: y */
    private boolean f12556y;
    /* renamed from: z */
    private boolean f12557z;

    /* renamed from: com.tdo.showbox.views.FixedVideoView$1 */
    class C32541 implements OnVideoSizeChangedListener {
        /* renamed from: a */
        final /* synthetic */ FixedVideoView f12521a;

        C32541(FixedVideoView fixedVideoView) {
            this.f12521a = fixedVideoView;
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            this.f12521a.f12543l = mediaPlayer.getVideoWidth();
            this.f12521a.f12544m = mediaPlayer.getVideoHeight();
            if (this.f12521a.f12543l != 0 && this.f12521a.f12544m != 0) {
                this.f12521a.getHolder().setFixedSize(this.f12521a.f12543l, this.f12521a.f12544m);
                this.f12521a.requestLayout();
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.FixedVideoView$2 */
    class C32552 implements OnPreparedListener {
        /* renamed from: a */
        final /* synthetic */ FixedVideoView f12522a;

        C32552(FixedVideoView fixedVideoView) {
            this.f12522a = fixedVideoView;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            this.f12522a.f12539h = 2;
            this.f12522a.f12555x = this.f12522a.f12556y = this.f12522a.f12557z = true;
            if (this.f12522a.f12550s != null) {
                this.f12522a.f12550s.onPrepared(this.f12522a.f12542k);
            }
            if (this.f12522a.f12548q != null) {
                this.f12522a.f12548q.setEnabled(true);
            }
            this.f12522a.f12543l = mediaPlayer.getVideoWidth();
            this.f12522a.f12544m = mediaPlayer.getVideoHeight();
            int f = this.f12522a.f12554w;
            if (f != 0) {
                this.f12522a.seekTo(f);
            }
            if (this.f12522a.f12543l != 0 && this.f12522a.f12544m != 0) {
                this.f12522a.getHolder().setFixedSize(this.f12522a.f12543l, this.f12522a.f12544m);
                if (this.f12522a.f12545n != this.f12522a.f12543l || this.f12522a.f12546o != this.f12522a.f12544m) {
                    return;
                }
                if (this.f12522a.f12540i == 3) {
                    this.f12522a.start();
                    if (this.f12522a.f12548q != null) {
                        this.f12522a.f12548q.show();
                    }
                } else if (!this.f12522a.isPlaying()) {
                    if ((f != 0 || this.f12522a.getCurrentPosition() > 0) && this.f12522a.f12548q != null) {
                        this.f12522a.f12548q.show(0);
                    }
                }
            } else if (this.f12522a.f12540i == 3) {
                this.f12522a.start();
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.FixedVideoView$3 */
    class C32563 implements OnCompletionListener {
        /* renamed from: a */
        final /* synthetic */ FixedVideoView f12523a;

        C32563(FixedVideoView fixedVideoView) {
            this.f12523a = fixedVideoView;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f12523a.f12539h = 5;
            this.f12523a.f12540i = 5;
            if (this.f12523a.f12548q != null) {
                this.f12523a.f12548q.hide();
            }
            if (this.f12523a.f12549r != null) {
                this.f12523a.f12549r.onCompletion(this.f12523a.f12542k);
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.FixedVideoView$4 */
    class C32574 implements OnErrorListener {
        /* renamed from: a */
        final /* synthetic */ FixedVideoView f12524a;

        C32574(FixedVideoView fixedVideoView) {
            this.f12524a = fixedVideoView;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 1 || i2 == -1004) {
                this.f12524a.m17215a(true);
                this.f12524a.f12528B = this.f12524a.f12528B + 1;
                if (this.f12524a.f12528B > 30) {
                    this.f12524a.f12528B = 0;
                } else {
                    this.f12524a.f12539h = 0;
                    this.f12524a.f12540i = 0;
                    this.f12524a.f12539h = 3;
                    this.f12524a.f12540i = 3;
                    this.f12524a.m17219b();
                    return false;
                }
            }
            this.f12524a.f12528B = 0;
            this.f12524a.f12539h = -1;
            this.f12524a.f12540i = -1;
            if (this.f12524a.f12548q != null) {
                this.f12524a.f12548q.hide();
            }
            return (this.f12524a.f12552u == null || !this.f12524a.f12552u.onError(this.f12524a.f12542k, i, i2)) ? true : true;
        }
    }

    /* renamed from: com.tdo.showbox.views.FixedVideoView$5 */
    class C32585 implements OnBufferingUpdateListener {
        /* renamed from: a */
        final /* synthetic */ FixedVideoView f12525a;

        C32585(FixedVideoView fixedVideoView) {
            this.f12525a = fixedVideoView;
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            this.f12525a.f12551t = i;
        }
    }

    /* renamed from: com.tdo.showbox.views.FixedVideoView$6 */
    class C32596 implements Callback {
        /* renamed from: a */
        final /* synthetic */ FixedVideoView f12526a;

        C32596(FixedVideoView fixedVideoView) {
            this.f12526a = fixedVideoView;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Object obj = 1;
            this.f12526a.f12545n = i2;
            this.f12526a.f12546o = i3;
            Object obj2 = this.f12526a.f12540i == 3 ? 1 : null;
            if (!(this.f12526a.f12543l == i2 && this.f12526a.f12544m == i3)) {
                obj = null;
            }
            if (this.f12526a.f12542k != null && obj2 != null && r1 != null) {
                if (this.f12526a.f12554w != 0) {
                    this.f12526a.seekTo(this.f12526a.f12554w);
                }
                this.f12526a.start();
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f12526a.f12541j = surfaceHolder;
            this.f12526a.m17219b();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f12526a.f12541j = null;
            if (this.f12526a.f12548q != null) {
                this.f12526a.f12548q.hide();
            }
            this.f12526a.m17215a(true);
        }
    }

    public FixedVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12527A = context;
        m17214a();
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.f12543l, i);
        int defaultSize2 = getDefaultSize(this.f12544m, i2);
        if (this.f12543l > 0 && this.f12544m > 0) {
            if (this.f12543l * defaultSize2 > this.f12544m * defaultSize) {
                defaultSize2 = (this.f12544m * defaultSize) / this.f12543l;
            } else if (this.f12543l * defaultSize2 < this.f12544m * defaultSize) {
                defaultSize = (this.f12543l * defaultSize2) / this.f12544m;
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

    /* renamed from: a */
    private void m17214a() {
        this.f12543l = 0;
        this.f12544m = 0;
        getHolder().addCallback(this.f12534c);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f12539h = 0;
        this.f12540i = 0;
        this.f12528B = 0;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        m17244a(uri, null);
    }

    /* renamed from: a */
    public void m17244a(Uri uri, Map<String, String> map) {
        this.f12536e = uri;
        this.f12537f = map;
        this.f12554w = 0;
        m17219b();
        requestLayout();
        invalidate();
    }

    /* renamed from: b */
    private void m17219b() {
        if (this.f12536e != null && this.f12541j != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            this.f12527A.sendBroadcast(intent);
            m17215a(false);
            try {
                this.f12542k = new MediaPlayer();
                this.f12542k.setOnBufferingUpdateListener(this.f12547p);
                this.f12542k.setOnPreparedListener(this.f12533b);
                this.f12542k.setOnVideoSizeChangedListener(this.f12532a);
                this.f12538g = -1;
                this.f12542k.setOnCompletionListener(this.f12529C);
                this.f12542k.setOnErrorListener(this.f12530D);
                this.f12542k.setOnInfoListener(this.f12553v);
                this.f12542k.setOnBufferingUpdateListener(this.f12531E);
                this.f12551t = 0;
                this.f12542k.setDataSource(this.f12527A, this.f12536e, this.f12537f);
                this.f12542k.setDisplay(this.f12541j);
                this.f12542k.setAudioStreamType(3);
                this.f12542k.setScreenOnWhilePlaying(true);
                this.f12542k.prepareAsync();
                this.f12539h = 1;
                m17223c();
            } catch (IOException e) {
                this.f12539h = -1;
                this.f12540i = -1;
                this.f12530D.onError(this.f12542k, 1, 0);
            } catch (IllegalArgumentException e2) {
                this.f12539h = -1;
                this.f12540i = -1;
                this.f12530D.onError(this.f12542k, 1, 0);
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        if (this.f12548q != null) {
            this.f12548q.hide();
        }
        this.f12548q = mediaController;
        m17223c();
    }

    /* renamed from: c */
    private void m17223c() {
        if (this.f12542k != null && this.f12548q != null) {
            View view;
            this.f12548q.setMediaPlayer(this);
            if (getParent() instanceof View) {
                view = (View) getParent();
            } else {
                view = this;
            }
            this.f12548q.setAnchorView(view);
            this.f12548q.setEnabled(m17231e());
        }
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.f12550s = onPreparedListener;
    }

    public void setOnBufferUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f12531E = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.f12549r = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.f12552u = onErrorListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.f12553v = onInfoListener;
    }

    /* renamed from: a */
    private void m17215a(boolean z) {
        if (this.f12542k != null) {
            this.f12542k.reset();
            this.f12542k.release();
            this.f12542k = null;
            this.f12539h = 0;
            if (z) {
                this.f12540i = 0;
            }
        }
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.f12542k.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (m17231e() && this.f12548q != null) {
            m17227d();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (m17231e() && this.f12548q != null) {
            m17227d();
        }
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (m17231e() && z && this.f12548q != null) {
            if (i == 79 || i == 85) {
                if (this.f12542k.isPlaying()) {
                    pause();
                    this.f12548q.show();
                    return true;
                }
                start();
                this.f12548q.hide();
                return true;
            } else if (i == 126) {
                if (this.f12542k.isPlaying()) {
                    return true;
                }
                start();
                this.f12548q.hide();
                return true;
            } else if (i != 86 && i != 127) {
                m17227d();
            } else if (!this.f12542k.isPlaying()) {
                return true;
            } else {
                pause();
                this.f12548q.show();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: d */
    private void m17227d() {
        try {
            if (this.f12548q.isShowing()) {
                this.f12548q.hide();
            } else {
                this.f12548q.show();
            }
        } catch (Exception e) {
        }
    }

    public MediaPlayer getMediaPlayer() {
        return this.f12542k;
    }

    public void start() {
        if (m17231e()) {
            this.f12542k.start();
            this.f12539h = 3;
        }
        this.f12540i = 3;
    }

    public void pause() {
        if (m17231e() && this.f12542k.isPlaying()) {
            this.f12542k.pause();
            this.f12539h = 4;
        }
        this.f12540i = 4;
    }

    public int getDuration() {
        if (!m17231e()) {
            this.f12538g = -1;
            return this.f12538g;
        } else if (this.f12538g > 0) {
            return this.f12538g;
        } else {
            this.f12538g = this.f12542k.getDuration();
            return this.f12538g;
        }
    }

    public int getCurrentPosition() {
        if (m17231e()) {
            return this.f12542k.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i) {
        if (m17231e()) {
            this.f12542k.seekTo(i);
            this.f12554w = 0;
            return;
        }
        this.f12554w = i;
    }

    public boolean isPlaying() {
        return m17231e() && this.f12542k.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.f12542k != null) {
            return this.f12551t;
        }
        return 0;
    }

    /* renamed from: e */
    private boolean m17231e() {
        return (this.f12542k == null || this.f12539h == -1 || this.f12539h == 0 || this.f12539h == 1) ? false : true;
    }

    public boolean canPause() {
        return this.f12555x;
    }

    public boolean canSeekBackward() {
        return this.f12556y;
    }

    public boolean canSeekForward() {
        return this.f12557z;
    }

    public int getAudioSessionId() {
        return 0;
    }
}
