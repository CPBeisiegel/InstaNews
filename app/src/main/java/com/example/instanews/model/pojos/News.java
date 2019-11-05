
package com.example.instanews.model.pojos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
@Entity(tableName = "news")
public class News {


    @PrimaryKey(autoGenerate = true)
    private long id;


    @ColumnInfo(name = "name")
    private String name;

    @Expose
    @SerializedName("articles")
    @ColumnInfo(name = "listaArtigos")
    private List<Article> articles;

    @Expose
    @SerializedName("status")
    @ColumnInfo(name = "status")
    private String status;

    @Expose
    @SerializedName("totalResults")
    @ColumnInfo(name = "resultadoTotal")
    private Long totalResults;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

}
