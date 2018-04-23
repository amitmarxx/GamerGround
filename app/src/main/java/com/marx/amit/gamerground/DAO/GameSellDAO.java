package com.marx.amit.gamerground.DAO;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.marx.amit.gamerground.model.Game;
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

    public void writeGameSell(/*GameSell gameSell*/ Game game) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String userId = "123id"/* user.getUid()*/; //TODO: add firebase auth~!!!!!
        String gameSellId = userId + getTimeStamp();
        GameSell gameSell = new GameSell(game, gameSellId);
        gameSellRef.child(gameSellId).setValue(gameSell);
    }

    public void deleteGameSell(GameSell gameSell) {
        gameSellRef.child(gameSell.getSellId()).setValue(null);
    }

    public String getTimeStamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
