package com.example.trabalho_noticias;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private Context context;
    private List<News> newsList;

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        }

        News news = newsList.get(position);

        TextView titleView = convertView.findViewById(R.id.news_title);
        TextView descriptionView = convertView.findViewById(R.id.news_description);
        TextView categoryView = convertView.findViewById(R.id.news_category);
        ImageView imageView = convertView.findViewById(R.id.news_image);

        titleView.setText(news.getTitle());
        descriptionView.setText(news.getDescription());
        imageView.setImageResource(news.getImageResource());
        categoryView.setText(news.getCategory());

        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, SecondActivity.class);
            intent.putExtra("title", news.getTitle());
            intent.putExtra("description", news.getDescription());
            intent.putExtra("category", news.getCategory());
            intent.putExtra("imageResource", news.getImageResource());
            intent.putExtra("fullDescription", news.getFullDescription());
            context.startActivity(intent);
        });

        return convertView;
    }
}
