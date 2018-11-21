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

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private Context context;
    private List<DayForecast> list;

    public ForecastAdapter(Context context, List<DayForecast> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_forecast_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final DayForecast dayForecast = list.get(i);
        viewHolder.wind.setText("wind speed: " + dayForecast.getWind_speed());
        viewHolder.temps.setText(String.valueOf(dayForecast.getTemp_min()) + (char) 0x00B0 + " | " + String.valueOf(dayForecast.getTemp_max()) + (char) 0x00B0);
        //viewHolder.temps.setText(String.valueOf(dayForecast.getTemp_min()) + (char) 0x00B0);
        viewHolder.desc.setText(dayForecast.getWeather_desc());
        viewHolder.date.setText(dayForecast.getDate().substring(5,10));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public RelativeLayout relativeLayout;
        public TextView temps, wind, desc, date;
        public ViewHolder(View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.forecastParent);
            wind = itemView.findViewById(R.id.forecastWindTV);
            temps = itemView.findViewById(R.id.forecastTempsTV);
            desc = itemView.findViewById(R.id.forecastDescTV);
            date = itemView.findViewById(R.id.forecastDateTV);
        }
    }
}
