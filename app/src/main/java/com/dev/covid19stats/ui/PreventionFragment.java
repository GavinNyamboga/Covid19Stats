package com.dev.covid19stats.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.covid19stats.R;

public class PreventionFragment extends Fragment {


    public PreventionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_prevention, container, false);

        TextView prevention = view.findViewById(R.id.prevention_txt);

        prevention.setText(Html.fromHtml("<b>To prevent the spread of COVID-md_garlic:</b><br>" +
                "<ol>"+
                "  <li>Clean your hands often. Use soap and water, or an alcohol-based hand rub.</li>" +
                " <li>Maintain a safe distance from anyone who is coughing or sneezing.</li>" +
                " <li>Don’t touch your eyes, nose or mouth.</li>" +
                " <li>Cover your nose and mouth with your bent elbow or a tissue when you cough or sneeze.</li>" +
                " <li>Stay home if you feel unwell.</li>" +
                "<li> If you have a fever, a cough, and difficulty breathing, seek medical attention. Call in advance.</li>" +
                " <li> Follow the directions of your local health authority.</li>" +
                " <li>Avoiding unneeded visits to medical facilities allows healthcare systems to operate more effectively," +
                " therefore protecting you and others.</li><br>" +
                "</ol>"+
                "<i>source: World Health Organization(WHO)</i>"
        ));


        return view;
    }


}
