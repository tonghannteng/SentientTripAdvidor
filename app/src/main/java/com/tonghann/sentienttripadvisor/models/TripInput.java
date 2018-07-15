package com.tonghann.sentienttripadvisor.models;

import java.io.Serializable;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class TripInput implements Serializable {

    private String destination_lat;
    private String current_lat;
    private String current_lng;
    private String destination_name;
    private String destination_lng;

    public TripInput(String destination_lat, String current_lat, String current_lng, String destination_name, String destination_lng) {
        this.destination_lat = destination_lat;
        this.current_lat = current_lat;
        this.current_lng = current_lng;
        this.destination_name = destination_name;
        this.destination_lng = destination_lng;
    }

    public String getDestination_lat() {
        return destination_lat;
    }

    public void setDestination_lat(String destination_lat) {
        this.destination_lat = destination_lat;
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

    public String getDestination_name() {
        return destination_name;
    }

    public void setDestination_name(String destination_name) {
        this.destination_name = destination_name;
    }

    public String getDestination_lng() {
        return destination_lng;
    }

    public void setDestination_lng(String destination_lng) {
        this.destination_lng = destination_lng;
    }
}
