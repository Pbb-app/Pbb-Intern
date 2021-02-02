package com.riseinsteps.packbagbuddy.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.riseinsteps.packbagbuddy.R;

import java.util.Objects;

public class MyAccountFragment extends Fragment
{
    FirebaseUser mCurrentUser;
    private DatabaseReference mUserDatabase;
    String name, emailId,phoneNumber;
    Uri photoUrl;
    ImageView profileImage;
    TextView tvFullName,tvUserEmailId,tvUserPhone;
    @Nullable
    @Override
    public View onCreateView
            (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view =inflater.inflate(R.layout.fragment_my_account, container, false);
        tvFullName= view.findViewById(R.id.tvFullName);
        tvUserEmailId= view.findViewById(R.id.tvUserEmailid);
        tvUserPhone= view.findViewById(R.id.tvUserPhone);
        profileImage= view.findViewById(R.id.profileimage);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null)
        {
                 name = user.getDisplayName();
                 emailId = user.getEmail();
                 phoneNumber=user.getPhoneNumber();
                 Uri photoUrl = user.getPhotoUrl();

                tvFullName.setText(name);
                tvUserPhone.setText(phoneNumber);
                tvUserEmailId.setText(emailId);
                Glide.with(this).load(photoUrl).into(profileImage);


            }

        return view;
    }
    }
