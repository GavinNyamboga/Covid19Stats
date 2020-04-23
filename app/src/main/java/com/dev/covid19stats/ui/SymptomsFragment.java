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
public class SymptomsFragment extends Fragment {




    public SymptomsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_symptoms, container, false);

        TextView symptomsTxt = view.findViewById(R.id.symptoms_txt);
        symptomsTxt.setText(Html.fromHtml("<b>Common symptoms:</b><br>" +
                "<ul>"+
                "<li>fever.</li>" +
                "<li>tiredness.</li>" +
                "<li>dry cough.</li>" +
                "<li>Some people may experience:</li>" +
                "<li>aches and pains.</li>" +
                "<li>nasal congestion.</li>" +
                "<li>runny nose.</li>" +
                "<li>sore throat.</li>" +
                "<li>diarrhoea.</li>" +
                "<li>On average it takes 5–6 days from when someone is infected with the virus for symptoms to show, " +
                "however it can take up to 14 days</li>" +
                "<li>People with mild symptoms who are otherwise healthy should self-isolate.</li> " +
                "<li>Seek medical attention if you have a fever, a cough, and difficulty breathing. Call ahead.</li>" +
                "</ul>"+
                "<i>source: World Health Organization(WHO)</i>"
        ));
        return view;
    }

}
