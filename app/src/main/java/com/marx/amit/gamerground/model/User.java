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
    private ArrayList<ConsoleSell>consoleSells;
    private ArrayList<GameSell> favoritesGameSell;
    private ArrayList<ConsoleSell> favoritesConsoleSell;

    public User() {
    }

    public User(String id, String name, String image, String status, ArrayList<String> genres, ArrayList<GameSell> gameSellId, ArrayList<ConsoleSell> consoleSells, ArrayList<GameSell> favoritesGameSell, ArrayList<ConsoleSell> favoritesConsoleSell) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
        this.genres = genres;
        this.gameSells = gameSellId;
        this.consoleSells = consoleSells;
        this.favoritesGameSell = favoritesGameSell;
        this.favoritesConsoleSell = favoritesConsoleSell;
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

    public ArrayList<ConsoleSell> getConsoleSells() {
        return consoleSells;
    }

    public void setConsoleSells(ArrayList<ConsoleSell> consoleSells) {
        this.consoleSells = consoleSells;
    }

    public ArrayList<GameSell> getFavoritesGameSell() {
        return favoritesGameSell;
    }

    public void setFavoritesGameSell(ArrayList<GameSell> favoritesGameSell) {
        this.favoritesGameSell = favoritesGameSell;
    }

    public ArrayList<ConsoleSell> getFavoritesConsoleSell() {
        return favoritesConsoleSell;
    }

    public void setFavoritesConsoleSell(ArrayList<ConsoleSell> favoritesConsoleSell) {
        this.favoritesConsoleSell = favoritesConsoleSell;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", genres=" + genres +
                ", gameSells=" + gameSells +
                ", consoleSells=" + consoleSells +
                ", favoritesGameSell=" + favoritesGameSell +
                ", favoritesConsoleSell=" + favoritesConsoleSell +
                '}';
    }
}
