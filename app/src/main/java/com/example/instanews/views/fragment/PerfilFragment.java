package com.example.instanews.views.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instanews.R;
import com.example.instanews.viewmodel.PrincipaisNoticiasViewModel;
import com.example.instanews.views.adapter.ArticleAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private RecyclerView recyclerView;
    private ImageView imgProfile;
    private TextView nameProfile;
    private Button btnLogout;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        initView(view);


        return view;
    }

    public void initView(View view){
        imgProfile = view.findViewById(R.id.imageView3);
        nameProfile = view.findViewById(R.id.nomePerfil);
        btnLogout = view.findViewById(R.id.buttonSair);
    }
}
