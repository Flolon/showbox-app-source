package com.tdo.showbox.views.hrecyclerviewparalax;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tdo.showbox.R;

public class ParallaxImageView extends ImageView {
    /* renamed from: a */
    private final float f12909a = 2.0f;
    /* renamed from: b */
    private final boolean f12910b = true;
    /* renamed from: c */
    private boolean f12911c = true;
    /* renamed from: d */
    private C2969a f12912d;
    /* renamed from: e */
    private int f12913e = -1;
    /* renamed from: f */
    private int f12914f = -1;
    /* renamed from: g */
    private int f12915g = -1;
    /* renamed from: h */
    private int f12916h = -1;
    /* renamed from: i */
    private boolean f12917i = true;
    /* renamed from: j */
    private float f12918j = 2.0f;
    /* renamed from: k */
    private float f12919k;

    /* renamed from: com.tdo.showbox.views.hrecyclerviewparalax.ParallaxImageView$a */
    public interface C2969a {
        int[] e_();
    }

    public ParallaxImageView(Context context) {
        super(context);
        m17582a(context, null);
    }

    public ParallaxImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17582a(context, attributeSet);
    }

    public ParallaxImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17582a(context, attributeSet);
    }

    /* renamed from: a */
    private void m17582a(Context context, AttributeSet attributeSet) {
        setScaleType(ScaleType.MATRIX);
        this.f12919k = (float) context.getResources().getDimensionPixelSize(R.dimen.dimen_30);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m17583c();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m17583c();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m17583c();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m17583c();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        m17583c();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m17583c();
    }

    /* renamed from: a */
    public void m17585a() {
        this.f12911c = true;
    }

    public void setParallaxRatio(float f) {
        this.f12918j = f;
    }

    public void setListener(C2969a c2969a) {
        this.f12912d = c2969a;
    }

    public C2969a getListener() {
        return this.f12912d;
    }

    /* renamed from: b */
    public synchronized boolean m17586b() {
        boolean z = false;
        synchronized (this) {
            if (getDrawable() != null) {
                if (getListener() != null && getValues()) {
                    m17584d();
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: c */
    private boolean m17583c() {
        if (this.f12911c) {
            boolean z;
            if (m17586b()) {
                z = false;
            } else {
                z = true;
            }
            this.f12911c = z;
        }
        if (this.f12911c) {
            return false;
        }
        return true;
    }

    private boolean getValues() {
        int[] e_ = getListener().e_();
        if (e_ == null) {
            return false;
        }
        this.f12913e = e_[0];
        this.f12914f = e_[1];
        this.f12915g = e_[2];
        this.f12916h = e_[3];
        return true;
    }

    /* renamed from: d */
    private void m17584d() {
        float f;
        float f2;
        float f3 = (float) (((this.f12916h + this.f12915g) / 2) - this.f12914f);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        if (((float) intrinsicHeight) / ((float) intrinsicWidth) < ((float) height) / ((float) width)) {
            f = ((float) height) / ((float) intrinsicHeight);
            f2 = f;
        } else {
            f = ((float) width) / ((float) intrinsicWidth);
            f2 = f;
        }
        float f4 = (float) (((double) f2) * 1.085d);
        float f5 = (float) (((double) f) * 1.085d);
        double d = 0.042d * ((double) height);
        double d2 = (double) (((((float) intrinsicWidth) * f4) - ((float) width)) / 2.0f);
        f = this.f12919k;
        m17581a(((((f3 / ((float) this.f12915g)) * f) * 2.0f) / 2.0f) - (f / 2.0f), f4, f5, -d, -d2);
    }

    /* renamed from: a */
    private void m17581a(float f, float f2, float f3, double d, double d2) {
        Matrix imageMatrix = getImageMatrix();
        if (!(f2 == 1.0f || f3 == 1.0f)) {
            imageMatrix.setScale(f2, f3);
        }
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        imageMatrix.postTranslate((((float) ((int) d2)) + f) - fArr[5], (float) ((int) d));
        setImageMatrix(imageMatrix);
        invalidate();
    }
}
