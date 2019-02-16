package com.tdo.showbox.p129e.p130a;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.p113d.C2973e;
import com.tdo.showbox.p117b.C2769a;
import com.tdo.showbox.p117b.C2770b;
import com.tdo.showbox.p117b.C2834c;
import com.tdo.showbox.p117b.C2853d;
import com.tdo.showbox.p117b.C2855e;
import com.tdo.showbox.p117b.C2867f;
import com.tdo.showbox.p117b.C2880h;
import com.tdo.showbox.p117b.C2886i;
import com.tdo.showbox.p117b.C2902j;
import com.tdo.showbox.p117b.C2914k;
import com.tdo.showbox.p117b.C2940n;
import com.tdo.showbox.p117b.C2950o;
import com.tdo.showbox.p117b.C2963p;
import com.tdo.showbox.p117b.C2967q;
import com.tdo.showbox.p117b.p118a.C2788b;
import com.tdo.showbox.p117b.p118a.C2801c;
import com.tdo.showbox.p117b.p118a.C2821d;
import java.util.Stack;

/* compiled from: UiManager */
/* renamed from: com.tdo.showbox.e.a.a */
public class C3167a extends C3166b implements C2973e {
    /* renamed from: a */
    public static C3167a f12264a = null;
    /* renamed from: b */
    private Stack<C2769a> f12265b = new Stack();
    /* renamed from: c */
    private C3165b f12266c = C3165b.NOTHING;
    /* renamed from: d */
    private C2853d f12267d;
    /* renamed from: e */
    private C3164a f12268e = C3164a.NOTHING;
    /* renamed from: f */
    private boolean f12269f = false;

    /* compiled from: UiManager */
    /* renamed from: com.tdo.showbox.e.a.a$a */
    public enum C3164a {
        MOVIES,
        SHOWS,
        FAVORITES,
        DOWNLOAD,
        UPDATES,
        selectMenuItem,
        NOTHING,
        TRAILERS,
        NEWS,
        TRENDING,
        SETTINGS
    }

    /* compiled from: UiManager */
    /* renamed from: com.tdo.showbox.e.a.a$b */
    public enum C3165b {
        MOVIES,
        SHOWS,
        MY_LIB,
        UPDATE,
        NOTHING
    }

    /* renamed from: A */
    public /* bridge */ /* synthetic */ int mo2141A() {
        return super.mo2141A();
    }

    /* renamed from: B */
    public /* bridge */ /* synthetic */ int mo2142B() {
        return super.mo2142B();
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ void mo2146c(int i) {
        super.mo2146c(i);
    }

    /* renamed from: z */
    public /* bridge */ /* synthetic */ int mo2147z() {
        return super.mo2147z();
    }

    /* renamed from: a */
    public static C3167a m16903a() {
        if (f12264a == null) {
            f12264a = new C3167a();
        }
        return f12264a;
    }

    /* renamed from: a */
    public void m16911a(MainActivity mainActivity, int i, int i2, int i3) {
        m16897a(mainActivity);
        mo2146c(i);
        mo2145b(i2);
        mo2143a(i3);
        m16895C().m15153a((C2973e) this);
        m16901D();
    }

    /* renamed from: D */
    private void m16901D() {
        this.f12267d = C2853d.m15823a();
        FragmentTransaction a = m16895C().getSupportFragmentManager().mo59a();
        a.mo22a(mo2147z(), this.f12267d);
        a.mo26b();
    }

    /* renamed from: b */
    public void m16917b() {
        m16895C().m15169p();
        if (this.f12267d != null) {
            this.f12267d.m15837c();
        }
        this.f12269f = true;
    }

    /* renamed from: c */
    public void m16921c() {
        m16895C().m15170q();
        this.f12269f = false;
    }

    /* renamed from: a */
    private void m16906a(C2769a c2769a, boolean z, boolean z2, boolean z3) {
        if (c2769a != null && !m16895C().isFinishing() && !m16895C().isChangingConfigurations()) {
            if (VERSION.SDK_INT <= 17 || !m16895C().isDestroyed()) {
                boolean g;
                m16904a(c2769a);
                boolean g2 = c2769a.m15483g();
                C2769a e = m16925e();
                if (e != null) {
                    g = e.m15483g();
                } else {
                    g = false;
                }
                if (z2) {
                    this.f12265b.push(c2769a);
                }
                FragmentTransaction a = m16895C().getSupportFragmentManager().mo59a();
                if (z) {
                    a.mo21a((int) R.anim.fade_in, (int) R.anim.fade_out);
                }
                if (g2) {
                    m16895C().findViewById(mo2141A()).setVisibility(0);
                    if (g) {
                        m16895C().findViewById(mo2142B()).setVisibility(4);
                    }
                    a.mo22a(mo2141A(), (Fragment) c2769a);
                } else {
                    ((ViewGroup) m16895C().findViewById(mo2141A())).removeAllViews();
                    m16895C().findViewById(mo2141A()).setVisibility(4);
                    if (z3) {
                        ((ViewGroup) m16895C().findViewById(mo2142B())).removeAllViews();
                    }
                    m16895C().findViewById(mo2142B()).setVisibility(0);
                    a.mo22a(mo2142B(), (Fragment) c2769a);
                }
                a.mo26b();
                try {
                    m16895C().mo2006i();
                } catch (Exception e2) {
                }
            }
        }
    }

    /* renamed from: a */
    private void m16905a(C2769a c2769a, boolean z, boolean z2) {
        m16906a(c2769a, z, z2, false);
    }

    /* renamed from: E */
    private void m16902E() {
        try {
            Fragment fragment = (C2769a) this.f12265b.elementAt(this.f12265b.size() - 2);
            m16904a((C2769a) fragment);
            C2769a c2769a = (C2769a) this.f12265b.pop();
            boolean g = fragment.m15483g();
            C2769a e = m16925e();
            if (e != null) {
                e.m15483g();
            }
            FragmentTransaction a = m16895C().getSupportFragmentManager().mo59a();
            a.mo21a((int) R.anim.fade_in, (int) R.anim.fade_out);
            if (g) {
                m16895C().findViewById(mo2141A()).setVisibility(0);
                a.mo22a(mo2141A(), fragment);
            } else if (e.getClass() == fragment.getClass()) {
                ((ViewGroup) m16895C().findViewById(mo2141A())).removeAllViews();
                m16895C().findViewById(mo2141A()).setVisibility(4);
                m16895C().findViewById(mo2142B()).setVisibility(0);
                a.mo22a(mo2142B(), fragment);
            } else {
                m16895C().findViewById(mo2142B()).setVisibility(0);
                a.mo22a(mo2142B(), fragment);
            }
            a.mo26b();
            if (g) {
                m16895C().getSupportFragmentManager().mo59a().mo24a(c2769a).mo26b();
            }
        } catch (Exception e2) {
            m16895C().finish();
        }
    }

    /* renamed from: a */
    private void m16904a(C2769a c2769a) {
        C2668a z = m16895C().m15179z();
        if (m16895C().m15148L()) {
            m16895C().m15151a(c2769a.mo2050a(z));
        } else {
            m16895C().m15151a(c2769a.mo2053b(z));
        }
    }

    /* renamed from: d */
    public void m16924d() {
        if (this.f12269f) {
            m16921c();
            return;
        }
        try {
            if (!((C2769a) this.f12265b.lastElement()).m15485i()) {
                if (this.f12265b.size() == 1) {
                    try {
                        m16895C().getSupportFragmentManager().mo59a().mo24a((Fragment) this.f12265b.remove(0)).mo26b();
                        this.f12265b.clear();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    m16895C().m15178y();
                    return;
                }
                m16902E();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            m16895C().m15178y();
        }
    }

    /* renamed from: e */
    public C2769a m16925e() {
        return this.f12265b.size() == 0 ? null : (C2769a) this.f12265b.peek();
    }

    /* renamed from: f */
    public void m16926f() {
        this.f12266c = C3165b.MOVIES;
        this.f12268e = C3164a.MOVIES;
        this.f12265b.clear();
        m16905a(new C2867f(), true, true);
    }

    /* renamed from: g */
    public void m16927g() {
        this.f12266c = C3165b.MOVIES;
        this.f12265b.clear();
        m16905a(new C2788b(), true, true);
    }

    /* renamed from: h */
    public void m16928h() {
        this.f12266c = C3165b.SHOWS;
        this.f12265b.clear();
        m16905a(new C2914k(), true, true);
    }

    /* renamed from: i */
    public void m16929i() {
        this.f12266c = C3165b.SHOWS;
        this.f12265b.clear();
        m16905a(new C2801c(), true, true);
    }

    /* renamed from: j */
    public void m16930j() {
        this.f12266c = C3165b.MY_LIB;
        this.f12265b.clear();
        m16905a(new C2855e(), true, true);
    }

    /* renamed from: k */
    public void m16931k() {
        this.f12266c = C3165b.UPDATE;
        this.f12265b.clear();
        m16905a(new C2967q(), true, true);
    }

    /* renamed from: l */
    public void m16932l() {
        this.f12268e = C3164a.MOVIES;
        this.f12265b.clear();
        m16905a(new C2788b(), true, true);
    }

    /* renamed from: m */
    public void m16933m() {
        boolean z = false;
        C2769a e = C3167a.m16903a().m16925e();
        if (e != null && e.m15483g() && this.f12268e == C3164a.MOVIES) {
            z = true;
        }
        this.f12268e = C3164a.SHOWS;
        this.f12265b.clear();
        m16906a(new C2801c(), true, true, z);
    }

    /* renamed from: n */
    public void m16934n() {
        boolean z = false;
        C2769a e = C3167a.m16903a().m16925e();
        if (e != null && e.m15483g() && this.f12268e == C3164a.MOVIES) {
            z = true;
        }
        this.f12268e = C3164a.SHOWS;
        this.f12265b.clear();
        m16906a(new C2914k(), true, true, z);
    }

    /* renamed from: o */
    public void m16935o() {
        if (this.f12265b == null || this.f12265b.size() <= 0 || !(this.f12265b.peek() instanceof C2967q)) {
            this.f12268e = C3164a.UPDATES;
            this.f12265b.clear();
            m16905a(new C2967q(), true, true);
        }
    }

    /* renamed from: p */
    public void m16936p() {
        this.f12268e = C3164a.DOWNLOAD;
        this.f12265b.clear();
        m16905a(new C2834c(), true, true);
    }

    /* renamed from: q */
    public void m16937q() {
        this.f12268e = C3164a.TRAILERS;
        this.f12265b.clear();
        m16905a(C2950o.m16169a(), true, true);
    }

    /* renamed from: r */
    public void m16938r() {
        this.f12268e = C3164a.TRENDING;
        this.f12265b.clear();
        m16905a(C2963p.m16199a(), true, true);
    }

    /* renamed from: s */
    public void m16939s() {
        this.f12268e = C3164a.NEWS;
        this.f12265b.clear();
        m16905a(C2880h.m15897b(), true, true);
    }

    /* renamed from: t */
    public void m16940t() {
        this.f12268e = C3164a.SETTINGS;
        this.f12265b.clear();
        m16905a(C2886i.m15917a(), true, true);
    }

    /* renamed from: a */
    public void m16916a(boolean z) {
        if (z) {
            C3088f.m16677a("PREF_NEWS_SUB_TAB", 1);
        } else {
            C3088f.m16677a("PREF_NEWS_SUB_TAB", 0);
        }
        m16939s();
    }

    /* renamed from: a */
    public void m16914a(String str, boolean z, String str2) {
        C2769a c2801c;
        this.f12268e = C3164a.SHOWS;
        this.f12265b.clear();
        if (C3167a.m16903a().m16942v()) {
            c2801c = new C2801c();
        } else {
            c2801c = new C2914k();
        }
        Bundle bundle = new Bundle();
        bundle.putString("showId", str);
        bundle.putBoolean("openLastSeason", z);
        bundle.putString("from", str2);
        c2801c.setArguments(bundle);
        m16906a(c2801c, true, true, false);
    }

    /* renamed from: a */
    public void m16913a(String str, String str2) {
        C2769a c2788b;
        this.f12268e = C3164a.MOVIES;
        if (m16895C().m15148L()) {
            c2788b = new C2788b();
        } else {
            this.f12266c = C3165b.MOVIES;
            c2788b = new C2867f();
        }
        Bundle bundle = new Bundle();
        bundle.putString("movieId", str);
        bundle.putString("from", str2);
        c2788b.setArguments(bundle);
        this.f12265b.clear();
        m16905a(c2788b, true, true);
    }

    /* renamed from: u */
    public void m16941u() {
        this.f12268e = C3164a.FAVORITES;
        this.f12265b.clear();
        m16905a(new C2855e(), true, true);
    }

    /* renamed from: b */
    public void m16920b(boolean z) {
        try {
            if (m16895C().getIntent().getBooleanExtra("fromNewPush", false)) {
                String stringExtra = m16895C().getIntent().getStringExtra("itemId");
                boolean booleanExtra = m16895C().getIntent().getBooleanExtra("isMovie", false);
                boolean booleanExtra2 = m16895C().getIntent().getBooleanExtra("openLastSeason", false);
                String stringExtra2 = m16895C().getIntent().getStringExtra("from");
                C3094j.m16698a("showStartupFragment", "itemID: " + stringExtra);
                C3094j.m16698a("showStartupFragment", "isShow: " + booleanExtra);
                C3094j.m16698a("showStartupFragment", "openLastSeason: " + booleanExtra2);
                C3094j.m16698a("showStartupFragment", "from: " + stringExtra2);
                if (booleanExtra) {
                    m16914a(stringExtra, booleanExtra2, stringExtra2);
                    return;
                } else {
                    m16913a(stringExtra, stringExtra2);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        m16895C().m15168o().m16844a(m16895C().m15142F(), null);
        m16938r();
    }

    /* renamed from: v */
    public boolean m16942v() {
        return m16895C().m15148L();
    }

    /* renamed from: a */
    public void m16915a(String str, boolean z, boolean z2) {
        m16905a(C2770b.m15486a(m16895C(), str, z, z2), true, true);
        m16895C().m15138B();
    }

    /* renamed from: b */
    public void m16919b(String str, String str2) {
        m16905a(m16942v() ? C2821d.m15726a(str, str2, false) : C2902j.m15937a(str, str2, false), true, true);
        m16895C().m15138B();
    }

    /* renamed from: a */
    public void m16912a(String str) {
        m16905a(C2940n.m16129a(m16895C(), str), true, true);
        m16895C().m15138B();
    }

    /* renamed from: c */
    public void m16923c(String str, String str2) {
        m16905a(m16942v() ? C2821d.m15726a(str, str2, true) : C2902j.m15937a(str, str2, true), true, true);
        m16895C().m15138B();
    }

    /* renamed from: a */
    public void mo2144a(int i, int i2, Intent intent) {
        if (this.f12265b != null && this.f12265b.size() > 0) {
            ((C2769a) this.f12265b.lastElement()).onActivityResult(i, i2, intent);
        }
    }

    /* renamed from: w */
    public C3165b m16943w() {
        return this.f12266c;
    }

    /* renamed from: x */
    public C3164a m16944x() {
        return this.f12268e;
    }

    /* renamed from: y */
    public C2853d m16945y() {
        return this.f12267d;
    }
}
