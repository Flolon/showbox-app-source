package com.tdo.showbox.data.loader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import com.activeandroid.query.Select;
import com.tdo.showbox.data.loader.p128a.C3109a;
import com.tdo.showbox.data.loader.p128a.C3110b;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.p131f.C3175d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;

public class DownloaderService extends Service implements C2755a {
    /* renamed from: a */
    public static boolean f12138a = true;
    /* renamed from: b */
    private LinkedBlockingQueue<Long> f12139b = new LinkedBlockingQueue();
    /* renamed from: c */
    private HashMap<Long, C3108a> f12140c = new HashMap();
    /* renamed from: d */
    private LinkedBlockingQueue<C3113d> f12141d;
    /* renamed from: e */
    private HashMap<Long, C3113d> f12142e = new HashMap();
    /* renamed from: f */
    private HashMap<Long, DownloadEpisode> f12143f = new HashMap();
    /* renamed from: g */
    private TimerTask f12144g;
    /* renamed from: h */
    private Timer f12145h;

    /* renamed from: com.tdo.showbox.data.loader.DownloaderService$b */
    private interface C3095b {
        /* renamed from: a */
        void mo2131a();
    }

    /* renamed from: com.tdo.showbox.data.loader.DownloaderService$1 */
    class C30971 extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ DownloaderService f12116a;

        /* renamed from: com.tdo.showbox.data.loader.DownloaderService$1$1 */
        class C30961 implements C3095b {
            /* renamed from: a */
            final /* synthetic */ C30971 f12103a;

            C30961(C30971 c30971) {
                this.f12103a = c30971;
            }

            /* renamed from: a */
            public void mo2131a() {
                for (Long l : this.f12103a.f12116a.f12143f.keySet()) {
                    this.f12103a.f12116a.sendBroadcast(C3175d.m16960a("com.tdo.showbox.ACTION_PROGRESS", (DownloadEpisode) this.f12103a.f12116a.f12143f.get(l)));
                }
            }
        }

        C30971(DownloaderService downloaderService) {
            this.f12116a = downloaderService;
        }

        public void run() {
            this.f12116a.m16727b(new C30961(this));
        }
    }

    /* renamed from: com.tdo.showbox.data.loader.DownloaderService$a */
    protected class C3108a {
        /* renamed from: a */
        volatile int f12135a;
        /* renamed from: b */
        DownloadEpisode f12136b;
        /* renamed from: c */
        final /* synthetic */ DownloaderService f12137c;

        protected C3108a(DownloaderService downloaderService) {
            this.f12137c = downloaderService;
        }
    }

    public void onCreate() {
        m16734e();
        m16732d();
        super.onCreate();
    }

    /* renamed from: d */
    private void m16732d() {
        this.f12144g = new C30971(this);
        this.f12145h = new Timer();
        this.f12145h.schedule(this.f12144g, 750, 750);
    }

    /* renamed from: e */
    private void m16734e() {
        m16742a();
        m16745b();
    }

    /* renamed from: a */
    public void m16742a() {
        this.f12141d = new LinkedBlockingQueue();
        for (int i = 0; i < 3; i++) {
            C3113d c3113d = new C3113d(getApplicationContext(), this);
            c3113d.setPriority(1);
            m16725a(c3113d);
            try {
                this.f12141d.put(c3113d);
            } catch (Throwable e) {
                e.printStackTrace();
                C3109a.m16753a("can`t put thread in pool", e, C3110b.thread, C3110b.dowloader_sevice);
            }
        }
    }

    /* renamed from: a */
    private void m16725a(final C3113d c3113d) {
        c3113d.m16781a(new C3106b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12134b;

            /* renamed from: com.tdo.showbox.data.loader.DownloaderService$9$1 */
            class C31051 implements C3095b {
                /* renamed from: a */
                final /* synthetic */ C31079 f12132a;

                C31051(C31079 c31079) {
                    this.f12132a = c31079;
                }

                /* renamed from: a */
                public void mo2131a() {
                    try {
                        this.f12132a.f12134b.f12142e.remove(Long.valueOf(c3113d.m16778a().f12136b.getEpisode_id()));
                        this.f12132a.f12134b.f12141d.put(c3113d);
                        if (this.f12132a.f12134b.f12141d.size() + 1 >= 3) {
                            this.f12132a.f12134b.mo2040c();
                        }
                    } catch (Throwable e) {
                        e.printStackTrace();
                        C3109a.m16753a("can`t put thread in pool", e, C3110b.thread, C3110b.dowloader_sevice);
                    }
                }
            }

            /* renamed from: a */
            public void mo2132a() {
                this.f12134b.m16722a(new C31051(this));
            }
        });
    }

    /* renamed from: b */
    public void m16745b() {
        new Thread(this) {
            /* renamed from: a */
            final /* synthetic */ DownloaderService f12104a;

            {
                this.f12104a = r1;
            }

            public void run() {
                super.run();
                while (true) {
                    try {
                        this.f12104a.m16729b((C3113d) this.f12104a.f12141d.take());
                    } catch (Throwable e) {
                        e.printStackTrace();
                        C3109a.m16753a("can`t get task from queue", e, C3110b.thread, C3110b.dowloader_sevice);
                    }
                }
            }
        }.start();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C3109a.m16754a("get command", C3110b.dowloader_sevice);
        if (intent == null) {
            try {
                throw new Exception("getting intent empty");
            } catch (Throwable e) {
                e.printStackTrace();
                C3109a.m16753a("some error when service get task", e, C3110b.dowloader_sevice);
            }
        } else {
            DownloadEpisode a = m16719a(intent);
            switch (intent.getIntExtra("ACTION_ID", -1)) {
                case 23:
                    C3109a.m16754a("service parse command as Constants.CMD_START_DOWNLOAD", C3110b.dowloader_sevice);
                    m16740k(a);
                    break;
                case 26:
                    C3109a.m16754a("service parse command as Constants.CMD_DELETE_MOVIE", C3110b.dowloader_sevice);
                    m16739j(a);
                    break;
                case 29:
                    C3109a.m16754a("service parse command as Constants.CMD_PAUSE_MOVIE", C3110b.dowloader_sevice);
                    m16738i(a);
                    break;
                case 36:
                    C3109a.m16754a("service parse command as Constants.CMD_GET_STATUS", C3110b.dowloader_sevice);
                    m16741l(a);
                    break;
                case 39:
                    C3109a.m16754a("service parse command as Constants.CMD_GET_COMMON_STATUS", C3110b.dowloader_sevice);
                    m16735f();
                    break;
                case 42:
                    C3109a.m16754a("service parse command as Constants.CMD_SAVE", C3110b.dowloader_sevice);
                    m16737h(a);
                    break;
                default:
                    break;
            }
            return 2;
        }
    }

    /* renamed from: h */
    private void m16737h(final DownloadEpisode downloadEpisode) {
        m16722a(new C3095b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12106b;

            /* renamed from: a */
            public void mo2131a() {
                C3108a c3108a = new C3108a(this.f12106b);
                c3108a.f12136b = downloadEpisode;
                c3108a.f12135a = 23;
                downloadEpisode.setDeleted(0);
                downloadEpisode.save();
                this.f12106b.f12140c.put(Long.valueOf(downloadEpisode.getEpisode_id()), c3108a);
            }
        });
    }

    /* renamed from: i */
    private void m16738i(final DownloadEpisode downloadEpisode) {
        m16722a(new C3095b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12108b;

            /* renamed from: a */
            public void mo2131a() {
                if (this.f12108b.f12140c.containsKey(Long.valueOf(downloadEpisode.getEpisode_id()))) {
                    ((C3108a) this.f12108b.f12140c.get(Long.valueOf(downloadEpisode.getEpisode_id()))).f12136b.save();
                }
                if (this.f12108b.f12142e.containsKey(Long.valueOf(downloadEpisode.getEpisode_id()))) {
                    ((C3113d) this.f12108b.f12142e.get(Long.valueOf(downloadEpisode.getEpisode_id()))).m16783b();
                } else if (this.f12108b.f12139b.contains(Long.valueOf(downloadEpisode.getEpisode_id()))) {
                    this.f12108b.f12139b.remove(Long.valueOf(downloadEpisode.getEpisode_id()));
                }
            }
        });
    }

    /* renamed from: j */
    private void m16739j(final DownloadEpisode downloadEpisode) {
        m16722a(new C3095b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12110b;

            /* renamed from: a */
            public void mo2131a() {
                if (this.f12110b.f12142e.containsKey(Long.valueOf(downloadEpisode.getEpisode_id()))) {
                    ((C3113d) this.f12110b.f12142e.get(Long.valueOf(downloadEpisode.getEpisode_id()))).m16784c();
                }
                if (this.f12110b.f12139b.contains(Long.valueOf(downloadEpisode.getEpisode_id()))) {
                    this.f12110b.f12139b.remove(Long.valueOf(downloadEpisode.getEpisode_id()));
                }
                if (this.f12110b.f12140c.containsKey(Long.valueOf(downloadEpisode.getEpisode_id()))) {
                    this.f12110b.f12140c.remove(Long.valueOf(downloadEpisode.getEpisode_id()));
                }
                downloadEpisode.setProgress(0);
                downloadEpisode.setPercent(0);
                downloadEpisode.setDeleted(1);
                downloadEpisode.save();
            }
        });
    }

    /* renamed from: k */
    private void m16740k(final DownloadEpisode downloadEpisode) {
        m16722a(new C3095b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12112b;

            /* renamed from: a */
            public void mo2131a() {
                if (!this.f12112b.f12142e.containsKey(Long.valueOf(downloadEpisode.getEpisode_id()))) {
                    if (this.f12112b.f12139b.contains(Long.valueOf(downloadEpisode.getEpisode_id()))) {
                        ((C3108a) this.f12112b.f12140c.get(Long.valueOf(downloadEpisode.getEpisode_id()))).f12135a = 23;
                        return;
                    }
                    C3108a c3108a = new C3108a(this.f12112b);
                    c3108a.f12136b = downloadEpisode;
                    c3108a.f12135a = 23;
                    downloadEpisode.setStatus(1);
                    downloadEpisode.save();
                    this.f12112b.f12140c.put(Long.valueOf(downloadEpisode.getEpisode_id()), c3108a);
                    try {
                        this.f12112b.f12139b.put(Long.valueOf(downloadEpisode.getEpisode_id()));
                    } catch (Throwable e) {
                        C3109a.m16753a("can`t put task to the queue", e, C3110b.dowloader_sevice);
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* renamed from: l */
    private void m16741l(final DownloadEpisode downloadEpisode) {
        m16722a(new C3095b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12114b;

            /* renamed from: a */
            public void mo2131a() {
                if (this.f12114b.f12140c.containsKey(Long.valueOf(downloadEpisode.getEpisode_id()))) {
                    this.f12114b.mo2044f(((C3108a) this.f12114b.f12140c.get(Long.valueOf(downloadEpisode.getEpisode_id()))).f12136b);
                } else {
                    this.f12114b.mo2044f(downloadEpisode);
                }
            }
        });
    }

    /* renamed from: f */
    private void m16735f() {
        m16722a(new C3095b(this) {
            /* renamed from: a */
            final /* synthetic */ DownloaderService f12115a;

            {
                this.f12115a = r1;
            }

            /* renamed from: a */
            public void mo2131a() {
                ArrayList arrayList = new ArrayList();
                for (Object obj : this.f12115a.f12140c.keySet()) {
                    arrayList.add(((C3108a) this.f12115a.f12140c.get(obj)).f12136b);
                }
                this.f12115a.m16744a(arrayList);
            }
        });
    }

    /* renamed from: b */
    private void m16729b(final C3113d c3113d) {
        C3109a.m16754a("getting free thread from pool", C3110b.dowloader_sevice);
        try {
            final C3108a c3108a = (C3108a) this.f12140c.get(Long.valueOf(((Long) this.f12139b.take()).longValue()));
            m16722a(new C3095b(this) {
                /* renamed from: c */
                final /* synthetic */ DownloaderService f12119c;

                /* renamed from: a */
                public void mo2131a() {
                    if (c3108a.f12135a == 23 || c3108a.f12135a == 32) {
                        this.f12119c.f12142e.put(Long.valueOf(c3108a.f12136b.getEpisode_id()), c3113d);
                        c3113d.m16780a(c3108a);
                    }
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
            C3109a.m16753a("can`t get new task, thar can be execute in pool thread", e, C3110b.thread, C3110b.dowloader_sevice);
            try {
                this.f12141d.put(c3113d);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private synchronized void m16722a(C3095b c3095b) {
        c3095b.mo2131a();
    }

    /* renamed from: b */
    private synchronized void m16727b(C3095b c3095b) {
        c3095b.mo2131a();
    }

    /* renamed from: a */
    public void mo2038a(final DownloadEpisode downloadEpisode) {
        m16727b(new C3095b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12121b;

            /* renamed from: a */
            public void mo2131a() {
                this.f12121b.f12143f.put(Long.valueOf(downloadEpisode.getEpisode_id()), downloadEpisode);
            }
        });
    }

    /* renamed from: b */
    public void mo2039b(final DownloadEpisode downloadEpisode) {
        m16727b(new C3095b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12123b;

            /* renamed from: a */
            public void mo2131a() {
                this.f12123b.f12143f.remove(Long.valueOf(downloadEpisode.getEpisode_id()));
                this.f12123b.sendBroadcast(C3175d.m16960a("com.tdo.showbox.ACTION_PAUSE_DOWNLOADING", downloadEpisode));
            }
        });
    }

    /* renamed from: c */
    public void mo2041c(final DownloadEpisode downloadEpisode) {
        m16727b(new C3095b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12125b;

            /* renamed from: a */
            public void mo2131a() {
                this.f12125b.f12143f.remove(Long.valueOf(downloadEpisode.getEpisode_id()));
                this.f12125b.sendBroadcast(C3175d.m16960a("com.tdo.showbox.ACTION_RESUME_DOWNLOADING", downloadEpisode));
            }
        });
    }

    /* renamed from: d */
    public void mo2042d(final DownloadEpisode downloadEpisode) {
        m16727b(new C3095b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12127b;

            /* renamed from: a */
            public void mo2131a() {
                this.f12127b.f12143f.remove(Long.valueOf(downloadEpisode.getEpisode_id()));
                this.f12127b.sendBroadcast(C3175d.m16960a("com.tdo.showbox.ACTION_FINISH_MOVIE_DOWNLOADING", downloadEpisode));
            }
        });
    }

    /* renamed from: e */
    public void mo2043e(final DownloadEpisode downloadEpisode) {
        m16727b(new C3095b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12129b;

            /* renamed from: a */
            public void mo2131a() {
                this.f12129b.f12143f.remove(Long.valueOf(downloadEpisode.getEpisode_id()));
                this.f12129b.sendBroadcast(C3175d.m16960a("com.tdo.showbox.ACTION_START_MOVIE_DOWNLOADING", downloadEpisode));
            }
        });
    }

    /* renamed from: c */
    public void mo2040c() {
        sendBroadcast(new Intent("com.tdo.showbox.ACTION_FINISH_ALL_DOWNLOADING"));
    }

    /* renamed from: f */
    public void mo2044f(final DownloadEpisode downloadEpisode) {
        m16727b(new C3095b(this) {
            /* renamed from: b */
            final /* synthetic */ DownloaderService f12131b;

            /* renamed from: a */
            public void mo2131a() {
                this.f12131b.f12143f.remove(Long.valueOf(downloadEpisode.getEpisode_id()));
                this.f12131b.sendBroadcast(C3175d.m16960a("com.tdo.showbox.ACTION_STATUS", downloadEpisode));
            }
        });
    }

    /* renamed from: a */
    protected void m16744a(ArrayList<DownloadEpisode> arrayList) {
        sendBroadcast(C3175d.m16961a("com.tdo.showbox.ACTION_ALL_STATUS", (ArrayList) arrayList));
    }

    /* renamed from: a */
    public static String m16720a(Context context, DownloadEpisode downloadEpisode, boolean z) {
        File file;
        try {
            file = new File(Environment.getExternalStorageDirectory(), "show_box");
        } catch (Exception e) {
            file = context.getExternalFilesDir(null);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        String shows_info = downloadEpisode.getShows_info();
        if (shows_info == null) {
            shows_info = "";
        }
        shows_info = (downloadEpisode.getTitle() + shows_info).replaceAll("\\W", "-") + ".mp4";
        if (z) {
            shows_info = shows_info + ".temp";
        }
        return new File(file, shows_info).getAbsolutePath();
    }

    /* renamed from: a */
    public static DownloadEpisode m16718a(Context context, DownloadEpisode downloadEpisode) {
        File file = new File(downloadEpisode.getFull_path());
        File file2 = new File(m16720a(context, downloadEpisode, false));
        file.renameTo(file2);
        downloadEpisode.setFull_path(file2.getAbsolutePath());
        return downloadEpisode;
    }

    /* renamed from: g */
    public static void m16736g(DownloadEpisode downloadEpisode) {
        File file = new File(downloadEpisode.getFull_path());
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: a */
    public static DownloadEpisode m16719a(Intent intent) {
        DownloadEpisode downloadEpisode = (DownloadEpisode) intent.getParcelableExtra("ARG_DOWNLOAD_ITEM");
        if (downloadEpisode == null) {
            return downloadEpisode;
        }
        DownloadEpisode downloadEpisode2 = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + downloadEpisode.getEpisode_id()).executeSingle();
        if (downloadEpisode2 == null) {
            downloadEpisode.save();
            downloadEpisode2 = downloadEpisode;
        }
        return downloadEpisode2;
    }

    public IBinder onBind(Intent intent) {
        C3109a.m16754a("download service was bind", C3110b.debug_and_test, C3110b.dowloader_sevice);
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        C3109a.m16754a("service destroy", C3110b.dowloader_sevice);
    }
}
