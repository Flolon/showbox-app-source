package com.tdo.showbox.p121g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.p121g.p133a.C3188a;
import com.tdo.showbox.p121g.p133a.C3189e;
import com.tdo.showbox.p121g.p133a.C3191b;
import com.tdo.showbox.p121g.p133a.C3194c;
import com.tdo.showbox.p121g.p133a.C3196f;
import java.util.List;

/* compiled from: MovieAdapter */
/* renamed from: com.tdo.showbox.g.f */
public class C3219f extends C3194c<Void> {
    /* renamed from: b */
    private List<MovieItem> f12375b;
    /* renamed from: c */
    private LayoutInflater f12376c;
    /* renamed from: d */
    private MainActivity f12377d;
    /* renamed from: e */
    private int f12378e = 1;
    /* renamed from: f */
    private int f12379f = 2;
    /* renamed from: g */
    private int f12380g = 1;
    /* renamed from: h */
    private int f12381h = 2;

    /* compiled from: MovieAdapter */
    /* renamed from: com.tdo.showbox.g.f$1 */
    class C32171 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3219f f12373a;

        C32171(C3219f c3219f) {
            this.f12373a = c3219f;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            if (i < 4) {
                return this.f12373a.f12380g;
            }
            return this.f12373a.f12381h;
        }
    }

    /* compiled from: MovieAdapter */
    /* renamed from: com.tdo.showbox.g.f$2 */
    class C32182 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3219f f12374a;

        C32182(C3219f c3219f) {
            this.f12374a = c3219f;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            try {
                return this.f12374a.getContext().getResources().getConfiguration().orientation == 2 ? this.f12374a.f12379f : this.f12374a.f12378e;
            } catch (Exception e) {
                return this.f12374a.f12379f;
            }
        }
    }

    public C3219f(MainActivity mainActivity, boolean z, List<MovieItem> list) {
        super(mainActivity, 1);
        this.f12375b = list;
        this.f12376c = LayoutInflater.from(mainActivity);
        this.f12377d = mainActivity;
        if (z) {
            m17105d();
        } else {
            m17102b();
        }
    }

    /* renamed from: b */
    private void m17102b() {
        C3191b c3191b = new C3191b();
        c3191b.m17001a(this.f12380g, new C3196f(true, 2));
        c3191b.m17001a(this.f12381h, new C3196f(true, 2));
        c3191b.m17002a(new C32171(this));
        m17014a(c3191b);
    }

    /* renamed from: d */
    private void m17105d() {
        C3191b c3191b = new C3191b();
        try {
            c3191b.m17001a(this.f12378e, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_portret)));
            c3191b.m17001a(this.f12379f, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_land)));
        } catch (Exception e) {
            c3191b.m17001a(this.f12378e, new C3196f(true, 4));
            c3191b.m17001a(this.f12379f, new C3196f(true, 5));
        }
        c3191b.m17002a(new C32182(this));
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
        if (view == null) {
            view = this.f12376c.inflate(R.layout.item_tv, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.txtv_descr);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgv_tv);
        View view2 = (ImageView) view.findViewById(R.id.imgv_tv_stub);
        try {
            MovieItem movieItem = (MovieItem) this.f12375b.get(i);
            textView.setText(movieItem.getTitle());
            if (((C3196f) c3188a).mo2149b()) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
            this.f12377d.m15139C().m16634a(imageView, view2, movieItem.getPoster());
        } catch (Exception e) {
        }
        return view;
    }

    /* renamed from: a */
    public void m17110a(List<MovieItem> list) {
        this.f12375b = list;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public int mo2150a() {
        if (this.f12375b == null || this.f12375b.size() <= 0) {
            return 0;
        }
        return this.f12375b.size();
    }

    /* renamed from: a */
    public MovieItem m17109a(int i) {
        return (MovieItem) this.f12375b.get(i);
    }

    public boolean isEmpty() {
        if (this.f12375b == null || this.f12375b.size() == 0) {
            return true;
        }
        return false;
    }
}
