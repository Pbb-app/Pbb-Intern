package com.riseinsteps.packbagbuddy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.riseinsteps.packbagbuddy.LoginActivity;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.User;


public class MyAccountFragment extends Fragment {

    FirebaseUser mCurrentUser;
    private DatabaseReference databaseReference;
    StorageReference storageReference;
    FirebaseDatabase database;
    String name, emailId, phoneNumber, username;
    Uri photoUrl;
    ImageView profileImage;
    TextView tvFullName, tvUserEmailId, tvUserPhone, tvUserName;
    private FirebaseAuth mAuth;
    View view;
    Button signout, btnImageChange;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_account, container, false);
        storageReference= FirebaseStorage.getInstance().getReference();
        initComponenet();
        mCurrentUser = mAuth.getCurrentUser();
        if (mCurrentUser != null) {

            fetchDetatils();

        } else {
            Toast.makeText(getActivity(), "Please Sign In with official id", Toast.LENGTH_SHORT).show();
        }

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mAuth.signOut();
                Intent intent= new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        btnImageChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGallery,100);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                Uri imageUri= data.getData();
                profileImage.setImageURI(imageUri);
                storeImageToFireBase(imageUri);
            }
        }
    }

    private void storeImageToFireBase(Uri imageUri)
    {
        StorageReference filerefrence = storageReference.child("profile_image");
        filerefrence.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getContext(),"Image Uploaded",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void fetchDetatils() {
        databaseReference = FirebaseDatabase.getInstance().getReference("user/" + mCurrentUser.getUid());
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                name = user.getName();
                username = user.getUserName();
                emailId = user.getEmail();
                phoneNumber = user.getPhoneNumber();

                //Uri photoUrl = user.getPhotoUrl();

                tvFullName.setText(name);
                tvUserName.setText(username);
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
        signout= view.findViewById(R.id.btnsignout);
        tvUserName = view.findViewById(R.id.tvUserName);
        btnImageChange= view.findViewById(R.id.btnChangeImage);
    }
}