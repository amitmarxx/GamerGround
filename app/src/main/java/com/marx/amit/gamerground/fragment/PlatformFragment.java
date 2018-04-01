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
import com.marx.amit.gamerground.model.Platform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlatformFragment extends Fragment {

    private AutoCompleteTextView actv;

    private ImageView ivCover;
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvSummary;

    public static final int ARG_POSITION = 2;
    protected View rootView;
    protected ConstraintLayout container;
    Platform platform = new Platform();

    public PlatformFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_platform, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTitle = view.findViewById(R.id.tvTitle);

        tvDate = view.findViewById(R.id.tvDate);

        tvSummary = view.findViewById(R.id.tvSummary);
        tvSummary.setMovementMethod(new ScrollingMovementMethod());

        ivCover = view.findViewById(R.id.ivCover);

    }


    public void platformsArrived(ArrayList<Platform> platforms) {

        Platform platform = platforms.get(0);

        tvTitle.setText(platform.getName());

        String coverUrl = "https:" + platform.getLogo().getUrl();
        Picasso.get().load(coverUrl).fit().into(ivCover);

        tvSummary.setText(platform.getSummary());

        tvDate.setText("Release Date: " + platform.getReleaseDateFormat());
    }
}
