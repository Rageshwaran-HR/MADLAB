package com.example.rss;


import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RssAdapter adapter;
    ArrayList<String> rssTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rssRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RssAdapter(rssTitles);
        recyclerView.setAdapter(adapter);

        loadRssFeed();
    }

    private void loadRssFeed() {
        new Thread(() -> {
            try {
                String url = "https://www.nasa.gov/rss/dyn/breaking_news.rss"; // Replace with your feed
                Document doc = Jsoup.connect(url).get();
                Elements items = doc.select("item > title");

                rssTitles.clear();
                for (int i = 0; i < items.size(); i++) {
                    rssTitles.add(items.get(i).text());
                }

                runOnUiThread(() -> adapter.notifyDataSetChanged());

            } catch (Exception e) {
                runOnUiThread(() ->
                        Toast.makeText(MainActivity.this, "Failed to load RSS", Toast.LENGTH_SHORT).show()
                );
            }
        }).start();
    }
}
