package com.example.dell.weatherapp;

public class CityCurrent {
    private int cityID;
    private String cityName, weatherDesc, temp_min, temp_max;

    public CityCurrent(){

    }

    public CityCurrent(int cityID, String cityName, String weatherDesc, String temp_min, String temp_max) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.weatherDesc = weatherDesc;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }
}
