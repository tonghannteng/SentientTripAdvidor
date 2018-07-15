package com.tonghann.sentienttripadvisor.triplistscreen.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tonghann.sentienttripadvisor.R;
import com.tonghann.sentienttripadvisor.models.Trips;
import com.tonghann.sentienttripadvisor.triplistscreen.adapter.TripListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TripListActivity extends AppCompatActivity {

    private static final String TAG = "TripActivity";
    @Bind(R.id.tripListRecyclerViewId) RecyclerView tripListRecyclerViewId;

    private TripListAdapter tripListAdapter;
    private Trips trips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);
        ButterKnife.bind(this);

        trips = (Trips) getIntent().getSerializableExtra(TAG);
        tripListAdapter = new TripListAdapter(this, trips.getFlights());
        configureLayout();
    }

    private void configureLayout() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        tripListRecyclerViewId.setLayoutManager(layoutManager);
        tripListRecyclerViewId.setAdapter(tripListAdapter);
        tripListRecyclerViewId.setHasFixedSize(true);
    }
}
