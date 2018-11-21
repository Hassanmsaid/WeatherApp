package com.example.dell.weatherapp;

public class DayForecast {
    private String  weather_desc, date;
    private double temp_min, temp_max, temp_avg, humidity, wind_speed;
    public DayForecast(){

    }

    public DayForecast(double temp_min, double temp_max, double temp_avg, double humidity, double wind_speed, String weather_desc, String date) {
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.temp_avg = temp_avg;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.weather_desc = weather_desc;
        this.date = date;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getTemp_avg() {
        return temp_avg;
    }

    public void setTemp_avg(double temp_avg) {
        this.temp_avg = temp_avg;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWeather_desc() {
        return weather_desc;
    }

    public void setWeather_desc(String weather_desc) {
        this.weather_desc = weather_desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
