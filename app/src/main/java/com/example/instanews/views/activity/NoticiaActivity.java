package com.example.instanews.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instanews.model.pojos.Article;
import com.example.instanews.R;
import com.example.instanews.viewmodel.FavoritosViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import static com.example.instanews.views.fragment.PrincipaisNoticFragment.ARTICLE_KEY;

public class NoticiaActivity extends AppCompatActivity {

    public TextView tituloNoticia;
    public ImageView fotoNoticia;
    public TextView fonteNoticia;
    public TextView corpoDoTexto;
    public Button siteNoticia;
    public FloatingActionButton floatingActionButton;
    private ImageButton imageButton;
    private FavoritosViewModel favoritosViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);

        initViews();

        if(getIntent() != null && getIntent().getExtras() != null){
            Article article = getIntent().getExtras().getParcelable(ARTICLE_KEY);
            Picasso.get().load(article.getUrlToImage()).into(fotoNoticia);
            tituloNoticia.setText(article.getTitle());
            fonteNoticia.setText(article.getAuthor());
            corpoDoTexto.setText(article.getContent());

            siteNoticia.setOnClickListener(view -> {
                Intent intent = new Intent(this, WebViewAcitivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(ARTICLE_KEY, article);
                intent.putExtras(bundle);
                startActivity(intent);
            });

            imageButton.setOnClickListener(view -> {
                favoritosViewModel.inserirNoticia(article);

            });
        }

        floatingActionButton.setOnClickListener(view -> {
            onBackPressed();
        });



    }
    private void initViews(){
        tituloNoticia = findViewById(R.id.tituloNoticia1);
        imageButton = findViewById(R.id.btn_favo);
        fotoNoticia = findViewById(R.id.fotoNoticia1);
        fonteNoticia = findViewById(R.id.fonteNoticia1);
        corpoDoTexto = findViewById(R.id.corpoTexto);
        favoritosViewModel = ViewModelProviders.of(this).get(FavoritosViewModel.class);
        siteNoticia = findViewById(R.id.btn_webview);
        floatingActionButton = findViewById(R.id.floatingActionButtonnSigno);
    }
}
