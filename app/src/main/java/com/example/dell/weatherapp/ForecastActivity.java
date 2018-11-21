package com.example.dell.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ForecastActivity extends AppCompatActivity {

    private String url, tempDate;
    private int cityID;
    private RecyclerView dayL;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<DayForecast> dayList;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        cityID = getIntent().getExtras().getInt("cityID");
        tempDate = "";
        url = "http://openweathermap.org/data/2.5/forecast?id=" + cityID + "&appid=b6907d289e10d714a6e88b30761fae22&units=metric";
        dayL = findViewById(R.id.daysRV);
        dayList = new ArrayList<>();
        adapter = new ForecastAdapter(getApplicationContext(), dayList);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setInitialPrefetchItemCount(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(dayL.getContext(), linearLayoutManager.getOrientation());

        dayL.setHasFixedSize(true);
        dayL.setLayoutManager(linearLayoutManager);
        dayL.addItemDecoration(dividerItemDecoration);
        dayL.setAdapter(adapter);

        getData();
    }

    private void getData() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray listArray = response.getJSONArray("list");
                    Toast.makeText(ForecastActivity.this, "json list size : " + listArray.length(), Toast.LENGTH_SHORT).show();
                    for(int i = 0; i < listArray.length(); i++){
                        DayForecast dayForecast = new DayForecast();
                        JSONObject listObject = listArray.getJSONObject(i);
                        JSONObject mainObject = listObject.getJSONObject("main");

                        dayForecast.setTemp_min(mainObject.getString("temp_min"));
                        dayForecast.setTemp_max(mainObject.getString("temp_max"));
                        dayForecast.setWeather_desc(listObject.getJSONArray("weather").getJSONObject(0).getString("description"));
                        dayForecast.setWind_speed(listObject.getJSONObject("wind").getString("speed"));
                        dayForecast.setDate(listObject.getString("dt_txt").substring(0, 10));

                        Log.i("list_object", listObject.toString());

                        if(!(listObject.getString("dt_txt").substring(0, 10)).equals(tempDate)){
                            dayList.add(dayForecast);
                            tempDate = listObject.getString("dt_txt").substring(0, 10);
                        }

                        //Toast.makeText(ForecastActivity.this, "list size:" + dayList.size(), Toast.LENGTH_SHORT).show();
                    }

                    Log.i("forecast_response", response.toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(ForecastActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}
