package com.marx.amit.gamerground;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Created by tsuryohananov on 06/04/2018.
 */

public class GeoUtil {

    private static GeoUtil sharedInstance;
    private Context context;

    private GeoUtil(Context context) {
        this.context = context;
    }

    public static GeoUtil getInstance(Context context) {
        if (sharedInstance == null)
            sharedInstance = new GeoUtil(context);
        return sharedInstance;
    }

    public String getLocality() {
        Geocoder gcd = new Geocoder(context, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = gcd.getFromLocation(32.074240, 34.779396, 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                return address.getCountryName() + ", " + address.getLocality();
            }
        } catch (IOException e) {
            //locality not found :(
        }
        return null;
    }

    public String getCoordinates(String locationName) {
        Geocoder geocoder = new Geocoder(context);
        try {
            List<Address> myP = geocoder.getFromLocationName(locationName, 1);
            String p = String.valueOf(myP.get(0).getLatitude()) + ", " + String.valueOf(myP.get(0).getLongitude());
            return p;
        } catch (IOException e) {
            //coordinates not found :(
        }
        return null;
    }

    public ArrayList<String> getCountries() {
        String[] locales = Locale.getISOCountries(); // here we get the countries codes
        ArrayList<String> countries = new ArrayList<>();
        for (String countryCode : locales) {
            Locale obj = new Locale(Locale.getDefault().getLanguage(), countryCode); // iter country code
            countries.add(obj.getDisplayCountry());
        }
        return countries;
    }
}
