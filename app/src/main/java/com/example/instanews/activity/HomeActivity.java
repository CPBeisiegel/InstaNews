package com.example.instanews.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.instanews.R;
import com.example.instanews.fragment.TelasFragment;
import com.example.instanews.fragment.TesteFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

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
                        replaceFragment(R.id.container1, new TelasFragment());
                        return true;
                    case R.id.nav_fav:
                        replaceFragment(R.id.container1, new TesteFragment());
                        return true;
                }

                return false;
            }
        });
    }

    private void replaceFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }


//    public class PageChange implements ViewPager.OnPageChangeListener {
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//            switch (position) {
//                case 0:
//                    navigationView.setSelectedItemId(R.id.nav_add);
//                    break;
//                case 1:
//                    navigationView.setSelectedItemId(R.id.nav_fav);
//                    break;
//                case 2:
//                    navigationView.setSelectedItemId(R.id.nav_home);
//                    break;
//            }
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//        }
//    }

}
