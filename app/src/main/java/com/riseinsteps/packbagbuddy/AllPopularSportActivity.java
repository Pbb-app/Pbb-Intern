package com.riseinsteps.packbagbuddy;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.riseinsteps.packbagbuddy.adapter.PopularSportAdapter;
import com.riseinsteps.packbagbuddy.model.PopularSportModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class AllPopularSportActivity extends AppCompatActivity
{
    ArrayList<PopularSportModel> mList;
    DatabaseReference myRef;
    RecyclerView recyclerView;
    PopularSportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_popular_sport);
        mList= new ArrayList<>();
        myRef= FirebaseDatabase.getInstance().getReference();
        ClearAll();
        GetDataFromFireBase();
    }
    private void GetDataFromFireBase()
    {
        Query query = myRef.child("");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
//                for(DataSnapshot Snapshot: dataSnapshot.getChildren()  ){
//                    PopularSportModel message = new PopularSportModel();
//                    message.setImage(Snapshot.child("image").getValue().toString());
//                    message.setTitle(Snapshot.child("title").getValue().toString());
//                    message.setRating((Float) Snapshot.child("rating").getValue());
//                    mList.add(message);
//                }
//                adapter= new PopularSportAdapter(mList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void ClearAll()
    {
        if(mList!=null)
            mList.clear();

        if(adapter!=null){
            adapter.notifyDataSetChanged();
        }

        mList= new ArrayList<>();
    }

}