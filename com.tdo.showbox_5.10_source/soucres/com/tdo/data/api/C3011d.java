package com.tdo.showbox.data.api;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: LoadTask */
/* renamed from: com.tdo.showbox.data.api.d */
public class C3011d extends Thread {
    /* renamed from: a */
    private String f11875a;
    /* renamed from: b */
    private String f11876b;
    /* renamed from: c */
    private C2625a f11877c;
    /* renamed from: d */
    private boolean f11878d;

    /* compiled from: LoadTask */
    /* renamed from: com.tdo.showbox.data.api.d$a */
    public interface C2625a {
        /* renamed from: a */
        void mo1993a();

        /* renamed from: a */
        void mo1994a(int i);

        /* renamed from: a */
        void mo1995a(String str);

        /* renamed from: b */
        void mo1996b();
    }

    public C3011d(String str, String str2, C2625a c2625a) {
        this.f11875a = str;
        this.f11876b = str2;
        this.f11877c = c2625a;
    }

    /* renamed from: a */
    protected void m16384a(Integer... numArr) {
        if (this.f11877c != null) {
            this.f11877c.mo1994a(numArr[0].intValue());
        }
    }

    public void run() {
        super.run();
        try {
            if (m16381b()) {
                m16383a();
                return;
            }
            URL url = new URL(this.f11875a);
            URLConnection openConnection = url.openConnection();
            openConnection.connect();
            if (m16381b()) {
                m16383a();
                return;
            }
            int contentLength = openConnection.getContentLength();
            InputStream bufferedInputStream = new BufferedInputStream(url.openStream());
            File file = new File(this.f11876b);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            long j = 0;
            do {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    j += (long) read;
                    m16384a(Integer.valueOf((int) ((100 * j) / ((long) contentLength))));
                    fileOutputStream.write(bArr, 0, read);
                    Thread.sleep(10);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    bufferedInputStream.close();
                    m16383a();
                    return;
                }
            } while (!m16381b());
            m16383a();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.f11877c != null) {
                this.f11877c.mo1995a("");
            }
        }
    }

    /* renamed from: b */
    private boolean m16381b() {
        if (!this.f11878d) {
            return false;
        }
        m16382c();
        return true;
    }

    public void interrupt() {
        this.f11878d = true;
    }

    /* renamed from: c */
    private void m16382c() {
        try {
            new File(this.f11876b).delete();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    protected void m16383a() {
        if (this.f11877c == null) {
            return;
        }
        if (this.f11878d) {
            this.f11877c.mo1996b();
        } else {
            this.f11877c.mo1993a();
        }
    }
}
