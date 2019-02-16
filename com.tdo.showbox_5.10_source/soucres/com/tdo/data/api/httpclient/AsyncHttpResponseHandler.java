package com.tdo.showbox.data.api.httpclient;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

public class AsyncHttpResponseHandler {
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    private Handler handler;

    /* renamed from: com.tdo.showbox.data.api.httpclient.AsyncHttpResponseHandler$1 */
    class C30191 extends Handler {
        C30191() {
        }

        public void handleMessage(Message message) {
            AsyncHttpResponseHandler.this.handleMessage(message);
        }
    }

    public AsyncHttpResponseHandler() {
        if (Looper.myLooper() != null) {
            this.handler = new C30191();
        }
    }

    public void onStart() {
    }

    public void onFinish() {
    }

    public void onSuccess(String str) {
    }

    public void onSuccess(String str, CookieStore cookieStore) {
    }

    public void onSuccess(String str, String str2, long j) {
    }

    public void onSuccess(int i, String str) {
        onSuccess(str);
    }

    public void onSuccess(int i, String str, CookieStore cookieStore) {
        onSuccess(str, cookieStore);
    }

    public void onFailure(Throwable th) {
    }

    public void onFailure(Throwable th, String str) {
        onFailure(th);
    }

    protected void sendSuccessMessage(int i, String str, String str2, long j) {
        sendMessage(obtainMessage(0, new Object[]{new Integer(i), str, str2, Long.valueOf(j)}));
    }

    protected void sendFailureMessage(Throwable th, String str) {
        sendMessage(obtainMessage(1, new Object[]{th, str}));
    }

    protected void sendFailureMessage(Throwable th, byte[] bArr) {
        sendMessage(obtainMessage(1, new Object[]{th, bArr}));
    }

    protected void sendStartMessage() {
        sendMessage(obtainMessage(2, null));
    }

    protected void sendFinishMessage() {
        sendMessage(obtainMessage(3, null));
    }

    protected void handleSuccessMessage(int i, String str, String str2, long j) {
        if (str2 == null) {
            onSuccess(i, str);
        } else {
            onSuccess(str, str2, j);
        }
    }

    protected void handleFailureMessage(Throwable th, String str) {
        onFailure(th, str);
    }

    protected void handleMessage(Message message) {
        Object[] objArr;
        switch (message.what) {
            case 0:
                objArr = (Object[]) message.obj;
                handleSuccessMessage(((Integer) objArr[0]).intValue(), (String) objArr[1], (String) objArr[2], ((Long) objArr[3]).longValue());
                return;
            case 1:
                objArr = (Object[]) message.obj;
                handleFailureMessage((Throwable) objArr[0], (String) objArr[1]);
                return;
            case 2:
                onStart();
                return;
            case 3:
                onFinish();
                return;
            default:
                return;
        }
    }

    protected void sendMessage(Message message) {
        if (this.handler != null) {
            this.handler.sendMessage(message);
        } else {
            handleMessage(message);
        }
    }

    protected Message obtainMessage(int i, Object obj) {
        if (this.handler != null) {
            return this.handler.obtainMessage(i, obj);
        }
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        return message;
    }

    void sendResponseMessage(HttpResponse httpResponse) {
        String str;
        StatusLine statusLine = httpResponse.getStatusLine();
        try {
            String entityUtils;
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                entityUtils = EntityUtils.toString(new BufferedHttpEntity(entity), "UTF-8");
            } else {
                entityUtils = null;
            }
            str = entityUtils;
        } catch (Throwable e) {
            sendFailureMessage(e, null);
            str = null;
        }
        if (statusLine.getStatusCode() >= IjkMediaCodecInfo.RANK_SECURE) {
            sendFailureMessage(new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), str);
        } else {
            sendSuccessMessage(statusLine.getStatusCode(), str, null, 0);
        }
    }

    void sendResponseMessage(HttpResponse httpResponse, String str, long j) {
        String str2;
        String str3 = null;
        StatusLine statusLine = httpResponse.getStatusLine();
        try {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                str3 = EntityUtils.toString(new BufferedHttpEntity(entity), "UTF-8");
            }
            str2 = str3;
        } catch (Throwable e) {
            sendFailureMessage(e, null);
            str2 = null;
        }
        if (statusLine.getStatusCode() >= IjkMediaCodecInfo.RANK_SECURE) {
            sendFailureMessage(new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), str2);
        } else {
            sendSuccessMessage(statusLine.getStatusCode(), str2, str, j);
        }
    }

    void sendResponseMessage(HttpResponse httpResponse, CookieStore cookieStore, String str, long j) {
        String str2;
        String str3 = null;
        StatusLine statusLine = httpResponse.getStatusLine();
        try {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                str3 = EntityUtils.toString(new BufferedHttpEntity(entity), "UTF-8");
            }
            str2 = str3;
        } catch (Throwable e) {
            sendFailureMessage(e, null);
            str2 = null;
        }
        if (statusLine.getStatusCode() >= IjkMediaCodecInfo.RANK_SECURE) {
            sendFailureMessage(new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), str2);
        } else {
            sendSuccessMessage(statusLine.getStatusCode(), str2, str, j);
        }
    }
}
