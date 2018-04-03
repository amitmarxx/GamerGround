package com.marx.amit.gamerground.model;

import android.location.Location;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class ConsoleSell extends Sell {
    private Platform platform;
    private String sellId;

    public ConsoleSell() {

    }

    public ConsoleSell(Platform platform, String sellId) {
        this.platform = platform;
        this.sellId = sellId;
    }

    public ConsoleSell(User publisher, String id, Location location, String price, Platform platform, String sellId) {
        super(publisher, id, location, price);
        this.platform = platform;

        this.sellId = sellId;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public String getSellId() {
        return sellId;
    }

    public void setSellId(String sellId) {
        this.sellId = sellId;
    }

    @Override
    public String toString() {
        return "ConsoleSell{" +
                "platform=" + platform +
                ", sellId='" + sellId + '\'' +
                '}';
    }
}
