package com.tonghann.sentienttripadvisor.tripscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tonghann.sentienttripadvisor.R;
import com.tonghann.sentienttripadvisor.models.Trips;
import com.tonghann.sentienttripadvisor.place.BaseActivity;

public class TripActivity extends BaseActivity implements TripDetailContractor.View {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);



    }

    @Override
    public void showTripsDetails(Trips trips) {

    }

    @Override
    public void showErrorMessage() {
        Toast.makeText( this, R.string.unsucessful, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
