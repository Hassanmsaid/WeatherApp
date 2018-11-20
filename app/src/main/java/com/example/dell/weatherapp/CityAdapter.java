package com.example.dell.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    private Context context;
    private List<CityCurrent> list;

    public CityAdapter(Context context, List<CityCurrent> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_city_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final CityCurrent cityCurrent = list.get(i);
        viewHolder.cityName.setText(cityCurrent.getCityName());
        viewHolder.cityTemps.setText(cityCurrent.getTemp_min() + (char) 0x00B0 + " | " + cityCurrent.getTemp_max() + (char) 0x00B0);
        viewHolder.desc.setText(cityCurrent.getWeatherDesc());

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ForecastActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public RelativeLayout relativeLayout;
        public TextView cityName, cityTemps, desc;
        public ViewHolder(View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.cityParent);
            cityName = itemView.findViewById(R.id.cityNameTV);
            cityTemps = itemView.findViewById(R.id.cityTempTV);
            desc = itemView.findViewById(R.id.cityDescTV);
        }
    }
}
