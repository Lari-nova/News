package com.hfad.news.iu;

import com.hfad.news.network.NetworkManager;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainPresenter implements Presenter {

    private Activity mainActivity;
    private NetworkManager manager;
    private String google_news = "google-news";
    private String buzzfeed = "buzzfeed";
    private String bitcoin = "bitcoin";
    private String bbc_news = "bbc-news";

    MainPresenter() {
        manager = new NetworkManager();
    }

    @Override
    public void addActivity(Activity activity) {
        this.mainActivity = activity;
    }

    @Override
    public void loadGoogleNews() {
        manager.requestNews(google_news, null);
    }

    @Override
    public void loadBuzzfeedNews() {
        manager.requestNews(buzzfeed, null);
    }

    @Override
    public void loadBitcoinNews() {
        manager.requestNews(null, bitcoin);
    }

    @Override
    public void loadBBCNews() {
        manager.requestNews(bbc_news, null);
    }


    @Override
    public void  subscribeNews() {
        manager.subscribeNews()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(example -> {
                    mainActivity.showNews(example.getArticles());
                });
    }
}
