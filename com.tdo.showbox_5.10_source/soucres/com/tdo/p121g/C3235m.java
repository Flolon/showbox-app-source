package com.tdo.showbox.p121g;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.p113d.C2780g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SortMoviesYearDropDownAdapter */
/* renamed from: com.tdo.showbox.g.m */
public class C3235m extends ArrayAdapter<Void> {
    /* renamed from: a */
    private List<String> f12433a = new ArrayList();
    /* renamed from: b */
    private LayoutInflater f12434b;
    /* renamed from: c */
    private MainActivity f12435c;
    /* renamed from: d */
    private int f12436d;
    /* renamed from: e */
    private C2780g f12437e;

    public C3235m(MainActivity mainActivity, int i) {
        super(mainActivity, 0);
        this.f12434b = LayoutInflater.from(mainActivity);
        this.f12435c = mainActivity;
        this.f12436d = i;
        this.f12433a.add(this.f12435c.getString(R.string.year_all));
        try {
            int u = this.f12435c.m15174u();
            for (int v = this.f12435c.m15175v(); v >= u; v--) {
                this.f12433a.add("" + v);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m17145a(C2780g c2780g) {
        this.f12437e = c2780g;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup);
    }

    public View getView(final int i, View view, final ViewGroup viewGroup) {
        if (view == null) {
            view = this.f12434b.inflate(R.layout.item_sort_full, null);
        }
        if (this.f12433a != null) {
            final String str = (String) this.f12433a.get(i);
            if (str != null) {
                TextView textView = (TextView) view.findViewById(R.id.sort_view);
                textView.setText(str);
                View findViewById = view.findViewById(R.id.img_selected);
                if (i == this.f12436d) {
                    findViewById.setVisibility(0);
                } else {
                    findViewById.setVisibility(8);
                }
                if (i != 0) {
                    textView.setBackgroundColor(0);
                }
                view.setOnClickListener(new OnClickListener(this) {
                    /* renamed from: d */
                    final /* synthetic */ C3235m f12432d;

                    public void onClick(View view) {
                        this.f12432d.f12436d = i;
                        if (this.f12432d.f12436d == 0) {
                            if (this.f12432d.f12437e != null) {
                                this.f12432d.f12437e.mo2057a("");
                            }
                        } else if (this.f12432d.f12437e != null) {
                            this.f12432d.f12437e.mo2057a(str);
                        }
                        View rootView = viewGroup.getRootView();
                        rootView.dispatchKeyEvent(new KeyEvent(0, 4));
                        rootView.dispatchKeyEvent(new KeyEvent(1, 4));
                    }
                });
            }
        }
        return view;
    }

    public int getCount() {
        if (this.f12433a == null) {
            return 0;
        }
        return this.f12433a.size();
    }
}
