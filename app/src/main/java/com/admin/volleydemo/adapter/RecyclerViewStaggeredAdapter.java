package com.admin.volleydemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.admin.volleydemo.StaggeredDetailActivity;
import com.admin.volleydemo.R;
import com.admin.volleydemo.applicationcontroller.MyApplication;
import com.admin.volleydemo.model.Item;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;


public class RecyclerViewStaggeredAdapter extends RecyclerView.Adapter<RecyclerViewStaggeredAdapter.MyViewHolder> {
    ArrayList<Item> arrayList = new ArrayList<Item>();
    Context context;
    ImageLoader imageLoader = MyApplication.getInstance().getImageLoader();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tilte, rating, genre;
        NetworkImageView imageView;

        View itemView;
        // ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            tilte = (TextView) itemView.findViewById(R.id.titletxt);
            rating = (TextView) itemView.findViewById(R.id.ratingetxt);
            genre = (TextView) itemView.findViewById(R.id.genretxt);
//            imageView = (ImageView) itemView.findViewById(R.id.imageview);
            imageView = (NetworkImageView) itemView.findViewById(R.id.imageview);

            this.itemView = itemView;
        }
    }

    public RecyclerViewStaggeredAdapter(Context context, ArrayList<Item> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.staggered_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tilte.setText(arrayList.get(position).getTitle());
        holder.rating.setText("Rating: " + arrayList.get(position).getRating());

        final Item item = arrayList.get(position);
        holder.imageView.setImageUrl(item.getImageUrl(), imageLoader);
        String genreStr = "";
        for (String str : item.getGenre()) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        holder.genre.setText(genreStr);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication.getInstance().setItemSelected(arrayList.get(position));

                Intent intent = new Intent(context, StaggeredDetailActivity.class);
                intent.putExtra("position", position);
                context.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
