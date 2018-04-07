package com.marx.amit.gamerground;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.marx.amit.gamerground.fragment.ConsoleSellFragment;
import com.marx.amit.gamerground.fragment.GameSellFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new GameSellFragment(), "GameSellList").commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(com.marx.amit.gamerground.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_people) {
            // Handle the camera action
        } else if (id == R.id.nav_game_sell) {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.container, new GameSellFragment()).
                    commit();

        } else if (id == R.id.nav_console_sell) {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.container, ConsoleSellFragment.newInstance()).
                    commit();

        } else if (id == R.id.nav_chat) {

        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_add) {

        } else if (id == R.id.nav_myItems) {

        } else if (id == R.id.nav_favorites) {

        } else if (id == R.id.nav_terms) {

        } else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_signOut) {

        }

        DrawerLayout drawer = findViewById(com.marx.amit.gamerground.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addPublish(View view) {
        Intent intent = new Intent(MainActivity.this, PublishActivity.class);
        startActivity(intent);

        // ex for getting a location by lat and long:

/*        String locality = GeoUtil.getInstance(getApplicationContext()).getLocality();
        Log.d("ADDRESS", locality);

        // ex for getting lat and long by location name:

        String latLong = GeoUtil.getInstance(getApplicationContext()).getCoordinates("תל אביב");
        Log.d("LAT + LONG", latLong);*/
    }


}
