package com.tonghann.sentienttripadvisor.tripscreen;

import com.tonghann.sentienttripadvisor.data.PlaceService;
import com.tonghann.sentienttripadvisor.models.Input;
import com.tonghann.sentienttripadvisor.models.TripInput;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class TripDetailPresenter implements TripDetailContractor.TripDetailAction {

    private final TripDetailContractor.View tripDetailView;
    private final PlaceService service;

    public TripDetailPresenter(TripDetailContractor.View tripDetailView, PlaceService service) {
        this.tripDetailView = tripDetailView;
        this.service = service;
    }

    @Override
    public void onTripDetail(String lat, String lng, String name) {

        TripInput tripInput = new TripInput()
    }
}
