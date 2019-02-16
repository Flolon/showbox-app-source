package com.tdo.showbox.data.p114e;

import android.database.DatabaseUtils;
import com.activeandroid.query.Select;
import com.tdo.showbox.data.C3077d;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.Episod;
import com.tdo.showbox.models.Subtitle;
import com.tdo.showbox.models.TvItem;

/* compiled from: ShowsPlayManager */
/* renamed from: com.tdo.showbox.data.e.d */
public class C3083d extends C3079a {
    /* renamed from: e */
    private Episod f12087e;
    /* renamed from: f */
    private int f12088f;

    public C3083d(long j, int i, long j2) {
        this.f12088f = i;
        this.f12087e = (Episod) new Select().from(Episod.class).where("season_num=" + i + " AND mov_id=" + j + " AND episode_id='" + j2 + "'").executeSingle();
    }

    /* renamed from: b */
    public void mo2130b() {
        TvItem tvItem = (TvItem) new Select().from(TvItem.class).where("item_id=" + this.f12087e.getMovId()).executeSingle();
        if (tvItem == null) {
            if (this.a != null) {
                this.a.mo2023j();
            }
        } else if (this.a != null) {
            C3077d.m16650a(tvItem, this.f12087e.getEpisode_id(), this.f12087e.getMovId(), this.f12088f);
            this.a.mo2023j();
        }
    }

    /* renamed from: a */
    public Subtitle mo2128a() {
        if (this.f12087e == null) {
            return null;
        }
        Subtitle subtitle = (Subtitle) new Select().from(Subtitle.class).where("is_movie=0 AND parrent_id='" + ("" + this.f12087e.getMovId() + this.f12088f + this.f12087e.getEpisode_id()) + "'").executeSingle();
        if (subtitle == null) {
            try {
                subtitle = (Subtitle) new Select().from(Subtitle.class).where("parrent_id='" + ((DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_num=" + this.f12087e.getEpisode_id() + " AND percent=100 AND season_num=" + this.f12088f + " AND title=" + DatabaseUtils.sqlEscapeString(((TvItem) new Select().from(TvItem.class).where("item_id=" + this.f12087e.getMovId()).executeSingle()).getTitle())).executeSingle()).getSubtitle_id() + "'").executeSingle();
                if (subtitle == null) {
                    return subtitle;
                }
                subtitle.setPartDelay(0);
                return subtitle;
            } catch (Exception e) {
                return null;
            }
        } else if (subtitle == null) {
            return subtitle;
        } else {
            subtitle.setPartDelay(0);
            return subtitle;
        }
    }

    /* renamed from: a */
    public void mo2129a(long j) {
    }
}
