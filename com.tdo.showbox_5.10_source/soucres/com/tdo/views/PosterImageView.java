package com.tdo.showbox.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class PosterImageView extends ImageView {
    public PosterImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PosterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PosterImageView(Context context) {
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
        setMeasuredDimension(getMeasuredWidth(), (int) (((float) getMeasuredWidth()) / 2.036f));
    }
}
