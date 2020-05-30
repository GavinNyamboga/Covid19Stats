package com.dev.covid19stats.ui;

import androidx.fragment.app.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Switch;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;


import com.dev.covid19stats.HomeActivity;
import com.dev.covid19stats.R;
import com.dev.covid19stats.adapters.InfoAdapter;

import java.util.Objects;


public class InfoFragment extends Fragment {
    ThemeSwitch themeSwitch;

    private String[]coronaTips ={
            "What is Covid-19?",
            "What are the symptoms?",
            "How is it transmitted?",
            "How to prevent it?",
            "Myths and Facts",
            "Is there a vaccine or treatment?",
            "About Developer"
    };
    private int[] getCoronaTipsImages = {
            R.drawable.ic_covid_19,
            R.drawable.ic_fever,
            R.drawable.ic_cough,
            R.drawable.ic_hand_wash,
            R.drawable.ic_face_mask,
            R.drawable.ic_vaccine,
            R.drawable.ic_developer
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        themeSwitch = new ThemeSwitch(getActivity().getApplicationContext());
        //use theme on launch
        if (themeSwitch.loadDarkMode()){
            getContext().getTheme().applyStyle(R.style.DarkTheme,true);
            //return localInflater.inflate(R.layout.fragment_info,container,false);
        }else {
            getContext().getTheme().applyStyle(R.style.LightTheme,true);
            //return localInflater.inflate(R.layout.fragment_info,container,false);
        }

        View root = inflater.inflate(R.layout.fragment_info, container, false);


        GridView gridView = root.findViewById(R.id.gridView);
        Switch darkSwitch = root.findViewById(R.id.switch_theme);

        if (themeSwitch.loadDarkMode()){
            darkSwitch.setChecked(true);
        }
        darkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    themeSwitch.setDarkMode(true);
                    reload();
                }else {
                    themeSwitch.setDarkMode(false);
                    reload();
                }
            }
        });

        InfoAdapter infoAdapter =new InfoAdapter(getContext(),coronaTips,getCoronaTipsImages);
        gridView.setAdapter(infoAdapter);


        gridView.setOnItemClickListener((parent, view, position, id) -> {


            switch (position){
                case 0:
                    CoronaFragment coronaFragment = new CoronaFragment();
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,coronaFragment,"findThisFragment")
                            .addToBackStack(null)
                            .commit();
                    break;
                case 1:
                    SymptomsFragment symptomsFragment = new SymptomsFragment();
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,symptomsFragment,"findThisFragment")
                            .addToBackStack(null)
                            .commit();
                    break;
                case 2:
                    TransmissionFragment transmissionFragment = new TransmissionFragment();
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,transmissionFragment,"findThisFragment")
                            .addToBackStack(null)
                            .commit();
                    break;
                case 3:
                    PreventionFragment preventionFragment = new PreventionFragment();
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,preventionFragment,"findThisFragment")
                            .addToBackStack(null)
                            .commit();
                    break;
                case 4:
                    MythsFragment mythsFragment = new MythsFragment();
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,mythsFragment,"findFragment")
                            .addToBackStack(null)
                            .commit();
                    break;
                case 5:
                    VaccineFragment vaccineFragment = new VaccineFragment();
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,vaccineFragment,"findThisFragment")
                            .addToBackStack(null)
                            .commit();
                    break;
                case 6:
                    DeveloperFragment developerFragment = new DeveloperFragment();
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,developerFragment,"findThisFragment")
                            .addToBackStack(null)
                            .commit();
                    break;
            }
        });




        return root;
    }

    private void reload() {

        Intent intent = new Intent(getActivity(),HomeActivity.class);

        startActivity(new Intent(getActivity(), HomeActivity.class));
        /*Fragment fragment = new InfoFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,fragment).commit();
*/
    }


}
