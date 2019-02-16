package com.tdo.showbox.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "PartVideos")
public class PartVideo extends Model implements Parcelable {
    public static final Creator<PartVideo> CREATOR = new C32471();
    public static final int TYPE_DOWNLOAD = 2;
    public static final int TYPE_STREAM = 1;
    public static final int TYPE_UNDEFINED = 0;
    @Column(name = "cookies")
    private String cookies;
    @Column(name = "file_size")
    private long file_size;
    @Column(name = "full_hd_link")
    protected String full_hd_link;
    @Column(name = "full_path")
    private String full_path;
    @Column(name = "hd_link")
    protected String hd_link;
    @Column(name = "is_downloading")
    private int is_downloading;
    @Column(name = "link")
    protected String link;
    @Column(name = "low_link")
    protected String low_link;
    @Column(name = "mid_link")
    protected String mid_link;
    @Column(name = "need_pause")
    private int need_pause;
    @Column(name = "number")
    private int number;
    @Column(name = "parrentId")
    private long parrentId;
    @Column(name = "parttype")
    private int parttype;
    @Column(name = "percent")
    private int percent;
    @Column(name = "progress")
    private long progress;
    @Column(name = "quality")
    private int quality;
    @Column(name = "size")
    private long size;
    @Column(name = "staticLink")
    private String staticLink;
    @Column(name = "status")
    private int status;

    /* renamed from: com.tdo.showbox.models.PartVideo$1 */
    static class C32471 implements Creator<PartVideo> {
        C32471() {
        }

        public PartVideo createFromParcel(Parcel parcel) {
            return new PartVideo(parcel);
        }

        public PartVideo[] newArray(int i) {
            return new PartVideo[i];
        }
    }

    public static PartVideo copy(PartVideo partVideo) {
        PartVideo partVideo2 = new PartVideo();
        partVideo2.setCookies(partVideo.getCookies());
        partVideo2.setFile_size(partVideo.getFile_size());
        partVideo2.setFull_hd_link(partVideo.getFull_hd_link());
        partVideo2.setFull_path(partVideo.getFull_path());
        partVideo2.setHd_link(partVideo.getHd_link());
        partVideo2.setIs_downloading(partVideo.getIs_downloading());
        partVideo2.setLink(partVideo.getLink());
        partVideo2.setLow_link(partVideo.getLow_link());
        partVideo2.setMid_link(partVideo.getMid_link());
        partVideo2.setNeed_pause(partVideo.getNeed_pause());
        partVideo2.setNumber(partVideo.getNumber());
        partVideo2.setParrentId(partVideo.getParrentId());
        partVideo2.setParttype(partVideo.getParttype());
        partVideo2.setPercent(partVideo.getPercent());
        partVideo2.setProgress(partVideo.getProgress());
        partVideo2.setQuality(partVideo.getQuality());
        partVideo2.setSize(partVideo.getSize());
        partVideo2.setStaticLink(partVideo.getStaticLink());
        partVideo2.setStatus(partVideo.getStatus());
        return partVideo2;
    }

    public PartVideo() {
        this.progress = 0;
        this.size = 0;
        this.full_path = "";
        this.is_downloading = 0;
        this.staticLink = "";
        this.need_pause = 0;
        this.quality = 0;
        this.status = -1;
        this.low_link = "";
        this.mid_link = "";
        this.hd_link = "";
        this.full_hd_link = "";
        this.parttype = 0;
        this.number = 0;
        this.percent = 0;
        this.cookies = "";
        this.link = "";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.full_path);
        parcel.writeLong(this.progress);
        parcel.writeLong(this.size);
        parcel.writeInt(this.is_downloading);
        parcel.writeInt(this.need_pause);
        parcel.writeInt(this.quality);
        parcel.writeString(this.staticLink);
        parcel.writeInt(this.status);
        parcel.writeLong(this.parrentId);
        parcel.writeString(this.low_link);
        parcel.writeString(this.mid_link);
        parcel.writeString(this.hd_link);
        parcel.writeString(this.full_hd_link);
        parcel.writeInt(this.parttype);
        parcel.writeInt(this.number);
        parcel.writeInt(this.percent);
        parcel.writeString(this.cookies);
        parcel.writeString(this.link);
        parcel.writeLong(this.file_size);
    }

    private PartVideo(Parcel parcel) {
        this.full_path = parcel.readString();
        this.progress = parcel.readLong();
        this.size = parcel.readLong();
        this.is_downloading = parcel.readInt();
        this.need_pause = parcel.readInt();
        this.quality = parcel.readInt();
        this.staticLink = parcel.readString();
        this.status = parcel.readInt();
        this.parrentId = parcel.readLong();
        this.low_link = parcel.readString();
        this.mid_link = parcel.readString();
        this.hd_link = parcel.readString();
        this.full_hd_link = parcel.readString();
        this.parttype = parcel.readInt();
        this.number = parcel.readInt();
        this.percent = parcel.readInt();
        this.cookies = parcel.readString();
        this.link = parcel.readString();
        this.file_size = parcel.readLong();
    }

    public long getParrentId() {
        return this.parrentId;
    }

    public void setParrentId(long j) {
        this.parrentId = j;
    }

    public String getStaticLink() {
        return this.staticLink;
    }

    public void setStaticLink(String str) {
        this.staticLink = str;
    }

    public int getQuality() {
        return this.quality;
    }

    public void setQuality(int i) {
        this.quality = i;
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

    public String getFull_path() {
        return this.full_path;
    }

    public void setFull_path(String str) {
        this.full_path = str;
    }

    public int getIs_downloading() {
        return this.is_downloading;
    }

    public void setIs_downloading(int i) {
        this.is_downloading = i;
    }

    public int getNeed_pause() {
        return this.need_pause;
    }

    public void setNeed_pause(int i) {
        this.need_pause = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getParttype() {
        return this.parttype;
    }

    public void setParttype(int i) {
        this.parttype = i;
    }

    public String getLow_link() {
        return this.low_link;
    }

    public void setLow_link(String str) {
        this.low_link = str;
    }

    public String getMid_link() {
        return this.mid_link;
    }

    public void setMid_link(String str) {
        this.mid_link = str;
    }

    public String getHd_link() {
        return this.hd_link;
    }

    public void setHd_link(String str) {
        this.hd_link = str;
    }

    public String getFull_hd_link() {
        return this.full_hd_link;
    }

    public void setFull_hd_link(String str) {
        this.full_hd_link = str;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int i) {
        this.number = i;
    }

    public int getPercent() {
        return this.percent;
    }

    public void setPercent(int i) {
        this.percent = i;
    }

    public String getCookies() {
        return this.cookies;
    }

    public void setCookies(String str) {
        this.cookies = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public long getFile_size() {
        return this.file_size;
    }

    public void setFile_size(long j) {
        this.file_size = j;
    }
}
