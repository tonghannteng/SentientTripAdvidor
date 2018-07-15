package com.tonghann.sentienttripadvisor.place;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tonghann.sentienttripadvisor.R;
import com.tonghann.sentienttripadvisor.models.Place;
import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private List<Place> places;
    private PlaceItemListener itemListener;
    private MapItemListener mapItemListener;

    private WeakReference<Context> context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.placeIconId) ImageView imagePlaceIcon;
        @Bind(R.id.placeNameId) TextView placeNameId;
        @Bind(R.id.ratingId) TextView ratingId;
        @Bind(R.id.mainClickId) LinearLayout mainClickId;
        @Bind(R.id.mapIconId) ImageView mapIconId;

        PlaceItemListener itemListener;

        public ViewHolder(View v, PlaceItemListener itemListener) {
            super(v);
            ButterKnife.bind(this, v);

            this.itemListener = itemListener;
            v.findViewById(R.id.mainClickId).setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Place place = getTrip(getAdapterPosition());
            this.itemListener.onPlaceClick(place);
        }
    }

    public PlaceAdapter(Context context,
                        List<Place> places,
                        PlaceItemListener itemListener,
                        MapItemListener mapItemListener) {
        this.context = new WeakReference<>(context);
        this.places = places;
        this.itemListener = itemListener;
        this.mapItemListener = mapItemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(v, itemListener);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Place place = places.get(position);
        holder.placeNameId.setText("Places Name: "+place.getName());
        holder.ratingId.setText("Rating: "+String.valueOf(place.getRating()));
        Picasso.with(context.get())
                .load(place.getImage())
                .resize(80, 108)
                .centerInside()
                .into(holder.imagePlaceIcon);

        holder.mapIconId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapItemListener.goToMap(place);
            }
        });

    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public void updatePlaces(List<Place> places) {
        this.places = places;
        notifyDataSetChanged();
    }

    private Place getTrip(int adapterPosition) {
        return places.get(adapterPosition);
    }

    public interface PlaceItemListener {
        void onPlaceClick(Place place);
    }
    public interface MapItemListener {
        void goToMap(Place place);
    }
}
