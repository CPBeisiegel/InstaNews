package com.example.instanews.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instanews.Interface.RecyclerSignoOnClick;
import com.example.instanews.Interface.RecyclerViewOnClick;
import com.example.instanews.R;
import com.example.instanews.adapter.HomeAdapter;
import com.example.instanews.adapter.SignoAdapter;
import com.example.instanews.model.Noticias;
import com.example.instanews.model.Signo;
import com.example.instanews.views.activity.HomeActivity;
import com.example.instanews.views.activity.NoticiaActivity;
import com.example.instanews.views.activity.SignoActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignoFragment extends Fragment implements RecyclerSignoOnClick{

    private RecyclerView recyclerView;
    public static final String SIGNO_KEY = "signo";



    public SignoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signo, container, false);

        recyclerView = view.findViewById(R.id.fragment_signo);
        RecyclerSignoOnClick signoListener = new RecyclerSignoOnClick() {
            @Override
            public void onClick(Signo signo) {
                Intent intent = new Intent(getActivity(), SignoActivity.class);
                startActivity(intent);

            }

        };


        SignoAdapter adapter = new SignoAdapter(retornaSigno(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        return view;


    }

    public List<Signo> retornaSigno(){
        List<Signo> listaSignos = new ArrayList<>();
        listaSignos.add(new Signo(R.drawable.aries, "Áries"));
        listaSignos.add(new Signo(R.drawable.touro, "Touro"));
        listaSignos.add(new Signo(R.drawable.gemeos, "Gêmeos"));
        listaSignos.add(new Signo(R.drawable.cancer, "Câncer"));
        listaSignos.add(new Signo(R.drawable.leo, "Leão"));
        listaSignos.add(new Signo(R.drawable.virgem, "Virgem"));
        listaSignos.add(new Signo(R.drawable.libra, "Libra"));

        return  listaSignos;
    }

    @Override
    public void onClick(Signo signo) {
        Intent intent = new Intent(getContext(), SignoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(SIGNO_KEY, signo);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
