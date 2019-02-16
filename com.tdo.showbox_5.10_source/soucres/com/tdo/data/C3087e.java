package com.tdo.showbox.data;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* compiled from: FileLogger */
/* renamed from: com.tdo.showbox.data.e */
public class C3087e {
    /* renamed from: a */
    private static String f12093a;
    /* renamed from: b */
    private static String f12094b = "           ";
    /* renamed from: c */
    private static String f12095c = "\n";
    /* renamed from: d */
    private static String f12096d;

    /* renamed from: a */
    public static void m16673a(Context context) {
        if (context != null) {
            File file = new File(Environment.getExternalStorageDirectory(), "shows_logs");
            if (!file.exists()) {
                file.mkdirs();
            }
            f12093a = file.getAbsolutePath();
            f12096d = null;
        }
    }

    /* renamed from: a */
    public static void m16674a(String str, String str2, String str3) {
    }
}
