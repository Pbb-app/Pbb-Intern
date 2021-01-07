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

import com.google.android.material.tabs.TabLayout;
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
    private TabLayout tablayout;

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

        setAdventureTripRecyclerView(view);
        setPopularSportRecyclerView(view);
        setBannerViewPager(view);


        layoutAdventureTrip = view.findViewById(R.id.ll_adventure_trip);
        layoutAdventureTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AdventureTripActivity.class);
                view.getContext().startActivity(intent);
            }
        });


        layoutPopularSport = view.findViewById(R.id.ll_adventure_trip);
        layoutPopularSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PopularSportActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        return view;
    }

    private void setBannerViewPager(View view) {
        tablayout = view.findViewById(R.id.tab_indicator);
        bannerModelList = new ArrayList<>();
        bannerModelList.add(new BannerModel(1,
                "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg"));
        bannerModelList.add(new BannerModel(2,
                "https://www.packbagbuddy.com/wp-content/uploads/2019/09/16-1.jpg"));
        bannerModelList.add(new BannerModel(3,
                "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-1-700x450.jpg"));
        bannerModelList.add(new BannerModel(4,
                "https://www.packbagbuddy.com/wp-content/uploads/2019/06/hamta-700x450.jpg"));
        bannerModelList.add(new BannerModel(5,
                "https://www.packbagbuddy.com/wp-content/uploads/2019/09/19-700x450.jpg"));

        viewPager = view.findViewById(R.id.vp_home_page_banner);
        bannerAdapter = new BannerAdapter(bannerModelList);
        viewPager.setAdapter(bannerAdapter);
        tablayout.setupWithViewPager(viewPager);


    }

    private void setAdventureTripRecyclerView(View view) {
        adventureTripModelList = new ArrayList<>();
        adventureTripModelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000));
        adventureTripModelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000));
        adventureTripModelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000));
        adventureTripModelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000));
        adventureTripModelList.add(new AdventureTripModel(1, "KedarNath Tour", "fsdhfsdhsdg", "8"
                , 12458, 10245, "https://www.packbagbuddy.com/wp-content/uploads/2020/10/Kedarnath-Dham-Yatra-700x411.jpg",
                "Uttarakhand", 2000));

        adventureTripRecyclerView = view.findViewById(R.id.rv_adventure_trips);
        adventureTripRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        adventureTripAdapter = new AdventureTripAdapter(adventureTripModelList);
        adventureTripRecyclerView.setAdapter(adventureTripAdapter);
    }

    private void setPopularSportRecyclerView(View view) {
        popularSportModelList = new ArrayList<>();
        popularSportModelList.add(new PopularSportModel(1, "https://www.packbagbuddy.com/wp-content/uploads/2018/10/1-1-800x681.jpg",
                "Trekking", 11));
        popularSportModelList.add(new PopularSportModel(1, "https://www.packbagbuddy.com/wp-content/uploads/2018/10/1-1-800x681.jpg",
                "Trekking", 11));
        popularSportModelList.add(new PopularSportModel(1, "https://www.packbagbuddy.com/wp-content/uploads/2018/10/1-1-800x681.jpg",
                "Trekking", 11));
        popularSportModelList.add(new PopularSportModel(1, "https://www.packbagbuddy.com/wp-content/uploads/2018/10/1-1-800x681.jpg",
                "Trekking", 11));
        popularSportModelList.add(new PopularSportModel(1, "https://www.packbagbuddy.com/wp-content/uploads/2018/10/1-1-800x681.jpg",
                "Trekking", 11));
        popularSportModelList.add(new PopularSportModel(1, "https://www.packbagbuddy.com/wp-content/uploads/2018/10/1-1-800x681.jpg",
                "Trekking", 11));

        popularSportRecyclerView = view.findViewById(R.id.rv_popular_sports);
        popularSportRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        popularSportAdapter = new PopularSportAdapter(popularSportModelList);
        popularSportRecyclerView.setAdapter(popularSportAdapter);
    }
}
