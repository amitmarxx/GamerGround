package com.marx.amit.gamerground.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by amit on 3/28/18.
 */

public class Platform {


    /**
     * id : 48
     * name : PlayStation 4
     * logo : {"url":"//images.igdb.com/igdb/image/upload/t_thumb/kjp5zjzy8omfm8kgxarx.jpg","cloudinary_id":"kjp5zjzy8omfm8kgxarx","width":600,"height":102}
     * summary : The PlayStation 4 system opens the door to an incredible journey through immersive new gaming worlds and a deeply connected gaming community. PS4 puts gamers first with an astounding launch line-up and over 180 games in development. Play amazing top-tier blockbusters and innovative indie hits on PS4. Developer inspired, gamer focused.
     * versions : [{"release_dates":[{"date":1384473600000},{"date":1385683200000},{"date":1385683200000},{"date":1385683200000}]},{"release_dates":[{"date":1473897600000}]},{"release_dates":[{"date":1478736000000}]}]
     */

    private int id;
    private String name;
    private LogoBean logo;
    private String summary;
    private List<VersionsBean> versions;

    public Platform() {
    }

    public Platform(int id, String name, String summary, List<VersionsBean> versions) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.versions = versions;
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

    public LogoBean getLogo() {
        return logo;
    }

    public void setLogo(LogoBean logo) {
        this.logo = logo;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<VersionsBean> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionsBean> versions) {
        this.versions = versions;
    }


    public static class LogoBean {
        /**
         * url : //images.igdb.com/igdb/image/upload/t_thumb/kjp5zjzy8omfm8kgxarx.jpg
         * cloudinary_id : kjp5zjzy8omfm8kgxarx
         * width : 600
         * height : 102
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

    public static class VersionsBean {
        private List<ReleaseDatesBean> release_dates;

        public List<ReleaseDatesBean> getRelease_dates() {
            return release_dates;
        }

        public void setRelease_dates(List<ReleaseDatesBean> release_dates) {
            this.release_dates = release_dates;
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

    public String getReleaseDateFormat(){
        long release =  new VersionsBean.ReleaseDatesBean().getDate();
        Date date = new Date(release);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
        String releaseDate = df2.format(date);
        return releaseDate;
    }

//    public String getLogoUrl(){
//        String url = new LogoBean().getUrl();
//        return url;
//    }
}