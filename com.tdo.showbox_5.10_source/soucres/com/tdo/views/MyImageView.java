package com.tdo.showbox.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MyImageView extends ImageView {
    /* renamed from: a */
    protected float f12576a = 1.45f;
    /* renamed from: b */
    private boolean f12577b = true;
    /* renamed from: c */
    private float f12578c = 0.6756757f;

    public MyImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyImageView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (RuntimeException e) {
        } catch (Exception e2) {
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f12577b) {
            setMeasuredDimension(getMeasuredWidth(), (int) (((float) getMeasuredWidth()) * this.f12576a));
        } else {
            setMeasuredDimension((int) (((float) getMeasuredHeight()) * this.f12578c), getWidth());
        }
    }

    /* renamed from: a */
    public void m17252a() {
        this.f12576a = 0.49115914f;
    }

    /* renamed from: b */
    public void m17253b() {
        this.f12576a = 0.5555556f;
    }

    /* renamed from: c */
    public void m17254c() {
        this.f12576a = 1.45f;
    }
}
