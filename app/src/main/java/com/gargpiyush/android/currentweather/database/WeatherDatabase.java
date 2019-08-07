package com.gargpiyush.android.currentweather.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.gargpiyush.android.currentweather.model.CurrentWeather;
import com.gargpiyush.android.currentweather.model.DailyWeather;
import com.gargpiyush.android.currentweather.model.DailyWeatherData;
import com.gargpiyush.android.currentweather.model.HourlyWeather;
import com.gargpiyush.android.currentweather.model.HourlyWeatherData;
import com.gargpiyush.android.currentweather.model.WeatherResponse;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 14:59.
 */

@Database(entities = {
        CurrentWeather.class,
        DailyWeather.class,
        DailyWeatherData.class,
        HourlyWeather.class,
        HourlyWeatherData.class,
        WeatherResponse.class},
        version = 1, exportSchema = false)
public abstract class WeatherDatabase extends RoomDatabase {

    private static WeatherDatabase instance;

    public abstract WeatherDAO weatherDao();

    public static WeatherDatabase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            WeatherDatabase.class, "weather-database")
                            .build();
        }
        return instance;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper
            (DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {
        instance = null;
    }
}
