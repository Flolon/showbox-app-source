package com.tdo.showbox.data.torrent.stream;

import java.io.File;

public class TorrentOptions {
    public Boolean anonymousMode;
    public Integer listeningPort;
    public Integer maxConnections;
    public Integer maxDht;
    public Integer maxDownloadSpeed;
    public Integer maxUploadSpeed;
    public String peerFingerprint;
    public Long prepareSize;
    public String proxyHost;
    public String proxyPassword;
    public String proxyUsername;
    public Boolean removeFiles;
    public String saveLocation;

    public static class Builder {
        private TorrentOptions torrentOptions;

        public Builder() {
            this.torrentOptions = new TorrentOptions();
        }

        private Builder(TorrentOptions torrentOptions) {
            TorrentOptions torrentOptions2 = new TorrentOptions();
        }

        public Builder saveLocation(String str) {
            this.torrentOptions.saveLocation = str;
            return this;
        }

        public Builder saveLocation(File file) {
            this.torrentOptions.saveLocation = file.getAbsolutePath();
            return this;
        }

        public Builder maxUploadSpeed(Integer num) {
            this.torrentOptions.maxUploadSpeed = num;
            return this;
        }

        public Builder maxDownloadSpeed(Integer num) {
            this.torrentOptions.maxDownloadSpeed = num;
            return this;
        }

        public Builder maxConnections(Integer num) {
            this.torrentOptions.maxConnections = num;
            return this;
        }

        public Builder maxActiveDHT(Integer num) {
            this.torrentOptions.maxDht = num;
            return this;
        }

        public Builder removeFilesAfterStop(Boolean bool) {
            this.torrentOptions.removeFiles = bool;
            return this;
        }

        public Builder prepareSize(Long l) {
            this.torrentOptions.prepareSize = l;
            return this;
        }

        public Builder listeningPort(Integer num) {
            this.torrentOptions.listeningPort = num;
            return this;
        }

        public Builder proxy(String str, String str2, String str3) {
            this.torrentOptions.proxyHost = str;
            this.torrentOptions.proxyUsername = str2;
            this.torrentOptions.proxyPassword = str3;
            return this;
        }

        public Builder peerFingerprint(String str) {
            this.torrentOptions.peerFingerprint = str;
            this.torrentOptions.anonymousMode = Boolean.valueOf(false);
            return this;
        }

        public Builder anonymousMode(Boolean bool) {
            this.torrentOptions.anonymousMode = bool;
            if (this.torrentOptions.anonymousMode.booleanValue()) {
                this.torrentOptions.peerFingerprint = null;
            }
            return this;
        }

        public TorrentOptions build() {
            return this.torrentOptions;
        }
    }

    private TorrentOptions() {
        this.saveLocation = "/";
        this.maxDownloadSpeed = Integer.valueOf(0);
        this.maxUploadSpeed = Integer.valueOf(0);
        this.maxConnections = Integer.valueOf(200);
        this.maxDht = Integer.valueOf(88);
        this.listeningPort = Integer.valueOf(-1);
        this.removeFiles = Boolean.valueOf(false);
        this.anonymousMode = Boolean.valueOf(false);
        this.prepareSize = Long.valueOf(10485760);
    }

    private TorrentOptions(TorrentOptions torrentOptions) {
        this.saveLocation = "/";
        this.maxDownloadSpeed = Integer.valueOf(0);
        this.maxUploadSpeed = Integer.valueOf(0);
        this.maxConnections = Integer.valueOf(200);
        this.maxDht = Integer.valueOf(88);
        this.listeningPort = Integer.valueOf(-1);
        this.removeFiles = Boolean.valueOf(false);
        this.anonymousMode = Boolean.valueOf(false);
        this.prepareSize = Long.valueOf(10485760);
        this.saveLocation = torrentOptions.saveLocation;
        this.proxyHost = torrentOptions.proxyHost;
        this.proxyUsername = torrentOptions.proxyUsername;
        this.proxyPassword = torrentOptions.proxyPassword;
        this.peerFingerprint = torrentOptions.peerFingerprint;
        this.maxDownloadSpeed = torrentOptions.maxDownloadSpeed;
        this.maxUploadSpeed = torrentOptions.maxUploadSpeed;
        this.maxConnections = torrentOptions.maxConnections;
        this.maxDht = torrentOptions.maxDht;
        this.listeningPort = torrentOptions.listeningPort;
        this.removeFiles = torrentOptions.removeFiles;
        this.anonymousMode = torrentOptions.anonymousMode;
        this.prepareSize = torrentOptions.prepareSize;
    }

    public Builder toBuilder() {
        return new Builder();
    }
}
