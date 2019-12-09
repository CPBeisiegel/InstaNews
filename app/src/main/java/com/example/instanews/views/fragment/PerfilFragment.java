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
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.squareup.picasso.Picasso;

import static com.example.instanews.views.activity.LoginActivity.GOOGLE_ACCOUNT;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private Button botaoSair;
    private GoogleSignInClient googleSignInClient;
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


        //Ação que traz os dados Default do usuário selecionado na hora do login
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(getContext(), gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getActivity());
        if (acct != null){
            Picasso.get().load(acct.getPhotoUrl()).centerInside().fit().into(imgProfile);
            nomeProfile.setText(acct.getDisplayName());
            emalProfile.setText(acct.getEmail());

        }
        //GoogleSignInAccount googleSignInAccount = getIntent().getParcelableExtra(GOOGLE_ACCOUNT);
        //Picasso.get().load(googleSignInAccount.getPhotoUrl()).centerInside().fit().into(imgProfile);
        //emalProfile.setText(googleSignInAccount.getDisplayName());


        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                googleSignInClient.signOut().addOnCompleteListener(task -> {
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                });
            }
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
