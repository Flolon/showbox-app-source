package com.tdo.showbox.activities.p115a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tdo.showbox.R;
import com.tdo.showbox.p129e.p130a.C3167a;

/* compiled from: MovieDetailsBar */
/* renamed from: com.tdo.showbox.activities.a.d */
public class C2695d extends C2668a {
    /* renamed from: a */
    public boolean f10938a = false;
    /* renamed from: b */
    private Context f10939b;
    /* renamed from: c */
    private View f10940c;
    /* renamed from: d */
    private C2692a f10941d;
    /* renamed from: e */
    private C2694c f10942e;
    /* renamed from: f */
    private C2693b f10943f;
    /* renamed from: g */
    private View f10944g;

    /* compiled from: MovieDetailsBar */
    /* renamed from: com.tdo.showbox.activities.a.d$1 */
    class C26881 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2695d f10934a;

        C26881(C2695d c2695d) {
            this.f10934a = c2695d;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16924d();
        }
    }

    /* compiled from: MovieDetailsBar */
    /* renamed from: com.tdo.showbox.activities.a.d$2 */
    class C26892 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2695d f10935a;

        C26892(C2695d c2695d) {
            this.f10935a = c2695d;
        }

        public void onClick(View view) {
            if (this.f10935a.f10941d != null) {
                this.f10935a.f10941d.mo2051a();
            }
        }
    }

    /* compiled from: MovieDetailsBar */
    /* renamed from: com.tdo.showbox.activities.a.d$3 */
    class C26903 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2695d f10936a;

        C26903(C2695d c2695d) {
            this.f10936a = c2695d;
        }

        public void onClick(View view) {
            if (this.f10936a.f10942e != null) {
                this.f10936a.f10942e.mo2055c();
            }
        }
    }

    /* compiled from: MovieDetailsBar */
    /* renamed from: com.tdo.showbox.activities.a.d$4 */
    class C26914 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2695d f10937a;

        C26914(C2695d c2695d) {
            this.f10937a = c2695d;
        }

        public void onClick(View view) {
            if (this.f10937a.f10943f != null) {
                this.f10937a.f10943f.mo2054b();
            }
        }
    }

    /* compiled from: MovieDetailsBar */
    /* renamed from: com.tdo.showbox.activities.a.d$a */
    public interface C2692a {
        /* renamed from: a */
        void mo2051a();
    }

    /* compiled from: MovieDetailsBar */
    /* renamed from: com.tdo.showbox.activities.a.d$b */
    public interface C2693b {
        /* renamed from: b */
        void mo2054b();
    }

    /* compiled from: MovieDetailsBar */
    /* renamed from: com.tdo.showbox.activities.a.d$c */
    public interface C2694c {
        /* renamed from: c */
        void mo2055c();
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f10939b = context;
        this.f10940c = LayoutInflater.from(context).inflate(R.layout.movie_detail_bar, null, false);
        m15317c();
        m15319e();
        m15318d();
        m15320f();
        m15315b();
        return this.f10940c;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private void m15315b() {
        if (VERSION.SDK_INT >= 21) {
            ColorStateList colorStateList = this.f10939b.getResources().getColorStateList(R.color.drawer_colors_state);
            this.f10940c.findViewById(R.id.options_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10939b.getDrawable(R.drawable.filter_ripple)));
            this.f10940c.findViewById(R.id.share_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10939b.getDrawable(R.drawable.riple)));
            this.f10940c.findViewById(R.id.fav_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10939b.getDrawable(R.drawable.riple)));
            this.f10940c.findViewById(R.id.back_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10939b.getDrawable(R.drawable.riple)));
        }
    }

    /* renamed from: c */
    private void m15317c() {
        this.f10940c.findViewById(R.id.back_btn).setOnClickListener(new C26881(this));
    }

    /* renamed from: d */
    private void m15318d() {
        this.f10944g = this.f10940c.findViewById(R.id.fav_btn_);
        this.f10940c.findViewById(R.id.fav_btn).setOnClickListener(new C26892(this));
        this.f10944g.setSelected(this.f10938a);
    }

    /* renamed from: e */
    private void m15319e() {
        this.f10940c.findViewById(R.id.share_btn).setOnClickListener(new C26903(this));
    }

    /* renamed from: f */
    private void m15320f() {
        this.f10940c.findViewById(R.id.options_btn).setOnClickListener(new C26914(this));
    }

    /* renamed from: a */
    public void m15325a(boolean z) {
        this.f10938a = z;
        if (this.f10944g != null) {
            this.f10944g.setSelected(this.f10938a);
        }
    }

    /* renamed from: a */
    public void m15322a(C2692a c2692a) {
        this.f10941d = c2692a;
    }

    /* renamed from: a */
    public void m15324a(C2694c c2694c) {
        this.f10942e = c2694c;
    }

    /* renamed from: a */
    public void m15323a(C2693b c2693b) {
        this.f10943f = c2693b;
    }

    /* renamed from: b */
    public void m15326b(boolean z) {
        try {
            this.f10940c.findViewById(R.id.options_btn).setEnabled(z);
            this.f10940c.findViewById(R.id.options_btn_).setEnabled(z);
        } catch (Exception e) {
        }
    }
}
