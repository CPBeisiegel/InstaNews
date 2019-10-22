package com.example.instanews.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.instanews.Interface.RecyclerSignoOnClick;
import com.example.instanews.R;
import com.example.instanews.fragment.AddFragment;
import com.example.instanews.fragment.FavoFragment;
import com.example.instanews.fragment.PerfilFragment;
import com.example.instanews.fragment.PesquisaFragment;
import com.example.instanews.fragment.SignoFragment;
import com.example.instanews.model.Signo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

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
    }

    private void replaceFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    public boolean subpagina(int id) {


        switch (id) {
            case R.id.nav_add:
                replaceFragment(R.id.container1, new AddFragment());
                return true;
            case R.id.nav_fav:
                replaceFragment(R.id.container1, new FavoFragment());
                return true;
            case R.id.nav_pesquisa:
                replaceFragment(R.id.container1, new PesquisaFragment());
                return true;
            case R.id.nav_perfil:
                replaceFragment(R.id.container1, new PerfilFragment());
                return true;
        }

        return false;

    }

}
