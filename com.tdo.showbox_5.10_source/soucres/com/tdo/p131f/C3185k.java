package com.tdo.showbox.p131f;

import com.activeandroid.Cache;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: ZipUtils */
/* renamed from: com.tdo.showbox.f.k */
public class C3185k {
    /* renamed from: a */
    public static byte[] m16990a(String str) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return toByteArray;
    }

    /* renamed from: a */
    public static String m16988a(byte[] bArr) throws IOException {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 32);
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bArr2 = new byte[32];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                stringBuilder.append(new String(bArr2, 0, read));
            } else {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return stringBuilder.toString();
            }
        }
    }

    /* renamed from: a */
    public static File m16987a(byte[] bArr, String str) throws IOException {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 32);
        File file = new File(str);
        try {
            file.createNewFile();
            OutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr2 = new byte[Cache.DEFAULT_CACHE_SIZE];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    fileOutputStream.write(bArr2, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    byteArrayInputStream.close();
                    return file;
                }
            }
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m16989a(String str, String str2) throws IOException {
        byte[] bArr = new byte[4096];
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream;
        try {
            if (!str2.endsWith("/")) {
                str2 = str2 + "/";
            }
            File file = new File(str2);
            if (!file.isDirectory()) {
                file.mkdirs();
            }
            zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str), 4096));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    File file2 = new File(str2 + nextEntry.getName());
                    if (!nextEntry.isDirectory()) {
                        File parentFile = file2.getParentFile();
                        if (!(parentFile == null || parentFile.isDirectory())) {
                            parentFile.mkdirs();
                        }
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, false), 4096);
                        while (true) {
                            int read = zipInputStream.read(bArr, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        zipInputStream.closeEntry();
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    } else if (!file2.isDirectory()) {
                        file2.mkdirs();
                    }
                } else {
                    zipInputStream.close();
                    return;
                }
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            zipInputStream.close();
        }
    }
}
