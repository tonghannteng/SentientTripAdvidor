package com.tonghann.sentienttripadvisor.place;

import com.tonghann.sentienttripadvisor.Constants;
import com.tonghann.sentienttripadvisor.data.PlaceService;
import com.tonghann.sentienttripadvisor.models.Input;
import com.tonghann.sentienttripadvisor.models.TripPlace;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class PlacePresenter implements PlaceContractor.UserAction {

    private final PlaceContractor.View placeView;
    private final PlaceService service;

    public PlacePresenter(PlaceContractor.View placeView, PlaceService service) {
        this.placeView = placeView;
        this.service = service;
    }

    public void onSearchPressed(String input) {
        Input inputCon = new Input(input, Constants.current_lat, Constants.current_lng);

        placeView.showLoading();

        service.getTripPlace(inputCon).enqueue(new Callback<TripPlace>() {
            @Override
            public void onResponse(Call<TripPlace> call, Response<TripPlace> response) {
                if (response.isSuccessful()) {
                    TripPlace tripPlace = response.body();
                    if (tripPlace.getPlaces().size() != 0) {
                        placeView.showPlaces(tripPlace.getPlaces());
                    } else {
                        placeView.showTrips(tripPlace.getTrips());
                    }
                    placeView.hideLoading();
                }
            }

            @Override
            public void onFailure(Call<TripPlace> call, Throwable t) {
                placeView.showErrorMessage();
                placeView.hideLoading();
            }
        });

    }
}
