package com.tdo.showbox.data.p119b.p120a;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.data.p119b.C3049h;
import com.tdo.showbox.data.p119b.C3049h.C3027a;
import com.tdo.showbox.models.InternalAd;
import com.tdo.showbox.views.CustomAdBannerView;
import com.tdo.showbox.views.CustomAdBannerView.C3029a;

/* compiled from: PrecachedCustomRectAd */
/* renamed from: com.tdo.showbox.data.b.a.d */
public class C3034d {
    /* renamed from: a */
    private static String f11926a = "PrecachedCustomRectAd";
    /* renamed from: b */
    private boolean f11927b;
    /* renamed from: c */
    private InternalAd f11928c;
    /* renamed from: d */
    private C2814a f11929d;

    /* compiled from: PrecachedCustomRectAd */
    /* renamed from: com.tdo.showbox.data.b.a.d$a */
    public interface C2814a {
        /* renamed from: a */
        void mo2067a();
    }

    /* compiled from: PrecachedCustomRectAd */
    /* renamed from: com.tdo.showbox.data.b.a.d$1 */
    class C30321 implements C3027a {
        /* renamed from: a */
        final /* synthetic */ C3034d f11924a;

        C30321(C3034d c3034d) {
            this.f11924a = c3034d;
        }

        /* renamed from: a */
        public void mo2109a(InternalAd internalAd) {
            this.f11924a.f11928c = internalAd;
            this.f11924a.f11927b = true;
            if (this.f11924a.f11929d != null) {
                this.f11924a.f11929d.mo2067a();
            }
            this.f11924a.f11929d = null;
        }
    }

    /* compiled from: PrecachedCustomRectAd */
    /* renamed from: com.tdo.showbox.data.b.a.d$2 */
    class C30332 implements C3029a {
        /* renamed from: a */
        final /* synthetic */ C3034d f11925a;

        C30332(C3034d c3034d) {
            this.f11925a = c3034d;
        }

        /* renamed from: a */
        public void mo2110a() {
        }
    }

    /* renamed from: a */
    public void m16445a(Context context, C2999a c2999a) {
        this.f11927b = false;
        C3049h.m16502d(context, c2999a, new C30321(this));
    }

    /* renamed from: a */
    public boolean m16446a() {
        return this.f11928c != null;
    }

    /* renamed from: a */
    public boolean m16448a(C2814a c2814a) {
        if (this.f11927b) {
            this.f11929d = null;
            return true;
        }
        this.f11929d = c2814a;
        return false;
    }

    /* renamed from: a */
    public boolean m16447a(Activity activity, ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = (int) ((((float) i) / 300.0f) * 100.0f);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(i, (int) (((double) ((float) i)) * 0.52d));
        layoutParams.gravity = 81;
        View customAdBannerView = new CustomAdBannerView(activity);
        customAdBannerView.setScaleFactor(i2);
        customAdBannerView.setBannerListener(new C30332(this));
        customAdBannerView.setAdInit(this.f11928c);
        viewGroup.setVisibility(0);
        viewGroup.addView(customAdBannerView, 0, layoutParams);
        customAdBannerView.m17199b();
        customAdBannerView.requestLayout();
        return true;
    }
}
