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
import com.bolatovyernur.testtaskarbuz.model.Time;
import com.bolatovyernur.testtaskarbuz.interfaces.TimeRecyclerViewClickListener;

import java.util.ArrayList;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder> {
    private final Context mContext;
    private final ArrayList<Time> timeArrayList;
    private final TimeRecyclerViewClickListener listener;
    int row_index;

    public TimeAdapter(Context context, ArrayList<Time> timeArrayList,TimeRecyclerViewClickListener itemListener) {
        this.mContext = context;
        this.timeArrayList = timeArrayList;
        this.listener = itemListener;
    }

    @NonNull
    @Override
    public TimeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.time_item, parent, false);
        return new TimeAdapter.ViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull TimeAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(timeArrayList.get(position).getTime());
        holder.title.setOnClickListener(view -> {
            listener.timeRecyclerViewClickListener(position);
            row_index=position;
            notifyDataSetChanged();
        });
        if (row_index==position){
            holder.title.setTextColor(Color.parseColor("#39A603"));
            holder.title.setBackgroundResource(R.drawable.selected);
        }else {
            holder.title.setTextColor(Color.parseColor("#000000"));
            holder.title.setBackgroundResource(R.drawable.bg_btn);
        }
    }

    @Override
    public int getItemCount() {
        return timeArrayList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_time);
        }
    }
}
