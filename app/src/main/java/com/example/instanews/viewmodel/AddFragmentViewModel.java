package com.example.instanews.viewmodel;
import io.reactivex.android.schedulers.AndroidSchedulers;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.instanews.model.pojos.Article;
import com.example.instanews.repository.NoticiaRepository;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class AddFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<List<Article>> listArticle = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();
    private NoticiaRepository repository = new NoticiaRepository();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();


    public AddFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Article>> getArticles() {
        return this.listArticle;
    }

    public LiveData<Boolean> getLoading(){
        return this.loading;
    }

    public void getAllArticle(){
        disposable.add(
                repository.getNoticas("br","e20a658afa904c22850939f8f038a03c" )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> loading.setValue(true))
                .doOnTerminate(()-> loading.setValue(false))
               .subscribe(result -> {
                   listArticle.setValue(result.getArticles());
               })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
