package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.data.p114e.p127a.C3078a;
import com.tdo.showbox.p131f.C3176e;
import java.io.FileInputStream;
import java.io.Serializable;

@Table(name = "Subtitles")
public class Subtitle extends Model implements Serializable {
    @Column(name = "IDSubtitleFile")
    private String IDSubtitleFile;
    @Column(name = "LanguageName")
    private String LanguageName;
    @Column(name = "MovieReleaseName")
    private String MovieReleaseName;
    @Column(name = "MovieYear")
    private String MovieYear;
    @Column(name = "SubAddDate")
    private String SubAddDate;
    @Column(name = "SubDownloadsCnt")
    private String SubDownloadsCnt;
    @Column(name = "SubFileName")
    private String SubFileName;
    @Column(name = "UserNickName")
    private String UserNickName;
    @Column(name = "ZipDownloadLink")
    private String ZipDownloadLink;
    @Column(name = "file")
    private String file;
    @Column(name = "file_en")
    private String file_en;
    @Column(name = "imdb_id")
    private String imdb_id;
    @Column(name = "is_downloaded")
    private int is_downloaded;
    @Column(name = "is_movie")
    private int is_movie;
    @Column(name = "item_id")
    private String item_id;
    @Column(name = "lang")
    private String lang;
    @Column(name = "parrent_id")
    private String parrent_id;
    private long partDelay;

    public void init(Subtitle subtitle) {
        this.item_id = subtitle.getItem_id();
        this.parrent_id = subtitle.getParrent_id();
        this.lang = subtitle.getLang();
        this.file = subtitle.getFile();
        this.LanguageName = subtitle.getLanguageName();
        this.imdb_id = subtitle.getImdb_id();
        this.SubAddDate = subtitle.getSubAddDate();
        this.ZipDownloadLink = subtitle.getZipDownloadLink();
        this.SubFileName = subtitle.getSubFileName();
        this.UserNickName = subtitle.getUserNickName();
        this.MovieReleaseName = subtitle.getMovieReleaseName();
        this.is_movie = subtitle.getIs_movie();
        this.is_downloaded = subtitle.getIs_downloaded();
        this.MovieYear = subtitle.getMovieYear();
        this.SubDownloadsCnt = subtitle.getSubDownloadsCnt();
        this.IDSubtitleFile = subtitle.getIDSubtitleFile();
        this.file_en = subtitle.getFile_en();
        this.partDelay = 0;
    }

    public void processDelays(int i) {
        if (this.file != null) {
            C3094j.m16698a("Subtitle", "ENG Dalay: " + i);
            this.file_en = this.file + "en.srt";
            try {
                C3176e.m16966a(this.file_en, new FileInputStream(this.file));
                if (i > 0) {
                    C3078a.m16652a(this.file_en, i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public long getPartDelay() {
        return this.partDelay;
    }

    public void setPartDelay(long j) {
        this.partDelay = j;
    }

    public String getFile_en() {
        return this.file_en;
    }

    public void setFile_en(String str) {
        this.file_en = str;
    }

    public String getIDSubtitleFile() {
        return this.IDSubtitleFile;
    }

    public void setIDSubtitleFile(String str) {
        this.IDSubtitleFile = str;
    }

    public String getSubDownloadsCnt() {
        return this.SubDownloadsCnt;
    }

    public void setSubDownloadsCnt(String str) {
        this.SubDownloadsCnt = str;
    }

    public String getMovieYear() {
        return this.MovieYear;
    }

    public void setMovieYear(String str) {
        this.MovieYear = str;
    }

    public int getIs_downloaded() {
        return this.is_downloaded;
    }

    public void setIs_downloaded(int i) {
        this.is_downloaded = i;
    }

    public int getIs_movie() {
        return this.is_movie;
    }

    public void setIs_movie(int i) {
        this.is_movie = i;
    }

    public String getParrent_id() {
        return this.parrent_id;
    }

    public void setParrent_id(String str) {
        this.parrent_id = str;
    }

    public String getItem_id() {
        return this.item_id;
    }

    public void setItem_id(String str) {
        this.item_id = str;
    }

    public String getImdb_id() {
        if (this.imdb_id == null) {
            return "";
        }
        return this.imdb_id;
    }

    public void setImdb_id(String str) {
        this.imdb_id = str;
    }

    public String getMovieReleaseName() {
        if (this.MovieReleaseName == null) {
            return "";
        }
        return this.MovieReleaseName;
    }

    public void setMovieReleaseName(String str) {
        this.MovieReleaseName = str;
    }

    public String getLanguageName() {
        if (this.LanguageName == null) {
            this.LanguageName = "";
        }
        return this.LanguageName;
    }

    public void setLanguageName(String str) {
        this.LanguageName = str;
    }

    public String getSubAddDate() {
        return this.SubAddDate;
    }

    public void setSubAddDate(String str) {
        this.SubAddDate = str;
    }

    public String getZipDownloadLink() {
        return this.ZipDownloadLink;
    }

    public void setZipDownloadLink(String str) {
        this.ZipDownloadLink = str;
    }

    public String getSubFileName() {
        return this.SubFileName;
    }

    public void setSubFileName(String str) {
        this.SubFileName = str;
    }

    public String getUserNickName() {
        if (this.UserNickName == null) {
            return "";
        }
        return this.UserNickName;
    }

    public void setUserNickName(String str) {
        this.UserNickName = str;
    }

    public String getLang() {
        if (this.lang == null) {
            return "";
        }
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String str) {
        this.file = str;
    }
}
