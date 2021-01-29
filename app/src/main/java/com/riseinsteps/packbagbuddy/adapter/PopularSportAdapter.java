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
import com.riseinsteps.packbagbuddy.model.TripModel;

import java.util.List;

public class PopularSportAdapter extends RecyclerView.Adapter<PopularSportAdapter.ViewHolder> {

    private List<TripModel> popularSportModelList;

    public PopularSportAdapter(List<TripModel> popularSportModelList) {
        this.popularSportModelList = popularSportModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_sport_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(popularSportModelList.get(position).getImageUrl(), popularSportModelList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return popularSportModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView popularSportImage;
        private TextView sportName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            popularSportImage = itemView.findViewById(R.id.iv_popular_sports_image);
            sportName = itemView.findViewById(R.id.tv_sport_name);

        }

        private void setData(final String imageURL, final String name) {
            Glide.with(itemView.getContext()).load(imageURL).into(popularSportImage);
            sportName.setText(name);

        }
    }
}
