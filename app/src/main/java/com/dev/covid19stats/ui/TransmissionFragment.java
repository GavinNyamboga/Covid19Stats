package com.dev.covid19stats.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.covid19stats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransmissionFragment extends Fragment {


    public TransmissionFragment() {
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

        View view =  inflater.inflate(R.layout.fragment_transmission, container, false);

        TextView transmission = view.findViewById(R.id.transmission_txt);
        transmission.setText(Html.fromHtml("COVID-19 is spread through respiratory droplets when an infected person coughs," +
                " sneezes or speaks." +
                " People can also be infected by touching a contaminated surface and then their eyes, mouth or nose. "));

        return view;
    }

}
