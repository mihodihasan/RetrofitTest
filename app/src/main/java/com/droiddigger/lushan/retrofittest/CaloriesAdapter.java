package com.droiddigger.lushan.retrofittest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by mihodihasan on 7/13/17.
 */

public class CaloriesAdapter extends RecyclerView.Adapter<CaloriesAdapter.CalViewHolder> {
    Context context;
    List<Calories>caloriesList;

    public CaloriesAdapter(Context context, List<Calories> caloriesList) {
        this.context = context;
        this.caloriesList = caloriesList;
    }

    @Override
    public CalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CalViewHolder(LayoutInflater.from(context).inflate(R.layout.raw_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(CalViewHolder holder, int position) {
        holder.name.setText(caloriesList.get(position).getName());
        holder.calories.setText(caloriesList.get(position).getCalory());
        Log.d("imagepath",caloriesList.get(position).getImagePath());
        Log.d("imageview",holder.imageView+"");
        Glide.with(context).load(caloriesList.get(position).getImagePath()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return caloriesList.size();
    }

    public class CalViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,calories;
        public CalViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.cal_name);
            calories=(TextView)itemView.findViewById(R.id.cal_cal);
            imageView=(ImageView) itemView.findViewById(R.id.imgView);
        }
    }
}
