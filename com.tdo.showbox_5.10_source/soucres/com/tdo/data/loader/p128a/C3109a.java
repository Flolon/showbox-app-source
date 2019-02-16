package com.tdo.showbox.data.loader.p128a;

import android.util.Log;

/* compiled from: L */
/* renamed from: com.tdo.showbox.data.loader.a.a */
public class C3109a {
    /* renamed from: a */
    public static boolean m16755a() {
        return false;
    }

    /* renamed from: a */
    public static void m16754a(String str, C3110b... c3110bArr) {
        if (C3109a.m16755a()) {
            Log.i(C3109a.m16752a(c3110bArr), str);
        }
    }

    /* renamed from: a */
    public static void m16753a(String str, Throwable th, C3110b... c3110bArr) {
        if (C3109a.m16755a()) {
            Log.e(C3109a.m16752a(c3110bArr), str, th);
        }
    }

    /* renamed from: a */
    private static String m16752a(C3110b[] c3110bArr) {
        String str = "";
        for (Object valueOf : c3110bArr) {
            str = str + String.valueOf(valueOf) + " :: ";
        }
        return str;
    }
}
