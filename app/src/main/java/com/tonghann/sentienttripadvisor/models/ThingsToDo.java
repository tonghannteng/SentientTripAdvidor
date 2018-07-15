package com.tonghann.sentienttripadvisor.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class ThingsToDo implements Serializable {

    private String rating;
    private String title;
    private String image;
    private String duration;
    private String price;
    private String categories;

    public ThingsToDo(String rating, String title, String image, String duration, String price, String categories) {
        this.rating = rating;
        this.title = title;
        this.image = image;
        this.duration = duration;
        this.price = price;
        this.categories = categories;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
