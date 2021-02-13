package com.riseinsteps.packbagbuddy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.riseinsteps.packbagbuddy.AdventureTripDetailActivity;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.TripModel;

import java.util.List;


public class AllAdventureTripAdapter extends RecyclerView.Adapter<AllAdventureTripAdapter.ViewHolder> {
    public static final int ID = 0;
    public static final String TRIPNAME = "com.riseinsteps.packbagbuddy.TRIPNAME";
    public static final String DESC = "com.riseinsteps.packbagbuddy.DESC";
    public static final String DAYS = "com.riseinsteps.packbagbuddy.DAYS";
    public static final String TRIPDEFAULTPRICE = "com.riseinsteps.packbagbuddy.TRIPDEFAULTPRICE";
    public static final String TRIPSPECIALPRICE = "com.riseinsteps.packbagbuddy.TRIPSPECIALPRICE";
    public static final String TRIPIMAGEURL = "com.riseinsteps.packbagbuddy.TRIPIMAGEURL";
    public static final String NAMEOFSTATE = "com.riseinsteps.packbagbuddy.NAMEOFSTATE";
    public static final String AVAILABILITYMONTH = "com.riseinsteps.packbagbuddy.AVAILABILITYMONTH";
    public static final String RATING = "com.riseinsteps.packbagbuddy.RATING";
    public static final String TRIPDISCOUNTPERCENTAGE = "com.riseinsteps.packbagbuddy.TRIPDISCOUNTPERCENTAGE";

    public static final String IMAGEURL = "com.riseinsteps.packbagbuddy.IMAGEURL";
    public static final String SPORTNAME = "com.riseinsteps.packbagbuddy.SPORTNAME";
    public static final String NUMBEROFTOURS = "com.riseinsteps.packbagbuddy.NUMBEROFTOURS";

    private List<TripModel> modelList;

    public AllAdventureTripAdapter(List<TripModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_adventrous_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(modelList.get(position).getImageUrl(), modelList.get(position).getName(),
                modelList.get(position).getCost(), modelList.get(position).getRating());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),AdventureTripDetailActivity.class);
                i.putExtra("name",modelList.get(position).getName());
                v.getContext().startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView adventureImage;
        private TextView tripName,costtv;
        private RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            adventureImage = itemView.findViewById(R.id.adventrous_image);
            tripName = itemView.findViewById(R.id.adventrous_title);
            costtv = itemView.findViewById(R.id.adventrous_cost);
            ratingBar = itemView.findViewById(R.id.adventure_trip_rating);
        }

        private void setData(final String image, final String name, final String cost, final float rating) {
            Glide.with(itemView.getContext()).load(image).into(adventureImage);
            tripName.setText(name);
            costtv.setText("Rs - "+cost);
            ratingBar.setRating(rating);
        }

    }
}
