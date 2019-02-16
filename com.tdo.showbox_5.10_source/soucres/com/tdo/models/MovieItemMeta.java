package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import java.util.HashMap;
import java.util.Map;

@Table(name = "MovieItemMetas")
public class MovieItemMeta extends Model {
    private Map<String, Object> additionalProperties = new HashMap();
    @Column(name = "last_cached_time")
    private long last_cached_time;
    @Column(name = "movie_id")
    private String movie_id;
    @Column(name = "movie_progress")
    private long movie_progress;
    @Column(name = "part_last_number")
    private int part_last_number;
    @Column(name = "part_progress")
    private long part_progress;
    @Column(name = "raw_json")
    private String raw_json;
    @Column(name = "source_id")
    private long source_id;

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

    public String getRaw_json() {
        return this.raw_json;
    }

    public void setRaw_json(String str) {
        this.raw_json = str;
    }

    public long getSource_id() {
        return this.source_id;
    }

    public void setSource_id(long j) {
        this.source_id = j;
    }

    public long getLast_cached_time() {
        return this.last_cached_time;
    }

    public void setLast_cached_time(long j) {
        this.last_cached_time = j;
    }

    public long getMovie_progress() {
        return this.movie_progress;
    }

    public void setMovie_progress(long j) {
        this.movie_progress = j;
    }

    public String getMovieId() {
        return this.movie_id;
    }

    public void setMovieId(String str) {
        this.movie_id = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(String str, Object obj) {
        this.additionalProperties.put(str, obj);
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
