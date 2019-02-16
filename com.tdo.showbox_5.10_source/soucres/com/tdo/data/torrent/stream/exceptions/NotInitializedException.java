package com.tdo.showbox.data.torrent.stream.exceptions;

public class NotInitializedException extends Exception {
    public NotInitializedException() {
        super("TorrentStreamer is not initialized. Call init() first before getting an instance.");
    }
}
