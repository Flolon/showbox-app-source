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
import java.util.Arrays;
import java.util.List;

/* compiled from: SortMovieDropDownAdapter */
/* renamed from: com.tdo.showbox.g.k */
public class C3231k extends ArrayAdapter<Void> {
    /* renamed from: a */
    private List<String> f12416a;
    /* renamed from: b */
    private LayoutInflater f12417b;
    /* renamed from: c */
    private int f12418c = -1;
    /* renamed from: d */
    private C2784a f12419d;

    /* compiled from: SortMovieDropDownAdapter */
    /* renamed from: com.tdo.showbox.g.k$a */
    public interface C2784a {
        /* renamed from: a */
        void mo2059a(int i);
    }

    public C3231k(MainActivity mainActivity, int i, C2784a c2784a) {
        super(mainActivity, 0);
        this.f12417b = LayoutInflater.from(mainActivity);
        this.f12416a = Arrays.asList(mainActivity.getResources().getStringArray(R.array.sort_entries_movie));
        this.f12418c = i;
        this.f12419d = c2784a;
        if (this.f12418c >= 3) {
            this.f12418c = 3;
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup);
    }

    public View getView(int i, View view, final ViewGroup viewGroup) {
        if (view == null) {
            view = this.f12417b.inflate(R.layout.item_sort_full, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.sort_view);
        textView.setText((CharSequence) this.f12416a.get(i));
        View findViewById = view.findViewById(R.id.img_selected);
        if (i == this.f12418c) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        if (i == 0) {
            textView.setBackgroundColor(-16777216);
            findViewById.setVisibility(8);
        } else {
            textView.setBackgroundColor(0);
        }
        switch (i) {
            case 0:
                view.setOnClickListener(null);
                break;
            case 1:
                view.setOnClickListener(new OnClickListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ C3231k f12411b;

                    public void onClick(View view) {
                        View rootView = viewGroup.getRootView();
                        rootView.dispatchKeyEvent(new KeyEvent(0, 4));
                        rootView.dispatchKeyEvent(new KeyEvent(1, 4));
                        if (this.f12411b.f12419d != null) {
                            this.f12411b.f12419d.mo2059a(1);
                        }
                        this.f12411b.f12418c = 1;
                    }
                });
                break;
            case 2:
                view.setOnClickListener(new OnClickListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ C3231k f12413b;

                    public void onClick(View view) {
                        View rootView = viewGroup.getRootView();
                        rootView.dispatchKeyEvent(new KeyEvent(0, 4));
                        rootView.dispatchKeyEvent(new KeyEvent(1, 4));
                        if (this.f12413b.f12419d != null) {
                            this.f12413b.f12419d.mo2059a(2);
                        }
                        this.f12413b.f12418c = 2;
                    }
                });
                break;
            case 3:
                view.setOnClickListener(new OnClickListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ C3231k f12415b;

                    public void onClick(View view) {
                        View rootView = viewGroup.getRootView();
                        rootView.dispatchKeyEvent(new KeyEvent(0, 4));
                        rootView.dispatchKeyEvent(new KeyEvent(1, 4));
                        if (this.f12415b.f12419d != null) {
                            this.f12415b.f12419d.mo2059a(3);
                        }
                        this.f12415b.f12418c = 3;
                    }
                });
                break;
        }
        return view;
    }

    public int getCount() {
        if (this.f12416a == null) {
            return 0;
        }
        return this.f12416a.size();
    }
}
