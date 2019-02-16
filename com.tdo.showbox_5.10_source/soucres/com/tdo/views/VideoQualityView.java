package com.tdo.showbox.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tdo.showbox.R;
import java.util.List;

public class VideoQualityView extends LinearLayout implements OnClickListener {
    /* renamed from: a */
    private View f12703a;
    /* renamed from: b */
    private TextView f12704b;
    /* renamed from: c */
    private TextView f12705c;
    /* renamed from: d */
    private TextView f12706d;
    /* renamed from: e */
    private View f12707e;
    /* renamed from: f */
    private View f12708f;
    /* renamed from: g */
    private View f12709g;
    /* renamed from: h */
    private View f12710h;
    /* renamed from: i */
    private View f12711i;
    /* renamed from: j */
    private View f12712j;
    /* renamed from: k */
    private int f12713k;
    /* renamed from: l */
    private int f12714l;
    /* renamed from: m */
    private int f12715m;
    /* renamed from: n */
    private C3288b f12716n = C3288b.LOW;
    /* renamed from: o */
    private C3287a f12717o;

    /* renamed from: com.tdo.showbox.views.VideoQualityView$a */
    public interface C3287a {
        /* renamed from: a */
        void mo2168a(C3288b c3288b);
    }

    /* renamed from: com.tdo.showbox.views.VideoQualityView$b */
    public enum C3288b {
        LOW(0),
        MIDDLE(1),
        HD(2);
        
        /* renamed from: d */
        private int f12702d;

        private C3288b(int i) {
            this.f12702d = i;
        }

        /* renamed from: a */
        public int m17357a() {
            return this.f12702d;
        }

        /* renamed from: a */
        public static C3288b m17356a(int i) {
            if (i == 1) {
                return MIDDLE;
            }
            if (i == 2) {
                return HD;
            }
            if (i == 0) {
                return LOW;
            }
            return LOW;
        }
    }

    public VideoQualityView(Context context) {
        super(context);
        m17359a();
    }

    public VideoQualityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17359a();
    }

    public VideoQualityView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17359a();
    }

    /* renamed from: a */
    private void m17359a() {
        this.f12703a = LayoutInflater.from(getContext()).inflate(R.layout.view_video_quality, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        removeAllViews();
        addView(this.f12703a, layoutParams);
        this.f12704b = (TextView) findViewById(R.id.btn_low);
        this.f12705c = (TextView) findViewById(R.id.btn_mid);
        this.f12706d = (TextView) findViewById(R.id.btn_hd);
        this.f12714l = getContext().getResources().getColor(R.color.yellow_disabled);
        this.f12713k = getContext().getResources().getColor(R.color.yellow);
        this.f12715m = getContext().getResources().getColor(R.color.marker_disable_color);
        this.f12710h = findViewById(R.id.low_marker);
        this.f12711i = findViewById(R.id.mid_marker);
        this.f12712j = findViewById(R.id.hd_marker);
        this.f12707e = findViewById(R.id.low_view);
        this.f12708f = findViewById(R.id.mid_view);
        this.f12709g = findViewById(R.id.hd_view);
        this.f12707e.setOnClickListener(this);
        this.f12709g.setOnClickListener(this);
        this.f12708f.setOnClickListener(this);
    }

    public void setQualityListener(C3287a c3287a) {
        this.f12717o = c3287a;
    }

    /* renamed from: a */
    public void m17361a(boolean z, List<C3288b> list, C3288b c3288b) {
        OnClickListener onClickListener;
        int i = z ? this.f12713k : this.f12714l;
        int i2 = z ? -1 : this.f12715m;
        int i3 = z ? 0 : 4;
        if (z) {
            onClickListener = this;
        } else {
            onClickListener = null;
        }
        this.f12704b.setTextColor(i);
        this.f12705c.setTextColor(i);
        this.f12706d.setTextColor(i);
        this.f12710h.setBackgroundColor(i2);
        this.f12711i.setBackgroundColor(i2);
        this.f12712j.setBackgroundColor(i2);
        this.f12710h.setVisibility(i3);
        this.f12711i.setVisibility(i3);
        this.f12712j.setVisibility(i3);
        this.f12707e.setOnClickListener(onClickListener);
        this.f12708f.setOnClickListener(onClickListener);
        this.f12709g.setOnClickListener(onClickListener);
        this.f12707e.setEnabled(true);
        this.f12708f.setEnabled(true);
        this.f12709g.setEnabled(true);
        if (list == null || list.size() <= 0) {
            this.f12716n = c3288b;
        } else {
            for (C3288b c3288b2 : list) {
                if (c3288b2 == C3288b.LOW) {
                    this.f12704b.setTextColor(this.f12714l);
                    this.f12707e.setEnabled(false);
                    this.f12710h.setVisibility(8);
                    this.f12707e.setOnClickListener(null);
                } else if (c3288b2 == C3288b.MIDDLE) {
                    this.f12708f.setEnabled(false);
                    this.f12705c.setTextColor(this.f12714l);
                    this.f12711i.setVisibility(8);
                    this.f12708f.setOnClickListener(null);
                } else if (c3288b2 == C3288b.HD) {
                    this.f12709g.setEnabled(false);
                    this.f12706d.setTextColor(this.f12714l);
                    this.f12712j.setVisibility(8);
                    this.f12709g.setOnClickListener(null);
                }
            }
            this.f12716n = m17358a(list, c3288b);
        }
        if (this.f12716n != null && z) {
            m17360a(this.f12716n);
        }
    }

    /* renamed from: a */
    private C3288b m17358a(List<C3288b> list, C3288b c3288b) {
        int i = c3288b.m17357a() == 2 ? 1 : 0;
        int i2 = 0;
        C3288b c3288b2 = c3288b;
        while (i2 < 3) {
            if (!list.contains(c3288b2)) {
                return c3288b2;
            }
            i2++;
            c3288b2 = C3288b.m17356a(((c3288b2.m17357a() + 1) + i) % 3);
        }
        return null;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hd_view:
                m17360a(C3288b.HD);
                return;
            case R.id.low_view:
                m17360a(C3288b.LOW);
                return;
            case R.id.mid_view:
                m17360a(C3288b.MIDDLE);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m17360a(C3288b c3288b) {
        this.f12710h.setVisibility(4);
        this.f12712j.setVisibility(4);
        this.f12711i.setVisibility(4);
        if (c3288b == C3288b.LOW) {
            this.f12710h.setVisibility(0);
        } else if (c3288b == C3288b.MIDDLE) {
            this.f12711i.setVisibility(0);
        } else if (c3288b == C3288b.HD) {
            this.f12712j.setVisibility(0);
        }
        this.f12716n = c3288b;
        if (this.f12717o != null) {
            this.f12717o.mo2168a(this.f12716n);
        }
    }
}
