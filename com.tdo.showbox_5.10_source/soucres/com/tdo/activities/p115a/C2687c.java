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

/* compiled from: LibBar */
/* renamed from: com.tdo.showbox.activities.a.c */
public class C2687c extends C2668a {
    /* renamed from: a */
    private Context f10928a;
    /* renamed from: b */
    private View f10929b;
    /* renamed from: c */
    private C2686b f10930c;
    /* renamed from: d */
    private View f10931d;
    /* renamed from: e */
    private View f10932e;
    /* renamed from: f */
    private C2685a f10933f = C2685a.MOVIES;

    /* compiled from: LibBar */
    /* renamed from: com.tdo.showbox.activities.a.c$1 */
    class C26821 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2687c f10922a;

        C26821(C2687c c2687c) {
            this.f10922a = c2687c;
        }

        public void onClick(View view) {
            if (this.f10922a.f10933f != C2685a.SHOWS) {
                this.f10922a.f10933f = C2685a.SHOWS;
                this.f10922a.m15303f();
            }
        }
    }

    /* compiled from: LibBar */
    /* renamed from: com.tdo.showbox.activities.a.c$2 */
    class C26832 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2687c f10923a;

        C26832(C2687c c2687c) {
            this.f10923a = c2687c;
        }

        public void onClick(View view) {
            if (this.f10923a.f10933f != C2685a.MOVIES) {
                this.f10923a.f10933f = C2685a.MOVIES;
                this.f10923a.m15303f();
            }
        }
    }

    /* compiled from: LibBar */
    /* renamed from: com.tdo.showbox.activities.a.c$3 */
    class C26843 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2687c f10924a;

        C26843(C2687c c2687c) {
            this.f10924a = c2687c;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16917b();
        }
    }

    /* compiled from: LibBar */
    /* renamed from: com.tdo.showbox.activities.a.c$a */
    public enum C2685a {
        MOVIES,
        SHOWS
    }

    /* compiled from: LibBar */
    /* renamed from: com.tdo.showbox.activities.a.c$b */
    public interface C2686b {
        /* renamed from: a */
        void mo2073a(C2685a c2685a);
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f10928a = context;
        this.f10929b = LayoutInflater.from(context).inflate(R.layout.lib_action_bar, null, false);
        m15305h();
        m15302e();
        m15301d();
        m15304g();
        m15300c();
        m15309b();
        return this.f10929b;
    }

    /* renamed from: b */
    public void m15309b() {
        int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
        if (this.f10929b != null) {
            TextView textView = (TextView) this.f10929b.findViewById(R.id.update_count);
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
    private void m15300c() {
        if (VERSION.SDK_INT >= 21) {
            ColorStateList colorStateList = this.f10928a.getResources().getColorStateList(R.color.drawer_colors_state);
            this.f10931d.setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f10932e.setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f10929b.findViewById(R.id.menu).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10928a.getDrawable(R.drawable.menu_ripple)));
        }
    }

    /* renamed from: d */
    private void m15301d() {
        this.f10932e = this.f10929b.findViewById(R.id.show_container);
        this.f10932e.setOnClickListener(new C26821(this));
    }

    /* renamed from: e */
    private void m15302e() {
        this.f10931d = this.f10929b.findViewById(R.id.move_container);
        this.f10931d.setOnClickListener(new C26832(this));
    }

    /* renamed from: f */
    private void m15303f() {
        if (this.f10930c != null) {
            this.f10930c.mo2073a(this.f10933f);
        }
        m15304g();
    }

    /* renamed from: g */
    private void m15304g() {
        boolean z;
        boolean z2 = true;
        View view = this.f10932e;
        if (this.f10933f == C2685a.SHOWS) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        View view2 = this.f10931d;
        if (this.f10933f != C2685a.MOVIES) {
            z2 = false;
        }
        view2.setSelected(z2);
    }

    /* renamed from: h */
    private void m15305h() {
        this.f10929b.findViewById(R.id.menu).setOnClickListener(new C26843(this));
    }

    /* renamed from: a */
    public void m15307a(C2685a c2685a) {
        this.f10933f = c2685a;
        if (this.f10932e != null && this.f10931d != null) {
            m15304g();
        }
    }

    /* renamed from: a */
    public void m15308a(C2686b c2686b) {
        this.f10930c = c2686b;
    }
}
