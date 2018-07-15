package com.tonghann.sentienttripadvisor.models;

import java.io.Serializable;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class CarRentals implements Serializable {

    private String Capacity;
    private String CarMakeModel;
    private String Price;
    private String SupplierName;
    private String CarClass;
    private String address;
    private String image;

    public CarRentals(String capacity, String carMakeModel, String price, String supplierName, String carClass, String address, String image) {
        Capacity = capacity;
        CarMakeModel = carMakeModel;
        Price = price;
        SupplierName = supplierName;
        CarClass = carClass;
        this.address = address;
        this.image = image;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public String getCarMakeModel() {
        return CarMakeModel;
    }

    public void setCarMakeModel(String carMakeModel) {
        CarMakeModel = carMakeModel;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getCarClass() {
        return CarClass;
    }

    public void setCarClass(String carClass) {
        CarClass = carClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
