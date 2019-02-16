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
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.p129e.p130a.C3167a;

/* compiled from: NewsBar */
/* renamed from: com.tdo.showbox.activities.a.g */
public class C2717g extends C2668a {
    /* renamed from: a */
    private Context f10978a;
    /* renamed from: b */
    private View f10979b;
    /* renamed from: c */
    private C2716a f10980c;
    /* renamed from: d */
    private View f10981d;
    /* renamed from: e */
    private View f10982e;
    /* renamed from: f */
    private View f10983f;
    /* renamed from: g */
    private int f10984g = -1;
    /* renamed from: h */
    private String f10985h;
    /* renamed from: i */
    private String f10986i;
    /* renamed from: j */
    private String f10987j;
    /* renamed from: k */
    private TextView f10988k;
    /* renamed from: l */
    private TextView f10989l;
    /* renamed from: m */
    private TextView f10990m;

    /* compiled from: NewsBar */
    /* renamed from: com.tdo.showbox.activities.a.g$1 */
    class C27121 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2717g f10974a;

        C27121(C2717g c2717g) {
            this.f10974a = c2717g;
        }

        public void onClick(View view) {
            this.f10974a.f10984g = 2;
            this.f10974a.m15366f();
        }
    }

    /* compiled from: NewsBar */
    /* renamed from: com.tdo.showbox.activities.a.g$2 */
    class C27132 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2717g f10975a;

        C27132(C2717g c2717g) {
            this.f10975a = c2717g;
        }

        public void onClick(View view) {
            this.f10975a.f10984g = 1;
            this.f10975a.m15366f();
        }
    }

    /* compiled from: NewsBar */
    /* renamed from: com.tdo.showbox.activities.a.g$3 */
    class C27143 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2717g f10976a;

        C27143(C2717g c2717g) {
            this.f10976a = c2717g;
        }

        public void onClick(View view) {
            this.f10976a.f10984g = 0;
            this.f10976a.m15366f();
        }
    }

    /* compiled from: NewsBar */
    /* renamed from: com.tdo.showbox.activities.a.g$4 */
    class C27154 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2717g f10977a;

        C27154(C2717g c2717g) {
            this.f10977a = c2717g;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16917b();
        }
    }

    /* compiled from: NewsBar */
    /* renamed from: com.tdo.showbox.activities.a.g$a */
    public interface C2716a {
        /* renamed from: a */
        void mo2077a(int i);
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f10978a = context;
        this.f10979b = LayoutInflater.from(context).inflate(R.layout.news_action_bar, null, false);
        m15370j();
        m15367g();
        m15368h();
        m15369i();
        m15375c();
        m15365e();
        m15364d();
        m15374b();
        return this.f10979b;
    }

    /* renamed from: b */
    public void m15374b() {
        int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
        if (this.f10979b != null) {
            TextView textView = (TextView) this.f10979b.findViewById(R.id.update_count);
            if (textView == null || c <= 0) {
                textView.setVisibility(4);
                return;
            }
            textView.setVisibility(0);
            textView.setText("" + c);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    private void m15364d() {
        if (VERSION.SDK_INT >= 21) {
            ColorStateList colorStateList = this.f10978a.getResources().getColorStateList(R.color.drawer_colors_state);
            this.f10981d.setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f10982e.setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f10983f.setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f10979b.findViewById(R.id.menu).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10978a.getDrawable(R.drawable.menu_ripple)));
        }
    }

    /* renamed from: c */
    public void m15375c() {
        this.f10988k = (TextView) this.f10979b.findViewById(R.id.movies_counr);
        this.f10988k.setText(this.f10987j);
        this.f10989l = (TextView) this.f10979b.findViewById(R.id.show_counter);
        this.f10989l.setText(this.f10986i);
        this.f10990m = (TextView) this.f10979b.findViewById(R.id.my_counter);
        this.f10990m.setText(this.f10985h);
    }

    /* renamed from: e */
    private void m15365e() {
        boolean z;
        boolean z2 = true;
        View view = this.f10983f;
        if (this.f10984g == 2) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        view = this.f10982e;
        if (this.f10984g == 1) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        View view2 = this.f10981d;
        if (this.f10984g != 0) {
            z2 = false;
        }
        view2.setSelected(z2);
    }

    /* renamed from: f */
    private void m15366f() {
        if (this.f10980c != null) {
            this.f10980c.mo2077a(this.f10984g);
        }
        m15365e();
    }

    /* renamed from: g */
    private void m15367g() {
        this.f10983f = this.f10979b.findViewById(R.id.music_container);
        this.f10983f.setOnClickListener(new C27121(this));
    }

    /* renamed from: h */
    private void m15368h() {
        this.f10982e = this.f10979b.findViewById(R.id.tv_container);
        this.f10982e.setOnClickListener(new C27132(this));
    }

    /* renamed from: i */
    private void m15369i() {
        this.f10981d = this.f10979b.findViewById(R.id.movies_contaner);
        this.f10981d.setOnClickListener(new C27143(this));
    }

    /* renamed from: j */
    private void m15370j() {
        this.f10979b.findViewById(R.id.menu).setOnClickListener(new C27154(this));
    }

    /* renamed from: a */
    public void m15373a(C2716a c2716a) {
        this.f10980c = c2716a;
    }

    /* renamed from: a */
    public void m15372a(int i) {
        this.f10984g = i;
        if (this.f10983f != null && this.f10982e != null && this.f10981d != null) {
            m15365e();
        }
    }
}
