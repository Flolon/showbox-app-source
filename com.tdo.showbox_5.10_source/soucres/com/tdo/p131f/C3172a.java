package com.tdo.showbox.p131f;

import android.content.Context;
import com.activeandroid.query.Delete;
import com.tdo.showbox.R;
import com.tdo.showbox.models.DownloadEpisode;
import com.tdo.showbox.models.videosources.BaseVideoSource;

/* compiled from: ConvetUtils */
/* renamed from: com.tdo.showbox.f.a */
public class C3172a {
    /* renamed from: a */
    public static DownloadEpisode m16954a(Context context, long j, String str, String str2, int i, String str3, String str4, int i2, long j2, BaseVideoSource baseVideoSource) {
        DownloadEpisode downloadEpisode = new DownloadEpisode();
        downloadEpisode.setEpisode_id(j);
        downloadEpisode.setLink(str);
        downloadEpisode.setPoster(str4);
        downloadEpisode.setTitle(str2);
        downloadEpisode.setShows_info(context.getString(R.string.download_season) + " " + i + ", " + str3);
        downloadEpisode.setIs_movie(0);
        if (baseVideoSource.getSource_mode_id() != 7) {
            str = baseVideoSource.getStatic_link();
        }
        downloadEpisode.setStatic_link(str);
        downloadEpisode.setSeason_num(i);
        downloadEpisode.setEpisode_num((int) j2);
        downloadEpisode.setSubtitle_id("" + str2.hashCode() + j + i + str3);
        downloadEpisode.setCookies(baseVideoSource.getCookies());
        downloadEpisode.setVideo_source(baseVideoSource.getSource_mode_id());
        downloadEpisode.setParts(baseVideoSource.getParts());
        downloadEpisode.setQuality(i2);
        if (baseVideoSource.getSource_mode_id() == 7) {
            new Delete().from(DownloadEpisode.class).where("episode_id = ?", Long.valueOf(j)).execute();
        }
        new Delete().from(DownloadEpisode.class).where("episode_id=" + j + " AND isDeleted=1").execute();
        return downloadEpisode;
    }

    /* renamed from: a */
    public static DownloadEpisode m16955a(Context context, long j, String str, String str2, String str3, int i, BaseVideoSource baseVideoSource) {
        DownloadEpisode downloadEpisode = new DownloadEpisode();
        downloadEpisode.setEpisode_id(j);
        downloadEpisode.setLink(str);
        downloadEpisode.setPoster(str3);
        downloadEpisode.setTitle(str2 + ".");
        if (baseVideoSource.getSource_mode_id() != 7) {
            str = baseVideoSource.getStatic_link();
        }
        downloadEpisode.setStatic_link(str);
        downloadEpisode.setIs_movie(1);
        downloadEpisode.setCookies(baseVideoSource.getCookies());
        downloadEpisode.setVideo_source(baseVideoSource.getSource_mode_id());
        downloadEpisode.setSubtitle_id("" + str2.hashCode() + j + str2);
        downloadEpisode.setParts(baseVideoSource.getParts());
        downloadEpisode.setQuality(i);
        if (baseVideoSource.getSource_mode_id() == 7) {
            new Delete().from(DownloadEpisode.class).where("episode_id = ?", Long.valueOf(j)).execute();
        }
        new Delete().from(DownloadEpisode.class).where("episode_id=" + j + " AND isDeleted=1").execute();
        return downloadEpisode;
    }
}
