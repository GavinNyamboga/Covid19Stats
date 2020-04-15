package com.dev.covid19stats.network;

import com.dev.covid19stats.models.CountriesResources;
import com.dev.covid19stats.models.GlobalResources;
import com.dev.covid19stats.models.SearchCountry;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("/all")
    Call<GlobalResources> getListResources();
    @GET("countries?sort=cases")
    Call<List<CountriesResources>> getAllCountriesData();
    @GET("countries/{query}")
    Call<SearchCountry> getEachCountryData(@Path("query") String query);


}
