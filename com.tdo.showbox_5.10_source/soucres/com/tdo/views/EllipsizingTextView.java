package com.tdo.showbox.views;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class EllipsizingTextView extends TextView {
    /* renamed from: a */
    private final List<C3253a> f12505a = new ArrayList();
    /* renamed from: b */
    private boolean f12506b;
    /* renamed from: c */
    private boolean f12507c;
    /* renamed from: d */
    private boolean f12508d;
    /* renamed from: e */
    private String f12509e;
    /* renamed from: f */
    private int f12510f = -1;
    /* renamed from: g */
    private float f12511g = 1.0f;
    /* renamed from: h */
    private float f12512h = 0.0f;

    /* renamed from: com.tdo.showbox.views.EllipsizingTextView$a */
    public interface C3253a {
        /* renamed from: a */
        void m17201a(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.f12510f = i;
        this.f12507c = true;
    }

    public int getMaxLines() {
        return this.f12510f;
    }

    public void setLineSpacing(float f, float f2) {
        this.f12512h = f;
        this.f12511g = f2;
        super.setLineSpacing(f, f2);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.f12508d) {
            this.f12509e = charSequence.toString();
            this.f12507c = true;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.f12507c) {
            super.setEllipsize(null);
            m17203a();
        }
        super.onDraw(canvas);
    }

    /* renamed from: a */
    private void m17203a() {
        boolean z;
        int maxLines = getMaxLines();
        CharSequence charSequence = this.f12509e;
        if (maxLines != -1) {
            Layout a = m17202a(charSequence);
            if (a.getLineCount() > maxLines) {
                String trim = this.f12509e.substring(0, a.getLineEnd(maxLines - 1)).trim();
                while (m17202a(trim + "...").getLineCount() > maxLines) {
                    int lastIndexOf = trim.lastIndexOf(32);
                    if (lastIndexOf == -1) {
                        break;
                    }
                    trim = trim.substring(0, lastIndexOf);
                }
                charSequence = trim + "...";
                z = true;
                if (!charSequence.equals(getText())) {
                    this.f12508d = true;
                    try {
                        setText(charSequence);
                    } finally {
                        this.f12508d = false;
                    }
                }
                this.f12507c = false;
                if (z != this.f12506b) {
                    this.f12506b = z;
                    for (C3253a a2 : this.f12505a) {
                        a2.m17201a(z);
                    }
                }
            }
        }
        z = false;
        if (charSequence.equals(getText())) {
            this.f12508d = true;
            setText(charSequence);
        }
        this.f12507c = false;
        if (z != this.f12506b) {
            this.f12506b = z;
            while (r2.hasNext()) {
                a2.m17201a(z);
            }
        }
    }

    /* renamed from: a */
    private Layout m17202a(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Alignment.ALIGN_NORMAL, this.f12511g, this.f12512h, false);
    }

    public void setEllipsize(TruncateAt truncateAt) {
    }
}
