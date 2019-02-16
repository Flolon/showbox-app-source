package com.tdo.showbox.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.C0722b;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.data.p119b.C3047g;
import com.tdo.showbox.models.AppConfig;
import com.tdo.showbox.p117b.C2769a;

public class NewsDetailsActivity extends C2631a {
    /* renamed from: b */
    protected C3047g f10781b;
    /* renamed from: c */
    private View f10782c;
    /* renamed from: d */
    private WebView f10783d;
    /* renamed from: e */
    private Toolbar f10784e;
    /* renamed from: f */
    private ViewGroup f10785f;

    /* renamed from: com.tdo.showbox.activities.NewsDetailsActivity$1 */
    class C26331 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ NewsDetailsActivity f10780a;

        C26331(NewsDetailsActivity newsDetailsActivity) {
            this.f10780a = newsDetailsActivity;
        }

        public void onClick(View view) {
            this.f10780a.finish();
            this.f10780a.overridePendingTransition(0, 0);
        }
    }

    /* renamed from: a */
    public static void m15180a(Context context, String str) {
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    /* renamed from: b */
    public C3047g mo2004b() {
        if (this.f10781b == null) {
            AppConfig appConfig = (AppConfig) new Select().from(AppConfig.class).executeSingle();
            if (appConfig == null) {
                return null;
            }
            this.f10781b = new C3047g(this, appConfig, this.f10785f);
        }
        return this.f10781b;
    }

    /* renamed from: i */
    private void m15181i() {
        this.f10784e = (Toolbar) findViewById(R.id.toolbar);
        this.f10784e.setPadding(0, 0, 0, 0);
        this.f10784e.setTitle((CharSequence) "");
        setSupportActionBar(this.f10784e);
        getSupportActionBar().mo453a(true);
        View textView = new TextView(this);
        textView.setLayoutParams(new C0722b(1, 1));
        getSupportActionBar().mo450a(textView);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getResources().getBoolean(R.bool.portrait_only)) {
            setRequestedOrientation(1);
        }
        overridePendingTransition(0, 0);
        getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.main_back)));
        setContentView((int) R.layout.act_news_details);
        m15181i();
        this.f10782c = LayoutInflater.from(this).inflate(R.layout.news_web_view_detail_bar, null, false);
        this.f10785f = (LinearLayout) findViewById(R.id.banner_container);
        try {
            m15182j();
            m15183k();
            getSupportActionBar().mo451a(this.f10782c, new C0722b(-1, -2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String stringExtra = getIntent().getStringExtra("url");
        ((ViewGroup) findViewById(R.id.bottom_container)).addView(C2769a.m15475a(LayoutInflater.from(this).inflate(R.layout.item_recycleview_empty_footer, null)));
        this.f10783d = (WebView) findViewById(R.id.webview);
        this.f10783d.getSettings().setJavaScriptEnabled(true);
        this.f10783d.setBackgroundColor(0);
        this.f10783d.getSettings().setUserAgentString("Show Box");
        this.f10783d.loadUrl(stringExtra);
        if (mo2004b() != null) {
            mo2004b().m16487a("banner_new_details");
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: j */
    private void m15182j() {
        if (VERSION.SDK_INT >= 21) {
            ColorStateList colorStateList = getResources().getColorStateList(R.color.drawer_colors_state);
            this.f10782c.findViewById(R.id.back_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), new ColorDrawable(-256)));
            this.f10782c.findViewById(R.id.back_btn).setBackground(new RippleDrawable(colorStateList, new ColorDrawable(0), getDrawable(R.drawable.riple)));
        }
    }

    /* renamed from: k */
    private void m15183k() {
        this.f10782c.findViewById(R.id.back_btn).setOnClickListener(new C26331(this));
    }

    public void onBackPressed() {
        overridePendingTransition(0, 0);
        super.onBackPressed();
    }

    public void onPause() {
        super.onPause();
        if (this.f10783d != null) {
            this.f10783d.onPause();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (mo2004b() != null) {
            mo2004b().m16487a("banner_new_details");
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f10783d != null) {
            this.f10783d.onResume();
        }
        if (mo2004b() != null) {
            mo2004b().m16485a();
        }
    }

    public void onDestroy() {
        if (this.f10783d != null) {
            this.f10783d.stopLoading();
            this.f10783d = null;
        }
        if (mo2004b() != null) {
            mo2004b().m16489b();
        }
        super.onDestroy();
    }
}
