package com.marx.amit.gamerground.model;
import android.location.Location;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class Sell {
    private User publisher;
    private String id;
    private Location location;
    private String price;

    public Sell() {
    }

    public Sell(User publisher, String id, Location location, String price) {
        this.publisher = publisher;
        this.id = id; // this will be the publisher.getId + time stamp - do this on DAO
        this.location = location;
        this.price = price;
    }

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sell{" +
                "publisher=" + publisher +
                ", id='" + id + '\'' +
                ", location=" + location +
                ", price='" + price + '\'' +
                '}';
    }
}
