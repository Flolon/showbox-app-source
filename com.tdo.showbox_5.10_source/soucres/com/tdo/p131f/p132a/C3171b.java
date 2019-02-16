package com.tdo.showbox.p131f.p132a;

import android.app.Activity;
import java.lang.reflect.Array;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;

/* compiled from: Se */
/* renamed from: com.tdo.showbox.f.a.b */
public class C3171b extends Activity {
    /* renamed from: a */
    public static byte[] f12271a = "<<<<<<fuck you parsers!!!!>>>>>".getBytes();
    /* renamed from: b */
    private static SecretKey f12272b;

    /* compiled from: Se */
    /* renamed from: com.tdo.showbox.f.a.b$1 */
    static class C31691 implements SecretKey {
        /* renamed from: a */
        final /* synthetic */ byte[] f12270a;

        public String getAlgorithm() {
            return "DES";
        }

        public String getFormat() {
            return "RAW";
        }

        public byte[] getEncoded() {
            return this.f12270a;
        }
    }

    /* compiled from: Se */
    /* renamed from: com.tdo.showbox.f.a.b$a */
    private static final class C3170a implements SecretKey {
        private C3170a() {
        }

        public String getAlgorithm() {
            return "AES";
        }

        public String getFormat() {
            return "RAW";
        }

        public byte[] getEncoded() {
            return C3171b.f12271a;
        }
    }

    static {
        try {
            f12272b = new C3170a();
        } catch (Throwable e) {
            Logger.getLogger(C3171b.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /* renamed from: a */
    public static int m16953a(String str) {
        int i;
        int hashCode = str.hashCode();
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{100, 100});
        String str2 = "" + ((((double) 18343) / ((double) hashCode)) * 0.23d);
        for (int i2 = 0; i2 < 100; i2++) {
            for (i = 0; i < 100; i++) {
                iArr[i2][i] = ((i + i2) + 89) + ((int) (((double) hashCode) * 0.00123d));
                iArr[i][i2] = iArr[i2][i] >> 24;
                str2.replace((char) iArr[i2][i], (char) i);
            }
        }
        i = hashCode;
        for (hashCode = 0; hashCode < 30; hashCode++) {
            iArr[hashCode][hashCode] = iArr[hashCode][hashCode] >> 5;
            i = ((i - iArr[hashCode][0]) + 98) + Integer.valueOf(str2.getBytes()[0]).intValue();
        }
        return (str2.charAt(5) * 10) + str2.charAt(6);
    }
}
