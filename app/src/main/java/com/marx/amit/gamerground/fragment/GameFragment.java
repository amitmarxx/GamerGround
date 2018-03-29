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

import com.marx.amit.gamerground.R;
import com.marx.amit.gamerground.model.Game;

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
        Game game = new Game();
        super.onViewCreated(view, savedInstanceState);

        tvTitle = view.findViewById(R.id.tvTitle);
        tvDate = view.findViewById(R.id.tvDate);

        tvSummary = view.findViewById(R.id.tvSummary);
        tvSummary.setMovementMethod(new ScrollingMovementMethod());

        tvRating= view.findViewById(R.id.tvRating);

    }

    public void setGameTitle(String data){
        tvTitle.setText(data);
    }

    public void gamesArrived(ArrayList<Game> games) {
        //TODO Listview
        Game game1 = games.get(0);

        tvTitle.setText(game1.getName());
        tvRating.setText(String.valueOf(game1.getRating()));
        tvSummary.setText(game1.getSummary());
        System.out.println(game1.getRelease_dates());
    }
}
