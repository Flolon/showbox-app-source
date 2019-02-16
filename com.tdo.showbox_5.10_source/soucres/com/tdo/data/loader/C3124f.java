package com.tdo.showbox.data.loader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tdo.showbox.data.loader.p128a.C3109a;
import com.tdo.showbox.data.loader.p128a.C3110b;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.p131f.C3175d;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: MovieDownloaderManager */
/* renamed from: com.tdo.showbox.data.loader.f */
public class C3124f {
    /* renamed from: b */
    private static C3124f f12173b = new C3124f();
    /* renamed from: a */
    private Context f12174a;
    /* renamed from: c */
    private HashMap<Long, C3126g> f12175c = new HashMap();
    /* renamed from: d */
    private BroadcastReceiver f12176d;
    /* renamed from: e */
    private BroadcastReceiver f12177e;
    /* renamed from: f */
    private BroadcastReceiver f12178f;
    /* renamed from: g */
    private BroadcastReceiver f12179g;
    /* renamed from: h */
    private BroadcastReceiver f12180h;
    /* renamed from: i */
    private BroadcastReceiver f12181i;
    /* renamed from: j */
    private BroadcastReceiver f12182j;
    /* renamed from: k */
    private BroadcastReceiver f12183k;
    /* renamed from: l */
    private boolean f12184l;
    /* renamed from: m */
    private C3111c f12185m = new C31151(this);

    /* compiled from: MovieDownloaderManager */
    /* renamed from: com.tdo.showbox.data.loader.f$1 */
    class C31151 implements C3111c {
        /* renamed from: a */
        final /* synthetic */ C3124f f12164a;

        C31151(C3124f c3124f) {
            this.f12164a = c3124f;
        }

        /* renamed from: a */
        public void mo2136a(ArrayList<DownloadEpisode> arrayList) {
        }

        /* renamed from: a */
        public void mo2135a() {
        }
    }

    /* compiled from: MovieDownloaderManager */
    /* renamed from: com.tdo.showbox.data.loader.f$2 */
    class C31162 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3124f f12165a;

        C31162(C3124f c3124f) {
            this.f12165a = c3124f;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (this.f12165a.f12175c != null) {
                    ((C3126g) this.f12165a.f12175c.get(Long.valueOf(C3175d.m16962a(intent).getEpisode_id()))).mo2038a(C3175d.m16962a(intent));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: MovieDownloaderManager */
    /* renamed from: com.tdo.showbox.data.loader.f$3 */
    class C31173 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3124f f12166a;

        C31173(C3124f c3124f) {
            this.f12166a = c3124f;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (this.f12166a.f12175c != null) {
                    ((C3126g) this.f12166a.f12175c.get(Long.valueOf(C3175d.m16962a(intent).getEpisode_id()))).mo2039b(C3175d.m16962a(intent));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: MovieDownloaderManager */
    /* renamed from: com.tdo.showbox.data.loader.f$4 */
    class C31184 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3124f f12167a;

        C31184(C3124f c3124f) {
            this.f12167a = c3124f;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (this.f12167a.f12175c != null) {
                    ((C3126g) this.f12167a.f12175c.get(Long.valueOf(C3175d.m16962a(intent).getEpisode_id()))).mo2041c(C3175d.m16962a(intent));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: MovieDownloaderManager */
    /* renamed from: com.tdo.showbox.data.loader.f$5 */
    class C31195 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3124f f12168a;

        C31195(C3124f c3124f) {
            this.f12168a = c3124f;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (this.f12168a.f12175c != null) {
                    ((C3126g) this.f12168a.f12175c.get(Long.valueOf(C3175d.m16962a(intent).getEpisode_id()))).mo2042d(C3175d.m16962a(intent));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: MovieDownloaderManager */
    /* renamed from: com.tdo.showbox.data.loader.f$6 */
    class C31206 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3124f f12169a;

        C31206(C3124f c3124f) {
            this.f12169a = c3124f;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (this.f12169a.f12175c != null) {
                    ((C3126g) this.f12169a.f12175c.get(Long.valueOf(C3175d.m16962a(intent).getEpisode_id()))).mo2043e(C3175d.m16962a(intent));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: MovieDownloaderManager */
    /* renamed from: com.tdo.showbox.data.loader.f$7 */
    class C31217 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3124f f12170a;

        C31217(C3124f c3124f) {
            this.f12170a = c3124f;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (this.f12170a.f12175c != null) {
                    for (Long l : this.f12170a.f12175c.keySet()) {
                        ((C3126g) this.f12170a.f12175c.get(l)).mo2040c();
                    }
                    this.f12170a.f12185m.mo2135a();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: MovieDownloaderManager */
    /* renamed from: com.tdo.showbox.data.loader.f$8 */
    class C31228 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3124f f12171a;

        C31228(C3124f c3124f) {
            this.f12171a = c3124f;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                ((C3126g) this.f12171a.f12175c.get(Long.valueOf(C3175d.m16962a(intent).getEpisode_id()))).mo2044f(C3175d.m16962a(intent));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: MovieDownloaderManager */
    /* renamed from: com.tdo.showbox.data.loader.f$9 */
    class C31239 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C3124f f12172a;

        C31239(C3124f c3124f) {
            this.f12172a = c3124f;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                this.f12172a.f12185m.mo2136a(C3175d.m16964b(intent));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private C3124f() {
        m16799d();
    }

    /* renamed from: d */
    private void m16799d() {
        this.f12176d = new C31162(this);
        this.f12177e = new C31173(this);
        this.f12178f = new C31184(this);
        this.f12179g = new C31195(this);
        this.f12180h = new C31206(this);
        this.f12181i = new C31217(this);
        this.f12182j = new C31228(this);
        this.f12183k = new C31239(this);
    }

    /* renamed from: a */
    public static C3124f m16794a(Context context) {
        if (f12173b == null) {
            f12173b = new C3124f();
            f12173b.f12174a = context;
            f12173b.m16802b();
        } else {
            if (f12173b.f12174a == null) {
                f12173b.f12174a = context;
            }
            if (!f12173b.f12184l) {
                f12173b.m16802b();
            }
        }
        return f12173b;
    }

    /* renamed from: a */
    public static void m16796a() {
        try {
            if (f12173b != null) {
                f12173b.m16804c();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public C3126g m16800a(DownloadEpisode downloadEpisode) {
        C3109a.m16754a("appare new episode", C3110b.dowloader_sevice);
        if (!this.f12175c.containsKey(downloadEpisode.getId())) {
            this.f12175c.put(Long.valueOf(downloadEpisode.getEpisode_id()), new C3126g(this, downloadEpisode));
        }
        return (C3126g) this.f12175c.get(Long.valueOf(downloadEpisode.getEpisode_id()));
    }

    /* renamed from: b */
    public void m16802b() {
        this.f12184l = true;
        this.f12174a.registerReceiver(this.f12176d, new IntentFilter("com.tdo.showbox.ACTION_PROGRESS"));
        this.f12174a.registerReceiver(this.f12177e, new IntentFilter("com.tdo.showbox.ACTION_PAUSE_DOWNLOADING"));
        this.f12174a.registerReceiver(this.f12181i, new IntentFilter("com.tdo.showbox.ACTION_FINISH_ALL_DOWNLOADING"));
        this.f12174a.registerReceiver(this.f12178f, new IntentFilter("com.tdo.showbox.ACTION_RESUME_DOWNLOADING"));
        this.f12174a.registerReceiver(this.f12179g, new IntentFilter("com.tdo.showbox.ACTION_FINISH_MOVIE_DOWNLOADING"));
        this.f12174a.registerReceiver(this.f12180h, new IntentFilter("com.tdo.showbox.ACTION_START_MOVIE_DOWNLOADING"));
        this.f12174a.registerReceiver(this.f12182j, new IntentFilter("com.tdo.showbox.ACTION_STATUS"));
        this.f12174a.registerReceiver(this.f12183k, new IntentFilter("com.tdo.showbox.ACTION_ALL_STATUS"));
    }

    /* renamed from: c */
    public void m16804c() {
        try {
            this.f12174a.unregisterReceiver(this.f12176d);
            this.f12174a.unregisterReceiver(this.f12177e);
            this.f12174a.unregisterReceiver(this.f12181i);
            this.f12174a.unregisterReceiver(this.f12178f);
            this.f12174a.unregisterReceiver(this.f12179g);
            this.f12174a.unregisterReceiver(this.f12180h);
            this.f12174a.unregisterReceiver(this.f12182j);
            this.f12174a.unregisterReceiver(this.f12183k);
            this.f12184l = false;
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    protected void m16801a(C3126g c3126g) {
        m16797a(c3126g.m16823h(), 23);
    }

    /* renamed from: b */
    protected void m16803b(C3126g c3126g) {
        m16797a(c3126g.m16823h(), 26);
    }

    /* renamed from: c */
    protected void m16805c(C3126g c3126g) {
        m16797a(c3126g.m16823h(), 29);
    }

    /* renamed from: d */
    protected void m16806d(C3126g c3126g) {
        m16797a(c3126g.m16823h(), 23);
    }

    /* renamed from: e */
    protected void m16807e(C3126g c3126g) {
        m16797a(c3126g.m16823h(), 36);
    }

    /* renamed from: f */
    public void m16808f(C3126g c3126g) {
        m16797a(c3126g.m16823h(), 42);
    }

    /* renamed from: a */
    private void m16797a(DownloadEpisode downloadEpisode, int i) {
        C3109a.m16754a("send task to service", C3110b.dowloader_sevice);
        Intent intent = new Intent(this.f12174a, DownloaderService.class);
        intent.putExtra("ACTION_ID", i);
        intent.putExtra("ARG_DOWNLOAD_ITEM", downloadEpisode);
        this.f12174a.startService(intent);
    }
}
