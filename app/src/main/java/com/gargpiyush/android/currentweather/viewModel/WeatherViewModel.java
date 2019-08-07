package com.gargpiyush.android.currentweather.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.gargpiyush.android.currentweather.model.WeatherResponse;
import com.gargpiyush.android.currentweather.repo.WeatherRepo;

/**
 * Created by Piyush Garg
 * on 8/4/2019
 * at 09:53.
 */
public class WeatherViewModel extends ViewModel {

    private WeatherRepo weatherRepo;

    public WeatherViewModel(WeatherRepo weatherRepo)
    {
        this.weatherRepo = weatherRepo;
    }

    public LiveData<WeatherResponse> getWeatherData(String key, Double lat,
                                                    Double lng){
        String blocks = "minutely,alerts,flags";
        return  weatherRepo.getWeather(key,String.valueOf(lat),
                String.valueOf(lng),blocks);
    }

    public LiveData<WeatherResponse> getWeatherDataFromDatabase(){
        return weatherRepo.getWeatherFromDatabase();
    }
}
