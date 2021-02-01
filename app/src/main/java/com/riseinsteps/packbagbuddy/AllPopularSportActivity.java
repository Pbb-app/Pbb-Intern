package com.riseinsteps.packbagbuddy;

import android.os.Bundle;
import android.view.View;

import com.riseinsteps.packbagbuddy.adapter.AdventureTripAdapter;
import com.riseinsteps.packbagbuddy.adapter.PopularSportAdapter;
import com.riseinsteps.packbagbuddy.model.TripModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AllPopularSportActivity extends AppCompatActivity
{
    private RecyclerView  popularSportRecyclerView;
    private List<TripModel> popularSportList;
    private PopularSportAdapter popularSportAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_popular_sport);
        setPopularSportRecyclerview();

    }
    private void setPopularSportRecyclerview() {
        popularSportRecyclerView = findViewById(R.id.recyclerViewPopularSport);
        popularSportRecyclerView.setHasFixedSize(true);
        popularSportRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        popularSportList = new ArrayList<>();
        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));
        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));
        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));
        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        popularSportList.add(new TripModel("Kedarnath", "Desc", "12", "https://www.packbagbuddy.com/wp-content/uploads/2019/09/11-3-700x450.jpg"
                , 2536.12f, 1000.2f, "Odhisa", "Always", "Delhi", "Himachal Pradesh",
                6, 12, "Quick Facts", "Lonavala", "Accommodation", "MEal", "bus", "ITinereary",
                "Details", "Rules", "Refund",4.2f,"2000"));

        popularSportAdapter = new PopularSportAdapter(popularSportList);
        popularSportRecyclerView.setAdapter(popularSportAdapter);
    }

}