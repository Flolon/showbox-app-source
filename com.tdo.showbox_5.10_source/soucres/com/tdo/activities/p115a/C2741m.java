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

/* compiled from: UpdateFragmentBar */
/* renamed from: com.tdo.showbox.activities.a.m */
public class C2741m extends C2668a {
    /* renamed from: a */
    private Context f11035a;
    /* renamed from: b */
    private View f11036b;
    /* renamed from: c */
    private C2740b f11037c;
    /* renamed from: d */
    private View f11038d;
    /* renamed from: e */
    private View f11039e;
    /* renamed from: f */
    private View f11040f;
    /* renamed from: g */
    private C2739a f11041g = C2739a.NOTHING;
    /* renamed from: h */
    private String f11042h;
    /* renamed from: i */
    private String f11043i;
    /* renamed from: j */
    private String f11044j;
    /* renamed from: k */
    private TextView f11045k;
    /* renamed from: l */
    private TextView f11046l;
    /* renamed from: m */
    private TextView f11047m;

    /* compiled from: UpdateFragmentBar */
    /* renamed from: com.tdo.showbox.activities.a.m$1 */
    class C27351 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2741m f11026a;

        C27351(C2741m c2741m) {
            this.f11026a = c2741m;
        }

        public void onClick(View view) {
            this.f11026a.f11041g = C2739a.MY;
            this.f11026a.m15422f();
        }
    }

    /* compiled from: UpdateFragmentBar */
    /* renamed from: com.tdo.showbox.activities.a.m$2 */
    class C27362 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2741m f11027a;

        C27362(C2741m c2741m) {
            this.f11027a = c2741m;
        }

        public void onClick(View view) {
            this.f11027a.f11041g = C2739a.SHOW;
            this.f11027a.m15422f();
        }
    }

    /* compiled from: UpdateFragmentBar */
    /* renamed from: com.tdo.showbox.activities.a.m$3 */
    class C27373 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2741m f11028a;

        C27373(C2741m c2741m) {
            this.f11028a = c2741m;
        }

        public void onClick(View view) {
            this.f11028a.f11041g = C2739a.MOVIES;
            this.f11028a.m15422f();
        }
    }

    /* compiled from: UpdateFragmentBar */
    /* renamed from: com.tdo.showbox.activities.a.m$4 */
    class C27384 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2741m f11029a;

        C27384(C2741m c2741m) {
            this.f11029a = c2741m;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16917b();
        }
    }

    /* compiled from: UpdateFragmentBar */
    /* renamed from: com.tdo.showbox.activities.a.m$a */
    public enum C2739a {
        MOVIES,
        SHOW,
        MY,
        NOTHING
    }

    /* compiled from: UpdateFragmentBar */
    /* renamed from: com.tdo.showbox.activities.a.m$b */
    public interface C2740b {
        /* renamed from: a */
        void mo2082a(C2739a c2739a);
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f11035a = context;
        this.f11036b = LayoutInflater.from(context).inflate(R.layout.update_action_bar, null, false);
        m15426j();
        m15425i();
        m15424h();
        m15423g();
        m15433c();
        m15421e();
        m15420d();
        m15431b();
        return this.f11036b;
    }

    /* renamed from: b */
    public void m15431b() {
        int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
        if (this.f11036b != null) {
            TextView textView = (TextView) this.f11036b.findViewById(R.id.update_count);
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
    private void m15420d() {
        if (VERSION.SDK_INT >= 21) {
            ColorStateList colorStateList = this.f11035a.getResources().getColorStateList(R.color.drawer_colors_state);
            this.f11038d.setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f11039e.setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f11040f.setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f11036b.findViewById(R.id.menu).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f11035a.getDrawable(R.drawable.menu_ripple)));
        }
    }

    /* renamed from: c */
    public void m15433c() {
        this.f11045k = (TextView) this.f11036b.findViewById(R.id.movies_counr);
        this.f11045k.setText(this.f11044j);
        this.f11046l = (TextView) this.f11036b.findViewById(R.id.show_counter);
        this.f11046l.setText(this.f11043i);
        this.f11047m = (TextView) this.f11036b.findViewById(R.id.my_counter);
        this.f11047m.setText(this.f11042h);
    }

    /* renamed from: e */
    private void m15421e() {
        boolean z;
        boolean z2 = true;
        View view = this.f11040f;
        if (this.f11041g == C2739a.MY) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        view = this.f11039e;
        if (this.f11041g == C2739a.SHOW) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        View view2 = this.f11038d;
        if (this.f11041g != C2739a.MOVIES) {
            z2 = false;
        }
        view2.setSelected(z2);
    }

    /* renamed from: f */
    private void m15422f() {
        if (this.f11037c != null) {
            this.f11037c.mo2082a(this.f11041g);
        }
        m15421e();
    }

    /* renamed from: g */
    private void m15423g() {
        this.f11040f = this.f11036b.findViewById(R.id.my_container);
        this.f11040f.setOnClickListener(new C27351(this));
    }

    /* renamed from: h */
    private void m15424h() {
        this.f11039e = this.f11036b.findViewById(R.id.show_container);
        this.f11039e.setOnClickListener(new C27362(this));
    }

    /* renamed from: i */
    private void m15425i() {
        this.f11038d = this.f11036b.findViewById(R.id.movi_contaner);
        this.f11038d.setOnClickListener(new C27373(this));
    }

    /* renamed from: j */
    private void m15426j() {
        this.f11036b.findViewById(R.id.menu).setOnClickListener(new C27384(this));
    }

    /* renamed from: a */
    public void m15429a(C2740b c2740b) {
        this.f11037c = c2740b;
    }

    /* renamed from: a */
    public void m15430a(String str) {
        if (str != null) {
            this.f11044j = str;
            if (this.f11045k != null) {
                this.f11045k.setText(this.f11044j);
            }
        }
    }

    /* renamed from: b */
    public void m15432b(String str) {
        if (str != null) {
            this.f11043i = str;
            if (this.f11046l != null) {
                this.f11046l.setText(this.f11043i);
            }
        }
    }

    /* renamed from: c */
    public void m15434c(String str) {
        if (str != null) {
            this.f11042h = str;
            if (this.f11047m != null) {
                this.f11047m.setText(this.f11042h);
            }
        }
    }

    /* renamed from: a */
    public void m15428a(C2739a c2739a) {
        this.f11041g = c2739a;
        if (this.f11040f != null && this.f11039e != null && this.f11038d != null) {
            m15421e();
        }
    }
}
