package com.tdo.showbox.data;

import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.tdo.showbox.activities.MainActivity;
import com.tdo.showbox.models.TvItem;
import com.tdo.showbox.models.TvItemMeta;
import com.tdo.showbox.models.ViewedEpizode;
import com.tdo.showbox.p129e.p130a.C3167a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EpizodeViewManager */
/* renamed from: com.tdo.showbox.data.d */
public class C3077d {
    /* renamed from: a */
    public static void m16650a(TvItem tvItem, long j, long j2, int i) {
        if (((ViewedEpizode) new Select().from(ViewedEpizode.class).where("episode_id=" + j + " AND season_num=" + i + " AND mov_id=" + j2).executeSingle()) == null) {
            ViewedEpizode viewedEpizode = new ViewedEpizode();
            viewedEpizode.setEpisode_id(j);
            viewedEpizode.setMov_id(j2);
            viewedEpizode.setSeason_num((long) i);
            viewedEpizode.save();
        }
        if (new Select().from(ViewedEpizode.class).where("mov_id=" + j2).execute().size() >= 3) {
            TvItemMeta tvItemMeta;
            TvItem tvItem2 = (TvItem) new Select().from(TvItem.class).where("item_id=" + j2 + " AND removed_from_lib!=1").executeSingle();
            if (tvItem2 != null) {
                TvItemMeta tvItemMeta2 = TvItem.getTvItemMeta(tvItem2);
                if (tvItemMeta2.getRemoved_from_lib() != 1) {
                    tvItem2.setIn_lib(1);
                    tvItem2.save();
                }
                tvItemMeta = tvItemMeta2;
            } else {
                tvItemMeta = null;
            }
            if (tvItemMeta != null && tvItemMeta.getRemoved_from_lib() == 0) {
                new Update(TvItem.class).set("in_lib=1").where("item_id=" + j2 + " AND removed_from_lib!=1").execute();
            }
            if (tvItem != null) {
                MainActivity C = C3167a.m16903a().m16895C();
                if (C != null) {
                    C.m15168o().m16845a(tvItem);
                }
            }
        }
    }

    /* renamed from: a */
    public static List<Long> m16649a(long j, long j2) {
        List<Long> arrayList = new ArrayList();
        for (ViewedEpizode episode_id : new Select().from(ViewedEpizode.class).where("mov_id=" + j + " AND season_num=" + j2).execute()) {
            arrayList.add(Long.valueOf(episode_id.getEpisode_id()));
        }
        return arrayList;
    }
}
