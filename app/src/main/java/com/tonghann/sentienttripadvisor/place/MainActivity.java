package com.tonghann.sentienttripadvisor.place;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tonghann.sentienttripadvisor.R;
import com.tonghann.sentienttripadvisor.di.Injector;
import com.tonghann.sentienttripadvisor.map.MapsActivity;
import com.tonghann.sentienttripadvisor.models.Place;
import com.tonghann.sentienttripadvisor.models.Trips;
import com.tonghann.sentienttripadvisor.triplistscreen.activity.CarRentalActivity;
import com.tonghann.sentienttripadvisor.triplistscreen.activity.HotelActivity;
import com.tonghann.sentienttripadvisor.triplistscreen.activity.ThingToDoActivity;
import com.tonghann.sentienttripadvisor.triplistscreen.activity.TripListActivity;
import com.tonghann.sentienttripadvisor.tripscreen.TripActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, PlaceContractor.View {

    private static final String TAG = "MainActivity";
    private static final String TAG1 = "TripActivity";

    private PlaceAdapter placeAdapter;
    private PlaceContractor.UserAction userAction;

    @Bind(R.id.mainRecyclerViewId) RecyclerView mainRecyclerViewId;
    @Bind(R.id.emptyTextId) EditText emptyTextId;
    @Bind(R.id.txtEmptyID) TextView txtEmptyID;
    @Bind(R.id.flightCountId) TextView flightCountId;
    @Bind(R.id.carRentalCountId) TextView carRentalCountId;
    @Bind(R.id.hotelCountId) TextView hotelCountId;
    @Bind(R.id.tripLayoutId) LinearLayout tripLayoutId;
    @Bind(R.id.placeLayoutId) RelativeLayout placeLayoutId;
    @Bind(R.id.thingToDoCountId) TextView thingToDoCountId;
    @Bind(R.id.flightRelativeId) RelativeLayout flightRelativeId;
    @Bind(R.id.carRentalLayoutID) RelativeLayout carRentalLayoutID;
    @Bind(R.id.hotelLayoutID) RelativeLayout hotelLayoutID;
    @Bind(R.id.thingToDoLayoutID) RelativeLayout thingToDoLayoutID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userAction.onSearchPressed(emptyTextId.getText().toString());
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        userAction = new PlacePresenter(this, Injector.provideTripService());
        placeAdapter = new PlaceAdapter(this, new ArrayList<Place>(0), itemListener, mapItemListener);

        configureLayout();
    }

    @Override
    public void showPlaces(List<Place> places) {
        if (places.size() != 0) {
            tripLayoutId.setVisibility(View.GONE);
            placeLayoutId.setVisibility(View.VISIBLE);
            txtEmptyID.setVisibility(View.GONE);
            placeAdapter.updatePlaces(places);
        }

    }

    @Override
    public void showTrips(final Trips trips) {
        tripLayoutId.setVisibility(View.VISIBLE);
        placeLayoutId.setVisibility(View.GONE);
        txtEmptyID.setVisibility(View.GONE);
        flightCountId.setText(String.valueOf(trips.getFlights().size()));
        carRentalCountId.setText(String.valueOf(trips.getCarRentals().size()));
        hotelCountId.setText(String.valueOf(trips.getHotels().size()));
        thingToDoCountId.setText(String.valueOf(trips.getThingsToDo().size()));

        flightRelativeId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TripListActivity.class);
                intent.putExtra(TAG1, trips);
                startActivity(intent);
            }
        });
        carRentalLayoutID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CarRentalActivity.class);
                intent.putExtra(TAG1, trips);
                startActivity(intent);
            }
        });
        hotelLayoutID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HotelActivity.class);
                intent.putExtra(TAG1, trips);
                startActivity(intent);
            }
        });
        thingToDoLayoutID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThingToDoActivity.class);
                intent.putExtra(TAG1, trips);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText( this, R.string.unsucessful, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        super.showDialog("Loading");
    }

    @Override
    public void hideLoading() {
        super.hideDialog();
    }

    private void configureLayout() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainRecyclerViewId.setLayoutManager(layoutManager);
        mainRecyclerViewId.setAdapter(placeAdapter);
        mainRecyclerViewId.setHasFixedSize(true);
    }

    private PlaceAdapter.PlaceItemListener itemListener = new PlaceAdapter.PlaceItemListener() {

        @Override
        public void onPlaceClick(Place place) {
            Intent intent = new Intent(getApplicationContext(), TripActivity.class);
            intent.putExtra(TAG, place);
            startActivity(intent);
        }


    };

    private PlaceAdapter.MapItemListener mapItemListener = new PlaceAdapter.MapItemListener() {
        @Override
        public void goToMap(Place place) {
            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            intent.putExtra(TAG, place);
            startActivity(intent);
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
