package com.marx.amit.gamerground;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.igdb.api_android_java.callback.onSuccessCallback;
import com.igdb.api_android_java.model.APIWrapper;
import com.igdb.api_android_java.model.Parameters;
import com.marx.amit.gamerground.DAO.GameSellDAO;
import com.marx.amit.gamerground.fragment.AccessoryFragment;
import com.marx.amit.gamerground.fragment.GameFragment;
import com.marx.amit.gamerground.fragment.PlatformFragment;
import com.marx.amit.gamerground.model.Game;
import com.marx.amit.gamerground.model.GameSell;
import com.marx.amit.gamerground.model.Platform;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static com.marx.amit.gamerground.R.id.actvProduct;

public class PublishActivity extends AppCompatActivity implements OnItemSelectedListener {

    private static final String TAG = PublishActivity.class.getSimpleName();

    private AutoCompleteTextView actv;
    private EditText etPrice;
    private EditText etLocation;

    private GameSellDAO gameSellDAO;
    private GameSell gameSell;
  //  private GameSellAdapter gameSellAdapter;
    private GameFragment gameFragment;

    private PlatformFragment platformFragment;

    private Spinner spinner;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);

        platformFragment = new PlatformFragment();
        gameFragment = new GameFragment();

        actv = findViewById(actvProduct);

        spinner = findViewById(R.id.spProduct);

        // Spinner element
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<>();
        categories.add("Game");
        categories.add("Platform");
        categories.add("Accessory");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories); //TODO: make adapters for game/console

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

//        actv.setThreshold(2);
//        actv.setAdapter(new GameAutoCompleteAdapter(this));
//
//        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Game game = (Game) adapterView.getItemAtPosition(position);
//                actv.setText(game.getName());
//            }
//        });

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, PRODUCTS);
//        MultiAutoCompleteTextView textView = findViewById(actvProduct);
//        textView.setAdapter(adapter);
//        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
//
//    }
//
//
//
//    private static final String[] PRODUCTS = new String[]{
//
//            "Belgium", "France", "Italy", "Germany", "Spain"
//    };


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

        if (position == 0) {
            // Create fragment and give it an argument specifying the article it should show
            Bundle args = new Bundle();
            args.putInt(String.valueOf(GameFragment.ARG_POSITION), position);
            gameFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.container, gameFragment);
            transaction.addToBackStack(null);

// Commit the transaction
            transaction.commit();

        } else if (position == 1) {

            Bundle args = new Bundle();
            args.putInt(String.valueOf(PlatformFragment.ARG_POSITION), position);
            platformFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, platformFragment);
            transaction.addToBackStack(null);

            transaction.commit();

        } else if (position == 2) {

            AccessoryFragment accessoryFragment = new AccessoryFragment();
            Bundle args = new Bundle();
            args.putInt(String.valueOf(AccessoryFragment.ARG_POSITION), position);
            accessoryFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, accessoryFragment);
            transaction.addToBackStack(null);

            transaction.commit();
        }
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void btnSet(View view) {
        String toSearch = actv.getText().toString();

        APIWrapper wrapper = new APIWrapper(this, "833c28f5d38906f156741a609002c0ed");

        if (spinner.getSelectedItemPosition() == 0) {
            Parameters params = new Parameters()

                    .addSearch(toSearch)
                    .addFields("id,name,first_release_date,rating,summary,cover,genres")
                    .addLimit("10")
                    .addOffset("0");

            wrapper.search(APIWrapper.Endpoint.GAMES, params, new onSuccessCallback() {
                @Override
                public void onSuccess(JSONArray result) {
                    // JSONArray containing 5 Zelda games
                    //System.out.println(result);

                    Gson gson = new Gson();

                    String game1 = null;
                    ArrayList<Game> games = new ArrayList<>();
                    try {
                        for (int i = 0; i < result.length(); i++) {

                            String json = result.get(i).toString();

                            Game game = gson.fromJson(json, Game.class);

                            games.add(game);
                            if (i == 0)
                                game1 = game.getName() + "\n" + game.getRating() + "\n" + game.getCover().getUrl();
                            // tvSearch.setText(game1 + "\n" + game.getName() + "\n" + game.getRating() + "\n" + game.getCover().getUrl());

                        }

                        gameFragment.gamesArrived(games);
                        String searchResult = result.toString();

                        System.out.println(searchResult);
                        if (gameFragment != null)
                            gameFragment.gamesArrived(games);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "ERROR!!!!!!", Toast.LENGTH_LONG).show();
                    }
                }


                @Override
                public void onError(VolleyError error) {
                    // Do something on error
                    // JSONArray containing 5 Zelda games
                }
            });
        } else if (spinner.getSelectedItemPosition() == 1) {
            final Parameters params = new Parameters()

                    .addSearch(toSearch)
                    .addFields("id,name,logo,versions.release_dates.date,summary")
                    .addLimit("10");

            wrapper.search(APIWrapper.Endpoint.PLATFORMS, params, new onSuccessCallback() {
                @Override
                public void onSuccess(JSONArray result) {
                    // JSONArray containing 5 Zelda games
                    System.out.println(result);

                    Gson gson = new Gson();

                    String platform1 = null;
                    ArrayList<Platform> platforms = new ArrayList<>();
                    for (int i = 0; i < result.length(); i++) {
                        try {
                            String json = result.get(i).toString();
                            Platform platform = gson.fromJson(json, Platform.class);

                            platforms.add(platform);
                            if (i == 0)
                                platform1 = platform.getName() + "\n" + platform.getReleaseDateFormat() + "\n" + platform.getLogo().getUrl();
                            // tvSearch.setText(game1 + "\n" + game.getName() + "\n" + game.getRating() + "\n" + game.getCover().getUrl());

                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(), "ERROR!!!!!!", Toast.LENGTH_LONG).show();
                        }
                    }

                    platformFragment.platformsArrived(platforms);
                    String searchResult = result.toString();

                    System.out.println(searchResult);
                    if (platformFragment != null)
                        platformFragment.platformsArrived(platforms);
                }

                @Override
                public void onError(VolleyError error) {
                    // Do something on error
                    // JSONArray containing 5 Zelda games
                }
            });
        }
    }


    public void btnAddProduct(View view) {

      //  GameSellAdapter gameSellAdapter;

        actv = findViewById(R.id.actvProduct);
        etPrice = findViewById(R.id.etPrice);
        etLocation = findViewById(R.id.etLocation);



        List<String> gameSellList = new ArrayList<>();
        gameSellList.add("name = " + actv.getText().toString());
        gameSellList.add("price = " + etPrice.getText().toString());
        gameSellList.add("Location = " + etLocation.getText().toString());


        //TODO: get the Game from the api into a Game object (Game game = from api)
        //TODO: GameSell gameSell = new GameSell(game, sellId) - myRef.setValue(gameSell)


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("GameSell").push();

        myRef.setValue(gameSellList);
    }
}

