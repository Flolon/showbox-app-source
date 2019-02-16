package com.tdo.showbox.data.torrent.stream.utils;

import android.os.Handler;
import android.os.Looper;

public final class ThreadUtils {
    private ThreadUtils() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            new Handler(Looper.getMainLooper()).post(runnable);
        } else {
            runnable.run();
        }
    }
}
