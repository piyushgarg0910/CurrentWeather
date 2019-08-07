package com.gargpiyush.android.currentweather.typeConverter;

import android.arch.persistence.room.TypeConverter;

import com.gargpiyush.android.currentweather.model.HourlyWeather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 19:22.
 */

public class HourlyWeatherConverter {

    @TypeConverter
    public String fromHourlyWeather(HourlyWeather hourlyWeather){
        if (hourlyWeather == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<HourlyWeather>() {
        }.getType();
        return gson.toJson(hourlyWeather, type);
    }

    @TypeConverter
    public HourlyWeather toHourlyWeather(String hourlyWeatherResponse){
        if (hourlyWeatherResponse == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<HourlyWeather>() {
        }.getType();
        return gson.fromJson(hourlyWeatherResponse, type);
    }
}
