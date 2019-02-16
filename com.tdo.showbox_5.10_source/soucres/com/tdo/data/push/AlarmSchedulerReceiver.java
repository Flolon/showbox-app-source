package com.tdo.showbox.data.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.activeandroid.query.Select;
import com.tdo.showbox.data.C3088f;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.torrent.TorrentAutoDownloader;
import com.tdo.showbox.models.topic.CurrentTopicScheme;
import com.tdo.showbox.models.topic.DelayedPush;
import com.tdo.showbox.p131f.C3178f;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONObject;

public class AlarmSchedulerReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C3094j.m16698a("Scheduler", "AlarmSchedulerReceiver onReceive. Check for push");
        TorrentAutoDownloader.m16852a(context);
        DelayedPush delayedPush = (DelayedPush) new Select().from(DelayedPush.class).executeSingle();
        if (delayedPush != null) {
            Calendar instance = Calendar.getInstance(Locale.US);
            int i = instance.get(7);
            int i2 = instance.get(11);
            C3094j.m16698a("Scheduler", "AlarmSchedulerReceiver onReceive. Date: " + i + ":" + i2);
            CurrentTopicScheme currentTopicScheme = (CurrentTopicScheme) new Select().from(CurrentTopicScheme.class).executeSingle();
            if (currentTopicScheme == null) {
                m16825a(context, delayedPush);
                return;
            }
            int optimalTimeForDay = currentTopicScheme.getOptimalTimeForDay(i);
            C3094j.m16698a("Scheduler", "AlarmSchedulerReceiver onReceive. Optimal time: " + optimalTimeForDay);
            if (i != delayedPush.getDay_push_delivered()) {
                if (i2 >= optimalTimeForDay) {
                    m16825a(context, delayedPush);
                }
            } else if (Math.abs(i2 - optimalTimeForDay) < 2) {
                m16825a(context, delayedPush);
            }
        }
    }

    /* renamed from: a */
    private void m16825a(Context context, DelayedPush delayedPush) {
        try {
            C3094j.m16698a("Scheduler", "AlarmSchedulerReceiver onReceive. try to show push");
            if (!C3178f.m16973b(context)) {
                delayedPush.setShow_when_inet(true);
                delayedPush.save();
            } else if (FMessagingService.m16830a(context, new JSONObject(delayedPush.getData()), delayedPush.getFrom())) {
                delayedPush.delete();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m16824a(Context context) {
        int i = 1;
        Intent intent = new Intent(context, AlarmSchedulerReceiver.class);
        boolean z = PendingIntent.getBroadcast(context, 0, intent, 536870912) != null;
        C3094j.m16698a("Scheduler", "ConnectionReceiver alarm is working: " + z);
        long d = C3088f.m16685d("PREF_LAST_PUSH_SCHEDULER_START");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - d > 7200000) {
            C3094j.m16698a("Scheduler", "ConnectionReceiver force restart");
            C3088f.m16678a("PREF_LAST_PUSH_SCHEDULER_START", currentTimeMillis);
        } else {
            i = 0;
        }
        if (!z || r4 != 0) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 134217728);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            C3094j.m16698a("Scheduler", "ConnectionReceiver Notification every: 3600000");
            alarmManager.cancel(broadcast);
            alarmManager.setRepeating(0, 3600000, 3600000, broadcast);
        }
    }
}
