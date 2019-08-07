package com.gargpiyush.android.currentweather.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.gargpiyush.android.currentweather
        .typeConverter.DailyWeatherDataConverter;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Piyush Garg
 * on 8/4/2019
 * at 08:18.
 */

@Entity(tableName = "daily_weather")
public class DailyWeather {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "summary")
    @SerializedName("summary")
    private String summary;

    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    private String icon;

    @TypeConverters(DailyWeatherDataConverter.class)
    @ColumnInfo(name = "data")
    @SerializedName("data")
    private ArrayList<DailyWeatherData> data;

    public DailyWeather(Integer id, String summary, String icon,
                        ArrayList<DailyWeatherData> data) {
        this.id = id;
        this.summary = summary;
        this.icon = icon;
        this.data = data;
    }

    public Integer getId(){
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public ArrayList<DailyWeatherData> getData() {
        return data;
    }
}
