package com.example.instanews.model.remote;

import com.example.instanews.model.pojos.News;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceAPI {

    @GET("/top-headlines")
    Observable<News> getTopNoticias(@Query("country") String pais,
                                    @Path("apiKey")String apiKey);
}
