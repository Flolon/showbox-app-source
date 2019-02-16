package com.tdo.showbox.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.TextView;
import com.tdo.showbox.C2968b.C2743a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

public class MagicTextView extends TextView {
    /* renamed from: a */
    private ArrayList<C3260a> f12563a;
    /* renamed from: b */
    private ArrayList<C3260a> f12564b;
    /* renamed from: c */
    private WeakHashMap<String, Pair<Canvas, Bitmap>> f12565c;
    /* renamed from: d */
    private Canvas f12566d;
    /* renamed from: e */
    private Bitmap f12567e;
    /* renamed from: f */
    private Drawable f12568f;
    /* renamed from: g */
    private float f12569g;
    /* renamed from: h */
    private Integer f12570h;
    /* renamed from: i */
    private Join f12571i;
    /* renamed from: j */
    private float f12572j;
    /* renamed from: k */
    private int[] f12573k;
    /* renamed from: l */
    private boolean f12574l = false;

    /* renamed from: com.tdo.showbox.views.MagicTextView$a */
    public static class C3260a {
        /* renamed from: a */
        float f12559a;
        /* renamed from: b */
        float f12560b;
        /* renamed from: c */
        float f12561c;
        /* renamed from: d */
        int f12562d;

        public C3260a(float f, float f2, float f3, int i) {
            this.f12559a = f;
            this.f12560b = f2;
            this.f12561c = f3;
            this.f12562d = i;
        }
    }

    public MagicTextView(Context context) {
        super(context);
        m17249a(null);
    }

    public MagicTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17249a(attributeSet);
    }

    public MagicTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17249a(attributeSet);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m17249a(AttributeSet attributeSet) {
        this.f12563a = new ArrayList();
        this.f12564b = new ArrayList();
        if (this.f12565c == null) {
            this.f12565c = new WeakHashMap();
        }
        if (attributeSet != null) {
            Drawable drawable;
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C2743a.MagicTextView);
            if (obtainStyledAttributes.getString(14) != null) {
                setTypeface(Typeface.createFromAsset(getContext().getAssets(), String.format("fonts/%s.ttf", new Object[]{r0})));
            }
            if (obtainStyledAttributes.hasValue(13)) {
                drawable = obtainStyledAttributes.getDrawable(13);
                if (drawable != null) {
                    setForegroundDrawable(drawable);
                } else {
                    setTextColor(obtainStyledAttributes.getColor(13, -16777216));
                }
            }
            if (obtainStyledAttributes.hasValue(12)) {
                drawable = obtainStyledAttributes.getDrawable(12);
                if (drawable != null) {
                    setBackgroundDrawable(drawable);
                } else {
                    setBackgroundColor(obtainStyledAttributes.getColor(12, -16777216));
                }
            }
            if (obtainStyledAttributes.hasValue(0)) {
                m17251b((float) obtainStyledAttributes.getDimensionPixelSize(3, 0), (float) obtainStyledAttributes.getDimensionPixelOffset(1, 0), (float) obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getColor(0, -16777216));
            }
            if (obtainStyledAttributes.hasValue(4)) {
                m17247a((float) obtainStyledAttributes.getDimensionPixelSize(7, 0), (float) obtainStyledAttributes.getDimensionPixelOffset(5, 0), (float) obtainStyledAttributes.getDimensionPixelOffset(6, 0), obtainStyledAttributes.getColor(4, -16777216));
            }
            if (obtainStyledAttributes.hasValue(8)) {
                float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(11, 1);
                int color = obtainStyledAttributes.getColor(8, -16777216);
                float dimensionPixelSize2 = (float) obtainStyledAttributes.getDimensionPixelSize(10, 10);
                Join join = null;
                switch (obtainStyledAttributes.getInt(9, 0)) {
                    case 0:
                        join = Join.MITER;
                        break;
                    case 1:
                        join = Join.BEVEL;
                        break;
                    case 2:
                        join = Join.ROUND;
                        break;
                }
                m17248a(dimensionPixelSize, color, join, dimensionPixelSize2);
            }
        }
        if (VERSION.SDK_INT < 11) {
            return;
        }
        if (this.f12564b.size() > 0 || this.f12568f != null) {
            setLayerType(1, null);
        }
    }

    /* renamed from: a */
    public void m17248a(float f, int i, Join join, float f2) {
        this.f12569g = f;
        this.f12570h = Integer.valueOf(i);
        this.f12571i = join;
        this.f12572j = f2;
    }

    /* renamed from: a */
    public void m17247a(float f, float f2, float f3, int i) {
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.f12563a.add(new C3260a(f, f2, f3, i));
    }

    /* renamed from: b */
    public void m17251b(float f, float f2, float f3, int i) {
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.f12564b.add(new C3260a(f, f2, f3, i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.f12568f = drawable;
    }

    public Drawable getForeground() {
        return this.f12568f == null ? this.f12568f : new ColorDrawable(getCurrentTextColor());
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m17246a();
        Drawable background = getBackground();
        Drawable[] compoundDrawables = getCompoundDrawables();
        int currentTextColor = getCurrentTextColor();
        setCompoundDrawables(null, null, null, null);
        Iterator it = this.f12563a.iterator();
        while (it.hasNext()) {
            C3260a c3260a = (C3260a) it.next();
            setShadowLayer(c3260a.f12559a, c3260a.f12560b, c3260a.f12561c, c3260a.f12562d);
            super.onDraw(canvas);
        }
        setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        setTextColor(currentTextColor);
        if (this.f12568f != null && (this.f12568f instanceof BitmapDrawable)) {
            m17245c();
            super.onDraw(this.f12566d);
            ((BitmapDrawable) this.f12568f).getPaint().setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
            this.f12568f.setBounds(canvas.getClipBounds());
            this.f12568f.draw(this.f12566d);
            canvas.drawBitmap(this.f12567e, 0.0f, 0.0f, null);
            this.f12566d.drawColor(0, Mode.CLEAR);
        }
        if (this.f12570h != null) {
            TextPaint paint = getPaint();
            paint.setStyle(Style.STROKE);
            paint.setStrokeJoin(this.f12571i);
            paint.setStrokeMiter(this.f12572j);
            setTextColor(this.f12570h.intValue());
            paint.setStrokeWidth(this.f12569g);
            super.onDraw(canvas);
            paint.setStyle(Style.FILL);
            setTextColor(currentTextColor);
        }
        if (this.f12564b.size() > 0) {
            m17245c();
            TextPaint paint2 = getPaint();
            Iterator it2 = this.f12564b.iterator();
            while (it2.hasNext()) {
                c3260a = (C3260a) it2.next();
                setTextColor(c3260a.f12562d);
                super.onDraw(this.f12566d);
                setTextColor(-16777216);
                paint2.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));
                paint2.setMaskFilter(new BlurMaskFilter(c3260a.f12559a, Blur.NORMAL));
                this.f12566d.save();
                this.f12566d.translate(c3260a.f12560b, c3260a.f12561c);
                super.onDraw(this.f12566d);
                this.f12566d.restore();
                canvas.drawBitmap(this.f12567e, 0.0f, 0.0f, null);
                this.f12566d.drawColor(0, Mode.CLEAR);
                paint2.setXfermode(null);
                paint2.setMaskFilter(null);
                setTextColor(currentTextColor);
                setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
        if (compoundDrawables != null) {
            setCompoundDrawablesWithIntrinsicBounds(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
        setBackgroundDrawable(background);
        setTextColor(currentTextColor);
        m17250b();
    }

    /* renamed from: c */
    private void m17245c() {
        String format = String.format("%dx%d", new Object[]{Integer.valueOf(getWidth()), Integer.valueOf(getHeight())});
        Pair pair = (Pair) this.f12565c.get(format);
        if (pair != null) {
            this.f12566d = (Canvas) pair.first;
            this.f12567e = (Bitmap) pair.second;
            return;
        }
        this.f12566d = new Canvas();
        this.f12567e = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        this.f12566d.setBitmap(this.f12567e);
        this.f12565c.put(format, new Pair(this.f12566d, this.f12567e));
    }

    /* renamed from: a */
    public void m17246a() {
        this.f12573k = new int[]{getCompoundPaddingLeft(), getCompoundPaddingRight(), getCompoundPaddingTop(), getCompoundPaddingBottom()};
        this.f12574l = true;
    }

    /* renamed from: b */
    public void m17250b() {
        this.f12574l = false;
    }

    public void requestLayout() {
        if (!this.f12574l) {
            super.requestLayout();
        }
    }

    public void postInvalidate() {
        if (!this.f12574l) {
            super.postInvalidate();
        }
    }

    public void postInvalidate(int i, int i2, int i3, int i4) {
        if (!this.f12574l) {
            super.postInvalidate(i, i2, i3, i4);
        }
    }

    public void invalidate() {
        if (!this.f12574l) {
            super.invalidate();
        }
    }

    public void invalidate(Rect rect) {
        if (!this.f12574l) {
            super.invalidate(rect);
        }
    }

    public void invalidate(int i, int i2, int i3, int i4) {
        if (!this.f12574l) {
            super.invalidate(i, i2, i3, i4);
        }
    }

    public int getCompoundPaddingLeft() {
        return !this.f12574l ? super.getCompoundPaddingLeft() : this.f12573k[0];
    }

    public int getCompoundPaddingRight() {
        return !this.f12574l ? super.getCompoundPaddingRight() : this.f12573k[1];
    }

    public int getCompoundPaddingTop() {
        return !this.f12574l ? super.getCompoundPaddingTop() : this.f12573k[2];
    }

    public int getCompoundPaddingBottom() {
        return !this.f12574l ? super.getCompoundPaddingBottom() : this.f12573k[3];
    }
}
