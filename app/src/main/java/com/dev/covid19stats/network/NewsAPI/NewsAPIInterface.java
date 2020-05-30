package com.dev.covid19stats.network.NewsAPI;

import com.dev.covid19stats.models.news.NewsHeadlines;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsAPIInterface {

    @GET("everything?q=COVID&Corona&language=en&sources=cnn,bbc-news,al-jazeera-english,reuters,fox-news" +
            "&sortBy=publishedAt&apiKey=4f91b96a7679470c94ddac393bfeec37&pageSize=30&page=1")

    Call<NewsHeadlines> getHeadlines();
}
