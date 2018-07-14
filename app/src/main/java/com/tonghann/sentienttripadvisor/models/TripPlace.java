
package com.tonghann.sentienttripadvisor.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TripPlace {

    @SerializedName("trips")
    @Expose
    private Trips trips;
    @SerializedName("places")
    @Expose
    private List<Place> places = null;

    public Trips getTrips() {
        return trips;
    }

    public void setTrips(Trips trips) {
        this.trips = trips;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

}
