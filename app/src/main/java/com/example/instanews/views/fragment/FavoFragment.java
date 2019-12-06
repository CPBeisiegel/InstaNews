package com.example.instanews.views.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instanews.R;
import com.example.instanews.model.pojos.Article;
import com.example.instanews.viewmodel.FavoritosViewModel;
import com.example.instanews.views.Interface.RecyclerViewOnClick;
import com.example.instanews.views.adapter.ArticleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoFragment extends Fragment implements RecyclerViewOnClick {

    private ArticleAdapter adapter;
    private List<Article> listaArtigos= new ArrayList<>();

    public FavoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favo, container, false);

        FavoritosViewModel favoritosViewModel = ViewModelProviders.of(this).get(FavoritosViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerviewFav);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new ArticleAdapter(listaArtigos, this);
        recyclerView.setAdapter(adapter);

        favoritosViewModel.mostrarFavoritos();

        favoritosViewModel.getListaFav().observe(this, articles -> adapter.atualizaLista(articles));


        // TODO: Listar itens salvos no firebase database

        return view;
    }

    @Override
    public void onClick(Article noticias) {

    }
}
