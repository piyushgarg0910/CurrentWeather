package com.gargpiyush.android.currentweather.application;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.gargpiyush.android.currentweather.database.WeatherDatabase;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 21:36.
 */

public class WeatherApplication extends Application {

    public static WeatherDatabase weatherDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        weatherDatabase = Room
                .databaseBuilder(getApplicationContext(),
                        WeatherDatabase.class,"WeatherDatabase")
                .fallbackToDestructiveMigration()
                .build();
    }
}
