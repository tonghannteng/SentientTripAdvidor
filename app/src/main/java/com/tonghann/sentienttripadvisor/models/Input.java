package com.tonghann.sentienttripadvisor.models;

import java.io.Serializable;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class Input implements Serializable {

    private String input;
    private String current_lat;
    private String current_lng;

    public Input(String input, String current_lat, String current_lng) {
        this.input = input;
        this.current_lat = current_lat;
        this.current_lng = current_lng;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getCurrent_lat() {
        return current_lat;
    }

    public void setCurrent_lat(String current_lat) {
        this.current_lat = current_lat;
    }

    public String getCurrent_lng() {
        return current_lng;
    }

    public void setCurrent_lng(String current_lng) {
        this.current_lng = current_lng;
    }
}
