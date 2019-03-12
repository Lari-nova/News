package com.hfad.news.network;

import com.hfad.news.entity.Example;

import java.io.IOException;
import io.reactivex.subjects.BehaviorSubject;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private BehaviorSubject<Example> subject = BehaviorSubject.create();

    public BehaviorSubject<Example> subscribeNews() {
        return subject;
    }

    public void requestNews(final String newsType, String q) {
        new Thread(() -> subject.onNext(load(newsType, q))).start();
    }

    private Example load(String newsType, String q) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiMessages messagesApi = retrofit.create(ApiMessages.class);

        Call<Example> messages = messagesApi.messages(newsType, q,"0b0cfa8211f14fcbb7cc5958c15bd816");

        try {
            Response<Example> response =  messages.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
