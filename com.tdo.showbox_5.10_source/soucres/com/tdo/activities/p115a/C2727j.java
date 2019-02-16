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

/* compiled from: TrailerDetailsBar */
/* renamed from: com.tdo.showbox.activities.a.j */
public class C2727j extends C2668a {
    /* renamed from: a */
    private Context f11012a;
    /* renamed from: b */
    private View f11013b;

    /* compiled from: TrailerDetailsBar */
    /* renamed from: com.tdo.showbox.activities.a.j$1 */
    class C27261 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2727j f11011a;

        C27261(C2727j c2727j) {
            this.f11011a = c2727j;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16924d();
        }
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f11012a = context;
        this.f11013b = LayoutInflater.from(context).inflate(R.layout.trailers_details_bar, null, false);
        m15397c();
        m15396b();
        return this.f11013b;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private void m15396b() {
        if (VERSION.SDK_INT >= 21) {
            ColorStateList colorStateList = this.f11012a.getResources().getColorStateList(R.color.drawer_colors_state);
            this.f11013b.findViewById(R.id.back_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f11013b.findViewById(R.id.back_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), this.f11012a.getDrawable(R.drawable.riple)));
        }
    }

    /* renamed from: c */
    private void m15397c() {
        this.f11013b.findViewById(R.id.back_btn).setOnClickListener(new C27261(this));
    }
}
