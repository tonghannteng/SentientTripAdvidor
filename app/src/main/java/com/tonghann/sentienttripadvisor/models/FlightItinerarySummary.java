
package com.tonghann.sentienttripadvisor.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlightItinerarySummary {

    @SerializedName("OutboundStopCount")
    @Expose
    private Integer outboundStopCount;
    @SerializedName("OutboundDepartureTime")
    @Expose
    private String outboundDepartureTime;
    @SerializedName("InboundStopCount")
    @Expose
    private Integer inboundStopCount;
    @SerializedName("OutboundDepartureAirlineCode")
    @Expose
    private String outboundDepartureAirlineCode;
    @SerializedName("OutboundDepartureAirportCode")
    @Expose
    private String outboundDepartureAirportCode;
    @SerializedName("InboundDepartureAirportCode")
    @Expose
    private String inboundDepartureAirportCode;
    @SerializedName("InboundDepartureTime")
    @Expose
    private String inboundDepartureTime;
    @SerializedName("InboundDepartureAirlineCode")
    @Expose
    private String inboundDepartureAirlineCode;

    public Integer getOutboundStopCount() {
        return outboundStopCount;
    }

    public void setOutboundStopCount(Integer outboundStopCount) {
        this.outboundStopCount = outboundStopCount;
    }

    public String getOutboundDepartureTime() {
        return outboundDepartureTime;
    }

    public void setOutboundDepartureTime(String outboundDepartureTime) {
        this.outboundDepartureTime = outboundDepartureTime;
    }

    public Integer getInboundStopCount() {
        return inboundStopCount;
    }

    public void setInboundStopCount(Integer inboundStopCount) {
        this.inboundStopCount = inboundStopCount;
    }

    public String getOutboundDepartureAirlineCode() {
        return outboundDepartureAirlineCode;
    }

    public void setOutboundDepartureAirlineCode(String outboundDepartureAirlineCode) {
        this.outboundDepartureAirlineCode = outboundDepartureAirlineCode;
    }

    public String getOutboundDepartureAirportCode() {
        return outboundDepartureAirportCode;
    }

    public void setOutboundDepartureAirportCode(String outboundDepartureAirportCode) {
        this.outboundDepartureAirportCode = outboundDepartureAirportCode;
    }

    public String getInboundDepartureAirportCode() {
        return inboundDepartureAirportCode;
    }

    public void setInboundDepartureAirportCode(String inboundDepartureAirportCode) {
        this.inboundDepartureAirportCode = inboundDepartureAirportCode;
    }

    public String getInboundDepartureTime() {
        return inboundDepartureTime;
    }

    public void setInboundDepartureTime(String inboundDepartureTime) {
        this.inboundDepartureTime = inboundDepartureTime;
    }

    public String getInboundDepartureAirlineCode() {
        return inboundDepartureAirlineCode;
    }

    public void setInboundDepartureAirlineCode(String inboundDepartureAirlineCode) {
        this.inboundDepartureAirlineCode = inboundDepartureAirlineCode;
    }

}
