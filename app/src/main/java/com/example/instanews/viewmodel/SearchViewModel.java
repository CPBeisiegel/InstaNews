package com.example.instanews.viewmodel;

import android.app.Application;
import android.util.Log;

import com.example.instanews.model.pojos.Article;
import com.example.instanews.repository.SignoRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SearchViewModel extends AndroidViewModel {
    private MutableLiveData<List<Article>> listArticle = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private SignoRepository repository = new SignoRepository();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public SearchViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Article>> getArticles() {
        return this.listArticle;
    }

    public LiveData<Boolean> getLoading(){
        return this.loading;
    }

    public void getSearch(String q, String apiKey){
        disposable.add(
                repository.getSignosSearch(q, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> loading.setValue(true))
                .doOnTerminate(()->loading.setValue(false))
                .subscribe(result -> {
                    listArticle.setValue(result.getArticles());
                }, throwable -> {
                    Log.i("LOG", "ERROR: " + throwable.getMessage());
                })
        );
    }

}
