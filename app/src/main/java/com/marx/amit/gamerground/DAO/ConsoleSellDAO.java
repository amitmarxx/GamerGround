package com.marx.amit.gamerground.DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tsuryohananov on 29/03/2018.
 */

public class ConsoleSellDAO {

    public static String getTimeStamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
