package com.riseinsteps.packbagbuddy.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.User;


public class MyAccountFragment extends Fragment {

    FirebaseUser mCurrentUser;
    private DatabaseReference databaseReference;
    String name, emailId, phoneNumber, username;
    Uri photoUrl;
    ImageView profileImage;
    TextView tvFullName, tvUserEmailId, tvUserPhone;
    private FirebaseAuth mAuth;
    View view;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_account, container, false);
        initComponenet();
        mCurrentUser = mAuth.getCurrentUser();
        if (mCurrentUser != null) {

            fetchDetatils();

        } else {
            Toast.makeText(getActivity(), "Please Sign In with official id", Toast.LENGTH_SHORT).show();
        }


        return view;
    }

    private void fetchDetatils() {
        databaseReference = FirebaseDatabase.getInstance().getReference("user/" + mCurrentUser.getUid());
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                name = user.getName();
              //  username = user.getUserName();
                emailId = user.getEmail();
                phoneNumber = user.getPhoneNumber();
                //Uri photoUrl = user.getPhotoUrl();

                tvFullName.setText(name);
                //tvUserName.setText(username);
                tvUserPhone.setText(phoneNumber);
                tvUserEmailId.setText(emailId);
                //Glide.with(this).load(photoUrl).into(profileImage);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.v(error.getMessage(), "My Account Fragment");
            }
        });
    }

    public void initComponenet() {
        mAuth = FirebaseAuth.getInstance();
        tvFullName = view.findViewById(R.id.tvFullName);
        tvUserEmailId = view.findViewById(R.id.tvUserEmailid);
        tvUserPhone = view.findViewById(R.id.tvUserPhone);
        profileImage = view.findViewById(R.id.profileimage);
      //  tvUserName = view.findViewById(R.id.tvUserName);

    }
}