package com.riseinsteps.packbagbuddy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.BannerModel;

import java.util.List;

public class BannerAdapter extends PagerAdapter {

    private List<BannerModel> bannerModelList;

    public BannerAdapter(List<BannerModel> bannerModelList) {
        this.bannerModelList = bannerModelList;
    }

    @Override
    public int getCount() {
        return bannerModelList.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.banner_row, container, false);

        ImageView bannerImage = view.findViewById(R.id.iv_banner_image);
        Glide.with(container.getContext()).load(bannerModelList.get(position).getBannerImageUrl()).into(bannerImage);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
