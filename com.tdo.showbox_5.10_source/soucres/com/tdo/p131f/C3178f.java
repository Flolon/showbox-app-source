package com.tdo.showbox.p131f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NetUtils */
/* renamed from: com.tdo.showbox.f.f */
public class C3178f {
    /* renamed from: a */
    public static int m16971a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return 0;
        }
        int i = 0;
        while (i < allNetworkInfo.length) {
            if (allNetworkInfo[i].getState() == State.CONNECTED) {
                return allNetworkInfo[i].getType() == 1 ? 2 : 1;
            } else {
                i++;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public static boolean m16973b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo state : allNetworkInfo) {
            if (state.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static Map<String, String> m16972a(final String str) throws URISyntaxException {
        return new HashMap<String, String>() {
        };
    }
}
