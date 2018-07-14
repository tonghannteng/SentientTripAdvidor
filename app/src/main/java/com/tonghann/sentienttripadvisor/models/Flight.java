
package com.tonghann.sentienttripadvisor.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flight {

    @SerializedName("FlightPriceSummary")
    @Expose
    private FlightPriceSummary flightPriceSummary;
    @SerializedName("Timestamp")
    @Expose
    private String timestamp;
    @SerializedName("FlightItinerarySummary")
    @Expose
    private FlightItinerarySummary flightItinerarySummary;

    public FlightPriceSummary getFlightPriceSummary() {
        return flightPriceSummary;
    }

    public void setFlightPriceSummary(FlightPriceSummary flightPriceSummary) {
        this.flightPriceSummary = flightPriceSummary;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public FlightItinerarySummary getFlightItinerarySummary() {
        return flightItinerarySummary;
    }

    public void setFlightItinerarySummary(FlightItinerarySummary flightItinerarySummary) {
        this.flightItinerarySummary = flightItinerarySummary;
    }

}
