
package com.tonghann.sentienttripadvisor.models;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trips implements Serializable {

    @SerializedName("ThingsToDo")
    @Expose
    private List<ThingsToDo> thingsToDo = null;

    @SerializedName("flights")
    @Expose
    private List<Flight> flights = null;

    @SerializedName("CarRentals")
    @Expose
    private List<CarRentals> carRentals = null;

    @SerializedName("hotels")
    @Expose
    private List<Hotels> hotels = null;

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<ThingsToDo> getThingsToDo() {
        return thingsToDo;
    }

    public void setThingsToDo(List<ThingsToDo> thingsToDo) {
        this.thingsToDo = thingsToDo;
    }

    public List<CarRentals> getCarRentals() {
        return carRentals;
    }

    public void setCarRentals(List<CarRentals> carRentals) {
        this.carRentals = carRentals;
    }

    public List<Hotels> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotels> hotels) {
        this.hotels = hotels;
    }
}
