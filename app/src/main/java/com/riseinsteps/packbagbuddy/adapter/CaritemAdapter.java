package com.riseinsteps.packbagbuddy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.riseinsteps.packbagbuddy.Caritem;
import com.riseinsteps.packbagbuddy.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{

    private ArrayList<Caritem> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView1;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.textview);
        }
    }

    public ExampleAdapter(ArrayList<Caritem> exampleList){
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
       Caritem currentItem = mExampleList.get(position);

        holder.mTextView1.setText(currentItem.getText1());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}