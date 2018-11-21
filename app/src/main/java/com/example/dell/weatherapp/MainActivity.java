package com.example.dell.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String url;
    int[] citiesID;
    private RecyclerView cityL;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<CityCurrent> cityList;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        citiesID = new int[]{2643743, 5332921, 6356055, 1850147, 6455259, 5128638, 360630, 745044};

        cityL = findViewById(R.id.citiesRV);
        cityList = new ArrayList<>();
        adapter = new CityAdapter(getApplicationContext(), cityList);
        linearLayoutManager = new LinearLayoutManager( this );
        linearLayoutManager.setInitialPrefetchItemCount( LinearLayoutManager.VERTICAL );
        dividerItemDecoration = new DividerItemDecoration( cityL.getContext(), linearLayoutManager.getOrientation() );

        cityL.setHasFixedSize( true );
        cityL.setLayoutManager( linearLayoutManager );
        cityL.addItemDecoration( dividerItemDecoration );
        cityL.setAdapter( adapter );

        for(int i = 0; i < citiesID.length ; i++){
            url = "http://openweathermap.org/data/2.5/weather?id=" + citiesID[i] + "&appid=b6907d289e10d714a6e88b30761fae22&units=metric";
            get5cities(citiesID[i]);
        }

    }

    private void get5cities(int cityID){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    CityCurrent cityCurrent = new CityCurrent();

                    cityCurrent.setCityID(response.getInt("id"));
                    cityCurrent.setCityName(response.getString("name"));
                    cityCurrent.setTemp_min(response.getJSONObject("main").getString("temp_min"));
                    cityCurrent.setTemp_max(response.getJSONObject("main").getString("temp_max"));
                    cityCurrent.setWeatherDesc(response.getJSONArray("weather").getJSONObject(0).getString("main"));
                    cityList.add(cityCurrent);
                    Log.i("responseeee", response.toString());
                    Log.i("city id", response.getString("id"));
                    Log.i("city name", response.getString("name"));
                    Log.i("temp min", response.getJSONObject("main").getString("temp_min"));
                    Log.i("temp max", response.getJSONObject("main").getString("temp_max"));
                    Log.i("desc", response.getJSONArray("weather").getJSONObject(0).getString("main"));
                    //Toast.makeText(MainActivity.this, "list size:" + cityList.size(), Toast.LENGTH_SHORT).show();
                }
                catch (JSONException e){
                    e.printStackTrace();
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
