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

import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.PopularSportModel;

import java.util.List;

public class PopularSportAdapter extends RecyclerView.Adapter<PopularSportAdapter.ViewHolder> {

    private List<PopularSportModel> popularSportModelList;

    public PopularSportAdapter(List<PopularSportModel> popularSportModelList) {
        this.popularSportModelList = popularSportModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adventour_popular_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(popularSportModelList.get(position).getImage(), popularSportModelList.get(position).getTitle(),
                popularSportModelList.get(position).getRating(),popularSportModelList.get(position).getCost());


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(holder.itemView.getContext(), PopularSportDetailActivity.class);
//
//                intent.putExtra(String.valueOf(ID), popularSportModelList.get(position).getId());
//                intent.putExtra(IMAGEURL, popularSportModelList.get(position).getImageURL());
//                intent.putExtra(SPORTNAME, popularSportModelList.get(position).getSportName());
//                intent.putExtra(NUMBEROFTOURS, popularSportModelList.get(position).getNumberOfTours());
//
//                holder.itemView.getContext().startActivity(intent);
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return popularSportModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView popularSportImage;
        private TextView sportName;
        private TextView costtv;
        private RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            popularSportImage = itemView.findViewById(R.id.adventrous_image);
            sportName = itemView.findViewById(R.id.adventrous_title);
            costtv = itemView.findViewById(R.id.adventrous_cost);
            ratingBar = itemView.findViewById(R.id.adventrous_rating);

        }

        private void setData(final String imageURL, final String title, final float rating, final String cost) {
            Glide.with(itemView.getContext()).load(imageURL).into(popularSportImage);
            sportName.setText(title);
            ratingBar.setRating(rating);
            costtv.setText(cost);
        }
    }
}
