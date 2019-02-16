package com.tdo.showbox.p121g.p122c;

import android.app.Activity;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0696v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tdo.showbox.R;
import com.tdo.showbox.data.p112c.C3074a;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.Trailer;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.p123c.C2971a;
import com.tdo.showbox.views.hrecyclerviewparalax.C3208a;
import com.tdo.showbox.views.hrecyclerviewparalax.C3340b;
import java.util.List;

/* compiled from: TrendingParalaxAdapter */
/* renamed from: com.tdo.showbox.g.c.b */
public class C3209b<T> extends C3208a<T> {
    /* renamed from: a */
    private Activity f12343a;
    /* renamed from: b */
    private C3074a f12344b;
    /* renamed from: c */
    private C2951a f12345c;
    /* renamed from: d */
    private PointF f12346d;
    /* renamed from: e */
    private LayoutInflater f12347e = LayoutInflater.from(this.f12343a);

    /* compiled from: TrendingParalaxAdapter */
    /* renamed from: com.tdo.showbox.g.c.b$a */
    public interface C2951a {
        /* renamed from: a */
        void mo2081a(int i);
    }

    /* renamed from: a */
    public void m17072a(C2951a c2951a) {
        this.f12345c = c2951a;
    }

    public C3209b(Activity activity, RecyclerView recyclerView, List<T> list, C3340b c3340b, C3074a c3074a) {
        super(recyclerView, list, c3340b);
        this.f12343a = activity;
        this.f12344b = c3074a;
    }

    /* renamed from: a */
    public void m17071a(PointF pointF) {
        this.f12346d = pointF;
    }

    /* renamed from: c */
    public C0696v mo2158c(ViewGroup viewGroup, int i) {
        View inflate = this.f12347e.inflate(R.layout.item_trending_paralax, null);
        if (this.f12346d != null) {
            View findViewById = inflate.findViewById(R.id.imgv_tv_stub);
            LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.width = (int) this.f12346d.x;
            layoutParams.height = (int) this.f12346d.y;
            findViewById.setLayoutParams(layoutParams);
            findViewById = inflate.findViewById(R.id.imgv_tv);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.width = (int) this.f12346d.x;
            layoutParams.height = (int) this.f12346d.y;
            findViewById.setLayoutParams(layoutParams);
            findViewById = inflate.findViewById(R.id.txtv_descr);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.width = (int) this.f12346d.x;
            layoutParams.height = -2;
            findViewById.setLayoutParams(layoutParams);
        }
        return new C2971a(inflate);
    }

    /* renamed from: c */
    public void mo2159c(C0696v c0696v, final int i) {
        String poster;
        CharSequence charSequence = null;
        Object obj = m17066c().get(i);
        C2971a c2971a = (C2971a) c0696v;
        if (obj instanceof Trailer) {
            poster = ((Trailer) obj).getPoster();
            charSequence = ((Trailer) obj).getTitle();
        } else {
            poster = null;
        }
        if (obj instanceof MovieItem) {
            poster = ((MovieItem) obj).getPoster();
            charSequence = ((MovieItem) obj).getTitle();
        }
        if (obj instanceof TvItem) {
            poster = ((TvItem) obj).getPoster();
            charSequence = ((TvItem) obj).getTitle();
        }
        this.f12344b.m16634a(c2971a.f11793l, c2971a.f11795n, poster);
        c2971a.f11793l.m17585a();
        c2971a.f11794m.setText(charSequence);
        c2971a.a.setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ C3209b f12333b;

            public void onClick(View view) {
                if (this.f12333b.f12345c != null) {
                    this.f12333b.f12345c.mo2081a(i);
                }
            }
        });
    }
}
