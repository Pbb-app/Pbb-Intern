package com.riseinsteps.packbagbuddy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        final ExploreIndia ob = modelList.get(position);
        holder.location.setImageResource(ob.getImage_id());
        holder.title.setText(ob.getTitle());
        holder.days.setText(ob.getDays());
        holder.availabilityMonth.setText(ob.getAvailabilityMonth());
        holder.tripDefaultPrice.setText(ob.getTripDefaultPrice());
        holder.tripSpecialPrice.setText(ob.getTripSpecialPrice());

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


    }
}
