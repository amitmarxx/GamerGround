package com.marx.amit.gamerground;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.igdb.api_android_java.callback.onSuccessCallback;
import com.igdb.api_android_java.model.APIWrapper;
import com.igdb.api_android_java.model.Parameters;
import com.marx.amit.gamerground.fragment.AccessoryFragment;
import com.marx.amit.gamerground.fragment.ConsoleFragment;
import com.marx.amit.gamerground.fragment.GameFragment;
import com.marx.amit.gamerground.model.Game;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class PublishActivity extends AppCompatActivity implements OnItemSelectedListener {

    //GameFragment gameFragment;

    interface OnGamesArivedListener{
        void onGamesArrived(ArrayList<Game> games);
    }
    private AutoCompleteTextView actv;

    private GameFragment gameFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);

        actv = findViewById(R.id.actvProduct);

        // Spinner element
        Spinner spinner = findViewById(R.id.spProduct);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<>();
        categories.add("Game");
        categories.add("Console");
        categories.add("Accessory");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories); //TODO: make adapters for game/console

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        MultiAutoCompleteTextView textView = findViewById(R.id.actvProduct);
        textView.setAdapter(adapter);
        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    private static final String[] COUNTRIES = new String[]{
            "Belgium", "France", "Italy", "Germany", "Spain"
    };


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

        if (position == 0) {
            // Create fragment and give it an argument specifying the article it should show
            gameFragment = new GameFragment();
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

            ConsoleFragment consoleFragment = new ConsoleFragment();
            Bundle args = new Bundle();
            args.putInt(String.valueOf(ConsoleFragment.ARG_POSITION), position);
            consoleFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, consoleFragment);
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

    public void btnSearch(View view) {
        String toSearch = actv.getText().toString();

        APIWrapper wrapper = new APIWrapper(this, "833c28f5d38906f156741a609002c0ed");

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
                for (int i = 0; i < result.length(); i++) {
                    try {
                        String json = result.get(i).toString();

                        Game game = gson.fromJson(json, Game.class);

                        games.add(game);
                        if (i == 0)
                            game1 = game.getName() + "\n" + game.getRating() + "\n" + game.getCover().getUrl();
                        // tvSearch.setText(game1 + "\n" + game.getName() + "\n" + game.getRating() + "\n" + game.getCover().getUrl());

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "ERROR!!!!!!", Toast.LENGTH_LONG).show();
                    }
                }

                gameFragment.gamesArrived(games);
                String searchResult = result.toString();

                System.out.println(searchResult);
                if (gameFragment!=null)
                gameFragment.gamesArrived(games);
            }

            @Override
            public void onError(VolleyError error) {
                // Do something on error
                // JSONArray containing 5 Zelda games

            }
        });

        //Game game = new Game();

    }


}

