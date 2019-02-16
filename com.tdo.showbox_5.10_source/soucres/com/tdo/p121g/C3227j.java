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

/* compiled from: SortDropDownAdapter */
/* renamed from: com.tdo.showbox.g.j */
public class C3227j extends ArrayAdapter<Void> {
    /* renamed from: a */
    private List<String> f12406a;
    /* renamed from: b */
    private LayoutInflater f12407b;
    /* renamed from: c */
    private int f12408c = -1;
    /* renamed from: d */
    private C2790a f12409d;

    /* compiled from: SortDropDownAdapter */
    /* renamed from: com.tdo.showbox.g.j$a */
    public interface C2790a {
        /* renamed from: a */
        void mo2065a(int i);
    }

    public C3227j(MainActivity mainActivity, int i, C2790a c2790a) {
        super(mainActivity, 0);
        this.f12407b = LayoutInflater.from(mainActivity);
        this.f12409d = c2790a;
        this.f12406a = Arrays.asList(mainActivity.getResources().getStringArray(R.array.sort_entries));
        if (this.f12408c >= 2) {
            this.f12408c = 2;
        }
        this.f12408c = i;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup);
    }

    public View getView(int i, View view, final ViewGroup viewGroup) {
        if (view == null) {
            view = this.f12407b.inflate(R.layout.item_sort_full, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.sort_view);
        textView.setText((CharSequence) this.f12406a.get(i));
        View findViewById = view.findViewById(R.id.img_selected);
        if (i == this.f12408c) {
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
                    final /* synthetic */ C3227j f12403b;

                    public void onClick(View view) {
                        View rootView = viewGroup.getRootView();
                        rootView.dispatchKeyEvent(new KeyEvent(0, 4));
                        rootView.dispatchKeyEvent(new KeyEvent(1, 4));
                        if (this.f12403b.f12409d != null) {
                            this.f12403b.f12409d.mo2065a(1);
                        }
                        this.f12403b.f12408c = 1;
                    }
                });
                break;
            case 2:
                view.setOnClickListener(new OnClickListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ C3227j f12405b;

                    public void onClick(View view) {
                        View rootView = viewGroup.getRootView();
                        rootView.dispatchKeyEvent(new KeyEvent(0, 4));
                        rootView.dispatchKeyEvent(new KeyEvent(1, 4));
                        if (this.f12405b.f12409d != null) {
                            this.f12405b.f12409d.mo2065a(2);
                        }
                        this.f12405b.f12408c = 2;
                    }
                });
                break;
        }
        return view;
    }

    public int getCount() {
        return this.f12406a.size();
    }
}
