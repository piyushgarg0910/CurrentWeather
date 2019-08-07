package com.gargpiyush.android.currentweather.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.gargpiyush.android.currentweather
        .typeConverter.CurrentWeatherConverter;
import com.gargpiyush.android.currentweather
        .typeConverter.DailyWeatherConverter;
import com.gargpiyush.android.currentweather
        .typeConverter.HourlyWeatherConverter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Piyush Garg
 * on 8/4/2019
 * at 08:10.
 */

@Entity(tableName = "weather",primaryKeys = {"latitude","longitude"})
public class WeatherResponse {

    @NonNull
    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    private Double latitude;

    @NonNull
    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")
    private Double longitude;

    @ColumnInfo(name = "timezone")
    @SerializedName("timezone")
    private String timeZone;

    @TypeConverters(CurrentWeatherConverter.class)
    @ColumnInfo(name = "currently")
    @SerializedName("currently")
    private CurrentWeather currentWeather;

    @TypeConverters(HourlyWeatherConverter.class)
    @ColumnInfo(name = "hourly")
    @SerializedName("hourly")
    private HourlyWeather hourlyWeather;

    @TypeConverters({DailyWeatherConverter.class})
    @ColumnInfo(name = "daily")
    @SerializedName("daily")
    private DailyWeather dailyWeather;

    public WeatherResponse(@NonNull Double latitude, @NonNull Double longitude,
                           String timeZone, CurrentWeather currentWeather,
                           HourlyWeather hourlyWeather,
                           DailyWeather dailyWeather) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timeZone = timeZone;
        this.currentWeather = currentWeather;
        this.hourlyWeather = hourlyWeather;
        this.dailyWeather = dailyWeather;
    }

    @NonNull
    public Double getLatitude() {
        return latitude;
    }

    @NonNull
    public Double getLongitude() {
        return longitude;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public HourlyWeather getHourlyWeather() {
        return hourlyWeather;
    }

    public DailyWeather getDailyWeather() {
        return dailyWeather;
    }
}
