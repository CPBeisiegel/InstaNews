package com.example.instanews.views.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instanews.model.pojos.Article;
import com.example.instanews.viewmodel.AddFragmentViewModel;
import com.example.instanews.views.Interface.RecyclerViewOnClick;
import com.example.instanews.R;
import com.example.instanews.views.activity.NoticiaActivity;
import com.example.instanews.views.adapter.ArticleAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

public class AddFragment extends Fragment implements RecyclerViewOnClick {
    public static final String ARTICLE_KEY = "article";
    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private AddFragmentViewModel addFragmentViewModel;
    private List<Article> articles = new ArrayList<>();
    private ProgressBar progressBar;


    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        initView(view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


        addFragmentViewModel.getAllArticle();
        addFragmentViewModel.getArticles().observe(this, articles1 -> {
            adapter.atualizaLista(articles1);
        });
        addFragmentViewModel.getLoading().observe(this, loading->{
            if(loading){
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });
        return view;
    }

    public void initView(View view){
        recyclerView = view.findViewById(R.id.recycler_article);
        adapter = new ArticleAdapter(articles, this);
        addFragmentViewModel = ViewModelProviders.of(this).get(AddFragmentViewModel.class);
        progressBar = view.findViewById(R.id.progress_signo);
    }

    @Override
    public void onClick(Article noticias) {
        Intent intent = new Intent(getContext(), NoticiaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARTICLE_KEY, noticias);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

