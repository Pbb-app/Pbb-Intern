package com.riseinsteps.packbagbuddy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.OtherTourDetailsModel;

import java.util.List;

public class OtherTourDetailsAdapter extends RecyclerView.Adapter<OtherTourDetailsAdapter.ViewHolder> {

    private List<OtherTourDetailsModel> modelList;

    public OtherTourDetailsAdapter(List<OtherTourDetailsModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.other_tour_details_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(modelList.get(position).getTourDetailsHeading(), modelList.get(position).getTourDetailsDesc());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView header, desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.tv_other_tour_details_heading);
            desc = itemView.findViewById(R.id.tv_other_tour_details_heading);
        }

        private void setData(final String headText, final String Desc) {
            header.setText(headText);
            desc.setText(Desc);
        }
    }
}
