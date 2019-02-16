package com.tdo.showbox.p121g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.models.DownloadEpisode;
import java.util.List;

/* compiled from: DownloadsAdapter */
/* renamed from: com.tdo.showbox.g.a */
public class C3197a extends ArrayAdapter<Void> {
    /* renamed from: a */
    private List<DownloadEpisode> f12295a;
    /* renamed from: b */
    private LayoutInflater f12296b;
    /* renamed from: c */
    private MainActivity f12297c;
    /* renamed from: d */
    private OnClickListener f12298d;
    /* renamed from: e */
    private OnClickListener f12299e;
    /* renamed from: f */
    private int f12300f = 0;

    public C3197a(MainActivity mainActivity, List<DownloadEpisode> list) {
        super(mainActivity, 0);
        this.f12295a = list;
        this.f12296b = LayoutInflater.from(mainActivity);
        this.f12297c = mainActivity;
    }

    /* renamed from: a */
    public void m17021a(OnClickListener onClickListener) {
        this.f12298d = onClickListener;
    }

    /* renamed from: b */
    public void m17023b(OnClickListener onClickListener) {
        this.f12299e = onClickListener;
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f12296b.inflate(R.layout.item_downloads, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.txtv_season);
        TextView textView2 = (TextView) view.findViewById(R.id.txtv_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.imgv_tv);
        ((ProgressBar) view.findViewById(R.id.load_progress)).setVisibility(8);
        view.findViewById(R.id.downloading_container).setVisibility(8);
        view.findViewById(R.id.downloaded_container).setVisibility(0);
        view.findViewById(R.id.txtv_download_info).setVisibility(8);
        view.findViewById(R.id.btn_remove).setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ C3197a f12277b;

            public void onClick(View view) {
                if (this.f12277b.f12298d != null) {
                    view.setTag(Integer.valueOf(i));
                    this.f12277b.f12298d.onClick(view);
                }
            }
        });
        view.findViewById(R.id.btn_watch).setOnClickListener(new OnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ C3197a f12279b;

            public void onClick(View view) {
                if (this.f12279b.f12299e != null) {
                    view.setTag(Integer.valueOf(i));
                    this.f12279b.f12299e.onClick(view);
                }
            }
        });
        try {
            DownloadEpisode downloadEpisode = (DownloadEpisode) this.f12295a.get(i);
            textView2.setText(downloadEpisode.getTitle());
            this.f12297c.m15139C().m16635a(imageView, downloadEpisode.getPoster());
            if (downloadEpisode.getShows_info() != null) {
                textView.setText(downloadEpisode.getShows_info());
            }
        } catch (Exception e) {
        }
        return view;
    }

    /* renamed from: a */
    public void m17022a(List<DownloadEpisode> list) {
        if (list != null) {
            this.f12295a = list;
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        this.f12300f = 0;
        if (this.f12295a != null && this.f12295a.size() > 0) {
            this.f12300f = this.f12295a.size();
        }
        return this.f12300f;
    }
}
