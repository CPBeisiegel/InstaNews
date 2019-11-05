
package com.example.instanews.model.pojos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "sources")
public class Source {


    @Expose
    @SerializedName("id")
    private String idSource;


    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "nomeFonte")
    private String name;



    public Source(String idSource, String name) {
        this.idSource = idSource;
        this.name = name;
    }

    public String getId() {
        return idSource;
    }

    public void setId(String id) {
        this.idSource = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
