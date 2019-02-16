package com.tdo.showbox.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class GridNoRefreshView extends GridView {
    /* renamed from: a */
    private boolean f12558a = false;

    public GridNoRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f12558a) {
            this.f12558a = false;
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }
}
