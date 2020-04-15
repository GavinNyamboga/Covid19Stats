package com.dev.covid19stats.ui;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;

import com.dev.covid19stats.HomeActivity;
import com.dev.covid19stats.R;




public class InfoFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeActivity homeActivity = (HomeActivity) getActivity();

        View root = inflater.inflate(R.layout.fragment_info, container, false);


        Switch aSwitch = root.findViewById(R.id.switch1);


        return root;
    }




}
