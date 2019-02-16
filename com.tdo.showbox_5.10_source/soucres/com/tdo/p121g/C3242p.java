package com.tdo.showbox.p121g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.models.Trailer;
import com.tdo.showbox.p121g.p133a.C3188a;
import com.tdo.showbox.p121g.p133a.C3189e;
import com.tdo.showbox.p121g.p133a.C3191b;
import com.tdo.showbox.p121g.p133a.C3194c;
import com.tdo.showbox.p121g.p133a.C3196f;
import java.util.List;
import java.util.Locale;

/* compiled from: TrailersAdapter */
/* renamed from: com.tdo.showbox.g.p */
public class C3242p extends C3194c<Void> {
    /* renamed from: b */
    private List<Trailer> f12462b;
    /* renamed from: c */
    private LayoutInflater f12463c;
    /* renamed from: d */
    private MainActivity f12464d;
    /* renamed from: e */
    private int f12465e = 1;
    /* renamed from: f */
    private int f12466f = 2;
    /* renamed from: g */
    private int f12467g = 1;
    /* renamed from: h */
    private int f12468h = 2;
    /* renamed from: i */
    private int f12469i = 2;
    /* renamed from: j */
    private View f12470j;

    /* compiled from: TrailersAdapter */
    /* renamed from: com.tdo.showbox.g.p$1 */
    class C32401 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3242p f12460a;

        C32401(C3242p c3242p) {
            this.f12460a = c3242p;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            if (i == this.f12460a.f12469i) {
                return this.f12460a.f12467g;
            }
            return this.f12460a.f12468h;
        }
    }

    /* compiled from: TrailersAdapter */
    /* renamed from: com.tdo.showbox.g.p$2 */
    class C32412 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3242p f12461a;

        C32412(C3242p c3242p) {
            this.f12461a = c3242p;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            try {
                return this.f12461a.getContext().getResources().getConfiguration().orientation == 2 ? this.f12461a.f12466f : this.f12461a.f12465e;
            } catch (Exception e) {
                return this.f12461a.f12466f;
            }
        }
    }

    public C3242p(MainActivity mainActivity, List<Trailer> list, boolean z) {
        super(mainActivity, 1);
        this.f12462b = list;
        this.f12463c = LayoutInflater.from(mainActivity);
        this.f12464d = mainActivity;
        if (z) {
            m17165d();
        } else {
            m17162b();
        }
    }

    /* renamed from: a */
    public void m17170a(View view) {
        this.f12470j = view;
        notifyDataSetChanged();
    }

    /* renamed from: b */
    private void m17162b() {
        C3191b c3191b = new C3191b();
        c3191b.m17001a(this.f12467g, new C3196f(true, 1));
        c3191b.m17001a(this.f12468h, new C3196f(true, 2));
        c3191b.m17002a(new C32401(this));
        m17014a(c3191b);
    }

    /* renamed from: d */
    private void m17165d() {
        C3191b c3191b = new C3191b();
        try {
            c3191b.m17001a(this.f12465e, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_portret)));
            c3191b.m17001a(this.f12466f, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_land)));
        } catch (Exception e) {
            c3191b.m17001a(this.f12465e, new C3196f(true, 4));
            c3191b.m17001a(this.f12466f, new C3196f(true, 5));
        }
        c3191b.m17002a(new C32412(this));
        m17014a(c3191b);
    }

    /* renamed from: a */
    public int mo2151a(C3188a c3188a) {
        try {
            return getContext().getResources().getDimensionPixelSize(R.dimen.grid_item_padding);
        } catch (Exception e) {
            return 10;
        }
    }

    /* renamed from: b */
    public int mo2153b(C3188a c3188a) {
        try {
            return getContext().getResources().getDimensionPixelSize(R.dimen.grid_item_padding);
        } catch (Exception e) {
            return 10;
        }
    }

    /* renamed from: a */
    public View mo2152a(int i, View view, ViewGroup viewGroup, C3188a c3188a) {
        if (c3188a.m16993a() == 1) {
            if (view == null || !(view instanceof FrameLayout)) {
                view = new FrameLayout(this.f12464d);
                view.setLayoutParams(new LayoutParams(-1, -2));
            } else {
                view = (FrameLayout) view;
            }
            if (this.f12470j != null) {
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                ViewGroup viewGroup2 = (ViewGroup) this.f12470j.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeAllViews();
                }
                view.removeAllViews();
                view.addView(this.f12470j, layoutParams);
            }
        } else {
            if (view == null) {
                view = this.f12463c.inflate(R.layout.item_tv, viewGroup, false);
            }
            try {
                TextView textView = (TextView) view.findViewById(R.id.txtv_descr);
                ImageView imageView = (ImageView) view.findViewById(R.id.imgv_tv);
                View view2 = (ImageView) view.findViewById(R.id.imgv_tv_stub);
                Trailer trailer = (Trailer) this.f12462b.get(m17159a(i));
                textView.setText(trailer.getTitle());
                if (((C3196f) c3188a).mo2149b()) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(4);
                }
                this.f12464d.m15139C().m16634a(imageView, view2, trailer.getPoster());
            } catch (Exception e) {
            }
        }
        return view;
    }

    /* renamed from: a */
    private int m17159a(int i) {
        if (m17017c() == null) {
            return i;
        }
        if (m17017c().m17000a(this.f12468h) == null) {
            throw new RuntimeException(String.format(Locale.getDefault(), "Can`t find row rule [%s]", new Object[]{Integer.valueOf(this.f12468h)}));
        } else if (i < m17017c().m17000a(this.f12468h).m16993a() * this.f12469i) {
            return i;
        } else {
            return i - 1;
        }
    }

    /* renamed from: a */
    protected void mo2163a(View view, int i) {
        super.mo2163a(view, m17159a(i));
    }

    /* renamed from: a */
    public int mo2150a() {
        return (this.f12462b == null || this.f12462b.isEmpty()) ? 0 : this.f12462b.size() + 1;
    }
}
