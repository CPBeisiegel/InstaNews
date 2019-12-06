package com.example.instanews.model.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.instanews.model.pojos.Article;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface FavDao {

    @Insert
    void insereFavoritos(Article article);

    @Query("SELECT * FROM article")
    Observable<List<Article>> getAllArticles();

    @Delete
    void deletarFavorito(Article article);

}
