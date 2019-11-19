package com.example.instanews.model.remote;

import com.example.instanews.model.pojos.Result;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceAPI {

    @GET("top-headlines")
    Observable<Result> getTopNoticias(@Query("country") String pais,
                                      @Query("apiKey") String apiKey);

    @GET("everything")
    Observable<Result> getSigno(@Query("q") String pesquisa,
                                @Query("apikey") String apikey);
}
