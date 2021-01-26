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

    private List<AdventureTripModel> modelList;

    public AdventureTripAdapter(List<AdventureTripModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adventure_trip_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(modelList.get(position).getTripImageURL(), modelList.get(position).getTripName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView adventureTripImage;
        private TextView adventureTripName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            adventureTripImage = itemView.findViewById(R.id.iv_adventure_trip_image);
            adventureTripName = itemView.findViewById(R.id.tv_adventure_trip_name);
        }

        private void setData(final String imageURL, final String name) {
            Glide.with(itemView.getContext()).load(imageURL).into(adventureTripImage);
            adventureTripName.setText(name);
        }
    }
}
