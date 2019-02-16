package com.tdo.showbox.data.p119b.p120a;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.iawl.api.ads.sdk.IAWLAdManager;

/* compiled from: IAWLRectangleAdapterHelper */
/* renamed from: com.tdo.showbox.data.b.a.b */
public class C3024b {
    /* renamed from: a */
    BaseAdapter f11899a;
    /* renamed from: b */
    boolean f11900b = true;
    /* renamed from: c */
    private int f11901c = 4;
    /* renamed from: d */
    private int f11902d = 5;
    /* renamed from: e */
    private View f11903e;

    /* renamed from: a */
    public void m16405a(View view) {
        this.f11903e = view;
    }

    public C3024b(Context context, BaseAdapter baseAdapter, int i, int i2) {
        this.f11899a = baseAdapter;
        if (i > 0) {
            this.f11901c = i;
        }
        if (i2 > 0) {
            this.f11902d = i2;
        }
        this.f11900b = IAWLAdManager.areNativeAdsSupportedForOS();
    }

    /* renamed from: a */
    public int m16403a(int i) {
        return (this.f11900b && i >= this.f11901c) ? i - (((i - this.f11901c) / this.f11902d) + 1) : i;
    }

    /* renamed from: b */
    public int m16406b(int i) {
        if (!this.f11900b || i < this.f11901c) {
            return i;
        }
        int i2 = (i - this.f11901c) / (this.f11902d - 1);
        if ((i - this.f11901c) % (this.f11902d - 1) > 0) {
            i2 = (i2 + i) + 1;
        } else {
            i2 += i;
        }
        return i2;
    }

    /* renamed from: c */
    public int m16407c(int i) {
        return i + 1;
    }

    /* renamed from: d */
    public boolean m16408d(int i) {
        if (this.f11900b && i >= this.f11901c && (i - this.f11901c) % this.f11902d == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public View m16404a(int i, View view, ViewGroup viewGroup) {
        if (!this.f11900b) {
            Log.e("Story", "StoryAdapterHelper, Android SDK version or device is not compatible");
            return null;
        } else if (view != null) {
            return view;
        } else {
            view = this.f11903e;
            if (view == null) {
                return new View(viewGroup.getContext());
            }
            return view;
        }
    }

    /* renamed from: e */
    public void m16409e(int i) {
        if (i >= 0) {
            this.f11901c = i;
        }
    }

    /* renamed from: f */
    public void m16410f(int i) {
        this.f11902d = i;
    }
}
