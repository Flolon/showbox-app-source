package com.tdo.showbox.p121g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.models.Subtitle;
import java.util.List;

/* compiled from: SubtitlesListAdapter */
/* renamed from: com.tdo.showbox.g.n */
public class C3236n extends ArrayAdapter<Void> {
    /* renamed from: a */
    private List<Subtitle> f12438a;
    /* renamed from: b */
    private LayoutInflater f12439b;
    /* renamed from: c */
    private MainActivity f12440c;
    /* renamed from: d */
    private String f12441d;
    /* renamed from: e */
    private String f12442e;
    /* renamed from: f */
    private int f12443f = -1;
    /* renamed from: g */
    private int f12444g = -7829368;
    /* renamed from: h */
    private int f12445h = -16711936;
    /* renamed from: i */
    private Subtitle f12446i;

    public C3236n(MainActivity mainActivity, List<Subtitle> list, Subtitle subtitle) {
        super(mainActivity, 0);
        this.f12438a = list;
        this.f12439b = LayoutInflater.from(mainActivity);
        this.f12440c = mainActivity;
        this.f12441d = this.f12440c.getString(R.string.sub_year) + " ";
        this.f12442e = this.f12440c.getString(R.string.sub_downloads) + " ";
        this.f12446i = subtitle;
        this.f12445h = this.f12440c.getResources().getColor(R.color.green_l);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f12439b.inflate(R.layout.item_subtitle, viewGroup, false);
        }
        try {
            TextView textView = (TextView) view.findViewById(R.id.txtv_name);
            TextView textView2 = (TextView) view.findViewById(R.id.txtv_downloads);
            Subtitle subtitle = (Subtitle) this.f12438a.get(i);
            textView.setText(subtitle.getMovieReleaseName().trim());
            textView2.setText(this.f12442e + subtitle.getSubDownloadsCnt());
            textView.setTextColor(this.f12443f);
            textView2.setTextColor(this.f12444g);
            if (this.f12446i != null && this.f12446i.getZipDownloadLink().equals(subtitle.getZipDownloadLink())) {
                textView.setTextColor(this.f12445h);
                textView2.setTextColor(this.f12445h);
            }
        } catch (Exception e) {
        }
        return view;
    }

    public int getCount() {
        return this.f12438a.size();
    }
}
