package com.dev.covid19stats.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.covid19stats.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeveloperFragment extends Fragment {


    public DeveloperFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_developer, container, false);

        TextView twitter,github,phone;
        twitter = root.findViewById(R.id.twitter_link);
        github = root.findViewById(R.id.github_link);
        phone = root.findViewById(R.id.phone_number);

        twitter.setOnClickListener(v -> {

            String twitterUser = "https://twitter.com/gavin_k3";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(twitterUser));
            startActivity(intent);
        });
        phone.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+254724136105"));
            startActivity(intent);
        });
        github.setOnClickListener(v -> {
            String githubUser = "https://github.com/GavinNyamboga";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(githubUser));
            startActivity(intent);
        });

        return root;
    }

}
