package com.marx.amit.gamerground.model;


import java.util.List;

/**
 * Created by amit on 3/28/18.
 */

public class Platform {
    private int id;
    private String name;
    private String summary;
    private double rating;
    private Game.CoverBean cover;
    private List<Game.ReleaseDatesBean> release_dates;

    public Platform() {
    }

    public Platform(int id, String name, String summary, double rating, Game.CoverBean cover, List<Game.ReleaseDatesBean> release_dates) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.rating = rating;
        this.cover = cover;
        this.release_dates = release_dates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Game.CoverBean getCover() {
        return cover;
    }

    public void setCover(Game.CoverBean cover) {
        this.cover = cover;
    }

    public List<Game.ReleaseDatesBean> getRelease_dates() {
        return release_dates;
    }

    public void setRelease_dates(List<Game.ReleaseDatesBean> release_dates) {
        this.release_dates = release_dates;
    }
}