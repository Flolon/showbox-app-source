package com.tdo.showbox.data.torrent.stream.exceptions;

public class TorrentInfoException extends Exception {
    public TorrentInfoException() {
        super("No torrent info could be found or read");
    }
}
