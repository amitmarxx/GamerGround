package com.marx.amit.gamerground.model;
import android.location.Location;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class GameSell extends Sell {
    private Game game;

    public GameSell() {
    }

    public GameSell(Game game) {
        this.game = game;
    }

    public GameSell(User publisher, String id, Location location, String price, Game game) {
        super(publisher, id, location, price);
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "GameSell{" +
                "game=" + game +
                '}';
    }
}
