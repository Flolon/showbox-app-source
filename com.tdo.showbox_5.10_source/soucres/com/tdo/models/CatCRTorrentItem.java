package com.tdo.showbox.models;

import java.util.HashMap;
import java.util.Map;

public class CatCRTorrentItem {
    private Map<String, Object> additionalProperties = new HashMap();
    private String category;
    private long comments;
    private long files;
    private String guid;
    private String hash;
    private long leechs;
    private String link;
    private long peers;
    private String pubDate;
    private long seeds;
    private long size;
    private String title;
    private String torrentLink;
    private long verified;
    private long votes;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public String getPubDate() {
        return this.pubDate;
    }

    public void setPubDate(String str) {
        this.pubDate = str;
    }

    public String getTorrentLink() {
        return this.torrentLink;
    }

    public void setTorrentLink(String str) {
        this.torrentLink = str;
    }

    public long getFiles() {
        return this.files;
    }

    public void setFiles(long j) {
        this.files = j;
    }

    public long getComments() {
        return this.comments;
    }

    public void setComments(Integer num) {
        this.comments = (long) num.intValue();
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public long getPeers() {
        return this.peers;
    }

    public void setPeers(long j) {
        this.peers = j;
    }

    public long getSeeds() {
        return this.seeds;
    }

    public void setSeeds(long j) {
        this.seeds = j;
    }

    public long getLeechs() {
        return this.leechs;
    }

    public void setLeechs(long j) {
        this.leechs = j;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public long getVotes() {
        return this.votes;
    }

    public void setVotes(long j) {
        this.votes = j;
    }

    public long getVerified() {
        return this.verified;
    }

    public void setVerified(long j) {
        this.verified = j;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
