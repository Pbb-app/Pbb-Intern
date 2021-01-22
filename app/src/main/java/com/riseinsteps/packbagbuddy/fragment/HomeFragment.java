package com.riseinsteps.packbagbuddy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.riseinsteps.packbagbuddy.AdventureTripActivity;
import com.riseinsteps.packbagbuddy.PopularSportActivity;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.adapter.AdventureTripAdapter;
import com.riseinsteps.packbagbuddy.adapter.BannerAdapter;
import com.riseinsteps.packbagbuddy.adapter.PopularSportAdapter;
import com.riseinsteps.packbagbuddy.model.AdventureTripModel;
import com.riseinsteps.packbagbuddy.model.BannerModel;
import com.riseinsteps.packbagbuddy.model.PopularSportModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private ViewPager viewPager;
    private List<BannerModel> bannerModelList;
    private BannerAdapter bannerAdapter;

    private LinearLayout layoutAdventureTrip, layoutPopularSport;

    private List<AdventureTripModel> adventureTripModelList;
    private RecyclerView adventureTripRecyclerView;
    private AdventureTripAdapter adventureTripAdapter;

    private List<PopularSportModel> popularSportModelList;
    private RecyclerView popularSportRecyclerView;
    private PopularSportAdapter popularSportAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }


}
