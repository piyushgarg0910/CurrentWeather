package com.gargpiyush.android.currentweather.typeConverter;

import android.arch.persistence.room.TypeConverter;

import com.gargpiyush.android.currentweather.model.HourlyWeatherData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 19:49.
 */
public class HourlyWeatherDataConverter {

    @TypeConverter
    public String fromHourlyWeatherData
            (List<HourlyWeatherData> hourlyWeatherData){
        if (hourlyWeatherData == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<HourlyWeatherData>>() {
        }.getType();
        return gson.toJson(hourlyWeatherData, type);
    }

    @TypeConverter
    public List<HourlyWeatherData> toHourlyWeatherData
            (String hourlyWeatherDataResponse) {
        if (hourlyWeatherDataResponse == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<HourlyWeatherData>>() {
        }.getType();
        return gson.fromJson(hourlyWeatherDataResponse, type);
    }
}
