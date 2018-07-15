package com.tonghann.sentienttripadvisor.triplistscreen.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tonghann.sentienttripadvisor.R;
import com.tonghann.sentienttripadvisor.models.Trips;
import com.tonghann.sentienttripadvisor.triplistscreen.adapter.HotelAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HotelActivity extends AppCompatActivity {

    private static final String TAG = "TripActivity";
    @Bind(R.id.tripListRecyclerViewId)
    RecyclerView tripListRecyclerViewId;

    private HotelAdapter hotelAdapter;
    private Trips trips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        ButterKnife.bind(this);

        trips = (Trips) getIntent().getSerializableExtra(TAG);
        hotelAdapter = new HotelAdapter(this, trips.getHotels());
        configureLayout();
    }

    private void configureLayout() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        tripListRecyclerViewId.setLayoutManager(layoutManager);
        tripListRecyclerViewId.setAdapter(hotelAdapter);
        tripListRecyclerViewId.setHasFixedSize(true);
    }
}
