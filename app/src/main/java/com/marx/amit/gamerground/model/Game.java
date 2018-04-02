package com.marx.amit.gamerground.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by amit on 3/28/18.
 */

public class Game {


    /**
     * id : 3990
     * name : Mario & Sonic at the Sochi 2014 Olympic Winter Games
     * summary : In Mario & Sonic at the Sochi 2014 Olympic Winter Games, players from around the world can take the action online and compete with others in exciting winter sports(broadband Internet access required). Four events are playable online: Ski Cross, Snowboard Cross and Short Track Speed Skating, in addition to Winter Sports Champion Race, a Dream Event that combines Skiing, Ice Skating, Bobsleigh and Snowboard into a single event. Every time players win a medal in online game play, they will win points for their home country. The points can be viewed through persistent online rankings
     * rating : 69.91472359016021
     * genres : [14]
     * first_release_date : 1383868800000
     * cover : {"url":"//images.igdb.com/igdb/image/upload/t_thumb/fgzkvw0b4a0sjjtwlz9p.jpg","cloudinary_id":"fgzkvw0b4a0sjjtwlz9p","width":250,"height":352}
     */

    private int id;
    private String name;
    private String summary;
    private double rating;
    private long first_release_date;
    private CoverBean cover;
    private List<Integer> genres;

    public Game() {
    }

    public Game(int id, String name, String summary, double rating, long first_release_date, CoverBean cover, List<Integer> genres) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.rating = rating;
        this.first_release_date = first_release_date;
        this.cover = cover;
        this.genres = genres;
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

    public long getFirst_release_date() {
        return first_release_date;
    }

    public String getReleaseDateFormat(){
        Date date=new Date(first_release_date);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
        String releaseDate = df2.format(date);
        return releaseDate;
    }

    public void setFirst_release_date(long first_release_date) {
        this.first_release_date = first_release_date;
    }

    public CoverBean getCover() {
        return cover;
    }

    public void setCover(CoverBean cover) {
        this.cover = cover;
    }

    public List<Integer> getGenres() {
        return genres;
    }

    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    public static class CoverBean {
        /**
         * url : //images.igdb.com/igdb/image/upload/t_thumb/fgzkvw0b4a0sjjtwlz9p.jpg
         * cloudinary_id : fgzkvw0b4a0sjjtwlz9p
         * width : 250
         * height : 352
         */

        private String url;
        private String cloudinary_id;
        private int width;
        private int height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCloudinary_id() {
            return cloudinary_id;
        }

        public void setCloudinary_id(String cloudinary_id) {
            this.cloudinary_id = cloudinary_id;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", rating=" + rating +
                ", first_release_date=" + first_release_date +
                ", cover=" + cover +
                ", genres=" + genres +
                '}';
    }
}