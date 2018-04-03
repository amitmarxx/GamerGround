package com.marx.amit.gamerground.DAO;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.marx.amit.gamerground.model.GameSell;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class GameSellDAO {
    private static DatabaseReference mDatabase;
    private static GameSellDAO sharedInstance = null;
    private static DatabaseReference gameSellRef = null;

    private GameSellDAO() {
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
        this.gameSellRef = mDatabase.getDatabase().getReference("gameSell");
    }

    public static GameSellDAO getInstance() {
        if (sharedInstance == null) {
            sharedInstance = new GameSellDAO();
        }
        return sharedInstance;
    }

    public static void writeGameSell(GameSell gameSell) {
        getInstance();
        gameSellRef.child(gameSell.getSellId()).setValue(gameSell);
    }

    public static void deleteGameSell(GameSell gameSell) {
        gameSellRef.child(gameSell.getSellId()).setValue(null);
    }

    public static String getTimeStamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
