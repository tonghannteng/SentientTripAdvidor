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
import com.tonghann.sentienttripadvisor.models.CarRentals;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class CarRentalListAdapter extends RecyclerView.Adapter<CarRentalListAdapter.ViewHolder> {

    private List<CarRentals> carRentals;
    private WeakReference<Context> context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.carRentalId) ImageView carRentalId;
        @Bind(R.id.Capacity) TextView Capacity;
        @Bind(R.id.CarMakeModel) TextView CarMakeModel;
        @Bind(R.id.Price) TextView Price;
        @Bind(R.id.SupplierName) TextView SupplierName;
        @Bind(R.id.CarClass) TextView CarClass;
        @Bind(R.id.address) TextView address;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public CarRentalListAdapter(Context context, List<CarRentals> carRentals) {
        this.context = new WeakReference<Context>(context);
        this.carRentals = carRentals;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_rental_layout, parent, false);

        return new CarRentalListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CarRentals carRental = carRentals.get(position);
        holder.Capacity.setText(carRental.getCapacity()+"");
        holder.CarMakeModel.setText(carRental.getCarMakeModel()+"");
        holder.Price.setText(carRental.getPrice()+"");
        holder.SupplierName.setText(carRental.getSupplierName()+"");
        holder.CarClass.setText(carRental.getCarClass()+"");
        holder.address.setText(carRental.getAddress()+"");
        Picasso.with(context.get())
                .load(carRental.getImage())
                .resize(80, 108)
                .centerInside()
                .error(R.drawable.baseline_local_car_wash)
                .into(holder.carRentalId);
    }

    @Override
    public int getItemCount() {
        return carRentals.size();
    }

    public void updateTripList(List<CarRentals> carRentals) {
        this.carRentals = carRentals;
        notifyDataSetChanged();
    }

}
