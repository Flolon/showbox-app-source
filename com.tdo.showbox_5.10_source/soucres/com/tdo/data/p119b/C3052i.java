package com.tdo.showbox.data.p119b;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.iawl.api.ads.sdk.IAWLNativeAdViewBinder;

/* compiled from: IAWLStoryAdapterBridge */
/* renamed from: com.tdo.showbox.data.b.i */
public class C3052i extends BaseAdapter {
    /* renamed from: a */
    private C3053j f11968a;
    /* renamed from: b */
    private DataSetObserver f11969b;
    /* renamed from: c */
    private C3051a f11970c;

    /* compiled from: IAWLStoryAdapterBridge */
    /* renamed from: com.tdo.showbox.data.b.i$a */
    private class C3051a extends DataSetObserver {
        /* renamed from: a */
        final /* synthetic */ C3052i f11967a;

        private C3051a(C3052i c3052i) {
            this.f11967a = c3052i;
        }

        public void onChanged() {
            if (this.f11967a.f11969b != null) {
                this.f11967a.f11969b.onChanged();
            }
        }

        public void onInvalidated() {
            if (this.f11967a.f11969b != null) {
                this.f11967a.f11969b.onInvalidated();
            }
        }
    }

    public C3052i(Context context, BaseAdapter baseAdapter, IAWLNativeAdViewBinder iAWLNativeAdViewBinder) {
        this(context, baseAdapter, iAWLNativeAdViewBinder, 0, 0);
    }

    public C3052i(Context context, BaseAdapter baseAdapter, IAWLNativeAdViewBinder iAWLNativeAdViewBinder, int i, int i2) {
        this.f11968a = new C3053j(context, baseAdapter, iAWLNativeAdViewBinder, i, i2);
        this.f11970c = new C3051a();
    }

    public int getCount() {
        return this.f11968a.m16506b(this.f11968a.f11971a.getCount());
    }

    public Object getItem(int i) {
        if (this.f11968a.m16508d(i)) {
            return null;
        }
        return this.f11968a.f11971a.getItem(this.f11968a.m16504a(i));
    }

    public long getItemId(int i) {
        if (this.f11968a.m16508d(i)) {
            return 0;
        }
        return this.f11968a.f11971a.getItemId(this.f11968a.m16504a(i));
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f11968a.m16508d(i)) {
            return this.f11968a.m16505a(i, view, viewGroup);
        }
        return this.f11968a.f11971a.getView(this.f11968a.m16504a(i), view, viewGroup);
    }

    public boolean hasStableIds() {
        return this.f11968a.f11971a.hasStableIds();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.f11969b = dataSetObserver;
        this.f11968a.f11971a.registerDataSetObserver(this.f11970c);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.f11969b = null;
        this.f11968a.f11971a.unregisterDataSetObserver(this.f11970c);
    }

    public void notifyDataSetChanged() {
        this.f11968a.f11971a.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated() {
        this.f11968a.f11971a.notifyDataSetInvalidated();
    }

    public boolean areAllItemsEnabled() {
        return this.f11968a.f11971a.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        if (this.f11968a.m16508d(i)) {
            return true;
        }
        return this.f11968a.f11971a.isEnabled(this.f11968a.m16504a(i));
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        Log.e("Story", "Story Adapter bridge currently does not support drop down mode");
        return null;
    }

    public int getItemViewType(int i) {
        if (this.f11968a.m16508d(i)) {
            return this.f11968a.f11971a.getViewTypeCount();
        }
        return this.f11968a.f11971a.getItemViewType(this.f11968a.m16504a(i));
    }

    public int getViewTypeCount() {
        return this.f11968a.m16507c(this.f11968a.f11971a.getViewTypeCount());
    }

    public boolean isEmpty() {
        return this.f11968a.f11971a.isEmpty();
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return this.f11968a.f11971a.hashCode();
    }

    public String toString() {
        return this.f11968a.f11971a.toString();
    }
}
