package com.tdo.showbox.p121g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.p121g.p133a.C3188a;
import com.tdo.showbox.p121g.p133a.C3189e;
import com.tdo.showbox.p121g.p133a.C3191b;
import com.tdo.showbox.p121g.p133a.C3194c;
import com.tdo.showbox.p121g.p133a.C3196f;
import com.tdo.showbox.views.ExtReletiveView;
import com.tdo.showbox.views.MyImageView;
import java.util.List;

/* compiled from: ShowsAdapter */
/* renamed from: com.tdo.showbox.g.i */
public class C3224i extends C3194c<Void> {
    /* renamed from: b */
    private List<TvItem> f12393b;
    /* renamed from: c */
    private LayoutInflater f12394c;
    /* renamed from: d */
    private MainActivity f12395d;
    /* renamed from: e */
    private String f12396e = "";
    /* renamed from: f */
    private int f12397f = 1;
    /* renamed from: g */
    private int f12398g = 2;
    /* renamed from: h */
    private int f12399h = 3;
    /* renamed from: i */
    private int f12400i = 1;
    /* renamed from: j */
    private int f12401j = 2;

    /* compiled from: ShowsAdapter */
    /* renamed from: com.tdo.showbox.g.i$1 */
    class C32221 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3224i f12391a;

        C32221(C3224i c3224i) {
            this.f12391a = c3224i;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            if (i < 4) {
                return this.f12391a.f12400i;
            }
            return this.f12391a.f12401j;
        }
    }

    /* compiled from: ShowsAdapter */
    /* renamed from: com.tdo.showbox.g.i$2 */
    class C32232 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3224i f12392a;

        C32232(C3224i c3224i) {
            this.f12392a = c3224i;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            try {
                return this.f12392a.getContext().getResources().getConfiguration().orientation == 2 ? this.f12392a.f12398g : this.f12392a.f12397f;
            } catch (Exception e) {
                return this.f12392a.f12398g;
            }
        }
    }

    public C3224i(MainActivity mainActivity, boolean z, List<TvItem> list) {
        super(mainActivity, 1);
        this.f12393b = list;
        this.f12394c = LayoutInflater.from(mainActivity);
        this.f12395d = mainActivity;
        if (z) {
            m17126d();
        } else {
            m17123b();
        }
    }

    /* renamed from: a */
    protected void mo2162a(LinearLayout linearLayout, C3188a c3188a) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.grid_item_padding);
        if (c3188a.m16993a() != 1) {
            linearLayout.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        } else {
            linearLayout.setPadding(0, 0, 0, 0);
        }
    }

    /* renamed from: b */
    private void m17123b() {
        C3191b c3191b = new C3191b();
        c3191b.m17001a(this.f12400i, new C3196f(true, 2));
        c3191b.m17001a(this.f12401j, new C3196f(true, 2));
        c3191b.m17002a(new C32221(this));
        m17014a(c3191b);
    }

    /* renamed from: a */
    public int mo2151a(C3188a c3188a) {
        int i = 0;
        if (c3188a.m16993a() != 1) {
            try {
                i = getContext().getResources().getDimensionPixelSize(R.dimen.grid_item_padding);
            } catch (Exception e) {
            }
        }
        return i;
    }

    /* renamed from: b */
    public int mo2153b(C3188a c3188a) {
        try {
            return getContext().getResources().getDimensionPixelSize(R.dimen.grid_item_padding);
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: d */
    private void m17126d() {
        C3191b c3191b = new C3191b();
        try {
            c3191b.m17001a(this.f12397f, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_portret)));
            c3191b.m17001a(this.f12398g, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_land)));
        } catch (Exception e) {
            c3191b.m17001a(this.f12397f, new C3196f(true, 4));
            c3191b.m17001a(this.f12398g, new C3196f(true, 5));
        }
        c3191b.m17002a(new C32232(this));
        m17014a(c3191b);
    }

    /* renamed from: a */
    public View mo2152a(int i, View view, ViewGroup viewGroup, C3188a c3188a) {
        View inflate;
        if (view == null) {
            inflate = this.f12394c.inflate(R.layout.item_tv, viewGroup, false);
        } else {
            inflate = view;
        }
        ExtReletiveView extReletiveView = (ExtReletiveView) inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.txtv_descr);
        TextView textView2 = (TextView) inflate.findViewById(R.id.txtv_descr_hiden);
        ImageView imageView = (MyImageView) inflate.findViewById(R.id.imgv_tv);
        View view2 = (MyImageView) inflate.findViewById(R.id.imgv_tv_stub);
        View findViewById = c3188a.m16993a() == 1 ? inflate.findViewById(R.id.stub_container) : view2;
        try {
            TvItem tvItem = (TvItem) this.f12393b.get(i);
            textView.setText(tvItem.getTitle());
            textView2.setText(tvItem.getTitle());
            if (((C3196f) c3188a).mo2149b()) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(4);
            }
            if (c3188a.m16993a() == 1) {
                textView2.setVisibility(0);
                view2.setImageResource(R.drawable.ic_shows_banner_stub_long);
                view2.m17252a();
                imageView.m17252a();
                extReletiveView.m17209b();
                if (tvItem.getBanner() == null || tvItem.getBanner().length() == 0) {
                    this.f12395d.m15141E().m16634a(imageView, findViewById, tvItem.getPoster() + "?");
                    textView.setVisibility(0);
                } else {
                    this.f12395d.m15140D().m16634a(imageView, findViewById, tvItem.getBanner());
                }
            } else {
                textView2.setVisibility(4);
                view2.setImageResource(R.drawable.ic_poster_stub);
                view2.m17254c();
                imageView.m17254c();
                extReletiveView.m17210c();
                this.f12395d.m15139C().m16634a(imageView, findViewById, tvItem.getPoster());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inflate;
    }

    /* renamed from: a */
    public void m17132a(List<TvItem> list) {
        this.f12393b = list;
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public int mo2150a() {
        if (this.f12393b == null || this.f12393b.size() <= 0) {
            return 0;
        }
        return this.f12393b.size();
    }

    /* renamed from: a */
    public TvItem m17130a(int i) {
        return (TvItem) this.f12393b.get(i);
    }
}
