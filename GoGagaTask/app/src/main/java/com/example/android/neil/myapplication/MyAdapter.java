package com.example.android.neil.myapplication;

import android.content.Context;

import com.example.android.neil.myapplication.ui.profile.ProfileFragement;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyAdapter extends FragmentStatePagerAdapter {
    int totalTabs;
    public MyAdapter(ProfileFragement c, FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Requests requestsFragment = new Requests();
                return requestsFragment;
            case 1:
                Offerings offeringsFragment = new Offerings();
                return offeringsFragment;
            case 2:
                Recommends recommendsFragment = new Recommends();
                return recommendsFragment;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}