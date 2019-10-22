package com.example.instanews.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instanews.Interface.RecyclerSignoOnClick;
import com.example.instanews.R;

public class NoticiaActivity extends AppCompatActivity {

    public TextView tituloNoticia;
    public ImageView fotoNoticia;
    public TextView fonteNoticia;
    public TextView corpoDoTexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signo);

        initViews();

    }




    private void initViews(){
        tituloNoticia = findViewById(R.id.tituloNoticia1);
        fotoNoticia = findViewById(R.id.fotoNoticia1);
        fonteNoticia = findViewById(R.id.fonteNoticia1);
        corpoDoTexto = findViewById(R.id.corpoTexto);
    }
}
