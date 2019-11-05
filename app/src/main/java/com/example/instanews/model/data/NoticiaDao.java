package com.example.instanews.model.data;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.instanews.model.pojos.News;
import com.example.instanews.model.pojos.Source;

import java.util.List;

import io.reactivex.Observable;

public interface NoticiaDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<News> news);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Source> source);


    @Update
    void update(Source source);

    @Delete
    void delete(Source news);

    @Query("DELETE FROM news")
    List<Source> deleteAll();

    @Query("SELECT * FROM News")
    Observable<List<Source>> getAllNotcias();

    @Query("SELECT * FROM News ORDER BY id DESC LIMIT 5")
    Observable<List<Source>> newsRecentes();

    @Query("SELECT id, name FROM news WHERE id = :id")
    Source getById(Long id);

    @Query("SELECT id, name FROM news WHERE name = :name")
    Source getByName(String name);


}
