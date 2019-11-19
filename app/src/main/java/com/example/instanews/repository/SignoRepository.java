package com.example.instanews.repository;

import com.example.instanews.model.pojos.Result;

import io.reactivex.Observable;

import static com.example.instanews.model.remote.RetrofitService.getApiService;


public class SignoRepository {

    public Observable<Result> getSignosSearch(String q, String apikey){
        return getApiService().getSigno(q, apikey);
    }
}
