package com.marx.amit.gamerground.DAO;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.marx.amit.gamerground.model.ConsoleSell;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class ConsoleSellDAO {
    private static ConsoleSellDAO sharedInstance;
    private static DatabaseReference mDatabase;
    private static DatabaseReference consoleSellRef;

    private ConsoleSellDAO() {
        this.mDatabase = FirebaseDatabase.getInstance().getReference();
        this.consoleSellRef = mDatabase.getDatabase().getReference("consoleSell");
    }

    public static ConsoleSellDAO getInstance() {
        if (sharedInstance == null)
            sharedInstance = new ConsoleSellDAO();
        return sharedInstance;
    }

    public void writeConsoleSell(ConsoleSell consoleSell) {
        consoleSellRef.child(consoleSell.getSellId()).setValue(consoleSell);
    }

    public void deleteConsoleSell(ConsoleSell consoleSell) {
        consoleSellRef.child(consoleSell.getSellId()).setValue(null);
    }

    public String getTimeStamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
