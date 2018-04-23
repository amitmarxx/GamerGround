package com.marx.amit.gamerground;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.marx.amit.gamerground.fragment.AccessorySellFragment;
import com.marx.amit.gamerground.fragment.ConsoleSellFragment;
import com.marx.amit.gamerground.fragment.GameSellFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        //Facebook Authentication:
//        FacebookSdk.sdkInitialize(getApplicationContext());
//        AppEventsLogger.activateApp(this);


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

        ViewPager vp_pages= (ViewPager) findViewById(R.id.vp_pages);
        PagerAdapter pagerAdapter=new FragmentAdapter(getSupportFragmentManager());
        vp_pages.setAdapter(pagerAdapter);

        TabLayout tbl_pages= (TabLayout) findViewById(R.id.tbl_pages);
        tbl_pages.setupWithViewPager(vp_pages);
    }

    class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new GameSellFragment();
                case 1:
                    return new ConsoleSellFragment();
                case 2:
                    return new AccessorySellFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                //
                //Your tab titles
                //
                case 0:return "Games";
                case 1:return "Consoles";
                case 2: return "Accessories";
                default:return null;
            }
        }
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
