package com.example.instanews.model.pojos;

import android.os.Parcel;
import android.os.Parcelable;

public class Signo implements Parcelable {

    public int imagemSigno;
    public String nomeSigno;


    public Signo(){

    }

    public Signo(int imagemSigno, String nomeSigno) {
        this.imagemSigno = imagemSigno;
        this.nomeSigno = nomeSigno;
    }

    protected Signo(Parcel in) {
        imagemSigno = in.readInt();
        nomeSigno = in.readString();
    }



    public static final Creator<Signo> CREATOR = new Creator<Signo>() {
        @Override
        public Signo createFromParcel(Parcel in) {
            return new Signo(in);
        }

        @Override
        public Signo[] newArray(int size) {
            return new Signo[size];
        }
    };

    public int getImagemSigno() {
        return imagemSigno;
    }

    public void setImagemSigno(int imagemSigno) {
        this.imagemSigno = imagemSigno;
    }

    public String getNomeSigno() {
        return nomeSigno;
    }

    public void setNomeSigno(String nomeSigno) {
        this.nomeSigno = nomeSigno;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imagemSigno);
        parcel.writeString(nomeSigno);
    }
}
