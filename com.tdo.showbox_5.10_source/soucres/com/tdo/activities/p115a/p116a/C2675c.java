package com.tdo.showbox.activities.p115a.p116a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.p129e.p130a.C3167a;

/* compiled from: ShowsDetailsTabBar */
/* renamed from: com.tdo.showbox.activities.a.a.c */
public class C2675c extends C2668a {
    /* renamed from: a */
    protected Context f10905a;
    /* renamed from: b */
    protected View f10906b;
    /* renamed from: c */
    private View f10907c;

    /* compiled from: ShowsDetailsTabBar */
    /* renamed from: com.tdo.showbox.activities.a.a.c$1 */
    class C26741 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2675c f10904a;

        C26741(C2675c c2675c) {
            this.f10904a = c2675c;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16924d();
        }
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        if (this.f10906b != null) {
            return this.f10906b;
        }
        this.f10905a = context;
        this.f10906b = LayoutInflater.from(context).inflate(R.layout.shows_details_tab_action_bar, null, false);
        this.f10906b.findViewById(R.id.back_btn).setOnClickListener(new C26741(this));
        return this.f10906b;
    }

    /* renamed from: b */
    public View m15285b(Context context) {
        if (this.f10907c == null) {
            this.f10907c = mo2026a(context);
        }
        return this.f10907c;
    }
}
