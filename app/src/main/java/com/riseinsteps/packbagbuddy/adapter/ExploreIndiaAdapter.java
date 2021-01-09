package com.riseinsteps.packbagbuddy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.ExploreIndia;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExploreIndiaAdapter extends RecyclerView.Adapter<ExploreIndiaAdapter.ViewHolder>
{
    private List<ExploreIndia> modelList;

    public ExploreIndiaAdapter(List<ExploreIndia> modelList)
    {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_explore, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.setData(modelList.get(position).getImage_id(), modelList.get(position).getTitle(),modelList.get(position)
                .getDays(),modelList.get(position).getTripDefaultPrice(),modelList.get(position).getTripSpecialPrice(), modelList.get(position).getAvailabilityMonth());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView location;
        private TextView title;
        private  TextView days;
        private TextView tripDefaultPrice;
        private TextView tripSpecialPrice;
        private TextView availabilityMonth;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            location =itemView.findViewById(R.id.exploreIndiaImage);
            title = itemView.findViewById(R.id.titleExp);
            days=itemView.findViewById(R.id.timetext);
            tripDefaultPrice= itemView.findViewById(R.id.cost);
            tripSpecialPrice= itemView.findViewById(R.id.actualcost);
            availabilityMonth=itemView.findViewById(R.id.calendertime);
        }


        public void setData(String image_id, String titles, String day, int tripDefaultPrices, int tripSpecialPrices, String availabilityMonths)
        {
            Glide.with(itemView.getContext()).load(image_id).into(location);
            title.setText(titles);
            days.setText(day);
            tripDefaultPrice.setText(Integer.toString(tripDefaultPrices));
            tripSpecialPrice.setText(Integer.toString(tripSpecialPrices));
            availabilityMonth.setText(availabilityMonths);

        }
    }
}
