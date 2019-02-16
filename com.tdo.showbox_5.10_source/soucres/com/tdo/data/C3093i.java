package com.tdo.showbox.data;

import com.activeandroid.query.Select;
import com.tdo.showbox.models.SeasonLastViewItem;
import com.tdo.showbox.models.TvItem;

/* compiled from: SeasonViewManager */
/* renamed from: com.tdo.showbox.data.i */
public class C3093i {
    /* renamed from: a */
    public static void m16697a(TvItem tvItem, int i, String str) {
        SeasonLastViewItem seasonLastViewItem = (SeasonLastViewItem) new Select().from(SeasonLastViewItem.class).where("movie_id=" + tvItem.getItemId()).executeSingle();
        if (seasonLastViewItem == null) {
            seasonLastViewItem = new SeasonLastViewItem();
        }
        seasonLastViewItem.setLast_season(i);
        seasonLastViewItem.setSeason_list(str);
        seasonLastViewItem.setMovie_id(tvItem.getItemId());
        seasonLastViewItem.save();
    }

    /* renamed from: a */
    public static SeasonLastViewItem m16696a(String str) {
        return (SeasonLastViewItem) new Select().from(SeasonLastViewItem.class).where("movie_id='" + str + "'").executeSingle();
    }
}
