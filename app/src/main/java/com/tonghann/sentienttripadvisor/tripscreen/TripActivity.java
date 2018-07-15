package com.tonghann.sentienttripadvisor.tripscreen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tonghann.sentienttripadvisor.Constants;
import com.tonghann.sentienttripadvisor.R;
import com.tonghann.sentienttripadvisor.di.Injector;
import com.tonghann.sentienttripadvisor.models.Place;
import com.tonghann.sentienttripadvisor.models.Trips;
import com.tonghann.sentienttripadvisor.place.BaseActivity;
import com.tonghann.sentienttripadvisor.triplistscreen.activity.CarRentalActivity;
import com.tonghann.sentienttripadvisor.triplistscreen.activity.HotelActivity;
import com.tonghann.sentienttripadvisor.triplistscreen.activity.ThingToDoActivity;
import com.tonghann.sentienttripadvisor.triplistscreen.activity.TripListActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TripActivity extends BaseActivity implements TripDetailContractor.View {

    private static final String TAG = "TripActivity";
    private TripDetailContractor.TripDetailAction tripDetailAction;
    private Trips trips;
    private Place place;

    @Bind(R.id.flightCountId) TextView flightCountId;
    @Bind(R.id.carRentalCountId) TextView carRentalCountId;
    @Bind(R.id.hotelCountId) TextView hotelCountId;
    @Bind(R.id.thingToDoCountId) TextView thingToDoCountId;
    @Bind(R.id.flightRelativeId) RelativeLayout flightRelativeId;
    @Bind(R.id.carRentalLayoutID) RelativeLayout carRentalLayoutID;
    @Bind(R.id.hotelLayoutID) RelativeLayout hotelLayoutID;
    @Bind(R.id.thingToDoLayoutID) RelativeLayout thingToDoLayoutID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        ButterKnife.bind(this);

        place = (Place) getIntent().getSerializableExtra("MainActivity");
        Log.d(TAG, place.getName()+" "+place.getLat()+" "+place.getLng());
        tripDetailAction = new TripDetailPresenter(this, Injector.provideTripService());
        tripDetailAction.onTripDetail(
                place.getLat()+"",
                Constants.current_lat,
                Constants.current_lng,
                place.getName(),
                place.getLng()+"");

        setActionClick();

    }

    private void setActionClick() {
        flightRelativeId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TripListActivity.class);
                intent.putExtra(TAG, trips);
                startActivity(intent);
            }
        });
        carRentalLayoutID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CarRentalActivity.class);
                intent.putExtra(TAG, trips);
                startActivity(intent);
            }
        });
        hotelLayoutID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HotelActivity.class);
                intent.putExtra(TAG, trips);
                startActivity(intent);
            }
        });
        thingToDoLayoutID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThingToDoActivity.class);
                intent.putExtra(TAG, trips);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showTripsDetails(Trips trips) {
        this.trips = trips;
        flightCountId.setText(String.valueOf(trips.getFlights().size()));
        carRentalCountId.setText(String.valueOf(trips.getCarRentals().size()));
        hotelCountId.setText(String.valueOf(trips.getHotels().size()));
        thingToDoCountId.setText(String.valueOf(trips.getThingsToDo().size()));
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, R.string.unsucessful, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        super.showDialog("Loading");
    }

    @Override
    public void hideLoading() {
        super.hideDialog();
    }
}
