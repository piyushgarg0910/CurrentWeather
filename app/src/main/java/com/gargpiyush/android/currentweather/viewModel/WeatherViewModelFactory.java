package com.gargpiyush.android.currentweather.viewModel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.gargpiyush.android.currentweather.repo.WeatherRepo;

/**
 * Created by Piyush Garg
 * on 8/4/2019
 * at 09:54.
 */
public class WeatherViewModelFactory implements ViewModelProvider.Factory {

    private WeatherRepo weatherRepo;

    public WeatherViewModelFactory(WeatherRepo weatherRepo)
    {
        this.weatherRepo = weatherRepo;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new WeatherViewModel(weatherRepo);
    }
}
