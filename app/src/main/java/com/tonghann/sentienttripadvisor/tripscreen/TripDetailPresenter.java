package com.tonghann.sentienttripadvisor.tripscreen;

import com.tonghann.sentienttripadvisor.data.PlaceService;
import com.tonghann.sentienttripadvisor.models.TripInput;
import com.tonghann.sentienttripadvisor.models.TripPlace;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    public void onTripDetail(String destination_lat, String lat, String lng, String destination_name, String destination_lng) {

        TripInput tripInput = new TripInput(destination_lat, lat, lng, destination_name, destination_lng);

        tripDetailView.showLoading();

        service.getTripDetail(tripInput).enqueue(new Callback<TripPlace>() {
            @Override
            public void onResponse(Call<TripPlace> call, Response<TripPlace> response) {
                if (response.isSuccessful()) {
                    TripPlace tripPlace = response.body();
                    tripDetailView.showTripsDetails(tripPlace.getTrips());
                    tripDetailView.hideLoading();
                }
            }

            @Override
            public void onFailure(Call<TripPlace> call, Throwable t) {
                tripDetailView.showErrorMessage();
                tripDetailView.hideLoading();
            }
        });
    }
}
