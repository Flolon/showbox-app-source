package com.tdo.showbox.p121g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.MainActivity;

/* compiled from: LanguageAdapter */
/* renamed from: com.tdo.showbox.g.c */
public class C3210c extends ArrayAdapter<Void> {
    /* renamed from: a */
    private String[] f12348a;
    /* renamed from: b */
    private LayoutInflater f12349b;
    /* renamed from: c */
    private MainActivity f12350c;
    /* renamed from: d */
    private String f12351d;
    /* renamed from: e */
    private String[] f12352e;
    /* renamed from: f */
    private int f12353f = this.f12350c.getResources().getColor(R.color.green_l);

    public C3210c(MainActivity mainActivity, String[] strArr, String str, String[] strArr2) {
        super(mainActivity, 0);
        this.f12348a = strArr;
        this.f12349b = LayoutInflater.from(mainActivity);
        this.f12350c = mainActivity;
        this.f12351d = str;
        this.f12352e = strArr2;
    }

    /* renamed from: a */
    public void m17075a(String[] strArr, String str, String[] strArr2) {
        int i = 0;
        this.f12348a = new String[strArr.length];
        for (int i2 = 0; i2 < this.f12348a.length; i2++) {
            this.f12348a[i2] = strArr[i2];
        }
        this.f12352e = new String[strArr2.length];
        while (i < this.f12352e.length) {
            this.f12352e[i] = strArr2[i];
            i++;
        }
        this.f12351d = str;
        notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f12349b.inflate(R.layout.item_lang_sub, viewGroup, false);
        }
        try {
            TextView textView = (TextView) view.findViewById(R.id.txtv_name);
            textView.setText(this.f12348a[i].toUpperCase());
            textView.setTextColor(-1);
            if (this.f12351d != null && this.f12351d.equals(this.f12352e[i].toLowerCase())) {
                textView.setTextColor(this.f12353f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public int getCount() {
        return this.f12348a.length;
    }
}
