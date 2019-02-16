package com.tdo.showbox.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RecycledImageView extends ImageView {
    public RecycledImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public RecycledImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecycledImageView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (RuntimeException e) {
        } catch (Exception e2) {
        }
    }
}
