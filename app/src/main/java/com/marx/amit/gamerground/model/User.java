package com.marx.amit.gamerground.model;

import java.util.ArrayList;

/**
 * Created by amit on 3/28/18.
 */

public class User {

    private String id;
    private String name;
    private String image;
    private String status;
    private ArrayList<String> genres;
    private ArrayList<GameSell> gameSells;

    public User() {
    }

    public User(String id, String name, String image, String status, ArrayList<String> genres, ArrayList<GameSell> gameSellId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
        this.genres = genres;
        this.gameSells = gameSellId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<GameSell> getGameSells() {
        return gameSells;
    }

    public void setGameSells(ArrayList<GameSell> gameSells) {
        this.gameSells = gameSells;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", genres=" + genres +
                ", gameSells=" + gameSells +
                '}';
    }

}
