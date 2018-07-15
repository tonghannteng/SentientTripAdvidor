package com.tonghann.sentienttripadvisor.triplistscreen.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tonghann.sentienttripadvisor.R;
import com.tonghann.sentienttripadvisor.models.Trips;
import com.tonghann.sentienttripadvisor.triplistscreen.adapter.ThingsToDoAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ThingToDoActivity extends AppCompatActivity {

    private static final String TAG = "TripActivity";
    @Bind(R.id.tripListRecyclerViewId)
    RecyclerView tripListRecyclerViewId;

    private ThingsToDoAdapter thingsToDoAdapter;
    private Trips trips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thing_to_do);
        ButterKnife.bind(this);

        trips = (Trips) getIntent().getSerializableExtra(TAG);
        thingsToDoAdapter = new ThingsToDoAdapter(this, trips.getThingsToDo());
        configureLayout();
    }

    private void configureLayout() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        tripListRecyclerViewId.setLayoutManager(layoutManager);
        tripListRecyclerViewId.setAdapter(thingsToDoAdapter);
        tripListRecyclerViewId.setHasFixedSize(true);
    }
}
