package com.tdo.showbox.data.torrent.stream.listeners;

import com.tdo.showbox.data.torrent.stream.StreamStatus;
import com.tdo.showbox.data.torrent.stream.Torrent;

public interface TorrentListener {
    void onStreamError(Torrent torrent, Exception exception);

    void onStreamPrepared(Torrent torrent);

    void onStreamProgress(Torrent torrent, StreamStatus streamStatus);

    void onStreamReady(Torrent torrent);

    void onStreamStarted(Torrent torrent);

    void onStreamStopped();
}
