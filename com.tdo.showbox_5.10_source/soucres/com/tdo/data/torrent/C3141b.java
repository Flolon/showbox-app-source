package com.tdo.showbox.data.torrent;

import android.content.Context;
import com.frostwire.jlibtorrent.TorrentInfo;
import com.tdo.showbox.data.api.C2999a;
import com.tdo.showbox.models.Episod;
import com.tdo.showbox.models.MovieItem;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import java.io.File;
import java.util.List;

/* compiled from: TorrentValidator */
/* renamed from: com.tdo.showbox.data.torrent.b */
public class C3141b {
    /* renamed from: a */
    public static boolean f12230a = false;
    /* renamed from: b */
    private Context f12231b;
    /* renamed from: c */
    private C2760a f12232c;

    /* compiled from: TorrentValidator */
    /* renamed from: com.tdo.showbox.data.torrent.b$a */
    public interface C2760a {
        /* renamed from: a */
        void mo2045a(String str);

        /* renamed from: a */
        void mo2046a(List<BaseVideoSource> list);
    }

    public C3141b(Context context) {
        this.f12231b = context;
    }

    /* renamed from: a */
    public void m16883a(final MovieItem movieItem, final C2760a c2760a) {
        new Thread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C3141b f12229c;

            public void run() {
                this.f12229c.m16886b(movieItem, c2760a);
            }
        }).start();
    }

    /* renamed from: b */
    public void m16886b(MovieItem movieItem, C2760a c2760a) {
        this.f12232c = c2760a;
        List<BaseVideoSource> sourceList = movieItem.getSourceList();
        if (f12230a) {
            for (BaseVideoSource baseVideoSource : sourceList) {
                if (baseVideoSource.getSource_mode_id() == 7) {
                    String str = "720";
                    String hd_link = baseVideoSource.getHd_link();
                    if (hd_link == null || hd_link.length() == 0) {
                        str = "480";
                        hd_link = baseVideoSource.getMid_link();
                    }
                    if (hd_link == null || hd_link.length() == 0) {
                        str = "1080";
                        hd_link = baseVideoSource.getFull_hd_link();
                    }
                    if (hd_link == null || hd_link.length() == 0) {
                        str = "360";
                        hd_link = baseVideoSource.getLow_link();
                    }
                    if (!m16885a(hd_link)) {
                        sourceList.remove(baseVideoSource);
                        this.f12232c.mo2045a(str);
                    }
                    this.f12232c.mo2046a((List) sourceList);
                    return;
                }
            }
            this.f12232c.mo2046a((List) sourceList);
            return;
        }
        this.f12232c.mo2046a((List) sourceList);
    }

    /* renamed from: a */
    public boolean m16884a(BaseVideoSource baseVideoSource) {
        if (baseVideoSource == null) {
            return false;
        }
        if (!f12230a) {
            return true;
        }
        if (baseVideoSource.getSource_mode_id() == 7) {
            String str = "720";
            str = baseVideoSource.getHd_link();
            if (str == null || str.length() == 0) {
                str = "480";
                str = baseVideoSource.getMid_link();
            }
            if (str == null || str.length() == 0) {
                str = "1080";
                str = baseVideoSource.getFull_hd_link();
            }
            if (str == null || str.length() == 0) {
                str = "360";
                str = baseVideoSource.getLow_link();
            }
            if (!m16885a(str)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void m16882a(Episod episod, C2760a c2760a) {
        this.f12232c = c2760a;
        List<BaseVideoSource> sourceList = episod.getSourceList();
        if (f12230a) {
            for (BaseVideoSource baseVideoSource : sourceList) {
                if (baseVideoSource.getSource_mode_id() == 7) {
                    String str = "720";
                    String hd_link = baseVideoSource.getHd_link();
                    if (hd_link == null || hd_link.length() == 0) {
                        str = "480";
                        hd_link = baseVideoSource.getMid_link();
                    }
                    if (hd_link == null || hd_link.length() == 0) {
                        str = "1080";
                        hd_link = baseVideoSource.getFull_hd_link();
                    }
                    if (hd_link == null || hd_link.length() == 0) {
                        str = "360";
                        hd_link = baseVideoSource.getLow_link();
                    }
                    if (!m16885a(hd_link)) {
                        sourceList.remove(baseVideoSource);
                        this.f12232c.mo2045a(str);
                    }
                    this.f12232c.mo2046a((List) sourceList);
                    return;
                }
            }
            this.f12232c.mo2046a((List) sourceList);
            return;
        }
        this.f12232c.mo2046a((List) sourceList);
    }

    /* renamed from: b */
    private String m16881b(String str) {
        try {
            return C2999a.m16321a(str, this.f12231b.getApplicationInfo().dataDir + "/torrent_filetemp", str.hashCode() + ".torrent");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public boolean m16885a(String str) {
        String b = m16881b(str);
        if (b == null) {
            return false;
        }
        File file = new File(b);
        try {
            if (new TorrentInfo(file).isValid()) {
                m16880a(file);
                return true;
            }
            throw new Exception();
        } catch (Exception e) {
            m16880a(file);
            return false;
        } catch (Throwable th) {
            m16880a(file);
            return false;
        }
    }

    /* renamed from: a */
    private void m16880a(File file) {
    }
}
