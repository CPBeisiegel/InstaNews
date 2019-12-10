package com.example.instanews.views.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instanews.model.pojos.Signo;
import com.example.instanews.views.Interface.RecyclerSignoOnClick;
import com.example.instanews.R;
import com.example.instanews.views.adapter.SignoAdapter;
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

        recyclerView = view.findViewById(R.id.recyclerview_signo);


        SignoAdapter adapter = new SignoAdapter(retornaSigno(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        return view;


    }

    public List<Signo> retornaSigno(){
        List<Signo> listaSignos = new ArrayList<>();
        listaSignos.add(new Signo(R.drawable.aries, "Aries"));
        listaSignos.add(new Signo(R.drawable.touro, "Taurus"));
        listaSignos.add(new Signo(R.drawable.gemeos, "Gemini"));
        listaSignos.add(new Signo(R.drawable.cancer, "Cancer"));
        listaSignos.add(new Signo(R.drawable.leo, "Leo"));
        listaSignos.add(new Signo(R.drawable.virgem, "Virgo"));
        listaSignos.add(new Signo(R.drawable.libra, "Libra"));
        listaSignos.add(new Signo(R.drawable.escorpiao,"Scorpio"));
        listaSignos.add(new Signo(R.drawable.sagitario,"Sagittarius"));
        listaSignos.add(new Signo(R.drawable.capricornio,"Capricorn"));
        listaSignos.add(new Signo(R.drawable.aquario,"Aquarius"));
        listaSignos.add(new Signo(R.drawable.peixes,"Pisces"));


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
