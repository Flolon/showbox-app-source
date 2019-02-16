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

/* compiled from: TrailersBar */
/* renamed from: com.tdo.showbox.activities.a.k */
public class C2732k extends C2668a {
    /* renamed from: a */
    private Context f11017a;
    /* renamed from: b */
    private View f11018b;
    /* renamed from: c */
    private C2731a f11019c;
    /* renamed from: d */
    private View f11020d;
    /* renamed from: e */
    private View f11021e;
    /* renamed from: f */
    private int f11022f = -1;

    /* compiled from: TrailersBar */
    /* renamed from: com.tdo.showbox.activities.a.k$1 */
    class C27281 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2732k f11014a;

        C27281(C2732k c2732k) {
            this.f11014a = c2732k;
        }

        public void onClick(View view) {
            if (this.f11014a.f11022f != 0) {
                this.f11014a.f11022f = 0;
                this.f11014a.m15406f();
            }
        }
    }

    /* compiled from: TrailersBar */
    /* renamed from: com.tdo.showbox.activities.a.k$2 */
    class C27292 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2732k f11015a;

        C27292(C2732k c2732k) {
            this.f11015a = c2732k;
        }

        public void onClick(View view) {
            if (this.f11015a.f11022f != 1) {
                this.f11015a.f11022f = 1;
                this.f11015a.m15406f();
            }
        }
    }

    /* compiled from: TrailersBar */
    /* renamed from: com.tdo.showbox.activities.a.k$3 */
    class C27303 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2732k f11016a;

        C27303(C2732k c2732k) {
            this.f11016a = c2732k;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16917b();
        }
    }

    /* compiled from: TrailersBar */
    /* renamed from: com.tdo.showbox.activities.a.k$a */
    public interface C2731a {
        /* renamed from: a */
        void mo2080a(int i);
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f11017a = context;
        this.f11018b = LayoutInflater.from(context).inflate(R.layout.trailer_action_bar, null, false);
        m15408h();
        m15404d();
        m15405e();
        m15407g();
        m15403c();
        m15412b();
        return this.f11018b;
    }

    /* renamed from: b */
    public void m15412b() {
        int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
        if (this.f11018b != null) {
            TextView textView = (TextView) this.f11018b.findViewById(R.id.update_count);
            if (textView == null || c <= 0) {
                textView.setVisibility(4);
                return;
            }
            textView.setVisibility(0);
            textView.setText("" + c);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    private void m15403c() {
        if (VERSION.SDK_INT >= 21) {
            ColorStateList colorStateList = this.f11017a.getResources().getColorStateList(R.color.drawer_colors_state);
            this.f11020d.setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f11021e.setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f11018b.findViewById(R.id.menu).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f11017a.getDrawable(R.drawable.menu_ripple)));
        }
    }

    /* renamed from: d */
    private void m15404d() {
        this.f11020d = this.f11018b.findViewById(R.id.popular_container);
        this.f11020d.setOnClickListener(new C27281(this));
    }

    /* renamed from: e */
    private void m15405e() {
        this.f11021e = this.f11018b.findViewById(R.id.just_container);
        this.f11021e.setOnClickListener(new C27292(this));
    }

    /* renamed from: f */
    private void m15406f() {
        if (this.f11019c != null) {
            this.f11019c.mo2080a(this.f11022f);
        }
        m15407g();
    }

    /* renamed from: g */
    private void m15407g() {
        boolean z;
        boolean z2 = true;
        View view = this.f11020d;
        if (this.f11022f == 0) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        View view2 = this.f11021e;
        if (this.f11022f != 1) {
            z2 = false;
        }
        view2.setSelected(z2);
    }

    /* renamed from: h */
    private void m15408h() {
        this.f11018b.findViewById(R.id.menu).setOnClickListener(new C27303(this));
    }

    /* renamed from: a */
    public void m15410a(int i) {
        this.f11022f = i;
        if (this.f11020d != null && this.f11021e != null) {
            m15407g();
        }
    }

    /* renamed from: a */
    public void m15411a(C2731a c2731a) {
        this.f11019c = c2731a;
    }
}
