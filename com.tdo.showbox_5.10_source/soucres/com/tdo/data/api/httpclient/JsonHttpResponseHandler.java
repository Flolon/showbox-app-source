package com.tdo.showbox.data.api.httpclient;

import android.os.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonHttpResponseHandler extends AsyncHttpResponseHandler {
    protected static final int SUCCESS_JSON_MESSAGE = 100;

    public void onSuccess(JSONObject jSONObject) {
    }

    public void onSuccess(JSONArray jSONArray) {
    }

    public void onSuccess(int i, JSONObject jSONObject) {
        onSuccess(jSONObject);
    }

    public void onSuccess(int i, JSONArray jSONArray) {
        onSuccess(jSONArray);
    }

    public void onFailure(Throwable th, JSONObject jSONObject) {
    }

    public void onFailure(Throwable th, JSONArray jSONArray) {
    }

    protected void sendSuccessMessage(int i, String str, String str2, long j) {
        try {
            Object parseResponse = parseResponse(str);
            sendMessage(obtainMessage(100, new Object[]{Integer.valueOf(i), parseResponse}));
        } catch (Throwable e) {
            sendFailureMessage(e, str);
        }
    }

    protected void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                Object[] objArr = (Object[]) message.obj;
                handleSuccessJsonMessage(((Integer) objArr[0]).intValue(), objArr[1]);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }

    protected void handleSuccessJsonMessage(int i, Object obj) {
        if (obj instanceof JSONObject) {
            onSuccess(i, (JSONObject) obj);
        } else if (obj instanceof JSONArray) {
            onSuccess(i, (JSONArray) obj);
        } else {
            onFailure(new JSONException("Unexpected type " + obj.getClass().getName()), (JSONObject) null);
        }
    }

    protected Object parseResponse(String str) throws JSONException {
        Object obj = null;
        String trim = str.trim();
        if (trim.startsWith("{") || trim.startsWith("[")) {
            obj = new JSONTokener(trim).nextValue();
        }
        return obj == null ? trim : obj;
    }

    protected void handleFailureMessage(Throwable th, String str) {
        if (str != null) {
            try {
                Object parseResponse = parseResponse(str);
                if (parseResponse instanceof JSONObject) {
                    onFailure(th, (JSONObject) parseResponse);
                    return;
                } else if (parseResponse instanceof JSONArray) {
                    onFailure(th, (JSONArray) parseResponse);
                    return;
                } else {
                    onFailure(th, str);
                    return;
                }
            } catch (JSONException e) {
                onFailure(th, str);
                return;
            }
        }
        onFailure(th, "");
    }
}
