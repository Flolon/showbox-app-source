package com.tdo.showbox.activities;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.C0505e;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.p112c.C3074a;
import com.tdo.showbox.data.p119b.C3049h;
import com.tdo.showbox.models.InternalAd;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

public class CustomAdActivity extends C0505e {
    /* renamed from: a */
    private View f10711a;
    /* renamed from: b */
    private InternalAd f10712b;
    /* renamed from: c */
    private boolean f10713c;
    /* renamed from: d */
    private VideoView f10714d;
    /* renamed from: e */
    private boolean f10715e;
    /* renamed from: f */
    private ImageView f10716f;
    /* renamed from: g */
    private C3074a f10717g;
    /* renamed from: h */
    private ProgressBar f10718h;
    /* renamed from: i */
    private Handler f10719i;
    /* renamed from: j */
    private Runnable f10720j;
    /* renamed from: k */
    private Messenger f10721k;
    /* renamed from: l */
    private boolean f10722l;

    /* renamed from: com.tdo.showbox.activities.CustomAdActivity$1 */
    class C26081 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ CustomAdActivity f10705a;

        C26081(CustomAdActivity customAdActivity) {
            this.f10705a = customAdActivity;
        }

        public void onClick(View view) {
            try {
                C3049h.m16498a(this.f10705a.f10712b);
                String a = C3088f.m16675a("PREF_COUNTRY_ISO");
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f10705a.f10712b.getLink()));
                    intent.setFlags(268435456);
                    this.f10705a.getApplicationContext().startActivity(intent);
                    this.f10705a.f10722l = true;
                    C3065b.m16570a("ad_internal_interstitial_click", new String[]{"id", "geo"}, new String[]{this.f10705a.f10712b.getItem_id(), a});
                } catch (Exception e) {
                    this.f10705a.m15048g();
                    this.f10705a.finish();
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.CustomAdActivity$2 */
    class C26092 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ CustomAdActivity f10706a;

        C26092(CustomAdActivity customAdActivity) {
            this.f10706a = customAdActivity;
        }

        public void run() {
            try {
                if (!(this.f10706a.f10714d == null || !this.f10706a.f10713c || this.f10706a.f10718h == null)) {
                    this.f10706a.f10718h.setProgress((this.f10706a.f10714d.getCurrentPosition() * IjkMediaCodecInfo.RANK_MAX) / this.f10706a.f10714d.getDuration());
                }
                if (this.f10706a.f10719i != null && !this.f10706a.f10715e) {
                    this.f10706a.f10719i.postDelayed(this.f10706a.f10720j, 50);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.CustomAdActivity$3 */
    class C26103 implements OnErrorListener {
        /* renamed from: a */
        final /* synthetic */ CustomAdActivity f10707a;

        C26103(CustomAdActivity customAdActivity) {
            this.f10707a = customAdActivity;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                this.f10707a.f10711a.setVisibility(4);
                this.f10707a.f10713c = false;
                this.f10707a.m15035a(this.f10707a.f10712b.getBanner());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: com.tdo.showbox.activities.CustomAdActivity$4 */
    class C26114 implements OnCompletionListener {
        /* renamed from: a */
        final /* synthetic */ CustomAdActivity f10708a;

        C26114(CustomAdActivity customAdActivity) {
            this.f10708a = customAdActivity;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                this.f10708a.m15042d();
                this.f10708a.f10711a.setVisibility(4);
                this.f10708a.f10713c = false;
                this.f10708a.m15035a(this.f10708a.f10712b.getBanner());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.CustomAdActivity$5 */
    class C26125 implements OnPreparedListener {
        /* renamed from: a */
        final /* synthetic */ CustomAdActivity f10709a;

        C26125(CustomAdActivity customAdActivity) {
            this.f10709a = customAdActivity;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                this.f10709a.f10711a.setVisibility(4);
                this.f10709a.m15041c();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.tdo.showbox.activities.CustomAdActivity$6 */
    class C26136 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ CustomAdActivity f10710a;

        C26136(CustomAdActivity customAdActivity) {
            this.f10710a = customAdActivity;
        }

        public void onClick(View view) {
            this.f10710a.m15048g();
            this.f10710a.finish();
        }
    }

    /* renamed from: a */
    public static void m15033a(Context context, InternalAd internalAd, Messenger messenger) {
        Intent intent = new Intent(context, CustomAdActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("ad_item", internalAd);
        intent.putExtra("messenger", messenger);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10722l = false;
        try {
            this.f10712b = (InternalAd) getIntent().getSerializableExtra("ad_item");
            this.f10721k = (Messenger) getIntent().getParcelableExtra("messenger");
        } catch (Exception e) {
        }
        this.f10715e = false;
        setRequestedOrientation(1);
        setContentView((int) R.layout.act_custom_ads);
        this.f10719i = new Handler();
        this.f10713c = false;
        this.f10711a = findViewById(R.id.viewProgress);
        this.f10714d = (VideoView) findViewById(R.id.video_view);
        this.f10716f = (ImageView) findViewById(R.id.banner_static_view);
        this.f10716f.setVisibility(8);
        this.f10718h = (ProgressBar) findViewById(R.id.video_progress);
        this.f10718h.setProgress(0);
        this.f10718h.setVisibility(8);
        findViewById(R.id.viewAdClick).setOnClickListener(new C26081(this));
        findViewById(R.id.viewAdClick).setVisibility(4);
        this.f10720j = new C26092(this);
        m15037b();
        m15047f();
    }

    /* renamed from: b */
    private void m15037b() {
        m15045e();
    }

    /* renamed from: c */
    private void m15041c() {
        m15042d();
        this.f10718h.setVisibility(0);
        this.f10718h.setProgress(0);
        this.f10719i.post(this.f10720j);
    }

    /* renamed from: d */
    private void m15042d() {
        try {
            this.f10719i.removeCallbacks(this.f10720j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m15045e() {
        this.f10718h.setVisibility(4);
        this.f10713c = true;
        findViewById(R.id.viewClose).setVisibility(8);
        this.f10711a.setVisibility(0);
        this.f10714d.setVisibility(0);
        try {
            this.f10714d.setVideoURI(Uri.parse(this.f10712b.getDirectVideoUrl()));
            this.f10714d.setOnErrorListener(new C26103(this));
            this.f10714d.setOnCompletionListener(new C26114(this));
            this.f10714d.setOnPreparedListener(new C26125(this));
            this.f10714d.start();
        } catch (Exception e) {
            this.f10711a.setVisibility(4);
            this.f10713c = false;
            m15035a(this.f10712b.getBanner());
        }
    }

    /* renamed from: a */
    private void m15035a(String str) {
        this.f10714d.setVisibility(8);
        this.f10716f.setVisibility(0);
        m15054a().m16635a(this.f10716f, str);
        this.f10718h.setVisibility(4);
        String a = C3088f.m16675a("PREF_COUNTRY_ISO");
        C3065b.m16570a("ad_internal_interstitial_show", new String[]{"id", "geo"}, new String[]{this.f10712b.getItem_id(), a});
        C3049h.m16500b(this.f10712b);
        findViewById(R.id.viewAdClick).setVisibility(0);
        findViewById(R.id.viewClose).setVisibility(0);
        findViewById(R.id.viewClose).setOnClickListener(new C26136(this));
    }

    public void onBackPressed() {
        if (!this.f10713c) {
            m15048g();
            super.onBackPressed();
        }
    }

    protected void onDestroy() {
        this.f10715e = true;
        if (this.f10717g != null) {
            this.f10717g.m16639b();
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        m15042d();
        try {
            if (this.f10714d != null && this.f10713c) {
                this.f10714d.pause();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f10722l) {
            m15048g();
            finish();
            return;
        }
        try {
            if (this.f10714d != null && this.f10713c) {
                this.f10714d.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public C3074a m15054a() {
        if (this.f10717g == null) {
            this.f10717g = new C3074a(this);
            AnimationSet animationSet = new AnimationSet(true);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400);
            animationSet.addAnimation(alphaAnimation);
            AnimationSet animationSet2 = new AnimationSet(true);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(400);
            animationSet2.addAnimation(alphaAnimation2);
            this.f10717g.m16633a(animationSet, animationSet2);
        }
        return this.f10717g;
    }

    /* renamed from: f */
    private void m15047f() {
        try {
            this.f10721k.send(Message.obtain(null, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private void m15048g() {
        try {
            this.f10721k.send(Message.obtain(null, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
