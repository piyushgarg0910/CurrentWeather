package com.gargpiyush.android.currentweather.typeConverter;

import android.arch.persistence.room.TypeConverter;

import com.gargpiyush.android.currentweather.model.DailyWeather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 19:48.
 */

public class DailyWeatherConverter {
    @TypeConverter
    public String fromDailyWeather(DailyWeather dailyWeather){
        if (dailyWeather == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<DailyWeather>() {
        }.getType();
        return gson.toJson(dailyWeather, type);
    }

    @TypeConverter
    public DailyWeather toDailyWeather(String dailyWeatherResponse) {
        if (dailyWeatherResponse == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<DailyWeather>() {
        }.getType();
        return gson.fromJson(dailyWeatherResponse, type);
    }
}
