package com.tdo.showbox.p121g.p133a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tdo.showbox.p121g.p134b.C3193a;
import java.util.ArrayList;

/* compiled from: AthimetricAdapter */
/* renamed from: com.tdo.showbox.g.a.c */
public abstract class C3194c<T> extends C3193a<T> {
    /* renamed from: b */
    private C3191b f12289b = new C3191b();
    /* renamed from: c */
    private C3195d f12290c = new C3195d();

    /* renamed from: a */
    protected abstract int mo2150a();

    /* renamed from: a */
    public abstract View mo2152a(int i, View view, ViewGroup viewGroup, C3188a c3188a);

    public C3194c(Context context, int i) {
        super(context, i);
    }

    /* renamed from: a */
    public void m17014a(C3191b c3191b) {
        this.f12289b = c3191b;
    }

    /* renamed from: c */
    public C3191b m17017c() {
        return this.f12289b;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return m17016b(i, view, viewGroup, this.f12289b.m17000a(((Integer) this.f12290c.f12293c.get(i)).intValue()));
    }

    /* renamed from: b */
    public View m17016b(int i, View view, ViewGroup viewGroup, C3188a c3188a) {
        int i2;
        int i3;
        int i4 = 0;
        LinearLayout linearLayout = (LinearLayout) view;
        ArrayList arrayList = new ArrayList();
        if (linearLayout == null) {
            linearLayout = new LinearLayout(getContext());
        }
        m17006a(linearLayout);
        mo2162a(linearLayout, c3188a);
        if (linearLayout.getChildCount() != c3188a.m16993a()) {
            linearLayout.removeAllViews();
        } else {
            for (i2 = 0; i2 < c3188a.m16993a(); i2++) {
                arrayList.add(linearLayout.getChildAt(i2));
            }
        }
        linearLayout.setOrientation(0);
        int intValue = ((Integer) this.f12290c.f12292b.get(i)).intValue();
        if (arrayList.size() != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int a = mo2150a();
        while (i4 < c3188a.m16993a()) {
            if (intValue + i4 >= a) {
                try {
                    linearLayout.removeViewAt(i4);
                    i4--;
                } catch (Exception e) {
                }
            } else {
                View a2;
                if (i3 != 0) {
                    a2 = mo2152a(intValue + i4, (View) arrayList.get(i4), null, c3188a);
                } else {
                    a2 = mo2152a(intValue + i4, null, null, c3188a);
                    a2.setLayoutParams(m17011a(c3188a.m16992a(i4), c3188a));
                    linearLayout.addView(a2);
                }
                mo2163a(a2, intValue + i4);
            }
            i4++;
        }
        for (i2 = linearLayout.getChildCount(); i2 < c3188a.m16993a(); i2++) {
            View view2 = new View(getContext());
            view2.setId(404);
            view2.setLayoutParams(m17011a(c3188a.m16992a(i2), c3188a));
            linearLayout.addView(view2);
        }
        return linearLayout;
    }

    /* renamed from: a */
    protected void mo2162a(LinearLayout linearLayout, C3188a c3188a) {
    }

    /* renamed from: a */
    private void m17006a(LinearLayout linearLayout) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            if (linearLayout.getChildAt(i).getId() == 404) {
                linearLayout.removeAllViews();
                return;
            }
        }
    }

    /* renamed from: a */
    public LayoutParams m17011a(float f, C3188a c3188a) {
        LayoutParams layoutParams = new LayoutParams(-1, -2, 1.0f);
        layoutParams.setMargins(mo2151a(c3188a), mo2153b(c3188a), mo2151a(c3188a), mo2153b(c3188a));
        return layoutParams;
    }

    /* renamed from: a */
    public int mo2151a(C3188a c3188a) {
        return 0;
    }

    /* renamed from: b */
    public int mo2153b(C3188a c3188a) {
        return 0;
    }

    /* renamed from: a */
    protected void mo2163a(final View view, final int i) {
        if (view != null) {
            view.setOnClickListener(new OnClickListener(this) {
                /* renamed from: c */
                final /* synthetic */ C3194c f12287c;

                public void onClick(View view) {
                    if (this.f12287c.a != null) {
                        this.f12287c.a.onItemClick(null, view, i, (long) i);
                    }
                }
            });
        }
    }

    public void notifyDataSetChanged() {
        this.f12290c = this.f12289b.m17003b(mo2150a());
        super.notifyDataSetChanged();
    }

    public int getCount() {
        return this.f12290c.f12291a;
    }
}
