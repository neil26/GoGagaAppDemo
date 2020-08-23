package com.example.android.neil.myapplication.ui.profile;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.android.neil.myapplication.MyAdapter;
import com.example.android.neil.myapplication.R;

import com.example.android.neil.myapplication.otherSettingsActivity;
import com.example.android.neil.myapplication.inviteMoreFriendsActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class ProfileFragement extends Fragment {
    Button btnOne;
    Button btnTwo;
    TabLayout tabLayout;
    ViewPager viewPager;


    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        btnOne = (Button) root.findViewById(R.id.btnOne);
        btnTwo = (Button ) root.findViewById(R.id.btnTwo);;
        btnOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(getActivity(), inviteMoreFriendsActivity.class);
                startActivity(activityChangeIntent);

            }

        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(getActivity(), otherSettingsActivity.class);
                startActivity(activityChangeIntent);
            }

        });
        tabLayout = root.findViewById(R.id.tabLayout);
        viewPager = root.findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Requests (0)"));
        tabLayout.addTab(tabLayout.newTab().setText("Offerings (0)"));
        tabLayout.addTab(tabLayout.newTab().setText("Recommends (0)"));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF6F26"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final MyAdapter adapter = new MyAdapter(this,getFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

        return root;
    }
}