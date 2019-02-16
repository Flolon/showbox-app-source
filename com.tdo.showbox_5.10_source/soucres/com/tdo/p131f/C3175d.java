package com.tdo.showbox.p131f;

import android.content.Intent;
import android.os.Parcelable;
import com.activeandroid.query.Select;
import com.tdo.showbox.models.DownloadEpisode;
import java.util.ArrayList;

/* compiled from: IntentUtils */
/* renamed from: com.tdo.showbox.f.d */
public class C3175d {
    /* renamed from: a */
    public static DownloadEpisode m16962a(Intent intent) {
        DownloadEpisode downloadEpisode = (DownloadEpisode) intent.getParcelableExtra("ARG_DOWNLOAD_ITEM");
        return downloadEpisode == null ? downloadEpisode : C3175d.m16963a(downloadEpisode);
    }

    /* renamed from: a */
    public static DownloadEpisode m16963a(DownloadEpisode downloadEpisode) {
        DownloadEpisode downloadEpisode2 = (DownloadEpisode) new Select().from(DownloadEpisode.class).where("episode_id=" + downloadEpisode.getEpisode_id()).executeSingle();
        if (downloadEpisode2 != null) {
            return downloadEpisode2;
        }
        downloadEpisode.save();
        return downloadEpisode;
    }

    /* renamed from: b */
    public static ArrayList<DownloadEpisode> m16964b(Intent intent) {
        ArrayList<DownloadEpisode> arrayList = new ArrayList();
        for (int i = 0; i < i + 1; i++) {
            DownloadEpisode downloadEpisode = (DownloadEpisode) intent.getExtras().getParcelable("ARG_DOWNLOAD_ITEM" + i);
            if (downloadEpisode == null) {
                break;
            }
            arrayList.add(C3175d.m16963a(downloadEpisode));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Intent m16960a(String str, DownloadEpisode downloadEpisode) {
        Intent intent = new Intent(str);
        intent.putExtra("ARG_IS_DOWNLOAD_ITEM_LIST", false);
        if (downloadEpisode != null) {
            intent.putExtra("ARG_DOWNLOAD_ITEM", downloadEpisode);
        }
        return intent;
    }

    /* renamed from: a */
    public static Intent m16961a(String str, ArrayList<DownloadEpisode> arrayList) {
        Intent intent = new Intent(str);
        if (arrayList == null) {
            return intent;
        }
        intent.putExtra("ARG_IS_DOWNLOAD_ITEM_LIST", true);
        for (int i = 0; i < arrayList.size(); i++) {
            intent.putExtra("ARG_DOWNLOAD_ITEM" + i, (Parcelable) arrayList.get(i));
        }
        return intent;
    }
}
