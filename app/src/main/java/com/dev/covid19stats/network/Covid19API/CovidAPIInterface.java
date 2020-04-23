package com.dev.covid19stats.network.Covid19API;

import com.dev.covid19stats.models.CountriesResources;
import com.dev.covid19stats.models.GlobalResources;
import com.dev.covid19stats.models.SearchCountry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface CovidAPIInterface {
    @GET("v2/all")
    Call<GlobalResources> getListResources();
    @GET("v2/countries?sort=cases")
    Call<List<CountriesResources>> getAllCountriesData();
    @GET("v2/countries/{query}")
    Call<SearchCountry> getEachCountryData(@Path("query") String query);


}
