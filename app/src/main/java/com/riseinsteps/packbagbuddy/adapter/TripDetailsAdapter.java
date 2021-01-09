package com.riseinsteps.packbagbuddy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.AdventureTripModel;

import java.util.List;

public class TripDetailsAdapter extends PagerAdapter {

    private List<AdventureTripModel> modelList;


    public TripDetailsAdapter(List<AdventureTripModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.trip_gallery_banner, container, false);

        ImageView tripPhotos = view.findViewById(R.id.iv_trip_images);
        Glide.with(container.getContext()).load(modelList.get(position).getTripImageURL()).into(tripPhotos);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
