package com.example.instanews.activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.instanews.R;
import com.example.instanews.adapter.ViagemAdapter;
import com.example.instanews.fragment.TelasFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        List<Fragment> navigationlist = new ArrayList<>();

        navigationlist.add(new TelasFragment());
        navigationlist.add(new TelasFragment());
        navigationlist.add(new TelasFragment());
        navigationlist.add(new TelasFragment());
        navigationlist.add(new TelasFragment());


        ViagemAdapter adapter = new ViagemAdapter(getSupportFragmentManager(), navigationlist);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        //BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        viewPager.setOffscreenPageLimit(navigationlist.size());

        //bottomNavigationView.setupWithViewPager(viewPager);

    }
}

