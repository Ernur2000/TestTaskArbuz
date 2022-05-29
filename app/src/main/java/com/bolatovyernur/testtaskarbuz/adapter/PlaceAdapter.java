package com.bolatovyernur.testtaskarbuz.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bolatovyernur.testtaskarbuz.R;
import com.bolatovyernur.testtaskarbuz.interfaces.PlaceRecyclerviewClickListener;
import com.bolatovyernur.testtaskarbuz.model.Place;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {
    private final ArrayList<Place> placeArrayList;
    private final Context mContext;
    private final PlaceRecyclerviewClickListener listener;
    int row_index;

    public PlaceAdapter(Context mContext, ArrayList<Place> placeArrayList, PlaceRecyclerviewClickListener itemListener) {
        this.mContext = mContext;
        this.placeArrayList = placeArrayList;
        listener = itemListener;
    }

    @NonNull
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.place_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull PlaceAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(placeArrayList.get(position).getPlace());
        holder.title.setOnClickListener(view -> {
            listener.recyclerviewClickListener(position);
            row_index = position;
            notifyDataSetChanged();
        });
        if (row_index == position) {
            holder.title.setTextColor(Color.parseColor("#39A603"));
            holder.title.setBackgroundResource(R.drawable.selected);
        } else {
            holder.title.setTextColor(Color.parseColor("#000000"));
            holder.title.setBackgroundResource(R.drawable.bg_btn);
        }
    }

    @Override
    public int getItemCount() {
        return placeArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_place);
        }
    }
}
