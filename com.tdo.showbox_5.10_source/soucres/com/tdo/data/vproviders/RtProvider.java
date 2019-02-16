package com.tdo.showbox.data.vproviders;

import android.webkit.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RtProvider {
    /* renamed from: a */
    private static String f12237a = "providers";
    /* renamed from: b */
    private DexClassLoader f12238b;
    /* renamed from: c */
    private Object f12239c;
    /* renamed from: d */
    private RtProviderExtractor f12240d;
    /* renamed from: e */
    private RtMediaInfo f12241e = new RtMediaInfo();

    public interface RtProviderExtractor {
        /* renamed from: a */
        void mo2089a(RtMediaInfo rtMediaInfo);
    }

    /* renamed from: com.tdo.showbox.data.vproviders.RtProvider$1 */
    class C31631 implements InvocationHandler {
        /* renamed from: a */
        final /* synthetic */ RtProvider f12236a;

        C31631(RtProvider rtProvider) {
            this.f12236a = rtProvider;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!method.getName().equals("onExtract")) {
                return Integer.valueOf(-1);
            }
            Object obj2 = objArr[0];
            Field declaredField = obj2.getClass().getDeclaredField("url");
            declaredField.setAccessible(true);
            Object obj3 = declaredField.get(obj2);
            Field declaredField2 = obj2.getClass().getDeclaredField("cookies");
            declaredField2.setAccessible(true);
            obj2 = declaredField2.get(obj2);
            this.f12236a.f12241e.setUrl((String) obj3);
            this.f12236a.f12241e.setCookies((String) obj2);
            if (this.f12236a.f12240d != null) {
                this.f12236a.f12240d.mo2089a(this.f12236a.f12241e);
            }
            return Integer.valueOf(1);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RtProvider(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
        r6 = this;
        r5 = 0;
        r6.<init>();
        r0 = new com.tdo.showbox.data.vproviders.RtMediaInfo;
        r0.<init>();
        r6.f12241e = r0;
        if (r8 == 0) goto L_0x0018;
    L_0x000d:
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x0089 }
        r0.<init>(r8);	 Catch:{ Throwable -> 0x0089 }
        r0 = r0.exists();	 Catch:{ Throwable -> 0x0089 }
        if (r0 != 0) goto L_0x0061;
    L_0x0018:
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x0089 }
        r1 = 0;
        r1 = r7.getExternalFilesDir(r1);	 Catch:{ Throwable -> 0x0089 }
        r2 = f12237a;	 Catch:{ Throwable -> 0x0089 }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x0089 }
        r1 = r0.exists();	 Catch:{ Throwable -> 0x0089 }
        if (r1 != 0) goto L_0x002d;
    L_0x002a:
        r0.mkdirs();	 Catch:{ Throwable -> 0x0089 }
    L_0x002d:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x005d }
        r2 = "prov.enc";
        r1.<init>(r0, r2);	 Catch:{ Exception -> 0x005d }
        r0 = r1.exists();	 Catch:{ Exception -> 0x005d }
        if (r0 != 0) goto L_0x003d;
    L_0x003a:
        r1.createNewFile();	 Catch:{ Exception -> 0x005d }
    L_0x003d:
        r8 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x005d }
        r0 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x005d }
        r0.<init>(r8);	 Catch:{ Exception -> 0x005d }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x005d }
        r2 = r7.getAssets();	 Catch:{ Exception -> 0x005d }
        r2 = r2.open(r9);	 Catch:{ Exception -> 0x005d }
    L_0x0052:
        r3 = r2.read(r1);	 Catch:{ Exception -> 0x005d }
        if (r3 <= 0) goto L_0x007f;
    L_0x0058:
        r4 = 0;
        r0.write(r1, r4, r3);	 Catch:{ Exception -> 0x005d }
        goto L_0x0052;
    L_0x005d:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Throwable -> 0x0089 }
    L_0x0061:
        r0 = "dexProv";
        r1 = 0;
        r0 = r7.getDir(r0, r1);	 Catch:{ Throwable -> 0x0089 }
        r6.m16888a(r0);	 Catch:{ Throwable -> 0x0089 }
        r0.mkdirs();	 Catch:{ Throwable -> 0x0089 }
        r1 = new dalvik.system.DexClassLoader;	 Catch:{ Throwable -> 0x0089 }
        r0 = r0.getAbsolutePath();	 Catch:{ Throwable -> 0x0089 }
        r2 = 0;
        r3 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ Throwable -> 0x0089 }
        r1.<init>(r8, r0, r2, r3);	 Catch:{ Throwable -> 0x0089 }
        r6.f12238b = r1;	 Catch:{ Throwable -> 0x0089 }
    L_0x007e:
        return;
    L_0x007f:
        r2.close();	 Catch:{ Exception -> 0x005d }
        r0.flush();	 Catch:{ Exception -> 0x005d }
        r0.close();	 Catch:{ Exception -> 0x005d }
        goto L_0x0061;
    L_0x0089:
        r0 = move-exception;
        r6.f12238b = r5;
        goto L_0x007e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdo.showbox.data.vproviders.RtProvider.<init>(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    private void m16888a(File file) {
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                m16888a(a);
            }
        }
        file.delete();
    }

    /* renamed from: a */
    public void m16891a(WebView webView, String str, String str2, RtProviderExtractor rtProviderExtractor) {
        if (this.f12238b != null) {
            try {
                this.f12240d = rtProviderExtractor;
                this.f12239c = this.f12238b.loadClass(str2).getConstructor(new Class[]{WebView.class}).newInstance(new Object[]{webView});
                Object newProxyInstance = Proxy.newProxyInstance(this.f12238b.loadClass("com.rtprovider.IExtractor").getClassLoader(), new Class[]{r0}, new C31631(this));
                this.f12239c.getClass().getMethod("extract", new Class[]{r0, String.class}).invoke(this.f12239c, new Object[]{newProxyInstance, str});
            } catch (Throwable th) {
                if (this.f12240d != null) {
                    this.f12240d.mo2089a(this.f12241e);
                }
            }
        } else if (rtProviderExtractor != null) {
            rtProviderExtractor.mo2089a(new RtMediaInfo());
        }
    }

    /* renamed from: a */
    public void m16890a() {
        this.f12240d = null;
        try {
            this.f12239c.getClass().getMethod("destroy", new Class[0]).invoke(this.f12239c, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
