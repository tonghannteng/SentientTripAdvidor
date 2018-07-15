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
import com.tonghann.sentienttripadvisor.models.ThingsToDo;

import java.lang.ref.WeakReference;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tonghannteng on 7/14/18.
 */

public class ThingsToDoAdapter extends RecyclerView.Adapter<ThingsToDoAdapter.ViewHolder> {

    private List<ThingsToDo> thingsToDos;
    private WeakReference<Context> context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.thingToDoImageId)
        ImageView thingToDoImageId;
        @Bind(R.id.rating)
        TextView rating;
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.duration)
        TextView duration;
        @Bind(R.id.price)
        TextView price;
        @Bind(R.id.categories)
        TextView categories;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public ThingsToDoAdapter(Context context, List<ThingsToDo> thingsToDos) {
        this.context = new WeakReference<Context>(context);
        this.thingsToDos = thingsToDos;
    }

    @Override
    public ThingsToDoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.thing_to_do_layout, parent, false);

        return new ThingsToDoAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ThingsToDoAdapter.ViewHolder holder, int position) {
        ThingsToDo thingsToDo = thingsToDos.get(position);
        holder.rating.setText(thingsToDo.getRating() + "");
        holder.title.setText(thingsToDo.getTitle() + "");
        holder.duration.setText(thingsToDo.getDuration() + "");
        holder.price.setText(thingsToDo.getPrice() + "");
        holder.categories.setText(thingsToDo.getCategories() + "");
        Picasso.with(context.get())
                .load(thingsToDo.getImage())
                .resize(80, 108)
                .centerInside()
                .error(R.drawable.baseline_thing_do)
                .into(holder.thingToDoImageId);
    }

    @Override
    public int getItemCount() {
        return thingsToDos.size();
    }

    public void updateTripList(List<ThingsToDo> thingsToDos) {
        this.thingsToDos = thingsToDos;
        notifyDataSetChanged();
    }
}