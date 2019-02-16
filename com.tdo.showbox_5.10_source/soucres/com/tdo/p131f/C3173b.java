package com.tdo.showbox.p131f;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: FormatterUtils */
/* renamed from: com.tdo.showbox.f.b */
public class C3173b {
    /* renamed from: a */
    public static String m16956a(long j) {
        if (j <= 0) {
            return "0";
        }
        int log10 = (int) (Math.log10((double) j) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(((double) j) / Math.pow(1024.0d, (double) log10)) + " " + new String[]{"B", "kB", "Mb", "Gb", "Tb"}[log10];
    }

    /* renamed from: a */
    public static String m16957a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            str = new SimpleDateFormat("dd MMM yyyy").format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
        }
        return str;
    }

    /* renamed from: b */
    public static String m16958b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            str = new SimpleDateFormat("dd MMM yyyy").format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
        }
        return str;
    }
}
