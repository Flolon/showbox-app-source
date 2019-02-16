package com.tdo.showbox.data.p119b;

import android.text.TextUtils;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.models.AppConfig;
import java.util.ArrayList;

/* compiled from: AdsAttemptsConfig */
/* renamed from: com.tdo.showbox.data.b.f */
public class C3046f {
    /* renamed from: a */
    private int f11954a = 3;
    /* renamed from: b */
    private int f11955b = 1;
    /* renamed from: c */
    private int f11956c = 2;

    /* renamed from: a */
    public void m16481a(AppConfig appConfig) {
        if (appConfig != null) {
            String a = C3088f.m16675a("PREF_COUNTRY_ISO");
            if (!TextUtils.isEmpty(a)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(appConfig.getRectangle_pos_1());
                arrayList.add(appConfig.getRectangle_pos_2());
                for (int i = 0; i < arrayList.size(); i++) {
                    String str = (String) arrayList.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        for (Object equals : str.split(",")) {
                            if (a.equals(equals)) {
                                this.f11956c = i;
                                break;
                            }
                        }
                    }
                }
                Object banner_pos_1 = appConfig.getBanner_pos_1();
                if (!TextUtils.isEmpty(banner_pos_1)) {
                    for (Object equals2 : banner_pos_1.split(",")) {
                        if (a.equals(equals2)) {
                            this.f11955b = 0;
                            return;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public int m16480a() {
        return this.f11954a;
    }

    /* renamed from: b */
    public int m16482b() {
        return this.f11955b;
    }

    /* renamed from: c */
    public int m16483c() {
        return this.f11956c;
    }
}
