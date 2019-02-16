package com.tdo.showbox.data.api.p125a;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: UntrustSSLSocketFactory */
/* renamed from: com.tdo.showbox.data.api.a.b */
public class C2998b extends SSLSocketFactory {
    /* renamed from: a */
    SSLContext f11822a = SSLContext.getInstance("TLS");

    public C2998b(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        C2997a c2997a = new C2997a();
        this.f11822a.init(null, new TrustManager[]{c2997a}, null);
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return this.f11822a.getSocketFactory().createSocket(socket, str, i, z);
    }

    public Socket createSocket() throws IOException {
        return this.f11822a.getSocketFactory().createSocket();
    }
}
