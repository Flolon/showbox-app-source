package com.tdo.showbox.views.materialmenu;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.Property;
import android.util.TypedValue;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

/* compiled from: MaterialMenuDrawable */
/* renamed from: com.tdo.showbox.views.materialmenu.b */
public class C3353b extends Drawable implements Animatable {
    /* renamed from: A */
    private boolean f12955A;
    /* renamed from: B */
    private ObjectAnimator f12956B;
    /* renamed from: C */
    private ObjectAnimator f12957C;
    /* renamed from: D */
    private AnimatorListener f12958D;
    /* renamed from: E */
    private C3351c f12959E;
    /* renamed from: F */
    private Property<C3353b, Float> f12960F;
    /* renamed from: G */
    private Property<C3353b, Float> f12961G;
    /* renamed from: a */
    private final float f12962a;
    /* renamed from: b */
    private final float f12963b;
    /* renamed from: c */
    private final float f12964c;
    /* renamed from: d */
    private final float f12965d;
    /* renamed from: e */
    private final float f12966e;
    /* renamed from: f */
    private final float f12967f;
    /* renamed from: g */
    private final float f12968g;
    /* renamed from: h */
    private final int f12969h;
    /* renamed from: i */
    private final int f12970i;
    /* renamed from: j */
    private final float f12971j;
    /* renamed from: k */
    private final float f12972k;
    /* renamed from: l */
    private final float f12973l;
    /* renamed from: m */
    private final float f12974m;
    /* renamed from: n */
    private final float f12975n;
    /* renamed from: o */
    private final C3352d f12976o;
    /* renamed from: p */
    private final Object f12977p;
    /* renamed from: q */
    private final Paint f12978q;
    /* renamed from: r */
    private final Paint f12979r;
    /* renamed from: s */
    private float f12980s;
    /* renamed from: t */
    private float f12981t;
    /* renamed from: u */
    private boolean f12982u;
    /* renamed from: v */
    private C3350b f12983v;
    /* renamed from: w */
    private C3349a f12984w;
    /* renamed from: x */
    private C3350b f12985x;
    /* renamed from: y */
    private boolean f12986y;
    /* renamed from: z */
    private boolean f12987z;

    /* compiled from: MaterialMenuDrawable */
    /* renamed from: com.tdo.showbox.views.materialmenu.b$3 */
    class C33463 extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ C3353b f12931a;

        C33463(C3353b c3353b) {
            this.f12931a = c3353b;
        }

        public void onAnimationEnd(Animator animator) {
            try {
                this.f12931a.f12982u = false;
                this.f12931a.m17636a(this.f12931a.f12985x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: MaterialMenuDrawable */
    /* renamed from: com.tdo.showbox.views.materialmenu.b$4 */
    class C33474 extends AnimatorListenerAdapter {
        /* renamed from: a */
        final /* synthetic */ C3353b f12932a;

        C33474(C3353b c3353b) {
            this.f12932a = c3353b;
        }

        public void onAnimationEnd(Animator animator) {
            this.f12932a.f12981t = 0.0f;
        }

        public void onAnimationCancel(Animator animator) {
            this.f12932a.f12981t = 0.0f;
        }
    }

    /* compiled from: MaterialMenuDrawable */
    /* renamed from: com.tdo.showbox.views.materialmenu.b$a */
    public enum C3349a {
        BURGER_ARROW,
        BURGER_X,
        ARROW_X,
        ARROW_CHECK,
        BURGER_CHECK,
        X_CHECK
    }

    /* compiled from: MaterialMenuDrawable */
    /* renamed from: com.tdo.showbox.views.materialmenu.b$b */
    public enum C3350b {
        BURGER,
        ARROW,
        X,
        CHECK
    }

    /* compiled from: MaterialMenuDrawable */
    /* renamed from: com.tdo.showbox.views.materialmenu.b$c */
    private final class C3351c extends ConstantState {
        /* renamed from: a */
        final /* synthetic */ C3353b f12948a;
        /* renamed from: b */
        private int f12949b;

        private C3351c(C3353b c3353b) {
            this.f12948a = c3353b;
        }

        public Drawable newDrawable() {
            Drawable c3353b = new C3353b(this.f12948a.f12979r.getColor(), this.f12948a.f12976o, this.f12948a.f12956B.getDuration(), this.f12948a.f12957C.getDuration(), this.f12948a.f12969h, this.f12948a.f12970i, this.f12948a.f12972k, this.f12948a.f12975n, this.f12948a.f12971j, this.f12948a.f12963b);
            c3353b.m17636a(this.f12948a.f12985x != null ? this.f12948a.f12985x : this.f12948a.f12983v);
            c3353b.m17639a(this.f12948a.f12955A);
            return c3353b;
        }

        public int getChangingConfigurations() {
            return this.f12949b;
        }
    }

    /* compiled from: MaterialMenuDrawable */
    /* renamed from: com.tdo.showbox.views.materialmenu.b$d */
    public enum C3352d {
        REGULAR(3),
        THIN(2),
        EXTRA_THIN(1);
        
        /* renamed from: d */
        private final int f12954d;

        private C3352d(int i) {
            this.f12954d = i;
        }

        /* renamed from: a */
        protected static C3352d m17606a(int i) {
            switch (i) {
                case 1:
                    return EXTRA_THIN;
                case 2:
                    return THIN;
                case 3:
                    return REGULAR;
                default:
                    return THIN;
            }
        }
    }

    public C3353b(Context context, int i, C3352d c3352d, int i2, int i3, int i4) {
        this.f12977p = new Object();
        this.f12978q = new Paint();
        this.f12979r = new Paint();
        this.f12980s = 0.0f;
        this.f12981t = 0.0f;
        this.f12982u = false;
        this.f12983v = C3350b.BURGER;
        this.f12984w = C3349a.BURGER_ARROW;
        this.f12960F = new Property<C3353b, Float>(this, Float.class, "transformation") {
            /* renamed from: a */
            final /* synthetic */ C3353b f12929a;

            public /* synthetic */ Object get(Object obj) {
                return m17601a((C3353b) obj);
            }

            public /* synthetic */ void set(Object obj, Object obj2) {
                m17602a((C3353b) obj, (Float) obj2);
            }

            /* renamed from: a */
            public Float m17601a(C3353b c3353b) {
                return c3353b.m17640b();
            }

            /* renamed from: a */
            public void m17602a(C3353b c3353b, Float f) {
                c3353b.m17638a(f);
            }
        };
        this.f12961G = new Property<C3353b, Float>(this, Float.class, "pressedProgress") {
            /* renamed from: a */
            final /* synthetic */ C3353b f12930a;

            public /* synthetic */ Object get(Object obj) {
                return m17603a((C3353b) obj);
            }

            public /* synthetic */ void set(Object obj, Object obj2) {
                m17604a((C3353b) obj, (Float) obj2);
            }

            /* renamed from: a */
            public Float m17603a(C3353b c3353b) {
                return c3353b.m17643c();
            }

            /* renamed from: a */
            public void m17604a(C3353b c3353b, Float f) {
                c3353b.m17642b(f);
            }
        };
        Resources resources = context.getResources();
        this.f12963b = C3353b.m17608a(resources, 1.0f) * ((float) i2);
        this.f12964c = C3353b.m17608a(resources, 2.0f) * ((float) i2);
        this.f12965d = C3353b.m17608a(resources, 3.0f) * ((float) i2);
        this.f12966e = C3353b.m17608a(resources, 4.0f) * ((float) i2);
        this.f12967f = C3353b.m17608a(resources, 6.0f) * ((float) i2);
        this.f12968g = C3353b.m17608a(resources, 8.0f) * ((float) i2);
        this.f12962a = this.f12963b / 2.0f;
        this.f12976o = c3352d;
        this.f12969h = (int) (C3353b.m17608a(resources, 40.0f) * ((float) i2));
        this.f12970i = (int) (C3353b.m17608a(resources, 40.0f) * ((float) i2));
        this.f12972k = C3353b.m17608a(resources, 23.0f) * ((float) i2);
        this.f12975n = C3353b.m17608a(resources, 15.0f) * ((float) i2);
        this.f12971j = C3353b.m17608a(resources, 1.2f) * ((float) i2);
        this.f12974m = (((float) this.f12969h) - this.f12972k) / 2.0f;
        this.f12973l = (((float) this.f12970i) - (5.0f * this.f12965d)) / 2.0f;
        m17620d(i);
        m17611a(i3, i4);
        this.f12959E = new C3351c();
    }

    private C3353b(int i, C3352d c3352d, long j, long j2, int i2, int i3, float f, float f2, float f3, float f4) {
        this.f12977p = new Object();
        this.f12978q = new Paint();
        this.f12979r = new Paint();
        this.f12980s = 0.0f;
        this.f12981t = 0.0f;
        this.f12982u = false;
        this.f12983v = C3350b.BURGER;
        this.f12984w = C3349a.BURGER_ARROW;
        this.f12960F = /* anonymous class already generated */;
        this.f12961G = /* anonymous class already generated */;
        this.f12963b = f4;
        this.f12964c = 2.0f * f4;
        this.f12965d = 3.0f * f4;
        this.f12966e = 4.0f * f4;
        this.f12967f = 6.0f * f4;
        this.f12968g = 8.0f * f4;
        this.f12962a = f4 / 2.0f;
        this.f12976o = c3352d;
        this.f12969h = i2;
        this.f12970i = i3;
        this.f12972k = f;
        this.f12975n = f2;
        this.f12971j = f3;
        this.f12974m = (((float) i2) - f) / 2.0f;
        this.f12973l = (((float) i3) - (5.0f * this.f12965d)) / 2.0f;
        m17620d(i);
        m17611a((int) j, (int) j2);
        this.f12959E = new C3351c();
    }

    /* renamed from: d */
    private void m17620d(int i) {
        this.f12978q.setAntiAlias(true);
        this.f12978q.setStyle(Style.STROKE);
        this.f12978q.setStrokeWidth(this.f12971j);
        this.f12978q.setColor(i);
        this.f12979r.setAntiAlias(true);
        this.f12979r.setStyle(Style.FILL);
        this.f12979r.setColor(i);
        this.f12979r.setAlpha(200);
        setBounds(0, 0, this.f12969h, this.f12970i);
    }

    public void draw(Canvas canvas) {
        float f = this.f12980s <= 1.0f ? this.f12980s : 2.0f - this.f12980s;
        if (this.f12955A) {
            canvas.save();
            canvas.scale(-1.0f, 1.0f, 0.0f, 0.0f);
            canvas.translate((float) (-getIntrinsicWidth()), 0.0f);
        }
        m17616b(canvas, f);
        m17613a(canvas, f);
        m17618c(canvas, f);
        if (this.f12955A) {
            canvas.restore();
        }
        if (this.f12986y) {
            m17612a(canvas);
        }
    }

    /* renamed from: a */
    private void m17612a(Canvas canvas) {
        canvas.restore();
        canvas.drawCircle(((float) this.f12969h) / 2.0f, ((float) this.f12970i) / 2.0f, this.f12981t, this.f12979r);
    }

    /* renamed from: a */
    private void m17613a(Canvas canvas, float f) {
        float f2;
        int i;
        canvas.restore();
        canvas.save();
        float f3 = (float) (this.f12969h / 2);
        float f4 = (float) (this.f12969h / 2);
        float f5 = this.f12974m;
        float f6 = this.f12973l + ((this.f12965d / 2.0f) * 5.0f);
        float f7 = ((float) this.f12969h) - this.f12974m;
        float f8 = this.f12973l + ((this.f12965d / 2.0f) * 5.0f);
        float f9;
        switch (this.f12984w) {
            case BURGER_ARROW:
                if (m17621d()) {
                    f9 = 180.0f * f;
                } else {
                    f9 = 180.0f + ((1.0f - f) * 180.0f);
                }
                f7 -= (m17607a(f) * f) / 2.0f;
                f2 = f5;
                f5 = f3;
                f3 = f9;
                i = 255;
                break;
            case BURGER_X:
                i = (int) ((1.0f - f) * 255.0f);
                f2 = f5;
                f5 = f3;
                f3 = 0.0f;
                break;
            case ARROW_X:
                i = (int) ((1.0f - f) * 255.0f);
                f2 = ((1.0f - f) * this.f12964c) + f5;
                f5 = f3;
                f3 = 0.0f;
                break;
            case ARROW_CHECK:
                if (m17621d()) {
                    f9 = 135.0f * f;
                } else {
                    f9 = 135.0f - (135.0f * (1.0f - f));
                }
                f7 += this.f12963b * f;
                f2 = f5 + (((this.f12965d / 2.0f) + this.f12966e) - ((1.0f - f) * this.f12964c));
                f5 = (((float) (this.f12969h / 2)) + this.f12965d) + this.f12962a;
                f3 = f9;
                i = 255;
                break;
            case BURGER_CHECK:
                f3 = f * 135.0f;
                f9 = ((this.f12966e + (this.f12965d / 2.0f)) * f) + f5;
                f7 += this.f12963b * f;
                f5 = (((float) (this.f12969h / 2)) + this.f12965d) + this.f12962a;
                f2 = f9;
                i = 255;
                break;
            case X_CHECK:
                i = (int) (255.0f * f);
                f3 = f * 135.0f;
                f2 = ((this.f12966e + (this.f12965d / 2.0f)) * f) + f5;
                f7 += this.f12963b * f;
                f5 = (((float) (this.f12969h / 2)) + this.f12965d) + this.f12962a;
                break;
            default:
                i = 255;
                f2 = f5;
                f5 = f3;
                f3 = 0.0f;
                break;
        }
        this.f12978q.setAlpha(i);
        canvas.rotate(f3, f5, f4);
        canvas.drawLine(f2, f6, f7, f8, this.f12978q);
        this.f12978q.setAlpha(255);
    }

    /* renamed from: b */
    private void m17616b(Canvas canvas, float f) {
        float f2;
        float f3;
        float f4;
        float f5;
        int i;
        canvas.save();
        float f6 = ((float) (this.f12969h / 2)) + (this.f12965d / 2.0f);
        float f7 = this.f12973l + this.f12964c;
        float f8 = this.f12974m;
        float f9 = this.f12973l + this.f12964c;
        float f10 = ((float) this.f12969h) - this.f12974m;
        float f11 = this.f12973l + this.f12964c;
        float f12;
        switch (this.f12984w) {
            case BURGER_ARROW:
                if (m17621d()) {
                    f12 = 215.0f * f;
                } else {
                    f12 = 215.0f + ((1.0f - f) * 145.0f);
                }
                f2 = (float) (this.f12969h / 2);
                f3 = (float) (this.f12970i / 2);
                f10 -= m17607a(f);
                f8 += this.f12965d * f;
                if (((double) f) <= 0.5d) {
                    f4 = f8;
                    f8 = 0.0f;
                    f5 = f3;
                    f3 = f2;
                    f2 = f12;
                    i = 255;
                    break;
                }
                f4 = (float) (((double) f8) + (((double) this.f12969h) / 7.5d));
                f8 = 0.0f;
                f5 = f3;
                f3 = f2;
                f2 = f12;
                i = 255;
                break;
            case BURGER_X:
                float f13 = 44.0f * f;
                f5 = 90.0f * f;
                f2 = this.f12974m + this.f12966e;
                f3 = this.f12965d + this.f12973l;
                f12 = (this.f12965d * f) + f8;
                f8 = f5;
                f5 = f3;
                f3 = f2;
                f2 = f13;
                f4 = f12;
                i = 255;
                break;
            case ARROW_X:
                f3 = (((this.f12973l + this.f12965d) - ((float) (this.f12970i / 2))) * f) + ((float) (this.f12970i / 2));
                f10 -= m17607a(f);
                f12 = this.f12965d + f8;
                f8 = 90.0f * f;
                f5 = f3;
                f3 = ((float) (this.f12969h / 2)) + (((this.f12974m + this.f12966e) - ((float) (this.f12969h / 2))) * f);
                f2 = 215.0f + (-171.0f * f);
                f4 = f12;
                i = 255;
                break;
            case ARROW_CHECK:
                i = (int) ((1.0f - f) * 255.0f);
                f10 -= m17607a(1.0f);
                f4 = this.f12965d + f8;
                f8 = 0.0f;
                f5 = (float) (this.f12970i / 2);
                f3 = (float) (this.f12969h / 2);
                f2 = 215.0f;
                break;
            case BURGER_CHECK:
                i = (int) ((1.0f - f) * 255.0f);
                f4 = f8;
                f8 = 0.0f;
                f5 = 0.0f;
                f3 = 0.0f;
                f2 = 0.0f;
                break;
            case X_CHECK:
                f10 += this.f12965d - (this.f12965d * (1.0f - f));
                f4 = f8 + this.f12965d;
                i = (int) ((1.0f - f) * 255.0f);
                f8 = 90.0f;
                f5 = this.f12973l + this.f12965d;
                f3 = this.f12974m + this.f12966e;
                f2 = 44.0f;
                break;
            default:
                i = 255;
                f4 = f8;
                f8 = 0.0f;
                f5 = 0.0f;
                f3 = 0.0f;
                f2 = 0.0f;
                break;
        }
        this.f12978q.setAlpha(i);
        canvas.rotate(f2, f3, f5);
        canvas.rotate(f8, f6, f7);
        canvas.drawLine(f4, f9, f10, f11, this.f12978q);
        this.f12978q.setAlpha(255);
    }

    /* renamed from: c */
    private void m17618c(Canvas canvas, float f) {
        float f2;
        float f3;
        canvas.restore();
        canvas.save();
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = ((float) (this.f12969h / 2)) + (this.f12965d / 2.0f);
        float f7 = (((float) this.f12970i) - this.f12973l) - this.f12964c;
        float f8 = this.f12974m;
        float f9 = (((float) this.f12970i) - this.f12973l) - this.f12964c;
        float f10 = ((float) this.f12969h) - this.f12974m;
        float f11 = (((float) this.f12970i) - this.f12973l) - this.f12964c;
        switch (this.f12984w) {
            case BURGER_ARROW:
                if (m17621d()) {
                    f2 = 145.0f * f;
                } else {
                    f2 = 145.0f + ((1.0f - f) * 215.0f);
                }
                f4 = (float) (this.f12969h / 2);
                f5 = (float) (this.f12970i / 2);
                f10 = (((float) this.f12969h) - this.f12974m) - m17607a(f);
                f8 = this.f12974m + (this.f12965d * f);
                if (((double) f) <= 0.5d) {
                    f3 = f5;
                    f5 = f4;
                    f4 = f2;
                    f2 = 0.0f;
                    break;
                }
                f8 = (float) (((double) f8) + (((double) this.f12969h) / 7.5d));
                f3 = f5;
                f5 = f4;
                f4 = f2;
                f2 = 0.0f;
                break;
            case BURGER_X:
                if (m17621d()) {
                    f2 = -90.0f * f;
                } else {
                    f2 = 90.0f * f;
                }
                f4 = -44.0f * f;
                f5 = this.f12966e + this.f12974m;
                f3 = (((float) this.f12970i) - this.f12973l) - this.f12965d;
                f8 += this.f12965d * f;
                break;
            case ARROW_X:
                f4 = 145.0f + (171.0f * f);
                f2 = -90.0f * f;
                f5 = (((this.f12974m + this.f12966e) - ((float) (this.f12969h / 2))) * f) + ((float) (this.f12969h / 2));
                f3 = ((float) (this.f12970i / 2)) + (((((float) (this.f12970i / 2)) - this.f12973l) - this.f12965d) * f);
                f10 -= m17607a(f);
                f8 += this.f12965d;
                break;
            case ARROW_CHECK:
                f4 = 145.0f + (-90.0f * f);
                f5 = (this.f12965d * f) + ((float) (this.f12969h / 2));
                f10 -= m17607a(1.0f);
                f8 += this.f12965d + ((this.f12966e + this.f12963b) * f);
                f3 = ((float) (this.f12970i / 2)) - (this.f12965d * f);
                f2 = 0.0f;
                break;
            case BURGER_CHECK:
                f4 = f * 55.0f;
                f5 = (this.f12965d * f) + ((float) (this.f12969h / 2));
                f8 += this.f12968g * f;
                f10 -= m17607a(f);
                f3 = ((float) (this.f12970i / 2)) - (this.f12965d * f);
                f2 = 0.0f;
                break;
            case X_CHECK:
                f2 = -90.0f * (1.0f - f);
                f4 = -44.0f + (99.0f * f);
                f5 = ((((((float) (this.f12969h / 2)) + this.f12965d) - this.f12974m) - this.f12966e) * f) + (this.f12974m + this.f12966e);
                f3 = ((((float) this.f12970i) - this.f12973l) - this.f12965d) + (((this.f12973l + ((float) (this.f12970i / 2))) - ((float) this.f12970i)) * f);
                f8 += this.f12968g - ((this.f12966e + this.f12963b) * (1.0f - f));
                f10 -= m17607a(1.0f - f);
                break;
            default:
                f3 = 0.0f;
                f2 = 0.0f;
                break;
        }
        canvas.rotate(f4, f5, f3);
        canvas.rotate(f2, f6, f7);
        canvas.drawLine(f8, f9, f10, f11, this.f12978q);
    }

    /* renamed from: d */
    private boolean m17621d() {
        return this.f12980s <= 1.0f;
    }

    /* renamed from: a */
    private float m17607a(float f) {
        switch (this.f12976o) {
            case REGULAR:
                if (this.f12984w == C3349a.ARROW_X || this.f12984w == C3349a.X_CHECK) {
                    return this.f12965d - (this.f12965d * f);
                }
                return this.f12965d * f;
            case THIN:
                if (this.f12984w == C3349a.ARROW_X || this.f12984w == C3349a.X_CHECK) {
                    return (this.f12965d + this.f12962a) - ((this.f12965d + this.f12962a) * f);
                }
                return (this.f12965d + this.f12962a) * f;
            case EXTRA_THIN:
                if (this.f12984w == C3349a.ARROW_X || this.f12984w == C3349a.X_CHECK) {
                    return this.f12966e - ((this.f12965d + this.f12963b) * f);
                }
                return this.f12966e * f;
            default:
                return 0.0f;
        }
    }

    public void setAlpha(int i) {
        this.f12978q.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f12978q.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -2;
    }

    /* renamed from: a */
    public void m17633a(int i) {
        this.f12978q.setColor(i);
        this.f12979r.setColor(i);
        invalidateSelf();
    }

    /* renamed from: b */
    public void m17641b(int i) {
        this.f12956B.setDuration((long) i);
    }

    /* renamed from: c */
    public void m17644c(int i) {
        this.f12957C.setDuration((long) i);
    }

    /* renamed from: a */
    public void m17635a(Interpolator interpolator) {
        this.f12956B.setInterpolator(interpolator);
    }

    /* renamed from: a */
    public void m17634a(AnimatorListener animatorListener) {
        if (this.f12958D != null) {
            this.f12956B.removeListener(this.f12958D);
        }
        if (animatorListener != null) {
            this.f12956B.addListener(animatorListener);
        }
        this.f12958D = animatorListener;
    }

    /* renamed from: a */
    public void m17636a(C3350b c3350b) {
        synchronized (this.f12977p) {
            if (this.f12982u) {
                this.f12956B.cancel();
                this.f12982u = false;
            }
            if (this.f12983v == c3350b) {
                return;
            }
            switch (c3350b) {
                case BURGER:
                    this.f12984w = C3349a.BURGER_ARROW;
                    this.f12980s = 0.0f;
                    break;
                case ARROW:
                    this.f12984w = C3349a.BURGER_ARROW;
                    this.f12980s = 1.0f;
                    break;
                case X:
                    this.f12984w = C3349a.BURGER_X;
                    this.f12980s = 1.0f;
                    break;
                case CHECK:
                    this.f12984w = C3349a.BURGER_CHECK;
                    this.f12980s = 1.0f;
                    break;
            }
            this.f12983v = c3350b;
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public void m17637a(C3350b c3350b, boolean z) {
        synchronized (this.f12977p) {
            if (this.f12982u) {
                this.f12956B.end();
                this.f12957C.end();
            }
            this.f12986y = z;
            this.f12985x = c3350b;
            start();
        }
    }

    /* renamed from: a */
    public void m17639a(boolean z) {
        this.f12955A = z;
        invalidateSelf();
    }

    /* renamed from: a */
    public C3350b m17632a() {
        return this.f12983v;
    }

    /* renamed from: b */
    public Float m17640b() {
        return Float.valueOf(this.f12980s);
    }

    /* renamed from: a */
    public void m17638a(Float f) {
        this.f12980s = f.floatValue();
        invalidateSelf();
    }

    /* renamed from: c */
    public Float m17643c() {
        return Float.valueOf(this.f12981t);
    }

    /* renamed from: b */
    public void m17642b(Float f) {
        this.f12981t = f.floatValue();
        this.f12979r.setAlpha((int) (200.0f * (1.0f - (f.floatValue() / (this.f12975n * 1.22f)))));
        invalidateSelf();
    }

    /* renamed from: a */
    private void m17611a(int i, int i2) {
        this.f12956B = ObjectAnimator.ofFloat(this, this.f12960F, new float[]{0.0f});
        this.f12956B.setInterpolator(new DecelerateInterpolator(3.0f));
        this.f12956B.setDuration((long) i);
        this.f12956B.addListener(new C33463(this));
        this.f12957C = ObjectAnimator.ofFloat(this, this.f12961G, new float[]{0.0f, 0.0f});
        this.f12957C.setDuration((long) i2);
        this.f12957C.setInterpolator(new DecelerateInterpolator());
        this.f12957C.addListener(new C33474(this));
    }

    /* renamed from: e */
    private boolean m17623e() {
        boolean z;
        boolean z2;
        boolean z3 = this.f12983v == C3350b.BURGER;
        if (this.f12983v == C3350b.ARROW) {
            z = true;
        } else {
            z = false;
        }
        if (this.f12983v == C3350b.X) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i;
        if (this.f12983v == C3350b.CHECK) {
            i = 1;
        } else {
            i = 0;
        }
        int i2;
        if (this.f12985x == C3350b.BURGER) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i3;
        if (this.f12985x == C3350b.ARROW) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i4;
        if (this.f12985x == C3350b.X) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        int i5;
        if (this.f12985x == C3350b.CHECK) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        if ((z3 && r7 != 0) || (z && r6 != 0)) {
            this.f12984w = C3349a.BURGER_ARROW;
            return z3;
        } else if ((z && r8 != 0) || (z2 && r7 != 0)) {
            this.f12984w = C3349a.ARROW_X;
            return z;
        } else if ((z3 && r8 != 0) || (z2 && r6 != 0)) {
            this.f12984w = C3349a.BURGER_X;
            return z3;
        } else if ((z && r9 != 0) || (r5 != 0 && r7 != 0)) {
            this.f12984w = C3349a.ARROW_CHECK;
            return z;
        } else if ((z3 && r9 != 0) || (r5 != 0 && r6 != 0)) {
            this.f12984w = C3349a.BURGER_CHECK;
            return z3;
        } else if ((!z2 || r9 == 0) && (r5 == 0 || r8 == 0)) {
            throw new IllegalStateException(String.format("Animating from %s to %s is not supported", new Object[]{this.f12983v, this.f12985x}));
        } else {
            this.f12984w = C3349a.X_CHECK;
            return z2;
        }
    }

    public void start() {
        float f = 1.0f;
        if (!this.f12982u) {
            if (!(this.f12985x == null || this.f12985x == this.f12983v)) {
                this.f12982u = true;
                boolean e = m17623e();
                ObjectAnimator objectAnimator = this.f12956B;
                float[] fArr = new float[2];
                fArr[0] = e ? 0.0f : 1.0f;
                if (!e) {
                    f = 2.0f;
                }
                fArr[1] = f;
                objectAnimator.setFloatValues(fArr);
                this.f12956B.start();
            }
            if (this.f12957C.isRunning()) {
                this.f12957C.cancel();
            }
            if (this.f12986y && !this.f12987z) {
                this.f12957C.setFloatValues(new float[]{0.0f, this.f12975n * 1.22f});
                this.f12957C.start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (isRunning() && this.f12956B.isRunning()) {
            this.f12956B.end();
            return;
        }
        this.f12982u = false;
        invalidateSelf();
    }

    public boolean isRunning() {
        return this.f12982u;
    }

    public int getIntrinsicWidth() {
        return this.f12969h;
    }

    public int getIntrinsicHeight() {
        return this.f12970i;
    }

    public ConstantState getConstantState() {
        this.f12959E.f12949b = getChangingConfigurations();
        return this.f12959E;
    }

    public Drawable mutate() {
        this.f12959E = new C3351c();
        return this;
    }

    /* renamed from: a */
    static float m17608a(Resources resources, float f) {
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }
}
