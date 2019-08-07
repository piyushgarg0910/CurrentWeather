package com.gargpiyush.android.currentweather;

import android.arch.lifecycle.MutableLiveData;

import com.gargpiyush.android.currentweather.model.CurrentWeather;
import com.gargpiyush.android.currentweather.model.DailyWeather;
import com.gargpiyush.android.currentweather.model.DailyWeatherData;
import com.gargpiyush.android.currentweather.model.HourlyWeather;
import com.gargpiyush.android.currentweather.model.HourlyWeatherData;
import com.gargpiyush.android.currentweather.model.WeatherResponse;
import com.gargpiyush.android.currentweather.repo.WeatherRepo;
import com.gargpiyush.android.currentweather.viewModel.WeatherViewModel;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Piyush Garg
 * on 8/6/2019
 * at 21:43.
 */
public class WeatherViewModelInstrumentedUnitTests {

    private WeatherRepo weatherRepo = new WeatherRepo();

    private WeatherViewModel weatherViewModel =
            new WeatherViewModel(weatherRepo);

    private MutableLiveData <WeatherResponse> mutableLiveData =
            new MutableLiveData<>();
    private WeatherResponse weatherResponse;

    @Before
    public void setUp(){
        CurrentWeather currentWeather = new CurrentWeather
                (15466161,"","",2.52,
                        2.1,0.5,
                        0.5,"",75.1,
                        78.0,80.5,20.5,
                        1024.5,5.8,7.6,
                        120.0,2.5,2,
                        10.0,2.5);
        ArrayList<HourlyWeatherData> arrayList = new ArrayList<>();
        HourlyWeatherData hourlyWeatherData =
                new HourlyWeatherData(1161651,"","",
                        2.2,2.5,"",
                        70.5,80.0,85.5,
                        20.0,1025.0,2.5,
                        2.8,120,20.5,1,
                        10.0,2.5);
        HourlyWeather hourlyWeather = new HourlyWeather(1,"",
                "",arrayList);
        arrayList.add(hourlyWeatherData);
        ArrayList<DailyWeatherData> arrayList1 = new ArrayList<>();
        DailyWeatherData dailyWeatherData =
                new DailyWeatherData(1561321,"","",
                        12312312,12312312,0.6,
                        5.5,6.0,
                        2165146,0.8,
                        "",75.5,
                        216546,50.5,
                        126546,77.7,
                        21651650,
                        50.5,
                        12331465,80.5,
                        50.5,1024.2,20.5,
                        24.5,213546,120,
                        10.5,2,231654,
                        12.5,5.5,50.5,
                        146541,80.5,
                        21651,40.5,
                        21651,
                        80.8,
                        165454);
        arrayList1.add(dailyWeatherData);
        DailyWeather dailyWeather = new DailyWeather(1,"","",
                arrayList1);
        Double lat = 40.1235;
        Double lng = -72.64165;
        String timeZone = "America/New_York";
        weatherResponse = new WeatherResponse(lat,lng,timeZone,currentWeather,
                hourlyWeather,dailyWeather);
    }

    @Test
    public void test_handleWeatherResponseFromNetwork_failure(){
        String key = "dihagdiuaghdihuasd";
        double lat = 40.65415;
        double lng = -72.65416;
        weatherViewModel.getWeatherData(key,lat,lng);
        assertNotEquals(weatherResponse,mutableLiveData.getValue());
    }

    @Test
    public void test_handleWeatherResponseFromNetwork_success(){
        String key = "dihagdiuaghdihuasd";
        double lat = 40.65415;
        double lng = -72.65416;
        mutableLiveData.postValue(weatherResponse);
        weatherViewModel.getWeatherData(key,lat,lng);
        assertEquals(weatherResponse,mutableLiveData.getValue());
    }

    @Test
    public void test_handleWeatherResponseFromDatabase_failure(){
        weatherViewModel.getWeatherDataFromDatabase();
        assertNotEquals(weatherResponse,mutableLiveData.getValue());
    }

    @Test
    public void test_handleWeatherResponseFromDatabase_success(){
        mutableLiveData.postValue(weatherResponse);
        weatherViewModel.getWeatherDataFromDatabase();
        assertEquals(weatherResponse,mutableLiveData.getValue());
    }
}
