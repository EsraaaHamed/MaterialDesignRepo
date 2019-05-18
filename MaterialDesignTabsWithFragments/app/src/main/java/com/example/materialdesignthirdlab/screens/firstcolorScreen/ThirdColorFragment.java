package com.example.materialdesignthirdlab.screens.firstcolorScreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.materialdesignthirdlab.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdColorFragment extends Fragment {


    public ThirdColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_third_color, container, false);
        return view;
    }

}
