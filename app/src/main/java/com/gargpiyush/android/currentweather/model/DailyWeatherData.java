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

@Entity(tableName = "daily_weather_data")
public class DailyWeatherData {

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

    @ColumnInfo(name = "sunriseTime")
    @SerializedName("sunriseTime")
    private Integer sunriseTime;

    @ColumnInfo(name = "sunsetTime")
    @SerializedName("sunsetTime")
    private Integer sunsetTime;

    @ColumnInfo(name = "moonPhase")
    @SerializedName("moonPhase")
    private Double moonPhase;

    @ColumnInfo(name = "precipIntensity")
    @SerializedName("precipIntensity")
    private Double precipIntensity;

    @ColumnInfo(name = "precipIntensityMax")
    @SerializedName("precipIntensityMax")
    private Double precipIntensityMax;

    @ColumnInfo(name = "precipIntensityMaxTime")
    @SerializedName("precipIntensityMaxTime")
    private Integer precipIntensityMaxTime;

    @ColumnInfo(name = "precipProbability")
    @SerializedName("precipProbability")
    private Double precipProbability;

    @ColumnInfo(name = "precipType")
    @SerializedName("precipType")
    private String precipType;

    @ColumnInfo(name = "temperatureHigh")
    @SerializedName("temperatureHigh")
    private Double tempratureHigh;

    @ColumnInfo(name = "temperatureHighTime")
    @SerializedName("temperatureHighTime")
    private Integer temperatureHighTime;

    @ColumnInfo(name = "temperatureLow")
    @SerializedName("temperatureLow")
    private Double temperatureLow;

    @ColumnInfo(name = "temperatureLowTime")
    @SerializedName("temperatureLowTime")
    private Integer temperatureLowTime;

    @ColumnInfo(name = "apparentTemperatureHigh")
    @SerializedName("apparentTemperatureHigh")
    private Double apparentTemperatureHigh;

    @ColumnInfo(name = "apparentTemperatureHighTime")
    @SerializedName("apparentTemperatureHighTime")
    private Integer apparentTemperatureHighTime;

    @ColumnInfo(name = "apparentTemperatureLow")
    @SerializedName("apparentTemperatureLow")
    private Double apparentTemperatureLow;

    @ColumnInfo(name = "apparentTemperatureLowTime")
    @SerializedName("apparentTemperatureLowTime")
    private Integer apparentTemperatureLowTime;

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

    @ColumnInfo(name = "windGustTime")
    @SerializedName("windGustTime")
    private Integer windGustTime;

    @ColumnInfo(name = "windBearing")
    @SerializedName("windBearing")
    private Integer windBearing;

    @ColumnInfo(name = "cloudCover")
    @SerializedName("cloudCover")
    private Double cloudCover;

    @ColumnInfo(name = "uvIndex")
    @SerializedName("uvIndex")
    private Integer uvIndex;

    @ColumnInfo(name = "uvIndexTime")
    @SerializedName("uvIndexTime")
    private Integer uvIndexTime;

    @ColumnInfo(name = "visibility")
    @SerializedName("visibility")
    private Double visibility;

    @ColumnInfo(name = "ozone")
    @SerializedName("ozone")
    private Double ozone;

    @ColumnInfo(name = "temperatureMin")
    @SerializedName("temperatureMin")
    private Double temperatureMin;

    @ColumnInfo(name = "temperatureMinTime")
    @SerializedName("temperatureMinTime")
    private Integer temperatureMinTime;

    @ColumnInfo(name = "temperatureMax")
    @SerializedName("temperatureMax")
    private Double temperatureMax;

    @ColumnInfo(name = "temperatureMaxTime")
    @SerializedName("temperatureMaxTime")
    private Integer temperatureMaxTime;

    @ColumnInfo(name = "apparentTemperatureMin")
    @SerializedName("apparentTemperatureMin")
    private Double apparentTemperatureMin;

    @ColumnInfo(name = "apparentTemperatureMinTime")
    @SerializedName("apparentTemperatureMinTime")
    private Integer apparentTemperatureMinTime;

    @ColumnInfo(name = "apparentTemperatureMax")
    @SerializedName("apparentTemperatureMax")
    private Double apparentTemperatureMax;

    @ColumnInfo(name = "apparentTemperatureMaxTime")
    @SerializedName("apparentTemperatureMaxTime")
    private Integer apparentTemperatureMaxTime;

    public DailyWeatherData(Integer time, String summary, String icon,
                            Integer sunriseTime, Integer sunsetTime,
                            Double moonPhase, Double precipIntensity,
                            Double precipIntensityMax,
                            Integer precipIntensityMaxTime,
                            Double precipProbability, String precipType,
                            Double tempratureHigh, Integer temperatureHighTime,
                            Double temperatureLow, Integer temperatureLowTime,
                            Double apparentTemperatureHigh,
                            Integer apparentTemperatureHighTime,
                            Double apparentTemperatureLow,
                            Integer apparentTemperatureLowTime, Double dewPoint,
                            Double humidity, Double pressure, Double windSpeed,
                            Double windGust, Integer windGustTime,
                            Integer windBearing, Double cloudCover,
                            Integer uvIndex, Integer uvIndexTime,
                            Double visibility, Double ozone,
                            Double temperatureMin, Integer temperatureMinTime,
                            Double temperatureMax, Integer temperatureMaxTime,
                            Double apparentTemperatureMin,
                            Integer apparentTemperatureMinTime,
                            Double apparentTemperatureMax,
                            Integer apparentTemperatureMaxTime) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.moonPhase = moonPhase;
        this.precipIntensity = precipIntensity;
        this.precipIntensityMax = precipIntensityMax;
        this.precipIntensityMaxTime = precipIntensityMaxTime;
        this.precipProbability = precipProbability;
        this.precipType = precipType;
        this.tempratureHigh = tempratureHigh;
        this.temperatureHighTime = temperatureHighTime;
        this.temperatureLow = temperatureLow;
        this.temperatureLowTime = temperatureLowTime;
        this.apparentTemperatureHigh = apparentTemperatureHigh;
        this.apparentTemperatureHighTime = apparentTemperatureHighTime;
        this.apparentTemperatureLow = apparentTemperatureLow;
        this.apparentTemperatureLowTime = apparentTemperatureLowTime;
        this.dewPoint = dewPoint;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.windGustTime = windGustTime;
        this.windBearing = windBearing;
        this.cloudCover = cloudCover;
        this.uvIndex = uvIndex;
        this.uvIndexTime = uvIndexTime;
        this.visibility = visibility;
        this.ozone = ozone;
        this.temperatureMin = temperatureMin;
        this.temperatureMinTime = temperatureMinTime;
        this.temperatureMax = temperatureMax;
        this.temperatureMaxTime = temperatureMaxTime;
        this.apparentTemperatureMin = apparentTemperatureMin;
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
        this.apparentTemperatureMax = apparentTemperatureMax;
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
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

    public Integer getSunriseTime() {
        return sunriseTime;
    }

    public Integer getSunsetTime() {
        return sunsetTime;
    }

    public Double getMoonPhase() {
        return moonPhase;
    }

    public Double getPrecipIntensity() {
        return precipIntensity;
    }

    public Double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public Integer getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public Double getPrecipProbability() {
        return precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public Double getTempratureHigh() {
        return tempratureHigh;
    }

    public Integer getTemperatureHighTime() {
        return temperatureHighTime;
    }

    public Double getTemperatureLow() {
        return temperatureLow;
    }

    public Integer getTemperatureLowTime() {
        return temperatureLowTime;
    }

    public Double getApparentTemperatureHigh() {
        return apparentTemperatureHigh;
    }

    public Integer getApparentTemperatureHighTime() {
        return apparentTemperatureHighTime;
    }

    public Double getApparentTemperatureLow() {
        return apparentTemperatureLow;
    }

    public Integer getApparentTemperatureLowTime() {
        return apparentTemperatureLowTime;
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

    public Integer getWindGustTime() {
        return windGustTime;
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

    public Integer getUvIndexTime() {
        return uvIndexTime;
    }

    public Double getVisibility() {
        return visibility;
    }

    public Double getOzone() {
        return ozone;
    }

    public Double getTemperatureMin() {
        return temperatureMin;
    }

    public Integer getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public Double getTemperatureMax() {
        return temperatureMax;
    }

    public Integer getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public Double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public Integer getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public Double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public Integer getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }
}
