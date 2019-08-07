package com.gargpiyush.android.currentweather.network;

import com.gargpiyush.android.currentweather.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Piyush Garg
 * on 8/4/2019
 * at 09:33.
 */
public interface WeatherRequest {

    @GET("forecast/{api_key}/{latitude},{longitude}")
    Call<WeatherResponse> getWeatherData(@Path("api_key") String key,
                                         @Path("latitude") String lat,
                                         @Path("longitude") String lng,
                                         @Query("exclude") String blocks);
}
