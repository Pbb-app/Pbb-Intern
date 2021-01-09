package com.riseinsteps.packbagbuddy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.adapter.ExploreIndiaAdapter;
import com.riseinsteps.packbagbuddy.adapter.PopularSportAdapter;
import com.riseinsteps.packbagbuddy.model.ExploreIndia;
import com.riseinsteps.packbagbuddy.model.PopularSportModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExploreIndiaFragment extends Fragment
{
    private List<ExploreIndia> exploreIndia;
    private RecyclerView exploreIndiaRecyclerView;
    private ExploreIndiaAdapter exploreIndiaAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore_india, container, false);
        setexploreIndiaRecyclerView(view);

        return view;
    }

    private void setexploreIndiaRecyclerView(View view) {
        exploreIndia = new ArrayList<>();
        exploreIndia .add(new ExploreIndia("https://www.packbagbuddy.com/wp-content/uploads/2018/10/1-1-800x681.jpg", "KEDARNATH KEDARNATH","5",5,5,"OCTOBER"));
        exploreIndia .add(new ExploreIndia("https://www.packbagbuddy.com/wp-content/uploads/2018/10/1-1-800x681.jpg", "KEDARNATH KEDARNATH","5",5,5,"OCTOBER"));
        exploreIndia .add(new ExploreIndia("https://www.packbagbuddy.com/wp-content/uploads/2018/10/1-1-800x681.jpg", "KEDARNATH KEDARNATH","5",5,5,"OCTOBER"));
        exploreIndia .add(new ExploreIndia("https://www.packbagbuddy.com/wp-content/uploads/2018/10/1-1-800x681.jpg", "KEDARNATH KEDARNATH","5",5,5,"OCTOBER"));



        exploreIndiaRecyclerView = view.findViewById(R.id.rvww);
        exploreIndiaRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        exploreIndiaAdapter = new ExploreIndiaAdapter(exploreIndia );
        exploreIndiaRecyclerView.setAdapter(exploreIndiaAdapter);
    }
}
