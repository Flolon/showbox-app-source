package com.tdo.showbox.data.p119b;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.iawl.api.ads.sdk.IAWLActivityOrientationMode;
import com.iawl.api.ads.sdk.IAWLAdManager;
import com.iawl.api.ads.sdk.IAWLErrorCode;
import com.iawl.api.ads.sdk.IAWLNativeAd;
import com.iawl.api.ads.sdk.IAWLNativeAdFactory;
import com.iawl.api.ads.sdk.IAWLNativeAdRequest;
import com.iawl.api.ads.sdk.IAWLNativeAdRequest.Mode;
import com.iawl.api.ads.sdk.IAWLNativeAdRequest.NativeAssetMode;
import com.iawl.api.ads.sdk.IAWLNativeAdViewBinder;
import com.iawl.api.ads.sdk.IAWLNativeAdViewBinder.Builder;
import com.iawl.api.ads.sdk.IAWLNativeVideoViewConfig;
import com.iawl.api.ads.sdk.IAWLUserConfig;
import com.iawl.api.ads.sdk.IAWLUserConfig.Gender;
import com.iawl.api.ads.sdk.IAWLVideoPlayerOverlay;
import com.iawl.api.ads.sdk.IAnativeAdListener;
import com.tdo.showbox.C2607a;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.p119b.p120a.C3031c;
import com.tdo.showbox.data.p119b.p120a.C3031c.C2747a;
import com.tdo.showbox.models.UserInfo;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: IaStoryAd */
/* renamed from: com.tdo.showbox.data.b.k */
public class C3056k implements IAnativeAdListener {
    /* renamed from: a */
    private String f11978a = "";
    /* renamed from: b */
    private IAWLNativeAd f11979b;
    /* renamed from: c */
    private Activity f11980c;
    /* renamed from: d */
    private ViewGroup f11981d;
    /* renamed from: e */
    private C2871a f11982e;
    /* renamed from: f */
    private boolean f11983f;
    /* renamed from: g */
    private boolean f11984g;
    /* renamed from: h */
    private String f11985h;
    /* renamed from: i */
    private C3031c f11986i;

    /* compiled from: IaStoryAd */
    /* renamed from: com.tdo.showbox.data.b.k$a */
    public interface C2871a {
        /* renamed from: a */
        void mo2074a();
    }

    /* compiled from: IaStoryAd */
    /* renamed from: com.tdo.showbox.data.b.k$1 */
    class C30541 implements C2747a {
        /* renamed from: a */
        final /* synthetic */ C3056k f11976a;

        C30541(C3056k c3056k) {
            this.f11976a = c3056k;
        }

        /* renamed from: a */
        public void mo2032a() {
            C3094j.m16698a("Ia_StoryAd", "onRectAdReady");
            C3094j.m16699b("Ia_StoryAd", "onRectAdReady");
            this.f11976a.m16513a().m16432a(true);
            if (this.f11976a.f11982e != null) {
                this.f11976a.f11982e.mo2074a();
            }
        }
    }

    /* compiled from: IaStoryAd */
    /* renamed from: com.tdo.showbox.data.b.k$2 */
    class C30552 implements C2747a {
        /* renamed from: a */
        final /* synthetic */ C3056k f11977a;

        C30552(C3056k c3056k) {
            this.f11977a = c3056k;
        }

        /* renamed from: a */
        public void mo2032a() {
            C3094j.m16698a("Ia_StoryAd", "onRectAdReady");
            this.f11977a.m16513a().m16432a(true);
            if (this.f11977a.f11982e != null) {
                this.f11977a.f11982e.mo2074a();
            }
        }
    }

    public C3056k(String str) {
        this.f11985h = str;
    }

    /* renamed from: a */
    public void m16514a(int i, int i2) {
        m16513a().m16427a(i, i2);
    }

    /* renamed from: a */
    public C3031c m16513a() {
        if (this.f11986i == null) {
            this.f11986i = new C3031c(this.f11985h);
        }
        return this.f11986i;
    }

    /* renamed from: a */
    public void m16518a(C2871a c2871a) {
        this.f11982e = c2871a;
    }

    /* renamed from: b */
    public boolean m16521b() {
        if (this.f11984g) {
            return m16513a().m16434c();
        }
        return this.f11983f;
    }

    /* renamed from: c */
    public boolean m16522c() {
        return this.f11984g;
    }

    /* renamed from: a */
    public void m16520a(boolean z) {
        this.f11983f = z;
    }

    /* renamed from: a */
    public void m16515a(Activity activity, Bundle bundle, UserInfo userInfo) {
        this.f11980c = activity;
        this.f11983f = false;
        this.f11984g = false;
        this.f11978a = C2607a.f10703a ? "TVFS_MovieTimev_Native_Android" : "TVFS_MovieTimev_Native_Android";
        if (bundle != null) {
            Object string = bundle.getString("CACHED_NATIVE_AD_ID");
            if (!TextUtils.isEmpty(string)) {
                IAWLNativeAd nativeAd = IAWLNativeAdFactory.getNativeAd(string);
                if (nativeAd != null) {
                    this.f11979b = nativeAd;
                    this.f11979b.addListener(this);
                }
            }
        }
        m16513a().m16429a(activity, userInfo);
        if (this.f11979b == null) {
            m16519a(userInfo);
        }
    }

    /* renamed from: a */
    public void m16516a(Bundle bundle) {
        if (this.f11979b != null) {
            bundle.putString("CACHED_NATIVE_AD_ID", this.f11979b.getUid());
        }
    }

    /* renamed from: d */
    public void m16523d() {
        m16513a().m16435d();
        this.f11979b.removeListener(this);
        this.f11982e = null;
        if (this.f11980c.isFinishing()) {
            IAWLAdManager.destroy();
            this.f11979b = null;
            this.f11980c = null;
        }
    }

    /* renamed from: e */
    public void m16524e() {
        IAWLAdManager.activityResumed();
        if (this.f11984g) {
            m16513a().m16431a(new C30541(this));
            m16513a().m16436e();
        }
    }

    /* renamed from: f */
    public void m16525f() {
        IAWLAdManager.activityPaused();
        if (this.f11984g) {
            m16513a().m16437f();
        }
    }

    /* renamed from: a */
    private void m16512a(View view) {
        if (view != null) {
            DisplayMetrics displayMetrics = this.f11980c.getResources().getDisplayMetrics();
            view.getLayoutParams().height = (Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels) / 16) * 9;
        }
    }

    /* renamed from: a */
    protected void m16519a(UserInfo userInfo) {
        IAWLAdManager.initialize(this.f11980c);
        this.f11979b = IAWLNativeAdFactory.createNativeAd(this.f11980c);
        this.f11979b.addListener(this);
        IAWLNativeAdRequest mode = new IAWLNativeAdRequest(this.f11978a).setIsInFeed(true).setTitleAssetMode(NativeAssetMode.OPTIONAL).setActionAssetMode(NativeAssetMode.OPTIONAL).setDescriptionAssetMode(NativeAssetMode.OPTIONAL).setMainAssetMinSize(IjkMediaCodecInfo.RANK_SECURE, 250).setIconMinSize(30, 30).setMode(Mode.NATIVE_AD_ALL);
        if (userInfo != null) {
            IAWLUserConfig iAWLUserConfig = new IAWLUserConfig();
            iAWLUserConfig.setAge(Integer.valueOf(userInfo.getAge()).intValue());
            if (userInfo.getGender().equalsIgnoreCase("Female")) {
                iAWLUserConfig.setGender(Gender.FEMALE);
            } else {
                iAWLUserConfig.setGender(Gender.MALE);
            }
            mode.setUserParams(iAWLUserConfig);
        }
        this.f11979b.requestAd(mode);
    }

    /* renamed from: a */
    public void m16517a(ListView listView, BaseAdapter baseAdapter) {
        if (this.f11980c != null) {
            if (this.f11984g) {
                m16513a().m16430a(listView, baseAdapter);
                return;
            }
            this.f11981d = (ViewGroup) this.f11980c.getLayoutInflater().inflate(R.layout.story_ad_layout, null);
            IAWLNativeAdViewBinder build = new Builder(this.f11980c, this.f11981d).setIconViewId(R.id.story_icon_view).setTitleViewId(R.id.story_title_view).setContentHostViewId(R.id.ad_content_host).setDescriptionViewId(R.id.description).build();
            m16512a(this.f11981d.findViewById(R.id.ad_content_host));
            if (this.f11979b != null) {
                try {
                    IAWLNativeVideoViewConfig autoStartOnlyWhenIdle = new IAWLNativeVideoViewConfig().setVideoFullscreenOrientationMode(IAWLActivityOrientationMode.FULL_USER).setStartMuted(true).setAutoStartOnlyWhenIdle(false);
                    autoStartOnlyWhenIdle.setRequestedOverlays(IAWLVideoPlayerOverlay.Action_Button, IAWLVideoPlayerOverlay.Mute_Button, IAWLVideoPlayerOverlay.Remaining_Time_Countdown, IAWLVideoPlayerOverlay.Skip_Close_Overlay);
                    autoStartOnlyWhenIdle.showProgressBar(false);
                    build.bind(this.f11979b, autoStartOnlyWhenIdle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                listView.setAdapter(new C3052i(this.f11980c, baseAdapter, build));
            }
        }
    }

    public void onAdReady(IAWLNativeAd iAWLNativeAd) {
        C3094j.m16698a("Ia_StoryAd", "onAdReady");
        C3094j.m16699b("Ia_StoryAd", "onAdReady");
        m16520a(true);
        this.f11984g = false;
        m16513a().m16435d();
        if (this.f11982e != null) {
            this.f11982e.mo2074a();
        }
    }

    public void onAdFailed(IAWLErrorCode iAWLErrorCode) {
        C3094j.m16698a("Ia_StoryAd", "onAdFailed");
        C3094j.m16699b("Ia_StoryAd", "onAdFailed");
        m16520a(false);
        if (!this.f11984g) {
            this.f11984g = true;
            m16513a().m16437f();
            m16513a().m16431a(new C30552(this));
            m16513a().m16436e();
        }
    }

    public void onVideoAdCompleted(IAWLNativeAd iAWLNativeAd) {
        C3094j.m16698a("Ia_StoryAd", "onVideoAdCompleted");
    }

    public void onImpression(IAWLNativeAd iAWLNativeAd) {
        C3094j.m16698a("Ia_StoryAd", "onImpression");
    }

    public void onClicked(IAWLNativeAd iAWLNativeAd) {
        C3094j.m16698a("Ia_StoryAd", "onClicked");
    }

    public void onVideoAdPlayingStateChanged(boolean z) {
        C3094j.m16698a("Ia_StoryAd", "onVideoAdPlayingStateChanged");
    }
}
