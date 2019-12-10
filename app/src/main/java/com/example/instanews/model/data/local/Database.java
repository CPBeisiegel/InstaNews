package com.example.instanews.model.data.local;

import android.content.Context;


import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.instanews.model.pojos.Article;

@androidx.room.Database(entities = {Article.class}, version = 2, exportSchema = false)
@TypeConverters(Converters.class) // Adicionamos os conversores

public abstract class Database extends RoomDatabase {

    private static volatile Database INSTANCE;

    public abstract FavDao favDao();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "instanews_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
