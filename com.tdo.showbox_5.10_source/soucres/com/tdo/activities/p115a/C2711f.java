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

/* compiled from: NewDetailBar */
/* renamed from: com.tdo.showbox.activities.a.f */
public class C2711f extends C2668a {
    /* renamed from: a */
    public boolean f10968a = false;
    /* renamed from: b */
    private Context f10969b;
    /* renamed from: c */
    private View f10970c;
    /* renamed from: d */
    private C2709a f10971d;
    /* renamed from: e */
    private C2710b f10972e;
    /* renamed from: f */
    private View f10973f;

    /* compiled from: NewDetailBar */
    /* renamed from: com.tdo.showbox.activities.a.f$1 */
    class C27061 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2711f f10965a;

        C27061(C2711f c2711f) {
            this.f10965a = c2711f;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16924d();
        }
    }

    /* compiled from: NewDetailBar */
    /* renamed from: com.tdo.showbox.activities.a.f$2 */
    class C27072 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2711f f10966a;

        C27072(C2711f c2711f) {
            this.f10966a = c2711f;
        }

        public void onClick(View view) {
            if (this.f10966a.f10971d != null) {
                this.f10966a.f10971d.mo2069a();
            }
        }
    }

    /* compiled from: NewDetailBar */
    /* renamed from: com.tdo.showbox.activities.a.f$3 */
    class C27083 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2711f f10967a;

        C27083(C2711f c2711f) {
            this.f10967a = c2711f;
        }

        public void onClick(View view) {
            if (this.f10967a.f10972e != null) {
                this.f10967a.f10972e.mo2070b();
            }
        }
    }

    /* compiled from: NewDetailBar */
    /* renamed from: com.tdo.showbox.activities.a.f$a */
    public interface C2709a {
        /* renamed from: a */
        void mo2069a();
    }

    /* compiled from: NewDetailBar */
    /* renamed from: com.tdo.showbox.activities.a.f$b */
    public interface C2710b {
        /* renamed from: b */
        void mo2070b();
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f10969b = context;
        this.f10970c = LayoutInflater.from(context).inflate(R.layout.new_detail_bar, null, false);
        m15354c();
        m15356e();
        m15355d();
        m15353b();
        return this.f10970c;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private void m15353b() {
        if (VERSION.SDK_INT >= 21) {
            ColorStateList colorStateList = this.f10969b.getResources().getColorStateList(R.color.drawer_colors_state);
            this.f10970c.findViewById(R.id.back_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f10970c.findViewById(R.id.share_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10969b.getDrawable(R.drawable.filter_ripple)));
            this.f10970c.findViewById(R.id.info_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10969b.getDrawable(R.drawable.riple)));
            this.f10970c.findViewById(R.id.fav_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10969b.getDrawable(R.drawable.riple)));
            this.f10970c.findViewById(R.id.back_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f10969b.getDrawable(R.drawable.riple)));
        }
    }

    /* renamed from: c */
    private void m15354c() {
        this.f10970c.findViewById(R.id.back_btn).setOnClickListener(new C27061(this));
    }

    /* renamed from: d */
    private void m15355d() {
        this.f10973f = this.f10970c.findViewById(R.id.info_btn_);
        this.f10970c.findViewById(R.id.info_btn).setOnClickListener(new C27072(this));
        this.f10973f.setSelected(this.f10968a);
    }

    /* renamed from: e */
    private void m15356e() {
        this.f10970c.findViewById(R.id.share_btn).setOnClickListener(new C27083(this));
    }

    /* renamed from: a */
    public void m15360a(boolean z) {
        this.f10968a = z;
        if (this.f10973f != null) {
            this.f10973f.setSelected(this.f10968a);
        }
    }

    /* renamed from: a */
    public void m15358a(C2709a c2709a) {
        this.f10971d = c2709a;
    }

    /* renamed from: a */
    public void m15359a(C2710b c2710b) {
        this.f10972e = c2710b;
    }
}
