package com.tdo.showbox.data.p119b;

import android.view.View;
import com.iawl.api.ads.sdk.IAWLAdView;
import com.iawl.api.ads.sdk.IAWLAdView.IAWLBannerAdListener;
import com.iawl.api.ads.sdk.IAWLErrorCode;
import com.startapp.android.publish.ads.banner.BannerListener;

/* compiled from: AdCommonBannerListener */
/* renamed from: com.tdo.showbox.data.b.a */
public class C3025a implements IAWLBannerAdListener, BannerListener {
    public void iawlBannerLoaded(IAWLAdView iAWLAdView) {
    }

    public void iawlBannerFailed(IAWLAdView iAWLAdView, IAWLErrorCode iAWLErrorCode) {
    }

    public void iawlBannerClicked(IAWLAdView iAWLAdView) {
    }

    public void iawlBannerExpanded(IAWLAdView iAWLAdView) {
    }

    public void iawlBannerCollapsed(IAWLAdView iAWLAdView) {
    }

    public void iawlBannerResized(IAWLAdView iAWLAdView) {
    }

    public void iawlAdWillOpenExternalApp(IAWLAdView iAWLAdView) {
    }

    public void iawlInternalBrowserDismissed(IAWLAdView iAWLAdView) {
    }

    public void onReceiveAd(View view) {
        iawlBannerLoaded(null);
    }

    public void onFailedToReceiveAd(View view) {
        iawlBannerFailed(null, null);
    }

    public void onClick(View view) {
        iawlBannerClicked(null);
    }
}
