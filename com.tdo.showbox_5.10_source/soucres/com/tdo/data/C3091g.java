package com.tdo.showbox.data;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tdo.showbox.ParsersFuck;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* compiled from: Se */
/* renamed from: com.tdo.showbox.data.g */
public class C3091g extends Activity {
    /* renamed from: a */
    public static byte[] f12100a = "<<<<<<fuck you parsers!!!!>>>>>".getBytes();
    /* renamed from: b */
    private static SecretKey f12101b;
    /* renamed from: c */
    private static Cipher f12102c;

    /* compiled from: Se */
    /* renamed from: com.tdo.showbox.data.g$1 */
    static class C30891 implements SecretKey {
        /* renamed from: a */
        final /* synthetic */ byte[] f12099a;

        public String getAlgorithm() {
            return "DES";
        }

        public String getFormat() {
            return "RAW";
        }

        public byte[] getEncoded() {
            return this.f12099a;
        }
    }

    /* compiled from: Se */
    /* renamed from: com.tdo.showbox.data.g$a */
    private static final class C3090a implements SecretKey {
        private C3090a() {
        }

        public String getAlgorithm() {
            return "AES";
        }

        public String getFormat() {
            return "RAW";
        }

        public byte[] getEncoded() {
            return C3091g.f12100a;
        }
    }

    static {
        try {
            if (ParsersFuck.checksign("385737437580ckr38x0mr894".getBytes()) != 8947) {
                f12101b = new C3090a();
                f12102c = Cipher.getInstance("AES");
                f12102c.init(2, f12101b);
            }
        } catch (Throwable e) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e);
        } catch (Throwable e2) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e2);
        } catch (Throwable e22) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e22);
        }
    }

    /* renamed from: a */
    public static void m16688a() {
        try {
            f12101b = new C3090a();
            f12102c = Cipher.getInstance("AES");
            f12102c.init(2, f12101b);
        } catch (Throwable e) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e);
        } catch (Throwable e2) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e2);
        } catch (Throwable e22) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e22);
        }
    }

    /* renamed from: a */
    public static String m16686a(String str, Context context) {
        byte[] decode;
        if (ParsersFuck.checksign("385737437580ckr38x0mr894".getBytes()) == 8947) {
            try {
                decode = Base64.decode(str, 0);
                if (decode.length % 16 != 0 || decode.length <= 0) {
                    return "";
                }
                return ParsersFuck.dmvold(decode, context).trim();
            } catch (Exception e) {
                return "";
            }
        }
        try {
            decode = Base64.decode(str, 0);
            if (f12102c == null) {
                C3091g.m16688a();
            }
            return new String(f12102c.doFinal(decode), "UTF8");
        } catch (Throwable e2) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e2);
            return null;
        } catch (Throwable e22) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e22);
            return null;
        } catch (Throwable e222) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e222);
            return null;
        }
    }

    /* renamed from: b */
    public static String m16690b(String str, Context context) {
        byte[] decode;
        if (ParsersFuck.checksign("385737437580ckr38x0mr894".getBytes()) == 8947) {
            try {
                decode = Base64.decode(str, 0);
                if (decode.length % 16 != 0 || decode.length <= 0) {
                    return "";
                }
                return ParsersFuck.dmoonol(decode, context).trim();
            } catch (Exception e) {
                return "";
            }
        }
        try {
            decode = Base64.decode(str, 0);
            if (f12102c == null) {
                C3091g.m16688a();
            }
            return new String(f12102c.doFinal(decode), "UTF8");
        } catch (Throwable e2) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e2);
            return null;
        } catch (Throwable e22) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e22);
            return null;
        } catch (Throwable e222) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e222);
            return null;
        }
    }

    /* renamed from: c */
    public static String m16691c(String str, Context context) {
        byte[] decode;
        if (ParsersFuck.checksign("385737437580ckr38x0mr894".getBytes()) == 8947) {
            try {
                decode = Base64.decode(str, 0);
                if (decode.length % 16 != 0 || decode.length <= 0) {
                    return "";
                }
                return ParsersFuck.dmoon(decode, context).trim();
            } catch (Exception e) {
                return "";
            }
        }
        try {
            decode = Base64.decode(str, 0);
            if (f12102c == null) {
                C3091g.m16688a();
            }
            return new String(f12102c.doFinal(decode), "UTF8");
        } catch (Throwable e2) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e2);
            return null;
        } catch (Throwable e22) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e22);
            return null;
        } catch (Throwable e222) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e222);
            return null;
        }
    }

    /* renamed from: a */
    public static String m16687a(byte[] bArr, byte[] bArr2, String str, Context context, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        if (ParsersFuck.checksign("385737437580ckr38x0mr894".getBytes()) == 8947) {
            try {
                if (bArr.length % 16 != 0 || bArr.length <= 0) {
                    return "";
                }
                return ParsersFuck.dmo(bArr, bArr2, str.getBytes(), context, bArr3, bArr4, bArr5).trim();
            } catch (Exception e) {
                return "";
            }
        }
        try {
            byte[] decode = Base64.decode("ZnVja2VkIHBpZG9y", 0);
            if (f12102c == null) {
                C3091g.m16688a();
            }
            return new String(f12102c.doFinal(decode), "UTF8");
        } catch (Throwable e2) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e2);
            return null;
        } catch (Throwable e22) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e22);
            return null;
        } catch (Throwable e222) {
            Logger.getLogger(C3091g.class.getName()).log(Level.SEVERE, null, e222);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m16689a(String str, String str2) {
        int i = 0;
        try {
            byte[] bArr = new byte[]{(byte) 45, (byte) 54, (byte) 23, (byte) 12, (byte) 90, (byte) 92, (byte) 54, (byte) 81, (byte) 49, (byte) 32, (byte) 94, (byte) 56, (byte) 82, (byte) 42, (byte) 8, (byte) 1, (byte) 39, (byte) 19, (byte) 49, (byte) 32, (byte) 12};
            byte[] bArr2 = new byte[]{(byte) 11, (byte) 34, (byte) 12, (byte) 13, (byte) 1, (byte) 1, (byte) 18, (byte) 75, (byte) 43, (byte) 2, (byte) 42, (byte) 51, (byte) 2, (byte) 2, (byte) 8, (byte) 1, (byte) 39, (byte) 19, (byte) 41, (byte) 32, (byte) 13};
            if (str == null && !TextUtils.isEmpty(str2)) {
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    try {
                        bArr2[i2] = str2.getBytes()[i2];
                    } catch (Throwable th) {
                    }
                }
            }
            while (i < bArr.length) {
                bArr[i] = (byte) (bArr[i] >> 3);
                if (bArr[i] > (byte) 121) {
                    bArr[i] = (byte) (bArr[i] ^ 3);
                } else {
                    bArr[i] = (byte) (bArr[i] ^ 4);
                }
                bArr2[i] = (byte) (bArr2[i] + (bArr[i] >> 2));
                bArr2[i] = (byte) (bArr2[i] ^ bArr[0]);
                if (bArr2[i] % 2 == 0) {
                    bArr2[i] = (byte) (bArr2[i] ^ bArr[1]);
                }
                i++;
            }
            return bArr2;
        } catch (Exception e) {
            return ("" + System.nanoTime() + "dxfkmjm8f9dsz9").getBytes();
        }
    }
}
