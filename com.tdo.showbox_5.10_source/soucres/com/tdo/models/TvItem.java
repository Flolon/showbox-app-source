package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.tdo.showbox.data.C3094j;
import com.tdo.showbox.p131f.C3178f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Table(name = "TvItems")
public class TvItem extends Model {
    @Column(name = "active")
    private String active;
    private Map<String, Object> additionalProperties = new HashMap();
    @Column(name = "banner")
    private String banner;
    @Column(name = "cats")
    private String cats;
    private ArrayList<String> catsList;
    @Column(name = "date")
    private long date;
    @Column(name = "description")
    private String description;
    @Column(name = "from_push")
    private int from_push;
    @Column(name = "imdb_id")
    private String imdb_id;
    @Column(name = "in_lib")
    private int in_lib;
    @Column(name = "item_id")
    private String item_id;
    @Column(name = "last_cached_time")
    private long last_cached_time;
    @Column(name = "last_vieved_season")
    private int last_vieved_season;
    @Column(name = "poster")
    private String poster;
    @Column(name = "push_topic")
    private String push_topic;
    @Column(name = "rating")
    private String rating;
    @Column(name = "removed_from_lib")
    private int removed_from_lib;
    @Column(name = "seasons")
    private String seasons;
    @Column(name = "seasonslist")
    private String seasonslist;
    @Column(name = "title")
    private String title;

    public int getFrom_push() {
        return this.from_push;
    }

    public void setFrom_push(int i) {
        this.from_push = i;
    }

    public String getSeasonslist() {
        return this.seasonslist;
    }

    public void setSeasonslist(String str) {
        this.seasonslist = str;
    }

    public static String getLinkOid(String str) {
        String str2;
        try {
            str2 = (String) C3178f.m16972a(str).get("oid");
            try {
                C3094j.m16698a("MovieDetails", "oid = " + str2);
            } catch (Exception e) {
                C3094j.m16698a("MovieDetails", "oid error");
                if (str2 == null) {
                    return "";
                }
                return str2;
            }
        } catch (Exception e2) {
            str2 = "";
            C3094j.m16698a("MovieDetails", "oid error");
            if (str2 == null) {
                return str2;
            }
            return "";
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public String getImdb_id() {
        return this.imdb_id;
    }

    public void setImdb_id(String str) {
        this.imdb_id = str;
    }

    public int getLast_vieved_season() {
        return this.last_vieved_season;
    }

    public void setLast_vieved_season(int i) {
        this.last_vieved_season = i;
    }

    public int getIn_lib() {
        return this.in_lib;
    }

    public void setIn_lib(int i) {
        this.in_lib = i;
    }

    public void parseCats() {
        this.catsList = new ArrayList();
        try {
            String[] split = getCats().split("#");
            if (split.length != 0) {
                this.catsList.addAll(Arrays.asList(split));
            }
        } catch (Exception e) {
        }
    }

    public ArrayList<String> getCatsList() {
        if (this.catsList == null) {
            this.catsList = new ArrayList();
        }
        return this.catsList;
    }

    public void setCatsList(ArrayList<String> arrayList) {
        this.catsList = arrayList;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getBanner() {
        return this.banner;
    }

    public void setBanner(String str) {
        this.banner = str;
    }

    public long getDate() {
        return this.date;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public String getItemId() {
        return this.item_id;
    }

    public void setId(String str) {
        this.item_id = str;
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

    public String getSeasons() {
        return this.seasons;
    }

    public void setSeasons(String str) {
        this.seasons = str;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }

    public static TvItemMeta getTvItemMeta(TvItem tvItem) {
        TvItemMeta tvItemMeta = (TvItemMeta) new Select().from(TvItemMeta.class).where("item_id='" + tvItem.getItemId() + "'").executeSingle();
        if (tvItemMeta != null) {
            return tvItemMeta;
        }
        tvItemMeta = new TvItemMeta();
        tvItemMeta.setItem_id(tvItem.getItemId());
        tvItemMeta.save();
        return tvItemMeta;
    }
}
