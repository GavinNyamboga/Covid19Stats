package com.dev.covid19stats.network;

import com.dev.covid19stats.models.CountriesResources;
import com.dev.covid19stats.models.GlobalResources;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("/all")
    Call<GlobalResources> getListResources();
    @GET("countries?sort=cases")
    Call<List<CountriesResources>> getAllCountriesData();
    @GET("countries/{country}")
    Call<CountriesResources> getEachCountryData(@Path("country") String country);

}
