package com.example.trabalho_noticias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class FirstActivity extends Activity {

    private ListView newsListView;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);

        newsListView = findViewById(R.id.news_list_view);
        List<News> newsList = loadNewsFromJson();

        adapter = new NewsAdapter(this, newsList);
        newsListView.setAdapter(adapter);
    }

    private List<News> loadNewsFromJson() {
        List<News> newsList = new ArrayList<>();

        try {
            // Lê o arquivo JSON do diretório res/raw
            InputStream inputStream = getResources().openRawResource(R.raw.news);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();

            // Converte o conteúdo para uma string
            String json = new String(buffer, "UTF-8");

            // Converte a string JSON em um JSONArray
            JSONArray jsonArray = new JSONArray(json);

            // Itera sobre o JSONArray para criar objetos News
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String title = jsonObject.getString("title");
                String description = jsonObject.getString("description");
                String imageName = jsonObject.getString("imageResource");
                String category = jsonObject.getString("category");
                String fullDescription = jsonObject.getString("fullDescription");

                // Converte o nome da imagem para um recurso ID
                int imageResource = getResources().getIdentifier(imageName, "drawable", getPackageName());

                // Adiciona o objeto News à lista
                newsList.add(new News(title, description, imageResource, category, fullDescription));
            }

        } catch (Exception e) {
            Log.e("FirstActivity", "Erro ao carregar notícias do JSON", e);
        }

        return newsList;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button button = findViewById(R.id.btn_to_second_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                } catch (Exception error) {
                    Log.e("LOGS_APP", "Erro ao carregar primeira tela no start", error);
                }
            }
        });
    }
}
