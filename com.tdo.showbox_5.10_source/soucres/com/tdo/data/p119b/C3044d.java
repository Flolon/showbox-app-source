package com.tdo.showbox.data.p119b;

import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.p113d.C2630b;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: AdFullscreenWaiter */
/* renamed from: com.tdo.showbox.data.b.d */
public class C3044d {
    /* renamed from: a */
    protected C2630b f11944a;
    /* renamed from: b */
    protected Timer f11945b;
    /* renamed from: c */
    protected TimerTask f11946c;
    /* renamed from: d */
    protected C3047g f11947d;
    /* renamed from: e */
    protected int f11948e;
    /* renamed from: f */
    protected boolean f11949f;
    /* renamed from: g */
    protected boolean f11950g;

    /* compiled from: AdFullscreenWaiter */
    /* renamed from: com.tdo.showbox.data.b.d$1 */
    class C30431 extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ C3044d f11943a;

        C30431(C3044d c3044d) {
            this.f11943a = c3044d;
        }

        public void run() {
            if (this.f11943a.f11947d != null) {
                C3044d c3044d = this.f11943a;
                c3044d.f11948e++;
                boolean g = this.f11943a.f11947d.m16495g();
                if (this.f11943a.f11944a == null) {
                    return;
                }
                if (g) {
                    C3094j.m16698a("AdWaiter", "onAdObtained");
                    this.f11943a.f11944a.mo1997d();
                    this.f11943a.m16463e();
                } else if (this.f11943a.f11948e >= 10) {
                    C3094j.m16698a("AdWaiter", "onAdTimeout");
                    this.f11943a.f11944a.mo1999f();
                    this.f11943a.m16463e();
                } else if (this.f11943a.f11947d.m16494f()) {
                    C3094j.m16698a("AdWaiter", "onAdFail");
                    this.f11943a.f11944a.mo1998e();
                    this.f11943a.m16463e();
                }
            }
        }
    }

    /* renamed from: a */
    public void m16466a(C3047g c3047g) {
        this.f11947d = c3047g;
        this.f11950g = false;
    }

    /* renamed from: a */
    public void m16465a(C2630b c2630b) {
        this.f11944a = c2630b;
    }

    /* renamed from: a */
    public void m16467a(boolean z, String str) {
        if (this.f11947d != null && this.f11947d.m16488a(true, z, str)) {
            this.f11949f = false;
            this.f11950g = false;
            m16470d();
        }
    }

    /* renamed from: a */
    public void m16464a() {
        if (this.f11944a != null && !this.f11949f) {
            this.f11949f = true;
            this.f11944a.mo2001h();
        }
    }

    /* renamed from: b */
    public boolean m16468b() {
        return this.f11949f;
    }

    /* renamed from: c */
    public boolean m16469c() {
        return this.f11950g;
    }

    /* renamed from: d */
    protected void m16470d() {
        m16463e();
        this.f11950g = false;
        this.f11949f = false;
        this.f11948e = 0;
        if (this.f11944a != null) {
            this.f11944a.mo2000g();
        }
        this.f11945b = new Timer();
        this.f11946c = new C30431(this);
        this.f11945b.schedule(this.f11946c, 1000, 1000);
    }

    /* renamed from: e */
    private void m16463e() {
        try {
            this.f11950g = true;
            this.f11948e = 0;
            if (this.f11945b != null) {
                this.f11946c.cancel();
                this.f11945b.purge();
                this.f11945b.cancel();
                this.f11945b = null;
                this.f11946c = null;
            }
        } catch (Exception e) {
        }
    }
}
