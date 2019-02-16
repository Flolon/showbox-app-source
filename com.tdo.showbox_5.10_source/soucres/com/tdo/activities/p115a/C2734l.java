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

/* compiled from: TrendingBar */
/* renamed from: com.tdo.showbox.activities.a.l */
public class C2734l extends C2668a {
    /* renamed from: a */
    private Context f11024a;
    /* renamed from: b */
    private View f11025b;

    /* compiled from: TrendingBar */
    /* renamed from: com.tdo.showbox.activities.a.l$1 */
    class C27331 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C2734l f11023a;

        C27331(C2734l c2734l) {
            this.f11023a = c2734l;
        }

        public void onClick(View view) {
            C3167a.m16903a().m16917b();
        }
    }

    /* renamed from: a */
    public View mo2026a(Context context) {
        this.f11024a = context;
        this.f11025b = LayoutInflater.from(context).inflate(R.layout.trending_action_bar, null, false);
        m15414d();
        m15413c();
        m15416b();
        return this.f11025b;
    }

    /* renamed from: b */
    public void m15416b() {
        int c = C3088f.m16684c("PREFS_UPDATES_UNVIEWED_TOTAL_COUNT");
        if (this.f11025b != null) {
            TextView textView = (TextView) this.f11025b.findViewById(R.id.update_count);
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
    private void m15413c() {
        if (VERSION.SDK_INT >= 21) {
            this.f11025b.findViewById(R.id.menu).setBackground(new RippleDrawable(this.f11024a.getResources().getColorStateList(R.color.drawer_colors_state), new ColorDrawable(0), this.f11024a.getDrawable(R.drawable.menu_ripple)));
        }
    }

    /* renamed from: d */
    private void m15414d() {
        this.f11025b.findViewById(R.id.menu).setOnClickListener(new C27331(this));
    }
}
