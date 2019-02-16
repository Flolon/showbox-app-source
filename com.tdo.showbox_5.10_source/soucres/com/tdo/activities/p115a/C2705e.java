package com.tdo.showbox.activities.p115a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.views.materialmenu.C3343a;
import com.tdo.showbox.views.materialmenu.C3353b.C3350b;

/* compiled from: MoviesBar */
/* renamed from: com.tdo.showbox.activities.a.e */
public class C2705e extends C2668a {
    /* renamed from: a */
    protected Context f10950a;
    /* renamed from: b */
    protected View f10951b;
    /* renamed from: c */
    protected String f10952c;
    /* renamed from: d */
    protected TextView f10953d;
    /* renamed from: e */
    protected C2702b f10954e;
    /* renamed from: f */
    protected C2703c f10955f;
    /* renamed from: g */
    protected C2704d f10956g;
    /* renamed from: h */
    protected C2701a f10957h;
    /* renamed from: i */
    protected boolean f10958i = false;
    /* renamed from: j */
    protected View f10959j;
    /* renamed from: k */
    protected View f10960k;
    /* renamed from: l */
    protected EditText f10961l;
    /* renamed from: m */
    protected String f10962m;
    /* renamed from: n */
    protected String f10963n;
    /* renamed from: o */
    protected C3343a f10964o;

    /* compiled from: MoviesBar */
    /* renamed from: com.tdo.showbox.activities.a.e$1 */
    class C26961 implements OnEditorActionListener {
        /* renamed from: a */
        final /* synthetic */ C2705e f10945a;

        C26961(C2705e c2705e) {
            this.f10945a = c2705e;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3 && i != 66) {
                return false;
            }
            if (this.f10945a.f10955f != null) {
                this.f10945a.f10955f.mo2061a(this.f10945a.f10961l.getText().toString());
            }
            this.f10945a.f10962m = this.f10945a.f10961l.getText().toString();
            C3184j.m16982a((Activity) this.f10945a.f10950a, this.f10945a.f10961l);
            return true;
        }
    }

    /* compiled from: MoviesBar */
    /* renamed from: com.tdo.showbox.activities.a.e$2 */
    class C26982 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2705e f10947a;

        /* compiled from: MoviesBar */
        /* renamed from: com.tdo.showbox.activities.a.e$2$1 */
        class C26971 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C26982 f10946a;

            C26971(C26982 c26982) {
                this.f10946a = c26982;
            }

            public void run() {
                this.f10946a.f10947a.f10958i = true;
                this.f10946a.f10947a.m15347b();
                this.f10946a.f10947a.m15336f();
                C3184j.m16986b((Activity) this.f10946a.f10947a.f10950a, this.f10946a.f10947a.f10961l);
                this.f10946a.f10947a.f10961l.setText(this.f10946a.f10947a.f10962m);
                if (this.f10946a.f10947a.f10956g != null) {
                    this.f10946a.f10947a.f10956g.m15330a();
                }
            }
        }

        C26982(C2705e c2705e) {
            this.f10947a = c2705e;
        }

        public void onClick(View view) {
            this.f10947a.f10964o.setTransformationDuration(450);
            this.f10947a.f10964o.mo2173a(C3350b.ARROW);
            new Handler(Looper.getMainLooper()).postDelayed(new C26971(this), 200);
        }
    }

    /* compiled from: MoviesBar */
    /* renamed from: com.tdo.showbox.activities.a.e$3 */
    class C26993 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2705e f10948a;

        C26993(C2705e c2705e) {
            this.f10948a = c2705e;
        }

        public void onClick(View view) {
            if (this.f10948a.f10954e != null) {
                this.f10948a.f10954e.mo2062b();
            }
        }
    }

    /* compiled from: MoviesBar */
    /* renamed from: com.tdo.showbox.activities.a.e$4 */
    class C27004 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2705e f10949a;

        C27004(C2705e c2705e) {
            this.f10949a = c2705e;
        }

        public void onClick(View view) {
            this.f10949a.f10964o.setTransformationDuration(450);
            if (this.f10949a.f10964o.getState() != C3350b.BURGER) {
                this.f10949a.m15341k();
                this.f10949a.f10964o.mo2173a(C3350b.BURGER);
                return;
            }
            C3167a.m16903a().m16917b();
        }
    }

    /* compiled from: MoviesBar */
    /* renamed from: com.tdo.showbox.activities.a.e$a */
    public interface C2701a {
        /* renamed from: a */
        void mo2060a();
    }

    /* compiled from: MoviesBar */
    /* renamed from: com.tdo.showbox.activities.a.e$b */
    public interface C2702b {
        /* renamed from: b */
        void mo2062b();
    }

    /* compiled from: MoviesBar */
    /* renamed from: com.tdo.showbox.activities.a.e$c */
    public interface C2703c {
        /* renamed from: a */
        void mo2061a(String str);
    }

    /* compiled from: MoviesBar */
    /* renamed from: com.tdo.showbox.activities.a.e$d */
    public interface C2704d {
        /* renamed from: a */
        void m15330a();
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f10950a = context;
        this.f10951b = LayoutInflater.from(context).inflate(R.layout.move_action_bar, null, false);
        m15335e();
        m15340j();
        m15339i();
        m15338h();
        m15337g();
        m15334d();
        if (this.f10958i) {
            this.f10961l.setText(this.f10962m);
            this.f10964o.setState(C3350b.ARROW);
        } else {
            this.f10964o.setState(C3350b.BURGER);
        }
        if (!(this.f10961l == null || this.f10963n == null)) {
            this.f10961l.setHint(this.f10963n);
        }
        m15333c();
        m15347b();
        return this.f10951b;
    }

    /* renamed from: b */
    public void m15347b() {
        if (this.f10958i) {
            if (this.f10951b != null) {
                this.f10951b.findViewById(R.id.update_count).setVisibility(4);
            }
        } else if (this.f10951b != null) {
            TextView textView = (TextView) this.f10951b.findViewById(R.id.update_count);
            int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
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
    private void m15333c() {
        if (VERSION.SDK_INT >= 21) {
            ColorStateList colorStateList = this.f10950a.getResources().getColorStateList(R.color.drawer_colors_state);
            this.f10951b.findViewById(R.id.filter_ripple).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10950a.getDrawable(R.drawable.filter_ripple)));
            this.f10951b.findViewById(R.id.search_click_receiver).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10950a.getDrawable(R.drawable.riple)));
            this.f10951b.findViewById(R.id.menu).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10950a.getDrawable(R.drawable.menu_ripple)));
        }
    }

    /* renamed from: a */
    public void m15346a(String str) {
        this.f10963n = str;
        if (this.f10961l != null) {
            this.f10961l.setHint(this.f10963n);
        }
    }

    /* renamed from: d */
    private void m15334d() {
        this.f10961l = (EditText) this.f10951b.findViewById(R.id.search_field);
        this.f10961l.setOnEditorActionListener(new C26961(this));
    }

    /* renamed from: e */
    private void m15335e() {
        this.f10959j = this.f10951b.findViewById(R.id.normal_menu);
        this.f10960k = this.f10951b.findViewById(R.id.search_view);
        m15336f();
    }

    /* renamed from: f */
    private void m15336f() {
        int i = 0;
        if (this.f10959j != null) {
            this.f10959j.setVisibility(this.f10958i ? 8 : 0);
        }
        if (this.f10960k != null) {
            View view = this.f10960k;
            if (!this.f10958i) {
                i = 8;
            }
            view.setVisibility(i);
        }
        m15347b();
    }

    /* renamed from: g */
    private void m15337g() {
        this.f10951b.findViewById(R.id.search_click_receiver).setOnClickListener(new C26982(this));
    }

    /* renamed from: h */
    private void m15338h() {
        this.f10951b.findViewById(R.id.filter_ripple).setOnClickListener(new C26993(this));
    }

    /* renamed from: i */
    private void m15339i() {
        this.f10953d = (TextView) this.f10951b.findViewById(R.id.title);
        if (this.f10952c != null) {
            this.f10953d.setText(this.f10952c);
        }
    }

    /* renamed from: j */
    private void m15340j() {
        this.f10964o = (C3343a) this.f10951b.findViewById(R.id.menu_btn);
        this.f10951b.findViewById(R.id.menu).setOnClickListener(new C27004(this));
    }

    /* renamed from: k */
    private void m15341k() {
        this.f10958i = false;
        m15347b();
        C3184j.m16982a((Activity) this.f10950a, this.f10961l);
        m15336f();
        if (this.f10957h != null) {
            this.f10957h.mo2060a();
        }
    }

    /* renamed from: b */
    public void m15348b(String str) {
        if (str != null) {
            this.f10952c = str;
            if (this.f10953d != null) {
                this.f10953d.setText(str);
            }
        }
    }

    /* renamed from: a */
    public void m15344a(C2702b c2702b) {
        this.f10954e = c2702b;
    }

    /* renamed from: a */
    public void m15345a(C2703c c2703c) {
        this.f10955f = c2703c;
    }

    /* renamed from: a */
    public void m15343a(C2701a c2701a) {
        this.f10957h = c2701a;
    }
}
