package com.marx.amit.gamerground.model;

import android.location.Location;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class GameSell extends Sell {
    private Game game;
    private String sellId; // user uid + timestamp

    public GameSell() {
    }

    public GameSell(Game game, String sellId) {
        this.game = game;
        this.sellId = sellId;
    }

    public GameSell(User publisher, String id, Location location, String price, Game game, String sellId) {
        super(publisher, id, location, price);
        this.game = game;
        this.sellId = sellId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


    public String getSellId() {
        return sellId;
    }

    public void setSellId(String sellId) {
        this.sellId = sellId;
    }

    @Override
    public String toString() {
        return "GameSell{" +
                "game=" + game +
                ", sellId='" + sellId + '\'' +
                '}';
    }
}
