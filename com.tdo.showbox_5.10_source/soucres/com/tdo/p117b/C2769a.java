package com.tdo.showbox.p117b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2725i;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.p131f.C3184j;

/* compiled from: BaseFragment */
/* renamed from: com.tdo.showbox.b.a */
public abstract class C2769a extends Fragment {
    /* renamed from: a */
    protected View f11092a;
    /* renamed from: b */
    protected volatile boolean f11093b;
    /* renamed from: c */
    private MainActivity f11094c;
    /* renamed from: d */
    private boolean f11095d;
    /* renamed from: e */
    private boolean f11096e;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f11094c = (MainActivity) getActivity();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        this.f11096e = false;
    }

    /* renamed from: d */
    public void mo2063d() {
    }

    /* renamed from: e */
    public void mo2064e() {
    }

    /* renamed from: a */
    public static View m15475a(View view) {
        int c = C3088f.m16684c("PREFS_BANNER_HEIGHT");
        Context context = view.getContext();
        if (!(context == null || context.getResources().getBoolean(R.bool.portrait_only))) {
            c = C3184j.m16980a(context, 95);
        }
        if (c != 0) {
            int i = (int) (((float) c) * 1.1f);
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) view).findViewById(R.id.root);
            LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.height = i;
            viewGroup.setLayoutParams(layoutParams);
        }
        return view;
    }

    /* renamed from: f */
    public boolean m15482f() {
        return false;
    }

    /* renamed from: a */
    public void m15477a(boolean z) {
        this.f11096e = z;
    }

    /* renamed from: g */
    public boolean m15483g() {
        return this.f11095d;
    }

    /* renamed from: b */
    public void m15479b(boolean z) {
        this.f11095d = z;
    }

    /* renamed from: h */
    protected MainActivity m15484h() {
        if (this.f11094c == null) {
            System.exit(0);
        }
        return this.f11094c;
    }

    /* renamed from: i */
    public boolean m15485i() {
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onResume() {
        this.f11093b = true;
        super.onResume();
    }

    public void onPause() {
        this.f11093b = false;
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    public C2668a mo2050a(C2668a c2668a) {
        return c2668a instanceof C2725i ? c2668a : new C2725i();
    }

    /* renamed from: b */
    public C2668a mo2053b(C2668a c2668a) {
        return c2668a instanceof C2725i ? c2668a : new C2725i();
    }
}
