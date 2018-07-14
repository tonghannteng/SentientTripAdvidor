package com.tonghann.sentienttripadvisor.place;


import com.tonghann.sentienttripadvisor.models.Place;
import com.tonghann.sentienttripadvisor.models.Trips;

import java.util.List;

/**
 * Created by tonghannteng on 7/14/18.
 */

public interface PlaceContractor {

    interface View {
        void showPlaces(List<Place> tripPlace);
        void showTrips(Trips trips);
        void showErrorMessage();
        void showLoading();
        void hideLoading();
    }

    interface UserAction {

        void onSearchPressed(String s);
    }

}
