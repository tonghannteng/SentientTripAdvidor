
package com.tonghann.sentienttripadvisor.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FlightPriceSummary implements Serializable {

    @SerializedName("CurrencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("TotalPrice")
    @Expose
    private Double totalPrice;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
