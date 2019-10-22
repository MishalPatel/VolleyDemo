package com.admin.volleydemo;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Gallery;

public class GridDetailActivity extends AppCompatActivity {
    TabLayout tabLayout;
    private int[] tabicnos = {R.drawable.ic_view_comfy_black_24dp,
            R.drawable.ic_group_black_24dp,
            R.drawable.ic_gps_fixed_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_detail);

        tabLayout = (TabLayout) findViewById(R.id.gridtablayout);

        tabLayout.addTab(tabLayout.newTab().setText("Gallery"));
        tabLayout.addTab(tabLayout.newTab().setText("Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Location"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        setupTabIcon();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void setupTabIcon() {
        tabLayout.getTabAt(0).setIcon(tabicnos[0]);
        tabLayout.getTabAt(1).setIcon(tabicnos[1]);
        tabLayout.getTabAt(2).setIcon(tabicnos[2]);
    }
}
