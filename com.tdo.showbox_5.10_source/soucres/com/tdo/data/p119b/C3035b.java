package com.tdo.showbox.data.p119b;

import com.iawl.api.ads.sdk.IAWLAdView;
import com.iawl.api.ads.sdk.IAWLErrorCode;
import com.iawl.api.ads.sdk.IAWLInterstitialView;
import com.iawl.api.ads.sdk.IAWLInterstitialView.IAWLInterstitialAdListener;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.adListeners.AdDisplayListener;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;

/* compiled from: AdCommonInterstitialListener */
/* renamed from: com.tdo.showbox.data.b.b */
public class C3035b implements IAWLInterstitialAdListener, AdDisplayListener, AdEventListener {
    public void iawlInterstitialLoaded(IAWLInterstitialView iAWLInterstitialView) {
    }

    public void iawlInterstitialFailed(IAWLInterstitialView iAWLInterstitialView, IAWLErrorCode iAWLErrorCode) {
    }

    public void iawlInterstitialShown(IAWLInterstitialView iAWLInterstitialView) {
    }

    public void iawlInterstitialClicked(IAWLInterstitialView iAWLInterstitialView) {
    }

    public void iawlInterstitialDismissed(IAWLInterstitialView iAWLInterstitialView) {
    }

    public void iawlAdWillOpenExternalApp(IAWLAdView iAWLAdView) {
    }

    public void iawlInternalBrowserDismissed(IAWLAdView iAWLAdView) {
    }

    public void iawlInterstitialVideoCompleted(IAWLInterstitialView iAWLInterstitialView) {
    }

    public void onReceiveAd(Ad ad) {
        iawlInterstitialLoaded(null);
    }

    public void onFailedToReceiveAd(Ad ad) {
        iawlInterstitialFailed(null, null);
    }

    public void adHidden(Ad ad) {
        iawlInterstitialDismissed(null);
    }

    public void adDisplayed(Ad ad) {
        iawlInterstitialShown(null);
    }

    public void adClicked(Ad ad) {
        iawlInterstitialClicked(null);
    }

    public void adNotDisplayed(Ad ad) {
    }
}
