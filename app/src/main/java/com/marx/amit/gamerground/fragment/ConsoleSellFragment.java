package com.marx.amit.gamerground.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marx.amit.gamerground.R;
import com.marx.amit.gamerground.adapter.ConsoleSellAdapter;

/**
 * Created by tsuryohananov on 03/04/2018.
 */

public class ConsoleSellFragment extends Fragment {

    public static ConsoleSellFragment newInstance() {
        return new ConsoleSellFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_sell, container, false);
    }

    @Override
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        RecyclerView recyclerView = v.findViewById(R.id.GameSellRecycleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new ConsoleSellAdapter(getContext()));
    }
}
