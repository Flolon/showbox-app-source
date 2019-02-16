package com.tdo.showbox.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class TopScrollView extends ScrollView {
    /* renamed from: a */
    private boolean f12697a = false;

    public TopScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f12697a) {
            this.f12697a = false;
            scrollTo(0, 0);
        }
    }
}
