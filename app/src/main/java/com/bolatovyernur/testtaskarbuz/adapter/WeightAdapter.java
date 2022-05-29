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
import com.bolatovyernur.testtaskarbuz.model.Weight;
import com.bolatovyernur.testtaskarbuz.interfaces.WeightRecyclerViewClickListener;

import java.util.ArrayList;

public class WeightAdapter extends RecyclerView.Adapter<WeightAdapter.ViewHolder> {
    private final Context mContext;
    private final ArrayList<Weight> weightArrayList;
    private final WeightRecyclerViewClickListener listener;
    int row_index;

    public WeightAdapter(Context context, ArrayList<Weight> weightArrayList,WeightRecyclerViewClickListener itemListener) {
        this.mContext = context;
        this.weightArrayList = weightArrayList;
        this.listener = itemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.weight_item, parent, false);
        return new WeightAdapter.ViewHolder(view);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(weightArrayList.get(position).getWeight());
        holder.title.setOnClickListener(view -> {
            listener.weightRecyclerviewClickListener(position);
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
        return weightArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_weight);
        }
    }
}
