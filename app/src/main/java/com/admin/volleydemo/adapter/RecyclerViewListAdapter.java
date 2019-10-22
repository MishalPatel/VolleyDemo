package com.admin.volleydemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.admin.volleydemo.ListDetailActivity;
import com.admin.volleydemo.R;
import com.admin.volleydemo.applicationcontroller.MyApplication;

import com.admin.volleydemo.model.Item;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.futuremind.recyclerviewfastscroll.SectionTitleProvider;


import java.util.ArrayList;


public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.MyViewHolder> {
    ArrayList<Item> arrayList;

    Context context;
    private static final String TAG = MyViewHolder.class.getSimpleName();
    ImageLoader imageLoader = MyApplication.getInstance().getImageLoader();


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tilte, rating, genre;
        NetworkImageView networkImageView;
        View itemView;


        public MyViewHolder(View itemView) {
            super(itemView);
            tilte = (TextView) itemView.findViewById(R.id.txttitle);
            rating = (TextView) itemView.findViewById(R.id.txtrating);
            genre = (TextView) itemView.findViewById(R.id.txtgenre);

            networkImageView = (NetworkImageView) itemView.findViewById(R.id.networkImageview);
            this.itemView = itemView;
        }

    }


    public RecyclerViewListAdapter(Context context, ArrayList<Item> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tilte.setText(arrayList.get(position).getTitle());
        holder.rating.setText("Rating : " + arrayList.get(position).getRating());

        final Item item = arrayList.get(position);
        holder.networkImageView.setImageUrl(item.getImageUrl(), imageLoader);
        String genreStr = "";
        for (String str : item.getGenre()) {
            genreStr += str + " , ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        holder.genre.setText(genreStr);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyApplication.getInstance().setItemSelected(arrayList.get(position));

                Intent intent = new Intent(context, ListDetailActivity.class);

                context.startActivity(intent);


            }

        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
