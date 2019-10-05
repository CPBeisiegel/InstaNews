package com.example.instanews.model;

import androidx.fragment.app.Fragment;

import java.util.List;

public class FragList {

    private List<Fragment> fragments;

    public FragList(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }
}
