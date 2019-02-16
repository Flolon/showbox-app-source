package com.tdo.showbox.p121g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.models.UpdateItem;
import com.tdo.showbox.p121g.p133a.C3188a;
import com.tdo.showbox.p121g.p133a.C3189e;
import com.tdo.showbox.p121g.p133a.C3191b;
import com.tdo.showbox.p121g.p133a.C3194c;
import com.tdo.showbox.p121g.p133a.C3196f;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/* compiled from: UpdatesAdapter */
/* renamed from: com.tdo.showbox.g.q */
public class C3245q extends C3194c<Void> {
    /* renamed from: b */
    private List<UpdateItem> f12473b;
    /* renamed from: c */
    private LayoutInflater f12474c;
    /* renamed from: d */
    private MainActivity f12475d;
    /* renamed from: e */
    private SimpleDateFormat f12476e;
    /* renamed from: f */
    private SimpleDateFormat f12477f;
    /* renamed from: g */
    private int f12478g = 1;
    /* renamed from: h */
    private int f12479h = 2;
    /* renamed from: i */
    private int f12480i = 1;
    /* renamed from: j */
    private int f12481j = 2;
    /* renamed from: k */
    private int f12482k = 2;
    /* renamed from: l */
    private View f12483l;

    /* compiled from: UpdatesAdapter */
    /* renamed from: com.tdo.showbox.g.q$1 */
    class C32431 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3245q f12471a;

        C32431(C3245q c3245q) {
            this.f12471a = c3245q;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            if (i == this.f12471a.f12482k) {
                return this.f12471a.f12480i;
            }
            return this.f12471a.f12481j;
        }
    }

    /* compiled from: UpdatesAdapter */
    /* renamed from: com.tdo.showbox.g.q$2 */
    class C32442 implements C3189e {
        /* renamed from: a */
        final /* synthetic */ C3245q f12472a;

        C32442(C3245q c3245q) {
            this.f12472a = c3245q;
        }

        /* renamed from: a */
        public int mo2148a(int i) {
            try {
                return this.f12472a.getContext().getResources().getConfiguration().orientation == 2 ? this.f12472a.f12479h : this.f12472a.f12478g;
            } catch (Exception e) {
                return this.f12472a.f12479h;
            }
        }
    }

    public C3245q(MainActivity mainActivity, List<UpdateItem> list, boolean z) {
        super(mainActivity, 1);
        this.f12473b = list;
        this.f12474c = LayoutInflater.from(mainActivity);
        this.f12475d = mainActivity;
        this.f12476e = new SimpleDateFormat("yyyy-MM-dd");
        this.f12477f = new SimpleDateFormat("dd LLL yyyy");
        if (z) {
            m17183e();
        } else {
            m17181d();
        }
    }

    /* renamed from: a */
    public void m17186a(View view) {
        this.f12483l = view;
        notifyDataSetChanged();
    }

    /* renamed from: d */
    private void m17181d() {
        C3191b c3191b = new C3191b();
        c3191b.m17001a(this.f12480i, new C3196f(true, 1));
        c3191b.m17001a(this.f12481j, new C3196f(true, 2));
        c3191b.m17002a(new C32431(this));
        m17014a(c3191b);
    }

    /* renamed from: e */
    private void m17183e() {
        C3191b c3191b = new C3191b();
        try {
            c3191b.m17001a(this.f12478g, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_portret)));
            c3191b.m17001a(this.f12479h, new C3196f(true, getContext().getResources().getInteger(R.integer.grid_colum_land)));
        } catch (Exception e) {
            c3191b.m17001a(this.f12478g, new C3196f(true, 4));
            c3191b.m17001a(this.f12479h, new C3196f(true, 5));
        }
        c3191b.m17002a(new C32442(this));
        m17014a(c3191b);
    }

    /* renamed from: a */
    private String m17177a(String str) {
        try {
            str = this.f12477f.format(this.f12476e.parse(str));
        } catch (Exception e) {
        }
        return str;
    }

    /* renamed from: a */
    public void m17188a(List<UpdateItem> list) {
        this.f12473b = list;
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public List<UpdateItem> m17189b() {
        return this.f12473b;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* renamed from: a */
    public View mo2152a(int i, View view, ViewGroup viewGroup, C3188a c3188a) {
        if (c3188a.m16993a() == 1) {
            if (view == null || !(view instanceof FrameLayout)) {
                view = new FrameLayout(this.f12475d);
                view.setLayoutParams(new LayoutParams(-1, -2));
            } else {
                view = (FrameLayout) view;
            }
            if (this.f12483l != null) {
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                ViewGroup viewGroup2 = (ViewGroup) this.f12483l.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeAllViews();
                }
                view.removeAllViews();
                view.addView(this.f12483l, layoutParams);
            }
        } else {
            if (view == null) {
                view = this.f12474c.inflate(R.layout.lib_item_tv, viewGroup, false);
            }
            try {
                UpdateItem updateItem = (UpdateItem) this.f12473b.get(m17175a(i));
                TextView textView = (TextView) view.findViewById(R.id.txtv_descr);
                TextView textView2 = (TextView) view.findViewById(R.id.txtv_name);
                textView2.setVisibility(4);
                ImageView imageView = (ImageView) view.findViewById(R.id.imgv_tv);
                View view2 = (ImageView) view.findViewById(R.id.imgv_tv_stub);
                if (textView != null) {
                    textView.setVisibility(0);
                    textView.setText(m17177a(updateItem.getDate()));
                }
                this.f12475d.m15139C().m16634a(imageView, view2, updateItem.getPoster());
                textView2.setVisibility(0);
                textView2.setText(updateItem.getTitle());
            } catch (Exception e) {
            }
        }
        return view;
    }

    /* renamed from: a */
    private int m17175a(int i) {
        if (m17017c() == null) {
            return i;
        }
        if (m17017c().m17000a(this.f12481j) == null) {
            throw new RuntimeException(String.format(Locale.getDefault(), "Can`t find row rule [%s]", new Object[]{Integer.valueOf(this.f12481j)}));
        } else if (i < m17017c().m17000a(this.f12481j).m16993a() * this.f12482k) {
            return i;
        } else {
            return i - 1;
        }
    }

    /* renamed from: a */
    protected void mo2163a(View view, int i) {
        super.mo2163a(view, m17175a(i));
    }

    /* renamed from: a */
    protected int mo2150a() {
        if (this.f12473b == null || this.f12473b.isEmpty()) {
            return 0;
        }
        if (this.f12473b.size() < m17017c().m17000a(this.f12481j).m16993a() * this.f12482k) {
            return this.f12473b.size();
        }
        return this.f12473b.size() + 1;
    }
}
