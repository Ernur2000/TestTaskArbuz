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
import com.bolatovyernur.testtaskarbuz.interfaces.DateRecyclerViewClickListener;
import com.bolatovyernur.testtaskarbuz.model.Date;

import java.util.ArrayList;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder> {
    private final Context mContext;
    private final ArrayList<Date> dateArrayList;
    private final DateRecyclerViewClickListener listener;
    int row_index;

    public DateAdapter(Context mContext, ArrayList<Date> dateArrayList, DateRecyclerViewClickListener itemListener) {
        this.mContext = mContext;
        this.dateArrayList = dateArrayList;
        this.listener = itemListener;
    }

    @NonNull
    @Override
    public DateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.date_item, parent, false);
        return new DateAdapter.ViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull DateAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(dateArrayList.get(position).getDate());
        holder.title.setOnClickListener(view -> {
            listener.dateRecyclerViewClickListener(position);
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
        return dateArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_date);
        }
    }
}
