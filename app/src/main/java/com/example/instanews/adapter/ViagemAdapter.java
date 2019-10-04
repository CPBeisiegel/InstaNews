package com.example.instanews.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class ViagemAdapter extends FragmentStatePagerAdapter {


    public List<Fragment> viagemList;

    public ViagemAdapter(FragmentManager fm, List<Fragment> viagemList) {
        super(fm);
        this.viagemList = viagemList;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return viagemList.get(position);
    }

    @Override
    public int getCount() {
        return viagemList.size();
    }

}
