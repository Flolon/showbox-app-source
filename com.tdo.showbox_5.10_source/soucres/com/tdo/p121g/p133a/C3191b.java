package com.tdo.showbox.p121g.p133a;

import java.util.HashMap;

/* compiled from: AdapterRowRule */
/* renamed from: com.tdo.showbox.g.a.b */
public class C3191b {
    /* renamed from: a */
    private HashMap<Integer, C3188a> f12283a = new HashMap();
    /* renamed from: b */
    private C3189e f12284b;

    /* compiled from: AdapterRowRule */
    /* renamed from: com.tdo.showbox.g.a.b$1 */
    class C31901 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3191b f12282a;

        C31901(C3191b c3191b) {
            this.f12282a = c3191b;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            return ((Integer) this.f12282a.f12283a.keySet().iterator().next()).intValue();
        }
    }

    public C3191b() {
        m16999b();
        m16998a();
    }

    /* renamed from: a */
    private void m16998a() {
        this.f12283a.put(Integer.valueOf(0), new C3188a(0));
    }

    /* renamed from: b */
    private void m16999b() {
        this.f12284b = new C31901(this);
    }

    /* renamed from: a */
    public void m17001a(int i, C3188a c3188a) {
        this.f12283a.put(Integer.valueOf(i), c3188a);
    }

    /* renamed from: a */
    public C3188a m17000a(int i) {
        return (C3188a) this.f12283a.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public void m17002a(C3189e c3189e) {
        this.f12284b = c3189e;
    }

    /* renamed from: b */
    public C3195d m17003b(int i) {
        C3195d c3195d = new C3195d();
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            int a = this.f12284b.mo2148a(i2);
            C3188a c3188a = (C3188a) this.f12283a.get(Integer.valueOf(a));
            c3195d.f12293c.add(Integer.valueOf(a));
            c3195d.f12292b.add(Integer.valueOf(i3));
            c3195d.f12291a = i2;
            i3 += c3188a.m16993a();
            i2++;
        }
        c3195d.f12291a = i2;
        return c3195d;
    }
}
