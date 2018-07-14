package com.tonghann.sentienttripadvisor.models;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class TripInput {

    private String input;
    private String current_lat;
    private String current_lng;
    private String destination_name;

    public TripInput(String input, String current_lat, String current_lng, String destination_name) {
        this.input = input;
        this.current_lat = current_lat;
        this.current_lng = current_lng;
        this.destination_name = destination_name;
    }
}
