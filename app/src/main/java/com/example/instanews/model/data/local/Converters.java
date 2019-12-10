package com.example.instanews.model.data.local;

import androidx.room.TypeConverter;

import com.example.instanews.model.pojos.Article;
import com.example.instanews.model.pojos.Source;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Converters {

    @TypeConverter
    public Source fromSource(String value) {
        Type listType = (Type) new TypeToken<Article>() {
        }.getType();
        return new Gson().fromJson(String.valueOf(value), listType);
    }

    @TypeConverter
    public String fromString(Source value){
        Gson gson = new Gson();
        return gson.toJson(value);
    }


}
