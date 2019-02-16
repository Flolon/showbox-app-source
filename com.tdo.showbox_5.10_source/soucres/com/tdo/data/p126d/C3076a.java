package com.tdo.showbox.data.p126d;

import android.content.Context;
import com.activeandroid.query.Select;
import com.tdo.showbox.R;
import com.tdo.showbox.models.Category;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: SearchUtil */
/* renamed from: com.tdo.showbox.data.d.a */
public class C3076a {
    /* renamed from: a */
    public static void m16647a(Context context) {
        List execute = new Select().from(Category.class).orderBy("name ASC").execute();
        if (context != null && execute.size() == 0) {
            ArrayList arrayList = new ArrayList(Arrays.asList(context.getResources().getStringArray(R.array.genre_list)));
            for (int i = 0; i < arrayList.size(); i++) {
                Category category = new Category();
                category.setCatId("" + (i + 1));
                category.setName((String) arrayList.get(i));
                category.save();
            }
        }
    }

    /* renamed from: a */
    public static String m16646a(int i) {
        switch (i) {
            case 1:
                return "added";
            case 2:
                return "rating";
            case 3:
                return "imdb";
            default:
                return "rating";
        }
    }

    /* renamed from: b */
    public static String m16648b(int i) {
        switch (i) {
            case 1:
                return "rating";
            case 2:
                return "added";
            default:
                return "rating";
        }
    }
}
