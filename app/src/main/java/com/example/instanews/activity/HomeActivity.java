package com.example.instanews.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.instanews.R;
import com.example.instanews.fragment.AddFragment;
import com.example.instanews.fragment.FavoFragment;
import com.example.instanews.fragment.PesquisaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity);

        navigationView = findViewById(R.id.buttonnavigation);


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_add:
                        replaceFragment(R.id.container1, new AddFragment());
                        return true;
                    case R.id.nav_fav:
                        replaceFragment(R.id.container1, new FavoFragment());
                        return true;
                    case R.id.nav_pesquisa:
                        replaceFragment(R.id.container1, new PesquisaFragment());
                        return true;
                }

                return false;
            }
        });
    }

    private void replaceFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

}
