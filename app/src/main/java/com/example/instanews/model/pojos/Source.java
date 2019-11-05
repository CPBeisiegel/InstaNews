
package com.example.instanews.model.pojos;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {


    @Expose
    @SerializedName("id")
    private String id;


    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "nomeFonte")
    private String name;



    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
