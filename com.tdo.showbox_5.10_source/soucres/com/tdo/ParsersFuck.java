package com.tdo.showbox;

import android.content.Context;

public class ParsersFuck {
    public static native int checksign(byte[] bArr);

    public static native void cms(String str, Context context);

    public static native String dmo(byte[] bArr, byte[] bArr2, byte[] bArr3, Context context, byte[] bArr4, byte[] bArr5, byte[] bArr6);

    public static native String dmoon(byte[] bArr, Context context);

    public static native String dmoonol(byte[] bArr, Context context);

    public static native String dmvold(byte[] bArr, Context context);

    public static native void init();

    public static native int settok(byte[] bArr);

    public static native void var(Context context);

    static {
        System.loadLibrary("video");
    }
}
