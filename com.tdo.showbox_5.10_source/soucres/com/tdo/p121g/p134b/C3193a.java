package com.tdo.showbox.p121g.p134b;

import android.content.Context;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

/* compiled from: BaseNoveltyAdapter */
/* renamed from: com.tdo.showbox.g.b.a */
public class C3193a<T> extends ArrayAdapter<T> {
    /* renamed from: a */
    protected OnItemClickListener f12288a;

    public C3193a(Context context, int i) {
        super(context, i);
    }

    /* renamed from: a */
    public void m17004a(OnItemClickListener onItemClickListener) {
        this.f12288a = onItemClickListener;
    }
}
