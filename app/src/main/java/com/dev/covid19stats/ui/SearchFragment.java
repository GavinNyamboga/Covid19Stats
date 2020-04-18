package com.dev.covid19stats.ui;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.os.Bundle;

import android.text.Layout;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.dev.covid19stats.R;
import com.dev.covid19stats.models.CountriesResources;
import com.dev.covid19stats.models.SearchCountry;
import com.dev.covid19stats.network.APIInterface;
import com.dev.covid19stats.network.RetrofitClientInstance;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;


public class SearchFragment extends Fragment {

    private APIInterface apiInterface;
    private EditText searchCountryTxt;
    private ImageView searchBtn;
    public static String COUNTRY_NAME ="";

    private CardView countryCard;
    private TextView countryName, countryCases, countryDeaths, countryRecovered,todayCases, todayDeaths;
    private ImageView flagImage;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_search, container, false);

        searchCountryTxt = root.findViewById(R.id.search_country);
        searchBtn = root.findViewById(R.id.search_country_btn);
        countryCard = root.findViewById(R.id.Country_card);


        countryName = root.findViewById(R.id.country2);
        countryCases = root.findViewById(R.id.confirmedCases2);
        countryDeaths = root.findViewById(R.id.totalDeaths2);
        countryRecovered = root.findViewById(R.id.casesRecovered2);
        todayCases = root.findViewById(R.id.today_cases2);
        todayDeaths = root.findViewById(R.id.today_deaths2);
        flagImage = root.findViewById(R.id.country_flag2);



        searchCountryTxt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    performSearch();
                    return true;
                }
                return false;
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                performSearch();
            }
        });





        return root;
    }

    private void performSearch() {

        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(APIInterface.class);


        String searchInput = searchCountryTxt.getText().toString();

        Call<SearchCountry> call= apiInterface.getEachCountryData(searchInput);
        call.enqueue(new Callback<SearchCountry>() {
            @Override
            public void onResponse(Call<SearchCountry> call, Response<SearchCountry> response) {
                SearchCountry searchCountry = response.body();
                if (searchCountry != null){

                    countryCard.setVisibility(View.VISIBLE);

                    countryName.setText(searchCountry.getCountry());
                    String displayCases = NumberFormat.getIntegerInstance().format(searchCountry.getCases());
                    countryCases.setText(displayCases);
                    String displayDeaths = NumberFormat.getIntegerInstance().format(searchCountry.getDeaths());
                    countryDeaths.setText(displayDeaths);
                    String displayRecovered = NumberFormat.getIntegerInstance().format(searchCountry.getRecovered());
                    countryRecovered.setText(displayRecovered);
                    String displayTodayCases = NumberFormat.getIntegerInstance().format(searchCountry.getTodayCases());
                    todayCases.setText(displayTodayCases);
                    String displayTodayDeaths = NumberFormat.getIntegerInstance().format(searchCountry.getTodayDeaths());
                    todayDeaths.setText(displayTodayDeaths);
                    Picasso.get().load(searchCountry.getCountryInfo().getFlag()).into(flagImage);


                }
                else {

                    Snackbar.make(getView(),"Country not found try Again!!",Snackbar.LENGTH_INDEFINITE)
                            .setActionTextColor( getResources().getColor(R.color.colorPrimary))
                            .setAction("OK", v -> {

                            }).show();
                }



            }

            @Override
            public void onFailure(Call<SearchCountry> call, Throwable t) {
                countryCard.setVisibility(View.GONE);

               Snackbar.make(getView(),"Check Internet Connection and Try Again!",Snackbar.LENGTH_INDEFINITE)
                       .setActionTextColor( getResources().getColor(R.color.colorPrimary))
                       .setAction("OK", new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {

                           }
                       }).show();
            }
        });
    }


}
