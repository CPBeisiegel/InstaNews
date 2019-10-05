package com.example.instanews.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.instanews.R;


/**
 * A simple {@link Fragment} subclass.
 */

public class TelasFragment extends Fragment {
    private static final String TITULO = "titulo";
    private static final String DESCRICAO = "descricao";
    private static final String IMAGEM = "imagem";
    private TextView txtTitulo;
    private TextView txtDescricao;
    private ImageView imgViagem;


    public TelasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_telas, container, false);



        imgViagem = view.findViewById(R.id.imagemview);
        txtTitulo = view.findViewById(R.id.tituloviagem_id);
        txtDescricao = view.findViewById(R.id.descricao_id);

        if (getArguments() != null) {

            int imagemRecebida = getArguments().getInt(IMAGEM);
            String tituloRecebido = getArguments().getString(TITULO);
            String descricaoRecebida = getArguments().getString(DESCRICAO);

            Drawable drawable = getResources().getDrawable(imagemRecebida);

            imgViagem.setImageDrawable(drawable);
            txtTitulo.setText(tituloRecebido);
            txtDescricao.setText(descricaoRecebida);

        }

        return view;
    }

    public static Fragment novaInstancia(int imagem, String titulo, String descricao) {

        TelasFragment telasFragment = new TelasFragment();
        Bundle bundle = new Bundle();

        bundle.putInt(IMAGEM, imagem);
        bundle.putString(TITULO, titulo);
        bundle.putString(DESCRICAO, descricao);

        telasFragment.setArguments(bundle);

        return telasFragment;
    }

}

