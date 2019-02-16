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

/* compiled from: MoviesTabBar */
/* renamed from: com.tdo.showbox.activities.a.a.b */
public class C2673b extends C2668a {
    /* renamed from: a */
    protected Context f10896a;
    /* renamed from: b */
    protected View f10897b;
    /* renamed from: c */
    protected View f10898c;
    /* renamed from: d */
    protected C3343a f10899d;
    /* renamed from: e */
    protected C2701a f10900e;
    /* renamed from: f */
    private View f10901f;
    /* renamed from: g */
    private View f10902g;
    /* renamed from: h */
    private EditText f10903h;

    /* compiled from: MoviesTabBar */
    /* renamed from: com.tdo.showbox.activities.a.a.b$1 */
    class C26701 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2673b f10893a;

        C26701(C2673b c2673b) {
            this.f10893a = c2673b;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16917b();
        }
    }

    /* compiled from: MoviesTabBar */
    /* renamed from: com.tdo.showbox.activities.a.a.b$2 */
    class C26712 implements TextWatcher {
        /* renamed from: a */
        final /* synthetic */ C2673b f10894a;

        C26712(C2673b c2673b) {
            this.f10894a = c2673b;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (this.f10894a.f10903h.getText().toString().length() == 0) {
                this.f10894a.f10902g.setVisibility(8);
            } else {
                this.f10894a.f10902g.setVisibility(0);
            }
        }
    }

    /* compiled from: MoviesTabBar */
    /* renamed from: com.tdo.showbox.activities.a.a.b$3 */
    class C26723 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2673b f10895a;

        C26723(C2673b c2673b) {
            this.f10895a = c2673b;
        }

        public void onClick(View view) {
            this.f10895a.f10903h.setText("");
            this.f10895a.f10902g.setVisibility(8);
            if (this.f10895a.f10900e != null) {
                this.f10895a.f10900e.mo2060a();
            }
        }
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        if (this.f10897b != null) {
            return this.f10897b;
        }
        this.f10896a = context;
        this.f10897b = LayoutInflater.from(context).inflate(R.layout.move_tab_action_bar, null, false);
        this.f10898c = this.f10897b.findViewById(R.id.normal_menu);
        this.f10902g = this.f10897b.findViewById(R.id.im_search_close);
        this.f10903h = (EditText) this.f10897b.findViewById(R.id.edttx_search);
        this.f10899d = (C3343a) this.f10897b.findViewById(R.id.menu_btn);
        this.f10897b.findViewById(R.id.menu).setOnClickListener(new C26701(this));
        if (this.f10903h.getText().toString().length() == 0) {
            this.f10902g.setVisibility(8);
        } else {
            this.f10902g.setVisibility(0);
        }
        this.f10903h.addTextChangedListener(new C26712(this));
        this.f10902g.setOnClickListener(new C26723(this));
        this.f10899d.setState(C3350b.BURGER);
        m15283b();
        return this.f10897b;
    }

    /* renamed from: b */
    public void m15283b() {
        int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
        if (this.f10897b != null) {
            TextView textView = (TextView) this.f10897b.findViewById(R.id.update_count);
            if (textView == null || c <= 0) {
                textView.setVisibility(4);
                return;
            }
            textView.setVisibility(0);
            textView.setText("" + c);
        }
    }

    /* renamed from: a */
    public void m15281a(C2701a c2701a) {
        this.f10900e = c2701a;
    }

    /* renamed from: b */
    public View m15282b(Context context) {
        if (this.f10901f == null) {
            this.f10901f = mo2026a(context);
        }
        return this.f10901f;
    }
}
