package com.hfad.news.iu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.hfad.news.R;
import com.hfad.news.entity.Article;
import com.hfad.news.recycleview.NewsAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Activity {

    private Button button_google_news;
    private Button button_buzzfeed;
    private Button button_bitcoin;
    private Button button_bbc_news;
    private Presenter presenter;
    private NewsAdapter newsAdapter;
    private RecyclerView recyclerView;

    public MainActivity() {
        presenter = new MainPresenter();
        presenter.addActivity(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        subscribeOnNews();
        createListener();
        presenter.loadGoogleNews();
    }



    private void initialization() {
        button_google_news = findViewById(R.id.google_news);
        button_buzzfeed = findViewById(R.id.buzzfeed);
        button_bitcoin = findViewById(R.id.bitcoin);
        button_bbc_news = findViewById(R.id.bbc_news);
        recyclerView = findViewById(R.id.recycler);
        newsAdapter = new NewsAdapter(this);
    }

    private void subscribeOnNews() {
        presenter.subscribeNews();
    }

    private void createListener() {
        button_google_news.setOnClickListener((View v) -> presenter.loadGoogleNews());
        button_buzzfeed.setOnClickListener((View v) -> presenter.loadBuzzfeedNews());
        button_bitcoin.setOnClickListener((View v) -> presenter.loadBitcoinNews());
        button_bbc_news.setOnClickListener((View v) -> presenter.loadBBCNews());
    }

    @Override
    public void showNews(List<Article> articles) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.addData(articles);
    }
}
