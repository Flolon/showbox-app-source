package com.tdo.showbox.activities.p115a.p116a;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.p115a.C2668a;
import com.tdo.showbox.activities.p115a.C2705e.C2701a;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.p129e.p130a.C3167a;
import com.tdo.showbox.views.materialmenu.C3343a;
import com.tdo.showbox.views.materialmenu.C3353b.C3350b;

/* compiled from: ShowsTabBar */
/* renamed from: com.tdo.showbox.activities.a.a.d */
public class C2679d extends C2668a {
    /* renamed from: a */
    protected Context f10911a;
    /* renamed from: b */
    protected View f10912b;
    /* renamed from: c */
    protected View f10913c;
    /* renamed from: d */
    protected C3343a f10914d;
    /* renamed from: e */
    protected C2701a f10915e;
    /* renamed from: f */
    private View f10916f;
    /* renamed from: g */
    private View f10917g;
    /* renamed from: h */
    private EditText f10918h;

    /* compiled from: ShowsTabBar */
    /* renamed from: com.tdo.showbox.activities.a.a.d$1 */
    class C26761 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2679d f10908a;

        C26761(C2679d c2679d) {
            this.f10908a = c2679d;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16917b();
        }
    }

    /* compiled from: ShowsTabBar */
    /* renamed from: com.tdo.showbox.activities.a.a.d$2 */
    class C26772 implements TextWatcher {
        /* renamed from: a */
        final /* synthetic */ C2679d f10909a;

        C26772(C2679d c2679d) {
            this.f10909a = c2679d;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (this.f10909a.f10918h.getText().toString().length() == 0) {
                this.f10909a.f10917g.setVisibility(8);
            } else {
                this.f10909a.f10917g.setVisibility(0);
            }
        }
    }

    /* compiled from: ShowsTabBar */
    /* renamed from: com.tdo.showbox.activities.a.a.d$3 */
    class C26783 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2679d f10910a;

        C26783(C2679d c2679d) {
            this.f10910a = c2679d;
        }

        public void onClick(View view) {
            this.f10910a.f10918h.setText("");
            this.f10910a.f10917g.setVisibility(8);
            if (this.f10910a.f10915e != null) {
                this.f10910a.f10915e.mo2060a();
            }
        }
    }

    /* renamed from: a */
    public void m15289a(C2701a c2701a) {
        this.f10915e = c2701a;
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        if (this.f10912b != null) {
            return this.f10912b;
        }
        this.f10911a = context;
        this.f10912b = LayoutInflater.from(context).inflate(R.layout.shows_tab_action_bar, null, false);
        this.f10917g = this.f10912b.findViewById(R.id.im_search_close);
        this.f10918h = (EditText) this.f10912b.findViewById(R.id.edttx_search);
        this.f10913c = this.f10912b.findViewById(R.id.normal_menu);
        this.f10914d = (C3343a) this.f10912b.findViewById(R.id.menu_btn);
        this.f10912b.findViewById(R.id.menu).setOnClickListener(new C26761(this));
        this.f10914d.setState(C3350b.BURGER);
        if (this.f10918h.getText().toString().length() == 0) {
            this.f10917g.setVisibility(8);
        } else {
            this.f10917g.setVisibility(0);
        }
        this.f10918h.addTextChangedListener(new C26772(this));
        this.f10917g.setOnClickListener(new C26783(this));
        m15291b();
        return this.f10912b;
    }

    /* renamed from: b */
    public void m15291b() {
        int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
        if (this.f10912b != null) {
            TextView textView = (TextView) this.f10912b.findViewById(R.id.update_count);
            if (textView == null || c <= 0) {
                textView.setVisibility(4);
                return;
            }
            textView.setVisibility(0);
            textView.setText("" + c);
        }
    }

    /* renamed from: b */
    public View m15290b(Context context) {
        if (this.f10916f == null) {
            this.f10916f = mo2026a(context);
        }
        return this.f10916f;
    }
}
