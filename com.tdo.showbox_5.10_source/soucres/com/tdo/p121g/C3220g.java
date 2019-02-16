package com.tdo.showbox.p121g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.models.MovieItem;
import java.util.List;

/* compiled from: MovieDetailsAdapter */
/* renamed from: com.tdo.showbox.g.g */
public class C3220g extends C3204b {
    /* renamed from: a */
    private List<MovieItem> f12382a;
    /* renamed from: b */
    private LayoutInflater f12383b;
    /* renamed from: c */
    private MainActivity f12384c;

    public C3220g(MainActivity mainActivity, List<MovieItem> list) {
        super(mainActivity);
        this.f12382a = list;
        this.f12383b = LayoutInflater.from(mainActivity);
        this.f12384c = mainActivity;
    }

    /* renamed from: a */
    public void m17113a(List<MovieItem> list) {
        this.f12382a = list;
        notifyDataSetChanged();
    }

    public Object getItem(int i) {
        return this.f12382a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: b */
    public int mo2161b() {
        if (this.f12382a == null || this.f12382a.size() <= 0) {
            return 0;
        }
        return this.f12382a.size();
    }

    /* renamed from: a */
    protected View mo2160a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f12383b.inflate(R.layout.item_see_also, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.txtv_descr);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgv_tv);
        View view2 = (ImageView) view.findViewById(R.id.imgv_tv_stub);
        try {
            MovieItem movieItem = (MovieItem) this.f12382a.get(i);
            if (movieItem != null) {
                textView.setVisibility(0);
                textView.setText(movieItem.getTitle());
                this.f12384c.m15139C().m16634a(imageView, view2, movieItem.getPoster());
            }
        } catch (Exception e) {
        }
        return view;
    }
}
