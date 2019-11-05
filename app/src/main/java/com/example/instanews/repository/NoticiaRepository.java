package com.example.instanews.repository;

import com.example.instanews.model.pojos.News;

import io.reactivex.Observable;

import static com.example.instanews.model.remote.RetrofitService.getApiService;

public class NoticiaRepository {

    public Observable<News> getFilmes(String pais, String apiKey){
        return getApiService().getTopNoticias(pais, apiKey);
    }

}
