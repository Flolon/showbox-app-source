package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import java.util.List;

@Table(name = "Episods")
public class Episod extends Model {
    @Column(name = "active")
    private long active = 0;
    @Column(name = "delay")
    private long delay = 0;
    @Column(name = "episode_id")
    private long episode_id = 0;
    @Column(name = "epizode_title")
    private String epizode_title;
    @Column(name = "mov_id")
    private long mov_id = 0;
    @Column(name = "movie_progress")
    private long movie_progress = 0;
    @Column(name = "part_last_number")
    private int part_last_number = 0;
    @Column(name = "part_progress")
    private long part_progress = 0;
    @Column(name = "season_num")
    private long season_num = 0;
    private List<BaseVideoSource> sourceList;
    @Column(name = "source_id")
    private long source_id;
    @Column(name = "thumb")
    private String thumb = "";
    @Column(name = "title")
    private String title = "";

    public long getDownloadID() {
        try {
            return getEpisode_id() + ((long) this.title.hashCode());
        } catch (Exception e) {
            return -1;
        }
    }

    public void setVideoSource(BaseVideoSource baseVideoSource) {
        if (baseVideoSource == null) {
            return;
        }
        if (baseVideoSource.getId() != null) {
            setSource_id(baseVideoSource.getId().longValue());
            return;
        }
        baseVideoSource.save();
        setSource_id(baseVideoSource.getId().longValue());
    }

    public BaseVideoSource getVideoSource() {
        return (BaseVideoSource) new Select().from(BaseVideoSource.class).where("Id=" + getSource_id()).executeSingle();
    }

    public List<BaseVideoSource> getSourceList() {
        return this.sourceList;
    }

    public void setSourceList(List<BaseVideoSource> list) {
        this.sourceList = list;
    }

    public long getActive() {
        return this.active;
    }

    public void setActive(long j) {
        this.active = j;
    }

    public long getSource_id() {
        return this.source_id;
    }

    public void setSource_id(long j) {
        this.source_id = j;
    }

    public long getDelay() {
        return this.delay;
    }

    public void setDelay(long j) {
        this.delay = j;
    }

    public String getEpizode_title() {
        return this.epizode_title;
    }

    public void setEpizode_title(String str) {
        this.epizode_title = str;
    }

    public long getMovieProgress() {
        return this.movie_progress;
    }

    public void setMovieProgress(long j) {
        this.movie_progress = j;
    }

    public long getMovId() {
        return this.mov_id;
    }

    public void setMovId(long j) {
        this.mov_id = j;
    }

    public long getSeasonNum() {
        return this.season_num;
    }

    public void setSeasonNum(long j) {
        this.season_num = j;
    }

    public long getEpisode_id() {
        return this.episode_id;
    }

    public void setEpisode_id(long j) {
        this.episode_id = j;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getThumb() {
        return this.thumb;
    }

    public void setThumb(String str) {
        this.thumb = str;
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
