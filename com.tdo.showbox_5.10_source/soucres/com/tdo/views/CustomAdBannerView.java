package com.tdo.showbox.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.tdo.showbox.data.C3065b;
import com.tdo.showbox.models.InternalAd;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CustomAdBannerView extends RelativeLayout {
    /* renamed from: a */
    private final String f12497a = "CustomAdBannerView";
    /* renamed from: b */
    private InternalAd f12498b;
    /* renamed from: c */
    private WebView f12499c;
    /* renamed from: d */
    private boolean f12500d;
    /* renamed from: e */
    private int f12501e;
    /* renamed from: f */
    private int f12502f;
    /* renamed from: g */
    private C3252b f12503g;
    /* renamed from: h */
    private C3029a f12504h;

    /* renamed from: com.tdo.showbox.views.CustomAdBannerView$a */
    public interface C3029a {
        /* renamed from: a */
        void mo2110a();
    }

    /* renamed from: com.tdo.showbox.views.CustomAdBannerView$1 */
    class C32481 extends WebViewClient {
        /* renamed from: a */
        final /* synthetic */ CustomAdBannerView f12484a;

        C32481(CustomAdBannerView customAdBannerView) {
            this.f12484a = customAdBannerView;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            if (this.f12484a.f12499c != null) {
                this.f12484a.f12499c.setBackgroundColor(this.f12484a.f12501e);
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (str.toLowerCase().contains("/favicon.ico")) {
                try {
                    return new WebResourceResponse("image/png", null, new BufferedInputStream(webView.getContext().getAssets().open("tttt_wzk_icon.ico")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.f12484a.f12503g != null) {
                return this.f12484a.f12503g.m17191a(str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (!webResourceRequest.isForMainFrame() && webResourceRequest.getUrl().getPath().endsWith("/favicon.ico")) {
                try {
                    return new WebResourceResponse("image/png", null, new BufferedInputStream(webView.getContext().getAssets().open("tttt_wzk_icon.ico")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.f12484a.f12503g != null) {
                return this.f12484a.f12503g.m17191a(webResourceRequest.getUrl().toString());
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }
    }

    /* renamed from: com.tdo.showbox.views.CustomAdBannerView$2 */
    class C32492 extends WebChromeClient {
        /* renamed from: a */
        final /* synthetic */ CustomAdBannerView f12485a;

        C32492(CustomAdBannerView customAdBannerView) {
            this.f12485a = customAdBannerView;
        }
    }

    /* renamed from: com.tdo.showbox.views.CustomAdBannerView$3 */
    class C32503 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ CustomAdBannerView f12486a;

        C32503(CustomAdBannerView customAdBannerView) {
            this.f12486a = customAdBannerView;
        }

        public void onClick(View view) {
            try {
                if (this.f12486a.f12504h != null) {
                    this.f12486a.f12504h.mo2110a();
                }
                if (this.f12486a.f12498b.getAd_type().equals("banner")) {
                    C3065b.m16569a("internal_ads_banner_click", "id", this.f12486a.f12498b.getItem_id());
                } else if (this.f12486a.f12498b.getAd_type().equals(InternalAd.RECT_AD)) {
                    C3065b.m16569a("internal_ads_mrec_click", "id", this.f12486a.f12498b.getItem_id());
                } else if (this.f12486a.f12498b.getAd_type().equals(InternalAd.OWN_RECT_AD)) {
                    C3065b.m16569a("internal_ads_own_mrec_click", "id", this.f12486a.f12498b.getItem_id());
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f12486a.f12498b.getLink()));
                intent.setFlags(268435456);
                this.f12486a.getContext().startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.tdo.showbox.views.CustomAdBannerView$b */
    public class C3252b {
        /* renamed from: a */
        protected Map<String, C3251a> f12493a = new HashMap();
        /* renamed from: b */
        protected Context f12494b = null;
        /* renamed from: c */
        protected File f12495c = null;
        /* renamed from: d */
        final /* synthetic */ CustomAdBannerView f12496d;

        /* renamed from: com.tdo.showbox.views.CustomAdBannerView$b$a */
        public class C3251a {
            /* renamed from: a */
            public String f12487a;
            /* renamed from: b */
            public String f12488b;
            /* renamed from: c */
            public String f12489c;
            /* renamed from: d */
            public String f12490d;
            /* renamed from: e */
            public long f12491e;
            /* renamed from: f */
            final /* synthetic */ C3252b f12492f;

            private C3251a(C3252b c3252b, String str, String str2, String str3, String str4, long j) {
                this.f12492f = c3252b;
                this.f12487a = str;
                this.f12488b = str2;
                this.f12489c = str3;
                this.f12490d = str4;
                this.f12491e = j;
            }
        }

        public C3252b(CustomAdBannerView customAdBannerView, Context context) {
            this.f12496d = customAdBannerView;
            this.f12494b = context;
            this.f12495c = new File(this.f12494b.getExternalFilesDir(null), "ads_cache");
            if (!this.f12495c.exists()) {
                this.f12495c.mkdirs();
            }
        }

        /* renamed from: a */
        public void m17192a(String str, String str2, String str3, String str4, long j) {
            this.f12493a.put(str, new C3251a(str, str2, str3, str4, j));
        }

        /* renamed from: a */
        public WebResourceResponse m17191a(String str) {
            C3251a c3251a = (C3251a) this.f12493a.get(str);
            if (c3251a == null) {
                return null;
            }
            File file = new File(this.f12495c.getPath() + File.separator + c3251a.f12488b);
            if (!file.exists()) {
                try {
                    m17190a(str, c3251a, file);
                    return m17191a(str);
                } catch (Exception e) {
                    return null;
                }
            } else if (System.currentTimeMillis() - file.lastModified() > c3251a.f12491e) {
                file.delete();
                return m17191a(str);
            } else {
                try {
                    return new WebResourceResponse(c3251a.f12489c, c3251a.f12490d, new FileInputStream(file));
                } catch (FileNotFoundException e2) {
                    return null;
                }
            }
        }

        /* renamed from: a */
        private void m17190a(String str, C3251a c3251a, File file) throws IOException {
            InputStream inputStream = new URL(str).openConnection().getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            for (int read = inputStream.read(); read != -1; read = inputStream.read()) {
                fileOutputStream.write(read);
            }
            inputStream.close();
            fileOutputStream.close();
        }
    }

    public void setBannerListener(C3029a c3029a) {
        this.f12504h = c3029a;
    }

    public CustomAdBannerView(Context context) {
        super(context);
        m17198a();
    }

    public CustomAdBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17198a();
    }

    public void setScaleFactor(int i) {
        this.f12502f = i;
    }

    /* renamed from: a */
    public void m17198a() {
        this.f12501e = 0;
        if (!this.f12500d) {
            this.f12500d = true;
            Context context = getContext();
            try {
                this.f12499c = new WebView(context);
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                addView(this.f12499c, layoutParams);
                this.f12499c.setWebChromeClient(new WebChromeClient());
                WebSettings settings = this.f12499c.getSettings();
                if (VERSION.SDK_INT >= 16) {
                    settings.setAllowUniversalAccessFromFileURLs(true);
                }
                settings.setJavaScriptEnabled(true);
                settings.setDomStorageEnabled(true);
                settings.setSaveFormData(false);
                settings.setSavePassword(false);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setLoadWithOverviewMode(false);
                settings.setUseWideViewPort(false);
                settings.setBuiltInZoomControls(false);
                this.f12499c.setVerticalScrollBarEnabled(false);
                this.f12499c.setHorizontalScrollBarEnabled(false);
                settings.setSupportZoom(false);
                settings.setAppCacheEnabled(true);
                settings.setCacheMode(-1);
                this.f12499c.setWebViewClient(new C32481(this));
                this.f12499c.setWebChromeClient(new C32492(this));
                this.f12499c.setBackgroundColor(this.f12501e);
                View view = new View(context);
                view.setOnClickListener(new C32503(this));
                addView(view, new RelativeLayout.LayoutParams(-1, -1));
            } catch (Exception e) {
            }
        }
    }

    public void setAdInit(InternalAd internalAd) {
        this.f12498b = internalAd;
    }

    /* renamed from: b */
    public void m17199b() {
        try {
            if (this.f12498b.getAd_type().equals("banner")) {
                C3065b.m16569a("internal_ads_banner_show", "id", this.f12498b.getItem_id());
            } else if (this.f12498b.getAd_type().equals(InternalAd.RECT_AD)) {
                C3065b.m16569a("internal_ads_mrec_show", "id", this.f12498b.getItem_id());
            } else if (this.f12498b.getAd_type().equals(InternalAd.OWN_RECT_AD)) {
                C3065b.m16569a("internal_ads_own_mrec_show", "id", this.f12498b.getItem_id());
            }
            if (this.f12502f != 0) {
                this.f12499c.setInitialScale(this.f12502f);
            }
            this.f12503g = new C3252b(this, getContext());
            this.f12503g.m17192a(this.f12498b.getUrl(), "" + this.f12498b.getUrl().hashCode(), "text/html", "UTF-8", 600000);
            this.f12499c.loadUrl(this.f12498b.getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f12499c != null) {
            this.f12499c.onPause();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12499c != null) {
            this.f12499c.onResume();
        }
    }

    /* renamed from: c */
    public void m17200c() {
        if (this.f12499c != null) {
            this.f12499c.stopLoading();
        }
    }
}
