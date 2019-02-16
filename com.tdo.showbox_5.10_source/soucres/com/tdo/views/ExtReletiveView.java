package com.tdo.showbox.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ExtReletiveView extends RelativeLayout {
    /* renamed from: a */
    protected float f12518a = 1.45f;
    /* renamed from: b */
    private boolean f12519b = true;
    /* renamed from: c */
    private float f12520c = 0.6756757f;

    public ExtReletiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ExtReletiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExtReletiveView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (RuntimeException e) {
        } catch (Exception e2) {
        }
    }

    public void setScaleKoof(float f) {
        this.f12518a = f;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f12519b) {
            setMeasuredDimension(getMeasuredWidth(), (int) (((float) getMeasuredWidth()) * this.f12518a));
            return;
        }
        setMeasuredDimension((int) (((float) getMeasuredHeight()) * this.f12520c), getWidth());
    }

    /* renamed from: a */
    public void m17208a() {
        this.f12518a = 0.625f;
    }

    /* renamed from: b */
    public void m17209b() {
        this.f12518a = 0.49115914f;
    }

    /* renamed from: c */
    public void m17210c() {
        this.f12518a = 1.45f;
    }
}
