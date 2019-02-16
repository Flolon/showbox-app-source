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

/* compiled from: LibMovieAdapter */
/* renamed from: com.tdo.showbox.g.d */
public class C3213d extends C3194c<Void> {
    /* renamed from: b */
    private List<MovieItem> f12356b;
    /* renamed from: c */
    private LayoutInflater f12357c;
    /* renamed from: d */
    private MainActivity f12358d;
    /* renamed from: e */
    private int f12359e = 1;
    /* renamed from: f */
    private int f12360f = 2;
    /* renamed from: g */
    private int f12361g = 1;
    /* renamed from: h */
    private int f12362h = 2;

    /* compiled from: LibMovieAdapter */
    /* renamed from: com.tdo.showbox.g.d$1 */
    class C32111 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3213d f12354a;

        C32111(C3213d c3213d) {
            this.f12354a = c3213d;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            return this.f12354a.f12361g;
        }
    }

    /* compiled from: LibMovieAdapter */
    /* renamed from: com.tdo.showbox.g.d$2 */
    class C32122 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3213d f12355a;

        C32122(C3213d c3213d) {
            this.f12355a = c3213d;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            try {
                return this.f12355a.getContext().getResources().getConfiguration().orientation == 2 ? this.f12355a.f12360f : this.f12355a.f12359e;
            } catch (Exception e) {
                return this.f12355a.f12360f;
            }
        }
    }

    public C3213d(MainActivity mainActivity, List<MovieItem> list, boolean z) {
        super(mainActivity, 1);
        this.f12356b = list;
        this.f12357c = LayoutInflater.from(mainActivity);
        this.f12358d = mainActivity;
        if (z) {
            m17082d();
        } else {
            m17080b();
        }
    }

    /* renamed from: b */
    private void m17080b() {
        C3191b c3191b = new C3191b();
        c3191b.m17001a(this.f12361g, new C3196f(true, 2));
        c3191b.m17001a(this.f12362h, new C3196f(true, 3));
        c3191b.m17002a(new C32111(this));
        m17014a(c3191b);
    }

    /* renamed from: d */
    private void m17082d() {
        C3191b c3191b = new C3191b();
        try {
            c3191b.m17001a(this.f12359e, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_portret)));
            c3191b.m17001a(this.f12360f, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_land)));
        } catch (Exception e) {
            c3191b.m17001a(this.f12359e, new C3196f(true, 4));
            c3191b.m17001a(this.f12360f, new C3196f(true, 5));
        }
        c3191b.m17002a(new C32122(this));
        m17014a(c3191b);
    }

    /* renamed from: a */
    public View mo2152a(int i, View view, ViewGroup viewGroup, C3188a c3188a) {
        if (view == null) {
            view = this.f12357c.inflate(R.layout.item_tv, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.txtv_descr);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgv_tv);
        View view2 = (ImageView) view.findViewById(R.id.imgv_tv_stub);
        try {
            MovieItem movieItem = (MovieItem) this.f12356b.get(i);
            textView.setText(movieItem.getTitle());
            if (((C3196f) c3188a).mo2149b()) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
            this.f12358d.m15139C().m16634a(imageView, view2, movieItem.getPoster());
        } catch (Exception e) {
        }
        return view;
    }

    /* renamed from: a */
    public int mo2150a() {
        if (this.f12356b == null || this.f12356b.size() <= 0) {
            return 0;
        }
        return this.f12356b.size();
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
}
