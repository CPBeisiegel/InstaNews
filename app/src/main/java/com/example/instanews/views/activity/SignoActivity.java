package com.example.instanews.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.instanews.R;
import com.example.instanews.model.pojos.Article;
import com.example.instanews.model.pojos.Signo;
import com.example.instanews.viewmodel.SearchViewModel;
import com.example.instanews.views.Interface.RecyclerViewOnClick;
import com.example.instanews.views.adapter.ArticleAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.instanews.views.fragment.PrincipaisNoticFragment.ARTICLE_KEY;
import static com.example.instanews.views.fragment.SignoFragment.SIGNO_KEY;

public class SignoActivity extends AppCompatActivity implements RecyclerViewOnClick {

    public TextView nomeSigno;
    public ImageView fotoNoticia;
    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private SearchViewModel searchViewModel;
    private List<Article> articles = new ArrayList<>();
    private ProgressBar progressBar;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signo);

        initViews();

        if(getIntent() != null && getIntent().getExtras() != null) {
            Signo signo = getIntent().getExtras().getParcelable(SIGNO_KEY);
            nomeSigno.setText(signo.getNomeSigno());
            Drawable drawable = getResources().getDrawable(signo.imagemSigno);
            fotoNoticia.setImageDrawable(drawable);
            searchViewModel.getSearch(signo.nomeSigno + " horoscope", "e20a658afa904c22850939f8f038a03c");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        searchViewModel.getSearchArticle().observe(this, result-> {
            adapter.atualizaLista(result);
        });
        searchViewModel.getLoading().observe(this, loading-> {
            if(loading){
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        floatingActionButton.setOnClickListener(v-> {
            onBackPressed();
        });

    }

    private void initViews(){
        nomeSigno = findViewById(R.id.nomeSigno);
        fotoNoticia = findViewById(R.id.imagetitulo);
        recyclerView = findViewById(R.id.recycler_signo);
        adapter = new ArticleAdapter(articles, this);
        progressBar = findViewById(R.id.progress_signo);
        floatingActionButton = findViewById(R.id.floatingActionButtonnSigno);
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
    }

    @Override
    public void onClick(Article noticias) {
        Intent intent = new Intent(this, NoticiaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARTICLE_KEY, noticias);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}


