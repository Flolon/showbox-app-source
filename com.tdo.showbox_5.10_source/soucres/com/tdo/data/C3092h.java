package com.tdo.showbox.data;

import android.content.Context;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Base64;
import com.tdo.showbox.ParsersFuck;
import java.util.Calendar;

/* compiled from: SeS */
/* renamed from: com.tdo.showbox.data.h */
public class C3092h {
    /* renamed from: a */
    public String m16692a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toCharsString();
        } catch (Throwable th) {
            return "cxvdf497f890mjked";
        }
    }

    /* renamed from: b */
    public String m16693b(Context context) {
        String a = C3088f.m16675a("crs_to");
        if (TextUtils.isEmpty(a)) {
            try {
                a = Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable th) {
            }
        }
        if (TextUtils.isEmpty(a)) {
            a = "r,s9fjksimjJKJHHFGBFBN*ON&*(M)_KJHHHHHHHHHHHHHHHHHHHT*^N)MK(==";
        }
        return new String(Base64.encode(a.getBytes(), 0));
    }

    /* renamed from: c */
    public String m16694c(Context context) {
        return "" + ParsersFuck.checksign(("__" + System.nanoTime() + "__*__").getBytes());
    }

    /* renamed from: d */
    public String m16695d(Context context) {
        try {
            CharSequence a = C3088f.m16675a("crs_to");
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 128).versionName;
            if (TextUtils.isEmpty(a)) {
                int i = Calendar.getInstance().get(6);
                byte[] bArr = new byte[]{(byte) 12, (byte) 45, (byte) 21, (byte) 55, (byte) 78, (byte) 3, (byte) 2, (byte) 12, (byte) 56, (byte) 32, (byte) 8, (byte) 39, (byte) 74};
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    bArr[i2] = (byte) (bArr[i2] ^ i);
                }
                return str + new String(Base64.encode(bArr, 0));
            }
        } catch (Exception e) {
        }
        return "dwk9f,0jkslcmx,cmx,vxlv,xkjvu49ef,ke,8fuy8e,fg904uk==";
    }
}
