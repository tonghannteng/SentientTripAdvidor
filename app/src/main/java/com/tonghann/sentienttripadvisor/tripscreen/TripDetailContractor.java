package com.tonghann.sentienttripadvisor.tripscreen;

import com.tonghann.sentienttripadvisor.models.Trips;

/**
 * Created by tonghannteng on 7/14/18.
 */

public interface TripDetailContractor {

    interface View {
        void showTripsDetails(Trips trips);
        void showErrorMessage();
        void showLoading();
        void hideLoading();
    }

    interface TripDetailAction {

        void onTripDetail(String destination_lat, String lat, String lng, String name, String destination_lng);
    }
}
