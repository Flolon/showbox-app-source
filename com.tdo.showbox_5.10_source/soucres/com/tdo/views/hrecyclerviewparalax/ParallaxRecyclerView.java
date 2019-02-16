package com.tdo.showbox.views.hrecyclerviewparalax;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0686m;
import android.util.AttributeSet;

public class ParallaxRecyclerView extends RecyclerView {
    /* renamed from: h */
    private C0686m f12921h;

    /* renamed from: com.tdo.showbox.views.hrecyclerviewparalax.ParallaxRecyclerView$1 */
    class C33371 extends C0686m {
        /* renamed from: a */
        final /* synthetic */ ParallaxRecyclerView f12920a;

        C33371(ParallaxRecyclerView parallaxRecyclerView) {
            this.f12920a = parallaxRecyclerView;
        }

        /* renamed from: a */
        public void mo2171a(RecyclerView recyclerView, int i, int i2) {
            super.mo2171a(recyclerView, i, i2);
            for (int i3 = 0; i3 < recyclerView.getChildCount(); i3++) {
                if (recyclerView.m3896a(recyclerView.getChildAt(i3)) instanceof C2970c) {
                    ((C2970c) recyclerView.m3896a(recyclerView.getChildAt(i3))).mo2085x();
                }
            }
            if (this.f12920a.f12921h != null) {
                this.f12920a.f12921h.mo2171a(recyclerView, i, i2);
            }
        }

        /* renamed from: a */
        public void mo2170a(RecyclerView recyclerView, int i) {
            super.mo2170a(recyclerView, i);
            if (this.f12920a.f12921h != null) {
                this.f12920a.f12921h.mo2170a(recyclerView, i);
            }
        }
    }

    public ParallaxRecyclerView(Context context) {
        super(context);
        m17590t();
    }

    public ParallaxRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17590t();
    }

    public ParallaxRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17590t();
    }

    /* renamed from: t */
    private void m17590t() {
        mo2172a(new C33371(this));
    }

    /* renamed from: a */
    public void mo2172a(C0686m c0686m) {
        super.mo2172a(c0686m);
    }
}
