package com.marx.amit.gamerground.model;

import sun.jvm.hotspot.code.Location;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class ConsoleSale extends Sell {
    private Platform platform;

    public ConsoleSale() {
    }

    public ConsoleSale(Platform platform) {
        this.platform = platform;
    }

    public ConsoleSale(User publisher, String id, Location location, String price, Platform platform) {
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
        return "ConsoleSale{" +
                "platform=" + platform +
                '}';
    }
}
