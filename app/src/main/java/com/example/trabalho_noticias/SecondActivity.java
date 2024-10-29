package com.example.trabalho_noticias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);

        ImageView newsImageView = findViewById(R.id.news_image);
        TextView newsTitleView = findViewById(R.id.news_title);
        TextView newsCategoryView = findViewById(R.id.news_category);
        TextView newsFullDescriptionView = findViewById(R.id.news_full_description);

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        String category = getIntent().getStringExtra("category");
        int imageResource = getIntent().getIntExtra("imageResource", 0);
        String fullDescription = getIntent().getStringExtra("fullDescription");

        newsImageView.setImageResource(imageResource);
        newsTitleView.setText(title);
        newsCategoryView.setText(category);
        newsFullDescriptionView.setText(fullDescription);
    }

    @Override
    protected void onStart() {
        super.onStart();

        findViewById(R.id.hamburger_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
