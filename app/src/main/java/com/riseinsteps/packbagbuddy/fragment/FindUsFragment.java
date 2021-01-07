package com.riseinsteps.packbagbuddy.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.riseinsteps.packbagbuddy.R;

public class FindUsFragment extends Fragment {

    private TextView facebook, instagram, twitter, youtube;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_us, container, false);

        facebook = view.findViewById(R.id.tv_facebook);
        instagram = view.findViewById(R.id.tv_instagram);
        twitter = view.findViewById(R.id.tv_twitter);
        youtube = view.findViewById(R.id.tv_youtube);

        return view;
    }
}
