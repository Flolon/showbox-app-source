package com.tdo.showbox.activities.p115a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.p129e.p130a.C3167a;

/* compiled from: SettingsBar */
/* renamed from: com.tdo.showbox.activities.a.h */
public class C2719h extends C2668a {
    /* renamed from: a */
    private Context f10992a;
    /* renamed from: b */
    private View f10993b;

    /* compiled from: SettingsBar */
    /* renamed from: com.tdo.showbox.activities.a.h$1 */
    class C27181 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2719h f10991a;

        C27181(C2719h c2719h) {
            this.f10991a = c2719h;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16917b();
        }
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f10992a = context;
        this.f10993b = LayoutInflater.from(context).inflate(R.layout.settings_action_bar, null, false);
        m15377d();
        m15376c();
        m15379b();
        return this.f10993b;
    }

    /* renamed from: b */
    public void m15379b() {
        int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
        if (this.f10993b != null) {
            TextView textView = (TextView) this.f10993b.findViewById(R.id.update_count);
            if (textView == null || c <= 0) {
                textView.setVisibility(4);
                return;
            }
            textView.setVisibility(0);
            textView.setText("" + c);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    private void m15376c() {
        if (VERSION.SDK_INT >= 21) {
            this.f10993b.findViewById(R.id.menu).setBackground(new RippleDrawable(this.f10992a.getResources().getColorStateList(R.color.drawer_colors_state), new ColorDrawable(0), this.f10992a.getDrawable(R.drawable.menu_ripple)));
        }
    }

    /* renamed from: d */
    private void m15377d() {
        this.f10993b.findViewById(R.id.menu).setOnClickListener(new C27181(this));
    }
}
