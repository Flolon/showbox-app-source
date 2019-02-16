package com.tdo.showbox.p131f;

import android.os.Build.VERSION;
import com.tdo.showbox.data.C3094j;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* compiled from: PerformanceUtils */
/* renamed from: com.tdo.showbox.f.g */
public class C3180g {

    /* compiled from: PerformanceUtils */
    /* renamed from: com.tdo.showbox.f.g$a */
    class C3179a implements FileFilter {
        C3179a() {
        }

        public boolean accept(File file) {
            if (Pattern.matches("cpu[0-9]+", file.getName())) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m16974a() {
        int availableProcessors;
        try {
            availableProcessors = Runtime.getRuntime().availableProcessors();
        } catch (Exception e) {
            availableProcessors = 1;
        }
        if (availableProcessors == 1) {
            availableProcessors = C3180g.m16976c();
            C3094j.m16698a("getNumCores", "" + availableProcessors);
        }
        if (VERSION.SDK_INT > 18) {
            return false;
        }
        if (VERSION.SDK_INT >= 18 || r0 >= 2) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static int m16976c() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C3179a()).length;
        } catch (Exception e) {
            return 1;
        }
    }

    /* renamed from: b */
    public static boolean m16975b() {
        try {
            String property = System.getProperty("ro.product.cpu.abilist");
            if (property == null) {
                property = System.getProperty("os.arch");
            }
            return property.contains("86");
        } catch (Throwable th) {
            return false;
        }
    }
}
