package com.tdo.showbox.data.api.p125a;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: FakeTrustManager */
/* renamed from: com.tdo.showbox.data.api.a.a */
public class C2997a implements X509TrustManager {
    /* renamed from: a */
    private static final X509Certificate[] f11821a = new X509Certificate[0];

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f11821a;
    }
}
