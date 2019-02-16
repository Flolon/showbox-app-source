package com.tdo.showbox.p121g;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

/* compiled from: GridViewWithHeaderBaseAdapter */
/* renamed from: com.tdo.showbox.g.b */
public abstract class C3204b extends BaseAdapter {
    /* renamed from: a */
    private int f12319a = 1;
    /* renamed from: b */
    private Context f12320b;
    /* renamed from: c */
    private C2771a f12321c;

    /* compiled from: GridViewWithHeaderBaseAdapter */
    /* renamed from: com.tdo.showbox.g.b$a */
    public interface C2771a {
        /* renamed from: a */
        void mo2052a(View view, int i, Object obj);
    }

    /* compiled from: GridViewWithHeaderBaseAdapter */
    /* renamed from: com.tdo.showbox.g.b$b */
    private class C3198b implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C3204b f12301a;
        /* renamed from: b */
        private int f12302b;

        public C3198b(C3204b c3204b, int i) {
            this.f12301a = c3204b;
            this.f12302b = i;
        }

        public void onClick(View view) {
            this.f12301a.m17036a(view, this.f12302b);
        }
    }

    /* renamed from: a */
    protected abstract View mo2160a(int i, View view, ViewGroup viewGroup);

    /* renamed from: b */
    public abstract int mo2161b();

    public C3204b(Context context) {
        this.f12320b = context;
    }

    /* renamed from: a */
    public final void m17041a(C2771a c2771a) {
        this.f12321c = c2771a;
    }

    /* renamed from: a */
    private final void m17036a(View view, int i) {
        if (this.f12321c != null) {
            this.f12321c.mo2052a(view, i, getItem(i));
        }
    }

    /* renamed from: a */
    public final int m17038a() {
        return this.f12319a;
    }

    /* renamed from: a */
    public final void m17040a(int i) {
        this.f12319a = i;
        notifyDataSetChanged();
    }

    public final int getCount() {
        return (int) Math.ceil((double) ((((float) mo2161b()) * 1.0f) / ((float) m17038a())));
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        double d = 0.0d;
        if (viewGroup != null) {
            d = ((double) viewGroup.getWidth()) / ((double) this.f12319a);
        } else if (view != null) {
            d = ((double) view.getWidth()) / ((double) this.f12319a);
        }
        return m17035a(i, viewGroup, d);
    }

    /* renamed from: a */
    private LinearLayout m17035a(int i, ViewGroup viewGroup, double d) {
        LinearLayout linearLayout = new LinearLayout(this.f12320b);
        linearLayout.setOrientation(0);
        for (int i2 = 0; i2 < this.f12319a; i2++) {
            View a;
            int i3 = (this.f12319a * i) + i2;
            if (i3 < mo2161b()) {
                a = mo2160a(i3, null, viewGroup);
                a.setVisibility(0);
                mo2160a(i3, a, viewGroup).setOnClickListener(new C3198b(this, i3));
            } else {
                a = new View(this.f12320b);
                a.setVisibility(4);
            }
            linearLayout.addView(a);
            LayoutParams layoutParams = a.getLayoutParams();
            layoutParams.width = (int) d;
            a.setLayoutParams(layoutParams);
        }
        return linearLayout;
    }
}
