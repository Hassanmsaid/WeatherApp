package com.example.dell.weatherapp;

public class DayForecast {
    private String temp_min, temp_max, temp_avg, humidity, wind_speed, weather_desc, date;

    public DayForecast(){

    }

    public DayForecast(String temp_min, String temp_max, String temp_avg, String humidity, String wind_speed, String weather_desc, String date) {
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.temp_avg = temp_avg;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.weather_desc = weather_desc;
        this.date = date;
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

    public String getTemp_avg() {
        return temp_avg;
    }

    public void setTemp_avg(String temp_avg) {
        this.temp_avg = temp_avg;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
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
