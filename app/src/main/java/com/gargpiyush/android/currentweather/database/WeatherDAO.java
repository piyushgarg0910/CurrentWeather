package com.gargpiyush.android.currentweather.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.gargpiyush.android.currentweather.model.WeatherResponse;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 14:57.
 */

@Dao
public interface WeatherDAO {

    @Query("SELECT * FROM weather")
    LiveData<WeatherResponse> getWeatherFromDatabase();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertIntoDatabase(WeatherResponse weatherResponse);

    @Query("DELETE FROM weather")
    void deleteAllDataFromDatabase();

}
