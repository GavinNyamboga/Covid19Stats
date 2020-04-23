package com.dev.covid19stats.network.NewsAPI;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsClientInstance {

public static Retrofit retrofit = null;
    private static final String NEWS_URL = "https://newsapi.org/v2/";

public static Retrofit getNewsClientInstance(){


    if (retrofit == null){
        retrofit = new Retrofit.Builder()
                .baseUrl(NEWS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    return retrofit;
}
}
