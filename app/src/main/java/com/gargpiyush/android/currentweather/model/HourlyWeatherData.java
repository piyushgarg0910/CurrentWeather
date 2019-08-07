package com.gargpiyush.android.currentweather.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Piyush Garg
 * on 8/4/2019
 * at 08:20.
 */

@Entity(tableName = "hourly_weather_data")
public class HourlyWeatherData {

    @PrimaryKey
    @ColumnInfo(name = "time")
    @SerializedName("time")
    private Integer time;

    @ColumnInfo(name = "summary")
    @SerializedName("summary")
    private String summary;

    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    private String icon;

    @ColumnInfo(name = "precipIntensity")
    @SerializedName("precipIntensity")
    private Double precipIntensity;

    @ColumnInfo(name = "precipProbability")
    @SerializedName("precipProbability")
    private Double precipProbability;

    @ColumnInfo(name = "precipType")
    @SerializedName("precipType")
    private String precipType;

    @ColumnInfo(name = "temperature")
    @SerializedName("temperature")
    private Double temperature;

    @ColumnInfo(name = "apparentTemperature")
    @SerializedName("apparentTemperature")
    private Double apparentTemperature;

    @ColumnInfo(name = "dewPoint")
    @SerializedName("dewPoint")
    private Double dewPoint;

    @ColumnInfo(name = "humidity")
    @SerializedName("humidity")
    private Double humidity;

    @ColumnInfo(name = "pressure")
    @SerializedName("pressure")
    private Double pressure;

    @ColumnInfo(name = "windSpeed")
    @SerializedName("windSpeed")
    private Double windSpeed;

    @ColumnInfo(name = "windGust")
    @SerializedName("windGust")
    private Double windGust;

    @ColumnInfo(name = "windBearing")
    @SerializedName("windBearing")
    private Integer windBearing;

    @ColumnInfo(name = "cloudCover")
    @SerializedName("cloudCover")
    private Double cloudCover;

    @ColumnInfo(name = "uvIndex")
    @SerializedName("uvIndex")
    private Integer uvIndex;

    @ColumnInfo(name = "visibility")
    @SerializedName("visibility")
    private Double visibility;

    @ColumnInfo(name = "ozone")
    @SerializedName("ozone")
    private Double ozone;

    public HourlyWeatherData(Integer time, String summary, String icon,
                             Double precipIntensity, Double precipProbability,
                             String precipType, Double temperature,
                             Double apparentTemperature, Double dewPoint,
                             Double humidity, Double pressure, Double windSpeed,
                             Double windGust, Integer windBearing,
                             Double cloudCover, Integer uvIndex,
                             Double visibility, Double ozone) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.precipIntensity = precipIntensity;
        this.precipProbability = precipProbability;
        this.precipType = precipType;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windBearing = windBearing;
        this.cloudCover = cloudCover;
        this.uvIndex = uvIndex;
        this.visibility = visibility;
        this.ozone = ozone;
    }

    public Integer getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public Double getPrecipIntensity() {
        return precipIntensity;
    }

    public Double getPrecipProbability() {
        return precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Double getWindGust() {
        return windGust;
    }

    public Integer getWindBearing() {
        return windBearing;
    }

    public Double getCloudCover() {
        return cloudCover;
    }

    public Integer getUvIndex() {
        return uvIndex;
    }

    public Double getVisibility() {
        return visibility;
    }

    public Double getOzone() {
        return ozone;
    }
}
