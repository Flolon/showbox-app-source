package com.tdo.showbox.p121g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.data.C3077d;
import com.tdo.showbox.models.Episod;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SeasonsAdapter */
/* renamed from: com.tdo.showbox.g.h */
public class C3221h extends C3204b {
    /* renamed from: a */
    private List<Episod> f12385a;
    /* renamed from: b */
    private LayoutInflater f12386b;
    /* renamed from: c */
    private MainActivity f12387c;
    /* renamed from: d */
    private List<Long> f12388d;
    /* renamed from: e */
    private int f12389e = this.f12387c.getResources().getColor(R.color.epizode_viewed);
    /* renamed from: f */
    private int f12390f = this.f12387c.getResources().getColor(R.color.l_gray_text_color);

    public C3221h(MainActivity mainActivity, List<Episod> list) {
        super(mainActivity);
        this.f12385a = list;
        this.f12386b = LayoutInflater.from(mainActivity);
        this.f12387c = mainActivity;
        m17118c();
    }

    /* renamed from: a */
    public void m17116a(List<Episod> list) {
        if (this.f12385a == null) {
            this.f12385a = new ArrayList();
        }
        this.f12385a.clear();
        this.f12385a.addAll(list);
        m17118c();
        notifyDataSetChanged();
    }

    public Object getItem(int i) {
        return this.f12385a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: b */
    public int mo2161b() {
        if (this.f12385a == null || this.f12385a.size() <= 0) {
            return 0;
        }
        return this.f12385a.size();
    }

    /* renamed from: c */
    public void m17118c() {
        if (this.f12385a != null && this.f12385a.size() > 0) {
            Episod episod = (Episod) this.f12385a.get(0);
            this.f12388d = C3077d.m16649a(episod.getMovId(), episod.getSeasonNum());
        }
        notifyDataSetChanged();
    }

    /* renamed from: a */
    protected View mo2160a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f12386b.inflate(R.layout.item_episod, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.imgv_tv);
        TextView textView = (TextView) view.findViewById(R.id.txtv_num);
        try {
            Episod episod = (Episod) this.f12385a.get(i);
            if (textView != null) {
                textView.setText("" + episod.getEpisode_id());
            }
            if (this.f12388d.contains(Long.valueOf(episod.getEpisode_id()))) {
                textView.setBackgroundColor(this.f12389e);
                textView.setTextColor(-16777216);
            } else {
                textView.setBackgroundResource(R.drawable.ic_season_num);
                textView.setTextColor(this.f12390f);
            }
            Integer num = (Integer) view.getTag();
            this.f12387c.m15137A().m16635a(imageView, episod.getThumb());
        } catch (Exception e) {
        }
        return view;
    }
}
