
package com.example.instanews.model.pojos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "artigos")
public class Article {


    @PrimaryKey(autoGenerate = true)
    private long id;

    @Expose
    @SerializedName("author")
    @ColumnInfo(name = "autor")
    private String author;

//    @Expose
//    private Object content;

    @Expose
    @SerializedName("description")
    @ColumnInfo(name = "descrição")
    private String description;

    @Expose
    @SerializedName("publishAt")
    @ColumnInfo(name = "dataPublicação")
    private String publishedAt;

    @Expose
    @SerializedName("source")
    @ColumnInfo(name = "source")
    private Source source;

    @Expose
    @SerializedName("title")
    @ColumnInfo(name = "titulo")
    private String title;

    @Expose
    @SerializedName("url")
    @ColumnInfo(name = "urlDaNoticia")
    private String url;

    @Expose
    @SerializedName("urlToImage")
    @ColumnInfo(name = "urlDaImagem")
    private String urlToImage;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public Object getContent() {
//        return content;
//    }
//
//    public void setContent(Object content) {
//        this.content = content;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

}
