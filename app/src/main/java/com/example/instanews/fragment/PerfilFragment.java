package com.example.instanews.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instanews.Interface.RecyclerViewOnClick;
import com.example.instanews.R;
import com.example.instanews.adapter.HomeAdapter;
import com.example.instanews.model.Noticias;
import com.example.instanews.views.activity.NoticiaActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private RecyclerView recyclerView;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        recyclerView = view.findViewById(R.id.fragmentlist_perfil);
        RecyclerViewOnClick listener = new RecyclerViewOnClick() {
            @Override
            public void onClick(Noticias noticias) {
                Intent intent = new Intent(getActivity(), NoticiaActivity.class);
                startActivity(intent);

            }
        };
        List<Noticias> listanoticia = new ArrayList<>();
        listanoticia.add(new Noticias(R.drawable.foto_noticia1, "Titulo Teste", "Descrição teste"));
        listanoticia.add(new Noticias(R.drawable.foto_noticia1, "Titulo Teste", "Descrição teste"));
        listanoticia.add(new Noticias(R.drawable.foto_noticia1, "Titulo Teste", "Descrição teste"));
        listanoticia.add(new Noticias(R.drawable.foto_noticia1, "Titulo Teste", "Descrição teste"));
        listanoticia.add(new Noticias(R.drawable.foto_noticia1, "Titulo Teste", "Descrição teste"));
        listanoticia.add(new Noticias(R.drawable.foto_noticia1, "Titulo Teste", "Descrição teste"));
        listanoticia.add(new Noticias(R.drawable.foto_noticia1, "Titulo Teste", "Descrição teste"));

        HomeAdapter adapter = new HomeAdapter(listanoticia, listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
