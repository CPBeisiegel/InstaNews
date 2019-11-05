package com.example.instanews.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.instanews.model.data.Database;
import com.example.instanews.model.data.NoticiaDao;
import com.example.instanews.model.pojos.Article;
import com.example.instanews.model.pojos.News;
import com.example.instanews.repository.NoticiaRepository;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class ArticleViewModel extends AndroidViewModel {

    private MutableLiveData<List<Article>> resultLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private NoticiaRepository repository = new NoticiaRepository();


    public ArticleViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Article>> getResultLiveData() {
        return getResultLiveData();
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
