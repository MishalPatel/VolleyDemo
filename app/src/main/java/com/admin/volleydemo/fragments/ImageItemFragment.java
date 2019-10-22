package com.admin.volleydemo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.admin.volleydemo.R;
import com.admin.volleydemo.applicationcontroller.MyApplication;
import com.admin.volleydemo.model.Item;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

public class ImageItemFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_pager_image,container,false);

        NetworkImageView networkImageView = (NetworkImageView) view.findViewById(R.id.griddetailnetworkimage);
        networkImageView.setImageUrl(getArguments().getString("Image"),MyApplication.getInstance().getImageLoader());
        return view;
    }
}