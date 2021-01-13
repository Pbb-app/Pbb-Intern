package com.riseinsteps.packbagbuddy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.riseinsteps.packbagbuddy.LeaveYourInfo;
import com.riseinsteps.packbagbuddy.R;

public class ContactUsFragment extends Fragment {

    Button btnInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

        btnInfo = view.findViewById(R.id.btnInfo);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(container.getContext(), LeaveYourInfo.class);
                startActivity(i);
            }
        });
        return view;
    }
}
