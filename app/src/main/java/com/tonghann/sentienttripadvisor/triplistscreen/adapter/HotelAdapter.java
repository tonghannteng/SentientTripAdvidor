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
import com.tonghann.sentienttripadvisor.models.Hotels;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private List<Hotels> hotels;
    private WeakReference<Context> context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.hotelImageId)
        ImageView hotelImageId;
        @Bind(R.id.rating)
        TextView rating;
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.address)
        TextView address;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public HotelAdapter(Context context, List<Hotels> hotels) {
        this.context = new WeakReference<Context>(context);
        this.hotels = hotels;
    }

    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout, parent, false);

        return new HotelAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HotelAdapter.ViewHolder holder, int position) {
        Hotels hotel = hotels.get(position);
        holder.rating.setText(hotel.getRating() + "");
        holder.name.setText(hotel.getName() + "");
        holder.address.setText(hotel.getAddress() + "");
        if (hotel.getImage().isEmpty()) {
            Picasso.with(context.get())
                    .load("aa")
                    .resize(80, 108)
                    .centerInside()
                    .error(R.drawable.baseline_local_car_wash)
                    .into(holder.hotelImageId);
        } else {
            Picasso.with(context.get())
                    .load(hotel.getImage())
                    .resize(80, 108)
                    .centerInside()
                    .error(R.drawable.baseline_local_car_wash)
                    .into(holder.hotelImageId);
        }

    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public void updateTripList(List<Hotels> hotels) {
        this.hotels = hotels;
        notifyDataSetChanged();
    }
}
