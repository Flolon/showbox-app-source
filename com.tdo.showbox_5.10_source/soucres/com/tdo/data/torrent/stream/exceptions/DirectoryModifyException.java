package com.tdo.showbox.data.torrent.stream.exceptions;

public class DirectoryModifyException extends Exception {
    public DirectoryModifyException() {
        super("Could not create or delete save directory");
    }
}
