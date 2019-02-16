package com.tdo.showbox.data.api.httpclient;

import android.content.Context;
import android.os.Message;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public abstract class SyncHttpClient extends AsyncHttpClient {
    private int responseCode;
    AsyncHttpResponseHandler responseHandler = new C30201();
    private String result;

    /* renamed from: com.tdo.showbox.data.api.httpclient.SyncHttpClient$1 */
    class C30201 extends AsyncHttpResponseHandler {
        C30201() {
        }

        void sendResponseMessage(HttpResponse httpResponse) {
            SyncHttpClient.this.responseCode = httpResponse.getStatusLine().getStatusCode();
            super.sendResponseMessage(httpResponse);
        }

        protected void sendMessage(Message message) {
            handleMessage(message);
        }

        public void onSuccess(String str) {
            SyncHttpClient.this.result = str;
        }

        public void onFailure(Throwable th, String str) {
            SyncHttpClient.this.result = SyncHttpClient.this.onRequestFailed(th, str);
        }
    }

    public abstract String onRequestFailed(Throwable th, String str);

    public int getResponseCode() {
        return this.responseCode;
    }

    protected void sendRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, AsyncHttpResponseHandler asyncHttpResponseHandler, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        new AsyncHttpRequest(defaultHttpClient, httpContext, httpUriRequest, asyncHttpResponseHandler).run();
    }

    public void delete(String str, RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        delete(str, asyncHttpResponseHandler);
    }

    public String get(String str, RequestParams requestParams) {
        get(str, requestParams, this.responseHandler);
        return this.result;
    }

    public String get(String str) {
        get(str, null, this.responseHandler);
        return this.result;
    }

    public String put(String str, RequestParams requestParams) {
        put(str, requestParams, this.responseHandler);
        return this.result;
    }

    public String put(String str) {
        put(str, null, this.responseHandler);
        return this.result;
    }

    public String post(String str, RequestParams requestParams) {
        post(str, requestParams, this.responseHandler);
        return this.result;
    }

    public String post(String str) {
        post(str, null, this.responseHandler);
        return this.result;
    }

    public String delete(String str, RequestParams requestParams) {
        delete(str, requestParams, this.responseHandler);
        return this.result;
    }

    public String delete(String str) {
        delete(str, null, this.responseHandler);
        return this.result;
    }
}
