package com.tdo.showbox.data.p114e;

import android.app.Activity;
import com.tdo.showbox.models.Subtitle;

/* compiled from: BasePlayManager */
/* renamed from: com.tdo.showbox.data.e.a */
public abstract class C3079a {
    /* renamed from: a */
    protected C2656a f12071a;
    /* renamed from: b */
    protected String f12072b;
    /* renamed from: c */
    protected boolean f12073c;
    /* renamed from: d */
    protected Activity f12074d;

    /* compiled from: BasePlayManager */
    /* renamed from: com.tdo.showbox.data.e.a$a */
    public interface C2656a {
        /* renamed from: a */
        void mo2022a(String str, boolean z, long j, long j2, int i);

        /* renamed from: j */
        void mo2023j();
    }

    /* renamed from: a */
    public abstract Subtitle mo2128a();

    /* renamed from: a */
    public void m16655a(Activity activity) {
        this.f12074d = activity;
    }

    /* renamed from: a */
    public void m16656a(C2656a c2656a) {
        this.f12071a = c2656a;
    }

    /* renamed from: a */
    public void m16657a(String str) {
        this.f12072b = str;
    }

    /* renamed from: b */
    public void mo2130b() {
    }

    /* renamed from: a */
    public void mo2129a(long j) {
    }
}
