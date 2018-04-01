package com.marx.amit.gamerground.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.marx.amit.gamerground.PublishActivity;
import com.marx.amit.gamerground.R;
import com.marx.amit.gamerground.model.Game;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment  {

    private AutoCompleteTextView actv;

    private ImageView ivCover;
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvSummary;
    private TextView tvRating;

    public static final int ARG_POSITION = 1;
    protected View rootView;
    protected ConstraintLayout container;

    private Game game = new Game();
    private PublishActivity publishActivity = new PublishActivity();


    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_game, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTitle = view.findViewById(R.id.tvTitle);

        tvDate = view.findViewById(R.id.tvDate);

        tvSummary = view.findViewById(R.id.tvSummary);
        tvSummary.setMovementMethod(new ScrollingMovementMethod());

        tvRating = view.findViewById(R.id.tvRating);

        ivCover = view.findViewById(R.id.ivCover);

    }

    public void gamesSpinner(ArrayList<Game> games){
        Game game0 = games.get(0);
        Game game1 = games.get(1);
        Game game2 = games.get(2);
        Game game3 = games.get(3);
        Game game4 = games.get(4);
        Game game5 = games.get(5);
        Game game6 = games.get(6);
        Game game7 = games.get(7);
        Game game8 = games.get(8);
        Game game9 = games.get(9);


    }

    public void gamesArrived(ArrayList<Game> games) {

        Game game = games.get(0);

        String coverUrl = "https:" + game.getCover().getUrl();
        Picasso.get().load(coverUrl).fit().into(ivCover);

        tvTitle.setText(game.getName());

        int intRating = (int) (game.getRating());
        tvRating.setText("Rating: " + String.valueOf(intRating));

        tvSummary.setText(game.getSummary());

        tvDate.setText("Release Date: " + game.getReleaseDateFormat());

    }
}
