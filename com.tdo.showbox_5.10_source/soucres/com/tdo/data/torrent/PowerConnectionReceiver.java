package com.tdo.showbox.data.torrent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class PowerConnectionReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            int intExtra = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
            boolean z = intExtra == 2 || intExtra == 5;
            TorrentAutoDownloader.m16862b(context, z);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
