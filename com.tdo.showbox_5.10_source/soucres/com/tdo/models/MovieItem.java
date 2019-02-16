package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.tdo.showbox.data.p124a.C2982e;
import com.tdo.showbox.models.videosources.BaseVideoSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Table(name = "MovieItems")
public class MovieItem extends Model {
    @Column(name = "active")
    private String active;
    private Map<String, Object> additionalProperties = new HashMap();
    @Column(name = "cats")
    private String cats;
    @Column(name = "description")
    private String description;
    @Column(name = "details_id")
    private String details_id;
    @Column(name = "from_push")
    private int from_push;
    @Column(name = "imdb_id")
    private String imdb_id;
    @Column(name = "imdb_rating")
    private String imdb_rating;
    @Column(name = "in_lib")
    private int in_lib;
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
    @Column(name = "poster")
    private String poster;
    @Column(name = "poster_hires")
    private String poster_hires;
    @Column(name = "prefered_server_id")
    private int prefered_server_id = -1;
    @Column(name = "rating")
    private String rating;
    @Column(name = "raw_json")
    private String raw_json;
    @Column(name = "recommend")
    private String recommend;
    private List<MovieItem> see_also;
    @Column(name = "see_also_array")
    private String see_also_array;
    private List<BaseVideoSource> sourceList;
    @Column(name = "source_id")
    private long source_id;
    @Column(name = "title")
    private String title;
    @Column(name = "trailer")
    private String trailer;
    @Column(name = "year")
    private String year;

    public String getSee_also_array() {
        return this.see_also_array;
    }

    public void setSee_also_array(String str) {
        this.see_also_array = str;
    }

    public int getFrom_push() {
        return this.from_push;
    }

    public void setFrom_push(int i) {
        this.from_push = i;
    }

    public long getDownloadID() {
        try {
            return (long) (getMovieId().hashCode() + this.title.hashCode());
        } catch (Exception e) {
            return -1;
        }
    }

    public String getPoster_hires() {
        return this.poster_hires;
    }

    public void setPoster_hires(String str) {
        this.poster_hires = str;
    }

    public List<BaseVideoSource> getSourceList() {
        return this.sourceList;
    }

    public void setSourceList(List<BaseVideoSource> list) {
        this.sourceList = list;
    }

    public String getImdb_id() {
        return this.imdb_id;
    }

    public void setImdb_id(String str) {
        this.imdb_id = str;
    }

    public String getRecommend() {
        return this.recommend;
    }

    public void setRecommend(String str) {
        this.recommend = str;
    }

    public List<MovieItem> getRecommendList() {
        if (this.see_also != null) {
            return this.see_also;
        }
        this.see_also = new ArrayList();
        try {
            this.see_also = C2982e.m16303a(this.see_also_array);
        } catch (Exception e) {
        }
        return this.see_also;
    }

    public int getIn_lib() {
        return this.in_lib;
    }

    public void setIn_lib(int i) {
        this.in_lib = i;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getTrailer() {
        return this.trailer;
    }

    public void setTrailer(String str) {
        this.trailer = str;
    }

    public String getMovieId() {
        return this.movie_id;
    }

    public void setMovieId(String str) {
        this.movie_id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getPoster() {
        return this.poster;
    }

    public void setPoster(String str) {
        this.poster = str;
    }

    public String getActive() {
        return this.active;
    }

    public void setActive(String str) {
        this.active = str;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String str) {
        this.year = str;
    }

    public String getCats() {
        return this.cats;
    }

    public void setCats(String str) {
        this.cats = str;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String str) {
        this.rating = str;
    }

    public String getImdb_rating() {
        return this.imdb_rating;
    }

    public void setImdb_rating(String str) {
        this.imdb_rating = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }

    public static MovieItemMeta getMovieItemMeta(MovieItem movieItem) {
        MovieItemMeta movieItemMeta = (MovieItemMeta) new Select().from(MovieItemMeta.class).where("movie_id='" + movieItem.getMovieId() + "'").executeSingle();
        if (movieItemMeta != null) {
            return movieItemMeta;
        }
        movieItemMeta = new MovieItemMeta();
        movieItemMeta.setMovieId(movieItem.getMovieId());
        movieItemMeta.save();
        return movieItemMeta;
    }
}
