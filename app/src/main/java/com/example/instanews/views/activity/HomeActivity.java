package com.example.instanews.views.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.instanews.R;
import com.example.instanews.views.fragment.PrincipaisNoticFragment;
import com.example.instanews.views.fragment.FavoFragment;
import com.example.instanews.views.fragment.PerfilFragment;
import com.example.instanews.views.fragment.SearchFragment;
import com.example.instanews.views.fragment.SignoFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import static com.example.instanews.views.activity.LoginActivity.GOOGLE_ACCOUNT;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    private GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity);


        replaceFragment(R.id.container2, new SignoFragment());
        navigationView = findViewById(R.id.buttonnavigation);
        subpagina(navigationView.getSelectedItemId());


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                return subpagina(menuItem.getItemId());

            }

        });


        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        //Atribuição paraa  o objeto o valor do login recebido
        googleSignInClient = GoogleSignIn.getClient(this, gso);

        //Chamada do método que pega os dados do usuario e atribui para as views
        pegaOsDados();
    }

    private void replaceFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    public boolean subpagina(int id) {


        switch (id) {
            case R.id.nav_fav:
                replaceFragment(R.id.container1, new FavoFragment());
                return true;
            case R.id.nav_pesquisa:
                replaceFragment(R.id.container1, new SearchFragment());
                return true;
            case R.id.nav_perfil:
                replaceFragment(R.id.container1, new PerfilFragment());
                return true;
            case R.id.nav_home:
                replaceFragment(R.id.container1, new PrincipaisNoticFragment());
                return true;
        }

        return false;

    }

    //Chamada do método que pega os dados do usuario e atribui para as views
    private void pegaOsDados() {
        GoogleSignInAccount googleSignInAccount = getIntent().getParcelableExtra(GOOGLE_ACCOUNT);
        // Picasso.get().load(googleSignInAccount.getPhotoUrl()).centerInside().fit().into(imgProfile);
        // nameProfile.setText(googleSignInAccount.getDisplayName());
    }

}
