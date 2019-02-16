package com.tdo.showbox.views.hrecyclerviewparalax;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0673a;
import android.support.v7.widget.RecyclerView.C0686m;
import android.support.v7.widget.RecyclerView.C0696v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.tdo.showbox.R;
import java.util.List;

/* compiled from: AbstractRecyclerViewAdapter */
/* renamed from: com.tdo.showbox.views.hrecyclerviewparalax.a */
public abstract class C3208a<T> extends C0673a<C0696v> {
    /* renamed from: a */
    private final int f12334a = 5;
    /* renamed from: b */
    private final int f12335b = 0;
    /* renamed from: c */
    private final int f12336c = 1;
    /* renamed from: d */
    private List<T> f12337d;
    /* renamed from: e */
    private int f12338e;
    /* renamed from: f */
    private int f12339f;
    /* renamed from: g */
    private int f12340g;
    /* renamed from: h */
    private int f12341h = 0;
    /* renamed from: i */
    private boolean f12342i = true;

    /* compiled from: AbstractRecyclerViewAdapter */
    /* renamed from: com.tdo.showbox.views.hrecyclerviewparalax.a$a */
    public static class C3339a extends C0696v {
        /* renamed from: l */
        public ProgressBar f12925l;

        public C3339a(View view) {
            super(view);
            this.f12925l = (ProgressBar) view.findViewById(R.id.progressBar);
        }
    }

    /* renamed from: c */
    public abstract C0696v mo2158c(ViewGroup viewGroup, int i);

    /* renamed from: c */
    public abstract void mo2159c(C0696v c0696v, int i);

    public C3208a(RecyclerView recyclerView, List<T> list, final C3340b c3340b) {
        this.f12337d = list;
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.mo2172a(new C0686m(this) {
                /* renamed from: c */
                final /* synthetic */ C3208a f12924c;

                /* renamed from: a */
                public void mo2171a(RecyclerView recyclerView, int i, int i2) {
                    this.f12924c.f12340g = linearLayoutManager.m3499y();
                    this.f12924c.f12339f = linearLayoutManager.m3491q();
                    this.f12924c.f12338e = linearLayoutManager.m3562h();
                    if (this.f12924c.f12342i && this.f12924c.f12340g > this.f12924c.f12341h) {
                        this.f12924c.f12342i = false;
                        this.f12924c.f12341h = this.f12924c.f12340g;
                    }
                    if (!this.f12924c.f12342i && this.f12924c.f12340g - this.f12924c.f12339f <= this.f12924c.f12338e + 5) {
                        this.f12924c.m17064a(null);
                        if (c3340b != null) {
                            c3340b.m17593a();
                        }
                        this.f12924c.f12342i = true;
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m17064a(T t) {
        if (!this.f12337d.contains(t)) {
            this.f12337d.add(t);
            m3630c(this.f12337d.size() - 1);
        }
    }

    /* renamed from: c */
    public List<T> m17066c() {
        return this.f12337d;
    }

    /* renamed from: a */
    public int mo2155a(int i) {
        return this.f12337d.get(i) != null ? 0 : 1;
    }

    /* renamed from: a */
    public int mo2154a() {
        return this.f12337d.size();
    }

    /* renamed from: a */
    public C0696v mo2156a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return mo2158c(viewGroup, i);
        }
        if (i == 1) {
            return m17068d(viewGroup, i);
        }
        throw new IllegalStateException("Invalid type, this type ot items " + i + " can't be handled");
    }

    /* renamed from: a */
    public void mo2157a(C0696v c0696v, int i) {
        if (mo2155a(i) == 0) {
            mo2159c(c0696v, i);
        } else {
            m17069d(c0696v, i);
        }
    }

    /* renamed from: d */
    public C0696v m17068d(ViewGroup viewGroup, int i) {
        return new C3339a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_loadmore_progress, viewGroup, false));
    }

    /* renamed from: d */
    public void m17069d(C0696v c0696v, int i) {
        ((C3339a) c0696v).f12925l.setIndeterminate(true);
    }
}
