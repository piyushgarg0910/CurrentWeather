package com.gargpiyush.android.currentweather.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Piyush Garg
 * on 8/4/2019
 * at 09:29.
 */

public class WeatherApi {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.darksky.net/";

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
