package com.dev.covid19stats.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.dev.covid19stats.R;
import com.dev.covid19stats.adapters.CountriesAdapter;
import com.dev.covid19stats.network.APIInterface;
import com.dev.covid19stats.models.CountriesResources;
import com.dev.covid19stats.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryFragment extends Fragment {

    private static final String TAG = "CountriesFragment";

    APIInterface apiInterface;
    private RecyclerView recyclerView;
    private TextView countryError;
    private ProgressBar progressBar;
    RecyclerView.LayoutManager layoutManager;
    private List<CountriesResources> countriesResourcesList;

    public CountryFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_country, container, false);

        recyclerView = view.findViewById(R.id.RecyclerView);
        countryError = view.findViewById(R.id.country_error);
        progressBar = view.findViewById(R.id.progress_bar);


        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(APIInterface.class);

        Call<List<CountriesResources>> call =apiInterface.getAllCountriesData();
        call.enqueue(new Callback<List<CountriesResources>>() {
            @Override
            public void onResponse(Call<List<CountriesResources>> call, Response<List<CountriesResources>> response) {
                if (response.isSuccessful()){

                    progressBar.setVisibility(View.GONE);
                    countriesResourcesList = response.body();

                    CountriesAdapter countriesAdapter = new CountriesAdapter(countriesResourcesList,getContext());
                    recyclerView.setAdapter(countriesAdapter);
                    layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);

                    displayCountries();
                }
            }

            @Override
            public void onFailure(Call<List<CountriesResources>> call, Throwable t) {

            }
        });



        return view;
    }

    private void displayCountries() {
        recyclerView.setVisibility(View.VISIBLE);
    }


}

