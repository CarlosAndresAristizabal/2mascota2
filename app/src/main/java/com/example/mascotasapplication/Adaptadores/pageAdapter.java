package com.example.mascotasapplication.Adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class pageAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> fragments;
    private FragmentManager fm;

    public pageAdapter(@NonNull FragmentManager manager, ArrayList<Fragment> fragments) {
        super(manager);
        this.fragments = fragments;
        this.fm = manager;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
