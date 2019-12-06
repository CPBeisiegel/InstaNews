
package com.example.instanews.model.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "article")
public class Article implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @Expose
    @ColumnInfo(name = "author")
    private String author;
    @Expose
    private String content;
    @Expose
    @ColumnInfo(name = "description")
    private String description;
    @Expose
    private String publishedAt;
    @Expose
    private Source source;
    @Expose
    @ColumnInfo(name = "name")
    private String title;
    @Expose
    private String url;
    @ColumnInfo(name = "imagem")
    @Expose
    private String urlToImage;

    @Ignore
    protected Article(Parcel in) {
        author = in.readString();
        content = in.readString();
        description = in.readString();
        publishedAt = in.readString();
        title = in.readString();
        url = in.readString();
        urlToImage = in.readString();
    }

    public Article() {
    }

    @Ignore
    public Article(long id, String author, String content, String description, String publishedAt, Source source, String title, String url, String urlToImage) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.description = description;
        this.publishedAt = publishedAt;
        this.source = source;
        this.title = title;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(author);
        parcel.writeString(content);
        parcel.writeString(description);
        parcel.writeString(publishedAt);
        parcel.writeString(title);
        parcel.writeString(url);
        parcel.writeString(urlToImage);
    }
}
