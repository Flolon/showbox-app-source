package com.tdo.showbox.p131f;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.widget.Toast;
import com.tdo.showbox.R;
import com.tdo.showbox.activities.TrailerPlayActivity;

/* compiled from: ShareUtils */
/* renamed from: com.tdo.showbox.f.i */
public class C3182i {
    /* renamed from: a */
    public static Intent m16978a(Context context, Intent intent) {
        try {
            if (!context.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
                return intent;
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: a */
    public static void m16979a(Context context, String str) {
        try {
            if (!C3178f.m16973b(context)) {
                Toast.makeText(context, context.getResources().getString(R.string.error_connection), 0).show();
            } else if (VERSION.SDK_INT < 11) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube://" + str)));
            } else {
                Intent intent = new Intent(context, TrailerPlayActivity.class);
                intent.putExtra("ARG_ID", str);
                context.startActivity(intent);
            }
        } catch (Exception e) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + str)));
            } catch (Exception e2) {
            }
        }
    }
}
