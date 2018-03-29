package com.marx.amit.gamerground.model;

import sun.jvm.hotspot.code.Location;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class ConsoleSell extends Sell {
    private Platform platform;

    public ConsoleSell() {
    }

    public ConsoleSell(Platform platform) {
        this.platform = platform;
    }

    public ConsoleSell(User publisher, String id, Location location, String price, Platform platform) {
        super(publisher, id, location, price);
        this.platform = platform;
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
}
