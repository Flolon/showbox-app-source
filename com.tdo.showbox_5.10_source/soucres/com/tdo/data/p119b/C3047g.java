package com.tdo.showbox.data.p119b;

import android.view.ViewGroup;
import com.tdo.showbox.activities.C2631a;
import com.tdo.showbox.models.AppConfig;

/* compiled from: AdsController */
/* renamed from: com.tdo.showbox.data.b.g */
public class C3047g {
    /* renamed from: a */
    private int f11957a;
    /* renamed from: b */
    private C2631a f11958b;
    /* renamed from: c */
    private AppConfig f11959c;
    /* renamed from: d */
    private C3045e f11960d;
    /* renamed from: e */
    private C3045e f11961e;
    /* renamed from: f */
    private boolean f11962f = false;
    /* renamed from: g */
    private ViewGroup f11963g;
    /* renamed from: h */
    private long f11964h = 0;

    public C3047g(C2631a c2631a, AppConfig appConfig, ViewGroup viewGroup) {
        this.f11958b = c2631a;
        this.f11959c = appConfig;
        this.f11963g = viewGroup;
        if (appConfig == null) {
            this.f11962f = false;
        } else {
            m16484h();
        }
    }

    /* renamed from: a */
    public void m16485a() {
        if (this.f11960d != null) {
            this.f11960d.mo2119a();
        }
    }

    /* renamed from: a */
    public void m16486a(int i) {
        this.f11957a = i;
        this.f11964h = 0;
    }

    /* renamed from: h */
    private void m16484h() {
        this.f11957a = 0;
        C3046f c3046f = new C3046f();
        c3046f.m16481a(this.f11959c);
        this.f11960d = new C3064l(this.f11958b, this.f11963g, c3046f);
        this.f11961e = this.f11960d;
        this.f11962f = true;
    }

    /* renamed from: a */
    public void m16487a(String str) {
        try {
            if (this.f11962f && this.f11960d != null) {
                this.f11960d.mo2120a(str);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public void m16489b() {
        if (this.f11962f) {
            this.f11962f = false;
            this.f11960d.mo2121b();
        }
    }

    /* renamed from: c */
    public void m16491c() {
        if (this.f11962f) {
            this.f11960d.mo2125d();
        }
    }

    /* renamed from: d */
    public void m16492d() {
        if (this.f11962f) {
            m16491c();
        }
    }

    /* renamed from: e */
    public boolean m16493e() {
        if (!this.f11962f) {
            return false;
        }
        try {
            if (!this.f11959c.getFullscreen_enabled().equals("1") || this.f11961e == null) {
                return false;
            }
            return this.f11961e.mo2124c();
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean m16488a(boolean z, boolean z2, String str) {
        if (!this.f11962f) {
            return false;
        }
        try {
            if (!this.f11959c.getFullscreen_enabled().equals("1")) {
                return false;
            }
            long intValue;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                intValue = (((long) Integer.valueOf(this.f11959c.getFullscreen_interval()).intValue()) * 60) * 1000;
            } catch (Exception e) {
                intValue = 0;
            }
            if (z) {
                this.f11957a++;
            }
            if (currentTimeMillis - this.f11964h < intValue && this.f11964h != 0 && !z2) {
                return false;
            }
            if (z) {
                this.f11957a = 0;
                this.f11964h = currentTimeMillis;
                if (z) {
                    try {
                        if (this.f11961e != null) {
                            this.f11961e.mo2122b(str);
                        }
                    } catch (Exception e2) {
                    }
                }
                return true;
            }
            return true;
        } catch (Exception e3) {
            return false;
        }
    }

    /* renamed from: b */
    public void m16490b(String str) {
        if (this.f11962f) {
            try {
                if (this.f11959c.getFullscreen_enabled().equals("1")) {
                    try {
                        if (this.f11961e != null) {
                            this.f11961e.mo2123c(str);
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: f */
    public boolean m16494f() {
        if (this.f11962f && this.f11961e != null) {
            return this.f11961e.mo2127f();
        }
        return false;
    }

    /* renamed from: g */
    public boolean m16495g() {
        if (this.f11962f && this.f11961e != null) {
            return this.f11961e.mo2126e();
        }
        return false;
    }
}
