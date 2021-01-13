package com.riseinsteps.packbagbuddy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.adapter.ExploreIndiaAdapter;
import com.riseinsteps.packbagbuddy.model.ExploreIndia;

import java.util.ArrayList;
import java.util.List;

public class ExploreIndiaFragment extends Fragment {
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
        exploreIndia.add(new ExploreIndia("https://www.youtube.com/watch?v=77czO8sxABI", "KEDARNATH", "Take in all the beauty and lushness of Barot and Rajgundha on this amazing 2N/3D trek. Camp under the stars, run free in the verdant meadows, drink fresh from the gurgling waterfalls and just take in all the visual grandeur that Mother Nature has to offer.", 4f));
        exploreIndia.add(new ExploreIndia("https://www.youtube.com/watch?v=77czO8sxABI", "KEDARNATH", "Take in all the beauty and lushness of Barot and Rajgundha on this amazing 2N/3D trek. Camp under the stars, run free in the verdant meadows, drink fresh from the gurgling waterfalls and just take in all the visual grandeur that Mother Nature has to offer.", 4f));
        exploreIndia.add(new ExploreIndia("https://www.youtube.com/watch?v=77czO8sxABI", "KEDARNATH ", "Take in all the beauty and lushness of Barot and Rajgundha on this amazing 2N/3D trek. Camp under the stars, run free in the verdant meadows, drink fresh from the gurgling waterfalls and just take in all the visual grandeur that Mother Nature has to offer.", 4f));


        exploreIndiaRecyclerView = view.findViewById(R.id.rvww);
        exploreIndiaRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        exploreIndiaAdapter = new ExploreIndiaAdapter(exploreIndia);
        exploreIndiaRecyclerView.setAdapter(exploreIndiaAdapter);
    }
}
