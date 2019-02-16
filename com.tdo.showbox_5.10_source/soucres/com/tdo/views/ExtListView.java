package com.tdo.showbox.views;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class ExtListView extends ListView {
    /* renamed from: a */
    private Rect f12513a = new Rect();
    /* renamed from: b */
    private C2746a f12514b;
    /* renamed from: c */
    private View f12515c;
    /* renamed from: d */
    private int f12516d = 0;
    /* renamed from: e */
    private boolean f12517e;

    /* renamed from: com.tdo.showbox.views.ExtListView$a */
    public interface C2746a {
        /* renamed from: a */
        void mo2031a();
    }

    public ExtListView(Context context) {
        super(context);
    }

    public ExtListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExtListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getCurrentScrollY() {
        return this.f12516d;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m17204b();
    }

    /* renamed from: b */
    private void m17204b() {
        this.f12516d = getScrollY();
        if (this.f12515c != null && this.f12514b != null && this.f12515c.getLocalVisibleRect(this.f12513a)) {
            if (!this.f12515c.getLocalVisibleRect(this.f12513a) || this.f12513a.height() < this.f12515c.getHeight()) {
                if (this.f12517e && this.f12514b != null) {
                    this.f12514b.mo2031a();
                }
            } else if (this.f12514b != null) {
                this.f12514b.mo2031a();
            }
        }
    }

    /* renamed from: a */
    public void m17206a(View view, C2746a c2746a) {
        this.f12515c = view;
        this.f12517e = false;
        this.f12514b = c2746a;
        getHitRect(this.f12513a);
        m17204b();
    }

    /* renamed from: a */
    public void m17207a(View view, boolean z, C2746a c2746a) {
        this.f12515c = view;
        this.f12514b = c2746a;
        this.f12517e = z;
        getHitRect(this.f12513a);
        m17204b();
    }

    /* renamed from: a */
    public void m17205a() {
        this.f12514b = null;
        this.f12515c = null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m17205a();
    }
}
