package com.admin.volleydemo.model;

import java.util.ArrayList;

/**
 * Created by admin on 01-02-2017.
 */

public class Item {
    String title, imageUrl;
   String rating;
    ArrayList<String> genre;

    public Item() {

    }

    public Item(String title, String imageUrl, String rating, ArrayList<String> genre) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }
}
