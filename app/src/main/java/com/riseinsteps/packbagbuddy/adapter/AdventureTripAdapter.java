package com.riseinsteps.packbagbuddy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.AdventureTripModel;

import java.util.List;

public class AdventureTripAdapter extends RecyclerView.Adapter<AdventureTripAdapter.ViewHolder> {

    private List<AdventureTripModel> tripModelList;

    public AdventureTripAdapter(List<AdventureTripModel> tripModelList) {
        this.tripModelList = tripModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adventure_trip_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(tripModelList.get(position).getTripImageURL(), tripModelList.get(position).getTripName(), tripModelList.get(position)
                .getTripDiscountPercentage());
    }

    @Override
    public int getItemCount() {
        return tripModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView adventureTripImage;
        private TextView specialDiscount;
        private TextView tripName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            adventureTripImage = itemView.findViewById(R.id.iv_adventure_trip_image);
            specialDiscount = itemView.findViewById(R.id.tv_adventure_trip_discount);
            tripName = itemView.findViewById(R.id.tv_adventure_trip_name);
        }

        private void setData(final String imageURL, final String name, final int Discount) {
            Glide.with(itemView.getContext()).load(imageURL).into(adventureTripImage);
            tripName.setText(name);
            specialDiscount.setText("Flat Rs." + Discount + " OFF");
        }
    }
}
