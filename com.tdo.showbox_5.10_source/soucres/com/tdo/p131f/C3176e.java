package com.tdo.showbox.p131f;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Environment;
import com.activeandroid.Cache;
import com.tdo.showbox.R;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.models.CatCRTorrentItem;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;

/* compiled from: IoUtils */
/* renamed from: com.tdo.showbox.f.e */
public class C3176e {
    /* renamed from: a */
    public static long m16965a() {
        return Environment.getDataDirectory().getUsableSpace();
    }

    /* renamed from: a */
    public static boolean m16969a(CatCRTorrentItem catCRTorrentItem, Activity activity) {
        long size = (long) (((double) catCRTorrentItem.getSize()) * 1.2d);
        long a = C3176e.m16965a();
        C3094j.m16698a("IoUtils", "torrentSize: " + size);
        C3094j.m16698a("IoUtils", "freeSize: " + a);
        if (size <= a) {
            return true;
        }
        Builder builder = new Builder(activity);
        builder.setMessage(R.string.alert_torrent_size);
        builder.setPositiveButton(R.string.cancel, null);
        builder.show();
        return false;
    }

    /* renamed from: a */
    public static void m16968a(File file) {
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                C3176e.m16968a(a);
            }
        }
        file.delete();
    }

    /* renamed from: a */
    public static File m16966a(String str, InputStream inputStream) throws IOException {
        File file = new File(str);
        try {
            file.createNewFile();
            OutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[Cache.DEFAULT_CACHE_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m16967a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        Object stringWriter = new StringWriter();
        char[] cArr = new char[16384];
        try {
            Reader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 65535);
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read == -1) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            return stringWriter.toString();
        } finally {
            inputStream.close();
        }
    }

    /* renamed from: b */
    public static byte[] m16970b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (Exception e) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
