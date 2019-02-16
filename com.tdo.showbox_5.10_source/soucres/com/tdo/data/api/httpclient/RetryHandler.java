package com.tdo.showbox.data.api.httpclient;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class RetryHandler implements HttpRequestRetryHandler {
    private static final int RETRY_SLEEP_TIME_MILLIS = 1500;
    private static HashSet<Class<?>> exceptionBlacklist = new HashSet();
    private static HashSet<Class<?>> exceptionWhitelist = new HashSet();
    private final int maxRetries;

    static {
        exceptionWhitelist.add(NoHttpResponseException.class);
        exceptionWhitelist.add(UnknownHostException.class);
        exceptionWhitelist.add(SocketException.class);
        exceptionBlacklist.add(InterruptedIOException.class);
        exceptionBlacklist.add(SSLHandshakeException.class);
    }

    public RetryHandler(int i) {
        this.maxRetries = i;
    }

    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        boolean z = true;
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        boolean z2 = bool != null && bool.booleanValue();
        if (i > this.maxRetries) {
            z2 = false;
        } else if (exceptionBlacklist.contains(iOException.getClass())) {
            z2 = false;
        } else if (exceptionWhitelist.contains(iOException.getClass())) {
            z2 = true;
        } else if (z2) {
            z2 = true;
        } else {
            z2 = true;
        }
        if (!z2) {
            z = z2;
        } else if (((HttpUriRequest) httpContext.getAttribute("http.request")).getMethod().equals("POST")) {
            z = false;
        }
        if (z) {
            SystemClock.sleep(1500);
        } else {
            iOException.printStackTrace();
        }
        return z;
    }
}
