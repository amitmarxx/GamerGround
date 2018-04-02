package com.marx.amit.gamerground.model;

import android.location.Location;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class ConsoleSell extends Sell {
    private Platform platform;
    private String timeStamp;

    public ConsoleSell() {
    }

    public ConsoleSell(Platform platform) {
        this.platform = platform;
    }

    public ConsoleSell(User publisher, String id, Location location, String price, Platform platform, String timeStamp) {
        super(publisher, id, location, price);
        this.platform = platform;
        this.timeStamp = timeStamp;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "ConsoleSell{" +
                "platform=" + platform +
                '}';
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
