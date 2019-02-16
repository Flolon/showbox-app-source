package com.tdo.showbox.data.api.httpclient;

import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.api.C3016f;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

class AsyncHttpRequest implements Runnable {
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private boolean isBinaryRequest;
    private String mKeyForCache;
    private long mTimeCache;
    private final HttpUriRequest request;
    private final AsyncHttpResponseHandler responseHandler;

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        this.client = abstractHttpClient;
        this.context = httpContext;
        this.request = httpUriRequest;
        this.responseHandler = asyncHttpResponseHandler;
        if (asyncHttpResponseHandler instanceof BinaryHttpResponseHandler) {
            this.isBinaryRequest = true;
        }
        this.mTimeCache = 0;
        this.mKeyForCache = null;
    }

    public AsyncHttpRequest(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, AsyncHttpResponseHandler asyncHttpResponseHandler, long j, String str) {
        this.mTimeCache = j;
        this.mKeyForCache = str;
        this.client = abstractHttpClient;
        this.context = httpContext;
        this.request = httpUriRequest;
        this.responseHandler = asyncHttpResponseHandler;
        if (asyncHttpResponseHandler instanceof BinaryHttpResponseHandler) {
            this.isBinaryRequest = true;
        }
    }

    public void run() {
        try {
            if (this.responseHandler != null) {
                this.responseHandler.sendStartMessage();
            }
            String a = C3016f.m16396a(this.mKeyForCache);
            if (a == null || a.length() == 0) {
                C3094j.m16698a("ApiClient", "Response from web");
                makeRequestWithRetries();
            } else {
                C3094j.m16698a("ApiClient", "Response from cache");
                if (this.responseHandler != null) {
                    this.responseHandler.sendSuccessMessage(200, a, this.mKeyForCache, this.mTimeCache);
                }
            }
            if (this.responseHandler != null) {
                this.responseHandler.sendFinishMessage();
            }
        } catch (Throwable e) {
            Throwable th = e;
            if (this.responseHandler != null) {
                this.responseHandler.sendFinishMessage();
                if (this.isBinaryRequest) {
                    this.responseHandler.sendFailureMessage(th, (byte[]) null);
                } else {
                    this.responseHandler.sendFailureMessage(th, (String) null);
                }
            }
        }
    }

    private void makeRequest() throws IOException {
        HttpResponse execute;
        if (!Thread.currentThread().isInterrupted()) {
            try {
                HttpResponse execute2 = this.client.execute(this.request, this.context);
                if (!Thread.currentThread().isInterrupted() && this.responseHandler != null) {
                    this.responseHandler.sendResponseMessage(execute2, this.mKeyForCache, this.mTimeCache);
                }
            } catch (SocketException e) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                try {
                    execute = this.client.execute(this.request, this.context);
                    if (!Thread.currentThread().isInterrupted() && this.responseHandler != null) {
                        this.responseHandler.sendResponseMessage(execute, this.client.getCookieStore(), this.mKeyForCache, this.mTimeCache);
                    }
                } catch (SocketException e3) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e4) {
                    }
                    execute = this.client.execute(this.request, this.context);
                    if (!Thread.currentThread().isInterrupted() && this.responseHandler != null) {
                        this.responseHandler.sendResponseMessage(execute, this.client.getCookieStore(), this.mKeyForCache, this.mTimeCache);
                    }
                }
            } catch (NoHttpResponseException e5) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e22) {
                    e22.printStackTrace();
                }
                try {
                    execute = this.client.execute(this.request, this.context);
                    if (!Thread.currentThread().isInterrupted() && this.responseHandler != null) {
                        this.responseHandler.sendResponseMessage(execute, this.client.getCookieStore(), this.mKeyForCache, this.mTimeCache);
                    }
                } catch (NoHttpResponseException e6) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e7) {
                    }
                    execute = this.client.execute(this.request, this.context);
                    if (!Thread.currentThread().isInterrupted() && this.responseHandler != null) {
                        this.responseHandler.sendResponseMessage(execute, this.client.getCookieStore(), this.mKeyForCache, this.mTimeCache);
                    }
                }
            }
        }
    }

    private void makeRequestWithRetries() throws ConnectException {
        int i;
        boolean z = true;
        Throwable th = null;
        HttpRequestRetryHandler httpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
        while (z) {
            try {
                makeRequest();
                return;
            } catch (Throwable th2) {
                if (this.responseHandler != null) {
                    this.responseHandler.sendFailureMessage(th2, "can't resolve host");
                    return;
                }
                return;
            } catch (Throwable th22) {
                if (this.responseHandler != null) {
                    this.responseHandler.sendFailureMessage(th22, "can't resolve host");
                    return;
                }
                return;
            } catch (IOException e) {
                th22 = e;
                i = this.executionCount + 1;
                this.executionCount = i;
                z = httpRequestRetryHandler.retryRequest(th22, i, this.context);
            } catch (NullPointerException e2) {
                th22 = new IOException("NPE in HttpClient" + e2.getMessage());
                i = this.executionCount + 1;
                this.executionCount = i;
                z = httpRequestRetryHandler.retryRequest(th22, i, this.context);
            }
        }
        ConnectException connectException = new ConnectException();
        connectException.initCause(th22);
        throw connectException;
    }
}
