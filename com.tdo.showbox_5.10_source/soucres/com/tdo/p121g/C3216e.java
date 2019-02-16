package com.tdo.showbox.p121g;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener;

/* compiled from: LibTvAdapter */
/* renamed from: com.tdo.showbox.g.e */
public class C3216e extends C3194c<Void> {
    /* renamed from: b */
    private List<TvItem> f12365b;
    /* renamed from: c */
    private LayoutInflater f12366c;
    /* renamed from: d */
    private MainActivity f12367d;
    /* renamed from: e */
    private int f12368e = 1;
    /* renamed from: f */
    private int f12369f = 2;
    /* renamed from: g */
    private int f12370g = 3;
    /* renamed from: h */
    private int f12371h = 1;
    /* renamed from: i */
    private int f12372i = 2;

    /* compiled from: LibTvAdapter */
    /* renamed from: com.tdo.showbox.g.e$1 */
    class C32141 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3216e f12363a;

        C32141(C3216e c3216e) {
            this.f12363a = c3216e;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            return this.f12363a.f12371h;
        }
    }

    /* compiled from: LibTvAdapter */
    /* renamed from: com.tdo.showbox.g.e$2 */
    class C32152 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3216e f12364a;

        C32152(C3216e c3216e) {
            this.f12364a = c3216e;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            try {
                return this.f12364a.getContext().getResources().getConfiguration().orientation == 2 ? this.f12364a.f12369f : this.f12364a.f12368e;
            } catch (Exception e) {
                return this.f12364a.f12369f;
            }
        }
    }

    public C3216e(MainActivity mainActivity, List<TvItem> list, boolean z) {
        super(mainActivity, 1);
        this.f12365b = list;
        this.f12366c = LayoutInflater.from(mainActivity);
        this.f12367d = mainActivity;
        if (z) {
            m17093d();
        } else {
            m17091b();
        }
    }

    /* renamed from: b */
    private void m17091b() {
        C3191b c3191b = new C3191b();
        c3191b.m17001a(this.f12371h, new C3196f(true, 2));
        c3191b.m17001a(this.f12372i, new C3196f(true, 3));
        c3191b.m17002a(new C32141(this));
        m17014a(c3191b);
    }

    /* renamed from: d */
    private void m17093d() {
        C3191b c3191b = new C3191b();
        try {
            c3191b.m17001a(this.f12368e, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_portret)));
            c3191b.m17001a(this.f12369f, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_land)));
        } catch (Exception e) {
            c3191b.m17001a(this.f12368e, new C3196f(true, 4));
            c3191b.m17001a(this.f12369f, new C3196f(true, 5));
        }
        c3191b.m17002a(new C32152(this));
        m17014a(c3191b);
    }

    /* renamed from: a */
    public View mo2152a(int i, View view, ViewGroup viewGroup, C3188a c3188a) {
        View inflate;
        if (view == null) {
            inflate = this.f12366c.inflate(R.layout.item_tv, viewGroup, false);
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
            TvItem tvItem = (TvItem) this.f12365b.get(i);
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
                    this.f12367d.m15141E().m16634a(imageView, findViewById, tvItem.getPoster() + "?");
                    textView.setVisibility(0);
                } else {
                    this.f12367d.m15140D().m16634a(imageView, findViewById, tvItem.getBanner());
                }
            } else {
                textView2.setVisibility(4);
                view2.setImageResource(R.drawable.ic_poster_stub);
                view2.m17254c();
                imageView.m17254c();
                extReletiveView.m17210c();
                this.f12367d.m15139C().m16634a(imageView, findViewById, tvItem.getPoster());
            }
        } catch (Throwable e) {
            Log.e("show_error", OnNativeInvokeListener.ARG_ERROR, e);
        }
        return inflate;
    }

    /* renamed from: a */
    public int mo2150a() {
        if (this.f12365b == null || this.f12365b.size() <= 0) {
            return 0;
        }
        return this.f12365b.size();
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
