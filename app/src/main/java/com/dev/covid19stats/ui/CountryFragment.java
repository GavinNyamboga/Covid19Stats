package com.dev.covid19stats.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.dev.covid19stats.R;
import com.dev.covid19stats.adapters.CountriesAdapter;
import com.dev.covid19stats.network.Covid19API.CovidAPIInterface;
import com.dev.covid19stats.models.CountriesResources;
import com.dev.covid19stats.network.Covid19API.Covid19ClientInstance;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryFragment extends Fragment {


    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerView.LayoutManager layoutManager;
    private List<CountriesResources> countriesResourcesList;


    public CountryFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ThemeSwitch themeSwitch = new ThemeSwitch(getActivity().getApplicationContext());
        if (themeSwitch.loadDarkMode()){
            getContext().getTheme().applyStyle(R.style.DarkTheme,true);

        }else {
            getContext().getTheme().applyStyle(R.style.LightTheme,true);


        }



        View view = inflater.inflate(R.layout.fragment_country, container, false);

        recyclerView = view.findViewById(R.id.RecyclerView);

        EditText search = view.findViewById(R.id.search_country2);


        CovidAPIInterface covidApiInterface = Covid19ClientInstance.getRetrofitInstance().create(CovidAPIInterface.class);

        Call<List<CountriesResources>> call = covidApiInterface.getAllCountriesData();
        call.enqueue(new Callback<List<CountriesResources>>() {
            @Override
            public void onResponse(Call<List<CountriesResources>> call, Response<List<CountriesResources>> response) {
                if (response.isSuccessful()){

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

        search.setOnClickListener(v -> {
            SearchFragment searchFragment = new SearchFragment();
            Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container,searchFragment,"search")
                    .addToBackStack(null)
                    .commit();
        });


        return view;
    }

    private void displayCountries() {
        recyclerView.setVisibility(View.VISIBLE);
    }




}

