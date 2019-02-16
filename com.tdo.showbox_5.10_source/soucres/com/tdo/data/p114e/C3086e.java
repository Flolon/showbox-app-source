package com.tdo.showbox.data.p114e;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: TopMediaController */
/* renamed from: com.tdo.showbox.data.e.e */
public class C3086e {
    /* renamed from: a */
    private View f12091a;
    /* renamed from: b */
    private boolean f12092b = false;

    /* compiled from: TopMediaController */
    /* renamed from: com.tdo.showbox.data.e.e$1 */
    class C30841 implements AnimatorListener {
        /* renamed from: a */
        final /* synthetic */ C3086e f12089a;

        C30841(C3086e c3086e) {
            this.f12089a = c3086e;
        }

        public void onAnimationStart(Animator animator) {
            if (this.f12089a.f12091a != null) {
                this.f12089a.f12091a.setVisibility(0);
            }
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: TopMediaController */
    /* renamed from: com.tdo.showbox.data.e.e$2 */
    class C30852 implements AnimatorListener {
        /* renamed from: a */
        final /* synthetic */ C3086e f12090a;

        C30852(C3086e c3086e) {
            this.f12090a = c3086e;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f12090a.f12091a != null) {
                this.f12090a.f12091a.setVisibility(4);
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public C3086e(View view) {
        this.f12091a = view;
        this.f12091a.setVisibility(4);
    }

    /* renamed from: a */
    public void m16671a(boolean z) {
        this.f12092b = z;
        if (!this.f12092b) {
            m16672b();
        }
    }

    /* renamed from: a */
    public void m16670a() {
        if (this.f12091a != null && this.f12092b) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f12091a, "alpha", new float[]{0.0f, 1.0f});
            ofFloat.setDuration(200);
            ofFloat.addListener(new C30841(this));
            ofFloat.start();
        }
    }

    /* renamed from: b */
    public void m16672b() {
        if (this.f12091a != null && this.f12092b) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f12091a, "alpha", new float[]{1.0f, 0.0f});
            ofFloat.setDuration(200);
            ofFloat.addListener(new C30852(this));
            ofFloat.start();
        }
    }
}
