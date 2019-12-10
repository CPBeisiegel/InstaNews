package com.example.instanews.views.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instanews.R;
import com.example.instanews.views.activity.HomeActivity;
import com.example.instanews.views.activity.LoginActivity;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import static com.example.instanews.views.activity.LoginActivity.GOOGLE_ACCOUNT;
import static com.google.firebase.auth.FirebaseAuth.getInstance;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private Button botaoSair;
    private ImageView imgProfile;
    private TextView emalProfile;
    private TextView nomeProfile;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        initView(view);

        FirebaseUser firebaseAuth = getInstance().getCurrentUser();
        if (firebaseAuth != null) {
            Picasso.get().load(firebaseAuth.getPhotoUrl()).error(R.drawable.viagem).into(imgProfile);
            emalProfile.setText(firebaseAuth.getEmail());
            nomeProfile.setText(firebaseAuth.getDisplayName());
        }


        botaoSair.setOnClickListener(view1 -> {
            //saindo
            Intent intent =  new Intent(getContext(), LoginActivity.class);
            FirebaseAuth.getInstance().signOut();
            startActivity(intent);
        });
        return view;
    }




    public void initView(View view){
        botaoSair = view.findViewById(R.id.buttonSair);
        imgProfile = view.findViewById(R.id.imageViewPerfil);
        emalProfile = view.findViewById(R.id.emailPerfil);
        nomeProfile = view.findViewById(R.id.nomePerfil);

    }



}
