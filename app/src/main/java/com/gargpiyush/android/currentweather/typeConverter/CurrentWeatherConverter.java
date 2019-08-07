package com.gargpiyush.android.currentweather.typeConverter;

import android.arch.persistence.room.TypeConverter;

import com.gargpiyush.android.currentweather.model.CurrentWeather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 19:48.
 */
public class CurrentWeatherConverter {

    @TypeConverter
    public String fromDailyWeather(CurrentWeather currentWeather){
        if (currentWeather == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<CurrentWeather>() {
        }.getType();
        return gson.toJson(currentWeather, type);
    }

    @TypeConverter
    public CurrentWeather toDailyWeather(String currentWeatherResponse) {
        if (currentWeatherResponse == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<CurrentWeather>() {
        }.getType();
        return gson.fromJson(currentWeatherResponse, type);
    }
}
