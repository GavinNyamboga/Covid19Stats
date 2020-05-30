package com.dev.covid19stats.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.covid19stats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MythsFragment extends Fragment {


    public MythsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ThemeSwitch themeSwitch = new ThemeSwitch(getActivity().getApplicationContext());
        if (themeSwitch.loadDarkMode()){
            getContext().getTheme().applyStyle(R.style.DarkTheme,true);

        }else {
            getContext().getTheme().applyStyle(R.style.LightTheme,true);

        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_myths, container, false);
    }

}
