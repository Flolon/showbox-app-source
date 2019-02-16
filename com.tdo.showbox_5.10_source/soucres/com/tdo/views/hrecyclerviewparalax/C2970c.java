package com.tdo.showbox.views.hrecyclerviewparalax;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0696v;
import android.view.View;
import com.tdo.showbox.views.hrecyclerviewparalax.ParallaxImageView.C2969a;

/* compiled from: ParallaxViewHolder */
/* renamed from: com.tdo.showbox.views.hrecyclerviewparalax.c */
public abstract class C2970c extends C0696v implements C2969a {
    /* renamed from: l */
    private ParallaxImageView f11792l;

    /* renamed from: w */
    public abstract int mo2084w();

    public C2970c(View view) {
        super(view);
        this.f11792l = (ParallaxImageView) view.findViewById(mo2084w());
        this.f11792l.setListener(this);
    }

    public int[] e_() {
        if (this.a.getParent() == null) {
            return null;
        }
        this.a.getLocationOnScreen(new int[2]);
        ((RecyclerView) this.a.getParent()).getLocationOnScreen(new int[2]);
        return new int[]{this.a.getMeasuredWidth(), r2[0], ((RecyclerView) this.a.getParent()).getMeasuredWidth(), r3[0]};
    }

    /* renamed from: x */
    public void mo2085x() {
        mo2086y().m17586b();
    }

    /* renamed from: y */
    public ParallaxImageView mo2086y() {
        return this.f11792l;
    }
}
