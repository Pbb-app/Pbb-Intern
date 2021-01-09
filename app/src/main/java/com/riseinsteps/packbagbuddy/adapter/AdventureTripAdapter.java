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
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.AdventureTripModel;

import java.util.List;

import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.AVAILABILITYMONTH;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.DAYS;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.DESC;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.ID;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.NAMEOFSTATE;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.RATING;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPDEFAULTPRICE;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPDISCOUNTPERCENTAGE;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPIMAGEURL;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPNAME;
import static com.riseinsteps.packbagbuddy.adapter.AllAdventureTripAdapter.TRIPSPECIALPRICE;

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
        holder.setData(modelList.get(position).getTripImageURL(), modelList.get(position).getTripName(), modelList.get(position)
                .getTripDiscountPercentage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), AdventureTripDetailActivity.class);

                intent.putExtra(String.valueOf(ID), modelList.get(position).getId());
                intent.putExtra(TRIPNAME, modelList.get(position).getTripName());
                intent.putExtra(TRIPDEFAULTPRICE, modelList.get(position).getTripDefaultPrice());
                intent.putExtra(TRIPSPECIALPRICE, modelList.get(position).getTripSpecialPrice());
                intent.putExtra(TRIPIMAGEURL, modelList.get(position).getTripImageURL());
                intent.putExtra(DESC, modelList.get(position).getDescription());
                intent.putExtra(DAYS, modelList.get(position).getDays());
                intent.putExtra(NAMEOFSTATE, modelList.get(position).getNameOfState());
                intent.putExtra(AVAILABILITYMONTH, modelList.get(position).getAvailabilityMonth());
                intent.putExtra(RATING, modelList.get(position).getRating());
                intent.putExtra(TRIPDISCOUNTPERCENTAGE, modelList.get(position).getTripDiscountPercentage());

                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView adventureTripImage;
        private TextView specialDiscount;
        private TextView tripName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            adventureTripImage = itemView.findViewById(R.id.iv_adventure_trip_image);
            specialDiscount = itemView.findViewById(R.id.tv_adventure_trip_discount);
            tripName = itemView.findViewById(R.id.tv_rip_detail_name);
        }

        private void setData(final String imageURL, final String name, final int Discount) {
            Glide.with(itemView.getContext()).load(imageURL).into(adventureTripImage);
            tripName.setText(name);
            specialDiscount.setText("Flat Rs." + Discount + " OFF");
        }
    }
}
