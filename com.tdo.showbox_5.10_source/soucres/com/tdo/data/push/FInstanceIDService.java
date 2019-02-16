package com.tdo.showbox.data.push;

import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.tdo.showbox.data.C3088f;

public class FInstanceIDService extends FirebaseInstanceIdService {
    /* renamed from: a */
    public void mo2137a() {
        String d = FirebaseInstanceId.m11699a().m11713d();
        Log.d("FirebasePush", "Refreshed token: " + d);
        m16826a(d);
    }

    /* renamed from: a */
    private void m16826a(String str) {
        C3088f.m16679a("PREFS_PUSH_REG_ID", str);
        C3088f.m16680a("PREFS_NEED_UPDATE_PUSH_REG_ID", true);
    }
}
