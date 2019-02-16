package com.tdo.showbox.data.p112c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Images.Thumbnails;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import com.activeandroid.Cache;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.Thread.State;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.nio.Buffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ImageDownloader */
/* renamed from: com.tdo.showbox.data.c.a */
public class C3074a {
    /* renamed from: A */
    private boolean f12041A;
    /* renamed from: B */
    private String f12042B;
    /* renamed from: C */
    private String f12043C;
    /* renamed from: a */
    private int f12044a;
    /* renamed from: b */
    private int f12045b;
    /* renamed from: c */
    private HashMap<String, Bitmap> f12046c;
    /* renamed from: d */
    private HashMap<String, SoftReference<Bitmap>> f12047d;
    /* renamed from: e */
    private HashMap<String, Long> f12048e;
    /* renamed from: f */
    private File f12049f;
    /* renamed from: g */
    private C3072f f12050g;
    /* renamed from: h */
    private C3072f f12051h;
    /* renamed from: i */
    private C3071e f12052i;
    /* renamed from: j */
    private C3073g f12053j;
    /* renamed from: k */
    private SoftReference<Activity> f12054k;
    /* renamed from: l */
    private Bitmap f12055l;
    /* renamed from: m */
    private Drawable f12056m;
    /* renamed from: n */
    private int f12057n;
    /* renamed from: o */
    private int f12058o;
    /* renamed from: p */
    private ArrayList<String> f12059p;
    /* renamed from: q */
    private C3067a f12060q;
    /* renamed from: r */
    private C3067a f12061r;
    /* renamed from: s */
    private boolean f12062s;
    /* renamed from: t */
    private boolean f12063t;
    /* renamed from: u */
    private C2618c f12064u;
    /* renamed from: v */
    private C2754b f12065v;
    /* renamed from: w */
    private int f12066w;
    /* renamed from: x */
    private boolean f12067x;
    /* renamed from: y */
    private boolean f12068y;
    /* renamed from: z */
    private boolean f12069z;

    /* compiled from: ImageDownloader */
    /* renamed from: com.tdo.showbox.data.c.a$1 */
    class C30661 implements Comparator<File> {
        /* renamed from: a */
        final /* synthetic */ C3074a f12021a;

        C30661(C3074a c3074a) {
            this.f12021a = c3074a;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m16574a((File) obj, (File) obj2);
        }

        /* renamed from: a */
        public int m16574a(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    /* compiled from: ImageDownloader */
    /* renamed from: com.tdo.showbox.data.c.a$a */
    private final class C3067a extends AnimationSet {
        /* renamed from: a */
        final /* synthetic */ C3074a f12022a;

        public C3067a(C3074a c3074a, boolean z) {
            this.f12022a = c3074a;
            super(z);
        }

        public AnimationSet clone() {
            try {
                return super.clone();
            } catch (Exception e) {
                return null;
            }
        }
    }

    /* compiled from: ImageDownloader */
    /* renamed from: com.tdo.showbox.data.c.a$b */
    private final class C3068b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3074a f12023a;
        /* renamed from: b */
        private Bitmap f12024b;
        /* renamed from: c */
        private ImageView f12025c;
        /* renamed from: d */
        private boolean f12026d;

        public C3068b(C3074a c3074a, Bitmap bitmap, ImageView imageView, boolean z) {
            this.f12023a = c3074a;
            this.f12024b = bitmap;
            this.f12025c = imageView;
            this.f12026d = z;
        }

        public void run() {
            if (this.f12024b != null) {
                if (this.f12023a.f12065v != null) {
                    Object tag = this.f12025c.getTag();
                    if (!(tag == null || this.f12024b == this.f12023a.f12055l)) {
                        this.f12023a.f12065v.mo2035a((String) tag);
                    }
                }
                this.f12025c.setImageBitmap(this.f12024b);
                if (this.f12023a.f12060q != null && this.f12026d) {
                    this.f12025c.clearAnimation();
                    try {
                        this.f12025c.startAnimation(this.f12023a.f12060q.clone());
                    } catch (Exception e) {
                    }
                }
            } else if (this.f12023a.f12069z) {
                this.f12025c.setImageDrawable(this.f12023a.f12056m);
            } else {
                this.f12025c.setImageBitmap(this.f12023a.f12055l);
            }
        }
    }

    /* compiled from: ImageDownloader */
    /* renamed from: com.tdo.showbox.data.c.a$c */
    private final class C3069c implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3074a f12027a;
        /* renamed from: b */
        private Bitmap f12028b;
        /* renamed from: c */
        private ImageView f12029c;
        /* renamed from: d */
        private boolean f12030d;
        /* renamed from: e */
        private View f12031e;

        public C3069c(C3074a c3074a, Bitmap bitmap, ImageView imageView, View view, boolean z) {
            this.f12027a = c3074a;
            this.f12028b = bitmap;
            this.f12029c = imageView;
            this.f12030d = z;
            this.f12031e = view;
        }

        public void run() {
            if (this.f12028b != null) {
                if (this.f12027a.f12065v != null) {
                    Object tag = this.f12029c.getTag();
                    if (!(tag == null || this.f12028b == this.f12027a.f12055l)) {
                        this.f12027a.f12065v.mo2035a((String) tag);
                    }
                }
                if (!this.f12028b.isRecycled()) {
                    this.f12029c.setImageBitmap(this.f12028b);
                }
                this.f12029c.setVisibility(0);
                if (this.f12027a.f12060q != null && this.f12030d) {
                    this.f12029c.clearAnimation();
                    this.f12031e.clearAnimation();
                    try {
                        this.f12029c.startAnimation(this.f12027a.f12060q.clone());
                        this.f12031e.startAnimation(this.f12027a.f12061r.clone());
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            }
            this.f12029c.setVisibility(0);
            this.f12031e.setVisibility(4);
            if (!this.f12028b.isRecycled()) {
                if (this.f12027a.f12069z) {
                    this.f12029c.setImageDrawable(this.f12027a.f12056m);
                } else {
                    this.f12029c.setImageBitmap(this.f12027a.f12055l);
                }
            }
        }
    }

    /* compiled from: ImageDownloader */
    /* renamed from: com.tdo.showbox.data.c.a$d */
    private final class C3070d {
        /* renamed from: a */
        final /* synthetic */ C3074a f12032a;
        /* renamed from: b */
        private String f12033b;
        /* renamed from: c */
        private ImageView f12034c;
        /* renamed from: d */
        private int f12035d;
        /* renamed from: e */
        private View f12036e;

        public boolean equals(Object obj) {
            C3070d c3070d = (C3070d) obj;
            if (this.f12033b == null || !this.f12033b.equals(c3070d.m16576b())) {
                return false;
            }
            return true;
        }

        public C3070d(C3074a c3074a, String str, ImageView imageView, View view, int i) {
            this.f12032a = c3074a;
            this.f12033b = str;
            this.f12034c = imageView;
            this.f12035d = i;
            this.f12036e = view;
        }

        /* renamed from: a */
        public final View m16575a() {
            return this.f12036e;
        }

        /* renamed from: b */
        public final String m16576b() {
            return this.f12033b;
        }

        /* renamed from: c */
        public final ImageView m16577c() {
            return this.f12034c;
        }

        /* renamed from: d */
        public final int m16578d() {
            return this.f12035d;
        }
    }

    /* compiled from: ImageDownloader */
    /* renamed from: com.tdo.showbox.data.c.a$e */
    private final class C3071e extends Thread {
        /* renamed from: a */
        final /* synthetic */ C3074a f12037a;

        private C3071e(C3074a c3074a) {
            this.f12037a = c3074a;
        }

        public void run() {
            do {
                try {
                    if (!Thread.interrupted()) {
                        if (this.f12037a.f12050g.m16581a().size() == 0) {
                            if (this.f12037a.f12051h.m16581a().size() != 0) {
                                System.gc();
                                this.f12037a.m16612d();
                            } else {
                                this.f12037a.m16614e();
                            }
                            synchronized (this.f12037a.f12050g.m16581a()) {
                                this.f12037a.f12050g.m16581a().wait();
                            }
                        }
                        if (!Thread.interrupted()) {
                            if (this.f12037a.f12050g.m16581a().size() != 0) {
                                C3070d c3070d;
                                Bitmap a;
                                synchronized (this.f12037a.f12050g.m16581a()) {
                                    try {
                                        c3070d = (C3070d) this.f12037a.f12050g.m16581a().removeLast();
                                    } catch (Exception e) {
                                        Thread.interrupted();
                                        c3070d = null;
                                    }
                                }
                                String b = c3070d.m16576b();
                                if (this.f12037a.f12065v != null) {
                                    this.f12037a.f12065v.mo2036b(b);
                                }
                                int d = c3070d.m16578d();
                                if (d == 2 || d == 3) {
                                    a = this.f12037a.m16606b(b, false);
                                } else if (d == 4) {
                                    a = this.f12037a.m16609c(b);
                                } else if (d == 5) {
                                    a = this.f12037a.m16593a(b, false);
                                } else if (d == 6) {
                                    a = this.f12037a.m16593a(b, true);
                                } else if (d == 0 || d == 1) {
                                    a = this.f12037a.m16592a(b, d);
                                } else {
                                    a = null;
                                }
                                String str = (String) c3070d.m16577c().getTag();
                                if ((a == null || a == this.f12037a.f12055l) && this.f12037a.f12065v != null) {
                                    this.f12037a.f12065v.mo2037c(b);
                                }
                                if (this.f12037a.f12058o == 0) {
                                    if (a != null) {
                                        this.f12037a.f12046c.put(b, a);
                                        this.f12037a.f12059p.add(b);
                                    }
                                    if (!(str == null || !str.equals(b) || a == null || this.f12037a.f12054k.get() == null || !(this.f12037a.f12054k.get() instanceof Activity))) {
                                        if (c3070d.m16575a() == null || this.f12037a.f12061r == null) {
                                            ((Activity) this.f12037a.f12054k.get()).runOnUiThread(new C3068b(this.f12037a, a, c3070d.m16577c(), true));
                                        } else {
                                            ((Activity) this.f12037a.f12054k.get()).runOnUiThread(new C3069c(this.f12037a, a, c3070d.m16577c(), c3070d.m16575a(), true));
                                        }
                                    }
                                } else {
                                    SoftReference softReference = new SoftReference(a);
                                    if (softReference.get() != null) {
                                        this.f12037a.f12047d.put(b, softReference);
                                    }
                                    if (!(str == null || !str.equals(b) || softReference.get() == null || this.f12037a.f12054k.get() == null || !(this.f12037a.f12054k.get() instanceof Activity))) {
                                        if (c3070d.m16575a() == null || this.f12037a.f12061r == null) {
                                            ((Activity) this.f12037a.f12054k.get()).runOnUiThread(new C3068b(this.f12037a, (Bitmap) softReference.get(), c3070d.m16577c(), true));
                                        } else {
                                            ((Activity) this.f12037a.f12054k.get()).runOnUiThread(new C3069c(this.f12037a, (Bitmap) softReference.get(), c3070d.m16577c(), c3070d.m16575a(), true));
                                        }
                                    }
                                }
                            } else if (this.f12037a.f12051h.m16581a().size() != 0) {
                                System.gc();
                                this.f12037a.m16612d();
                            } else {
                                this.f12037a.m16614e();
                            }
                        } else {
                            return;
                        }
                    }
                    return;
                } catch (Exception e2) {
                    return;
                }
            } while (!Thread.interrupted());
        }
    }

    /* compiled from: ImageDownloader */
    /* renamed from: com.tdo.showbox.data.c.a$f */
    private final class C3072f {
        /* renamed from: a */
        final /* synthetic */ C3074a f12038a;
        /* renamed from: b */
        private LinkedList<C3070d> f12039b = new LinkedList();

        public C3072f(C3074a c3074a) {
            this.f12038a = c3074a;
        }

        /* renamed from: a */
        public LinkedList<C3070d> m16581a() {
            return this.f12039b;
        }

        /* renamed from: a */
        public final void m16582a(C3070d c3070d) {
            if (!this.f12039b.contains(c3070d)) {
                if (this.f12039b.size() <= this.f12038a.f12045b) {
                    this.f12039b.addFirst(c3070d);
                } else if (this.f12039b.size() > 0) {
                    this.f12039b.remove(this.f12039b.size() - 1);
                    this.f12039b.addFirst(c3070d);
                }
            }
        }
    }

    /* compiled from: ImageDownloader */
    /* renamed from: com.tdo.showbox.data.c.a$g */
    private final class C3073g extends Thread {
        /* renamed from: a */
        final /* synthetic */ C3074a f12040a;

        private C3073g(C3074a c3074a) {
            this.f12040a = c3074a;
        }

        public void run() {
            do {
                try {
                    if (!Thread.interrupted()) {
                        if (this.f12040a.f12051h.m16581a().size() == 0) {
                            try {
                                Thread.interrupted();
                                return;
                            } catch (Exception e) {
                            }
                        }
                        if (!Thread.interrupted()) {
                            if (this.f12040a.f12051h.m16581a().size() != 0) {
                                C3070d c3070d;
                                synchronized (this.f12040a.f12051h.m16581a()) {
                                    try {
                                        c3070d = (C3070d) this.f12040a.f12050g.m16581a().remove(0);
                                    } catch (Exception e2) {
                                        Thread.interrupted();
                                        c3070d = null;
                                    }
                                }
                                String b = c3070d.m16576b();
                                Bitmap a = this.f12040a.m16606b(b, true);
                                String str = (String) c3070d.m16577c().getTag();
                                if (this.f12040a.f12058o == 0) {
                                    if (a != null) {
                                        this.f12040a.f12046c.put(b, a);
                                        this.f12040a.f12059p.add(b);
                                    }
                                    if (!(str == null || !str.equals(b) || a == null || this.f12040a.f12054k.get() == null || !(this.f12040a.f12054k.get() instanceof Activity))) {
                                        if (c3070d.m16575a() == null || this.f12040a.f12061r == null) {
                                            ((Activity) this.f12040a.f12054k.get()).runOnUiThread(new C3068b(this.f12040a, a, c3070d.m16577c(), false));
                                        } else {
                                            ((Activity) this.f12040a.f12054k.get()).runOnUiThread(new C3069c(this.f12040a, a, c3070d.m16577c(), c3070d.m16575a(), false));
                                        }
                                    }
                                } else {
                                    SoftReference softReference = new SoftReference(a);
                                    if (softReference.get() != null) {
                                        this.f12040a.f12047d.put(b, softReference);
                                    }
                                    if (!(str == null || !str.equals(b) || softReference.get() == null || this.f12040a.f12054k.get() == null || !(this.f12040a.f12054k.get() instanceof Activity))) {
                                        if (c3070d.m16575a() == null || this.f12040a.f12061r == null) {
                                            ((Activity) this.f12040a.f12054k.get()).runOnUiThread(new C3068b(this.f12040a, (Bitmap) softReference.get(), c3070d.m16577c(), false));
                                        } else {
                                            ((Activity) this.f12040a.f12054k.get()).runOnUiThread(new C3069c(this.f12040a, a, c3070d.m16577c(), c3070d.m16575a(), false));
                                        }
                                    }
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    return;
                } catch (Exception e3) {
                    return;
                }
            } while (!Thread.interrupted());
        }
    }

    public C3074a(Activity activity) {
        this(activity, C3074a.m16594a(activity), 200, 18, 1, true);
    }

    private C3074a(Activity activity, String str, int i, int i2, int i3, boolean z) {
        File file;
        this.f12044a = i;
        this.f12045b = i2;
        this.f12055l = null;
        this.f12069z = false;
        this.f12056m = null;
        this.f12057n = i3;
        this.f12058o = 0;
        this.f12060q = null;
        this.f12061r = null;
        this.f12062s = true;
        this.f12063t = true;
        this.f12067x = true;
        this.f12064u = null;
        this.f12066w = 7000;
        this.f12068y = false;
        this.f12054k = new SoftReference(activity);
        this.f12046c = new HashMap();
        this.f12050g = new C3072f(this);
        this.f12051h = new C3072f(this);
        this.f12047d = new HashMap();
        this.f12059p = new ArrayList();
        this.f12041A = false;
        if (z) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                this.f12049f = new File(str);
            } else {
                this.f12049f = activity.getCacheDir();
            }
            if (!this.f12049f.exists()) {
                this.f12049f.mkdirs();
            }
        } else {
            this.f12049f = new File(str);
            if (!this.f12049f.exists()) {
                this.f12049f.mkdirs();
            }
        }
        try {
            file = new File(this.f12049f, "" + this.f12057n);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
        }
        try {
            file = new File(this.f12049f, "mini");
            if (!file.exists()) {
                file.mkdir();
            }
            file = new File(this.f12049f, "micro");
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e2) {
        }
        this.f12048e = m16617f();
        this.f12052i = new C3071e();
        this.f12052i.setPriority(4);
        this.f12053j = new C3073g();
        this.f12053j.setPriority(4);
        m16619g();
    }

    /* renamed from: a */
    public final void m16635a(ImageView imageView, String str) {
        if (imageView != null && !this.f12041A) {
            m16596a(imageView, str, false, 2);
        }
    }

    /* renamed from: a */
    public final void m16634a(ImageView imageView, View view, String str) {
        if (imageView != null && view != null && !this.f12041A) {
            if (this.f12061r == null || this.f12060q == null) {
                m16601a("Animation error. Check yout image/stub animation or remove it!", null);
                m16596a(imageView, str, false, 2);
                return;
            }
            m16595a(imageView, view, str, false, 2);
        }
    }

    /* renamed from: a */
    public final void m16630a() {
        try {
            C3074a.m16597a(this.f12049f);
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public final void m16639b() {
        if (!this.f12041A) {
            this.f12041A = true;
            try {
                this.f12052i.interrupt();
                try {
                    this.f12052i.notifyAll();
                } catch (Exception e) {
                }
                Thread.sleep(100);
            } catch (Exception e2) {
            }
            m16614e();
            if (this.f12046c != null) {
                this.f12046c.clear();
            }
            if (this.f12047d != null) {
                this.f12047d.clear();
            }
            if (this.f12059p != null) {
                this.f12059p.clear();
            }
            m16603a(this.f12048e);
            if (this.f12048e != null) {
                this.f12048e.clear();
            }
            try {
                this.f12050g.m16581a().clear();
            } catch (Exception e3) {
            }
            this.f12050g.f12039b = null;
            try {
                this.f12051h.f12039b.clear();
            } catch (Exception e4) {
            }
            this.f12051h = null;
            this.f12052i = null;
            this.f12053j = null;
            this.f12059p = null;
            this.f12054k.clear();
            this.f12054k = null;
            this.f12046c = null;
            this.f12047d = null;
            this.f12048e = null;
            this.f12049f = null;
            System.gc();
        }
    }

    /* renamed from: c */
    public final void m16641c() {
        try {
            if (!this.f12041A) {
                this.f12046c.clear();
                this.f12047d.clear();
                this.f12059p.clear();
                m16603a(this.f12048e);
                this.f12048e.clear();
                System.gc();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m16631a(int i) {
        if (!this.f12041A) {
            this.f12057n = i;
            try {
                File file = new File(this.f12049f, "" + this.f12057n);
                if (!file.exists()) {
                    file.mkdir();
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    public final void m16640b(int i) {
        this.f12045b = i;
    }

    /* renamed from: a */
    public final void m16636a(C2754b c2754b) {
        this.f12065v = c2754b;
    }

    /* renamed from: a */
    public final String m16629a(String str) {
        if (this.f12041A) {
            return "";
        }
        File file;
        if (this.f12063t) {
            file = new File(this.f12049f, "/1/" + m16638b(str));
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            file = new File(this.f12049f, "/" + this.f12057n + "/" + m16638b(str));
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            return null;
        }
        file = new File(this.f12049f, "/" + this.f12057n + "/" + m16638b(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* renamed from: c */
    public final void m16642c(int i) {
        if (!this.f12041A) {
            this.f12058o = i;
        }
    }

    /* renamed from: d */
    public final void m16643d(int i) {
        if (!this.f12041A && this.f12054k.get() != null) {
            Drawable drawable = ((Activity) this.f12054k.get()).getResources().getDrawable(i);
            if (drawable instanceof BitmapDrawable) {
                this.f12055l = ((BitmapDrawable) drawable).getBitmap();
                this.f12069z = false;
                return;
            }
            this.f12069z = true;
            this.f12056m = drawable;
        }
    }

    /* renamed from: a */
    public final void m16637a(C2618c c2618c) {
        if (!this.f12041A) {
            this.f12064u = c2618c;
            this.f12067x = true;
        }
    }

    /* renamed from: a */
    public final void m16632a(AnimationSet animationSet) {
        if (!this.f12041A) {
            this.f12060q = m16607b(animationSet);
            this.f12061r = null;
        }
    }

    /* renamed from: a */
    public final void m16633a(AnimationSet animationSet, AnimationSet animationSet2) {
        if (!this.f12041A) {
            this.f12060q = m16607b(animationSet);
            this.f12061r = m16607b(animationSet2);
            if (this.f12061r != null) {
                this.f12061r.setFillAfter(true);
            }
        }
    }

    /* renamed from: a */
    private final void m16595a(ImageView imageView, View view, String str, boolean z, int i) {
        imageView.clearAnimation();
        view.clearAnimation();
        if (VERSION.SDK_INT < 16) {
            if (this.f12069z) {
                view.setBackgroundDrawable(this.f12056m);
            } else {
                view.setBackgroundDrawable(new BitmapDrawable(this.f12055l));
            }
        } else if (this.f12069z) {
            view.setBackground(this.f12056m);
        } else {
            view.setBackground(new BitmapDrawable(this.f12055l));
        }
        view.setVisibility(0);
        imageView.setVisibility(4);
        if (str != null && str.length() != 0) {
            imageView.setTag(str);
            if (this.f12058o == 0) {
                if (this.f12046c.get(str) != null) {
                    Bitmap bitmap = (Bitmap) this.f12046c.get(str);
                    if (bitmap.isRecycled()) {
                        m16600a(str, imageView, view, i);
                    } else {
                        imageView.setVisibility(0);
                        view.setVisibility(4);
                        imageView.setImageBitmap(bitmap);
                    }
                } else {
                    m16600a(str, imageView, view, i);
                }
            } else if (this.f12047d.get(str) == null || ((SoftReference) this.f12047d.get(str)).get() == null) {
                m16600a(str, imageView, view, i);
            } else {
                imageView.setImageBitmap((Bitmap) ((SoftReference) this.f12047d.get(str)).get());
            }
            if (z) {
                m16599a(str, imageView, view);
            }
        }
    }

    /* renamed from: a */
    private final void m16596a(ImageView imageView, String str, boolean z, int i) {
        imageView.clearAnimation();
        if (str == null) {
            if (this.f12069z) {
                imageView.setImageDrawable(this.f12056m);
            } else {
                imageView.setImageBitmap(this.f12055l);
            }
        } else if (str.length() != 0) {
            imageView.setTag(str);
            if (this.f12058o == 0) {
                if (this.f12046c.get(str) != null) {
                    Bitmap bitmap = (Bitmap) this.f12046c.get(str);
                    if (bitmap.isRecycled()) {
                        if (this.f12069z) {
                            imageView.setImageDrawable(this.f12056m);
                        } else {
                            imageView.setImageBitmap(this.f12055l);
                        }
                        m16600a(str, imageView, null, i);
                    } else {
                        imageView.setImageBitmap(bitmap);
                    }
                } else {
                    if (this.f12069z) {
                        imageView.setImageDrawable(this.f12056m);
                    } else {
                        imageView.setImageBitmap(this.f12055l);
                    }
                    m16600a(str, imageView, null, i);
                }
            } else if (this.f12047d.get(str) == null || ((SoftReference) this.f12047d.get(str)).get() == null) {
                if (this.f12069z) {
                    imageView.setImageDrawable(this.f12056m);
                } else {
                    imageView.setImageBitmap(this.f12055l);
                }
                m16600a(str, imageView, null, i);
            } else {
                imageView.setImageBitmap((Bitmap) ((SoftReference) this.f12047d.get(str)).get());
            }
            if (z) {
                m16599a(str, null, (View) imageView);
            }
        } else if (this.f12069z) {
            imageView.setImageDrawable(this.f12056m);
        } else {
            imageView.setImageBitmap(this.f12055l);
        }
    }

    /* renamed from: a */
    private final void m16600a(String str, ImageView imageView, View view, int i) {
        C3070d c3070d = new C3070d(this, str, imageView, view, i);
        synchronized (this.f12050g.m16581a()) {
            this.f12050g.m16582a(c3070d);
            this.f12050g.m16581a().notifyAll();
            m16614e();
        }
        try {
            if (this.f12052i.getState() == State.NEW) {
                this.f12052i.start();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private final void m16599a(String str, ImageView imageView, View view) {
        C3070d c3070d = new C3070d(this, str, imageView, view, 2);
        synchronized (this.f12051h.m16581a()) {
            this.f12051h.m16582a(c3070d);
        }
    }

    /* renamed from: d */
    private final void m16612d() {
        try {
            this.f12053j = new C3073g();
            this.f12053j.start();
        } catch (Exception e) {
        }
    }

    /* renamed from: e */
    private final void m16614e() {
        try {
            synchronized (this.f12051h.m16581a()) {
                this.f12051h.m16581a().clear();
                this.f12051h.f12039b.notifyAll();
            }
            this.f12053j.interrupt();
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    private final Bitmap m16609c(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        File file = new File(this.f12049f, "/" + this.f12057n + "/" + m16638b(str));
        Bitmap a;
        if (file.exists() && this.f12062s) {
            a = m16588a(file, 1);
            if (a != null) {
                return a;
            }
            return null;
        }
        a = m16588a(new File(str), this.f12057n);
        if (!(this.f12064u == null || a == null)) {
            a = m16589a(new File(str), a, this.f12057n);
        }
        if (a != null) {
            if (this.f12062s) {
                m16598a(file, a, 90, m16611d(str));
            }
            return a;
        } else if (this.f12058o == 0) {
            return null;
        } else {
            if (!this.f12069z) {
                return this.f12055l;
            }
            try {
                a = ((BitmapDrawable) this.f12056m).getBitmap();
            } catch (Exception e) {
                a = null;
            }
            return a;
        }
    }

    /* renamed from: a */
    private final Bitmap m16593a(String str, boolean z) {
        Bitmap bitmap = null;
        if (str == null || str.equals("") || this.f12054k.get() == null) {
            return bitmap;
        }
        File file = new File(this.f12049f, "/" + this.f12057n + "/" + m16638b(str));
        Bitmap a;
        if (file.exists() && this.f12062s) {
            try {
                a = m16588a(file, 1);
                if (a != null) {
                    return a;
                }
                return bitmap;
            } catch (Exception e) {
                return bitmap;
            }
        }
        InputStream openRawResource;
        if (z) {
            openRawResource = ((Activity) this.f12054k.get()).getResources().openRawResource(Integer.parseInt(str));
        } else {
            try {
                openRawResource = ((Activity) this.f12054k.get()).getAssets().open(str);
            } catch (Exception e2) {
                return bitmap;
            }
        }
        a = m16590a(openRawResource, this.f12057n);
        if (!(this.f12064u == null || a == null)) {
            a = m16589a(new File(""), a, this.f12057n);
        }
        if (a != null) {
            if (this.f12062s) {
                m16598a(file, a, 90, m16611d(str));
            }
            return a;
        } else if (this.f12058o == 0) {
            return bitmap;
        } else {
            if (!this.f12069z) {
                return this.f12055l;
            }
            try {
                a = ((BitmapDrawable) this.f12056m).getBitmap();
            } catch (Exception e3) {
                a = bitmap;
            }
            return a;
        }
    }

    /* renamed from: a */
    private final Bitmap m16592a(String str, int i) {
        Bitmap a;
        int i2;
        Bitmap bitmap;
        int size;
        int i3;
        if (str == null || str.equals("")) {
            return null;
        }
        File file = new File(this.f12049f, "/" + (i == 1 ? "mini" : "micro") + "/" + m16638b(str));
        if (file.exists() && this.f12062s) {
            a = m16588a(file, 1);
            if (a != null) {
                return a;
            }
            return null;
        }
        if (i == 1) {
            i2 = 1;
        } else {
            i2 = 3;
        }
        try {
            a = Thumbnails.getThumbnail(((Activity) this.f12054k.get()).getContentResolver(), Long.parseLong(str), i2, null);
            try {
                if (!(this.f12064u == null || a == null)) {
                    a = m16589a(new File(""), a, this.f12057n);
                }
            } catch (Exception e) {
            } catch (OutOfMemoryError e2) {
                bitmap = a;
                if (this.f12058o == 0) {
                    size = this.f12059p.size() / 7;
                    if (this.f12059p.size() > size) {
                        for (i3 = 0; i3 < size; i3++) {
                            this.f12046c.remove(this.f12059p.remove(0));
                        }
                        System.gc();
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e3) {
                        }
                        try {
                            a = Thumbnails.getThumbnail(((Activity) this.f12054k.get()).getContentResolver(), Long.parseLong(str), i2, null);
                            try {
                                a = m16589a(new File(""), a, this.f12057n);
                            } catch (Exception e4) {
                            } catch (OutOfMemoryError e5) {
                            }
                        } catch (Exception e6) {
                            a = bitmap;
                        } catch (OutOfMemoryError e7) {
                            a = bitmap;
                        }
                    }
                }
                a = bitmap;
            }
        } catch (Exception e8) {
            a = null;
        } catch (OutOfMemoryError e9) {
            bitmap = null;
            if (this.f12058o == 0) {
                size = this.f12059p.size() / 7;
                if (this.f12059p.size() > size) {
                    for (i3 = 0; i3 < size; i3++) {
                        this.f12046c.remove(this.f12059p.remove(0));
                    }
                    System.gc();
                    Thread.sleep(200);
                    a = Thumbnails.getThumbnail(((Activity) this.f12054k.get()).getContentResolver(), Long.parseLong(str), i2, null);
                    if (!(this.f12064u == null || a == null)) {
                        a = m16589a(new File(""), a, this.f12057n);
                    }
                }
            }
            a = bitmap;
        }
        if (a != null) {
            if (this.f12062s) {
                m16598a(file, a, 90, CompressFormat.JPEG);
            }
            return a;
        } else if (this.f12058o == 0) {
            return null;
        } else {
            if (!this.f12069z) {
                return this.f12055l;
            }
            try {
                a = ((BitmapDrawable) this.f12056m).getBitmap();
            } catch (Exception e10) {
                a = null;
            }
            return a;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final android.graphics.Bitmap m16606b(java.lang.String r11, boolean r12) {
        /*
        r10 = this;
        r8 = 0;
        r5 = 1;
        r2 = 0;
        if (r11 != 0) goto L_0x0007;
    L_0x0006:
        return r2;
    L_0x0007:
        r3 = new java.io.File;
        r0 = r10.f12049f;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "/";
        r1 = r1.append(r4);
        r4 = r10.f12057n;
        r1 = r1.append(r4);
        r4 = "/";
        r1 = r1.append(r4);
        r4 = r10.m16638b(r11);
        r1 = r1.append(r4);
        r1 = r1.toString();
        r3.<init>(r0, r1);
        r0 = r3.exists();
        if (r0 == 0) goto L_0x013b;
    L_0x0037:
        r0 = r10.f12062s;
        if (r0 == 0) goto L_0x013b;
    L_0x003b:
        if (r12 != 0) goto L_0x0045;
    L_0x003d:
        r0 = r10.m16588a(r3, r5);
        if (r0 == 0) goto L_0x013b;
    L_0x0043:
        r2 = r0;
        goto L_0x0006;
    L_0x0045:
        r0 = new java.net.URL;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r0.<init>(r11);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r0 = r0.openConnection();	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r10.m16602a(r0);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = r10.f12066w;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r0.setConnectTimeout(r1);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = r10.f12066w;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r0.setReadTimeout(r1);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = 1;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = "Last-Modified";
        r4 = 0;
        r4 = r0.getHeaderFieldDate(r1, r4);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = r10.f12048e;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = r1.containsKey(r11);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        if (r1 == 0) goto L_0x00f6;
    L_0x0071:
        r1 = r10.f12048e;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = r1.get(r11);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = (java.lang.Long) r1;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r6 = r1.longValue();	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r1 >= 0) goto L_0x0006;
    L_0x0081:
        r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r1 == 0) goto L_0x0006;
    L_0x0085:
        r1 = r10.f12048e;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1.put(r11, r4);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = new java.io.File;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r4 = r10.f12049f;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r5 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r5.<init>();	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r6 = "/1/";
        r5 = r5.append(r6);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r6 = r10.m16638b(r11);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r5 = r5.append(r6);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r5 = r5.toString();	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1.<init>(r4, r5);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r4 = r0.getInputStream();	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r4 = r10.m16604a(r1, r4);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        if (r4 == 0) goto L_0x00db;
    L_0x00b6:
        r0 = r10.f12057n;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r0 = r10.m16588a(r1, r0);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r4 = r10.f12064u;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        if (r4 == 0) goto L_0x00c8;
    L_0x00c0:
        if (r0 == 0) goto L_0x00c8;
    L_0x00c2:
        r4 = r10.f12057n;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r0 = r10.m16589a(r1, r0, r4);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
    L_0x00c8:
        r4 = 90;
        r5 = r10.m16611d(r11);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r10.m16598a(r3, r0, r4, r5);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r3 = r10.f12063t;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        if (r3 != 0) goto L_0x00d8;
    L_0x00d5:
        r1.delete();	 Catch:{ Exception -> 0x0204, SocketTimeoutException -> 0x0101 }
    L_0x00d8:
        r2 = r0;
        goto L_0x0006;
    L_0x00db:
        r1 = r0.getInputStream();	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r3 = r10.f12057n;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = r10.m16590a(r1, r3);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r3 = r10.f12064u;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        if (r3 == 0) goto L_0x0212;
    L_0x00e9:
        if (r1 == 0) goto L_0x0212;
    L_0x00eb:
        r0 = r0.getInputStream();	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r3 = r10.f12057n;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r0 = r10.m16591a(r0, r1, r3);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        goto L_0x00d8;
    L_0x00f6:
        r0 = r10.f12048e;	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        r0.put(r11, r1);	 Catch:{ SocketTimeoutException -> 0x0101, Exception -> 0x0121 }
        goto L_0x0006;
    L_0x0101:
        r0 = move-exception;
        r1 = "Timeout error. Check internet connection, image urls and server";
        r10.m16601a(r1, r0);
        r0 = r10.f12058o;
        if (r0 == 0) goto L_0x0006;
    L_0x010b:
        r0 = r10.f12069z;
        if (r0 == 0) goto L_0x011d;
    L_0x010f:
        r0 = r10.f12056m;	 Catch:{ Exception -> 0x011a }
        r0 = (android.graphics.drawable.BitmapDrawable) r0;	 Catch:{ Exception -> 0x011a }
        r0 = r0.getBitmap();	 Catch:{ Exception -> 0x011a }
    L_0x0117:
        r2 = r0;
        goto L_0x0006;
    L_0x011a:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0117;
    L_0x011d:
        r2 = r10.f12055l;
        goto L_0x0006;
    L_0x0121:
        r0 = move-exception;
        r10.m16601a(r2, r0);
        r0 = r10.f12058o;
        if (r0 == 0) goto L_0x0006;
    L_0x0129:
        r0 = r10.f12069z;
        if (r0 == 0) goto L_0x0137;
    L_0x012d:
        r0 = r10.f12056m;	 Catch:{ Exception -> 0x020f }
        r0 = (android.graphics.drawable.BitmapDrawable) r0;	 Catch:{ Exception -> 0x020f }
        r2 = r0.getBitmap();	 Catch:{ Exception -> 0x020f }
        goto L_0x0006;
    L_0x0137:
        r2 = r10.f12055l;
        goto L_0x0006;
    L_0x013b:
        r0 = new java.net.URL;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0.<init>(r11);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0 = r0.openConnection();	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r10.m16602a(r0);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r1 = r10.f12066w;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0.setConnectTimeout(r1);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r1 = r10.f12066w;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0.setReadTimeout(r1);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r1 = 1;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r1 = r0.getInputStream();	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0 = r10.f12062s;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        if (r0 == 0) goto L_0x01bb;
    L_0x015f:
        r4 = new java.io.File;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0 = r10.f12049f;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r5 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r5.<init>();	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r6 = "/1/";
        r5 = r5.append(r6);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r6 = r10.m16638b(r11);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r5 = r5.append(r6);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r5 = r5.toString();	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r4.<init>(r0, r5);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0 = r10.m16604a(r4, r1);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        if (r0 == 0) goto L_0x01a8;
    L_0x0183:
        r0 = r10.f12057n;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0 = r10.m16588a(r4, r0);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r1 = r10.f12064u;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        if (r1 == 0) goto L_0x0195;
    L_0x018d:
        if (r0 == 0) goto L_0x0195;
    L_0x018f:
        r1 = r10.f12057n;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0 = r10.m16589a(r4, r0, r1);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
    L_0x0195:
        r1 = 90;
        r5 = r10.m16611d(r11);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r10.m16598a(r3, r0, r1, r5);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r1 = r10.f12063t;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        if (r1 != 0) goto L_0x01a5;
    L_0x01a2:
        r4.delete();	 Catch:{ Exception -> 0x0207, SocketTimeoutException -> 0x01ce }
    L_0x01a5:
        r2 = r0;
        goto L_0x0006;
    L_0x01a8:
        r0 = r10.f12057n;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0 = r10.m16590a(r1, r0);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r3 = r10.f12064u;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        if (r3 == 0) goto L_0x01a5;
    L_0x01b2:
        if (r0 == 0) goto L_0x01a5;
    L_0x01b4:
        r3 = r10.f12057n;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0 = r10.m16591a(r1, r0, r3);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        goto L_0x01a5;
    L_0x01bb:
        r0 = r10.f12057n;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0 = r10.m16590a(r1, r0);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r3 = r10.f12064u;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        if (r3 == 0) goto L_0x01a5;
    L_0x01c5:
        if (r0 == 0) goto L_0x01a5;
    L_0x01c7:
        r3 = r10.f12057n;	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        r0 = r10.m16591a(r1, r0, r3);	 Catch:{ SocketTimeoutException -> 0x01ce, Exception -> 0x01ea }
        goto L_0x01a5;
    L_0x01ce:
        r0 = move-exception;
        r1 = "Timeout error. Check internet connection, image urls and server";
        r10.m16601a(r1, r0);
        r0 = r10.f12058o;
        if (r0 == 0) goto L_0x0006;
    L_0x01d8:
        r0 = r10.f12069z;
        if (r0 == 0) goto L_0x01e6;
    L_0x01dc:
        r0 = r10.f12056m;	 Catch:{ Exception -> 0x020c }
        r0 = (android.graphics.drawable.BitmapDrawable) r0;	 Catch:{ Exception -> 0x020c }
        r2 = r0.getBitmap();	 Catch:{ Exception -> 0x020c }
        goto L_0x0006;
    L_0x01e6:
        r2 = r10.f12055l;
        goto L_0x0006;
    L_0x01ea:
        r0 = move-exception;
        r10.m16601a(r2, r0);
        r0 = r10.f12058o;
        if (r0 == 0) goto L_0x0006;
    L_0x01f2:
        r0 = r10.f12069z;
        if (r0 == 0) goto L_0x0200;
    L_0x01f6:
        r0 = r10.f12056m;	 Catch:{ Exception -> 0x0209 }
        r0 = (android.graphics.drawable.BitmapDrawable) r0;	 Catch:{ Exception -> 0x0209 }
        r2 = r0.getBitmap();	 Catch:{ Exception -> 0x0209 }
        goto L_0x0006;
    L_0x0200:
        r2 = r10.f12055l;
        goto L_0x0006;
    L_0x0204:
        r1 = move-exception;
        goto L_0x00d8;
    L_0x0207:
        r1 = move-exception;
        goto L_0x01a5;
    L_0x0209:
        r0 = move-exception;
        goto L_0x0006;
    L_0x020c:
        r0 = move-exception;
        goto L_0x0006;
    L_0x020f:
        r0 = move-exception;
        goto L_0x0006;
    L_0x0212:
        r0 = r1;
        goto L_0x00d8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdo.showbox.data.c.a.b(java.lang.String, boolean):android.graphics.Bitmap");
    }

    /* renamed from: a */
    private void m16602a(HttpURLConnection httpURLConnection) {
        try {
            if (this.f12043C != null && this.f12042B != null) {
                String str = "Authorization";
                httpURLConnection.setRequestProperty(str, "Basic " + Base64.encodeToString((this.f12043C + ":" + this.f12042B).getBytes(), 2));
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private final void m16598a(File file, Bitmap bitmap, int i, CompressFormat compressFormat) {
        if (bitmap != null) {
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(compressFormat, i, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(toByteArray);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e) {
                m16601a("Storage error during IO operation. Please check your storage where placed cache folder", e);
            } catch (OutOfMemoryError e2) {
            } catch (Exception e3) {
            }
        }
    }

    /* renamed from: d */
    private final CompressFormat m16611d(String str) {
        if (str == null) {
            return CompressFormat.JPEG;
        }
        String[] split = str.split("\\.");
        if (split == null) {
            return CompressFormat.JPEG;
        }
        if (split.length == 0) {
            return CompressFormat.JPEG;
        }
        if (split[split.length - 1].equalsIgnoreCase("png")) {
            return CompressFormat.PNG;
        }
        return CompressFormat.JPEG;
    }

    /* renamed from: a */
    private final Bitmap m16589a(File file, Bitmap bitmap, int i) {
        Bitmap a;
        Bitmap bitmap2;
        try {
            if (this.f12067x) {
                bitmap = m16584a(bitmap);
            }
            if (bitmap != null) {
                a = this.f12064u.mo1989a(bitmap);
            } else {
                a = null;
            }
            bitmap2 = bitmap;
        } catch (Exception e) {
            m16601a(null, e);
            a = null;
            bitmap2 = bitmap;
        } catch (OutOfMemoryError e2) {
            m16601a("Out of memory error. Check your bitmap operations and decrease memory usage", null);
            a = null;
            bitmap2 = bitmap;
        }
        if (!(a == null || bitmap2 == a)) {
            if (bitmap2 != null) {
                try {
                    if (!bitmap2.isRecycled()) {
                        bitmap2.recycle();
                        bitmap2 = null;
                    }
                } catch (Exception e3) {
                    a = bitmap2;
                }
            }
            if (a.isRecycled()) {
                m16601a("Obtained recycled bitmap after image processing", null);
            }
            if (a == null) {
                try {
                    if (a.isRecycled()) {
                        return a;
                    }
                    m16601a("Obtained bitmap is invalid and input image is recycled or wrong", null);
                    return m16588a(file, i);
                } catch (Exception e4) {
                    return null;
                }
            }
            m16601a("Obtained null after image processing", null);
            return m16588a(file, i);
        }
        a = bitmap2;
        if (a == null) {
            m16601a("Obtained null after image processing", null);
            return m16588a(file, i);
        } else if (a.isRecycled()) {
            return a;
        } else {
            m16601a("Obtained bitmap is invalid and input image is recycled or wrong", null);
            return m16588a(file, i);
        }
    }

    /* renamed from: a */
    private final Bitmap m16591a(InputStream inputStream, Bitmap bitmap, int i) {
        Bitmap a;
        Bitmap bitmap2;
        try {
            if (this.f12067x) {
                bitmap = m16584a(bitmap);
            }
            if (bitmap != null) {
                a = this.f12064u.mo1989a(bitmap);
            } else {
                a = null;
            }
            bitmap2 = bitmap;
        } catch (Exception e) {
            m16601a(null, e);
            a = null;
            bitmap2 = bitmap;
        } catch (OutOfMemoryError e2) {
            m16601a("Out of memory error. Check your bitmap operations and decrease memory usage", null);
            a = null;
            bitmap2 = bitmap;
        }
        if (!(a == null || bitmap2 == a)) {
            if (bitmap2 != null) {
                try {
                    if (!bitmap2.isRecycled()) {
                        bitmap2.recycle();
                        bitmap2 = null;
                    }
                } catch (Exception e3) {
                    a = bitmap2;
                }
            }
            if (a.isRecycled()) {
                m16601a("Obtained recycled bitmap after image processing", null);
            }
            if (a != null) {
                m16601a("Obtained null after image processing", null);
                return m16590a(inputStream, i);
            } else if (a.isRecycled()) {
                return a;
            } else {
                m16601a("Obtained bitmap is invalid and input image is recycled or wrong", null);
                return m16590a(inputStream, i);
            }
        }
        a = bitmap2;
        if (a != null) {
            m16601a("Obtained null after image processing", null);
            return m16590a(inputStream, i);
        } else if (a.isRecycled()) {
            return a;
        } else {
            m16601a("Obtained bitmap is invalid and input image is recycled or wrong", null);
            return m16590a(inputStream, i);
        }
    }

    /* renamed from: a */
    private boolean m16604a(File file, InputStream inputStream) {
        try {
            OutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[Cache.DEFAULT_CACHE_SIZE];
            while (true) {
                int read = inputStream.read(bArr, 0, Cache.DEFAULT_CACHE_SIZE);
                if (read == -1) {
                    fileOutputStream.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            m16601a("Storage error during IO operation. Please check your storage where placed cache folder", e);
            return false;
        }
    }

    /* renamed from: a */
    private final Bitmap m16588a(File file, int i) {
        try {
            return m16590a(new FileInputStream(file), i);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private final Bitmap m16590a(InputStream inputStream, int i) {
        InputStream bufferedInputStream = new BufferedInputStream(inputStream, 8000);
        if (i == 1) {
            try {
                return BitmapFactory.decodeStream(bufferedInputStream);
            } catch (OutOfMemoryError e) {
                if (this.f12058o != 0) {
                    return null;
                }
                int size = this.f12059p.size() / 7;
                if (this.f12059p.size() <= size) {
                    return null;
                }
                for (int i2 = 0; i2 < size; i2++) {
                    this.f12046c.remove(this.f12059p.remove(0));
                }
                System.gc();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
                try {
                    bufferedInputStream.reset();
                } catch (Exception e3) {
                }
                if (i == 1) {
                    try {
                        return BitmapFactory.decodeStream(bufferedInputStream);
                    } catch (Exception e4) {
                        return null;
                    } catch (OutOfMemoryError e5) {
                        return null;
                    }
                }
                Options options = new Options();
                options.inSampleSize = i;
                return BitmapFactory.decodeStream(bufferedInputStream, null, options);
            } catch (Exception e6) {
                return null;
            }
        }
        options = new Options();
        options.inSampleSize = i;
        return BitmapFactory.decodeStream(bufferedInputStream, null, options);
    }

    /* renamed from: a */
    private final Bitmap m16584a(Bitmap bitmap) {
        try {
            File file;
            if (this.f12054k.get() != null) {
                file = new File(((Activity) this.f12054k.get()).getFilesDir(), "temp.tmp");
            } else {
                file = new File(Environment.getExternalStorageDirectory() + File.separator + "temp.tmp");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Config config = bitmap.getConfig();
            FileChannel channel = randomAccessFile.getChannel();
            Buffer map = channel.map(MapMode.READ_WRITE, 0, (long) (bitmap.getRowBytes() * height));
            bitmap.copyPixelsToBuffer(map);
            bitmap.recycle();
            System.gc();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, config);
            map.position(0);
            createBitmap.copyPixelsFromBuffer(map);
            channel.close();
            randomAccessFile.close();
            file.delete();
            return createBitmap;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e2) {
            return null;
        } catch (OutOfMemoryError e3) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m16594a(Activity activity) {
        if (activity != null) {
            return new File(activity.getExternalFilesDir(null), "/.cache").getAbsolutePath();
        }
        return "";
    }

    /* renamed from: a */
    private final void m16601a(String str, Exception exception) {
        if (this.f12068y) {
            if (str != null) {
                Log.w("ImageDownloader", str);
            }
            if (exception != null) {
                exception.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m16597a(File file) {
        if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                C3074a.m16597a(a);
            }
        }
        file.delete();
    }

    /* renamed from: a */
    private final void m16603a(HashMap<String, Long> hashMap) {
        try {
            File file = new File(this.f12049f, "time_hash");
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(hashMap);
            objectOutputStream.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: f */
    private final HashMap<String, Long> m16617f() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(this.f12049f, "time_hash")));
            HashMap<String, Long> hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            if (hashMap == null) {
                return new HashMap();
            }
            return hashMap;
        } catch (Exception e) {
            return new HashMap();
        }
    }

    /* renamed from: b */
    private final C3067a m16607b(AnimationSet animationSet) {
        try {
            List animations = animationSet.getAnimations();
            C3067a c3067a = new C3067a(this, true);
            for (int i = 0; i < animations.size(); i++) {
                c3067a.addAnimation((Animation) animations.get(i));
            }
            return c3067a;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: g */
    private final void m16619g() {
        int i = 0;
        File file = new File(this.f12049f, "" + this.f12057n);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            try {
                if (listFiles.length > this.f12044a) {
                    int length = listFiles.length - this.f12044a;
                    Arrays.sort(listFiles, new C30661(this));
                    for (int i2 = 0; i2 < length; i2++) {
                        listFiles[i2].delete();
                    }
                }
            } catch (Exception e) {
                while (i < listFiles.length) {
                    listFiles[i].delete();
                    i++;
                }
            }
        }
    }

    /* renamed from: b */
    public String m16638b(String str) {
        return "" + str.hashCode();
    }
}
