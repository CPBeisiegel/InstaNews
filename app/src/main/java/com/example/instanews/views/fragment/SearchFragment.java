package com.example.instanews.views.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.instanews.R;
import com.example.instanews.model.pojos.Article;
import com.example.instanews.viewmodel.SearchViewModel;
import com.example.instanews.views.Interface.RecyclerViewOnClick;
import com.example.instanews.views.activity.NoticiaActivity;
import com.example.instanews.views.adapter.ArticleAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.instanews.views.fragment.PrincipaisNoticFragment.ARTICLE_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements RecyclerViewOnClick {

    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private SearchViewModel searchViewModel;
    private List<Article> articles = new ArrayList<>();
    private ProgressBar progressBar;
    private SearchView searchView;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_search, container, false);
        initView(view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        searchViewModel.getLoading().observe(this, (Boolean loading) -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        String inicialNoticia = "S";
        searchViewModel.getSearch(inicialNoticia, "e20a658afa904c22850939f8f038a03c");

        searchViewModel.getSearchArticle().observe(this, articles1 -> adapter.atualizaLista(articles1));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.clear();
                searchViewModel.getSearch(s, "e20a658afa904c22850939f8f038a03c");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.length() > 1) {
                    adapter.clear();
                    searchViewModel.getSearch(s, "e20a658afa904c22850939f8f038a03c");
                }
                return false;
            }
        });
        return view;
    }


    public void initView(View view){
        recyclerView = view.findViewById(R.id.recycler_search);
        adapter = new ArticleAdapter(articles, this);
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        searchView = view.findViewById(R.id.search_article);
        progressBar = view.findViewById(R.id.progress);
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
