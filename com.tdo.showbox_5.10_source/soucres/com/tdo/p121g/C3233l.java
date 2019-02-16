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
import com.tdo.showbox.models.Category;
import com.tdo.showbox.p113d.C2782f;
import java.util.List;

/* compiled from: SortMoviesGenreDropDownAdapter */
/* renamed from: com.tdo.showbox.g.l */
public class C3233l extends ArrayAdapter<Void> {
    /* renamed from: a */
    private List<Category> f12424a;
    /* renamed from: b */
    private LayoutInflater f12425b;
    /* renamed from: c */
    private Category f12426c;
    /* renamed from: d */
    private int f12427d;
    /* renamed from: e */
    private C2782f f12428e;

    public C3233l(MainActivity mainActivity, Category category, List<Category> list, int i) {
        super(mainActivity, 0);
        this.f12425b = LayoutInflater.from(mainActivity);
        this.f12424a = list;
        this.f12426c = category;
        this.f12427d = i;
    }

    /* renamed from: a */
    public void m17141a(C2782f c2782f) {
        this.f12428e = c2782f;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup);
    }

    public View getView(final int i, View view, final ViewGroup viewGroup) {
        if (view == null) {
            view = this.f12425b.inflate(R.layout.item_sort_full, null);
        }
        if (this.f12424a != null) {
            final Category category = (Category) this.f12424a.get(i);
            if (category != null) {
                TextView textView = (TextView) view.findViewById(R.id.sort_view);
                textView.setText(((Category) this.f12424a.get(i)).getName());
                View findViewById = view.findViewById(R.id.img_selected);
                if (i == this.f12427d) {
                    findViewById.setVisibility(0);
                } else {
                    findViewById.setVisibility(8);
                }
                if (i != 0) {
                    textView.setBackgroundColor(0);
                }
                view.setOnClickListener(new OnClickListener(this) {
                    /* renamed from: d */
                    final /* synthetic */ C3233l f12423d;

                    public void onClick(View view) {
                        this.f12423d.f12427d = i;
                        if (this.f12423d.f12427d == 0) {
                            if (this.f12423d.f12428e != null) {
                                this.f12423d.f12428e.mo2058a(null);
                            }
                        } else if (this.f12423d.f12428e != null) {
                            this.f12423d.f12428e.mo2058a(category);
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
        if (this.f12424a == null) {
            return 0;
        }
        return this.f12424a.size();
    }
}
