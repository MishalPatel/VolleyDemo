package com.admin.volleydemo.applicationcontroller;

import android.app.Application;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.admin.volleydemo.model.Item;
import com.admin.volleydemo.util.LruBitmapCache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();

    private Item itemSelected;

    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    RecyclerView recyclerView;
    ArrayList<Item> arrayList = new ArrayList<>();
    private static MyApplication Instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Instance = this;
    }

    public static synchronized MyApplication getInstance() {
        return Instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return requestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (imageLoader == null) {
            imageLoader = new ImageLoader(this.requestQueue,
                    new LruBitmapCache());
        }
        return this.imageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }

    public Item getItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(Item itemSelected) {
        this.itemSelected = itemSelected;
    }

    public ArrayList<Item> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Item> arrayList)
    {
        this.arrayList = arrayList;
    }

}