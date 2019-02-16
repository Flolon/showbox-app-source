package com.tdo.showbox.data.torrent.stream;

public class StreamStatus {
    public final int bufferProgress;
    public final float downloadSpeed;
    public final float progress;
    public final int seeds;

    protected StreamStatus(float f, int i, int i2, int i3) {
        this.progress = f;
        this.bufferProgress = i;
        this.seeds = i2;
        this.downloadSpeed = (float) i3;
    }
}
