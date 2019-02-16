package com.tdo.showbox.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SeasonImageView extends ImageView {
    public SeasonImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SeasonImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SeasonImageView(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) (((double) getMeasuredWidth()) / 1.35d));
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (RuntimeException e) {
        } catch (Exception e2) {
        }
    }
}
