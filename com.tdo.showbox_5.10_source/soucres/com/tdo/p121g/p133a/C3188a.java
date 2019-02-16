package com.tdo.showbox.p121g.p133a;

/* compiled from: AdapterItemRule */
/* renamed from: com.tdo.showbox.g.a.a */
public class C3188a {
    /* renamed from: a */
    protected final int f12280a;
    /* renamed from: b */
    protected final float[] f12281b;

    public C3188a() {
        this(1);
    }

    public C3188a(int i) {
        this.f12280a = i;
        this.f12281b = mo2149b();
    }

    /* renamed from: b */
    private float[] mo2149b() {
        float[] fArr = new float[this.f12280a];
        for (int i = 0; i < this.f12280a; i++) {
            fArr[i] = m16994b(i);
        }
        return fArr;
    }

    /* renamed from: a */
    public int m16993a() {
        return this.f12280a;
    }

    /* renamed from: a */
    public float m16992a(int i) {
        return i > this.f12280a ? 0.0f : this.f12281b[i];
    }

    /* renamed from: b */
    protected float m16994b(int i) {
        if (i > m16993a()) {
            return 0.0f;
        }
        return 1.0f / ((float) m16993a());
    }
}
