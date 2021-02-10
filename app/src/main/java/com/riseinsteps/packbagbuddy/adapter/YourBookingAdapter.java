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

import com.riseinsteps.packbagbuddy.model.YourBookingModel;

import java.util.List;

public class YourBookingAdapter extends RecyclerView.Adapter<YourBookingAdapter.YourBookingViewHolder> {

    private List<YourBookingModel> modelList;
    public YourBookingAdapter(List<YourBookingModel> modelList,RecyclerviewClickListener listener)
    {
        this.modelList = modelList;
        this.listener=listener;
    }
    private RecyclerviewClickListener listener;


    @NonNull
    @Override
    public YourBookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.yourbookingviewholder, parent, false);
        return new YourBookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YourBookingViewHolder holder, int position) {
        holder.setData(modelList.get(position).getLocation(),
                modelList.get(position).getTitle(),
                modelList.get(position).getDuration(),
                modelList.get(position).getCost(),
                modelList.get(position).getSubstitle(),
                modelList.get(position).getDate()
        );

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public interface RecyclerviewClickListener {
        void onClick(View v,int position);
    }

    public class YourBookingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView locationtv ;
        private TextView titletv;
        private TextView durationtv;
        private TextView amounttv;
        private TextView subtitletv;
        private TextView datetv;

        public YourBookingViewHolder(@NonNull View itemView) {
            super(itemView);
            locationtv = itemView.findViewById(R.id.location);
            titletv = itemView.findViewById(R.id.title);
            durationtv = itemView.findViewById(R.id.duration);
            amounttv = itemView.findViewById(R.id.amount);
            subtitletv = itemView.findViewById(R.id.subtitle);
            datetv = itemView.findViewById(R.id.date);

            itemView.setOnClickListener(this);
        }

            private void setData( String location,  String title, final String duration,  String cost, final String subtitle, final String date) {
                Glide.with(itemView.getContext()).load(location).into(locationtv);
                titletv.setText(title);
                durationtv.setText(duration);
                amounttv.setText(cost);
                subtitletv.setText(subtitle);
                datetv.setText(date);


        }

        @Override
        public void onClick(View v) {
            listener.onClick(itemView,getAdapterPosition());

        }
    }
}
