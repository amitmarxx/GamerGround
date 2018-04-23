package com.marx.amit.gamerground.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marx.amit.gamerground.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccessorySellFragment extends Fragment {


    public AccessorySellFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accessory_sell, container, false);
    }

}
