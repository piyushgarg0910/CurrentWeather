package com.gargpiyush.android.currentweather.typeConverter;

import android.arch.persistence.room.TypeConverter;

import com.gargpiyush.android.currentweather.model.DailyWeatherData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 19:49.
 */
public class DailyWeatherDataConverter {

    @TypeConverter
    public String fromDailyWeather(List<DailyWeatherData> dailyWeatherData){
        if (dailyWeatherData == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<DailyWeatherData>>() {
        }.getType();
        return gson.toJson(dailyWeatherData, type);
    }

    @TypeConverter
    public List<DailyWeatherData> toDailyWeather
            (String dailyWeatherDataResponse) {
        if (dailyWeatherDataResponse == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<DailyWeatherData>>() {
        }.getType();
        return gson.fromJson(dailyWeatherDataResponse, type);
    }
}
