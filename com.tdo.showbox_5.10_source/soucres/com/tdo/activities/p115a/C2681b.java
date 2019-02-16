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

/* compiled from: DownloadActionBar */
/* renamed from: com.tdo.showbox.activities.a.b */
public class C2681b extends C2668a {
    /* renamed from: a */
    private Context f10920a;
    /* renamed from: b */
    private View f10921b;

    /* compiled from: DownloadActionBar */
    /* renamed from: com.tdo.showbox.activities.a.b$1 */
    class C26801 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2681b f10919a;

        C26801(C2681b c2681b) {
            this.f10919a = c2681b;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16917b();
        }
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f10920a = context;
        this.f10921b = LayoutInflater.from(context).inflate(R.layout.download_action_bar, null, false);
        m15293d();
        m15292c();
        m15295b();
        return this.f10921b;
    }

    /* renamed from: b */
    public void m15295b() {
        int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
        if (this.f10921b != null) {
            TextView textView = (TextView) this.f10921b.findViewById(R.id.update_count);
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
    private void m15292c() {
        if (VERSION.SDK_INT >= 21) {
            this.f10921b.findViewById(R.id.menu).setBackground(new RippleDrawable(this.f10920a.getResources().getColorStateList(R.color.drawer_colors_state), new ColorDrawable(0), this.f10920a.getDrawable(R.drawable.menu_ripple)));
        }
    }

    /* renamed from: d */
    private void m15293d() {
        this.f10921b.findViewById(R.id.menu).setOnClickListener(new C26801(this));
    }
}
