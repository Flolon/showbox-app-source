package com.tdo.showbox.activities;

import android.support.v7.app.C0505e;
import com.activeandroid.query.Select;
import com.tdo.showbox.data.p119b.C3044d;
import com.tdo.showbox.data.p119b.C3047g;
import com.tdo.showbox.models.AppConfig;
import com.tdo.showbox.p113d.C2630b;

/* compiled from: AdWaiterActivity */
/* renamed from: com.tdo.showbox.activities.a */
public class C2631a extends C0505e implements C2630b {
    /* renamed from: a */
    protected C3047g f10750a;
    /* renamed from: b */
    private C3044d f10751b;

    /* renamed from: a */
    public C3044d m15076a() {
        if (this.f10751b == null) {
            this.f10751b = new C3044d();
            this.f10751b.m16466a(mo2004b());
            this.f10751b.m16465a((C2630b) this);
        }
        return this.f10751b;
    }

    /* renamed from: a */
    public void m15077a(C3047g c3047g) {
        this.f10750a = c3047g;
    }

    /* renamed from: b */
    public C3047g mo2004b() {
        if (this.f10750a == null) {
            this.f10750a = new C3047g(this, (AppConfig) new Select().from(AppConfig.class).executeSingle(), null);
        }
        return this.f10750a;
    }

    /* renamed from: c */
    public void mo2005c() {
    }

    /* renamed from: d */
    public void mo1997d() {
    }

    /* renamed from: e */
    public void mo1998e() {
    }

    /* renamed from: f */
    public void mo1999f() {
    }

    /* renamed from: g */
    public void mo2000g() {
    }

    /* renamed from: h */
    public void mo2001h() {
    }
}
