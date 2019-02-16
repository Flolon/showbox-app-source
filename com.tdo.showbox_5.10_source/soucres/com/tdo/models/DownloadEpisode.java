package com.tdo.showbox.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "DownloadEpisodes")
public class DownloadEpisode extends Model implements Parcelable {
    public static final Creator<DownloadEpisode> CREATOR = new C32461();
    @Column(name = "auto")
    private int auto;
    @Column(name = "cookies")
    private String cookies;
    @Column(name = "episode_id")
    private long episode_id;
    @Column(name = "episode_num")
    private int episode_num;
    @Column(name = "file_size")
    private long file_size;
    @Column(name = "full_path")
    private String full_path;
    @Column(name = "isDeleted")
    private int isDeleted;
    @Column(name = "is_downloading")
    private int is_downloading;
    @Column(name = "is_movie")
    private int is_movie;
    @Column(name = "is_viewed")
    private int is_viewed;
    @Column(name = "link")
    private String link;
    @Column(name = "need_pause")
    private int need_pause;
    @Column(name = "part_last_number")
    private int part_last_number;
    @Column(name = "part_progress")
    private long part_progress;
    private List<PartVideo> parts;
    @Column(name = "parttitle")
    private String parttitle;
    @Column(name = "percent")
    private int percent;
    @Column(name = "poster")
    private String poster;
    @Column(name = "progress")
    private long progress;
    @Column(name = "quality")
    private int quality;
    @Column(name = "season_num")
    private int season_num;
    @Column(name = "shows_info")
    private String shows_info;
    @Column(name = "size")
    private long size;
    @Column(name = "static_link")
    private String static_link;
    @Column(name = "status")
    private int status;
    @Column(name = "subtitle_id")
    private String subtitle_id;
    @Column(name = "title")
    private String title;
    @Column(name = "video_source")
    private int video_source;
    @Column(name = "view_position")
    private long view_position;

    /* renamed from: com.tdo.showbox.models.DownloadEpisode$1 */
    static class C32461 implements Creator<DownloadEpisode> {
        C32461() {
        }

        public DownloadEpisode createFromParcel(Parcel parcel) {
            return new DownloadEpisode(parcel);
        }

        public DownloadEpisode[] newArray(int i) {
            return new DownloadEpisode[i];
        }
    }

    public DownloadEpisode() {
        this.poster = "";
        this.title = "";
        this.episode_id = 0;
        this.link = "";
        this.progress = 0;
        this.size = 0;
        this.percent = 0;
        this.full_path = "";
        this.is_downloading = 0;
        this.need_pause = 0;
        this.isDeleted = 0;
        this.view_position = 0;
        this.file_size = 0;
        this.quality = 0;
        this.static_link = "";
        this.is_movie = 0;
        this.season_num = 0;
        this.episode_num = 0;
        this.status = -1;
        this.subtitle_id = "";
        this.cookies = "";
        this.video_source = 3;
        this.parts = null;
        this.parttitle = "";
        this.part_progress = 0;
        this.part_last_number = 0;
        this.auto = 0;
        this.is_viewed = 0;
    }

    public int getIs_viewed() {
        return this.is_viewed;
    }

    public void setIs_viewed(int i) {
        this.is_viewed = i;
    }

    public int getAuto() {
        return this.auto;
    }

    public void setAuto(int i) {
        this.auto = i;
    }

    public List<PartVideo> getParts() {
        return this.parts;
    }

    public void setParts(List<PartVideo> list) {
        this.parts = list;
    }

    public String getStatic_link() {
        return this.static_link;
    }

    public void setStatic_link(String str) {
        this.static_link = str;
    }

    public int getVideo_source() {
        return this.video_source;
    }

    public void setVideo_source(int i) {
        this.video_source = i;
    }

    public String getCookies() {
        return this.cookies;
    }

    public void setCookies(String str) {
        this.cookies = str;
    }

    public String getSubtitle_id() {
        return this.subtitle_id;
    }

    public void setSubtitle_id(String str) {
        this.subtitle_id = str;
    }

    public int isDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(int i) {
        this.isDeleted = i;
    }

    public int getEpisode_num() {
        return this.episode_num;
    }

    public void setEpisode_num(int i) {
        this.episode_num = i;
    }

    public int getSeason_num() {
        return this.season_num;
    }

    public void setSeason_num(int i) {
        this.season_num = i;
    }

    public int getIs_movie() {
        return this.is_movie;
    }

    public void setIs_movie(int i) {
        this.is_movie = i;
    }

    public int getQuality() {
        return this.quality;
    }

    public void setQuality(int i) {
        this.quality = i;
    }

    public String getShows_info() {
        return this.shows_info;
    }

    public void setShows_info(String str) {
        this.shows_info = str;
    }

    public long getFile_size() {
        return this.file_size;
    }

    public void setFile_size(long j) {
        this.file_size = j;
    }

    public long getView_position() {
        return this.view_position;
    }

    public void setView_position(long j) {
        this.view_position = j;
    }

    public void setNeed_pause(int i) {
        this.need_pause = i;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String str) {
        this.poster = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public long getEpisode_id() {
        return this.episode_id;
    }

    public void setEpisode_id(long j) {
        this.episode_id = j;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public long getProgress() {
        return this.progress;
    }

    public void setProgress(long j) {
        this.progress = j;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public int getPercent() {
        return this.percent;
    }

    public void setPercent(int i) {
        this.percent = i;
    }

    public String getFull_path() {
        return this.full_path;
    }

    public void setFull_path(String str) {
        this.full_path = str;
    }

    public int isIs_downloading() {
        return this.is_downloading;
    }

    public void setIs_downloading(int i) {
        this.is_downloading = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.full_path);
        parcel.writeString(this.link);
        parcel.writeString(this.poster);
        parcel.writeString(this.title);
        parcel.writeLong(this.episode_id);
        parcel.writeLong(this.progress);
        parcel.writeLong(this.size);
        parcel.writeInt(this.percent);
        parcel.writeInt(this.is_downloading);
        parcel.writeInt(this.need_pause);
        parcel.writeLong(this.file_size);
        if (this.shows_info == null) {
            this.shows_info = "";
        }
        parcel.writeString(this.shows_info);
        parcel.writeInt(this.quality);
        parcel.writeString(this.static_link);
        parcel.writeInt(this.is_movie);
        parcel.writeInt(this.season_num);
        parcel.writeInt(this.episode_num);
        parcel.writeString(this.subtitle_id);
        parcel.writeInt(this.isDeleted);
        parcel.writeString(this.cookies);
        parcel.writeInt(this.video_source);
        parcel.writeTypedList(this.parts);
        parcel.writeString(this.parttitle);
        parcel.writeLong(this.part_progress);
        parcel.writeInt(this.part_last_number);
        parcel.writeInt(this.auto);
        parcel.writeInt(this.is_viewed);
    }

    private DownloadEpisode(Parcel parcel) {
        this.full_path = parcel.readString();
        this.link = parcel.readString();
        this.poster = parcel.readString();
        this.title = parcel.readString();
        this.episode_id = parcel.readLong();
        this.progress = parcel.readLong();
        this.size = parcel.readLong();
        this.percent = parcel.readInt();
        this.is_downloading = parcel.readInt();
        this.need_pause = parcel.readInt();
        this.file_size = parcel.readLong();
        this.shows_info = parcel.readString();
        this.quality = parcel.readInt();
        this.static_link = parcel.readString();
        this.is_movie = parcel.readInt();
        this.season_num = parcel.readInt();
        this.episode_num = parcel.readInt();
        this.subtitle_id = parcel.readString();
        this.isDeleted = parcel.readInt();
        this.cookies = parcel.readString();
        this.video_source = parcel.readInt();
        this.parts = new ArrayList();
        parcel.readTypedList(this.parts, PartVideo.CREATOR);
        this.parttitle = parcel.readString();
        this.part_progress = parcel.readLong();
        this.part_last_number = parcel.readInt();
        this.auto = parcel.readInt();
        this.is_viewed = parcel.readInt();
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getParttitle() {
        return this.parttitle;
    }

    public void setParttitle(String str) {
        this.parttitle = str;
    }

    public long getPart_progress() {
        return this.part_progress;
    }

    public void setPart_progress(long j) {
        this.part_progress = j;
    }

    public int getPart_last_number() {
        return this.part_last_number;
    }

    public void setPart_last_number(int i) {
        this.part_last_number = i;
    }
}
