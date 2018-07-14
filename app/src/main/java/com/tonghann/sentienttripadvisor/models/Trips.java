
package com.tonghann.sentienttripadvisor.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trips {

    @SerializedName("flights")
    @Expose
    private List<Flight> flights = null;
    @SerializedName("car_rentals")
    @Expose
    private List<Object> carRentals = null;
    @SerializedName("hotels")
    @Expose
    private List<Object> hotels = null;

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Object> getCarRentals() {
        return carRentals;
    }

    public void setCarRentals(List<Object> carRentals) {
        this.carRentals = carRentals;
    }

    public List<Object> getHotels() {
        return hotels;
    }

    public void setHotels(List<Object> hotels) {
        this.hotels = hotels;
    }

}
