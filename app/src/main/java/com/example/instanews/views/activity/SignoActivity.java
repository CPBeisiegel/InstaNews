package com.example.instanews.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instanews.R;
import com.example.instanews.model.Signo;

import static com.example.instanews.fragment.SignoFragment.SIGNO_KEY;

public class SignoActivity extends AppCompatActivity {

    public TextView nomeSigno;
    public TextView tituloNoticia;
    public ImageView fotoNoticia;
    public TextView fonteNoticia;
    public TextView corpoDoTexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signo);

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null){
            Signo signo = getIntent().getExtras().getParcelable(SIGNO_KEY);
            nomeSigno.setText(signo.getNomeSigno());
        }

    }

    private void initViews(){
        nomeSigno = findViewById(R.id.nomeSigno);
        tituloNoticia = findViewById(R.id.TituloNoticia);
        fotoNoticia = findViewById(R.id.imagetitulo);
        fonteNoticia = findViewById(R.id.fonteNoticia1);
        corpoDoTexto = findViewById(R.id.corpoTexto);
    }
}


