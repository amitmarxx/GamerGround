package com.marx.amit.gamerground.model;

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
     * release_dates : [{"date":1384473600000},{"date":1383955200000},{"date":1383868800000},{"date":1386201600000}]
     * cover : {"url":"//images.igdb.com/igdb/image/upload/t_thumb/fgzkvw0b4a0sjjtwlz9p.jpg","cloudinary_id":"fgzkvw0b4a0sjjtwlz9p","width":250,"height":352}
     */

    private int id;
    private String name;
    private String summary;
    private double rating;
    private CoverBean cover;
    private List<Integer> genres;
    private List<ReleaseDatesBean> release_dates;

    /**
     * id : 3990
     * name : Mario & Sonic at the Sochi 2014 Olympic Winter Games
     * summary : In Mario & Sonic at the Sochi 2014 Olympic Winter Games, players from around the world can take the action online and compete with others in exciting winter sports(broadband Internet access required). Four events are playable online: Ski Cross, Snowboard Cross and Short Track Speed Skating, in addition to Winter Sports Champion Race, a Dream Event that combines Skiing, Ice Skating, Bobsleigh and Snowboard into a single event. Every time players win a medal in online game play, they will win points for their home country. The points can be viewed through persistent online rankings
     * rating : 69.91472359016021
     * genres : [14]
     * release_dates : [{"date":1384473600000},{"date":1383955200000},{"date":1383868800000},{"date":1386201600000}]
     * cover : {"url":"//images.igdb.com/igdb/image/upload/t_thumb/fgzkvw0b4a0sjjtwlz9p.jpg","cloudinary_id":"fgzkvw0b4a0sjjtwlz9p","width":250,"height":352}
     */


    public Game() {

    }

    public Game(int id, String name, String summary, double rating, CoverBean cover, List<Integer> genres, List<ReleaseDatesBean> release_dates) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.rating = rating;
        this.cover = cover;
        this.genres = genres;
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

    public List<ReleaseDatesBean> getRelease_dates() {
        return release_dates;
    }

    public void setRelease_dates(List<ReleaseDatesBean> release_dates) {
        this.release_dates = release_dates;
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

    public static class ReleaseDatesBean {
        /**
         * date : 1384473600000
         */

        private long date;

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }
    }
}
