package com.tdo.showbox.p117b;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p129e.p130a.C3167a.C3164a;

/* compiled from: LeftMenuFragment */
/* renamed from: com.tdo.showbox.b.d */
public class C2853d extends C2769a {
    /* renamed from: c */
    private View f11340c;
    /* renamed from: d */
    private View f11341d;
    /* renamed from: e */
    private View f11342e;
    /* renamed from: f */
    private View f11343f;
    /* renamed from: g */
    private View f11344g;
    /* renamed from: h */
    private View f11345h;
    /* renamed from: i */
    private View f11346i;
    /* renamed from: j */
    private View f11347j;
    /* renamed from: k */
    private View f11348k;
    /* renamed from: l */
    private TextView f11349l;
    /* renamed from: m */
    private View f11350m;
    /* renamed from: n */
    private TextView f11351n;
    /* renamed from: o */
    private TextView f11352o;

    /* compiled from: LeftMenuFragment */
    /* renamed from: com.tdo.showbox.b.d$1 */
    class C28361 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2853d f11323a;

        /* compiled from: LeftMenuFragment */
        /* renamed from: com.tdo.showbox.b.d$1$1 */
        class C28351 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C28361 f11322a;

            C28351(C28361 c28361) {
                this.f11322a = c28361;
            }

            public void run() {
                C3167a.m16903a().m16935o();
                this.f11322a.f11323a.m15836b();
            }
        }

        C28361(C2853d c2853d) {
            this.f11323a = c2853d;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16921c();
            new Handler(Looper.getMainLooper()).postDelayed(new C28351(this), 400);
        }
    }

    /* compiled from: LeftMenuFragment */
    /* renamed from: com.tdo.showbox.b.d$2 */
    class C28382 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2853d f11325a;

        /* compiled from: LeftMenuFragment */
        /* renamed from: com.tdo.showbox.b.d$2$1 */
        class C28371 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C28382 f11324a;

            C28371(C28382 c28382) {
                this.f11324a = c28382;
            }

            public void run() {
                C3167a.m16903a().m16936p();
                this.f11324a.f11325a.m15836b();
            }
        }

        C28382(C2853d c2853d) {
            this.f11325a = c2853d;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16921c();
            new Handler(Looper.getMainLooper()).postDelayed(new C28371(this), 400);
        }
    }

    /* compiled from: LeftMenuFragment */
    /* renamed from: com.tdo.showbox.b.d$3 */
    class C28403 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2853d f11327a;

        /* compiled from: LeftMenuFragment */
        /* renamed from: com.tdo.showbox.b.d$3$1 */
        class C28391 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C28403 f11326a;

            C28391(C28403 c28403) {
                this.f11326a = c28403;
            }

            public void run() {
                C3167a.m16903a().m16938r();
                this.f11326a.f11327a.m15836b();
            }
        }

        C28403(C2853d c2853d) {
            this.f11327a = c2853d;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16921c();
            new Handler(Looper.getMainLooper()).postDelayed(new C28391(this), 400);
        }
    }

    /* compiled from: LeftMenuFragment */
    /* renamed from: com.tdo.showbox.b.d$4 */
    class C28424 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2853d f11329a;

        /* compiled from: LeftMenuFragment */
        /* renamed from: com.tdo.showbox.b.d$4$1 */
        class C28411 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C28424 f11328a;

            C28411(C28424 c28424) {
                this.f11328a = c28424;
            }

            public void run() {
                C3167a.m16903a().m16937q();
                this.f11328a.f11329a.m15836b();
            }
        }

        C28424(C2853d c2853d) {
            this.f11329a = c2853d;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16921c();
            new Handler(Looper.getMainLooper()).postDelayed(new C28411(this), 400);
        }
    }

    /* compiled from: LeftMenuFragment */
    /* renamed from: com.tdo.showbox.b.d$5 */
    class C28445 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2853d f11331a;

        /* compiled from: LeftMenuFragment */
        /* renamed from: com.tdo.showbox.b.d$5$1 */
        class C28431 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C28445 f11330a;

            C28431(C28445 c28445) {
                this.f11330a = c28445;
            }

            public void run() {
                C3167a.m16903a().m16939s();
                this.f11330a.f11331a.m15836b();
            }
        }

        C28445(C2853d c2853d) {
            this.f11331a = c2853d;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16921c();
            new Handler(Looper.getMainLooper()).postDelayed(new C28431(this), 400);
        }
    }

    /* compiled from: LeftMenuFragment */
    /* renamed from: com.tdo.showbox.b.d$6 */
    class C28466 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2853d f11333a;

        /* compiled from: LeftMenuFragment */
        /* renamed from: com.tdo.showbox.b.d$6$1 */
        class C28451 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C28466 f11332a;

            C28451(C28466 c28466) {
                this.f11332a = c28466;
            }

            public void run() {
                C3167a.m16903a().m16940t();
                this.f11332a.f11333a.m15836b();
            }
        }

        C28466(C2853d c2853d) {
            this.f11333a = c2853d;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16921c();
            new Handler(Looper.getMainLooper()).postDelayed(new C28451(this), 400);
        }
    }

    /* compiled from: LeftMenuFragment */
    /* renamed from: com.tdo.showbox.b.d$7 */
    class C28487 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2853d f11335a;

        /* compiled from: LeftMenuFragment */
        /* renamed from: com.tdo.showbox.b.d$7$1 */
        class C28471 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C28487 f11334a;

            C28471(C28487 c28487) {
                this.f11334a = c28487;
            }

            public void run() {
                C3167a.m16903a().m16941u();
                this.f11334a.f11335a.m15836b();
            }
        }

        C28487(C2853d c2853d) {
            this.f11335a = c2853d;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16921c();
            new Handler(Looper.getMainLooper()).postDelayed(new C28471(this), 400);
        }
    }

    /* compiled from: LeftMenuFragment */
    /* renamed from: com.tdo.showbox.b.d$8 */
    class C28508 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2853d f11337a;

        /* compiled from: LeftMenuFragment */
        /* renamed from: com.tdo.showbox.b.d$8$1 */
        class C28491 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C28508 f11336a;

            C28491(C28508 c28508) {
                this.f11336a = c28508;
            }

            public void run() {
                if (C3167a.m16903a().m16942v()) {
                    C3167a.m16903a().m16933m();
                } else {
                    C3167a.m16903a().m16934n();
                }
                this.f11336a.f11337a.m15836b();
            }
        }

        C28508(C2853d c2853d) {
            this.f11337a = c2853d;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16921c();
            new Handler(Looper.getMainLooper()).postDelayed(new C28491(this), 400);
        }
    }

    /* compiled from: LeftMenuFragment */
    /* renamed from: com.tdo.showbox.b.d$9 */
    class C28529 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2853d f11339a;

        /* compiled from: LeftMenuFragment */
        /* renamed from: com.tdo.showbox.b.d$9$1 */
        class C28511 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C28529 f11338a;

            C28511(C28529 c28529) {
                this.f11338a = c28529;
            }

            public void run() {
                if (C3167a.m16903a().m16942v()) {
                    C3167a.m16903a().m16932l();
                } else {
                    C3167a.m16903a().m16926f();
                }
                this.f11338a.f11339a.m15836b();
            }
        }

        C28529(C2853d c2853d) {
            this.f11339a = c2853d;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16921c();
            new Handler(Looper.getMainLooper()).postDelayed(new C28511(this), 400);
        }
    }

    /* renamed from: a */
    public static C2853d m15823a() {
        return new C2853d();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.left_menu_fragment, null);
        m15829p();
        m15835v();
        m15834u();
        m15833t();
        m15828o();
        m15827n();
        m15831r();
        m15832s();
        m15830q();
        m15826m();
        m15825l();
        m15824k();
        return this.a;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: k */
    private void m15824k() {
        if (VERSION.SDK_INT >= 21) {
            Drawable rippleDrawable = new RippleDrawable(m15484h().getResources().getColorStateList(R.color.drawer_colors_state), new ColorDrawable(m15484h().getResources().getColor(R.color.menu_back_color)), new ColorDrawable(-256));
            this.f11340c.setBackground(rippleDrawable);
            this.f11341d.setBackground(rippleDrawable);
            this.f11342e.setBackground(rippleDrawable);
            this.f11343f.setBackground(rippleDrawable);
            this.f11344g.setBackground(rippleDrawable);
            return;
        }
        this.f11340c.setBackgroundResource(R.drawable.btn_left_navigation);
        this.f11341d.setBackgroundResource(R.drawable.btn_left_navigation);
        this.f11342e.setBackgroundResource(R.drawable.btn_left_navigation);
        this.f11343f.setBackgroundResource(R.drawable.btn_left_navigation);
        this.f11344g.setBackgroundResource(R.drawable.btn_left_navigation);
    }

    /* renamed from: l */
    private void m15825l() {
        this.f11351n = (TextView) this.a.findViewById(R.id.update_count);
        this.f11352o = (TextView) this.a.findViewById(R.id.download_count);
    }

    /* renamed from: m */
    private void m15826m() {
        this.f11349l = (TextView) this.a.findViewById(R.id.txtv_update_persents);
        this.f11350m = this.a.findViewById(R.id.update_indecator);
    }

    /* renamed from: n */
    private void m15827n() {
        this.f11343f = this.a.findViewById(R.id.update_container);
        this.f11343f.setOnClickListener(new C28361(this));
    }

    /* renamed from: o */
    private void m15828o() {
        this.f11344g = this.a.findViewById(R.id.download_container);
        this.f11344g.setOnClickListener(new C28382(this));
    }

    /* renamed from: p */
    private void m15829p() {
        this.f11347j = this.a.findViewById(R.id.trending_container);
        this.f11347j.setOnClickListener(new C28403(this));
    }

    /* renamed from: q */
    private void m15830q() {
        this.f11346i = this.a.findViewById(R.id.trailers_container);
        this.f11346i.setOnClickListener(new C28424(this));
    }

    /* renamed from: r */
    private void m15831r() {
        this.f11345h = this.a.findViewById(R.id.news_container);
        this.f11345h.setOnClickListener(new C28445(this));
    }

    /* renamed from: s */
    private void m15832s() {
        this.f11348k = this.a.findViewById(R.id.settings_container);
        this.f11348k.setOnClickListener(new C28466(this));
    }

    /* renamed from: t */
    private void m15833t() {
        this.f11342e = this.a.findViewById(R.id.favorite_container);
        this.f11342e.setOnClickListener(new C28487(this));
    }

    /* renamed from: u */
    private void m15834u() {
        this.f11341d = this.a.findViewById(R.id.show_container);
        this.f11341d.setOnClickListener(new C28508(this));
    }

    /* renamed from: v */
    private void m15835v() {
        this.f11340c = this.a.findViewById(R.id.movi_container);
        this.f11340c.setOnClickListener(new C28529(this));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void m15836b() {
        boolean z;
        boolean z2 = true;
        C3164a x = C3167a.m16903a().m16944x();
        this.f11340c.setSelected(x == C3164a.MOVIES);
        View view = this.f11341d;
        if (x == C3164a.SHOWS) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        view = this.f11342e;
        if (x == C3164a.FAVORITES) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        view = this.f11344g;
        if (x == C3164a.DOWNLOAD) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        view = this.f11343f;
        if (x == C3164a.UPDATES) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        view = this.f11346i;
        if (x == C3164a.TRAILERS) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        view = this.f11347j;
        if (x == C3164a.TRENDING) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        view = this.f11345h;
        if (x == C3164a.NEWS) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        View view2 = this.f11348k;
        if (x != C3164a.SETTINGS) {
            z2 = false;
        }
        view2.setSelected(z2);
    }

    /* renamed from: c */
    public void m15837c() {
        m15836b();
        m15838j();
    }

    /* renamed from: j */
    public void m15838j() {
        int size;
        int i = 0;
        try {
            size = new Select().from(DownloadEpisode.class).where("percent!=100 AND isDeleted=0").execute().size();
            try {
                i = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            size = i;
        }
        this.f11351n.setText(i == 0 ? "" : String.valueOf(i));
        this.f11352o.setText(size == 0 ? "" : String.valueOf(size));
    }
}
