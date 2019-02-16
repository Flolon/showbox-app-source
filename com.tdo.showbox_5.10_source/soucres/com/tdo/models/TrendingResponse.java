package com.tdo.showbox.models;

import java.util.List;

public class TrendingResponse {
    private List<MovieItem> movies;
    private List<News> movies_news;
    private List<Trailer> trailers;
    private List<TvItem> tv;
    private List<News> tv_news;

    public List<News> getMovies_news() {
        return this.movies_news;
    }

    public void setMovies_news(List<News> list) {
        this.movies_news = list;
    }

    public List<News> getTv_news() {
        return this.tv_news;
    }

    public void setTv_news(List<News> list) {
        this.tv_news = list;
    }

    public List<Trailer> getTrailers() {
        return this.trailers;
    }

    public void setTrailers(List<Trailer> list) {
        this.trailers = list;
    }

    public List<MovieItem> getMovies() {
        return this.movies;
    }

    public void setMovies(List<MovieItem> list) {
        this.movies = list;
    }

    public List<TvItem> getTv() {
        return this.tv;
    }

    public void setTv(List<TvItem> list) {
        this.tv = list;
    }
}
