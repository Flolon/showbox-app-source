package com.tdo.showbox.p121g;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.models.TrailerDetails;
import com.tdo.showbox.models.TrailerDetailsItem;
import com.tdo.showbox.p121g.p133a.C3188a;
import com.tdo.showbox.p121g.p133a.C3189e;
import com.tdo.showbox.p121g.p133a.C3191b;
import com.tdo.showbox.p121g.p133a.C3194c;
import com.tdo.showbox.p121g.p133a.C3196f;
import com.tdo.showbox.p131f.C3173b;
import com.tdo.showbox.p131f.C3184j;
import com.tdo.showbox.views.ExtReletiveView;
import com.tdo.showbox.views.MyImageView;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener;

/* compiled from: TrailerDetailsAdapter */
/* renamed from: com.tdo.showbox.g.o */
public class C3239o extends C3194c<Void> {
    /* renamed from: b */
    private TrailerDetails f12449b;
    /* renamed from: c */
    private LayoutInflater f12450c;
    /* renamed from: d */
    private MainActivity f12451d;
    /* renamed from: e */
    private List<TrailerDetailsItem> f12452e;
    /* renamed from: f */
    private int f12453f = 1;
    /* renamed from: g */
    private int f12454g = 2;
    /* renamed from: h */
    private int f12455h = 3;
    /* renamed from: i */
    private int f12456i = 1;
    /* renamed from: j */
    private int f12457j = 2;
    /* renamed from: k */
    private boolean f12458k;
    /* renamed from: l */
    private int f12459l;

    /* compiled from: TrailerDetailsAdapter */
    /* renamed from: com.tdo.showbox.g.o$1 */
    class C32371 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3239o f12447a;

        C32371(C3239o c3239o) {
            this.f12447a = c3239o;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            return this.f12447a.f12455h;
        }
    }

    /* compiled from: TrailerDetailsAdapter */
    /* renamed from: com.tdo.showbox.g.o$2 */
    class C32382 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3239o f12448a;

        C32382(C3239o c3239o) {
            this.f12448a = c3239o;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            try {
                return this.f12448a.getContext().getResources().getConfiguration().orientation == 2 ? this.f12448a.f12454g : this.f12448a.f12453f;
            } catch (Exception e) {
                return this.f12448a.f12454g;
            }
        }
    }

    public C3239o(MainActivity mainActivity, TrailerDetails trailerDetails, boolean z, int i) {
        super(mainActivity, 1);
        this.f12449b = trailerDetails;
        this.f12452e = this.f12449b.getTrailerDetailItems();
        this.f12450c = LayoutInflater.from(mainActivity);
        this.f12451d = mainActivity;
        this.f12458k = z;
        this.f12459l = i;
        if (z) {
            m17152d();
        } else {
            m17150b();
        }
    }

    /* renamed from: b */
    private void m17150b() {
        C3191b c3191b = new C3191b();
        c3191b.m17001a(this.f12455h, new C3196f(false, 1));
        c3191b.m17001a(this.f12456i, new C3196f(true, 2));
        c3191b.m17001a(this.f12457j, new C3196f(true, 3));
        c3191b.m17002a(new C32371(this));
        m17014a(c3191b);
    }

    /* renamed from: d */
    private void m17152d() {
        C3191b c3191b = new C3191b();
        try {
            c3191b.m17001a(this.f12453f, new C3196f(true, 1));
            c3191b.m17001a(this.f12454g, new C3196f(true, 2));
        } catch (Exception e) {
            c3191b.m17001a(this.f12453f, new C3196f(true, 1));
            c3191b.m17001a(this.f12454g, new C3196f(true, 2));
        }
        c3191b.m17002a(new C32382(this));
        m17014a(c3191b);
    }

    /* renamed from: a */
    public View mo2152a(int i, View view, ViewGroup viewGroup, C3188a c3188a) {
        View inflate;
        if (view == null) {
            inflate = this.f12450c.inflate(R.layout.item_trailer_detail, viewGroup, false);
        } else {
            inflate = view;
        }
        ExtReletiveView extReletiveView = (ExtReletiveView) inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.txtv_date);
        ImageView imageView = (MyImageView) inflate.findViewById(R.id.imgv_tv);
        View view2 = (MyImageView) inflate.findViewById(R.id.imgv_tv_stub);
        View findViewById = c3188a.m16993a() == 1 ? inflate.findViewById(R.id.stub_container) : view2;
        try {
            TrailerDetailsItem trailerDetailsItem = (TrailerDetailsItem) this.f12452e.get(i);
            textView.setText(C3173b.m16958b(trailerDetailsItem.getDate()));
            view2.setImageResource(R.drawable.ic_shows_banner_stub_long);
            view2.m17253b();
            imageView.m17253b();
            extReletiveView.m17208a();
            if (c3188a.m16993a() == 1) {
                this.f12451d.m15140D().m16634a(imageView, findViewById, trailerDetailsItem.getYoutubeLink());
            } else {
                this.f12451d.m15139C().m16634a(imageView, findViewById, trailerDetailsItem.getYoutubeLink());
            }
        } catch (Throwable e) {
            Log.e("show_error", OnNativeInvokeListener.ARG_ERROR, e);
        }
        return inflate;
    }

    /* renamed from: a */
    public int mo2150a() {
        if (this.f12452e == null || this.f12452e.size() <= 0) {
            return 0;
        }
        return this.f12452e.size();
    }

    /* renamed from: a */
    public int mo2151a(C3188a c3188a) {
        try {
            if (this.f12458k) {
                return C3184j.m16980a(this.f12451d, 10);
            }
            return 0;
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
