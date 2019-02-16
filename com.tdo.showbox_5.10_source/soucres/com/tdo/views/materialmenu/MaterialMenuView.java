package com.tdo.showbox.views.materialmenu;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import com.tdo.showbox.C2968b.C2743a;
import com.tdo.showbox.views.materialmenu.C3353b.C3350b;
import com.tdo.showbox.views.materialmenu.C3353b.C3352d;

public class MaterialMenuView extends View implements C3343a {
    /* renamed from: a */
    private C3353b f12927a;
    /* renamed from: b */
    private C3350b f12928b;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C33421();
        /* renamed from: a */
        protected C3350b f12926a;

        /* renamed from: com.tdo.showbox.views.materialmenu.MaterialMenuView$SavedState$1 */
        static class C33421 implements Creator<SavedState> {
            C33421() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m17594a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m17595a(i);
            }

            /* renamed from: a */
            public SavedState m17594a(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] m17595a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f12926a = C3350b.valueOf(parcel.readString());
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f12926a.name());
        }
    }

    public MaterialMenuView(Context context) {
        this(context, null);
    }

    public MaterialMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12928b = C3350b.BURGER;
        m17599a(context, attributeSet);
    }

    /* renamed from: a */
    private void m17599a(Context context, AttributeSet attributeSet) {
        TypedArray a = m17597a(context, attributeSet, C2743a.MaterialMenuView);
        try {
            int color = a.getColor(0, -1);
            int integer = a.getInteger(3, 1);
            int integer2 = a.getInteger(5, 800);
            int integer3 = a.getInteger(1, 400);
            C3352d a2 = C3352d.m17606a(a.getInteger(4, 0));
            boolean z = a.getBoolean(2, false);
            this.f12927a = new C3353b(context, color, a2, integer, integer2, integer3);
            this.f12927a.m17639a(z);
            this.f12927a.setCallback(this);
        } finally {
            a.recycle();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (getPaddingLeft() == 0 && getPaddingTop() == 0) {
            this.f12927a.draw(canvas);
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        this.f12927a.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        m17598a();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f12927a || super.verifyDrawable(drawable);
    }

    public void setState(C3350b c3350b) {
        this.f12928b = c3350b;
        this.f12927a.m17636a(c3350b);
    }

    public C3350b getState() {
        return this.f12927a.m17632a();
    }

    /* renamed from: a */
    public void mo2173a(C3350b c3350b) {
        this.f12928b = c3350b;
        this.f12927a.m17637a(c3350b, false);
    }

    public void setColor(int i) {
        this.f12927a.m17633a(i);
    }

    public void setTransformationDuration(int i) {
        this.f12927a.m17641b(i);
    }

    public void setPressedDuration(int i) {
        this.f12927a.m17644c(i);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f12927a.m17635a(interpolator);
    }

    public void setAnimationListener(AnimatorListener animatorListener) {
        this.f12927a.m17634a(animatorListener);
    }

    public void setRTLEnabled(boolean z) {
        this.f12927a.m17639a(z);
    }

    public C3353b getDrawable() {
        return this.f12927a;
    }

    protected void onMeasure(int i, int i2) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (VERSION.SDK_INT >= 11) {
            setMeasuredDimension(MeasureSpec.makeMeasureSpec(paddingLeft + this.f12927a.getIntrinsicWidth(), 1073741824), MeasureSpec.makeMeasureSpec(paddingTop + this.f12927a.getIntrinsicHeight(), 1073741824));
        } else {
            setMeasuredDimension(paddingLeft + this.f12927a.getIntrinsicWidth(), paddingTop + this.f12927a.getIntrinsicHeight());
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m17598a();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f12926a = this.f12928b;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setState(savedState.f12926a);
    }

    /* renamed from: a */
    private void m17598a() {
        if (this.f12927a != null) {
            this.f12927a.setBounds(0, 0, (this.f12927a.getIntrinsicWidth() + getPaddingLeft()) + getPaddingRight(), (this.f12927a.getIntrinsicHeight() + getPaddingTop()) + getPaddingBottom());
        }
    }

    /* renamed from: a */
    private TypedArray m17597a(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
