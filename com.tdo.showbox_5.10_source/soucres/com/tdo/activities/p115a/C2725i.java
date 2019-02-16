package com.tdo.showbox.activities.p115a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.p129e.p130a.C3167a;

/* compiled from: TabNavigationActionBar */
/* renamed from: com.tdo.showbox.activities.a.i */
public class C2725i extends C2668a {
    /* renamed from: a */
    private Context f10999a;
    /* renamed from: b */
    private View f11000b;
    /* renamed from: c */
    private View f11001c;
    /* renamed from: d */
    private View f11002d;
    /* renamed from: e */
    private View f11003e;
    /* renamed from: f */
    private View f11004f;
    /* renamed from: g */
    private View f11005g;
    /* renamed from: h */
    private View f11006h;
    /* renamed from: i */
    private View f11007i;
    /* renamed from: j */
    private View f11008j;
    /* renamed from: k */
    private boolean f11009k = false;
    /* renamed from: l */
    private long f11010l = 0;

    /* compiled from: TabNavigationActionBar */
    /* renamed from: com.tdo.showbox.activities.a.i$1 */
    class C27201 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2725i f10994a;

        C27201(C2725i c2725i) {
            this.f10994a = c2725i;
        }

        public void onClick(View view) {
            this.f10994a.m15391j();
        }
    }

    /* compiled from: TabNavigationActionBar */
    /* renamed from: com.tdo.showbox.activities.a.i$2 */
    class C27212 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2725i f10995a;

        C27212(C2725i c2725i) {
            this.f10995a = c2725i;
        }

        public void onClick(View view) {
            this.f10995a.m15389h();
        }
    }

    /* compiled from: TabNavigationActionBar */
    /* renamed from: com.tdo.showbox.activities.a.i$3 */
    class C27223 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2725i f10996a;

        C27223(C2725i c2725i) {
            this.f10996a = c2725i;
        }

        public void onClick(View view) {
            this.f10996a.m15387f();
        }
    }

    /* compiled from: TabNavigationActionBar */
    /* renamed from: com.tdo.showbox.activities.a.i$4 */
    class C27234 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2725i f10997a;

        C27234(C2725i c2725i) {
            this.f10997a = c2725i;
        }

        public void onClick(View view) {
            this.f10997a.m15384d();
        }
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f10999a = context;
        this.f11009k = context.getResources().getBoolean(R.bool.portrait_only);
        this.f11000b = LayoutInflater.from(context).inflate(R.layout.tab_navigation_action_bar, null, false);
        this.f11005g = this.f11000b.findViewById(R.id.movie_marker);
        this.f11006h = this.f11000b.findViewById(R.id.show_marker);
        this.f11007i = this.f11000b.findViewById(R.id.updates_marker);
        this.f11008j = this.f11000b.findViewById(R.id.library_marker);
        this.f11001c = this.f11000b.findViewById(R.id.txtv_shows_tab);
        this.f11004f = this.f11000b.findViewById(R.id.txtv_library_tab);
        this.f11003e = this.f11000b.findViewById(R.id.txtv_update_tab);
        this.f11002d = this.f11000b.findViewById(R.id.txtv_movies_tab);
        this.f11002d.setOnClickListener(new C27201(this));
        this.f11001c.setOnClickListener(new C27212(this));
        this.f11004f.setOnClickListener(new C27223(this));
        this.f11003e.setOnClickListener(new C27234(this));
        int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
        ((TextView) this.f11000b.findViewById(R.id.txtv_all_couner)).setText(c == 0 ? "" : "" + c);
        m15382c();
        return this.f11000b;
    }

    /* renamed from: c */
    private void m15382c() {
        switch (C3167a.m16903a().m16943w()) {
            case SHOWS:
                m15390i();
                return;
            case MY_LIB:
                m15388g();
                return;
            case UPDATE:
                m15386e();
                return;
            default:
                m15392k();
                return;
        }
    }

    /* renamed from: d */
    private void m15384d() {
        if (m15395b()) {
            m15386e();
            C3167a.m16903a().m16931k();
        }
    }

    /* renamed from: e */
    private void m15386e() {
        m15393l();
        this.f11007i.setVisibility(0);
    }

    /* renamed from: f */
    private void m15387f() {
        if (m15395b()) {
            m15388g();
            C3167a.m16903a().m16930j();
        }
    }

    /* renamed from: g */
    private void m15388g() {
        m15393l();
        this.f11008j.setVisibility(0);
    }

    /* renamed from: h */
    private void m15389h() {
        if (m15395b()) {
            m15390i();
            if (this.f11009k) {
                C3167a.m16903a().m16929i();
            } else {
                C3167a.m16903a().m16928h();
            }
        }
    }

    /* renamed from: i */
    private void m15390i() {
        m15393l();
        this.f11006h.setVisibility(0);
    }

    /* renamed from: j */
    private void m15391j() {
        if (m15395b()) {
            m15392k();
            if (this.f11009k) {
                C3167a.m16903a().m16927g();
            } else {
                C3167a.m16903a().m16926f();
            }
        }
    }

    /* renamed from: k */
    private void m15392k() {
        m15393l();
        this.f11005g.setVisibility(0);
    }

    /* renamed from: l */
    private void m15393l() {
        this.f11006h.setVisibility(4);
        this.f11005g.setVisibility(4);
        this.f11007i.setVisibility(4);
        this.f11008j.setVisibility(4);
    }

    /* renamed from: b */
    public boolean m15395b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f11010l <= 350) {
            return false;
        }
        this.f11010l = currentTimeMillis;
        return true;
    }
}
