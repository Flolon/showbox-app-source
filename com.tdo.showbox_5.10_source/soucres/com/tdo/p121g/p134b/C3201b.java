package com.tdo.showbox.p121g.p134b;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.data.p112c.C3074a;
import com.tdo.showbox.models.News;
import com.tdo.showbox.p121g.p133a.C3188a;
import com.tdo.showbox.p121g.p133a.C3189e;
import com.tdo.showbox.p121g.p133a.C3191b;
import com.tdo.showbox.p121g.p133a.C3194c;
import com.tdo.showbox.p121g.p133a.C3196f;
import com.tdo.showbox.p131f.C3173b;
import com.tdo.showbox.views.ExtReletiveView;
import com.tdo.showbox.views.MyImageView;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener;

/* compiled from: NoveltyAdapter */
/* renamed from: com.tdo.showbox.g.b.b */
public class C3201b extends C3194c<Void> {
    /* renamed from: b */
    private List<News> f12305b;
    /* renamed from: c */
    private LayoutInflater f12306c;
    /* renamed from: d */
    private MainActivity f12307d;
    /* renamed from: e */
    private int f12308e = 1;
    /* renamed from: f */
    private int f12309f = 2;
    /* renamed from: g */
    private int f12310g = 3;
    /* renamed from: h */
    private int f12311h = 1;
    /* renamed from: i */
    private int f12312i = 2;
    /* renamed from: j */
    private C3074a f12313j;

    /* compiled from: NoveltyAdapter */
    /* renamed from: com.tdo.showbox.g.b.b$1 */
    class C31991 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3201b f12303a;

        C31991(C3201b c3201b) {
            this.f12303a = c3201b;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            return this.f12303a.f12310g;
        }
    }

    /* compiled from: NoveltyAdapter */
    /* renamed from: com.tdo.showbox.g.b.b$2 */
    class C32002 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3201b f12304a;

        C32002(C3201b c3201b) {
            this.f12304a = c3201b;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            try {
                return this.f12304a.getContext().getResources().getConfiguration().orientation == 2 ? this.f12304a.f12309f : this.f12304a.f12308e;
            } catch (Exception e) {
                return this.f12304a.f12309f;
            }
        }
    }

    public C3201b(MainActivity mainActivity, C3074a c3074a, List<News> list, boolean z) {
        super(mainActivity, 1);
        this.f12305b = list;
        this.f12306c = LayoutInflater.from(mainActivity);
        this.f12307d = mainActivity;
        this.f12313j = c3074a;
        if (z) {
            m17030d();
        } else {
            m17028b();
        }
    }

    /* renamed from: b */
    private void m17028b() {
        C3191b c3191b = new C3191b();
        c3191b.m17001a(this.f12310g, new C3196f(false, 1));
        c3191b.m17001a(this.f12311h, new C3196f(true, 2));
        c3191b.m17001a(this.f12312i, new C3196f(true, 3));
        c3191b.m17002a(new C31991(this));
        m17014a(c3191b);
    }

    /* renamed from: d */
    private void m17030d() {
        C3191b c3191b = new C3191b();
        try {
            c3191b.m17001a(this.f12308e, new C3196f(true, 2));
            c3191b.m17001a(this.f12309f, new C3196f(true, 2));
        } catch (Exception e) {
            c3191b.m17001a(this.f12308e, new C3196f(true, 2));
            c3191b.m17001a(this.f12309f, new C3196f(true, 2));
        }
        c3191b.m17002a(new C32002(this));
        m17014a(c3191b);
    }

    /* renamed from: a */
    public View mo2152a(int i, View view, ViewGroup viewGroup, C3188a c3188a) {
        View inflate;
        if (view == null) {
            inflate = this.f12306c.inflate(R.layout.item_news, viewGroup, false);
        } else {
            inflate = view;
        }
        ExtReletiveView extReletiveView = (ExtReletiveView) inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.txtv_descr);
        TextView textView2 = (TextView) inflate.findViewById(R.id.txtv_date);
        ImageView imageView = (MyImageView) inflate.findViewById(R.id.imgv_tv);
        View view2 = (MyImageView) inflate.findViewById(R.id.imgv_tv_stub);
        View findViewById = c3188a.m16993a() == 1 ? inflate.findViewById(R.id.stub_container) : view2;
        try {
            News news = (News) this.f12305b.get(i);
            textView.setText(news.getHead());
            textView.setVisibility(0);
            textView2.setText(C3173b.m16957a(news.getDate()));
            if (c3188a.m16993a() == 1) {
                view2.setImageResource(R.drawable.ic_shows_banner_stub_long);
                view2.m17252a();
                imageView.m17252a();
                extReletiveView.m17209b();
                if (this.f12313j != null) {
                    this.f12313j.m16634a(imageView, findViewById, news.getPic());
                }
            } else {
                view2.setImageResource(R.drawable.ic_shows_banner_stub_long);
                view2.m17252a();
                imageView.m17252a();
                extReletiveView.m17209b();
                if (this.f12313j != null) {
                    this.f12313j.m16634a(imageView, findViewById, news.getPic());
                }
            }
        } catch (Throwable e) {
            Log.e("show_error", OnNativeInvokeListener.ARG_ERROR, e);
        }
        return inflate;
    }

    /* renamed from: a */
    public int mo2150a() {
        if (this.f12305b == null || this.f12305b.size() <= 0) {
            return 0;
        }
        return this.f12305b.size();
    }

    /* renamed from: a */
    public int mo2151a(C3188a c3188a) {
        return 0;
    }

    /* renamed from: b */
    public int mo2153b(C3188a c3188a) {
        return 0;
    }
}
