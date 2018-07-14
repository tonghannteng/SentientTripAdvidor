package com.tonghann.sentienttripadvisor.data;

import com.tonghann.sentienttripadvisor.models.Input;
import com.tonghann.sentienttripadvisor.models.TripPlace;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by tonghannteng on 7/13/18.
 */

public interface PlaceService {

    @Headers("Content-Type: application/json")
    @POST("place")
    Call<TripPlace> getTripPlace(@Body Input input);

    @Headers("Content-Type: application/json")
    @POST("trips")
    Call<TripPlace> getTripDetail(@Body Input input);

}
