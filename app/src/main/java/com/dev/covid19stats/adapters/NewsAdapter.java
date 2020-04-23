package com.dev.covid19stats.adapters;




import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.covid19stats.ItemClickListener;
import com.dev.covid19stats.R;
import com.dev.covid19stats.models.news.NewsArticle;
import com.squareup.picasso.Picasso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsArticle> headlines;
    private Context context;
    private ItemClickListener listener;


    public NewsAdapter(List<NewsArticle> headlines, Context context) {
        this.headlines = headlines;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card,parent,false);
        return new NewsViewHolder(view);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {


        holder.itemView.setOnClickListener(v -> holder.layoutContent.setVisibility(View.VISIBLE));

        Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.newsImage);
        holder.newsTitle.setText(headlines.get(position).getTitle());
        holder.newsContent.setText(headlines.get(position).getContent());
        holder.newsDescription.setText(headlines.get(position).getDescription());
        String newsSource = String.valueOf(headlines.get(position).getSource().getName());
        holder.newsSource.setText(newsSource);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:SS'Z'", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH);
        String publishDate = headlines.get(position).getPublishedAt();
        LocalDate date = LocalDate.parse(publishDate, inputFormatter);
        String formattedDate = outputFormatter.format(date);
        holder.newsTime.setText(formattedDate);

        String url = headlines.get(position).getUrl();
        holder.newsUrl.setOnClickListener(v -> {
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(url));
               context.startActivity(intent);

        });


    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView newsImage;
        TextView newsTitle,newsDescription,newsSource,newsTime,newsContent,newsUrl;
        LinearLayout layoutContent;

        NewsViewHolder(View itemView) {
            super(itemView);


            newsImage = itemView.findViewById(R.id.news_image);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsDescription = itemView.findViewById(R.id.news_description);
            newsSource = itemView.findViewById(R.id.news_source);
            newsTime = itemView.findViewById(R.id.news_time);
            newsContent = itemView.findViewById(R.id.news_content);
            newsUrl = itemView.findViewById(R.id.news_url);

            layoutContent = itemView.findViewById(R.id.layout_content);
        }


        @Override
        public void onClick(View v) {
           listener.recyclerViewOnClick(v,getAdapterPosition());

        }
    }
}
