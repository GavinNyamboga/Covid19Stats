package com.dev.covid19stats.ui;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.dev.covid19stats.HomeActivity;
import com.dev.covid19stats.R;
import com.dev.covid19stats.adapters.InfoAdapter;


public class InfoFragment extends Fragment {

    GridView gridView;

    String[]coronaTips ={
            "What are Corona Viruses?",
            "What are the symptoms?",
            "How is it transmitted?",
            "How to prevent it?",
            "When to wear masks?",
            "Is there a vaccine or treatment?"
    };
    int[] getCoronaTipsImages = {
            R.drawable.coronavirus,
            R.drawable.fever,
            R.drawable.coughing,
            R.drawable.handwashing,
            R.drawable.mask,
            R.drawable.vaccine
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_info, container, false);

        gridView = root.findViewById(R.id.gridView);

        InfoAdapter infoAdapter =new InfoAdapter(getContext(),coronaTips,getCoronaTipsImages);
        gridView.setAdapter(infoAdapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> Toast.makeText(getContext(), "You clicked " + coronaTips[position], Toast.LENGTH_SHORT).show());




        return root;
    }




}
