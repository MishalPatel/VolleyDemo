package com.admin.volleydemo;


import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.admin.volleydemo.adapter.MyPagerAdapter;
import com.admin.volleydemo.applicationcontroller.MyApplication;

public class StaggeredDetailActivity extends AppCompatActivity {

    ViewPager viewPager;
    MyPagerAdapter pagerAdapter;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_detail);
        viewPager = (ViewPager) findViewById(R.id.viewpagergrid);

       final TextView rating = (TextView) findViewById(R.id.ratinggrid);
        final TextView title = (TextView) findViewById(R.id.titlegrid);
        final TextView genre = (TextView) findViewById(R.id.genregrid);

        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        int postion = getIntent().getIntExtra("position",0);
        viewPager.setCurrentItem(postion);

        title.setText("" + MyApplication.getInstance().getArrayList().get(postion).getTitle());
        rating.setText("Rating : " + MyApplication.getInstance().getArrayList().get(postion).getRating());
        genre.setText("" + MyApplication.getInstance().getArrayList().get(postion).getGenre());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                title.setText("" +MyApplication.getInstance().getArrayList().get(position).getTitle());
                rating.setText("Rating : " +MyApplication.getInstance().getArrayList().get(position).getRating());
                genre.setText("" +MyApplication.getInstance().getArrayList().get(position).getGenre());

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
