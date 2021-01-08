package com.riseinsteps.packbagbuddy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.AdventureTripModel;

import java.util.List;


public class AllAdventureTripAdapter extends RecyclerView.Adapter<AllAdventureTripAdapter.ViewHolder> {
    private List<AdventureTripModel> modelList;

    public AllAdventureTripAdapter(List<AdventureTripModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_adventure_trip_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(modelList.get(position).getTripImageURL(), modelList.get(position).getTripName(),
                modelList.get(position).getAvailabilityMonth(), modelList.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView adventureImage;
        private TextView tripName, tripAvailabilityMonth;
        private RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            adventureImage = itemView.findViewById(R.id.iv_all_adventure_trip_image);
            tripName = itemView.findViewById(R.id.tv_all_adventure_trip_name);
            tripAvailabilityMonth = itemView.findViewById(R.id.tv_all_adventure_trip_availability_month);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }

        private void setData(final String image, final String name, final String month, final float rating) {
            Glide.with(itemView.getContext()).load(image).into(adventureImage);
            tripName.setText(name);
            tripAvailabilityMonth.setText(month);
            ratingBar.setRating(rating);
        }
    }
}
