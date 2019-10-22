package com.admin.volleydemo.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.admin.volleydemo.fragments.DesginFragment;
import com.admin.volleydemo.applicationcontroller.MyApplication;
import com.admin.volleydemo.fragments.ImageItemFragment;

/**
 * Created by admin on 08-02-2017.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {

        Bundle bundle = new Bundle();
        bundle.putString("Image", MyApplication.getInstance().getArrayList().get(position).getImageUrl());
        ImageItemFragment imageItemFragment = new ImageItemFragment();
        imageItemFragment.setArguments(bundle);
        return imageItemFragment;

    }

    @Override
    public int getCount()
    {
        return MyApplication.getInstance().getArrayList().size();
    }
}
