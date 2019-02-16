package com.tdo.showbox.data.p114e;

import com.activeandroid.query.Select;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.Subtitle;
import com.tdo.showbox.models.videosources.BaseVideoSource;

/* compiled from: MoviePlayManager */
/* renamed from: com.tdo.showbox.data.e.c */
public class C3082c extends C3079a {
    /* renamed from: e */
    private String f12082e;
    /* renamed from: f */
    private BaseVideoSource f12083f;
    /* renamed from: g */
    private DownloadEpisode f12084g;
    /* renamed from: h */
    private long f12085h;
    /* renamed from: i */
    private boolean f12086i;

    public C3082c(String str, long j, BaseVideoSource baseVideoSource, DownloadEpisode downloadEpisode) {
        this.f12082e = str;
        this.f12083f = baseVideoSource;
        this.f12084g = downloadEpisode;
        this.f12085h = j;
        this.f12086i = this.f12084g == null;
    }

    /* renamed from: b */
    public void mo2130b() {
        if (this.a != null) {
            this.a.mo2023j();
        }
    }

    /* renamed from: a */
    public Subtitle mo2128a() {
        Subtitle subtitle;
        if (this.f12084g != null) {
            subtitle = (Subtitle) new Select().from(Subtitle.class).where("is_movie=1 AND parrent_id='" + this.f12084g.getSubtitle_id() + "'").executeSingle();
        } else {
            subtitle = (Subtitle) new Select().from(Subtitle.class).where("is_movie=1 AND parrent_id='" + this.f12082e + "'").executeSingle();
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
