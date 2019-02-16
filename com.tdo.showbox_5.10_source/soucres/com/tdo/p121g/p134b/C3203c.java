package com.tdo.showbox.p121g.p134b;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.data.p112c.C3074a;
import com.tdo.showbox.models.News;
import com.tdo.showbox.p131f.C3173b;
import com.tdo.showbox.views.ExtReletiveView;
import com.tdo.showbox.views.MyImageView;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener;

/* compiled from: NoveltyAdsPhoneAdapter */
/* renamed from: com.tdo.showbox.g.b.c */
public class C3203c extends C3193a<Void> {
    /* renamed from: b */
    private List<News> f12316b;
    /* renamed from: c */
    private LayoutInflater f12317c;
    /* renamed from: d */
    private C3074a f12318d;

    public C3203c(MainActivity mainActivity, C3074a c3074a, List<News> list) {
        super(mainActivity, 0);
        this.f12316b = list;
        this.f12317c = LayoutInflater.from(mainActivity);
        this.f12318d = c3074a;
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.f12317c.inflate(R.layout.item_news, viewGroup, false);
        } else {
            inflate = view;
        }
        ExtReletiveView extReletiveView = (ExtReletiveView) inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.txtv_descr);
        TextView textView2 = (TextView) inflate.findViewById(R.id.txtv_date);
        ImageView imageView = (MyImageView) inflate.findViewById(R.id.imgv_tv);
        MyImageView myImageView = (MyImageView) inflate.findViewById(R.id.imgv_tv_stub);
        View findViewById = inflate.findViewById(R.id.stub_container);
        try {
            News news = (News) this.f12316b.get(i);
            textView.setText(news.getHead());
            textView.setVisibility(0);
            textView2.setText(C3173b.m16957a(news.getDate()));
            myImageView.setImageResource(R.drawable.ic_shows_banner_stub_long);
            myImageView.m17252a();
            imageView.m17252a();
            extReletiveView.m17209b();
            if (this.f12318d != null) {
                this.f12318d.m16634a(imageView, findViewById, news.getPic());
            }
        } catch (Throwable e) {
            Log.e("show_error", OnNativeInvokeListener.ARG_ERROR, e);
        }
        inflate.setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ C3203c f12315b;

            public void onClick(View view) {
                if (this.f12315b.a != null) {
                    this.f12315b.a.onItemClick(null, null, i, (long) i);
                }
            }
        });
        return inflate;
    }

    public int getCount() {
        if (this.f12316b == null || this.f12316b.size() <= 0) {
            return 0;
        }
        return this.f12316b.size();
    }
}
