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
public class VaccineFragment extends Fragment {




    public VaccineFragment() {
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
        View view = inflater.inflate(R.layout.fragment_vaccine, container, false);

        TextView treatment = view.findViewById(R.id.vaccine_txt);
        treatment.setText(Html.fromHtml(
                "<u>Self care<br></u>"+"<ul>"+
                "<li> If you feel sick you should rest, drink plenty of fluid, and eat nutritious food.</li>" +
                "<li> Stay in a separate room from other family members, and use a dedicated bathroom if possible.</li> " +
                "<li> Clean and disinfect frequently touched surfaces.</li>" +
                "<li> Everyone should keep a healthy lifestyle at home. Maintain a healthy diet, sleep, stay active, and make social contact with loved ones through the phone or internet.</li>" +
                "<li> Children need extra love and attention from adults during difficult times. Keep to regular routines and schedules as much as possible.</li>" +
                "<li> It is normal to feel sad, stressed, or confused during a crisis. Talking to people you trust, such as friends and family, can help. If you feel overwhelmed, talk to a health worker or counsellor.</li>" +
                        "</ul>"+
                "<u>Medical treatments</u><br>" +"<ul>"+
                "<li>If you have mild symptoms and are otherwise healthy, self-isolate and contact your medical provider or a COVID-md_garlic information line for advice.</li>" +
                "<li>Seek medical care if you have a fever, a cough, and difficulty breathing. Call in advance.</li>"
                +"</ul>"+
                "<i>source: World Health Organization(WHO)</i>"
        ));

        return view;
    }

}
