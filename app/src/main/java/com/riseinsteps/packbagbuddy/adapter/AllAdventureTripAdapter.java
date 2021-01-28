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
import com.riseinsteps.packbagbuddy.AdventureTripDetailActivity;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.AdventureTripModel;
import com.riseinsteps.packbagbuddy.model.AllAdventureTripModel;

import java.util.List;


public class AllAdventureTripAdapter extends RecyclerView.Adapter<AllAdventureTripAdapter.ViewHolder> {

    private List<AllAdventureTripModel> modelList;

    public AllAdventureTripAdapter(List<AllAdventureTripModel> modelList) {
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
        holder.setData(modelList.get(position).getImage(), modelList.get(position).getTitle(),
                modelList.get(position).getRating(), modelList.get(position).getCost());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(holder.itemView.getContext(), AdventureTripDetailActivity.class);
//
//                intent.putExtra(String.valueOf(ID), modelList.get(position).getId());
//                intent.putExtra(TRIPNAME, modelList.get(position).getTripName());
//                intent.putExtra(TRIPDEFAULTPRICE, modelList.get(position).getTripDefaultPrice());
//                intent.putExtra(TRIPSPECIALPRICE, modelList.get(position).getTripSpecialPrice());
//                intent.putExtra(TRIPIMAGEURL, modelList.get(position).getTripImageURL());
//                intent.putExtra(DESC, modelList.get(position).getDescription());
//                intent.putExtra(DAYS, modelList.get(position).getDays());
//                intent.putExtra(NAMEOFSTATE, modelList.get(position).getNameOfState());
//                intent.putExtra(AVAILABILITYMONTH, modelList.get(position).getAvailabilityMonth());
//                intent.putExtra(RATING, modelList.get(position).getRating());
//                intent.putExtra(TRIPDISCOUNTPERCENTAGE, modelList.get(position).getTripDiscountPercentage());
//
//                holder.itemView.getContext().startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView adventureImage;
        private TextView tripName, costtv;
        private RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            adventureImage = itemView.findViewById(R.id.adventrous_image);
            tripName = itemView.findViewById(R.id.adventrous_title);
            costtv = itemView.findViewById(R.id.adventrous_cost);
            ratingBar = itemView.findViewById(R.id.adventrous_rating);
        }

        private void setData(final String image, final String name, final float rating, final String cost) {
            Glide.with(itemView.getContext()).load(image).into(adventureImage);
            tripName.setText(name);
            costtv.setText(cost);
            ratingBar.setRating(rating);
        }

    }
}
