package com.riseinsteps.packbagbuddy.adapter;

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
import com.riseinsteps.packbagbuddy.PopularSportDetailActivity;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.PopularSportModel;
import com.riseinsteps.packbagbuddy.model.TripModel;

import java.util.List;

import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.ID;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.IMAGEURL;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.NUMBEROFTOURS;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.SPORTNAME;

public class PopularSportAdapter extends RecyclerView.Adapter<PopularSportAdapter.ViewHolder> {

    private List<TripModel> popularSportModelList;

    public PopularSportAdapter(List<TripModel> popularSportModelList) {
        this.popularSportModelList = popularSportModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_adventrous_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(popularSportModelList.get(position).getImageUrl(), popularSportModelList.get(position).getName(),
                popularSportModelList.get(position).getCost(), popularSportModelList.get(position).getRating());



    }

    @Override
    public int getItemCount() {
        return popularSportModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView popularSportImage;
        private TextView title;
        private TextView costtv;
        private RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            popularSportImage = itemView.findViewById(R.id.adventrous_image);
            title = itemView.findViewById(R.id.adventrous_title);
            costtv = itemView.findViewById(R.id.adventrous_cost);
            ratingBar = itemView.findViewById(R.id.adventure_trip_rating);
        }

        private void setData(final String imageURL, final String name, final String cost, final float rating ) {
            Glide.with(itemView.getContext()).load(imageURL).into(popularSportImage);
            title.setText(name);
            costtv.setText(cost);
            ratingBar.setRating(rating);
        }
    }
}
