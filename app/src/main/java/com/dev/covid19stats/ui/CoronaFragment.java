package com.dev.covid19stats.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.covid19stats.R;


public class CoronaFragment extends Fragment {
    ;

    public CoronaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_corona, container, false);

        TextView aboutCovid = view.findViewById(R.id.about_corona);
        aboutCovid.setText(Html.fromHtml("Coronaviruses are a family of viruses that range from the common cold to" +
                " MERS coronavirus, which is Middle East Respiratory Syndrome coronavirus and SARs," +
                " Severe acute respiratory syndrome coronavirus.<br>" +
                "<b><u>Where do coronaviruses come from?</u></b><br>" +
                "Corona viruses are circulating in animals and some of these coronaviruses have the capability of transmitting between animals and humans." +
                " We call that a spillover event.<br>" +
                "<i>source: World Health Organization(WHO)"));

        return view;


    }



}
