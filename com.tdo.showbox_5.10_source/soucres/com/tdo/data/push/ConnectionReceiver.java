package com.tdo.showbox.data.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.activeandroid.query.Select;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.torrent.TorrentAutoDownloader;
import com.tdo.showbox.models.topic.DelayedPush;
import com.tdo.showbox.p131f.C3178f;
import org.json.JSONObject;

public class ConnectionReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C3094j.m16698a("Scheduler", "ConnectionReceiver onReceive");
        AlarmSchedulerReceiver.m16824a(context.getApplicationContext());
        try {
            int a = C3178f.m16971a(context);
            TorrentAutoDownloader.m16857a(context, a == 2);
            if (a != 0) {
                DelayedPush delayedPush = (DelayedPush) new Select().from(DelayedPush.class).executeSingle();
                if (delayedPush != null && delayedPush.getShow_when_inet() && FMessagingService.m16830a(context, new JSONObject(delayedPush.getData()), delayedPush.getFrom())) {
                    delayedPush.delete();
                }
            }
        } catch (Exception e) {
        }
    }
}
