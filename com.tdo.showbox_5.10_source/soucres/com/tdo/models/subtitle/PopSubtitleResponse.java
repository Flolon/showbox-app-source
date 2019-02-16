package com.tdo.showbox.models.subtitle;

import com.tdo.showbox.models.Subtitle;
import java.util.List;

public class PopSubtitleResponse {
    private List<String> countries;
    private List<Subtitle> subtitles;

    public List<String> getCountries() {
        return this.countries;
    }

    public void setCountries(List<String> list) {
        this.countries = list;
    }

    public List<Subtitle> getSubtitles() {
        return this.subtitles;
    }

    public void setSubtitles(List<Subtitle> list) {
        this.subtitles = list;
    }
}
