package com.tdo.showbox.data.p119b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.tdo.showbox.activities.CustomAdActivity;
import com.tdo.showbox.data.ObjParser;
import com.tdo.showbox.data.api.C2999a.C2996c;
import com.tdo.showbox.models.InternalAd;
import com.tdo.showbox.models.videosources.BaseVideoSource;

/* compiled from: AdCustomFullscreen */
/* renamed from: com.tdo.showbox.data.b.c */
public class C3042c {
    /* renamed from: a */
    private Context f11936a;
    /* renamed from: b */
    private boolean f11937b;
    /* renamed from: c */
    private C3035b f11938c;
    /* renamed from: d */
    private InternalAd f11939d;
    /* renamed from: e */
    private Handler f11940e = new Handler();
    /* renamed from: f */
    private Handler f11941f = new C30361(this);
    /* renamed from: g */
    private Messenger f11942g = new Messenger(this.f11941f);

    /* compiled from: AdCustomFullscreen */
    /* renamed from: com.tdo.showbox.data.b.c$1 */
    class C30361 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C3042c f11930a;

        C30361(C3042c c3042c) {
            this.f11930a = c3042c;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f11930a.m16459e();
                    return;
                case 3:
                    this.f11930a.m16460f();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* compiled from: AdCustomFullscreen */
    /* renamed from: com.tdo.showbox.data.b.c$2 */
    class C30372 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3042c f11931a;

        C30372(C3042c c3042c) {
            this.f11931a = c3042c;
        }

        public void run() {
            try {
                BaseVideoSource baseVideoSource = new BaseVideoSource();
                baseVideoSource.setSource_mode_id(4);
                baseVideoSource.setStatic_link(this.f11931a.f11939d.getVideo());
                ObjParser.m16276a(baseVideoSource, new C2996c(baseVideoSource.getStatic_link()).m16318a().getResponse());
                Object a = this.f11931a.m16451a(baseVideoSource);
                if (TextUtils.isEmpty(a)) {
                    this.f11931a.m16458d();
                    return;
                }
                this.f11931a.f11939d.setDirectVideoUrl(a);
                this.f11931a.m16457c();
            } catch (Exception e) {
                e.printStackTrace();
                this.f11931a.m16458d();
            }
        }
    }

    /* compiled from: AdCustomFullscreen */
    /* renamed from: com.tdo.showbox.data.b.c$3 */
    class C30383 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3042c f11932a;

        C30383(C3042c c3042c) {
            this.f11932a = c3042c;
        }

        public void run() {
            if (this.f11932a.f11938c != null) {
                this.f11932a.f11938c.iawlInterstitialLoaded(null);
            }
        }
    }

    /* compiled from: AdCustomFullscreen */
    /* renamed from: com.tdo.showbox.data.b.c$4 */
    class C30394 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3042c f11933a;

        C30394(C3042c c3042c) {
            this.f11933a = c3042c;
        }

        public void run() {
            if (this.f11933a.f11938c != null) {
                this.f11933a.f11938c.iawlInterstitialFailed(null, null);
            }
        }
    }

    /* compiled from: AdCustomFullscreen */
    /* renamed from: com.tdo.showbox.data.b.c$5 */
    class C30405 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3042c f11934a;

        C30405(C3042c c3042c) {
            this.f11934a = c3042c;
        }

        public void run() {
            if (this.f11934a.f11938c != null) {
                this.f11934a.f11938c.iawlInterstitialDismissed(null);
            }
        }
    }

    /* compiled from: AdCustomFullscreen */
    /* renamed from: com.tdo.showbox.data.b.c$6 */
    class C30416 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3042c f11935a;

        C30416(C3042c c3042c) {
            this.f11935a = c3042c;
        }

        public void run() {
            if (this.f11935a.f11938c != null) {
                this.f11935a.f11938c.iawlInterstitialShown(null);
            }
        }
    }

    public C3042c(Context context) {
        this.f11936a = context;
    }

    /* renamed from: a */
    public boolean m16455a() {
        return this.f11937b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m16454a(com.tdo.showbox.models.InternalAd r5, com.tdo.showbox.data.p119b.C3035b r6) {
        /*
        r4 = this;
        r0 = 0;
        r4.f11938c = r6;
        r4.f11939d = r5;
        r4.f11937b = r0;
        r2 = r5.getAd_type();
        r1 = -1;
        r3 = r2.hashCode();
        switch(r3) {
            case 110066619: goto L_0x0024;
            case 604727084: goto L_0x001b;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = r1;
    L_0x0014:
        switch(r0) {
            case 0: goto L_0x002e;
            case 1: goto L_0x0032;
            default: goto L_0x0017;
        };
    L_0x0017:
        r4.m16458d();
    L_0x001a:
        return;
    L_0x001b:
        r3 = "interstitial";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0013;
    L_0x0023:
        goto L_0x0014;
    L_0x0024:
        r0 = "fullscreen";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x0013;
    L_0x002c:
        r0 = 1;
        goto L_0x0014;
    L_0x002e:
        r4.m16453h();
        goto L_0x001a;
    L_0x0032:
        r4.m16457c();
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdo.showbox.data.b.c.a(com.tdo.showbox.models.InternalAd, com.tdo.showbox.data.b.b):void");
    }

    /* renamed from: b */
    public void m16456b() {
        CustomAdActivity.m15033a(this.f11936a, this.f11939d, this.f11942g);
    }

    /* renamed from: h */
    private void m16453h() {
        new Thread(new C30372(this)).start();
    }

    /* renamed from: c */
    public void m16457c() {
        this.f11937b = true;
        if (this.f11940e != null) {
            this.f11940e.post(new C30383(this));
        }
    }

    /* renamed from: d */
    public void m16458d() {
        this.f11937b = false;
        if (this.f11940e != null) {
            this.f11940e.post(new C30394(this));
        }
    }

    /* renamed from: e */
    public void m16459e() {
        if (this.f11940e != null) {
            this.f11940e.post(new C30405(this));
        }
    }

    /* renamed from: f */
    public void m16460f() {
        if (this.f11940e != null) {
            this.f11940e.post(new C30416(this));
        }
    }

    /* renamed from: a */
    private String m16451a(BaseVideoSource baseVideoSource) {
        if (!TextUtils.isEmpty(baseVideoSource.getHd_link())) {
            return baseVideoSource.getHd_link();
        }
        if (!TextUtils.isEmpty(baseVideoSource.getMid_link())) {
            return baseVideoSource.getMid_link();
        }
        if (!TextUtils.isEmpty(baseVideoSource.getLow_link())) {
            return baseVideoSource.getLow_link();
        }
        if (TextUtils.isEmpty(baseVideoSource.getFull_hd_link())) {
            return null;
        }
        return baseVideoSource.getFull_hd_link();
    }

    /* renamed from: g */
    public void m16461g() {
        this.f11936a = null;
        this.f11938c = null;
        this.f11940e.removeCallbacksAndMessages(null);
        this.f11941f.removeCallbacksAndMessages(null);
        this.f11940e = null;
        this.f11941f = null;
    }
}
