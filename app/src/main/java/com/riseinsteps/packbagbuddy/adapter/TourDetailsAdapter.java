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
import com.riseinsteps.packbagbuddy.model.TourDetailsModel;

import java.util.List;

public class TourDetailsAdapter extends RecyclerView.Adapter<TourDetailsAdapter.ViewHolder> {

    private List<TourDetailsModel> modelList;

    public TourDetailsAdapter(List<TourDetailsModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tour_details_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(modelList.get(position).getImageUrl(), modelList.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ImageUrl;
        private TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageUrl = itemView.findViewById(R.id.iv_tour_details_image);
            desc = itemView.findViewById(R.id.tv_tour_details_desc);
        }

        private void setData(final String ImageURL, final String desc) {
            Glide.with(itemView.getContext()).load(ImageURL).into(ImageUrl);
            this.desc.setText(desc);
        }
    }
}
