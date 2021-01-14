package com.riseinsteps.packbagbuddy.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.riseinsteps.packbagbuddy.AdventureTripDetailActivity;
import com.riseinsteps.packbagbuddy.PopularSportDetailActivity;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.PopularSportModel;

import java.util.List;

import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.AVAILABILITYMONTH;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.DAYS;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.DESC;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.ID;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.IMAGEURL;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.NAMEOFSTATE;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.NUMBEROFTOURS;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.RATING;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.SPORTNAME;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPDEFAULTPRICE;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPDISCOUNTPERCENTAGE;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPIMAGEURL;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPNAME;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPSPECIALPRICE;

public class PopularSportAdapter extends RecyclerView.Adapter<PopularSportAdapter.ViewHolder> {

    private List<PopularSportModel> popularSportModelList;

    public PopularSportAdapter(List<PopularSportModel> popularSportModelList) {
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
        holder.setData(popularSportModelList.get(position).getImageURL(), popularSportModelList.get(position).getSportName(),
                popularSportModelList.get(position).getNumberOfTours());





        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), PopularSportDetailActivity.class);

                intent.putExtra(String.valueOf(ID), popularSportModelList.get(position).getId());
                intent.putExtra(IMAGEURL, popularSportModelList.get(position).getImageURL());
                intent.putExtra(SPORTNAME, popularSportModelList.get(position).getSportName());
                intent.putExtra(NUMBEROFTOURS, popularSportModelList.get(position).getNumberOfTours());

                holder.itemView.getContext().startActivity(intent);
            }
        });








    }

    @Override
    public int getItemCount() {
        return popularSportModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView popularSportImage;
        private TextView sportName;
        private TextView numOfTours;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            popularSportImage = itemView.findViewById(R.id.iv_popular_sports_image);
            sportName = itemView.findViewById(R.id.tv_sport_name);
            numOfTours = itemView.findViewById(R.id.tv_numOfTours);
        }

        private void setData(final String imageURL, final String name, final int tours) {
            Glide.with(itemView.getContext()).load(imageURL).into(popularSportImage);
            sportName.setText(name);
            numOfTours.setText(tours + " Tours");
        }
    }
}
