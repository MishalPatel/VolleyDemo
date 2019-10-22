package com.admin.volleydemo;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.admin.volleydemo.adapter.RecyclerViewGridAdapter;
import com.admin.volleydemo.adapter.RecyclerViewStaggeredAdapter;
import com.admin.volleydemo.adapter.RecyclerViewListAdapter;
import com.admin.volleydemo.applicationcontroller.MyApplication;
import com.admin.volleydemo.model.Item;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String url = "http://api.androidhive.info/json/movies.json";
    ArrayList<Item> list;
    RecyclerViewListAdapter recyclerViewListAdapter;
    RecyclerViewStaggeredAdapter recyclerViewStaggeredAdapter;
    RecyclerViewGridAdapter recyclerViewGridAdapter;
    ProgressDialog progressDialog;

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //swipeRefreshLayout =(SwipeRefreshLayout) findViewById(R.id.swiperefres);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        fastScroller = (FastScroller) findViewById(R.id.fastscroll);
//        fastScroller.setBubbleColor(0xffccffcc);
//        fastScroller.setHandleColor(0xffff0000);
        list = new ArrayList<>();
        //       pagerAdapter = new ViewPagerAdapter(this,list);
//        viewPager.setAdapter(pagerAdapter);
//          progressDialog = new ProgressDialog(this);
//          progressDialog.setMessage("Wait...");
//          progressDialog.show();

//          JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//               @Override
//              public void onResponse(JSONArray response) {
//                    Log.d(TAG, response.toString());
//
//                  for (int i = 0; i < response.length(); i++) {
//
//                  try {
//
//                        JSONObject jsonObject = response.getJSONObject(i);
//                        Item item = new Item();
//                        item.setTitle(jsonObject.getString("title"));
//                        item.setRating(jsonObject.getString("rating"));
//                        item.setImageUrl(jsonObject.getString("image"));
//                        JSONArray genreArry = jsonObject.getJSONArray("genre");
//                        ArrayList<String> genre = new ArrayList<>();
//                        for (int j = 0; j < genreArry.length(); j++) {
//                            genre.add((String) genreArry.get(j));
//                        }
//                        item.setGenre(genre);
//                        list.add(item);
//
//                    } catch (JSONException e) {
//
//                    }
//
//                }
//                recyclerViewListAdapter = new RecyclerViewListAdapter(list);
//                recyclerView.setAdapter(recyclerViewListAdapter);
//                progressDialog.hide();
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                progressDialog.hide();
//            }
//        });
//
//        MyApplication.getInstance().addToRequestQueue(jsonArrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, 1, 0, "StaggeredGrid Layout");
        menu.add(0, 2, 0, "List Layout");
        menu.add(0, 3, 0, "Grid Layout");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, 1));

            list.clear();

            final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Log.d(TAG, response.toString());

                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            Item item = new Item();
                            item.setTitle(jsonObject.getString("title"));
                            item.setRating(jsonObject.getString("rating"));
                            item.setImageUrl(jsonObject.getString("image"));
                            JSONArray genreArry = jsonObject.getJSONArray("genre");
                            ArrayList<String> genre = new ArrayList<>();
                            for (int j = 0; j < genreArry.length(); j++) {
                                genre.add((String) genreArry.get(j));
                            }
                            item.setGenre(genre);
                            list.add(item);

                        } catch (JSONException e) {

                        }

                    }
                    MyApplication.getInstance().setArrayList(list);
                    if (recyclerViewStaggeredAdapter == null) {
                        recyclerViewStaggeredAdapter = new RecyclerViewStaggeredAdapter(getApplicationContext(), MyApplication.getInstance().getArrayList());
                        recyclerView.setAdapter(recyclerViewStaggeredAdapter);
                    }
                    recyclerViewStaggeredAdapter.notifyDataSetChanged();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            MyApplication.getInstance().addToRequestQueue(jsonArrayRequest);
        }
        if (item.getItemId() == 2) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            list.clear();
//        swipeRefreshLayout.setRefreshing(true);
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    Log.d(TAG, response.toString());

                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            Item item = new Item();
                            item.setTitle(jsonObject.getString("title"));
                            item.setRating(jsonObject.getString("rating"));
                            item.setImageUrl(jsonObject.getString("image"));
                            JSONArray genreArry = jsonObject.getJSONArray("genre");
                            ArrayList<String> genre = new ArrayList<>();
                            for (int j = 0; j < genreArry.length(); j++) {
                                genre.add((String) genreArry.get(j));
                            }
                            item.setGenre(genre);
                            list.add(item);

                        } catch (JSONException e) {

                        }

                    }
                    MyApplication.getInstance().setArrayList(list);

                    recyclerViewListAdapter = new RecyclerViewListAdapter(getApplicationContext(), MyApplication.getInstance().getArrayList());
                    recyclerView.setAdapter(recyclerViewListAdapter);
                    //fastScroller.setRecyclerView(recyclerView);
                    recyclerViewListAdapter.notifyDataSetChanged();
                    // swipeRefreshLayout.setRefreshing(false);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //   swipeRefreshLayout.setRefreshing(false);
                }
            });
            MyApplication.getInstance().addToRequestQueue(jsonArrayRequest);

        }
        if (item.getItemId() == 3) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            list.clear();
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            Item item = new Item();
                            item.setTitle(jsonObject.getString("title"));
                            item.setRating(jsonObject.getString("rating"));
                            item.setImageUrl(jsonObject.getString("image"));
                            JSONArray genreArry = jsonObject.getJSONArray("genre");
                            ArrayList<String> genre = new ArrayList<>();

                            for (int j = 0; j < genreArry.length(); j++) {
                                genre.add((String) genreArry.get(j));
                            }
                            item.setGenre(genre);
                            list.add(item);
                        } catch (JSONException e) {

                        }
                    }
                    MyApplication.getInstance().setArrayList(list);
                    recyclerViewGridAdapter = new RecyclerViewGridAdapter(getApplicationContext(), MyApplication.getInstance().getArrayList());
                    recyclerView.setAdapter(recyclerViewGridAdapter);
                    recyclerViewGridAdapter.notifyDataSetChanged();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            MyApplication.getInstance().addToRequestQueue(jsonArrayRequest);
        }
        return super.onOptionsItemSelected(item);
    }
}
