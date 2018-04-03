package com.marx.amit.gamerground.DAO;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.marx.amit.gamerground.model.ConsoleSell;
import com.marx.amit.gamerground.model.GameSell;
import com.marx.amit.gamerground.model.User;

import java.util.ArrayList;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class UserDAO {


    private static DatabaseReference mDatabase;
    private static UserDAO sharedInstance = null;


    public static UserDAO getInstance() {
        if (sharedInstance == null) {
            sharedInstance = new UserDAO();
        }
        return sharedInstance;
    }


    private UserDAO() {
        this.mDatabase = FirebaseDatabase.getInstance().getReference("users");
    }


    public static void writeUserData(User user) {
        getInstance();
        mDatabase.child(user.getId()).setValue(user);
    }


    public static void addFavoritesGameSell(User user, GameSell gameSell) {
        getInstance();
        ArrayList<GameSell> favoritesGameSell = user.getFavoritesGameSell();
        if (favoritesGameSell == null)
            favoritesGameSell = new ArrayList<>();
        favoritesGameSell.add(gameSell);
        user.setFavoritesGameSell(favoritesGameSell);
        mDatabase.child("users").child(user.getId()).child("favoritesGameSell").setValue(user.getFavoritesGameSell());
    }


    public static void deleteFavoritesGameSell(User user, GameSell gameSell) {
        getInstance();
        ArrayList<GameSell> favoritesGameSell = user.getFavoritesGameSell();
        if (favoritesGameSell == null) {
            favoritesGameSell = new ArrayList<>();
            if (favoritesGameSell.contains(gameSell)) {
                favoritesGameSell.remove(gameSell);
            }

        }
        user.setFavoritesGameSell(favoritesGameSell);
        mDatabase.child("users").child(user.getId()).child("favoritesGameSell").setValue(user.getFavoritesGameSell());
    }


    public static void addFavoritesConsoleSell(User user, ConsoleSell consoleSell) {
        getInstance();
        ArrayList<ConsoleSell> favoritesConsoleSell = user.getFavoritesConsoleSell();
        if (favoritesConsoleSell == null)
            favoritesConsoleSell = new ArrayList<>();
        favoritesConsoleSell.add(consoleSell);
        user.setFavoritesConsoleSell(favoritesConsoleSell);
        mDatabase.child("users").child(user.getId()).child("favoritesConsoleSell").setValue(user.getFavoritesConsoleSell());
    }


    public static void deleteFavoritesConsoleSell(User user, ConsoleSell consoleSell) {
        getInstance();
        ArrayList<ConsoleSell> favoritesConsoleSell = user.getFavoritesConsoleSell();
        if (favoritesConsoleSell == null) {
            favoritesConsoleSell = new ArrayList<>();
            if (favoritesConsoleSell.contains(consoleSell)) {
                favoritesConsoleSell.remove(consoleSell);
            }

        }
        user.setFavoritesConsoleSell(favoritesConsoleSell);
        mDatabase.child("users").child(user.getId()).child("favoritesConsoleSell").setValue(user.getFavoritesConsoleSell());
    }


    public static void addGameSell(User user, GameSell gameSell) {
        getInstance();
        ArrayList<GameSell> gameSells = user.getGameSells();
        if (gameSells == null)
            gameSells = new ArrayList<>();
        gameSells.add(gameSell);
        user.setGameSells(gameSells);
        mDatabase.child("users").child(user.getId()).child("gameSells").setValue(user.getGameSells());
    }


    public static void deleteGameSell(User user, GameSell gameSell) {
        getInstance();
        ArrayList<GameSell> gameSells = user.getGameSells();
        if (gameSells == null) {
            gameSells = new ArrayList<>();
            if (gameSells.contains(gameSell)) {
                gameSells.remove(gameSell);
            }

        }
        user.setGameSells(gameSells);
        mDatabase.child("users").child(user.getId()).child("gameSells").setValue(user.getGameSells());
    }


    public static void addConsoleSell(User user, ConsoleSell consoleSell) {
        getInstance();
        ArrayList<ConsoleSell> consoleSells = user.getConsoleSells();
        if (consoleSells == null)
            consoleSells = new ArrayList<>();
        consoleSells.add(consoleSell);
        user.setConsoleSells(consoleSells);
        mDatabase.child("users").child(user.getId()).child("consoleSells").setValue(user.getConsoleSells());
    }


    public static void deleteConsoleSell(User user, ConsoleSell consoleSell) {
        getInstance();
        ArrayList<ConsoleSell> consoleSells = user.getConsoleSells();
        if (consoleSells == null) {
            consoleSells = new ArrayList<>();
            if (consoleSells.contains(consoleSell)) {
                consoleSells.remove(consoleSell);
            }

        }
        user.setConsoleSells(consoleSells);
        mDatabase.child("users").child(user.getId()).child("consoleSells").setValue(user.getConsoleSells());
    }


    public static void addGenre(User user, String genre) {
        getInstance();
        ArrayList<String> genres = user.getGenres();
        if (genres == null)
            genres = new ArrayList<>();
        genres.add(genre);
        user.setGenres(genres);
        mDatabase.child("users").child(user.getId()).child("genres").setValue(user.getGenres());
    }


    public static void deleteGenre(User user, String genre) {
        getInstance();
        ArrayList<String> genres = user.getGenres();
        if (genres == null) {
            genres = new ArrayList<>();
            if (genres.contains(genre)) {
                genres.remove(genre);
            }

        }
        user.setGenres(genres);
        mDatabase.child("users").child(user.getId()).child("genres").setValue(user.getGenres());
    }


    public static void updateName(User user, String name) {
        getInstance();
        mDatabase.child("users").child(user.getId()).child("name").setValue(name);
    }


    public static void updateImage(User user, String url) {
        getInstance();
        mDatabase.child("users").child(user.getId()).child("image").setValue(url);
    }


    public static void updateStatus(User user, String status) {
        getInstance();
        mDatabase.child("users").child(user.getId()).child("status").setValue(status);
    }


    public static DatabaseReference getmDatabase() {
        getInstance();
        return mDatabase;
    }
}
