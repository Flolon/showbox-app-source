package com.tdo.showbox.p123c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.views.hrecyclerviewparalax.C2970c;
import com.tdo.showbox.views.hrecyclerviewparalax.ParallaxImageView;

/* compiled from: TrendingParalaxViewHolder */
/* renamed from: com.tdo.showbox.c.a */
public class C2971a extends C2970c {
    /* renamed from: l */
    public ParallaxImageView f11793l;
    /* renamed from: m */
    public TextView f11794m;
    /* renamed from: n */
    public ImageView f11795n;

    /* renamed from: w */
    public int mo2084w() {
        return R.id.imgv_tv;
    }

    public C2971a(View view) {
        super(view);
        this.f11794m = (TextView) view.findViewById(R.id.txtv_descr);
        this.f11795n = (ImageView) view.findViewById(R.id.imgv_tv_stub);
        this.f11793l = (ParallaxImageView) view.findViewById(R.id.imgv_tv);
    }
}
