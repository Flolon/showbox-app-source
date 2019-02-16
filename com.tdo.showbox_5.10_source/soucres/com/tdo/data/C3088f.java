package com.tdo.showbox.data;

import android.content.Context;
import android.content.SharedPreferences.Editor;

/* compiled from: Prefs */
/* renamed from: com.tdo.showbox.data.f */
public class C3088f {
    /* renamed from: a */
    private static Context f12097a;
    /* renamed from: b */
    private static String f12098b = "prefs";

    /* renamed from: a */
    public static void m16676a(Context context) {
        f12097a = context;
    }

    /* renamed from: a */
    public static void m16679a(String str, String str2) {
        if (f12097a != null) {
            Editor edit = f12097a.getSharedPreferences(f12098b, 0).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    /* renamed from: a */
    public static void m16677a(String str, int i) {
        if (f12097a != null) {
            Editor edit = f12097a.getSharedPreferences(f12098b, 0).edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    /* renamed from: a */
    public static void m16680a(String str, boolean z) {
        if (f12097a != null) {
            Editor edit = f12097a.getSharedPreferences(f12098b, 0).edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    /* renamed from: a */
    public static String m16675a(String str) {
        if (f12097a == null) {
            return "";
        }
        return f12097a.getSharedPreferences(f12098b, 0).getString(str, "");
    }

    /* renamed from: b */
    public static boolean m16682b(String str) {
        if (f12097a == null) {
            return false;
        }
        return f12097a.getSharedPreferences(f12098b, 0).getBoolean(str, false);
    }

    /* renamed from: b */
    public static boolean m16683b(String str, boolean z) {
        if (f12097a == null) {
            return false;
        }
        return f12097a.getSharedPreferences(f12098b, 0).getBoolean(str, z);
    }

    /* renamed from: c */
    public static int m16684c(String str) {
        if (f12097a == null) {
            return 0;
        }
        return f12097a.getSharedPreferences(f12098b, 0).getInt(str, 0);
    }

    /* renamed from: b */
    public static int m16681b(String str, int i) {
        if (f12097a == null) {
            return 0;
        }
        return f12097a.getSharedPreferences(f12098b, 0).getInt(str, i);
    }

    /* renamed from: d */
    public static long m16685d(String str) {
        if (f12097a == null) {
            return 0;
        }
        return f12097a.getSharedPreferences(f12098b, 0).getLong(str, 0);
    }

    /* renamed from: a */
    public static void m16678a(String str, long j) {
        if (f12097a != null) {
            Editor edit = f12097a.getSharedPreferences(f12098b, 0).edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }
}
