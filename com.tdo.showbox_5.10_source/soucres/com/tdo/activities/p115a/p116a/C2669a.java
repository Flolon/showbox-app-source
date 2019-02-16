package com.tdo.showbox.activities.p115a.p116a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.p129e.p130a.C3167a;

/* compiled from: MoviesDetailsTabBar */
/* renamed from: com.tdo.showbox.activities.a.a.a */
public class C2669a extends C2668a {
    /* renamed from: a */
    protected Context f10890a;
    /* renamed from: b */
    protected View f10891b;
    /* renamed from: c */
    private View f10892c;

    /* compiled from: MoviesDetailsTabBar */
    /* renamed from: com.tdo.showbox.activities.a.a.a$1 */
    class C26671 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2669a f10889a;

        C26671(C2669a c2669a) {
            this.f10889a = c2669a;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16924d();
        }
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        if (this.f10891b != null) {
            return this.f10891b;
        }
        this.f10890a = context;
        this.f10891b = LayoutInflater.from(context).inflate(R.layout.movies_details_tab_action_bar, null, false);
        this.f10891b.findViewById(R.id.back_btn).setOnClickListener(new C26671(this));
        return this.f10891b;
    }

    /* renamed from: b */
    public View m15277b(Context context) {
        if (this.f10892c == null) {
            this.f10892c = mo2026a(context);
        }
        return this.f10892c;
    }
}
