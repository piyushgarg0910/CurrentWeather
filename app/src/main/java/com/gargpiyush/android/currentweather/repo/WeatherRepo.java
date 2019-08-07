package com.gargpiyush.android.currentweather.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.gargpiyush.android.currentweather.model.WeatherResponse;
import com.gargpiyush.android.currentweather.network.WeatherApi;
import com.gargpiyush.android.currentweather.network.WeatherRequest;
import com.gargpiyush.android.currentweather.application.WeatherApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Piyush Garg
 * on 8/4/2019
 * at 09:44.
 */

public class WeatherRepo {

    private WeatherRequest request = WeatherApi.getRetrofitInstance()
            .create(WeatherRequest.class);

    public LiveData<WeatherResponse> getWeatherFromDatabase(){
        return WeatherApplication
                .weatherDatabase.weatherDao()
                .getWeatherFromDatabase();
    }

    public LiveData<WeatherResponse> getWeather(String key, String lat,
                                                 String lng, String blocks){

        final MutableLiveData<WeatherResponse> data = new MutableLiveData<>();

        request.getWeatherData(key,lat,lng,blocks)
                .enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call,
                                   Response<WeatherResponse> response) {
                UpdateDB updateDB = new UpdateDB(response.body());
                new Thread(updateDB).start();
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.e("Get weather call","Failure to get response");
                Log.e("Reason",t.getMessage());
                Log.e("Call url", call.request().url().toString());
            }
        });
        return data;
    }

    class UpdateDB implements Runnable{

        WeatherResponse wr;

        UpdateDB(WeatherResponse wr){
            this.wr = wr;
        }

        @Override
        public void run() {
            WeatherApplication
                    .weatherDatabase
                    .weatherDao()
                    .deleteAllDataFromDatabase();

            WeatherApplication
                    .weatherDatabase
                    .weatherDao()
                    .insertIntoDatabase(wr);
        }
    }
}
