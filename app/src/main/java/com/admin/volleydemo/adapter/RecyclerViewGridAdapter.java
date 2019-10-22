package com.admin.volleydemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.admin.volleydemo.GridDetailActivity;
import com.admin.volleydemo.R;
import com.admin.volleydemo.applicationcontroller.MyApplication;
import com.admin.volleydemo.model.Item;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by admin on 09-02-2017.
 */

public class RecyclerViewGridAdapter extends RecyclerView.Adapter<RecyclerViewGridAdapter.MyViewHolder> {
    ArrayList<Item> arrayList;
    Context context;
    private static final String TAG = RecyclerViewGridAdapter.MyViewHolder.class.getSimpleName();
    ImageLoader imageLoader = MyApplication.getInstance().getImageLoader();

    public RecyclerViewGridAdapter(Context context, ArrayList<Item> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, rating, genre;
        NetworkImageView networkImageView;
        View itemView;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txtgridtitle);
            rating = (TextView) itemView.findViewById(R.id.txtgridratintg);
            genre = (TextView) itemView.findViewById(R.id.txtgridgenre);

            networkImageView = (NetworkImageView) itemView.findViewById(R.id.networkview);
            this.itemView = itemView;
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_row, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.rating.setText("Rating : " + arrayList.get(position).getRating());
        Item item = arrayList.get(position);
        holder.networkImageView.setImageUrl(item.getImageUrl(), imageLoader);
        holder.genre.setText(" " + arrayList.get(position).getGenre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GridDetailActivity.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount()
    {
        return arrayList.size();
    }



}
