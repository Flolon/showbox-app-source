package com.tdo.showbox.data.p119b.p120a;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* compiled from: IAWLRectangleAdapterBridge */
/* renamed from: com.tdo.showbox.data.b.a.a */
public class C3023a extends BaseAdapter {
    /* renamed from: a */
    private C3024b f11896a;
    /* renamed from: b */
    private DataSetObserver f11897b;
    /* renamed from: c */
    private C3022a f11898c;

    /* compiled from: IAWLRectangleAdapterBridge */
    /* renamed from: com.tdo.showbox.data.b.a.a$a */
    private class C3022a extends DataSetObserver {
        /* renamed from: a */
        final /* synthetic */ C3023a f11895a;

        private C3022a(C3023a c3023a) {
            this.f11895a = c3023a;
        }

        public void onChanged() {
            if (this.f11895a.f11897b != null) {
                this.f11895a.f11897b.onChanged();
            }
        }

        public void onInvalidated() {
            if (this.f11895a.f11897b != null) {
                this.f11895a.f11897b.onInvalidated();
            }
        }
    }

    public C3023a(Context context, BaseAdapter baseAdapter, View view) {
        this(context, baseAdapter, 0, 0, view);
    }

    public C3023a(Context context, BaseAdapter baseAdapter, int i, int i2, View view) {
        this.f11896a = new C3024b(context, baseAdapter, i, i2);
        this.f11896a.m16405a(view);
        this.f11898c = new C3022a();
    }

    /* renamed from: a */
    public void m16402a(int i, int i2) {
        this.f11896a.m16409e(i);
        this.f11896a.m16410f(i2);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f11896a.m16406b(this.f11896a.f11899a.getCount());
    }

    public Object getItem(int i) {
        if (this.f11896a.m16408d(i)) {
            return null;
        }
        return this.f11896a.f11899a.getItem(this.f11896a.m16403a(i));
    }

    public long getItemId(int i) {
        if (this.f11896a.m16408d(i)) {
            return 0;
        }
        return this.f11896a.f11899a.getItemId(this.f11896a.m16403a(i));
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f11896a.m16408d(i)) {
            return this.f11896a.m16404a(i, view, viewGroup);
        }
        return this.f11896a.f11899a.getView(this.f11896a.m16403a(i), view, viewGroup);
    }

    public boolean hasStableIds() {
        return this.f11896a.f11899a.hasStableIds();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.f11897b = dataSetObserver;
        this.f11896a.f11899a.registerDataSetObserver(this.f11898c);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.f11897b = null;
        this.f11896a.f11899a.unregisterDataSetObserver(this.f11898c);
    }

    public void notifyDataSetChanged() {
        this.f11896a.f11899a.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {
        this.f11896a.f11899a.notifyDataSetInvalidated();
    }

    public boolean areAllItemsEnabled() {
        return this.f11896a.f11899a.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        if (this.f11896a.m16408d(i)) {
            return true;
        }
        return this.f11896a.f11899a.isEnabled(this.f11896a.m16403a(i));
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        Log.e("Story", "Story Adapter bridge currently does not support drop down mode");
        return null;
    }

    public int getItemViewType(int i) {
        if (this.f11896a.m16408d(i)) {
            return this.f11896a.f11899a.getViewTypeCount();
        }
        return this.f11896a.f11899a.getItemViewType(this.f11896a.m16403a(i));
    }

    public int getViewTypeCount() {
        return this.f11896a.m16407c(this.f11896a.f11899a.getViewTypeCount());
    }

    public boolean isEmpty() {
        return this.f11896a.f11899a.isEmpty();
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return this.f11896a.f11899a.hashCode();
    }

    public String toString() {
        return this.f11896a.f11899a.toString();
    }
}
