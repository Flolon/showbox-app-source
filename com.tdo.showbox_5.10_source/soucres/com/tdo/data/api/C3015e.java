package com.tdo.showbox.data.api;

import android.content.Context;
import android.util.Base64;
import com.tdo.showbox.p131f.C3185k;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.p143b.p144a.C3487c;
import org.p143b.p144a.C3488e;
import org.p143b.p144a.C3489f;

/* compiled from: OpenSubApi */
/* renamed from: com.tdo.showbox.data.api.e */
public class C3015e {
    /* renamed from: a */
    private C3487c f11887a = new C3487c(this.f11888b);
    /* renamed from: b */
    private URI f11888b = URI.create(this.f11889c);
    /* renamed from: c */
    private String f11889c = "http://api.opensubtitles.org/xml-rpc";
    /* renamed from: d */
    private String f11890d = "ShowBox";
    /* renamed from: e */
    private String f11891e = "LogIn";
    /* renamed from: f */
    private String f11892f = "SearchSubtitles";
    /* renamed from: g */
    private String f11893g = "DownloadSubtitles";
    /* renamed from: h */
    private Context f11894h;

    /* compiled from: OpenSubApi */
    /* renamed from: com.tdo.showbox.data.api.e$a */
    public interface C3012a {
        /* renamed from: a */
        void mo2090a(Object obj);

        /* renamed from: a */
        void mo2091a(String str, String str2);
    }

    /* compiled from: OpenSubApi */
    /* renamed from: com.tdo.showbox.data.api.e$b */
    private class C3014b extends Thread {
        /* renamed from: a */
        final /* synthetic */ C3015e f11883a;
        /* renamed from: b */
        private String f11884b;
        /* renamed from: c */
        private Object[] f11885c;
        /* renamed from: d */
        private C3012a f11886d;

        public C3014b(C3015e c3015e, String str, C3012a c3012a) {
            this.f11883a = c3015e;
            this.f11884b = str;
            this.f11886d = c3012a;
        }

        /* renamed from: a */
        public void m16389a(Object[] objArr) {
            this.f11885c = objArr;
            start();
        }

        public void run() {
            try {
                Object a = this.f11883a.f11887a.m17867a(this.f11884b, this.f11885c);
                if (this.f11886d != null) {
                    this.f11886d.mo2090a(a);
                }
            } catch (C3489f e) {
                if (this.f11886d != null) {
                    this.f11886d.mo2091a(e.m17868a(), "" + e.m17869b());
                }
            } catch (C3488e e2) {
                if (this.f11886d != null) {
                    this.f11886d.mo2091a(e2.getMessage(), "-1");
                }
            }
        }
    }

    public C3015e(Context context) {
        this.f11894h = context;
    }

    /* renamed from: a */
    public void m16393a(String str, String str2, String str3, String str4, C3012a c3012a) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(str3);
        arrayList.add(str4);
        new C3014b(this, this.f11891e, c3012a).m16389a(arrayList.toArray());
    }

    /* renamed from: a */
    public void m16392a(final Context context, String str, final String str2, final C3012a c3012a) {
        m16395a(str, new String[]{str2}, new C3012a(this) {
            /* renamed from: d */
            final /* synthetic */ C3015e f11882d;

            /* renamed from: a */
            public void mo2090a(Object obj) {
                String str;
                try {
                    Object obj2 = ((HashMap) obj).get("data");
                    if (obj2 instanceof Object[]) {
                        str = (String) ((HashMap) ((Object[]) obj2)[0]).get("data");
                        try {
                            File file = new File(context.getExternalFilesDir(null), "" + System.currentTimeMillis());
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            C3185k.m16987a(Base64.decode(str, 0), new File(file, str2 + ".srt").getAbsolutePath());
                            c3012a.mo2090a(file.getAbsolutePath());
                            return;
                        } catch (Exception e) {
                            c3012a.mo2091a("", "");
                        }
                    }
                    throw new Exception();
                } catch (Exception e2) {
                    if (obj != null) {
                        str = ("" + obj.toString()).toLowerCase();
                        if ((str.contains("407") && str.contains("data=false")) || str.contains("download limit reached")) {
                            c3012a.mo2091a("", "407");
                            return;
                        }
                    }
                    c3012a.mo2091a("", "");
                }
            }

            /* renamed from: a */
            public void mo2091a(String str, String str2) {
                c3012a.mo2091a("", "");
            }
        });
    }

    /* renamed from: a */
    public void m16394a(String str, String str2, String[] strArr, String str3, String str4, C3012a c3012a) {
        if (str4 == null || str3 == null) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            Map hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder(strArr[0].toLowerCase());
            for (int i = 1; i < strArr.length; i++) {
                stringBuilder.append(',').append(strArr[i].toLowerCase());
            }
            hashMap.put("sublanguageid", stringBuilder.toString());
            hashMap.put("imdbid", str2);
            arrayList2.add(hashMap);
            arrayList.add(str);
            arrayList.add(arrayList2);
            new C3014b(this, this.f11892f, c3012a).m16389a(arrayList.toArray());
            return;
        }
        m16391b(str, str2, strArr, str3, str4, c3012a);
    }

    /* renamed from: b */
    private void m16391b(String str, String str2, String[] strArr, String str3, String str4, C3012a c3012a) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Map hashMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder(strArr[0].toLowerCase());
        for (int i = 1; i < strArr.length; i++) {
            stringBuilder.append(',').append(strArr[i].toLowerCase());
        }
        hashMap.put("sublanguageid", stringBuilder.toString());
        hashMap.put("imdbid", str2);
        hashMap.put("season", str3);
        hashMap.put("episode", str4);
        arrayList2.add(hashMap);
        arrayList.add(str);
        arrayList.add(arrayList2);
        new C3014b(this, this.f11892f, c3012a).m16389a(arrayList.toArray());
    }

    /* renamed from: a */
    public void m16395a(String str, String[] strArr, C3012a c3012a) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Map hashMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuilder.append(',').append(strArr[i]);
        }
        hashMap.put("data", stringBuilder.toString());
        arrayList2.add(stringBuilder.toString());
        arrayList.add(str);
        arrayList.add(arrayList2);
        new C3014b(this, this.f11893g, c3012a).m16389a(arrayList.toArray());
    }
}
