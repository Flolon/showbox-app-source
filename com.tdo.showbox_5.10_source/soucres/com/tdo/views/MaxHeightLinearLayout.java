package com.tdo.showbox.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.tdo.showbox.p131f.C3184j;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

public class MaxHeightLinearLayout extends LinearLayout {
    /* renamed from: a */
    private final int f12575a;

    public MaxHeightLinearLayout(Context context) {
        super(context);
        this.f12575a = 0;
    }

    public MaxHeightLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12575a = C3184j.m16980a(context, (int) IjkMediaCodecInfo.RANK_SECURE);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i2);
        if (this.f12575a > 0 && this.f12575a < size) {
            i2 = MeasureSpec.makeMeasureSpec(this.f12575a, MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }
}
