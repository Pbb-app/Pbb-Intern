package com.riseinsteps.packbagbuddy.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;

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
        ExploreIndia ob = modelList.get(position);
        String video_url = modelList.get(position).getVideourl();
        holder.videourl.setVideoURI(Uri.parse(video_url));
        holder.title.setText(ob.getTitle());
        holder.description.setText(String.valueOf(ob.getDescription()));
        holder.ratings.setRating(modelList.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private VideoView videourl;
        private TextView title;
        private  TextView description;
        private RatingBar ratings;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            videourl =itemView.findViewById(R.id.exploreVideoView);
            title = itemView.findViewById(R.id.titleExp);
            description=itemView.findViewById(R.id.content);
            ratings=itemView.findViewById(R.id.ratingbarExplore);
        }

    }
}
