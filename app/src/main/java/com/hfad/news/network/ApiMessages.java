package com.hfad.news.network;

import com.hfad.news.entity.Example;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiMessages {

    @GET("/v2/top-headlines")

    Call<Example> messages(@Query("sources") String sources, @Query("q") String q, @Query("apiKey") String apiKey);
}
