package com.admin.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.admin.volleydemo.applicationcontroller.MyApplication;
import com.admin.volleydemo.model.Item;
import com.android.volley.toolbox.NetworkImageView;

public class ListDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarlist);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        Item item = MyApplication.getInstance().getItemSelected();

        getSupportActionBar().setTitle(item.getTitle());

        ((NetworkImageView) findViewById(R.id.listdetailnetworkimage)).setImageUrl(item.getImageUrl(), MyApplication.getInstance().getImageLoader());
        TextView raring = (TextView) findViewById(R.id.rating);
        TextView genre = (TextView) findViewById(R.id.genre);
        raring.setText("Rating : " + item.getRating());
        genre.setText("" + item.getGenre());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent homeIntent = new Intent(ListDetailActivity.this, MainActivity.class);
//                startActivity(homeIntent);
                onBackPressed();
            }
        });
    }


}
