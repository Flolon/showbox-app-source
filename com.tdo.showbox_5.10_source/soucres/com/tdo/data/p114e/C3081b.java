package com.tdo.showbox.data.p114e;

import android.database.DatabaseUtils;
import com.activeandroid.query.Select;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.Subtitle;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: DownloadedShowsPlayManager */
/* renamed from: com.tdo.showbox.data.e.b */
public class C3081b extends C3079a {
    /* renamed from: e */
    private List<DownloadEpisode> f12076e;
    /* renamed from: f */
    private int f12077f;
    /* renamed from: g */
    private long f12078g;
    /* renamed from: h */
    private int f12079h = 0;
    /* renamed from: i */
    private String f12080i;
    /* renamed from: j */
    private String f12081j;

    /* compiled from: DownloadedShowsPlayManager */
    /* renamed from: com.tdo.showbox.data.e.b$1 */
    class C30801 implements Comparator<DownloadEpisode> {
        /* renamed from: a */
        final /* synthetic */ C3081b f12075a;

        C30801(C3081b c3081b) {
            this.f12075a = c3081b;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m16659a((DownloadEpisode) obj, (DownloadEpisode) obj2);
        }

        /* renamed from: a */
        public int m16659a(DownloadEpisode downloadEpisode, DownloadEpisode downloadEpisode2) {
            long longValue = Long.valueOf((long) downloadEpisode.getEpisode_num()).longValue();
            long longValue2 = Long.valueOf((long) downloadEpisode2.getEpisode_num()).longValue();
            if (longValue == longValue2) {
                return 0;
            }
            if (longValue < longValue2) {
                return -1;
            }
            return 1;
        }
    }

    public C3081b(int i, long j, String str, String str2) {
        this.f12078g = j;
        this.f12077f = i;
        this.f12080i = str;
        this.f12081j = str2;
        this.f12076e = new Select().from(DownloadEpisode.class).where("percent=100 AND is_movie=0 AND season_num=" + this.f12077f + " AND title=" + DatabaseUtils.sqlEscapeString(str)).execute();
        Collections.sort(this.f12076e, new C30801(this));
        for (int i2 = 0; i2 < this.f12076e.size(); i2++) {
            if (((long) ((DownloadEpisode) this.f12076e.get(i2)).getEpisode_num()) == this.f12078g) {
                this.f12079h = i2;
                return;
            }
        }
    }

    /* renamed from: b */
    public void mo2130b() {
        if (this.a != null) {
            try {
                List list = this.f12076e;
                int i = this.f12079h + 1;
                this.f12079h = i;
                DownloadEpisode downloadEpisode = (DownloadEpisode) list.get(i);
                this.a.mo2022a(downloadEpisode.getFull_path(), this.c, downloadEpisode.getEpisode_id(), -1, -1);
            } catch (Exception e) {
                this.a.mo2023j();
            }
        }
    }

    /* renamed from: a */
    public Subtitle mo2128a() {
        Subtitle subtitle;
        try {
            subtitle = (Subtitle) new Select().from(Subtitle.class).where("parrent_id='" + ((DownloadEpisode) this.f12076e.get(this.f12079h)).getSubtitle_id() + "'").executeSingle();
        } catch (Exception e) {
            DownloadEpisode downloadEpisode = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("percent=100 AND is_movie=0 AND title=" + DatabaseUtils.sqlEscapeString(this.f12080i)).executeSingle();
            if (downloadEpisode != null) {
                subtitle = (Subtitle) new Select().from(Subtitle.class).where("parrent_id='" + downloadEpisode.getSubtitle_id() + "'").executeSingle();
            } else {
                subtitle = (Subtitle) new Select().from(Subtitle.class).where("parrent_id='" + this.f12081j + "'").executeSingle();
            }
        }
        if (subtitle != null) {
            subtitle.setPartDelay(0);
        }
        return subtitle;
    }

    /* renamed from: a */
    public void mo2129a(long j) {
    }
}
