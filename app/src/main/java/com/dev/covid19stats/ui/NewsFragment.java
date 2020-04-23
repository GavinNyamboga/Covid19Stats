package com.dev.covid19stats.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.dev.covid19stats.ItemClickListener;
import com.dev.covid19stats.R;
import com.dev.covid19stats.adapters.NewsAdapter;
import com.dev.covid19stats.models.news.NewsArticle;
import com.dev.covid19stats.models.news.NewsHeadlines;
import com.dev.covid19stats.network.NewsAPI.NewsAPIInterface;
import com.dev.covid19stats.network.NewsAPI.NewsClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private List<NewsArticle> headlines;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_news, container, false);


        recyclerView = root.findViewById(R.id.news_recyclerview);
        getNews();
        final SwipeRefreshLayout swipeRefreshLayout= root.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            getNews();
            swipeRefreshLayout.setRefreshing(false);
        });





        return root;
    }

    private void getNews(){
        NewsAPIInterface newsAPIInterface = NewsClientInstance.getNewsClientInstance().create(NewsAPIInterface.class);
        Call<NewsHeadlines> call = newsAPIInterface.getHeadlines();
        call.enqueue(new Callback<NewsHeadlines>() {
            @Override
            public void onResponse(Call<NewsHeadlines> call, Response<NewsHeadlines> response) {

                if (response.isSuccessful()){
                    assert response.body() != null;
                    headlines = response.body().getArticles();
                    NewsAdapter newsAdapter =new NewsAdapter(headlines,getContext());
                    recyclerView.setAdapter(newsAdapter);

                    layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                }
                else
                {
                    Toast.makeText(getContext(), "Check Internet connection", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<NewsHeadlines> call, Throwable t) {

                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}