package com.riseinsteps.packbagbuddy.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.model.Booking_Data;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {

    List<Booking_Data> my_list;

    public BookingAdapter(List<Booking_Data> my_list) {
        this.my_list=my_list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.booking_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Booking_Data adventure_data= my_list.get(position);
        //holder.location.setImageResource(adventure_data.getImage_id());
        Picasso.get().load(adventure_data.getImage_url()).fit().centerCrop().into(holder.location);
        holder.title.setText(adventure_data.getTitle());
        holder.duration.setText(adventure_data.getDuration());
        holder.amount.setText(adventure_data.getAmount());
        setAnimation(holder.itemView, position);
    }


    @Override
    public int getItemCount() {
        return my_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView location;

        public TextView title;
        public TextView duration;
        public TextView amount;
        public View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            location = (ImageView) itemView.findViewById(R.id.location);

            title = (TextView) itemView.findViewById(R.id.title);
            duration = (TextView) itemView.findViewById(R.id.duration);
            amount = (TextView) itemView.findViewById(R.id.amount);
            itemView.setOnClickListener((view -> {
                Log.v("item clicked",getAdapterPosition()+"  position");
            }));
        }
    }
    int lastPosition=-1;
    private void setAnimation(View view, int position) {
        if (position > lastPosition) {
            animateFadeIn(view, position);
            lastPosition = position;
        }
    }
    private static void animateFadeIn(View view, int position) {
        boolean not_first_item = position == -1;
        position = position + 1;
        view.setAlpha(0.f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(view, "alpha", 0.f, 0.5f, 1.f);
        ObjectAnimator.ofFloat(view, "alpha", 0.f).start();
        animatorAlpha.setStartDelay(not_first_item ? 500 / 2 : (position * 500 / 3));
        animatorAlpha.setDuration(500);
        animatorSet.play(animatorAlpha);
        animatorSet.start();
    }


}

