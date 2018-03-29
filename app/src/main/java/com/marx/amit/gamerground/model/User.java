package com.marx.amit.gamerground.model;

import java.util.ArrayList;

/**
 * Created by amit on 3/28/18.
 */

public class User {

    private int id;
    private String name;
    private String image;
    private String Status;
    private ArrayList<String> genres;
    private ArrayList<String> gameSellId;

    public User() {
    }

    public User(int id, String name, String image, String status, ArrayList<String> genres, ArrayList<String> gameSellId) {
        this.id = id;
        this.name = name;
        this.image = image;
        Status = status;
        this.genres = genres;
        this.gameSellId = gameSellId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getGameSellId() {
        return gameSellId;
    }

    public void setGameSellId(ArrayList<String> gameSellId) {
        this.gameSellId = gameSellId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", Status='" + Status + '\'' +
                ", genres=" + genres +
                ", gameSellId=" + gameSellId +
                '}';
    }

}
