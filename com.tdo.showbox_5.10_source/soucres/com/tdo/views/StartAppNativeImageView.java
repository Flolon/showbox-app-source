package com.tdo.showbox.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class StartAppNativeImageView extends ImageView {
    public StartAppNativeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public StartAppNativeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StartAppNativeImageView(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) (((double) ((float) getMeasuredWidth())) * 0.52d));
    }
}
