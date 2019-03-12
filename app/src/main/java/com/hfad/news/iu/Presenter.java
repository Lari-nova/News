package com.hfad.news.iu;

public interface Presenter {
    void addActivity(Activity activity);
    void loadGoogleNews();
    void loadBuzzfeedNews();
    void loadBitcoinNews();
    void loadBBCNews();
    void subscribeNews();
}