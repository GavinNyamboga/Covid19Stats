package com.dev.covid19stats.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.covid19stats.R;
import com.dev.covid19stats.models.CountriesResources;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {

    private List<CountriesResources> countriesResourcesList;

    public CountriesAdapter(List<CountriesResources> countriesResourcesList, Context context) {
        this.countriesResourcesList = countriesResourcesList;
    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.countries_data,parent,false);
        return new CountriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {


       Picasso.get().load(countriesResourcesList.get(position).getCountryInfo().getFlag()).into(holder.flagImage);
         holder.countryName.setText(countriesResourcesList.get(position).getCountry());


        Integer cases = countriesResourcesList.get(position).getCases();
        String cases2 = NumberFormat.getIntegerInstance().format(cases);
        holder.countryCases.setText(cases2);

        Integer deaths = countriesResourcesList.get(position).getDeaths();
        String deaths2 = NumberFormat.getIntegerInstance().format(deaths);
        holder.countryDeaths.setText(deaths2);

        Integer recovered = countriesResourcesList.get(position).getRecovered();
        String recovered2 =  NumberFormat.getIntegerInstance().format(recovered);
        holder.countryRecovered.setText(recovered2);

        Integer todayDeaths = countriesResourcesList.get(position).getTodayDeaths();
        String todayDeaths2 = NumberFormat.getIntegerInstance().format(todayDeaths);
        holder.todayDeaths.setText(todayDeaths2 );

        Integer todayCases = countriesResourcesList.get(position).getTodayCases();
        String todayCases2 = NumberFormat.getIntegerInstance().format(todayCases);
        holder.todayCases.setText(todayCases2);

    }

    @Override
    public int getItemCount() {
        return countriesResourcesList.size();
    }

    class CountriesViewHolder extends RecyclerView.ViewHolder {
        private TextView countryName, countryCases, countryDeaths, countryRecovered,todayCases, todayDeaths;
        private ImageView flagImage;


        CountriesViewHolder(@NonNull View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.country);
            countryCases = itemView.findViewById(R.id.confirmedCases);
            countryDeaths = itemView.findViewById(R.id.totalDeaths);
            countryRecovered = itemView.findViewById(R.id.casesRecovered);
            todayCases = itemView.findViewById(R.id.today_cases);
            todayDeaths = itemView.findViewById(R.id.today_deaths);
            flagImage = itemView.findViewById(R.id.country_flag);

        }
    }
}
