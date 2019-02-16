package com.tdo.showbox.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.iawl.api.ads.sdk.IAWLNativeAdRequest;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Table(name = "TrailerDetailss")
public class TrailerDetails extends Model {
    @Column(name = "cats")
    private String cats;
    @Column(name = "description")
    private String description;
    private List<TrailerDetailsItem> mItems;
    @Column(name = "poster_hires")
    private String poster_hires;
    @Column(name = "release_info")
    private String release_info;
    @Column(name = "trailer_id")
    private String trailer_id;
    @Column(name = "trailers")
    private String trailers;

    public List<TrailerDetailsItem> getTrailerDetailItems() {
        if (this.trailers == null) {
            return new ArrayList();
        }
        if (this.mItems == null) {
            this.mItems = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(this.trailers);
                for (int i = 0; i < jSONArray.length(); i++) {
                    TrailerDetailsItem trailerDetailsItem = new TrailerDetailsItem();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    trailerDetailsItem.setId(jSONObject.getString("id"));
                    trailerDetailsItem.setLink(jSONObject.getString(IAWLNativeAdRequest.ASSET_TYPE_LINK));
                    trailerDetailsItem.setDate(jSONObject.getString("date"));
                    this.mItems.add(trailerDetailsItem);
                }
            } catch (Exception e) {
            }
        }
        return this.mItems;
    }

    public String getTrailer_id() {
        return this.trailer_id;
    }

    public void setTrailer_id(String str) {
        this.trailer_id = str;
    }

    public String getPoster_hires() {
        return this.poster_hires;
    }

    public void setPoster_hires(String str) {
        this.poster_hires = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getRelease_info() {
        return this.release_info;
    }

    public void setRelease_info(String str) {
        this.release_info = str;
    }

    public String getCats() {
        return this.cats;
    }

    public void setCats(String str) {
        this.cats = str;
    }

    public String getTrailers() {
        return this.trailers;
    }

    public void setTrailers(String str) {
        this.trailers = str;
    }
}
