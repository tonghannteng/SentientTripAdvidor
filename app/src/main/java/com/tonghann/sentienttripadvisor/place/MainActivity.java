package com.tonghann.sentienttripadvisor.place;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.tonghann.sentienttripadvisor.models.Place;
import com.tonghann.sentienttripadvisor.models.Trips;
import com.tonghann.sentienttripadvisor.tripscreen.TripActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, PlaceContractor.View {

    private static final String TAG = "MainActivity";

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
        placeAdapter = new PlaceAdapter(this, new ArrayList<Place>(0), itemListener);

        configureLayout();
    }

    @Override
    public void showPlaces(List<Place> places) {
        if (places != null) {
            tripLayoutId.setVisibility(View.GONE);
            placeLayoutId.setVisibility(View.VISIBLE);
            txtEmptyID.setVisibility(View.GONE);
            placeAdapter.updatePlaces(places);
        }

    }

    @Override
    public void showTrips(Trips trips) {
        flightCountId.setText(String.valueOf(trips.getFlights().size()));
        carRentalCountId.setText(String.valueOf(trips.getCarRentals().size()));
        hotelCountId.setText(String.valueOf(trips.getHotels().size()));
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
        public void onPlaceClick(String placeName) {
            Intent intent = new Intent(getApplicationContext(), TripActivity.class);
            intent.putExtra(TAG, placeName);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

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
