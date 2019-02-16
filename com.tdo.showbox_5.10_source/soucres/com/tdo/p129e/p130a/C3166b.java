package com.tdo.showbox.p129e.p130a;

import android.util.Log;
import com.tdo.showbox.activities.MainActivity;

/* compiled from: UiManagerGuard */
/* renamed from: com.tdo.showbox.e.a.b */
class C3166b {
    /* renamed from: a */
    private MainActivity f12260a;
    /* renamed from: b */
    private int f12261b = -1;
    /* renamed from: c */
    private int f12262c = -1;
    /* renamed from: d */
    private int f12263d = -1;

    C3166b() {
    }

    /* renamed from: a */
    protected final void m16897a(MainActivity mainActivity) {
        this.f12260a = mainActivity;
    }

    /* renamed from: C */
    public final MainActivity m16895C() {
        if (this.f12260a != null) {
            return this.f12260a;
        }
        Log.e("UI_OPERATION", "parent link is null, Ui manager can not work with null parent!!!!!!!!!!!!!!", m16892a());
        System.exit(0);
        return new MainActivity();
    }

    /* renamed from: a */
    private Throwable m16892a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        Throwable th = new Throwable();
        th.setStackTrace(stackTrace);
        return th;
    }

    /* renamed from: B */
    public int mo2142B() {
        if (this.f12261b == -1) {
            Log.e("UI_OPERATION", "missing fragment container id", m16892a());
            System.exit(0);
        }
        return this.f12261b;
    }

    /* renamed from: c */
    public void mo2146c(int i) {
        this.f12261b = i;
    }

    /* renamed from: A */
    public int mo2141A() {
        if (this.f12262c == -1) {
            Log.e("UI_OPERATION", "missing fragment fullscreen container id", m16892a());
            System.exit(0);
        }
        return this.f12262c;
    }

    /* renamed from: b */
    public void mo2145b(int i) {
        this.f12262c = i;
    }

    /* renamed from: z */
    public int mo2147z() {
        if (this.f12263d == -1) {
            Log.e("UI_OPERATION", "missing left menu container id", m16892a());
            System.exit(0);
        }
        return this.f12263d;
    }

    /* renamed from: a */
    public void mo2143a(int i) {
        this.f12263d = i;
    }
}
