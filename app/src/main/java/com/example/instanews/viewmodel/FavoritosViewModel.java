package com.example.instanews.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.instanews.model.data.local.Database;
import com.example.instanews.model.data.local.FavDao;
import com.example.instanews.model.pojos.Article;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FavoritosViewModel extends AndroidViewModel {
    private MutableLiveData<Article> articleMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Article>> listaFavoritos = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();

    private FavDao favDao = Database.getDatabase(getApplication()).favDao();

    public FavoritosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Article> getArticle(){
        return this.articleMutableLiveData;
    }

    public LiveData<List<Article>> getListaFav(){
        return this.listaFavoritos;
    }

    public void inserirNoticia(Article article){
        new Thread(() -> {
            if(article != null){
                favDao.insereFavoritos(article);
            }
        }).start();

        this.articleMutableLiveData.setValue(article);
    }

    public void mostrarFavoritos(){
        disposable.add(
                favDao.getAllArticles()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loading.setValue(true))
                        .doOnTerminate(()-> loading.setValue(false))
                        .subscribe(result -> listaFavoritos.setValue(result))
        );
    }
}
