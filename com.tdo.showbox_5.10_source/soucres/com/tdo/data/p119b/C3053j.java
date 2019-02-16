package com.tdo.showbox.data.p119b;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.iawl.api.ads.sdk.IAWLAdManager;
import com.iawl.api.ads.sdk.IAWLNativeAdViewBinder;

/* compiled from: IAWLStoryAdapterHelper */
/* renamed from: com.tdo.showbox.data.b.j */
public class C3053j {
    /* renamed from: a */
    BaseAdapter f11971a;
    /* renamed from: b */
    IAWLNativeAdViewBinder f11972b;
    /* renamed from: c */
    boolean f11973c = true;
    /* renamed from: d */
    private int f11974d = 4;
    /* renamed from: e */
    private int f11975e = 5;

    public C3053j(Context context, BaseAdapter baseAdapter, IAWLNativeAdViewBinder iAWLNativeAdViewBinder, int i, int i2) {
        this.f11971a = baseAdapter;
        this.f11972b = iAWLNativeAdViewBinder;
        if (i > 0) {
            this.f11974d = i;
        }
        if (i2 > 0) {
            this.f11975e = i2;
        }
        this.f11973c = IAWLAdManager.areNativeAdsSupportedForOS();
    }

    /* renamed from: a */
    public int m16504a(int i) {
        return (this.f11973c && i >= this.f11974d) ? i - (((i - this.f11974d) / this.f11975e) + 1) : i;
    }

    /* renamed from: b */
    public int m16506b(int i) {
        if (!this.f11973c || i < this.f11974d) {
            return i;
        }
        int i2 = (i - this.f11974d) / (this.f11975e - 1);
        if ((i - this.f11974d) % (this.f11975e - 1) > 0) {
            i2 = (i2 + i) + 1;
        } else {
            i2 += i;
        }
        return i2;
    }

    /* renamed from: c */
    public int m16507c(int i) {
        return i + 1;
    }

    /* renamed from: d */
    public boolean m16508d(int i) {
        if (this.f11973c && i >= this.f11974d && (i - this.f11974d) % this.f11975e == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public View m16505a(int i, View view, ViewGroup viewGroup) {
        if (this.f11973c) {
            if (view == null) {
                view = this.f11972b.getBoundedView();
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
            }
            this.f11972b.update();
            return view;
        }
        Log.e("Story", "StoryAdapterHelper, Android SDK version or device is not compatible");
        return null;
    }
}
