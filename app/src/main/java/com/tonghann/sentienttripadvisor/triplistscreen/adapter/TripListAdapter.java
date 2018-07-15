package com.tonghann.sentienttripadvisor.triplistscreen.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tonghann.sentienttripadvisor.R;
import com.tonghann.sentienttripadvisor.models.Flight;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class TripListAdapter extends RecyclerView.Adapter<TripListAdapter.ViewHolder> {

    private List<Flight> flights;
    private WeakReference<Context> context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.placeIconId) ImageView imagePlaceIcon;
        @Bind(R.id.CurrencyCode) TextView CurrencyCode;
        @Bind(R.id.TotalPrice) TextView TotalPrice;
        @Bind(R.id.OutboundDepartureAirportCode) TextView OutboundDepartureAirportCode;
        @Bind(R.id.OutboundDepartureAirlineCode) TextView OutboundDepartureAirlineCode;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public TripListAdapter(Context context, List<Flight> flight) {
        this.context = new WeakReference<Context>(context);
        this.flights = flight;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_list_layout, parent, false);

        return new TripListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Flight trip = flights.get(position);
        holder.CurrencyCode.setText(trip.getFlightPriceSummary().getCurrencyCode()+"");
        holder.TotalPrice.setText(trip.getFlightPriceSummary().getTotalPrice()+"");
        holder.OutboundDepartureAirportCode.setText(trip.getFlightItinerarySummary().getOutboundDepartureAirportCode()+"");
        holder.OutboundDepartureAirlineCode.setText(trip.getFlightItinerarySummary().getInboundDepartureAirportCode()+"");
        Picasso.with(context.get())
                .load("a")
                .resize(80, 108)
                .centerInside()
                .error(R.drawable.baseline_flight)
                .into(holder.imagePlaceIcon);
    }

    @Override
    public int getItemCount() {
        return flights.size();
    }

    public void updateTripList(List<Flight> trips) {
        this.flights = trips;
        notifyDataSetChanged();
    }

}
